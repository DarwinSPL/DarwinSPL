package eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.feature;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.abego.treelayout.util.AbstractTreeForTreeLayout;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;

public class HyFeatureTreeForTreeLayout extends AbstractTreeForTreeLayout<HyFeature> {
	private Date date;
	
	public HyFeatureTreeForTreeLayout(HyFeature root, Date date) {
		super(root);

		this.date = (date != null) ? date : new Date();	
	}

	@Override
	public List<HyFeature> getChildrenList(HyFeature feature) {
		ArrayList<HyFeature> children = new ArrayList<HyFeature>();

		if (feature == null) {
			return children;
		}
		
		for(HyFeatureChild child : HyEvolutionUtil.getValidTemporalElements(feature.getParentOf(), date)){
			HyGroup group = child.getChildGroup();
			
			for(HyGroupComposition composition : HyEvolutionUtil.getValidTemporalElements(group.getParentOf(), date)){
				children.addAll(HyEvolutionUtil.getValidTemporalElements(composition.getFeatures(), date));
			}
		}

		return children;
	}

	@Override
	public HyFeature getParent(HyFeature node) {
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(node.getGroupMembership(), date);
		HyFeatureChild child = HyEvolutionUtil.getValidTemporalElement(composition.getCompositionOf().getChildOf(), date);
		
		return child.getParent();
	}
}
