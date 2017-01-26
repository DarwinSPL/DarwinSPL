/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.Invoker.EvolutionOperation;
import de.darwinspl.feature.evolution.atomic.operations.AddName;
import de.darwinspl.feature.evolution.atomic.operations.DeleteName;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;

/**
 *
 */
public class Rename extends ComplexOperation {


	private HyFeature feature;
	private String name;
	
	private HyName oldName;
	private HyName newName;
	
	
	public Rename(HyFeature feature, String name, Date timestamp) {
		
		this.feature = feature;
		this.name = name;
		this.timestamp = timestamp;
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		//get the valid name object
		for (HyName name : feature.getNames()) {
			if (name.getValidUntil() == null) {
				this.oldName = name;
			}
		}
		
		DeleteName deleteName = new DeleteName(oldName, timestamp);
		AddName addName = new AddName(name, feature, timestamp);
		
		addToComposition(deleteName);
		addToComposition(addName);
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
		}
		
		newName = addName.getName();
		
	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}
	
	//Getter
	public HyFeature getFeature() {
		return feature;
	}
	public HyName getOldName() {
		return oldName;
	}
	public HyName getNewName() {
		return newName;
	}

}
