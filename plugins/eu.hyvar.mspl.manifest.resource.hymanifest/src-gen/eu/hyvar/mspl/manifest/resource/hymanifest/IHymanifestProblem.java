/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest;

import java.util.Collection;

public interface IHymanifestProblem {
	public String getMessage();
	public eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemSeverity getSeverity();
	public eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemType getType();
	public Collection<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestQuickFix> getQuickFixes();
}
