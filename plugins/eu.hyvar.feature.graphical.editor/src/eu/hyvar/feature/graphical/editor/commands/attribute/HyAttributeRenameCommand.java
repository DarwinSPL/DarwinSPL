package eu.hyvar.feature.graphical.editor.commands.attribute;

import java.util.Date;

import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.editor.commands.HyLinearTemporalElementCommand;
import eu.hyvar.feature.graphical.editor.util.HyElementEditorUtil;

public class HyAttributeRenameCommand extends HyLinearTemporalElementCommand {
	private HyName oldName;
	private HyName newName;
	private Date changeDate;

	private HyFeatureAttribute attribute;
	private GraphicalFeatureModelEditor editor;

	public HyAttributeRenameCommand(HyFeatureAttribute attribute, GraphicalFeatureModelEditor editor){
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
			attribute.getNames().remove(oldName);
		}
		
		changeVisibilities(oldName, newName, changeDate);
		attribute.getNames().add(newName);		
		
		HyElementEditorUtil.cleanNames(attribute);
	}
	
	public void setNewName(String newName) {
		this.newName = HyEvolutionFactory.eINSTANCE.createHyName();
		this.newName.setName(newName);
	}
}
