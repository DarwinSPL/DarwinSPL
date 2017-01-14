/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import de.darwinspl.feature.evolution.atomic.operations.AddFeatureType;
import de.darwinspl.feature.evolution.atomic.operations.AddName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;



/**
 * Create a new feature object, but don't add it to the model, because the location depends on the situation. (added it to an existing or new group) 
 */
public class AddFeature extends ComplexOperation {
	
	private String name;
	private HyFeatureTypeEnum type;

	private static final HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;
	private HyFeature feature = factory.createHyFeature();
	
	public AddFeature(String name, HyFeatureTypeEnum type, Date timestamp) {
		
		this.name = name;
		this.type = type;
		this.timestamp = timestamp;
		
		//create objects of all operation which are used by this one and add them to the list
		AddName hyName = new AddName(name, feature, timestamp);		
		AddFeatureType hyFeatureType = new AddFeatureType(type, feature, timestamp);

		add(hyName);
		add(hyFeatureType);
		
	}
	
	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		//execute each atomic or complex operation which are used from this complex operation
		for (EvolutionOperation operation : evoOps) {
			operation.execute();
		}
		
		feature.setValidSince(timestamp);
		feature.setValidUntil(null);
		
	}

	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		
		//undo each atomic or complex operation which are used from this complex operation
		for (EvolutionOperation operation : evoOps) {
			operation.undo();
		}
		tfm.getFeatures().remove(feature);

	}
	
	/**
	 * To provide the creating feature for other operations.
	 * @return the created feature
	 */
	public HyFeature getFeature() {
		return this.feature;
	}

}
