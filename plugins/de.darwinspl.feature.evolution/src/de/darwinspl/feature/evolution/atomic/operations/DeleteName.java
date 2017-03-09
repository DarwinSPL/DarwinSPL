/**
 * 
 */
package de.darwinspl.feature.evolution.atomic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.evolution.HyName;

/**
 * atomic operation which delete a name from a tfm
 */
public class DeleteName extends EvolutionOperation {

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
		//check if the execute method was executed, otherwise leave this method
		if (name.getValidUntil().compareTo(timestamp) != 0) {
			return;
		}
		name.setValidUntil(null);
	}
	
	//Getter	
	public HyName getName() {
		return name;
	}

}
