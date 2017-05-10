package dw.darwinspl.feature.graphical.configurator.figures;

import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEDrawingUtil;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.util.DwFeatureUtil;
import dw.darwinspl.feature.graphical.configurator.viewer.DwFeatureModelConfiguratorViewer;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;

public class DwConfiguratorFeatureModelFigure extends FreeformLayer {
	private DwFeatureModelWrapped featureModel;
	private DwFeatureModelConfiguratorViewer graphicalEditor;

	public DwConfiguratorFeatureModelFigure(DwFeatureModelWrapped featureModel, DwFeatureModelConfiguratorViewer graphicalEditor) {
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
		for (DwFeatureWrapped feature : featureModel.getFeatures(null)) {
			drawFeatureMarks(feature, graphics);
		}
	}

	protected void drawFeatureMarks(DwFeatureWrapped feature, Graphics graphics) {

		Rectangle featureMarkRectangle = getFeatureMarkRectangle(feature);

		//boolean featureHasError = graphicalEditor.hasError(feature);
		//boolean featureHasWarning = graphicalEditor.hasWarning(feature);

		HyConfiguration configuration = graphicalEditor.getSelectedConfiguration();

		if (HyConfigurationUtil.configurationSelects(configuration, feature.getWrappedModelElement())) {
			DEDrawingUtil.drawSelection(graphics, featureMarkRectangle, this, false);
		}
	}

	protected Rectangle getFeatureMarkRectangle(DwFeatureWrapped feature) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		Date date = graphicalEditor.getCurrentSelectedDate();
		Rectangle featureMarkRectangle = new Rectangle(feature.getPosition(date).getPosition(), feature.getSize(date));

		for(HyRootFeature root : feature.getWrappedModelElement().getFeatureModel().getRootFeature()){
			if(EcoreUtil.equals(root.getFeature(), feature.getWrappedModelElement())){
				if(DwFeatureUtil.isWithModifier(feature.getWrappedModelElement(), date)) {
					featureMarkRectangle.y += theme.getLineWidth();
					featureMarkRectangle.height -= theme.getLineWidth();
				}				
			}else{
				if(DwFeatureUtil.isWithModifier(feature.getWrappedModelElement(), date)) {
					int increment = (theme.getFeatureVariationTypeExtent() - 1);
					featureMarkRectangle.y += increment;
					featureMarkRectangle.height -= increment;
				}				
			}
		}
	




		return featureMarkRectangle;
	}

	/*
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
	*/
}
