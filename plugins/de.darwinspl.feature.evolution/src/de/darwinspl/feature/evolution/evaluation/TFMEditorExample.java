/**
 * 
 */
package de.darwinspl.feature.evolution.evaluation;

import java.util.Calendar;
import java.util.Date;

import de.darwinspl.feature.evolution.basic.operations.Add;
import de.darwinspl.feature.evolution.basic.operations.AddFeatureInGroup;
import de.darwinspl.feature.evolution.basic.operations.AddFeatureWithGroup;
import de.darwinspl.feature.evolution.basic.operations.ChangeGroupType;
import de.darwinspl.feature.evolution.basic.operations.Rename;
import de.darwinspl.feature.evolution.complex.operations.AddFeatureWithNameAndType;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.util.HyFeatureCreationUtil;

/**
 *
 */
public class TFMEditorExample {
	
	public static void createTFM() {
		
		HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;

		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 0, 31, 23, 59, 59);
		Date timestamp = calendar.getTime();

		HyFeatureModel tfm = factory.createHyFeatureModel();
		
		//create root feature
		AddFeatureWithNameAndType car = new AddFeatureWithNameAndType("Car", HyFeatureTypeEnum.MANDATORY, timestamp, tfm);
		car.execute();
		HyRootFeature root = HyFeatureCreationUtil.createRootFeature(car.getFeature(), timestamp, null, null);
		tfm.getRootFeature().add(root);
		
		AddFeatureWithGroup ecu_a = new AddFeatureWithGroup("ECU_A", HyFeatureTypeEnum.OPTIONAL, car.getFeature(), timestamp, tfm);
		ecu_a.execute();
		
		AddFeatureWithGroup emergencyCall = new AddFeatureWithGroup("Emergency Call", HyFeatureTypeEnum.MANDATORY, ecu_a.getFeature(), timestamp, tfm);
		emergencyCall.execute();
		
		AddFeatureInGroup positioning = new AddFeatureInGroup("Positioning", HyFeatureTypeEnum.MANDATORY, emergencyCall.getGroup(), timestamp, tfm);
		positioning.execute();
		
		AddFeatureWithGroup eCall = new AddFeatureWithGroup("eCall", HyFeatureTypeEnum.OPTIONAL, emergencyCall.getFeature(), timestamp, tfm);
		eCall.execute();
		
		AddFeatureInGroup eraGlonass = new AddFeatureInGroup("Era Glonass", HyFeatureTypeEnum.OPTIONAL, eCall.getGroup(), timestamp, tfm);
		eraGlonass.execute();
		
		ChangeGroupType alternativeEmergencyCall = new ChangeGroupType(eCall.getGroup(), HyGroupTypeEnum.ALTERNATIVE, timestamp);
		alternativeEmergencyCall.execute();
		
		AddFeatureWithGroup gps = new AddFeatureWithGroup("GPS", HyFeatureTypeEnum.OPTIONAL, positioning.getFeature(), timestamp, tfm);
		gps.execute();
		
		AddFeatureInGroup glonass = new AddFeatureInGroup("Glonass", HyFeatureTypeEnum.OPTIONAL, gps.getGroup(), timestamp, tfm);
		glonass.execute();
		
		ChangeGroupType orPositioning = new ChangeGroupType(gps.getGroup(), HyGroupTypeEnum.OR, timestamp);
		orPositioning.execute();	
		
		//-------------------------Evolution-----------------------------------
			
		
		calendar.set(2017, 2, 06, 12, 00, 00);
		timestamp = calendar.getTime();
		
		Rename gnss = new Rename(positioning.getFeature(), "GNSS", timestamp);
		gnss.execute();
		
		Add ecu_b = new Add("ECU_B", HyFeatureTypeEnum.OPTIONAL, car.getFeature(), null, timestamp, tfm);
		ecu_b.execute();
		
		Add nav = new Add("Navigation System", HyFeatureTypeEnum.OPTIONAL, ecu_b.getFeature(), null, timestamp, tfm);
		nav.execute();
		
		Add emergencyCallUI = new Add("Emergency Call UI", HyFeatureTypeEnum.OPTIONAL, null, nav.getGroup(), timestamp, tfm);
		emergencyCallUI.execute();
		
		Add gearAdvice = new Add("GearAdvice", HyFeatureTypeEnum.MANDATORY, null, nav.getGroup(), timestamp, tfm);
		gearAdvice.execute();
		
	}
	
	public static void main(String[] args) {
		
		createTFM();
	}
}
