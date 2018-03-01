package eu.hyvar.feature.impl.custom;

import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import eu.hyvar.feature.util.HyFeatureResourceFactoryImpl;
import eu.hyvar.feature.util.HyFeatureResourceImpl;

public class HyFeatureResourceFactoryImplCustom extends HyFeatureResourceFactoryImpl {

	@Override
	public Resource createResource(URI uri) {
		XMLResourceImpl result = new HyFeatureResourceImpl(uri);
		result.getDefaultLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		result.setIntrinsicIDToEObjectMap(new HashMap<String,EObject>());
		return result;
	}

}
