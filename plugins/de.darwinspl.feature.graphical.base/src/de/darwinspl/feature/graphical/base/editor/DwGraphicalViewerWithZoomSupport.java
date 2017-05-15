package de.darwinspl.feature.graphical.base.editor;

import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.MouseWheelHandler;
import org.eclipse.gef.MouseWheelZoomHandler;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.swt.SWT;

/**
 * Abstract class that adds zoom support to a graphical editor using the graphical editing
 * framework (GEF). Zooming can be performed by pressing 'Ctrl' and '+' to zoom in, 'Ctrl' and '-' to zoom
 * out. Both zooming actions (in and out) can be also performed by using the mouse wheel.
 * 
 * @author Gil Engel
 *
 */
public abstract class DwGraphicalViewerWithZoomSupport extends GraphicalEditor{
	// handles additional shortcuts
	protected KeyHandler sharedKeyHandler;
	
	/**
	 * Adds zooming support with the keys ctrl & +/-.
	 * @return the keyhandler to handle the zomming shortcuts
	 */
	protected KeyHandler getCommonKeyHandler() {
		ZoomManager manager = (ZoomManager) getGraphicalViewer().getProperty(ZoomManager.class.toString());

		if (sharedKeyHandler == null) {
			sharedKeyHandler = new KeyHandler();
			sharedKeyHandler.put(KeyStroke.getPressed('+', SWT.KEYPAD_ADD, SWT.CONTROL),
					new ZoomInAction(manager));
			sharedKeyHandler.put(KeyStroke.getPressed('-', SWT.KEYPAD_SUBTRACT, SWT.CONTROL),
					new ZoomOutAction(manager));
		}

		return sharedKeyHandler;
	}
	
	/**
	 * Adds zoom support to the zoom manager via the mouse wheel. 
	 */
	protected void enableZoomWithMouseWheel() {
		// Zoom
		ZoomManager manager = (ZoomManager) getGraphicalViewer().getProperty(
				ZoomManager.class.toString());
		if (manager != null)
			manager.setZoom(1);


		// Scroll-wheel Zoom
		getGraphicalViewer().setProperty(
				MouseWheelHandler.KeyGenerator.getKey(SWT.MOD1),
				MouseWheelZoomHandler.SINGLETON);
	}
	
	@Override
	protected void initializeGraphicalViewer() {
		enableZoomWithMouseWheel();
	}
	
	/**
	 * Register the zoom in and zoom out action to the zoom manager of the current graphical editor.
	 */
	@Override
	public void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		ZoomManager manager = (ZoomManager) getGraphicalViewer().getProperty(ZoomManager.class.toString());

		getActionRegistry().registerAction(new ZoomInAction(manager));
		getActionRegistry().registerAction(new ZoomOutAction(manager));
	}	
	
	/**
	 * Returns the zoom manager for the current editor in case there is one.
	 */
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class type) {
		if(type == ZoomManager.class)
			return getGraphicalViewer().getProperty(ZoomManager.class.toString());
		else
			return super.getAdapter(type);

	}	
}
