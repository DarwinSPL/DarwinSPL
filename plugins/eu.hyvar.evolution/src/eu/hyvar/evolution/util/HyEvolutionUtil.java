package eu.hyvar.evolution.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.evolution.HyEvolvedElementsContainer;
import eu.hyvar.evolution.HyLinearTemporalElement;
import eu.hyvar.evolution.HyModelDiff;
import eu.hyvar.evolution.HyTemporalElement;

public class HyEvolutionUtil {

	/**
	 * Returns diff container which consists of the origin and evolved model
	 * (copies) and the respective removed and added elements (each from the
	 * respective copy). Should be way slower than getEvolvedElements as a diff
	 * is computed by iterating over elements
	 * 
	 * @param model
	 * @param originDate
	 * @param evolvedDate
	 * @return
	 */
	public static HyModelDiff getModelDiff(EObject model, Date originDate, Date evolvedDate) {
		List<EObject> newElements = new ArrayList<EObject>();
		List<EObject> removedElements = new ArrayList<EObject>();

		EObject originModel = getCopyOfValidModel(model, originDate);
		EObject evolvedModel = getCopyOfValidModel(model, evolvedDate);

		HyEvolvedElementsContainer evolvedElements = getEvolvedElements(model, originDate, evolvedDate);

		// TreeIterator<EObject> contentIterator = model.eAllContents();
		// while(contentIterator.hasNext()) {
		// contentIterator.next();
		// }

		TreeIterator<EObject> evolvedIterator = evolvedModel.eAllContents();
		while (evolvedIterator.hasNext()) {
			EObject evolvedElement = evolvedIterator.next();
			for (EObject newElement : evolvedElements.getNewElements()) {
				if (EcoreUtil.equals(newElement, evolvedElement)) {
					newElements.add(evolvedElement);
				}
			}
		}

		TreeIterator<EObject> originIterator = originModel.eAllContents();
		while (originIterator.hasNext()) {
			EObject originElement = originIterator.next();

			for (EObject removedElement : evolvedElements.getRemovedElements()) {
				if (EcoreUtil.equals(removedElement, originElement)) {
					removedElements.add(originElement);
				}
			}
		}

		HyEvolvedElementsContainer evolvedElementsPerModel = new HyEvolvedElementsContainer(newElements,
				removedElements);

		HyModelDiff diff = new HyModelDiff(originModel, evolvedModel, evolvedElementsPerModel);

		return diff;
	}

	/**
	 * Returns a container for evolved elements (new and removed) of the given
	 * model. Elements which are added and again removed between those dates are
	 * not considered
	 * 
	 * @param model
	 * @param originDate
	 * @param evolvedDate
	 * @return
	 */
	public static HyEvolvedElementsContainer getEvolvedElements(EObject model, Date originDate, Date evolvedDate) {
		List<EObject> newElements = new ArrayList<EObject>();
		List<EObject> removedElements = new ArrayList<EObject>();

		TreeIterator<EObject> modelIterator = model.eAllContents();
		while (modelIterator.hasNext()) {
			EObject modelObject = modelIterator.next();
			if (modelObject instanceof HyTemporalElement) {
				HyTemporalElement evolvedElement = (HyTemporalElement) modelObject;

				boolean validAtOriginDate = isValid(evolvedElement, originDate);
				boolean validAtEvolvedDate = isValid(evolvedElement, evolvedDate);

				if (validAtEvolvedDate && !validAtOriginDate) {
					newElements.add(evolvedElement);
				} else if (validAtOriginDate && !validAtEvolvedDate) {
					removedElements.add(evolvedElement);
				}
			}
		}

		HyEvolvedElementsContainer evolvedElements = new HyEvolvedElementsContainer(newElements, removedElements);
		return evolvedElements;
	}

	/**
	 * Return type equals input type. IDs are preserved
	 * 
	 * @param model
	 * @param date
	 * @return
	 */
	public static <T extends EObject> T getCopyOfValidModel(T model, Date date) {
		HyEvolutionCopier copier = new HyEvolutionCopier();
		EObject result = copier.copy(model);
		copier.copyReferences();

		@SuppressWarnings("unchecked")
		T copiedModel = (T) result;

		removeAllInvalidElements(copiedModel, date);
		return copiedModel;
	}
	
	/**
	 * Return type equals input type. IDs NOT preserved
	 * 
	 * @param model
	 * @param date
	 * @return
	 */
	public static <T extends EObject> T getCopyOfValidModelWithNewIds(T model, Date date) {
		T copiedModel = EcoreUtil.copy(model);
		removeAllInvalidElements(copiedModel, date);
		return copiedModel;
	}

