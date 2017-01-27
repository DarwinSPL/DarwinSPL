/**
 * 
 */
package de.darwinspl.feature.evolution.tests;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.darwinspl.feature.evolution.atomic.operations.AddFeature;
import de.darwinspl.feature.evolution.atomic.operations.AddFeatureChild;
import de.darwinspl.feature.evolution.atomic.operations.AddFeatureType;
import de.darwinspl.feature.evolution.atomic.operations.AddGroup;
import de.darwinspl.feature.evolution.atomic.operations.AddName;
import de.darwinspl.feature.evolution.atomic.operations.DeleteFeature;
import de.darwinspl.feature.evolution.atomic.operations.DeleteFeatureChild;
import de.darwinspl.feature.evolution.atomic.operations.DeleteFeatureType;
import de.darwinspl.feature.evolution.atomic.operations.DeleteGroup;
import de.darwinspl.feature.evolution.atomic.operations.DeleteGroupComposition;
import de.darwinspl.feature.evolution.atomic.operations.DeleteGroupType;
import de.darwinspl.feature.evolution.atomic.operations.DeleteName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroupTypeEnum;

/**
 *
 */
public class AtomicOperationTests extends TestCases {

	public static void atomicAddTests(HyFeatureModel tfm) {
		
		AddName name = new AddName("test", infotainmentFeature, timestamp);
		AddFeatureType featureType = new AddFeatureType(HyFeatureTypeEnum.OPTIONAL, infotainmentFeature, timestamp);
		AddFeatureChild fc = new AddFeatureChild(infotainmentFeature, frontDistanceSensorsAlternativeGroup,
				timestamp);
		
		name.execute();
		featureType.execute();
		fc.execute();

		AddFeature addF = new AddFeature("test1", HyFeatureTypeEnum.OPTIONAL, timestamp);
		addF.execute();

		EList<HyFeature> features = new BasicEList<HyFeature>();
		features.addAll(frontDistanceSensorsAlternativeGroup.getParentOf().get(0).getFeatures());
		features.add(addF.getFeature());
		AddGroup addG = new AddGroup(HyGroupTypeEnum.ALTERNATIVE, infotainmentFeature, features, timestamp, tfm);
		addG.execute();
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
		
		AddFeature addF = new AddFeature("test1", HyFeatureTypeEnum.OPTIONAL, timestamp);
		addF.execute();
		DeleteFeature deleteF = new DeleteFeature(addF.getFeature(), timestamp);
		deleteF.execute();
		
		EList<HyFeature> features = new BasicEList<HyFeature>();
		features.addAll(frontDistanceSensorsAlternativeGroup.getParentOf().get(0).getFeatures());
		features.add(addF.getFeature());
		AddGroup addG = new AddGroup(HyGroupTypeEnum.ALTERNATIVE, infotainmentFeature, features, timestamp, tfm);
		addG.execute();
		DeleteGroup deleteG = new DeleteGroup(addG.getGroup(), timestamp);
		deleteG.execute();
	}
}
