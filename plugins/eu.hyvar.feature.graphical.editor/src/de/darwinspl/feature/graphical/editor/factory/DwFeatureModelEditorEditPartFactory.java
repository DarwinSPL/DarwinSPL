package de.darwinspl.feature.graphical.editor.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwEnumContainerEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureModelEditPart;
import de.darwinspl.feature.graphical.base.factory.DwFeatureModelEditPartFactory;
import de.darwinspl.feature.graphical.base.model.DwEnumContainerWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import de.darwinspl.feature.graphical.base.model.DwRootFeatureWrapped;
import de.darwinspl.feature.graphical.editor.editparts.DwAttributeEditorEditPart;
import de.darwinspl.feature.graphical.editor.editparts.DwEnumEditorEditPart;
import de.darwinspl.feature.graphical.editor.editparts.DwEnumLiteralEditorEditPart;
import de.darwinspl.feature.graphical.editor.editparts.DwFeatureEditorEditPart;
import de.darwinspl.feature.graphical.editor.editparts.DwFeatureModelEditorEditPart;
import de.darwinspl.feature.graphical.editor.editparts.DwGroupEditorEditPart;
import de.darwinspl.feature.graphical.editor.editparts.DwParentChildConnectionEditorEditPart;
import de.darwinspl.feature.graphical.editor.editparts.DwRootFeatureEditorEditPart;
import de.darwinspl.feature.graphical.editor.editparts.DwVersionEditorEditPart;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;

public class DwFeatureModelEditorEditPartFactory extends DwFeatureModelEditPartFactory{
	
	public DwFeatureModelEditorEditPartFactory(GraphicalViewer viewer, DwGraphicalFeatureModelViewer editor) {
		super(viewer, editor);
	}
	
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		
		if(model instanceof DwFeatureModelWrapped){
			part = new DwFeatureModelEditorEditPart(editor);
			viewer.getControl().addControlListener((DwFeatureModelEditPart)part);
			viewer.addPropertyChangeListener((DwFeatureModelEditPart)part);
			
			featureModel = (DwFeatureModelWrapped)model;
		}else if(model instanceof DwRootFeatureWrapped){
			part = new DwRootFeatureEditorEditPart(editor, featureModel);
		}else if(model instanceof DwFeatureWrapped){
			part = new DwFeatureEditorEditPart(editor, featureModel);
		}else if(model instanceof DwGroupWrapped){
			part = new DwGroupEditorEditPart(editor, featureModel);
		}else if(model instanceof DwParentChildConnection){
			part = new DwParentChildConnectionEditorEditPart(editor, featureModel);
		}else if(model instanceof HyVersion){
			part = new DwVersionEditorEditPart(editor, featureModel);
		}else if(model instanceof HyFeatureAttribute){
			part = new DwAttributeEditorEditPart(editor, featureModel);
		}else if(model instanceof DwEnumContainerWrapped){
			part = new DwEnumContainerEditPart(editor, featureModel);
		}else if(model instanceof HyEnum){
			part = new DwEnumEditorEditPart(editor, featureModel);			
		}else if(model instanceof HyEnumLiteral){
			part = new DwEnumLiteralEditorEditPart(editor, featureModel);
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
