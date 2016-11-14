package eu.hyvar.feature.graphical.base.editparts;


import java.util.Date;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.figures.HyEnumFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.util.HyEnumEditorUtil;


public class HyEnumEditPart  extends HyAbstractEditPart{
	public class HyEnumAdapter implements Adapter {

		// Adapter interface
		@Override 
		public void notifyChanged(Notification notification) {
			refreshChildren();
			refreshVisuals();
		}

		@Override 
		public Notifier getTarget() {
			return (HyEnum)getModel();
		}

		@Override public void setTarget(Notifier newTarget) {
			// Do nothing.
		}

		@Override public boolean isAdapterForType(Object type) {
			return type.equals(HyFeature.class);
		}
	} 

	private HyEnumAdapter adapter = new HyEnumAdapter();

	public HyEnumEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}


	@Override
	protected IFigure createFigure() {
		return new HyEnumFigure(editor);
	}

	@Override
	protected void createEditPolicies() {
	}


	public void activate() {
		if(!isActive()) {
			HyEnum model = (HyEnum)getModel();
			model.eAdapters().add(adapter);
		}

		for(Object part : this.getChildren()){
			((EditPart)part).activate();
		}
		super.activate();
	}


	public void deactivate() {
		if(isActive()) {
			HyEnum model = (HyEnum)getModel();
			model.eAdapters().remove(adapter);	
		}

		super.deactivate();
	}


	/**
	 * Fetch all versions related to the feature to display them as subfeatures
	 */
	@Override 
	protected EList<HyEnumLiteral> getModelChildren() {
		HyEnum model = (HyEnum) getModel();	

		return model.getLiterals();
	}



	@Override
	public void refresh(){
		refreshVisuals();
		refreshChildren();
	}



	/**
	 * Calculates and sets the size needed to display all versions and attributes for this feature at the selected date
	 */
	protected void setSize(){

		HyFeatureModelEditPart parent = (HyFeatureModelEditPart)getParent();
	
		Rectangle layout = new Rectangle(0, 0, 200, 200);
		parent.setLayoutConstraint(this, figure, layout);	
	}	

	@Override
	public void refreshVisuals(){
		
		HyFeatureModelEditPart parent = (HyFeatureModelEditPart)getParent();
		HyEnum model = (HyEnum)getModel();

		Date date = editor.getCurrentSelectedDate();

		IFigure parentFigure = parent.getFigure();

		HyFeatureModel featureModel = editor.getModelWrapped().getModel();
		int index = featureModel.getEnums().indexOf(model);
		int topOffset = 0;
		for(int i=0; i<index; i++){
			topOffset += HyEnumEditorUtil.getEnumHeight(featureModel.getEnums().get(i), date);
		}

		int width = 300;
		Rectangle layout = new Rectangle(new Point(parentFigure.getSize().width()-(width+20), 20+topOffset), 
										 new Dimension(width, HyEnumEditorUtil.getEnumHeight(model, date)));
		

		parent.setLayoutConstraint(this, figure, layout);





		HyEnumFigure figure = (HyEnumFigure)getFigure();
		figure.setVisible(true);
		figure.setText(model.getName());
		


		refreshVisualsOfChildren();
		
	}

	/**
	 * Refresh the visual representation of all versions and attributes releated to this feature
	 */
	protected void refreshVisualsOfChildren(){
		for(Object o : this.getChildren()){
			if(o instanceof HyEnumLiteralEditPart){
				HyEnumLiteralEditPart edit = (HyEnumLiteralEditPart)o;	
				if(!edit.isActive())
					edit.activate();
				
				edit.refreshVisuals();
			}
		}		
	}
}
