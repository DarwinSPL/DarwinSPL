/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.util;

import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyStringValue;
import eu.hyvar.dataValues.HyValue;
import eu.hyvar.mspl.manifest.HyManifest;
import eu.hyvar.mspl.manifest.HySPLImplementation;
import eu.hyvar.mspl.manifest.HySPLSignature;
import eu.hyvar.mspl.manifest.HyTimedDependencies;
import eu.hyvar.mspl.manifest.HyTimedImplementationLink;
import eu.hyvar.mspl.manifest.HyTimedImplementations;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.eclipse.emf.ecore.EObject;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractHymanifestInterpreter<ResultType, ContextType> {
	
	private Stack<EObject> interpretationStack = new Stack<EObject>();
	private List<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestInterpreterListener> listeners = new ArrayList<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestInterpreterListener>();
	private EObject nextObjectToInterprete;
	private ContextType currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof eu.hyvar.mspl.manifest.HySPLImplementation) {
			result = interprete_eu_hyvar_mspl_manifest_HySPLImplementation((eu.hyvar.mspl.manifest.HySPLImplementation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.mspl.manifest.HySPLSignature) {
			result = interprete_eu_hyvar_mspl_manifest_HySPLSignature((eu.hyvar.mspl.manifest.HySPLSignature) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.mspl.manifest.HyManifest) {
			result = interprete_eu_hyvar_mspl_manifest_HyManifest((eu.hyvar.mspl.manifest.HyManifest) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.mspl.manifest.HyTimedDependencies) {
			result = interprete_eu_hyvar_mspl_manifest_HyTimedDependencies((eu.hyvar.mspl.manifest.HyTimedDependencies) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.mspl.manifest.HyTimedImplementations) {
			result = interprete_eu_hyvar_mspl_manifest_HyTimedImplementations((eu.hyvar.mspl.manifest.HyTimedImplementations) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.mspl.manifest.HyTimedImplementationLink) {
			result = interprete_eu_hyvar_mspl_manifest_HyTimedImplementationLink((eu.hyvar.mspl.manifest.HyTimedImplementationLink) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.dataValues.HyNumberValue) {
			result = interprete_eu_hyvar_dataValues_HyNumberValue((eu.hyvar.dataValues.HyNumberValue) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.dataValues.HyStringValue) {
			result = interprete_eu_hyvar_dataValues_HyStringValue((eu.hyvar.dataValues.HyStringValue) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.dataValues.HyBooleanValue) {
			result = interprete_eu_hyvar_dataValues_HyBooleanValue((eu.hyvar.dataValues.HyBooleanValue) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.dataValues.HyEnumValue) {
			result = interprete_eu_hyvar_dataValues_HyEnumValue((eu.hyvar.dataValues.HyEnumValue) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.dataValues.HyValue) {
			result = interprete_eu_hyvar_dataValues_HyValue((eu.hyvar.dataValues.HyValue) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.dataValues.HyEnum) {
			result = interprete_eu_hyvar_dataValues_HyEnum((eu.hyvar.dataValues.HyEnum) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.dataValues.HyEnumLiteral) {
			result = interprete_eu_hyvar_dataValues_HyEnumLiteral((eu.hyvar.dataValues.HyEnumLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_eu_hyvar_mspl_manifest_HyManifest(HyManifest hyManifest, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_mspl_manifest_HySPLImplementation(HySPLImplementation hySPLImplementation, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_mspl_manifest_HySPLSignature(HySPLSignature hySPLSignature, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_mspl_manifest_HyTimedDependencies(HyTimedDependencies hyTimedDependencies, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_mspl_manifest_HyTimedImplementations(HyTimedImplementations hyTimedImplementations, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_mspl_manifest_HyTimedImplementationLink(HyTimedImplementationLink hyTimedImplementationLink, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_dataValues_HyNumberValue(HyNumberValue hyNumberValue, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_dataValues_HyValue(HyValue hyValue, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_dataValues_HyStringValue(HyStringValue hyStringValue, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_dataValues_HyBooleanValue(HyBooleanValue hyBooleanValue, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_dataValues_HyEnum(HyEnum hyEnum, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_dataValues_HyEnumLiteral(HyEnumLiteral hyEnumLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_dataValues_HyEnumValue(HyEnumValue hyEnumValue, ContextType context) {
		return null;
	}
	
	private void notifyListeners(EObject element) {
		for (eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestInterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(Collection<? extends EObject> objects) {
		for (EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(Collection<? extends EObject> objects) {
		List<EObject> reverse = new ArrayList<EObject>(objects.size());
		reverse.addAll(objects);
		Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(EObject root) {
		List<EObject> objects = new ArrayList<EObject>();
		objects.add(root);
		Iterator<EObject> it = root.eAllContents();
		while (it.hasNext()) {
			EObject eObject = (EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestInterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public Stack<EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public ContextType getCurrentContext() {
		return currentContext;
	}
	
}
