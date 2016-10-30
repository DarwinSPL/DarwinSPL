package eu.hyvar.feature.graphical.editor.commands;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public class HyGroupChangeGroupTypeCommand extends Command{
	private HyGroup group;
	private HyGroupTypeEnum newGroupTypeEnum;
	private GraphicalFeatureModelEditor editor;
	
	HyGroupType newType;
	HyGroupType oldType;
	HyGroupType changedType;
	
	public HyGroupChangeGroupTypeCommand(HyGroup group, HyGroupTypeEnum newGroupTypeEnum, GraphicalFeatureModelEditor editor){
		this.group = group;
		this.newGroupTypeEnum = newGroupTypeEnum;
		this.editor = editor;
	}
	
	@Override
	public void execute(){
		redo();
	}
	
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
		newType.setValidSince(date);
		type.setValidUntil(date);
		
		group.getTypes().add(newType);
	}
}
