/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class HymappingProblem implements eu.hyvar.feature.mapping.resource.hymapping.IHymappingProblem {
	
	private String message;
	private eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemType type;
	private eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemSeverity severity;
	private Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix> quickFixes;
	
	public HymappingProblem(String message, eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemType type, eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemSeverity severity) {
		this(message, type, severity, Collections.<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix>emptySet());
	}
	
	public HymappingProblem(String message, eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemType type, eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemSeverity severity, eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix quickFix) {
		this(message, type, severity, Collections.singleton(quickFix));
	}
	
	public HymappingProblem(String message, eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemType type, eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemSeverity severity, Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new LinkedHashSet<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemType getType() {
		return type;
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
