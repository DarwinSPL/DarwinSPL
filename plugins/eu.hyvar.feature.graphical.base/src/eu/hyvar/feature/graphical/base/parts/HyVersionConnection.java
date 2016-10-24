package eu.hyvar.feature.graphical.base.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

public class HyVersionConnection extends AbstractConnectionEditPart	 {

	@Override protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
	}

	@Override protected IFigure createFigure() {
		PolylineConnection connection = new PolylineConnection();
		return connection; 
	}

}
