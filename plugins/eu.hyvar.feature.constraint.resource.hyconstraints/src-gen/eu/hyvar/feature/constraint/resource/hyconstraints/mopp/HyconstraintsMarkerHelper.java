/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreValidator;

/**
 * Helper class to add markers to text files based on EMF's
 * <code>ResourceDiagnostic</code>. If a resource contains
 * <code>eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextDiagn
 * ostic</code>s it uses the more precise information of this extended diagnostic
 * type.
 */
public class HyconstraintsMarkerHelper {
	
	/**
	 * The extension id of the custom marker type that is used by this text resource.
	 */
	public static final String MARKER_TYPE = eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsPlugin.PLUGIN_ID + ".problem";
	
	/**
	 * The total number of markers per file is restricted with this constant.
	 * Restriction is needed because the performance of Eclipse decreases drastically
	 * if large amounts of markers are added to files.
	 */
	public static int MAXIMUM_MARKERS = 500;
	
	/**
	 * We use a queue to aggregate commands that create or remove markers. This is
	 * basically for performance reasons. Without the queue we would need to create a
	 * job for each marker creation/removal, which creates tons of threads and takes
	 * very long time.
	 */
	private final static MarkerCommandQueue COMMAND_QUEUE = new MarkerCommandQueue();
	
	public static class MutexRule implements ISchedulingRule {
		
		public boolean isConflicting(ISchedulingRule rule) {
			return rule == this;
		}
		
		public boolean contains(ISchedulingRule rule) {
			return rule == this;
		}
	}
	
	private static class MarkerCommandQueue {
		
		private List<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<Object>> commands = new ArrayList<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<Object>>();
		
		private MutexRule schedulingRule = new MutexRule();
		
		public void addCommand(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<Object> command) {
			synchronized(commands) {
				commands.add(command);
				// we only need to schedule a job, if the queue was empty
				if (commands.size() == 1) {
					scheduleRunCommandsJob();
				}
			}
		}
		
		private void scheduleRunCommandsJob() {
			Job job = new Job(eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsResourceBundle.UPDATING_MARKERS_JOB_NAME) {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					runCommands();
					return Status.OK_STATUS;
				}
			};
			job.setRule(schedulingRule);
			job.schedule();
		}
		
