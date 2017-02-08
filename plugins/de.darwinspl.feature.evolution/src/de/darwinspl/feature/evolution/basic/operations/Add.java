/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;

/**
 *
 */
public class Add extends ComplexOperation {

	private String name;
	private HyFeatureTypeEnum type;
	private HyFeature parent;
	private HyGroup group;
	
	public Add(String name, HyFeatureTypeEnum type, HyFeature parent, HyGroup group, Date timestamp, HyFeatureModel tfm) {
		
		this.name = name;
		this.type = type;
		this.parent = parent;
		this.group = group;
		this.timestamp = timestamp;
		this.tfm = tfm;
		
	}
	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#execute()
	 */
	@Override
	public void execute() {
		
		/*call the needed basic op add(iG) or add(wG). If the group is null, the user hasn't a group which 
		* the feature should be added. Therefore add(wG) is needed, otherwise the feature will be add 
		* into the delivered group.
		*/
		if (group == null) {
			AddFeatureWithGroup addFeatureWithGroup = new AddFeatureWithGroup(name, type, parent, timestamp, tfm);
			addToComposition(addFeatureWithGroup);
		} else {
			AddFeatureInGroup addFeatureInGroup = new AddFeatureInGroup(name, type, group, timestamp, tfm);
			addToComposition(addFeatureInGroup);
		}
		
		for (EvolutionOperation evolutionOperation : evoOps) {
			evolutionOperation.execute();
		}

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}
