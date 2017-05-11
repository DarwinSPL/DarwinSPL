package eu.hyvar.feature.graphical.base.editparts;

import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.figures.HyAttributeFigure;
import eu.hyvar.feature.graphical.base.model.DwTemporalPosition;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;

public class HyAttributeEditPart extends HyAbstractEditPart{

	public HyAttributeEditPart(DwGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected IFigure createFigure() {
		return new HyAttributeFigure(editor, (HyFeatureAttribute)getModel());
	}

	@Override
	protected void createEditPolicies() {
	}
	
	
	protected Rectangle getFigureConstraint(){
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		int lineWidth = theme.getLineWidth();
		
		HyFeatureEditPart parent = (HyFeatureEditPart)getParent();
		
		
		if(parent == null) 
			return new Rectangle(0, 0, 0, 0);
		
		HyFeatureWrapped feature = (HyFeatureWrapped)parent.getModel();
		Date date = featureModel.getSelectedDate();
		
		HyFeatureAttribute attribute = (HyFeatureAttribute)getModel();
		int index = HyEvolutionUtil.getValidTemporalElements(attribute.getFeature().getAttributes(), date).indexOf(attribute);
		
		DwTemporalPosition parentPosition = feature.getPosition(date);
		int featurePositionY = feature.calculateVersionAreaBounds(date).getBottomLeft().y - parentPosition.getPosition().y + (int)Math.floor(theme.getLineWidth() * 1.5);
		int attributeHeight = theme.getFeatureNameAreaHeight();
		
		
		Rectangle layout = new Rectangle(new Point(0, featurePositionY + index * attributeHeight), new Dimension(feature.getSize(date).width, attributeHeight));
		layout = layout.shrink(new Insets(0, (int)Math.floor(lineWidth * 2.5), 0, (int)Math.floor(lineWidth * 2.5)));
		
		return layout;
	}
	
	@Override
	public void refreshVisuals(){
		super.refreshVisuals();
		
		HyAttributeFigure figure = (HyAttributeFigure)getFigure();
		HyFeatureAttribute attribute = (HyFeatureAttribute)getModel();
		
		Date date = featureModel.getSelectedDate();
		
		HyName name = HyEvolutionUtil.getValidTemporalElement(attribute.getNames(), date);
		if(name != null){
			figure.setName(name.getName());
		}else{
			// TODO show error that no name for the attribute exist at this timestamp
		}
		
		((HyAttributeFigure)getFigure()).update();
	
	}
}