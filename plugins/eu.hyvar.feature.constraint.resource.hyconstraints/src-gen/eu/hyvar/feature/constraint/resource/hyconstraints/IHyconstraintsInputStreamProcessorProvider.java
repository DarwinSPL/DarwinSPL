/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints;

import java.io.InputStream;

/**
 * Implementors of this interface can provide InputStreamProcessors. These
 * processors can be used to pre-process input stream before a text resource is
 * actually lexed and parsed. This can be for example useful to do an encoding
 * conversion.
 */
public interface IHyconstraintsInputStreamProcessorProvider {
	
	/**
	 * <p>
	 * Returns a processor for the given input stream.
	 * </p>
	 * 
	 * @param inputStream the actual stream that provides the content of a resource
	 * 
	 * @return a processor that pre-processes the input stream
	 */
	public eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsInputStreamProcessor getInputStreamProcessor(InputStream inputStream);
}
