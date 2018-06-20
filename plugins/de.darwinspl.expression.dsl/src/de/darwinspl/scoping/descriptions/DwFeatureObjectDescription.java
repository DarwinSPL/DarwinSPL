package de.darwinspl.scoping.descriptions;

import java.util.Date;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;

public class DwFeatureObjectDescription implements IEObjectDescription {

	protected HyFeature feature;
	protected Date date;
	protected QualifiedName name;
	
	public DwFeatureObjectDescription(HyFeature feature, Date date) {
		this.feature = feature;
		this.date = date;
		
		if(feature != null) {
			HyName hyName = HyEvolutionUtil.getValidTemporalElement(feature.getNames(), date);
			if(hyName != null) {
				name = QualifiedName.create(hyName.getName());
			}
		}
	}
	
	@Override
	public QualifiedName getName() {
		return name;
	}

	@Override
	public QualifiedName getQualifiedName() {
		return name;
	}

	@Override
	public EObject getEObjectOrProxy() {
		return feature;
	}

	@Override
	public URI getEObjectURI() {
		feature.eResource().getURI();
		return null;
	}

	@Override
	public EClass getEClass() {
		return feature.eClass();
	}

	@Override
	public String getUserData(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getUserDataKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
