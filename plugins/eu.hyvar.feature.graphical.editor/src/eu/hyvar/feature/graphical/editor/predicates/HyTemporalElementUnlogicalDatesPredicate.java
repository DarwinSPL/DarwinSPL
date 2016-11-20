package eu.hyvar.feature.graphical.editor.predicates;

import java.util.Date;
import java.util.function.Predicate;

import eu.hyvar.evolution.HyTemporalElement;

@SuppressWarnings("hiding")
public class HyTemporalElementUnlogicalDatesPredicate<Object> implements Predicate<Object> {
	@Override
	public boolean test(Object type) {
		if(type instanceof HyTemporalElement){
			HyTemporalElement element = (HyTemporalElement)type;
			
			if(element.getValidSince() != null && element.getValidUntil() != null &&
			   element.getValidSince().equals(element.getValidUntil())){
				return true;
			}

			if(element.getValidUntil() != null && element.getValidUntil().equals(new Date(Long.MIN_VALUE))){
				return true;
			}
		}

		return false;
	}  
}