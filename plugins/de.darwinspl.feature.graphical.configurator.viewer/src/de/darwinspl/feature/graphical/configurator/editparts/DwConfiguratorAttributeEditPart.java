package de.darwinspl.feature.graphical.configurator.editparts;


import org.eclipse.draw2d.IFigure;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwAttributeEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.configurator.figures.DwConfiguratorAttributeFigure;
import eu.hyvar.dataValues.HyValue;
import eu.hyvar.feature.HyFeatureAttribute;

public class DwConfiguratorAttributeEditPart extends DwAttributeEditPart {
	HyValue attributeValue = null;
	
	public DwConfiguratorAttributeEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}
	
	@Override
	protected IFigure createFigure() {
		return new DwConfiguratorAttributeFigure(editor, (HyFeatureAttribute) getModel());
	}
}
