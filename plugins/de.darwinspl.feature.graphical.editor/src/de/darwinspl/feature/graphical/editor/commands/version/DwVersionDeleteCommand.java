package de.darwinspl.feature.graphical.editor.commands.version;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.MessageDialog;

import eu.hyvar.feature.HyVersion;

public class DwVersionDeleteCommand extends Command {
	private HyVersion version;

	public HyVersion getVersion() {
		return version;
	}
	public void setVersion(HyVersion version) {
		this.version = version;
	}

	private void removeAllChildren(HyVersion parent){

		for(HyVersion child : parent.getSupersedingVersions()){

			child.getFeature().getVersions().remove(child);

			removeAllChildren(child);
		}

		parent.getSupersedingVersions().clear();
	}


	@Override
	public void execute(){
		boolean hasChildren = version.getSupersedingVersions().size() > 0;
		MessageDialog dialog = null;
		if(version.getSupersedingVersions().size() > 0){
			dialog = new MessageDialog(null, "What do you want to do?", null,
					"The version you want to delete has children. You have the following options:\n"
							+ "Delete Children:\tThis will delete the selected version with all its children\n"
							+ "Keep Children:\tDelete the selected version all its children will be added to the parent version of the selected version.\n\n"
							+ "Deleting will remove the version(s) in all variants of the FM.", MessageDialog.QUESTION, new String[] { "Delete Children",
									"Keep Children", "Cancel" }, 0);
		}else{
			dialog = new MessageDialog(null, "What do you want to do?", null,
					"Deleting will permantly remove the version(s) in all variants of the FM. Do you really want to delete it?", MessageDialog.QUESTION, new String[] { 
							"Permanently Delete Version", "Cancel" }, 0);
		}

		int result = dialog.open();
		if(result != -1){
			if(hasChildren){
				if(result == 0){
					removeAllChildren(version);
					version.getFeature().getVersions().remove(version);
					version.getSupersededVersion().getSupersedingVersions().remove(version);
				}else if(result == 1){

					HyVersion parent = version.getSupersededVersion();

					version.getFeature().getVersions().remove(version);
					version.getSupersededVersion().getSupersedingVersions().remove(version);
					for(HyVersion child : version.getSupersedingVersions()){
						int count = parent.getSupersedingVersions().size();
						for(HyVersion parentChilds : parent.getSupersedingVersions()){
							if(parentChilds.getNumber().equals(child.getNumber())){
								child.setNumber("C"+count);
							}
						}
						parent.getSupersedingVersions().add(child);
						child.setSupersededVersion(parent);
					}

				}
			}else{
				if(result == 0){
					version.getFeature().getVersions().remove(version);
				}
			}
		}
	}
}
