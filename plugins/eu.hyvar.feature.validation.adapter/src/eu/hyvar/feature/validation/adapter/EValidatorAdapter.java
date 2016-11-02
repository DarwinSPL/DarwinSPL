package eu.hyvar.feature.validation.adapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyLinearTemporalElement;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyNamedElement;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.impl.HyFeatureImpl;
import eu.hyvar.feature.impl.HyFeatureModelImpl;
import eu.hyvar.feature.impl.HyGroupImpl;

/**
 * An adapter that plugs the EMF Model Validation Service API into the
 * {@link org.eclipse.emf.ecore.EValidator} API.
 */
public class EValidatorAdapter extends EObjectValidator {

	private List<Date> dates = null;

	/**
	 * Model Validation Service interface for batch validation of EMF elements.
	 */
	private final IBatchValidator batchValidator;

	/**
	 * Initializes me.
	 */
	public EValidatorAdapter() {
		super();

		batchValidator = ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
		batchValidator.setIncludeLiveConstraints(true);
		batchValidator.setReportSuccesses(false);

	}

	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {

		return validate(eObject.eClass(), eObject, diagnostics, context);
	}

	/**
	 * Implements validation by delegation to the EMF validation framework.
	 */
	@Override
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// first, do whatever the basic EcoreValidator does
		super.validate(eClass, eObject, diagnostics, context);

		IStatus status = Status.OK_STATUS;

		checkConstraints(eClass, eObject, diagnostics, context);

		// no point in validating if we can't report results
		if (diagnostics != null) {
			// if EMF Mode Validation Service already covered the sub-tree,
			// which it does for efficient computation and error reporting,
			// then don't repeat (the Diagnostician does the recursion
			// externally). If there is no context map, then we can't
			// help it
			if (!hasProcessed(eObject, context)) {
				status = batchValidator.validate(eObject, new NullProgressMonitor());

				processed(eObject, context, status);

				appendDiagnostics(status, diagnostics);
			}
		}

