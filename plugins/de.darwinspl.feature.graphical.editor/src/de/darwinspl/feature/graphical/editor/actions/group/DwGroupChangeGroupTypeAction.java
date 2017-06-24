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
import eu.hyvar.feature.HyGroup;
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
		for(Object o : getSelectedObjects()){
			if(!(o instanceof DwGroupEditPart || o instanceof DwParentChildConnectionEditPart))
				return false;
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
