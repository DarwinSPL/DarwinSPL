package eu.hyvar.feature.graphical.configurator.editparts;

import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.dialogs.InputDialog;

import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyValue;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyStringAttribute;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyAttributeEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.configurator.editor.HyFeatureModelDeltaModuleConfiguratorEditor;
import eu.hyvar.feature.graphical.configurator.predicates.HyConfiguratorElementHasAttributePredicate;
import eu.hyvar.feature.graphical.configurator.util.HyConfiguratorEditorUtil;

public class HyConfiguratorAttributeEditPart extends HyAttributeEditPart {
	HyValue attributeValue = null;
	
	public HyConfiguratorAttributeEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	public void performRequest(Request request) {
		//React to double click
		if (request.getType() == RequestConstants.REQ_OPEN) {
			HyFeatureAttribute attribute = (HyFeatureAttribute)getModel();

			HyFeatureModelDeltaModuleConfiguratorEditor editor = (HyFeatureModelDeltaModuleConfiguratorEditor)getEditor();
			HyConfiguration configuration = editor.getSelectedConfiguration();
			

			if(attributeValue != null){
				HyConfiguratorElementHasAttributePredicate<Object> predicate = new HyConfiguratorElementHasAttributePredicate<>();
				predicate.attribute = attribute;
				predicate.value = attributeValue;
				
				if(configuration.getElements().removeIf(predicate)){
					attributeValue = null;
				}
				
			}else{
				InputDialog dialog = new InputDialog(this.getViewer().getControl().getShell(), "Specify Attribute Value", "Please give the attribute a value:", "", null);
				if(dialog.open() == InputDialog.OK){
					if(attribute instanceof HyBooleanAttribute){
						attributeValue = HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
					}else if(attribute instanceof HyNumberAttribute){
						attributeValue = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
					}else if(attribute instanceof HyStringAttribute){
						attributeValue = HyDataValuesFactory.eINSTANCE.createHyStringValue();
					}
					
					if(attributeValue != null){
						HyConfiguratorEditorUtil.addAttributeToConfiguration(configuration, attribute, attributeValue, editor.getCurrentSelectedDate());	
					}
				}			
			}
		}
	}
}
