package eu.hyvar.feature.graphical.base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.graphical.base.adapters.HyFeatureWrappedAdapter;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version.HyVersionLayouterManager;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version.HyVersionTreeLayouter;

public class HyFeatureWrapped extends HyEditorChangeableElement{
	public final static String PROPERTY_CARDINALITY = "PropertyCardinality";
	public final static String PROPERTY_PARENT_CONNECTIONS_SIZE_CHANGED = "PropertyParentConnectionsSize";
	public final static String PROPERTY_CHILDREN_CONNECTIONS_SIZE_CHANGED = "PropertyChildrenConnectionsSize";



	HyGroupWrapped parentGroup;
	HyFeatureModelWrapped featureModel = null;

	private List<HyParentChildConnection> parentConnections;
	private List<HyParentChildConnection> childrenConnections;

	private Dimension size;
	
	
	public int getHeightWithoutAttributes(Date date) {
		HyFeature feature = getWrappedModelElement();
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		
		int height = (hasModfierAtDate(date) ? theme.getFeatureVariationTypeExtent() : 0) + theme.getFeatureNameAreaHeight() + theme.getLineWidth() * 2;
		if(HyEvolutionUtil.getValidTemporalElements(feature.getVersions(), date).isEmpty()){
			return height;
		}
		
		HyVersionTreeLayouter versionTreeLayouter = HyVersionLayouterManager.getLayouter(feature, date);
		if(versionTreeLayouter != null){
			Rectangle versionTreeBounds = versionTreeLayouter.getTreeBounds();
			height += versionTreeBounds.height;
		}
		
		return height;
	}
	
	public Dimension getSize(Date date){
		Dimension size = new Dimension();
		
		HyFeature feature = getWrappedModelElement();
		
		HyVersionTreeLayouter versionTreeLayouter = HyVersionLayouterManager.getLayouter(feature, date);
		if(versionTreeLayouter != null){
			size.expand(0, versionTreeLayouter.getTreeBounds().height);
			//Rectangle versionTreeBounds = versionTreeLayouter.getTreeBounds();			
		}
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		//int visibleAttributes = HyEvolutionUtil.getValidTemporalElements(feature.getAttributes(), date).size();

		int height = calculateAttributeAreaBounds(date).height;
		
		size.expand(0, theme.getFeatureNameAreaHeight());
		size.expand(0, (hasModfierAtDate(date) ? theme.getFeatureVariationTypeExtent() : 0));
		size.expand(0, height);
		size.expand(0, theme.getLineWidth()*2);
		return size;
	}
	
	public boolean hasModfierAtDate(Date date){
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(getWrappedModelElement().getGroupMembership(), date);
		
		if(composition != null){
			HyGroupType type = HyEvolutionUtil.getValidTemporalElement(composition.getCompositionOf().getTypes(), date);
			return type.getType() == HyGroupTypeEnum.AND;
		}
		
		return false;
	}
	
	public boolean hasVersionsAtDate(Date date) {
		return !HyEvolutionUtil.getValidTemporalElements(getWrappedModelElement().getVersions(), date).isEmpty();
	}
	
	public boolean hasAttributesAtDate(Date date) {
		return !HyEvolutionUtil.getValidTemporalElements(getWrappedModelElement().getAttributes(), date).isEmpty();
	}
	public Rectangle calculateAttributeAreaBounds(Date date) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		int visibleAttributes = HyEvolutionUtil.getValidTemporalElements(getWrappedModelElement().getAttributes(), date).size();

		int y = getHeightWithoutAttributes(date);
		if(hasVersionsAtDate(date)){
			y += theme.getFeatureNameAreaHeight() / 2;
		}
		int height = visibleAttributes * (theme.getFeatureNameAreaHeight()+theme.getLineWidth());

