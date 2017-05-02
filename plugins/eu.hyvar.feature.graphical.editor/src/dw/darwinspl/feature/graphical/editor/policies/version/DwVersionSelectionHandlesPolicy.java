package dw.darwinspl.feature.graphical.editor.policies.version;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;


public class DwVersionSelectionHandlesPolicy extends SelectionEditPolicy{
	Label figure;

	@Override
	protected void hideSelection() {
		getHostFigure().setBorder(null);
	}

	@Override
	protected void showSelection() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		getHostFigure().setBorder(new LineBorder(theme.getSelectionLineColor(), theme.getLineWidth()));

	}
}
