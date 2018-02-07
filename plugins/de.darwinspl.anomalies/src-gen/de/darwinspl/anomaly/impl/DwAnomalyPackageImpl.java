/**
 */
package de.darwinspl.anomaly.impl;

import de.darwinspl.anomaly.DwAnomaly;
import de.darwinspl.anomaly.DwAnomalyFactory;
import de.darwinspl.anomaly.DwAnomalyPackage;
import de.darwinspl.anomaly.DwDeadFeatureAnomaly;
import de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly;
import de.darwinspl.anomaly.DwFeatureAnomaly;
import de.darwinspl.anomaly.DwVoidFeatureModelAnomaly;

import eu.hyvar.evolution.HyEvolutionPackage;

import eu.hyvar.feature.HyFeaturePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DwAnomalyPackageImpl extends EPackageImpl implements DwAnomalyPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwAnomalyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwVoidFeatureModelAnomalyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwFeatureAnomalyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwFalseOptionalFeatureAnomalyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwDeadFeatureAnomalyEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.darwinspl.anomaly.DwAnomalyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DwAnomalyPackageImpl() {
		super(eNS_URI, DwAnomalyFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DwAnomalyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DwAnomalyPackage init() {
		if (isInited) return (DwAnomalyPackage)EPackage.Registry.INSTANCE.getEPackage(DwAnomalyPackage.eNS_URI);

		// Obtain or create and register package
		DwAnomalyPackageImpl theDwAnomalyPackage = (DwAnomalyPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DwAnomalyPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DwAnomalyPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		HyFeaturePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDwAnomalyPackage.createPackageContents();

		// Initialize created meta-data
		theDwAnomalyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDwAnomalyPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DwAnomalyPackage.eNS_URI, theDwAnomalyPackage);
		return theDwAnomalyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwAnomaly() {
		return dwAnomalyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwVoidFeatureModelAnomaly() {
		return dwVoidFeatureModelAnomalyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwVoidFeatureModelAnomaly_FeatureModel() {
		return (EReference)dwVoidFeatureModelAnomalyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwFeatureAnomaly() {
		return dwFeatureAnomalyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwFeatureAnomaly_Feature() {
		return (EReference)dwFeatureAnomalyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwFalseOptionalFeatureAnomaly() {
		return dwFalseOptionalFeatureAnomalyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwDeadFeatureAnomaly() {
		return dwDeadFeatureAnomalyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DwAnomalyFactory getDwAnomalyFactory() {
		return (DwAnomalyFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		dwAnomalyEClass = createEClass(DW_ANOMALY);

		dwVoidFeatureModelAnomalyEClass = createEClass(DW_VOID_FEATURE_MODEL_ANOMALY);
		createEReference(dwVoidFeatureModelAnomalyEClass, DW_VOID_FEATURE_MODEL_ANOMALY__FEATURE_MODEL);

		dwFeatureAnomalyEClass = createEClass(DW_FEATURE_ANOMALY);
		createEReference(dwFeatureAnomalyEClass, DW_FEATURE_ANOMALY__FEATURE);

		dwFalseOptionalFeatureAnomalyEClass = createEClass(DW_FALSE_OPTIONAL_FEATURE_ANOMALY);

		dwDeadFeatureAnomalyEClass = createEClass(DW_DEAD_FEATURE_ANOMALY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		HyEvolutionPackage theHyEvolutionPackage = (HyEvolutionPackage)EPackage.Registry.INSTANCE.getEPackage(HyEvolutionPackage.eNS_URI);
		HyFeaturePackage theHyFeaturePackage = (HyFeaturePackage)EPackage.Registry.INSTANCE.getEPackage(HyFeaturePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dwAnomalyEClass.getESuperTypes().add(theHyEvolutionPackage.getHyTemporalElement());
		dwVoidFeatureModelAnomalyEClass.getESuperTypes().add(this.getDwAnomaly());
		dwFeatureAnomalyEClass.getESuperTypes().add(this.getDwAnomaly());
		dwFalseOptionalFeatureAnomalyEClass.getESuperTypes().add(this.getDwFeatureAnomaly());
		dwDeadFeatureAnomalyEClass.getESuperTypes().add(this.getDwFeatureAnomaly());

		// Initialize classes, features, and operations; add parameters
		initEClass(dwAnomalyEClass, DwAnomaly.class, "DwAnomaly", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwVoidFeatureModelAnomalyEClass, DwVoidFeatureModelAnomaly.class, "DwVoidFeatureModelAnomaly", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwVoidFeatureModelAnomaly_FeatureModel(), theHyFeaturePackage.getHyFeatureModel(), null, "featureModel", null, 1, 1, DwVoidFeatureModelAnomaly.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwFeatureAnomalyEClass, DwFeatureAnomaly.class, "DwFeatureAnomaly", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwFeatureAnomaly_Feature(), theHyFeaturePackage.getHyFeature(), null, "feature", null, 1, 1, DwFeatureAnomaly.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwFalseOptionalFeatureAnomalyEClass, DwFalseOptionalFeatureAnomaly.class, "DwFalseOptionalFeatureAnomaly", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwDeadFeatureAnomalyEClass, DwDeadFeatureAnomaly.class, "DwDeadFeatureAnomaly", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //DwAnomalyPackageImpl
