/**
 * 
 */
package de.darwinspl.feature.evolution.tests;

import de.darwinspl.feature.evolution.basic.operations.AddFeatureWithGroup;
import de.darwinspl.feature.evolution.complex.operations.AddFeatureWithNameAndType;
import de.darwinspl.feature.evolution.complex.operations.AddToGroupComposition;
import de.darwinspl.feature.evolution.complex.operations.MergeKeepCode;
import de.darwinspl.feature.evolution.complex.operations.RemoveFromGroupComposition;
import de.darwinspl.feature.evolution.complex.operations.Split;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;

/**
 *
 */
public class ComplexOperationsTests extends TestCases{

	public static void testTimestampAdjustment(HyFeatureModel tfm) {
		
		calendar.set(2016, 0, 20, 23, 59, 59);
		timestamp = calendar.getTime();
		
		AddFeatureWithGroup addFwG = new AddFeatureWithGroup("test3", HyFeatureTypeEnum.MANDATORY,
				infotainmentFeature, timestamp, tfm);
		addFwG.execute();
		
		AddFeatureWithNameAndType addF = new AddFeatureWithNameAndType("test1", HyFeatureTypeEnum.OPTIONAL, timestamp, tfm);
		addF.execute();
		
		//Add new Feature to the group from the basic op add(wG)
		AddToGroupComposition addGC = new AddToGroupComposition(
				addFwG.getGroup().getParentOf().get(0), addF.getFeature() , timestamp);
		addGC.execute();
		
		//change timestamp
		calendar.set(2016, 1, 31, 23, 59, 59);
		timestamp = calendar.getTime();
		
		//remove the Feature from the add(wG) operation from his group
		RemoveFromGroupComposition remGC = new RemoveFromGroupComposition(
				addGC.getNewGroupComposition(), addFwG.getFeature(), timestamp);
		remGC.execute();
		
		//change timestamp
		calendar.set(2016, 2, 31, 23, 59, 59);
		timestamp = calendar.getTime();
		
		//add the feature again to his initially group
		AddToGroupComposition addGC2 = new AddToGroupComposition(
				remGC.getNewGroupComposition(), addFwG.getFeature(), timestamp);
		addGC2.execute();
	}
	
	public static void complexOperationUndoTests(HyFeatureModel tfm) {
		
		calendar.set(2016, 0, 20, 23, 59, 59);
		timestamp = calendar.getTime();

		AddToGroupComposition addGC = new AddToGroupComposition(frontDistanceSensorsAlternativeGroup.getParentOf().get(0), sideFeature, timestamp);
		addGC.undo();
		addGC.execute();
		addGC.undo();
		
		RemoveFromGroupComposition rmGC = new RemoveFromGroupComposition(frontDistanceSensorsAlternativeGroup.getParentOf().get(0), sideFeature, timestamp);
		rmGC.undo();
		rmGC.execute();
		rmGC.undo();
		
	}
	
	public static void complexOperationSplitAndMergeTests(HyFeatureModel tfm) {
		
		calendar.set(2016, 0, 20, 23, 59, 59);
		timestamp = calendar.getTime();
		
		Split split = new Split(infotainmentFeature, "infotainment 1", "infotainment 2", timestamp, tfm);
		split.execute();
		
		MergeKeepCode merge = new MergeKeepCode(split.getNewFeature1(), infotainmentFeature, timestamp);
		merge.execute();
		
	}
}
