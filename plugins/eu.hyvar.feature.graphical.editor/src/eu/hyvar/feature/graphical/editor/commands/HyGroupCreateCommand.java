package eu.hyvar.feature.graphical.editor.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;

public class HyGroupCreateCommand extends Command {

	private HyGroup newGroup;
	public HyGroup getNewGroup() {
		return newGroup;
	}

	public void setNewGroup(HyGroup newGroup) {
		this.newGroup = newGroup;
	}

	private EObject parent;


	public EObject getParent() {
		return parent;
	}

	public void setParent(EObject parent) {
		this.parent = parent;
	}


	Point position;

	@Override public void execute(){
		if(parent instanceof HyFeatureModel){
			((HyFeatureModel)parent).getGroups().add(newGroup);
		}

		if(parent instanceof HyFeature){
			HyFeature feature = (HyFeature)parent;
			EList<HyFeatureChild> childs = feature.getParentOf();


			// empty compositions, add a composition to add the feature

			HyFeatureChild child = HyFeatureFactory.eINSTANCE.createHyFeatureChild();
			child.setChildGroup(newGroup);
			childs.add(child);

			childs.get(childs.size()-1).setChildGroup(newGroup);
		}
	}
}