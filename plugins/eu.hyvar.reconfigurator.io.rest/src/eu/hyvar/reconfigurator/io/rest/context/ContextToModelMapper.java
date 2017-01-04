package eu.hyvar.reconfigurator.io.rest.context;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.information.contextValue.ContextValueFactory;
import eu.hyvar.context.information.contextValue.HyContextValue;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyEnumValue;

public class ContextToModelMapper {

	// TODO Horrible component! Hard mapping of arbitrary GPS coordinates to europe / russia
	
	private static final String POSITION_CONTEXT_NAME = "GPS_Positions";
	private static final String POSITION_ENUM_NAME = "GPS_Position_enum";
	private static final String POSITION_ENUM_EUROPE_NAME = "GPS_Position_Europe"; 
	private static final String POSITION_ENUM_RUSSIA_NAME = "GPS_Position_Russia";
	
	private static final double LATITUDE_EUROPE_RANGE_START = -90.0;
	private static final double LATITUDE_EUROPE_RANGE_END = 90.0;
	private static final double LONGITUDE_EUROPE_RANGE_START = -180.0;
	private static final double LONGITUDE_EUROPE_RANGE_END = 30.985047;
	
	private static final double LATITUDE_RUSSIA_RANGE_START = -90.0;
	private static final double LATITUDE_RUSSIA_RANGE_END = 90.0;
	private static final double LONGITUDE_RUSSIA_RANGE_START = 30.985048;
	private static final double LONGITUDE_RUSSIA_RANGE_END = 180.0;
	
	public static HyContextValue mapGPSToContextValue(double latitude, double longitude, HyContextModel contextModel) {
		
		for(HyContextualInformation contextInfo: contextModel.getContextualInformations()) {
			if(contextInfo.getName().equals(POSITION_CONTEXT_NAME)) {
				for(HyEnum hyEnum: contextModel.getEnums()) {
					if(hyEnum.getId().equals(POSITION_ENUM_NAME)) {
						String positionId = "";
						if(latitude >= LATITUDE_EUROPE_RANGE_START && latitude <= LATITUDE_EUROPE_RANGE_END && longitude >= LONGITUDE_EUROPE_RANGE_START && longitude <= LONGITUDE_EUROPE_RANGE_END) {
							positionId = POSITION_ENUM_EUROPE_NAME;
						} else if(latitude >= LATITUDE_RUSSIA_RANGE_START && latitude <= LATITUDE_RUSSIA_RANGE_END && longitude >= LONGITUDE_RUSSIA_RANGE_START && longitude <= LONGITUDE_RUSSIA_RANGE_END) {
							positionId = POSITION_ENUM_RUSSIA_NAME;
						}
						
						for(HyEnumLiteral literal: hyEnum.getLiterals()) {
							if(literal.getName().equals(positionId)) {
								HyContextValue contextValue = ContextValueFactory.eINSTANCE.createHyContextValue();
								contextValue.setContext(contextInfo);
								HyEnumValue enumValue = HyDataValuesFactory.eINSTANCE.createHyEnumValue();
								enumValue.setEnum(hyEnum);
								enumValue.setEnumLiteral(literal);
								contextValue.setValue(enumValue);
								return contextValue;
							}
						}
					}
				}
			}
		}
		
		
		
		return null;
	}
	
}
