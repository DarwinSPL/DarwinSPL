package eu.hyvar.context.information.factory;

import eu.hyvar.context.HyContextualInformationBoolean;
import eu.hyvar.context.HyContextualInformationEnum;
import eu.hyvar.context.HyContextualInformationNumber;
import eu.hyvar.context.impl.HyContextInformationFactoryImpl;

public class HyContextInformationFactoryWithIds extends HyContextInformationFactoryImpl {

	@Override
	public HyContextualInformationBoolean createHyContextualInformationBoolean() {
		HyContextualInformationBoolean hyContextualInformationBoolean = super.createHyContextualInformationBoolean();
		hyContextualInformationBoolean.createId();
		return hyContextualInformationBoolean;
	}
	
	@Override
	public HyContextualInformationEnum createHyContextualInformationEnum() {
		HyContextualInformationEnum hyContextualInformationEnum = super.createHyContextualInformationEnum();
		hyContextualInformationEnum.createId();
		return hyContextualInformationEnum;
	}

	@Override
	public HyContextualInformationNumber createHyContextualInformationNumber() {
		HyContextualInformationNumber hyContextualInformationNumber = super.createHyContextualInformationNumber();
		hyContextualInformationNumber.createId();
		return hyContextualInformationNumber;
	}
}
