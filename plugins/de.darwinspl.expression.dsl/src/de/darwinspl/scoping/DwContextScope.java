package de.darwinspl.scoping;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.util.DwContextFeatureModelResolverUtil;
import eu.hyvar.feature.util.HyFeatureResolverUtil;

public class DwContextScope implements IScope {


	private EObject context;
	
	public DwContextScope(EObject context) {
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
		
		// TODO check that contexts temporal validity lies within the temporal validity of the container (e.g. constraint or validity formula). 
		Date date = new Date();
		
		HyContextualInformation resolvedContext = DwContextFeatureModelResolverUtil.resolveContext(identifier, featureModel, date);
		
		
		return null;
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
