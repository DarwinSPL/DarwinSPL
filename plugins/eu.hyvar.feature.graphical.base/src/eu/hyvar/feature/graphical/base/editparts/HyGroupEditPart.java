package eu.hyvar.feature.graphical.base.editparts;

import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.figures.HyGroupFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;

public class HyGroupEditPart extends HyAbstractEditPart{
	
	public HyGroupEditPart(DwGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel){
		super(editor, featureModel);
	}

	@Override
	protected IFigure createFigure() {
		DwGraphicalFeatureModelViewer editor = (DwGraphicalFeatureModelViewer) getEditor();
		HyGroupWrapped model = (HyGroupWrapped)getModel();
		return new HyGroupFigure(editor, model);
	}

	@Override
	protected void createEditPolicies() {		
	}


	
	protected Rectangle getFigureConstraint(){
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		HyGroupWrapped model = (HyGroupWrapped)getModel();
		
		HyFeatureWrapped feature = featureModel.getParentFeatureForGroup(model, featureModel.getSelectedDate());
		
		Point parentPosition = feature.getPosition(featureModel.getSelectedDate()).getPosition().getCopy();
		parentPosition.x += feature.getSize(editor.getCurrentSelectedDate()).width() / 2.0 - theme.getGroupSymbolRadius();
		parentPosition.y += feature.getSize(editor.getCurrentSelectedDate()).height; 

		int size = theme.getLineWidth() * 2 + theme.getGroupSymbolRadius() * 2;
		
		return new Rectangle(parentPosition, new Dimension(size, size));
	}

	@Override
	protected void refreshVisibility(){
		HyGroupWrapped model = (HyGroupWrapped)getModel();
		Date date = featureModel.getSelectedDate();

		HyFeatureWrapped parentFeature = featureModel.getParentFeatureForGroup(model, date);
		
		// check if group as at a valid parent feature and show/hide the group accordingly
		boolean isVisible = HyEvolutionUtil.isValid(model.getWrappedModelElement(), date);
		
		// hide group if parent feature is set to hide children
		boolean hasValidParentFeature = false;
		if(parentFeature != null){
			if(!parentFeature.isVisible() || parentFeature.isHideChildren())
				isVisible = false;
			
			hasValidParentFeature = true;
		}


		figure.setVisible(isVisible && hasValidParentFeature);
		
		AbstractGraphicalEditPart parent = (AbstractGraphicalEditPart)getParent();
		if(figure.isVisible() && parent != null)
			parent.setLayoutConstraint(this, figure, getFigureConstraint());
	}
}
