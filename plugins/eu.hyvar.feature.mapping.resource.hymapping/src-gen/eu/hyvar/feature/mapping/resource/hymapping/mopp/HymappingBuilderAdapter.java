/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

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

public class HymappingBuilderAdapter extends IncrementalProjectBuilder {
	
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
	public final static String BUILDER_ID = "eu.hyvar.feature.mapping.resource.hymapping.builder";
	
	private eu.hyvar.feature.mapping.resource.hymapping.IHymappingBuilder defaultBuilder = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingBuilder();
	
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
		monitor.beginTask(eu.hyvar.feature.mapping.resource.hymapping.HymappingResourceBundle.BUILDER_ADAPTER_TASK_NAME, resourceMap.size() * 2);
		for (IResource resource : resourceMap.keySet()) {
			doVisit(resource, resourceMap.get(resource), monitor, resourceSet);
		}
		monitor.done();
		return null;
	}
	
	public void build(IFile resource, ResourceSet resourceSet, IProgressMonitor monitor) {
		URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		eu.hyvar.feature.mapping.resource.hymapping.IHymappingBuilder builder = getBuilder();
		if (builder.isBuildingNeeded(uri)) {
			eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingResource customResource = (eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingResource) resourceSet.getResource(uri, true);
			new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			builder.build(customResource, monitor);
		}
	}
	
	/**
	 * Returns the builder that shall be used by this adapter. This allows subclasses
	 * to perform builds with different builders.
	 */
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingBuilder getBuilder() {
		return defaultBuilder;
	}
	
	/**
	 * Returns the id for the markers that are created by this builder. This allows
	 * subclasses to produce different kinds of markers.
	 */
	public String getBuilderMarkerId() {
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingMarkerHelper().getMarkerID(eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemType.BUILDER_ERROR);
	}
	
	/**
	 * Runs the task item builder to search for new task items in changed resources.
	 */
	public void runTaskItemBuilder(IFile resource, ResourceSet resourceSet, IProgressMonitor monitor) {
		eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTaskItemBuilder taskItemBuilder = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTaskItemBuilder();
		taskItemBuilder.build(resource, resourceSet, monitor);
	}
	
	protected boolean doVisit(IResource resource, boolean removed, IProgressMonitor monitor, ResourceSet resourceSet) throws CoreException {
		if (removed) {
			URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
			eu.hyvar.feature.mapping.resource.hymapping.IHymappingBuilder builder = getBuilder();
			if (builder.isBuildingNeeded(uri)) {
				builder.handleDeletion(uri, monitor);
			}
			new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			return false;
		}
		
		if (resource instanceof IFile && resource.getName().endsWith("." + new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingMetaInformation().getSyntaxName())) {
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
