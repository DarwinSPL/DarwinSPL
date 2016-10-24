package eu.hyvar.feature.factory;

import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyStringAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.impl.HyFeatureFactoryImpl;

public class HyFeatureFactoryWithIds extends HyFeatureFactoryImpl {

	@Override
	public HyBooleanAttribute createHyBooleanAttribute() {
		HyBooleanAttribute hyBooleanAttribute = super.createHyBooleanAttribute();
		hyBooleanAttribute.createId();
		return hyBooleanAttribute;
	}
	
	@Override
	public HyFeatureType createHyFeatureType() {
		HyFeatureType hyFeatureType = super.createHyFeatureType();
		hyFeatureType.createId();
		return hyFeatureType;
	}
	

	@Override
	public HyGroupType createHyGroupType() {
		HyGroupType hyGroupType = super.createHyGroupType();
		hyGroupType.createId();
		return hyGroupType;
	}
	
	@Override
	public HyEnumAttribute createHyEnumAttribute() {
		HyEnumAttribute hyEnumAttribute = super.createHyEnumAttribute();
		hyEnumAttribute.createId();
		return hyEnumAttribute;
	}
	
	@Override
	public HyFeature createHyFeature() {
		HyFeature hyFeature = super.createHyFeature();
		hyFeature.createId();
		return hyFeature;
	}
	
	@Override
	public HyFeatureChild createHyFeatureChild() {
		HyFeatureChild hyFeatureChild = super.createHyFeatureChild();
		hyFeatureChild.createId();
		return hyFeatureChild;
	}
	
	@Override
	public HyGroup createHyGroup() {
		HyGroup hyGroup = super.createHyGroup();
		hyGroup.createId();
		return hyGroup;
	}
	
	@Override
	public HyGroupComposition createHyGroupComposition() {
		HyGroupComposition hyGroupComposition = super.createHyGroupComposition();
		hyGroupComposition.createId();
		return hyGroupComposition;
	}
	
	@Override
	public HyNumberAttribute createHyNumberAttribute() {
		HyNumberAttribute hyNumberAttribute = super.createHyNumberAttribute();
		hyNumberAttribute.createId();
		return hyNumberAttribute;
	}
	
	@Override
	public HyRootFeature createHyRootFeature() {
		HyRootFeature hyRootFeature = super.createHyRootFeature();
		hyRootFeature.createId();
		return hyRootFeature;
	}
	
	@Override
	public HyStringAttribute createHyStringAttribute() {
		HyStringAttribute hyStringAttribute = super.createHyStringAttribute();
		hyStringAttribute.createId();
		return hyStringAttribute;
	}
	
	@Override
	public HyVersion createHyVersion() {
		HyVersion hyVersion = super.createHyVersion();
		hyVersion.createId();
		return hyVersion;
	}
}
