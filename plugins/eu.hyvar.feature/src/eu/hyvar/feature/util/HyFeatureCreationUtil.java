package eu.hyvar.feature.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyLinearTemporalElement;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyStringAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.impl.custom.HyFeatureFactoryWithIds;

public class HyFeatureCreationUtil {
	
	private static HyFeatureFactory factory = HyFeatureFactoryWithIds.eINSTANCE;


	public static HyFeature createFeature(HyFeatureType type ,HyName name,
			Date validSince, Date validUntil) {
		HyFeature feature = factory.createHyFeature();

		if(name!= null) {
			feature.getNames().add(name);			
		}
		else {
			System.err.println("Braah!");
		}
		if(type != null) {
			feature.getTypes().add(type);			
		}
		setValidity(feature, validSince, validUntil);

		return feature;
	}

	public static void setValidity(HyTemporalElement temporalElement,
			Date validSince, Date validUntil) {
		if(temporalElement == null) {
			System.err.println("Something bad happened. Could not set validity time for TemporalElement. TemporalElement given to setValidity(...) was null");
			return;
		}
		
		temporalElement.setValidSince(validSince);
		temporalElement.setValidUntil(validUntil);
	}

	public static HyGroup createGroup(HyGroupType type,
			Date validSince, Date validUntil) {
		
		
		HyGroup group = factory.createHyGroup();

		if(type != null) {
			group.getTypes().add(type);
		}
		setValidity(group, validSince, validUntil);

		return group;
	}

	public static HyFeatureType createFeatureType(HyFeatureTypeEnum featureType, Date validSince, Date validUntil,
			HyFeatureType supersededType) {
		HyFeatureType type = factory
				.createHyFeatureType();
		setValidity(type, validSince, validUntil);
		type.setType(featureType);

		if (supersededType != null) {
			setSupersedingRelationForLinearTemporalElements(
					supersededType, type);
		}

		return type;
	}
	
	public static HyGroupType createGroupType(HyGroupTypeEnum groupType, Date validSince, Date validUntil,
			HyGroupType supersededType) {
		HyGroupType type = factory
				.createHyGroupType();
		setValidity(type, validSince, validUntil);
		type.setType(groupType);

		if (supersededType != null) {
			setSupersedingRelationForLinearTemporalElements(
					supersededType, type);
		}

		return type;
	}

	public static HyVersion createVersion(String number, Date validSince,
			Date validUntil, HyVersion supersededVersion) {
		if(number == null) {
			System.err.println("Something bad happened. Could not create version. number string given to createVersion(...) was null");
			return null;
		}
		
		HyVersion version = factory.createHyVersion();
		version.setNumber(number);
		setValidity(version, validSince, validUntil);
		
		if(supersededVersion != null) {
			version.setSupersededVersion(supersededVersion);
		}
		
		return version;
	}

	public static HyGroupComposition createGroupComposition(Date validSince,
			Date validUntil, HyGroupComposition supersededComposition) {
		HyGroupComposition groupComposition = factory
				.createHyGroupComposition();
		setValidity(groupComposition, validSince, validUntil);

		if (supersededComposition != null) {
			setSupersedingRelationForLinearTemporalElements(
					supersededComposition, groupComposition);
		}

		return groupComposition;
	}

	public static void setSupersedingRelationForLinearTemporalElements(
			HyLinearTemporalElement supersededElement,
			HyLinearTemporalElement supersedingElement) {
		supersededElement.setSupersedingElement(supersedingElement);
		supersedingElement.setSupersededElement(supersededElement);
	}
	
	public static void setSupersedingRelationForVersions(HyVersion supersededVersion, HyVersion supersedingVersion) {
		if(!supersededVersion.getSupersedingVersions().contains(supersedingVersion)) {
			supersededVersion.getSupersedingVersions().add(supersedingVersion);
		}
		supersedingVersion.setSupersededVersion(supersededVersion);
	}

	public static HyFeatureChild createFeatureChild(Date validSince,
			Date validUntil, HyFeatureChild supersededFeatureChild) {
		HyFeatureChild featureChild = factory
				.createHyFeatureChild();
		setValidity(featureChild, validSince, validUntil);

		if (supersededFeatureChild != null) {
			setSupersedingRelationForLinearTemporalElements(
					supersededFeatureChild, featureChild);
		}

		return featureChild;
	}

	public static HyName createName(String name, Date validSince,
			Date validUntil, HyName supersededName) {
		if(name == null) {
			System.err.println("Something bad happened. Could not create Name. name string given to createName(...) was null");
			return null;
		}
		
		HyName nameObject = HyEvolutionFactory.eINSTANCE.createHyName();
		nameObject.setName(name);
		setValidity(nameObject, validSince, validUntil);
		if (supersededName != null) {
			setSupersedingRelationForLinearTemporalElements(supersededName,
					nameObject);
		}

		return nameObject;
	}

