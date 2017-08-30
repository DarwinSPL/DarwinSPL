package de.darwinspl.feature.graphical.editor.commands.enumeration;

import java.util.Date;

import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;

public class DwFeatureAttributeEnumCreateLiteralCommand extends Command {
	private DwGraphicalFeatureModelViewer editor;
	private HyEnum featureEnum;
	private HyEnumLiteral literal;
	
	public DwFeatureAttributeEnumCreateLiteralCommand(HyEnum featureEnum, DwGraphicalFeatureModelViewer editor){
		this.editor = editor;
		this.featureEnum = featureEnum;
	}
	
	@Override
	public void execute(){
		redo();
	}
	
	@Override
	public boolean canExecute() {
		return editor.isLastDateSelected();
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
