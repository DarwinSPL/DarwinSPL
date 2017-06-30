package de.darwinspl.feature.graphical.base.deltaecore.wrapper.layouter.feature;

import org.abego.treelayout.NodeExtentProvider;

import de.darwinspl.feature.graphical.base.deltaecore.wrapper.DwGeometryUtil;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;

public class DwFeatureNodeExtentProvider implements NodeExtentProvider<DwFeatureWrapped> {
	private DwFeatureModelWrapped featureModel;
	public DwFeatureNodeExtentProvider(DwFeatureModelWrapped featureModel){
		this.featureModel = featureModel;
	}
	@Override
	public double getWidth(DwFeatureWrapped feature) {
		int width = DwGeometryUtil.calculateFeatureWidth(feature.getWrappedModelElement(), featureModel.getSelectedDate());
		
		return width;
	}

	@Override
	public double getHeight(DwFeatureWrapped feature) {
		return DwGeometryUtil.calculateFeatureHeight(feature.getWrappedModelElement(), featureModel.getSelectedDate());
	}
}
