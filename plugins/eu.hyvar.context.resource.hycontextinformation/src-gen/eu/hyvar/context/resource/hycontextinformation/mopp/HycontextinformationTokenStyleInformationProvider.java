/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;


public class HycontextinformationTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("true".equals(tokenName)) {
			return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("false".equals(tokenName)) {
			return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("enum:".equals(tokenName)) {
			return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("eternity".equals(tokenName)) {
			return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("ML_COMMENT".equals(tokenName)) {
			return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTokenStyle(new int[] {0x3F, 0x80, 0x5D}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
