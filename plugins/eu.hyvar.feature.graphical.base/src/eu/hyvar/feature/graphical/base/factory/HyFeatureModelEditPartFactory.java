package eu.hyvar.feature.graphical.base.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalViewer;

import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyAttributeEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureModelEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyGroupEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyParentChildConnectionEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyRootFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyVersionEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;
import eu.hyvar.feature.graphical.base.model.HyRootFeatureWrapped;

public class HyFeatureModelEditPartFactory implements EditPartFactory{
	protected HyFeatureModelWrapped featureModel;
	protected GraphicalViewer viewer;
	
	protected DwGraphicalFeatureModelViewer editor;
	
	public HyFeatureModelEditPartFactory(GraphicalViewer viewer, DwGraphicalFeatureModelViewer editor){
		this.viewer = viewer;
		this.editor = editor;
	}
	
	public HyFeatureModelWrapped getFeatureModel() {
		return featureModel;
	}

	public void setFeatureModel(HyFeatureModelWrapped featureModel) {
		this.featureModel = featureModel;
	}

	
	

	
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		
		
		if(model instanceof HyFeatureModelWrapped){
			part = new HyFeatureModelEditPart(editor);
			viewer.getControl().addControlListener((HyFeatureModelEditPart)part);
			viewer.addPropertyChangeListener((HyFeatureModelEditPart)part);
			
			featureModel = (HyFeatureModelWrapped)model;
		}else if(model instanceof HyRootFeatureWrapped){
			part = new HyRootFeatureEditPart(editor, featureModel);
		}else if(model instanceof HyFeatureWrapped){
			part = new HyFeatureEditPart(editor, featureModel);
		}else if(model instanceof HyGroupWrapped){
			part = new HyGroupEditPart(editor, featureModel);
		}else if(model instanceof HyParentChildConnection){
			part = new HyParentChildConnectionEditPart(editor, featureModel);
		}else if(model instanceof HyVersion){
			part = new HyVersionEditPart(editor, featureModel);
		}else if(model instanceof HyFeatureAttribute){
			part = new HyAttributeEditPart(editor, featureModel);
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
