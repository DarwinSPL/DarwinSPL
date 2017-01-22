package eu.hyvar.feature.graphical.base.editparts;

import java.util.ArrayList;
import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.figures.HyGroupFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;

public class HyGroupEditPart extends HyAbstractEditPart{

	private boolean changeMode;

	public boolean isChangeMode() {
		return changeMode;
	}

	public void setChangeMode(boolean changeMode) {
		this.changeMode = changeMode;
	}

	private int temporaryElementIndex;

	public int getTemporaryElementIndex() {
		return temporaryElementIndex;
	}

	public void setTemporaryElementIndex(int temporaryElementIndex) {
		this.temporaryElementIndex = temporaryElementIndex;
	}

	public HyGroupEditPart(HyGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel){
		super(editor, featureModel);
		children = new ArrayList<HyFeature>();


	}

	@Override
	protected IFigure createFigure() {
		HyGraphicalFeatureModelViewer editor = (HyGraphicalFeatureModelViewer) getEditor();
		HyGroupWrapped model = (HyGroupWrapped)getModel();
		return new HyGroupFigure(editor, model);
	}

	@Override 
	protected void refreshVisuals() {
		refreshVisibillity();
		refreshLayoutConstraint();		
	}

	@Override
	protected void createEditPolicies() {		
	}

	private void refreshLayoutConstraint(){
		HyGroupWrapped model = (HyGroupWrapped)getModel();
		
		HyFeatureWrapped feature = featureModel.getParentFeatureForGroup(model, featureModel.getSelectedDate());
		if(feature == null)
			return;
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		Point parentPosition = feature.getPosition(null).getCopy();
		parentPosition.x += feature.getSize().width() / 2.0 - theme.getGroupSymbolRadius();
		parentPosition.y += feature.getSize(editor.getCurrentSelectedDate()).height; 

		int size = theme.getLineWidth() * 2 + theme.getGroupSymbolRadius() * 2;

		HyFeatureModelEditPart parent = (HyFeatureModelEditPart)getParent();
		
		if(parent != null)
			parent.setLayoutConstraint(this, figure, new Rectangle(parentPosition, new Dimension(size, size)));
	}

	private void refreshVisibillity(){
		HyGroupWrapped model = (HyGroupWrapped)getModel();
		Date date = featureModel.getSelectedDate();

		// check if group as at a valid parent feature and show/hide the group accordingly
		boolean isVisible = HyEvolutionUtil.isValid(model.getWrappedModelElement(), date);
		boolean hasValidParentFeature = false;
		for(HyFeatureChild child : model.getWrappedModelElement().getChildOf()){
			if(child.getParent() != null){
				if(HyEvolutionUtil.isValid(child.getParent(), date))
					hasValidParentFeature = true;		
			}
		}


		//figure.setVisible(isVisible && hasValidParentFeature);
	}
}
