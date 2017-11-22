package eu.hyvar.context.presentation;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import de.darwinspl.common.eclipse.ui.dialogs.DwDateDialog;

public class DwCustomizedContextEditorPropertyDescriptor extends PropertyDescriptor {

	public DwCustomizedContextEditorPropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor) {
		super(object, itemPropertyDescriptor);
	}

	@Override
	public CellEditor createPropertyEditor(Composite composite) {
		CellEditor result = super.createPropertyEditor(composite);

		if (result == null) {
			return result;
		}

		EClassifier eType = ((EStructuralFeature) itemPropertyDescriptor.getFeature(object)).getEType();

		if (eType instanceof EDataType) {
			EDataType eDataType = (EDataType) eType;
			if (eDataType.getInstanceClass() == Date.class) {
				result = new ExtendedDialogCellEditor(composite, getEditLabelProvider()) {
					protected Object openDialogBox(Control cellEditorWindow) {
						
						Calendar calendar = Calendar.getInstance();
						calendar.set(Calendar.HOUR_OF_DAY, 0);
						calendar.set(Calendar.MINUTE, 0);
						calendar.set(Calendar.SECOND, 0);
						calendar.set(Calendar.MILLISECOND, 0);
						
						DwDateDialog dateDialog = new DwDateDialog(cellEditorWindow.getShell(), calendar.getTime());
						
						dateDialog.setBlockOnOpen(true);
						dateDialog.open();
						
						if (dateDialog.getReturnCode() == Dialog.OK) {
							Date date = dateDialog.getValue();
							
							return date;
						}
						
						return null;
					}
				};
			}
		}
		return result;
	}
}
