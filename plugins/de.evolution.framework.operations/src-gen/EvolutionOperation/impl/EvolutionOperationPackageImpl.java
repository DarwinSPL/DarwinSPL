/**
 */
package EvolutionOperation.impl;

import EvolutionOperation.AddAttribute;
import EvolutionOperation.AddFeature;
import EvolutionOperation.AddFeatureTyp;
import EvolutionOperation.AddName;
import EvolutionOperation.ComplexOp;
import EvolutionOperation.EvoOp;
import EvolutionOperation.EvolutionOperationFactory;
import EvolutionOperation.EvolutionOperationPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EvolutionOperationPackageImpl extends EPackageImpl implements EvolutionOperationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evoOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addFeatureTypEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addFeatureEClass = null;

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
	 * @see EvolutionOperation.EvolutionOperationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EvolutionOperationPackageImpl() {
		super(eNS_URI, EvolutionOperationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EvolutionOperationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EvolutionOperationPackage init() {
		if (isInited) return (EvolutionOperationPackage)EPackage.Registry.INSTANCE.getEPackage(EvolutionOperationPackage.eNS_URI);

		// Obtain or create and register package
		EvolutionOperationPackageImpl theEvolutionOperationPackage = (EvolutionOperationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EvolutionOperationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EvolutionOperationPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEvolutionOperationPackage.createPackageContents();

		// Initialize created meta-data
		theEvolutionOperationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEvolutionOperationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EvolutionOperationPackage.eNS_URI, theEvolutionOperationPackage);
		return theEvolutionOperationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddName() {
		return addNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAddName__Execute__String_Date() {
		return addNameEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAddName__Undo() {
		return addNameEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvoOp() {
		return evoOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEvoOp__Execute() {
		return evoOpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEvoOp__Undo() {
		return evoOpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexOp() {
		return complexOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComplexOp_Name() {
		return (EAttribute)complexOpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComplexOp__Execute() {
		return complexOpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComplexOp__Undo() {
		return complexOpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComplexOp__Add__EvoOp() {
		return complexOpEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComplexOp__Remove__EvoOp() {
		return complexOpEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddFeatureTyp() {
		return addFeatureTypEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAddFeatureTyp__Execute__Date() {
		return addFeatureTypEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAddFeatureTyp__Undo() {
		return addFeatureTypEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddAttribute() {
		return addAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAddAttribute__Execute__Date() {
		return addAttributeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAddAttribute__Undo() {
		return addAttributeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddFeature() {
		return addFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAddFeature__Execute__String_Date() {
		return addFeatureEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAddFeature__Undo() {
		return addFeatureEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvolutionOperationFactory getEvolutionOperationFactory() {
		return (EvolutionOperationFactory)getEFactoryInstance();
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
		addNameEClass = createEClass(ADD_NAME);
		createEOperation(addNameEClass, ADD_NAME___EXECUTE__STRING_DATE);
		createEOperation(addNameEClass, ADD_NAME___UNDO);

		evoOpEClass = createEClass(EVO_OP);
		createEOperation(evoOpEClass, EVO_OP___EXECUTE);
		createEOperation(evoOpEClass, EVO_OP___UNDO);

		complexOpEClass = createEClass(COMPLEX_OP);
		createEAttribute(complexOpEClass, COMPLEX_OP__NAME);
		createEOperation(complexOpEClass, COMPLEX_OP___EXECUTE);
		createEOperation(complexOpEClass, COMPLEX_OP___UNDO);
		createEOperation(complexOpEClass, COMPLEX_OP___ADD__EVOOP);
		createEOperation(complexOpEClass, COMPLEX_OP___REMOVE__EVOOP);

		addFeatureTypEClass = createEClass(ADD_FEATURE_TYP);
		createEOperation(addFeatureTypEClass, ADD_FEATURE_TYP___EXECUTE__DATE);
		createEOperation(addFeatureTypEClass, ADD_FEATURE_TYP___UNDO);

		addAttributeEClass = createEClass(ADD_ATTRIBUTE);
		createEOperation(addAttributeEClass, ADD_ATTRIBUTE___EXECUTE__DATE);
		createEOperation(addAttributeEClass, ADD_ATTRIBUTE___UNDO);

		addFeatureEClass = createEClass(ADD_FEATURE);
		createEOperation(addFeatureEClass, ADD_FEATURE___EXECUTE__STRING_DATE);
		createEOperation(addFeatureEClass, ADD_FEATURE___UNDO);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(addNameEClass, AddName.class, "AddName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getAddName__Execute__String_Date(), null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDate(), "timestamp", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAddName__Undo(), null, "undo", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(evoOpEClass, EvoOp.class, "EvoOp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEvoOp__Execute(), null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getEvoOp__Undo(), null, "undo", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(complexOpEClass, ComplexOp.class, "ComplexOp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComplexOp_Name(), ecorePackage.getEString(), "name", null, 0, 1, ComplexOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getComplexOp__Execute(), null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEOperation(getComplexOp__Undo(), null, "undo", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getComplexOp__Add__EvoOp(), null, "add", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEvoOp(), "operation", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getComplexOp__Remove__EvoOp(), null, "remove", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEvoOp(), "operation", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(addFeatureTypEClass, AddFeatureTyp.class, "AddFeatureTyp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getAddFeatureTyp__Execute__Date(), null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDate(), "timestamp", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAddFeatureTyp__Undo(), null, "undo", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(addAttributeEClass, AddAttribute.class, "AddAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getAddAttribute__Execute__Date(), null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDate(), "timestamp", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAddAttribute__Undo(), null, "undo", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(addFeatureEClass, AddFeature.class, "AddFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getAddFeature__Execute__String_Date(), null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDate(), "timestamp", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAddFeature__Undo(), null, "undo", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //EvolutionOperationPackageImpl
