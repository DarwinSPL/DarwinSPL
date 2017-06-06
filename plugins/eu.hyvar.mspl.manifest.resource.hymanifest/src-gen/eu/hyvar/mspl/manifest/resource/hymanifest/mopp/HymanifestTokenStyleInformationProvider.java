/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;


public class HymanifestTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("SL_COMMENT".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, false, false, false);
		}
		if ("ML_COMMENT".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, false, false, false);
		}
		if ("Implementation".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("Signature".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if (":".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("->".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("[".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x00, 0x00, 0xCC}, null, false, false, false, false);
		}
		if ("]".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x00, 0x00, 0xCC}, null, false, false, false, false);
		}
		if ("(".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x00, 0x00, 0xCC}, null, false, false, false, false);
		}
		if (")".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x00, 0x00, 0xCC}, null, false, false, false, false);
		}
		if ("true".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("false".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("enum:".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("eternity".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		if ("Signature ".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Implementation ".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("QUOTED_60_62".equals(tokenName)) {
			return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		return null;
	}
	
}
