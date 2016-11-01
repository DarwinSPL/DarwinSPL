package eu.hyvar.feature.graphical.base.figures;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public class HyEnumLiteralFigure extends Figure{
	private Label label;
	
	public HyEnumLiteralFigure(GraphicalFeatureModelEditor editor) {
		setLayoutManager(new XYLayout());
		
		createChildFigures();
	}

	public Label getLabel(){
		return label;
	}
	
	private void createChildFigures() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		label = new Label();
		label.setFont(theme.getFeatureFont());
		//label.setForegroundColor(theme.getFeatureFontColor());

		add(label);	
	}
	
	private void resizeToContent() {
		Rectangle bounds = new Rectangle(new Point(0, 0), getBounds().getSize());	
		label.setBounds(bounds);
		setConstraint(label, bounds);
	}
	
	//@Override
	public void update() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		int width = getParent().getBounds().width;
		int height = theme.getFeatureNameAreaHeight();
		
		setSize(width, height);

	}

	@Override 
	public void paintFigure(Graphics graphics) {	
		resizeToContent();
	}
	
	public void setText(String text){
		label.setText(text);
	}
	
	@Override
	protected boolean useLocalCoordinates(){
		return true;
	}
}
	