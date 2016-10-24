/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;

import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class HyvalidityformulaBuilderAdapter extends IncrementalProjectBuilder {
	
	private static class ResourceCollector implements IResourceDeltaVisitor, IResourceVisitor {
		
		private Map<IResource, Boolean> resourceMap = new LinkedHashMap<IResource, Boolean>();
		
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			return doVisit(resource, delta.getKind() == IResourceDelta.REMOVED);
		}
		
		public boolean visit(IResource resource) throws CoreException {
			return doVisit(resource, false);
		}
		
		private boolean doVisit(IResource resource, boolean removed) throws CoreException {
			resourceMap.put(resource, removed);
			return true;
		}
		
		private Map<IResource, Boolean> getResourceMap() {
			return resourceMap;
		}
		
	}
	
	/**
	 * The ID of the default, generated builder.
	 */
	public final static String BUILDER_ID = "eu.hyvar.context.contextValidity.resource.hyvalidityformula.builder";
	
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaBuilder defaultBuilder = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaBuilder();
	
	public IProject[] build(int kind, Map<String, String> args, final IProgressMonitor monitor) throws CoreException {
		// Collect resources that must be built
		ResourceCollector resourceCollector = new ResourceCollector();
		IResourceDelta delta = getDelta(getProject());
		if (delta != null) {
			// This is an incremental build
			delta.accept(resourceCollector);
		} else {
			// This is a full build
			getProject().accept(resourceCollector);
		}
		
		// This resource set is used during the whole build.
		ResourceSet resourceSet = new ResourceSetImpl();
		Map<IResource, Boolean> resourceMap = resourceCollector.getResourceMap();
		monitor.beginTask(eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaResourceBundle.BUILDER_ADAPTER_TASK_NAME, resourceMap.size() * 2);
		for (IResource resource : resourceMap.keySet()) {
			doVisit(resource, resourceMap.get(resource), monitor, resourceSet);
		}
		monitor.done();
		return null;
	}
	
	public void build(IFile resource, ResourceSet resourceSet, IProgressMonitor monitor) {
		URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaBuilder builder = getBuilder();
		if (builder.isBuildingNeeded(uri)) {
			eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResource customResource = (eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResource) resourceSet.getResource(uri, true);
			new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			builder.build(customResource, monitor);
		}
	}
	
	/**
	 * Returns the builder that shall be used by this adapter. This allows subclasses
	 * to perform builds with different builders.
	 */
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaBuilder getBuilder() {
		return defaultBuilder;
	}
	
	/**
	 * Returns the id for the markers that are created by this builder. This allows
	 * subclasses to produce different kinds of markers.
	 */
	public String getBuilderMarkerId() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaMarkerHelper().getMarkerID(eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemType.BUILDER_ERROR);
	}
	
	/**
	 * Runs the task item builder to search for new task items in changed resources.
	 */
	public void runTaskItemBuilder(IFile resource, ResourceSet resourceSet, IProgressMonitor monitor) {
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTaskItemBuilder taskItemBuilder = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTaskItemBuilder();
		taskItemBuilder.build(resource, resourceSet, monitor);
	}
	
	protected boolean doVisit(IResource resource, boolean removed, IProgressMonitor monitor, ResourceSet resourceSet) throws CoreException {
		if (removed) {
			URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
			eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaBuilder builder = getBuilder();
			if (builder.isBuildingNeeded(uri)) {
				builder.handleDeletion(uri, monitor);
			}
			new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			return false;
		}
		
		if (resource instanceof IFile && resource.getName().endsWith("." + new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaMetaInformation().getSyntaxName())) {
			// Calling the default generated builder is disabled because of syntax option
			// 'disableBuilder'.
			monitor.worked(1);
			// Second, call the task item builder that searches for task items in DSL
			// documents and creates task markers. The TaskItemBuilder may consume one tick
			// from the progress monitor.
			runTaskItemBuilder((IFile) resource, resourceSet, monitor);
			return false;
		}
		
		return true;
	}
	
}
