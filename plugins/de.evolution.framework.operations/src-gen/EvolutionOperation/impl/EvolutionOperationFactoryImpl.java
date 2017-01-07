/**
 */
package EvolutionOperation.impl;

import EvolutionOperation.*;

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
public class EvolutionOperationFactoryImpl extends EFactoryImpl implements EvolutionOperationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EvolutionOperationFactory init() {
		try {
			EvolutionOperationFactory theEvolutionOperationFactory = (EvolutionOperationFactory)EPackage.Registry.INSTANCE.getEFactory(EvolutionOperationPackage.eNS_URI);
			if (theEvolutionOperationFactory != null) {
				return theEvolutionOperationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EvolutionOperationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvolutionOperationFactoryImpl() {
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
			case EvolutionOperationPackage.ADD_NAME: return createAddName();
			case EvolutionOperationPackage.EVO_OP: return createEvoOp();
			case EvolutionOperationPackage.COMPLEX_OP: return createComplexOp();
			case EvolutionOperationPackage.ADD_FEATURE_TYP: return createAddFeatureTyp();
			case EvolutionOperationPackage.ADD_ATTRIBUTE: return createAddAttribute();
			case EvolutionOperationPackage.ADD_FEATURE: return createAddFeature();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddName createAddName() {
		AddNameImpl addName = new AddNameImpl();
		return addName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvoOp createEvoOp() {
		EvoOpImpl evoOp = new EvoOpImpl();
		return evoOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexOp createComplexOp() {
		ComplexOpImpl complexOp = new ComplexOpImpl();
		return complexOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddFeatureTyp createAddFeatureTyp() {
		AddFeatureTypImpl addFeatureTyp = new AddFeatureTypImpl();
		return addFeatureTyp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddAttribute createAddAttribute() {
		AddAttributeImpl addAttribute = new AddAttributeImpl();
		return addAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddFeature createAddFeature() {
		AddFeatureImpl addFeature = new AddFeatureImpl();
		return addFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvolutionOperationPackage getEvolutionOperationPackage() {
		return (EvolutionOperationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EvolutionOperationPackage getPackage() {
		return EvolutionOperationPackage.eINSTANCE;
	}

} //EvolutionOperationFactoryImpl
