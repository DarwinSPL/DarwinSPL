package dw.darwinspl.feature.graphical.editor.actions.attribute;

import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import dw.darwinspl.feature.graphical.base.editparts.DwRootFeatureEditPart;
import dw.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import dw.darwinspl.feature.graphical.editor.commands.attribute.DwAttributeCreateCommand;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;

public abstract class DwAttributeCreateAction extends SelectionAction{
	public static final String FEATURE_ADD_ATTRIBUTE = "AddFeatureAttribute";
	public static final String REQ_FEATURE_ADD_ATTRIBUTE = "AddFeatureAttribute";
	
	protected String text = "Create Attribute";

	protected Request request;
	
	protected DwGraphicalFeatureModelViewer editor;
	
	public DwAttributeCreateAction(DwGraphicalFeatureModelViewer editor) {
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
			if(!(o instanceof DwRootFeatureEditPart) &&
			   !(o instanceof DwFeatureEditPart)){
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
			
			if(o instanceof DwRootFeatureEditPart){
				DwRootFeatureEditPart p = (DwRootFeatureEditPart)o;
				DwFeatureWrapped model = (DwFeatureWrapped)p.getModel();
				feature = model.getWrappedModelElement();
			}else if(o instanceof DwFeatureEditPart){
				DwFeatureEditPart p = (DwFeatureEditPart)o;
				DwFeatureWrapped model = (DwFeatureWrapped)p.getModel();
				feature = model.getWrappedModelElement();		
			}
			
			HyFeatureAttribute newAttribute = createNewAttribute();
			if(feature != null && newAttribute != null){
				DwAttributeCreateCommand command = new DwAttributeCreateCommand(feature, newAttribute, editor);
				this.editor.executeCommand(command);
			}
		}
		
		this.editor.getModelWrapped().rearrangeFeatures();
		this.editor.refreshView();
	}
}
