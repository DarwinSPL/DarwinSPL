/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.analysis;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix;
import eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceMapping;

public class HyEnumValueEnumReferenceResolver implements eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsReferenceResolver<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum> {
	
	private eu.hyvar.feature.expression.resource.hyexpression.analysis.HyEnumValueEnumReferenceResolver delegate = new eu.hyvar.feature.expression.resource.hyexpression.analysis.HyEnumValueEnumReferenceResolver();
	
	public void resolve(String identifier, eu.hyvar.dataValues.HyEnumValue container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsReferenceResolveResult<eu.hyvar.dataValues.HyEnum> result) {
		
		
		if((identifier!=null)&&(identifier.contains(eu.hyvar.mspl.manifest.util.custom.HyManifestResolverUtil.MANIFEST_SEPARATOR))) {
			HyEnum found = eu.hyvar.mspl.manifest.util.custom.HyManifestResolverUtil.resolveMsplEnum(identifier, container);
			if (found!=null) {
				result.addMapping(identifier, found);
			}
		}
		else {
			delegate.resolve(identifier, container, reference, position, resolveFuzzy, new eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolveResult<eu.hyvar.dataValues.HyEnum>() {
				
				public boolean wasResolvedUniquely() {
					return result.wasResolvedUniquely();
				}
				
				public boolean wasResolvedMultiple() {
					return result.wasResolvedMultiple();
				}
				
				public boolean wasResolved() {
					return result.wasResolved();
				}
				
				public void setErrorMessage(String message) {
					result.setErrorMessage(message);
				}
				
				public String getErrorMessage() {
					return result.getErrorMessage();
				}
				
				public void addMapping(String identifier, URI newIdentifier) {
					result.addMapping(identifier, newIdentifier);
				}
				
				public void addMapping(String identifier, URI newIdentifier, String warning) {
					result.addMapping(identifier, newIdentifier, warning);
				}
				
				public void addMapping(String identifier, eu.hyvar.dataValues.HyEnum target) {
					result.addMapping(identifier, target);
				}
				
				public void addMapping(String identifier, eu.hyvar.dataValues.HyEnum target, String warning) {
					result.addMapping(identifier, target, warning);
				}
				
				@Override
				public Collection<IHyexpressionQuickFix> getQuickFixes() {
					return Collections.emptySet();
				}
				
				@Override
				public void addQuickFix(final IHyexpressionQuickFix quickFix) {
					result.addQuickFix(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsQuickFix() {
						
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
				public Collection<IHyexpressionReferenceMapping<HyEnum>> getMappings() {
					throw new UnsupportedOperationException();
				}
				
			});
			
		}
		
	}
	
	public String deResolve(eu.hyvar.dataValues.HyEnum element, eu.hyvar.dataValues.HyEnumValue container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
