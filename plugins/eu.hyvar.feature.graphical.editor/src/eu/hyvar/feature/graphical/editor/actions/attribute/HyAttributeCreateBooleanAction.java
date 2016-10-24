package eu.hyvar.feature.graphical.editor.actions.attribute;

import org.eclipse.gef.Request;

import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;

public class HyAttributeCreateBooleanAction extends HyAttributeCreateAction{
	public static final String FEATURE_ADD_BOOLEAN_ATTRIBUTE = "AddFeatureBooleanAttribute";
	public static final String REQ_FEATURE_ADD_BOOLEAN_ATTRIBUTE = "AddFeatureBooleanAttribute";

	Request request;
	

	public HyAttributeCreateBooleanAction(GraphicalEvolutionFeatureModelEditor editor) {
		super(editor);

		setId(FEATURE_ADD_BOOLEAN_ATTRIBUTE);
		setText("Create Boolean Attribute");

		request = new Request(REQ_FEATURE_ADD_BOOLEAN_ATTRIBUTE);
	}

	@Override
	protected HyFeatureAttribute createNewAttribute(){
		HyFeatureAttribute attribute = HyFeatureFactory.eINSTANCE.createHyBooleanAttribute();
		attribute.setValidSince(editor.getCurrentSelectedDate());
		HyName name = HyEvolutionFactory.eINSTANCE.createHyName();
		name.setName("New Boolean Attribute");
		attribute.getNames().add(name);
		
		editor.getModelWrapped().rearrangeFeatures();
		
		return attribute;
	}
}
