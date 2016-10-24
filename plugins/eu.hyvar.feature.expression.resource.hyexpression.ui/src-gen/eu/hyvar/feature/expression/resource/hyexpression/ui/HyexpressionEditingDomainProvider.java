/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.ui;

import java.util.LinkedHashMap;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.IEditorInput;

/**
 * The EditingDomainProvider is used by the editor to obtain an EMF editing
 * domain. This default implementation creates a new editing domain for each
 * editor input.
 */
public class HyexpressionEditingDomainProvider {
	
	public EditingDomain getEditingDomain(IEditorInput editorInput) {
		return createEditingDomain();
	}
	
	private EditingDomain createEditingDomain() {
		AdapterFactory adapterFactory = new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionAdapterFactoryProvider().getAdapterFactory();
		
		BasicCommandStack commandStack = new BasicCommandStack();
		
		// Register resource factories (esp. for additional extensions).
		new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionMetaInformation().registerResourceFactory();
		
		return new AdapterFactoryEditingDomain(adapterFactory, commandStack, new LinkedHashMap<Resource, Boolean>());
	}
	
}
