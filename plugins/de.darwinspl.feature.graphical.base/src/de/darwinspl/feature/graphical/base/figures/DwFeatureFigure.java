package de.darwinspl.feature.graphical.base.figures;

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

import de.darwinspl.feature.graphical.base.anchors.DwFeatureChildrenAnchor;
import de.darwinspl.feature.graphical.base.anchors.DwFeatureParentAnchor;
import de.darwinspl.feature.graphical.base.deltaecore.wrapper.DwGeometryUtil;
import de.darwinspl.feature.graphical.base.deltaecore.wrapper.layouter.version.DwVersionLayouterManager;
import de.darwinspl.feature.graphical.base.deltaecore.wrapper.layouter.version.DwVersionTreeLayouter;
import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;

/**
 * Handles the rendering of a feature and corresponding versions. 
 * 
 * @author Gil Engel
 *
 */
public class DwFeatureFigure extends DwErrorMarkerFigure{
	/**
	 * Tooltip to display the id of a feature
	 */
	private DwTooltipFigure tooltipFigure;	
	
	/**
	 * Button to hide/show children
	 */
	private DwExpandButton expandButton;

	/**
	 * Figure to indicate the type of the feature
	 */
	private DwFeatureTypeFigure typeFigure;

	/**
	 * Indicator to show the numbers of hidden features
	 */
	private DwHiddenChildrenIndicatorFigure hiddenChildrenIndicator;



	protected AbstractConnectionAnchor parentAnchor;
	protected AbstractConnectionAnchor childrenAnchor;

	/**
	 * The model that is represented by this figure
	 */
	protected DwFeatureWrapped feature;


	public DwFeatureFigure(DwGraphicalFeatureModelViewer editor, DwFeatureWrapped feature) {
		super(editor);

		this.feature = feature;	

		createExpandButton();
		createHiddenChildrenIndicator();
		createTypeFigure();
		createIconFigure();
	


		this.setLayoutManager(new XYLayout());

		parentAnchor = new DwFeatureParentAnchor(this, editor);	
		childrenAnchor = new DwFeatureChildrenAnchor(this, editor);
		
		tooltipFigure = new DwTooltipFigure();
		setToolTip(tooltipFigure);


	}
	
	public void setTooltipText(String tooltipText) {
        tooltipFigure.setMessage(tooltipText);
    }


	@Override
	protected void createTooltipFigure() {
		super.createTooltipFigure();

		if(calculateIconVisibility())
			setTooltipText(editor.getModelWrapped().getMarkerForElement(feature.getWrappedModelElement()).getMessage());
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

	/**
	 * Creates the figure to show the number of hidden children
	 */
	private void createHiddenChildrenIndicator(){
		hiddenChildrenIndicator = new DwHiddenChildrenIndicatorFigure(feature, editor.getModelWrapped());
		add(hiddenChildrenIndicator);
	}

	/**
	 * Creates the figure to indicate the feature type if the figure has a type
	 */
	private void createTypeFigure(){
		typeFigure = new DwFeatureTypeFigure(feature, editor.getModelWrapped());
		add(typeFigure);
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
	public void updateLabel(){
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Date date = editor.getCurrentSelectedDate();
		//Label size
		Rectangle nameAreaBounds = feature.calculateNameAreaBounds(date);
		Dimension preferredLabelSize = label.getPreferredSize();

		int labelWidth = nameAreaBounds.width;
		int labelHeight = preferredLabelSize.height;
		int labelX = theme.getPrimaryMargin() / 2;
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
		DwVersionTreeLayouter versionTree = DwVersionLayouterManager.getLayouter(feature, editor.getCurrentSelectedDate());
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

	private void resizeToContent() {
		Date date = editor.getCurrentSelectedDate();

		int width = DwGeometryUtil.calculateFeatureWidth(feature.getWrappedModelElement(), date);
		int height = DwGeometryUtil.calculateFeatureHeight(feature.getWrappedModelElement(), date);

		setSize(width, height);
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
			label.setText(name.getName());	
		}else{
			// TODO show error that specific feature has no name at current date
		}	

		expandButton.setDirection(feature.isHideChildren() ? Orientable.SOUTH : Orientable.NORTH);
		boolean noConnections = feature.getChildrenConnections(date).isEmpty();
		expandButton.setVisible(!noConnections);
		
		hiddenChildrenIndicator.setVisible(feature.isHideChildren() && !noConnections);
	}

	private void updateHiddenChildrenIndicator(){
		this.hiddenChildrenIndicator.update();
	}

	public void update() {
		updateContent();

		resizeToContent();
		updateLabel();
		updateExpandButton();
		updateIconFigure();
		updateHiddenChildrenIndicator();

		repaint();

		typeFigure.repaint();
	}

	@Override 
	protected void paintFigure(Graphics graphics) {
		Date date = editor.getCurrentSelectedDate();

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

		DwVersionTreeLayouter versionTreeLayouter = DwVersionLayouterManager.getLayouter(feature, date);
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



	@Override
	protected boolean calculateIconVisibility() {

		DwFeatureModelWrapped featureModel = editor.getModelWrapped();
		if(featureModel.hasMarkerForElement(feature.getWrappedModelElement())){
			return true;
		}

		return false;
	}

	protected Point calculateLocation(){
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Date date = editor.getCurrentSelectedDate();

		return new Point(theme.getPrimaryMargin() / 2, feature.calculateVariationTypeCircleBounds(date).height + feature.calculateNameAreaBounds(date).height / 2 - 8);

	}
}