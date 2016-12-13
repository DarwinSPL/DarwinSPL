package de.darwinspl.importer.splot;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.darwinspl.importer.DarwinSPLFeatureModelImporter;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyRootFeature;

public class SplotImporter implements DarwinSPLFeatureModelImporter<fm.FeatureModel> {
	
	private Map<fm.FeatureTreeNode, HyFeature> featureMapping;

	@Override
	public HyFeatureModel importFeatureModel(fm.FeatureModel originalFeatureModel) {
		featureMapping = new HashMap<fm.FeatureTreeNode, HyFeature>();
		
		HyFeatureModel featureModel = HyFeatureFactory.eINSTANCE.createHyFeatureModel();
		
		
		fm.FeatureTreeNode originalRootFeature = originalFeatureModel.getRoot();
		
		HyRootFeature rootFeature = HyFeatureFactory.eINSTANCE.createHyRootFeature();
		HyFeature rootFeatureFeature = HyFeatureFactory.eINSTANCE.createHyFeature();
		rootFeature.setFeature(rootFeatureFeature);
		featureModel.getFeatures().add(rootFeatureFeature);
		featureModel.getRootFeature().add(rootFeature);
		HyName rootFeatureName = HyEvolutionFactory.eINSTANCE.createHyName();
		rootFeatureName.setName(originalRootFeature.getName());
		
		featureMapping.put(originalRootFeature, rootFeatureFeature);
		
		
		List<fm.FeatureTreeNode> propagatedNodes = originalRootFeature.getPropagatedNodes();
		
		// TODO translate constraints
		Collection<constraints.PropositionalFormula> originalConstraints =  originalFeatureModel.getConstraints();
		
		
		return featureModel;
	}
	
	

}
