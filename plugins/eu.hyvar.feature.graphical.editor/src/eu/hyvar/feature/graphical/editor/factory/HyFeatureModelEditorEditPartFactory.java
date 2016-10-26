package eu.hyvar.feature.graphical.editor.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;

import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureModelEditPart;
import eu.hyvar.feature.graphical.base.factory.HyFeatureModelEditPartFactory;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;
import eu.hyvar.feature.graphical.base.model.HyRootFeatureWrapped;
import eu.hyvar.feature.graphical.editor.editparts.HyAttributeEditorEditPart;
import eu.hyvar.feature.graphical.editor.editparts.HyFeatureEditorEditPart;
import eu.hyvar.feature.graphical.editor.editparts.HyFeatureModelEditorEditPart;
import eu.hyvar.feature.graphical.editor.editparts.HyGroupEditorEditPart;
import eu.hyvar.feature.graphical.editor.editparts.HyParentChildConnectionEditorEditPart;
import eu.hyvar.feature.graphical.editor.editparts.HyRootFeatureEditorEditPart;
import eu.hyvar.feature.graphical.editor.editparts.HyVersionEditorEditPart;

public class HyFeatureModelEditorEditPartFactory extends HyFeatureModelEditPartFactory{
	
	public HyFeatureModelEditorEditPartFactory(GraphicalViewer viewer, GraphicalFeatureModelEditor editor) {
		super(viewer, editor);
	}

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		
		if(model instanceof HyFeatureModelWrapped){
			part = new HyFeatureModelEditorEditPart(editor);
			viewer.getControl().addControlListener((HyFeatureModelEditPart)part);
			viewer.addPropertyChangeListener((HyFeatureModelEditPart)part);
			
			featureModel = (HyFeatureModelWrapped)model;
		}else if(model instanceof HyRootFeatureWrapped){
			part = new HyRootFeatureEditorEditPart(editor, featureModel);
		}else if(model instanceof HyFeatureWrapped){
			part = new HyFeatureEditorEditPart(editor, featureModel);
		}else if(model instanceof HyGroupWrapped){
			part = new HyGroupEditorEditPart(editor, featureModel);
		}else if(model instanceof HyParentChildConnection){
			part = new HyParentChildConnectionEditorEditPart(editor, featureModel);
		}else if(model instanceof HyVersion){
			part = new HyVersionEditorEditPart(editor, featureModel);
		}else if(model instanceof HyFeatureAttribute){
			part = new HyAttributeEditorEditPart(editor, featureModel);
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
