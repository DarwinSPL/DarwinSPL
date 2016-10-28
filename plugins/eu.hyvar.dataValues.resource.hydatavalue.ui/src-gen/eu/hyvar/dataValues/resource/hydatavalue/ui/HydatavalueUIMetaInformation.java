/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.ui;

import org.eclipse.core.resources.IResource;

public class HydatavalueUIMetaInformation extends eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueMetaInformation {
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueHoverTextProvider getHoverTextProvider() {
		return new eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueHoverTextProvider();
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueImageProvider getImageProvider() {
		return eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueImageProvider.INSTANCE;
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueColorManager createColorManager() {
		return new eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextReso
	 * urce, eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueColorManager)
	 * instead.
	 */
	public eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueTokenScanner createTokenScanner(eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueColorManager colorManager) {
		return (eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueTokenScanner) createTokenScanner(null, colorManager);
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.ui.IHydatavalueTokenScanner createTokenScanner(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource resource, eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueColorManager colorManager) {
		return new eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueTokenScanner(resource, colorManager);
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueCodeCompletionHelper createCodeCompletionHelper() {
		return new eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueCodeCompletionHelper();
	}
	
	@SuppressWarnings("rawtypes")
	public Object createResourceAdapter(Object adaptableObject, Class adapterType, IResource resource) {
		return new eu.hyvar.dataValues.resource.hydatavalue.ui.debug.HydatavalueLineBreakpointAdapter();
	}
	
}
