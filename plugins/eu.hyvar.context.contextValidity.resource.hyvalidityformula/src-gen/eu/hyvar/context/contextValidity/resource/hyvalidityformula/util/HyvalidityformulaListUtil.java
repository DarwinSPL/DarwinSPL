/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A utility class that encapsulates some case operations that need to be
 * performed unchecked, because of Java's type erasure.
 */
public class HyvalidityformulaListUtil {
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> castListUnchecked(Object list) {
		return (List<T>) list;
	}
	
	public static List<Object> copySafelyToObjectList(List<?> list) {
		Iterator<?> it = list.iterator();
		List<Object> castedCopy = new ArrayList<Object>();
		while (it.hasNext()) {
			castedCopy.add(it.next());
		}
		return castedCopy;
	}
}
