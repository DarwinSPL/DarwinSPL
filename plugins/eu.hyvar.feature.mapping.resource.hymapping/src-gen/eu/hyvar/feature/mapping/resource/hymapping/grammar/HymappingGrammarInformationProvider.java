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
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_4 = INSTANCE.getHYEXPRESSION_4();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_4() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), HYEXPRESSION_4_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_5_0_0_0 = INSTANCE.getHYEXPRESSION_5_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_5_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("-", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_5_0_0_1 = INSTANCE.getHYEXPRESSION_5_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_5_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NEGATION_EXPRESSION__OPERAND), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_5_0_0 = INSTANCE.getHYEXPRESSION_5_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_5_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_5_0_0_0, HYEXPRESSION_5_0_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_5_0 = INSTANCE.getHYEXPRESSION_5_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_5_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_5_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_5 = INSTANCE.getHYEXPRESSION_5();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_5() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), HYEXPRESSION_5_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_6_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_6_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("(", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_6_0_0_1 = INSTANCE.getHYEXPRESSION_6_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_6_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NESTED_EXPRESSION__OPERAND), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_6_0_0_2 = INSTANCE.getHYEXPRESSION_6_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_6_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(")", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_6_0_0 = INSTANCE.getHYEXPRESSION_6_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_6_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_6_0_0_0, HYEXPRESSION_6_0_0_1, HYEXPRESSION_6_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_6_0 = INSTANCE.getHYEXPRESSION_6_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_6_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_6_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_6 = INSTANCE.getHYEXPRESSION_6();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_6() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), HYEXPRESSION_6_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_7_0_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_7_0_0_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_7_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_7_0_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_7_0_0_0_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_7_0_0_0_0_1_0 = INSTANCE.getHYEXPRESSION_7_0_0_0_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_7_0_0_0_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_7_0_0_0_0_1 = INSTANCE.getHYEXPRESSION_7_0_0_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_7_0_0_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_7_0_0_0_0_1_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_7_0_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_7_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_7_0_0_0_0_0, HYEXPRESSION_7_0_0_0_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYEXPRESSION_7_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYEXPRESSION_7_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYEXPRESSION_7_0_0_0_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_7_0_0_1_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_7_0_0_1_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRestriction(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_7_0_0_1_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_7_0_0_1_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_7_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_7_0_0_1_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_7_0_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_7_0_0_1_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYEXPRESSION_7_0_0_1 = INSTANCE.getHYEXPRESSION_7_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYEXPRESSION_7_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYEXPRESSION_7_0_0_1_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_7_0_0 = INSTANCE.getHYEXPRESSION_7_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_7_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_7_0_0_0, HYEXPRESSION_7_0_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_7_0 = INSTANCE.getHYEXPRESSION_7_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_7_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_7_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_7 = INSTANCE.getHYEXPRESSION_7();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_7() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), HYEXPRESSION_7_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_8_0_0_0 = INSTANCE.getHYEXPRESSION_8_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_8_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("?", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_8_0_0_1_0_0_0 = INSTANCE.getHYEXPRESSION_8_0_0_1_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_8_0_0_1_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_8_0_0_1_0_0 = INSTANCE.getHYEXPRESSION_8_0_0_1_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_8_0_0_1_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_8_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_8_0_0_1_0_1_0 = INSTANCE.getHYEXPRESSION_8_0_0_1_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_8_0_0_1_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_8_0_0_1_0_1 = INSTANCE.getHYEXPRESSION_8_0_0_1_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_8_0_0_1_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_8_0_0_1_0_1_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_8_0_0_1_0 = INSTANCE.getHYEXPRESSION_8_0_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_8_0_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_8_0_0_1_0_0, HYEXPRESSION_8_0_0_1_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYEXPRESSION_8_0_0_1 = INSTANCE.getHYEXPRESSION_8_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYEXPRESSION_8_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYEXPRESSION_8_0_0_1_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_8_0_0_2 = INSTANCE.getHYEXPRESSION_8_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_8_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRestriction(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_8_0_0 = INSTANCE.getHYEXPRESSION_8_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_8_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_8_0_0_0, HYEXPRESSION_8_0_0_1, HYEXPRESSION_8_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_8_0 = INSTANCE.getHYEXPRESSION_8_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_8_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_8_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_8 = INSTANCE.getHYEXPRESSION_8();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_8() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), HYEXPRESSION_8_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_9_0_0_0 = INSTANCE.getHYEXPRESSION_9_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_9_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("context:", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_9_0_0_1 = INSTANCE.getHYEXPRESSION_9_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_9_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_9_0_0 = INSTANCE.getHYEXPRESSION_9_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_9_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_9_0_0_0, HYEXPRESSION_9_0_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_9_0 = INSTANCE.getHYEXPRESSION_9_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_9_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_9_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_9 = INSTANCE.getHYEXPRESSION_9();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_9() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression(), HYEXPRESSION_9_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_10_0_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_10_0_0_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_10_0_0_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_10_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_10_0_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_10_0_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_10_0_0_0_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_10_0_0_0_0_1_0 = INSTANCE.getHYEXPRESSION_10_0_0_0_0_1_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_10_0_0_0_0_1_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_10_0_0_0_0_1 = INSTANCE.getHYEXPRESSION_10_0_0_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_10_0_0_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_10_0_0_0_0_1_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_10_0_0_0_0 = INSTANCE.getHYEXPRESSION_10_0_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_10_0_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_10_0_0_0_0_0, HYEXPRESSION_10_0_0_0_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYEXPRESSION_10_0_0_0 = INSTANCE.getHYEXPRESSION_10_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYEXPRESSION_10_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYEXPRESSION_10_0_0_0_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_10_0_0_1 = INSTANCE.getHYEXPRESSION_10_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_10_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(".", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_10_0_0_2 = INSTANCE.getHYEXPRESSION_10_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_10_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_10_0_0 = INSTANCE.getHYEXPRESSION_10_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_10_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_10_0_0_0, HYEXPRESSION_10_0_0_1, HYEXPRESSION_10_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_10_0 = INSTANCE.getHYEXPRESSION_10_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_10_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_10_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_10 = INSTANCE.getHYEXPRESSION_10();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_10() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression(), HYEXPRESSION_10_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_11_0_0_0 = INSTANCE.getHYEXPRESSION_11_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_11_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VALUE_EXPRESSION__VALUE), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyValue(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_11_0_0 = INSTANCE.getHYEXPRESSION_11_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_11_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_11_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_11_0 = INSTANCE.getHYEXPRESSION_11_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_11_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_11_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_11 = INSTANCE.getHYEXPRESSION_11();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_11() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression(), HYEXPRESSION_11_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal HYEXPRESSION_12_0_0_0 = INSTANCE.getHYEXPRESSION_12_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal getHYEXPRESSION_12_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyBooleanValueExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), "true", "false", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_12_0_0 = INSTANCE.getHYEXPRESSION_12_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_12_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_12_0_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_12_0 = INSTANCE.getHYEXPRESSION_12_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_12_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_12_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_12 = INSTANCE.getHYEXPRESSION_12();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_12() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyBooleanValueExpression(), HYEXPRESSION_12_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_13_0_0_0 = INSTANCE.getHYEXPRESSION_13_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_13_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("min(", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_13_0_0_1 = INSTANCE.getHYEXPRESSION_13_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_13_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MINIMUM_EXPRESSION__OPERAND), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_13_0_0_2 = INSTANCE.getHYEXPRESSION_13_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_13_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(")", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_13_0_0 = INSTANCE.getHYEXPRESSION_13_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_13_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_13_0_0_0, HYEXPRESSION_13_0_0_1, HYEXPRESSION_13_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_13_0 = INSTANCE.getHYEXPRESSION_13_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_13_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_13_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_13 = INSTANCE.getHYEXPRESSION_13();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_13() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), HYEXPRESSION_13_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_14_0_0_0 = INSTANCE.getHYEXPRESSION_14_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_14_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("max(", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_14_0_0_1 = INSTANCE.getHYEXPRESSION_14_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_14_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MAXIMUM_EXPRESSION__OPERAND), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_14_0_0_2 = INSTANCE.getHYEXPRESSION_14_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_14_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(")", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_14_0_0 = INSTANCE.getHYEXPRESSION_14_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_14_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_14_0_0_0, HYEXPRESSION_14_0_0_1, HYEXPRESSION_14_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_14_0 = INSTANCE.getHYEXPRESSION_14_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_14_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_14_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_14 = INSTANCE.getHYEXPRESSION_14();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_14() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), HYEXPRESSION_14_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_15_0_0_0 = INSTANCE.getHYEXPRESSION_15_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_15_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("ifPossible(", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_15_0_0_1 = INSTANCE.getHYEXPRESSION_15_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_15_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IF_POSSIBLE_EXPRESSION__OPERANDS), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_15_0_0_2_0_0_0 = INSTANCE.getHYEXPRESSION_15_0_0_2_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_15_0_0_2_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(",", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_15_0_0_2_0_0_1 = INSTANCE.getHYEXPRESSION_15_0_0_2_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_15_0_0_2_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IF_POSSIBLE_EXPRESSION__OPERANDS), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_15_0_0_2_0_0 = INSTANCE.getHYEXPRESSION_15_0_0_2_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_15_0_0_2_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_15_0_0_2_0_0_0, HYEXPRESSION_15_0_0_2_0_0_1);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_15_0_0_2_0 = INSTANCE.getHYEXPRESSION_15_0_0_2_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_15_0_0_2_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_15_0_0_2_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound HYEXPRESSION_15_0_0_2 = INSTANCE.getHYEXPRESSION_15_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound getHYEXPRESSION_15_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCompound(HYEXPRESSION_15_0_0_2_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.STAR);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_15_0_0_3 = INSTANCE.getHYEXPRESSION_15_0_0_3();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_15_0_0_3() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(")", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_15_0_0 = INSTANCE.getHYEXPRESSION_15_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_15_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_15_0_0_0, HYEXPRESSION_15_0_0_1, HYEXPRESSION_15_0_0_2, HYEXPRESSION_15_0_0_3);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_15_0 = INSTANCE.getHYEXPRESSION_15_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_15_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_15_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_15 = INSTANCE.getHYEXPRESSION_15();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_15() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), HYEXPRESSION_15_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_16_0_0_0 = INSTANCE.getHYEXPRESSION_16_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_16_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_16_0_0_1 = INSTANCE.getHYEXPRESSION_16_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_16_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("<", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_16_0_0_2 = INSTANCE.getHYEXPRESSION_16_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_16_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_16_0_0 = INSTANCE.getHYEXPRESSION_16_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_16_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_16_0_0_0, HYEXPRESSION_16_0_0_1, HYEXPRESSION_16_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_16_0 = INSTANCE.getHYEXPRESSION_16_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_16_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_16_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_16 = INSTANCE.getHYEXPRESSION_16();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_16() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), HYEXPRESSION_16_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_17_0_0_0 = INSTANCE.getHYEXPRESSION_17_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_17_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_OR_EQUAL_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_17_0_0_1 = INSTANCE.getHYEXPRESSION_17_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_17_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("<=", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_17_0_0_2 = INSTANCE.getHYEXPRESSION_17_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_17_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_OR_EQUAL_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_17_0_0 = INSTANCE.getHYEXPRESSION_17_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_17_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_17_0_0_0, HYEXPRESSION_17_0_0_1, HYEXPRESSION_17_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_17_0 = INSTANCE.getHYEXPRESSION_17_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_17_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_17_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_17 = INSTANCE.getHYEXPRESSION_17();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_17() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), HYEXPRESSION_17_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_18_0_0_0 = INSTANCE.getHYEXPRESSION_18_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_18_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_18_0_0_1 = INSTANCE.getHYEXPRESSION_18_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_18_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(">", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_18_0_0_2 = INSTANCE.getHYEXPRESSION_18_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_18_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_18_0_0 = INSTANCE.getHYEXPRESSION_18_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_18_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_18_0_0_0, HYEXPRESSION_18_0_0_1, HYEXPRESSION_18_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_18_0 = INSTANCE.getHYEXPRESSION_18_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_18_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_18_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_18 = INSTANCE.getHYEXPRESSION_18();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_18() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), HYEXPRESSION_18_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_19_0_0_0 = INSTANCE.getHYEXPRESSION_19_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_19_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_OR_EQUAL_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_19_0_0_1 = INSTANCE.getHYEXPRESSION_19_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_19_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(">=", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_19_0_0_2 = INSTANCE.getHYEXPRESSION_19_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_19_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_OR_EQUAL_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_19_0_0 = INSTANCE.getHYEXPRESSION_19_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_19_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_19_0_0_0, HYEXPRESSION_19_0_0_1, HYEXPRESSION_19_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_19_0 = INSTANCE.getHYEXPRESSION_19_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_19_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_19_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_19 = INSTANCE.getHYEXPRESSION_19();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_19() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), HYEXPRESSION_19_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_20_0_0_0 = INSTANCE.getHYEXPRESSION_20_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_20_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_20_0_0_1 = INSTANCE.getHYEXPRESSION_20_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_20_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("-", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_20_0_0_2 = INSTANCE.getHYEXPRESSION_20_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_20_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_20_0_0 = INSTANCE.getHYEXPRESSION_20_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_20_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_20_0_0_0, HYEXPRESSION_20_0_0_1, HYEXPRESSION_20_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_20_0 = INSTANCE.getHYEXPRESSION_20_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_20_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_20_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_20 = INSTANCE.getHYEXPRESSION_20();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_20() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), HYEXPRESSION_20_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_21_0_0_0 = INSTANCE.getHYEXPRESSION_21_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_21_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_21_0_0_1 = INSTANCE.getHYEXPRESSION_21_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_21_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("+", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_21_0_0_2 = INSTANCE.getHYEXPRESSION_21_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_21_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_21_0_0 = INSTANCE.getHYEXPRESSION_21_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_21_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_21_0_0_0, HYEXPRESSION_21_0_0_1, HYEXPRESSION_21_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_21_0 = INSTANCE.getHYEXPRESSION_21_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_21_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_21_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_21 = INSTANCE.getHYEXPRESSION_21();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_21() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), HYEXPRESSION_21_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_22_0_0_0 = INSTANCE.getHYEXPRESSION_22_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_22_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_22_0_0_1 = INSTANCE.getHYEXPRESSION_22_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_22_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("%", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_22_0_0_2 = INSTANCE.getHYEXPRESSION_22_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_22_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_22_0_0 = INSTANCE.getHYEXPRESSION_22_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_22_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_22_0_0_0, HYEXPRESSION_22_0_0_1, HYEXPRESSION_22_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_22_0 = INSTANCE.getHYEXPRESSION_22_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_22_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_22_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_22 = INSTANCE.getHYEXPRESSION_22();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_22() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), HYEXPRESSION_22_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_23_0_0_0 = INSTANCE.getHYEXPRESSION_23_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_23_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_23_0_0_1 = INSTANCE.getHYEXPRESSION_23_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_23_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("*", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_23_0_0_2 = INSTANCE.getHYEXPRESSION_23_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_23_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_23_0_0 = INSTANCE.getHYEXPRESSION_23_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_23_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_23_0_0_0, HYEXPRESSION_23_0_0_1, HYEXPRESSION_23_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_23_0 = INSTANCE.getHYEXPRESSION_23_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_23_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_23_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_23 = INSTANCE.getHYEXPRESSION_23();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_23() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), HYEXPRESSION_23_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_24_0_0_0 = INSTANCE.getHYEXPRESSION_24_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_24_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_24_0_0_1 = INSTANCE.getHYEXPRESSION_24_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_24_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("/", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_24_0_0_2 = INSTANCE.getHYEXPRESSION_24_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_24_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_24_0_0 = INSTANCE.getHYEXPRESSION_24_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_24_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_24_0_0_0, HYEXPRESSION_24_0_0_1, HYEXPRESSION_24_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_24_0 = INSTANCE.getHYEXPRESSION_24_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_24_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_24_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_24 = INSTANCE.getHYEXPRESSION_24();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_24() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), HYEXPRESSION_24_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_25_0_0_0 = INSTANCE.getHYEXPRESSION_25_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_25_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUAL_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_25_0_0_1 = INSTANCE.getHYEXPRESSION_25_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_25_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("=", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_25_0_0_2 = INSTANCE.getHYEXPRESSION_25_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_25_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUAL_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_25_0_0 = INSTANCE.getHYEXPRESSION_25_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_25_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_25_0_0_0, HYEXPRESSION_25_0_0_1, HYEXPRESSION_25_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_25_0 = INSTANCE.getHYEXPRESSION_25_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_25_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_25_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_25 = INSTANCE.getHYEXPRESSION_25();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_25() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), HYEXPRESSION_25_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_26_0_0_0 = INSTANCE.getHYEXPRESSION_26_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_26_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EQUAL_EXPRESSION__OPERAND1), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_26_0_0_1 = INSTANCE.getHYEXPRESSION_26_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_26_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("!=", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment HYEXPRESSION_26_0_0_2 = INSTANCE.getHYEXPRESSION_26_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment getHYEXPRESSION_26_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EQUAL_EXPRESSION__OPERAND2), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_26_0_0 = INSTANCE.getHYEXPRESSION_26_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_26_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_26_0_0_0, HYEXPRESSION_26_0_0_1, HYEXPRESSION_26_0_0_2);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_26_0 = INSTANCE.getHYEXPRESSION_26_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_26_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_26_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_26 = INSTANCE.getHYEXPRESSION_26();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_26() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), HYEXPRESSION_26_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_27_0_0_0 = INSTANCE.getHYEXPRESSION_27_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_27_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("[", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingEnumerationTerminal HYEXPRESSION_27_0_0_1 = INSTANCE.getHYEXPRESSION_27_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingEnumerationTerminal getHYEXPRESSION_27_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingEnumerationTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), new String[] {"lessThan", "<", "lessThanOrEqual", "<=", "equal", "=", "implicitEqual", "", "greaterThanOrEqual", ">=", "greaterThan", ">", }, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_27_0_0_2 = INSTANCE.getHYEXPRESSION_27_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_27_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), "QUOTED_34_34", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_27_0_0_3 = INSTANCE.getHYEXPRESSION_27_0_0_3();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_27_0_0_3() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("]", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_27_0_0 = INSTANCE.getHYEXPRESSION_27_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_27_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_27_0_0_0, HYEXPRESSION_27_0_0_1, HYEXPRESSION_27_0_0_2, HYEXPRESSION_27_0_0_3);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_27_0 = INSTANCE.getHYEXPRESSION_27_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_27_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_27_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_27 = INSTANCE.getHYEXPRESSION_27();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_27() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction(), HYEXPRESSION_27_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_28_0_0_0 = INSTANCE.getHYEXPRESSION_28_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_28_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("[", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal HYEXPRESSION_28_0_0_1 = INSTANCE.getHYEXPRESSION_28_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal getHYEXPRESSION_28_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), "", "^", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_28_0_0_2 = INSTANCE.getHYEXPRESSION_28_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_28_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), "QUOTED_34_34", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_28_0_0_3 = INSTANCE.getHYEXPRESSION_28_0_0_3();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_28_0_0_3() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("-", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal HYEXPRESSION_28_0_0_4 = INSTANCE.getHYEXPRESSION_28_0_0_4();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal getHYEXPRESSION_28_0_0_4() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), "", "^", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYEXPRESSION_28_0_0_5 = INSTANCE.getHYEXPRESSION_28_0_0_5();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYEXPRESSION_28_0_0_5() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), "QUOTED_34_34", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYEXPRESSION_28_0_0_6 = INSTANCE.getHYEXPRESSION_28_0_0_6();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYEXPRESSION_28_0_0_6() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("]", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYEXPRESSION_28_0_0 = INSTANCE.getHYEXPRESSION_28_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYEXPRESSION_28_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_28_0_0_0, HYEXPRESSION_28_0_0_1, HYEXPRESSION_28_0_0_2, HYEXPRESSION_28_0_0_3, HYEXPRESSION_28_0_0_4, HYEXPRESSION_28_0_0_5, HYEXPRESSION_28_0_0_6);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYEXPRESSION_28_0 = INSTANCE.getHYEXPRESSION_28_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYEXPRESSION_28_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYEXPRESSION_28_0_0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYEXPRESSION_28 = INSTANCE.getHYEXPRESSION_28();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYEXPRESSION_28() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction(), HYEXPRESSION_28_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
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
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule HYDATAVALUE_1 = INSTANCE.getHYDATAVALUE_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule getHYDATAVALUE_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue(), HYDATAVALUE_1_0, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_2_0_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_2_0_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword("enum:", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_2_0_0_1 = INSTANCE.getHYDATAVALUE_2_0_0_1();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_2_0_0_1() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword HYDATAVALUE_2_0_0_2 = INSTANCE.getHYDATAVALUE_2_0_0_2();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword getHYDATAVALUE_2_0_0_2() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingKeyword(".", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder HYDATAVALUE_2_0_0_3 = INSTANCE.getHYDATAVALUE_2_0_0_3();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder getHYDATAVALUE_2_0_0_3() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), "IDENTIFIER_TOKEN", eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence HYDATAVALUE_2_0_0 = INSTANCE.getHYDATAVALUE_2_0_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence getHYDATAVALUE_2_0_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSequence(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_2_0_0_0, HYDATAVALUE_2_0_0_1, HYDATAVALUE_2_0_0_2, HYDATAVALUE_2_0_0_3);
	}
	
	public final static eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice HYDATAVALUE_2_0 = INSTANCE.getHYDATAVALUE_2_0();
	private eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice getHYDATAVALUE_2_0() {
		return new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingChoice(eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality.ONE, HYDATAVALUE_2_0_0);
	}
	
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
		HYEXPRESSION_22,
		HYEXPRESSION_23,
		HYEXPRESSION_24,
		HYEXPRESSION_25,
		HYEXPRESSION_26,
		HYEXPRESSION_27,
		HYEXPRESSION_28,
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
