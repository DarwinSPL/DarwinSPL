package eu.hyvar.feature.graphical.editor.commands.version;

import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version.HyVersionUtil;

public class HyVersionCreateCommand  extends Command {
	private HyVersion version;
	private Object parentObject;
	
	private boolean wireAndAddAfter;
	private boolean useSameBranch;
	
	public HyVersionCreateCommand(HyVersion version, Object parentObject)  {
		initialize(version, parentObject, true, true);
	}
	
	public HyVersionCreateCommand(HyVersion version, HyVersion parentVersion, boolean wireAndAddAfter) {
		initialize(version, parentVersion, wireAndAddAfter, true);
	}
	
	public HyVersionCreateCommand(HyVersion version, HyVersion parentVersion, boolean wireAndAddAfter, boolean useNewBranch) {
		initialize(version, parentVersion, wireAndAddAfter, useNewBranch);
	}
	
	private void initialize(HyVersion version, Object parentObject, boolean wireAndAddAfter, boolean useSameBranch) {
		this.version = version;
		this.parentObject = parentObject;
		this.wireAndAddAfter = wireAndAddAfter;
		this.useSameBranch = useSameBranch;
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
