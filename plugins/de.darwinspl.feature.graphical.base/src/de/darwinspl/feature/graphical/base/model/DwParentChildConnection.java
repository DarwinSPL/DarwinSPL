package de.darwinspl.feature.graphical.base.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;
import java.util.UUID;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroupComposition;

public class DwParentChildConnection{
	private PropertyChangeSupport changes = new PropertyChangeSupport( this );
	private boolean highlight = false;
	private boolean visible = true;
	
	private UUID id;

	Date validSince;
	Date validUntil;

	public Date getValidSince() {
		return validSince;
	}

	public void setValidSince(Date validSince) {
		this.validSince = validSince;
	}

	public Date getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}



	public static final String PROPERTY_SOURCE = "PropertySOURCE";
	public static final String PROPERTY_TARGET = "PropertyTARGET";
	public static final String PROPERTY_HIGHLIGHTED = "PropertyHighlighted";
	public static final String PROPERTY_VISIBLE = "PropertyVisible";

	DwFeatureWrapped source;
	DwFeatureWrapped target;

	DwFeatureModelWrapped model;

	public DwParentChildConnection() {
		id = UUID.randomUUID();
	}
	public void setVisible(boolean visible) {
		boolean old = this.visible;
		this.visible = visible;

		changes.firePropertyChange(PROPERTY_HIGHLIGHTED, old, visible);
	}
	public boolean isVisible(Date date){
		if (date == null) {
			if (validSince == null && validUntil == null) {
				return true;
			} else {
				return false;
			}
		}

		if ((validSince == null || validSince.before(date)
				|| validSince.equals(date))
				&& (validUntil == null || validUntil.after(date))) {
			return true;
		}

		return false;
		/*
		if(!target.isValid(date) || !source.isValid(date))
			return false;

		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(target.getWrappedModelElement().getGroupMembership(), date);
		if(composition == null) 
			return false;

		// check if children match
		HyFeatureChild sourceChild = HyEvolutionUtil.getValidTemporalElement(source.getWrappedModelElement().getParentOf(), date);
		for(HyFeatureChild child : HyEvolutionUtil.getValidTemporalElements(source.getWrappedModelElement().getParentOf(), date)){
			if(sourceChild.equals(child)){
				return true;
			}
		}
		
		return false;
		*/
	}

	public boolean isVisible(){
		return visible;
	}
	public boolean isHighlight() {
		return highlight;
	}
	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
		changes.firePropertyChange(PROPERTY_HIGHLIGHTED, !highlight, highlight);
	}

	public DwFeatureModelWrapped getModel() {
		return model;
	}
	public void setModel(DwFeatureModelWrapped model) {
		this.model = model;
	}
	public DwFeatureWrapped getSource() {
		return source;
	}
	public void setSource(DwFeatureWrapped source) {
		DwFeatureWrapped old = this.source;
		this.source = source;

		changes.firePropertyChange(PROPERTY_SOURCE, old, source);
	}
	public DwFeatureWrapped getTarget() {
		return target;
	}
	public void setTarget(DwFeatureWrapped target) {
		DwFeatureWrapped old = this.target;
		this.target = target;

		changes.firePropertyChange(PROPERTY_TARGET, old, target);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener){
		changes.addPropertyChangeListener(listener);
	}
	public void removePropertyChangeListener(PropertyChangeListener listener){
		changes.removePropertyChangeListener(listener);
	}

	public HyGroupComposition getComposition(){
		HyFeature parentFeature = source.getWrappedModelElement();
		HyFeature childFeature = target.getWrappedModelElement();

		for(HyFeatureChild child : parentFeature.getParentOf()){
			for(HyGroupComposition composition : child.getChildGroup().getParentOf()){
				if(childFeature.getGroupMembership().contains(composition)){
					return composition;
				}
			}
		}

		return null;
	}

	public void notifyChange() {
		changes.firePropertyChange("SomeConnectedElementHasChanged", 1, 2);
	}
	
	@Override
	public boolean equals(Object other){
		DwParentChildConnection connection = (DwParentChildConnection)other;
		
		return this.getId().equals(connection.getId());
	}
}
