package eu.hyvar.feature.graphical.editor.actions.layout;

import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.RetargetAction;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public class HyFeatureModelAutoLayoutAction extends RetargetAction {
	public static final String ID = "eu.hyvar.feature.graphical.editor.actions.autolayout";
	
	/**
	 * Constructs a new HyFeatureModelAutoLayoutAction with the default ID, label and
	 * image.
	 */
	public HyFeatureModelAutoLayoutAction() {
		super(ID, "Automaticly layout the feature model");
		setToolTipText("Automaticly layout the feature model");
		ISharedImages sharedImages = PlatformUI.getWorkbench()
				.getSharedImages();
		setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
		setDisabledImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD_DISABLED));
		
		setEnabled(true);
	}

    @Override
	public void run() {
    }
    
    @Override
	public void runWithEvent(Event event) {
        if(this.getActivePart() instanceof GraphicalFeatureModelEditor){
        	
        	GraphicalFeatureModelEditor editor = (GraphicalFeatureModelEditor)this.getActivePart();
        	
        	boolean isAutoLayoutActive = editor.getModelWrapped().isAutoLayoutActive();
        	editor.getModelWrapped().setAutoLayoutActive(true);
        	editor.getModelWrapped().rearrangeFeatures();
        	editor.getModelWrapped().setAutoLayoutActive(isAutoLayoutActive);
        	editor.refreshView();
        }
    }

}
