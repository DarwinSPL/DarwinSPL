package eu.hyvar.feature.graphical.editor.util;

import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.graphical.editor.predicates.HyGroupTypeEmptyCompositionsPredicate;
import eu.hyvar.feature.graphical.editor.predicates.HyGroupTypeUnlogicalDatesPredicate;

public class HyGroupEditorUtil {
	public static void cleanGroupTypes(HyGroup group){
		HyGroupTypeUnlogicalDatesPredicate<Object> predicate = new HyGroupTypeUnlogicalDatesPredicate<>();
		
		group.getTypes().removeIf(predicate);
	}
	
	public static void cleanGroupCompositions(HyGroup group){
		HyGroupTypeEmptyCompositionsPredicate<Object> predicate = new HyGroupTypeEmptyCompositionsPredicate<>();
		
		group.getTypes().removeIf(predicate);		
	}
}
