package eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.feature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelEvolutionWrapped;


/**
 * http://code.google.com/p/treelayout/
 * 
 * @author Florian
 */
public class HyFeatureLayouterManager {
	private static HyFeatureLayouterManager instance = null;

	protected static HyFeatureLayouterManager getInstance() {
		if (instance == null) {
			instance = new HyFeatureLayouterManager();
		}

		return instance;
	}


	private Map<HyFeatureModelEvolutionWrapped, HyFeatureTreeLayouter> featureToLayouterMap;

	private HyFeatureLayouterManager() {
		featureToLayouterMap = new HashMap<HyFeatureModelEvolutionWrapped, HyFeatureTreeLayouter>();
	}


	/**
	 * This method retrieves the appropriate layouter from a map. If there is no such layouter, a new one will be created and returned.
	 */
	public static HyFeatureTreeLayouter getLayouter(HyFeatureModelEvolutionWrapped feature) {
		return getInstance().doGetLayouter(feature);
	}

	private HyFeatureTreeLayouter doGetLayouter(HyFeatureModelEvolutionWrapped feature) {
		if (!featureToLayouterMap.containsKey(feature)) {
			doUpdateLayouter(feature);
		}

		return featureToLayouterMap.get(feature);
	}

	public static void updateLayouter(HyFeatureModelEvolutionWrapped feature) {
		getInstance().doUpdateLayouter(feature);
	}

	private void doUpdateLayouter(HyFeatureModelEvolutionWrapped feature) {
		List<HyFeature> features = feature.getModel().getFeatures();
		
		if (!features.isEmpty()) {
			featureToLayouterMap.put(feature, new HyFeatureTreeLayouter(feature));
		}
	}	
}
