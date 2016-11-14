package eu.hyvar.feature.graphical.configurator.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyEnumEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyEnumLiteralEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyGroupEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyParentChildConnectionEditPart;
import eu.hyvar.feature.graphical.base.factory.HyFeatureModelEditPartFactory;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;
import eu.hyvar.feature.graphical.base.model.HyRootFeatureWrapped;
import eu.hyvar.feature.graphical.configurator.editparts.HyConfiguratorAttributeEditPart;
import eu.hyvar.feature.graphical.configurator.editparts.HyConfiguratorFeatureEditPart;
import eu.hyvar.feature.graphical.configurator.editparts.HyConfiguratorFeatureModelEditPart;
import eu.hyvar.feature.graphical.configurator.editparts.HyConfiguratorVersionEditPart;

public class HyConfiguratorEditPartFactory extends HyFeatureModelEditPartFactory{

	public HyConfiguratorEditPartFactory(GraphicalViewer viewer, GraphicalFeatureModelEditor editor) {
		super(viewer, editor);
	}
	
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		
		if(model instanceof HyFeatureModelWrapped){
			part = new HyConfiguratorFeatureModelEditPart(editor);
			viewer.getControl().addControlListener((HyConfiguratorFeatureModelEditPart)part);
			viewer.addPropertyChangeListener((HyConfiguratorFeatureModelEditPart)part);
			
			featureModel = (HyFeatureModelWrapped)model;
		}else if(model instanceof HyRootFeatureWrapped){
			part = new HyConfiguratorFeatureEditPart(editor, featureModel);
		}else if(model instanceof HyFeatureWrapped){
			part = new HyConfiguratorFeatureEditPart(editor, featureModel);
		}else if(model instanceof HyGroupWrapped){
			part = new HyGroupEditPart(editor, featureModel);
		}else if(model instanceof HyParentChildConnection){
			part = new HyParentChildConnectionEditPart(editor, featureModel);
		}else if(model instanceof HyVersion){
			part = new HyConfiguratorVersionEditPart(editor, featureModel);
		}else if(model instanceof HyFeatureAttribute){
			part = new HyConfiguratorAttributeEditPart(editor, featureModel);
		}else if(model instanceof HyEnum){
			part = new HyEnumEditPart(editor, featureModel);
		}else if(model instanceof HyEnumLiteral){
			part = new HyEnumLiteralEditPart(editor, featureModel);
		}

		if(context != null && model != null && !(model instanceof HyParentChildConnection)){
			part.setParent(context);
		}
		if(part != null){
			part.setModel(model);
		}		
		
		return part;
	}


}
