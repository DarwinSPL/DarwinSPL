package eu.hyvar.feature.graphical.editor.commands;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.editor.util.HyElementEditorUtil;

public class HyGroupChangeGroupTypeCommand extends HyLinearTemporalElementCommand{
	private HyGroup group;
	private HyGroupTypeEnum newGroupTypeEnum;
	private HyGraphicalFeatureModelViewer editor;
	
	HyGroupType newType;
	HyGroupType oldType;
	HyGroupType changedType;
	
	public HyGroupChangeGroupTypeCommand(HyGroup group, HyGroupTypeEnum newGroupTypeEnum, HyGraphicalFeatureModelViewer editor){
		this.group = group;
		this.newGroupTypeEnum = newGroupTypeEnum;
		this.editor = editor;
	}
	
	@Override
	public void execute(){
		redo();
	}
	
	/**
	 * TODO undo not working properly. Example case: the group type was changed at since == Long.MIN_VALUE then the preccessor type
	 * was deleted due to invalid date(since == until == null/Long.MIN_VALUE). Therefore the old type has to be added again to the
	 * group 
	 */
	@Override
	public void undo() {	
		for(HyGroupType type : group.getTypes()){
			if(EcoreUtil.equals(type, newType)){
				changedType.setValidUntil(oldType.getValidUntil());
			}
		}
		
		group.getTypes().remove(newType);	
	}

	@Override
	public void redo() {
		Date date = editor.getCurrentSelectedDate();
		
		HyGroupType type = HyEvolutionUtil.getValidTemporalElement(group.getTypes(), date);
		changedType = type;
		oldType = EcoreUtil.copy(type);
		newType = HyFeatureFactory.eINSTANCE.createHyGroupType();
		newType.setType(newGroupTypeEnum);
		
		if(date.equals(new Date(Long.MIN_VALUE)))
			date = null;
		
		changeVisibilities(type, newType, date);

		

		group.getTypes().add(newType);
		if(date == null){
			group.getTypes().remove(type);
		}
		
		HyElementEditorUtil.cleanGroupTypes(group);
	}
}
