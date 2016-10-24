package eu.hyvar.feature.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * Container class to capture the diff of two HyFeatureModels
 * @author Michael Nieke
 *
 */
public class HyFeatureModelDiff {
	
	private EObject originFeatureModel;
	private EObject evolvedFeatureModel;
	
	private List<EObject> newElements;
	private List<EObject> removedElements;
	
//	private Map<HyNamedElement, HyName> changedNames;

	public HyFeatureModelDiff() {
		newElements = new ArrayList<EObject>();
		removedElements = new ArrayList<EObject>();
//		changedNames = new HashMap<HyNamedElement, HyName>();
	}
	
	public EObject getOriginFeatureModel() {
		return originFeatureModel;
	}

	public void setOriginFeatureModel(EObject originFeatureModel) {
		this.originFeatureModel = originFeatureModel;
	}

	public EObject getEvolvedFeatureModel() {
		return evolvedFeatureModel;
	}

	public void setEvolvedFeatureModel(EObject evolvedFeatureModel) {
		this.evolvedFeatureModel = evolvedFeatureModel;
	}

	public List<EObject> getNewElements() {
		return newElements;
	}

	public void setNewElements(List<EObject> newElements) {
		this.newElements = newElements;
	}

	public List<EObject> getRemovedElements() {
		return removedElements;
	}

	public void setRemovedElements(List<EObject> removedElements) {
		this.removedElements = removedElements;
	}

//	public Map<HyNamedElement, HyName> getChangedNames() {
//		return changedNames;
//	}
//
//	public void setChangedNames(Map<HyNamedElement, HyName> changedNames) {
//		this.changedNames = changedNames;
//	}
	
	
}
