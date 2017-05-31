package de.darwinspl.feature.graphical.editor.util;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyVersion;

public class DwEcoreUtil {
	public static HyFeature copy(HyFeature o){
		HyFeature result = (HyFeature)EcoreUtil.copy(o);
		result.setId(o.getId());
		
		for(int i=0; i<o.getNames().size(); i++){
			result.getNames().get(i).setId(o.getNames().get(i).getId());
		}
		
		for(int i=0; i<o.getTypes().size(); i++){
			result.getTypes().get(i).setId(o.getTypes().get(i).getId());
		}	
		
		return result;	
	}
	
	public static HyFeatureChild copy(HyFeatureChild o){
		HyFeatureChild result = (HyFeatureChild)EcoreUtil.copy(o);
		result.setId(o.getId());
		
		return result;	
	}	
	
	public static HyGroupComposition copy(HyGroupComposition o){
		HyGroupComposition result = (HyGroupComposition)EcoreUtil.copy(o);
		result.setId(o.getId());
		
		return result;	
	}
	
	public static HyGroup copy(HyGroup o){
		HyGroup result = (HyGroup)EcoreUtil.copy(o);
		result.setId(o.getId());
		
		for(int i=0; i<o.getTypes().size(); i++){
			result.getTypes().get(i).setId(o.getTypes().get(i).getId());
		}	
		
		return result;	
	}
	
	public static HyVersion copy(HyVersion o){
		HyVersion result = (HyVersion)EcoreUtil.copy(o);
		result.setId(o.getId());
		
		return result;
	}
}
