package dw.darwinspl.feature.graphical.editor.policies;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.editpolicies.FeedbackHelper;
import org.eclipse.gef.handles.ConnectionEndpointHandle;
import org.eclipse.gef.requests.ReconnectRequest;

import dw.darwinspl.feature.graphical.base.anchors.DwParentChildConnectionAnchor;
import dw.darwinspl.feature.graphical.base.figures.DwParentChildConnectionFigure;
import dw.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import dw.darwinspl.feature.graphical.base.model.DwParentChildConnection;

public class DwParentChildConnectionEndpointEditPolicy extends ConnectionEndpointEditPolicy {
	private class HyParentChildConnectionFeedbackHelper extends FeedbackHelper{
		List<DwParentChildConnection> highlightedConnections = new ArrayList<DwParentChildConnection>();
		
		public void update(ConnectionAnchor anchor, Point p){
			
			if(anchor instanceof DwParentChildConnectionAnchor){
				
				DwParentChildConnectionFigure figure = (DwParentChildConnectionFigure)anchor.getOwner();
				DwFeatureWrapped feature = figure.getSource();
				
				Date date = figure.getEditor().getCurrentSelectedDate();
				
				for(DwParentChildConnection connection : feature.getChildrenConnections(date)){
					connection.setHighlight(true);	
					
					highlightedConnections.add(connection);
				}	
			}else{
				for(DwParentChildConnection connection : highlightedConnections){
					connection.setHighlight(false);
				}
				
				highlightedConnections.clear();
			}
			
			if(anchor != null)			
				super.update(anchor, p);
		}
	}
	
	private HyParentChildConnectionFeedbackHelper feedbackHelper;
	
	protected FeedbackHelper getFeedbackHelper(ReconnectRequest request) {
		if (feedbackHelper == null) {
			feedbackHelper = new HyParentChildConnectionFeedbackHelper();
			feedbackHelper.setConnection(getConnection());
			feedbackHelper.setMovingStartAnchor(request.isMovingStartAnchor());
		}
		
		return feedbackHelper;
	}
	
	
	@Override
	protected List<Object> createSelectionHandles(){
		List<Object> list = new ArrayList<Object>();
		list.add(new ConnectionEndpointHandle((ConnectionEditPart) getHost(),
				ConnectionLocator.SOURCE));
		return list;
	}
}
