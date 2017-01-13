/**
 * 
 */
package de.darwinspl.feature.evolution.basis.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.atomic.operations.AddFeatureType;
import de.darwinspl.feature.evolution.atomic.operations.AddName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;



/**
 *
 */
public class AddFeature extends ComplexeOperation {

	// TODO du nutzt gar nicht @evoOps von ComplexeOperation
	// TODO: complex wird ohne e am Ende geschrieben
	// TODO: package name: basis = die Basis, der Stuetzpunkt. basic = grundlegende Basis.
	
	private String name;
	private HyFeatureTypeEnum type;
	
	private HyFeature feature;
	private AddName hyName;
	private AddFeatureType hyFeatureType;

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
		
		feature = factory.createHyFeature();
		
		hyName = new AddName(name, feature, timestamp);
		
		hyFeatureType = new AddFeatureType(type, feature, timestamp);
		
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
		// TODO Auto-generated method stub
		hyName.undo();
		hyFeatureType.undo();
		tfm.getFeatures().remove(feature);

	}

}
