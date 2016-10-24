/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import org.antlr.runtime3_4_0.RecognitionException;

/**
 * <p>
 * An Excpetion to represent invalid content types for parser instances.
 * </p>
 * 
 * @see
 * eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsOptions.RESOURC
 * E_CONTENT_TYPE
 */
public class HyconstraintsUnexpectedContentTypeException extends RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  HyconstraintsUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
