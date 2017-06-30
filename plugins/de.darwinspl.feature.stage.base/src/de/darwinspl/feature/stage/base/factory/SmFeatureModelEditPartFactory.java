package de.darwinspl.feature.stage.base.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;

import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feautre.stage.base.editparts.SmFeatureEditPart;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;
import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwEnumContainerEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwAttributeEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwEnumEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwEnumLiteralEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureModelEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwGroupEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwParentChildConnectionEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwRootFeatureEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwVersionEditPart;
import de.darwinspl.feature.graphical.base.factory.DwFeatureModelEditPartFactory;
import de.darwinspl.feature.graphical.base.model.DwEnumContainerWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import de.darwinspl.feature.graphical.base.model.DwRootFeatureWrapped;

public class SmFeatureModelEditPartFactory extends DwFeatureModelEditPartFactory {

	protected Stage currentStage;
	
	public SmFeatureModelEditPartFactory(GraphicalViewer viewer, DwGraphicalFeatureModelViewer editor) {
		super(viewer, editor);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Overwritten Edit Part, uses new Edit Part for Features to allow
	 */
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		
		
		if(model instanceof DwFeatureModelWrapped){
			part = new DwFeatureModelEditPart(editor);
			viewer.getControl().addControlListener((DwFeatureModelEditPart)part);
			viewer.addPropertyChangeListener((DwFeatureModelEditPart)part);
			
			featureModel = (DwFeatureModelWrapped)model;
		}else if(model instanceof DwRootFeatureWrapped){
			part = new DwRootFeatureEditPart(editor, featureModel);
		}else if(model instanceof DwFeatureWrapped){
			//Override
			part = new SmFeatureEditPart(editor, featureModel, currentStage);
		}else if(model instanceof DwGroupWrapped){
			part = new DwGroupEditPart(editor, featureModel);
		}else if(model instanceof DwParentChildConnection){
			part = new DwParentChildConnectionEditPart(editor, featureModel);
		}else if(model instanceof HyVersion){
			part = new DwVersionEditPart(editor, featureModel);
		}else if(model instanceof HyFeatureAttribute){
			part = new DwAttributeEditPart(editor, featureModel);
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