		public void runCommands() {
			List<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<Object>> commandsToProcess = new ArrayList<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<Object>>();
			synchronized(commands) {
				commandsToProcess.addAll(commands);
				commands.clear();
			}
			for (eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<Object> command : commandsToProcess) {
				command.execute(null);
			}
		}
		
	}
	
	/**
	 * <p>
	 * Creates a marker from the given diagnostics object and attaches the marker to
	 * the resource. Markers are created and removed asynchronously. Thus, they may
	 * not appear when calls to this method return. But, the order of marker additions
	 * and removals is preserved.
	 * </p>
	 * 
	 * @param resource The resource that is the file to mark.
	 * @param diagnostic The diagnostic with information for the marker.
	 */
	public void mark(Resource resource, eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextDiagnostic diagnostic) {
		final IFile file = getFile(resource);
		if (file == null) {
			return;
		}
		createMarkerFromDiagnostic(file, diagnostic);
	}
	
	protected void createMarkerFromDiagnostic(final IFile file, final eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextDiagnostic diagnostic) {
		final eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsProblem problem = diagnostic.getProblem();
		eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType problemType = problem.getType();
		final String markerID = getMarkerID(problemType);
		COMMAND_QUEUE.addCommand(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<Object>() {
			public boolean execute(Object context) {
				try {
					// if there are too many markers, we do not add new ones
					if (file.findMarkers(markerID, false, IResource.DEPTH_ZERO).length >= MAXIMUM_MARKERS) {
						return true;
					}
					
					IMarker marker = file.createMarker(markerID);
					if (problem.getSeverity() == eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemSeverity.ERROR) {
						marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
					} else {
						marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
					}
					marker.setAttribute(IMarker.MESSAGE, diagnostic.getMessage());
					eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextDiagnostic textDiagnostic = (eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextDiagnostic) diagnostic;
					marker.setAttribute(IMarker.LINE_NUMBER, textDiagnostic.getLine());
					marker.setAttribute(IMarker.CHAR_START, textDiagnostic.getCharStart());
					marker.setAttribute(IMarker.CHAR_END, textDiagnostic.getCharEnd() + 1);
					if (diagnostic instanceof eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsResource.ElementBasedTextDiagnostic) {
						EObject element = ((eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsResource.ElementBasedTextDiagnostic) diagnostic).getElement();
						String elementURI = getObjectURI(element);
						if (elementURI != null) {
							marker.setAttribute(EcoreValidator.URI_ATTRIBUTE, elementURI);
						}
					}
					Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsQuickFix> quickFixes = textDiagnostic.getProblem().getQuickFixes();
					Collection<Object> sourceIDs = new ArrayList<Object>();
					if (quickFixes != null) {
						for (eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsQuickFix quickFix : quickFixes) {
							if (quickFix != null) {
								sourceIDs.add(quickFix.getContextAsString());
							}
						}
					}
					if (!sourceIDs.isEmpty()) {
						marker.setAttribute(IMarker.SOURCE_ID, eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsStringUtil.explode(sourceIDs, "|"));
					}
				} catch (CoreException ce) {
					handleException(ce);
				}
				return true;
			}
		});
	}
	
	/**
	 * <p>
	 * Removes all markers from the given resource regardless of their type. Markers
	 * are created and removed asynchronously. Thus, they may not appear when calls to
	 * this method return. But, the order of marker additions and removals is
	 * preserved.
	 * </p>
	 * 
	 * @param resource The resource where to delete markers from
	 */
	public void unmark(Resource resource) {
		for (eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType nextType : eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType.values()) {
			unmark(resource, nextType);
		}
	}
	
	/**
	 * <p>
	 * Removes all markers of the given type from the given resource. Markers are
	 * created and removed asynchronously. Thus, they may not appear when calls to
	 * this method return. But, the order of marker additions and removals is
	 * preserved.
	 * </p>
	 * 
	 * @param resource The resource where to delete markers from
	 * @param problemType The type of problem to remove
	 */
	public void unmark(Resource resource, eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType problemType) {
		final IFile file = getFile(resource);
		if (file == null) {
			return;
		}
		final String markerType = getMarkerID(problemType);
		COMMAND_QUEUE.addCommand(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<Object>() {
			public boolean execute(Object context) {
				try {
					file.deleteMarkers(markerType, false, IResource.DEPTH_ZERO);
				} catch (CoreException ce) {
					handleException(ce);
				}
				return true;
			}
		});
	}
	
	/**
	 * <p>
	 * Removes all markers that were caused by the given object from the resource.
	 * Markers are created and removed asynchronously. Thus, they may not appear when
	 * calls to this method return. But, the order of marker additions and removals is
	 * preserved.
	 * </p>
	 * 
	 * @param resource The resource where to delete markers from
	 * @param causingObject The cause of the problems to remove
	 */
	public void unmark(Resource resource, final EObject causingObject) {
		final IFile file = getFile(resource);
		if (file == null) {
			return;
		}
		final String markerID = getMarkerID(eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType.UNKNOWN);
		final String causingObjectURI = getObjectURI(causingObject);
		if (causingObjectURI == null) {
			return;
		}
		COMMAND_QUEUE.addCommand(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<Object>() {
			public boolean execute(Object context) {
				try {
					IMarker[] markers = file.findMarkers(markerID, true, IResource.DEPTH_ZERO);
					for (IMarker marker : markers) {
						if (causingObjectURI.equals(marker.getAttribute(EcoreValidator.URI_ATTRIBUTE))) {
							marker.delete();
						}
					}
				} catch (CoreException ce) {
					handleException(ce);
				}
				return true;
			}
		});
	}
	
	/**
	 * Returns the ID of the marker type that is used to indicate problems of the
	 * given type.
	 */
	public String getMarkerID(eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType problemType) {
		String markerID = MARKER_TYPE;
		String typeID = problemType.getID();
		if (!"".equals(typeID)) {
			markerID += "." + typeID;
		}
		return markerID;
	}
	
	/**
	 * Tries to determine the file for the given resource. If the platform is not
	 * running, the resource is not a platform resource, or the resource cannot be
	 * found in the workspace, this method returns <code>null</code>.
	 */
	protected IFile getFile(Resource resource) {
		if (resource == null || !Platform.isRunning()) {
			return null;
		}
		String platformString = resource.getURI().toPlatformString(true);
		if (platformString == null) {
			return null;
		}
		IFile file = (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
		return file;
	}
	
	/**
	 * Returns an URI that identifies the given object.
	 */
	protected String getObjectURI(EObject object) {
		if (object == null) {
			return null;
		}
		if (object.eIsProxy() && object instanceof BasicEObjectImpl) {
			return ((BasicEObjectImpl) object).eProxyURI().toString();
		}
		Resource eResource = object.eResource();
		if (eResource == null) {
			return null;
		}
		return eResource.getURI().toString() + "#" + eResource.getURIFragment(object);
	}
	
	protected void handleException(CoreException ce) {
		if (ce.getMessage().matches("Marker.*not found.")) {
			// ignore
		}else if (ce.getMessage().matches("Resource.*does not exist.")) {
			// ignore
		} else {
			new eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsRuntimeUtil().logError("Error while removing markers from resource:", ce);
		}
	}
	
	/**
	 * <p>
	 * Removes all markers of the given type from the given resource. Markers are
	 * created and removed asynchronously. Thus, they may not appear when calls to
	 * this method return. But, the order of marker additions and removals is
	 * preserved.
	 * </p>
	 * 
	 * @param resource The resource where to delete markers from
	 * @param markerId The id of the marker type to remove
	 */
	public void removeAllMarkers(final IResource resource, final String markerId) {
		if (resource == null) {
			return;
		}
		COMMAND_QUEUE.addCommand(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<Object>() {
			public boolean execute(Object context) {
				try {
					resource.deleteMarkers(markerId, false, IResource.DEPTH_ZERO);
				} catch (CoreException ce) {
					handleException(ce);
				}
				return true;
			}
		});
	}
	
	public void createMarker(final IResource resource, final String markerId, final Map<String, Object> markerAttributes) {
		if (resource == null) {
			return;
		}
		
		COMMAND_QUEUE.addCommand(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<Object>() {
			public boolean execute(Object context) {
				try {
					IMarker marker = resource.createMarker(markerId);
					for (String key : markerAttributes.keySet()) {
						marker.setAttribute(key, markerAttributes.get(key));
					}
					return true;
				} catch (CoreException e) {
					eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsPlugin.logError("Can't create marker.", e);
					return false;
				}
			}
		});
	}
	
	public void beginDeferMarkerUpdates() {
	}
	
	public void endDeferMarkerUpdates() {
	}
	
	public void runCommands() {
		COMMAND_QUEUE.runCommands();
	}
	
}
