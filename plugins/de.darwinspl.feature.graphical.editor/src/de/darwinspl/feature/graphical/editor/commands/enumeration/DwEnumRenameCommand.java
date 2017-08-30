package de.darwinspl.feature.graphical.editor.commands.enumeration;

import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;

public class DwEnumRenameCommand extends Command {
	private HyEnum enumeration;
	private String newName;
	private String oldName;
	
	DwGraphicalFeatureModelViewer editor;
	
	public DwEnumRenameCommand(HyEnum enumeration, DwGraphicalFeatureModelViewer editor) {
		this.enumeration = enumeration;
		
		this.editor = editor;
	}
	
	@Override 
	public void execute(){
		redo();
	}

	@Override
	public void undo() {
		enumeration.setName(oldName);
	}

	@Override
	public void redo() {
		oldName = enumeration.getName();
		enumeration.setName(newName);
	}
	
	@Override
	public boolean canExecute() {
		return editor.isLastDateSelected();
	}
	
	public void setNewName(String newName) {
		this.newName = newName;
	}
}
