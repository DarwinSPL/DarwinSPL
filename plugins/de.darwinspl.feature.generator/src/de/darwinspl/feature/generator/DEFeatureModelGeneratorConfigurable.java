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
				oldValue = this.childFeatureFactorAverage;
				this.childFeatureFactorAverage = newValue.intValue();
				break;
			case CHILD_FEATURE_FACTOR_VARIANCE:
				oldValue = this.childFeatureFactorVariance;
				this.childFeatureFactorVariance = newValue.intValue();
				break;
			case CHILD_FEATURE_FACTOR_VARIANCE_PROBABILITY:
				oldValue = this.childFeatureFactorVarianceProbability;
				this.childFeatureFactorVarianceProbability = newValue;
				break;
			case CHILD_GROUP_FACTOR_AVERAGE:
				oldValue = this.childGroupFactorAverage;
				this.childGroupFactorAverage = newValue.intValue();
				break;
			case CHILD_GROUP_FACTOR_VARIANCE:
				oldValue = this.childGroupFactorVariance;
				this.childGroupFactorVariance = newValue.intValue();
				break;
			case CHILD_GROUP_FACTOR_VARIANCE_PROBABILITY:
				oldValue = this.childGroupFactorVarianceProbability;
				this.childGroupFactorVarianceProbability = newValue;
				break;
			case FEATURE_TREE_DEPTH_AVERAGE:
				oldValue = this.featureTreeDepthAverage;
				this.featureTreeDepthAverage = newValue.intValue();
				break;
			case FEATURE_TREE_DEPTH_VARIANCE:
				oldValue = this.featureTreeDepthVariance;
				this.featureTreeDepthVariance = newValue.intValue();
				break;
			case FEATURE_TREE_DEPTH_VARIANCE_PROBABILITY:
				oldValue = this.featureTreeDepthVarianceProbability;
				this.featureTreeDepthVarianceProbability = newValue;
				break;
			case VERSION_TREE_BRANCHING_FACTOR_AVERAGE:
				oldValue = this.versionTreeBranchingFactorAverage;
				this.versionTreeBranchingFactorAverage = newValue.intValue();
				break;
			case VERSION_TREE_BRANCHING_FACTOR_VARIANCE:
				oldValue = this.versionTreeBranchingFactorVariance;
				this.versionTreeBranchingFactorVariance = newValue.intValue();
				break;
			case VERSION_TREE_BRANCHING_FACTOR_VARIANCE_PROBABILITY:
				oldValue = this.versionTreeBranchingFactorVarianceProbability;
				this.versionTreeBranchingFactorVarianceProbability = newValue;
				break;
			case VERSION_TREE_DEPTH_AVERAGE:
				oldValue = this.versionTreeDepthAverage;
				this.versionTreeDepthAverage = newValue.intValue();
				break;
			case VERSION_TREE_DEPTH_VARIANCE:
				oldValue = this.versionTreeDepthVariance;
				this.versionTreeDepthVariance = newValue.intValue();
				break;
			case VESRION_TREE_DEPTH_VARIANCE_PROBABILITY:
				oldValue = this.versionTreeDepthVarianceProbability;
				this.versionTreeDepthVarianceProbability = newValue;
				break;
			}

			oldValues.put(kvp.getKey(), oldValue);

		}

		return oldValues;
	}
}
