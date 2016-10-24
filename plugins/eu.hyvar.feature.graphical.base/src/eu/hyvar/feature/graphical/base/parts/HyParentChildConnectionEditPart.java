package eu.hyvar.feature.graphical.base.parts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.figures.HyParentChildConnectionFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;

public class HyParentChildConnectionEditPart extends AbstractConnectionEditPart implements PropertyChangeListener, NodeEditPart {
	protected HyFeatureModelWrapped model;
	protected GraphicalFeatureModelEditor editor;
	
	public HyParentChildConnectionEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped model){
		this.model = model;
		this.editor = editor;
	}
	@Override
	protected void createEditPolicies() {
	}

	@Override 
	protected IFigure createFigure(){
		return new HyParentChildConnectionFigure();
	}

	@Override
	public void setParent(EditPart parent){
		super.setParent(parent);
	}

	@Override 
	public void activate() {
		if(!isActive()) {
			HyParentChildConnection model = ((HyParentChildConnection)getModel());
			model.addPropertyChangeListener(this);
		}
		super.activate();
	}

	@Override 
	public void deactivate() {
		if(isActive()) {
			HyParentChildConnection model = ((HyParentChildConnection)getModel());
			model.removePropertyChangeListener(this);
		}
		super.deactivate();
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		HyParentChildConnectionFigure connectionFigure = (HyParentChildConnectionFigure)this.figure;

		if(evt.getPropertyName().equals(HyParentChildConnection.PROPERTY_HIGHLIGHTED)){
			connectionFigure.setColor((boolean)evt.getNewValue() ? theme.getSelectionLineColor() : theme.getLineColor());
		}
		if(evt.getPropertyName().equals(HyParentChildConnection.PROPERTY_VISIBLE)){
			connectionFigure.setVisible((boolean)evt.getNewValue());
		}

		refreshVisuals();
	}


	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return ((HyParentChildConnectionFigure)getFigure()).getAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return ((HyParentChildConnectionFigure)getFigure()).getAnchor();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return ((HyParentChildConnectionFigure)getFigure()).getAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return ((HyParentChildConnectionFigure)getFigure()).getAnchor();
	}


	
	@Override
	public void refreshVisuals(){
		((HyParentChildConnectionFigure)this.getFigure()).layout();
		Date date = editor.getCurrentSelectedDate();
		
		HyParentChildConnection connection = (HyParentChildConnection)getModel();
		boolean sourceValid = connection.getSource().isValid(date);
		boolean targetValid = connection.getTarget().isValid(date);
		
		HyParentChildConnectionFigure figure = (HyParentChildConnectionFigure)this.getFigure();
		figure.setVisible(sourceValid && targetValid);
		figure.layout();
	}

}
