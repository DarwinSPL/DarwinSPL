package dw.darwinspl.feature.graphical.editor.actions.attribute;

import java.util.Date;

import org.eclipse.gef.Request;

import dw.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureFactory;

public class DwAttributeCreateStringAction extends DwAttributeCreateAction{
	
	public static final String FEATURE_ADD_STRING_ATTRIBUTE = "AddFeatureStringAttribute";
	public static final String REQ_FEATURE_ADD_STRING_ATTRIBUTE = "AddFeatureStringAttribute";
	

	public DwAttributeCreateStringAction(DwGraphicalFeatureModelEditor editor) {
		super(editor);

		setId(FEATURE_ADD_STRING_ATTRIBUTE);
		setText("Create String Attribute");

		request = new Request(REQ_FEATURE_ADD_STRING_ATTRIBUTE);
	}

	@Override
	protected HyFeatureAttribute createNewAttribute(){
		Date date = editor.getCurrentSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE)))
			date = null;
		
		HyFeatureAttribute attribute = HyFeatureFactory.eINSTANCE.createHyStringAttribute();
		attribute.setValidSince(editor.getCurrentSelectedDate());
		HyName name = HyEvolutionFactory.eINSTANCE.createHyName();
		name.setName("New String Attribute");
		name.setValidSince(date);
		attribute.getNames().add(name);
				
		return attribute;
	}

}