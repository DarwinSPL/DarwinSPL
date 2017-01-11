/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation;

import java.util.Collection;

public interface IHycontextinformationProblem {
	public String getMessage();
	public eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemSeverity getSeverity();
	public eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemType getType();
	public Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationQuickFix> getQuickFixes();
}
