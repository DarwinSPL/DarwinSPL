package de.darwinspl.feature.graphical.configurator.editparts;

import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwAttributeEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.configurator.editor.DwFeatureModelConfiguratorEditor;
import de.darwinspl.feature.graphical.configurator.predicates.DwConfiguratorElementHasAttributePredicate;
import de.darwinspl.feature.graphical.configurator.util.DwConfiguratorEditorUtil;
import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyStringValue;
import eu.hyvar.dataValues.HyValue;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyStringAttribute;
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;

public class DwConfiguratorEditorAttributeEditPart extends DwAttributeEditPart {
	HyValue attributeValue = null;
	
	IInputValidator numberValidator = new IInputValidator() {
		
		@Override
		public String isValid(String newText) {
			try {
				int newInt = Integer.parseInt(newText);
				return null;
				
			} catch (Exception e) {
				
				return "Enter a valid number";
				
			}
			
			
		}
	};
	
        IInputValidator booleanValidator = new IInputValidator() {
		
		@Override
		public String isValid(String newText) {
			if(newText.equals("false") || newText.equals("true")){
				return null;
			}
			return "Enter a 'false' or 'true'";
			
		}
	};
	
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
				
				InputDialog dialog;
				
				if(attribute instanceof HyNumberAttribute){
					dialog =new InputDialog(this.getViewer().getControl().getShell(), "Specify Attribute Value", "Please give the attribute a value:", "", numberValidator);
					
				} else if (attribute instanceof HyBooleanAttribute){
					
					dialog = new InputDialog(this.getViewer().getControl().getShell(), "Specify Attribute Value", "Please give the attribute a value:", "", booleanValidator);
				}
				else{
					dialog = new InputDialog(this.getViewer().getControl().getShell(), "Specify Attribute Value", "Please give the attribute a value:", "", null);
				}
				
				
				if(dialog.open() == InputDialog.OK){
				
					String dialogValue = dialog.getValue();
					if(attribute instanceof HyBooleanAttribute){
						
						attributeValue = HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
						if(dialogValue.equals("false")){
                            ((HyBooleanValue) attributeValue).setValue(false);
						}else{
							((HyBooleanValue) attributeValue).setValue(true);
						}
					}else if(attribute instanceof HyNumberAttribute){
						attributeValue = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
						int intValue =Integer.parseInt(dialogValue);
					    ((HyNumberValue) attributeValue).setValue(intValue);
					}else if(attribute instanceof HyStringAttribute){
						attributeValue = HyDataValuesFactory.eINSTANCE.createHyStringValue();
						((HyStringValue) attributeValue).setValue(dialogValue);
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
