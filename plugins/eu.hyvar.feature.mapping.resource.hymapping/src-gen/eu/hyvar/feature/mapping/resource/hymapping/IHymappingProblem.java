/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping;

import java.util.Collection;

public interface IHymappingProblem {
	public String getMessage();
	public eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemSeverity getSeverity();
	public eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemType getType();
	public Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix> getQuickFixes();
}
