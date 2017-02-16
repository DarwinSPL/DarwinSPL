/**
 * 
 */
package de.darwinspl.feature.evolution.tests;

import de.darwinspl.feature.evolution.invoker.OperationInvoker;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;

/**
 *
 */
public class InvokerTests extends TestCases {

	public static void invokerTests(HyFeatureModel tfm) {
		OperationInvoker invoker = new OperationInvoker();
		for (int i = 0; i < 11; i++) {
			//invoker.addFeature("test4", HyFeatureTypeEnum.MANDATORY, frontDistanceSensorsAlternativeGroup, timestamp, tfm);
		}
	}
}
