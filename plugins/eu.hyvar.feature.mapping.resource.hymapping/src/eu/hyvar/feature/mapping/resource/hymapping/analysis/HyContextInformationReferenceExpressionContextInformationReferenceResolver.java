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

public class HyContextInformationReferenceExpressionContextInformationReferenceResolver implements eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceResolver<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation> {
	
	private eu.hyvar.feature.expression.resource.hyexpression.analysis.HyContextInformationReferenceExpressionContextInformationReferenceResolver delegate = new eu.hyvar.feature.expression.resource.hyexpression.analysis.HyContextInformationReferenceExpressionContextInformationReferenceResolver();
	
	public void resolve(String identifier, eu.hyvar.feature.expression.HyContextInformationReferenceExpression container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceResolveResult<eu.hyvar.context.HyContextualInformation> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolveResult<eu.hyvar.context.HyContextualInformation>() {
			
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
			
			public Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceMapping<eu.hyvar.context.HyContextualInformation>> getMappings() {
				throw new UnsupportedOperationException();
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
			
			public void addMapping(String identifier, eu.hyvar.context.HyContextualInformation target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, eu.hyvar.context.HyContextualInformation target, String warning) {
				result.addMapping(identifier, target, warning);
			}
			
			public Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix> getQuickFixes() {
				return Collections.emptySet();
			}
			
			public void addQuickFix(final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix quickFix) {
				result.addQuickFix(new eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix() {
					
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
		});
		
	}
	
	public String deResolve(eu.hyvar.context.HyContextualInformation element, eu.hyvar.feature.expression.HyContextInformationReferenceExpression container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
