package eu.hyvar.feature.impl.custom;

import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

public class DwFeatureResourceFactoryImplCustom extends ResourceFactoryImpl {

	@Override
	public Resource createResource(URI uri) {
		XMLResourceImpl result = new XMIResourceImpl(uri);
		result.getDefaultLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		result.setIntrinsicIDToEObjectMap(new HashMap<String,EObject>());
		return result;
	}

}
