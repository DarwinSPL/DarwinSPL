/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;


/**
 * This class contains some constants that are used during code completion.
 */
public class HydatavalueExpectationConstants {
	
	public final static int EXPECTATIONS[][] = new int[61][];
	
	public static int index;
	
	public static void initialize0() {
		index = 0;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue();
		EXPECTATIONS[index][1] = getValue();
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1);
		EXPECTATIONS[index][1] = getValue();
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,1);
		EXPECTATIONS[index][1] = getValue();
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1);
		EXPECTATIONS[index][1] = getValue();
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,1);
		EXPECTATIONS[index][1] = getValue();
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,0,1);
		EXPECTATIONS[index][1] = getValue(1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,1,1);
		EXPECTATIONS[index][1] = getValue(0,1);
		index++;
		EXPECTATIONS[index] = new int[3];
		EXPECTATIONS[index][0] = getValue(0,0,1);
		EXPECTATIONS[index][1] = getValue(1,1);
		EXPECTATIONS[index][2] = getValue();
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,1);
		EXPECTATIONS[index][1] = getValue(1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,0,1);
		EXPECTATIONS[index][1] = getValue(0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,1);
		EXPECTATIONS[index][1] = getValue(0,0,1);
		index++;
		EXPECTATIONS[index] = new int[3];
		EXPECTATIONS[index][0] = getValue(0,0,1);
		EXPECTATIONS[index][1] = getValue(1,0,1);
		EXPECTATIONS[index][2] = getValue();
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,0,1);
		EXPECTATIONS[index][1] = getValue(0,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,1);
		EXPECTATIONS[index][1] = getValue(0,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,0,1);
		EXPECTATIONS[index][1] = getValue(1,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,1);
		EXPECTATIONS[index][1] = getValue(1,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,1);
		EXPECTATIONS[index][1] = getValue(0,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,0,0,1);
		EXPECTATIONS[index][1] = getValue(1,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,1,0,1);
		EXPECTATIONS[index][1] = getValue(0,1,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,0,1);
		EXPECTATIONS[index][1] = getValue(0,1,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,1,1);
		EXPECTATIONS[index][1] = getValue(0,1,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,0,1,1);
		EXPECTATIONS[index][1] = getValue(1,1,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,1,1,1);
		EXPECTATIONS[index][1] = getValue(0,0,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,1,1);
		EXPECTATIONS[index][1] = getValue(1,0,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,0,0,1);
		EXPECTATIONS[index][1] = getValue(0,1,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,1,1);
		EXPECTATIONS[index][1] = getValue(1,1,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,0,0,0,1);
		EXPECTATIONS[index][1] = getValue(0,0,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,1,0,0,1);
		EXPECTATIONS[index][1] = getValue(1,0,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,1,1);
		EXPECTATIONS[index][1] = getValue(0,1,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,1,1);
		EXPECTATIONS[index][1] = getValue(1,1,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,0,0,1);
		EXPECTATIONS[index][1] = getValue(0,1,1,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,1,0,1);
		EXPECTATIONS[index][1] = getValue(1,1,1,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,0,1,0,1);
		EXPECTATIONS[index][1] = getValue(0,0,0,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,1,1,0,1);
		EXPECTATIONS[index][1] = getValue(1,0,0,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,1,0,1);
		EXPECTATIONS[index][1] = getValue(0,1,0,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,0,1);
		EXPECTATIONS[index][1] = getValue(0,1,0,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,1);
		EXPECTATIONS[index][1] = getValue(0,1,0,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,0,1,1);
		EXPECTATIONS[index][1] = getValue(1,1,0,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,0,0,1,1);
		EXPECTATIONS[index][1] = getValue(1,1,0,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,1,0,1,1);
		EXPECTATIONS[index][1] = getValue(1,1,0,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,0,1,1);
		EXPECTATIONS[index][1] = getValue(0,0,1,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,1,1,1);
		EXPECTATIONS[index][1] = getValue(1,0,1,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,0,1,1,1);
		EXPECTATIONS[index][1] = getValue(0,1,1,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,1,1,1,1);
		EXPECTATIONS[index][1] = getValue(1,1,1,1,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,1,1,1);
		EXPECTATIONS[index][1] = getValue(0,0,0,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,0,1,1,1);
		EXPECTATIONS[index][1] = getValue(1,0,0,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,0,0,0,1);
		EXPECTATIONS[index][1] = getValue(0,1,0,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,0,0,0,0,1);
		EXPECTATIONS[index][1] = getValue(1,1,0,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,0,1,1,1);
		EXPECTATIONS[index][1] = getValue(0,0,1,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,0,1,1,1);
		EXPECTATIONS[index][1] = getValue(1,0,1,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,0,1);
		EXPECTATIONS[index][1] = getValue(0,1,1,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,1);
		EXPECTATIONS[index][1] = getValue(0,1,1,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,0,1);
		EXPECTATIONS[index][1] = getValue(1,1,1,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,1);
		EXPECTATIONS[index][1] = getValue(1,1,1,0,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,1,0,0,0,1);
		EXPECTATIONS[index][1] = getValue(0,1,0,1,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,1,0,0,0,1);
		EXPECTATIONS[index][1] = getValue(0,1,0,1,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,1,0,0,1);
		EXPECTATIONS[index][1] = getValue(1,1,0,1,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,1,0,0,1);
		EXPECTATIONS[index][1] = getValue(0,0,1,1,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,0,1,0,0,1);
		EXPECTATIONS[index][1] = getValue(1,0,1,1,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(1,0,1,0,0,1);
		EXPECTATIONS[index][1] = getValue(0,1,1,1,0,1);
		index++;
		EXPECTATIONS[index] = new int[2];
		EXPECTATIONS[index][0] = getValue(0,1,1,0,0,1);
		EXPECTATIONS[index][1] = getValue(0,1,1,1,0,1);
		index++;
	}
	
	public static void initialize() {
		initialize0();
	}
	
	static {
		initialize();
	}
	
	private static int getValue(int... bits) {
		int value = 0;
		int multiplier = 1;
		for (int i = 0; i < bits.length; i++) {
			value = value + bits[i] * multiplier;
			multiplier = multiplier * 2;
		}
		return value;
	}
	
}
