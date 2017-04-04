package eu.hyvar.feature.graphical.base.editparts;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.figures.HyEnumLiteralFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;

public class HyEnumLiteralEditPart extends HyAbstractEditPart{
	public class HyEnumLiteralAdapter implements Adapter {

		// Adapter interface
		@Override 
		public void notifyChanged(Notification notification) {
			refreshChildren();
			refreshVisuals();
		}

		@Override 
		public Notifier getTarget() {
			return (HyEnumLiteral)getModel();
		}

		@Override public void setTarget(Notifier newTarget) {
			// Do nothing.
		}

		@Override public boolean isAdapterForType(Object type) {
			return type.equals(HyEnumLiteral.class);
		}
	} 

	private HyEnumLiteralAdapter adapter = new HyEnumLiteralAdapter();

	public HyEnumLiteralEditPart(DwGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
		
	}

	@Override
	protected IFigure createFigure() {
		return new HyEnumLiteralFigure(editor);
	}

	@Override
	protected void createEditPolicies() {
	}

	@Override
	public void activate() {
		if(!isActive()) {
			HyEnumLiteral model = (HyEnumLiteral)getModel();
			model.eAdapters().add(adapter);
		}

		super.activate();
	}

	@Override
	public void deactivate() {
		if(isActive()) {
			HyEnumLiteral model = (HyEnumLiteral)getModel();
			model.eAdapters().remove(adapter);		
		}
		super.deactivate();
	}

	@Override
	public void refresh(){
		refreshVisuals();
	}
	
	protected Rectangle getFigureConstraint(){
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Dimension size = new Dimension(0, figure.isVisible() ? theme.getFeatureNameAreaHeight() : 0);
		
		return new Rectangle(new Point(0, 0), size);
	}
	
	@Override
	public void refreshVisuals() {
		super.refreshVisuals();
		//HyEnumEditPart parent = (HyEnumEditPart)getParent();

		
		
		HyEnumLiteralFigure figure = (HyEnumLiteralFigure)getFigure();
		//figure.setSize(size.width, size.height);
		figure.setText(((HyEnumLiteral)getModel()).getName());
		
		
		//parent.setLayoutConstraint(this, figure, layout);	
	}
}
