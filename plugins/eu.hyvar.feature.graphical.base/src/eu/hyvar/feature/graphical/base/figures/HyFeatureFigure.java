package eu.hyvar.feature.graphical.base.figures;

import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEDrawingUtil;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.anchors.HyFeatureChildrenAnchor;
import eu.hyvar.feature.graphical.base.anchors.HyFeatureParentAnchor;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.HyGeometryUtil;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version.HyVersionLayouterManager;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version.HyVersionTreeLayouter;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;

public class HyFeatureFigure extends Figure{
	protected AbstractConnectionAnchor parentAnchor;
	protected AbstractConnectionAnchor childrenAnchor;
	
	protected HyFeatureWrapped feature;
	protected Label label;
	protected HyGraphicalFeatureModelViewer editor;

	public HyGraphicalFeatureModelViewer getEditor() {
		return editor;
	}

	public HyFeatureWrapped getFeature() {
		return feature;
	}
	
	public HyFeatureFigure(HyGraphicalFeatureModelViewer editor, HyFeatureWrapped feature) {
		setLayoutManager(new XYLayout());
		this.feature = feature;

		createChildFigures();

		this.editor = editor;
		
		parentAnchor = new HyFeatureParentAnchor(this, editor);	
		childrenAnchor = new HyFeatureChildrenAnchor(this, editor);
		
		seperatorLocation = new Point(0, 0);
	}

	public ConnectionAnchor getParentAnchor() {
		return parentAnchor;
	}

	public void setParentAnchor(AbstractConnectionAnchor parentAnchor) {
		this.parentAnchor = parentAnchor;
	}

	public ConnectionAnchor getChildrenAnchor() {
		return childrenAnchor;
	}

	public void setChildrenAnchor(AbstractConnectionAnchor childrenAnchor) {
		this.childrenAnchor = childrenAnchor;
	}

	public void setText(String text){
		label.setText(text);
	}

	private void createChildFigures() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		label = new Label();
		label.setFont(theme.getFeatureFont());
		label.setForegroundColor(theme.getFeatureFontColor());

