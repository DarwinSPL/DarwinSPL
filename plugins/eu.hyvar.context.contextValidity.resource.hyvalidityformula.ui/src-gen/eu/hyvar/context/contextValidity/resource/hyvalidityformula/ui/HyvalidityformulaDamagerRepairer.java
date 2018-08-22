/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui;

import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.ITokenScanner;

/**
 * This class subclasses the {@link DefaultDamagerRepairer} and modifies of a
 * damage region to not damage only the line where the modification event
 * occurred.It damages the whole region of the model element which corresponds to
 * the offset at which the modification event occurred.
 */
public class HyvalidityformulaDamagerRepairer extends DefaultDamagerRepairer {
	
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaResourceProvider resourceProvider;
	
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
	public HyvalidityformulaDamagerRepairer(ITokenScanner tokenScanner, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaResourceProvider resourceProvider) {
		super(tokenScanner);
		this.resourceProvider = resourceProvider;
	}
	
}
