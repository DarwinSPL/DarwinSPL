package de.darwinspl.feature.graphical.base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;

import de.darwinspl.feature.graphical.base.adapters.DwFeatureWrappedAdapter;
import de.darwinspl.feature.graphical.base.deltaecore.wrapper.DwGeometryUtil;
import de.darwinspl.feature.graphical.base.deltaecore.wrapper.layouter.version.DwVersionLayouterManager;
import de.darwinspl.feature.graphical.base.deltaecore.wrapper.layouter.version.DwVersionTreeLayouter;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;

public class DwFeatureWrapped extends DwEditorChangeableElement{
	public final static String PROPERTY_CARDINALITY = "PropertyCardinality";
	public final static String PROPERTY_PARENT_CONNECTIONS_SIZE_CHANGED = "PropertyParentConnectionsSize";
	public final static String PROPERTY_CHILDREN_CONNECTIONS_SIZE_CHANGED = "PropertyChildrenConnectionsSize";
	public final static String PROPERTY_VIEW_HIDE_CHILDREN = "PropertyHideChildren";
	public final static String PROPERTY_VISIBILITY = "PropertyVisibility";

	DwGroupWrapped parentGroup;
	DwFeatureModelWrapped featureModel = null;

	private List<DwParentChildConnection> parentConnections;
	private List<DwParentChildConnection> childrenConnections;
	

	/**
	 * Controls if all features are hidden or visible
	 */
	private boolean hideChildren = false;
	
	/**
	 * Indicates if the feature figure is visible
	 */
	private boolean visible = true;



	/**
	 * 
	 * @param date
	 * @return
	 */
	public int getHeightWithoutAttributes(Date date) {
		Point position = this.getPosition(date).getPosition();
		Point attributeAreaTopLeft = this.calculateAttributesAreaBounds(date).getTopLeft();
		
		return attributeAreaTopLeft.y - position.y;
	}

	public Dimension getSize(Date date){
		Dimension size = new Dimension();
		
		size.width = DwGeometryUtil.calculateFeatureWidth(getWrappedModelElement(), date);

		int variationTypeCircleHeight = this.calculateVariationTypeCircleBounds(date).height;
		size.height = variationTypeCircleHeight+
					  this.calculateAttributesAreaBounds(date).height+
					  this.calculateNameAreaBounds(date).height +
					  this.calculateVersionAreaBounds(date).height;
		
		return size;
	}
	
	

	public boolean isHideChildren() {
		return hideChildren;
	}

	public void setHideChildren(boolean hideChildren, Date date) {
		boolean old = this.hideChildren;
		
		this.hideChildren = hideChildren;
		
		for(DwParentChildConnection connection : getChildrenConnections(date)){
			connection.getTarget().setVisible(!hideChildren, date);
		}
		
		listeners.firePropertyChange(PROPERTY_VIEW_HIDE_CHILDREN, old, hideChildren);
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible, Date date) {
		boolean old = this.visible;
		
		this.visible = visible;
		
		for(DwParentChildConnection connection : getChildrenConnections(date)){
			if(visible){
				if(!hideChildren)
					connection.getTarget().setVisible(true, date);
				else{
					connection.getTarget().setVisible(false, date);
				}
			}else{
				connection.getTarget().setVisible(false, date);
			}
		}
		
		listeners.firePropertyChange(PROPERTY_VISIBILITY, old, visible);
	}

	public Rectangle calculateVersionAreaBounds(Date date) {
		Rectangle variationAndNameBounds = calculateNameAreaBounds(date);
		
		Rectangle bounds = new Rectangle(variationAndNameBounds.getBottomLeft(), new Dimension(0, 0));
		bounds.width = variationAndNameBounds.width;
		
		DwVersionTreeLayouter versionTree = DwVersionLayouterManager.getLayouter(getWrappedModelElement(), date);
		if(versionTree != null && !HyEvolutionUtil.getValidTemporalElements(getWrappedModelElement().getVersions(), date).isEmpty()){
			DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
			
			int variationHeight = calculateVariationTypeCircleBounds(date).height;
			variationHeight -= variationHeight == 0 ? 0 : theme.getLineWidth();
			
			bounds.setHeight(versionTree.getTreeBounds().height + theme.getPrimaryMargin() * 2);
		}
		
		return bounds;
	}
	
	public Rectangle calculateNameAreaBounds(Date date) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		int width = DwGeometryUtil.calculateFeatureWidth(getWrappedModelElement(), date);

		Point position = getPosition(date).getPosition().getCopy();
		if(hasModfierAtDate(date)){
			position.y += theme.getFeatureVariationTypeExtent();
		}
		
