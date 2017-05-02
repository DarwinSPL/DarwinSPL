package dw.darwinspl.feature.graphical.base.deltaecore.wrapper.layouter.feature;

import org.abego.treelayout.NodeExtentProvider;

import dw.darwinspl.feature.graphical.base.deltaecore.wrapper.DwGeometryUtil;
import dw.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import eu.hyvar.feature.HyFeature;

public class DwFeatureNodeExtentProvider implements NodeExtentProvider<HyFeature> {
	private DwFeatureModelWrapped featureModel;
	public DwFeatureNodeExtentProvider(DwFeatureModelWrapped featureModel){
		this.featureModel = featureModel;
	}
	@Override
	public double getWidth(HyFeature feature) {
		int width = DwGeometryUtil.calculateFeatureWidth(feature, featureModel.getSelectedDate());
		
		return width;
	}

	@Override
	public double getHeight(HyFeature feature) {
		return DwGeometryUtil.calculateFeatureHeight(feature, featureModel.getSelectedDate());
	}
}
