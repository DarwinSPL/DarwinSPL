package de.darwinspl.feature.graphical.editor.actions.layout;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.RetargetAction;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public class DwFeatureModelAutoLayoutAction extends RetargetAction {
	public static final String ID = "eu.hyvar.feature.graphical.editor.actions.autolayout";
	
	/**
	 * Constructs a new HyFeatureModelAutoLayoutAction with the default ID, label and
	 * image.
	 */
	public DwFeatureModelAutoLayoutAction() {
		super(ID, "Automaticly layout the feature model");
		setToolTipText("Automaticly layout the feature model");
		ISharedImages sharedImages = PlatformUI.getWorkbench()
				.getSharedImages();			
		
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		URL url = FileLocator.find(bundle,
		    new Path("icons/icon_auto_layout.png"), null);
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);
		
		setImageDescriptor(imageDescriptor);
		setDisabledImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD_DISABLED));
		
		setEnabled(true);
	}
    
    @Override
	public void runWithEvent(Event event) {
        if(this.getActivePart() instanceof DwGraphicalFeatureModelViewer){
        	
        	DwGraphicalFeatureModelViewer editor = (DwGraphicalFeatureModelViewer)this.getActivePart();
        	
        	editor.getModelWrapped().setAutoLayoutActive(true);
        	editor.getModelWrapped().rearrangeFeatures();
        	editor.refreshView();
        }
    }

}
