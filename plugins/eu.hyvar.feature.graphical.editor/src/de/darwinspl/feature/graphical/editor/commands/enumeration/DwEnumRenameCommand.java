package de.darwinspl.feature.graphical.editor.commands.enumeration;

import org.eclipse.gef.commands.Command;

import eu.hyvar.dataValues.HyEnum;

public class DwEnumRenameCommand extends Command {
	private HyEnum enumeration;
	private String newName;
	private String oldName;
	
	public DwEnumRenameCommand(HyEnum enumeration){
		this.enumeration = enumeration;
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
	
	public void setNewName(String newName) {
		this.newName = newName;
	}
}
