package dw.darwinspl.feature.graphical.configurator.composites;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Composite;

import de.christophseidl.util.swt.controls.SelectSingleFolderComposite;

public class DwVariantComposite extends SelectSingleFolderComposite {
	
	public DwVariantComposite(Composite parent, int style) {
		super(parent, style);
		setGroupName("Variant Folder");
	}

	@Override
	protected String createResourceDialogTitle() {
		return "Select Variant Folder";
	}

	@Override
	protected boolean createResourceDialogAllowNewFolderName() {
		return true;
	}

	@Override
	protected IFolder loadResourceFromString(String resourceString, IWorkspaceRoot workspaceRoot) {
		if (resourceString == null || resourceString.isEmpty()) {
			return null;
		}
		
		IPath folderPath = new Path(resourceString);
		return workspaceRoot.getFolder(folderPath);
	}
}
