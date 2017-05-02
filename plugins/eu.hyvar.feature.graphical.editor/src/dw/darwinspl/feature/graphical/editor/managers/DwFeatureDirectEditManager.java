package dw.darwinspl.feature.graphical.editor.managers;

import org.eclipse.draw2d.Label;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;

public class DwFeatureDirectEditManager extends DirectEditManager {

	Label label;

	@SuppressWarnings("rawtypes")
	public DwFeatureDirectEditManager(GraphicalEditPart source, Class editorType, CellEditorLocator locator, Label label) {
		super(source, editorType, locator);
		this.label = label;
	}

	@Override protected void initCellEditor() {
		String initialLabelText = label.getText();
		getCellEditor().setValue(initialLabelText);
	}
}
