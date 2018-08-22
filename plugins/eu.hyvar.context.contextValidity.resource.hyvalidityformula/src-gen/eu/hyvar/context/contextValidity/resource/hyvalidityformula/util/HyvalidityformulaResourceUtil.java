/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Class ResourceUtil can be used to perform common tasks on resources, such as
 * resolving proxy object, saving resources, as well as, checking them for errors.
 */
public class HyvalidityformulaResourceUtil {
	
	/**
	 * <p>
	 * Searches for all unresolved proxy objects in the given resource set.
	 * </p>
	 * 
	 * @param resourceSet
	 * 
	 * @return all proxy objects that are not resolvable
	 */
	public static Set<EObject> findUnresolvedProxies(ResourceSet resourceSet) {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaInterruptibleEcoreResolver().findUnresolvedProxies(resourceSet);
	}
	
	/**
	 * <p>
	 * Searches for all unresolved proxy objects in the given resource.
	 * </p>
	 * 
	 * @param resource
	 * 
	 * @return all proxy objects that are not resolvable
	 */
	public static Set<EObject> findUnresolvedProxies(Resource resource) {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaInterruptibleEcoreResolver().findUnresolvedProxies(resource);
	}
	
	/**
	 * <p>
	 * Tries to resolve all unresolved proxy objects in the given resource. If all
	 * proxies were resolved true is returned. If some could not be resolved, false is
	 * returned.
	 * </p>
	 * 
	 * @param resource the resource containing the proxy object
	 * 
	 * @return true on success
	 */
	public static boolean resolveAll(Resource resource) {
		EcoreUtil.resolveAll(resource);
		if (findUnresolvedProxies(resource).size() > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static String getProxyIdentifier(EObject eObject) {
		String deresolvedReference = null;
		if (eObject instanceof EObject) {
			EObject eObjectToDeResolve = (EObject) eObject;
			if (eObjectToDeResolve.eIsProxy()) {
				deresolvedReference = ((InternalEObject) eObjectToDeResolve).eProxyURI().fragment();
				// If the proxy was created by EMFText, we can try to recover the identifier from
				// the proxy URI
				if (deresolvedReference != null && deresolvedReference.startsWith(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX)) {
					deresolvedReference = deresolvedReference.substring(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX.length());
					deresolvedReference = deresolvedReference.substring(deresolvedReference.indexOf("_") + 1);
				}
			}
		}
		return deresolvedReference;
	}
	
	public static eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResource getResource(File file) {
		return getResource(file, null);
	}
	
	public static eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResource getResource(File file, Map<?,?> options) {
		return getResource(URI.createFileURI(file.getAbsolutePath()), options);
	}
	
	public static eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResource getResource(URI uri) {
		return getResource(uri, null);
	}
	
	public static eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResource getResource(URI uri, Map<?,?> options) {
		new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaMetaInformation().registerResourceFactory();
		ResourceSet rs = new ResourceSetImpl();
		if (options != null) {
			rs.getLoadOptions().putAll(options);
		}
		Resource resource = rs.getResource(uri, true);
		return (eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResource) resource;
	}
	
	/**
	 * Returns the resource after parsing the given text. This method is deprecated
	 * because it uses the default platform encoding. Use {@link #getResource(byte[])}
	 * instead.
	 */
	@Deprecated
	public static Resource getResource(String text) {
		ResourceSet resourceSet = new ResourceSetImpl();
		return getResource(text, resourceSet);
	}
	
	/**
	 * Returns the resource after parsing the given text. This method is deprecated
	 * because it uses the default platform encoding. Use {@link #getResource(byte[],
	 * ResourceSet)} instead.
	 */
	@Deprecated
	public static Resource getResource(String text, ResourceSet resourceSet) {
		return getResource(text.getBytes(), resourceSet);
	}
	
	/**
	 * Returns the resource after parsing the given bytes.
	 */
	public static Resource getResource(byte[] content) {
		ResourceSet resourceSet = new ResourceSetImpl();
		return getResource(content, resourceSet);
	}
	
	/**
	 * Returns the resource after parsing the given bytes.
	 */
	public static Resource getResource(byte[] content, ResourceSet resourceSet) {
		return getResource(content, resourceSet, null);
	}
	
	/**
	 * Returns the resource after parsing the given bytes using the given load options.
	 */
	public static Resource getResource(byte[] content, ResourceSet resourceSet, Map<?, ?> loadOptions) {
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaMetaInformation metaInformation = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaMetaInformation();
		metaInformation.registerResourceFactory();
		URI uri = URI.createURI("temp." + metaInformation.getSyntaxName());
		Resource resource = resourceSet.createResource(uri);
		if (resource == null) {
			return null;
		}
		ByteArrayInputStream inputStream = new ByteArrayInputStream(content);
		try {
			resource.load(inputStream, loadOptions);
		} catch (IOException ioe) {
			return null;
		}
		return resource;
	}
	
	/**
	 * Returns the root element of the resource with the given URI.
	 */
	public static eu.hyvar.context.contextValidity.HyValidityModel getResourceContent(URI uri) {
		return getResourceContent(uri, null);
	}
	
	/**
	 * Returns the root element of the resource with the given URI.
	 */
	public static eu.hyvar.context.contextValidity.HyValidityModel getResourceContent(URI uri, Map<?,?> options) {
		Resource resource = getResource(uri, options);
		if (resource == null) {
			return null;
		}
		List<EObject> contents = resource.getContents();
		if (contents == null || contents.isEmpty()) {
			return null;
		}
		EObject root = contents.get(0);
		return (eu.hyvar.context.contextValidity.HyValidityModel) root;
	}
	
	/**
	 * Returns the root element after parsing the given text.
	 */
	public static eu.hyvar.context.contextValidity.HyValidityModel getResourceContent(String text) {
		return (eu.hyvar.context.contextValidity.HyValidityModel) getResourceContent(text, null);
	}
	
	/**
	 * Returns the root element after parsing the given text assuming the specified
	 * EClass as start rule.
	 */
	public static EObject getResourceContent(String text, EClass startEClass) {
		Map<Object, Object> loadOptions = new LinkedHashMap<Object, Object>();
		
		if (startEClass != null) {
			loadOptions.put(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaOptions.RESOURCE_CONTENT_TYPE, startEClass);
		}
		
		Resource resource = getResource(text.getBytes(), new ResourceSetImpl(), loadOptions);
		
		if (resource == null) {
			return null;
		}
		List<EObject> contents = resource.getContents();
		if (contents == null || contents.isEmpty()) {
			return null;
		}
		EObject root = contents.get(0);
		return root;
	}
	
	public static void saveResource(File file, Resource resource) throws IOException {
		Map<?, ?> options = Collections.EMPTY_MAP;
		OutputStream outputStream = new FileOutputStream(file);
		resource.save(outputStream, options);
		outputStream.close();
	}
	
	public static String getText(EObject eObject) {
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaMetaInformation metaInformation = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaMetaInformation();
		metaInformation.registerResourceFactory();
		ResourceSet rs = null;
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResource resource = (eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResource) eObject.eResource();
		if (resource != null) {
			rs = resource.getResourceSet();
		}
		if (rs == null) {
			rs = new ResourceSetImpl();
		}
		if (resource == null) {
			URI uri = URI.createURI("temp." + metaInformation.getSyntaxName());
			resource = (eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResource) rs.createResource(uri);
		}
		// Convert layout information to EAdapters because the printer retrieves layout
		// information from these adapters.
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaLayoutUtil layoutUtil = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaLayoutUtil();
		if (resource.isLayoutInformationRecordingEnabled()) {
			layoutUtil.transferAllLayoutInformationFromModel(eObject);
		}
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextPrinter printer = metaInformation.createPrinter(outputStream, resource);
		try {
			printer.print(eObject);
		} catch (IOException e) {
			return null;
		}
		// Move layout information from EAdapters back to the model.
		if (resource.isLayoutInformationRecordingEnabled()) {
			layoutUtil.transferAllLayoutInformationToModel(eObject);
		}
		return outputStream.toString();
	}
	
	public static boolean containsErrors(Resource resource) {
		return !resource.getErrors().isEmpty();
	}
	
	public static boolean containsWarnings(Resource resource) {
		return !resource.getWarnings().isEmpty();
	}
	
	public static boolean containsProblems(Resource resource) {
		return containsErrors(resource) || containsWarnings(resource);
	}
	
}
