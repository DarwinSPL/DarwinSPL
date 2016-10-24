package eu.hyvar.feature.graphical.base.parts;

import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.figures.HyAttributeFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelEvolutionWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;

public class HyAttributeEditPart  extends HyAbstractEditPart{

	public HyAttributeEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected IFigure createFigure() {
		return new HyAttributeFigure(editor, (HyFeatureAttribute)getModel());
	}

	@Override
	protected void createEditPolicies() {
		// TODO
		//installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new HyVersionSelectionHandlesPolicy());
	}
	
	@Override
	public void refreshVisuals(){
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		HyFeatureEditPart parent = (HyFeatureEditPart)getParent();
		HyAttributeFigure figure = (HyAttributeFigure)getFigure();
		HyFeatureWrapped feature = (HyFeatureWrapped)parent.getModel();
		Date date = ((HyFeatureModelEvolutionWrapped)featureModel).getSelectedDate();
		
		HyFeatureAttribute attribute = (HyFeatureAttribute)getModel();
		int index = HyEvolutionUtil.getValidTemporalElements(attribute.getFeature().getAttributes(), date).indexOf(attribute);
		
		boolean versionsVisible = HyEvolutionUtil.getValidTemporalElements(feature.getWrappedModelElement().getVersions(), date).size() > 0;
		int y = parent.getHeightWithoutAttributes();
		if(versionsVisible){
			y += theme.getFeatureNameAreaHeight() / 2;
		}
		int height = theme.getFeatureNameAreaHeight()+theme.getLineWidth();
		
		int offset = 0;
		if(this.getSelected() != SELECTED_PRIMARY){
			offset = theme.getLineWidth();
		}
		
		Rectangle layout = new Rectangle(new Point(theme.getLineWidth()+offset, y + index*height+offset), 
										 new Dimension(feature.getSize().width-theme.getLineWidth()*2-offset*2, height));
		parent.setLayoutConstraint(this, figure, layout);	
		
		
		
		

		

		figure.setVisible(HyEvolutionUtil.isValid(attribute, date));
		HyName name = HyEvolutionUtil.getValidTemporalElement(attribute.getNames(), date);
		if(name != null){
			figure.setName(name.getName());
		}else{
			// TODO show error that no name for the attribute exist at this timestamp
		}
		
		((HyAttributeFigure)getFigure()).update();
	
	}
	
	/*
	 * TODO
	@Override
	public void setSelected(int value){
		super.setSelected(value);
		
		refreshVisuals();
	}
	
*/
}