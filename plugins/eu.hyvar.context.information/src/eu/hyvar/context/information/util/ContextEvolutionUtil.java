package eu.hyvar.context.information.util;

import java.util.Date;
import java.util.List;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.evolution.HyEvolutionUtil;

public class ContextEvolutionUtil {

	public static List<HyContextualInformation> getContextualInformation(HyContextModel contextModel, Date date) {
		return HyEvolutionUtil.getValidTemporalElements(contextModel.getContextualInformations(), date);
	}
	
	public static List<HyEnum> getEnums(HyContextModel contextModel, Date date) {
		return HyEvolutionUtil.getValidTemporalElements(contextModel.getEnums(), date);
	}
	
}
