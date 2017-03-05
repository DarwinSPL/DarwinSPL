package eu.hyvar.feature.graphical.editor.commands.attribute;

import java.util.Date;

import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;

public class HyAttributeCreateCommand extends Command {
	private HyFeature feature;
	private HyFeatureAttribute attribute;
	private HyGraphicalFeatureModelViewer editor;
	
	public HyAttributeCreateCommand(HyFeature feature, HyFeatureAttribute attribute, HyGraphicalFeatureModelViewer editor){
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
