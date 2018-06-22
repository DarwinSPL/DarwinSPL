package de.darwinspl.feature.graphical.editor.commands.feature;

import java.util.ArrayList;
import java.util.List;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.editor.commands.DwFeatureModelEditorCommand;
import eu.hyvar.context.HyContextModel;

public class DwContextReferenceChangeCommand extends DwFeatureModelEditorCommand {

	private List<HyContextModel> newContextModels;
	private List<HyContextModel> oldContextModels;
	
	public DwContextReferenceChangeCommand(DwGraphicalFeatureModelViewer viewer) {
		super(viewer);
	}
	
	public void setNewContextModels(List<HyContextModel> newContextModels) {
		this.newContextModels = newContextModels;
	}
	
	public void redo(){
		if(newContextModels == null) {
			return;
		}
		
		oldContextModels = new ArrayList<HyContextModel>();
		oldContextModels.addAll(viewer.getInternalFeatureModel().getContexts());
		
		viewer.getInternalFeatureModel().getContexts().clear();
		viewer.getInternalFeatureModel().getContexts().addAll(newContextModels);
	}
	
	public void undo(){
		if(oldContextModels == null) {
			return;
		}
		
		viewer.getInternalFeatureModel().getContexts().clear();
		viewer.getInternalFeatureModel().getContexts().addAll(oldContextModels);
	}
	
	@Override
	public void execute(){
		redo();
	}

}
