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
	
	//Add all evolution operations for the extension
	
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
	
	/**
	 * On execute the operation will move a Feature from one group into another. The group, which are contains the feature before the evolution operation will still exist after the evolution.
	 * @param feature which should be move 
	 * @param groupComposition new group composition of the feature
	 * @param timestamp
	 */
	public void move(HyFeature feature, HyGroupComposition groupComposition, Date timestamp) {
		
		ComplexOperation moveFeature = new MoveFeature(feature, groupComposition, timestamp);
		evoOps.add(moveFeature);
		moveFeature.execute();
		commandHistory.add(counterOfExecuteCommands++, moveFeature);
	}
	
	/**
	 *  Move a feature from a group, which will still exist after the evolution, under a feature where no group exists or fit.
	 * @param feature which should be move 
	 * @param parent of the new group
	 * @param timestamp
	 * @param tfm the tfm is needed because a new group will be added.
	 */
	public void move(HyFeature feature, HyFeature parent, Date timestamp, HyFeatureModel tfm) {
		
		ComplexOperation moveFeatureAddGroup = new MoveFeatureAddGroup(feature, parent, timestamp, tfm);
		evoOps.add(moveFeatureAddGroup);
		moveFeatureAddGroup.execute();
		commandHistory.add(counterOfExecuteCommands++, moveFeatureAddGroup);
	}
	
	/**
	 * Move a feature from a group which will have no features in his composition after the evolution, to another group.
	 * @param feature which should be move 
	 * @param group which will be deleted
	 * @param groupComposition new groupComposition of the feature
	 * @param timestamp
	 */
	public void move(HyFeature feature, HyGroup group, HyGroupComposition groupComposition, Date timestamp) {
		
		ComplexOperation moveFeatureDeleteGroup = new MoveFeatureDeleteGroup(feature, group, groupComposition, timestamp);
		evoOps.add(moveFeatureDeleteGroup);
		moveFeatureDeleteGroup.execute();
		commandHistory.add(counterOfExecuteCommands++, moveFeatureDeleteGroup);
	}
	
	/**
	 * Move a feature from a group which will have no features in his composition after the evolution, under a feature where no group exists or fit.
	 * @param feature which should be move
	 * @param group which should be delete
	 * @param parent of the new group
	 * @param timestamp
	 * @param tfm
	 */
	public void move(HyFeature feature, HyGroup group, HyFeature parent, Date timestamp, HyFeatureModel tfm) {
		
		ComplexOperation moveFeatureDeleteAndAddGroup = new MoveFeatureDeleteAndAddGroup(feature, group, parent, timestamp, tfm);
		evoOps.add(moveFeatureDeleteAndAddGroup);
		moveFeatureDeleteAndAddGroup.execute();
		commandHistory.add(counterOfExecuteCommands++, moveFeatureDeleteAndAddGroup);
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
