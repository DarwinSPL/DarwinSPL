package eu.hyvar.feature.graphical.base.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.feature.HyFeatureLayouterManager;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.feature.HyFeatureTreeLayouter;

public class HyFeatureModelEvolutionWrapped extends HyFeatureModelWrapped{
	public static final String PROPERTY_SELECTED_DATE = "PropertySelectedDate";
	public static final String PROPERTY_DATES_COUNT = "PropertyDatesCount";
	private Date selectedDate;
	
	private List<Date> dates;
	
	public List<Date> getDates() {
		//List<Date> dates = HyEvolutionUtil.collectDates(getModel());
		//dates.add(0, new Date(Long.MIN_VALUE));
		//dates.add(dates.size(), new Date(Long.MAX_VALUE));
		
		return dates;
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

	public void addDate(Date date){
		if(dates.contains(date)) return;
		
		int old = dates.size();
		dates.add(dates.size(), date);
		
		Collections.sort(dates);
		
		
		changes.firePropertyChange(PROPERTY_DATES_COUNT, old, dates.size());
	}
	
	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		Date old = this.selectedDate;
		this.selectedDate = selectedDate;
		
		
		changes.firePropertyChange(PROPERTY_SELECTED_DATE, old, selectedDate);
		
		this.rearrangeFeatures();
	}

	public HyFeatureModelEvolutionWrapped(HyFeatureModel model) {
		super(model);
		
		dates = new ArrayList<Date>();
		dates = HyEvolutionUtil.collectDates(model);
				
		dates.add(0, new Date(Long.MIN_VALUE));
		dates.add(dates.size(), new Date(Long.MAX_VALUE));
	}

	
	public void changeConnection(HyParentChildConnection oldConnection, HyParentChildConnection newConnection){
		HyGroupComposition oldComposition = oldConnection.getComposition();	
		
		HyFeature parentFeature = newConnection.getSource().getWrappedModelElement();
		HyFeature childFeature = newConnection.getTarget().getWrappedModelElement();

		// find all children valid at given timestamp
		List<HyFeatureChild> children = HyEvolutionUtil.getValidTemporalElements(parentFeature.getParentOf(), selectedDate);
		
		for(HyFeatureChild child : children){
			HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(child.getChildGroup().getParentOf(), selectedDate);
			
			// change validity of composition to the selected value
			if(composition.getValidUntil() == null){
							
				
				HyGroupComposition supersedingComposition = EcoreUtil.copy(composition);
				Calendar a = Calendar.getInstance();
				a.setTime(selectedDate);
				a.add(Calendar.SECOND, -1);
				oldComposition.setValidUntil(a.getTime());
				child.getChildGroup().getParentOf().add(supersedingComposition);
				
				// make new composition only valid from current time stamp
				supersedingComposition.setValidSince(selectedDate);
				supersedingComposition.setSupersededElement(composition);
				
				composition.setSupersedingElement(supersedingComposition);
				
				
				supersedingComposition.getFeatures().add(childFeature);
				childFeature.getGroupMembership().add(supersedingComposition);
				//connection.getTarget().setParent(wrappedGroup);	
				//wrappedGroup.addChildFeature(connection.getTarget());
			}
		}
	}

	
	@Override
	
	public void rearrangeFeatures(){
		
		updateLayouter();
		HyFeatureTreeLayouter layouter = HyFeatureLayouterManager.getLayouter(this);
		
		for(HyFeature feature : HyEvolutionUtil.getValidTemporalElements(model.getFeatures(), this.selectedDate)){
			Rectangle rectangle = layouter.getBounds(feature);
			
			getWrappedFeature(feature).setPosition(rectangle.getTopLeft());	
		}	
	}
	
	
	@Override
	public void addFeature(HyFeatureWrapped feature){
		features.add(feature);
		
		model.getFeatures().add(feature.getWrappedModelElement());
		
		//HyFeatureLayouterManager.updateLayouter(getModel());
	}
	
	@Override
	public void createConnection(HyFeatureWrapped parent, HyFeatureWrapped child){
		super.createConnection(parent, child);
		
		HyFeatureLayouterManager.updateLayouter(this);
		//this.rearrangeFeatures();
	}
	
	public void updateLayouter(){
		HyFeatureLayouterManager.updateLayouter(this);
	}
}
