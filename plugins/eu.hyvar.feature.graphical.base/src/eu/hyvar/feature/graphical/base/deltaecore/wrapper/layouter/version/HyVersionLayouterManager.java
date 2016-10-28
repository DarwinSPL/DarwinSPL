package eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyVersion;

/**
 * Singleton (this can only be a singleton as the respective layouters are created per version instance, i.e., unique even over model bounds)
 * 
 * Each Feature with versions needs such a tree in order to organize the versions. In other words, each version tree has one layouter. They are
 * organized with the help of this class
 * 
 * The reason for each VersionTree having its own layouter is that these very layouters are accessed during redrawing in order to get the coordinates
 * of the single elements. A recalculation is not performed until there is a change in the layout.
 */
public class HyVersionLayouterManager {
	private static HyVersionLayouterManager instance = null;

	protected static HyVersionLayouterManager getInstance() {
		if (instance == null) {
			instance = new HyVersionLayouterManager();
		}

		return instance;
	}


	private Map<HyFeature, HyVersionTreeLayouter> featureToLayouterMap;

	private HyVersionLayouterManager() {
		featureToLayouterMap = new HashMap<HyFeature, HyVersionTreeLayouter>();
	}


	/**
	 * This method retrieves the appropriate layouter from a map. If there is no such layouter, a new one will be created and returned.
	 */
	public static HyVersionTreeLayouter getLayouter(HyFeature feature, Date date) {
		return getInstance().doGetLayouter(feature, date);
	}

	private HyVersionTreeLayouter doGetLayouter(HyFeature feature, Date date) {
		if (!featureToLayouterMap.containsKey(feature)) {
			doUpdateLayouter(feature, date);
		}

		return featureToLayouterMap.get(feature);
	}

	public static void updateLayouter(HyFeature feature, Date date) {
		getInstance().doUpdateLayouter(feature, date);
	}

	private void doUpdateLayouter(HyFeature feature, Date date) {
		List<HyVersion> versions = HyEvolutionUtil.getValidTemporalElements(feature.getVersions(), date);
		
		if (!versions.isEmpty()) {
			featureToLayouterMap.put(feature, new HyVersionTreeLayouter(feature, date));
		}
	}
}
