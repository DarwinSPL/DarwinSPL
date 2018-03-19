package de.darwinspl.feature.graphical.configurator.figures;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.figures.DwAttributeFigure;
import de.darwinspl.feature.graphical.configurator.util.DwConfiguratorEditorUtil;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeatureAttribute;

public class DwConfiguratorAttributeFigure extends DwAttributeFigure{

	Label valueAssignmentLabel;

	
	public DwConfiguratorAttributeFigure(DwGraphicalFeatureModelViewer editor, HyFeatureAttribute attribute) {
		super(editor, attribute);
		
	}
	
	public void setValueAssignment(String text){
		valueAssignmentLabel.setText(" = "  + text);
	}
	
	public void addValueAssignmentLabel(){
		add(valueAssignmentLabel);
	}
	
	public void setValueAssignmentLabelVisible(){
		valueAssignmentLabel.setVisible(true);
		
		
	}
	
	
	public void setValueAssignmentVisibility(boolean value){
		valueAssignmentLabel.setVisible(value);
	}
	
	
	public void setValueAssignmentLabelInVisible(){
		valueAssignmentLabel.setVisible(false);
	}
		
	@Override
	public void setText(String typeText, String valueText){
		super.setText(typeText, valueText);
		
		
		
		switch(getType()){
		case "String":
			valueAssignmentLabel.setText("NULL");
			break;
		case "Boolean":
			valueAssignmentLabel.setText("false");
			break;
			
		case "Number":
			valueAssignmentLabel.setText("0");
			break;
		default:
			if(attribute instanceof HyEnumAttribute){
				valueAssignmentLabel.setText(((HyEnumAttribute) attribute).getEnumType().getLiterals().get(0).getName());
			}
				
			
		}
		
	
	}
	
	@Override
	public int getMinimalWidth() {
		
		return (super.getMinimalWidth() + valueAssignmentLabel.getTextBounds().width + 400);
	}
	
	@Override
	protected void createChildFigures() {
		
		super.createChildFigures();
	    
		
		valueAssignmentLabel = new Label();
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		valueAssignmentLabel.setForegroundColor(theme.getSelectionSecondaryColor());
		add(valueAssignmentLabel);
		
		valueAssignmentLabel.setVisible(false);
	
	}
	
	@Override
	public void update() {
	DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		int width = getParent().getBounds().width;
		int height = theme.getFeatureNameAreaHeight();
		
		setSize(width, height);
	
		label.setSize(new Dimension(label.getTextBounds().width, height));
		label.setLocation(new Point(26, 0));
		
		valueLabel.setSize(new Dimension(valueLabel.getTextBounds().width, height));
		valueLabel.setLocation(new Point(label.getTextBounds().width+36, 0));
	
		
		valueAssignmentLabel.setSize(new Dimension(valueAssignmentLabel.getTextBounds().width, height));
		valueAssignmentLabel.setLocation(new Point(label.getTextBounds().width+36+ 10+valueLabel.getTextBounds().width, 0));
		
		updateIconFigure();
		
		((DwConfiguratorFeatureFigure) getParent()).update();
	}

}