		add(label);	
	}
	
	public Rectangle calculateNameAreaBounds() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Rectangle bounds = getBounds();
		Rectangle nameAreaBounds = bounds.getCopy();


		nameAreaBounds.height = theme.getFeatureNameAreaHeight();
		if(bounds.height > 30)
			nameAreaBounds.setHeight(30);

		return nameAreaBounds;
	}

	public Rectangle calculateVariationTypeCircleBounds() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		Rectangle bounds = getBounds();

		int x = bounds.x + (bounds.width - theme.getFeatureVariationTypeExtent()) / 2;
		int y = bounds.y;
		
		Date date = editor.getCurrentSelectedDate();
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(feature.getWrappedModelElement().getGroupMembership(), date);
		
		int height = 0;
		if(composition != null){
			HyGroupType type = HyEvolutionUtil.getValidTemporalElement(composition.getCompositionOf().getTypes(), date);
			
			height = (type.getType() == HyGroupTypeEnum.AND ? theme.getFeatureVariationTypeExtent() : 0);
		}else{
			height = 4;
		}
		int width = theme.getFeatureVariationTypeExtent();

		return new Rectangle(x, y, width, height);
	}

	protected void paintNameAreaBackground(Graphics graphics) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Rectangle nameAreaBounds = calculateNameAreaBounds();

		//Compensate for line width
		int halfLineWidth = theme.getLineWidth() / 2;
		nameAreaBounds.expand(-halfLineWidth, 0);

		Rectangle variationBounds = calculateVariationTypeCircleBounds();


		nameAreaBounds.setY(variationBounds.height+nameAreaBounds.getTop().y());

		DEDrawingUtil.gradientFillRectangle(graphics, nameAreaBounds, theme.getFeatureNameAreaPrimaryColor(), theme.getFeatureNameAreaSecondaryColor());
		DEDrawingUtil.outlineRectangle(graphics, nameAreaBounds, theme.getLineColor());
		
	}

	public void updateLabelSize(){
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Rectangle nameAreaBounds = calculateNameAreaBounds();
		Dimension preferredLabelSize = label.getPreferredSize();
		
		int labelWidth = nameAreaBounds.width;
		int labelHeight = preferredLabelSize.height;
		int labelX = 0;
		int labelY = theme.getFeatureVariationTypeExtent() + (theme.getFeatureNameAreaHeight() - labelHeight) / 2+theme.getLineWidth();

		Rectangle labelBounds = new Rectangle(labelX, labelY, labelWidth, labelHeight);
		label.setBounds(labelBounds);
	}
	


	protected void paintVersionAreaBackground(Graphics graphics) {
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Rectangle versionAreaBounds = calculateVersionAreaBounds();

		//Compensate for line width
		int halfLineWidth = (int) Math.ceil(theme.getLineWidth() / 2);
		versionAreaBounds.expand(new Insets(0, -halfLineWidth, -halfLineWidth, -halfLineWidth));

		DEDrawingUtil.gradientFillRectangle(graphics, versionAreaBounds, theme.getFeatureVersionAreaPrimaryColor(), theme.getFeatureVersionAreaSecondaryColor());
		
		paintVersionMarks(graphics);
		paintAttributeMarks(graphics);
		
		DEDrawingUtil.outlineRectangle(graphics, versionAreaBounds, theme.getLineColor());
		
	}
	protected void paintAttributeAreaBackground(Graphics graphics) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		Date date = editor.getCurrentSelectedDate();
		Rectangle attributesAreaBounds = feature.calculateAttributeAreaBounds(date);

		//Compensate for line width
		int halfLineWidth = (int) Math.ceil(theme.getLineWidth() / 2);
		attributesAreaBounds.expand(new Insets(0, -halfLineWidth, 0, -halfLineWidth));

		DEDrawingUtil.gradientFillRectangle(graphics, attributesAreaBounds, theme.getFeatureVersionAreaPrimaryColor(), theme.getFeatureVersionAreaSecondaryColor());
		
		paintAttributeMarks(graphics);
		
		DEDrawingUtil.outlineRectangle(graphics, attributesAreaBounds, theme.getLineColor());
	}
	
	
	protected Rectangle getVersionMarkRectangle(HyVersion version) {
		HyFeature feature = getFeature().getWrappedModelElement();
		HyVersionTreeLayouter versionTree = HyVersionLayouterManager.getLayouter(feature, editor.getCurrentSelectedDate());
		Rectangle versionBounds = versionTree.getBounds(version);
		
		return versionBounds;
	}
	
	protected void paintVersionMarks(Graphics graphics) {
	}
	protected void paintAttributeMarks(Graphics graphics) {
	}

	protected Rectangle getAttributeMarkRectangle(HyFeatureAttribute attribute) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Date date = editor.getCurrentSelectedDate();
		
		
		int index = HyEvolutionUtil.getValidTemporalElements(attribute.getFeature().getAttributes(), date).indexOf(attribute);
		int height = theme.getFeatureNameAreaHeight()+theme.getLineWidth();
		int y = feature.getHeightWithoutAttributes(date);
		
		return new Rectangle(new Point(theme.getLineWidth(), y + index*height), 
				 new Dimension(feature.getSize().width-theme.getLineWidth()*2, height));
	}

	public Rectangle calculateVersionAreaBounds() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Rectangle bounds = getBounds();
		Rectangle versionAreaBounds = bounds.getCopy();

	
		int variationTypeAndNameAreaHeight = calculateVariationTypeCircleBounds().height + theme.getFeatureNameAreaHeight() + theme.getLineWidth() * 2 - 1;

		versionAreaBounds.y += variationTypeAndNameAreaHeight;
		versionAreaBounds.height -= variationTypeAndNameAreaHeight;

		return versionAreaBounds;
	}


	
	@Override
	protected boolean useLocalCoordinates(){
		return true;
	}

	public Label getLabel() {
		return label;
	}
	
	
	
	
	
	
	
	
	private Point seperatorLocation;
	
	

	public Point getSeperatorLocation() {
		return seperatorLocation;
	}



	public void setSeperatorLocation(Point seperatorLocation) {
		this.seperatorLocation = seperatorLocation;
	}


	protected void paintVariationTypeCircle(Graphics graphics) {
		Date date = ((HyGraphicalFeatureModelViewer)editor).getCurrentSelectedDate();
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		boolean isMandatory = feature.isMandatory(date);
		
		Color light = isMandatory ? theme.getFeatureMandatoryPrimaryColor() : theme.getFeatureOptionalPrimaryColor();
		Color dark = isMandatory ? theme.getFeatureMandatorySecondaryColor() : theme.getFeatureOptionalSecondaryColor();

		Rectangle variationTypeCircleBounds = calculateVariationTypeCircleBounds();

		//Compensate for line width
		int lineWidth = theme.getLineWidth();
		variationTypeCircleBounds.expand(-lineWidth, -lineWidth);


		DEDrawingUtil.gradientFillEllipsis(graphics, variationTypeCircleBounds, light, dark);
		DEDrawingUtil.outlineEllipsis(graphics, variationTypeCircleBounds, theme.getLineColor());
	}	
	
	
	private void resizeToContent() {
		Date date = editor.getCurrentSelectedDate();
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		int width = HyGeometryUtil.calculateFeatureWidth(feature.getWrappedModelElement(), date);
		int height = HyGeometryUtil.calculateFeatureHeight(feature.getWrappedModelElement(), date);
		
		setSize(width, height);
		
		//Label size
		Rectangle nameAreaBounds = calculateNameAreaBounds();
		Dimension preferredLabelSize = label.getPreferredSize();
		
		int labelWidth = nameAreaBounds.width;
		int labelHeight = preferredLabelSize.height;
		int labelX = 0;
		int labelY = this.calculateVariationTypeCircleBounds().height + (theme.getFeatureNameAreaHeight() - labelHeight) / 2;
		
		Rectangle labelBounds = new Rectangle(labelX, labelY, labelWidth, labelHeight);
		label.setBounds(labelBounds);
		setConstraint(label, labelBounds);
	}
	
	private void updateContent(){
		Date date = editor.getCurrentSelectedDate();
		HyName name = HyEvolutionUtil.getValidTemporalElement(feature.getWrappedModelElement().getNames(), date);
		
		if(name != null){
			getLabel().setText(name.getName());	
		}else{
			// TODO show error that specific feature has no name at current date
		}		
	}
	
	public void update() {
		updateContent();
		resizeToContent();
		repaint();
	}
	
	@Override 
	protected void paintFigure(Graphics graphics) {
		Date date = editor.getCurrentSelectedDate();
		
		if(!feature.isWithoutModifier(date)){
			paintVariationTypeCircle(graphics);
		}
		
		if (feature.hasVersionsAtDate(date)) {
			paintVersionAreaBackground(graphics);
			
			paintConnection(graphics, HyEvolutionUtil.getValidTemporalElements(feature.getWrappedModelElement().getVersions(), date).get(0));
		}
		
		
		if (feature.hasAttributesAtDate(date)) {
			paintAttributeAreaBackground(graphics);
		}		

		
		paintSeperatorLine(graphics);
		paintNameAreaBackground(graphics);
	}
	
	private void paintSeperatorLine(Graphics graphics){
		
		Date date = ((HyGraphicalFeatureModelViewer)editor).getCurrentSelectedDate();
		
		// feature has attributes and versions at the selected date, we need to display a seperation line
		if(HyEvolutionUtil.getValidTemporalElements(feature.getWrappedModelElement().getVersions(), date).size() > 0 &&
		   HyEvolutionUtil.getValidTemporalElements(feature.getWrappedModelElement().getAttributes(), date).size() > 0){
			DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

			graphics.setForegroundColor(theme.getLineColor());
			graphics.setLineWidth(theme.getLineWidth());
			int x = this.getLocation().x;
			int y = this.getLocation().y+theme.getFeatureVariationTypeExtent()+seperatorLocation.y-5;
			graphics.drawLine(x, y, x+getSize().width, y);
		}			
	}
	
	protected void paintConnection(Graphics graphics, HyVersion superseded) {
		Date date = ((HyGraphicalFeatureModelViewer)editor).getCurrentSelectedDate();
		HyFeature feature = superseded.getFeature();

		HyVersionTreeLayouter versionTreeLayouter = HyVersionLayouterManager.getLayouter(feature, date);
		for(HyVersion superseding : HyEvolutionUtil.getValidTemporalElements(superseded.getSupersedingVersions(), date)){
			Rectangle sb = versionTreeLayouter.getBounds(superseded);
			Rectangle ss = versionTreeLayouter.getBounds(superseding);
			
			
			Point supersedeedLocation = sb.getCenter();
			Point supersedingLocation = ss.getCenter();

			supersedeedLocation.x += sb.width / 2;
			supersedingLocation.x -= sb.width / 2;


			DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
			graphics.setForegroundColor(theme.getLineColor());
			graphics.setLineWidth(theme.getLineWidth());

			graphics.setLineWidth(2);
			Point start = new Point(supersedeedLocation.x + getLocation().x, supersedeedLocation.y + getLocation().y);
			Point end = new Point(supersedingLocation.x + this.getLocation().x, supersedingLocation.y + getLocation().y);		
			graphics.drawLine(start, end);

			paintConnection(graphics, superseding);
		}
	}
}