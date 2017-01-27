package eu.hyvar.feature.graphical.base.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.HyGeometryUtil;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version.HyVersionLayouterManager;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.figures.HyFeatureFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;

public class HyFeatureEditPart extends HyAbstractEditPart implements NodeEditPart{
	protected int heightWithoutAttributes = 0;
	
	public class HyFeatureAdapter implements Adapter {

		@Override 
		public void notifyChanged(Notification notification) {
			refreshChildren();
			refreshVisuals();
		}

		@Override 
		public Notifier getTarget() {
			return (HyFeature)((HyFeatureWrapped)getModel()).getWrappedModelElement();
		}

		@Override public void setTarget(Notifier newTarget) {
			// Do nothing.
		}

		@Override public boolean isAdapterForType(Object type) {
			return type.equals(HyFeature.class);
		}
	} 

	private HyFeatureAdapter adapter;

	private boolean changeMode;

	public boolean isChangeMode() {
		return changeMode;
	}

	public void setChangeMode(boolean changeMode) {
		this.changeMode = changeMode;
	}

	public HyFeatureEditPart(HyGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel){
		super(editor, featureModel);

		adapter = new HyFeatureAdapter();
	}

	@Override
	protected IFigure createFigure() {	
		return new HyFeatureFigure(editor, (HyFeatureWrapped)getModel());
	}



	@Override 
	public void activate() {
		//super.activate();
		if(!isActive()) {
			HyFeatureWrapped model = ((HyFeatureWrapped)getModel());
			model.addPropertyChangeListener(this);
			model.getWrappedModelElement().eAdapters().add(adapter);
		}
		super.activate();
	}

	@Override 
	public void deactivate() {
		//super.deactivate();
		if(isActive()) {
			HyFeatureWrapped model = ((HyFeatureWrapped)getModel());
			model.removePropertyChangeListener(this);

			model.getWrappedModelElement().eAdapters().remove(adapter);
		}
		super.deactivate();
	}



	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		super.propertyChange(evt);
		
		refreshVisuals();

		refreshTargetConnections();
		refreshSourceConnections();		
	}






	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return ((HyFeatureFigure)getFigure()).getChildrenAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return ((HyFeatureFigure)getFigure()).getParentAnchor();
		
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return ((HyFeatureFigure)getFigure()).getChildrenAnchor();
		
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return ((HyFeatureFigure)getFigure()).getParentAnchor();
	}


	/**
	 * Fetch all versions related to the feature to display them as subfeatures
	 */
	@Override 
	protected ArrayList<EObject> getModelChildren() {
		HyFeatureWrapped model = (HyFeatureWrapped) getModel();	

		ArrayList<EObject> objects = new ArrayList<>();
		for(HyVersion version : model.getWrappedModelElement().getVersions()){
			objects.add(version);
		}
		
		for(HyFeatureAttribute attribute : model.getWrappedModelElement().getAttributes()){
			objects.add(attribute);
		}
		
		return objects;	
	}
	
	
	
	protected boolean hasModifier(HyFeatureWrapped feature){
		Date date = ((HyGraphicalFeatureModelViewer)this.editor).getCurrentSelectedDate();
		if(date == null)
			date = new Date();

		return feature.isWithoutModifier(date);
	}

	
	@Override
	public void refreshVisuals(){
		refreshChildren();
		super.refreshVisuals();
		
		HyGraphicalFeatureModelViewer editor = (HyGraphicalFeatureModelViewer)this.editor;
		Date date = editor.getCurrentSelectedDate();

		HyFeatureFigure figure = (HyFeatureFigure)getFigure();
		figure.setSeperatorLocation(new Point(0, ((HyFeatureWrapped)getModel()).getHeightWithoutAttributes(date)));
		HyFeatureWrapped wrappedFeature = (HyFeatureWrapped)this.getModel();

		figure.setVisible(wrappedFeature.isValid(date));
		

		setSize();
		figure.update();
		
		for(HyParentChildConnection connection : this.getModelSourceConnections()){
			connection.notifyChange();
		}
		
		refreshVisualsOfChildren();
	}
	
	
	@Override
	protected void refreshChildren() {
		super.refreshChildren();
		
		HyFeature feature = ((HyFeatureWrapped)getModel()).getWrappedModelElement();
		
		HyGraphicalFeatureModelViewer editor = (HyGraphicalFeatureModelViewer)this.editor;
		Date date = editor.getCurrentSelectedDate();
		HyVersionLayouterManager.updateLayouter(feature, date);
	}
	
	/**
	 * Calculates and sets the size needed to display all versions and attributes for this feature at the selected date
	 */
	protected void setSize(){
		HyFeatureWrapped feature = (HyFeatureWrapped)getModel();
		HyFeatureModelEditPart parent = (HyFeatureModelEditPart)getParent();
		HyFeatureFigure figure = (HyFeatureFigure)getFigure();
		HyGraphicalFeatureModelViewer editor = (HyGraphicalFeatureModelViewer)this.editor;
		Date date = editor.getCurrentSelectedDate();
		
		int width = HyGeometryUtil.calculateFeatureWidth(feature.getWrappedModelElement(), date);
		int height = feature.getSize(date).height; //HyGeometryUtil.calculateFeatureHeight(feature.getWrappedModelElement(), date);

		
		Dimension newFeatureSize = new Dimension(width, height);
		feature.setSize(newFeatureSize);
		
		Rectangle layout = new Rectangle(feature.getPosition(date), newFeatureSize);
		parent.setLayoutConstraint(this, figure, layout);	
		
		
	}
	


	
	@Override
	protected void createEditPolicies(){
	}


	@Override 
	protected List<HyParentChildConnection> getModelSourceConnections() {
		HyFeatureWrapped model = (HyFeatureWrapped)getModel();

		HyGraphicalFeatureModelViewer editor = (HyGraphicalFeatureModelViewer)this.editor;
		Date date = editor.getCurrentSelectedDate();
		return model.getChildrenConnections(date);
	}

	@Override 
	protected List<HyParentChildConnection> getModelTargetConnections() {
		HyFeatureWrapped model = (HyFeatureWrapped)getModel();

		HyGraphicalFeatureModelViewer editor = (HyGraphicalFeatureModelViewer)this.editor;
		Date date = editor.getCurrentSelectedDate();
		return model.getParentConnections(date);
	}

	/**
	 * Refresh the visual representation of all versions and attributes releated to this feature
	 */
	protected void refreshVisualsOfChildren(){
		
		for(Object o : this.getChildren()){
			if(o instanceof HyVersionEditPart){
				HyVersionEditPart edit = (HyVersionEditPart)o;
				edit.refreshVisuals();
			}

			if(o instanceof HyAttributeEditPart){
				HyAttributeEditPart edit = (HyAttributeEditPart)o;
				edit.refreshVisuals();
			}
		}		
	}
}