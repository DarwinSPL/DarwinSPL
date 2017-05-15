package de.darwinspl.feature.graphical.editor.commands.feature;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwRootFeatureEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import de.darwinspl.feature.graphical.editor.commands.DwFeatureModelEditorCommand;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyFeature;

public class DwFeatureDeleteCommand extends DwFeatureModelEditorCommand{
	EditPart host;

	public DwFeatureDeleteCommand(DwGraphicalFeatureModelViewer viewer, EditPart host) {
		super(viewer);

		this.host = host;
	}

	private DwFeatureWrapped feature;
	private DwFeatureWrapped oldParent;
	private HyFeature oldFeature;
	private Date executionDate;

	public void setFeature(DwFeatureWrapped feature) {
		this.feature = feature;
	}

	private void restrictHyLinearTemporalElementsToParentValidUntil(EList<HyTemporalElement> elements){
		Date date = viewer.getCurrentSelectedDate();
		for(HyTemporalElement element : elements){
			if(element.getValidUntil() == null || element.getValidUntil().after(date)){
				element.setValidUntil(date);
			}
		}			
	}

	@Override
	public boolean canExecute() {
		if(host instanceof DwRootFeatureEditPart)
			return false;
		if(host instanceof DwFeatureEditPart)
			return true;
		
		return false;
	}


	@SuppressWarnings("unchecked")
	public void redo(){
		
		HyFeature feature = this.feature.getWrappedModelElement();
		Date date = viewer.getCurrentSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE)))
			date = null;
		
		executionDate = date;

		oldFeature = EcoreUtil.copy(feature);
		oldParent = this.feature.getParentFeature(date);
		
		if(date == null){
			viewer.getModelWrapped().removeFeaturePermanently(this.feature);
		}else{
			feature.setValidUntil(date);

			// restrict feature parameters to the date
			restrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)feature.getNames());
			restrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)feature.getAttributes());
			restrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)feature.getVersions());
		
			viewer.getModelWrapped().removeFeature(this.feature, date);
		}
		

		
		

		// delete the selection from the element
		host.setSelected(0);

		viewer.getModelWrapped().rearrangeFeatures();
		viewer.refreshView();
		
	}
	
	public void undo(){
		
		Date date = executionDate;
		DwParentChildConnection connection = new DwParentChildConnection();
		
		this.feature.setWrappedModelElement(oldFeature);
		DwFeatureModelWrapped featureModel = viewer.getModelWrapped();
		date = viewer.getCurrentSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE))){
			date = null;
		}		
		

		
		connection = new DwParentChildConnection();
		connection.setSource(oldParent);
		connection.setTarget(this.feature);
		connection.setModel(featureModel);
		
		featureModel.addConnection(connection, featureModel.getSelectedDate(), null);
		
		featureModel.rearrangeFeatures();
		viewer.refreshView();	
	}
	
	@Override
	public void execute(){
		redo();
	}
}
