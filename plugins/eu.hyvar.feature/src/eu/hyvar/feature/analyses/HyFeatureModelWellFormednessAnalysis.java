package eu.hyvar.feature.analyses;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;

@Deprecated
/**
 * Use eu.hyvar.feature.analyses.DwFeatureModelAnalyses instead.
 * @author Michael Nieke
 *
 */
public class HyFeatureModelWellFormednessAnalysis {
	// TODO superseding relations checked on correctness
	
	// TODO exception handling to provide more information
	private HashSet<HyGroupComposition> checkedGroupCompositions = new HashSet<HyGroupComposition>();
	private HashSet<HyFeatureChild> checkedFeatureChilds = new HashSet<HyFeatureChild>();
	
	public boolean isWellFormed(HyFeatureModel featureModel) throws HyFeatureModelWellFormednessException {
		
		EList<HyFeature> allFeatures = featureModel.getFeatures();
		validitiesAreWellFormed(allFeatures);
		
		EList<HyGroup> allGroups = featureModel.getGroups();
		validitiesAreWellFormed(allGroups);
		
		EList<HyEnum> allEnums = featureModel.getEnums();
		validitiesAreWellFormed(allEnums);

		EList<HyRootFeature> rootFeatures = featureModel.getRootFeature();
		validitiesAreWellFormed(rootFeatures);
		// Only one valid root Feature at a time
		exactOneValidElement(rootFeatures);
		
		for(HyFeature feature: allFeatures) {
			checkFeature(feature);			
		}
		
		for(HyGroup group: allGroups) {
			checkGroup(group);
		}
		
		for(HyEnum hyEnum: allEnums) {
			checkEnum(hyEnum);
		}
		
		return true;
	}
	
	/**
	 * TODO necessary?: at least one version at a time
	 * Checks a feature for well formedness. Concrete: validities of cardinalities, names, attributes, group membership (composition), children and versions.
	 * Exact one element at a time of: cardinality, name, group membership (composition) 
	 * For attributes:
	 * exact one name and if HyEnumAttribute, validity is in range of enum validity
	 * @param feature
	 * @throws HyFeatureModelWellFormednessException
	 */
	private void checkFeature(HyFeature feature) throws HyFeatureModelWellFormednessException {
		EList<HyFeatureType> types = feature.getTypes();
		validitiesAreWellFormed(types);
		exactOneValidElement(types);
		
		EList<HyName> featureNames = feature.getNames();
		validitiesAreWellFormed(featureNames);
		exactOneValidElement(featureNames);
		
		// TODO
//		EList<HyFeatureAttribute<?>> attributes = feature.getAttributes();
//		validitiesAreWellFormed(attributes);
//		for(HyFeatureAttribute<?> attribute: attributes) {
//			EList<HyName> attributeNames = attribute.getName();
//			validitiesAreWellFormed(attributeNames);
//			exactOneValidElement(attributeNames);
//			
//			if(attribute instanceof HyEnumAttribute) {
//				HyEnumAttribute enumAttribute = (HyEnumAttribute) attribute;
//				HyEnum enumType = enumAttribute.getEnumType();
//				elementIsInValidityRangeOfOtherElement(enumAttribute, enumType);
//			}
//		}
		
		// Group memberships of feature
		EList<HyGroupComposition> groupMemberships = feature.getGroupMembership();
		for(HyGroupComposition groupComposition: groupMemberships) {
			if(!checkedGroupCompositions.contains(groupComposition)) {
				checkGroupComposition(groupComposition);
				checkedGroupCompositions.add(groupComposition);
			}
		}
		// A feature is only supposed to be in one group at a time
		exactOneValidElement(groupMemberships);
		
		EList<HyFeatureChild> children = feature.getParentOf();
		for(HyFeatureChild child: children) {
			if(!checkedFeatureChilds.contains(child)) {
				checkFeatureChild(child);
				checkedFeatureChilds.add(child);
			}
		}
		
		EList<HyVersion> versions = feature.getVersions();
		for(HyVersion version: versions) {
			validityIsWellFormed(version);
//			elementIsInValidityRangeOfOtherElement(version, feature);
		}
	}
	
	/**
	 * Checks a group for well formedness. Concrete: validities of cardinalities, parents (HyFeatureChild) and compositions
	 * Exact one element at a time of: cardinality, parent (HyFeatureChild) and composition
	 * @param group
	 * @throws HyFeatureModelWellFormednessException
	 */
	private void checkGroup(HyGroup group) throws HyFeatureModelWellFormednessException {
		EList<HyGroupType> types = group.getTypes();
		validitiesAreWellFormed(types);
		exactOneValidElement(types);
		
		EList<HyFeatureChild> parentFeatures = group.getChildOf();
		for(HyFeatureChild parent: parentFeatures) {
			if(!checkedFeatureChilds.contains(parent)) {
				validityIsWellFormed(parent);
				checkFeatureChild(parent);
				checkedFeatureChilds.add(parent);
			}
		}
		exactOneValidElement(parentFeatures);
		
		EList<HyGroupComposition> compositions = group.getParentOf();
		for(HyGroupComposition composition: compositions) {
			if(!checkedGroupCompositions.contains(composition)) {
				validityIsWellFormed(composition);
				checkGroupComposition(composition);
				checkedGroupCompositions.add(composition);
			}
		}
		exactOneValidElement(compositions);
	}
	
