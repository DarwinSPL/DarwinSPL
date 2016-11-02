package eu.hyvar.feature.graphical.configurator.figures;

import java.util.Date;
import java.util.List;

import org.deltaecore.feature.DEGroup;
import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.figures.DEGroupFigure;
import org.deltaecore.feature.graphical.base.util.DEDrawingUtil;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.configurator.editor.HyFeatureModelDeltaModuleConfiguratorEditor;
import eu.hyvar.feature.graphical.base.util.HyFeatureUtil;

public class HyConfiguratorFeatureModelFigure extends FreeformLayer {
	private HyFeatureModelWrapped featureModel;
	private HyFeatureModelDeltaModuleConfiguratorEditor graphicalEditor;
	
	public HyConfiguratorFeatureModelFigure(HyFeatureModelWrapped featureModel, HyFeatureModelDeltaModuleConfiguratorEditor graphicalEditor) {
		this.featureModel = featureModel;
		this.graphicalEditor = graphicalEditor;
		
		setLayoutManager(new FreeformLayout());
	}
	
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		
		paintFeatureAndGroupMarks(graphics);
	}
	
	private void paintFeatureAndGroupMarks(Graphics graphics) {

		for (HyFeatureWrapped feature : featureModel.getFeatures(null)) {

				//Rectangle featureMarkRectangle = getFeatureMarkRectangle(feature);
				
				//drawFeatureMarks(feature, graphics);
				
				/*
				boolean featureHasError = graphicalEditor.hasError(feature);
				boolean featureHasWarning = graphicalEditor.hasWarning(feature);
				
				if (featureHasError) {
					DEDrawingUtil.drawProblem(graphics, featureMarkRectangle, this, true);
				} else if (featureHasWarning) {
					DEDrawingUtil.drawProblem(graphics, featureMarkRectangle, this, false);
				}
				*/
			
			
			
			/*
			if (element instanceof DEGroup) {
				DEGroup group = (DEGroup) element;
				Rectangle groupMarkRectangle = getGroupMarkRectangle(group);
				
				//It might be that the figure never was visible
				//so there is no rectangle around it either.
				if (groupMarkRectangle != null) {

				}
			}
			*/
		}
	}
	
	protected void drawFeatureMarks(HyFeatureWrapped feature, Graphics graphics) {

		Rectangle featureMarkRectangle = getFeatureMarkRectangle(feature);
		
		//boolean featureHasError = graphicalEditor.hasError(feature);
		//boolean featureHasWarning = graphicalEditor.hasWarning(feature);
		
		HyConfiguration configuration = graphicalEditor.getSelectedConfiguration();
		
		if (HyConfigurationUtil.configurationSelects(configuration, feature.getWrappedModelElement())) {
			DEDrawingUtil.drawSelection(graphics, featureMarkRectangle, this, false);
		}
	}
	
	protected Rectangle getFeatureMarkRectangle(HyFeatureWrapped feature) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		Date date = graphicalEditor.getCurrentSelectedDate();
		Rectangle featureMarkRectangle = new Rectangle(feature.getPosition(date), feature.getSize());
		
		
		if(HyFeatureUtil.isWithModifier(feature.getWrappedModelElement(), date)) {
			int increment = (theme.getFeatureVariationTypeExtent() - 1);
			featureMarkRectangle.y += increment;
			featureMarkRectangle.height -= increment;
		}
		
		
		return featureMarkRectangle;
	}
	
	private Rectangle getGroupMarkRectangle(DEGroup searchedGroup) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		List<?> children = getChildren();
		
		for (Object child : children) {
			if (child instanceof DEGroupFigure) {
				DEGroupFigure groupFigure = (DEGroupFigure) child;
				DEGroup group = groupFigure.getGroup();
				
				if (group == searchedGroup) {
					Rectangle groupMarkRectangle = groupFigure.getBounds().getCopy();
					groupMarkRectangle.expand(theme.getSecondaryMargin(), theme.getSecondaryMargin());
					return groupMarkRectangle;
				}
			}
		}
		
		return null;
	}
}
