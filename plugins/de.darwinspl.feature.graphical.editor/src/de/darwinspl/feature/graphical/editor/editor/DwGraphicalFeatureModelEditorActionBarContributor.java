package de.darwinspl.feature.graphical.editor.editor;

import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
import org.eclipse.gef.ui.actions.ZoomComboContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.actions.ActionFactory;

import de.darwinspl.feature.graphical.editor.actions.DwFeatureModelCreateOverviewAction;
import de.darwinspl.feature.graphical.editor.actions.DwFeatureModelCreateSVGAction;
import de.darwinspl.feature.graphical.editor.actions.layout.DwFeatureModelAutoLayoutAction;

/**
 * Adds buttons to the eclipse toolbar
 * @author Gil Engel
 *
 */
public class DwGraphicalFeatureModelEditorActionBarContributor extends ActionBarContributor {

	@Override
	protected void buildActions() {
		addRetargetAction(new DeleteRetargetAction());
		addRetargetAction(new DwFeatureModelAutoLayoutAction());
		addRetargetAction(new DwFeatureModelCreateOverviewAction());
		addRetargetAction(new DwFeatureModelCreateSVGAction());
	}

	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		super.contributeToToolBar(toolBarManager);
		toolBarManager.add(getAction(ActionFactory.DELETE.getId()));
		toolBarManager.add(getAction(DwFeatureModelAutoLayoutAction.ID));
		toolBarManager.add(getAction(DwFeatureModelCreateOverviewAction.FEATUREMODEL_CREATE_OVERVIEW));
		toolBarManager.add(getAction(DwFeatureModelCreateSVGAction.FEATUREMODEL_CREATE_SVG));
		toolBarManager.add(new ZoomComboContributionItem(getPage()));
		
	}	

	@Override
	protected void declareGlobalActionKeys() {
		// TODO Auto-generated method stub

	}

}
