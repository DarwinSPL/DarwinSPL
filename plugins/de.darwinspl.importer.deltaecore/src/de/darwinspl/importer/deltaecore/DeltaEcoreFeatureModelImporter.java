package de.darwinspl.importer.deltaecore;

import java.util.HashMap;
import java.util.Map;

import org.deltaecore.feature.DEFeature;
import org.deltaecore.feature.DEFeatureModel;
import org.deltaecore.feature.DEGroup;
import org.deltaecore.feature.DEVersion;
import org.eclipse.core.resources.IFile;

import de.darwinspl.importer.DarwinSPLFeatureModelImporter;
import eu.hyvar.evolution.HyEvolutionFactory;
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
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyVersion;

public class DeltaEcoreFeatureModelImporter implements DarwinSPLFeatureModelImporter<DEFeatureModel> {
	
	protected Map<DEFeature, HyFeature> featureMap;
	protected HyFeatureFactory factory;
	protected HyEvolutionFactory evoFactory;
	protected Map<DEVersion, HyVersion> versionMap;
	
	public DeltaEcoreFeatureModelImporter() {
		featureMap = new HashMap<DEFeature, HyFeature>();
		versionMap = new HashMap<DEVersion, HyVersion>();
		factory = HyFeatureFactory.eINSTANCE;
		evoFactory = HyEvolutionFactory.eINSTANCE;
	}

	@Override
	public HyFeatureModel importFeatureModel(DEFeatureModel featureModel) {
		
		HyFeatureModel dwFeatureModel = factory.createHyFeatureModel();
		
		DEFeature deRootFeature = featureModel.getRootFeature();
		if(deRootFeature != null) {
			HyRootFeature rootFeature = factory.createHyRootFeature();
			dwFeatureModel.getRootFeature().add(rootFeature);
			
			HyFeature rootFeatureFeature = translateFeature(deRootFeature, dwFeatureModel);
			rootFeature.setFeature(rootFeatureFeature);
			
			processSubTree(deRootFeature, rootFeatureFeature, dwFeatureModel);
		}
		
		return dwFeatureModel;
	}

	@Override
	public HyFeatureModel importFeatureModel(String pathToFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HyFeatureModel importFeatureModel(IFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	protected void processSubTree(DEFeature parentFeature, HyFeature translatedParentFeature, HyFeatureModel dwFeatureModel) {
		for(DEGroup group: parentFeature.getGroups()) {
			HyGroup dwGroup = factory.createHyGroup();
			
			dwFeatureModel.getGroups().add(dwGroup);
			
			HyGroupType groupType = factory.createHyGroupType();
			
			if(group.isAnd()) {
				groupType.setType(HyGroupTypeEnum.AND);
			} else if(group.isAlternative()) {
				groupType.setType(HyGroupTypeEnum.ALTERNATIVE);
			} else if(group.isOr()) {
				groupType.setType(HyGroupTypeEnum.OR);
			}
			
			dwGroup.getTypes().add(groupType);
			
			HyFeatureChild featureChild = factory.createHyFeatureChild();
			featureChild.setChildGroup(dwGroup);
			featureChild.setParent(translatedParentFeature);
			
			HyGroupComposition groupComposition = factory.createHyGroupComposition();
			groupComposition.setCompositionOf(dwGroup);
			
			for(DEFeature subFeature: group.getFeatures()) {
				HyFeature dwSubFeature = translateFeature(subFeature, dwFeatureModel);
				groupComposition.getFeatures().add(dwSubFeature);
				
				processSubTree(subFeature, dwSubFeature, dwFeatureModel);
			}
		}
	}
	
	
	
	protected HyFeature translateFeature(DEFeature feature, HyFeatureModel dwFeatureModel) {
		HyFeature dwFeature = factory.createHyFeature();
		
		HyName name = evoFactory.createHyName();
		name.setName(feature.getName());
		dwFeature.getNames().add(name);
		
		HyFeatureType featureType = factory.createHyFeatureType();
		
		if(feature.getMinCardinality() == 0) {
			featureType.setType(HyFeatureTypeEnum.OPTIONAL);
		}
		else {
			featureType.setType(HyFeatureTypeEnum.MANDATORY);
		}
		
		dwFeature.getTypes().add(featureType);
		
		dwFeatureModel.getFeatures().add(dwFeature);
		
		featureMap.put(feature, dwFeature);
		
		for(DEVersion version: feature.getVersions()) {
			HyVersion dwVersion = factory.createHyVersion();
			dwVersion.setNumber(version.getNumber());
			
			dwFeature.getVersions().add(dwVersion);
			
			
			HyVersion supersededVersion = versionMap.get(version.getSupersededVersion());
			if(supersededVersion != null) {
				dwVersion.setSupersededVersion(supersededVersion);
			}
			
			for(DEVersion supersedingVersion: version.getSupersedingVersions()) {
				HyVersion dwSupersedingVersion = versionMap.get(supersedingVersion);
				if(dwSupersedingVersion != null) {
					dwVersion.getSupersedingVersions().add(dwSupersedingVersion);
				}
			}
		}
		
		return dwFeature;
	}
}
