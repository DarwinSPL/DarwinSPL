package de.darwinspl.feature.graphical.configurator.editparts;


import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwAttributeEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import eu.hyvar.dataValues.HyValue;

public class DwConfiguratorAttributeEditPart extends DwAttributeEditPart {
	HyValue attributeValue = null;
	
	public DwConfiguratorAttributeEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}
}
