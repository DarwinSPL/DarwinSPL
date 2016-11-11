package eu.hyvar.feature.graphical.editor.commands;


import java.util.Date;

import org.eclipse.gef.commands.Command;

import eu.hyvar.evolution.HyLinearTemporalElement;

public class HyLinearTemporalElementCommand extends Command{
	
	protected HyLinearTemporalElement getLastHyLinearTemporalElement(HyLinearTemporalElement root){
		while(root.getSupersedingElement() != null){
			root = root.getSupersedingElement();
		}
		
		return root;		
	}
	
	protected void changeVisibilities(HyLinearTemporalElement previousElement, HyLinearTemporalElement newElement, Date date){
		previousElement.setValidUntil(date);
		newElement.setValidSince(date);
		
		
		
		HyLinearTemporalElement supersedingElement = previousElement.getSupersedingElement();
		if(supersedingElement == null){			
			previousElement.setSupersedingElement(newElement);
		}else{
			newElement.setSupersedingElement(supersedingElement);
			supersedingElement.setSupersededElement(newElement);
			previousElement.setSupersedingElement(newElement);
			
			newElement.setValidUntil(supersedingElement.getValidSince());
		}
		
		newElement.setSupersededElement(previousElement);
				
	}
}
