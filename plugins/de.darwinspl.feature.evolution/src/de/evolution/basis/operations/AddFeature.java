/**
 * 
 */
package de.evolution.basis.operations;

import java.util.Date;

import de.evolution.atomic.operations.AddFeatureType;
import de.evolution.atomic.operations.AddName;
import de.evolution.framework.ComplexeOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;



/**
 *
 */
public class AddFeature extends ComplexeOperation {

	private String name;
	private HyFeatureTypeEnum type;

	private static final HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;
	
	public AddFeature(String name, HyFeatureTypeEnum type, Date timestamp, HyFeatureModel tfm) {
		this.name = name;
		this.type = type;
		this.timestamp = timestamp;
		this.tfm = tfm;
	}
	
	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		HyFeature feature = factory.createHyFeature();
		
		AddName hyName = new AddName(name, feature, timestamp);
		
		AddFeatureType hyFeatureType = new AddFeatureType(type, feature, timestamp);
		
		feature.setValidSince(timestamp);
		feature.setValidUntil(null);
		
		tfm.getFeatures().add(feature);

	}

	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}
