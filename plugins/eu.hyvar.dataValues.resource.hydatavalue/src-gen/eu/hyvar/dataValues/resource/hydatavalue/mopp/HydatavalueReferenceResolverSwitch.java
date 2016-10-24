/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HydatavalueReferenceResolverSwitch implements eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private Map<Object, Object> options;
	
	protected eu.hyvar.dataValues.resource.hydatavalue.analysis.HyEnumValueEnumReferenceResolver hyEnumValueEnumReferenceResolver = new eu.hyvar.dataValues.resource.hydatavalue.analysis.HyEnumValueEnumReferenceResolver();
	protected eu.hyvar.dataValues.resource.hydatavalue.analysis.HyEnumValueEnumLiteralReferenceResolver hyEnumValueEnumLiteralReferenceResolver = new eu.hyvar.dataValues.resource.hydatavalue.analysis.HyEnumValueEnumLiteralReferenceResolver();
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolver<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum> getHyEnumValueEnumReferenceResolver() {
		return getResolverChain(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue_Enum(), hyEnumValueEnumReferenceResolver);
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolver<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral> getHyEnumValueEnumLiteralReferenceResolver() {
		return getResolverChain(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue_EnumLiteral(), hyEnumValueEnumLiteralReferenceResolver);
	}
	
	public void setOptions(Map<?, ?> options) {
		if (options != null) {
			this.options = new LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		hyEnumValueEnumReferenceResolver.setOptions(options);
		hyEnumValueEnumLiteralReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, EObject container, EReference reference, int position, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolveResult<EObject> result) {
		if (container == null) {
			return;
		}
		if (eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().isInstance(container)) {
			HydatavalueFuzzyResolveResult<eu.hyvar.dataValues.HyEnum> frr = new HydatavalueFuzzyResolveResult<eu.hyvar.dataValues.HyEnum>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("enum")) {
				hyEnumValueEnumReferenceResolver.resolve(identifier, (eu.hyvar.dataValues.HyEnumValue) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().isInstance(container)) {
			HydatavalueFuzzyResolveResult<eu.hyvar.dataValues.HyEnumLiteral> frr = new HydatavalueFuzzyResolveResult<eu.hyvar.dataValues.HyEnumLiteral>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("enumLiteral")) {
				hyEnumValueEnumLiteralReferenceResolver.resolve(identifier, (eu.hyvar.dataValues.HyEnumValue) container, (EReference) feature, position, true, frr);
			}
		}
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolver<? extends EObject, ? extends EObject> getResolver(EStructuralFeature reference) {
		if (reference == eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue_Enum()) {
			return getResolverChain(reference, hyEnumValueEnumReferenceResolver);
		}
		if (reference == eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue_EnumLiteral()) {
			return getResolverChain(reference, hyEnumValueEnumLiteralReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public <ContainerType extends EObject, ReferenceType extends EObject> eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolver<ContainerType, ReferenceType> getResolverChain(EStructuralFeature reference, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof Map)) {
			// send this to the error log
			new eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueRuntimeUtil().logWarning("Found value with invalid type for option " + eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		Map<?,?> resolverMap = (Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolver) {
			eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolver replacingResolver = (eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolver) resolverValue;
			if (replacingResolver instanceof eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof Collection) {
			Collection replacingResolvers = (Collection) resolverValue;
			eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceCache) {
					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolver nextResolver = (eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolver) next;
					if (nextResolver instanceof eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueRuntimeUtil().logWarning("Found value with invalid type in value map for option " + eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueRuntimeUtil().logWarning("Found value with invalid type in value map for option " + eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
