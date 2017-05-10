package eu.hyvar.feature.graphical.editor.commands.version;

import java.util.Date;

import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public class HyVersionCreateSuccessorCommand extends Command {
	private DwGraphicalFeatureModelViewer editor;
	private HyVersion parentVersion;
	private HyVersion version;
	public HyVersionCreateSuccessorCommand(HyVersion version, DwGraphicalFeatureModelViewer editor)  {
		this.editor = editor;
		this.parentVersion = version;
	}

	@Override
	public void execute() {
		redo();
	}

	@Override
	public void undo() {
		parentVersion.getSupersedingVersions().remove(version);
		version.getFeature().getVersions().remove(version);
		
		
	}

	@Override
	public void redo() {
		Date date = editor.getCurrentSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE))){
			date = null;
		}		

		version = HyFeatureFactory.eINSTANCE.createHyVersion();
		version.setValidSince(date);
		version.setNumber("C"+parentVersion.getSupersedingVersions().size());

		parentVersion.getSupersedingVersions().add(version);
		version.setSupersededVersion(parentVersion);

		parentVersion.getFeature().getVersions().add(version);
		version.setFeature(parentVersion.getFeature());
	}
}
