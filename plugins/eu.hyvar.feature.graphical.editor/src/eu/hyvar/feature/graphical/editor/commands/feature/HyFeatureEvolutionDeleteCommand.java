package eu.hyvar.feature.graphical.editor.commands.feature;

import java.util.Date;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;

public class HyFeatureEvolutionDeleteCommand extends FeatureConnectionChangeCommand{
	
	public HyFeatureEvolutionDeleteCommand(GraphicalEvolutionFeatureModelEditor editor) {
		super(editor);
	}

	private HyFeatureWrapped feature;
	
	public void setFeature(HyFeatureWrapped feature) {
		this.feature = feature;
	}

	public void setModel(HyFeatureModelWrapped model) {
		this.featureModel = model;
	}
	
	@Override
	public void execute(){
		Date date = editor.getCurrentSelectedDate();
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(feature.getWrappedModelElement().getGroupMembership(), date);
		splitComposition(composition, feature);
		feature.getWrappedModelElement().setValidUntil(date);
	}
}
