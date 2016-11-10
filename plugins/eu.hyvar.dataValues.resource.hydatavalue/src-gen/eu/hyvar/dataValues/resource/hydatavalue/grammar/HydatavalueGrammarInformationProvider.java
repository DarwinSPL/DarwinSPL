/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.grammar;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class HydatavalueGrammarInformationProvider {
	
	public final static EStructuralFeature ANONYMOUS_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static HydatavalueGrammarInformationProvider INSTANCE = new HydatavalueGrammarInformationProvider();
	
	private Set<String> keywords;
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder HYDATAVALUE_0_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder getHYDATAVALUE_0_0_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_NUMBER_VALUE__VALUE), "INTEGER_LITERAL", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence HYDATAVALUE_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence getHYDATAVALUE_0_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_0_0_0_0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice HYDATAVALUE_0_0 = INSTANCE.getHYDATAVALUE_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice getHYDATAVALUE_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_0_0_0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule HYDATAVALUE_0 = INSTANCE.getHYDATAVALUE_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule getHYDATAVALUE_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue(), HYDATAVALUE_0_0, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueBooleanTerminal HYDATAVALUE_1_0_0_0 = INSTANCE.getHYDATAVALUE_1_0_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueBooleanTerminal getHYDATAVALUE_1_0_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueBooleanTerminal(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), "true", "false", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence HYDATAVALUE_1_0_0 = INSTANCE.getHYDATAVALUE_1_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence getHYDATAVALUE_1_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_1_0_0_0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice HYDATAVALUE_1_0 = INSTANCE.getHYDATAVALUE_1_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice getHYDATAVALUE_1_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_1_0_0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule HYDATAVALUE_1 = INSTANCE.getHYDATAVALUE_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule getHYDATAVALUE_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue(), HYDATAVALUE_1_0, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_2_0_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_2_0_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("enum:", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder HYDATAVALUE_2_0_0_1 = INSTANCE.getHYDATAVALUE_2_0_0_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder getHYDATAVALUE_2_0_0_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), "IDENTIFIER_TOKEN", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_2_0_0_2 = INSTANCE.getHYDATAVALUE_2_0_0_2();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_2_0_0_2() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword(".", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder HYDATAVALUE_2_0_0_3 = INSTANCE.getHYDATAVALUE_2_0_0_3();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder getHYDATAVALUE_2_0_0_3() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), "IDENTIFIER_TOKEN", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence HYDATAVALUE_2_0_0 = INSTANCE.getHYDATAVALUE_2_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence getHYDATAVALUE_2_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_2_0_0_0, HYDATAVALUE_2_0_0_1, HYDATAVALUE_2_0_0_2, HYDATAVALUE_2_0_0_3);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice HYDATAVALUE_2_0 = INSTANCE.getHYDATAVALUE_2_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice getHYDATAVALUE_2_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_2_0_0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule HYDATAVALUE_2 = INSTANCE.getHYDATAVALUE_2();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule getHYDATAVALUE_2() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue(), HYDATAVALUE_2_0, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_3_0_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("Enum(", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder HYDATAVALUE_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder getHYDATAVALUE_3_0_0_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__NAME), "IDENTIFIER_TOKEN", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_3_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_2();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_3_0_0_2() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword(",", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueContainment HYDATAVALUE_3_0_0_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueContainment getHYDATAVALUE_3_0_0_3_0_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_3_0_0_3_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword(",", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueContainment HYDATAVALUE_3_0_0_3_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueContainment getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence HYDATAVALUE_3_0_0_3_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence getHYDATAVALUE_3_0_0_3_0_0_1_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1_0_0_1);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice HYDATAVALUE_3_0_0_3_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice getHYDATAVALUE_3_0_0_3_0_0_1_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound HYDATAVALUE_3_0_0_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound getHYDATAVALUE_3_0_0_3_0_0_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound(HYDATAVALUE_3_0_0_3_0_0_1_0, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.STAR);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence HYDATAVALUE_3_0_0_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence getHYDATAVALUE_3_0_0_3_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice HYDATAVALUE_3_0_0_3_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice getHYDATAVALUE_3_0_0_3_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound HYDATAVALUE_3_0_0_3 = INSTANCE.getHYDATAVALUE_3_0_0_3();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound getHYDATAVALUE_3_0_0_3() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound(HYDATAVALUE_3_0_0_3_0, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_3_0_0_4 = INSTANCE.getHYDATAVALUE_3_0_0_4();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_3_0_0_4() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword(")", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_3_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_3_0_0_5_0_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("[", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("-", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence HYDATAVALUE_3_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("-", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_1_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_2();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_1_2() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("eternity", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence HYDATAVALUE_3_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, HYDATAVALUE_3_0_0_5_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("eternity", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("-", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence HYDATAVALUE_3_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice HYDATAVALUE_3_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice getHYDATAVALUE_3_0_0_5_0_0_1_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound HYDATAVALUE_3_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound getHYDATAVALUE_3_0_0_5_0_0_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound(HYDATAVALUE_3_0_0_5_0_0_1_0, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_3_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_2();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_3_0_0_5_0_0_2() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("]", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence HYDATAVALUE_3_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence getHYDATAVALUE_3_0_0_5_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1, HYDATAVALUE_3_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice HYDATAVALUE_3_0_0_5_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice getHYDATAVALUE_3_0_0_5_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound HYDATAVALUE_3_0_0_5 = INSTANCE.getHYDATAVALUE_3_0_0_5();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound getHYDATAVALUE_3_0_0_5() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound(HYDATAVALUE_3_0_0_5_0, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence HYDATAVALUE_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence getHYDATAVALUE_3_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_3_0_0_0, HYDATAVALUE_3_0_0_1, HYDATAVALUE_3_0_0_2, HYDATAVALUE_3_0_0_3, HYDATAVALUE_3_0_0_4, HYDATAVALUE_3_0_0_5);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice HYDATAVALUE_3_0 = INSTANCE.getHYDATAVALUE_3_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice getHYDATAVALUE_3_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_3_0_0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule HYDATAVALUE_3 = INSTANCE.getHYDATAVALUE_3();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule getHYDATAVALUE_3() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), HYDATAVALUE_3_0, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_4_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_4_0_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("EnumLiteral(", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder HYDATAVALUE_4_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder getHYDATAVALUE_4_0_0_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__NAME), "IDENTIFIER_TOKEN", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_4_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_2();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_4_0_0_2() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword(",", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder HYDATAVALUE_4_0_0_3 = INSTANCE.getHYDATAVALUE_4_0_0_3();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder getHYDATAVALUE_4_0_0_3() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALUE), "INTEGER_LITERAL", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_4_0_0_4 = INSTANCE.getHYDATAVALUE_4_0_0_4();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_4_0_0_4() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword(")", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_4_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_4_0_0_5_0_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("[", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("-", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence HYDATAVALUE_4_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("-", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("eternity", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence HYDATAVALUE_4_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, HYDATAVALUE_4_0_0_5_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("eternity", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("-", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavaluePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence HYDATAVALUE_4_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice HYDATAVALUE_4_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice getHYDATAVALUE_4_0_0_5_0_0_1_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound HYDATAVALUE_4_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound getHYDATAVALUE_4_0_0_5_0_0_1() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound(HYDATAVALUE_4_0_0_5_0_0_1_0, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword HYDATAVALUE_4_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_2();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword getHYDATAVALUE_4_0_0_5_0_0_2() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword("]", eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence HYDATAVALUE_4_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence getHYDATAVALUE_4_0_0_5_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1, HYDATAVALUE_4_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice HYDATAVALUE_4_0_0_5_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice getHYDATAVALUE_4_0_0_5_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound HYDATAVALUE_4_0_0_5 = INSTANCE.getHYDATAVALUE_4_0_0_5();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound getHYDATAVALUE_4_0_0_5() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCompound(HYDATAVALUE_4_0_0_5_0, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence HYDATAVALUE_4_0_0 = INSTANCE.getHYDATAVALUE_4_0_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence getHYDATAVALUE_4_0_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSequence(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_4_0_0_0, HYDATAVALUE_4_0_0_1, HYDATAVALUE_4_0_0_2, HYDATAVALUE_4_0_0_3, HYDATAVALUE_4_0_0_4, HYDATAVALUE_4_0_0_5);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice HYDATAVALUE_4_0 = INSTANCE.getHYDATAVALUE_4_0();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice getHYDATAVALUE_4_0() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueChoice(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE, HYDATAVALUE_4_0_0);
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule HYDATAVALUE_4 = INSTANCE.getHYDATAVALUE_4();
	private eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule getHYDATAVALUE_4() {
		return new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), HYDATAVALUE_4_0, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueCardinality.ONE);
	}
	
	
	public static String getSyntaxElementID(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (Field field : eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.class.getFields()) {
			Object fieldValue;
			try {
				fieldValue = field.get(null);
				if (fieldValue == syntaxElement) {
					String id = field.getName();
					return id;
				}
			} catch (Exception e) { }
		}
		return null;
	}
	
	public static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement) eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule[] RULES = new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule[] {
		HYDATAVALUE_0,
		HYDATAVALUE_1,
		HYDATAVALUE_2,
		HYDATAVALUE_3,
		HYDATAVALUE_4,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new LinkedHashSet<String>();
			for (eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement element, Set<String> keywords) {
		if (element instanceof eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword) {
			keywords.add(((eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueKeyword) element).getValue());
		} else if (element instanceof eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueBooleanTerminal) {
			keywords.add(((eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueBooleanTerminal) element).getTrueLiteral());
			keywords.add(((eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueEnumerationTerminal) {
			eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueEnumerationTerminal terminal = (eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
