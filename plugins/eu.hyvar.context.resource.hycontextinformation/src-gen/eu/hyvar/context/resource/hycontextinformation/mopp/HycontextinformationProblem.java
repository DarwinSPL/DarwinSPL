/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class HycontextinformationProblem implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationProblem {
	
	private String message;
	private eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemType type;
	private eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemSeverity severity;
	private Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationQuickFix> quickFixes;
	
	public HycontextinformationProblem(String message, eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemType type, eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemSeverity severity) {
		this(message, type, severity, Collections.<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationQuickFix>emptySet());
	}
	
	public HycontextinformationProblem(String message, eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemType type, eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemSeverity severity, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationQuickFix quickFix) {
		this(message, type, severity, Collections.singleton(quickFix));
	}
	
	public HycontextinformationProblem(String message, eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemType type, eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemSeverity severity, Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new LinkedHashSet<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemType getType() {
		return type;
	}
	
	public eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
