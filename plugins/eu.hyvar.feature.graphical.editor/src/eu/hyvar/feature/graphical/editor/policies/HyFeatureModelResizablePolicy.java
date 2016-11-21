package eu.hyvar.feature.graphical.editor.policies;

import java.util.ArrayList;
import java.util.List;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;


public class HyFeatureModelResizablePolicy extends NonResizableEditPolicy{
	@SuppressWarnings("rawtypes")
	@Override
	protected List createSelectionHandles() {
		List list = new ArrayList();
		createMoveHandle(list);
		return list;
	}
	
	protected void addSelectionHandles() {
		removeSelectionHandles();
		IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
		
	
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		LineBorder border = new LineBorder();
		border.setColor(theme.getSelectionSecondaryColor());
		border.setWidth(3);
		
		
		handles = createSelectionHandles();
		for (int i = 0; i < handles.size(); i++){
			IFigure figure = (IFigure) handles.get(i);
			
			figure.setBorder(border);
			layer.add(figure);
		}
	}
}
