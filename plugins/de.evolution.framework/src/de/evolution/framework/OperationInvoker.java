/**
 * 
 */
package de.evolution.framework;

import java.util.ArrayList;

/**
 * Get request from the editor and invoke the corresponding evoOp to execute the command.
 */
public class OperationInvoker {

	//Catalog of all existing evoOps
	protected ArrayList<EvolutionOperation> evoOps = new ArrayList<>();
	
	private ArrayList<EvolutionOperation> commandHistory = new ArrayList<>();
	private int counterOfExecuteCommands = 0;
	
	/**
	 * undo the last command and decrease the counter of execute commands.
	 */
	public void undo() {
		commandHistory.get(counterOfExecuteCommands--).undo();
	}
	
	/**
	 * execute the last undo command, to recover the old state.
	 */
	public void redo() {
		commandHistory.get(++counterOfExecuteCommands).execute();
	}
	
	/**
	 * execute a evolution operation and added it to the history
	 * @param position: position of the evoOp in the operation catalog
	 */
	public void executeCommand(int position) {	//TODO: delivery of the informations from the editor to the evoOp
		evoOps.get(position).execute();
		commandHistory.add(++counterOfExecuteCommands, evoOps.get(position));
	}
		
	/**
	 * Add a new evoOp to the catalog
	 * @param evoOp which should add to the catalog
	 */
	public void addOperation(EvolutionOperation evoOp) {		
		evoOps.add(evoOp);
	}
	
}
