package eu.hyvar.evolution;

import org.eclipse.emf.ecore.EObject;

public class HyModelDiff {

	private EObject originModel;
	private EObject evolvedModel;
	
	private HyEvolvedElementsContainer evolvedElements;

	public HyModelDiff() {
		evolvedElements = new HyEvolvedElementsContainer();
	}
	
	public HyModelDiff(EObject originModel, EObject evolvedModel, HyEvolvedElementsContainer evolvedElements) {
		this.evolvedElements = evolvedElements;
		this.evolvedModel = evolvedModel;
		this.originModel = originModel;
	}
	
	public EObject getOriginModel() {
		return originModel;
	}

	public void setOriginModel(EObject originModel) {
		this.originModel = originModel;
	}

	public EObject getEvolvedModel() {
		return evolvedModel;
	}

	public void setEvolvedModel(EObject evolvedModel) {
		this.evolvedModel = evolvedModel;
	}

	public HyEvolvedElementsContainer getEvolvedElements() {
		return evolvedElements;
	}

	public void setEvolvedElements(HyEvolvedElementsContainer evolvedElements) {
		this.evolvedElements = evolvedElements;
	}

	
}
