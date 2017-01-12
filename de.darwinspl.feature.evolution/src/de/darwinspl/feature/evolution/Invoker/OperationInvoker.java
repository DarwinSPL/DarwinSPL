/**
 * 
 */
package de.darwinspl.feature.evolution.Invoker;

import java.util.ArrayList;
import java.util.Date;

import de.darwinspl.feature.evolution.basis.operations.ComplexeOperation;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import de.darwinspl.feature.evolution.basis.operations.*;

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
		if (counterOfExecuteCommands > 0)
			commandHistory.get(counterOfExecuteCommands--).undo();
	}
	
	/**
	 * execute the last undo command, to recover the old state.
	 */
	/*public void redo() {
		commandHistory.get(++counterOfExecuteCommands).execute();
	}*/
	
	/**
	 * provide addFeature operation as command for use
	 * @param name of the new feature
	 * @param type of the new feature
	 * @param timestamp since the feature is valid
	 * @param tfm the corresponding model
	 */
	public HyFeatureModel AddFeature(String name, HyFeatureTypeEnum type, Date timestamp, HyFeatureModel tfm) {
		
		ComplexeOperation addFeature = new AddFeature(name, type, timestamp, tfm);
		evoOps.add(addFeature);
		addFeature.execute();
		//add the operation as next command in the history
		commandHistory.add(++counterOfExecuteCommands, addFeature);
		
		return tfm;
	}
	
}
