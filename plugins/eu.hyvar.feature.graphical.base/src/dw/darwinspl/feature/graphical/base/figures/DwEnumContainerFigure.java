package dw.darwinspl.feature.graphical.base.figures;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Insets;

import dw.darwinspl.feature.graphical.base.borders.DwMarginLineBorder;
import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public class DwEnumContainerFigure extends DwFeatureViewerReferencedFigure {

	public DwEnumContainerFigure(DwGraphicalFeatureModelViewer editor) {
		super(editor);
				
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		
		ToolbarLayout layout = new ToolbarLayout();
		layout.setHorizontal(false);
		layout.setSpacing(theme.getPrimaryMargin());		
		setLayoutManager(layout);	
		
		this.setBorder(new DwMarginLineBorder(new Insets(10, 10, 10, 10), theme.getLineColor(), theme.getLineWidth()));
	}
}
