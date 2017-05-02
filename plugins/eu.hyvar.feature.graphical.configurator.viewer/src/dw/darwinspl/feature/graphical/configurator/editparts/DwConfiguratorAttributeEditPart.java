package dw.darwinspl.feature.graphical.configurator.editparts;


import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.editparts.DwAttributeEditPart;
import dw.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import eu.hyvar.dataValues.HyValue;

public class DwConfiguratorAttributeEditPart extends DwAttributeEditPart {
	HyValue attributeValue = null;
	
	public DwConfiguratorAttributeEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}
}
