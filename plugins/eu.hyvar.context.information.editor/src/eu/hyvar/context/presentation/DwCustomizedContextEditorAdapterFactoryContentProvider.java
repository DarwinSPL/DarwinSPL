package eu.hyvar.context.presentation;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.ui.views.properties.IPropertySource;

public class DwCustomizedContextEditorAdapterFactoryContentProvider extends AdapterFactoryContentProvider {

	public DwCustomizedContextEditorAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	protected IPropertySource createPropertySource(Object object, IItemPropertySource itemPropertySource) {
		return new DwCustomizedContextEditorPropertySource(object, itemPropertySource);
	}
}
