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
import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.util.HyFeatureUtil;
import eu.hyvar.feature.graphical.configurator.viewer.HyFeatureModelConfiguratorViewer;

public class HyConfiguratorFeatureModelFigure extends FreeformLayer {
	private HyFeatureModelWrapped featureModel;
	private HyFeatureModelConfiguratorViewer graphicalEditor;

	public HyConfiguratorFeatureModelFigure(HyFeatureModelWrapped featureModel, HyFeatureModelConfiguratorViewer graphicalEditor) {
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
			drawFeatureMarks(feature, graphics);
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

		for(HyRootFeature root : feature.getWrappedModelElement().getFeatureModel().getRootFeature()){
			if(EcoreUtil.equals(root.getFeature(), feature.getWrappedModelElement())){
				if(HyFeatureUtil.isWithModifier(feature.getWrappedModelElement(), date)) {
					featureMarkRectangle.y += theme.getLineWidth();
					featureMarkRectangle.height -= theme.getLineWidth();
				}				
			}else{
				if(HyFeatureUtil.isWithModifier(feature.getWrappedModelElement(), date)) {
					int increment = (theme.getFeatureVariationTypeExtent() - 1);
					featureMarkRectangle.y += increment;
					featureMarkRectangle.height -= increment;
				}				
			}
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
