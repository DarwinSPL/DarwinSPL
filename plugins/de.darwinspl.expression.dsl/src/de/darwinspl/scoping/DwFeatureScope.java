package de.darwinspl.scoping;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import de.darwinspl.scoping.descriptions.DwFeatureObjectDescription;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;
import eu.hyvar.feature.util.HyFeatureResolverUtil;

public class DwFeatureScope implements IScope {

	private EObject context;
	
	public DwFeatureScope(EObject context) {
		System.out.println("Test Scope");
		this.context = context;
	}
	
	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		if(name == null || name.getSegments() == null || name.getSegments().size() == 0) {
			return null;
		}
		
		HyFeatureModel featureModel = HyFeatureResolverUtil.getAccompanyingFeatureModel(context);
		if(featureModel == null) {
			return null;
		}
		
		String identifier = name.getFirstSegment();
		
		// TODO unresolved: what to do if multiple features have the same name?!
		Date date = null;
		if(context != null && context instanceof HyTemporalElement) {
			date = ((HyTemporalElement) context).getValidSince(); 
		}
		
		try {
			HyFeature feature = HyFeatureResolverUtil.resolveFeature(identifier, featureModel, date);
			DwFeatureObjectDescription objectDescription = new DwFeatureObjectDescription(feature, date);
			return objectDescription;
		} catch (HyFeatureModelWellFormednessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEObjectDescription getSingleElement(EObject object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<IEObjectDescription> getElements(EObject object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		// TODO Auto-generated method stub
		return null;
	}

}
