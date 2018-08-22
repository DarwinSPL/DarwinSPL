/**
 */
package de.darwinspl.feature.evolution.evolutionoperation.impl;

import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperation;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttribute;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeDelete;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeRename;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraint;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraintCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraintDelete;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContext;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContextCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContextDelete;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnum;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumDelete;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteral;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteralCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteralDelete;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeature;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureDelete;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureRename;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersion;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersionCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersionDelete;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroup;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeatures;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeaturesAdded;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeaturesRemoved;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupType;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormula;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormulaCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormulaDelete;
import de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationFactory;
import de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage;

import eu.hyvar.context.HyContextInformationPackage;

import eu.hyvar.context.contextValidity.HyContextValidityPackage;

import eu.hyvar.dataValues.HyDataValuesPackage;

import eu.hyvar.evolution.HyEvolutionPackage;

import eu.hyvar.feature.HyFeaturePackage;

import eu.hyvar.feature.constraint.HyConstraintPackage;

import eu.hyvar.feature.expression.HyExpressionPackage;

import org.eclipse.emf.ecore.EAttribute;
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
public class EvolutionoperationPackageImpl extends EPackageImpl implements EvolutionoperationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationFeatureCreateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationFeatureDeleteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationFeatureRenameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationFeatureTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationFeatureGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationFeatureVersionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationFeatureVersionCreateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationFeatureVersionDeleteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationGroupTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationGroupFeaturesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationGroupFeaturesAddedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationGroupFeaturesRemovedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationAttributeCreateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationAttributeDeleteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationAttributeRenameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationEnumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationEnumCreateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationEnumDeleteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationEnumLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationEnumLiteralCreateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationEnumLiteralDeleteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationConstraintCreateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationConstraintDeleteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationContextCreateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationContextDeleteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationValidityFormulaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationValidityFormulaCreateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dwEvolutionOperationValidityFormulaDeleteEClass = null;

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
	 * @see de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EvolutionoperationPackageImpl() {
		super(eNS_URI, EvolutionoperationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EvolutionoperationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EvolutionoperationPackage init() {
		if (isInited) return (EvolutionoperationPackage)EPackage.Registry.INSTANCE.getEPackage(EvolutionoperationPackage.eNS_URI);

		// Obtain or create and register package
		EvolutionoperationPackageImpl theEvolutionoperationPackage = (EvolutionoperationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EvolutionoperationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EvolutionoperationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		HyConstraintPackage.eINSTANCE.eClass();
		HyContextInformationPackage.eINSTANCE.eClass();
		HyContextValidityPackage.eINSTANCE.eClass();
		HyDataValuesPackage.eINSTANCE.eClass();
		HyEvolutionPackage.eINSTANCE.eClass();
		HyExpressionPackage.eINSTANCE.eClass();
		HyFeaturePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEvolutionoperationPackage.createPackageContents();

		// Initialize created meta-data
		theEvolutionoperationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEvolutionoperationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EvolutionoperationPackage.eNS_URI, theEvolutionoperationPackage);
		return theEvolutionoperationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperation() {
		return dwEvolutionOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDwEvolutionOperation_EvoStep() {
		return (EAttribute)dwEvolutionOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationFeature() {
		return dwEvolutionOperationFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationFeature_Feature() {
		return (EReference)dwEvolutionOperationFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationFeatureCreate() {
		return dwEvolutionOperationFeatureCreateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationFeatureDelete() {
		return dwEvolutionOperationFeatureDeleteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationFeatureRename() {
		return dwEvolutionOperationFeatureRenameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationFeatureRename_OldName() {
		return (EReference)dwEvolutionOperationFeatureRenameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationFeatureRename_NewName() {
		return (EReference)dwEvolutionOperationFeatureRenameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationFeatureType() {
		return dwEvolutionOperationFeatureTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationFeatureType_OldType() {
		return (EReference)dwEvolutionOperationFeatureTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationFeatureType_NewType() {
		return (EReference)dwEvolutionOperationFeatureTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationFeatureGroup() {
		return dwEvolutionOperationFeatureGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationFeatureGroup_OldGroup() {
		return (EReference)dwEvolutionOperationFeatureGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationFeatureGroup_NewGroup() {
		return (EReference)dwEvolutionOperationFeatureGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationFeatureVersion() {
		return dwEvolutionOperationFeatureVersionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationFeatureVersion_Version() {
		return (EReference)dwEvolutionOperationFeatureVersionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationFeatureVersionCreate() {
		return dwEvolutionOperationFeatureVersionCreateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationFeatureVersionDelete() {
		return dwEvolutionOperationFeatureVersionDeleteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationGroup() {
		return dwEvolutionOperationGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationGroup_Group() {
		return (EReference)dwEvolutionOperationGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationGroupType() {
		return dwEvolutionOperationGroupTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationGroupType_OldType() {
		return (EReference)dwEvolutionOperationGroupTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationGroupType_NewType() {
		return (EReference)dwEvolutionOperationGroupTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationGroupFeatures() {
		return dwEvolutionOperationGroupFeaturesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationGroupFeatures_AffectedFeatures() {
		return (EReference)dwEvolutionOperationGroupFeaturesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationGroupFeaturesAdded() {
		return dwEvolutionOperationGroupFeaturesAddedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationGroupFeaturesRemoved() {
		return dwEvolutionOperationGroupFeaturesRemovedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationAttribute() {
		return dwEvolutionOperationAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationAttribute_Attribute() {
		return (EReference)dwEvolutionOperationAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationAttributeCreate() {
		return dwEvolutionOperationAttributeCreateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationAttributeDelete() {
		return dwEvolutionOperationAttributeDeleteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationAttributeRename() {
		return dwEvolutionOperationAttributeRenameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationAttributeRename_OldName() {
		return (EReference)dwEvolutionOperationAttributeRenameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationAttributeRename_NewName() {
		return (EReference)dwEvolutionOperationAttributeRenameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationEnum() {
		return dwEvolutionOperationEnumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationEnum_Enum() {
		return (EReference)dwEvolutionOperationEnumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationEnumCreate() {
		return dwEvolutionOperationEnumCreateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationEnumDelete() {
		return dwEvolutionOperationEnumDeleteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationEnumLiteral() {
		return dwEvolutionOperationEnumLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationEnumLiteral_Literal() {
		return (EReference)dwEvolutionOperationEnumLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationEnumLiteralCreate() {
		return dwEvolutionOperationEnumLiteralCreateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationEnumLiteralDelete() {
		return dwEvolutionOperationEnumLiteralDeleteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationConstraint() {
		return dwEvolutionOperationConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationConstraint_Constraint() {
		return (EReference)dwEvolutionOperationConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationConstraintCreate() {
		return dwEvolutionOperationConstraintCreateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationConstraintDelete() {
		return dwEvolutionOperationConstraintDeleteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationContext() {
		return dwEvolutionOperationContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationContext_Context() {
		return (EReference)dwEvolutionOperationContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationContextCreate() {
		return dwEvolutionOperationContextCreateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationContextDelete() {
		return dwEvolutionOperationContextDeleteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationValidityFormula() {
		return dwEvolutionOperationValidityFormulaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDwEvolutionOperationValidityFormula_ValidityFormula() {
		return (EReference)dwEvolutionOperationValidityFormulaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationValidityFormulaCreate() {
		return dwEvolutionOperationValidityFormulaCreateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDwEvolutionOperationValidityFormulaDelete() {
		return dwEvolutionOperationValidityFormulaDeleteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvolutionoperationFactory getEvolutionoperationFactory() {
		return (EvolutionoperationFactory)getEFactoryInstance();
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
		dwEvolutionOperationEClass = createEClass(DW_EVOLUTION_OPERATION);
		createEAttribute(dwEvolutionOperationEClass, DW_EVOLUTION_OPERATION__EVO_STEP);

		dwEvolutionOperationFeatureEClass = createEClass(DW_EVOLUTION_OPERATION_FEATURE);
		createEReference(dwEvolutionOperationFeatureEClass, DW_EVOLUTION_OPERATION_FEATURE__FEATURE);

		dwEvolutionOperationFeatureCreateEClass = createEClass(DW_EVOLUTION_OPERATION_FEATURE_CREATE);

		dwEvolutionOperationFeatureDeleteEClass = createEClass(DW_EVOLUTION_OPERATION_FEATURE_DELETE);

		dwEvolutionOperationFeatureRenameEClass = createEClass(DW_EVOLUTION_OPERATION_FEATURE_RENAME);
		createEReference(dwEvolutionOperationFeatureRenameEClass, DW_EVOLUTION_OPERATION_FEATURE_RENAME__OLD_NAME);
		createEReference(dwEvolutionOperationFeatureRenameEClass, DW_EVOLUTION_OPERATION_FEATURE_RENAME__NEW_NAME);

		dwEvolutionOperationFeatureTypeEClass = createEClass(DW_EVOLUTION_OPERATION_FEATURE_TYPE);
		createEReference(dwEvolutionOperationFeatureTypeEClass, DW_EVOLUTION_OPERATION_FEATURE_TYPE__OLD_TYPE);
		createEReference(dwEvolutionOperationFeatureTypeEClass, DW_EVOLUTION_OPERATION_FEATURE_TYPE__NEW_TYPE);

		dwEvolutionOperationFeatureGroupEClass = createEClass(DW_EVOLUTION_OPERATION_FEATURE_GROUP);
		createEReference(dwEvolutionOperationFeatureGroupEClass, DW_EVOLUTION_OPERATION_FEATURE_GROUP__OLD_GROUP);
		createEReference(dwEvolutionOperationFeatureGroupEClass, DW_EVOLUTION_OPERATION_FEATURE_GROUP__NEW_GROUP);

		dwEvolutionOperationFeatureVersionEClass = createEClass(DW_EVOLUTION_OPERATION_FEATURE_VERSION);
		createEReference(dwEvolutionOperationFeatureVersionEClass, DW_EVOLUTION_OPERATION_FEATURE_VERSION__VERSION);

		dwEvolutionOperationFeatureVersionCreateEClass = createEClass(DW_EVOLUTION_OPERATION_FEATURE_VERSION_CREATE);

		dwEvolutionOperationFeatureVersionDeleteEClass = createEClass(DW_EVOLUTION_OPERATION_FEATURE_VERSION_DELETE);

		dwEvolutionOperationGroupEClass = createEClass(DW_EVOLUTION_OPERATION_GROUP);
		createEReference(dwEvolutionOperationGroupEClass, DW_EVOLUTION_OPERATION_GROUP__GROUP);

		dwEvolutionOperationGroupTypeEClass = createEClass(DW_EVOLUTION_OPERATION_GROUP_TYPE);
		createEReference(dwEvolutionOperationGroupTypeEClass, DW_EVOLUTION_OPERATION_GROUP_TYPE__OLD_TYPE);
		createEReference(dwEvolutionOperationGroupTypeEClass, DW_EVOLUTION_OPERATION_GROUP_TYPE__NEW_TYPE);

		dwEvolutionOperationGroupFeaturesEClass = createEClass(DW_EVOLUTION_OPERATION_GROUP_FEATURES);
		createEReference(dwEvolutionOperationGroupFeaturesEClass, DW_EVOLUTION_OPERATION_GROUP_FEATURES__AFFECTED_FEATURES);

		dwEvolutionOperationGroupFeaturesAddedEClass = createEClass(DW_EVOLUTION_OPERATION_GROUP_FEATURES_ADDED);

		dwEvolutionOperationGroupFeaturesRemovedEClass = createEClass(DW_EVOLUTION_OPERATION_GROUP_FEATURES_REMOVED);

		dwEvolutionOperationAttributeEClass = createEClass(DW_EVOLUTION_OPERATION_ATTRIBUTE);
		createEReference(dwEvolutionOperationAttributeEClass, DW_EVOLUTION_OPERATION_ATTRIBUTE__ATTRIBUTE);

		dwEvolutionOperationAttributeCreateEClass = createEClass(DW_EVOLUTION_OPERATION_ATTRIBUTE_CREATE);

		dwEvolutionOperationAttributeDeleteEClass = createEClass(DW_EVOLUTION_OPERATION_ATTRIBUTE_DELETE);

		dwEvolutionOperationAttributeRenameEClass = createEClass(DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME);
		createEReference(dwEvolutionOperationAttributeRenameEClass, DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__OLD_NAME);
		createEReference(dwEvolutionOperationAttributeRenameEClass, DW_EVOLUTION_OPERATION_ATTRIBUTE_RENAME__NEW_NAME);

		dwEvolutionOperationEnumEClass = createEClass(DW_EVOLUTION_OPERATION_ENUM);
		createEReference(dwEvolutionOperationEnumEClass, DW_EVOLUTION_OPERATION_ENUM__ENUM);

		dwEvolutionOperationEnumCreateEClass = createEClass(DW_EVOLUTION_OPERATION_ENUM_CREATE);

		dwEvolutionOperationEnumDeleteEClass = createEClass(DW_EVOLUTION_OPERATION_ENUM_DELETE);

		dwEvolutionOperationEnumLiteralEClass = createEClass(DW_EVOLUTION_OPERATION_ENUM_LITERAL);
		createEReference(dwEvolutionOperationEnumLiteralEClass, DW_EVOLUTION_OPERATION_ENUM_LITERAL__LITERAL);

		dwEvolutionOperationEnumLiteralCreateEClass = createEClass(DW_EVOLUTION_OPERATION_ENUM_LITERAL_CREATE);

		dwEvolutionOperationEnumLiteralDeleteEClass = createEClass(DW_EVOLUTION_OPERATION_ENUM_LITERAL_DELETE);

		dwEvolutionOperationConstraintEClass = createEClass(DW_EVOLUTION_OPERATION_CONSTRAINT);
		createEReference(dwEvolutionOperationConstraintEClass, DW_EVOLUTION_OPERATION_CONSTRAINT__CONSTRAINT);

		dwEvolutionOperationConstraintCreateEClass = createEClass(DW_EVOLUTION_OPERATION_CONSTRAINT_CREATE);

		dwEvolutionOperationConstraintDeleteEClass = createEClass(DW_EVOLUTION_OPERATION_CONSTRAINT_DELETE);

		dwEvolutionOperationContextEClass = createEClass(DW_EVOLUTION_OPERATION_CONTEXT);
		createEReference(dwEvolutionOperationContextEClass, DW_EVOLUTION_OPERATION_CONTEXT__CONTEXT);

		dwEvolutionOperationContextCreateEClass = createEClass(DW_EVOLUTION_OPERATION_CONTEXT_CREATE);

		dwEvolutionOperationContextDeleteEClass = createEClass(DW_EVOLUTION_OPERATION_CONTEXT_DELETE);

		dwEvolutionOperationValidityFormulaEClass = createEClass(DW_EVOLUTION_OPERATION_VALIDITY_FORMULA);
		createEReference(dwEvolutionOperationValidityFormulaEClass, DW_EVOLUTION_OPERATION_VALIDITY_FORMULA__VALIDITY_FORMULA);

		dwEvolutionOperationValidityFormulaCreateEClass = createEClass(DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_CREATE);

		dwEvolutionOperationValidityFormulaDeleteEClass = createEClass(DW_EVOLUTION_OPERATION_VALIDITY_FORMULA_DELETE);
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
		HyFeaturePackage theHyFeaturePackage = (HyFeaturePackage)EPackage.Registry.INSTANCE.getEPackage(HyFeaturePackage.eNS_URI);
		HyEvolutionPackage theHyEvolutionPackage = (HyEvolutionPackage)EPackage.Registry.INSTANCE.getEPackage(HyEvolutionPackage.eNS_URI);
		HyDataValuesPackage theHyDataValuesPackage = (HyDataValuesPackage)EPackage.Registry.INSTANCE.getEPackage(HyDataValuesPackage.eNS_URI);
		HyConstraintPackage theHyConstraintPackage = (HyConstraintPackage)EPackage.Registry.INSTANCE.getEPackage(HyConstraintPackage.eNS_URI);
		HyContextInformationPackage theHyContextInformationPackage = (HyContextInformationPackage)EPackage.Registry.INSTANCE.getEPackage(HyContextInformationPackage.eNS_URI);
		HyContextValidityPackage theHyContextValidityPackage = (HyContextValidityPackage)EPackage.Registry.INSTANCE.getEPackage(HyContextValidityPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dwEvolutionOperationFeatureEClass.getESuperTypes().add(this.getDwEvolutionOperation());
		dwEvolutionOperationFeatureCreateEClass.getESuperTypes().add(this.getDwEvolutionOperationFeature());
		dwEvolutionOperationFeatureDeleteEClass.getESuperTypes().add(this.getDwEvolutionOperationFeature());
		dwEvolutionOperationFeatureRenameEClass.getESuperTypes().add(this.getDwEvolutionOperationFeature());
		dwEvolutionOperationFeatureTypeEClass.getESuperTypes().add(this.getDwEvolutionOperationFeature());
		dwEvolutionOperationFeatureGroupEClass.getESuperTypes().add(this.getDwEvolutionOperationFeature());
		dwEvolutionOperationFeatureVersionEClass.getESuperTypes().add(this.getDwEvolutionOperationFeature());
		dwEvolutionOperationFeatureVersionCreateEClass.getESuperTypes().add(this.getDwEvolutionOperationFeatureVersion());
		dwEvolutionOperationFeatureVersionDeleteEClass.getESuperTypes().add(this.getDwEvolutionOperationFeatureVersion());
		dwEvolutionOperationGroupEClass.getESuperTypes().add(this.getDwEvolutionOperation());
		dwEvolutionOperationGroupTypeEClass.getESuperTypes().add(this.getDwEvolutionOperationGroup());
		dwEvolutionOperationGroupFeaturesEClass.getESuperTypes().add(this.getDwEvolutionOperationGroup());
		dwEvolutionOperationGroupFeaturesAddedEClass.getESuperTypes().add(this.getDwEvolutionOperationGroupFeatures());
		dwEvolutionOperationGroupFeaturesRemovedEClass.getESuperTypes().add(this.getDwEvolutionOperationGroupFeatures());
		dwEvolutionOperationAttributeEClass.getESuperTypes().add(this.getDwEvolutionOperation());
		dwEvolutionOperationAttributeCreateEClass.getESuperTypes().add(this.getDwEvolutionOperationAttribute());
		dwEvolutionOperationAttributeDeleteEClass.getESuperTypes().add(this.getDwEvolutionOperationAttribute());
		dwEvolutionOperationAttributeRenameEClass.getESuperTypes().add(this.getDwEvolutionOperationAttribute());
		dwEvolutionOperationEnumEClass.getESuperTypes().add(this.getDwEvolutionOperation());
		dwEvolutionOperationEnumCreateEClass.getESuperTypes().add(this.getDwEvolutionOperationEnum());
		dwEvolutionOperationEnumDeleteEClass.getESuperTypes().add(this.getDwEvolutionOperationEnum());
		dwEvolutionOperationEnumLiteralEClass.getESuperTypes().add(this.getDwEvolutionOperationEnum());
		dwEvolutionOperationEnumLiteralCreateEClass.getESuperTypes().add(this.getDwEvolutionOperationEnumLiteral());
		dwEvolutionOperationEnumLiteralDeleteEClass.getESuperTypes().add(this.getDwEvolutionOperationEnumLiteral());
		dwEvolutionOperationConstraintEClass.getESuperTypes().add(this.getDwEvolutionOperation());
		dwEvolutionOperationConstraintCreateEClass.getESuperTypes().add(this.getDwEvolutionOperationConstraint());
		dwEvolutionOperationConstraintDeleteEClass.getESuperTypes().add(this.getDwEvolutionOperationConstraint());
		dwEvolutionOperationContextEClass.getESuperTypes().add(this.getDwEvolutionOperation());
		dwEvolutionOperationContextCreateEClass.getESuperTypes().add(this.getDwEvolutionOperationContext());
		dwEvolutionOperationContextDeleteEClass.getESuperTypes().add(this.getDwEvolutionOperationContext());
		dwEvolutionOperationValidityFormulaEClass.getESuperTypes().add(this.getDwEvolutionOperation());
		dwEvolutionOperationValidityFormulaCreateEClass.getESuperTypes().add(this.getDwEvolutionOperationValidityFormula());
		dwEvolutionOperationValidityFormulaDeleteEClass.getESuperTypes().add(this.getDwEvolutionOperationValidityFormula());

		// Initialize classes, features, and operations; add parameters
		initEClass(dwEvolutionOperationEClass, DwEvolutionOperation.class, "DwEvolutionOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDwEvolutionOperation_EvoStep(), ecorePackage.getEDate(), "evoStep", null, 0, 1, DwEvolutionOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationFeatureEClass, DwEvolutionOperationFeature.class, "DwEvolutionOperationFeature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwEvolutionOperationFeature_Feature(), theHyFeaturePackage.getHyFeature(), null, "feature", null, 1, 1, DwEvolutionOperationFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationFeatureCreateEClass, DwEvolutionOperationFeatureCreate.class, "DwEvolutionOperationFeatureCreate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationFeatureDeleteEClass, DwEvolutionOperationFeatureDelete.class, "DwEvolutionOperationFeatureDelete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationFeatureRenameEClass, DwEvolutionOperationFeatureRename.class, "DwEvolutionOperationFeatureRename", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwEvolutionOperationFeatureRename_OldName(), theHyEvolutionPackage.getHyName(), null, "oldName", null, 0, 1, DwEvolutionOperationFeatureRename.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDwEvolutionOperationFeatureRename_NewName(), theHyEvolutionPackage.getHyName(), null, "newName", null, 1, 1, DwEvolutionOperationFeatureRename.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationFeatureTypeEClass, DwEvolutionOperationFeatureType.class, "DwEvolutionOperationFeatureType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwEvolutionOperationFeatureType_OldType(), theHyFeaturePackage.getHyFeatureType(), null, "oldType", null, 0, 1, DwEvolutionOperationFeatureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDwEvolutionOperationFeatureType_NewType(), theHyFeaturePackage.getHyFeatureType(), null, "newType", null, 1, 1, DwEvolutionOperationFeatureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationFeatureGroupEClass, DwEvolutionOperationFeatureGroup.class, "DwEvolutionOperationFeatureGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwEvolutionOperationFeatureGroup_OldGroup(), theHyFeaturePackage.getHyGroupComposition(), null, "oldGroup", null, 0, 1, DwEvolutionOperationFeatureGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDwEvolutionOperationFeatureGroup_NewGroup(), theHyFeaturePackage.getHyGroupComposition(), null, "newGroup", null, 1, 1, DwEvolutionOperationFeatureGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationFeatureVersionEClass, DwEvolutionOperationFeatureVersion.class, "DwEvolutionOperationFeatureVersion", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwEvolutionOperationFeatureVersion_Version(), theHyFeaturePackage.getHyVersion(), null, "version", null, 1, 1, DwEvolutionOperationFeatureVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationFeatureVersionCreateEClass, DwEvolutionOperationFeatureVersionCreate.class, "DwEvolutionOperationFeatureVersionCreate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationFeatureVersionDeleteEClass, DwEvolutionOperationFeatureVersionDelete.class, "DwEvolutionOperationFeatureVersionDelete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationGroupEClass, DwEvolutionOperationGroup.class, "DwEvolutionOperationGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwEvolutionOperationGroup_Group(), theHyFeaturePackage.getHyGroup(), null, "group", null, 1, 1, DwEvolutionOperationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationGroupTypeEClass, DwEvolutionOperationGroupType.class, "DwEvolutionOperationGroupType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwEvolutionOperationGroupType_OldType(), theHyFeaturePackage.getHyGroupType(), null, "oldType", null, 0, 1, DwEvolutionOperationGroupType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDwEvolutionOperationGroupType_NewType(), theHyFeaturePackage.getHyGroupType(), null, "newType", null, 1, 1, DwEvolutionOperationGroupType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationGroupFeaturesEClass, DwEvolutionOperationGroupFeatures.class, "DwEvolutionOperationGroupFeatures", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwEvolutionOperationGroupFeatures_AffectedFeatures(), theHyFeaturePackage.getHyFeature(), null, "affectedFeatures", null, 0, -1, DwEvolutionOperationGroupFeatures.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationGroupFeaturesAddedEClass, DwEvolutionOperationGroupFeaturesAdded.class, "DwEvolutionOperationGroupFeaturesAdded", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationGroupFeaturesRemovedEClass, DwEvolutionOperationGroupFeaturesRemoved.class, "DwEvolutionOperationGroupFeaturesRemoved", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationAttributeEClass, DwEvolutionOperationAttribute.class, "DwEvolutionOperationAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwEvolutionOperationAttribute_Attribute(), theHyFeaturePackage.getHyFeatureAttribute(), null, "attribute", null, 1, 1, DwEvolutionOperationAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationAttributeCreateEClass, DwEvolutionOperationAttributeCreate.class, "DwEvolutionOperationAttributeCreate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationAttributeDeleteEClass, DwEvolutionOperationAttributeDelete.class, "DwEvolutionOperationAttributeDelete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationAttributeRenameEClass, DwEvolutionOperationAttributeRename.class, "DwEvolutionOperationAttributeRename", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwEvolutionOperationAttributeRename_OldName(), theHyEvolutionPackage.getHyName(), null, "oldName", null, 0, 1, DwEvolutionOperationAttributeRename.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDwEvolutionOperationAttributeRename_NewName(), theHyEvolutionPackage.getHyName(), null, "newName", null, 1, 1, DwEvolutionOperationAttributeRename.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationEnumEClass, DwEvolutionOperationEnum.class, "DwEvolutionOperationEnum", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwEvolutionOperationEnum_Enum(), theHyDataValuesPackage.getHyEnum(), null, "enum", null, 1, 1, DwEvolutionOperationEnum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationEnumCreateEClass, DwEvolutionOperationEnumCreate.class, "DwEvolutionOperationEnumCreate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationEnumDeleteEClass, DwEvolutionOperationEnumDelete.class, "DwEvolutionOperationEnumDelete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationEnumLiteralEClass, DwEvolutionOperationEnumLiteral.class, "DwEvolutionOperationEnumLiteral", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwEvolutionOperationEnumLiteral_Literal(), theHyDataValuesPackage.getHyEnumLiteral(), null, "literal", null, 1, 1, DwEvolutionOperationEnumLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationEnumLiteralCreateEClass, DwEvolutionOperationEnumLiteralCreate.class, "DwEvolutionOperationEnumLiteralCreate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationEnumLiteralDeleteEClass, DwEvolutionOperationEnumLiteralDelete.class, "DwEvolutionOperationEnumLiteralDelete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationConstraintEClass, DwEvolutionOperationConstraint.class, "DwEvolutionOperationConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwEvolutionOperationConstraint_Constraint(), theHyConstraintPackage.getHyConstraint(), null, "constraint", null, 1, 1, DwEvolutionOperationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationConstraintCreateEClass, DwEvolutionOperationConstraintCreate.class, "DwEvolutionOperationConstraintCreate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationConstraintDeleteEClass, DwEvolutionOperationConstraintDelete.class, "DwEvolutionOperationConstraintDelete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationContextEClass, DwEvolutionOperationContext.class, "DwEvolutionOperationContext", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwEvolutionOperationContext_Context(), theHyContextInformationPackage.getHyContextualInformation(), null, "context", null, 1, 1, DwEvolutionOperationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationContextCreateEClass, DwEvolutionOperationContextCreate.class, "DwEvolutionOperationContextCreate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationContextDeleteEClass, DwEvolutionOperationContextDelete.class, "DwEvolutionOperationContextDelete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationValidityFormulaEClass, DwEvolutionOperationValidityFormula.class, "DwEvolutionOperationValidityFormula", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDwEvolutionOperationValidityFormula_ValidityFormula(), theHyContextValidityPackage.getHyValidityFormula(), null, "validityFormula", null, 1, 1, DwEvolutionOperationValidityFormula.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dwEvolutionOperationValidityFormulaCreateEClass, DwEvolutionOperationValidityFormulaCreate.class, "DwEvolutionOperationValidityFormulaCreate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dwEvolutionOperationValidityFormulaDeleteEClass, DwEvolutionOperationValidityFormulaDelete.class, "DwEvolutionOperationValidityFormulaDelete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EvolutionoperationPackageImpl
