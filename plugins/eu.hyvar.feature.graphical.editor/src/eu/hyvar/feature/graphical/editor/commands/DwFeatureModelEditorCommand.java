package eu.hyvar.feature.graphical.editor.commands;

import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public class DwFeatureModelEditorCommand extends Command{

	protected DwGraphicalFeatureModelViewer viewer;
	
	public DwFeatureModelEditorCommand(DwGraphicalFeatureModelViewer viewer){
		this.viewer = viewer;
	}
}
