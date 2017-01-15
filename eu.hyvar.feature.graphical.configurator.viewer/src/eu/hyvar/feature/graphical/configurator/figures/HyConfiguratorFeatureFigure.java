package eu.hyvar.feature.graphical.configurator.figures;

import java.util.List;

import org.deltaecore.feature.graphical.base.util.DEDrawingUtil;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.figures.HyFeatureFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.configurator.editor.HyFeatureModelDeltaModuleConfiguratorEditor;

public class HyConfiguratorFeatureFigure extends HyFeatureFigure{

	public HyConfiguratorFeatureFigure(HyGraphicalFeatureModelViewer editor, HyFeatureWrapped feature) {
		super(editor, feature);
	}
	
	@Override
	protected void paintVersionMarks(Graphics graphics) {
		HyFeature feature = getFeature().getWrappedModelElement();
		List<HyVersion> versions = feature.getVersions();

		for (HyVersion version : versions) {
			Rectangle versionMarkRectangle = getVersionMarkRectangle(version);
			
			HyConfiguration selectedConfiguration = ((HyFeatureModelDeltaModuleConfiguratorEditor)editor).getSelectedConfiguration();
			
			if (HyConfigurationUtil.configurationSelectsVersion(selectedConfiguration, version)) {
				DEDrawingUtil.drawSelection(graphics, versionMarkRectangle, this, false);
			}
		}
		
		super.paintVersionMarks(graphics);
	}
	
	@Override
	protected void paintAttributeMarks(Graphics graphics) {
		HyFeature feature = getFeature().getWrappedModelElement();
		List<HyFeatureAttribute> attributes = feature.getAttributes();

		for (HyFeatureAttribute attribute : attributes) {
			Rectangle attributeMarkRectangle = getAttributeMarkRectangle(attribute);
			
			HyConfiguration selectedConfiguration = ((HyFeatureModelDeltaModuleConfiguratorEditor)editor).getSelectedConfiguration();
			
			for(HyConfigurationElement element : selectedConfiguration.getElements()){
				if(element instanceof HyAttributeValueAssignment){
					if(EcoreUtil.equals(((HyAttributeValueAssignment)element).getAttribute(), attribute)){
						DEDrawingUtil.drawSelection(graphics, attributeMarkRectangle, this, false);
					}
				}
			}
		}
		
		super.paintVersionMarks(graphics);
	}
}
