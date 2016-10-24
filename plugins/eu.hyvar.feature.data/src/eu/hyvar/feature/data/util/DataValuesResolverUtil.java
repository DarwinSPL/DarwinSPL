package eu.hyvar.feature.data.util;

import java.util.Date;
import java.util.List;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.HyEvolutionUtil;

public class DataValuesResolverUtil {

	public static HyEnumLiteral resolveEnumLiteral(String identifier, HyEnum containingEnum, Date date) {
		if(identifier == null || containingEnum == null) {
			return null;
		}
		
		if (identifier.startsWith("\"") && identifier.endsWith("\"")) {
			identifier = identifier.substring(1, identifier.length() - 1);
		}
		
		List<HyEnumLiteral> validLiterals = HyEvolutionUtil.getValidTemporalElements(containingEnum.getLiterals(), date);
		
		// TODO check well formedness -> only one valid enumLiteral
		for(HyEnumLiteral literal : validLiterals) {
			if(literal.getName().equals(identifier)) {
				return literal;
			}
		}
		
		return null;
	}
	
	public static String deresolveEnumLiteral(HyEnumLiteral literal) {
		return literal.getName();
	}
	
}
