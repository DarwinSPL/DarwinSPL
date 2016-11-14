package eu.hyvar.feature.graphical.editor.commands.feature;

import java.util.Date;

import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.commands.HyLinearTemporalElementCommand;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;

public class HyFeatureEvolutionRenameCommand extends HyLinearTemporalElementCommand {
	private HyName oldName;
	private HyName newName;
	private Date changeDate;

	private HyFeatureWrapped feature;
	private GraphicalEvolutionFeatureModelEditor editor;

	public HyFeatureEvolutionRenameCommand(HyFeatureWrapped feature, GraphicalEvolutionFeatureModelEditor editor){
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
		removeElementFromLinkedList(newName);
		feature.getWrappedModelElement().getNames().remove(newName);
	}

	@Override
	public void redo() {
		changeDate = editor.getCurrentSelectedDate();

		oldName =  HyEvolutionUtil.getValidTemporalElement(feature.getWrappedModelElement().getNames(), changeDate);
		
		changeVisibilities(oldName, newName, changeDate);
		feature.getWrappedModelElement().getNames().add(newName);
	}
	
	public void setNewName(String newName) {
		this.newName = HyEvolutionFactory.eINSTANCE.createHyName();
		this.newName.setName(newName);
	}
}
