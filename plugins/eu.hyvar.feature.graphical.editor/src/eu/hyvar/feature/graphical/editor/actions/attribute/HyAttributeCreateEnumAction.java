package eu.hyvar.feature.graphical.editor.actions.attribute;

import java.util.Date;

import org.eclipse.gef.Request;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.editor.dialogs.DwEnumDialog;

public class HyAttributeCreateEnumAction extends HyAttributeCreateAction{
	public static final String FEATURE_ADD_ENUM_ATTRIBUTE = "AddFeatureEnumAttribute";
	public static final String REQ_FEATURE_ADD_ENUM_ATTRIBUTE = "AddFeatureEnumAttribute";

	Request request;
	
	public HyAttributeCreateEnumAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);

		setId(FEATURE_ADD_ENUM_ATTRIBUTE);
		setText("Create Enumeration Attribute");

		request = new Request(REQ_FEATURE_ADD_ENUM_ATTRIBUTE);
	}

	@Override
	protected HyFeatureAttribute createNewAttribute(){
		Date date = editor.getCurrentSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE)))
			date = null;
		
		// check if enums exist and show a dialog otherwise
		if(editor.getModelWrapped().getModel().getEnums().isEmpty()){
			MessageBox dialog =
			        new MessageBox(editor.getSite().getShell(), SWT.ERROR | SWT.OK);
			dialog.setText("No existing enumerations");
			dialog.setMessage("This feature model does not have any defined enumerations. Please create first one enumeration"
					+ " before adding it to a feature.");

			// open dialog and await user selection
			dialog.open();
			return null;
		}
		
		DwEnumDialog dialog = new DwEnumDialog(editor.getSite().getShell(), editor.getCurrentSelectedDate(), editor.getModelWrapped().getModel(), null, null);		
		dialog.open();
		
		HyEnumLiteral literal = dialog.getValue();
		if(literal != null){		
			HyEnumAttribute attribute = HyFeatureFactory.eINSTANCE.createHyEnumAttribute();
			attribute.setValidSince(editor.getCurrentSelectedDate());
			HyName name = HyEvolutionFactory.eINSTANCE.createHyName();
			name.setName("New Enumeration Attribute");
			name.setValidSince(date);
			attribute.getNames().add(name);
			
			attribute.setEnumType(literal.getEnum());
			return attribute;
		}else{
			return null;
		}
	}
}
