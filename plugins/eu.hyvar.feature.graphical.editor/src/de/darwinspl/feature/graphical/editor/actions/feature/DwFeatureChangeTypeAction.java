package de.darwinspl.feature.graphical.editor.actions.feature;

import java.util.Date;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.editor.commands.feature.DwFeatureChangeTypeCommand;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;

public class DwFeatureChangeTypeAction extends DwFeatureSelectionAction {
	public static final String FEATURE_CHANGE_TYPE = "ChangeFeatureType";
	public static final String REQ_FEATURE_CHANGE_TYPE = "ChangeFeatureType";
		
	public DwFeatureChangeTypeAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);
			
		setId(FEATURE_CHANGE_TYPE);
		setText("Change Type");
		request = new Request(REQ_FEATURE_CHANGE_TYPE);
	}
	
	@Override
	protected Command createCommand(Object acceptedModel) {
		DwFeatureWrapped selectedFeature = getSelectedFeature();		
		DwGraphicalFeatureModelViewer editor = (DwGraphicalFeatureModelViewer)this.getWorkbenchPart();
		Date date = editor.getCurrentSelectedDate();
		
		HyFeatureType type = HyEvolutionUtil.getValidTemporalElement(selectedFeature.getWrappedModelElement().getTypes(), date);
		HyFeatureTypeEnum newTypeEnum = type.getType() == HyFeatureTypeEnum.MANDATORY ? HyFeatureTypeEnum.OPTIONAL : HyFeatureTypeEnum.MANDATORY;
		DwFeatureChangeTypeCommand command = new DwFeatureChangeTypeCommand(selectedFeature.getWrappedModelElement(), newTypeEnum, editor);
		return command;
	}	
}
