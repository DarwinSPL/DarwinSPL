package de.darwinspl.feature.graphical.base.figures;

import java.util.Date;
import org.eclipse.draw2d.Graphics;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import eu.hyvar.evolution.HyEvolutionUtil;

public class DwRootFeatureFigure extends DwFeatureFigure{

	public DwRootFeatureFigure(DwGraphicalFeatureModelViewer editor, DwFeatureWrapped feature) {
		super(editor, feature);
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
}