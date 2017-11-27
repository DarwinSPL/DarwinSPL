/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <p>
 * DwprofileLayoutInformation objects are used to store layout information that is
 * found while parsing text files. Layout information does include all unused
 * tokens. Usually, these are whitespace characters, line breaks and comments, but
 * depending on the concrete syntax definition it can also include other tokens.
 * </p>
 * <p>
 * DwprofileLayoutInformations are aggregated in LayoutInformationAdapters. One
 * DwprofileLayoutInformation contains the layout that was found before a keyword,
 * attribute or reference.
 * </p>
 */
public class DwprofileLayoutInformation {
	
	/**
	 * The element in the grammar that is associated with this layout information.
	 * This can be either an attribute, a non-containment reference (placeholder) or a
	 * terminal (boolean or enumeration).
	 */
	private final de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement syntaxElement;
	
	/**
	 * The offset in the document where this piece of layout was found.
	 */
	private final int startOffset;
	
	/**
	 * Contains a concatenated version of all hidden tokens that were found before
	 * this object.
	 */
	private final String hiddenTokenText;
	
	/**
	 * Contains the visible token that represented this object in its text form.
	 */
	private final String visibleTokenText;
	
	/**
	 * The object the layout information refers to. This can be either the value of an
	 * attribute or a referenced EObject.
	 */
	private Object object;
	
	/**
	 * A flag that is used to remember whether the proxy to which this layout refers
	 * was resolved.
	 */
	private boolean wasResolved;
	
	public DwprofileLayoutInformation(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement syntaxElement, Object object, int startOffset, String hiddenTokenText, String visibleTokenText) {
		super();
		this.syntaxElement = syntaxElement;
		this.object = object;
		this.startOffset = startOffset;
		this.hiddenTokenText = hiddenTokenText;
		this.visibleTokenText = visibleTokenText;
	}
	
	public de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement getSyntaxElement() {
		return syntaxElement;
	}
	
	public int getStartOffset() {
		return startOffset;
	}
	
	/**
	 * Returns the objects that this layout information adapter refers to. This can be
	 * either the value of an attribute or a referenced object. If the parameter
	 * 'resolve' is set to true and the referenced object is a proxy, this method
	 * tries to resolve the proxy.
	 */
	public Object getObject(EObject container, boolean resolve) {
		if (wasResolved || !resolve) {
			return object;
		}
		// we need to try to resolve proxy objects again, because the proxy might have
		// been resolved before this adapter existed, which means we missed the
		// replaceProxy() notification
		if (object instanceof InternalEObject) {
			InternalEObject internalObject = (InternalEObject) object;
			if (internalObject.eIsProxy()) {
				if (container instanceof InternalEObject) {
					InternalEObject internalContainer = (InternalEObject) container;
					EObject resolvedObject = internalContainer.eResolveProxy(internalObject);
					if (resolvedObject != internalObject) {
						object = resolvedObject;
						wasResolved = true;
					}
				}
			}
		} else {
			wasResolved = true;
		}
		return object;
	}
	
	public String getHiddenTokenText() {
		return hiddenTokenText;
	}
	
	public String getVisibleTokenText() {
		return visibleTokenText;
	}
	
	public void replaceProxy(EObject proxy, EObject target) {
		if (this.object == proxy) {
			this.object = target;
		}
	}
	
	public String toString() {
		return "visible='" + visibleTokenText + "', hidden='" + hiddenTokenText + "', object='" + object + "', syntaxElement='" + syntaxElement + "'";
	}
	
}
