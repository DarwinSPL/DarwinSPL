package eu.hyvar.feature.graphical.editor.predicates;

import java.util.function.Predicate;

import eu.hyvar.feature.HyGroupType;

@SuppressWarnings("hiding")
public class HyGroupTypeUnlogicalDatesPredicate<Object> implements Predicate<Object> {
	@Override
	public boolean test(Object type) {
		if(type instanceof HyGroupType){
			HyGroupType groupType = (HyGroupType)type;
			
			if(groupType.getValidSince() != null && groupType.getValidUntil() != null &&
			   groupType.getValidSince().equals(groupType.getValidUntil())){
				return true;
			}
		}

		return false;
	}  
}