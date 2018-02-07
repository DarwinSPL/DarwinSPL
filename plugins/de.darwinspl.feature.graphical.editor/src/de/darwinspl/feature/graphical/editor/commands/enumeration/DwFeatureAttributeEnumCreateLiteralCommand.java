package de.darwinspl.feature.graphical.editor.commands.enumeration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		
		if(date.equals(new Date(Long.MIN_VALUE))) {
			date = null;			
		}
		
		literal = HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
		literal.setName("New Literal");
		literal.setValidSince(date);
		
		List<Integer> literalValues = new ArrayList<Integer>();
		
		for(HyEnumLiteral literal : featureEnum.getLiterals()) {
			literalValues.add(literal.getValue());
		}
		 
		int value=0;
		while(literalValues.contains(value)) {
			value++;
		}
		
		literal.setValue(value);
		
		featureEnum.getLiterals().add(literal);		
		editor.refreshView();
	}
}
