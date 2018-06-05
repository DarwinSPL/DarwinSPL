package de.darwinspl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;

import eu.hyvar.feature.expression.HyExpressionPackage;

public class ExpressionDslScopeProvider extends AbstractExpressionDslScopeProvider {

	@Override
	public IScope getScope(EObject ctx, EReference ref) {
		if (ref == HyExpressionPackage.Literals.HY_ABSTRACT_FEATURE_REFERENCE_EXPRESSION__FEATURE) {
			return new DwFeatureScope(ctx);
		}
		
		return null;
	}

}
