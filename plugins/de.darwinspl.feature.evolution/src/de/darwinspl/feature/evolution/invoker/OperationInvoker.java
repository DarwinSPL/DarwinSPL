/**
 * 
 */
package de.darwinspl.feature.evolution.invoker;

import java.util.ArrayList;
import java.util.Date;

import de.darwinspl.feature.evolution.basic.operations.*;
import de.darwinspl.feature.evolution.complex.operations.ComplexOperation;
import de.darwinspl.feature.evolution.complex.operations.MergeKeepCode;
import de.darwinspl.feature.evolution.complex.operations.Split;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupTypeEnum;

/**
 * Get request from the editor and invoke the corresponding evoOp to execute the command.
 */
public class OperationInvoker {
	
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
	 */
	public void add(String name, HyFeatureTypeEnum type, HyFeature parent, HyGroup group, Date timestamp, HyFeatureModel tfm) {
		
		ComplexOperation addFeature = new Add(name, type, parent, group, timestamp, tfm);
		addFeature.execute();
		//add the operation as next command in the history
		commandHistory.add(counterOfExecuteCommands++, addFeature);
		
	}
	
	/**
	 * Delete a valid feature.
	 * @param feature
	 * @param timestamp
	 */
	public void delete(HyFeature feature, Date timestamp) {
		
		ComplexOperation deleteFeature = new Delete(feature, timestamp);
		deleteFeature.execute();
		//add the operation as next command in the history
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
		rename.execute();
		//add the operation as next command in the history
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
		changeFeatureType.execute();
		//add the operation as next command in the history
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
		changeGroupType.execute();
		//add the operation as next command in the history
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
		moveFeature.execute();
		//add the operation as next command in the history
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
		moveGroup.execute();
		//add the operation as next command in the history
		commandHistory.add(counterOfExecuteCommands++, moveGroup);
	}
	
	/**
	 * Split a feature into two features. 
	 * @param feature which should be split
	 * @param name1: new name of the first feature
	 * @param name2: new name of the second feature
	 * @param timestamp
	 * @param tfm
	 */
	public void split(HyFeature feature, String name1, String name2, Date timestamp, HyFeatureModel tfm) {
		
		ComplexOperation split = new Split(feature, name1, name2, timestamp, tfm);
		split.execute();
		//add the operation as next command in the history
		commandHistory.add(counterOfExecuteCommands++, split);
	}
	
	/**
	 * merge a feature into another.
	 * @param deleteFeature: Feature which should be removed
	 * @param targetFeature: target feature of the merge.
	 * @param timestamp
	 */
	public void merge(HyFeature deleteFeature, HyFeature targetFeature, Date timestamp){
		
		ComplexOperation merge = new MergeKeepCode(deleteFeature, targetFeature, timestamp);
		merge.execute();
		commandHistory.add(counterOfExecuteCommands++, merge);
	}
}
