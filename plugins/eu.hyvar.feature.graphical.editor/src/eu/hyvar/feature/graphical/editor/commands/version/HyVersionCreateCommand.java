package eu.hyvar.feature.graphical.editor.commands.version;

import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version.HyVersionUtil;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public class HyVersionCreateCommand  extends Command {
	private HyVersion version;
	private Object parentObject;
	
	private boolean wireAndAddAfter;
	private boolean useSameBranch;
	
	private GraphicalFeatureModelEditor editor;
	
	public HyVersionCreateCommand(HyVersion version, Object parentObject, GraphicalFeatureModelEditor editor)  {
		this.version = version;
		this.parentObject = parentObject;
		this.editor = editor;
	}
	

	
	@Override
	public void execute() {
		
		if (parentObject instanceof HyFeature) {
			HyFeature parentFeature = (HyFeature) parentObject;
			addToParentFeature(parentFeature);
		}
		
		if (parentObject instanceof HyVersion) {
			version.setSupersededVersion((HyVersion)parentObject);
			((HyVersion)parentObject).getSupersedingVersions().add(version);
		}
		
		editor.getModelWrapped().rearrangeFeatures();
		editor.refreshView();
	}

	@Override
	public void undo() {
		HyVersionUtil.unwireAndRemoveVersion(version);
	}
	
	protected void addToParentFeature(HyFeature parentFeature) {
		HyVersion selectedVersion = HyVersionUtil.getLastVersionOnMostRecentBranch(parentFeature);
		doAddToParentFeature(parentFeature, selectedVersion);
	}
	
	protected void addToParentVersion(HyVersion parentVersion) {
		HyFeature parentFeature = parentVersion.getFeature();
		doAddToParentFeature(parentFeature, parentVersion);
	}

	protected void doAddToParentFeature(HyFeature parentFeature, HyVersion selectedVersion) {
		if (selectedVersion == null) {
			HyVersionUtil.wireVersionAsRoot(version, parentFeature);
		} else {
			if (wireAndAddAfter) {
				if (useSameBranch) {
					HyVersionUtil.wireVersionAfter(version, selectedVersion);
				} else {
					HyVersionUtil.wireVersionAfterOnNewBranch(version, selectedVersion);
				}
			} else {
				if (useSameBranch) {
					HyVersionUtil.wireVersionBefore(version, selectedVersion);
				} else {
					HyVersionUtil.wireVersionBefore(version, selectedVersion, true);
				}
			}
		}
		
		HyVersionUtil.addVersion(version, parentFeature);
	}
}
