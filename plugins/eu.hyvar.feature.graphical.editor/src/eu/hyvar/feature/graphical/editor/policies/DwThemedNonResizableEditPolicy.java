package eu.hyvar.feature.graphical.editor.policies;

import java.util.ArrayList;
import java.util.List;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.SharedCursors;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;

/**
 * Non resizable edit policy that overrides the normal selection handles with 
 * DeltaEcore defined style
 * 
 * @author Gil Engel
 *
 */
public class DwThemedNonResizableEditPolicy extends NonResizableEditPolicy{
	
	/**
	 * Create selection handles in the style as predefined in DeltaEcore
	 * @see DEGraphicalEditorTheme
	 */
	@Override
	protected List<Object> createSelectionHandles() {
		List<Object> list = new ArrayList<Object>();

		MoveHandle moveHandle = new MoveHandle((GraphicalEditPart) getHost());
		moveHandle.setDragTracker(getDragTracker());		
		
		if (isDragAllowed()) {
			moveHandle.setCursor(Cursors.SIZEALL);
		} else {
			moveHandle.setCursor(SharedCursors.ARROW);
		}
		
		// set line style to meet the predefined theme
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		LineBorder border = new LineBorder();
		border.setColor(theme.getSelectionSecondaryColor());
		border.setWidth(theme.getLineWidth());
		moveHandle.setBorder(border);
		
		list.add(moveHandle);
		
		return list;
	}
}
