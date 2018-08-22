/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.util;

import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyAdditionExpression;
import eu.hyvar.feature.expression.HyAndExpression;
import eu.hyvar.feature.expression.HyArithmeticalComparisonExpression;
import eu.hyvar.feature.expression.HyArithmeticalValueAtomicExpression;
import eu.hyvar.feature.expression.HyArithmeticalValueBinaryOperationExpression;
import eu.hyvar.feature.expression.HyArithmeticalValueExpression;
import eu.hyvar.feature.expression.HyArithmeticalValueUnaryOperationExpression;
import eu.hyvar.feature.expression.HyAtomicExpression;
import eu.hyvar.feature.expression.HyAttributeReferenceExpression;
import eu.hyvar.feature.expression.HyBinaryExpression;
import eu.hyvar.feature.expression.HyBooleanValueExpression;
import eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyContextInformationReferenceExpression;
import eu.hyvar.feature.expression.HyDivisionExpression;
import eu.hyvar.feature.expression.HyEquivalenceExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyIfPossibleExpression;
import eu.hyvar.feature.expression.HyImpliesExpression;
import eu.hyvar.feature.expression.HyMaximumExpression;
import eu.hyvar.feature.expression.HyMinimumExpression;
import eu.hyvar.feature.expression.HyModuloExpression;
import eu.hyvar.feature.expression.HyMultiplicationExpression;
import eu.hyvar.feature.expression.HyNegationExpression;
import eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression;
import eu.hyvar.feature.expression.HyNestedExpression;
import eu.hyvar.feature.expression.HyNotExpression;
import eu.hyvar.feature.expression.HyOrExpression;
import eu.hyvar.feature.expression.HyRelativeVersionRestriction;
import eu.hyvar.feature.expression.HySetExpression;
import eu.hyvar.feature.expression.HySubtractionExpression;
import eu.hyvar.feature.expression.HyUnaryExpression;
import eu.hyvar.feature.expression.HyValueExpression;
import eu.hyvar.feature.expression.HyVersionRangeRestriction;
import eu.hyvar.feature.expression.HyVersionRestriction;
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
public class AbstractHyconstraintsInterpreter<ResultType, ContextType> {
	
