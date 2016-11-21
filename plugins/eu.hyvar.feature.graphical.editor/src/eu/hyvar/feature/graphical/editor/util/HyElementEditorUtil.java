package eu.hyvar.feature.graphical.editor.util;

import eu.hyvar.evolution.HyNamedElement;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.graphical.editor.predicates.HyGroupTypeEmptyCompositionsPredicate;
import eu.hyvar.feature.graphical.editor.predicates.HyTemporalElementUnlogicalDatesPredicate;

public class HyElementEditorUtil {
	public static void cleanGroupTypes(HyGroup group){
		HyTemporalElementUnlogicalDatesPredicate<Object> predicate = new HyTemporalElementUnlogicalDatesPredicate<>();
		
		group.getTypes().removeIf(predicate);
	}
	
	public static void cleanGroupCompositions(HyGroup group){
		HyGroupTypeEmptyCompositionsPredicate<Object> predicate = new HyGroupTypeEmptyCompositionsPredicate<>();
		
		group.getTypes().removeIf(predicate);		
	}
	
	public static void cleanNames(HyNamedElement namedElement){
		HyTemporalElementUnlogicalDatesPredicate<Object> predicate = new HyTemporalElementUnlogicalDatesPredicate<>();
		
		namedElement.getNames().removeIf(predicate);
	}
}
