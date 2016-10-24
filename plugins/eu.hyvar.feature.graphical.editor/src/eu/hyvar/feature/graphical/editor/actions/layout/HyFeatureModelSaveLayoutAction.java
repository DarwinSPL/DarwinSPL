package eu.hyvar.feature.graphical.editor.actions.layout;

import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.RetargetAction;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public class HyFeatureModelSaveLayoutAction extends RetargetAction {
	public static final String ID = "eu.hyvar.feature.graphical.editor.actions.savelayout";
	
	/**
	 * Constructs a new HyFeatureModelAutoLayoutAction with the default ID, label and
	 * image.
	 */
	public HyFeatureModelSaveLayoutAction(){
		super(ID, "Save layout of the feature model");
		setToolTipText("Save layout of the feature model");
		ISharedImages sharedImages = PlatformUI.getWorkbench()
				.getSharedImages();
		setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
		setDisabledImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD_DISABLED));
		
		setEnabled(true);
	}


    @Override
	public void runWithEvent(Event event) {
        if(this.getActivePart() instanceof GraphicalFeatureModelEditor){
        	//GraphicalEvolutionFeatureModelEditor editor = (GraphicalEvolutionFeatureModelEditor)this.getActivePart();
        }
    }

}
