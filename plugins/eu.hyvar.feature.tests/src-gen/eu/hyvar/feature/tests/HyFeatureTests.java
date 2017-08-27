/**
 */
package eu.hyvar.feature.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>feature</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class HyFeatureTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new HyFeatureTests("feature Tests");
		suite.addTestSuite(HyFeatureTest.class);
		suite.addTestSuite(HyGroupTest.class);
		suite.addTestSuite(HyVersionTest.class);
		suite.addTestSuite(HyNumberAttributeTest.class);
		suite.addTestSuite(HyBooleanAttributeTest.class);
		suite.addTestSuite(HyStringAttributeTest.class);
		suite.addTestSuite(HyEnumAttributeTest.class);
		suite.addTestSuite(HyRootFeatureTest.class);
		suite.addTestSuite(HyGroupCompositionTest.class);
		suite.addTestSuite(HyFeatureChildTest.class);
		suite.addTestSuite(HyFeatureTypeTest.class);
		suite.addTestSuite(HyGroupTypeTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyFeatureTests(String name) {
		super(name);
	}

} //HyFeatureTests
