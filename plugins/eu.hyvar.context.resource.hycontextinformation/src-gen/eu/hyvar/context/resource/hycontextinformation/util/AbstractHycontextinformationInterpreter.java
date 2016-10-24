/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.util;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.HyContextualInformationBoolean;
import eu.hyvar.context.HyContextualInformationEnum;
import eu.hyvar.context.HyContextualInformationNumber;
import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyStringValue;
import eu.hyvar.dataValues.HyValue;
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
public class AbstractHycontextinformationInterpreter<ResultType, ContextType> {
	
	private Stack<EObject> interpretationStack = new Stack<EObject>();
	private List<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationInterpreterListener> listeners = new ArrayList<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationInterpreterListener>();
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
		if (object instanceof eu.hyvar.context.HyContextModel) {
			result = interprete_eu_hyvar_context_HyContextModel((eu.hyvar.context.HyContextModel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.context.HyContextualInformationEnum) {
			result = interprete_eu_hyvar_context_HyContextualInformationEnum((eu.hyvar.context.HyContextualInformationEnum) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.context.HyContextualInformationNumber) {
			result = interprete_eu_hyvar_context_HyContextualInformationNumber((eu.hyvar.context.HyContextualInformationNumber) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.context.HyContextualInformationBoolean) {
			result = interprete_eu_hyvar_context_HyContextualInformationBoolean((eu.hyvar.context.HyContextualInformationBoolean) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.context.HyContextualInformation) {
			result = interprete_eu_hyvar_context_HyContextualInformation((eu.hyvar.context.HyContextualInformation) object, context);
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
	
	public ResultType interprete_eu_hyvar_context_HyContextModel(HyContextModel hyContextModel, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_context_HyContextualInformationEnum(HyContextualInformationEnum hyContextualInformationEnum, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_context_HyContextualInformation(HyContextualInformation hyContextualInformation, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_context_HyContextualInformationNumber(HyContextualInformationNumber hyContextualInformationNumber, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_context_HyContextualInformationBoolean(HyContextualInformationBoolean hyContextualInformationBoolean, ContextType context) {
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
		for (eu.hyvar.context.resource.hycontextinformation.IHycontextinformationInterpreterListener listener : listeners) {
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
	
	public void addListener(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationInterpreterListener listener) {
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
