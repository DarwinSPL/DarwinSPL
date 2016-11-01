package eu.hyvar.feature.graphical.base.figures;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public class HyEnumFigure extends HyAbstractFigure{
	private Label label;

	public HyEnumFigure(GraphicalFeatureModelEditor editor) {
		super(editor);

		createChildFigures();
	}

	public Label getLabel(){
		return label;
	}

	private void createChildFigures() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		label = new Label();
		label.setFont(theme.getFeatureFont());
		label.setForegroundColor(ColorConstants.black);

		add(label);	
	}

	private void resizeToContent() {
		Rectangle bounds = new Rectangle(new Point(0, 0), new Dimension(300, 20));	
		label.setBounds(bounds);
		setConstraint(label, bounds);
	}

	@Override 
	public void paintFigure(Graphics graphics) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		int lineWidth = theme.getLineWidth();
		graphics.setLineWidth(theme.getLineWidth());
		graphics.setForegroundColor(theme.getLineColor());
		graphics.drawRectangle(this.getBounds().expand(new Insets(-lineWidth, -lineWidth, -lineWidth, -lineWidth)));

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
