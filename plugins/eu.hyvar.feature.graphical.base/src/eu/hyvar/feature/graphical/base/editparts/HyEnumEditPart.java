package eu.hyvar.feature.graphical.base.editparts;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.figures.HyEnumFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;

/**
 * EditPart that handles an enumeration and all related literals.
 * @author Gil Engel
 *
 */
public class HyEnumEditPart extends HyAbstractEditPart{

	public class HyEnumAdapter implements Adapter {

		// Adapter interface
		@Override 
		public void notifyChanged(Notification notification) {
			refreshChildren();
			refreshVisuals();

			changes.firePropertyChange(""+notification.getEventType(), notification.getOldValue(), notification.getNewValue());
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

	/**
	 * Used to inform the parent container in case a literal was added to the enumeration.
	 */
	private PropertyChangeSupport changes = new PropertyChangeSupport( this );

	public void addPropertyChangeListener( PropertyChangeListener l ) {
		changes.addPropertyChangeListener( l );
	}

	public void removePropertyChangeListener( PropertyChangeListener l ) {
		changes.removePropertyChangeListener( l );
	}


	public HyEnumEditPart(DwGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel) {
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
	 * Fetches all literals related to the enumeration. Needed to display them as children.
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
	 * Sets the text of the figure label to the name of the HyEnum enumeration
	 */
	protected void refreshLabel(){
		HyEnum model = (HyEnum)getModel();

		HyEnumFigure figure = (HyEnumFigure)getFigure();
		figure.setText(model.getName());		
	}


	/**
	 * Refreshes the layout and label of the figure
	 */
	@Override
	public void refreshVisuals(){
		refreshLabel();	
	}


	/**
	 * Sets the index where the child will be placed within the children list to -1. This causes the child to be added to the back to the list.
	 * Otherwise the child would be inserted before the existing one causing a reverse draw order. 
	 */
	@Override
	protected void addChildVisual(EditPart child, int index){
		super.addChildVisual(child, -1);
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
