package eu.hyvar.feature.graphical.editor.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ContainerEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;

public class HyFeatureContainerPolicy extends ContainerEditPolicy {

	public HyFeatureContainerPolicy(HyFeatureModelWrapped featureModel,
			GraphicalEvolutionFeatureModelEditor editor) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}
