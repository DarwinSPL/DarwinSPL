package de.darwinspl.feature.graphical.editor.actions.feature;

import java.util.Date;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwRootFeatureEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.editor.commands.feature.DwFeatureCreateCommand;
import de.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroupComposition;

public class DwFeatureCreateSiblingAction extends DwFeatureSelectionAction{
	public static final String FEATURE_CREATE_SIBLING = "CreateSibling";
	public static final String REQ_FEATURE_CREATE_SIBLING = "CreateSibling";

	Request request;
	
	public DwFeatureCreateSiblingAction(DwGraphicalFeatureModelViewer editor){
		super(editor);
		
		setId(FEATURE_CREATE_SIBLING);
		setText("Create Sibling");
		
		request = new Request(REQ_FEATURE_CREATE_SIBLING);
	}
	
	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty())
			return false;

		for(Object selectedObject : getSelectedObjects()){
			if(selectedObject instanceof DwRootFeatureEditPart)
				return false;
			
			if(!(selectedObject instanceof DwFeatureEditPart)){
				return false;
			}
		}

		return true;
	}	
	
	@Override
	protected Command createCommand(Object acceptedModel) {
		DwFeatureWrapped selectedFeature = getSelectedFeature();		
		DwGraphicalFeatureModelEditor editor = (DwGraphicalFeatureModelEditor)this.getWorkbenchPart();
		
		Date date = editor.getCurrentSelectedDate();
		
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(selectedFeature.getWrappedModelElement().getGroupMembership(), date);
		HyFeatureChild child = HyEvolutionUtil.getValidTemporalElement(composition.getCompositionOf().getChildOf(), date);
		
		DwFeatureCreateCommand command = new DwFeatureCreateCommand(editor.getModelWrapped().findWrappedFeature(child.getParent()), (DwGraphicalFeatureModelViewer)editor, selectedFeature);
		return command;
	}	
}

