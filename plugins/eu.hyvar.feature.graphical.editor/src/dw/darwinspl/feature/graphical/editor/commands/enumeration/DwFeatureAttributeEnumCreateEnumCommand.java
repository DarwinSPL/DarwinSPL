package dw.darwinspl.feature.graphical.editor.commands.enumeration;

import java.util.Date;

import org.eclipse.gef.commands.Command;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnum;

public class DwFeatureAttributeEnumCreateEnumCommand extends Command {
	private DwGraphicalFeatureModelViewer editor;
	private HyEnum featureEnum;
	
	public DwFeatureAttributeEnumCreateEnumCommand(DwGraphicalFeatureModelViewer editor){
		this.editor = editor;
	}
	
	@Override
	public void execute(){
		redo();
	}
	
	@Override
	public void undo() {	
		editor.getModelWrapped().getModel().getEnums().remove(featureEnum);
	}

	@Override
	public void redo() {
		Date date = editor.getCurrentSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE)))
			date = null;
		
		featureEnum = HyDataValuesFactory.eINSTANCE.createHyEnum();
		featureEnum.setValidSince(date);
		featureEnum.setName("New Feature Enum");
		
		editor.getModelWrapped().getModel().getEnums().add(featureEnum);
	}
}
