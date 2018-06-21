package de.darwinspl.scoping.descriptions;

import eu.hyvar.context.HyContextualInformation;

import java.util.Date;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

public class DwContextObjectDescription implements IEObjectDescription {

	protected HyContextualInformation context;
	protected Date date;
	protected QualifiedName name;
	
	public DwContextObjectDescription(HyContextualInformation context) {
		this.context = context;

		if(context != null) {
			QualifiedName.create(context.getName());
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
		return context;
	}

	@Override
	public URI getEObjectURI() {
		return context.eResource().getURI();
	}

	@Override
	public EClass getEClass() {
		return context.eClass();
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
