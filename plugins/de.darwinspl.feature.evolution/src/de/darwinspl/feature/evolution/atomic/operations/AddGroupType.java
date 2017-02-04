/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;

/**
 *
 */
public class AddGroupType implements EvolutionOperation {

	private HyGroupTypeEnum type;
	private Date timestamp;
	private HyGroup group;
	private HyGroupType groupTyp;
	

	private static final HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;
	
	public AddGroupType(HyGroupTypeEnum type, HyGroup group, Date timestamp) {
		
		this.type = type;
		this.group = group;
		this.timestamp = timestamp;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		groupTyp = factory.createHyGroupType();
		
		groupTyp.setType(type);
		groupTyp.setValidSince(timestamp);
		groupTyp.setValidUntil(null);
				
		group.getTypes().add(groupTyp);

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		//check if the execute method was executed, otherwise leave this method
		if (groupTyp == null) {
			return;
		}
		group.getTypes().remove(groupTyp);
		groupTyp = null;

	}
	public HyGroup getGroup() {
		return group;
	}
	public HyGroupType getGroupTyp() {
		return groupTyp;
	}

}
