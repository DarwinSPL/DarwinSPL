package eu.hyvar.feature.graphical.editor.listeners;

import java.util.Date;

import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.geometry.Rectangle;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.graphical.base.figures.HyFeatureFigure;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;

public class HyFeatureEvolutionFigureMouseListener implements MouseListener{
	HyFeatureFigure figure;
	
	public HyFeatureEvolutionFigureMouseListener(HyFeatureFigure figure){
		this.figure = figure;
	}
	
	
	@Override
	public void mousePressed(MouseEvent me) {
		Rectangle variationTypeCircleBounds = figure.calculateVariationTypeCircleBounds();
		if(variationTypeCircleBounds.contains(me.getLocation())){
			Date date = ((GraphicalEvolutionFeatureModelEditor)figure.getEditor()).getCurrentSelectedDate();
			HyFeatureType type = HyEvolutionUtil.getValidTemporalElement(figure.getFeature().getWrappedModelElement().getTypes(), date);
			type.setValidUntil(date);
			
			HyFeatureType newType = HyFeatureFactory.eINSTANCE.createHyFeatureType();
			newType.setValidSince(date);
			if(type.getType() == HyFeatureTypeEnum.MANDATORY){
				newType.setType(HyFeatureTypeEnum.OPTIONAL);
			}else{
				newType.setType(HyFeatureTypeEnum.MANDATORY);
			}
			
			figure.getFeature().getWrappedModelElement().getTypes().add(newType);
		}
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		
	}


	@Override
	public void mouseDoubleClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}
}
