/**
 * 
 */
package de.darwinspl.feature.evolution.tests;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.darwinspl.feature.evolution.Invoker.OperationInvoker;
import de.darwinspl.feature.evolution.atomic.operations.AddFeature;
import de.darwinspl.feature.evolution.atomic.operations.AddFeatureChild;
import de.darwinspl.feature.evolution.atomic.operations.AddFeatureType;
import de.darwinspl.feature.evolution.atomic.operations.AddGroup;
import de.darwinspl.feature.evolution.atomic.operations.AddName;
import de.darwinspl.feature.evolution.atomic.operations.DeleteGroupComposition;
import de.darwinspl.feature.evolution.basic.operations.AddFeatureInGroup;
import de.darwinspl.feature.evolution.basic.operations.AddFeatureWithGroup;
import de.darwinspl.feature.evolution.complex.operations.AddToGroupComposition;
import de.darwinspl.feature.evolution.complex.operations.RemoveFromGroupComposition;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.util.HyFeatureCreationUtil;

/**
 *
 */
public class EvolutionOperationTests {

	private static HyFeatureModel tfm;

	static boolean testAtomic = false;
	static boolean testBasic = true;
	static boolean testComplex = false;
	static boolean testInvoker = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		tfm = TestCases.createExample();

		// ----------------------------atomic Ops test area------------------------------------------
		if (testAtomic) {
			//AtomicOperationTests.atomicAddTests(tfm);
			AtomicOperationTests.atomicDeleteTests(tfm);
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
		}

		// -------------------------------------------- operation invoker test area--------------------------------------------
		if (testInvoker) {
			InvokerTests.invokerTests(tfm);
		}

	}
}
