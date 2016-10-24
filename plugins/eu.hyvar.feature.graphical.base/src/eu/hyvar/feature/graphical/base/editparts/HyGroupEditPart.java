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
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.figures.HyGroupFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelEvolutionWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
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

	public HyGroupEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped featureModel){
		super(editor, featureModel);
		children = new ArrayList<HyFeature>();
		

	}

	@Override
	protected IFigure createFigure() {
		GraphicalFeatureModelEditor editor = (GraphicalFeatureModelEditor) getEditor();
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
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		Point parentPosition = model.getParentFeature().getPosition(null).getCopy();
		parentPosition.x += model.getParentFeature().getSize().width() / 2.0 - theme.getGroupSymbolRadius();
		parentPosition.y += theme.getFeatureNameAreaHeight() + 
				theme.getFeatureVariationTypeExtent() + theme.getLineWidth() * 2;

		int size = theme.getLineWidth() * 2 + theme.getGroupSymbolRadius() * 2;
		
		HyFeatureModelEditPart parent = (HyFeatureModelEditPart)getParent();
		parent.setLayoutConstraint(this, figure, new Rectangle(parentPosition, new Dimension(size, size)));
		
	}
	
	private void refreshVisibillity(){
		HyGroupWrapped model = (HyGroupWrapped)getModel();
		HyFeatureModelEvolutionWrapped featureModel = (HyFeatureModelEvolutionWrapped)this.featureModel;
		Date date = featureModel.getSelectedDate();
		
		// check if group as at a valid parent feature and show/hide the group accordingly
		boolean isVisible = HyEvolutionUtil.isValid(model.getWrappedModelElement(), date);
		boolean hasValidParentFeature = false;
		for(HyFeatureChild child : model.getWrappedModelElement().getChildOf()){
			if(HyEvolutionUtil.isValid(child.getParent(), date))
				hasValidParentFeature = true;			
		}
		

		figure.setVisible(isVisible && hasValidParentFeature);
	}
}
