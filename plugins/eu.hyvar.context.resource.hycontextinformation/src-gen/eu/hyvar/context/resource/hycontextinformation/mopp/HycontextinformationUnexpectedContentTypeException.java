/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import org.antlr.runtime3_4_0.RecognitionException;

/**
 * <p>
 * An Excpetion to represent invalid content types for parser instances.
 * </p>
 * 
 * @see
 * eu.hyvar.context.resource.hycontextinformation.IHycontextinformationOptions.RESO
 * URCE_CONTENT_TYPE
 */
public class HycontextinformationUnexpectedContentTypeException extends RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  HycontextinformationUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
