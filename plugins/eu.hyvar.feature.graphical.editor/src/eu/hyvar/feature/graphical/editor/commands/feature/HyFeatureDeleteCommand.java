package eu.hyvar.feature.graphical.editor.commands.feature;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;

import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyRootFeatureEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;
import eu.hyvar.feature.graphical.editor.editor.HyGraphicalFeatureModelEditor;

public class HyFeatureDeleteCommand extends FeatureConnectionChangeCommand{
	EditPart host;

	public HyFeatureDeleteCommand(HyGraphicalFeatureModelEditor editor, EditPart host) {
		super(editor);

		this.host = host;
	}

	private HyFeatureWrapped feature;
	private HyFeatureWrapped oldParent;
	private HyFeature oldFeature;

	public void setFeature(HyFeatureWrapped feature) {
		this.feature = feature;
	}

	public void setModel(HyFeatureModelWrapped model) {
		this.featureModel = model;
	}

	private void restrictHyLinearTemporalElementsToParentValidUntil(EList<HyTemporalElement> elements){
		Date date = editor.getCurrentSelectedDate();
		for(HyTemporalElement element : elements){
			if(element.getValidUntil() == null || element.getValidUntil().after(date)){
				element.setValidUntil(date);
			}
		}			
	}

	@Override
	public boolean canExecute() {
		if(host instanceof HyRootFeatureEditPart)
			return false;
		if(host instanceof HyFeatureEditPart)
			return true;
		
		return false;
	}


	@SuppressWarnings("unchecked")
	public void redo(){
		
		HyFeature feature = this.feature.getWrappedModelElement();
		Date date = editor.getCurrentSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE)))
			date = null;
		//HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(feature.getGroupMembership(), date);
		//splitComposition(composition, this.feature);

		oldFeature = EcoreUtil.copy(feature);
		feature.setValidUntil(date);

		restrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)feature.getNames());
		restrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)feature.getAttributes());
		restrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)feature.getVersions());

		//oldGroup = this.feature.getParentGroup(date);
		oldParent = this.feature.getParentFeature(date);
		this.feature.getParentGroup(date).removeChildFeature(this.feature, date);
		//deleteFeatureChildrenTemporarily(feature);

		// delete the selection from the element
		host.setSelected(0);

		editor.getModelWrapped().rearrangeFeatures();
		editor.refreshView();		
	}
	
	public void undo(){
		Date date = featureModel.getSelectedDate();
		HyParentChildConnection connection = new HyParentChildConnection();
		
		this.feature.setWrappedModelElement(oldFeature);
		HyFeatureModelWrapped featureModel = editor.getModelWrapped();
		date = editor.getCurrentSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE))){
			date = null;
		}		
		
		

		
		connection = new HyParentChildConnection();
		connection.setSource(oldParent);
		connection.setTarget(this.feature);
		connection.setModel(featureModel);
		
		featureModel.addConnection(connection, featureModel.getSelectedDate(), null);
		
		featureModel.rearrangeFeatures();
		editor.refreshView();	
	}
	
	@Override
	public void execute(){
		redo();
	}
}
