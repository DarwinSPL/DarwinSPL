/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;

/**
 * atomic operation which add a name for a feature to a tfm
 */
public class AddName implements EvolutionOperation {

	private String featureName;
	private HyFeature feature;
	private Date timestamp;
	private HyName name;
	
	private static final HyEvolutionFactory factory = HyEvolutionFactory.eINSTANCE;
	
	public AddName(String name , HyFeature feature, Date timestamp) {
		this.featureName = name;
		this.feature = feature;
		this.timestamp = timestamp;
	}
	
	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {	
		
		name = factory.createHyName();
		name.setName(featureName);
		name.setValidSince(timestamp);
		name.setValidUntil(null);
						
		feature.getNames().add(name);
		
	}

	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (name == null) {
			return;
		}
		feature.getNames().remove(name);
		name = null;

	}

	//Getter
	public HyName getName() {
		return name;
	}

}
