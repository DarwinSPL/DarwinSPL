/**
 * 
 */
package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;

/**
 *
 */
public class Move extends ComplexOperation {

	private HyFeature feature, parent;
	private HyGroup group;
	
	public Move(HyFeature feature, HyFeature parent, HyGroup group, Date timestamp, HyFeatureModel tfm) {
		
		this.feature = feature;
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
		

	}

	/* (non-Javadoc)
	 * @see de.darwinspl.feature.evolution.basic.operations.ComplexOperation#undo()
	 */
	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}
