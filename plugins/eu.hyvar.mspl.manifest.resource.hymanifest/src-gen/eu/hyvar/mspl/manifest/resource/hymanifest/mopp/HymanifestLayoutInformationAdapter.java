/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;

/**
 * <p>
 * A HymanifestLayoutInformationAdapter is used to store layout information that
 * is found while parsing text files. Layout information does include all unused
 * tokens. Usually, these are whitespace characters, line breaks and comments, but
 * depending on the concrete syntax definition it can also include other tokens.
 * HymanifestLayoutInformationAdapters are attached to EObjects and aggregate
 * multiple LayoutInformation objects. Each of these objects contains the layout
 * that was found before a keyword, attribute or reference.
 * </p>
 * 
 * <p>
 * Since layout information is stored in EAdapters, models can be transformed and
 * modified, while still keeping the formatting of the original text document from
 * which the model was originally created.
 * </p>
 */
public class HymanifestLayoutInformationAdapter implements Adapter {
	
	/**
	 * The EObject that this adapter is attached to.
	 */
	private Notifier target;
	
	/**
	 * A list of LayoutInformation objects. one for each keyword, attribute and
	 * reference.
	 */
	private List<eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestLayoutInformation> layoutInformations = new ArrayList<eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestLayoutInformation>();
	
	/**
	 * Returns the EObject that this adapter is attached to.
	 */
	public Notifier getTarget() {
		return target;
	}
	
	public boolean isAdapterForType(Object type) {
		return false;
	}
	
	public void notifyChanged(Notification notification) {
	}
	
	/**
	 * Sets the EObject that this adapter is attached to.
	 */
	public void setTarget(Notifier newTarget) {
		this.target = newTarget;
	}
	
	public List<eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestLayoutInformation> getLayoutInformations() {
		return layoutInformations;
	}
	
	public void addLayoutInformation(eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestLayoutInformation layoutInformation) {
		layoutInformations.add(layoutInformation);
	}
	
	/**
	 * Iterates over all layout informations and searches for those that refer to the
	 * given proxy object. Then, the old target of these layout informations (i.e.,
	 * the proxy) is changed to the new target. This is required, because at the time
	 * when the layout information is collected, all references point to proxy
	 * objects. But, later on these proxy objects are replaced by the objects that are
	 * referenced. To keep the layout information up to date, this replacement must be
	 * propagated to all attached layout information objects.
	 */
	public void replaceProxy(EObject proxy, EObject target) {
		for (eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestLayoutInformation layoutInformation : layoutInformations) {
			layoutInformation.replaceProxy(proxy, target);
		}
	}
	
}
