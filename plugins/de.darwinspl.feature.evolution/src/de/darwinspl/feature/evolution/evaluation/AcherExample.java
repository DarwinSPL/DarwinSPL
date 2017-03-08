/**
 * 
 */
package de.darwinspl.feature.evolution.evaluation;

import java.util.Calendar;
import java.util.Date;

import de.darwinspl.feature.evolution.basic.operations.AddFeatureInGroup;
import de.darwinspl.feature.evolution.basic.operations.AddFeatureWithGroup;
import de.darwinspl.feature.evolution.basic.operations.ChangeFeatureType;
import de.darwinspl.feature.evolution.basic.operations.ChangeGroupType;
import de.darwinspl.feature.evolution.basic.operations.Move;
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
public class AcherExample {


	public HyFeatureModel createTFM() {
		
		HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;

		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 0, 31, 23, 59, 59);
		Date timestamp = calendar.getTime();

		HyFeatureModel tfm = factory.createHyFeatureModel();
		
		//create root feature
		AddFeatureWithNameAndType applet = new AddFeatureWithNameAndType("applet", HyFeatureTypeEnum.MANDATORY, timestamp, tfm);
		applet.execute();
		HyRootFeature root = HyFeatureCreationUtil.createRootFeature(applet.getFeature(), timestamp, null, null);
		tfm.getRootFeature().add(root);
		
		
		AddFeatureWithGroup mustOverride = new AddFeatureWithGroup("mustOverride", HyFeatureTypeEnum.MANDATORY, applet.getFeature(), timestamp, tfm);
		mustOverride.execute();
		
		AddFeatureInGroup destroy = new AddFeatureInGroup("destroy", HyFeatureTypeEnum.OPTIONAL, mustOverride.getGroup(), timestamp, tfm);
		destroy.execute();
		
		AddFeatureInGroup stop = new AddFeatureInGroup("stop", HyFeatureTypeEnum.OPTIONAL, mustOverride.getGroup(), timestamp, tfm);
		stop.execute();
		
		AddFeatureWithGroup paint = new AddFeatureWithGroup("paint", HyFeatureTypeEnum.OPTIONAL, mustOverride.getFeature(), timestamp, tfm);
		paint.execute();
		
		AddFeatureInGroup start = new AddFeatureInGroup("start", HyFeatureTypeEnum.OPTIONAL, paint.getGroup(), timestamp, tfm);
		start.execute();
		
		AddFeatureInGroup init = new AddFeatureInGroup("init", HyFeatureTypeEnum.OPTIONAL, paint.getGroup(), timestamp, tfm);
		init.execute();
		
		ChangeGroupType paintGroupToOr = new ChangeGroupType(paint.getGroup(), HyGroupTypeEnum.OR, timestamp);
		paintGroupToOr.execute();
		
		//-------------------------Evolution-----------------------------------
		
		calendar.set(2017, 2, 06, 12, 00, 00);
		timestamp = calendar.getTime();
		
//		Move initUnderApplet = new Move(init.getFeature(), applet.getFeature(), mustOverride.getGroup(), timestamp, tfm);
//		initUnderApplet.execute();
//		
//		Move destroyUnderInit = new Move(destroy.getFeature(), init.getFeature(), null, timestamp, tfm);
//		destroyUnderInit.execute();
//		
//		Move stopUnderInit = new Move(stop.getFeature(), init.getFeature(), destroyUnderInit.getNewGroup(), timestamp, tfm);
//		stopUnderInit.execute();
//		
//		ChangeFeatureType overrideToOptional = new ChangeFeatureType(mustOverride.getFeature(), HyFeatureTypeEnum.OPTIONAL, timestamp);
//		overrideToOptional.execute();
		
//		OperationInvoker invoker = new OperationInvoker();
//		invoker.move(init.getFeature(), applet.getFeature(), mustOverride.getGroup(), timestamp, tfm);
//		invoker.move(destroy.getFeature(), init.getFeature(), null, timestamp, tfm);
//		invoker.move(stop.getFeature(), init.getFeature(), destroyUnderInit.getNewGroup(), timestamp, tfm);
		return tfm;
	}
	
}