	/**
	 * Use with caution! Deletes elements from model with HyTemporalElements!
	 * 
	 * @param featureModel
	 * @param date
	 */
	public static void removeAllInvalidElements(EObject model, Date date) {
		List<EObject> eObjectsToRemove = new ArrayList<EObject>();
		{
			TreeIterator<EObject> iterator = model.eAllContents();

			while (iterator.hasNext()) {
				EObject content = iterator.next();
				if (content instanceof HyTemporalElement) {
					if (!isValid(((HyTemporalElement) content), date)) {
						// EcoreUtil.remove(content);
						eObjectsToRemove.add(content);
					}
				}
			}

		}

		for (EObject eObjectToRemove : eObjectsToRemove) {
			EcoreUtil.delete(eObjectToRemove, true);
		}
	}

	/**
	 * Checks if an element is valid at a given date
	 * 
	 * @param temporalElement
	 * @param date
	 * @return
	 */
	public static boolean isValid(HyTemporalElement temporalElement, Date date) {
		if (date == null) {
			if (temporalElement.getValidSince() == null && temporalElement.getValidUntil() == null) {
				return true;
			} else {
				return false;
			}
		}

		if ((temporalElement.getValidSince() == null || temporalElement.getValidSince().before(date)
				|| temporalElement.getValidSince().equals(date))
				&& (temporalElement.getValidUntil() == null || temporalElement.getValidUntil().after(date))) {
			return true;
		}

		return false;
	}
	
	/**
	 * Checks if the validity of @elementToCheck is within the validity of @elementToCheckAgainst
	 * Usable, e.g., to check if a constraint's ( @elementToCheck ) validity is no longer than it's referencing features' validity ( @elementToCheckAgainst )  
	 * @param elementToCheck
	 * @param elementToCheckAgainst
	 * @return
	 */
	public static boolean isWithinValidityOf(HyTemporalElement elementToCheck, HyTemporalElement elementToCheckAgainst) {
		if(elementToCheck.getValidSince() == null && elementToCheckAgainst.getValidSince() != null) {
			return false;
		}
		else if(elementToCheck.getValidSince() != null && elementToCheckAgainst.getValidSince() != null && elementToCheck.getValidSince().before(elementToCheckAgainst.getValidSince())) {
			return false;
		}
		else if(elementToCheck.getValidUntil() == null && elementToCheckAgainst.getValidUntil() != null) {
			return false;
		}
		else if(elementToCheck.getValidUntil() != null && elementToCheckAgainst.getValidUntil() != null && elementToCheck.getValidUntil().after(elementToCheckAgainst.getValidUntil())) {
			return false;
		}
		return true;
	}
	
