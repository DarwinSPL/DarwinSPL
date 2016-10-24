/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.grammar;


public class HydatavalueWhiteSpace extends eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueFormattingElement {
	
	private final int amount;
	
	public HydatavalueWhiteSpace(int amount, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
