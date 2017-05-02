package dw.darwinspl.feature.graphical.editor.editparts;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.editparts.DwParentChildConnectionEditPart;
import dw.darwinspl.feature.graphical.base.figures.DwParentChildConnectionFigure;
import dw.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import dw.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import dw.darwinspl.feature.graphical.editor.policies.DwParentChildConnectionEndpointEditPolicy;
import dw.darwinspl.feature.graphical.editor.policies.feature.DwFeatureGraphicalNodeEditPolicy;
import dw.darwinspl.feature.graphical.editor.policies.feature.DwParentChildConnectionEditPolicy;

public class DwParentChildConnectionEditorEditPart extends DwParentChildConnectionEditPart {
	private DwGraphicalFeatureModelViewer editor;

	public DwParentChildConnectionEditorEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel){
		super(editor, featureModel);
		this.editor = editor;
	}

	
	@Override public void activate() {
		if(!isActive()) {
			DwParentChildConnection model = ((DwParentChildConnection)getModel());
			model.getSource().addPropertyChangeListener(this);
			model.getTarget().addPropertyChangeListener(this);
		}
		super.activate();
	}

	@Override public void deactivate() {
		if(isActive()) {
			DwParentChildConnection model = ((DwParentChildConnection)getModel());
			model.getSource().removePropertyChangeListener(this);
			model.getTarget().removePropertyChangeListener(this);
		}
		super.deactivate();
	}
	

	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();

		installEditPolicy(EditPolicy.CONNECTION_ROLE, new DwParentChildConnectionEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DwFeatureGraphicalNodeEditPolicy(editor, model));
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new DwParentChildConnectionEndpointEditPolicy());
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new SelectionEditPolicy(){
			DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

			@Override
			protected void hideSelection() {
				((DwParentChildConnectionFigure)getFigure()).setColor(theme.getLineColor());
				getFigure().repaint();
			}

			@Override
			protected void showSelection() {
				((DwParentChildConnectionFigure)getFigure()).setColor(theme.getSelectionSecondaryColor());
				getFigure().repaint();
			}
		});
	}

}
