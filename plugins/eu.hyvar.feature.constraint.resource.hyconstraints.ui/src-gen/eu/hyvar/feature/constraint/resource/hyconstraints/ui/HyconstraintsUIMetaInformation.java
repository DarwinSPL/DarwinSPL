/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.ui;

import org.eclipse.core.resources.IResource;

public class HyconstraintsUIMetaInformation extends eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsMetaInformation {
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsHoverTextProvider getHoverTextProvider() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsHoverTextProvider();
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsImageProvider getImageProvider() {
		return eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsImageProvider.INSTANCE;
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsColorManager createColorManager() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstra
	 * intsTextResource,
	 * eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsColorManager)
	 * instead.
	 */
	public eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsTokenScanner createTokenScanner(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsColorManager colorManager) {
		return (eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsTokenScanner) createTokenScanner(null, colorManager);
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.ui.IHyconstraintsTokenScanner createTokenScanner(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource resource, eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsColorManager colorManager) {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsTokenScanner(resource, colorManager);
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsCodeCompletionHelper createCodeCompletionHelper() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsCodeCompletionHelper();
	}
	
	@SuppressWarnings("rawtypes")
	public Object createResourceAdapter(Object adaptableObject, Class adapterType, IResource resource) {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.ui.debug.HyconstraintsLineBreakpointAdapter();
	}
	
}
