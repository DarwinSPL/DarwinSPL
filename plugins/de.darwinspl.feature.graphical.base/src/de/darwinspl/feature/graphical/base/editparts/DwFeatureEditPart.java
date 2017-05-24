package de.darwinspl.feature.graphical.base.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;

import de.darwinspl.feature.graphical.base.deltaecore.wrapper.DwGeometryUtil;
import de.darwinspl.feature.graphical.base.deltaecore.wrapper.layouter.version.DwVersionLayouterManager;
import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.figures.DwFeatureFigure;
import de.darwinspl.feature.graphical.base.figures.DwHiddenChildrenIndicatorFigure;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;

public class DwFeatureEditPart extends DwAbstractEditPart implements NodeEditPart{
	private HyFeatureAdapter adapter;

	public class HyFeatureAdapter implements Adapter {

		@Override 
		public void notifyChanged(Notification notification) {

			if(notification.getEventType() == ENotificationImpl.ADD){
				if(notification.getNotifier() instanceof HyFeature){
					if(notification.getNewValue() instanceof HyVersion){
						refreshChildren();
						refreshVisuals();						
					}

				}
			}
			if(notification.getEventType() == ENotificationImpl.REMOVE && notification.getNotifier() instanceof HyFeature){
				// in case that the feature was deleted do nothing
			}			
		}

		@Override 
		public Notifier getTarget() {
			return (HyFeature)((DwFeatureWrapped)getModel()).getWrappedModelElement();
		}

		@Override public void setTarget(Notifier newTarget) {
			// Do nothing.
		}

		@Override public boolean isAdapterForType(Object type) {
			return type.equals(HyFeature.class);
		}
	} 

	public DwFeatureEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel){
		super(editor, featureModel);

		adapter = new HyFeatureAdapter();
	}

	@Override
	protected IFigure createFigure() {	
		return new DwFeatureFigure(editor, (DwFeatureWrapped)getModel());
	}

	@Override 
	public void activate() {
		if(!isActive()) {
			DwFeatureWrapped model = ((DwFeatureWrapped)getModel());
			model.getWrappedModelElement().eAdapters().add(adapter);
		}

		super.activate();
	}

	@Override 
	public void deactivate() {
		if(isActive()) {
			DwFeatureWrapped model = ((DwFeatureWrapped)getModel());

			model.getWrappedModelElement().eAdapters().remove(adapter);
		}
		super.deactivate();
	}



	@Override
	public void propertyChange(PropertyChangeEvent evt) {				
		DwFeatureFigure figure = (DwFeatureFigure)getFigure();
		DwFeatureWrapped model = ((DwFeatureWrapped)getModel());

		boolean hasMarker = featureModel.hasMarkerForElement(model.getWrappedModelElement());

		if(hasMarker){
			figure.setTooltipVisible(true);
			figure.setTooltipText(featureModel.getMarkerForElement(model.getWrappedModelElement()).getMessage());

		}else{
			figure.setTooltipVisible(false);
		}

		refreshVisuals();

		refreshTargetConnections();
		refreshSourceConnections();				

	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return ((DwFeatureFigure)getFigure()).getChildrenAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return ((DwFeatureFigure)getFigure()).getParentAnchor();	
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return ((DwFeatureFigure)getFigure()).getChildrenAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return ((DwFeatureFigure)getFigure()).getParentAnchor();
	}

	/**
	 * Fetch all versions related to the feature to display them as subfeatures
	 */
	@Override 
	protected ArrayList<EObject> getModelChildren() {
		DwFeatureWrapped model = (DwFeatureWrapped) getModel();	

		ArrayList<EObject> objects = new ArrayList<>();
		for(HyVersion version : model.getWrappedModelElement().getVersions()){
			objects.add(version);
		}

		for(HyFeatureAttribute attribute : model.getWrappedModelElement().getAttributes()){
			objects.add(attribute);
		}

		return objects;	
	}



	protected boolean hasModifier(DwFeatureWrapped feature){
		Date date = ((DwGraphicalFeatureModelViewer)this.editor).getCurrentSelectedDate();
		if(date == null)
			date = new Date();

		return feature.isWithoutModifier(date);
	}


	@Override
	public void refreshVisuals(){
		
		refreshChildren();
		super.refreshVisuals();

		DwGraphicalFeatureModelViewer editor = (DwGraphicalFeatureModelViewer)this.editor;
		Date date = editor.getCurrentSelectedDate();

		DwFeatureFigure figure = (DwFeatureFigure)getFigure();
		DwFeatureWrapped wrappedFeature = (DwFeatureWrapped)this.getModel();
		
		boolean featureIsCurrentlyValid = wrappedFeature.isValid(date);

		if(featureIsCurrentlyValid){
			figure.update();
		}

		figure.setVisible(wrappedFeature.isVisible());


		for(DwParentChildConnection connection : this.getModelSourceConnections()){
			connection.notifyChange();
		}

		refreshVisualsOfChildren();
	}


	@Override
	protected void refreshChildren() {
		super.refreshChildren();

		HyFeature feature = ((DwFeatureWrapped)getModel()).getWrappedModelElement();

		DwGraphicalFeatureModelViewer editor = (DwGraphicalFeatureModelViewer)this.editor;
		Date date = editor.getCurrentSelectedDate();
		DwVersionLayouterManager.updateLayouter(feature, date);
	}

	@Override
	protected void createEditPolicies(){
	}


	@Override 
	protected List<DwParentChildConnection> getModelSourceConnections() {
		DwFeatureWrapped model = (DwFeatureWrapped)getModel();

		DwGraphicalFeatureModelViewer editor = (DwGraphicalFeatureModelViewer)this.editor;
		Date date = editor.getCurrentSelectedDate();
		return model.getChildrenConnections(date);
	}

	@Override 
	protected List<DwParentChildConnection> getModelTargetConnections() {
		DwFeatureWrapped model = (DwFeatureWrapped)getModel();

		DwGraphicalFeatureModelViewer editor = (DwGraphicalFeatureModelViewer)this.editor;
		Date date = editor.getCurrentSelectedDate();
		return model.getParentConnections(date);
	}

	/**
	 * Refresh the visual representation of all versions and attributes related to this feature
	 */
	protected void refreshVisualsOfChildren(){

		for(Object o : this.getChildren()){
			if(o instanceof DwVersionEditPart){
				DwVersionEditPart edit = (DwVersionEditPart)o;
				edit.refreshVisuals();
			}

			if(o instanceof DwAttributeEditPart){
				DwAttributeEditPart edit = (DwAttributeEditPart)o;
				edit.refreshVisuals();
			}
		}		
	}

	@Override
	protected Rectangle getFigureConstraint() {
		DwFeatureWrapped feature = (DwFeatureWrapped)getModel();
		DwGraphicalFeatureModelViewer editor = (DwGraphicalFeatureModelViewer)this.editor;
		Date date = editor.getCurrentSelectedDate();

		int width = DwGeometryUtil.calculateFeatureWidth(feature.getWrappedModelElement(), date);
		int height = feature.getSize(date).height;

		if(feature.isHideChildren()){
			height += (int)(DwHiddenChildrenIndicatorFigure.HIDDEN_CHILDREN_INDICATOR_SIZE * 1.5); 
		}

		Dimension newFeatureSize = new Dimension(width, height);
		feature.setSize(newFeatureSize);

		Rectangle layout = new Rectangle(feature.getPosition(date).getPosition(), newFeatureSize);
		return layout;
	}
}