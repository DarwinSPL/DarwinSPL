package dw.darwinspl.feature.graphical.editor.actions.attribute;

import java.util.Date;

import org.eclipse.gef.Request;

import dw.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureFactory;

public class DwAttributeCreateBooleanAction extends DwAttributeCreateAction{
	public static final String FEATURE_ADD_BOOLEAN_ATTRIBUTE = "AddFeatureBooleanAttribute";
	public static final String REQ_FEATURE_ADD_BOOLEAN_ATTRIBUTE = "AddFeatureBooleanAttribute";

	Request request;
	

	public DwAttributeCreateBooleanAction(DwGraphicalFeatureModelEditor editor) {
		super(editor);

		setId(FEATURE_ADD_BOOLEAN_ATTRIBUTE);
		setText("Create Boolean Attribute");

		request = new Request(REQ_FEATURE_ADD_BOOLEAN_ATTRIBUTE);
	}

	@Override
	protected HyFeatureAttribute createNewAttribute(){
		Date date = editor.getCurrentSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE)))
			date = null;
		
		HyFeatureAttribute attribute = HyFeatureFactory.eINSTANCE.createHyBooleanAttribute();
		attribute.setValidSince(date);
		HyName name = HyEvolutionFactory.eINSTANCE.createHyName();
		name.setValidSince(date);
		name.setName("New Boolean Attribute");
		attribute.getNames().add(name);
				
		return attribute;
	}
}
