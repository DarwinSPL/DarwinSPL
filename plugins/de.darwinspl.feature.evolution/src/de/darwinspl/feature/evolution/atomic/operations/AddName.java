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

	private String featureName;
	private HyFeature feature;
	protected Date timestamp;
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
		// TODO Auto-generated method stub
		feature.getNames().remove(name);
		
		if (!feature.getNames().isEmpty()) {
			HyName oldName = feature.getNames().get(feature.getNames().size() - 1);
			oldName.setValidUntil(null);
		}

	}

	//Getter
	public HyFeature getFeature() {
		return feature;
	}

	public HyName getName() {
		return name;
	}

}
