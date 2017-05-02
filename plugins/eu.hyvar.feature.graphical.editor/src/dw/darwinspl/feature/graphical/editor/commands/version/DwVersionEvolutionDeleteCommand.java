package dw.darwinspl.feature.graphical.editor.commands.version;

import java.util.Date;

import org.eclipse.gef.commands.Command;

import dw.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;
import eu.hyvar.feature.HyVersion;

public class DwVersionEvolutionDeleteCommand extends Command{
	private DwGraphicalFeatureModelEditor editor;
	private HyVersion version;
	
	public DwGraphicalFeatureModelEditor getEditor() {
		return editor;
	}

	public void setEditor(DwGraphicalFeatureModelEditor editor) {
		this.editor = editor;
	}
		
	public HyVersion getVersion() {
		return version;
	}

	public void setVersion(HyVersion version) {
		this.version = version;
	}

	public DwVersionEvolutionDeleteCommand(DwGraphicalFeatureModelEditor editor) {
		this.editor = editor;
	}
	
	private void deleteVersionAndChildrenTemporarily(HyVersion version){
		Date date = editor.getCurrentSelectedDate();
		
		version.setValidUntil(date);
		for(HyVersion child : version.getSupersedingVersions()){
			child.setValidUntil(date);
			
			deleteVersionAndChildrenTemporarily(child);
		}
	}

	
	@Override
	public void execute(){
		deleteVersionAndChildrenTemporarily(version);
		
		editor.getModelWrapped().getWrappedFeature(version.getFeature()).getListeners().firePropertyChange("versions", 0, 1);
		
		editor.getModelWrapped().rearrangeFeatures();
		editor.refreshView();
	}
}
