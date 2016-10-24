/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HycontextinformationReferenceResolverSwitch implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private Map<Object, Object> options;
	
	protected eu.hyvar.context.resource.hycontextinformation.analysis.HyContextualInformationEnumEnumTypeReferenceResolver hyContextualInformationEnumEnumTypeReferenceResolver = new eu.hyvar.context.resource.hycontextinformation.analysis.HyContextualInformationEnumEnumTypeReferenceResolver();
	protected eu.hyvar.context.resource.hycontextinformation.analysis.HyEnumValueEnumReferenceResolver hyEnumValueEnumReferenceResolver = new eu.hyvar.context.resource.hycontextinformation.analysis.HyEnumValueEnumReferenceResolver();
	protected eu.hyvar.context.resource.hycontextinformation.analysis.HyEnumValueEnumLiteralReferenceResolver hyEnumValueEnumLiteralReferenceResolver = new eu.hyvar.context.resource.hycontextinformation.analysis.HyEnumValueEnumLiteralReferenceResolver();
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver<eu.hyvar.context.HyContextualInformationEnum, eu.hyvar.dataValues.HyEnum> getHyContextualInformationEnumEnumTypeReferenceResolver() {
		return getResolverChain(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationEnum_EnumType(), hyContextualInformationEnumEnumTypeReferenceResolver);
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum> getHyEnumValueEnumReferenceResolver() {
		return getResolverChain(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue_Enum(), hyEnumValueEnumReferenceResolver);
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral> getHyEnumValueEnumLiteralReferenceResolver() {
		return getResolverChain(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue_EnumLiteral(), hyEnumValueEnumLiteralReferenceResolver);
	}
	
	public void setOptions(Map<?, ?> options) {
		if (options != null) {
			this.options = new LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		hyContextualInformationEnumEnumTypeReferenceResolver.setOptions(options);
		hyEnumValueEnumReferenceResolver.setOptions(options);
		hyEnumValueEnumLiteralReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, EObject container, EReference reference, int position, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolveResult<EObject> result) {
		if (container == null) {
			return;
		}
		if (eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationEnum().isInstance(container)) {
			HycontextinformationFuzzyResolveResult<eu.hyvar.dataValues.HyEnum> frr = new HycontextinformationFuzzyResolveResult<eu.hyvar.dataValues.HyEnum>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("enumType")) {
				hyContextualInformationEnumEnumTypeReferenceResolver.resolve(identifier, (eu.hyvar.context.HyContextualInformationEnum) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().isInstance(container)) {
			HycontextinformationFuzzyResolveResult<eu.hyvar.dataValues.HyEnum> frr = new HycontextinformationFuzzyResolveResult<eu.hyvar.dataValues.HyEnum>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("enum")) {
				hyEnumValueEnumReferenceResolver.resolve(identifier, (eu.hyvar.dataValues.HyEnumValue) container, (EReference) feature, position, true, frr);
			}
		}
		if (eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().isInstance(container)) {
			HycontextinformationFuzzyResolveResult<eu.hyvar.dataValues.HyEnumLiteral> frr = new HycontextinformationFuzzyResolveResult<eu.hyvar.dataValues.HyEnumLiteral>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("enumLiteral")) {
				hyEnumValueEnumLiteralReferenceResolver.resolve(identifier, (eu.hyvar.dataValues.HyEnumValue) container, (EReference) feature, position, true, frr);
			}
		}
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver<? extends EObject, ? extends EObject> getResolver(EStructuralFeature reference) {
		if (reference == eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationEnum_EnumType()) {
			return getResolverChain(reference, hyContextualInformationEnumEnumTypeReferenceResolver);
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
	public <ContainerType extends EObject, ReferenceType extends EObject> eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver<ContainerType, ReferenceType> getResolverChain(EStructuralFeature reference, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof Map)) {
			// send this to the error log
			new eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationRuntimeUtil().logWarning("Found value with invalid type for option " + eu.hyvar.context.resource.hycontextinformation.IHycontextinformationOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		Map<?,?> resolverMap = (Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver) {
			eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver replacingResolver = (eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver) resolverValue;
			if (replacingResolver instanceof eu.hyvar.context.resource.hycontextinformation.IHycontextinformationDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((eu.hyvar.context.resource.hycontextinformation.IHycontextinformationDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof Collection) {
			Collection replacingResolvers = (Collection) resolverValue;
			eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceCache) {
					eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver nextResolver = (eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver) next;
					if (nextResolver instanceof eu.hyvar.context.resource.hycontextinformation.IHycontextinformationDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((eu.hyvar.context.resource.hycontextinformation.IHycontextinformationDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationRuntimeUtil().logWarning("Found value with invalid type in value map for option " + eu.hyvar.context.resource.hycontextinformation.IHycontextinformationOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + eu.hyvar.context.resource.hycontextinformation.IHycontextinformationDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationRuntimeUtil().logWarning("Found value with invalid type in value map for option " + eu.hyvar.context.resource.hycontextinformation.IHycontextinformationOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + eu.hyvar.context.resource.hycontextinformation.IHycontextinformationDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
