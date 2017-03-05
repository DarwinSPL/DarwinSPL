/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.atomic.operations.AddFeatureType;
import de.darwinspl.feature.evolution.atomic.operations.DeleteFeatureType;
import de.darwinspl.feature.evolution.complex.operations.ComplexOperation;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;

/**
 * Basic evolution operation which change the type of a feature
 */
public class ChangeFeatureType extends ComplexOperation {

	private HyFeature feature;
	private HyFeatureTypeEnum type;
	
	private HyFeatureType oldFeatureType, newFeatureType;
	
	public ChangeFeatureType(HyFeature feature, HyFeatureTypeEnum type, Date timestamp) {
		
		this.feature = feature;
		this.type = type;
		this.timestamp = timestamp;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		//get the valid featureType object
		for (HyFeatureType featureType : feature.getTypes()) {
			if (featureType.getValidUntil() == null) {
				this.oldFeatureType = featureType;
				break;
			}
		}

		DeleteFeatureType deleteFeatureType = new DeleteFeatureType(oldFeatureType, timestamp);
		AddFeatureType addFeatureType = new AddFeatureType(type, feature, timestamp);
		
		addToComposition(deleteFeatureType);
		addToComposition(addFeatureType);
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
		}
		
		newFeatureType = addFeatureType.getFeatureTyp();
	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (newFeatureType == null) {
			return;
		}
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.undo();
		}
		
		oldFeatureType = null;
		newFeatureType = null;

		//remove each evo op to avoid that on a redo the evoOps list will contain the same evo op twice
		for (EvolutionOperation evolutionOperation : evoOps) {
			removeFromComposition(evolutionOperation);
			if (evoOps.size() == 0) {
				break;
			}
		}
	}
	
	//Getter
	public HyFeature getFeature() {
		return feature;
	}
	public HyFeatureType getOldFeatureType() {
		return oldFeatureType;
	}
	public HyFeatureType getNewFeatureType() {
		return newFeatureType;
	}

}
