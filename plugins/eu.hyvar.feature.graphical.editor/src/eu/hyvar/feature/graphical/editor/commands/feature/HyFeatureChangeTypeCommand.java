package eu.hyvar.feature.graphical.editor.commands.feature;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public class HyFeatureChangeTypeCommand extends Command{
	private HyFeature feature;
	private HyFeatureTypeEnum newGroupTypeEnum;
	private GraphicalFeatureModelEditor editor;
	
	HyFeatureType newType;
	HyFeatureType oldType;
	HyFeatureType changedType;
	
	public HyFeatureChangeTypeCommand(HyFeature feature, HyFeatureTypeEnum newFeatureTypeEnum, GraphicalFeatureModelEditor editor){
		this.feature = feature;
		this.newGroupTypeEnum = newFeatureTypeEnum;
		this.editor = editor;
	}
	
	@Override
	public void execute(){
		redo();
	}
	
	@Override
	public void undo() {	
		for(HyFeatureType type : feature.getTypes()){
			if(EcoreUtil.equals(type, newType)){
				changedType.setValidUntil(oldType.getValidUntil());
			}
		}
		
		feature.getTypes().remove(newType);	
	}

	@Override
	public void redo() {
		Date date = editor.getCurrentSelectedDate();
		
		HyFeatureType type = HyEvolutionUtil.getValidTemporalElement(feature.getTypes(), date);
		changedType = type;
		oldType = EcoreUtil.copy(type);
		newType = HyFeatureFactory.eINSTANCE.createHyFeatureType();
		newType.setType(newGroupTypeEnum);
		newType.setValidSince(date);
		type.setValidUntil(date);
		
		
		feature.getTypes().add(newType);
	}
}