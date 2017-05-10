package eu.hyvar.feature.graphical.configurator.editparts;


import eu.hyvar.dataValues.HyValue;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyAttributeEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;

public class HyConfiguratorAttributeEditPart extends HyAttributeEditPart {
	HyValue attributeValue = null;
	
	public HyConfiguratorAttributeEditPart(DwGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}
}
