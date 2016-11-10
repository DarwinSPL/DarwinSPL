/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;


public class HyconstraintsTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("SL_COMMENT".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, false, false, false);
		}
		if ("ML_COMMENT".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, false, false, false);
		}
		if ("<->".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("->".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("||".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("&&".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("!".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("/".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("*".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("\\u0025".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("+".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("-".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("?".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("<".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("<=".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("=".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if (">".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if (">=".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("[".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x00, 0x00, 0xCC}, null, false, false, false, false);
		}
		if ("]".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x00, 0x00, 0xCC}, null, false, false, false, false);
		}
		if ("(".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x00, 0x00, 0xCC}, null, false, false, false, false);
		}
		if (")".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x00, 0x00, 0xCC}, null, false, false, false, false);
		}
		if ("true".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("false".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("enum:".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("eternity".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		if ("context:".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		return null;
	}
	
}
