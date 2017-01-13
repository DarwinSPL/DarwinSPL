/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;


/**
 *
 */
public class AddFeatureType implements EvolutionOperation {

	private HyFeatureTypeEnum type;
	private Date timestamp;
	private HyFeature feature;
	private HyFeatureType featureTyp;
	

	private static final HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;
	
	public AddFeatureType(HyFeatureTypeEnum type, HyFeature feature, Date timestamp) {
		
		this.type = type;
		this.timestamp = timestamp;
		this.feature = feature;
	}
	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		featureTyp = factory.createHyFeatureType();
		featureTyp.setType(type);
		featureTyp.setValidSince(timestamp);
		featureTyp.setValidUntil(null);
		
		//Get the latest featuretype of the feature, if it exists, and set the until variable
		if (!feature.getTypes().isEmpty()) {
			HyFeatureType oldFeatureType = feature.getTypes().get(feature.getTypes().size() - 1);	//Nicht zwingend der Fall
			oldFeatureType.setValidUntil(timestamp);
		}
		
		feature.getTypes().add(featureTyp);

	}

	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		feature.getTypes().remove(featureTyp);
		
		if (!feature.getTypes().isEmpty()) {
			HyFeatureType oldFeatureType = feature.getTypes().get(feature.getTypes().size() - 1);
			oldFeatureType.setValidUntil(null);
		}
	}

}
