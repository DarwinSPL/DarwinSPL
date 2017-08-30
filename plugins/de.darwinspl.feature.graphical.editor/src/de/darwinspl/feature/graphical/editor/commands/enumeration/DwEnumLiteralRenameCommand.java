package de.darwinspl.feature.graphical.editor.commands.enumeration;

import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.dataValues.HyEnumLiteral;

public class DwEnumLiteralRenameCommand extends Command {
	private HyEnumLiteral literal;
	private String newName;
	private String oldName;
	
	DwGraphicalFeatureModelViewer editor;
	
	public DwEnumLiteralRenameCommand(HyEnumLiteral literal, DwGraphicalFeatureModelViewer editor) {
		this.editor = editor;
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
	
	@Override
	public boolean canExecute() {
		return editor.isLastDateSelected();
	}
}