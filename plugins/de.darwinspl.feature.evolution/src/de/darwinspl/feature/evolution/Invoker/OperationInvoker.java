/**
 * 
 */
package de.darwinspl.feature.evolution.Invoker;

import java.util.ArrayList;
import java.util.Date;

import de.darwinspl.feature.evolution.basic.operations.*;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupTypeEnum;

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
		if (counterOfExecuteCommands > 0) {
			commandHistory.get(counterOfExecuteCommands--).undo();
			//remove the last undo operation from the history. (Clean up of history)
			commandHistory.remove(counterOfExecuteCommands + 1);
		}
	}
	
	/**
	 * provide add(wG) operation as command for the extension
	 * @param name of the new feature
	 * @param type of the new feature
	 * @param timestamp since the feature is valid
	 * @param tfm the corresponding model
	 * @return the tfm with the new feature
	 */
	public HyFeatureModel addFeature(String name, HyFeatureTypeEnum type, HyFeature parent, Date timestamp, HyFeatureModel tfm) {
		
		ComplexOperation addFeatureWithGroup = new AddFeatureWithGroup(name, type, parent, timestamp, tfm);
		evoOps.add(addFeatureWithGroup);
		addFeatureWithGroup.execute();
		//add the operation as next command in the history
		commandHistory.add(counterOfExecuteCommands++, addFeatureWithGroup);
		
		return tfm;
	}
	
	/**
	 * provide add(iG) operation as command for the extension
	 * @param name of the new feature
	 * @param type of the new feature
	 * @param group in which the feature should be added
	 * @param timestamp since the feature is valid
	 * @param tfm the corresponding model
	 * @return the tfm with the new feature
	 */
	public HyFeatureModel addFeature(String name, HyFeatureTypeEnum type, HyGroup group, Date timestamp, HyFeatureModel tfm) {
		
		ComplexOperation addFeatureInGroup = new AddFeatureInGroup(name, type, group, timestamp, tfm);
		evoOps.add(addFeatureInGroup);
		addFeatureInGroup.execute();
		commandHistory.add(counterOfExecuteCommands++, addFeatureInGroup);
		
		return tfm;
	}
	
	/**
	 * Delete a valid feature from a group, where the group are still existing after the remove of the feature
	 * @param feature
	 * @param timestamp
	 */
	public void deleteFeature(HyFeature feature, Date timestamp) {
		
		ComplexOperation deleteFeatureInGroup = new DeleteFeatureInGroup(feature, timestamp);
		evoOps.add(deleteFeatureInGroup);
		deleteFeatureInGroup.execute();
		commandHistory.add(counterOfExecuteCommands++, deleteFeatureInGroup);
	}
	
	/**
	 * Delete a valid feature and the group of the feature
	 * @param feature
	 * @param group
	 * @param timestamp
	 */
	public void deleteFeature(HyFeature feature, HyGroup group, Date timestamp) {
		
		ComplexOperation deleteFeatureWithGroup = new DeleteFeatureWithGroup(feature,group, timestamp);
		evoOps.add(deleteFeatureWithGroup);
		deleteFeatureWithGroup.execute();
		commandHistory.add(counterOfExecuteCommands++, deleteFeatureWithGroup);
	}
	
	/**
	 * rename a feature
	 * @param feature
	 * @param name
	 * @param timestamp
	 */
	public void rename(HyFeature feature, String name, Date timestamp) {
		
		ComplexOperation rename = new Rename(feature, name, timestamp);
		evoOps.add(rename);
		rename.execute();
		commandHistory.add(counterOfExecuteCommands++, rename);
	}
	
	/**
	 * changeType from a feature
	 * @param feature
	 * @param type
	 * @param timestamp
	 */
	public void changeType(HyFeature feature, HyFeatureTypeEnum type, Date timestamp) {
		
		ComplexOperation changeFeatureType = new ChangeFeatureType(feature, type, timestamp);
		evoOps.add(changeFeatureType);
		changeFeatureType.execute();
		commandHistory.add(counterOfExecuteCommands++, changeFeatureType);
	}
	
	/**
	 * changeType from a group
	 * @param group
	 * @param type
	 * @param timestamp
	 */
	public void changeType(HyGroup group, HyGroupTypeEnum type, Date timestamp) {
		
		ComplexOperation changeGroupType = new ChangeGroupType(group, type, timestamp);
		evoOps.add(changeGroupType);
		changeGroupType.execute();
		commandHistory.add(counterOfExecuteCommands++, changeGroupType);
	}
}
