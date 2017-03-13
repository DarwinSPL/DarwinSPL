package eu.hyvar.feature.graphical.editor.actions.attribute;

import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyRootFeatureEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.commands.attribute.HyAttributeCreateCommand;

public abstract class HyAttributeCreateAction extends SelectionAction{
	public static final String FEATURE_ADD_ATTRIBUTE = "AddFeatureAttribute";
	public static final String REQ_FEATURE_ADD_ATTRIBUTE = "AddFeatureAttribute";
	
	protected String text = "Create Attribute";

	protected Request request;
	
	protected DwGraphicalFeatureModelViewer editor;
	
	public HyAttributeCreateAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);
		
		setId(FEATURE_ADD_ATTRIBUTE);
		setText(text);

		request = new Request(REQ_FEATURE_ADD_ATTRIBUTE);
		
		this.editor = editor;
	}
	
	@Override
	protected boolean calculateEnabled() {
		boolean result = true;
		
		for(Object o : getSelectedObjects()){
			if(!(o instanceof HyRootFeatureEditPart) &&
			   !(o instanceof HyFeatureEditPart)){
				return false;
			}
		}
		
		return result;
	}	
	
	protected abstract HyFeatureAttribute createNewAttribute();
	
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
			
			HyFeatureAttribute newAttribute = createNewAttribute();
			if(feature != null && newAttribute != null){
				HyAttributeCreateCommand command = new HyAttributeCreateCommand(feature, newAttribute, editor);
				this.editor.executeCommand(command);
			}
		}
		
		this.editor.getModelWrapped().rearrangeFeatures();
		this.editor.refreshView();
	}
}
