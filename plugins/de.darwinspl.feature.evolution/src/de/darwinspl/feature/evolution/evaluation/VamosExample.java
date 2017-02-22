/**
 * 
 */
package de.darwinspl.feature.evolution.evaluation;

import java.util.Calendar;
import java.util.Date;

import de.darwinspl.feature.evolution.atomic.operations.AddName;
import de.darwinspl.feature.evolution.basic.operations.Add;
import de.darwinspl.feature.evolution.basic.operations.AddFeatureInGroup;
import de.darwinspl.feature.evolution.basic.operations.AddFeatureWithGroup;
import de.darwinspl.feature.evolution.basic.operations.ChangeFeatureType;
import de.darwinspl.feature.evolution.basic.operations.ChangeGroupType;
import de.darwinspl.feature.evolution.basic.operations.Delete;
import de.darwinspl.feature.evolution.basic.operations.Move;
import de.darwinspl.feature.evolution.basic.operations.Rename;
import de.darwinspl.feature.evolution.complex.operations.AddFeatureWithNameAndType;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.util.HyFeatureCreationUtil;

import de.darwinspl.feature.evolution.invoker.OperationInvoker;

/**
 *
 */
public class VamosExample {
	
	public HyFeatureModel createTFM() {
		
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

		AddFeatureWithGroup assistanceSystems = new AddFeatureWithGroup("Assistance Systems", HyFeatureTypeEnum.OPTIONAL, car.getFeature(), timestamp, tfm);
		assistanceSystems.execute();
		
		AddFeatureInGroup infotainmentSystem = new AddFeatureInGroup("Infotainment System", HyFeatureTypeEnum.MANDATORY, assistanceSystems.getGroup(), timestamp, tfm);
		infotainmentSystem.execute();
		
		AddFeatureWithGroup parkingAssistance = new AddFeatureWithGroup("Parking Assistance", HyFeatureTypeEnum.OPTIONAL, assistanceSystems.getFeature(), timestamp, tfm);
		parkingAssistance.execute();
		
		AddFeatureInGroup frontDistanceSensor = new AddFeatureInGroup("Front Distance Sensor", HyFeatureTypeEnum.OPTIONAL, parkingAssistance.getGroup(), timestamp, tfm);
		frontDistanceSensor.execute();
		
		AddFeatureInGroup adaptiveCruiseControl = new AddFeatureInGroup("Adaptive Criuse Control", HyFeatureTypeEnum.OPTIONAL, parkingAssistance.getGroup(), timestamp, tfm);
		adaptiveCruiseControl.execute();
		
		AddFeatureWithGroup consumptionIndikator = new AddFeatureWithGroup("Consumption Indikator", HyFeatureTypeEnum.OPTIONAL, infotainmentSystem.getFeature(), timestamp, tfm);
		consumptionIndikator.execute();
		
		AddFeatureWithGroup sideDistanceSensor = new AddFeatureWithGroup("Side Distance Sensor", HyFeatureTypeEnum.MANDATORY, parkingAssistance.getFeature(), timestamp, tfm);
		sideDistanceSensor.execute();
		
		//-------------------------Evolution-----------------------------------
		
		calendar.set(2017, 2, 06, 12, 00, 00);
		timestamp = calendar.getTime();
		
		Add distanceSensors = new Add("Distance Sensors", HyFeatureTypeEnum.OPTIONAL, null, assistanceSystems.getGroup(), timestamp, tfm);
		distanceSensors.execute(); 
		
		Add frontDistanceSensors = new Add("Front Distance Sensors", HyFeatureTypeEnum.OPTIONAL, distanceSensors.getFeature(), null, timestamp, tfm);
		frontDistanceSensors.execute();
		
		Add fastFrontDistanceSensor = new Add("Fast Front Distance Sensor", HyFeatureTypeEnum.OPTIONAL, frontDistanceSensors.getFeature(), null, timestamp, tfm);
		fastFrontDistanceSensor.execute();
		
		Delete deleteConsumptionIndicator = new Delete(consumptionIndikator.getFeature(), timestamp);
		deleteConsumptionIndicator.execute();
		
		Rename slowFrontDistanceSensor = new Rename(frontDistanceSensor.getFeature(), "Slow Front Distance Sensor", timestamp);
		slowFrontDistanceSensor.execute();
		
		Move moveSideDistance = new Move(sideDistanceSensor.getFeature(), distanceSensors.getFeature(), frontDistanceSensors.getGroup(), timestamp, tfm); //parent could also be null
		moveSideDistance.execute();
		
		ChangeFeatureType sideDistanceToOptional = new ChangeFeatureType(sideDistanceSensor.getFeature(), HyFeatureTypeEnum.OPTIONAL, timestamp);
		sideDistanceToOptional.execute();
		
		Move moveSlowFrontSensor = new Move(slowFrontDistanceSensor.getFeature(), null, fastFrontDistanceSensor.getGroup(), timestamp, tfm);	//parent: frontDistanceSensors.getFeature()
		moveSlowFrontSensor.execute();
		
		ChangeGroupType fastDistanceSensorGroupToAlternative = new ChangeGroupType(fastFrontDistanceSensor.getGroup(), HyGroupTypeEnum.ALTERNATIVE, timestamp);
		fastDistanceSensorGroupToAlternative.execute();
		
		return tfm;
		
	}
	
}
