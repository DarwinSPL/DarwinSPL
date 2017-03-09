/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;


/**
 * atomic operation which add a feature type for a feature to a tfm
 */
public class AddFeatureType extends EvolutionOperation {

	private HyFeatureTypeEnum type;
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
				
		feature.getTypes().add(featureTyp);

	}

	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (featureTyp == null) {
			return;
		}
		feature.getTypes().remove(featureTyp);
		featureTyp = null;
	}
	
	//Getter
	public HyFeatureType getFeatureTyp() {
		return featureTyp;
	}

}
