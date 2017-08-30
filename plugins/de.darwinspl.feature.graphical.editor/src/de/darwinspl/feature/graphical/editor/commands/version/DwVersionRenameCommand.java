package de.darwinspl.feature.graphical.editor.commands.version;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.editor.commands.DwFeatureModelEditorCommand;
import eu.hyvar.feature.HyVersion;

public class DwVersionRenameCommand extends DwFeatureModelEditorCommand{
	private String oldNumber;
	private String newNumber;

	private HyVersion version;

	public DwVersionRenameCommand(HyVersion version, DwGraphicalFeatureModelViewer viewer){
		super(viewer);
		
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
	
	
	@Override
	public boolean canExecute() {
		return viewer.isLastDateSelected();
	}
}
