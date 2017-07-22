package de.darwinspl.feature.stage.configurator.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwEnumContainerEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwEnumEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwEnumLiteralEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwGroupEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwParentChildConnectionEditPart;
import de.darwinspl.feature.graphical.base.model.DwEnumContainerWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import de.darwinspl.feature.graphical.base.model.DwRootFeatureWrapped;
import de.darwinspl.feature.graphical.configurator.editparts.DwConfiguratorEditorAttributeEditPart;
import de.darwinspl.feature.graphical.configurator.editparts.DwConfiguratorEditorFeatureEditPart;
import de.darwinspl.feature.graphical.configurator.editparts.DwConfiguratorEditorFeatureModelEditPart;
import de.darwinspl.feature.graphical.configurator.editparts.DwConfiguratorEditorVersionEditPart;
import de.darwinspl.feature.graphical.configurator.factory.DwConfiguratorEditorEditPartFactory;
import de.darwinspl.feature.stage.configurator.configurator.SmStageModelConfigurator;
import de.darwinspl.feature.stage.configurator.editparts.SmConfiguratorFeatureEditPart;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;

public class SmConfiguratorEditPartFactory extends DwConfiguratorEditorEditPartFactory {
	protected SmStageModelConfigurator stageConfigurator;

	public SmConfiguratorEditPartFactory(GraphicalViewer viewer, DwGraphicalFeatureModelViewer editor, SmStageModelConfigurator configurator ) {
		super(viewer, editor);
		this.stageConfigurator = configurator;
	}
	
	/**
	 * Changed Edit part Creation to support Stage Models
	 */
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		
		if(model instanceof DwFeatureModelWrapped){
			part = new DwConfiguratorEditorFeatureModelEditPart(editor);
			viewer.getControl().addControlListener((DwConfiguratorEditorFeatureModelEditPart)part);
			viewer.addPropertyChangeListener((DwConfiguratorEditorFeatureModelEditPart)part);
			
			featureModel = (DwFeatureModelWrapped)model;
		}else if(model instanceof DwRootFeatureWrapped){
			//Changed part to support Stages and their representation
			part = new SmConfiguratorFeatureEditPart(editor, featureModel, stageConfigurator);
		}else if(model instanceof DwFeatureWrapped){
			//Changed part to support Stages and their representation
			part = new SmConfiguratorFeatureEditPart(editor, featureModel, stageConfigurator);
		}else if(model instanceof DwGroupWrapped){
			part = new DwGroupEditPart(editor, featureModel);
		}else if(model instanceof DwParentChildConnection){
			part = new DwParentChildConnectionEditPart(editor, featureModel);
		}else if(model instanceof HyVersion){
			part = new DwConfiguratorEditorVersionEditPart(editor, featureModel);
		}else if(model instanceof HyFeatureAttribute){
			part = new DwConfiguratorEditorAttributeEditPart(editor, featureModel);
		}else if(model instanceof HyEnum){
			part = new DwEnumEditPart(editor, featureModel);
		}else if(model instanceof DwEnumContainerWrapped){
			part = new DwEnumContainerEditPart(editor, featureModel);
		}else if(model instanceof HyEnum){
			part = new DwEnumEditPart(editor, featureModel);			
		}else if(model instanceof HyEnumLiteral){
			part = new DwEnumLiteralEditPart(editor, featureModel);
		}

		if(context != null && model != null && !(model instanceof DwParentChildConnection)){
			part.setParent(context);
		}
		if(part != null){
			part.setModel(model);
		}		
		
		return part;
	}

}
