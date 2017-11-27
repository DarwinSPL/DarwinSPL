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

public class HyEnumValueEnumLiteralReferenceResolver implements de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolver<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral> {
	
	private eu.hyvar.dataValues.resource.hydatavalue.analysis.HyEnumValueEnumLiteralReferenceResolver delegate = new eu.hyvar.dataValues.resource.hydatavalue.analysis.HyEnumValueEnumLiteralReferenceResolver();
	
	public void resolve(String identifier, eu.hyvar.dataValues.HyEnumValue container, EReference reference, int position, boolean resolveFuzzy, final de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolveResult<eu.hyvar.dataValues.HyEnumLiteral> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolveResult<eu.hyvar.dataValues.HyEnumLiteral>() {
			
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
			
			public Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceMapping<eu.hyvar.dataValues.HyEnumLiteral>> getMappings() {
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
			
			public void addMapping(String identifier, eu.hyvar.dataValues.HyEnumLiteral target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, eu.hyvar.dataValues.HyEnumLiteral target, String warning) {
				result.addMapping(identifier, target, warning);
			}
			
			public Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix> getQuickFixes() {
				return Collections.emptySet();
			}
			
			public void addQuickFix(final eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix quickFix) {
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
	
	public String deResolve(eu.hyvar.dataValues.HyEnumLiteral element, eu.hyvar.dataValues.HyEnumValue container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