		return status.isOK();
	}

	private void addErrorMessage(EClass eClass, EObject eObject, DiagnosticChain diagnostics, String message) {
		diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, eClass.getName(), 0, message, new Object[] { eObject }));
	}

	/**
	 * Checks if valid since and valid until are equal at a given timestamp.
	 * Is a date is null, the date will be treated like no restriction
	 * @param date
	 * @param validSince
	 * @param validUntil
	 * @return true if since < until or else false 
	 */
	private boolean validSinceUntilCombinationAtTimestamp(Date date, Date validSince, Date validUntil) {
		return count(date, validSince, validUntil) == 1 ? true : false;
	}

	/**
	 * Checks if validSince and/or validUntil is/are null and returns
	 * corresponding to that situation 1 or 0 depending whether date is valid
	 * between validSince and validUntil or not
	 * 
	 * @param Use
	 *            this variable for the date from model
	 * @param validSince
	 * @param validUntil
	 * @return Returns 1 if model is valid at date or 0 if not
	 */
	private int count(Date date, Date validSince, Date validUntil) {
		if (validSince == null && validUntil == null) {
			return 1;
		}
		if (validSince == null && validUntil != null) {
			if (date.before(validUntil))
				return 1;
		}
		if (validSince != null && validUntil == null) {
			if (date.after(validSince) || date.equals(validSince))
				return 1;
		}
		if (validSince != null && validUntil != null) {
			if ((date.after(validSince) || date.equals(validSince)) && date.before(validUntil))
				return 1;
		}

		return 0;
	}
	/**
	 * Checks constraints for each HyFeature defined in the model.
	 * @param eClass
	 * @param eObject
	 * @param diagnostics
	 * @param context
	 */
	private void checkHyFeatureConstraints(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		
		HyFeatureImpl feature = (HyFeatureImpl) eObject;
		EList<HyGroupComposition> compositions = feature.getGroupMembership();
		EList<HyVersion> versions = feature.getVersions();
		EList<HyName> names = feature.getNames();
		EList<HyFeatureAttribute> attributes = feature.getAttributes();

		// Version Constraint(s)
		for (int i = 0; i < dates.size(); i++) {
			Date date = dates.get(i);

			int count = 0;
			for (int j = 0; j < versions.size(); j++) {
				HyVersion version = versions.get(j);
				Date validSince = version.getValidSince();
				Date validUntil = version.getValidUntil();

				count += count(date, validSince, validUntil);
			}

			if (count > 1)
				addErrorMessage(eClass, eObject, diagnostics,
						eClass.getName() + " has more than one version at timestamp " + date.toString());

			// if feature has no valid versions, feature cannot be valid either
			if (count == 0 && versions.size() > 0 && validSinceUntilCombinationAtTimestamp(date, feature.getValidSince(), feature.getValidUntil())) {
				addErrorMessage(eClass, eObject, diagnostics, eClass.getName() + " has no valid versions but is valid at timestamp " + date.toString()
								+ ". This is not possible");
			}
		}

		// Group Constraint
		for (int i = 0; i < dates.size(); i++) {
			Date date = dates.get(i);

			int count = 0;
			for (int j = 0; j < compositions.size(); j++) {
				HyGroupComposition composition = compositions.get(j);
				Date validSince = composition.getValidSince();
				Date validUntil = composition.getValidUntil();

				count += count(date, validSince, validUntil);
			}

			if (count > 1)
				addErrorMessage(eClass, eObject, diagnostics,
						eClass.getName() + " has more than group membership at timestamp " + date.toString());

		}

		// Name Constraint
		for (int i = 0; i < dates.size(); i++) {
			Date date = dates.get(i);

			int count = 0;
			for (int j = 0; j < names.size(); j++) {
				HyName name = names.get(j);
				Date validSince = name.getValidSince();
				Date validUntil = name.getValidUntil();

				count += count(date, validSince, validUntil);
			}

			if (count > 1) {
				addErrorMessage(eClass, eObject, diagnostics,
						eClass.getName() + " has more than one name at timestamp " + date.toString());
			}
		}
		
		// Attribute Constraint
		for(int i = 0; i < dates.size(); i++){
			Date date = dates.get(i);
			
			int count = 0;
			for(int j = 0; j < attributes.size(); j++){
				HyFeatureAttribute attribute = attributes.get(j);
				Date validSince = attribute.getValidSince();
				Date validUntil = attribute.getValidUntil();
				
				count += count(date, validSince, validUntil);
				
				
			}
		}
	}

	/**
	 * Checks constraints for each HyGroup defined in the model.
	 * @param eClass
	 * @param eObject
	 * @param diagnostics
	 * @param context
	 */
	private void checkHyGroupConstraints(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {

		HyGroupImpl group = (HyGroupImpl) eObject;
		
		EList<HyGroupComposition> compositions = group.getParentOf();

		// special case if no date exist in model
		if(compositions.size() > 1 && dates.isEmpty())
			addErrorMessage(eClass, eObject, diagnostics,
					eClass.getName() + " has more than one GroupComposition at any time. Please define valid since and valid until for each composition");
		
		
		// Check group compositions
		for (int i = 0; i < dates.size(); i++) {
			Date date = dates.get(i);

			int count = 0;
			for (int j = 0; j < compositions.size(); j++) {
				HyGroupComposition composition = compositions.get(j);
				Date validSince = composition.getValidSince();
				Date validUntil = composition.getValidUntil();

				count += count(date, validSince, validUntil);
			}

			if (count > 1) {
				addErrorMessage(eClass, eObject, diagnostics,
						eClass.getName() + " has more than one GroupComposition at timestamp " + date.toString());


			}
			if(count >= 1){
				boolean validAtTimeStamp = validSinceUntilCombinationAtTimestamp(date, group.getValidSince(),
						group.getValidUntil());
				if (!validAtTimeStamp) {
					addErrorMessage(eClass, eObject, diagnostics, eClass.getName() + " is invalid at timestamp "
							+ date.toString() + " but one composition is valid.");
				}				
			}
			
			if(count == 0){
				addErrorMessage(eClass, eObject, diagnostics,
						eClass.getName() + " has no GroupComposition at timestamp " + date.toString());				
			}
		}

		// Constraint Group can only be in one FeatureChild at one timestamp
		EList<HyFeatureChild> childrenOf = group.getChildOf();
		for (int i = 0; i < dates.size(); i++) {
			Date date = dates.get(i);

			if (group.getValidSince() != null) {
				int count = 0;
				for (int j = 0; j < childrenOf.size(); j++) {
					if (childrenOf.get(j).getValidSince() != null) {
						if (date.equals(childrenOf.get(j).getValidSince())) {
							count++;
						}
					}
				}

				if (count > 1)
					addErrorMessage(eClass, eObject, diagnostics, eClass.getName()
							+ " is children in more than one HyFeatureChild at timestamp " + date.toString());
				if (count == 0)
					addErrorMessage(eClass, eObject, diagnostics, eClass.getName()
							+ " is not a children in any HyFeatureChild at timestamp " + date.toString());					
			}
		}
	}

	private void checkHyFeatureChildConstraints(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
	}

	private void checkHyVersionConstraints(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
	}

	private void checkHyNamedElementConstraints(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
	}

	/**
	 * Checks if the model has more than one root feature at a timestamp
	 * @param eClass
	 * @param eObject
	 * @param diagnostics
	 * @param context
	 */
	private void checkHyFeatureModelConstraints(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {

		HyFeatureModelImpl model = (HyFeatureModelImpl) eObject;
		EList<HyRootFeature> rootFeatures = model.getRootFeature();

		for (int i = 0; i < dates.size(); i++) {
			Date date = dates.get(i);

			int count = 0;
			for (int j = 0; j < rootFeatures.size(); j++) {
				Date validSince = rootFeatures.get(j).getValidSince();
				Date validUntil = rootFeatures.get(j).getValidUntil();

				count += count(date, validSince, validUntil);
			}

			if (count > 1) {
				addErrorMessage(eClass, eObject, diagnostics,
						eClass.getName() + " has more than one root feature at timestamp " + date.toString());
			}
			if (count == 0){
				addErrorMessage(eClass, eObject, diagnostics,
						eClass.getName() + " has no root feature at timestamp " + date.toString());				
			}
		}

	}

	/**
	 * Checks if the composition has features or not. 
	 * @param eClass
	 * @param eObject
	 * @param diagnostics
	 * @param context
	 */
	private void checkHyGroupCompositionConstraints(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		
		//FIXME date = null?!
		HyGroupComposition composition = (HyGroupComposition) eObject;
		
		EList<HyFeature> features = composition.getFeatures();
		for (int i = 0; i < dates.size(); i++) {
			Date date = dates.get(i);

			int count = 0;
			for (int j = 0; j < features.size(); j++) {
				Date validSince = features.get(j).getValidSince();
				Date validUntil = features.get(j).getValidUntil();

				count += count(date, validSince, validUntil);
			}

			if (count == 0){
				addErrorMessage(eClass, eObject, diagnostics,
						eClass.getName() + " has no feature(s) at timestamp " + date.toString());				
			}
		}		
		
	}

	private void checkHyCardinalityBasedElementConstraints(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {

		// HyCardinalityImpl cardinalityElement = (HyCardinalityBasedElement)
		// eObject;

	}

	private void checkHyLinearTemporalElementConstraints(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {

	}

	private void checkHyTemporalElementConstraints(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {

	}

	private void checkHyCardinilityConstraints(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {

	}

	private void checkHyCardinalityConstraints(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {

		/*
		HyCardinalityImpl cardinality = (HyCardinalityImpl) eObject;
		if (cardinality.getMaxCardinality() > 1 || cardinality.getMaxCardinality() < 0) {
			addErrorMessage(eClass, eObject, diagnostics, eClass.getName() + " has invalid max cardinality with value"
					+ cardinality.getMaxCardinality() + ". Valid values are 0 and 1.");

		}
		if (cardinality.getMinCardinality() > 1 || cardinality.getMinCardinality() < 0) {
			addErrorMessage(eClass, eObject, diagnostics, eClass.getName() + " has invalid min cardinality with value"
					+ cardinality.getMinCardinality() + ". Valid values are 0 and 1.");

		}
		*/
	}

	/**
	 * Checks if an object has more than one type at a timestamp
	 * @param eClass
	 * @param eObject
	 * @param diagnostics
	 * @param context
	 */
	private void checkTypes(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		
		List<HyTemporalElement> types = null;
		
		if (eObject instanceof HyFeature) {
			HyFeature e = (HyFeature) eObject;
			types = new ArrayList<HyTemporalElement>();
			types.addAll(e.getTypes());
		} 
		else if(eObject instanceof HyGroup) {
			HyGroup e = (HyGroup) eObject;
			types = new ArrayList<HyTemporalElement>();
			types.addAll(e.getTypes());
		}
		
		if(types != null) {

			for (int i = 0; i < dates.size(); i++) {
				Date date = dates.get(i);

				int count = 0;
				for (int j = 0; j < types.size(); j++) {
					Date validSince = types.get(j).getValidSince();
					Date validUntil = types.get(j).getValidUntil();

					count += count(date, validSince, validUntil);
				}

				if (count > 1) {
					addErrorMessage(eClass, eObject, diagnostics,
							eClass.getName() + " has more than one type at timestamp " + date.toString());
				}
			}
		}
		
	}

	/**
	 * Checks if a object is instance of a HyLinearTemporalElement and checks if more than 
	 * superseding and superseded objects are valid. Also checks for circle of superseding 
	 * objects. 
	 * @param eClass
	 * @param eObject
	 * @param diagnostics
	 * @param context
	 */
	private void checkSuperseeding(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {

		
		if (eObject instanceof HyLinearTemporalElement) {
			HyLinearTemporalElement element = (HyLinearTemporalElement) eObject;
			
			// check if a circle exist
			HyLinearTemporalElement whileElement = (HyLinearTemporalElement) eObject;
			Vector<HyLinearTemporalElement> list = new Vector<HyLinearTemporalElement>();
			boolean endWhile = false;
			while(whileElement != null && !endWhile){
				for(int i=0; i<list.size(); i++){
					if(list.get(i).equals(whileElement)){
						addErrorMessage(eClass, eObject, diagnostics,
								eClass.getName() + " has a circle of superseding elements");
						endWhile = true;
					}
				}
				
				list.add(whileElement);
				whileElement = (HyLinearTemporalElement)whileElement.getSupersedingElement();
			}
			
			
			
			if (element.getSupersedingElement() != null || element.getSupersededElement() != null)
				if (element.getSupersedingElement() == element.getSupersededElement()) {
					addErrorMessage(eClass, eObject, diagnostics,
							eClass.getName() + " has equal superseded and superseding element");
				}

			if (element.getSupersededElement() != null && element.getSupersedingElement() != null) {
				Date supersedingValidSince = element.getSupersedingElement().getValidSince();
				Date supersededValidUntil = element.getSupersededElement().getValidUntil();

				if (supersedingValidSince == null && supersededValidUntil == null) {
					addErrorMessage(eClass, eObject, diagnostics,
							eClass.getName()
									+ ": the superseding and superseded elements are valid both valid at all timestamps." + 
									". Define valid since of superseding element and valid until of superseded element to avoid this error");
				}
				if (supersedingValidSince == null && supersededValidUntil != null) {
					addErrorMessage(eClass, eObject, diagnostics,
							eClass.getName()
									+ ": the superseding and superseded elements are valid both valid before timestamp " + supersededValidUntil + 
									". Define valid since of superseding element to avoid this error");
				}
				if (supersedingValidSince != null && supersededValidUntil == null) {
					addErrorMessage(eClass, eObject, diagnostics,
							eClass.getName()
									+ ": the superseding and superseded elements are valid both valid from timestamp " + supersedingValidSince + 
									". Define valid until of superseded element to avoid this error");
				}
				if (supersedingValidSince != null && supersededValidUntil != null) {
					if (supersedingValidSince.equals(supersededValidUntil)) {
						addErrorMessage(eClass, eObject, diagnostics,
								eClass.getName()
										+ ": the superseding and superseded elements are valid at one time stamp. Superseded element until timestamp"
										+ "has to be smaller than until timestamp from superseded element");
					}
				}
			}

		}
	}

	/**
	 * Checks if valid since and valid until are not equal and valid until is before valid since
	 * @param eClass
	 * @param eObject
	 * @param diagnostics
	 * @param context
	 */
	private void checkTemporalConstraint(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {

		if (eObject instanceof HyTemporalElement) {
			HyTemporalElement element = (HyTemporalElement) eObject;

			if (element.getValidSince() != null && element.getValidUntil() != null) {
				if (element.getValidSince().equals(element.getValidUntil())) {
					addErrorMessage(eClass, eObject, diagnostics, eClass.getName()
							+ " valid since and valid until are equal. Valid until must be greater than valid since");
				}
				if (element.getValidSince().after(element.getValidUntil())) {
					addErrorMessage(eClass, eObject, diagnostics, eClass.getName()
							+ " valid since is after valid until. Valid since must be before valid until");
				}
			}
		}
	}

	/**
	 * This function calls, depending on object type, the corresponding function to check
	 * all defined constraints for an object.
	 * @param eClass
	 * @param eObject
	 * @param diagnostics
	 * @param context
	 */
	private void checkConstraints(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {

		// initialize list with all used dates by the model
		if (eClass.getName() == "HyFeatureModel") {
			dates = HyEvolutionUtil.collectDates(eObject);
		}

		checkTypes(eClass, eObject, diagnostics, context);
		checkSuperseeding(eClass, eObject, diagnostics, context);
		checkTemporalConstraint(eClass, eObject, diagnostics, context);
		
		if(eObject instanceof HyNamedElement){
		}

		switch (eClass.getName()) {
		case "HyGroup":
			checkHyGroupConstraints(eClass, eObject, diagnostics, context);
			break;
		case "HyFeatureChild":
			checkHyFeatureChildConstraints(eClass, eObject, diagnostics, context);
			break;
		case "HyVersion":
			checkHyVersionConstraints(eClass, eObject, diagnostics, context);
			break;
		case "HyName":
			checkHyNamedElementConstraints(eClass, eObject, diagnostics, context);
			break;
		case "HyFeatureModel":
			checkHyFeatureModelConstraints(eClass, eObject, diagnostics, context);
			break;
		case "HyGroupComposition":
			checkHyGroupCompositionConstraints(eClass, eObject, diagnostics, context);
			break;
		case "HyCardinalityBasedElement":
			checkHyCardinalityBasedElementConstraints(eClass, eObject, diagnostics, context);
			break;
		case "HyLinearTemporalElement":
			checkHyLinearTemporalElementConstraints(eClass, eObject, diagnostics, context);
			break;
		case "HyTemporalElement":
			checkHyTemporalElementConstraints(eClass, eObject, diagnostics, context);
			break;
		case "HyCardinility":
			checkHyCardinilityConstraints(eClass, eObject, diagnostics, context);
			break;
		case "HyRootFeature":
			checkHyRootFeatureConstraints(eClass, eObject, diagnostics, context);
			break;
		case "HyFeature":
			checkHyFeatureConstraints(eClass, eObject, diagnostics, context);
			break;
		case "HyCardinality":
			checkHyCardinalityConstraints(eClass, eObject, diagnostics, context);
		case "":
			break;
		default:
			break;
		}
	}
	
	private void checkHyRootFeatureConstraints(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		
		HyRootFeature rootFeature = (HyRootFeature) eObject;
		/*
		for (int i = 0; i < dates.size(); i++) {
			Date date = dates.get(i);
			
			if(!validSinceUntilCombinationAtTimestamp(date, rootFeature.getValidSince(), rootFeature.getValidUntil())){
				
			}
			if(rootFeature.getValidSince().equals(rootFeature.getValidUntil())){
				
			}
			if(rootFeature.getValidSince().after(rootFeature.getValidUntil())){
				
			}
		}*/
		
		
	}

	/**
	 * Direct validation of {@link EDataType}s is not supported by the EMF
	 * validation framework; they are validated indirectly via the
	 * {@link EObject}s that hold their values.
	 */
	@Override
	public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context) {

		return super.validate(eDataType, value, diagnostics, context);
	}

	/**
	 * If we have a context map, record this object's <code>status</code> in it
	 * so that we will know later that we have processed it and its sub-tree.
	 * 
	 * @param eObject
	 *            an element that we have validated
	 * @param context
	 *            the context (may be <code>null</code>)
	 * @param status
	 *            the element's validation status
	 */
	private void processed(EObject eObject, Map<Object, Object> context, IStatus status) {
		if (context != null) {
			context.put(eObject, status);
		}
	}

	/**
	 * Determines whether we have processed this <code>eObject</code> before, by
	 * automatic recursion of the EMF Model Validation Service. This is only
	 * possible if we do, indeed, have a context.
	 * 
	 * @param eObject
	 *            an element to be validated (we hope not)
	 * @param context
	 *            the context (may be <code>null</code>)
	 * @return <code>true</code> if the context is not <code>null</code> and the
	 *         <code>eObject</code> or one of its containers has already been
	 *         validated; <code>false</code>, otherwise
	 */
	private boolean hasProcessed(EObject eObject, Map<Object, Object> context) {
		boolean result = false;

		if (context != null) {
			// this is O(NlogN) but there's no helping it
			while (eObject != null) {
				if (context.containsKey(eObject)) {
					result = true;
					eObject = null;
				} else {
					eObject = eObject.eContainer();
				}
			}
		}

		return result;
	}

	/**
	 * Converts a status result from the EMF validation service to diagnostics.
	 * 
	 * @param status
	 *            the EMF validation service's status result
	 * @param diagnostics
	 *            a diagnostic chain to accumulate results on
	 */
	private void appendDiagnostics(IStatus status, DiagnosticChain diagnostics) {
		if (status.isMultiStatus()) {
			IStatus[] children = status.getChildren();

			for (IStatus element : children) {
				appendDiagnostics(element, diagnostics);
			}
		} else if (status instanceof IConstraintStatus) {
			diagnostics.add(new BasicDiagnostic(status.getSeverity(), status.getPlugin(), status.getCode(),
					status.getMessage(), ((IConstraintStatus) status).getResultLocus().toArray()));
		}
	}

}
