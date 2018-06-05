package de.darwinspl.feature.graphical.editor.actions.feature;

import java.util.Date;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.editor.commands.feature.DwFeatureChangeTypeCommand;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

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
	
	@Override
	protected boolean calculateEnabled() {
		boolean executable = true;
		
		if(!editor.isLastDateSelected()) {
			return false;
		} else {
			DwFeatureWrapped selectedFeature = getSelectedFeature();
			if(selectedFeature == null) {
				return false;
			}
			else if(selectedFeature.getWrappedModelElement() == null) {
				return false;
			}
			else if(selectedFeature.getWrappedModelElement().getGroupMembership() == null || selectedFeature.getWrappedModelElement().getGroupMembership().isEmpty()) {
				return false;
			}
			
			Date date = editor.getCurrentSelectedDate();
			HyGroupComposition groupComposition = HyEvolutionUtil.getValidTemporalElement(selectedFeature.getWrappedModelElement().getGroupMembership(), date);
			
			if(groupComposition != null) {
				HyGroupType groupType = HyFeatureEvolutionUtil.getType(groupComposition.getCompositionOf(), date);
				if(groupType != null) {
					
					HyFeatureType type = HyEvolutionUtil.getValidTemporalElement(selectedFeature.getWrappedModelElement().getTypes(), date);
					HyFeatureTypeEnum newFeatureTypeEnum = type.getType() == HyFeatureTypeEnum.MANDATORY ? HyFeatureTypeEnum.OPTIONAL : HyFeatureTypeEnum.MANDATORY;
					
					switch(groupType.getType()) {
					case ALTERNATIVE:
						if(newFeatureTypeEnum.equals(HyFeatureTypeEnum.MANDATORY)) {
							executable = false;
						}
						break;
					case AND:
						executable = true;
						break;
					case OR:
						if(newFeatureTypeEnum.equals(HyFeatureTypeEnum.MANDATORY)) {
							executable = false;
						}
						break;
					}
				}
			}
		}
		
		
		
		return executable;
	}
}
