package de.darwinspl.feature.graphical.configurator.editparts;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwAttributeEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.configurator.dialogs.DwChoiceBoxAttributeAssignmentDialog;
import de.darwinspl.feature.graphical.configurator.editor.DwFeatureModelConfiguratorEditor;
import de.darwinspl.feature.graphical.configurator.util.DwConfiguratorEditorUtil;
import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyStringValue;
import eu.hyvar.dataValues.HyValue;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyStringAttribute;
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.HyFeatureSelected;

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
			if (newText.equals("false") || newText.equals("true")) {
				return null;
			}
			return "Enter a 'false' or 'true'";

		}
	};

	public DwConfiguratorEditorAttributeEditPart(DwGraphicalFeatureModelViewer editor,
			DwFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	public void performRequest(Request request) {
		// React to double click
		if (request.getType() == RequestConstants.REQ_OPEN) {
			
			
			HyFeatureAttribute attribute = (HyFeatureAttribute) getModel();

			DwFeatureModelConfiguratorEditor editor = (DwFeatureModelConfiguratorEditor) getEditor();
			HyConfiguration configuration = editor.getSelectedConfiguration();
			
			boolean isFeatureSelected = false;
			for(HyConfigurationElement configElement: configuration.getElements()){
				if(configElement instanceof HyFeatureSelected){
					if(((HyFeatureSelected) configElement).getSelectedFeature().equals(attribute.getFeature())){
						isFeatureSelected = true;
						break;
					}
				}
			}
			
			if(isFeatureSelected== false){
				return;
			}
			

			Dialog dialog;
			String initialValue= "";
			EList<HyEnumLiteral> literals = null;


			if (attribute instanceof HyNumberAttribute) {
				HyAttributeValueAssignment assignment = DwConfiguratorEditorUtil.getValueAssignmentForFeatureAttribute(configuration, attribute);
				if(assignment!=null){
					initialValue = Integer.toString(((HyNumberValue) assignment.getValue()).getValue());
				}
				dialog = new InputDialog(this.getViewer().getControl().getShell(), "Specify Attribute Value",
						"Please give the attribute a value:", initialValue, numberValidator);
				

			} else if (attribute instanceof HyBooleanAttribute) {
				HyAttributeValueAssignment assignment = DwConfiguratorEditorUtil.getValueAssignmentForFeatureAttribute(configuration, attribute);
				if(assignment!=null){
					initialValue = Boolean.toString(((HyBooleanValue) assignment.getValue()).isValue());
				}
				String[] listi = new String[2];
				listi[0] = "true";
				listi[1] = "false";

			    dialog = new DwChoiceBoxAttributeAssignmentDialog(this.getViewer().getControl().getShell(), "Specify Attribute Value",
						"Please give the attribute a value:", initialValue, listi);

			} else if(attribute instanceof HyStringAttribute){
				HyAttributeValueAssignment assignment = DwConfiguratorEditorUtil.getValueAssignmentForFeatureAttribute(configuration, attribute);
				if(assignment!=null){
					initialValue = ((HyStringValue) assignment.getValue()).getValue();
				}
				dialog = new InputDialog(this.getViewer().getControl().getShell(), "Specify Attribute Value",
						"Please give the attribute a value:", initialValue, null);
			} else{
				HyAttributeValueAssignment assignment = DwConfiguratorEditorUtil.getValueAssignmentForFeatureAttribute(configuration, attribute);
				if(assignment!=null){
					initialValue = (((HyEnumValue) assignment.getValue()).getEnumLiteral().getName());
				}
				
				HyEnum enumType = ((HyEnumAttribute) attribute).getEnumType();
				literals = enumType.getLiterals();
				String[] validLiterals = new String[literals.size()];
				int i =0;
				for(HyEnumLiteral l: literals){
					
					validLiterals[i] = l.getName();
					i++;
				}
				
				dialog = new DwChoiceBoxAttributeAssignmentDialog(this.getViewer().getControl().getShell(), "Specify Attribute Value",
							"Please give the attribute a value:", initialValue, validLiterals);
			}

			
			if ((dialog.open() == Dialog.OK)) {

				String dialogValue = null;
				if(dialog instanceof InputDialog){
					dialogValue =((InputDialog)dialog).getValue();
				}else{
					dialogValue = ((DwChoiceBoxAttributeAssignmentDialog)dialog).getValue();
					System.out.println(dialogValue);
				}
				if (attribute instanceof HyBooleanAttribute) {

					attributeValue = HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
					if (dialogValue.equals("false")) {
						((HyBooleanValue) attributeValue).setValue(false);
					} else {
						((HyBooleanValue) attributeValue).setValue(true);
					}
				} else if (attribute instanceof HyNumberAttribute) {
					attributeValue = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
					int intValue = Integer.parseInt(dialogValue);
					((HyNumberValue) attributeValue).setValue(intValue);
				} else if (attribute instanceof HyStringAttribute) {
					attributeValue = HyDataValuesFactory.eINSTANCE.createHyStringValue();
					((HyStringValue) attributeValue).setValue(dialogValue);
				} else if (attribute instanceof HyEnumAttribute){
				   attributeValue = HyDataValuesFactory.eINSTANCE.createHyEnumValue();
				   if(literals!=null){
					   
					   for(HyEnumLiteral l: literals){
						   if(l.getName().equals(dialogValue)){
							   ((HyEnumValue) attributeValue).setEnum(l.getEnum());
							   ((HyEnumValue) attributeValue).setEnumLiteral(l);
							   break;
						   }
					   }
					   
				   }
				}

				if (attributeValue != null) {
					DwConfiguratorEditorUtil.changeValueAssignmentOfAttribute(configuration, attribute, attributeValue);

				}
			

				editor.refreshView();
			}
		}
	}
}
