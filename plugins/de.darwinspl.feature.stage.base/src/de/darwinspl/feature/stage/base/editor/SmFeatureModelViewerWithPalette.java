package de.darwinspl.feature.stage.base.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.MouseWheelHandler;
import org.eclipse.gef.MouseWheelZoomHandler;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.swt.SWT;


/**
 * FM viewer with Palette Based on DwGraphicalViewerWithZoomSupport by Gil Engel
 * @author Alexander Manegold
 *
 */
public abstract class SmFeatureModelViewerWithPalette extends GraphicalEditorWithFlyoutPalette{
	
	
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
	  protected PaletteRoot getPaletteRoot() {
	    // TODO Auto-generated method stub
	    return null;
	  }
	 
	  @Override
	  public void doSave(IProgressMonitor monitor) {
	    // TODO Auto-generated method stub
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
