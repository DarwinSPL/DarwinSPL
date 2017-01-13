/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.atomic.operations.AddGroupType;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupType;

/**
 *
 */
public class AddGroup extends ComplexOperation {

	private HyGroupType type;
	private Date timestamp;
	private HyFeatureModel tfm;
	private HyGroup group;
	
	private static final HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;
	
	public AddGroup(HyGroupType type, Date timestamp, HyFeatureModel tfm) {
		
		this.type = type;
		this.timestamp = timestamp;
		this.tfm = tfm;
		
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		group = factory.createHyGroup();

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}
