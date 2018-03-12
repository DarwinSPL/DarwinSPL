/**
 */
package de.darwinspl.anomaly.impl;

import de.darwinspl.anomaly.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DwAnomalyFactoryImpl extends EFactoryImpl implements DwAnomalyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DwAnomalyFactory init() {
		try {
			DwAnomalyFactory theDwAnomalyFactory = (DwAnomalyFactory)EPackage.Registry.INSTANCE.getEFactory(DwAnomalyPackage.eNS_URI);
			if (theDwAnomalyFactory != null) {
				return theDwAnomalyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DwAnomalyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwAnomalyFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DwAnomalyPackage.DW_VOID_FEATURE_MODEL_ANOMALY: return createDwVoidFeatureModelAnomaly();
			case DwAnomalyPackage.DW_FALSE_OPTIONAL_FEATURE_ANOMALY: return createDwFalseOptionalFeatureAnomaly();
			case DwAnomalyPackage.DW_DEAD_FEATURE_ANOMALY: return createDwDeadFeatureAnomaly();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwVoidFeatureModelAnomaly createDwVoidFeatureModelAnomaly() {
		DwVoidFeatureModelAnomalyImpl dwVoidFeatureModelAnomaly = new DwVoidFeatureModelAnomalyImpl();
		return dwVoidFeatureModelAnomaly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwFalseOptionalFeatureAnomaly createDwFalseOptionalFeatureAnomaly() {
		DwFalseOptionalFeatureAnomalyImpl dwFalseOptionalFeatureAnomaly = new DwFalseOptionalFeatureAnomalyImpl();
		return dwFalseOptionalFeatureAnomaly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwDeadFeatureAnomaly createDwDeadFeatureAnomaly() {
		DwDeadFeatureAnomalyImpl dwDeadFeatureAnomaly = new DwDeadFeatureAnomalyImpl();
		return dwDeadFeatureAnomaly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwAnomalyPackage getDwAnomalyPackage() {
		return (DwAnomalyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DwAnomalyPackage getPackage() {
		return DwAnomalyPackage.eINSTANCE;
	}

} //DwAnomalyFactoryImpl
