package de.darwinspl.anomalies.explanations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.darwinspl.feature.evolution.evolutionoperation.EvolutionOperationExplanation;
import eu.hyvar.context.contextValidity.HyValidityFormula;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

/**
 * 
 * @author Felix Franzke
 * 
 */
public class AnomalyConstraintExplanation  {
	
	private EObject affectedObject;
	private String translatedConstraint;
	private List<EvolutionOperationExplanation> evolutionOperationExplanations = new ArrayList<EvolutionOperationExplanation>();
	private Date date;
	
	
	public String explainConstraintString() {
		if (affectedObject instanceof HyRootFeature) {
			HyRootFeature rootFeature = (HyRootFeature) affectedObject;
			return explain(rootFeature);
		} else if (affectedObject instanceof HyFeature) {
			HyFeature feature = (HyFeature) affectedObject;
			return explain(feature);
		} else if (affectedObject instanceof HyConstraint) {
			HyConstraint constraint = (HyConstraint) affectedObject;
			return explain(constraint);
		} else if (affectedObject instanceof HyValidityFormula) {
			HyValidityFormula validityFormula = (HyValidityFormula) affectedObject;
			return explain(validityFormula);
		} else if (affectedObject instanceof HyGroup) {
			HyGroup group = (HyGroup) affectedObject;
			return explain(group);
		}
		return "";
	}
	
	public List<String> explainCausingOperations() {
		List<String> list = new ArrayList<String>();
		for (EvolutionOperationExplanation opExplanation : evolutionOperationExplanations) {
			if ((opExplanation.getEvolutionOperation().getEvoStep() == null && opExplanation.getEvolutionOperation().getEvoStep() == date)
					|| (opExplanation.getEvolutionOperation().getEvoStep() != null && opExplanation.getEvolutionOperation().getEvoStep().equals(date))) {
				list.add(opExplanation.explain());
			}
		}
		return list;
	}
	
	public List<String> explainInvolvedPastEvolutionOperations() {
		List<String> list = new ArrayList<String>();
		for (EvolutionOperationExplanation opExplanation : evolutionOperationExplanations) {
			if ((opExplanation.getEvolutionOperation().getEvoStep() == null && opExplanation.getEvolutionOperation().getEvoStep() == date)
					|| (opExplanation.getEvolutionOperation().getEvoStep() != null && opExplanation.getEvolutionOperation().getEvoStep().equals(date))) {
				
			} else {
				list.add(opExplanation.explain());
			}
		}
		return list;
	}

	public String explain() {
		String constraintStringExplanation = explainConstraintString();

		String evoOperationExplanation = "";
		if (evolutionOperationExplanations.size() > 0) {
			evoOperationExplanation = "\n>Evolution Operations:\n" + evoOperationExplanation;
			for (String s : explainCausingOperations()) {
				evoOperationExplanation += "CAUSING - " + s;
			}
			for (String s : explainInvolvedPastEvolutionOperations()) {
				evoOperationExplanation += "INVOLVED PAST - " + s;
			}
		}
		if (constraintStringExplanation.isEmpty()) {
			return translatedConstraint;
		} else {
			return constraintStringExplanation + "\n-> " + translatedConstraint + evoOperationExplanation;
		}
	}

	private String explain(HyRootFeature rootFeature) {
		String rootFeatureName = HyEvolutionUtil.getValidTemporalElement(rootFeature.getFeature().getNames(), date).getName();
		return rootFeatureName + " is root feature";
	}

	private String explain(HyFeature feature) {
		// HyFeature may stand for: version constraints, parent -> mandatory, feature = 0 if invalidFeature or invalidVersionOfValidFeature
		String featureName = HyEvolutionUtil.getValidTemporalElement(feature.getNames(), date).getName();
		return featureName + " is mandatory";
	}

	private String explain(HyConstraint constraint) {
		return "Cross-tree constraint";
	}

	private String explain(HyValidityFormula validityFormula) {
		return "Validity formula";
	}

	private String explain(HyGroup group) {
		// HyGroup may mean: f1 or f2 ... -> parent, parent -> f1 alt/and/or f2 ... , feature that is optional+hasnochild -> parent
		String featurenames = "";
		List<HyFeature> featureList = HyFeatureEvolutionUtil.getChildsOfGroup(group, date);
		for (HyFeature feature : featureList) {
			if (!featurenames.isEmpty()) {
				featurenames += ", ";
			}
			featurenames += HyEvolutionUtil.getValidTemporalElement(feature.getNames(), date).getName();
		}

		HyFeature parentFeature = HyFeatureEvolutionUtil.getParentOfGroup(group, date);
		String parentName = HyEvolutionUtil.getValidTemporalElement(parentFeature.getNames(), date).getName();

		String groupType = HyFeatureEvolutionUtil.getType(group, date).getType().getName();

		String beWord = (featureList.size() > 1) ? "are" : "is";
		return featurenames + " " + beWord + " in an " + groupType + "-group under " + parentName;
	}

	public EObject getAffectedObject() {
		return affectedObject;
	}

	public void setAffectedObject(EObject affectedObject) {
		this.affectedObject = affectedObject;
	}

	public String getTranslatedConstraint() {
		return translatedConstraint;
	}

	public void setTranslatedConstraint(String translatedConstraint) {
		this.translatedConstraint = translatedConstraint;
	}
	
	public void addEvolutionOperationExplanation(EvolutionOperationExplanation evolutionOperationExplanation) {
		for (EvolutionOperationExplanation existing : evolutionOperationExplanations) {
			if (existing.getEvolutionOperation() == evolutionOperationExplanation.getEvolutionOperation()) {
				return;
			}
		}
		evolutionOperationExplanations.add(evolutionOperationExplanation);
	}
	
	public List<EvolutionOperationExplanation> getEvolutionOperations() {
		return evolutionOperationExplanations;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}
}
