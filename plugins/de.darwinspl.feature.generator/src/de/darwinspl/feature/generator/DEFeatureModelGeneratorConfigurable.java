package de.darwinspl.feature.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.deltaecore.feature.DEFeatureModel;
import org.deltaecore.feature.generator.DEFeatureModelGenerator;

public class DEFeatureModelGeneratorConfigurable extends DEFeatureModelGenerator {

	public enum OptionsEnum {
		CHILD_FEATURE_FACTOR_AVERAGE, CHILD_FEATURE_FACTOR_VARIANCE, CHILD_FEATURE_FACTOR_VARIANCE_PROBABILITY,
		CHILD_GROUP_FACTOR_AVERAGE, CHILD_GROUP_FACTOR_VARIANCE, CHILD_GROUP_FACTOR_VARIANCE_PROBABILITY,
		FEATURE_TREE_DEPTH_AVERAGE, FEATURE_TREE_DEPTH_VARIANCE, FEATURE_TREE_DEPTH_VARIANCE_PROBABILITY,
		VERSION_TREE_BRANCHING_FACTOR_AVERAGE, VERSION_TREE_BRANCHING_FACTOR_VARIANCE, VERSION_TREE_BRANCHING_FACTOR_VARIANCE_PROBABILITY,
		VERSION_TREE_DEPTH_AVERAGE, VERSION_TREE_DEPTH_VARIANCE, VESRION_TREE_DEPTH_VARIANCE_PROBABILITY
	};

	public DEFeatureModel generateFeatureModel(Map<OptionsEnum, Double> optionsMap) {
		Map<OptionsEnum, Double> oldValues = setOptions(optionsMap);

		DEFeatureModel generatedModel = generateFeatureModel();

		setOptions(oldValues);

		return generatedModel;
	}

	/**
	 * 
	 * @param optionsMap
	 * @return oldValues
	 */
	protected Map<OptionsEnum, Double> setOptions(Map<OptionsEnum, Double> optionsMap) {
		Map<OptionsEnum, Double> oldValues = new HashMap<OptionsEnum, Double>();

		for (Entry<OptionsEnum, Double> kvp : optionsMap.entrySet()) {
			Double newValue = kvp.getValue();

			double oldValue = 0.0;

			switch (kvp.getKey()) {
			case CHILD_FEATURE_FACTOR_AVERAGE:
				oldValue = getChildFeatureFactorAverage();
				setChildFeatureFactorAverage(newValue.intValue());
				break;
			case CHILD_FEATURE_FACTOR_VARIANCE:
				oldValue = getChildFeatureFactorVariance();
				setChildFeatureFactorVariance(newValue.intValue());
				break;
			case CHILD_FEATURE_FACTOR_VARIANCE_PROBABILITY:
				oldValue = getChildFeatureFactorVarianceProbability();
				setChildFeatureFactorVarianceProbability(newValue);
				break;
			case CHILD_GROUP_FACTOR_AVERAGE:
				oldValue = getChildGroupFactorAverage();
				setChildGroupFactorAverage(newValue.intValue());
				break;
			case CHILD_GROUP_FACTOR_VARIANCE:
				oldValue = getChildGroupFactorVariance();
				setChildGroupFactorVariance(newValue.intValue());
				break;
			case CHILD_GROUP_FACTOR_VARIANCE_PROBABILITY:
				oldValue = getChildGroupFactorVarianceProbability();
				setChildGroupFactorVarianceProbability(newValue);
				break;
			case FEATURE_TREE_DEPTH_AVERAGE:
				oldValue = getFeatureTreeDepthAverage();
				setFeatureTreeDepthAverage(newValue.intValue());
				break;
			case FEATURE_TREE_DEPTH_VARIANCE:
				oldValue = getFeatureTreeDepthVariance();
				setFeatureTreeDepthVariance(newValue.intValue());
				break;
			case FEATURE_TREE_DEPTH_VARIANCE_PROBABILITY:
				oldValue = getFeatureTreeDepthVarianceProbability();
				setFeatureTreeDepthVarianceProbability(newValue);
				break;
			case VERSION_TREE_BRANCHING_FACTOR_AVERAGE:
				oldValue = getVersionTreeBranchingFactorAverage();
				setVersionTreeBranchingFactorAverage(newValue.intValue());
				break;
			case VERSION_TREE_BRANCHING_FACTOR_VARIANCE:
				oldValue = getVersionTreeBranchingFactorVariance();
				setVersionTreeBranchingFactorVariance(newValue.intValue());
				break;
			case VERSION_TREE_BRANCHING_FACTOR_VARIANCE_PROBABILITY:
				oldValue = getVersionTreeBranchingFactorVarianceProbability();
				setVersionTreeBranchingFactorVarianceProbability(newValue);
				break;
			case VERSION_TREE_DEPTH_AVERAGE:
				oldValue = getVersionTreeDepthAverage();
				setVersionTreeDepthAverage(newValue.intValue());
				break;
			case VERSION_TREE_DEPTH_VARIANCE:
				oldValue = getVersionTreeDepthVariance();
				setVersionTreeDepthVariance(newValue.intValue());
				break;
			case VESRION_TREE_DEPTH_VARIANCE_PROBABILITY:
				oldValue = getVersionTreeDepthVarianceProbability();
				setVersionTreeDepthVarianceProbability(newValue);
				break;
			}

			oldValues.put(kvp.getKey(), oldValue);

		}

		return oldValues;
	}
}
