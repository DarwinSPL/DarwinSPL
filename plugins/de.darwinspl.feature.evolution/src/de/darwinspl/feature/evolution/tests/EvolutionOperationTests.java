/**
 * 
 */
package de.darwinspl.feature.evolution.tests;

import eu.hyvar.feature.HyFeatureModel;

/**
 *
 */
public class EvolutionOperationTests {

	private static HyFeatureModel tfm;

	static boolean testAtomic = false;
	static boolean testBasic = false;
	static boolean testComplex = true;
	static boolean testInvoker = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		tfm = TestCases.createExample();

		// ----------------------------atomic Ops test area------------------------------------------
		if (testAtomic) {
			AtomicOperationTests.atomicAddTests(tfm);
			//AtomicOperationTests.atomicDeleteTests(tfm);
			//AtomicOperationTests.atomicUndoTests(tfm);
		}

		// --------------------------------------------basic Ops test area-----------------------------------
		if (testBasic) {
			//BasicOpertationTests.basicOperationAddTest(tfm);
			//BasicOpertationTests.basicOperationDeleteTest(tfm);
			//BasicOpertationTests.basicOperationRenameTest(tfm);
			//BasicOpertationTests.basicOperationChangeTypeTest(tfm);
			BasicOpertationTests.basicOperationMoveTest(tfm);
		}

		// ------------------------------------ complex evoOp test area------------------------------------------------
		if (testComplex) {
			ComplexOperationsTests.testTimestampAdjustment(tfm);
			ComplexOperationsTests.complexOperationSplitAndMergeTests(tfm);
		}

		// -------------------------------------------- operation invoker test area--------------------------------------------
		if (testInvoker) {
			InvokerTests.invokerTests(tfm);
		}

	}
}
