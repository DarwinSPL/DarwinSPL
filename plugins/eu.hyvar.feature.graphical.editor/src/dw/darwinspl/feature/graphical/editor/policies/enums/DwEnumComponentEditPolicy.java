package dw.darwinspl.feature.graphical.editor.policies.enums;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import dw.darwinspl.feature.graphical.editor.commands.enumeration.DwEnumDeleteCommand;
import eu.hyvar.dataValues.HyEnum;

public class DwEnumComponentEditPolicy extends ComponentEditPolicy {
	private DwGraphicalFeatureModelViewer editor;
	protected DwFeatureModelWrapped featureModel;

	public DwEnumComponentEditPolicy(DwFeatureModelWrapped featureModel, DwGraphicalFeatureModelViewer editor) {
		this.featureModel = featureModel;
		this.editor = editor;
	}

	@Override 
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		Object model = getHost().getModel();
		if(model instanceof HyEnum){
			DwEnumDeleteCommand deleteCommand = new DwEnumDeleteCommand(editor);
			deleteCommand.setEditor(editor);
			deleteCommand.setEnumeration((HyEnum)getHost().getModel());

			return deleteCommand;	  
		}

		return null;
	}
}