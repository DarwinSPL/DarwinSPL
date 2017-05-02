package dw.darwinspl.feature.graphical.configurator.editparts;

import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.dialogs.InputDialog;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.editparts.DwAttributeEditPart;
import dw.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import dw.darwinspl.feature.graphical.configurator.editor.DwFeatureModelConfiguratorEditor;
import dw.darwinspl.feature.graphical.configurator.predicates.DwConfiguratorElementHasAttributePredicate;
import dw.darwinspl.feature.graphical.configurator.util.DwConfiguratorEditorUtil;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyValue;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyStringAttribute;
import eu.hyvar.feature.configuration.HyConfiguration;

public class DwConfiguratorEditorAttributeEditPart extends DwAttributeEditPart {
	HyValue attributeValue = null;
	
	public DwConfiguratorEditorAttributeEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	public void performRequest(Request request) {
		//React to double click
		if (request.getType() == RequestConstants.REQ_OPEN) {
			HyFeatureAttribute attribute = (HyFeatureAttribute)getModel();

			DwFeatureModelConfiguratorEditor editor = (DwFeatureModelConfiguratorEditor)getEditor();
			HyConfiguration configuration = editor.getSelectedConfiguration();
			

			if(attributeValue != null){
				DwConfiguratorElementHasAttributePredicate<Object> predicate = new DwConfiguratorElementHasAttributePredicate<>();
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
						DwConfiguratorEditorUtil.addAttributeToConfiguration(configuration, attribute, attributeValue, editor.getCurrentSelectedDate());	
					}
				}	
				
				editor.refreshView();
			}
		}
	}
}
