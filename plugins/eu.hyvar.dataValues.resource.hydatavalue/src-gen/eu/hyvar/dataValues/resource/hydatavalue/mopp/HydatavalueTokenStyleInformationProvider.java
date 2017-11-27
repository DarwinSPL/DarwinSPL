/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;


public class HydatavalueTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("true".equals(tokenName)) {
			return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("false".equals(tokenName)) {
			return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("enum:".equals(tokenName)) {
			return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("eternity".equals(tokenName)) {
			return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("ML_COMMENT".equals(tokenName)) {
			return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTokenStyle(new int[] {0x3F, 0x80, 0x5D}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
