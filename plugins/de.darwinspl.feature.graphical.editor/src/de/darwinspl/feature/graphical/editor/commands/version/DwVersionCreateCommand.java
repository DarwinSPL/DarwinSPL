package de.darwinspl.feature.graphical.editor.commands.version;

import java.util.Date;

import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.deltaecore.wrapper.layouter.version.DwVersionUtil;
import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyVersion;

public class DwVersionCreateCommand  extends Command {
	private HyVersion version;
	
	private boolean wireAndAddAfter;
	private boolean useSameBranch;
	
	private DwGraphicalFeatureModelViewer editor;
	private Object parent; 
	
	public DwVersionCreateCommand(Object parent, DwGraphicalFeatureModelViewer editor)  {
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
	}
	
	@Override
	public void undo() {
		version.getFeature().getVersions().remove(version);
	}
	
	
	protected void addToParentFeature(HyFeature parentFeature) {
		HyVersion selectedVersion = DwVersionUtil.getLastVersionOnMostRecentBranch(parentFeature);
		doAddToParentFeature(parentFeature, selectedVersion);
	}
	
	protected void addToParentVersion(HyVersion parentVersion) {
		HyFeature parentFeature = parentVersion.getFeature();
		doAddToParentFeature(parentFeature, parentVersion);
	}

	protected void doAddToParentFeature(HyFeature parentFeature, HyVersion selectedVersion) {
		Date date = editor.getCurrentSelectedDate();
		
		if (selectedVersion == null) {
			DwVersionUtil.wireVersionAsRoot(version, parentFeature, date);
		} else {
			if (wireAndAddAfter) {
				if (useSameBranch) {
					DwVersionUtil.wireVersionAfter(version, selectedVersion);
				} else {
					DwVersionUtil.wireVersionAfterOnNewBranch(version, selectedVersion);
				}
			} else {
				if (useSameBranch) {
					DwVersionUtil.wireVersionBefore(version, selectedVersion, date);
				} else {
					DwVersionUtil.wireVersionBefore(version, selectedVersion, true, date);
				}
			}
		}
		
		DwVersionUtil.addVersion(version, parentFeature, date);
	}
	
}
