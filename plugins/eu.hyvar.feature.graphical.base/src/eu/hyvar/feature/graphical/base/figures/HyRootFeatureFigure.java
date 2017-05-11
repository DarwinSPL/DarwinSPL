package eu.hyvar.feature.graphical.base.figures;

import java.util.Date;
import org.eclipse.draw2d.Graphics;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;

public class HyRootFeatureFigure extends HyFeatureFigure{

	public HyRootFeatureFigure(DwGraphicalFeatureModelViewer editor, HyFeatureWrapped feature) {
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