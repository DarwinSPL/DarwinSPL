/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.grammar;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class HymappingGrammarInformationProvider {
	
	public final static EStructuralFeature ANONYMOUS_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static HymappingGrammarInformationProvider INSTANCE = new HymappingGrammarInformationProvider();
	
	private Set<String> keywords;
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYMAPPING_0_0_0_0_0_0_0 = INSTANCE.getHYMAPPING_0_0_0_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYMAPPING_0_0_0_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING_MODEL__MAPPINGS), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingLineBreak HYMAPPING_0_0_0_0_0_0_1_0_0_0 = INSTANCE.getHYMAPPING_0_0_0_0_0_0_1_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingLineBreak getHYMAPPING_0_0_0_0_0_0_1_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingLineBreak(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingLineBreak HYMAPPING_0_0_0_0_0_0_1_0_0_1 = INSTANCE.getHYMAPPING_0_0_0_0_0_0_1_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingLineBreak getHYMAPPING_0_0_0_0_0_0_1_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingLineBreak(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYMAPPING_0_0_0_0_0_0_1_0_0_2 = INSTANCE.getHYMAPPING_0_0_0_0_0_0_1_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYMAPPING_0_0_0_0_0_0_1_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING_MODEL__MAPPINGS), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYMAPPING_0_0_0_0_0_0_1_0_0 = INSTANCE.getHYMAPPING_0_0_0_0_0_0_1_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYMAPPING_0_0_0_0_0_0_1_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_0_0_0_0_0_0_1_0_0_0, HYMAPPING_0_0_0_0_0_0_1_0_0_1, HYMAPPING_0_0_0_0_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYMAPPING_0_0_0_0_0_0_1_0 = INSTANCE.getHYMAPPING_0_0_0_0_0_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYMAPPING_0_0_0_0_0_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_0_0_0_0_0_0_1_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYMAPPING_0_0_0_0_0_0_1 = INSTANCE.getHYMAPPING_0_0_0_0_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYMAPPING_0_0_0_0_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYMAPPING_0_0_0_0_0_0_1_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.STAR);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYMAPPING_0_0_0_0_0_0 = INSTANCE.getHYMAPPING_0_0_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYMAPPING_0_0_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_0_0_0_0_0_0_0, HYMAPPING_0_0_0_0_0_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYMAPPING_0_0_0_0_0 = INSTANCE.getHYMAPPING_0_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYMAPPING_0_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_0_0_0_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYMAPPING_0_0_0_0 = INSTANCE.getHYMAPPING_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYMAPPING_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYMAPPING_0_0_0_0_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYMAPPING_0_0_0 = INSTANCE.getHYMAPPING_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYMAPPING_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_0_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYMAPPING_0_0 = INSTANCE.getHYMAPPING_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYMAPPING_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_0_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyMappingModel
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYMAPPING_0 = INSTANCE.getHYMAPPING_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYMAPPING_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), HYMAPPING_0_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYMAPPING_1_0_0_0 = INSTANCE.getHYMAPPING_1_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYMAPPING_1_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(org.deltaecore.core.decore.DEcorePackage.eINSTANCE.getDEDeltaInvokation().getEStructuralFeature(org.deltaecore.core.decore.DEcorePackage.DE_DELTA_INVOKATION__DELTA), "QUOTED_6060_6262", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYMAPPING_1_0_0 = INSTANCE.getHYMAPPING_1_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYMAPPING_1_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYMAPPING_1_0 = INSTANCE.getHYMAPPING_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYMAPPING_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_1_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * DEDeltaInvokation
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYMAPPING_1 = INSTANCE.getHYMAPPING_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYMAPPING_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(org.deltaecore.core.decore.DEcorePackage.eINSTANCE.getDEDeltaInvokation(), HYMAPPING_1_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYMAPPING_2_0_0_0 = INSTANCE.getHYMAPPING_2_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYMAPPING_2_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__EXPRESSION), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingWhiteSpace HYMAPPING_2_0_0_1 = INSTANCE.getHYMAPPING_2_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingWhiteSpace getHYMAPPING_2_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingWhiteSpace(1, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYMAPPING_2_0_0_2 = INSTANCE.getHYMAPPING_2_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYMAPPING_2_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(":", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingLineBreak HYMAPPING_2_0_0_3 = INSTANCE.getHYMAPPING_2_0_0_3();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingLineBreak getHYMAPPING_2_0_0_3() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingLineBreak(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYMAPPING_2_0_0_4 = INSTANCE.getHYMAPPING_2_0_0_4();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYMAPPING_2_0_0_4() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__DELTA_INVOKATIONS), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {org.deltaecore.core.decore.DEcorePackage.eINSTANCE.getDEDeltaInvokation(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYMAPPING_2_0_0_5_0_0_0 = INSTANCE.getHYMAPPING_2_0_0_5_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYMAPPING_2_0_0_5_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(",", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingLineBreak HYMAPPING_2_0_0_5_0_0_1 = INSTANCE.getHYMAPPING_2_0_0_5_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingLineBreak getHYMAPPING_2_0_0_5_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingLineBreak(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYMAPPING_2_0_0_5_0_0_2 = INSTANCE.getHYMAPPING_2_0_0_5_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYMAPPING_2_0_0_5_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__DELTA_INVOKATIONS), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {org.deltaecore.core.decore.DEcorePackage.eINSTANCE.getDEDeltaInvokation(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYMAPPING_2_0_0_5_0_0 = INSTANCE.getHYMAPPING_2_0_0_5_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYMAPPING_2_0_0_5_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_2_0_0_5_0_0_0, HYMAPPING_2_0_0_5_0_0_1, HYMAPPING_2_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYMAPPING_2_0_0_5_0 = INSTANCE.getHYMAPPING_2_0_0_5_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYMAPPING_2_0_0_5_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_2_0_0_5_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYMAPPING_2_0_0_5 = INSTANCE.getHYMAPPING_2_0_0_5();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYMAPPING_2_0_0_5() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYMAPPING_2_0_0_5_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.STAR);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYMAPPING_2_0_0_6_0_0_0 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYMAPPING_2_0_0_6_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("[", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYMAPPING_2_0_0_6_0_0_1_0_0_0 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_1_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYMAPPING_2_0_0_6_0_0_1_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__VALID_SINCE), "DATE", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYMAPPING_2_0_0_6_0_0_1_0_0_1 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_1_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYMAPPING_2_0_0_6_0_0_1_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("-", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYMAPPING_2_0_0_6_0_0_1_0_0_2 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_1_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYMAPPING_2_0_0_6_0_0_1_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__VALID_UNTIL), "DATE", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYMAPPING_2_0_0_6_0_0_1_0_0 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_1_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYMAPPING_2_0_0_6_0_0_1_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_2_0_0_6_0_0_1_0_0_0, HYMAPPING_2_0_0_6_0_0_1_0_0_1, HYMAPPING_2_0_0_6_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYMAPPING_2_0_0_6_0_0_1_0_1_0 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_1_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYMAPPING_2_0_0_6_0_0_1_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__VALID_SINCE), "DATE", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYMAPPING_2_0_0_6_0_0_1_0_1_1 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_1_0_1_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYMAPPING_2_0_0_6_0_0_1_0_1_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("-", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYMAPPING_2_0_0_6_0_0_1_0_1_2 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_1_0_1_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYMAPPING_2_0_0_6_0_0_1_0_1_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("eternity", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYMAPPING_2_0_0_6_0_0_1_0_1 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_1_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYMAPPING_2_0_0_6_0_0_1_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_2_0_0_6_0_0_1_0_1_0, HYMAPPING_2_0_0_6_0_0_1_0_1_1, HYMAPPING_2_0_0_6_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYMAPPING_2_0_0_6_0_0_1_0_2_0 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_1_0_2_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYMAPPING_2_0_0_6_0_0_1_0_2_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("eternity", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYMAPPING_2_0_0_6_0_0_1_0_2_1 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_1_0_2_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYMAPPING_2_0_0_6_0_0_1_0_2_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("-", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYMAPPING_2_0_0_6_0_0_1_0_2_2 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_1_0_2_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYMAPPING_2_0_0_6_0_0_1_0_2_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__VALID_UNTIL), "DATE", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYMAPPING_2_0_0_6_0_0_1_0_2 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_1_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYMAPPING_2_0_0_6_0_0_1_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_2_0_0_6_0_0_1_0_2_0, HYMAPPING_2_0_0_6_0_0_1_0_2_1, HYMAPPING_2_0_0_6_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYMAPPING_2_0_0_6_0_0_1_0 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYMAPPING_2_0_0_6_0_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_2_0_0_6_0_0_1_0_0, HYMAPPING_2_0_0_6_0_0_1_0_1, HYMAPPING_2_0_0_6_0_0_1_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYMAPPING_2_0_0_6_0_0_1 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYMAPPING_2_0_0_6_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYMAPPING_2_0_0_6_0_0_1_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYMAPPING_2_0_0_6_0_0_2 = INSTANCE.getHYMAPPING_2_0_0_6_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYMAPPING_2_0_0_6_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("]", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYMAPPING_2_0_0_6_0_0 = INSTANCE.getHYMAPPING_2_0_0_6_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYMAPPING_2_0_0_6_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_2_0_0_6_0_0_0, HYMAPPING_2_0_0_6_0_0_1, HYMAPPING_2_0_0_6_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYMAPPING_2_0_0_6_0 = INSTANCE.getHYMAPPING_2_0_0_6_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYMAPPING_2_0_0_6_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_2_0_0_6_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYMAPPING_2_0_0_6 = INSTANCE.getHYMAPPING_2_0_0_6();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYMAPPING_2_0_0_6() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYMAPPING_2_0_0_6_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYMAPPING_2_0_0 = INSTANCE.getHYMAPPING_2_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYMAPPING_2_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_2_0_0_0, HYMAPPING_2_0_0_1, HYMAPPING_2_0_0_2, HYMAPPING_2_0_0_3, HYMAPPING_2_0_0_4, HYMAPPING_2_0_0_5, HYMAPPING_2_0_0_6);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYMAPPING_2_0 = INSTANCE.getHYMAPPING_2_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYMAPPING_2_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYMAPPING_2_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class HyMapping
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYMAPPING_2 = INSTANCE.getHYMAPPING_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYMAPPING_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping(), HYMAPPING_2_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_0_0_0_0 = INSTANCE.getHYEXPRESSION_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_0_0_0_1 = INSTANCE.getHYEXPRESSION_0_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_0_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("<->", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_0_0_0_2 = INSTANCE.getHYEXPRESSION_0_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_0_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_0_0_0 = INSTANCE.getHYEXPRESSION_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_0_0_0_0, HYEXPRESSION_0_0_0_1, HYEXPRESSION_0_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_0_0 = INSTANCE.getHYEXPRESSION_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_0_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyEquivalenceExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_0 = INSTANCE.getHYEXPRESSION_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), HYEXPRESSION_0_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_1_0_0_0 = INSTANCE.getHYEXPRESSION_1_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_1_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_1_0_0_1 = INSTANCE.getHYEXPRESSION_1_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_1_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("->", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_1_0_0_2 = INSTANCE.getHYEXPRESSION_1_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_1_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_1_0_0 = INSTANCE.getHYEXPRESSION_1_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_1_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_1_0_0_0, HYEXPRESSION_1_0_0_1, HYEXPRESSION_1_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_1_0 = INSTANCE.getHYEXPRESSION_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_1_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyImpliesExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_1 = INSTANCE.getHYEXPRESSION_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), HYEXPRESSION_1_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_2_0_0_0 = INSTANCE.getHYEXPRESSION_2_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_2_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_2_0_0_1 = INSTANCE.getHYEXPRESSION_2_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_2_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("||", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_2_0_0_2 = INSTANCE.getHYEXPRESSION_2_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_2_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_2_0_0 = INSTANCE.getHYEXPRESSION_2_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_2_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_2_0_0_0, HYEXPRESSION_2_0_0_1, HYEXPRESSION_2_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_2_0 = INSTANCE.getHYEXPRESSION_2_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_2_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_2_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyOrExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_2 = INSTANCE.getHYEXPRESSION_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), HYEXPRESSION_2_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_3_0_0_0 = INSTANCE.getHYEXPRESSION_3_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_3_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_3_0_0_1 = INSTANCE.getHYEXPRESSION_3_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_3_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("&&", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_3_0_0_2 = INSTANCE.getHYEXPRESSION_3_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_3_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_3_0_0 = INSTANCE.getHYEXPRESSION_3_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_3_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_3_0_0_0, HYEXPRESSION_3_0_0_1, HYEXPRESSION_3_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_3_0 = INSTANCE.getHYEXPRESSION_3_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_3_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_3_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyAndExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_3 = INSTANCE.getHYEXPRESSION_3();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_3() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), HYEXPRESSION_3_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_4_0_0_0 = INSTANCE.getHYEXPRESSION_4_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_4_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("!", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_4_0_0_1 = INSTANCE.getHYEXPRESSION_4_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_4_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EXPRESSION__OPERAND), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_4_0_0 = INSTANCE.getHYEXPRESSION_4_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_4_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_4_0_0_0, HYEXPRESSION_4_0_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_4_0 = INSTANCE.getHYEXPRESSION_4_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_4_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_4_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyNotExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_4 = INSTANCE.getHYEXPRESSION_4();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_4() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), HYEXPRESSION_4_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_5_0_0_0 = INSTANCE.getHYEXPRESSION_5_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_5_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("(", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_5_0_0_1 = INSTANCE.getHYEXPRESSION_5_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_5_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NESTED_EXPRESSION__OPERAND), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_5_0_0_2 = INSTANCE.getHYEXPRESSION_5_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_5_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(")", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_5_0_0 = INSTANCE.getHYEXPRESSION_5_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_5_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_5_0_0_0, HYEXPRESSION_5_0_0_1, HYEXPRESSION_5_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_5_0 = INSTANCE.getHYEXPRESSION_5_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_5_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_5_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyNestedExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_5 = INSTANCE.getHYEXPRESSION_5();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_5() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), HYEXPRESSION_5_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_6_0_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_6_0_0_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_6_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_6_0_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_6_0_0_0_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_6_0_0_0_0_1_0 = INSTANCE.getHYEXPRESSION_6_0_0_0_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_6_0_0_0_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_6_0_0_0_0_1 = INSTANCE.getHYEXPRESSION_6_0_0_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_6_0_0_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_6_0_0_0_0_1_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_6_0_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_6_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_6_0_0_0_0_0, HYEXPRESSION_6_0_0_0_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYEXPRESSION_6_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYEXPRESSION_6_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYEXPRESSION_6_0_0_0_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_6_0_0_1_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_1_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_6_0_0_1_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRestriction(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_6_0_0_1_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_1_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_6_0_0_1_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_6_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_6_0_0_1_0 = INSTANCE.getHYEXPRESSION_6_0_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_6_0_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_6_0_0_1_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYEXPRESSION_6_0_0_1 = INSTANCE.getHYEXPRESSION_6_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYEXPRESSION_6_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYEXPRESSION_6_0_0_1_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_6_0_0 = INSTANCE.getHYEXPRESSION_6_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_6_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_6_0_0_0, HYEXPRESSION_6_0_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_6_0 = INSTANCE.getHYEXPRESSION_6_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_6_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_6_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyFeatureReferenceExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_6 = INSTANCE.getHYEXPRESSION_6();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_6() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), HYEXPRESSION_6_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_7_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_7_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("?", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_7_0_0_1_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_7_0_0_1_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_7_0_0_1_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_7_0_0_1_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_7_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_7_0_0_1_0_1_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_7_0_0_1_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_7_0_0_1_0_1 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_7_0_0_1_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_7_0_0_1_0_1_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_7_0_0_1_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_7_0_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_7_0_0_1_0_0, HYEXPRESSION_7_0_0_1_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYEXPRESSION_7_0_0_1 = INSTANCE.getHYEXPRESSION_7_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYEXPRESSION_7_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYEXPRESSION_7_0_0_1_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_7_0_0_2 = INSTANCE.getHYEXPRESSION_7_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_7_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRestriction(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_7_0_0 = INSTANCE.getHYEXPRESSION_7_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_7_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_7_0_0_0, HYEXPRESSION_7_0_0_1, HYEXPRESSION_7_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_7_0 = INSTANCE.getHYEXPRESSION_7_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_7_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_7_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyConditionalFeatureReferenceExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_7 = INSTANCE.getHYEXPRESSION_7();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_7() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), HYEXPRESSION_7_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal HYEXPRESSION_8_0_0_0 = INSTANCE.getHYEXPRESSION_8_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal getHYEXPRESSION_8_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyBooleanValueExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), "true", "false", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_8_0_0 = INSTANCE.getHYEXPRESSION_8_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_8_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_8_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_8_0 = INSTANCE.getHYEXPRESSION_8_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_8_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_8_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyBooleanValueExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_8 = INSTANCE.getHYEXPRESSION_8();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_8() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyBooleanValueExpression(), HYEXPRESSION_8_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_9_0_0_0 = INSTANCE.getHYEXPRESSION_9_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_9_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("{", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_9_0_0_1 = INSTANCE.getHYEXPRESSION_9_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_9_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingEnumerationTerminal HYEXPRESSION_9_0_0_2 = INSTANCE.getHYEXPRESSION_9_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingEnumerationTerminal getHYEXPRESSION_9_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingEnumerationTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), new String[] {"HyLessOperator", "<", "HyLessOrEqualOperator", "<=", "HyEqualOperator", "=", "HyNotEqualOperator", "!=", "HyGreaterOrEqualOperator", ">=", "HyGreaterOperator", ">", }, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_9_0_0_3 = INSTANCE.getHYEXPRESSION_9_0_0_3();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_9_0_0_3() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_9_0_0_4 = INSTANCE.getHYEXPRESSION_9_0_0_4();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_9_0_0_4() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("}", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_9_0_0 = INSTANCE.getHYEXPRESSION_9_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_9_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_9_0_0_0, HYEXPRESSION_9_0_0_1, HYEXPRESSION_9_0_0_2, HYEXPRESSION_9_0_0_3, HYEXPRESSION_9_0_0_4);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_9_0 = INSTANCE.getHYEXPRESSION_9_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_9_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_9_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyArithmeticalComparisonExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_9 = INSTANCE.getHYEXPRESSION_9();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_9() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(), HYEXPRESSION_9_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_10_0_0_0 = INSTANCE.getHYEXPRESSION_10_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_10_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_10_0_0_1 = INSTANCE.getHYEXPRESSION_10_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_10_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("+", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_10_0_0_2 = INSTANCE.getHYEXPRESSION_10_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_10_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_10_0_0 = INSTANCE.getHYEXPRESSION_10_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_10_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_10_0_0_0, HYEXPRESSION_10_0_0_1, HYEXPRESSION_10_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_10_0 = INSTANCE.getHYEXPRESSION_10_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_10_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_10_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyAdditionExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_10 = INSTANCE.getHYEXPRESSION_10();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_10() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), HYEXPRESSION_10_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_11_0_0_0 = INSTANCE.getHYEXPRESSION_11_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_11_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_11_0_0_1 = INSTANCE.getHYEXPRESSION_11_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_11_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("-", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_11_0_0_2 = INSTANCE.getHYEXPRESSION_11_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_11_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_11_0_0 = INSTANCE.getHYEXPRESSION_11_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_11_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_11_0_0_0, HYEXPRESSION_11_0_0_1, HYEXPRESSION_11_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_11_0 = INSTANCE.getHYEXPRESSION_11_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_11_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_11_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HySubtractionExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_11 = INSTANCE.getHYEXPRESSION_11();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_11() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), HYEXPRESSION_11_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_12_0_0_0 = INSTANCE.getHYEXPRESSION_12_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_12_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_12_0_0_1 = INSTANCE.getHYEXPRESSION_12_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_12_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("%", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_12_0_0_2 = INSTANCE.getHYEXPRESSION_12_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_12_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_12_0_0 = INSTANCE.getHYEXPRESSION_12_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_12_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_12_0_0_0, HYEXPRESSION_12_0_0_1, HYEXPRESSION_12_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_12_0 = INSTANCE.getHYEXPRESSION_12_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_12_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_12_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyModuloExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_12 = INSTANCE.getHYEXPRESSION_12();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_12() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), HYEXPRESSION_12_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_13_0_0_0 = INSTANCE.getHYEXPRESSION_13_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_13_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_13_0_0_1 = INSTANCE.getHYEXPRESSION_13_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_13_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("*", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_13_0_0_2 = INSTANCE.getHYEXPRESSION_13_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_13_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_13_0_0 = INSTANCE.getHYEXPRESSION_13_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_13_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_13_0_0_0, HYEXPRESSION_13_0_0_1, HYEXPRESSION_13_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_13_0 = INSTANCE.getHYEXPRESSION_13_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_13_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_13_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyMultiplicationExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_13 = INSTANCE.getHYEXPRESSION_13();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_13() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), HYEXPRESSION_13_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_14_0_0_0 = INSTANCE.getHYEXPRESSION_14_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_14_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_14_0_0_1 = INSTANCE.getHYEXPRESSION_14_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_14_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("/", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_14_0_0_2 = INSTANCE.getHYEXPRESSION_14_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_14_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_14_0_0 = INSTANCE.getHYEXPRESSION_14_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_14_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_14_0_0_0, HYEXPRESSION_14_0_0_1, HYEXPRESSION_14_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_14_0 = INSTANCE.getHYEXPRESSION_14_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_14_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_14_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyDivisionExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_14 = INSTANCE.getHYEXPRESSION_14();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_14() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), HYEXPRESSION_14_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_15_0_0_0 = INSTANCE.getHYEXPRESSION_15_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_15_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("-", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_15_0_0_1 = INSTANCE.getHYEXPRESSION_15_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_15_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NEGATION_EXPRESSION__OPERAND), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_15_0_0 = INSTANCE.getHYEXPRESSION_15_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_15_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_15_0_0_0, HYEXPRESSION_15_0_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_15_0 = INSTANCE.getHYEXPRESSION_15_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_15_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_15_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyNegationExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_15 = INSTANCE.getHYEXPRESSION_15();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_15() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), HYEXPRESSION_15_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_16_0_0_0 = INSTANCE.getHYEXPRESSION_16_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_16_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("(", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_16_0_0_1 = INSTANCE.getHYEXPRESSION_16_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_16_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedArithmeticalValueExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NESTED_ARITHMETICAL_VALUE_EXPRESSION__OPERAND), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_16_0_0_2 = INSTANCE.getHYEXPRESSION_16_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_16_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(")", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_16_0_0 = INSTANCE.getHYEXPRESSION_16_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_16_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_16_0_0_0, HYEXPRESSION_16_0_0_1, HYEXPRESSION_16_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_16_0 = INSTANCE.getHYEXPRESSION_16_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_16_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_16_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyNestedArithmeticalValueExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_16 = INSTANCE.getHYEXPRESSION_16();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_16() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedArithmeticalValueExpression(), HYEXPRESSION_16_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_17_0_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_17_0_0_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_17_0_0_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_17_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_17_0_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_17_0_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_17_0_0_0_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_17_0_0_0_0_1_0 = INSTANCE.getHYEXPRESSION_17_0_0_0_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_17_0_0_0_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_17_0_0_0_0_1 = INSTANCE.getHYEXPRESSION_17_0_0_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_17_0_0_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_17_0_0_0_0_1_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_17_0_0_0_0 = INSTANCE.getHYEXPRESSION_17_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_17_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_17_0_0_0_0_0, HYEXPRESSION_17_0_0_0_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYEXPRESSION_17_0_0_0 = INSTANCE.getHYEXPRESSION_17_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYEXPRESSION_17_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYEXPRESSION_17_0_0_0_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_17_0_0_1 = INSTANCE.getHYEXPRESSION_17_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_17_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(".", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_17_0_0_2 = INSTANCE.getHYEXPRESSION_17_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_17_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_17_0_0 = INSTANCE.getHYEXPRESSION_17_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_17_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_17_0_0_0, HYEXPRESSION_17_0_0_1, HYEXPRESSION_17_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_17_0 = INSTANCE.getHYEXPRESSION_17_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_17_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_17_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyAttributeReferenceExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_17 = INSTANCE.getHYEXPRESSION_17();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_17() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression(), HYEXPRESSION_17_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_18_0_0_0 = INSTANCE.getHYEXPRESSION_18_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_18_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("context:", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_18_0_0_1_0_0_0 = INSTANCE.getHYEXPRESSION_18_0_0_1_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_18_0_0_1_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), "QUOTED_34_34", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_18_0_0_1_0_0 = INSTANCE.getHYEXPRESSION_18_0_0_1_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_18_0_0_1_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_18_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_18_0_0_1_0_1_0 = INSTANCE.getHYEXPRESSION_18_0_0_1_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_18_0_0_1_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_18_0_0_1_0_1 = INSTANCE.getHYEXPRESSION_18_0_0_1_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_18_0_0_1_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_18_0_0_1_0_1_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_18_0_0_1_0 = INSTANCE.getHYEXPRESSION_18_0_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_18_0_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_18_0_0_1_0_0, HYEXPRESSION_18_0_0_1_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYEXPRESSION_18_0_0_1 = INSTANCE.getHYEXPRESSION_18_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYEXPRESSION_18_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYEXPRESSION_18_0_0_1_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_18_0_0 = INSTANCE.getHYEXPRESSION_18_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_18_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_18_0_0_0, HYEXPRESSION_18_0_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_18_0 = INSTANCE.getHYEXPRESSION_18_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_18_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_18_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyContextInformationReferenceExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_18 = INSTANCE.getHYEXPRESSION_18();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_18() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression(), HYEXPRESSION_18_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_19_0_0_0 = INSTANCE.getHYEXPRESSION_19_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_19_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VALUE_EXPRESSION__VALUE), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyValue(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_19_0_0 = INSTANCE.getHYEXPRESSION_19_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_19_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_19_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_19_0 = INSTANCE.getHYEXPRESSION_19_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_19_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_19_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyValueExpression
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_19 = INSTANCE.getHYEXPRESSION_19();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_19() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression(), HYEXPRESSION_19_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_20_0_0_0 = INSTANCE.getHYEXPRESSION_20_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_20_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("[", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingEnumerationTerminal HYEXPRESSION_20_0_0_1 = INSTANCE.getHYEXPRESSION_20_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingEnumerationTerminal getHYEXPRESSION_20_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingEnumerationTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), new String[] {"lessThan", "<", "lessThanOrEqual", "<=", "equal", "=", "implicitEqual", "", "greaterThanOrEqual", ">=", "greaterThan", ">", }, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_20_0_0_2 = INSTANCE.getHYEXPRESSION_20_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_20_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), "QUOTED_34_34", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_20_0_0_3 = INSTANCE.getHYEXPRESSION_20_0_0_3();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_20_0_0_3() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("]", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_20_0_0 = INSTANCE.getHYEXPRESSION_20_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_20_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_20_0_0_0, HYEXPRESSION_20_0_0_1, HYEXPRESSION_20_0_0_2, HYEXPRESSION_20_0_0_3);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_20_0 = INSTANCE.getHYEXPRESSION_20_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_20_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_20_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyRelativeVersionRestriction
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_20 = INSTANCE.getHYEXPRESSION_20();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_20() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction(), HYEXPRESSION_20_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_21_0_0_0 = INSTANCE.getHYEXPRESSION_21_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_21_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("[", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal HYEXPRESSION_21_0_0_1 = INSTANCE.getHYEXPRESSION_21_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal getHYEXPRESSION_21_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), "", "^", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_21_0_0_2 = INSTANCE.getHYEXPRESSION_21_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_21_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), "QUOTED_34_34", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_21_0_0_3 = INSTANCE.getHYEXPRESSION_21_0_0_3();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_21_0_0_3() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("-", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal HYEXPRESSION_21_0_0_4 = INSTANCE.getHYEXPRESSION_21_0_0_4();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal getHYEXPRESSION_21_0_0_4() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), "", "^", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_21_0_0_5 = INSTANCE.getHYEXPRESSION_21_0_0_5();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_21_0_0_5() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), "QUOTED_34_34", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_21_0_0_6 = INSTANCE.getHYEXPRESSION_21_0_0_6();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_21_0_0_6() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("]", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_21_0_0 = INSTANCE.getHYEXPRESSION_21_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_21_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_21_0_0_0, HYEXPRESSION_21_0_0_1, HYEXPRESSION_21_0_0_2, HYEXPRESSION_21_0_0_3, HYEXPRESSION_21_0_0_4, HYEXPRESSION_21_0_0_5, HYEXPRESSION_21_0_0_6);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_21_0 = INSTANCE.getHYEXPRESSION_21_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_21_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_21_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyVersionRangeRestriction
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_21 = INSTANCE.getHYEXPRESSION_21();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_21() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction(), HYEXPRESSION_21_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_0_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_NUMBER_VALUE__VALUE), "INTEGER_LITERAL", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_0_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYDATAVALUE_0_0 = INSTANCE.getHYDATAVALUE_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYDATAVALUE_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_0_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyNumberValue
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYDATAVALUE_0 = INSTANCE.getHYDATAVALUE_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYDATAVALUE_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue(), HYDATAVALUE_0_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal HYDATAVALUE_1_0_0_0 = INSTANCE.getHYDATAVALUE_1_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal getHYDATAVALUE_1_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), "true", "false", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_1_0_0 = INSTANCE.getHYDATAVALUE_1_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_1_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYDATAVALUE_1_0 = INSTANCE.getHYDATAVALUE_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYDATAVALUE_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_1_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyBooleanValue
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYDATAVALUE_1 = INSTANCE.getHYDATAVALUE_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYDATAVALUE_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue(), HYDATAVALUE_1_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_2_0_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_2_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("enum:", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_2_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_1_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_2_0_0_1_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), "QUOTED_34_34", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_2_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_1_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_2_0_0_1_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_2_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_2_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_2_0_0_1_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_2_0_0_1_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_2_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_2_0_0_1_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_2_0_0_1_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_2_0_0_1_0_1_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYDATAVALUE_2_0_0_1_0 = INSTANCE.getHYDATAVALUE_2_0_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYDATAVALUE_2_0_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_2_0_0_1_0_0, HYDATAVALUE_2_0_0_1_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYDATAVALUE_2_0_0_1 = INSTANCE.getHYDATAVALUE_2_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYDATAVALUE_2_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYDATAVALUE_2_0_0_1_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_2_0_0_2 = INSTANCE.getHYDATAVALUE_2_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_2_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(".", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_2_0_0_3_0_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_3_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_2_0_0_3_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), "QUOTED_34_34", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_2_0_0_3_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_3_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_2_0_0_3_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_2_0_0_3_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_2_0_0_3_0_1_0 = INSTANCE.getHYDATAVALUE_2_0_0_3_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_2_0_0_3_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_2_0_0_3_0_1 = INSTANCE.getHYDATAVALUE_2_0_0_3_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_2_0_0_3_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_2_0_0_3_0_1_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYDATAVALUE_2_0_0_3_0 = INSTANCE.getHYDATAVALUE_2_0_0_3_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYDATAVALUE_2_0_0_3_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_2_0_0_3_0_0, HYDATAVALUE_2_0_0_3_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYDATAVALUE_2_0_0_3 = INSTANCE.getHYDATAVALUE_2_0_0_3();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYDATAVALUE_2_0_0_3() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYDATAVALUE_2_0_0_3_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_2_0_0 = INSTANCE.getHYDATAVALUE_2_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_2_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_2_0_0_0, HYDATAVALUE_2_0_0_1, HYDATAVALUE_2_0_0_2, HYDATAVALUE_2_0_0_3);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYDATAVALUE_2_0 = INSTANCE.getHYDATAVALUE_2_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYDATAVALUE_2_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_2_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class HyEnumValue
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYDATAVALUE_2 = INSTANCE.getHYDATAVALUE_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYDATAVALUE_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue(), HYDATAVALUE_2_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_3_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("Enum(", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_3_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__NAME), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_3_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_3_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(",", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYDATAVALUE_3_0_0_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYDATAVALUE_3_0_0_3_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_3_0_0_3_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(",", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYDATAVALUE_3_0_0_3_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_3_0_0_3_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_3_0_0_3_0_0_1_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1_0_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYDATAVALUE_3_0_0_3_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYDATAVALUE_3_0_0_3_0_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYDATAVALUE_3_0_0_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYDATAVALUE_3_0_0_3_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYDATAVALUE_3_0_0_3_0_0_1_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.STAR);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_3_0_0_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_3_0_0_3_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYDATAVALUE_3_0_0_3_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYDATAVALUE_3_0_0_3_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYDATAVALUE_3_0_0_3 = INSTANCE.getHYDATAVALUE_3_0_0_3();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYDATAVALUE_3_0_0_3() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYDATAVALUE_3_0_0_3_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_3_0_0_4 = INSTANCE.getHYDATAVALUE_3_0_0_4();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_3_0_0_4() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(")", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_3_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_3_0_0_5_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("[", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("-", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_3_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("-", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_3_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("eternity", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("-", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_3_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYDATAVALUE_3_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYDATAVALUE_3_0_0_5_0_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYDATAVALUE_3_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYDATAVALUE_3_0_0_5_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYDATAVALUE_3_0_0_5_0_0_1_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_3_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_3_0_0_5_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("]", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_3_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_3_0_0_5_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1, HYDATAVALUE_3_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYDATAVALUE_3_0_0_5_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYDATAVALUE_3_0_0_5_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYDATAVALUE_3_0_0_5 = INSTANCE.getHYDATAVALUE_3_0_0_5();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYDATAVALUE_3_0_0_5() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYDATAVALUE_3_0_0_5_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_3_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_3_0_0_0, HYDATAVALUE_3_0_0_1, HYDATAVALUE_3_0_0_2, HYDATAVALUE_3_0_0_3, HYDATAVALUE_3_0_0_4, HYDATAVALUE_3_0_0_5);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYDATAVALUE_3_0 = INSTANCE.getHYDATAVALUE_3_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYDATAVALUE_3_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_3_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class HyEnum
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYDATAVALUE_3 = INSTANCE.getHYDATAVALUE_3();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYDATAVALUE_3() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), HYDATAVALUE_3_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_4_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_4_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("EnumLiteral(", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_4_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_4_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__NAME), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_4_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_4_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(",", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_4_0_0_3 = INSTANCE.getHYDATAVALUE_4_0_0_3();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_4_0_0_3() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALUE), "INTEGER_LITERAL", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_4_0_0_4 = INSTANCE.getHYDATAVALUE_4_0_0_4();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_4_0_0_4() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(")", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_4_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_4_0_0_5_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("[", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("-", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_4_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("-", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("eternity", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_4_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, HYDATAVALUE_4_0_0_5_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("eternity", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("-", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_4_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYDATAVALUE_4_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYDATAVALUE_4_0_0_5_0_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYDATAVALUE_4_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYDATAVALUE_4_0_0_5_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYDATAVALUE_4_0_0_5_0_0_1_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_4_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_4_0_0_5_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("]", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_4_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_4_0_0_5_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1, HYDATAVALUE_4_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYDATAVALUE_4_0_0_5_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYDATAVALUE_4_0_0_5_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYDATAVALUE_4_0_0_5 = INSTANCE.getHYDATAVALUE_4_0_0_5();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYDATAVALUE_4_0_0_5() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYDATAVALUE_4_0_0_5_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_4_0_0 = INSTANCE.getHYDATAVALUE_4_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_4_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_4_0_0_0, HYDATAVALUE_4_0_0_1, HYDATAVALUE_4_0_0_2, HYDATAVALUE_4_0_0_3, HYDATAVALUE_4_0_0_4, HYDATAVALUE_4_0_0_5);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYDATAVALUE_4_0 = INSTANCE.getHYDATAVALUE_4_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYDATAVALUE_4_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_4_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyEnumLiteral
	 */
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYDATAVALUE_4 = INSTANCE.getHYDATAVALUE_4();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYDATAVALUE_4() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), HYDATAVALUE_4_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	
	public static String getSyntaxElementID(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (Field field : eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.class.getFields()) {
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
	
	public static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement) eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule[] RULES = new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule[] {
		HYMAPPING_0,
		HYMAPPING_1,
		HYMAPPING_2,
		HYEXPRESSION_0,
		HYEXPRESSION_1,
		HYEXPRESSION_2,
		HYEXPRESSION_3,
		HYEXPRESSION_4,
		HYEXPRESSION_5,
		HYEXPRESSION_6,
		HYEXPRESSION_7,
		HYEXPRESSION_8,
		HYEXPRESSION_9,
		HYEXPRESSION_10,
		HYEXPRESSION_11,
		HYEXPRESSION_12,
		HYEXPRESSION_13,
		HYEXPRESSION_14,
		HYEXPRESSION_15,
		HYEXPRESSION_16,
		HYEXPRESSION_17,
		HYEXPRESSION_18,
		HYEXPRESSION_19,
		HYEXPRESSION_20,
		HYEXPRESSION_21,
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
			for (eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement element, Set<String> keywords) {
		if (element instanceof eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword) {
			keywords.add(((eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword) element).getValue());
		} else if (element instanceof eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal) {
			keywords.add(((eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal) element).getTrueLiteral());
			keywords.add(((eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingEnumerationTerminal) {
			eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingEnumerationTerminal terminal = (eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
