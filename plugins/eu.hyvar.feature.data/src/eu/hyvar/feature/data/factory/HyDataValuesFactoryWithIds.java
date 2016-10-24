package eu.hyvar.feature.data.factory;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.impl.HyDataValuesFactoryImpl;

public class HyDataValuesFactoryWithIds extends HyDataValuesFactoryImpl {

	@Override
	public HyEnum createHyEnum() {
		HyEnum hyEnum = super.createHyEnum();
		hyEnum.createId();
		return hyEnum;
	}

	@Override
	public HyEnumLiteral createHyEnumLiteral() {
		HyEnumLiteral hyEnumLiteral = super.createHyEnumLiteral();
		hyEnumLiteral.createId();
		return hyEnumLiteral;
	}
	
}
