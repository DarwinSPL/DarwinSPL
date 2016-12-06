package eu.hyvar.feature.graphical.editor.policies;

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

import eu.hyvar.feature.graphical.base.anchors.HyParentChildConnectionAnchor;
import eu.hyvar.feature.graphical.base.figures.HyParentChildConnectionFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;

public class HyParentChildConnectionEndpointEditPolicy extends ConnectionEndpointEditPolicy {
	private class HyParentChildConnectionFeedbackHelper extends FeedbackHelper{
		List<HyParentChildConnection> highlightedConnections = new ArrayList<HyParentChildConnection>();
		
		public void update(ConnectionAnchor anchor, Point p){
			
			if(anchor instanceof HyParentChildConnectionAnchor){
				
				HyParentChildConnectionFigure figure = (HyParentChildConnectionFigure)anchor.getOwner();
				HyFeatureWrapped feature = figure.getSource();
				
				Date date = figure.getEditor().getCurrentSelectedDate();
				
				for(HyParentChildConnection connection : feature.getChildrenConnections(date)){
					connection.setHighlight(true);	
					
					highlightedConnections.add(connection);
				}	
			}else{
				for(HyParentChildConnection connection : highlightedConnections){
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
	protected List createSelectionHandles(){
		List list = new ArrayList();
		list.add(new ConnectionEndpointHandle((ConnectionEditPart) getHost(),
				ConnectionLocator.SOURCE));
		return list;
	}
}