		Point location = position;
		return new Rectangle(new Point(location.x, location.y+y), 
				 new Dimension(getSize().width, height));
	}

	

	/*
	 * Needed to track changes of the original model and reallocate connections if necessary
	 */
	private HyFeatureWrappedAdapter adapter;

	public boolean isValid(Date since, Date until){
		HyFeature feature = (HyFeature)wrappedModelElement;
		Date validSince = feature.getValidSince();

		if(since == null || validSince == null || validSince.compareTo(since) <= 0){
			return true;
		}

		return false;
	}

	/**
	 * Checks if all parent features are valid at a specific date and returns a boolean value to indicate it.
	 * @param feature
	 * @param date
	 * @return true if and only if all parent features and groups are valid, false otherwise
	 */
	private boolean isValidRec(HyFeature feature, Date date){
		// check for root features
		for(HyRootFeature root : featureModel.getModel().getRootFeature()){
			if(feature.equals(root.getFeature()) && HyEvolutionUtil.isValid(root.getFeature(), date)){
				return true;
			}
		}	

		List<HyGroupComposition> compositions = HyEvolutionUtil.getValidTemporalElements(feature.getGroupMembership(), date);
		if(compositions.isEmpty()) 
			return false;

		for(HyGroupComposition composition : compositions){
			if(HyEvolutionUtil.isValid(composition.getCompositionOf(), date)){
				List<HyFeatureChild> children = HyEvolutionUtil.getValidTemporalElements(composition.getCompositionOf().getChildOf(), date);
				if(children.size() == 0) 
					return false;

				boolean valid = false;
				for(HyFeatureChild child : children){
					if(isValidRec(child.getParent(), date))
						valid = true;
				}

				if(!valid) 
					return false;
			}else
				return false;
		}

		boolean valid = HyEvolutionUtil.isValid(feature, date);
		return valid;
	}
	public boolean isValid(Date date){
		boolean result = isValidRec(this.getWrappedModelElement(), date);
		return result;
	}

	/**
	 * Checks if feature is optional at given date
	 * @param date
	 * @return true if feature is optional, false otherwise
	 */
	public boolean isOptional(Date date){
		HyFeatureType type = HyEvolutionUtil.getValidTemporalElement(this.getWrappedModelElement().getTypes(), date);

		return type.getType() == HyFeatureTypeEnum.OPTIONAL;
	}

	/**
	 * Checks if feature is mandatory at given date
	 * @param date
	 * @return true if feature is mandatory, false otherwise
	 */
	public boolean isMandatory(Date date){
		HyFeatureType type = HyEvolutionUtil.getValidTemporalElement(this.getWrappedModelElement().getTypes(), date);

		return type.getType() == HyFeatureTypeEnum.MANDATORY;	
	}

	/**
	 * Checks if feature has no modifier therefore is child of a "or" or "alternative" group
	 * @param date
	 * @return true if feature  is child of a "or" or "alternative" group, false otherwise
	 */
	public boolean isWithoutModifier(Date date){
		if(HyEvolutionUtil.getValidTemporalElements(this.getGroupMembership(date).get(0).getFeatures(), date).size() <= 1)
			return false;
		
		HyGroupWrapped groupWrapped = this.getParentGroup(date);
		if(groupWrapped != null){
			HyGroup group = groupWrapped.getWrappedModelElement();

			return !group.isAnd(date);
		}

		return true;
	}

	/**
	 * Returns an instance of the HyFeature model which was wrapped by this class.
	 */
	@Override
	public HyFeature getWrappedModelElement() {
		return (HyFeature)wrappedModelElement;
	}

	/**
	 * Returns the parent group, valid at given date. 
	 * @param date
	 * @return Instance of HyGroupWrapped if this feature has a valid group at the given date, null otherwise.
	 */
	public HyGroupWrapped getParentGroup(Date date) {

		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(this.getWrappedModelElement().getGroupMembership(), date);
		// TODO throw an exception or something to inform that something got wrong
		if(composition == null)	
			return null;
		if(composition.getCompositionOf().isAnd(date)){
			return featureModel.findWrappedGroup(composition.getCompositionOf());
		}

		return null;
	}
	public void setParent(HyGroupWrapped parentGroup) {
		this.parentGroup = parentGroup;
	}

	public HyFeatureWrapped(EObject wrappedModelElement, HyFeatureModelWrapped featureModel) {
		super(wrappedModelElement);

		adapter = new HyFeatureWrappedAdapter();
		adapter.setModel(this);

		
		DEGraphicalEditorTheme theme = new DEGraphicalEditorTheme();
		size = new Dimension(theme.getFeatureMinimumWidth(), theme.getFeatureNameAreaHeight());

		
		this.featureModel = featureModel;

		childrenConnections = new ArrayList<HyParentChildConnection>();
		parentConnections = new ArrayList<HyParentChildConnection>();
	}

	private List<HyParentChildConnection> filterConnections(List<HyParentChildConnection> connections, Date date){
		ArrayList<HyParentChildConnection> filteredConnections = new ArrayList<HyParentChildConnection>();
		for(HyParentChildConnection connection : connections){
			if(connection.isVisible(date))
				filteredConnections.add(connection);
		}
		return filteredConnections;		
	}

	public void setParentConnections(List<HyParentChildConnection> parentConnections) {
		this.parentConnections = parentConnections;
	}
	public List<HyParentChildConnection> getChildrenConnections(Date date) {
		return filterConnections(childrenConnections, date);
	}
	public void setChildrenConnections(List<HyParentChildConnection> childrenConnections) {
		this.childrenConnections = childrenConnections;
	}
	public List<HyParentChildConnection> getParentConnections(Date date) {
		return filterConnections(parentConnections, date);
	}
	public void addParentToChildConnection(HyParentChildConnection connection){
		int old = childrenConnections.size();

		if(!(childrenConnections.contains(connection))){
			childrenConnections.add(connection);				
		}else{
		}

		listeners.firePropertyChange(PROPERTY_PARENT_CONNECTIONS_SIZE_CHANGED, old, childrenConnections.size());
	}


	public void removeParentToChildConnection(HyParentChildConnection connection) {
		int old = childrenConnections.size();

		childrenConnections.remove(connection);
		listeners.firePropertyChange(PROPERTY_PARENT_CONNECTIONS_SIZE_CHANGED, old, childrenConnections.size());
	}	

	public void addChildToParentConnection(HyParentChildConnection connection){
		int old = parentConnections.size();

		if(!(parentConnections.contains(connection))){
			parentConnections.add(connection);				
		}else{
		}		

		listeners.firePropertyChange(PROPERTY_CHILDREN_CONNECTIONS_SIZE_CHANGED, old, parentConnections.size());
	}


	public void removeChildToParentConnection(HyParentChildConnection connection) {
		int old = parentConnections.size();

		parentConnections.remove(connection);

		listeners.firePropertyChange(PROPERTY_CHILDREN_CONNECTIONS_SIZE_CHANGED, old, childrenConnections.size());
	}


	public List<HyGroupComposition> getGroupMembership(Date date){
		return HyEvolutionUtil.getValidTemporalElements(this.getWrappedModelElement().getGroupMembership(), date);
	}




	public Dimension getSize() {
		return size;
	}
	public void setSize(Dimension size) {
		this.size = size;
	}




	public void setType(HyFeatureType value){
		HyFeatureType oldCardinality = getWrappedModelElement().getTypes().get(0);
		getWrappedModelElement().getTypes().set(0, value);

		listeners.firePropertyChange(PROPERTY_CARDINALITY, oldCardinality, value);
	}

	public List<HyFeature> getParentFeatures(Date date) {
		if(date == null) date = new Date();

		List<HyFeature> parents = new ArrayList<HyFeature>();
		List<HyGroupComposition> compositions = HyEvolutionUtil.getValidTemporalElements(getWrappedModelElement().getGroupMembership(), date);
		for(HyGroupComposition composition : compositions){
			List<HyFeatureChild> children = HyEvolutionUtil.getValidTemporalElements(composition.getCompositionOf().getChildOf(), date);
			for(HyFeatureChild child : children){
				parents.add(child.getParent());
			}
		}

		return parents;
	}
}
