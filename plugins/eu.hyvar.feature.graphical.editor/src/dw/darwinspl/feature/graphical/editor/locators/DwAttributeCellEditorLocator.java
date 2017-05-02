package dw.darwinspl.feature.graphical.editor.locators;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;

public class DwAttributeCellEditorLocator implements CellEditorLocator{
	private Label label;
	
	public DwAttributeCellEditorLocator(Label label){
		this.label = label;
	}
	
	@Override
	public void relocate(CellEditor celleditor) {
		Text text = (Text)celleditor.getControl();
		Point point = text.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		Rectangle rectangle = label.getTextBounds().getCopy();
		label.translateToAbsolute(rectangle);
		text.setBounds(rectangle.x -1, rectangle.y -1, point.x +1, point.y +1);
	}
}
