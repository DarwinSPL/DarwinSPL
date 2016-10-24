/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;

import org.antlr.runtime3_4_0.RecognitionException;

/**
 * <p>
 * An Excpetion to represent invalid content types for parser instances.
 * </p>
 * 
 * @see
 * eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionOptions.RESOURCE_
 * CONTENT_TYPE
 */
public class HyexpressionUnexpectedContentTypeException extends RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  HyexpressionUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
