package eu.hyvar.feature.graphical.editor.commands.feature;

import java.util.Date;
import java.util.List;

import org.eclipse.gef.EditPart;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;

public class HyFeatureEvolutionDeleteCommand extends FeatureConnectionChangeCommand{
	EditPart host;
	public HyFeatureEvolutionDeleteCommand(GraphicalEvolutionFeatureModelEditor editor, EditPart host) {
		super(editor);
		
		this.host = host;
	}

	private HyFeatureWrapped feature;
	
	public void setFeature(HyFeatureWrapped feature) {
		this.feature = feature;
	}

	public void setModel(HyFeatureModelWrapped model) {
		this.featureModel = model;
	}
	
	private void deleteFeatureChildrenTemporarily(HyFeature feature){
		Date date = editor.getCurrentSelectedDate();
				
		List<HyFeatureChild> children = HyEvolutionUtil.getValidTemporalElements(feature.getParentOf(), date);
		for(HyFeatureChild child : children){
			List<HyGroupComposition> compositions = HyEvolutionUtil.getValidTemporalElements(child.getChildGroup().getParentOf(), date);
			
			for(HyGroupComposition composition : compositions){
				for(HyFeature childFeature : composition.getFeatures()){
					childFeature.setValidUntil(date);
					
					deleteFeatureChildrenTemporarily(childFeature);
				}
				
			}
		}
	}
	
	@Override
	public void execute(){
		Date date = editor.getCurrentSelectedDate();
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(feature.getWrappedModelElement().getGroupMembership(), date);
		splitComposition(composition, feature);
		
		feature.getWrappedModelElement().setValidUntil(date);
		
		deleteFeatureChildrenTemporarily(feature.getWrappedModelElement());

		// delete the selection from the element
		host.setSelected(0);
		
		editor.getModelWrapped().rearrangeFeatures();
		editor.refreshView();
	}
}
