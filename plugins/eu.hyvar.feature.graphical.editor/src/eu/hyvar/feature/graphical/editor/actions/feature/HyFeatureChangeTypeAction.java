package eu.hyvar.feature.graphical.editor.actions.feature;

import java.util.Date;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.commands.feature.HyFeatureChangeTypeCommand;

public class HyFeatureChangeTypeAction extends HyFeatureSelectionAction {
	public static final String FEATURE_CHANGE_TYPE = "ChangeFeatureType";
	public static final String REQ_FEATURE_CHANGE_TYPE = "ChangeFeatureType";
		
	public HyFeatureChangeTypeAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);
			
		setId(FEATURE_CHANGE_TYPE);
		setText("Change Type");
		request = new Request(REQ_FEATURE_CHANGE_TYPE);
	}
	
	@Override
	protected Command createCommand(Object acceptedModel) {
		HyFeatureWrapped selectedFeature = getSelectedFeature();		
		DwGraphicalFeatureModelViewer editor = (DwGraphicalFeatureModelViewer)this.getWorkbenchPart();
		Date date = editor.getCurrentSelectedDate();
		
		HyFeatureType type = HyEvolutionUtil.getValidTemporalElement(selectedFeature.getWrappedModelElement().getTypes(), date);
		HyFeatureTypeEnum newTypeEnum = type.getType() == HyFeatureTypeEnum.MANDATORY ? HyFeatureTypeEnum.OPTIONAL : HyFeatureTypeEnum.MANDATORY;
		HyFeatureChangeTypeCommand command = new HyFeatureChangeTypeCommand(selectedFeature.getWrappedModelElement(), newTypeEnum, editor);
		return command;
	}	
}
