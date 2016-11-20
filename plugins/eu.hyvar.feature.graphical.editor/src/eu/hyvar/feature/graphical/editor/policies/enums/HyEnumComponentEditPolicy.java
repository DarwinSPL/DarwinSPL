package eu.hyvar.feature.graphical.editor.policies.enums;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.editor.commands.enumeration.HyEnumDeleteCommand;

public class HyEnumComponentEditPolicy extends ComponentEditPolicy {
	private HyGraphicalFeatureModelViewer editor;
	protected HyFeatureModelWrapped featureModel;
	
	public HyEnumComponentEditPolicy(HyFeatureModelWrapped featureModel, HyGraphicalFeatureModelViewer editor) {
		this.featureModel = featureModel;
		this.editor = editor;
	}

	
	  @Override protected Command createDeleteCommand(GroupRequest deleteRequest) {
		  Object model = getHost().getModel();
		  if(model instanceof HyEnum){
			  HyEnumDeleteCommand deleteCommand = new HyEnumDeleteCommand(editor);
			  deleteCommand.setEditor(editor);
			  deleteCommand.setEnumeration((HyEnum)getHost().getModel());
			  
			  return deleteCommand;	  
		  }

		  return null;
	  }
}