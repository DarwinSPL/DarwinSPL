package eu.hyvar.feature.graphical.editor.actions.feature;

import java.util.Date;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyRootFeatureEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.commands.feature.HyFeatureCreateCommand;
import eu.hyvar.feature.graphical.editor.editor.HyGraphicalFeatureModelEditor;

public class HyFeatureCreateSiblingAction extends HyFeatureSelectionAction{
	public static final String FEATURE_CREATE_SIBLING = "CreateSibling";
	public static final String REQ_FEATURE_CREATE_SIBLING = "CreateSibling";

	Request request;
	
	public HyFeatureCreateSiblingAction(DwGraphicalFeatureModelViewer editor){
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
			if(selectedObject instanceof HyRootFeatureEditPart)
				return false;
			
			if(!(selectedObject instanceof HyFeatureEditPart)){
				return false;
			}
		}

		return true;
	}	
	
	@Override
	protected Command createCommand(Object acceptedModel) {
		HyFeatureWrapped selectedFeature = getSelectedFeature();		
		HyGraphicalFeatureModelEditor editor = (HyGraphicalFeatureModelEditor)this.getWorkbenchPart();
		
		Date date = editor.getCurrentSelectedDate();
		
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(selectedFeature.getWrappedModelElement().getGroupMembership(), date);
		HyFeatureChild child = HyEvolutionUtil.getValidTemporalElement(composition.getCompositionOf().getChildOf(), date);
		
		HyFeatureCreateCommand command = new HyFeatureCreateCommand(editor.getModelWrapped().getWrappedFeature(child.getParent()), (DwGraphicalFeatureModelViewer)editor);
		return command;
	}	
}

