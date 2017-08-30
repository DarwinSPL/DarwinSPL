package de.darwinspl.feature.graphical.editor.commands.attribute;


import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.editor.dialogs.DwNumberAttributeRangeDialog;
import eu.hyvar.feature.HyNumberAttribute;

public class DwNumberAttributeSetNumberRangeCommand  extends Command {
	private HyNumberAttribute attribute;
	private DwGraphicalFeatureModelViewer editor;
	
	private int oldMinimum;
	private int oldMaximum;
	
	public DwNumberAttributeSetNumberRangeCommand(HyNumberAttribute attribute, DwGraphicalFeatureModelViewer editor){
		this.attribute = attribute;
		this.editor = editor;
	}
	
	@Override
	public void execute(){
		redo();
	}
	
	@Override
	public boolean canExecute() {
		return editor.isLastDateSelected();
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
		
		DwNumberAttributeRangeDialog dialog = new DwNumberAttributeRangeDialog(editor.getSite().getShell());
		dialog.setElement(attribute);
		dialog.open();
		
		if(dialog.getReturnCode() == 0){
			attribute.setMin(dialog.getMinimum());
			attribute.setMax(dialog.getMaximum());
		}
	}
}
