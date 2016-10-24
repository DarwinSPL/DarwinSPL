/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;

public class HycontextinformationResourceFactoryDelegator implements Factory {
	
	protected Map<String, Factory> factories = null;
	
	public HycontextinformationResourceFactoryDelegator() {
		init();
	}
	
	protected void init() {
		if (factories == null) {
			factories = new LinkedHashMap<String, Factory>();
		}
		if (new eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationRuntimeUtil().isEclipsePlatformAvailable()) {
			new eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationEclipseProxy().getResourceFactoryExtensions(factories);
		}
		if (factories.get("") == null) {
			factories.put("", new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationResourceFactory());
		}
	}
	
	public Map<String, Factory> getResourceFactoriesMap() {
		return factories;
	}
	
	public Factory getFactoryForURI(URI uri) {
		URI trimmedURI = uri.trimFileExtension();
		String secondaryFileExtension = trimmedURI.fileExtension();
		Factory factory = factories.get(secondaryFileExtension);
		if (factory == null) {
			factory = factories.get("");
		}
		return factory;
	}
	
	public Resource createResource(URI uri) {
		return getFactoryForURI(uri).createResource(uri);
	}
	
}
