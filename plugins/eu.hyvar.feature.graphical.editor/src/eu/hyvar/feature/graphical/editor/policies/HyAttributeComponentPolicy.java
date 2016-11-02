package eu.hyvar.feature.graphical.editor.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.editor.commands.attribute.HyAttributeDeleteCommand;

public class HyAttributeComponentPolicy extends ComponentEditPolicy {
	private GraphicalFeatureModelEditor editor;
	protected HyFeatureModelWrapped featureModel;
	
	public HyAttributeComponentPolicy(HyFeatureModelWrapped featureModel, GraphicalFeatureModelEditor editor) {
		this.featureModel = featureModel;
		this.editor = editor;
	}

	
	  @Override protected Command createDeleteCommand(GroupRequest deleteRequest) {
		  HyAttributeDeleteCommand deleteCommand = new HyAttributeDeleteCommand(editor);
		  deleteCommand.setAttribute((HyFeatureAttribute)getHost().getModel());
		  
		  return deleteCommand;
	  }
}