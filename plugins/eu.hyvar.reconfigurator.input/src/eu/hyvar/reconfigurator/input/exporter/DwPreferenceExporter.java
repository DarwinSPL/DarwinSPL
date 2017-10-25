package eu.hyvar.reconfigurator.input.exporter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eu.hyvar.feature.expression.util.HyExpressionStringExporter;
import de.darwinspl.preferences.DwPreference;
import de.darwinspl.preferences.DwProfile;
import eu.hyvar.reconfigurator.input.format.Context;

public class DwPreferenceExporter {

	private HyExpressionStringExporter expressionExporter;

	public DwPreferenceExporter(HyExpressionStringExporter expressionExporter) {
		this.expressionExporter = expressionExporter;
	}
	

	public List<String> getPreferences(DwProfile preferenceModel, Date date, Context dateContext, List<Date> sortedDateList) {
		List<String> preferences = new ArrayList<String>();

		if(preferenceModel == null) {
			return preferences;
		}
		for (DwPreference preference : preferenceModel.getPreferences()) {
			String preferenceString = getPreference(preference, date, dateContext, sortedDateList);
			
			if(preferenceString != null) {
				preferences.add(preferenceString);
			}
		}

		return preferences;
	}

	private String getPreference(DwPreference preference, Date date, Context dateContext, List<Date> sortedDateList) {
		return HyVarRecExporter.createTimedExpression(preference, preference.getRootExpression(), date, dateContext, sortedDateList, expressionExporter);
	}
	
}
