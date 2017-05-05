package eu.hyvar.feature.graphical.editor.commands.group;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.editor.commands.DwLinearTemporalElementCommand;
import eu.hyvar.feature.graphical.editor.util.HyElementEditorUtil;

public class HyGroupChangeGroupTypeCommand extends DwLinearTemporalElementCommand{
	private HyGroup group;
	private HyGroupTypeEnum newGroupTypeEnum;
	private DwGraphicalFeatureModelViewer editor;
	
	HyGroupType newType;
	HyGroupType oldType;
	HyGroupType changedType;
	
	HyGroup copy;
	
	public HyGroupChangeGroupTypeCommand(HyGroup group, HyGroupTypeEnum newGroupTypeEnum, DwGraphicalFeatureModelViewer editor){
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
		removeElementFromLinkedList(newType);
		
		// if the group type was changed at the first date, the old type is deleted. To overcome the missing type, the deleted group type, saved
		// in a local variable, is added again to the group lists.
		if(group.getTypes().size() == 1){
			group.getTypes().add(oldType);
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
		
		group.getTypes().add(newType);
		if(date == null){
			group.getTypes().remove(type);
		}else{
			changeVisibilities(type, newType, date);
		}
		
		HyElementEditorUtil.cleanGroupTypes(group);
	}
}
