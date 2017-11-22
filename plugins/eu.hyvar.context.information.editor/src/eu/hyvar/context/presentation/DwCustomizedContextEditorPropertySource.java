package eu.hyvar.context.presentation;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

public class DwCustomizedContextEditorPropertySource extends PropertySource {

	public DwCustomizedContextEditorPropertySource(Object object, IItemPropertySource itemPropertySource) {
		super(object, itemPropertySource);
	}

	@Override
	protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
		return new DwCustomizedContextEditorPropertyDescriptor(object, itemPropertyDescriptor);
	}

}
