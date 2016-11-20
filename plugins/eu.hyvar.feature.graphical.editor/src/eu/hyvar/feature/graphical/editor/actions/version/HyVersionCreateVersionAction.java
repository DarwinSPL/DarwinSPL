package eu.hyvar.feature.graphical.editor.actions.version;

import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyRootFeatureEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyRootFeatureWrapped;
import eu.hyvar.feature.graphical.editor.commands.version.HyVersionCreateCommand;

public class HyVersionCreateVersionAction extends SelectionAction{
	public static final String FEATURE_ADD_VERSION = "AddFeatureVersion";
	public static final String REQ_FEATURE_ADD_VERSION = "AddFeatureVersion";

	public static final String ID = "eu.hyvar.feature.graphical.editor.actions.hyversioncreateaction";

	private HyGraphicalFeatureModelViewer editor;
	
	@SuppressWarnings("unused")
	private Request request;
	
	public HyVersionCreateVersionAction(HyGraphicalFeatureModelViewer editor) {
		super(editor);

		setId(FEATURE_ADD_VERSION);
		setText("Create Version");

		request = new Request(REQ_FEATURE_ADD_VERSION);
		
		this.editor = editor;
	}

	@Override
	protected boolean calculateEnabled() {
		for(Object o : getSelectedObjects()){
			if(!(o instanceof HyRootFeatureEditPart) && !(o instanceof HyFeatureEditPart))
				return false;
			else{
				if(o instanceof HyRootFeatureEditPart){
					HyRootFeatureWrapped rootFeature = (HyRootFeatureWrapped)((HyRootFeatureEditPart)o).getModel();
					if(HyEvolutionUtil.getValidTemporalElement(rootFeature.getWrappedModelElement().getVersions(), editor.getCurrentSelectedDate()) != null){
						return false;
					}
				}else if(o instanceof HyFeatureEditPart){
					HyFeatureWrapped feature = (HyFeatureWrapped)((HyFeatureEditPart)o).getModel();
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
			if(o instanceof HyRootFeatureEditPart){
				HyRootFeatureEditPart p = (HyRootFeatureEditPart)o;
				HyFeatureWrapped model = (HyFeatureWrapped)p.getModel();
				feature = model.getWrappedModelElement();

			}else if(o instanceof HyFeatureEditPart){
				HyFeatureEditPart p = (HyFeatureEditPart)o;
				HyFeatureWrapped model = (HyFeatureWrapped)p.getModel();
				feature = model.getWrappedModelElement();

			}
			
			HyVersionCreateCommand command = new HyVersionCreateCommand(feature, editor);
			editor.executeCommand(command);
		}
		
		editor.getModelWrapped().rearrangeFeatures();
		editor.refreshView();
	}
}
