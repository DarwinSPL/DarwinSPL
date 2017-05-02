package dw.darwinspl.feature.graphical.configurator.figures;

import java.util.List;

import org.deltaecore.feature.graphical.base.util.DEDrawingUtil;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.util.EcoreUtil;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.figures.DwFeatureFigure;
import dw.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import dw.darwinspl.feature.graphical.configurator.viewer.DwFeatureModelConfiguratorViewer;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;

public class DwConfiguratorFeatureFigure extends DwFeatureFigure{

	public DwConfiguratorFeatureFigure(DwGraphicalFeatureModelViewer editor, DwFeatureWrapped feature) {
		super(editor, feature);
	}
	
	@Override
	protected void paintVersionMarks(Graphics graphics) {
		HyFeature feature = this.feature.getWrappedModelElement();
		List<HyVersion> versions = feature.getVersions();

		for (HyVersion version : versions) {
			Rectangle versionMarkRectangle = getVersionMarkRectangle(version);
			
			HyConfiguration selectedConfiguration = ((DwFeatureModelConfiguratorViewer)editor).getSelectedConfiguration();
			
			if (HyConfigurationUtil.configurationSelectsVersion(selectedConfiguration, version)) {
				DEDrawingUtil.drawSelection(graphics, versionMarkRectangle, this, false);
			}
		}
		
		super.paintVersionMarks(graphics);
	}
	
	@Override
	protected void paintAttributeMarks(Graphics graphics) {
		HyFeature feature = this.feature.getWrappedModelElement();
		List<HyFeatureAttribute> attributes = feature.getAttributes();

		for (HyFeatureAttribute attribute : attributes) {
			Rectangle attributeMarkRectangle = getAttributeMarkRectangle(attribute);
			
			HyConfiguration selectedConfiguration = ((DwFeatureModelConfiguratorViewer)editor).getSelectedConfiguration();
			
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
