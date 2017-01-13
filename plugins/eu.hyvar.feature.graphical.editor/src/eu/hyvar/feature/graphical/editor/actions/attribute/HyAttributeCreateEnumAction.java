package eu.hyvar.feature.graphical.editor.actions.attribute;

import java.util.Date;

import org.eclipse.gef.Request;

import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.editor.dialogs.EnumDialog;

public class HyAttributeCreateEnumAction extends HyAttributeCreateAction{
	public static final String FEATURE_ADD_ENUM_ATTRIBUTE = "AddFeatureEnumAttribute";
	public static final String REQ_FEATURE_ADD_ENUM_ATTRIBUTE = "AddFeatureEnumAttribute";

	Request request;
	
	public HyAttributeCreateEnumAction(HyGraphicalFeatureModelViewer editor) {
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
		
		EnumDialog dialog = new EnumDialog(editor.getSite().getShell(), editor.getModelWrapped().getModel(), null, null);		
		dialog.open();
		HyEnumLiteral literal = dialog.getValue();
		
		HyEnumAttribute attribute = HyFeatureFactory.eINSTANCE.createHyEnumAttribute();
		attribute.setValidSince(editor.getCurrentSelectedDate());
		HyName name = HyEvolutionFactory.eINSTANCE.createHyName();
		name.setName("New Enumeration Attribute");
		name.setValidSince(date);
		attribute.getNames().add(name);
		
		attribute.setEnumType(literal.getEnum());
		return attribute;
	}
}
