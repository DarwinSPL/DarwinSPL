package dw.darwinspl.feature.graphical.editor.commands.enumeration;

import org.eclipse.gef.commands.Command;

import eu.hyvar.dataValues.HyEnumLiteral;

public class DwEnumLiteralRenameCommand extends Command {
	private HyEnumLiteral literal;
	private String newName;
	private String oldName;
	
	public DwEnumLiteralRenameCommand(HyEnumLiteral literal){
		this.literal = literal;
	}
	
	@Override 
	public void execute(){
		redo();
	}

	@Override
	public void undo() {
		literal.setName(oldName);
	}

	@Override
	public void redo() {
		oldName = literal.getName();
		literal.setName(newName);
	}
	
	public void setNewName(String newName) {
		this.newName = newName;
	}
}