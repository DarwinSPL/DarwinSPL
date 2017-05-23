package eu.hyvar.feature.graphical.editor.actions.dimacsexport;

import java.util.List;

import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.RetargetAction;

import de.darwinspl.configurator.Configurator;
import de.darwinspl.exporter.dimacs.FeatureModelToDimacsExporter;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;
import eu.hyvar.feature.util.exporter.HyFeatureModelConsoleExporter;

public class HyFeatureModelToDimacsAction extends RetargetAction {
	public static final String ID = "eu.hyvar.feature.graphical.editor.actions.todimacs";
	
	/**
	 * Constructs a new HyFeatureModelToDimacsAction with the default ID, label and
	 * image.
	 */
	public HyFeatureModelToDimacsAction() {
		super(ID, "Export the current fm as a dimacs file");
		setToolTipText("Export the current fm as a dimacs file");
		ISharedImages sharedImages = PlatformUI.getWorkbench()
				.getSharedImages();
		setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_OBJ_FILE));
		setDisabledImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_OBJ_FILE));
		
		setEnabled(true);
	}
    
    @Override
	public void runWithEvent(Event event) {
        if(this.getActivePart() instanceof DwGraphicalFeatureModelViewer){
        	
        	DwGraphicalFeatureModelViewer editor = (DwGraphicalFeatureModelViewer)this.getActivePart();
        	HyFeatureModel featureModel = editor.getModelWrapped().getModel();
                	
        	FeatureModelToDimacsExporter exporter = new FeatureModelToDimacsExporter(featureModel, null);
        	exporter.export(editor.getFile().getProject().getLocation() + "/FeatureModel.dimacs");
        	
        	HyFeatureModelConsoleExporter exp = new HyFeatureModelConsoleExporter();
    		try {
    			System.out.println(exp.exportFeatureModel(featureModel, editor.getCurrentSelectedDate()));
    		} catch (HyFeatureModelWellFormednessException e) {
    			e.printStackTrace();
    		}
        	
        	
        	
        	
        	Configurator configurator = new Configurator(editor.getFile().getProject().getLocation() + "/FeatureModel.dimacs");
        	configurator.run();
        }
    }


}
