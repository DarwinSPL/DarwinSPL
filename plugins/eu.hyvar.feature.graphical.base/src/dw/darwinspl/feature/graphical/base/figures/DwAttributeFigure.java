package dw.darwinspl.feature.graphical.base.figures;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyStringAttribute;

public class DwAttributeFigure extends DwLabelFigure{
	private HyFeatureAttribute attribute;
	
	private Label valueLabel;
	
	public DwAttributeFigure(DwGraphicalFeatureModelViewer editor, HyFeatureAttribute attribute) {
		super(editor);
		
		this.attribute = attribute;
		setText(getType(), attribute.getNames().get(0).getName());
	}
	
	public void setText(String typeText, String valueText){
		label.setText(typeText);
		valueLabel.setText(valueText);
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
	
	public int getMinimalWidth(){
		return label.getTextBounds().width + valueLabel.getTextBounds().width + 100;
	}
	
	@Override
	protected void createChildFigures() {
		label = new Label();
		label.setForegroundColor(ColorConstants.black);
		add(label);
		
		valueLabel = new Label();
		valueLabel.setForegroundColor(ColorConstants.black);
		add(valueLabel);	
	}
	
	public void setName(String text){
		valueLabel.setText(text);
	}

	public void update() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		int width = getParent().getBounds().width;
		int height = theme.getFeatureNameAreaHeight();
		setSize(width, height);
	
		label.setSize(new Dimension(label.getTextBounds().width, height));
		label.setLocation(new Point(10, 0));
		
		valueLabel.setSize(new Dimension(valueLabel.getTextBounds().width, height));
		valueLabel.setLocation(new Point(label.getTextBounds().width+20, 0));
	}
	
	@Override
	protected boolean useLocalCoordinates(){
		return true;
	}
}
