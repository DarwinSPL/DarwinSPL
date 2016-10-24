package eu.hyvar.feature.exporter.hfm_exporter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.deltaecore.feature.DEFeature;
import org.deltaecore.feature.DEFeatureFactory;
import org.deltaecore.feature.DEFeatureModel;
import org.deltaecore.feature.DEGroup;
import org.deltaecore.feature.DEVersion;

import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;
import eu.hyvar.feature.util.HyFeatureUtil;
import eu.hyvar.feature.util.exporter.HyFeatureExporter;

public class HFMExporter extends HyFeatureExporter<DEFeatureModel> {
//
	private DEFeatureFactory factory = DEFeatureFactory.eINSTANCE;

	private DEFeatureModel deFeatureModel;
	
	private Map<HyGroup, DEGroup> groupMapping;
	private Map<HyFeature, DEFeature> featureMapping;
	
	private Map<HyVersion, DEVersion> versionMapping;
	
	public DEFeature getDEFeature(HyFeature feature) {
		return featureMapping.get(feature);
	}
	
	public HyFeature getHyFeature(DEFeature feature) {
		for(HyFeature hyFeature: featureMapping.keySet()) {
			if(featureMapping.get(hyFeature).equals(feature)) {
				return hyFeature;
			}
		}
		
		return null;
	}
	
	public DEGroup getDEGroup(HyGroup group) {
		return groupMapping.get(group);
	}
	
	public HyGroup getHyGroup(DEGroup group) {
		for(HyGroup hyGroup: groupMapping.keySet()) {
			if(groupMapping.get(hyGroup).equals(group)) {
				return hyGroup;
			}
		}
		
		return null;
	}
	
	public DEVersion getDEVersion(HyVersion version) {
		return versionMapping.get(version);
	}
	
	public HyVersion getHyVersion(DEVersion version) {
		for(HyVersion hyVersion: versionMapping.keySet()) {
			if(versionMapping.get(hyVersion).equals(version)) {
				return hyVersion;
			}
		}
		
		return null;
	}
	
	public HFMExporter() {
		groupMapping = new HashMap<HyGroup, DEGroup>();
		featureMapping = new HashMap<HyFeature, DEFeature>();
		versionMapping = new HashMap<HyVersion, DEVersion>();
		
		deFeatureModel = factory.createDEFeatureModel();
	}
	
	@Override
	protected void visitFeature(HyFeature feature, HyName name, HyFeatureType featureType,
			List<? extends HyFeatureAttribute> attributes, List<HyVersion> versions, boolean isRoot, HyGroup group, Date date)
					throws HyFeatureModelWellFormednessException {
		// TODO attributes
		DEFeature deFeature = factory.createDEFeature();
		deFeature.setName(name.getName());
		
		switch(featureType.getType()) {
		case MANDATORY:
			deFeature.setMinCardinality(1);
			deFeature.setMaxCardinality(1);
			break;
		case OPTIONAL:
			deFeature.setMinCardinality(0);
			deFeature.setMaxCardinality(1);
			break;
		default:
			deFeature.setMinCardinality(0);
			deFeature.setMaxCardinality(1);
			break;
		}
		
		for(HyVersion version: versions) {
			// Create corresponding DEVersion
			DEVersion deVersion = factory.createDEVersion();
			deVersion.setFeature(deFeature);
			deVersion.setNumber(version.getNumber());
			
			// Check if superseded Version is already in the mapping - should be evolution safe
			if(versionMapping.containsKey(version.getSupersededVersion())) {
				DEVersion supersededVersion = versionMapping.get(version.getSupersededVersion());
				deVersion.setSupersededVersion(supersededVersion);
				supersededVersion.getSupersedingVersions().add(deVersion);
			}
			
			for(HyVersion supersedingVersion: version.getSupersedingVersions()) {
				if(versionMapping.containsKey(supersedingVersion)) {
					DEVersion deSupersedingVersion = versionMapping.get(supersedingVersion); 
					if(!deVersion.getSupersedingVersions().contains(deSupersedingVersion)) {
						deVersion.getSupersedingVersions().add(deSupersedingVersion);
					}
					
					deSupersedingVersion.setSupersededVersion(deVersion);
				}
			}
			
			versionMapping.put(version, deVersion);
		}
		
		if(isRoot) {
			deFeatureModel.setRootFeature(deFeature);
		} else {
			if(groupMapping.containsKey(group)) {
				DEGroup deGroup = groupMapping.get(group);
				deGroup.getFeatures().add(deFeature);
				deFeature.setParentOfFeature(deGroup);
			} else {
				System.err.println("Something bad happened. Feature visited and no belonging group was visited until then");
			}
		}
		
		
		featureMapping.put(feature, deFeature);
	}
	
	

	@Override
	protected void visitGroup(HyGroup group, HyGroupType groupType, HyFeature parent, Date date)
			throws HyFeatureModelWellFormednessException {
		DEGroup deGroup = factory.createDEGroup();
		
		switch(groupType.getType()) {
		case ALTERNATIVE:
			deGroup.setMinCardinality(1);
			deGroup.setMaxCardinality(1);
			break;
		case AND:
			deGroup.setMinCardinality(HyFeatureUtil.getAmountOfFeaturesOfGroup(group, HyFeatureTypeEnum.MANDATORY));
			deGroup.setMaxCardinality(HyFeatureUtil.getAmountOfFeaturesOfGroup(group, null));
			break;
		case OR:
			deGroup.setMinCardinality(1);
			deGroup.setMaxCardinality(HyFeatureUtil.getAmountOfFeaturesOfGroup(group, null));
			break;		
		}
		
		if(featureMapping.containsKey(parent)) {
			DEFeature deFeature = featureMapping.get(parent);
			deGroup.setParentOfGroup(deFeature);
		} else {
			System.err.println("Something bad happened. Group visited and the parent feature was not visited until then");
		}
		
		groupMapping.put(group, deGroup);
	}

	@Override
	protected DEFeatureModel finish() {
//		EcoreIOUtil.saveModel(deFeatureModel);
		
		
//		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
//	    Map<String, Object> m = reg.getExtensionToFactoryMap();
//	    m.put("feature", new XMIResourceFactoryImpl());
//
//	    // Obtain a new resource set
//	    ResourceSet resSet = new ResourceSetImpl();
//
//	    // create a resource
//	    Resource resource = resSet.createResource(URI
//	        .createURI("exports/exportedFeatureModel.feature"));
//	    // Get the first model element and cast it to the right type, in my
//	    // example everything is hierarchical included in this first node
//	    resource.getContents().add(deFeatureModel);
//
//	    // now save the content.
//	    try {
//	      resource.save(Collections.EMPTY_MAP);
//	    } catch (IOException e) {
//	      // TODO Auto-generated catch block
//	      e.printStackTrace();
//	    }
	    
	    return deFeatureModel;
	}

	public DEFeatureModel getDeFeatureModel() {
		return deFeatureModel;
	}

	public Map<HyGroup, DEGroup> getGroupMapping() {
		return groupMapping;
	}

	public Map<HyFeature, DEFeature> getFeatureMapping() {
		return featureMapping;
	}

	public Map<HyVersion, DEVersion> getVersionMapping() {
		return versionMapping;
	}

	
	
}
