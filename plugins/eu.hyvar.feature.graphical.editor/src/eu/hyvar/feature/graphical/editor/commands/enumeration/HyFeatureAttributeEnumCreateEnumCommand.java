package eu.hyvar.feature.graphical.editor.commands.enumeration;

import java.util.Date;

import org.eclipse.gef.commands.Command;

import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public class HyFeatureAttributeEnumCreateEnumCommand extends Command {
	private GraphicalFeatureModelEditor editor;
	private HyEnum featureEnum;
	
	public HyFeatureAttributeEnumCreateEnumCommand(GraphicalFeatureModelEditor editor){
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
		
		featureEnum = HyDataValuesFactory.eINSTANCE.createHyEnum();
		featureEnum.setValidSince(date);
		featureEnum.setName("New Feature Enum");
		
		editor.getModelWrapped().getModel().getEnums().add(featureEnum);
	}
}
