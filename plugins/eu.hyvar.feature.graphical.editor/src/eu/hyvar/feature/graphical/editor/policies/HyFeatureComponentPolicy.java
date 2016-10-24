package eu.hyvar.feature.graphical.editor.policies;


import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.commands.feature.HyFeatureEvolutionDeleteCommand;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;

public class HyFeatureComponentPolicy extends ComponentEditPolicy {
	private GraphicalEvolutionFeatureModelEditor editor;
	protected HyFeatureModelWrapped featureModel;
	
	public HyFeatureComponentPolicy(HyFeatureModelWrapped featureModel, GraphicalEvolutionFeatureModelEditor editor) {
		this.featureModel = featureModel;
		this.editor = editor;
	}

	
	  @Override protected Command createDeleteCommand(GroupRequest deleteRequest) {
		  HyFeatureEvolutionDeleteCommand deleteCommand = new HyFeatureEvolutionDeleteCommand(editor);
		  deleteCommand.setModel(featureModel);
		  deleteCommand.setFeature((HyFeatureWrapped)getHost().getModel());
		  
		  return deleteCommand;
	  }
}
