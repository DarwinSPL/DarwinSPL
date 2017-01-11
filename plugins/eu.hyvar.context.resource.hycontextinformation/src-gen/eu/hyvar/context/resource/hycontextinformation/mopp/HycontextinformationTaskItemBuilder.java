/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * The HycontextinformationTaskItemBuilder is used to find task items in text
 * documents. The current implementation uses the generated lexer and the
 * TaskItemDetector to detect task items. This class is called by the
 * BuilderAdapter, which runs both this builder and the default builder that is
 * intended to be customized.
 */
public class HycontextinformationTaskItemBuilder {
	
	public void build(IFile resource, ResourceSet resourceSet, IProgressMonitor monitor) {
		// We use one tick from the parent monitor because the BuilderAdapter reserves one
		// tick for finding task items.
		SubProgressMonitor subMonitor = new SubProgressMonitor(monitor, 1);
		// We define the overall work to be 3 ticks (removing markers, scanning the
		// resource, creating new markers).
		subMonitor.beginTask("Searching for task items in " + new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationMetaInformation().getSyntaxName() + " files", 3);
		new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationMarkerHelper().removeAllMarkers(resource, IMarker.TASK);
		subMonitor.worked(1);
		if (isInBinFolder(resource)) {
			subMonitor.done();
			return;
		}
		List<eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTaskItem> taskItems = new ArrayList<eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTaskItem>();
		eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTaskItemDetector taskItemDetector = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTaskItemDetector();
		InputStream inputStream = null;
		try {
			inputStream = resource.getContents();
			String charset = resource.getCharset();
			String content = eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationStreamUtil.getContent(inputStream, charset);
			eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextScanner lexer = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationMetaInformation().createLexer();
			lexer.setText(content);
			
			eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (IOException e) {
			eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationPlugin.logError("Exception while searching for task items", e);
		} catch (CoreException e) {
			eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationPlugin.logError("Exception while searching for task items", e);
		}
		
		try {
			if (inputStream != null) {
				inputStream.close();
			}
		} catch (IOException e) {
			// Ignore this
		}
		subMonitor.worked(1);
		
		for (eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTaskItem taskItem : taskItems) {
			Map<String, Object> markerAttributes = new LinkedHashMap<String, Object>();
			markerAttributes.put(IMarker.USER_EDITABLE, false);
			markerAttributes.put(IMarker.DONE, false);
			markerAttributes.put(IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(IMarker.MESSAGE, taskItem.getMessage());
			new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationMarkerHelper().createMarker(resource, IMarker.TASK, markerAttributes);
		}
		subMonitor.worked(1);
		subMonitor.done();
	}
	
	public String getBuilderMarkerId() {
		return IMarker.TASK;
	}
	
	public boolean isInBinFolder(IFile resource) {
		IContainer parent = resource.getParent();
		while (parent != null) {
			if ("bin".equals(parent.getName())) {
				return true;
			}
			parent = parent.getParent();
		}
		return false;
	}
	
}