	/**
	 * TODO needs an enum at least one valid literal at a time?
	 * Checks an HyEnum for well formedness. Concrete: validities of names and literals
	 * Exact one valid name at a time
	 * @param hyEnum
	 * @throws HyFeatureModelWellFormednessException
	 */
	private void checkEnum(HyEnum hyEnum) throws HyFeatureModelWellFormednessException {
//		EList<HyName> names = hyEnum.getNames();
//		validitiesAreWellFormed(names);
//		exactOneValidElement(names);
		EList<HyEnumLiteral> literals = hyEnum.getLiterals();
		validitiesAreWellFormed(literals);
		
//		TODO :unnecessary? bad modeling bad not crucial
//		for(HyEnumLiteral literal : literals) {
//			elementIsInValidityRangeOfOtherElement(literal, hyEnum);
//		}
	}
	
	
	/**
	 * Checks a HyFeatureChild for well formedness:
	 * its validity
	 * Child group and parent feature are not null
	 * @param featureChild
	 * @throws HyFeatureModelWellFormednessException
	 */
	private void checkFeatureChild(HyFeatureChild featureChild) throws HyFeatureModelWellFormednessException {
		validityIsWellFormed(featureChild);
		
		if(featureChild.getChildGroup() == null) {
			// TODO content
			throw new HyFeatureModelWellFormednessException();
		}
		
		if(featureChild.getParent() == null) {
			// TODO content
			throw new HyFeatureModelWellFormednessException();
		}
		
//		TODO unnecessary. Bad modeling but not crucial
//		elementIsInValidityRangeOfOtherElement(featureChild, featureChild.getChildGroup());
//		elementIsInValidityRangeOfOtherElement(featureChild, featureChild.getParent());
	}
	
	/**
	 * Checks a HyGroupComposition for well formedness:
	 * validity
	 * composing group != null
	 * containing features != null && > 0
	 * @param groupComposition non-null
	 * @throws HyFeatureModelWellFormednessException
	 */
	private void checkGroupComposition(HyGroupComposition groupComposition) throws HyFeatureModelWellFormednessException {
		validityIsWellFormed(groupComposition);
		
		EList<HyFeature> features = groupComposition.getFeatures();
		if(features == null || features.size() <= 0) {
			// TODO content and really if size == 0? size==0 bad modeling but not crucial
			throw new HyFeatureModelWellFormednessException();
		}
		if(groupComposition.getCompositionOf() == null) {
			// TODO content
			throw new HyFeatureModelWellFormednessException();
		}
		
//		TODO unnecessary: bad modeling but not crucial
//		elementIsInValidityRangeOfOtherElement(groupComposition, groupComposition.getCompositionOf());
//		elementIsInValidityRangeOfOtherElements(groupComposition, groupComposition.getFeatures());
	}
	
	
	/**
	 * Such that the validity of element is lower or equal than of elements
	 * @param element
	 * @param elements
	 * @return
	 * @throws HyFeatureModelWellFormednessException
	 */
	protected boolean elementIsInValidityRangeOfOtherElements(HyTemporalElement element, EList<? extends HyTemporalElement> elements) throws HyFeatureModelWellFormednessException {
		
		for(HyTemporalElement ele: elements) {
			elementIsInValidityRangeOfOtherElement(element, ele);
		}
		
		return true;		
	}
	
	/**
	 * Such that the validity of element is lower or equal than validity of otherElement
	 * @param element
	 * @param otherElement
	 * @return
	 * @throws HyFeatureModelWellFormednessException
	 */
	protected boolean elementIsInValidityRangeOfOtherElement(HyTemporalElement element, HyTemporalElement otherElement) throws HyFeatureModelWellFormednessException {
		Date validSince = element.getValidSince();
		Date validUntil = element.getValidUntil();
		
		Date otherValidSince = otherElement.getValidSince();
		Date otherValidUntil = otherElement.getValidUntil();
		
		if(validSince == null) {
			if(otherValidSince != null) {
				// TODO content
				throw new HyFeatureModelWellFormednessException();
			}
		} else if(otherValidSince != null && validSince.before(otherValidSince)) {
				// TODO content
				throw new HyFeatureModelWellFormednessException();
		}
		
		if(validUntil == null) {
			if(otherValidUntil != null) {
				// TODO content
				throw new HyFeatureModelWellFormednessException();
			}
		} else if(otherValidUntil != null && validUntil.after(otherValidUntil)) {
			// TODO content
			throw new HyFeatureModelWellFormednessException();
		}
		
		return true;
	}
	
	/**
	 * Checks every HyTemporalElement of the list for well formed validities with validityIsWellFormed
	 * @param temporalElements
	 * @return
	 * @throws HyFeatureModelWellFormednessException
	 */
	public boolean validitiesAreWellFormed(EList<? extends HyTemporalElement> temporalElements) throws HyFeatureModelWellFormednessException  {
		for(HyTemporalElement element: temporalElements) {
			validityIsWellFormed(element);
		}
		
		return true;
	}
	
