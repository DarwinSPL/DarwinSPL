package eu.hyvar.feature.util;

import java.util.List;

public class HyFeatureModelWellFormednessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4464144824337378601L;
	
	private StringBuilder messageString;
	
	public HyFeatureModelWellFormednessException() {
		messageString = new StringBuilder();
	}
	
	public HyFeatureModelWellFormednessException(String sourceElement, String list, int amountOfElements) {
		this();
		messageString.append("The List of: ");
		messageString.append(list);
		messageString.append(" of Element: ");
		messageString.append(sourceElement);
		messageString.append(" has ");
		if(amountOfElements < 1) {
			messageString.append("no elements.");		
		} else if(amountOfElements > 1) {
			messageString.append("too many elements.");					
		}
		messageString.append(" Thus the model is not well formed for a certain point in time.");
	}
	
	public HyFeatureModelWellFormednessException(String sourceElement, String list, int amountOfElements, List<String> listOfNames) {
		this(sourceElement, list, amountOfElements);
		messageString.append("\n");
		messageString.append("The list seems to be a list of names:");
		messageString.append("\n");
		for(String name: listOfNames) {
			messageString.append(name);
			messageString.append("\n");
		}
	}
	

	@Override
	public String getMessage() {
		return messageString.toString();
	}
	
	
	// TODO unique name of features (overall) / attributes / versions per date!
}
