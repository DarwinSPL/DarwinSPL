/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula;

import java.util.Collection;

public interface IHyvalidityformulaProblem {
	public String getMessage();
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemSeverity getSeverity();
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemType getType();
	public Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaQuickFix> getQuickFixes();
}
