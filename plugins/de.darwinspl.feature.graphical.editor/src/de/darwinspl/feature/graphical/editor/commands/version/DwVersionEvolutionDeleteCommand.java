package de.darwinspl.feature.graphical.editor.commands.version;

import java.util.Date;

import org.eclipse.gef.EditPart;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwVersionEditPart;
import de.darwinspl.feature.graphical.editor.commands.DwFeatureModelEditorCommand;
import de.darwinspl.feature.graphical.editor.util.DwEcoreUtil;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyVersion;

public class DwVersionEvolutionDeleteCommand extends DwFeatureModelEditorCommand{
	private HyVersion version;
	private HyVersion oldVersion;
	
	private EditPart host;
	

	public HyVersion getVersion() {
		return version;
	}

	public void setVersion(HyVersion version) {
		this.version = version;
	}

	public DwVersionEvolutionDeleteCommand(DwGraphicalFeatureModelViewer viewer, EditPart host) {
		super(viewer);
		
		this.host = host;
	}

	@Override
	public boolean canExecute() {
		Date date = viewer.getCurrentSelectedDate();
		
		boolean correctElement = (host instanceof DwVersionEditPart);

		if(correctElement){
			HyVersion version = (HyVersion)((DwVersionEditPart)host).getModel();
			
			return HyEvolutionUtil.getValidTemporalElements(version.getSupersedingVersions(), date).isEmpty();
			
		}

		return false;
	}


	
	@Override
	public void execute(){
		redo();
	}
	
	private void removePermanentlyFromFeature(HyFeature feature){
		int index = -1;
		for(int i = 0; i<feature.getVersions().size(); i++){
			if(feature.getVersions().get(i).getId().equals(version.getId())){
				index = i;
			}
		}
		
		if(index != -1){
			
			feature.getVersions().remove(index);
			
			// has parent version
			if(version.getSupersededVersion() != null){
				version.setSupersededVersion(null);
			}
		}		
	}
	
	@Override
	public void redo(){
		Date date = viewer.getCurrentSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE)))
			date = null;
		
		// save a copy to the feature with dummy references to all related elements
		oldVersion = DwEcoreUtil.copy(version);
		
		// save a copy to parent version
		if(version.getSupersededVersion() != null)
			oldVersion.setSupersededVersion(DwEcoreUtil.copy(version.getSupersededVersion()));
		
		HyFeature feature = version.getFeature();
		
		if(date == null){
			removePermanentlyFromFeature(feature);
		}else{
			version.setValidUntil(date);
		}	
		

		oldVersion.setFeature(DwEcoreUtil.copy(feature));
		
		//featureWrapped.getListeners().firePropertyChange("versions", 0, 1);
		
		viewer.getModelWrapped().rearrangeFeatures();
		viewer.refreshView();
		
		host.setSelected(0);
	}
	
	@Override
	public void undo(){
		Date date = viewer.getCurrentSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE)))
			date = null;
		
		if(date == null){
			HyFeature containmentFeature = oldVersion.getFeature();
			
			for(HyFeature feature : viewer.getModelWrapped().getModel().getFeatures()){
				if(containmentFeature.getId().equals(feature.getId())){

					if(oldVersion.getSupersededVersion() != null){
						for(HyVersion version : feature.getVersions()){
							if(version.getId().equals(oldVersion.getSupersededVersion().getId())){
								oldVersion.setSupersededVersion(version);
							}
						}
					}
					
					oldVersion.setFeature(feature);
					feature.getVersions().add(oldVersion);
					
					version = oldVersion;
				}
			}
		}else{
			version.setValidUntil(oldVersion.getValidUntil());
		}
		
		viewer.getModelWrapped().rearrangeFeatures();
		viewer.refreshView();
	}
}
