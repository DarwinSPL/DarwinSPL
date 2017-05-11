package de.darwinspl.feature.graphical.editor.commands.feature;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;

import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.editor.commands.DwLinearTemporalElementCommand;
import de.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;
import de.darwinspl.feature.graphical.editor.util.DwElementEditorUtil;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.analyses.DwFeatureModelAnalyses;
import eu.hyvar.feature.analyses.DwFeatureModelAnalysesMarker;

public class DwFeatureRenameCommand extends DwLinearTemporalElementCommand {
	private HyName oldName;
	private HyName newName;
	private Date changeDate;

	private DwFeatureWrapped feature;
	private DwGraphicalFeatureModelEditor editor;

	public DwFeatureRenameCommand(DwFeatureWrapped feature, DwGraphicalFeatureModelEditor editor){
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
		
		editor.getModelWrapped().checkModelForErrors();
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
		
		DwElementEditorUtil.cleanNames(feature.getWrappedModelElement());
		
		editor.getModelWrapped().checkModelForErrors();
	}
	
	public void setNewName(String newName) {
		this.newName = HyEvolutionFactory.eINSTANCE.createHyName();
		this.newName.setName(newName);
	}
}