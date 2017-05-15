package de.darwinspl.feature.graphical.editor.commands;

import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public class DwFeatureModelEditorCommand extends Command{

	protected DwGraphicalFeatureModelViewer viewer;
	
	public DwFeatureModelEditorCommand(DwGraphicalFeatureModelViewer viewer){
		this.viewer = viewer;
	}
}
