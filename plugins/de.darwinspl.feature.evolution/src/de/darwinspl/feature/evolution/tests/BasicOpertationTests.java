/**
 * 
 */
package de.darwinspl.feature.evolution.tests;

import de.darwinspl.feature.evolution.basic.operations.AddFeatureInGroup;
import de.darwinspl.feature.evolution.basic.operations.AddFeatureWithGroup;
import de.darwinspl.feature.evolution.basic.operations.DeleteFeatureInGroup;
import de.darwinspl.feature.evolution.basic.operations.DeleteFeatureWithGroup;
import de.darwinspl.feature.evolution.basic.operations.Rename;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;

/**
 *
 */
public class BasicOpertationTests extends TestCases {

	public static void basicOperationAddTest(HyFeatureModel tfm) {
		AddFeatureInGroup addFiG = new AddFeatureInGroup("test2", HyFeatureTypeEnum.MANDATORY, frontDistanceSensorsAlternativeGroup,
				timestamp, tfm);
		addFiG.execute();

		AddFeatureWithGroup addFwG = new AddFeatureWithGroup("test3", HyFeatureTypeEnum.MANDATORY,
				infotainmentFeature, timestamp, tfm);
		addFwG.execute();
	}
	
	public static void basicOperationDeleteTest(HyFeatureModel tfm) {
		
		calendar.set(2016, 0, 20, 23, 59, 59);
		timestamp = calendar.getTime();
		
		DeleteFeatureInGroup deleteFiG = new DeleteFeatureInGroup(infotainmentFeature, timestamp);
		deleteFiG.execute();
		
		calendar.set(2015, 0, 20, 23, 59, 59);
		timestamp = calendar.getTime();
		AddFeatureWithGroup addFwG = new AddFeatureWithGroup("test3", HyFeatureTypeEnum.MANDATORY,
				infotainmentFeature, timestamp, tfm);
		addFwG.execute();
		
		calendar.set(2016, 0, 20, 23, 59, 59);
		timestamp = calendar.getTime();
		DeleteFeatureWithGroup deleteFwG = new DeleteFeatureWithGroup(addFwG.getFeature(), addFwG.getGroup(), timestamp);
	}
	
	public static void basicOperationRenameTest(HyFeatureModel tfm) {
		
		calendar.set(2016, 0, 20, 23, 59, 59);
		timestamp = calendar.getTime();
		
		Rename rename = new Rename(infotainmentFeature, "Test 123", timestamp);
		rename.execute();
	}
}
