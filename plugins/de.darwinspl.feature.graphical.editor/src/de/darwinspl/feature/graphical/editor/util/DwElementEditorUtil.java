package de.darwinspl.feature.graphical.editor.util;

import java.util.ArrayList;
import java.util.List;

import de.darwinspl.feature.graphical.editor.predicates.DwGroupTypeEmptyCompositionsPredicate;
import de.darwinspl.feature.graphical.editor.predicates.DwTemporalElementUnlogicalDatesPredicate;
import eu.hyvar.evolution.HyLinearTemporalElement;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyNamedElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;

public class DwElementEditorUtil {
	public static void cleanGroupTypes(HyGroup group){
		DwTemporalElementUnlogicalDatesPredicate<Object> predicate = new DwTemporalElementUnlogicalDatesPredicate<>();
		
		List<HyGroupType> unlogicalElements = new ArrayList<HyGroupType>();
		for(HyGroupType element : group.getTypes()){
			if(predicate.test(element)){
				HyLinearTemporalElement predecessor = element.getSupersededElement();
				HyLinearTemporalElement successor = element.getSupersedingElement();
				
				
				if(predecessor != null && successor != null){
					predecessor.setSupersedingElement(successor);
					successor.setSupersededElement(predecessor);
				}
				
				unlogicalElements.add(element);
			}
		}
		
		group.getTypes().removeAll(unlogicalElements);
			
	}
	
	public static void cleanGroupCompositions(HyGroup group){
		DwGroupTypeEmptyCompositionsPredicate<Object> predicate = new DwGroupTypeEmptyCompositionsPredicate<>();

		List<HyGroupComposition> unlogicalElements = new ArrayList<HyGroupComposition>();
		for(HyGroupComposition element : group.getParentOf()){
			if(predicate.test(element)){
				HyLinearTemporalElement predecessor = element.getSupersededElement();
				HyLinearTemporalElement successor = element.getSupersedingElement();
				
				if(predecessor != null && successor != null){
					predecessor.setSupersedingElement(successor);
					successor.setSupersededElement(predecessor);
				}
				
				unlogicalElements.add(element);
			}
		}
		
		group.getParentOf().removeAll(unlogicalElements);
			
	}
	
	public static void cleanNames(HyNamedElement namedElement){
		DwTemporalElementUnlogicalDatesPredicate<Object> predicate = new DwTemporalElementUnlogicalDatesPredicate<>();
		
		List<HyName> unlogicalElements = new ArrayList<HyName>();
		for(HyName element : namedElement.getNames()){
			if(predicate.test(element)){
				HyLinearTemporalElement predecessor = element.getSupersededElement();
				HyLinearTemporalElement successor = element.getSupersedingElement();
				
				if(predecessor != null && successor != null){
					predecessor.setSupersedingElement(successor);
					successor.setSupersededElement(predecessor);
				}
				
				unlogicalElements.add(element);
			}
		}
		
		namedElement.getNames().removeAll(unlogicalElements);
	}
	
	public static void cleanFeatureTypes(HyFeature feature){
		
		DwTemporalElementUnlogicalDatesPredicate<Object> predicate = new DwTemporalElementUnlogicalDatesPredicate<>();
		
		List<HyFeatureType> unlogicalElements = new ArrayList<HyFeatureType>();
		for(HyFeatureType element : feature.getTypes()){
			if(predicate.test(element)){
				HyLinearTemporalElement predecessor = element.getSupersededElement();
				HyLinearTemporalElement successor = element.getSupersedingElement();
				
				if(predecessor != null && successor != null){
					predecessor.setSupersedingElement(successor);
					successor.setSupersededElement(predecessor);
				}
				
				unlogicalElements.add(element);
			}
		}
		
		feature.getTypes().removeAll(unlogicalElements);
	}
}
