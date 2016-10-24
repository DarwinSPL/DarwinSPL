package eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.feature;

import org.abego.treelayout.NodeExtentProvider;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.HyGeometryUtil;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelEvolutionWrapped;

public class HyFeatureNodeExtentProvider implements NodeExtentProvider<HyFeature> {
	private HyFeatureModelEvolutionWrapped featureModel;
	public HyFeatureNodeExtentProvider(HyFeatureModelEvolutionWrapped featureModel){
		this.featureModel = featureModel;
	}
	@Override
	public double getWidth(HyFeature feature) {
		return HyGeometryUtil.calculateFeatureWidth(feature, featureModel.getSelectedDate());
	}

	@Override
	public double getHeight(HyFeature feature) {
		return HyGeometryUtil.calculateFeatureHeight(feature, featureModel.getSelectedDate());
	}
}
