package eu.hyvar.feature.graphical.base.figures;

import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEDrawingUtil;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Orientable;
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
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.anchors.HyFeatureChildrenAnchor;
import eu.hyvar.feature.graphical.base.anchors.HyFeatureParentAnchor;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.HyGeometryUtil;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version.HyVersionLayouterManager;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version.HyVersionTreeLayouter;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;

/**
 * Handles the rendering of a feature and corresponding versions. 
 * 
 * @author Gil Engel
 *
 */
public class HyFeatureFigure extends DwLabelFigure{
	/**
	 * Button to hide/show children
	 */
	private DwExpandButton expandButton;
	
	protected AbstractConnectionAnchor parentAnchor;
	protected AbstractConnectionAnchor childrenAnchor;
	
	/**
	 * The model that is represented by this figure
	 */
	protected HyFeatureWrapped feature;

	
	public HyFeatureFigure(DwGraphicalFeatureModelViewer editor, HyFeatureWrapped feature) {
		super(editor);
		
		this.feature = feature;	
		
		createExpandButton();
		
		this.setLayoutManager(new XYLayout());
		
		parentAnchor = new HyFeatureParentAnchor(this, editor);	
		childrenAnchor = new HyFeatureChildrenAnchor(this, editor);
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

	/**
	 * Creates the label to render the feature name
	 */
	@Override
	protected void createChildFigures() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		label = new Label();
		label.setFont(theme.getFeatureFont());
		label.setForegroundColor(theme.getFeatureFontColor());

		add(label);	
	}
	
