package eu.hyvar.evolution;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

public class HyEvolvedElementsContainer {
	

	private List<EObject> newElements;
	private List<EObject> removedElements;
	
	public HyEvolvedElementsContainer() {
		newElements = new ArrayList<EObject>();
		removedElements = new ArrayList<EObject>();
	}
	
	public HyEvolvedElementsContainer(List<EObject> newElements, List<EObject> removedElements) {
		this.newElements = newElements;
		this.removedElements = removedElements;
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
	
	
}
