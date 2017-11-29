package de.darwinspl.feature.graphical.base.figures;


import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyStringAttribute;

public class DwAttributeFigure extends DwErrorMarkerFigure{
	private HyFeatureAttribute attribute;
	
	public Label valueLabel;
	
	public DwAttributeFigure(DwGraphicalFeatureModelViewer editor, HyFeatureAttribute attribute) {
		super(editor);
		
		this.attribute = attribute;
		
		createIconFigure();
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
		label.setLocation(new Point(26, 0));
		
		valueLabel.setSize(new Dimension(valueLabel.getTextBounds().width, height));
		valueLabel.setLocation(new Point(label.getTextBounds().width+36, 0));
		
		updateIconFigure();
		
		((DwFeatureFigure) getParent()).update();
	}
	
	@Override
	protected boolean useLocalCoordinates(){
		return true;
	}
	
	@Override
	public Label getLabel() {
		return valueLabel;
	}

	@Override
	protected void createTooltipFigure() {
		super.createTooltipFigure();
		
		if(calculateIconVisibility())
			setTooltipText(editor.getModelWrapped().getMarkerForElement(attribute).getMessage());
	}
	
	@Override
	protected boolean calculateIconVisibility() {
		DwFeatureModelWrapped featureModel = editor.getModelWrapped();
		if(featureModel.hasMarkerForElement(attribute)){
			return true;
		}
		
		return false;
	}

	@Override
	protected Point calculateLocation() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		return new Point(theme.getPrimaryMargin() / 2, 
						 theme.getFeatureNameAreaHeight() / 2 - 8);
	}
}
