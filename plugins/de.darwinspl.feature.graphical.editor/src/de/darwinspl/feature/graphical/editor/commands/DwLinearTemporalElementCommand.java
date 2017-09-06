package de.darwinspl.feature.graphical.editor.commands;


import java.util.Date;

import org.eclipse.gef.commands.Command;

import eu.hyvar.evolution.HyLinearTemporalElement;

public class DwLinearTemporalElementCommand extends Command{
	
	protected HyLinearTemporalElement getLastHyLinearTemporalElement(HyLinearTemporalElement root){
		while(root.getSupersedingElement() != null){
			root = root.getSupersedingElement();
		}
		
		return root;		
	}
	
	protected void changeVisibilities(HyLinearTemporalElement previousElement, HyLinearTemporalElement newElement, Date date){
		Date modelDate = date;
		
		if(date != null && date.equals(new Date(Long.MIN_VALUE)))
			modelDate = null;
		
		if(previousElement == null){	
			newElement.setValidSince(modelDate);
			return;
		}
		
		previousElement.setValidUntil(modelDate);
		newElement.setValidSince(modelDate);
		
		HyLinearTemporalElement successor = previousElement.getSupersedingElement();
		if(successor == null){			
//			previousElement.setSupersedingElement(newElement);
		}else{
//			newElement.setSupersedingElement(successor);
//			
//			successor.setSupersededElement(newElement);
//			previousElement.setSupersedingElement(newElement);
			
			newElement.setValidUntil(successor.getValidSince());
		}
		
//		newElement.setSupersededElement(previousElement);		
	}
	
	protected void removeElementFromLinkedList(HyLinearTemporalElement element){
		HyLinearTemporalElement successor = element.getSupersedingElement();
		HyLinearTemporalElement predecessor = element.getSupersededElement();
		
		if(predecessor != null && successor != null){
			predecessor.setSupersedingElement(successor);
			predecessor.setValidUntil(successor.getValidSince());
			successor.setSupersededElement(predecessor);
		}
		
		if(predecessor != null && successor == null){
			predecessor.setSupersedingElement(null);
			predecessor.setValidUntil(null);
		}
		
		if(predecessor == null && successor != null){
			successor.setSupersededElement(null);
			successor.setValidUntil(null);
		}
		
		if(predecessor == null && successor == null){
			// ERROR, cannot delete only and unique element
		}
	}
}
