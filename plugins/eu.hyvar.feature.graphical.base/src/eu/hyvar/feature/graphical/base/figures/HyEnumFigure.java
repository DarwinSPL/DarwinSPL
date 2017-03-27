package eu.hyvar.feature.graphical.base.figures;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ToolbarLayout;

import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public class HyEnumFigure extends DwLabelFigure{

	public HyEnumFigure(DwGraphicalFeatureModelViewer editor) {
		super(editor);
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		setBorder(new LineBorder(theme.getLineColor(), theme.getLineWidth()));		
	}
	
	@Override
	protected void createChildFigures() {
		ToolbarLayout layout = new ToolbarLayout();
		layout.setHorizontal(false); 
		setLayoutManager(layout);

		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		label = new Label();
		label.setFont(theme.getFeatureFont());
		label.setBorder(new MarginBorder(5));
		add(label);
	}
	
	@Override
	protected boolean useLocalCoordinates(){
		return true;
	}
}
