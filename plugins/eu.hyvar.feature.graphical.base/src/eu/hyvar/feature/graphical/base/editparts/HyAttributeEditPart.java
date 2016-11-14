package eu.hyvar.feature.graphical.base.editparts;

import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.figures.HyAttributeFigure;
import eu.hyvar.feature.graphical.base.figures.HyFeatureFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;

public class HyAttributeEditPart extends HyAbstractEditPart{

	public HyAttributeEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected IFigure createFigure() {
		return new HyAttributeFigure(editor, (HyFeatureAttribute)getModel());
	}

	@Override
	protected void createEditPolicies() {
	}
	
	@Override
	public void refreshVisuals(){
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		HyFeatureEditPart parent = (HyFeatureEditPart)getParent();
		HyAttributeFigure figure = (HyAttributeFigure)getFigure();
		HyFeatureFigure parentFigure = (HyFeatureFigure)figure.getParent();
		HyFeatureWrapped feature = (HyFeatureWrapped)parent.getModel();
		Date date = featureModel.getSelectedDate();
		
		HyFeatureAttribute attribute = (HyFeatureAttribute)getModel();
		int index = HyEvolutionUtil.getValidTemporalElements(attribute.getFeature().getAttributes(), date).indexOf(attribute);
		
		int y = feature.getHeightWithoutAttributes(date);
		if(feature.hasVersionsAtDate(date)){
			y = parentFigure.calculateVersionAreaBounds().height - theme.getVersionExtentY();
		}

		int height = theme.getFeatureNameAreaHeight()+theme.getLineWidth();
		
		
		Rectangle layout = new Rectangle(new Point(0, y+ index*height), new Dimension(feature.getSize().width, height));
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
}