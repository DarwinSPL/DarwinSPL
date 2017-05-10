/**
 * 
 */
package de.darwinspl.feature.evolution.evaluation;

import java.util.Calendar;
import java.util.Date;

import de.darwinspl.feature.evolution.basic.operations.Add;
import de.darwinspl.feature.evolution.basic.operations.AddFeatureWithGroup;
import de.darwinspl.feature.evolution.basic.operations.ChangeGroupType;
import de.darwinspl.feature.evolution.basic.operations.Delete;
import de.darwinspl.feature.evolution.basic.operations.Move;
import de.darwinspl.feature.evolution.complex.operations.AddFeatureWithNameAndType;
import de.darwinspl.feature.evolution.complex.operations.MergeFeatures;
import de.darwinspl.feature.evolution.complex.operations.Split;
import de.darwinspl.feature.evolution.complex.operations.SplitIntoFiveFeatures;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.util.HyFeatureCreationUtil;

/**
 *
 */
public class CoEvolutionExample {

	public HyFeatureModel createTFM() {
		
		HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;

		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 0, 31, 23, 59, 59);
		Date timestamp = calendar.getTime();

		HyFeatureModel tfm = factory.createHyFeatureModel();
		
		//create root feature
		AddFeatureWithNameAndType automotiveMuldimedia = new AddFeatureWithNameAndType("AutomotiveMultimedia", HyFeatureTypeEnum.MANDATORY, timestamp, tfm);
		automotiveMuldimedia.execute();
		HyRootFeature root = HyFeatureCreationUtil.createRootFeature(automotiveMuldimedia.getFeature(), timestamp, null, null);
		tfm.getRootFeature().add(root);
		
		AddFeatureWithGroup audioPlayer = new AddFeatureWithGroup("AudioPlayer", HyFeatureTypeEnum.OPTIONAL, automotiveMuldimedia.getFeature(), timestamp, tfm);
		audioPlayer.execute();
		
		Add onBoardComputer = new Add("OnBoardComputer", HyFeatureTypeEnum.MANDATORY, null, audioPlayer.getGroup(), timestamp, tfm);
		onBoardComputer.execute();
		
		Add radio = new Add("Radio", HyFeatureTypeEnum.MANDATORY, audioPlayer.getFeature(), null, timestamp, tfm);
		radio.execute();
		
		Add cassettePlayer = new Add("Cassette Player", HyFeatureTypeEnum.OPTIONAL, null, radio.getGroup(), timestamp, tfm);
		cassettePlayer.execute();
		
		Add cdPlayer = new Add("CDPlayer", HyFeatureTypeEnum.OPTIONAL, null, radio.getGroup(), timestamp, tfm);
		cdPlayer.execute();
		
		//-------------------------1. Evolution-----------------------------------
		
		calendar.set(2017, 2, 05, 12, 00, 00);
		timestamp = calendar.getTime();
		
		Delete deleteCassette = new Delete(cassettePlayer.getFeature(), timestamp);
		deleteCassette.execute();
		
		Split splitCDPlayer = new Split(cdPlayer.getFeature(), "AudioCDPlayer", "MP3CDPlayer", timestamp, tfm);
		splitCDPlayer.execute();
		
		ChangeGroupType alternativeCDGroup = new ChangeGroupType(splitCDPlayer.getGroup(), HyGroupTypeEnum.ALTERNATIVE, timestamp);
		alternativeCDGroup.execute();
		
		Add personalNavigation = new Add("PersonalNavigation", HyFeatureTypeEnum.OPTIONAL, null, audioPlayer.getGroup(), timestamp, tfm);
		personalNavigation.execute();
		
		Add voiceRecognition = new Add("VoiceRecognition", HyFeatureTypeEnum.OPTIONAL, personalNavigation.getFeature(), null, timestamp, tfm);
		voiceRecognition.execute();
		
		Add maps = new Add("Maps", HyFeatureTypeEnum.MANDATORY, null, voiceRecognition.getGroup(), timestamp, tfm);
		maps.execute();
		
		//-------------------------2. Evolution-----------------------------------
		
		calendar.set(2017, 2, 06, 12, 00, 00);
		timestamp = calendar.getTime();
		
		MergeFeatures mergeAudioCDInCDPlayer = new MergeFeatures(splitCDPlayer.getNewFeature1(), cdPlayer.getFeature(), timestamp);
		mergeAudioCDInCDPlayer.execute();
		
		MergeFeatures mergeMP3InCDPlayer = new MergeFeatures(splitCDPlayer.getNewFeature2(), cdPlayer.getFeature(), timestamp);
		mergeMP3InCDPlayer.execute();
		
		Move moveVoiceInPersonal = new Move(voiceRecognition.getFeature(), null, personalNavigation.getGroup(), timestamp, tfm);
		moveVoiceInPersonal.execute();
		
		SplitIntoFiveFeatures splitMaps = new SplitIntoFiveFeatures(maps.getFeature(), "Europe", "NorthAmerica", "CentralAmerica", "SouthAmerica", "Asia", timestamp, tfm);
		splitMaps.execute();
		
		return tfm;
	}
}
