package dw.darwinspl.feature.graphical.base.deltaecore.wrapper.layouter.feature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dw.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import eu.hyvar.feature.HyFeature;


/**
 * http://code.google.com/p/treelayout/
 * 
 * @author Florian
 */
public class DwFeatureLayouterManager {
	private static DwFeatureLayouterManager instance = null;

	protected static DwFeatureLayouterManager getInstance() {
		if (instance == null) {
			instance = new DwFeatureLayouterManager();
		}

		return instance;
	}


	private Map<DwFeatureModelWrapped, DwFeatureTreeLayouter> featureToLayouterMap;

	private DwFeatureLayouterManager() {
		featureToLayouterMap = new HashMap<DwFeatureModelWrapped, DwFeatureTreeLayouter>();
	}


	/**
	 * This method retrieves the appropriate layouter from a map. If there is no such layouter, a new one will be created and returned.
	 */
	public static DwFeatureTreeLayouter getLayouter(DwFeatureModelWrapped feature) {
		return getInstance().doGetLayouter(feature);
	}

	private DwFeatureTreeLayouter doGetLayouter(DwFeatureModelWrapped feature) {
		if (!featureToLayouterMap.containsKey(feature)) {
			doUpdateLayouter(feature);
		}

		return featureToLayouterMap.get(feature);
	}

	public static void updateLayouter(DwFeatureModelWrapped feature) {
		getInstance().doUpdateLayouter(feature);
	}

	private void doUpdateLayouter(DwFeatureModelWrapped feature) {
		List<HyFeature> features = feature.getModel().getFeatures();
		
		if (!features.isEmpty()) {
			featureToLayouterMap.put(feature, new DwFeatureTreeLayouter(feature));
		}
	}	
}
