/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.atomic.operations.AddName;
import de.darwinspl.feature.evolution.atomic.operations.DeleteName;
import de.darwinspl.feature.evolution.complex.operations.ComplexOperation;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;

/**
 * Basic evolution operation which rename a feature.
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
				break;
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
		//check if the execute method was executed, otherwise leave this method
		if (newName == null) {
			return;
		}
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.undo();
		}
		oldName = null;
		newName = null;

		//remove each evo op to avoid that on a redo the evoOps list will contain the same evo op twice
		for (EvolutionOperation evolutionOperation : evoOps) {
			removeFromComposition(evolutionOperation);
			if (evoOps.size() == 0) {
				break;
			}
		}
	}
	
	//Getter
	public HyName getNewName() {
		return newName;
	}
	public HyFeature getFeature() {
		return feature;
	}

}
