package eu.hyvar.feature.graphical.editor.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.editor.commands.attribute.HyAttributeEvolutionDeleteCommand;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;

public class HyAttributeComponentPolicy extends ComponentEditPolicy {
	private GraphicalEvolutionFeatureModelEditor editor;
	protected HyFeatureModelWrapped featureModel;
	
	public HyAttributeComponentPolicy(HyFeatureModelWrapped featureModel, GraphicalEvolutionFeatureModelEditor editor) {
		this.featureModel = featureModel;
		this.editor = editor;
	}

	
	  @Override protected Command createDeleteCommand(GroupRequest deleteRequest) {
		  HyAttributeEvolutionDeleteCommand deleteCommand = new HyAttributeEvolutionDeleteCommand(editor);
		  deleteCommand.setEditor(editor);
		  deleteCommand.setAttribute((HyFeatureAttribute)getHost().getModel());
		  
		  return deleteCommand;
	  }
}