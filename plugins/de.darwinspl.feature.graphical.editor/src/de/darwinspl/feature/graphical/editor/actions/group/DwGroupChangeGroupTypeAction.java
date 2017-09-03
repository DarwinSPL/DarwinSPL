package de.darwinspl.feature.graphical.editor.actions.group;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwGroupEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwParentChildConnectionEditPart;
import de.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import de.darwinspl.feature.graphical.editor.commands.group.DwGroupChangeGroupTypeCommand;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupTypeEnum;

public abstract class DwGroupChangeGroupTypeAction extends SelectionAction{
	protected DwGraphicalFeatureModelViewer editor;

	protected Request request;

	private DwGroupChangeGroupTypeCommand command;

	public DwGroupChangeGroupTypeAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);

		this.editor = editor;
	}

	/**
	 * Collects the groups of all selected editparts in order to change the group type
	 * @return
	 */
	protected List<HyGroup> getGroupOfSelectedEditparts(){
		List<HyGroup> groups = new ArrayList<HyGroup>();

		for(Object o : getSelectedObjects()){

			if(o instanceof DwGroupEditPart){
				DwGroupEditPart editpart = (DwGroupEditPart)o;

				groups.add(((DwGroupWrapped)editpart.getModel()).getWrappedModelElement());
			}

			if(o instanceof DwParentChildConnectionEditPart){
				DwParentChildConnectionEditPart editpart = (DwParentChildConnectionEditPart)o;

				groups.add(((DwParentChildConnection)editpart.getModel()).getComposition().getCompositionOf());
			}
		}		

		return groups;
	}

	@Override
	protected boolean calculateEnabled() {
		if(!editor.isLastDateSelected())
			return false;
		
		for(Object o : getSelectedObjects()){
			if(!(o instanceof DwGroupEditPart || o instanceof DwParentChildConnectionEditPart))
				return false;
			
			if(o instanceof DwGroupEditPart) {
				DwGroupEditPart groupEditPart = (DwGroupEditPart)o;
				DwGroupWrapped groupWrapped = (DwGroupWrapped)groupEditPart.getModel();
				
				HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(groupWrapped.getWrappedModelElement().getParentOf(), editor.getCurrentSelectedDate());

				if(composition.getFeatures().size() < 2)
					return false;
			}
			
			if(o instanceof DwParentChildConnectionEditPart) {
				DwParentChildConnectionEditPart connectionEditPart = (DwParentChildConnectionEditPart)o;
				DwParentChildConnection connection = (DwParentChildConnection)connectionEditPart.getModel();
								
				if(HyEvolutionUtil.getValidTemporalElement(connection.getTarget().getWrappedModelElement().getGroupMembership(), editor.getCurrentSelectedDate()).getFeatures().size() < 2)
					return false;
			}
		}	
		
		

		return true;
	}

	public abstract HyGroupTypeEnum getNewGroupType();

	@Override
	public void run(){
		for(HyGroup group : getGroupOfSelectedEditparts()){
			command = new DwGroupChangeGroupTypeCommand(group, getNewGroupType(), editor);

			editor.executeCommand(command);
		}		
	}
}
