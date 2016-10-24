/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class HyconstraintsProblem implements eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsProblem {
	
	private String message;
	private eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType type;
	private eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemSeverity severity;
	private Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsQuickFix> quickFixes;
	
	public HyconstraintsProblem(String message, eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType type, eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemSeverity severity) {
		this(message, type, severity, Collections.<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsQuickFix>emptySet());
	}
	
	public HyconstraintsProblem(String message, eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType type, eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemSeverity severity, eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsQuickFix quickFix) {
		this(message, type, severity, Collections.singleton(quickFix));
	}
	
	public HyconstraintsProblem(String message, eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType type, eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemSeverity severity, Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new LinkedHashSet<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType getType() {
		return type;
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
