package eu.hyvar.feature.graphical.editor.commands.attribute;

import java.util.Date;

import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.graphical.editor.commands.HyLinearTemporalElementCommand;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;

public class HyAttributeRenameCommand extends HyLinearTemporalElementCommand {
	private String oldName;
	private String newName;
	
	private HyFeatureAttribute attribute;
	private GraphicalEvolutionFeatureModelEditor editor;
	
	public HyAttributeRenameCommand(HyFeatureAttribute attribute, GraphicalEvolutionFeatureModelEditor editor){
		this.attribute = attribute;
		this.editor = editor;
	}
	
	@Override 
	public void execute(){
		Date date = editor.getCurrentSelectedDate();
		
		HyName name =  HyEvolutionUtil.getValidTemporalElement(attribute.getNames(), date);
		oldName = name.getName();
		
		HyName newName = HyEvolutionFactory.eINSTANCE.createHyName();
		newName.setName(this.newName);	
		
		changeVisibilities(name, newName, date);
		
		attribute.getNames().add(newName);
	}
	
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
}
