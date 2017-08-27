package de.darwinspl.feature.graphical.base.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.figures.DwParentChildConnectionFigure;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import eu.hyvar.evolution.util.HyEvolutionUtil;

public class DwParentChildConnectionEditPart extends AbstractConnectionEditPart implements PropertyChangeListener, NodeEditPart {
	protected DwFeatureModelWrapped model;
	protected DwGraphicalFeatureModelViewer editor;
	
	public DwParentChildConnectionEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped model){
		this.model = model;
		this.editor = editor;
	}
	@Override
	protected void createEditPolicies() {
	}

	@Override 
	protected IFigure createFigure(){
		return new DwParentChildConnectionFigure(editor, ((DwParentChildConnection)getModel()).getSource());
	}


	@Override 
	public void activate() {
		if(!isActive()) {
			DwParentChildConnection model = ((DwParentChildConnection)getModel());
			model.addPropertyChangeListener(this);
		}
		super.activate();
	}

	@Override 
	public void deactivate() {
		if(isActive()) {
			DwParentChildConnection model = ((DwParentChildConnection)getModel());
			model.removePropertyChangeListener(this);
		}
		super.deactivate();
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		DwParentChildConnectionFigure connectionFigure = (DwParentChildConnectionFigure)this.figure;

		if(evt.getPropertyName().equals(DwParentChildConnection.PROPERTY_HIGHLIGHTED)){
			connectionFigure.setColor((boolean)evt.getNewValue() ? theme.getSelectionLineColor() : theme.getLineColor());
		}
		if(evt.getPropertyName().equals(DwParentChildConnection.PROPERTY_VISIBLE)){
			connectionFigure.setVisible((boolean)evt.getNewValue());
		}
		
		
		if(evt.getPropertyName().equals(DwParentChildConnection.PROPERTY_HIGHLIGHTED) && ((boolean)evt.getNewValue()) == true)
			connectionFigure.setColor(theme.getSelectionLineColor());
		
		refreshVisuals();
	}


	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		if(!figure.isVisible()){
			return null;
		}
		
		return ((DwParentChildConnectionFigure)getFigure()).getAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		if(!figure.isVisible()){
			return null;
		}
		
		return ((DwParentChildConnectionFigure)getFigure()).getAnchor();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		if(!figure.isVisible()){
			return null;
		}
		
		return ((DwParentChildConnectionFigure)getFigure()).getAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		if(!figure.isVisible()){
			return null;
		}
		
		return ((DwParentChildConnectionFigure)getFigure()).getAnchor();
	}

	@Override
	public void refreshVisuals(){
		Date date = editor.getCurrentSelectedDate();
		DwParentChildConnection connection = (DwParentChildConnection)getModel();
		boolean sourceValid = HyEvolutionUtil.isValid(connection.getSource().getWrappedModelElement(), date);
		boolean targetValid = HyEvolutionUtil.isValid(connection.getTarget().getWrappedModelElement(), date);
		
		boolean connectionValid = true;
		
		if(!targetValid || connection.getTarget().getParentFeature(date) == null ||
		   !connection.getSource().isVisible() || !connection.getTarget().isVisible()){
			connectionValid = false;
		}else
			connectionValid = connection.getTarget().getParentFeature(date).equals(connection.getSource());
		
		if(sourceValid && targetValid && connectionValid){
			figure.setVisible(true);
			
			((DwParentChildConnectionFigure)this.getFigure()).layout();
		}else{
			figure.setVisible(false);
		}
		
	}
}
