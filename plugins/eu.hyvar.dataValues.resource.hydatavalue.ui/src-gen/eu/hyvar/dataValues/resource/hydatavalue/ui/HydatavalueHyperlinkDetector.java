/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.ui;

import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;

/**
 * A hyperlink detector returns hyperlink if the token, where the mouse cursor
 * hovers, is a proxy.
 */
public class HydatavalueHyperlinkDetector implements IHyperlinkDetector {
	
	private eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource textResource;
	
	/**
	 * <p>
	 * Creates a hyperlink detector.
	 * </p>
	 * 
	 * @param resource the resource to use for calculating the locations.
	 */
	public HydatavalueHyperlinkDetector(Resource resource) {
		textResource = (eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource) resource;
	}
	
	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region, boolean canShowMultipleHyperlinks) {
		eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueLocationMap locationMap = textResource.getLocationMap();
		List<EObject> elementsAtOffset = locationMap.getElementsAt(region.getOffset());
		EObject resolvedEObject = null;
		for (EObject eObject : elementsAtOffset) {
			if (eObject.eIsProxy()) {
				resolvedEObject = EcoreUtil.resolve(eObject, textResource);
				if (resolvedEObject == eObject) {
					continue;
				}
				int offset = locationMap.getCharStart(eObject);
				int length = locationMap.getCharEnd(eObject) - offset + 1;
				String text = null;
				try {
					text = textViewer.getDocument().get(offset, length);
				} catch (BadLocationException e) {
				}
				// we skip elements that are not contained in a resource, because we cannot jump
				// to them anyway
				if (resolvedEObject.eResource() != null) {
					IHyperlink hyperlink = new eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueHyperlink(new Region(offset, length), resolvedEObject, text);
					return new IHyperlink[] {hyperlink};
				}
			}
		}
		return null;
	}
	
}
