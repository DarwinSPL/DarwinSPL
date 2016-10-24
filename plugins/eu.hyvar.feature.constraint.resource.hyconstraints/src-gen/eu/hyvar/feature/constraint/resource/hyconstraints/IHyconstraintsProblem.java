/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints;

import java.util.Collection;

public interface IHyconstraintsProblem {
	public String getMessage();
	public eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemSeverity getSeverity();
	public eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType getType();
	public Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsQuickFix> getQuickFixes();
}
