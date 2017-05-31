package de.darwinspl.feature.graphical.editor.policies.version;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.editor.commands.version.DwVersionEvolutionDeleteCommand;
import de.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;
import eu.hyvar.feature.HyVersion;

public class DwVersionComponentPolicy extends ComponentEditPolicy {
	private DwGraphicalFeatureModelEditor editor;
	protected DwFeatureModelWrapped featureModel;

	public DwVersionComponentPolicy(DwGraphicalFeatureModelEditor editor, DwFeatureModelWrapped featureModel) {
		this.featureModel = featureModel;
		this.editor = editor;
	}

	@Override 
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		DwVersionEvolutionDeleteCommand deleteCommand = new DwVersionEvolutionDeleteCommand(editor, (EditPart)deleteRequest.getEditParts().get(0));
		deleteCommand.setVersion((HyVersion)getHost().getModel());

		return deleteCommand;
	}
}