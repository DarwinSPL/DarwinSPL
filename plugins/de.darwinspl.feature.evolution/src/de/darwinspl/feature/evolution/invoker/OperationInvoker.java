/**
 * 
 */
package de.darwinspl.feature.evolution.invoker;

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
	
	//Add all evolution operations for the extension
	
	/**
	 * provide add operation as command for the extension
	 * @param name of the new feature
	 * @param type of the new feature
	 * @param parent is needed, when the new feature will be add in a new group
	 * @param group is needed, if the feature should be add in an existing group, otherwise it must be null
	 * @param timestamp since the feature is valid
	 * @param tfm the corresponding model
	 * @return the tfm with the new feature
	 */
	public HyFeatureModel addFeature(String name, HyFeatureTypeEnum type, HyFeature parent, HyGroup group, Date timestamp, HyFeatureModel tfm) {
		
		ComplexOperation addFeature = new Add(name, type, parent, group, timestamp, tfm);
		evoOps.add(addFeature);
		addFeature.execute();
		//add the operation as next command in the history
		commandHistory.add(counterOfExecuteCommands++, addFeature);
		
		return tfm;
	}
	
	/**
	 * Delete a valid feature.
	 * @param feature
	 * @param timestamp
	 */
	public void deleteFeature(HyFeature feature, Date timestamp) {
		
		ComplexOperation deleteFeature = new Delete(feature, timestamp);
		evoOps.add(deleteFeature);
		deleteFeature.execute();
		commandHistory.add(counterOfExecuteCommands++, deleteFeature);
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
	
	/**
	 * On execute the operation will move a Feature from one group into another. 
	 * @param feature which should be move 
	 * @param parent of the new feature
	 * @param group if the feature should be moved in an existing group, the group must be delivered, otherwise it's null
	 * @param timestamp
	 */
	public void move(HyFeature feature, HyFeature parent, HyGroup group, Date timestamp, HyFeatureModel tfm) {
		
		ComplexOperation moveFeature = new Move(feature, parent, group, timestamp, tfm);
		evoOps.add(moveFeature);
		moveFeature.execute();
		commandHistory.add(counterOfExecuteCommands++, moveFeature);
		
	}
	
	
	/**
	 * Move a group.
	 * @param group which should be move
	 * @param parent the new parent of the group
	 * @param timestamp
	 */
	public void move(HyGroup group, HyFeature parent, Date timestamp) {
		
		ComplexOperation moveGroup = new MoveGroup(group, parent, timestamp);
		evoOps.add(moveGroup);
		moveGroup.execute();
		commandHistory.add(counterOfExecuteCommands++, moveGroup);
	}
}
