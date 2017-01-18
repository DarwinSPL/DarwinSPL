/**
 * 
 */
package de.darwinspl.feature.evolution.Invoker;

import java.util.ArrayList;
import java.util.Date;

import de.darwinspl.feature.evolution.basic.operations.*;
import de.darwinspl.feature.evolution.operations.AddFeatureInGroup;
import de.darwinspl.feature.evolution.operations.AddFeatureWithGroup;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;

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
	public HyFeatureModel AddFeature(String name, HyFeatureTypeEnum type, HyFeature parent, Date timestamp, HyFeatureModel tfm) {
		
		ComplexOperation addFeatureWithGroup = new AddFeatureWithGroup(name, type, parent, timestamp, tfm);
		evoOps.add(addFeatureWithGroup);
		addFeatureWithGroup.execute();
		//add the operation as next command in the history
		commandHistory.add(++counterOfExecuteCommands, addFeatureWithGroup);
		
		return tfm;
	}
	
	public HyFeatureModel AddFeature(String name, HyFeatureTypeEnum type, HyGroup group, Date timestamp, HyFeatureModel tfm) {
		
		ComplexOperation addFeatureInGroup = new AddFeatureInGroup(name, type, group, timestamp, tfm);
		evoOps.add(addFeatureInGroup);
		addFeatureInGroup.execute();
		commandHistory.add(++counterOfExecuteCommands, addFeatureInGroup);
		
		return tfm;
	}
	
}
