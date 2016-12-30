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
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.figures.HyEnumLiteralFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;

public class HyEnumLiteralEditPart  extends HyAbstractEditPart{
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

	public HyEnumLiteralEditPart(HyGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel) {
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

	@Override
	public void refreshVisuals() {
		HyEnumEditPart parent = (HyEnumEditPart)getParent();
		HyEnumLiteral literal = (HyEnumLiteral)getModel();
		IFigure parentFigure = parent.getFigure();

		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		if(literal.getEnum() == null) return;
		int index = literal.getEnum().getLiterals().indexOf(literal);


		Rectangle layout = new Rectangle(new Point(1, theme.getFeatureNameAreaHeight()*(index + 1)), 
				new Dimension(parentFigure.getSize().width, theme.getFeatureNameAreaHeight()));
		parent.setLayoutConstraint(this, figure, layout);	


		HyEnumLiteralFigure figure = (HyEnumLiteralFigure)getFigure();
		figure.setText(((HyEnumLiteral)getModel()).getName());
		figure.setBounds(layout);
		figure.update();
	}
}
