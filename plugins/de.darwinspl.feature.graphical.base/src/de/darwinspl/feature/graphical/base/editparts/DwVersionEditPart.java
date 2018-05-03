package de.darwinspl.feature.graphical.base.editparts;


import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import de.darwinspl.feature.graphical.base.deltaecore.wrapper.layouter.version.DwVersionLayouterManager;
import de.darwinspl.feature.graphical.base.deltaecore.wrapper.layouter.version.DwVersionTreeLayouter;
import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.figures.DwVersionFigure;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import eu.hyvar.feature.HyVersion;

public class DwVersionEditPart extends DwAbstractEditPart{
	private DwVersionAdapter adapter;

	public class DwVersionAdapter implements Adapter {

		@Override 
		public void notifyChanged(Notification notification) {
			HyVersion version = (HyVersion)getModel();
			
			if(version.getFeature() != null)
				for(Adapter adapter : version.getFeature().eAdapters()){
					adapter.notifyChanged(notification);
				}

			
			if(notification.getEventType() != Notification.SET && notification.getPosition() != -1 &&
			   notification.getEventType() != Notification.REMOVE &&
			   notification.getEventType() != Notification.REMOVING_ADAPTER)
				refreshVisuals();
			
			else if ( notification.getEventType() == Notification.SET){
				refreshVisuals();
				
			}
			
			
		}
		


		@Override 
		public Notifier getTarget() {
			return (HyVersion)getModel();
		}

		@Override public void setTarget(Notifier newTarget) {
			// Do nothing.
		}

		@Override public boolean isAdapterForType(Object type) {
			return type.equals(HyVersion.class);
		}
	} 
	
	public DwVersionEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		super(editor, featureModel);
		
		adapter = new DwVersionAdapter();
	}
	
	@Override 
	public void activate() {
		if(!isActive()) {
			HyVersion model = ((HyVersion)getModel());
			model.eAdapters().add(adapter);
		}

		super.activate();
	}

	@Override 
	public void deactivate() {
		if(isActive()) {
			HyVersion model = ((HyVersion)getModel());
			model.eAdapters().remove(adapter);
		}
		super.deactivate();
	}

	@Override
	protected IFigure createFigure() {
		return new DwVersionFigure((HyVersion)getModel());
	}

	@Override
	protected void createEditPolicies() {
	}

	@Override
	protected Rectangle getFigureConstraint(){
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Date date = ((DwGraphicalFeatureModelViewer)editor).getCurrentSelectedDate();

		HyVersion model = (HyVersion)getModel();

		int offset = 0;
		if(this.getSelected() == SELECTED_PRIMARY){
			offset = theme.getLineWidth();
		}


		DwVersionTreeLayouter versionTreeLayouter = DwVersionLayouterManager.getLayouter(model.getFeature(), date);
		if(versionTreeLayouter != null){
			Rectangle bounds = versionTreeLayouter.getBounds(model);
			bounds.setX(bounds.x - offset);
			bounds.setY(bounds.y - offset);
			bounds.setWidth(bounds.width+offset*2);
			bounds.setHeight(bounds.height+offset*2);

			return bounds;	
		}

		return new Rectangle(0, 0, 0, 0);
	}
	
	@Override
	public void refreshVisuals(){
		super.refreshVisuals();

		((DwVersionFigure)getFigure()).update();
	}
}