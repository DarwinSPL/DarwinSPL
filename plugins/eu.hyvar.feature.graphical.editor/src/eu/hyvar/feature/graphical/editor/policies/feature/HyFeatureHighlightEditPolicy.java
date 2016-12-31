package eu.hyvar.feature.graphical.editor.policies.feature;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;

public class HyFeatureHighlightEditPolicy extends GraphicalEditPolicy {
	public void eraseTargetFeedback(Request request) {
		if (((GraphicalEditPart) getHost()).getSelected() == EditPart.SELECTED) {
			((GraphicalEditPart) getHost()).setSelected(EditPart.SELECTED_NONE);
		}
	}

	public EditPart getTargetEditPart(Request request) {
		return request.getType().equals(RequestConstants.REQ_SELECTION_HOVER) ? getHost()
				: null;
	}

	public void showTargetFeedback(Request request) {
		if (request.getType().equals(RequestConstants.REQ_MOVE)
				|| request.getType().equals(RequestConstants.REQ_ADD)
				|| request.getType().equals(RequestConstants.REQ_CLONE)
				|| request.getType().equals(RequestConstants.REQ_CONNECTION_START)
				|| request.getType().equals(RequestConstants.REQ_CONNECTION_END)
				|| request.getType().equals(RequestConstants.REQ_CREATE)){
			((GraphicalEditPart) getHost()).setSelected(EditPart.SELECTED);
		}
	}
}
