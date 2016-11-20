package eu.hyvar.feature.graphical.editor.commands.feature;

import java.util.Date;

import org.eclipse.gef.commands.Command;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.editor.HyGraphicalFeatureModelEditor;

public class FeatureConnectionChangeCommand extends Command {
	protected HyFeatureModelWrapped featureModel;
	
	protected HyGraphicalFeatureModelEditor editor;
	public FeatureConnectionChangeCommand(HyGraphicalFeatureModelEditor editor){
		this.editor = editor;
	}

	
	protected HyGroupComposition findComposition(HyFeatureWrapped oldSource, HyFeatureWrapped oldTarget){
		Date date = featureModel.getSelectedDate();
		// find composition of selected date
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(oldTarget.getWrappedModelElement().getGroupMembership(), date);
		return composition;
	}

	protected HyGroupComposition splitComposition(HyGroupComposition composition, HyFeatureWrapped feature){
		Date date = featureModel.getSelectedDate();

		HyGroup group = composition.getCompositionOf();

		// copy the composition in order to replace the old composition since selected date
		HyGroupComposition newComposition = HyFeatureFactory.eINSTANCE.createHyGroupComposition();
		newComposition.setCompositionOf(composition.getCompositionOf());
		newComposition.setSupersededElement(composition.getSupersededElement());
		newComposition.setSupersedingElement(composition.getSupersedingElement());
		

		// update validation of old composition (until) and new composition (since) selected date
		

		composition.setValidUntil(date);
		newComposition.setValidSince(date);

		for(HyFeature f : composition.getFeatures()){
			if(!f.equals(feature.getWrappedModelElement())){
				newComposition.getFeatures().add(f);
				f.getGroupMembership().add(newComposition);
			}
		}
		

		

		group.getParentOf().add(newComposition);
		
		return newComposition;

	}
}
