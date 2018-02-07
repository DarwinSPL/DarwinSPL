/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HymanifestReferenceResolverSwitch implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private Map<Object, Object> options;
	
	protected eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedDependenciesSignatureReferenceResolver hyTimedDependenciesSignatureReferenceResolver = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedDependenciesSignatureReferenceResolver();
	protected eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationsSignatureReferenceResolver hyTimedImplementationsSignatureReferenceResolver = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationsSignatureReferenceResolver();
	protected eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationFeatureLinkLocalReferenceResolver hyTimedImplementationFeatureLinkLocalReferenceResolver = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationFeatureLinkLocalReferenceResolver();
	protected eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationFeatureLinkSignatureReferenceResolver hyTimedImplementationFeatureLinkSignatureReferenceResolver = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationFeatureLinkSignatureReferenceResolver();
	protected eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationFeatureAttributeLinkLocalReferenceResolver hyTimedImplementationFeatureAttributeLinkLocalReferenceResolver = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationFeatureAttributeLinkLocalReferenceResolver();
	protected eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationFeatureAttributeLinkSignatureReferenceResolver hyTimedImplementationFeatureAttributeLinkSignatureReferenceResolver = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationFeatureAttributeLinkSignatureReferenceResolver();
	protected eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationEnumLinkLocalReferenceResolver hyTimedImplementationEnumLinkLocalReferenceResolver = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationEnumLinkLocalReferenceResolver();
	protected eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationEnumLinkSignatureReferenceResolver hyTimedImplementationEnumLinkSignatureReferenceResolver = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationEnumLinkSignatureReferenceResolver();
	protected eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationEnumLiteralLinkLocalReferenceResolver hyTimedImplementationEnumLiteralLinkLocalReferenceResolver = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationEnumLiteralLinkLocalReferenceResolver();
	protected eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationEnumLiteralLinkSignatureReferenceResolver hyTimedImplementationEnumLiteralLinkSignatureReferenceResolver = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyTimedImplementationEnumLiteralLinkSignatureReferenceResolver();
	protected eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyEnumValueEnumReferenceResolver hyEnumValueEnumReferenceResolver = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyEnumValueEnumReferenceResolver();
	protected eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyEnumValueEnumLiteralReferenceResolver hyEnumValueEnumLiteralReferenceResolver = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HyEnumValueEnumLiteralReferenceResolver();
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.mspl.manifest.HyTimedDependencies, eu.hyvar.mspl.manifest.HySPLSignature> getHyTimedDependenciesSignatureReferenceResolver() {
		return getResolverChain(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedDependencies_Signature(), hyTimedDependenciesSignatureReferenceResolver);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.mspl.manifest.HyTimedImplementations, eu.hyvar.mspl.manifest.HySPLSignature> getHyTimedImplementationsSignatureReferenceResolver() {
		return getResolverChain(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations_Signature(), hyTimedImplementationsSignatureReferenceResolver);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.mspl.manifest.HyTimedImplementationFeatureLink, eu.hyvar.feature.HyFeature> getHyTimedImplementationFeatureLinkLocalReferenceResolver() {
		return getResolverChain(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationFeatureLink_Local(), hyTimedImplementationFeatureLinkLocalReferenceResolver);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.mspl.manifest.HyTimedImplementationFeatureLink, eu.hyvar.feature.HyFeature> getHyTimedImplementationFeatureLinkSignatureReferenceResolver() {
		return getResolverChain(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationFeatureLink_Signature(), hyTimedImplementationFeatureLinkSignatureReferenceResolver);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.mspl.manifest.HyTimedImplementationFeatureAttributeLink, eu.hyvar.feature.HyFeatureAttribute> getHyTimedImplementationFeatureAttributeLinkLocalReferenceResolver() {
		return getResolverChain(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationFeatureAttributeLink_Local(), hyTimedImplementationFeatureAttributeLinkLocalReferenceResolver);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.mspl.manifest.HyTimedImplementationFeatureAttributeLink, eu.hyvar.feature.HyFeatureAttribute> getHyTimedImplementationFeatureAttributeLinkSignatureReferenceResolver() {
		return getResolverChain(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationFeatureAttributeLink_Signature(), hyTimedImplementationFeatureAttributeLinkSignatureReferenceResolver);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.mspl.manifest.HyTimedImplementationEnumLink, eu.hyvar.dataValues.HyEnum> getHyTimedImplementationEnumLinkLocalReferenceResolver() {
		return getResolverChain(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationEnumLink_Local(), hyTimedImplementationEnumLinkLocalReferenceResolver);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.mspl.manifest.HyTimedImplementationEnumLink, eu.hyvar.dataValues.HyEnum> getHyTimedImplementationEnumLinkSignatureReferenceResolver() {
		return getResolverChain(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationEnumLink_Signature(), hyTimedImplementationEnumLinkSignatureReferenceResolver);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.mspl.manifest.HyTimedImplementationEnumLiteralLink, eu.hyvar.dataValues.HyEnumLiteral> getHyTimedImplementationEnumLiteralLinkLocalReferenceResolver() {
		return getResolverChain(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationEnumLiteralLink_Local(), hyTimedImplementationEnumLiteralLinkLocalReferenceResolver);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.mspl.manifest.HyTimedImplementationEnumLiteralLink, eu.hyvar.dataValues.HyEnumLiteral> getHyTimedImplementationEnumLiteralLinkSignatureReferenceResolver() {
		return getResolverChain(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationEnumLiteralLink_Signature(), hyTimedImplementationEnumLiteralLinkSignatureReferenceResolver);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum> getHyEnumValueEnumReferenceResolver() {
		return getResolverChain(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue_Enum(), hyEnumValueEnumReferenceResolver);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral> getHyEnumValueEnumLiteralReferenceResolver() {
		return getResolverChain(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue_EnumLiteral(), hyEnumValueEnumLiteralReferenceResolver);
	}
	
	public void setOptions(Map<?, ?> options) {
		if (options != null) {
			this.options = new LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		hyTimedDependenciesSignatureReferenceResolver.setOptions(options);
		hyTimedImplementationsSignatureReferenceResolver.setOptions(options);
		hyTimedImplementationFeatureLinkLocalReferenceResolver.setOptions(options);
		hyTimedImplementationFeatureLinkSignatureReferenceResolver.setOptions(options);
		hyTimedImplementationFeatureAttributeLinkLocalReferenceResolver.setOptions(options);
		hyTimedImplementationFeatureAttributeLinkSignatureReferenceResolver.setOptions(options);
		hyTimedImplementationEnumLinkLocalReferenceResolver.setOptions(options);
		hyTimedImplementationEnumLinkSignatureReferenceResolver.setOptions(options);
		hyTimedImplementationEnumLiteralLinkLocalReferenceResolver.setOptions(options);
		hyTimedImplementationEnumLiteralLinkSignatureReferenceResolver.setOptions(options);
		hyEnumValueEnumReferenceResolver.setOptions(options);
		hyEnumValueEnumLiteralReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, EObject container, EReference reference, int position, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolveResult<EObject> result) {
		if (container == null) {
			return;
		}
		if (eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedDependencies().isInstance(container)) {
			HymanifestFuzzyResolveResult<eu.hyvar.mspl.manifest.HySPLSignature> frr = new HymanifestFuzzyResolveResult<eu.hyvar.mspl.manifest.HySPLSignature>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("signature")) {
				hyTimedDependenciesSignatureReferenceResolver.resolve(identifier, (eu.hyvar.mspl.manifest.HyTimedDependencies) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations().isInstance(container)) {
			HymanifestFuzzyResolveResult<eu.hyvar.mspl.manifest.HySPLSignature> frr = new HymanifestFuzzyResolveResult<eu.hyvar.mspl.manifest.HySPLSignature>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("signature")) {
				hyTimedImplementationsSignatureReferenceResolver.resolve(identifier, (eu.hyvar.mspl.manifest.HyTimedImplementations) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationFeatureLink().isInstance(container)) {
			HymanifestFuzzyResolveResult<eu.hyvar.feature.HyFeature> frr = new HymanifestFuzzyResolveResult<eu.hyvar.feature.HyFeature>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("local")) {
				hyTimedImplementationFeatureLinkLocalReferenceResolver.resolve(identifier, (eu.hyvar.mspl.manifest.HyTimedImplementationFeatureLink) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationFeatureLink().isInstance(container)) {
			HymanifestFuzzyResolveResult<eu.hyvar.feature.HyFeature> frr = new HymanifestFuzzyResolveResult<eu.hyvar.feature.HyFeature>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("signature")) {
				hyTimedImplementationFeatureLinkSignatureReferenceResolver.resolve(identifier, (eu.hyvar.mspl.manifest.HyTimedImplementationFeatureLink) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationFeatureAttributeLink().isInstance(container)) {
			HymanifestFuzzyResolveResult<eu.hyvar.feature.HyFeatureAttribute> frr = new HymanifestFuzzyResolveResult<eu.hyvar.feature.HyFeatureAttribute>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("local")) {
				hyTimedImplementationFeatureAttributeLinkLocalReferenceResolver.resolve(identifier, (eu.hyvar.mspl.manifest.HyTimedImplementationFeatureAttributeLink) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationFeatureAttributeLink().isInstance(container)) {
			HymanifestFuzzyResolveResult<eu.hyvar.feature.HyFeatureAttribute> frr = new HymanifestFuzzyResolveResult<eu.hyvar.feature.HyFeatureAttribute>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("signature")) {
				hyTimedImplementationFeatureAttributeLinkSignatureReferenceResolver.resolve(identifier, (eu.hyvar.mspl.manifest.HyTimedImplementationFeatureAttributeLink) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationEnumLink().isInstance(container)) {
			HymanifestFuzzyResolveResult<eu.hyvar.dataValues.HyEnum> frr = new HymanifestFuzzyResolveResult<eu.hyvar.dataValues.HyEnum>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("local")) {
				hyTimedImplementationEnumLinkLocalReferenceResolver.resolve(identifier, (eu.hyvar.mspl.manifest.HyTimedImplementationEnumLink) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationEnumLink().isInstance(container)) {
			HymanifestFuzzyResolveResult<eu.hyvar.dataValues.HyEnum> frr = new HymanifestFuzzyResolveResult<eu.hyvar.dataValues.HyEnum>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("signature")) {
				hyTimedImplementationEnumLinkSignatureReferenceResolver.resolve(identifier, (eu.hyvar.mspl.manifest.HyTimedImplementationEnumLink) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationEnumLiteralLink().isInstance(container)) {
			HymanifestFuzzyResolveResult<eu.hyvar.dataValues.HyEnumLiteral> frr = new HymanifestFuzzyResolveResult<eu.hyvar.dataValues.HyEnumLiteral>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("local")) {
				hyTimedImplementationEnumLiteralLinkLocalReferenceResolver.resolve(identifier, (eu.hyvar.mspl.manifest.HyTimedImplementationEnumLiteralLink) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationEnumLiteralLink().isInstance(container)) {
			HymanifestFuzzyResolveResult<eu.hyvar.dataValues.HyEnumLiteral> frr = new HymanifestFuzzyResolveResult<eu.hyvar.dataValues.HyEnumLiteral>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("signature")) {
				hyTimedImplementationEnumLiteralLinkSignatureReferenceResolver.resolve(identifier, (eu.hyvar.mspl.manifest.HyTimedImplementationEnumLiteralLink) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().isInstance(container)) {
			HymanifestFuzzyResolveResult<eu.hyvar.dataValues.HyEnum> frr = new HymanifestFuzzyResolveResult<eu.hyvar.dataValues.HyEnum>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("enum")) {
				hyEnumValueEnumReferenceResolver.resolve(identifier, (eu.hyvar.dataValues.HyEnumValue) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().isInstance(container)) {
			HymanifestFuzzyResolveResult<eu.hyvar.dataValues.HyEnumLiteral> frr = new HymanifestFuzzyResolveResult<eu.hyvar.dataValues.HyEnumLiteral>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("enumLiteral")) {
				hyEnumValueEnumLiteralReferenceResolver.resolve(identifier, (eu.hyvar.dataValues.HyEnumValue) container, (EReference) feature, position, true, frr);
			}
		}
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<? extends EObject, ? extends EObject> getResolver(EStructuralFeature reference) {
		if (reference == eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedDependencies_Signature()) {
			return getResolverChain(reference, hyTimedDependenciesSignatureReferenceResolver);
		}
		if (reference == eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations_Signature()) {
			return getResolverChain(reference, hyTimedImplementationsSignatureReferenceResolver);
		}
		if (reference == eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationFeatureLink_Local()) {
			return getResolverChain(reference, hyTimedImplementationFeatureLinkLocalReferenceResolver);
		}
		if (reference == eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationFeatureLink_Signature()) {
			return getResolverChain(reference, hyTimedImplementationFeatureLinkSignatureReferenceResolver);
		}
		if (reference == eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationFeatureAttributeLink_Local()) {
			return getResolverChain(reference, hyTimedImplementationFeatureAttributeLinkLocalReferenceResolver);
		}
		if (reference == eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationFeatureAttributeLink_Signature()) {
			return getResolverChain(reference, hyTimedImplementationFeatureAttributeLinkSignatureReferenceResolver);
		}
		if (reference == eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationEnumLink_Local()) {
			return getResolverChain(reference, hyTimedImplementationEnumLinkLocalReferenceResolver);
		}
		if (reference == eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationEnumLink_Signature()) {
			return getResolverChain(reference, hyTimedImplementationEnumLinkSignatureReferenceResolver);
		}
		if (reference == eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationEnumLiteralLink_Local()) {
			return getResolverChain(reference, hyTimedImplementationEnumLiteralLinkLocalReferenceResolver);
		}
		if (reference == eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationEnumLiteralLink_Signature()) {
			return getResolverChain(reference, hyTimedImplementationEnumLiteralLinkSignatureReferenceResolver);
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
	public <ContainerType extends EObject, ReferenceType extends EObject> eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<ContainerType, ReferenceType> getResolverChain(EStructuralFeature reference, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof Map)) {
			// send this to the error log
			new eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestRuntimeUtil().logWarning("Found value with invalid type for option " + eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		Map<?,?> resolverMap = (Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver) {
			eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver replacingResolver = (eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver) resolverValue;
			if (replacingResolver instanceof eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof Collection) {
			Collection replacingResolvers = (Collection) resolverValue;
			eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceCache) {
					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver nextResolver = (eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver) next;
					if (nextResolver instanceof eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestRuntimeUtil().logWarning("Found value with invalid type in value map for option " + eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestRuntimeUtil().logWarning("Found value with invalid type in value map for option " + eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
