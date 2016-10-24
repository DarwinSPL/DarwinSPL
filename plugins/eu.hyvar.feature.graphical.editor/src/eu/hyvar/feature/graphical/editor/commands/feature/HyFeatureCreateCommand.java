package eu.hyvar.feature.graphical.editor.commands.feature;


import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;

public class HyFeatureCreateCommand extends Command {

	private HyFeatureWrapped newFeature;
	private HyFeatureModelWrapped parent;
	
	public HyFeatureModelWrapped getParent() {
		return parent;
	}

	public void setParent(HyFeatureModelWrapped parent) {
		this.parent = parent;
	}

	public HyFeatureWrapped getNewFeature() {
		return newFeature;
	}

	public void setNewFeature(HyFeatureWrapped newFeature) {
		this.newFeature = newFeature;
	}

	
	@Override public void execute(){
		if(parent instanceof HyFeatureModelWrapped){
			((HyFeatureModelWrapped)parent).addFeature(newFeature);
		}
	}
}
