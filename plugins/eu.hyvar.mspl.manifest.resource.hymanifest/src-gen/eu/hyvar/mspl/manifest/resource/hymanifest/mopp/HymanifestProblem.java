/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class HymanifestProblem implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestProblem {
	
	private String message;
	private eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemType type;
	private eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemSeverity severity;
	private Collection<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestQuickFix> quickFixes;
	
	public HymanifestProblem(String message, eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemType type, eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemSeverity severity) {
		this(message, type, severity, Collections.<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestQuickFix>emptySet());
	}
	
	public HymanifestProblem(String message, eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemType type, eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemSeverity severity, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestQuickFix quickFix) {
		this(message, type, severity, Collections.singleton(quickFix));
	}
	
	public HymanifestProblem(String message, eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemType type, eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemSeverity severity, Collection<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new LinkedHashSet<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemType getType() {
		return type;
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Collection<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
