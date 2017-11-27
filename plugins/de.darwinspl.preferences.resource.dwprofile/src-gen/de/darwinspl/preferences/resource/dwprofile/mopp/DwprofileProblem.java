/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class DwprofileProblem implements de.darwinspl.preferences.resource.dwprofile.IDwprofileProblem {
	
	private String message;
	private de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemType type;
	private de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemSeverity severity;
	private Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix> quickFixes;
	
	public DwprofileProblem(String message, de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemType type, de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemSeverity severity) {
		this(message, type, severity, Collections.<de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix>emptySet());
	}
	
	public DwprofileProblem(String message, de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemType type, de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemSeverity severity, de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix quickFix) {
		this(message, type, severity, Collections.singleton(quickFix));
	}
	
	public DwprofileProblem(String message, de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemType type, de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemSeverity severity, Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new LinkedHashSet<de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemType getType() {
		return type;
	}
	
	public de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
