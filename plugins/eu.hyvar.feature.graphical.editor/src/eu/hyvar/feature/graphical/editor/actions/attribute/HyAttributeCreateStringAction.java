package eu.hyvar.feature.graphical.editor.actions.attribute;

import org.eclipse.gef.Request;

import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;

public class HyAttributeCreateStringAction extends HyAttributeCreateAction{
	
	public static final String FEATURE_ADD_STRING_ATTRIBUTE = "AddFeatureStringAttribute";
	public static final String REQ_FEATURE_ADD_STRING_ATTRIBUTE = "AddFeatureStringAttribute";
	

	public HyAttributeCreateStringAction(GraphicalEvolutionFeatureModelEditor editor) {
		super(editor);

		setId(FEATURE_ADD_STRING_ATTRIBUTE);
		setText("Create String Attribute");

		request = new Request(REQ_FEATURE_ADD_STRING_ATTRIBUTE);
	}

	@Override
	protected HyFeatureAttribute createNewAttribute(){
		HyFeatureAttribute attribute = HyFeatureFactory.eINSTANCE.createHyStringAttribute();
		attribute.setValidSince(editor.getCurrentSelectedDate());
		HyName name = HyEvolutionFactory.eINSTANCE.createHyName();
		name.setName("New String Attribute");
		attribute.getNames().add(name);
		
		editor.getModelWrapped().rearrangeFeatures();
		
		return attribute;
	}

}