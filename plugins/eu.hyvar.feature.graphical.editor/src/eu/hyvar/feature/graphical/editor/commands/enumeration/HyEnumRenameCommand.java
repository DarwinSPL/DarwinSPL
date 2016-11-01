package eu.hyvar.feature.graphical.editor.commands.enumeration;

import org.eclipse.gef.commands.Command;

import eu.hyvar.dataValues.HyEnum;

public class HyEnumRenameCommand extends Command {
	private HyEnum enumeration;
	private String newName;
	private String oldName;
	
	public HyEnumRenameCommand(HyEnum enumeration){
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
