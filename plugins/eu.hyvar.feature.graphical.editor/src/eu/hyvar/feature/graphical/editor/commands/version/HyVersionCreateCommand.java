package eu.hyvar.feature.graphical.editor.commands.version;

import java.util.Date;

import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version.HyVersionUtil;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public class HyVersionCreateCommand  extends Command {
	private HyVersion version;
	
	private boolean wireAndAddAfter;
	private boolean useSameBranch;
	
	private GraphicalFeatureModelEditor editor;
	private Object parent; 
	
	public HyVersionCreateCommand(Object parent, GraphicalFeatureModelEditor editor)  {
		this.editor = editor;
		this.parent = parent;
	}
	

	
	@Override
	public void execute() {
		if (parent instanceof HyFeature) {
			Date date = editor.getCurrentSelectedDate();
			if(date.equals(new Date(Long.MIN_VALUE))){
				date = null;
			}		
			
			
			HyFeature parentAsFeature = (HyFeature)parent;
			version = HyFeatureFactory.eINSTANCE.createHyVersion();
			version.setNumber("V"+ (parentAsFeature.getVersions().size()));
			version.setFeature(parentAsFeature);
			version.setValidSince(date);
			parentAsFeature.getVersions().add(version);
		}
				
		
		

		/*
		if (parent instanceof HyFeature) {
			HyFeature parentFeature = (HyFeature) parentObject;
			addToParentFeature(parentFeature);
		}
		
		if (parent instanceof HyVersion) {
			version.setSupersededVersion((HyVersion)parentObject);
			((HyVersion)parent).getSupersedingVersions().add(version);
		}
		
		editor.getModelWrapped().rearrangeFeatures();
		editor.refreshView();
		*/
	}
	
	@Override
	public void undo() {
		version.getFeature().getVersions().remove(version);
	}
	
	

	/*
	@Override
	public void undo() {
		HyVersionUtil.unwireAndRemoveVersion(version);
	}
	*/
	
	protected void addToParentFeature(HyFeature parentFeature) {
		HyVersion selectedVersion = HyVersionUtil.getLastVersionOnMostRecentBranch(parentFeature);
		doAddToParentFeature(parentFeature, selectedVersion);
	}
	
	protected void addToParentVersion(HyVersion parentVersion) {
		HyFeature parentFeature = parentVersion.getFeature();
		doAddToParentFeature(parentFeature, parentVersion);
	}

	protected void doAddToParentFeature(HyFeature parentFeature, HyVersion selectedVersion) {
		Date date = editor.getCurrentSelectedDate();
		
		if (selectedVersion == null) {
			HyVersionUtil.wireVersionAsRoot(version, parentFeature, date);
		} else {
			if (wireAndAddAfter) {
				if (useSameBranch) {
					HyVersionUtil.wireVersionAfter(version, selectedVersion);
				} else {
					HyVersionUtil.wireVersionAfterOnNewBranch(version, selectedVersion);
				}
			} else {
				if (useSameBranch) {
					HyVersionUtil.wireVersionBefore(version, selectedVersion, date);
				} else {
					HyVersionUtil.wireVersionBefore(version, selectedVersion, true, date);
				}
			}
		}
		
		HyVersionUtil.addVersion(version, parentFeature, date);
	}
	
}
