package eu.hyvar.feature.graphical.editor.commands.feature;

import java.util.Date;
import java.util.List;

import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.commands.DwLinearTemporalElementCommand;
import eu.hyvar.feature.graphical.editor.editor.HyGraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.editor.util.HyElementEditorUtil;

public class HyFeatureRenameCommand extends DwLinearTemporalElementCommand {
	private HyName oldName;
	private HyName newName;
	private Date changeDate;

	private HyFeatureWrapped feature;
	private HyGraphicalFeatureModelEditor editor;

	public HyFeatureRenameCommand(HyFeatureWrapped feature, HyGraphicalFeatureModelEditor editor){
		this.feature = feature;
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
		List<HyName> names = feature.getWrappedModelElement().getNames();
		removeElementFromLinkedList(newName);
		names.remove(newName);
		
		if(!names.contains(oldName))
			names.add(oldName);
	}

	@Override
	public void redo() {
		changeDate = editor.getCurrentSelectedDate();

		oldName =  HyEvolutionUtil.getValidTemporalElement(feature.getWrappedModelElement().getNames(), changeDate);
		if(changeDate.equals(new Date(Long.MIN_VALUE))){
			feature.getWrappedModelElement().getNames().remove(oldName);
		}else{
			changeVisibilities(oldName, newName, changeDate);
		}
		
		
		feature.getWrappedModelElement().getNames().add(newName);
		
		HyElementEditorUtil.cleanNames(feature.getWrappedModelElement());
	}
	
	public void setNewName(String newName) {
		this.newName = HyEvolutionFactory.eINSTANCE.createHyName();
		this.newName.setName(newName);
	}
}
