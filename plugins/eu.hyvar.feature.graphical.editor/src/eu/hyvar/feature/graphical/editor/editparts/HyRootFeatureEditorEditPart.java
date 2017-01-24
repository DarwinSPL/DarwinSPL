package eu.hyvar.feature.graphical.editor.editparts;

import java.beans.PropertyChangeEvent;
import java.util.Date;

import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.jface.viewers.TextCellEditor;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyRootFeatureEditPart;
import eu.hyvar.feature.graphical.base.figures.HyFeatureFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.locators.HyFeatureCellEditorLocator;
import eu.hyvar.feature.graphical.editor.managers.HyFeatureDirectEditManager;
import eu.hyvar.feature.graphical.editor.policies.feature.HyFeatureComponentEditPolicy;
import eu.hyvar.feature.graphical.editor.policies.feature.HyFeatureDirectEditPolicy;
import eu.hyvar.feature.graphical.editor.policies.feature.HyFeatureGraphicalNodeEditPolicy;
import eu.hyvar.feature.graphical.editor.policies.feature.HyFeatureXYLayoutPolicy;

public class HyRootFeatureEditorEditPart extends HyRootFeatureEditPart{

	public HyRootFeatureEditorEditPart(HyGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected void createEditPolicies(){
		super.createEditPolicies();

		installEditPolicy(EditPolicy.COMPONENT_ROLE, new HyFeatureComponentEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new HyFeatureGraphicalNodeEditPolicy(editor, featureModel));
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new HyFeatureDirectEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new HyFeatureXYLayoutPolicy());		
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.refreshVisuals();
	}
	
	/**
	 * This method is used to enable direct name editing in the feature
	 */
	@Override public void performRequest(Request req) {
		if(req.getType() == RequestConstants.REQ_DIRECT_EDIT) {
			
		}
		if(req.getType() == RequestConstants.REQ_OPEN){
			HyFeatureWrapped feature = (HyFeatureWrapped)getModel();
			Date date = editor.getCurrentSelectedDate();
			
			if(feature.calculateVariationTypeCircleBounds(date).contains(((SelectionRequest)req).getLocation())){

				HyFeatureType type = HyEvolutionUtil.getValidTemporalElement(feature.getWrappedModelElement().getTypes(), date);
				type.setValidUntil(date);
				
				HyFeatureType newType = HyFeatureFactory.eINSTANCE.createHyFeatureType();
				newType.setValidSince(date);
				
				
				if(type.getType() == HyFeatureTypeEnum.MANDATORY){
					newType.setType(HyFeatureTypeEnum.OPTIONAL);
				}else{
					newType.setType(HyFeatureTypeEnum.MANDATORY);
				}
				
				feature.getWrappedModelElement().getTypes().add(newType);
				
				this.refreshVisuals();
			}else{
				performDirectEditing();
			}
		}
	}

	private void performDirectEditing() {		
		Label label = ((HyFeatureFigure)getFigure()).getLabel();
		HyFeatureDirectEditManager manager = new HyFeatureDirectEditManager(this, TextCellEditor.class, new HyFeatureCellEditorLocator(label), label);
		manager.show();
	}   
}
