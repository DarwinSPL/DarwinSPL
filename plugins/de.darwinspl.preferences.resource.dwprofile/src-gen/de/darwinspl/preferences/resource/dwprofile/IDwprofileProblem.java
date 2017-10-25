/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile;

import java.util.Collection;

public interface IDwprofileProblem {
	public String getMessage();
	public de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemSeverity getSeverity();
	public de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemType getType();
	public Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix> getQuickFixes();
}
