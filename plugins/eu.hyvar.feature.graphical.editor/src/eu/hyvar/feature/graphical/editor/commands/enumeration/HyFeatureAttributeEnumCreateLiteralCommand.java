package eu.hyvar.feature.graphical.editor.commands.enumeration;

import java.util.Date;

import org.eclipse.gef.commands.Command;

import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public class HyFeatureAttributeEnumCreateLiteralCommand extends Command {
	private GraphicalFeatureModelEditor editor;
	private HyEnum featureEnum;
	private HyEnumLiteral literal;
	
	public HyFeatureAttributeEnumCreateLiteralCommand(HyEnum featureEnum, GraphicalFeatureModelEditor editor){
		this.editor = editor;
		this.featureEnum = featureEnum;
	}
	
	@Override
	public void execute(){
		redo();
	}
	
	@Override
	public void undo() {	
		featureEnum.getLiterals().remove(literal);
	}

	@Override
	public void redo() {
		Date date = editor.getCurrentSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE)))
			date = null;
		
		literal = HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
		literal.setName("New Literal");
		literal.setValidSince(date);
		
		featureEnum.getLiterals().add(literal);		
		
		editor.refreshView();
	}
}
