/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HyvalidityformulaReferenceResolverSwitch implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private Map<Object, Object> options;
	
	protected eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyFeatureValidityFormulaFeatureReferenceResolver hyFeatureValidityFormulaFeatureReferenceResolver = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyFeatureValidityFormulaFeatureReferenceResolver();
	protected eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyAttributeValidityFormulaFeatureReferenceResolver hyAttributeValidityFormulaFeatureReferenceResolver = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyAttributeValidityFormulaFeatureReferenceResolver();
	protected eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyAttributeValidityFormulaAttributeReferenceResolver hyAttributeValidityFormulaAttributeReferenceResolver = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyAttributeValidityFormulaAttributeReferenceResolver();
	protected eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyAbstractFeatureReferenceExpressionFeatureReferenceResolver hyAbstractFeatureReferenceExpressionFeatureReferenceResolver = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyAbstractFeatureReferenceExpressionFeatureReferenceResolver();
	protected eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyAttributeReferenceExpressionFeatureReferenceResolver hyAttributeReferenceExpressionFeatureReferenceResolver = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyAttributeReferenceExpressionFeatureReferenceResolver();
	protected eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyAttributeReferenceExpressionAttributeReferenceResolver hyAttributeReferenceExpressionAttributeReferenceResolver = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyAttributeReferenceExpressionAttributeReferenceResolver();
	protected eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyContextInformationReferenceExpressionContextInformationReferenceResolver hyContextInformationReferenceExpressionContextInformationReferenceResolver = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyContextInformationReferenceExpressionContextInformationReferenceResolver();
	protected eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyRelativeVersionRestrictionVersionReferenceResolver hyRelativeVersionRestrictionVersionReferenceResolver = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyRelativeVersionRestrictionVersionReferenceResolver();
	protected eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyVersionRangeRestrictionLowerVersionReferenceResolver hyVersionRangeRestrictionLowerVersionReferenceResolver = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyVersionRangeRestrictionLowerVersionReferenceResolver();
	protected eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyVersionRangeRestrictionUpperVersionReferenceResolver hyVersionRangeRestrictionUpperVersionReferenceResolver = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyVersionRangeRestrictionUpperVersionReferenceResolver();
	protected eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyEnumValueEnumReferenceResolver hyEnumValueEnumReferenceResolver = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyEnumValueEnumReferenceResolver();
	protected eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyEnumValueEnumLiteralReferenceResolver hyEnumValueEnumLiteralReferenceResolver = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyEnumValueEnumLiteralReferenceResolver();
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<eu.hyvar.context.contextValidity.HyFeatureValidityFormula, eu.hyvar.feature.HyFeature> getHyFeatureValidityFormulaFeatureReferenceResolver() {
		return getResolverChain(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula_Feature(), hyFeatureValidityFormulaFeatureReferenceResolver);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<eu.hyvar.context.contextValidity.HyAttributeValidityFormula, eu.hyvar.feature.HyFeature> getHyAttributeValidityFormulaFeatureReferenceResolver() {
		return getResolverChain(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula_Feature(), hyAttributeValidityFormulaFeatureReferenceResolver);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<eu.hyvar.context.contextValidity.HyAttributeValidityFormula, eu.hyvar.feature.HyFeatureAttribute> getHyAttributeValidityFormulaAttributeReferenceResolver() {
		return getResolverChain(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula_Attribute(), hyAttributeValidityFormulaAttributeReferenceResolver);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature> getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver() {
		return getResolverChain(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAbstractFeatureReferenceExpression_Feature(), hyAbstractFeatureReferenceExpressionFeatureReferenceResolver);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature> getHyAttributeReferenceExpressionFeatureReferenceResolver() {
		return getResolverChain(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression_Feature(), hyAttributeReferenceExpressionFeatureReferenceResolver);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeatureAttribute> getHyAttributeReferenceExpressionAttributeReferenceResolver() {
		return getResolverChain(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression_Attribute(), hyAttributeReferenceExpressionAttributeReferenceResolver);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation> getHyContextInformationReferenceExpressionContextInformationReferenceResolver() {
		return getResolverChain(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression_ContextInformation(), hyContextInformationReferenceExpressionContextInformationReferenceResolver);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<eu.hyvar.feature.expression.HyRelativeVersionRestriction, eu.hyvar.feature.HyVersion> getHyRelativeVersionRestrictionVersionReferenceResolver() {
		return getResolverChain(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction_Version(), hyRelativeVersionRestrictionVersionReferenceResolver);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion> getHyVersionRangeRestrictionLowerVersionReferenceResolver() {
		return getResolverChain(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction_LowerVersion(), hyVersionRangeRestrictionLowerVersionReferenceResolver);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion> getHyVersionRangeRestrictionUpperVersionReferenceResolver() {
		return getResolverChain(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction_UpperVersion(), hyVersionRangeRestrictionUpperVersionReferenceResolver);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum> getHyEnumValueEnumReferenceResolver() {
		return getResolverChain(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue_Enum(), hyEnumValueEnumReferenceResolver);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral> getHyEnumValueEnumLiteralReferenceResolver() {
		return getResolverChain(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue_EnumLiteral(), hyEnumValueEnumLiteralReferenceResolver);
	}
	
	public void setOptions(Map<?, ?> options) {
		if (options != null) {
			this.options = new LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		hyFeatureValidityFormulaFeatureReferenceResolver.setOptions(options);
		hyAttributeValidityFormulaFeatureReferenceResolver.setOptions(options);
		hyAttributeValidityFormulaAttributeReferenceResolver.setOptions(options);
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
	
	public void resolveFuzzy(String identifier, EObject container, EReference reference, int position, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolveResult<EObject> result) {
		if (container == null) {
			return;
		}
		if (eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula().isInstance(container)) {
			HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyFeature> frr = new HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyFeature>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("feature")) {
				hyFeatureValidityFormulaFeatureReferenceResolver.resolve(identifier, (eu.hyvar.context.contextValidity.HyFeatureValidityFormula) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula().isInstance(container)) {
			HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyFeature> frr = new HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyFeature>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("feature")) {
				hyAttributeValidityFormulaFeatureReferenceResolver.resolve(identifier, (eu.hyvar.context.contextValidity.HyAttributeValidityFormula) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula().isInstance(container)) {
			HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyFeatureAttribute> frr = new HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyFeatureAttribute>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("attribute")) {
				hyAttributeValidityFormulaAttributeReferenceResolver.resolve(identifier, (eu.hyvar.context.contextValidity.HyAttributeValidityFormula) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAbstractFeatureReferenceExpression().isInstance(container)) {
			HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyFeature> frr = new HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyFeature>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("feature")) {
				hyAbstractFeatureReferenceExpressionFeatureReferenceResolver.resolve(identifier, (eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().isInstance(container)) {
			HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyFeature> frr = new HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyFeature>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("feature")) {
				hyAttributeReferenceExpressionFeatureReferenceResolver.resolve(identifier, (eu.hyvar.feature.expression.HyAttributeReferenceExpression) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().isInstance(container)) {
			HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyFeatureAttribute> frr = new HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyFeatureAttribute>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("attribute")) {
				hyAttributeReferenceExpressionAttributeReferenceResolver.resolve(identifier, (eu.hyvar.feature.expression.HyAttributeReferenceExpression) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression().isInstance(container)) {
			HyvalidityformulaFuzzyResolveResult<eu.hyvar.context.HyContextualInformation> frr = new HyvalidityformulaFuzzyResolveResult<eu.hyvar.context.HyContextualInformation>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("contextInformation")) {
				hyContextInformationReferenceExpressionContextInformationReferenceResolver.resolve(identifier, (eu.hyvar.feature.expression.HyContextInformationReferenceExpression) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction().isInstance(container)) {
			HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyVersion> frr = new HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyVersion>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("version")) {
				hyRelativeVersionRestrictionVersionReferenceResolver.resolve(identifier, (eu.hyvar.feature.expression.HyRelativeVersionRestriction) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().isInstance(container)) {
			HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyVersion> frr = new HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyVersion>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("lowerVersion")) {
				hyVersionRangeRestrictionLowerVersionReferenceResolver.resolve(identifier, (eu.hyvar.feature.expression.HyVersionRangeRestriction) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().isInstance(container)) {
			HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyVersion> frr = new HyvalidityformulaFuzzyResolveResult<eu.hyvar.feature.HyVersion>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("upperVersion")) {
				hyVersionRangeRestrictionUpperVersionReferenceResolver.resolve(identifier, (eu.hyvar.feature.expression.HyVersionRangeRestriction) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().isInstance(container)) {
			HyvalidityformulaFuzzyResolveResult<eu.hyvar.dataValues.HyEnum> frr = new HyvalidityformulaFuzzyResolveResult<eu.hyvar.dataValues.HyEnum>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("enum")) {
				hyEnumValueEnumReferenceResolver.resolve(identifier, (eu.hyvar.dataValues.HyEnumValue) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().isInstance(container)) {
			HyvalidityformulaFuzzyResolveResult<eu.hyvar.dataValues.HyEnumLiteral> frr = new HyvalidityformulaFuzzyResolveResult<eu.hyvar.dataValues.HyEnumLiteral>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("enumLiteral")) {
				hyEnumValueEnumLiteralReferenceResolver.resolve(identifier, (eu.hyvar.dataValues.HyEnumValue) container, (EReference) feature, position, true, frr);
			}
		}
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<? extends EObject, ? extends EObject> getResolver(EStructuralFeature reference) {
		if (reference == eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula_Feature()) {
			return getResolverChain(reference, hyFeatureValidityFormulaFeatureReferenceResolver);
		}
		if (reference == eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula_Feature()) {
			return getResolverChain(reference, hyAttributeValidityFormulaFeatureReferenceResolver);
		}
		if (reference == eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula_Attribute()) {
			return getResolverChain(reference, hyAttributeValidityFormulaAttributeReferenceResolver);
		}
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
	public <ContainerType extends EObject, ReferenceType extends EObject> eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<ContainerType, ReferenceType> getResolverChain(EStructuralFeature reference, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof Map)) {
			// send this to the error log
			new eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaRuntimeUtil().logWarning("Found value with invalid type for option " + eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		Map<?,?> resolverMap = (Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver) {
			eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver replacingResolver = (eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver) resolverValue;
			if (replacingResolver instanceof eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof Collection) {
			Collection replacingResolvers = (Collection) resolverValue;
			eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceCache) {
					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver nextResolver = (eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver) next;
					if (nextResolver instanceof eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaRuntimeUtil().logWarning("Found value with invalid type in value map for option " + eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaRuntimeUtil().logWarning("Found value with invalid type in value map for option " + eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