	public static HyRootFeature createRootFeature(HyFeature feature,
			Date validSince, Date validUntil, HyRootFeature supersededRootFeature) {
		if(feature == null) {
			System.err.println("Something bad happened. Could not create RootFeature. Feature given to createRootFeature(...) was null");
			return null;
		}
		
		HyRootFeature rootFeature = factory
				.createHyRootFeature();
		rootFeature.setFeature(feature);
		setValidity(rootFeature, validSince, validUntil);
		if (supersededRootFeature != null) {
			setSupersedingRelationForLinearTemporalElements(
					supersededRootFeature, rootFeature);
		}
		return rootFeature;
	}

	public static HyNumberAttribute createNumberAttribute(HyName name, Date validSince, Date validUntil) {
		HyNumberAttribute attribute = factory.createHyNumberAttribute();
		if(name!=null) {
			attribute.getNames().add(name);			
		}
		setValidity(attribute, validSince, validUntil);
		return attribute;
	}
	
	public static HyBooleanAttribute createBooleanAttribute(Date validSince, Date validUntil, HyName name) {
		HyBooleanAttribute attribute = factory.createHyBooleanAttribute();
		if(name!=null) {
			attribute.getNames().add(name);
		}
		setValidity(attribute, validSince, validUntil);
		return attribute;
	}
	
	public static HyStringAttribute createStringAttribute(Date validSince, Date validUntil, HyName name) {
		HyStringAttribute attribute = factory.createHyStringAttribute();
		if(name!=null) {
			attribute.getNames().add(name);
		}
		setValidity(attribute, validSince, validUntil);
		return attribute;
	}
	
	public static HyEnumAttribute createEnumAttribute(Date validSince, Date validUntil, HyName name) {
		HyEnumAttribute attribute = factory.createHyEnumAttribute();
		if(name!=null) {
			attribute.getNames().add(name);
		}
		setValidity(attribute, validSince, validUntil);
		return attribute;
	}
	
	
	// TODO Enum literal
	
	// --------------- Cloning methods
	
	public static HyFeatureChild cloneFeatureChild(HyFeatureChild featureChild) {
		HyFeatureChild newFeatureChild = factory.createHyFeatureChild();
		cloneValidity(featureChild, newFeatureChild);
		return newFeatureChild;
	}
	
	public static HyGroup cloneGroup(HyGroup group) {
		HyGroup newGroup = factory.createHyGroup();
		cloneValidity(group, newGroup);
		return newGroup;
	}
	
	public static HyGroupComposition cloneGroupComposition(HyGroupComposition groupComposition) {
		HyGroupComposition newGroupComposition = factory.createHyGroupComposition();
		cloneValidity(groupComposition, newGroupComposition);
		return newGroupComposition;
	}
	
	public static List<HyVersion> cloneVersions(List<HyVersion> versions) {
		List<HyVersion> newVersions = new ArrayList<HyVersion>();
		for(HyVersion version: versions) {
			newVersions.add(cloneVersion(version));
		}
		return newVersions;
	}
	
	public static HyVersion cloneVersion(HyVersion version) {
		HyVersion newVersion = factory.createHyVersion();
		newVersion.setNumber(version.getNumber());
		cloneValidity(version, newVersion);
		return newVersion;
	}
	
	public static HyRootFeature cloneRootFeature(HyRootFeature rootFeature) {
		HyRootFeature newRootFeature = factory.createHyRootFeature();
		cloneValidity(rootFeature, newRootFeature);
		return newRootFeature;
	}
	
	public static HyName cloneName(HyName name) {
		HyName newName = HyEvolutionFactory.eINSTANCE.createHyName();
		newName.setName(name.getName());
		cloneValidity(name, newName);
		return newName;
	}
	
	public static HyFeature cloneFeature(HyFeature feature) {
		HyFeature newFeature = factory.createHyFeature();
		if(feature.getDeprecatedSince() == null) {
			newFeature.setDeprecatedSince(null);
		} else {
			newFeature.setDeprecatedSince((Date)feature.getDeprecatedSince().clone());			
		}
		cloneValidity(feature, newFeature);
		return newFeature;
	}
	
	public static void cloneValidity(HyTemporalElement source, HyTemporalElement target) {
		if(source.getValidSince() == null) {
			target.setValidSince(null);
		} else {
			target.setValidSince((Date)source.getValidSince().clone());			
		}
		
		if(source.getValidUntil() == null) {
			target.setValidUntil(null);
		} else {
			target.setValidUntil((Date)source.getValidUntil().clone());			
		}
	}
	
	public static HyFeatureType cloneFeatureType(HyFeatureType type) {
		HyFeatureType clonedType = createFeatureType(type.getType(), null, null, (HyFeatureType) type.getSupersededElement());
		cloneValidity(type, clonedType);
		return clonedType;
	}
	

	public static HyGroupType cloneFeatureType(HyGroupType type) {
		HyGroupType clonedType = createGroupType(type.getType(), null, null, (HyGroupType) type.getSupersededElement());
		cloneValidity(type, clonedType);
		return clonedType;
	}
	
}