	/**
	 * Checks if the validity of @elementToCheck is within the validity of each of @elementsToCheckAgainst
	 * Usable, e.g., to check if a constraint's ( @elementToCheck ) validity is no longer than it's referencing features' validity ( @elementsToCheckAgainst )  
	 * @param elementToCheck
	 * @param elementsToCheckAgainst
	 * @return
	 */
	public static boolean isWithinValidityOf(HyTemporalElement elementToCheck, List<HyTemporalElement> elementsToCheckAgainst) {
		for(HyTemporalElement elementToCheckAgainst: elementsToCheckAgainst) {
			if(!isWithinValidityOf(elementToCheck, elementToCheckAgainst)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if the each validity of @elementsToCheck is within the validity of @elementToCheckAgainst
	 * Usable, e.g., to check if a constraint's ( @elementsToCheck ) validity is no longer than it's referencing features' validity ( @elementToCheckAgainst )  
	 * @param elementsToCheck
	 * @param elementToCheckAgainst
	 * @return
	 */
	public static boolean areWithinValidityOf(List<HyTemporalElement> elementsToCheck, HyTemporalElement elementToCheckAgainst) {
		for(HyTemporalElement elementToCheck: elementsToCheck) {
			if(!isWithinValidityOf(elementToCheck, elementToCheckAgainst)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if the each validity of @elementsToCheck is within the validity of each @elementsToCheckAgainst
	 * Usable, e.g., to check if a constraint's ( @elementsToCheck ) validity is no longer than it's referencing features' validity ( @elementsToCheckAgainst )  
	 * @param elementsToCheck
	 * @param elementsToCheckAgainst
	 * @return
	 */
	public static boolean areWithinValitiyOf(List<HyTemporalElement> elementsToCheck, List<HyTemporalElement> elementsToCheckAgainst) {
		for(HyTemporalElement elementToCheck: elementsToCheck) {
			if(!isWithinValidityOf(elementToCheck, elementsToCheckAgainst)) {
				return false;
			}
		}
		return true;
	}

	// With supersedes
	public static HyLinearTemporalElement getMostRecentLinearTemporalElement(List<HyLinearTemporalElement> elements) {
		if (elements == null || elements.isEmpty()) {
			System.err.println(
					"Something bad happened. List<LinearTemporalElement> given to getMostRecentLinearTemporalElement(...) in HyEvolutionUtil.java was null or empty");
			return null;
		}

		for (HyLinearTemporalElement lTE : elements) {
			if (lTE.getSupersedingElement() == null) {
				return lTE;
			}
		}

		return null;
	}

	// TODO assumption only one valid temporal element at a time, check that?
	public static <T extends HyTemporalElement> T getValidTemporalElement(EList<T> elements, Date date) {
		if (elements == null || elements.isEmpty()) {
			// TODO proper logging
//			System.err.println(
//					"Something bad happened. EList<?> given to getValidTemporalElement(...) in HyEvolutionUtil.java was null or empty");
			return null;
		}

		if (date == null) {
			if(elements.size() == 1) {
				return elements.get(0);
			}
			else {
				System.err.println(
						"Something bad happened. Date given to getValidTemporalElement(...) in HyEvolutionUtil.java was null and more than one element was present.");
				return null;				
			}
		}

		for (T element : elements) {
			if (isValid(element, date)) {
				return element;
			}
		}

		return null;
	}

	/**
	 * Non copy
	 * 
	 * @param elements
	 * @param date
	 * @return
	 */
	public static <T extends HyTemporalElement> List<T> getValidTemporalElements(List<T> elements, Date date) {
		List<T> validElements = new ArrayList<T>(elements.size());

		if (elements == null || elements.isEmpty()) {
			return validElements;
		}

		if (date == null) {
//			System.out.println(
//					"Date given to getValidTemporalElements(...) in HyEvolutionUtil.java was null. Returning all elements!");
			validElements.addAll(elements);
			return validElements;
		}

		for (T element : elements) {
			if (isValid(element, date)) {
				validElements.add(element);
			}
		}

		return validElements;
	}

	/**
	 * Returns a sorted list of all available dates of HyTemporalElements in the
	 * given model
	 * 
	 * @param model
	 * @return
	 */
	public static List<Date> collectDates(EObject model) {
		// NOTE: Check if equals and identity work for hash set.
		Set<Date> rawDates = new HashSet<Date>();

		Iterator<EObject> iterator = model.eAllContents();
		// boolean validSinceNull = false;

		while (iterator.hasNext()) {
			EObject eObject = iterator.next();

			if (eObject instanceof HyTemporalElement) {
				HyTemporalElement temporalElement = (HyTemporalElement) eObject;
				Date validSince = temporalElement.getValidSince();

				if (validSince != null) {
					rawDates.add(validSince);
					// } else {
					// validSinceNull = true;
				}

				Date validUntil = temporalElement.getValidUntil();

				if (validUntil != null) {
					rawDates.add(validUntil);
				}
			}
		}

		List<Date> dates = new ArrayList<Date>(rawDates);

		Collections.sort(dates);

		return dates;
	}
	
	/**
	 * Collects dates of valid until and valid since of the given elements
	 * @param elements
	 * @return sorted list of unique dates (created using a set)
	 */
	public static List<Date> collectDates(List<? extends HyTemporalElement> elements) {
		// NOTE: Check if equals and identity work for hash set.
		Set<Date> rawDates = new HashSet<Date>();

		for (HyTemporalElement temporalElement : elements) {
			Date validSince = temporalElement.getValidSince();

			if (validSince != null) {
				rawDates.add(validSince);
				// } else {
				// validSinceNull = true;
			}

			Date validUntil = temporalElement.getValidUntil();

			if (validUntil != null) {
				rawDates.add(validUntil);
			}
		}
		List<Date> dates = new ArrayList<Date>(rawDates);

		Collections.sort(dates);

		return dates;
	}

	public static boolean modelHasValiditySinceNull(EObject model) {
		Iterator<EObject> iterator = model.eAllContents();

		while (iterator.hasNext()) {
			EObject eObject = iterator.next();

			if (eObject instanceof HyTemporalElement) {
				HyTemporalElement temporalElement = (HyTemporalElement) eObject;
				Date validSince = temporalElement.getValidSince();

				if (validSince == null) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean modelHasValidityUntilNull(EObject model) {
		Iterator<EObject> iterator = model.eAllContents();

		while (iterator.hasNext()) {
			EObject eObject = iterator.next();

			if (eObject instanceof HyTemporalElement) {
				HyTemporalElement temporalElement = (HyTemporalElement) eObject;
				Date validUntil = temporalElement.getValidUntil();

				if (validUntil == null) {
					return true;
				}
			}
		}

		return false;
	}

	

	/**
	 * Returns all LinearTemporalElements which follow element
	 * @param element
	 * @return
	 */
	public static List<HyLinearTemporalElement> getAllSupersedingElements(HyLinearTemporalElement element) {
		List<HyLinearTemporalElement> linearTemporalElements = new ArrayList<HyLinearTemporalElement>();
		
		if(element == null) {
			return linearTemporalElements;
		}
		
		linearTemporalElements.add(element.getSupersedingElement());
		linearTemporalElements.addAll(getAllSupersedingElements(element.getSupersedingElement()));
		
		return linearTemporalElements;
	}
}
