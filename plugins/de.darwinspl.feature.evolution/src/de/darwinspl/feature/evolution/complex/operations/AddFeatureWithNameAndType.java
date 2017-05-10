/**
 * 
 */
package de.darwinspl.feature.evolution.complex.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.atomic.operations.AddFeature;
import de.darwinspl.feature.evolution.atomic.operations.AddFeatureType;
import de.darwinspl.feature.evolution.atomic.operations.AddName;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;


/**
 * Add a new feature with name and type
 */
public class AddFeatureWithNameAndType extends ComplexOperation {
	
	private String featureName;
	private HyName name;
	private HyFeatureTypeEnum type;
	private HyFeatureType featureType;
	private HyFeature feature;
	
	private HyFeatureModel tfm;
	
	public AddFeatureWithNameAndType(String name, HyFeatureTypeEnum type, Date timestamp, HyFeatureModel tfm) {
		
		this.featureName = name;
		this.type = type;
		this.timestamp = timestamp;
		this.tfm = tfm;
		
	}
	
	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		AddFeature addFeature = new AddFeature(timestamp, tfm);
		//The add feature atomic op must be execute, because the next operations are need the feature which will be create. 
		addFeature.execute();
		feature = addFeature.getFeature();
		
		//create objects of all operation which are used by this one and add them to the list
		AddName addName = new AddName(featureName, feature, timestamp);		
		AddFeatureType addFeatureType = new AddFeatureType(type, feature, timestamp);

		addToComposition(addName);
		addToComposition(addFeatureType);
		
		//execute each atomic or complex operation which are used from this complex operation
		for (EvolutionOperation operation : evoOps) {
			operation.execute();
		}
		name = addName.getName();
		featureType = addFeatureType.getFeatureTyp();
		
		//after the execution of all evolution operations, the addFeature evolution op should be add to the evoOp list, in case of the undo.
		addToComposition(addFeature);
		
	}

	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (feature == null) {
			return;
		}
		
		//undo each atomic or complex operation which are used from this complex operation
		for (EvolutionOperation operation : evoOps) {
			operation.undo();
		}
		name = null;
		featureType = null;
		feature = null;

		//remove each evo op to avoid that on a redo the evoOps list will contain the same evo op twice
		for (EvolutionOperation evolutionOperation : evoOps) {
			removeFromComposition(evolutionOperation);
			if (evoOps.size() == 0) {
				break;
			}
		}
	}
	
	/**
	 * To provide the creating feature for other operations.
	 * @return the created feature
	 */
	public HyFeature getFeature() {
		return this.feature;
	}

	public HyName getName() {
		return name;
	}

	public HyFeatureType getFeatureType() {
		return featureType;
	}

}
