package eu.hyvar.feature.graphical.configurator.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;

import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.configurator.editor.HyFeatureModelDeltaModuleConfiguratorEditor;
import eu.hyvar.feature.graphical.configurator.figures.HyConfiguratorFeatureFigure;
import eu.hyvar.feature.graphical.configurator.predicates.HyConfiguratorElementHasFeaturePredicate;
import eu.hyvar.feature.graphical.configurator.util.HyConfiguratorEditorUtil;

public class HyConfiguratorFeatureEditPart extends HyFeatureEditPart{

	public HyConfiguratorFeatureEditPart(HyGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}
	
	@Override
	protected IFigure createFigure() {	
		return new HyConfiguratorFeatureFigure(editor, (HyFeatureWrapped)getModel());
	}


	@Override
	public void performRequest(Request request) {
		//React to double click
		if (request.getType() == RequestConstants.REQ_OPEN) {
			HyFeatureWrapped feature = (HyFeatureWrapped)getModel();

			HyFeatureModelDeltaModuleConfiguratorEditor editor = (HyFeatureModelDeltaModuleConfiguratorEditor)getEditor();
			HyConfiguration configuration = editor.getSelectedConfiguration();
			
			HyConfiguratorElementHasFeaturePredicate<Object> predicate = new HyConfiguratorElementHasFeaturePredicate<>();
			predicate.feature = feature.getWrappedModelElement();
			
			if(!configuration.getElements().removeIf(predicate)){
				HyConfiguratorEditorUtil.addFeatureToConfiguration(configuration, feature.getWrappedModelElement(), editor.getCurrentSelectedDate());
			}else{
				HyConfiguratorEditorUtil.removeChildrenFeaturesFromConfiguration(configuration, feature.getWrappedModelElement(), editor.getCurrentSelectedDate());
			}
		}
		
		editor.refreshView();
	}	
}
