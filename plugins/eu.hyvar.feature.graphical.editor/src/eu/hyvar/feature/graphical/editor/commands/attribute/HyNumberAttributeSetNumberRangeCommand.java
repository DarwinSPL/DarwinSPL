package eu.hyvar.feature.graphical.editor.commands.attribute;


import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.editor.dialogs.HyNumberAttributeRangeDialog;

public class HyNumberAttributeSetNumberRangeCommand  extends Command {
	private HyNumberAttribute attribute;
	private GraphicalFeatureModelEditor editor;
	
	private int oldMinimum;
	private int oldMaximum;
	
	public HyNumberAttributeSetNumberRangeCommand(HyNumberAttribute attribute, GraphicalFeatureModelEditor editor){
		this.attribute = attribute;
		this.editor = editor;
	}
	
	@Override
	public void execute(){
		redo();
	}
	
	@Override
	public void undo() {
		attribute.setMin(oldMinimum);
		attribute.setMax(oldMaximum);
	}

	@Override
	public void redo() {
		oldMinimum = attribute.getMin();
		oldMaximum = attribute.getMax();
		
		HyNumberAttributeRangeDialog dialog = new HyNumberAttributeRangeDialog(editor.getSite().getShell());
		dialog.setElement(attribute);
		dialog.open();
		
		if(dialog.getReturnCode() == 0){
			attribute.setMin(dialog.getMinimum());
			attribute.setMax(dialog.getMaximum());
		}
	}
}
