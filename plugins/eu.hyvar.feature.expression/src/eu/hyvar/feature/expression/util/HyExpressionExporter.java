package eu.hyvar.feature.expression.util;

import eu.hyvar.feature.expression.HyExpression;

public interface HyExpressionExporter<T> {
	
	public T exportExpression(HyExpression expression) throws UnsupportedOperationException;
}
