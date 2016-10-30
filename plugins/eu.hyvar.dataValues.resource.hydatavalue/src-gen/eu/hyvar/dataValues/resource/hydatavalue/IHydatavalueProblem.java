/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue;

import java.util.Collection;

public interface IHydatavalueProblem {
	public String getMessage();
	public eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemSeverity getSeverity();
	public eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemType getType();
	public Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix> getQuickFixes();
}
