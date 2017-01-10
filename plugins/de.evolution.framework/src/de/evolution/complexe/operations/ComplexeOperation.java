/**
 * 
 */
package de.evolution.complexe.operations;

import java.util.ArrayList;

import de.evolution.framework.EvolutionOperation;

/**
 *
 */
public class ComplexeOperation implements EvolutionOperation {
	
	public String name;
	private ArrayList<EvolutionOperation> evoOps = new ArrayList<EvolutionOperation>();

	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#execute()
	 */
	@Override
	public void execute() {
		
		for (EvolutionOperation operation : evoOps) {
			/* TODO: 
			 * 1. allocation of information(needed parameter) to the specific operations
			 * 2. check the receiving parameters with the needed one of the operations
			 */
			operation.execute();
		}
	}

	/* (non-Javadoc)
	 * @see de.evolution.framework.EvolutionOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 
	 * @param operation: Atomic or basis operation which should add to the complexe operation
	 */
	public void add(EvolutionOperation operation) {
		evoOps.add(operation);
	}

	/**
	 * 
	 * @param operation: Atomic or basis operation which should remove to the complexe operation
	 */
	public void remove(EvolutionOperation operation) {
		evoOps.remove(operation);
	}
	/**
	 * Get the name of the complexe evolution operations
	 * @return the name of the complexe evolution operation
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the complexe evolution operations
	 * @param name: Name of the complexe evolution operation
	 */
	public void setName(String name) {
		this.name = name;
	}
}
