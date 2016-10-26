package eu.hyvar.feature.graphical.editor.actions.version;

import java.util.Date;

import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyRootFeatureEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyRootFeatureWrapped;

public class HyVersionCreateVersionAction extends SelectionAction{
	public static final String FEATURE_ADD_VERSION = "AddFeatureVersion";
	public static final String REQ_FEATURE_ADD_VERSION = "AddFeatureVersion";

	public static final String ID = "eu.hyvar.feature.graphical.editor.actions.hyversioncreateaction";

	private GraphicalFeatureModelEditor editor;
	
	@SuppressWarnings("unused")
	private Request request;
	
	public HyVersionCreateVersionAction(GraphicalFeatureModelEditor editor) {
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
		Date date = editor.getCurrentSelectedDate();
		for(Object o : getSelectedObjects()){
			if(o instanceof HyRootFeatureEditPart){
				HyRootFeatureEditPart p = (HyRootFeatureEditPart)o;
				HyFeatureWrapped model = (HyFeatureWrapped)p.getModel();
				HyFeature feature = model.getWrappedModelElement();

				HyVersion version = HyFeatureFactory.eINSTANCE.createHyVersion();
				version.setNumber("V"+ (feature.getVersions().size()));
				version.setFeature(feature);
				version.setValidSince(date);
				feature.getVersions().add(version);
			}else if(o instanceof HyFeatureEditPart){
				HyFeatureEditPart p = (HyFeatureEditPart)o;
				HyFeatureWrapped model = (HyFeatureWrapped)p.getModel();
				HyFeature feature = model.getWrappedModelElement();

				HyVersion version = HyFeatureFactory.eINSTANCE.createHyVersion();
				version.setNumber("V"+ (feature.getVersions().size()));
				version.setFeature(feature);
				version.setValidSince(date);
				feature.getVersions().add(version);		
			}
		}
		
		editor.getModelWrapped().rearrangeFeatures();
		editor.refreshView();
	}
}
