/**
 * 
 */
package de.evolution.atomic.operations;

import java.util.Date;

//import java.util.Date;

import de.evolution.framework.EvolutionOperation;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;

/**
 *
 */
public class AddName implements EvolutionOperation {

	private String name;
	private HyFeature feature;
	protected Date timestamp;
	
	private static final HyEvolutionFactory factory = HyEvolutionFactory.eINSTANCE;
	
	public AddName(String name , HyFeature feature, Date timestamp) {
		this.name = name;
		this.feature = feature;
		this.timestamp = timestamp;
	}
	
	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {	
		
		HyName nameElement = factory.createHyName();
		nameElement.setName(name);
		nameElement.setValidSince(timestamp);
		nameElement.setValidUntil(null);
		
		feature.getNames().add(nameElement);
		
	}

	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}
