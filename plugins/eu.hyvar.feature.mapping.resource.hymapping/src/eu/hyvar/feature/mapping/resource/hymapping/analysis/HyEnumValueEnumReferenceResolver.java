/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.analysis;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix;
import eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceMapping;
import eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolveResult;
import eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix;

public class HyEnumValueEnumReferenceResolver implements eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceResolver<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum> {
	
	private eu.hyvar.feature.expression.resource.hyexpression.analysis.HyEnumValueEnumReferenceResolver delegate = new eu.hyvar.feature.expression.resource.hyexpression.analysis.HyEnumValueEnumReferenceResolver();
	
//	private eu.hyvar.dataValues.resource.hydatavalue.analysis.HyEnumValueEnumReferenceResolver delegate = new eu.hyvar.dataValues.resource.hydatavalue.analysis.HyEnumValueEnumReferenceResolver();
	
	public void resolve(String identifier, eu.hyvar.dataValues.HyEnumValue container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceResolveResult<eu.hyvar.dataValues.HyEnum> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new IHyexpressionReferenceResolveResult<HyEnum>() {
			
			@Override
			public boolean wasResolvedUniquely() {
				return result.wasResolvedUniquely();
			}

			@Override
			public boolean wasResolvedMultiple() {
				return result.wasResolvedMultiple();
			}

			@Override
			public boolean wasResolved() {
				return result.wasResolved();
			}

			@Override
			public void setErrorMessage(String message) {
				result.setErrorMessage(message);
			}
			
			@Override
			public Collection<IHyexpressionQuickFix> getQuickFixes() {
				// TODO Auto-generated method stub
				return Collections.emptySet();
			}
			
			@Override
			public Collection<IHyexpressionReferenceMapping<HyEnum>> getMappings() {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}
			
			@Override
			public String getErrorMessage() {
				return result.getErrorMessage();
			}
			
			@Override
			public void addQuickFix(IHyexpressionQuickFix quickFix) {
				result.addQuickFix(new IHymappingQuickFix() {

					public String getImageKey() {
						return quickFix.getImageKey();
					}

					public String getDisplayString() {
						return quickFix.getDisplayString();
					}

					public Collection<EObject> getContextObjects() {
						return quickFix.getContextObjects();
					}

					public String getContextAsString() {
						return quickFix.getContextAsString();
					}

					public String apply(String currentText) {
						return quickFix.apply(currentText);
					}

				});
			}
			
			@Override
			public void addMapping(String identifier, URI newIdentifier) {
				result.addMapping(identifier, newIdentifier);
			}
			
			@Override
			public void addMapping(String identifier, URI newIdentifier, String warning) {
				result.addMapping(identifier, newIdentifier, warning);
			}
			
			@Override
			public void addMapping(String identifier, HyEnum target) {
				result.addMapping(identifier, target);
			}
			
			@Override
			public void addMapping(String identifier, HyEnum target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public String deResolve(eu.hyvar.dataValues.HyEnum element, eu.hyvar.dataValues.HyEnumValue container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