	/**
	 * Creates the button to show/hide children
	 */
	private void createExpandButton(){
		expandButton = new DwExpandButton();
		add(expandButton);
		
		expandButton.setSize(new Dimension( 16, 16 ));
		expandButton.setDirection(Orientable.NORTH);
		expandButton.setVisible(false);
		
		expandButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				feature.setHideChildren(!feature.isHideChildren(), editor.getCurrentSelectedDate());
			}
		});		
	}
	
	@Override
	protected boolean useLocalCoordinates(){
		return true;
	}
	
	/**
	 * Paints the background for the name area with the predefined style as defined by 
	 * DeltaEcore
	 * @param graphics
	 */
	protected void paintNameAreaBackground(Graphics graphics) {
		Date date = editor.getCurrentSelectedDate();
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Rectangle nameAreaBounds = feature.calculateNameAreaBounds(date);

		//Compensate for line width
		int halfLineWidth = theme.getLineWidth() / 2;
		nameAreaBounds.expand(-halfLineWidth, -halfLineWidth);
		
		DEDrawingUtil.gradientFillRectangle(graphics, nameAreaBounds, theme.getFeatureNameAreaPrimaryColor(), theme.getFeatureNameAreaSecondaryColor());
		DEDrawingUtil.outlineRectangle(graphics, nameAreaBounds, theme.getLineColor());
		
	}

	/**
	 * Updates the label size after resizing the figure.
	 * The figure uses XYLayout therefore the label size has to be updated manually. 
	 */
	public void resizeLabel(){
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Date date = editor.getCurrentSelectedDate();
		//Label size
		Rectangle nameAreaBounds = feature.calculateNameAreaBounds(date);
		Dimension preferredLabelSize = label.getPreferredSize();
		
		int labelWidth = nameAreaBounds.width;
		int labelHeight = preferredLabelSize.height;
		int labelX = 0;
		int labelY = feature.calculateVariationTypeCircleBounds(date).height + (theme.getFeatureNameAreaHeight() - labelHeight) / 2;
		
		Rectangle labelBounds = new Rectangle(labelX, labelY, labelWidth, labelHeight);
		label.setBounds(labelBounds);
		setConstraint(label, labelBounds);
	}
	
	protected void paintVersionAreaBackground(Graphics graphics) {
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Rectangle versionAreaBounds = feature.calculateVersionAreaBounds(editor.getCurrentSelectedDate());

		//Compensate for line width
		int halfLineWidth = (int) Math.ceil(theme.getLineWidth() / 2);
		versionAreaBounds.expand(new Insets(halfLineWidth, -halfLineWidth, -halfLineWidth, -halfLineWidth));

		
		DEDrawingUtil.gradientFillRectangle(graphics, versionAreaBounds, theme.getFeatureVersionAreaPrimaryColor(), theme.getFeatureVersionAreaSecondaryColor());
		
		paintVersionMarks(graphics);
		paintAttributeMarks(graphics);
		
		DEDrawingUtil.outlineRectangle(graphics, versionAreaBounds, theme.getLineColor());
		
	}
	protected void paintAttributeAreaBackground(Graphics graphics) {
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		Date date = editor.getCurrentSelectedDate();
		Rectangle attributesAreaBounds = feature.calculateAttributesAreaBounds(date);

		//Compensate for line width
		int halfLineWidth = (int) Math.ceil(theme.getLineWidth() / 2);
		attributesAreaBounds.expand(new Insets(halfLineWidth, -halfLineWidth, -halfLineWidth, -halfLineWidth));

		DEDrawingUtil.gradientFillRectangle(graphics, attributesAreaBounds, theme.getFeatureVersionAreaPrimaryColor(), theme.getFeatureVersionAreaSecondaryColor());
		
		paintAttributeMarks(graphics);
		
		DEDrawingUtil.outlineRectangle(graphics, attributesAreaBounds, theme.getLineColor());
	}
	
	
	protected Rectangle getVersionMarkRectangle(HyVersion version) {
		HyFeature feature = this.feature.getWrappedModelElement();
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
				 new Dimension(feature.getSize(date).width-theme.getLineWidth()*2, height));
	}

	protected void paintVariationTypeCircle(Graphics graphics) {
		Date date = editor.getCurrentSelectedDate();
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		boolean isMandatory = feature.isMandatory(date);
		
		Color light = isMandatory ? theme.getFeatureMandatoryPrimaryColor() : theme.getFeatureOptionalPrimaryColor();
		Color dark = isMandatory ? theme.getFeatureMandatorySecondaryColor() : theme.getFeatureOptionalSecondaryColor();

		Rectangle variationTypeCircleBounds = feature.calculateVariationTypeCircleBounds(date);

		//Compensate for line width
		int lineWidth = theme.getLineWidth() / 2;
		variationTypeCircleBounds.expand(-lineWidth, -lineWidth);


		DEDrawingUtil.gradientFillEllipsis(graphics, variationTypeCircleBounds, light, dark);
		DEDrawingUtil.outlineEllipsis(graphics, variationTypeCircleBounds, theme.getLineColor());
	}	
	
	private void resizeToContent() {
		Date date = editor.getCurrentSelectedDate();
		
		int width = HyGeometryUtil.calculateFeatureWidth(feature.getWrappedModelElement(), date);
		int height = HyGeometryUtil.calculateFeatureHeight(feature.getWrappedModelElement(), date);
		
		setSize(width, height);
		
		resizeLabel();
		updateExpandButton();
	}
	
	private void updateExpandButton(){
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		Date date = editor.getCurrentSelectedDate();
		
		int width = feature.getSize(date).width;
		
		int positionY = theme.getFeatureNameAreaHeight() / 2-8;
		positionY += feature.calculateVariationTypeCircleBounds(editor.getCurrentSelectedDate()).height;
		
		expandButton.setLocation(new Point(width-18, positionY));		
	}
	
	private void updateContent(){
		Date date = editor.getCurrentSelectedDate();
		HyName name = HyEvolutionUtil.getValidTemporalElement(feature.getWrappedModelElement().getNames(), date);
		
		if(name != null){
			getLabel().setText(name.getName());	
		}else{
			// TODO show error that specific feature has no name at current date
		}	
		
		boolean hasChildren = !HyEvolutionUtil.getValidTemporalElements(feature.getWrappedModelElement().getParentOf(), editor.getCurrentSelectedDate()).isEmpty();

		expandButton.setDirection(feature.isHideChildren() ? Orientable.SOUTH : Orientable.NORTH);
		expandButton.setVisible(hasChildren);
	}
	
	public void update() {
		updateContent();
		resizeToContent();
		repaint();
	}
	
	@Override 
	protected void paintFigure(Graphics graphics) {

		Date date = editor.getCurrentSelectedDate();

		HyFeature model = feature.getWrappedModelElement();
		if(HyEvolutionUtil.getValidTemporalElement(model.getTypes(), date) == null ||
				feature.getGroupMembership(date).isEmpty()){
			return;
		}
		
		
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
		
		paintNameAreaBackground(graphics);

	}
	
	protected void paintConnection(Graphics graphics, HyVersion superseded) {
		Date date = ((DwGraphicalFeatureModelViewer)editor).getCurrentSelectedDate();
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