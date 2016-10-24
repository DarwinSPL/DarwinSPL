/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import org.antlr.runtime3_4_0.RecognitionException;

/**
 * <p>
 * An Excpetion to represent invalid content types for parser instances.
 * </p>
 * 
 * @see
 * eu.hyvar.feature.mapping.resource.hymapping.IHymappingOptions.RESOURCE_CONTENT_T
 * YPE
 */
public class HymappingUnexpectedContentTypeException extends RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  HymappingUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
