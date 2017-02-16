/**
 * 
 */
package de.darwinspl.feature.evolution.tests;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.darwinspl.feature.evolution.atomic.operations.AddFeatureChild;
import de.darwinspl.feature.evolution.atomic.operations.AddFeatureType;
import de.darwinspl.feature.evolution.atomic.operations.AddGroupComposition;
import de.darwinspl.feature.evolution.atomic.operations.AddGroupType;
import de.darwinspl.feature.evolution.atomic.operations.AddName;
import de.darwinspl.feature.evolution.atomic.operations.DeleteFeatureChild;
import de.darwinspl.feature.evolution.atomic.operations.DeleteFeatureType;
import de.darwinspl.feature.evolution.atomic.operations.DeleteGroupComposition;
import de.darwinspl.feature.evolution.atomic.operations.DeleteGroupType;
import de.darwinspl.feature.evolution.atomic.operations.DeleteName;
import de.darwinspl.feature.evolution.complex.operations.AddFeatureWithNameAndType;
import de.darwinspl.feature.evolution.complex.operations.AddGroupWithTypeChildAndComposition;
import de.darwinspl.feature.evolution.complex.operations.DeleteFeatureWithNameAndType;
import de.darwinspl.feature.evolution.complex.operations.DeleteGroupWithTypeChildAndComposition;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroupTypeEnum;

/**
 *
 */
public class AtomicOperationTests extends TestCases {

	public static void atomicAddTests(HyFeatureModel tfm) {
		
		calendar.set(2016, 0, 20, 23, 59, 59);
		timestamp = calendar.getTime();
		
		AddName name = new AddName("test", infotainmentFeature, timestamp);
		AddFeatureType featureType = new AddFeatureType(HyFeatureTypeEnum.OPTIONAL, infotainmentFeature, timestamp);
		AddFeatureChild fc = new AddFeatureChild(infotainmentFeature, frontDistanceSensorsAlternativeGroup,
				timestamp);
		
		name.execute();
		featureType.execute();
		fc.execute();

//		AddFeatureWithNameAndType addF = new AddFeatureWithNameAndType("test1", HyFeatureTypeEnum.OPTIONAL, timestamp);
//		addF.execute();
//
//		EList<HyFeature> features = new BasicEList<HyFeature>();
//		features.addAll(frontDistanceSensorsAlternativeGroup.getParentOf().get(0).getFeatures());
//		features.add(addF.getFeature());
//		AddGroupWithTypeChildAndComposition addG = new AddGroupWithTypeChildAndComposition(HyGroupTypeEnum.ALTERNATIVE, infotainmentFeature, features, timestamp, tfm);
//		addG.execute();
	}
	
	public static void atomicDeleteTests(HyFeatureModel tfm) {
		
		calendar.set(2016, 0, 20, 23, 59, 59);
		timestamp = calendar.getTime();
		
		DeleteGroupComposition dGC = new DeleteGroupComposition(
				frontDistanceSensorsAlternativeGroup.getParentOf().get(0), timestamp);

		dGC.execute();
		
		DeleteGroupType deleteGT = new DeleteGroupType(frontDistanceSensorsAlternativeGroup.getTypes().get(0), timestamp);
		deleteGT.execute();
		
		DeleteFeatureChild deleteFC= new DeleteFeatureChild(frontDistanceSensorsAlternativeGroup.getChildOf().get(0), timestamp);
		deleteFC.execute();
		
		DeleteFeatureType deleteFT = new DeleteFeatureType(infotainmentFeature.getTypes().get(0), timestamp);
		deleteFT.execute();
		
		DeleteName deleteName = new DeleteName(infotainmentFeature.getNames().get(0), timestamp);
		deleteName.execute();
		
		AddFeatureWithNameAndType addF = new AddFeatureWithNameAndType("test1", HyFeatureTypeEnum.OPTIONAL, timestamp, tfm);
		addF.execute();
		DeleteFeatureWithNameAndType deleteF = new DeleteFeatureWithNameAndType(addF.getFeature(), timestamp);
		deleteF.execute();
		
		EList<HyFeature> features = new BasicEList<HyFeature>();
		features.addAll(frontDistanceSensorsAlternativeGroup.getParentOf().get(0).getFeatures());
		features.add(addF.getFeature());
		AddGroupWithTypeChildAndComposition addG = new AddGroupWithTypeChildAndComposition(HyGroupTypeEnum.ALTERNATIVE, infotainmentFeature, features, timestamp, tfm);
		addG.execute();
		DeleteGroupWithTypeChildAndComposition deleteG = new DeleteGroupWithTypeChildAndComposition(addG.getGroup(), timestamp);
		deleteG.execute();
	}
	
	public static void atomicUndoTests(HyFeatureModel tfm) {
		
		calendar.set(2016, 0, 20, 23, 59, 59);
		timestamp = calendar.getTime();
		
		AddName name = new AddName("test", infotainmentFeature, timestamp);
		name.undo();    //Shouldn't do anything
		name.execute();
		name.undo();
		
		AddFeatureType featureType = new AddFeatureType(HyFeatureTypeEnum.OPTIONAL, infotainmentFeature, timestamp);
		featureType.undo();    //Shouldn't do anything
		featureType.execute();
		featureType.undo();
		
		AddFeatureChild fc = new AddFeatureChild(infotainmentFeature, frontDistanceSensorsAlternativeGroup,
				timestamp);
		fc.undo();	//Shouldn't do anything
		fc.execute();
		fc.undo();
		
		AddFeatureWithNameAndType addF = new AddFeatureWithNameAndType("test1", HyFeatureTypeEnum.OPTIONAL, timestamp, tfm);
		addF.undo();	//Shouldn't do anything
		addF.execute();
		addF.undo();
		
		
		EList<HyFeature> features = new BasicEList<HyFeature>();
		features.addAll(frontDistanceSensorsAlternativeGroup.getParentOf().get(0).getFeatures());
		features.add(addF.getFeature());
		
		AddGroupType gt = new AddGroupType(HyGroupTypeEnum.ALTERNATIVE, frontDistanceSensorsAlternativeGroup, timestamp);
		gt.undo();	//Shouldn't do anything
		gt.execute();
		gt.undo();
		
		AddGroupComposition gc = new AddGroupComposition(frontDistanceSensorsAlternativeGroup, features, timestamp);
		gc.undo();	//Shouldn't do anything
		gc.execute();
		gt.undo();
		
		AddGroupWithTypeChildAndComposition addG = new AddGroupWithTypeChildAndComposition(HyGroupTypeEnum.ALTERNATIVE, infotainmentFeature, features, timestamp, tfm);
		addG.undo();	//Shouldn't do anything
		addG.execute();
		addG.undo();
		
	}
}
