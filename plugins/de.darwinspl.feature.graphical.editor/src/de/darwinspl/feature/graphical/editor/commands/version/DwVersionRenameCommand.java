package de.darwinspl.feature.graphical.editor.commands.version;

import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.HyVersion;

public class DwVersionRenameCommand extends Command{
	private String oldNumber;
	private String newNumber;

	private HyVersion version;

	public DwVersionRenameCommand(HyVersion version){
		this.version = version;
	}

	@Override 
	public void execute(){
		redo();
	}
	
	/**
	 * Undo renaming the feature.
	 */
	@Override
	public void undo() {
		version.setNumber(oldNumber);
	}

	@Override
	public void redo() {
		oldNumber = version.getNumber();
		version.setNumber(newNumber);
	}
	
	public void setNewNumber(String newNumber) {
		this.newNumber = newNumber;
	}
}
