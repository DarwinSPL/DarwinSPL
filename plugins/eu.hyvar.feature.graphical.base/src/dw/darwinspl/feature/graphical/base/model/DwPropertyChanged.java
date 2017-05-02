package dw.darwinspl.feature.graphical.base.model;

public interface DwPropertyChanged {
	/**
	 * This function is called each time if a property is changed in a class. The normal way to perform would be to
	 * pass forward the information to all listeners defined for the implementing class of this method.
	 * 
	 * @param property
	 * @param oldValue
	 * @param newValue
	 */
	void notifyProperyChange(String property, Object oldValue, Object newValue);
}
