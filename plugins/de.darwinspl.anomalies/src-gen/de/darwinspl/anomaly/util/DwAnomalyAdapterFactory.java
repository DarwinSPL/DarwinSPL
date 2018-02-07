/**
 */
package de.darwinspl.anomaly.util;

import de.darwinspl.anomaly.*;

import eu.hyvar.evolution.HyTemporalElement;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.darwinspl.anomaly.DwAnomalyPackage
 * @generated
 */
public class DwAnomalyAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DwAnomalyPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwAnomalyAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DwAnomalyPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DwAnomalySwitch<Adapter> modelSwitch =
		new DwAnomalySwitch<Adapter>() {
			@Override
			public Adapter caseDwAnomaly(DwAnomaly object) {
				return createDwAnomalyAdapter();
			}
			@Override
			public Adapter caseDwVoidFeatureModelAnomaly(DwVoidFeatureModelAnomaly object) {
				return createDwVoidFeatureModelAnomalyAdapter();
			}
			@Override
			public Adapter caseDwFeatureAnomaly(DwFeatureAnomaly object) {
				return createDwFeatureAnomalyAdapter();
			}
			@Override
			public Adapter caseDwFalseOptionalFeatureAnomaly(DwFalseOptionalFeatureAnomaly object) {
				return createDwFalseOptionalFeatureAnomalyAdapter();
			}
			@Override
			public Adapter caseDwDeadFeatureAnomaly(DwDeadFeatureAnomaly object) {
				return createDwDeadFeatureAnomalyAdapter();
			}
			@Override
			public Adapter caseHyTemporalElement(HyTemporalElement object) {
				return createHyTemporalElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.anomaly.DwAnomaly <em>Dw Anomaly</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.anomaly.DwAnomaly
	 * @generated
	 */
	public Adapter createDwAnomalyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.anomaly.DwVoidFeatureModelAnomaly <em>Dw Void Feature Model Anomaly</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.anomaly.DwVoidFeatureModelAnomaly
	 * @generated
	 */
	public Adapter createDwVoidFeatureModelAnomalyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.anomaly.DwFeatureAnomaly <em>Dw Feature Anomaly</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.anomaly.DwFeatureAnomaly
	 * @generated
	 */
	public Adapter createDwFeatureAnomalyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly <em>Dw False Optional Feature Anomaly</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly
	 * @generated
	 */
	public Adapter createDwFalseOptionalFeatureAnomalyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.darwinspl.anomaly.DwDeadFeatureAnomaly <em>Dw Dead Feature Anomaly</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.darwinspl.anomaly.DwDeadFeatureAnomaly
	 * @generated
	 */
	public Adapter createDwDeadFeatureAnomalyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.hyvar.evolution.HyTemporalElement <em>Hy Temporal Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.hyvar.evolution.HyTemporalElement
	 * @generated
	 */
	public Adapter createHyTemporalElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DwAnomalyAdapterFactory
