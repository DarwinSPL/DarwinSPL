package eu.hyvar.feature.graphical.base.figures;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;

import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public class HyEnumLiteralFigure extends DwLabelFigure{

	public HyEnumLiteralFigure(DwGraphicalFeatureModelViewer editor) {
		super(editor);
		setLayoutManager(new ToolbarLayout());
	}
	
	@Override
	protected void createChildFigures() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		label = new Label();
		label.setFont(theme.getFeatureFont());
		label.setTextAlignment(PositionConstants.CENTER);
		label.setBorder(new MarginBorder(5));
	
		add(label);	
	}
}
	