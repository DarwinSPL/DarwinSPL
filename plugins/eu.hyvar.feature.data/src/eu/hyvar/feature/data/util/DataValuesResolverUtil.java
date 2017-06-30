package eu.hyvar.feature.data.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.util.HyEvolutionUtil;

public class DataValuesResolverUtil {

	public static HyEnumLiteral resolveEnumLiteral(String identifier, HyEnum containingEnum) {
		if(identifier == null || containingEnum == null) {
			return null;
		}

		Tuple<String, Date> identifierAndDate = IdentifierWithDateUtil.getIdentifierAndDate(identifier);
		if (identifierAndDate.getSecondEntry() == null) {
			identifierAndDate.setSecondEntry(new Date());
		}		
						
		List<HyEnumLiteral> validLiterals = new ArrayList<HyEnumLiteral>(1);
		
		for(HyEnumLiteral literal : containingEnum.getLiterals()) {
			if(literal.getName().equals(identifierAndDate.getFirstEntry())) {
				validLiterals.add(literal);
			}
		}
		
		if(validLiterals.size() > 1) {
			if(!HyEvolutionUtil.isValid(containingEnum, identifierAndDate.getSecondEntry())) {
				return null;
			}
			
			
			List<HyEnumLiteral> validLiteralsWithEvolution = new ArrayList<HyEnumLiteral>(1);
			
			for(HyEnumLiteral literal: validLiterals) {
				if(HyEvolutionUtil.isValid(literal, identifierAndDate.getSecondEntry())) {
					validLiteralsWithEvolution.add(literal);
				}
			}
			
			validLiterals = validLiteralsWithEvolution;
		}
		
		if(validLiterals.size() != 1) {
			return null;
		}
		else {
			return validLiterals.get(0);
		}
	}
	
	public static String deresolveEnumLiteral(HyEnumLiteral literal) {
		return literal.getName();
	}
	
}
