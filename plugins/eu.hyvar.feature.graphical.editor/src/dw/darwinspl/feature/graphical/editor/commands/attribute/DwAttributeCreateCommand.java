package dw.darwinspl.feature.graphical.editor.commands.attribute;

import java.util.Date;

import org.eclipse.gef.commands.Command;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;

public class DwAttributeCreateCommand extends Command {
	private HyFeature feature;
	private HyFeatureAttribute attribute;
	private DwGraphicalFeatureModelViewer editor;
	
	public DwAttributeCreateCommand(HyFeature feature, HyFeatureAttribute attribute, DwGraphicalFeatureModelViewer editor){
		this.feature = feature;
		this.attribute = attribute;
		this.editor = editor;
	}
	
	@Override
	public void execute(){
		redo();
	}
	
	@Override
	public void undo() {	
		feature.getAttributes().remove(attribute);	
	}

	@Override
	public void redo() {
		// cancel redo if attribute is null
		if(attribute == null) return;
		
		Date date = editor.getCurrentSelectedDate();
		
		if(date.equals(new Date(Long.MIN_VALUE))){
			attribute.setValidSince(null);
		}else{
			attribute.setValidSince(date);
		}
		
		
		feature.getAttributes().add(attribute);
	}
}
