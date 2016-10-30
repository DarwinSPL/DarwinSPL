/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class HydatavalueProblem implements eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueProblem {
	
	private String message;
	private eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemType type;
	private eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemSeverity severity;
	private Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix> quickFixes;
	
	public HydatavalueProblem(String message, eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemType type, eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemSeverity severity) {
		this(message, type, severity, Collections.<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix>emptySet());
	}
	
	public HydatavalueProblem(String message, eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemType type, eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemSeverity severity, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix quickFix) {
		this(message, type, severity, Collections.singleton(quickFix));
	}
	
	public HydatavalueProblem(String message, eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemType type, eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemSeverity severity, Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new LinkedHashSet<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemType getType() {
		return type;
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
