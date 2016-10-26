package eu.hyvar.feature.graphical.editor.editor;

import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
import org.eclipse.gef.ui.actions.ZoomComboContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.actions.ActionFactory;

import eu.hyvar.feature.graphical.editor.actions.layout.HyFeatureModelAutoLayoutAction;

/**
 * Adds buttons to the eclipse toolbar
 * @author Gil Engel
 *
 */
public class HyGraphicalFeatureModelEditorActionBarContributor extends ActionBarContributor {

	@Override
	protected void buildActions() {
		addRetargetAction(new DeleteRetargetAction());
		addRetargetAction(new HyFeatureModelAutoLayoutAction());
		//addRetargetAction(new HyFeatureModelSaveLayoutAction());
	}

	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		super.contributeToToolBar(toolBarManager);
		toolBarManager.add(getAction(ActionFactory.DELETE.getId()));
		toolBarManager.add(getAction(HyFeatureModelAutoLayoutAction.ID));
		toolBarManager.add(new ZoomComboContributionItem(getPage()));
		
	}	

	@Override
	protected void declareGlobalActionKeys() {
		// TODO Auto-generated method stub

	}

}
