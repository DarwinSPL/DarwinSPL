package dw.darwinspl.feature.graphical.editor.commands.attribute;

import java.util.Date;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.editor.commands.DwLinearTemporalElementCommand;
import dw.darwinspl.feature.graphical.editor.util.DwElementEditorUtil;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeatureAttribute;

public class DwAttributeRenameCommand extends DwLinearTemporalElementCommand {
	private HyName oldName;
	private HyName newName;
	private Date changeDate;

	private HyFeatureAttribute attribute;
	private DwGraphicalFeatureModelViewer editor;

	public DwAttributeRenameCommand(HyFeatureAttribute attribute, DwGraphicalFeatureModelViewer editor){
		this.attribute = attribute;
		this.editor = editor;
	}

	@Override 
	public void execute(){
		redo();
	}

	/**
	 * Undo renaming the feature.
	 */
	@Override
	public void undo() {
		removeElementFromLinkedList(newName);
		attribute.getNames().remove(newName);
	}

	@Override
	public void redo() {
		changeDate = editor.getCurrentSelectedDate();

		oldName =  HyEvolutionUtil.getValidTemporalElement(attribute.getNames(), changeDate);

		if(changeDate.equals(new Date(Long.MIN_VALUE))){
			changeDate = null;
			attribute.getNames().remove(oldName);
		}
		
		changeVisibilities(oldName, newName, changeDate);
		attribute.getNames().add(newName);		
		
		DwElementEditorUtil.cleanNames(attribute);
	}
	
	public void setNewName(String newName) {
		this.newName = HyEvolutionFactory.eINSTANCE.createHyName();
		this.newName.setName(newName);
	}
}
