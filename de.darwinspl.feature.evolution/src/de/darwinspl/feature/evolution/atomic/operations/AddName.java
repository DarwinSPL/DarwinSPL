/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
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
	private HyName nameElement;
	
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
		
		nameElement = factory.createHyName();
		nameElement.setName(name);
		nameElement.setValidSince(timestamp);
		nameElement.setValidUntil(null);
		
		//Get the latest name of the feature, if it exists, and set the until variable
		if (!feature.getNames().isEmpty()) {
			HyName oldName = feature.getNames().get(feature.getNames().size() - 1);
			oldName.setValidUntil(timestamp);
		}
				
		feature.getNames().add(nameElement);
		
	}

	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		feature.getNames().remove(nameElement);
		
		if (!feature.getNames().isEmpty()) {
			HyName oldName = feature.getNames().get(feature.getNames().size() - 1);
			oldName.setValidUntil(null);
		}

	}

}