	/**
	 * Checks a HyTemporalElement for well formed validity. Concrete: validSince must _not_ be after validUntil. Special case: if either one is null (than it is well formed)
	 * @param temporalElement
	 * @return
	 * @throws HyFeatureModelWellFormednessException
	 */
	public boolean validityIsWellFormed(HyTemporalElement temporalElement) throws HyFeatureModelWellFormednessException {
		if(temporalElement.getValidSince() == null || temporalElement.getValidUntil() == null) {
			return true;
		}
		else if(temporalElement.getValidSince().after(temporalElement.getValidUntil())) {
			// TODO error handling
			throw new HyFeatureModelWellFormednessException();
		}
		
		return true;
	}
	
	/**
	 * Assuming that validities are wellFormed
	 * @param namedElement
	 * @return
	 */
	public boolean exactOneValidElement(EList<? extends HyTemporalElement> elements) throws HyFeatureModelWellFormednessException {
		if(elements == null || elements.size()<=0) {
			// TODO
			throw new HyFeatureModelWellFormednessException();
		}
		
		// Pairwise testing
		for(int i=0;i<elements.size()-2;i++) {
			for(int j=i+1;j<elements.size()-1;j++) {
				HyTemporalElement firstElement = elements.get(i);
				HyTemporalElement secondElement = elements.get(j);
				
				Date firstValidSince = firstElement.getValidSince();
				Date firstValidUntil = firstElement.getValidUntil();
				Date secondValidSince = secondElement.getValidSince();
				Date secondValidUntil = secondElement.getValidUntil();
				
				if(firstValidSince == null && secondValidSince == null) {
					// TODO error handling
					throw new HyFeatureModelWellFormednessException();
				}
				else if(firstValidUntil == null && secondValidUntil == null) {
					// TODO error handling
					throw new HyFeatureModelWellFormednessException();
				} 
				// case first before second
				else if(firstValidSince == null || firstValidSince.before(secondValidSince)) {
					// if both validities of one element are null, none other may exist
					if(firstValidUntil == null) {
						// TODO error handling
						throw new HyFeatureModelWellFormednessException();
					}
					else if(secondValidSince.before(firstValidUntil)) {
						// TODO error handling
						throw new HyFeatureModelWellFormednessException();			
					}
				}
				// case second before first 
				else if(secondValidSince == null || secondValidSince.before(firstValidSince)) {
					// if both validities of one element are null, none other may exist
					if(secondValidUntil == null) {
						// TODO error handling
						throw new HyFeatureModelWellFormednessException();
					}
					else if(firstValidSince.before(secondValidUntil)) {
						// TODO error handling
						throw new HyFeatureModelWellFormednessException();
					}
				}
			}
		}
		
		return true;
	}
	
	
	// TODO integrate
//	List<Date> dates = HyEvolutionUtil.collectDates(mergedFeatureModel);
//	
//	for(Date date: dates) {
//		for(HyFeature feature: mergedFeatureModel.getFeatures()) {
//			if(HyEvolutionUtil.isValid(feature, date)) {
//				List<HyGroupComposition> groupMemberships = HyEvolutionUtil.getValidTemporalElements(feature.getGroupMembership(), date) ;
//				
//				if(groupMemberships == null || groupMemberships.size() == 0) {
//					System.err.println("Feature "+HyEvolutionUtil.getValidTemporalElement(feature.getNames(), date).getName()+ " has no group membership at date "+date);
//				}
//				else if(groupMemberships.size() > 1) {
//					System.err.println("Feature "+HyEvolutionUtil.getValidTemporalElement(feature.getNames(), date).getName()+ " has multiple group membership at date "+date);
//				}
//			}
//		}
//		
//		for(HyGroup group: mergedFeatureModel.getGroups()) {
//			if(HyEvolutionUtil.isValid(group, date)) {
//				List<HyFeatureChild> featureChildrenParent = HyEvolutionUtil.getValidTemporalElements(group.getChildOf(), date);
//				List<HyGroupComposition> groupCompositions = HyEvolutionUtil.getValidTemporalElements(group.getParentOf(), date);
//				
//				if(featureChildrenParent == null || featureChildrenParent.size() == 0) {
//					System.err.println("Group has no group parent feature at date "+date);
//				}
//				else if(featureChildrenParent.size() > 1) {
//					System.err.println("Group has multiple group parent feature at date "+date);
//				}
//				
//				if(groupCompositions == null || groupCompositions.size() == 0) {
//					System.err.println("Group has no composition at date "+date);
//				}
//				else if(groupCompositions.size() > 1) {
//					System.err.println("Group has multiple compositions at date "+date);
//				}
//			}
//		}
//	}
//	
//	
////	for(HyGroup group: mergedFeatureModel.getGroups()) {
////		for(HyGroupComposition groupComposition: group.getParentOf()) {
////			if(!mergedFeatureModel.getFeatures().containsAll(groupComposition.getFeatures())) {
////				System.err.println("Non consistent!");
////				return;
////			}
////		}
////	}
	
	
}
