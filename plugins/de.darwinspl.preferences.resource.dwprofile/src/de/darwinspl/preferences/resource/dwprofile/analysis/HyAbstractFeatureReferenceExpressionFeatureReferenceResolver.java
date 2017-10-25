/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.analysis;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class HyAbstractFeatureReferenceExpressionFeatureReferenceResolver implements de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature> {
	
	private eu.hyvar.feature.expression.resource.hyexpression.analysis.HyAbstractFeatureReferenceExpressionFeatureReferenceResolver delegate = new eu.hyvar.feature.expression.resource.hyexpression.analysis.HyAbstractFeatureReferenceExpressionFeatureReferenceResolver();
	
	public void resolve(String identifier, eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression container, EReference reference, int position, boolean resolveFuzzy, final de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolveResult<eu.hyvar.feature.HyFeature> result) {
		
		if((identifier!=null)&&(identifier.contains(eu.hyvar.mspl.util.HyManifestResolverUtil.MANIFEST_SEPARATOR))) {
			eu.hyvar.feature.HyFeature found = eu.hyvar.mspl.util.HyManifestResolverUtil.resolveMsplFeature(identifier, container);
			if (found!=null) {
				result.addMapping(identifier, found);
			}
		}
		else {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolveResult<eu.hyvar.feature.HyFeature>() {
			
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
			
			public Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceMapping<eu.hyvar.feature.HyFeature>> getMappings() {
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
			
			public void addMapping(String identifier, eu.hyvar.feature.HyFeature target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, eu.hyvar.feature.HyFeature target, String warning) {
				result.addMapping(identifier, target, warning);
			}
			
			public Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix> getQuickFixes() {
				return Collections.emptySet();
			}
			
			public void addQuickFix(final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix quickFix) {
				result.addQuickFix(new de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix() {
					
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
	}
	
	public String deResolve(eu.hyvar.feature.HyFeature element, eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
