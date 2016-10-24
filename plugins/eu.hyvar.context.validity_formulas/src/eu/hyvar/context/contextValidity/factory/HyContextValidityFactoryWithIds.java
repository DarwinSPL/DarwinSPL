package eu.hyvar.context.contextValidity.factory;

import eu.hyvar.context.contextValidity.HyAttributeValidityFormula;
import eu.hyvar.context.contextValidity.HyFeatureValidityFormula;
import eu.hyvar.context.contextValidity.impl.HyContextValidityFactoryImpl;

public class HyContextValidityFactoryWithIds extends HyContextValidityFactoryImpl {

	@Override
	public HyFeatureValidityFormula createHyFeatureValidityFormula() {
		HyFeatureValidityFormula hyFeatureValidityFormula = super.createHyFeatureValidityFormula();
		hyFeatureValidityFormula.createId();
		return hyFeatureValidityFormula;
	}

	@Override
	public HyAttributeValidityFormula createHyAttributeValidityFormula() {
		HyAttributeValidityFormula hyAttributeValidityFormula = super.createHyAttributeValidityFormula();
		hyAttributeValidityFormula.createId();
		return hyAttributeValidityFormula;
	}
}