	private Stack<EObject> interpretationStack = new Stack<EObject>();
	private List<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsInterpreterListener> listeners = new ArrayList<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsInterpreterListener>();
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
		if (object instanceof eu.hyvar.feature.constraint.HyConstraint) {
			result = interprete_eu_hyvar_feature_constraint_HyConstraint((eu.hyvar.feature.constraint.HyConstraint) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.constraint.HyConstraintModel) {
			result = interprete_eu_hyvar_feature_constraint_HyConstraintModel((eu.hyvar.feature.constraint.HyConstraintModel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyAtomicExpression) {
			result = interprete_eu_hyvar_feature_expression_HyAtomicExpression((eu.hyvar.feature.expression.HyAtomicExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyUnaryExpression) {
			result = interprete_eu_hyvar_feature_expression_HyUnaryExpression((eu.hyvar.feature.expression.HyUnaryExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyAndExpression) {
			result = interprete_eu_hyvar_feature_expression_HyAndExpression((eu.hyvar.feature.expression.HyAndExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyBinaryExpression) {
			result = interprete_eu_hyvar_feature_expression_HyBinaryExpression((eu.hyvar.feature.expression.HyBinaryExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HySetExpression) {
			result = interprete_eu_hyvar_feature_expression_HySetExpression((eu.hyvar.feature.expression.HySetExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyFeatureReferenceExpression) {
			result = interprete_eu_hyvar_feature_expression_HyFeatureReferenceExpression((eu.hyvar.feature.expression.HyFeatureReferenceExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression) {
			result = interprete_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression((eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression) {
			result = interprete_eu_hyvar_feature_expression_HyAbstractFeatureReferenceExpression((eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyExpression) {
			result = interprete_eu_hyvar_feature_expression_HyExpression((eu.hyvar.feature.expression.HyExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyRelativeVersionRestriction) {
			result = interprete_eu_hyvar_feature_expression_HyRelativeVersionRestriction((eu.hyvar.feature.expression.HyRelativeVersionRestriction) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyVersionRestriction) {
			result = interprete_eu_hyvar_feature_expression_HyVersionRestriction((eu.hyvar.feature.expression.HyVersionRestriction) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyBooleanValueExpression) {
			result = interprete_eu_hyvar_feature_expression_HyBooleanValueExpression((eu.hyvar.feature.expression.HyBooleanValueExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyVersionRangeRestriction) {
			result = interprete_eu_hyvar_feature_expression_HyVersionRangeRestriction((eu.hyvar.feature.expression.HyVersionRangeRestriction) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyNestedExpression) {
			result = interprete_eu_hyvar_feature_expression_HyNestedExpression((eu.hyvar.feature.expression.HyNestedExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyNotExpression) {
			result = interprete_eu_hyvar_feature_expression_HyNotExpression((eu.hyvar.feature.expression.HyNotExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyMinimumExpression) {
			result = interprete_eu_hyvar_feature_expression_HyMinimumExpression((eu.hyvar.feature.expression.HyMinimumExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyMaximumExpression) {
			result = interprete_eu_hyvar_feature_expression_HyMaximumExpression((eu.hyvar.feature.expression.HyMaximumExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyOrExpression) {
			result = interprete_eu_hyvar_feature_expression_HyOrExpression((eu.hyvar.feature.expression.HyOrExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyEquivalenceExpression) {
			result = interprete_eu_hyvar_feature_expression_HyEquivalenceExpression((eu.hyvar.feature.expression.HyEquivalenceExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyImpliesExpression) {
			result = interprete_eu_hyvar_feature_expression_HyImpliesExpression((eu.hyvar.feature.expression.HyImpliesExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyIfPossibleExpression) {
			result = interprete_eu_hyvar_feature_expression_HyIfPossibleExpression((eu.hyvar.feature.expression.HyIfPossibleExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyArithmeticalComparisonExpression) {
			result = interprete_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression((eu.hyvar.feature.expression.HyArithmeticalComparisonExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyAdditionExpression) {
			result = interprete_eu_hyvar_feature_expression_HyAdditionExpression((eu.hyvar.feature.expression.HyAdditionExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HySubtractionExpression) {
			result = interprete_eu_hyvar_feature_expression_HySubtractionExpression((eu.hyvar.feature.expression.HySubtractionExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyMultiplicationExpression) {
			result = interprete_eu_hyvar_feature_expression_HyMultiplicationExpression((eu.hyvar.feature.expression.HyMultiplicationExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyDivisionExpression) {
			result = interprete_eu_hyvar_feature_expression_HyDivisionExpression((eu.hyvar.feature.expression.HyDivisionExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyModuloExpression) {
			result = interprete_eu_hyvar_feature_expression_HyModuloExpression((eu.hyvar.feature.expression.HyModuloExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyArithmeticalValueBinaryOperationExpression) {
			result = interprete_eu_hyvar_feature_expression_HyArithmeticalValueBinaryOperationExpression((eu.hyvar.feature.expression.HyArithmeticalValueBinaryOperationExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyNegationExpression) {
			result = interprete_eu_hyvar_feature_expression_HyNegationExpression((eu.hyvar.feature.expression.HyNegationExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression) {
			result = interprete_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression((eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyArithmeticalValueUnaryOperationExpression) {
			result = interprete_eu_hyvar_feature_expression_HyArithmeticalValueUnaryOperationExpression((eu.hyvar.feature.expression.HyArithmeticalValueUnaryOperationExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyContextInformationReferenceExpression) {
			result = interprete_eu_hyvar_feature_expression_HyContextInformationReferenceExpression((eu.hyvar.feature.expression.HyContextInformationReferenceExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyAttributeReferenceExpression) {
			result = interprete_eu_hyvar_feature_expression_HyAttributeReferenceExpression((eu.hyvar.feature.expression.HyAttributeReferenceExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyValueExpression) {
			result = interprete_eu_hyvar_feature_expression_HyValueExpression((eu.hyvar.feature.expression.HyValueExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyArithmeticalValueAtomicExpression) {
			result = interprete_eu_hyvar_feature_expression_HyArithmeticalValueAtomicExpression((eu.hyvar.feature.expression.HyArithmeticalValueAtomicExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof eu.hyvar.feature.expression.HyArithmeticalValueExpression) {
			result = interprete_eu_hyvar_feature_expression_HyArithmeticalValueExpression((eu.hyvar.feature.expression.HyArithmeticalValueExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_eu_hyvar_feature_constraint_HyConstraint(HyConstraint hyConstraint, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_constraint_HyConstraintModel(HyConstraintModel hyConstraintModel, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyExpression(HyExpression hyExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyAtomicExpression(HyAtomicExpression hyAtomicExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyUnaryExpression(HyUnaryExpression hyUnaryExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyBinaryExpression(HyBinaryExpression hyBinaryExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HySetExpression(HySetExpression hySetExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyAbstractFeatureReferenceExpression(HyAbstractFeatureReferenceExpression hyAbstractFeatureReferenceExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyFeatureReferenceExpression(HyFeatureReferenceExpression hyFeatureReferenceExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression(HyConditionalFeatureReferenceExpression hyConditionalFeatureReferenceExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyVersionRestriction(HyVersionRestriction hyVersionRestriction, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyBooleanValueExpression(HyBooleanValueExpression hyBooleanValueExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyVersionRangeRestriction(HyVersionRangeRestriction hyVersionRangeRestriction, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyRelativeVersionRestriction(HyRelativeVersionRestriction hyRelativeVersionRestriction, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyNestedExpression(HyNestedExpression hyNestedExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyNotExpression(HyNotExpression hyNotExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyMinimumExpression(HyMinimumExpression hyMinimumExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyMaximumExpression(HyMaximumExpression hyMaximumExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyAndExpression(HyAndExpression hyAndExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyOrExpression(HyOrExpression hyOrExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyEquivalenceExpression(HyEquivalenceExpression hyEquivalenceExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyImpliesExpression(HyImpliesExpression hyImpliesExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyIfPossibleExpression(HyIfPossibleExpression hyIfPossibleExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression(HyArithmeticalComparisonExpression hyArithmeticalComparisonExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyArithmeticalValueExpression(HyArithmeticalValueExpression hyArithmeticalValueExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyArithmeticalValueBinaryOperationExpression(HyArithmeticalValueBinaryOperationExpression hyArithmeticalValueBinaryOperationExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyAdditionExpression(HyAdditionExpression hyAdditionExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HySubtractionExpression(HySubtractionExpression hySubtractionExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyMultiplicationExpression(HyMultiplicationExpression hyMultiplicationExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyDivisionExpression(HyDivisionExpression hyDivisionExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyModuloExpression(HyModuloExpression hyModuloExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyArithmeticalValueUnaryOperationExpression(HyArithmeticalValueUnaryOperationExpression hyArithmeticalValueUnaryOperationExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyNegationExpression(HyNegationExpression hyNegationExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression(HyNestedArithmeticalValueExpression hyNestedArithmeticalValueExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyArithmeticalValueAtomicExpression(HyArithmeticalValueAtomicExpression hyArithmeticalValueAtomicExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyContextInformationReferenceExpression(HyContextInformationReferenceExpression hyContextInformationReferenceExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyAttributeReferenceExpression(HyAttributeReferenceExpression hyAttributeReferenceExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_eu_hyvar_feature_expression_HyValueExpression(HyValueExpression hyValueExpression, ContextType context) {
		return null;
	}
	
	private void notifyListeners(EObject element) {
		for (eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsInterpreterListener listener : listeners) {
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
	
	public void addListener(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsInterpreterListener listener) {
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
