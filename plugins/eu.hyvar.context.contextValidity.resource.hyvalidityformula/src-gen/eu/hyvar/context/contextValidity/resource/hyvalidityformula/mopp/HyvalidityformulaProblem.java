/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class HyvalidityformulaProblem implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaProblem {
	
	private String message;
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemType type;
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemSeverity severity;
	private Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaQuickFix> quickFixes;
	
	public HyvalidityformulaProblem(String message, eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemType type, eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemSeverity severity) {
		this(message, type, severity, Collections.<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaQuickFix>emptySet());
	}
	
	public HyvalidityformulaProblem(String message, eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemType type, eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemSeverity severity, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaQuickFix quickFix) {
		this(message, type, severity, Collections.singleton(quickFix));
	}
	
	public HyvalidityformulaProblem(String message, eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemType type, eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemSeverity severity, Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new LinkedHashSet<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemType getType() {
		return type;
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
