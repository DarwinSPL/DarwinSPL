package eu.hyvar.feature.graphical.editor.dialogs;

import org.eclipse.swt.widgets.Shell;

import eu.hyvar.feature.HyFeatureTypeEnum;

public class HyFeatureTypeDialog extends TypeDialog {
	public HyFeatureTypeDialog(Shell parentShell) {
		super(parentShell);
		
		Type mandatory = new Type();
		mandatory.type = HyFeatureTypeEnum.MANDATORY_VALUE;
		mandatory.description = "Mandatory";		
		
		Type optional = new Type();
		optional.type = HyFeatureTypeEnum.OPTIONAL_VALUE;
		optional.description = "Optional";
		
		types.add(mandatory);
		types.add(optional);
	}
}
