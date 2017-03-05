/**
 * 
 */
package de.darwinspl.feature.evolution.complex.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.atomic.operations.DeleteFeature;
import de.darwinspl.feature.evolution.atomic.operations.DeleteFeatureType;
import de.darwinspl.feature.evolution.atomic.operations.DeleteName;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureType;

/**
 * Delete a feature with his name and type.
 */
public class DeleteFeatureWithNameAndType extends ComplexOperation {

	private HyFeature feature;
	
	private HyFeatureType featureType;
	private HyName name;
	
	public DeleteFeatureWithNameAndType(HyFeature feature, Date timestamp) {
		
		this.feature = feature;
		this.timestamp = timestamp;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		//Iterate through the feature types and name list of the feature and find the element where no until is that. This element must by the current valid type or name
		for (HyFeatureType type : feature.getTypes()) {
			if (type.getValidUntil() == null) {
				featureType = type; 
				break;
			}
		}
		for (HyName name : feature.getNames()) {
			if (name.getValidUntil() == null) {
				this.name = name;
				break;
			}
		}
		
		DeleteName deleteName = new DeleteName(name, timestamp);
		DeleteFeatureType deleteFeatureType = new DeleteFeatureType(featureType, timestamp);
		DeleteFeature deleteFeature = new DeleteFeature(feature, timestamp);
		
		addToComposition(deleteName);
		addToComposition(deleteFeatureType);
		addToComposition(deleteFeature);
	
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
		}
		
		this.featureType = deleteFeatureType.getFeatureType();
		this.name = deleteName.getName();

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (feature.getValidUntil().compareTo(timestamp) != 0) {
			return;
		}
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.undo();
		}
		name = null;
		featureType = null;

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
	public HyFeatureType getFeatureType() {
		return featureType;
	}
	public HyName getName() {
		return name;
	}

}
