package dw.darwinspl.feature.graphical.editor.actions.group;

import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.editparts.DwGroupEditPart;
import dw.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import dw.darwinspl.feature.graphical.editor.commands.group.DwGroupChangeGroupTypeCommand;
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


	@Override
	protected boolean calculateEnabled() {
		for(Object o : getSelectedObjects()){
			if(!(o instanceof DwGroupEditPart))
				return false;
		}		
		
		return true;
	}
	
	public abstract HyGroupTypeEnum getNewGroupType();
	
	@Override
	public void run(){
		for(Object o : getSelectedObjects()){
			DwGroupEditPart editpart = (DwGroupEditPart)o;
			HyGroup group = ((DwGroupWrapped)editpart.getModel()).getWrappedModelElement();
			
			command = new DwGroupChangeGroupTypeCommand(group, getNewGroupType(), editor);

			editor.executeCommand(command);
		}		
	}
}
