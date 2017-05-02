package dw.darwinspl.feature.graphical.base.figures;

import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import dw.darwinspl.feature.graphical.base.deltaecore.wrapper.DwGeometryUtil;
import dw.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import dw.darwinspl.feature.graphical.base.model.DwFeatureWrapped;

public class DwFeatureTypeFigure extends DwGradientFillCircleFigure{
	private DwFeatureWrapped feature;
	private DwFeatureModelWrapped featureModel;
	
	public DwFeatureTypeFigure(DwFeatureWrapped feature, DwFeatureModelWrapped featureModel){
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		this.primaryColor = theme.getFeatureOptionalPrimaryColor();
		this.secondaryColor = theme.getFeatureOptionalSecondaryColor();
		this.outlineColor = theme.getLineColor();
		this.outlineWidth = theme.getLineWidth();
		
		this.feature = feature;
		this.featureModel = featureModel;
	}
	
	@Override
	public Rectangle getBounds() {
		Date date = featureModel.getSelectedDate();
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Dimension size = new Dimension(0, 0);
		if(feature.hasModfierAtDate(date)){
			size.setSize(theme.getFeatureVariationTypeExtent(), theme.getFeatureVariationTypeExtent());
		}
		
		int width = DwGeometryUtil.calculateFeatureWidth(feature.getWrappedModelElement(), date);
		
		int x = width / 2 - theme.getFeatureVariationTypeExtent() / 2;
		
		return new Rectangle(new Point(x, 0), size);
	}
	
	/**
	 * Update the feature type each time the figure is repainted
	 */
	@Override
	public void repaint() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		if(feature.isOptional(featureModel.getSelectedDate())){
			primaryColor = theme.getFeatureOptionalPrimaryColor();
			secondaryColor = theme.getFeatureOptionalSecondaryColor();
		}else{
			primaryColor = theme.getFeatureMandatoryPrimaryColor();
			secondaryColor = theme.getFeatureMandatorySecondaryColor();
		}
		
		super.repaint();
	};
}
