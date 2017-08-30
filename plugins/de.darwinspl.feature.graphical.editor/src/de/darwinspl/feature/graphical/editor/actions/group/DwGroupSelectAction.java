package de.darwinspl.feature.graphical.editor.actions.group;

import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwParentChildConnectionEditPart;

public class DwGroupSelectAction extends SelectionAction{
	public static final String SELECT_GROUP = "SelectGroup";
	
	public DwGroupSelectAction(IWorkbenchPart part) {
		super(part);

		setId(SELECT_GROUP);
		setText("Select Group");
		
	}


	protected DwGraphicalFeatureModelViewer editor;

	@Override
	protected boolean calculateEnabled() {
		if(!editor.isLastDateSelected())
			return false;
		
		for(Object o : getSelectedObjects()){
			if(!(o instanceof DwParentChildConnectionEditPart))
				return false;
		}		

		return true;
	}
	
	@Override
	public void run() {
		for(Object o : getSelectedObjects()){
			DwParentChildConnectionEditPart connection = (DwParentChildConnectionEditPart)o;
			

		}		
		getSelectedObjects().clear();
	}

}
