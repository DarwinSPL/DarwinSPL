/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class DwprofileReferenceResolverSwitch implements de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private Map<Object, Object> options;
	
	protected de.darwinspl.preferences.resource.dwprofile.analysis.HyAbstractFeatureReferenceExpressionFeatureReferenceResolver hyAbstractFeatureReferenceExpressionFeatureReferenceResolver = new de.darwinspl.preferences.resource.dwprofile.analysis.HyAbstractFeatureReferenceExpressionFeatureReferenceResolver();
	protected de.darwinspl.preferences.resource.dwprofile.analysis.HyAttributeReferenceExpressionFeatureReferenceResolver hyAttributeReferenceExpressionFeatureReferenceResolver = new de.darwinspl.preferences.resource.dwprofile.analysis.HyAttributeReferenceExpressionFeatureReferenceResolver();
	protected de.darwinspl.preferences.resource.dwprofile.analysis.HyAttributeReferenceExpressionAttributeReferenceResolver hyAttributeReferenceExpressionAttributeReferenceResolver = new de.darwinspl.preferences.resource.dwprofile.analysis.HyAttributeReferenceExpressionAttributeReferenceResolver();
	protected de.darwinspl.preferences.resource.dwprofile.analysis.HyContextInformationReferenceExpressionContextInformationReferenceResolver hyContextInformationReferenceExpressionContextInformationReferenceResolver = new de.darwinspl.preferences.resource.dwprofile.analysis.HyContextInformationReferenceExpressionContextInformationReferenceResolver();
	protected de.darwinspl.preferences.resource.dwprofile.analysis.HyRelativeVersionRestrictionVersionReferenceResolver hyRelativeVersionRestrictionVersionReferenceResolver = new de.darwinspl.preferences.resource.dwprofile.analysis.HyRelativeVersionRestrictionVersionReferenceResolver();
	protected de.darwinspl.preferences.resource.dwprofile.analysis.HyVersionRangeRestrictionLowerVersionReferenceResolver hyVersionRangeRestrictionLowerVersionReferenceResolver = new de.darwinspl.preferences.resource.dwprofile.analysis.HyVersionRangeRestrictionLowerVersionReferenceResolver();
	protected de.darwinspl.preferences.resource.dwprofile.analysis.HyVersionRangeRestrictionUpperVersionReferenceResolver hyVersionRangeRestrictionUpperVersionReferenceResolver = new de.darwinspl.preferences.resource.dwprofile.analysis.HyVersionRangeRestrictionUpperVersionReferenceResolver();
	protected de.darwinspl.preferences.resource.dwprofile.analysis.HyEnumValueEnumReferenceResolver hyEnumValueEnumReferenceResolver = new de.darwinspl.preferences.resource.dwprofile.analysis.HyEnumValueEnumReferenceResolver();
	protected de.darwinspl.preferences.resource.dwprofile.analysis.HyEnumValueEnumLiteralReferenceResolver hyEnumValueEnumLiteralReferenceResolver = new de.darwinspl.preferences.resource.dwprofile.analysis.HyEnumValueEnumLiteralReferenceResolver();
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature> getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver() {
		return getResolverChain(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAbstractFeatureReferenceExpression_Feature(), hyAbstractFeatureReferenceExpressionFeatureReferenceResolver);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature> getHyAttributeReferenceExpressionFeatureReferenceResolver() {
		return getResolverChain(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression_Feature(), hyAttributeReferenceExpressionFeatureReferenceResolver);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeatureAttribute> getHyAttributeReferenceExpressionAttributeReferenceResolver() {
		return getResolverChain(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression_Attribute(), hyAttributeReferenceExpressionAttributeReferenceResolver);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation> getHyContextInformationReferenceExpressionContextInformationReferenceResolver() {
		return getResolverChain(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression_ContextInformation(), hyContextInformationReferenceExpressionContextInformationReferenceResolver);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<eu.hyvar.feature.expression.HyRelativeVersionRestriction, eu.hyvar.feature.HyVersion> getHyRelativeVersionRestrictionVersionReferenceResolver() {
		return getResolverChain(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction_Version(), hyRelativeVersionRestrictionVersionReferenceResolver);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion> getHyVersionRangeRestrictionLowerVersionReferenceResolver() {
		return getResolverChain(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction_LowerVersion(), hyVersionRangeRestrictionLowerVersionReferenceResolver);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion> getHyVersionRangeRestrictionUpperVersionReferenceResolver() {
		return getResolverChain(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction_UpperVersion(), hyVersionRangeRestrictionUpperVersionReferenceResolver);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum> getHyEnumValueEnumReferenceResolver() {
		return getResolverChain(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue_Enum(), hyEnumValueEnumReferenceResolver);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral> getHyEnumValueEnumLiteralReferenceResolver() {
		return getResolverChain(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue_EnumLiteral(), hyEnumValueEnumLiteralReferenceResolver);
	}
	
	public void setOptions(Map<?, ?> options) {
		if (options != null) {
			this.options = new LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		hyAbstractFeatureReferenceExpressionFeatureReferenceResolver.setOptions(options);
		hyAttributeReferenceExpressionFeatureReferenceResolver.setOptions(options);
		hyAttributeReferenceExpressionAttributeReferenceResolver.setOptions(options);
		hyContextInformationReferenceExpressionContextInformationReferenceResolver.setOptions(options);
		hyRelativeVersionRestrictionVersionReferenceResolver.setOptions(options);
		hyVersionRangeRestrictionLowerVersionReferenceResolver.setOptions(options);
		hyVersionRangeRestrictionUpperVersionReferenceResolver.setOptions(options);
		hyEnumValueEnumReferenceResolver.setOptions(options);
		hyEnumValueEnumLiteralReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, EObject container, EReference reference, int position, de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolveResult<EObject> result) {
		if (container == null) {
			return;
		}
		if (eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAbstractFeatureReferenceExpression().isInstance(container)) {
			DwprofileFuzzyResolveResult<eu.hyvar.feature.HyFeature> frr = new DwprofileFuzzyResolveResult<eu.hyvar.feature.HyFeature>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("feature")) {
				hyAbstractFeatureReferenceExpressionFeatureReferenceResolver.resolve(identifier, (eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().isInstance(container)) {
			DwprofileFuzzyResolveResult<eu.hyvar.feature.HyFeature> frr = new DwprofileFuzzyResolveResult<eu.hyvar.feature.HyFeature>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("feature")) {
				hyAttributeReferenceExpressionFeatureReferenceResolver.resolve(identifier, (eu.hyvar.feature.expression.HyAttributeReferenceExpression) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().isInstance(container)) {
			DwprofileFuzzyResolveResult<eu.hyvar.feature.HyFeatureAttribute> frr = new DwprofileFuzzyResolveResult<eu.hyvar.feature.HyFeatureAttribute>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("attribute")) {
				hyAttributeReferenceExpressionAttributeReferenceResolver.resolve(identifier, (eu.hyvar.feature.expression.HyAttributeReferenceExpression) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression().isInstance(container)) {
			DwprofileFuzzyResolveResult<eu.hyvar.context.HyContextualInformation> frr = new DwprofileFuzzyResolveResult<eu.hyvar.context.HyContextualInformation>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("contextInformation")) {
				hyContextInformationReferenceExpressionContextInformationReferenceResolver.resolve(identifier, (eu.hyvar.feature.expression.HyContextInformationReferenceExpression) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction().isInstance(container)) {
			DwprofileFuzzyResolveResult<eu.hyvar.feature.HyVersion> frr = new DwprofileFuzzyResolveResult<eu.hyvar.feature.HyVersion>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("version")) {
				hyRelativeVersionRestrictionVersionReferenceResolver.resolve(identifier, (eu.hyvar.feature.expression.HyRelativeVersionRestriction) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().isInstance(container)) {
			DwprofileFuzzyResolveResult<eu.hyvar.feature.HyVersion> frr = new DwprofileFuzzyResolveResult<eu.hyvar.feature.HyVersion>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("lowerVersion")) {
				hyVersionRangeRestrictionLowerVersionReferenceResolver.resolve(identifier, (eu.hyvar.feature.expression.HyVersionRangeRestriction) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().isInstance(container)) {
			DwprofileFuzzyResolveResult<eu.hyvar.feature.HyVersion> frr = new DwprofileFuzzyResolveResult<eu.hyvar.feature.HyVersion>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("upperVersion")) {
				hyVersionRangeRestrictionUpperVersionReferenceResolver.resolve(identifier, (eu.hyvar.feature.expression.HyVersionRangeRestriction) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().isInstance(container)) {
			DwprofileFuzzyResolveResult<eu.hyvar.dataValues.HyEnum> frr = new DwprofileFuzzyResolveResult<eu.hyvar.dataValues.HyEnum>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("enum")) {
				hyEnumValueEnumReferenceResolver.resolve(identifier, (eu.hyvar.dataValues.HyEnumValue) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().isInstance(container)) {
			DwprofileFuzzyResolveResult<eu.hyvar.dataValues.HyEnumLiteral> frr = new DwprofileFuzzyResolveResult<eu.hyvar.dataValues.HyEnumLiteral>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("enumLiteral")) {
				hyEnumValueEnumLiteralReferenceResolver.resolve(identifier, (eu.hyvar.dataValues.HyEnumValue) container, (EReference) feature, position, true, frr);
			}
		}
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<? extends EObject, ? extends EObject> getResolver(EStructuralFeature reference) {
		if (reference == eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAbstractFeatureReferenceExpression_Feature()) {
			return getResolverChain(reference, hyAbstractFeatureReferenceExpressionFeatureReferenceResolver);
		}
		if (reference == eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression_Feature()) {
			return getResolverChain(reference, hyAttributeReferenceExpressionFeatureReferenceResolver);
		}
		if (reference == eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression_Attribute()) {
			return getResolverChain(reference, hyAttributeReferenceExpressionAttributeReferenceResolver);
		}
		if (reference == eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression_ContextInformation()) {
			return getResolverChain(reference, hyContextInformationReferenceExpressionContextInformationReferenceResolver);
		}
		if (reference == eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction_Version()) {
			return getResolverChain(reference, hyRelativeVersionRestrictionVersionReferenceResolver);
		}
		if (reference == eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction_LowerVersion()) {
			return getResolverChain(reference, hyVersionRangeRestrictionLowerVersionReferenceResolver);
		}
		if (reference == eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction_UpperVersion()) {
			return getResolverChain(reference, hyVersionRangeRestrictionUpperVersionReferenceResolver);
		}
		if (reference == eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue_Enum()) {
			return getResolverChain(reference, hyEnumValueEnumReferenceResolver);
		}
		if (reference == eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue_EnumLiteral()) {
			return getResolverChain(reference, hyEnumValueEnumLiteralReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public <ContainerType extends EObject, ReferenceType extends EObject> de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<ContainerType, ReferenceType> getResolverChain(EStructuralFeature reference, de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(de.darwinspl.preferences.resource.dwprofile.IDwprofileOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof Map)) {
			// send this to the error log
			new de.darwinspl.preferences.resource.dwprofile.util.DwprofileRuntimeUtil().logWarning("Found value with invalid type for option " + de.darwinspl.preferences.resource.dwprofile.IDwprofileOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		Map<?,?> resolverMap = (Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver) {
			de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver replacingResolver = (de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver) resolverValue;
			if (replacingResolver instanceof de.darwinspl.preferences.resource.dwprofile.IDwprofileDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((de.darwinspl.preferences.resource.dwprofile.IDwprofileDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof Collection) {
			Collection replacingResolvers = (Collection) resolverValue;
			de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceCache) {
					de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver nextResolver = (de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver) next;
					if (nextResolver instanceof de.darwinspl.preferences.resource.dwprofile.IDwprofileDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((de.darwinspl.preferences.resource.dwprofile.IDwprofileDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new de.darwinspl.preferences.resource.dwprofile.util.DwprofileRuntimeUtil().logWarning("Found value with invalid type in value map for option " + de.darwinspl.preferences.resource.dwprofile.IDwprofileOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + de.darwinspl.preferences.resource.dwprofile.IDwprofileDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new de.darwinspl.preferences.resource.dwprofile.util.DwprofileRuntimeUtil().logWarning("Found value with invalid type in value map for option " + de.darwinspl.preferences.resource.dwprofile.IDwprofileOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + de.darwinspl.preferences.resource.dwprofile.IDwprofileDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
