package dw.darwinspl.feature.graphical.base.figures;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.ArrowButton;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Triangle;
import org.eclipse.draw2d.geometry.Insets;

/**
 * Renders an arrow button with DeltaEcore colors
 * @author Gil Engel
 *
 */
public class DwExpandButton extends ArrowButton{
	public DwExpandButton(){
		setOpaque(false);
		setBorder(null);
	}
	
	protected void createTriangle() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();		
		
		Triangle tri = new Triangle();
		tri.setOutline(true);
		tri.setBackgroundColor(theme.getFeatureFontColor());
		tri.setForegroundColor(theme.getFeatureFontColor());
		tri.setBorder(new MarginBorder(new Insets(2)));
		setContents(tri);
	}
}