		return new Rectangle(position, new Dimension(width, theme.getFeatureNameAreaHeight()));
	}

	public Rectangle calculateAttributesAreaBounds(Date date) {
		Rectangle variationNameAndVersionsBounds = calculateVersionAreaBounds(date);

		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		Rectangle bounds = new Rectangle(variationNameAndVersionsBounds.getBottomLeft(), variationNameAndVersionsBounds.getSize());
		int visibleAttributes = HyEvolutionUtil.getValidTemporalElements(getWrappedModelElement().getAttributes(), date).size();
		int height = visibleAttributes * (theme.getFeatureNameAreaHeight());
		
		// add the line width offset in case this feature has at least one attribute
		if(visibleAttributes > 0)
			height += theme.getLineWidth() * 4;
		bounds.setHeight(height);
		
		return bounds;
	}
	
	public Rectangle calculateVariationTypeCircleBounds(Date date) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Dimension size = new Dimension(0, 0);
		if(hasModfierAtDate(date)){
			size.setSize(theme.getFeatureVariationTypeExtent(), theme.getFeatureVariationTypeExtent());
		}
		
		Point position = getPosition(date).getPosition();
		int width = DwGeometryUtil.calculateFeatureWidth(getWrappedModelElement(), date);
		
		int x = position.x+width / 2 - theme.getFeatureVariationTypeExtent() / 2;
		
		return new Rectangle(new Point(x, position.y), size);
	}	


	public boolean hasModfierAtDate(Date date){
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(getWrappedModelElement().getGroupMembership(), date);

		if(composition != null){
			HyGroupType type = HyEvolutionUtil.getValidTemporalElement(composition.getCompositionOf().getTypes(), date);
			return type.getType() == HyGroupTypeEnum.AND;
		}

		return false;
	}
	
	/**
	 * Checks if feature has no modifier therefore is child of a "or" or "alternative" group
	 * @param date
	 * @return true if feature  is child of a "or" or "alternative" group, false otherwise
	 */
	/*
	public boolean isWithoutModifier(Date date){
		if(HyEvolutionUtil.getValidTemporalElements(this.getGroupMembership(date).get(0).getFeatures(), date).size() <= 1)
			return false;

		DwGroupWrapped groupWrapped = this.getParentGroup(date);
		if(groupWrapped != null){
			HyGroup group = groupWrapped.getWrappedModelElement();

			return !group.isAnd(date);
		}

		return true;
	}
	*/
	public HyGroupTypeEnum getModfierAtDate(Date date){
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(getWrappedModelElement().getGroupMembership(), date);

		if(composition != null){
			HyGroupType type = HyEvolutionUtil.getValidTemporalElement(composition.getCompositionOf().getTypes(), date);
			return type.getType();
		}

		return null;
	}

	public boolean hasVersionsAtDate(Date date) {
		return !HyEvolutionUtil.getValidTemporalElements(getWrappedModelElement().getVersions(), date).isEmpty();
	}

	public boolean hasAttributesAtDate(Date date) {
		return !HyEvolutionUtil.getValidTemporalElements(getWrappedModelElement().getAttributes(), date).isEmpty();
	}



	/*
	 * Needed to track changes of the original model and reallocate connections if necessary
	 */
	private DwFeatureWrappedAdapter adapter;

	
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
	/*
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
	*/
	
	public boolean isValid(Date date){
		return HyEvolutionUtil.isValid(this.getWrappedModelElement(), date);
	}

	/**
	 * Checks if feature is optional at given date
	 * @param date
	 * @return true if feature is optional, false otherwise
	 */
	public boolean isOptional(Date date){
		HyFeatureType type = HyEvolutionUtil.getValidTemporalElement(this.getWrappedModelElement().getTypes(), date);
		
		if(type == null)
			return true;
		
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
	public DwGroupWrapped getParentGroup(Date date) {

		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(this.getWrappedModelElement().getGroupMembership(), date);
		// TODO throw an exception or something to inform that something got wrong
		if(composition == null)	
			return null;
		// TODO remove add maybe breaks program
		else
			return featureModel.findWrappedGroup(composition.getCompositionOf());

		
		//if(composition.getCompositionOf().isAnd(date)){
		//	return featureModel.findWrappedGroup(composition.getCompositionOf());
		//}

		//return null;
	}
	public void setParent(DwGroupWrapped parentGroup) {
		this.parentGroup = parentGroup;
	}

	public DwFeatureWrapped(EObject wrappedModelElement, DwFeatureModelWrapped featureModel) {
		super(wrappedModelElement);

		adapter = new DwFeatureWrappedAdapter();
		adapter.setModel(this);


		DEGraphicalEditorTheme theme = new DEGraphicalEditorTheme();
		size = new Dimension(theme.getFeatureMinimumWidth(), theme.getFeatureNameAreaHeight());


		this.featureModel = featureModel;

		childrenConnections = new ArrayList<DwParentChildConnection>();
		parentConnections = new ArrayList<DwParentChildConnection>();
	}

	private List<DwParentChildConnection> filterConnections(List<DwParentChildConnection> connections, Date date){
		ArrayList<DwParentChildConnection> filteredConnections = new ArrayList<DwParentChildConnection>();
		for(DwParentChildConnection connection : connections){
			if(connection.isVisible(date))
				filteredConnections.add(connection);
		}
		return filteredConnections;		
	}

	public void setParentConnections(List<DwParentChildConnection> parentConnections) {
		this.parentConnections = parentConnections;
	}
	public List<DwParentChildConnection> getChildrenConnections() {
		return childrenConnections;
	}
	public List<DwParentChildConnection> getChildrenConnections(Date date) {
		return filterConnections(childrenConnections, date);
	}
	public void setChildrenConnections(List<DwParentChildConnection> childrenConnections) {
		this.childrenConnections = childrenConnections;
	}
	
	public List<DwParentChildConnection> getParentConnections() {
		return parentConnections;
	}	
	public List<DwParentChildConnection> getParentConnections(Date date) {
		return filterConnections(parentConnections, date);
	}
	public void clearParentConnections(){
		parentConnections.clear();
	}
	public void clearChildrenConnections(){
		childrenConnections.clear();
	}
	
	private boolean hasSimilarConnection(DwParentChildConnection connection, List<DwParentChildConnection> connections) {
		for(DwParentChildConnection c : connections) {
			boolean equalSinceDates = false;
			if(c.getValidSince() == null) {
				if(connection.getValidSince() == null)
					equalSinceDates = true;
				else
					equalSinceDates = false;
			}else {
				if(connection.getValidSince() == null)
					equalSinceDates = false;
				else
					equalSinceDates = c.getValidSince().equals(connection.getValidSince());
			}
			
			boolean equalUntilDates = false;
			if(c.getValidUntil() == null) {
				if(connection.getValidUntil() == null)
					equalUntilDates = true;
				else
					equalUntilDates = false;
			}else {
				if(connection.getValidUntil() == null)
					equalUntilDates = false;
				else
					equalUntilDates = c.getValidUntil().equals(connection.getValidUntil());
			}
			
			boolean equalDates = equalSinceDates && equalUntilDates;
			boolean equalFeatures = c.getSource().equals(connection.getSource()) && c.getTarget().equals(connection.getTarget());
			
			if (equalDates && equalFeatures)
				return true;
		}		
		
		return false;
	}
	
	public void addOrUpdateParentToChildConnection(DwParentChildConnection connection){

		
		if(hasSimilarConnection(connection,  childrenConnections))
			return;
		
		if(!(childrenConnections.contains(connection))){
			childrenConnections.add(connection);	
		}else {
			DwParentChildConnection other = childrenConnections.get(childrenConnections.indexOf(connection));
			other.setValidSince(other.getValidSince());
			other.setValidUntil(connection.getValidUntil());
		}

		//listeners.firePropertyChange(PROPERTY_PARENT_CONNECTIONS_SIZE_CHANGED, old, childrenConnections.size());
	}


	public void removeParentToChildConnection(DwParentChildConnection connection) {
		childrenConnections.remove(connection);
		//listeners.firePropertyChange(PROPERTY_PARENT_CONNECTIONS_SIZE_CHANGED, old, childrenConnections.size());
	}	

	public void addOrUpdateChildToParentConnection(DwParentChildConnection connection){
		if(getWrappedModelElement().getNames().get(0).getName().equals("New Feature 1"))
			System.out.println("");
		
		int old = parentConnections.size();

		if(hasSimilarConnection(connection,  parentConnections))
			return;
		
		if(!(parentConnections.contains(connection))){
			parentConnections.add(connection);				
		}else{
		}		

		listeners.firePropertyChange(PROPERTY_CHILDREN_CONNECTIONS_SIZE_CHANGED, old, parentConnections.size());
	}


	public void removeChildToParentConnection(DwParentChildConnection connection) {
		parentConnections.remove(connection);

		//listeners.firePropertyChange(PROPERTY_CHILDREN_CONNECTIONS_SIZE_CHANGED, old, childrenConnections.size());
	}


	public HyGroupComposition getGroupMembership(Date date){
		return HyEvolutionUtil.getValidTemporalElement(this.getWrappedModelElement().getGroupMembership(), date);
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

	public DwFeatureWrapped getParentFeature(Date date){
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(getWrappedModelElement().getGroupMembership(), date);
		
		if(composition == null) return null;
		
		HyFeatureChild child = HyEvolutionUtil.getValidTemporalElement(composition.getCompositionOf().getChildOf(), date);

		return featureModel.findWrappedFeature(child.getParent());
	}
}
