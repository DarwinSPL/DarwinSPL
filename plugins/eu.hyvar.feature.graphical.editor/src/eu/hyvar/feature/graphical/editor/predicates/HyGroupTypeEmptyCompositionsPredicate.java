package eu.hyvar.feature.graphical.editor.predicates;

import java.util.function.Predicate;

import eu.hyvar.feature.HyGroupComposition;

@SuppressWarnings("hiding")
public class HyGroupTypeEmptyCompositionsPredicate<Object> implements Predicate<Object> {
	@Override
	public boolean test(Object composition) {
		if(composition instanceof HyGroupComposition){
			HyGroupComposition groupComposition = (HyGroupComposition)composition;
			
			if(groupComposition.getFeatures().isEmpty()){
				return true;
			}
		}

		return false;
	}  
}		