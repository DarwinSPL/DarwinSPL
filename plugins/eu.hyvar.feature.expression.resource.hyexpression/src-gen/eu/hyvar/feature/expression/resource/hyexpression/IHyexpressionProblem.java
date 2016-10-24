/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression;

import java.util.Collection;

public interface IHyexpressionProblem {
	public String getMessage();
	public eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemSeverity getSeverity();
	public eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemType getType();
	public Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix> getQuickFixes();
}
