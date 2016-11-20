package eu.hyvar.feature.graphical.editor.eclipse;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import eu.hyvar.feature.expression.extensionpoints.IFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;

public class ActiveFeatureModelEditorSolver implements IFeatureModelEditor, GraphicalFeatureModelEditorFoundListener {
	EObject editorObj;
	
	Run runner = null;
	
	public ActiveFeatureModelEditorSolver(){
		runner = new Run();
		runner.addListener(this);
	}
	

	private class Run implements Runnable{
		private List<GraphicalFeatureModelEditorFoundListener> listeners = new ArrayList<GraphicalFeatureModelEditorFoundListener>();
	    
		public void addListener(GraphicalFeatureModelEditorFoundListener toAdd) {
	        listeners.add(toAdd);
	    }
		@Override
        public void run() {
			
    		IWorkbench workbench = PlatformUI.getWorkbench();

    		IWorkbenchWindow workbenchWindow = workbench.getWorkbenchWindows()[0];
    		IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
    		for(IEditorReference reference : workbenchPage.getEditorReferences()){
    			IEditorPart editor = reference.getEditor(true);

    			
    			if(editor instanceof HyGraphicalFeatureModelViewer){
    				EObject obj = ((HyGraphicalFeatureModelViewer)editor).getInternalFeatureModel();
    				for(GraphicalFeatureModelEditorFoundListener l : listeners)
    					l.found(obj);
    			}
    		}
        }
		
	}
	@Override
	public EObject getInternalFeatureModel() {
		Display.getDefault().syncExec(runner);
		return editorObj;
	}

	@Override
	public void found(EObject object) {
		editorObj = object;
		
	}
}
