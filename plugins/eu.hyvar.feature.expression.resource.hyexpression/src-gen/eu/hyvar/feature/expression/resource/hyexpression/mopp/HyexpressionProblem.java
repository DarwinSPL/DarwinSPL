/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class HyexpressionProblem implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionProblem {
	
	private String message;
	private eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemType type;
	private eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemSeverity severity;
	private Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix> quickFixes;
	
	public HyexpressionProblem(String message, eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemType type, eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemSeverity severity) {
		this(message, type, severity, Collections.<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix>emptySet());
	}
	
	public HyexpressionProblem(String message, eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemType type, eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemSeverity severity, eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix quickFix) {
		this(message, type, severity, Collections.singleton(quickFix));
	}
	
	public HyexpressionProblem(String message, eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemType type, eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemSeverity severity, Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new LinkedHashSet<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemType getType() {
		return type;
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
