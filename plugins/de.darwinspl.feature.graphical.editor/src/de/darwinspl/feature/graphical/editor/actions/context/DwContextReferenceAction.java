package de.darwinspl.feature.graphical.editor.actions.context;

import java.util.List;

import org.eclipse.gef.commands.Command;
//import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

import de.darwinspl.feature.graphical.editor.actions.DwCommandAction;
import de.darwinspl.feature.graphical.editor.commands.feature.DwContextReferenceChangeCommand;
import de.darwinspl.feature.graphical.editor.dialogs.DwContextReferenceDialog;
import de.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.feature.HyFeatureModel;

public class DwContextReferenceAction extends DwCommandAction {

	public static final String ID_CONTEXT_REFERENCE = "ModifyContextReference";
	protected static final String REQ_CONTEXT_REFERENCE = "ModifyContextReference";
	protected static final String TEXT_CONTEXT_REFERENCE = "Set context models";

	protected HyFeatureModel featureModel;
	
	private DwGraphicalFeatureModelEditor editor;
//	private Request request;
	
	public DwContextReferenceAction(DwGraphicalFeatureModelEditor editor) {
		super(editor);
		this.editor = editor;
		featureModel = editor.getModelWrapped().getModel();
		
		setId(ID_CONTEXT_REFERENCE);
		setText(TEXT_CONTEXT_REFERENCE);

//		request = new Request(REQ_CONTEXT_REFERENCE);
	}

	@Override
	protected boolean calculateEnabled() {
		return true;
	}

	@Override
	protected Command createCommand(Object acceptedModel) {
		Shell shell = this.getWorkbenchPart().getSite().getShell();
		
		DwContextReferenceDialog contextReferenceDialog = new DwContextReferenceDialog(shell, featureModel);
		
		int returnCode = contextReferenceDialog.open();
		if(returnCode == Dialog.OK) {
			List<HyContextModel> selectedContextModels = contextReferenceDialog.getSelectedContextModels();
			if(selectedContextModels != null) {
				DwContextReferenceChangeCommand command = new DwContextReferenceChangeCommand(editor);
				command.setNewContextModels(selectedContextModels);
				return command;
			}
		}
		else if(returnCode == Dialog.CANCEL) {
			// right now, nothing to do if cancelled.
		}
		
		return null;
	}

}
