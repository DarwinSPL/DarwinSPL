package eu.hyvar.feature.graphical.base.figures;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyStringAttribute;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public class HyAttributeFigure extends Figure{
	private HyFeatureAttribute attribute;
	
	private Label typeLabel;
	private Label valueLabel;
	
	public HyAttributeFigure(GraphicalFeatureModelEditor editor, HyFeatureAttribute attribute) {
		setLayoutManager(new XYLayout());
		
		this.attribute = attribute;
		
		createChildFigures();
	}
	
	private String getType(){
		if(attribute == null)
			return "No Attribute specified";
		else{
			if(attribute instanceof HyBooleanAttribute)
				return "Boolean";
			if(attribute instanceof HyNumberAttribute)
				return "Number";
			if(attribute instanceof HyStringAttribute)
				return "String";
			if(attribute instanceof HyEnumAttribute)
				return "Enum ["+((HyEnumAttribute)attribute).getEnumType().getName()+"]";

			// no supported attribute
			return "Unsupported Attribute Type";
		}
	}
	
	public Label getLabel(){
		return valueLabel;
	}
	
	public int getMinimalWidth(){
		return typeLabel.getTextBounds().width + valueLabel.getTextBounds().width + 100;
	}
	
	private void createChildFigures() {
		typeLabel = new Label();
		typeLabel.setForegroundColor(ColorConstants.black);
		typeLabel.setText(getType());
		add(typeLabel);
		
		valueLabel = new Label();
		valueLabel.setForegroundColor(ColorConstants.black);
		valueLabel.setText(attribute.getNames().get(0).getName());
		add(valueLabel);	
	}
	
	public void setName(String text){
		valueLabel.setText(text);
	}
	//@Override
	public void update() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		int width = getParent().getBounds().width;
		int height = theme.getFeatureNameAreaHeight();
		setSize(width, height);

		
	
		typeLabel.setSize(new Dimension(typeLabel.getTextBounds().width, height));
		typeLabel.setLocation(new Point(10, 0));
		
		valueLabel.setSize(new Dimension(valueLabel.getTextBounds().width, height));
		valueLabel.setLocation(new Point(typeLabel.getTextBounds().width+20, 0));
	}
	
	@Override
	protected boolean useLocalCoordinates(){
		return true;
	}
}
