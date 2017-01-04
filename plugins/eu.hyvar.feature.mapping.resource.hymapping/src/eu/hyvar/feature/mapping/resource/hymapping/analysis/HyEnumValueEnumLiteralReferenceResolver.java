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

import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix;
import eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceMapping;
import eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolveResult;
import eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix;

public class HyEnumValueEnumLiteralReferenceResolver implements
		eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceResolver<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral> {

	private eu.hyvar.feature.expression.resource.hyexpression.analysis.HyEnumValueEnumLiteralReferenceResolver delegate = new eu.hyvar.feature.expression.resource.hyexpression.analysis.HyEnumValueEnumLiteralReferenceResolver();

	// private
	// eu.hyvar.dataValues.resource.hydatavalue.analysis.HyEnumValueEnumLiteralReferenceResolver
	// delegate = new
	// eu.hyvar.dataValues.resource.hydatavalue.analysis.HyEnumValueEnumLiteralReferenceResolver();

	public void resolve(String identifier, eu.hyvar.dataValues.HyEnumValue container, EReference reference,
			int position, boolean resolveFuzzy,
			final eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceResolveResult<eu.hyvar.dataValues.HyEnumLiteral> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy,
				new IHyexpressionReferenceResolveResult<HyEnumLiteral>() {

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
						// TODO add QuickFixes
						return Collections.emptySet();
					}

					@Override
					public Collection<IHyexpressionReferenceMapping<HyEnumLiteral>> getMappings() {
						// TODO Auto-generated method stub
						throw new UnsupportedOperationException();
					}

					@Override
					public String getErrorMessage() {
						return result.getErrorMessage();
					}

					@Override
					public void addQuickFix(final IHyexpressionQuickFix quickFix) {
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
					public void addMapping(String identifier, HyEnumLiteral target) {
						result.addMapping(identifier, target);

					}

					@Override
					public void addMapping(String identifier, HyEnumLiteral target, String warning) {
						result.addMapping(identifier, target, warning);
					}
				});

	}

	public String deResolve(eu.hyvar.dataValues.HyEnumLiteral element, eu.hyvar.dataValues.HyEnumValue container,
			EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(Map<?, ?> options) {
		// save options in a field or leave method empty if this resolver does
		// not depend
		// on any option
	}

}
