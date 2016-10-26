package eu.hyvar.feature.graphical.editor.editparts;
import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyParentChildConnectionEditPart;
import eu.hyvar.feature.graphical.base.figures.HyParentChildConnectionFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;
import eu.hyvar.feature.graphical.editor.policies.HyFeatureEvolutionGraphicalNodeEditPolicy;
import eu.hyvar.feature.graphical.editor.policies.HyParentChildConnectionEditPolicy;

public class HyParentChildConnectionEditorEditPart extends HyParentChildConnectionEditPart {
	private GraphicalFeatureModelEditor editor;
	
	public HyParentChildConnectionEditorEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped featureModel){
		super(editor, featureModel);
		this.editor = editor;
	}
	
	@Override public void activate() {
		//super.activate();
		if(!isActive()) {
			HyParentChildConnection model = ((HyParentChildConnection)getModel());
			model.getSource().addPropertyChangeListener(this);
			model.getTarget().addPropertyChangeListener(this);
		}
		super.activate();
	}

	@Override public void deactivate() {
		//super.deactivate();
		if(isActive()) {
			HyParentChildConnection model = ((HyParentChildConnection)getModel());
			model.getSource().removePropertyChangeListener(this);
			model.getTarget().removePropertyChangeListener(this);
		}
		super.deactivate();
	}
	
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new HyParentChildConnectionEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new HyFeatureEvolutionGraphicalNodeEditPolicy(model, editor));
		installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new SelectionEditPolicy(){
			DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

			@Override
			protected void hideSelection() {
				((HyParentChildConnectionFigure)getFigure()).setColor(theme.getLineColor());
			}

			@Override
			protected void showSelection() {
				((HyParentChildConnectionFigure)getFigure()).setColor(theme.getSelectionLineColor());
			}
		});
	}

}
