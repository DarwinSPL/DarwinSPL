package eu.hyvar.feature.graphical.editor.policies.version;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.editor.commands.version.HyVersionEvolutionDeleteCommand;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;

public class HyVersionComponentPolicy extends ComponentEditPolicy {
	private GraphicalEvolutionFeatureModelEditor editor;
	protected HyFeatureModelWrapped featureModel;

	public HyVersionComponentPolicy(GraphicalEvolutionFeatureModelEditor editor, HyFeatureModelWrapped featureModel) {
		this.featureModel = featureModel;
		this.editor = editor;
	}

	@Override 
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		HyVersionEvolutionDeleteCommand deleteCommand = new HyVersionEvolutionDeleteCommand(editor);
		deleteCommand.setVersion((HyVersion)getHost().getModel());

		return deleteCommand;
	}
}