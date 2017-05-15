package de.darwinspl.feature.graphical.editor.actions.version;

import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwRootFeatureEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwRootFeatureWrapped;
import de.darwinspl.feature.graphical.editor.commands.version.DwVersionCreateCommand;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;

public class DwVersionCreateVersionAction extends SelectionAction{
	public static final String FEATURE_ADD_VERSION = "AddFeatureVersion";
	public static final String REQ_FEATURE_ADD_VERSION = "AddFeatureVersion";

	public static final String ID = "eu.hyvar.feature.graphical.editor.actions.hyversioncreateaction";

	private DwGraphicalFeatureModelViewer editor;
	
	@SuppressWarnings("unused")
	private Request request;
	
	public DwVersionCreateVersionAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);

		setId(FEATURE_ADD_VERSION);
		setText("Create Version");

		request = new Request(REQ_FEATURE_ADD_VERSION);
		
		this.editor = editor;
	}

	@Override
	protected boolean calculateEnabled() {
		for(Object o : getSelectedObjects()){
			if(!(o instanceof DwRootFeatureEditPart) && !(o instanceof DwFeatureEditPart))
				return false;
			else{
				if(o instanceof DwRootFeatureEditPart){
					DwRootFeatureWrapped rootFeature = (DwRootFeatureWrapped)((DwRootFeatureEditPart)o).getModel();
					if(HyEvolutionUtil.getValidTemporalElement(rootFeature.getWrappedModelElement().getVersions(), editor.getCurrentSelectedDate()) != null){
						return false;
					}
				}else if(o instanceof DwFeatureEditPart){
					DwFeatureWrapped feature = (DwFeatureWrapped)((DwFeatureEditPart)o).getModel();
					if(HyEvolutionUtil.getValidTemporalElement(feature.getWrappedModelElement().getVersions(), editor.getCurrentSelectedDate()) != null){
						return false;
					}			
				}
			}
		}
		
		
		return true;
	}	

	@Override
	public void run(){
		for(Object o : getSelectedObjects()){
			HyFeature feature = null;
			if(o instanceof DwRootFeatureEditPart){
				DwRootFeatureEditPart p = (DwRootFeatureEditPart)o;
				DwFeatureWrapped model = (DwFeatureWrapped)p.getModel();
				feature = model.getWrappedModelElement();

			}else if(o instanceof DwFeatureEditPart){
				DwFeatureEditPart p = (DwFeatureEditPart)o;
				DwFeatureWrapped model = (DwFeatureWrapped)p.getModel();
				feature = model.getWrappedModelElement();

			}
			
			DwVersionCreateCommand command = new DwVersionCreateCommand(feature, editor);
			editor.executeCommand(command);
		}
		
		editor.getModelWrapped().rearrangeFeatures();
		editor.refreshView();
	}
}
