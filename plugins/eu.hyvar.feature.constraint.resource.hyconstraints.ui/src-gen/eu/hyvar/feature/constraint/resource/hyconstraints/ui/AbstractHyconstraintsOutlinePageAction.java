/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;

public abstract class AbstractHyconstraintsOutlinePageAction extends Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageTreeViewer treeViewer;
	
	public AbstractHyconstraintsOutlinePageAction(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		ImageDescriptor descriptor = eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
		valueChanged(checked, false);
	}
	
	@Override
	public void run() {
		if (keepState()) {
			valueChanged(isChecked(), true);
		} else {
			runBusy(true);
		}
	}
	
	public void runBusy(final boolean on) {
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			public void run() {
				runInternal(on);
			}
		});
	}
	
	public abstract void runInternal(boolean on);
	
	private void valueChanged(boolean on, boolean store) {
		setChecked(on);
		runBusy(on);
		if (store) {
			eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
