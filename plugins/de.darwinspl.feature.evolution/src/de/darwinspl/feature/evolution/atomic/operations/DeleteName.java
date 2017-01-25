/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import eu.hyvar.evolution.HyName;

/**
 *
 */
public class DeleteName implements EvolutionOperation {

	private Date timestamp;
	private HyName name;


	public DeleteName(HyName name, Date timestamp) {
		
		this.name = name;
		this.timestamp = timestamp;
	}
	
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		name.setValidUntil(timestamp);
	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.Invoker.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}
	
		
	public HyName getName() {
		return name;
	}

}
