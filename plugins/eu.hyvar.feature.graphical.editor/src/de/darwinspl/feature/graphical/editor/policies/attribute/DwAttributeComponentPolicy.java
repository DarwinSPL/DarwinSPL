package de.darwinspl.feature.graphical.editor.policies.attribute;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.editor.commands.attribute.DwAttributeDeleteCommand;
import eu.hyvar.feature.HyFeatureAttribute;

public class DwAttributeComponentPolicy extends ComponentEditPolicy {
	private DwGraphicalFeatureModelViewer editor;
	protected DwFeatureModelWrapped featureModel;
	
	public DwAttributeComponentPolicy(DwFeatureModelWrapped featureModel, DwGraphicalFeatureModelViewer editor) {
		this.featureModel = featureModel;
		this.editor = editor;
	}

	
	  @Override protected Command createDeleteCommand(GroupRequest deleteRequest) {
		  DwAttributeDeleteCommand deleteCommand = new DwAttributeDeleteCommand(editor);
		  deleteCommand.setAttribute((HyFeatureAttribute)getHost().getModel());
		  
		  return deleteCommand;
	  }
}