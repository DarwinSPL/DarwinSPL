package dw.darwinspl.feature.graphical.configurator.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import dw.darwinspl.feature.graphical.configurator.composites.DwVariantComposite;

public class DwVariantDerivationDialog extends Dialog {
	private DwVariantComposite variantComposite;

	// TODO: Make resizeable

	public DwVariantDerivationDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		// Composite area = (Composite) super.createDialogArea(parent);
		// Composite container = new Composite(area, SWT.NONE);
		// container.setLayoutData(new GridData(GridData.FILL_BOTH));

		variantComposite = new DwVariantComposite(parent, SWT.NONE);
		variantComposite.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));

		return variantComposite;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Variant Derivation");
	}

	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	public DwVariantComposite getVariantComposite() {
		return variantComposite;
	}
}
