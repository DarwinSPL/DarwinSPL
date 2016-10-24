/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;

public abstract class AbstractHymappingOutlinePageAction extends Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageTreeViewer treeViewer;
	
	public AbstractHymappingOutlinePageAction(eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		ImageDescriptor descriptor = eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
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
			eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
