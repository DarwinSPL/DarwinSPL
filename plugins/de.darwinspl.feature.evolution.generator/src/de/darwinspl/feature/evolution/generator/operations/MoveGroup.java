package de.darwinspl.feature.evolution.generator.operations;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyLinearTemporalElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyGroup;

public class MoveGroup implements EvolutionOperation {

	protected HyGroup groupToMove;
	protected HyFeature targetParent;
	protected Date date;
//	protected HyFeature oldParent;
	
	
	public MoveGroup(HyGroup groupToMove, HyFeature targetParent, Date date) {
		this.groupToMove = groupToMove;
		this.targetParent = targetParent;
		this.date = date;
	}
	
	@Override
	public void applyOperation() throws EvolutionOperationException {
		HyFeatureChild oldFeatureChild = HyEvolutionUtil.getValidTemporalElement(groupToMove.getChildOf(), date);
		oldFeatureChild.setValidUntil(date);
		
		HyFeatureChild newFeatureChild = HyFeatureFactory.eINSTANCE.createHyFeatureChild();
		newFeatureChild.setValidSince(date);
		newFeatureChild.setChildGroup(groupToMove);
		newFeatureChild.setParent(targetParent);
		
		
		if(oldFeatureChild.getValidSince().equals(oldFeatureChild.getValidUntil())) {
			HyLinearTemporalElement oldSupersededElement = oldFeatureChild.getSupersededElement();
			EcoreUtil.delete(oldFeatureChild);
			newFeatureChild.setSupersededElement(oldSupersededElement);
		}
		else {
			newFeatureChild.setSupersededElement(oldFeatureChild);			
		}
		
	}

}
