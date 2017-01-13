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
 *
 */
public class AddFeature extends ComplexOperation {

	// TODO du nutzt gar nicht @evoOps von ComplexeOperation
	
	private String name;
	private HyFeatureTypeEnum type;
	
	private HyFeature feature = factory.createHyFeature();

	private static final HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;
	
	public AddFeature(String name, HyFeatureTypeEnum type, Date timestamp, HyFeatureModel tfm) {
		
		this.name = name;
		this.type = type;
		this.timestamp = timestamp;
		this.tfm = tfm;
		
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
		
		tfm.getFeatures().add(feature);
		// TODO: und wo ist dieses feature dann im Baum? Es muss ja entweder in irgendeiner Gruppe sein oder das Root Feature sein.
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

}
