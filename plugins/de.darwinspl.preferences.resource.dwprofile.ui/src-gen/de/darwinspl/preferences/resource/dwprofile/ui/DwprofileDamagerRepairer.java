/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.ui;

import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.ITokenScanner;

/**
 * This class subclasses the {@link DefaultDamagerRepairer} and modifies of a
 * damage region to not damage only the line where the modification event
 * occurred.It damages the whole region of the model element which corresponds to
 * the offset at which the modification event occurred.
 */
public class DwprofileDamagerRepairer extends DefaultDamagerRepairer {
	
	private de.darwinspl.preferences.resource.dwprofile.IDwprofileResourceProvider resourceProvider;
	
	/**
	 * <p>
	 * Creates a new damager repairer.
	 * </p>
	 * 
	 * @param tokenScanner the token scanner for retrieving the tokens for syntax
	 * coloring
	 * @param resourceProvider the resource provider giving access to the resource
	 * which contains the model
	 */
	public DwprofileDamagerRepairer(ITokenScanner tokenScanner, de.darwinspl.preferences.resource.dwprofile.IDwprofileResourceProvider resourceProvider) {
		super(tokenScanner);
		this.resourceProvider = resourceProvider;
	}
	
}
