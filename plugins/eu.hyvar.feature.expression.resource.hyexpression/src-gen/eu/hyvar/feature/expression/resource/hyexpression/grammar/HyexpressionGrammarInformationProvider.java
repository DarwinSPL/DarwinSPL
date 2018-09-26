/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.grammar;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class HyexpressionGrammarInformationProvider {
	
	public final static EStructuralFeature ANONYMOUS_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static HyexpressionGrammarInformationProvider INSTANCE = new HyexpressionGrammarInformationProvider();
	
	private Set<String> keywords;
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_0_0_0_0 = INSTANCE.getHYEXPRESSION_0_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_0_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND1), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_0_0_0_1 = INSTANCE.getHYEXPRESSION_0_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_0_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("<->", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_0_0_0_2 = INSTANCE.getHYEXPRESSION_0_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_0_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND2), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_0_0_0 = INSTANCE.getHYEXPRESSION_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_0_0_0_0, HYEXPRESSION_0_0_0_1, HYEXPRESSION_0_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_0_0 = INSTANCE.getHYEXPRESSION_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_0_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyEquivalenceExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_0 = INSTANCE.getHYEXPRESSION_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), HYEXPRESSION_0_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_1_0_0_0 = INSTANCE.getHYEXPRESSION_1_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_1_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND1), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_1_0_0_1 = INSTANCE.getHYEXPRESSION_1_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_1_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("->", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_1_0_0_2 = INSTANCE.getHYEXPRESSION_1_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_1_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND2), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_1_0_0 = INSTANCE.getHYEXPRESSION_1_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_1_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_1_0_0_0, HYEXPRESSION_1_0_0_1, HYEXPRESSION_1_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_1_0 = INSTANCE.getHYEXPRESSION_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_1_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyImpliesExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_1 = INSTANCE.getHYEXPRESSION_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), HYEXPRESSION_1_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_2_0_0_0 = INSTANCE.getHYEXPRESSION_2_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_2_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND1), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_2_0_0_1 = INSTANCE.getHYEXPRESSION_2_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_2_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("||", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_2_0_0_2 = INSTANCE.getHYEXPRESSION_2_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_2_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND2), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_2_0_0 = INSTANCE.getHYEXPRESSION_2_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_2_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_2_0_0_0, HYEXPRESSION_2_0_0_1, HYEXPRESSION_2_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_2_0 = INSTANCE.getHYEXPRESSION_2_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_2_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_2_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyOrExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_2 = INSTANCE.getHYEXPRESSION_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), HYEXPRESSION_2_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_3_0_0_0 = INSTANCE.getHYEXPRESSION_3_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_3_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND1), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_3_0_0_1 = INSTANCE.getHYEXPRESSION_3_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_3_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("&&", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_3_0_0_2 = INSTANCE.getHYEXPRESSION_3_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_3_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND2), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_3_0_0 = INSTANCE.getHYEXPRESSION_3_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_3_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_3_0_0_0, HYEXPRESSION_3_0_0_1, HYEXPRESSION_3_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_3_0 = INSTANCE.getHYEXPRESSION_3_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_3_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_3_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyAndExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_3 = INSTANCE.getHYEXPRESSION_3();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_3() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), HYEXPRESSION_3_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_4_0_0_0 = INSTANCE.getHYEXPRESSION_4_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_4_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("!", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_4_0_0_1 = INSTANCE.getHYEXPRESSION_4_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_4_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EXPRESSION__OPERAND), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_4_0_0 = INSTANCE.getHYEXPRESSION_4_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_4_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_4_0_0_0, HYEXPRESSION_4_0_0_1);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_4_0 = INSTANCE.getHYEXPRESSION_4_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_4_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_4_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyNotExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_4 = INSTANCE.getHYEXPRESSION_4();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_4() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), HYEXPRESSION_4_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_5_0_0_0 = INSTANCE.getHYEXPRESSION_5_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_5_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("(", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_5_0_0_1 = INSTANCE.getHYEXPRESSION_5_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_5_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NESTED_EXPRESSION__OPERAND), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_5_0_0_2 = INSTANCE.getHYEXPRESSION_5_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_5_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword(")", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_5_0_0 = INSTANCE.getHYEXPRESSION_5_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_5_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_5_0_0_0, HYEXPRESSION_5_0_0_1, HYEXPRESSION_5_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_5_0 = INSTANCE.getHYEXPRESSION_5_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_5_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_5_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyNestedExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_5 = INSTANCE.getHYEXPRESSION_5();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_5() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), HYEXPRESSION_5_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYEXPRESSION_6_0_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_0_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYEXPRESSION_6_0_0_0_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_6_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_6_0_0_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_6_0_0_0_0_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYEXPRESSION_6_0_0_0_0_1_0 = INSTANCE.getHYEXPRESSION_6_0_0_0_0_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYEXPRESSION_6_0_0_0_0_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_6_0_0_0_0_1 = INSTANCE.getHYEXPRESSION_6_0_0_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_6_0_0_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_6_0_0_0_0_1_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_6_0_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_6_0_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_6_0_0_0_0_0, HYEXPRESSION_6_0_0_0_0_1);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound HYEXPRESSION_6_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound getHYEXPRESSION_6_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound(HYEXPRESSION_6_0_0_0_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_6_0_0_1_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_1_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_6_0_0_1_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRestriction(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_6_0_0_1_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_1_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_6_0_0_1_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_6_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_6_0_0_1_0 = INSTANCE.getHYEXPRESSION_6_0_0_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_6_0_0_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_6_0_0_1_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound HYEXPRESSION_6_0_0_1 = INSTANCE.getHYEXPRESSION_6_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound getHYEXPRESSION_6_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound(HYEXPRESSION_6_0_0_1_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_6_0_0 = INSTANCE.getHYEXPRESSION_6_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_6_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_6_0_0_0, HYEXPRESSION_6_0_0_1);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_6_0 = INSTANCE.getHYEXPRESSION_6_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_6_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_6_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyFeatureReferenceExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_6 = INSTANCE.getHYEXPRESSION_6();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_6() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), HYEXPRESSION_6_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_7_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_7_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("?", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYEXPRESSION_7_0_0_1_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYEXPRESSION_7_0_0_1_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_7_0_0_1_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_7_0_0_1_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_7_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYEXPRESSION_7_0_0_1_0_1_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYEXPRESSION_7_0_0_1_0_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_7_0_0_1_0_1 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_7_0_0_1_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_7_0_0_1_0_1_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_7_0_0_1_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_7_0_0_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_7_0_0_1_0_0, HYEXPRESSION_7_0_0_1_0_1);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound HYEXPRESSION_7_0_0_1 = INSTANCE.getHYEXPRESSION_7_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound getHYEXPRESSION_7_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound(HYEXPRESSION_7_0_0_1_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_7_0_0_2 = INSTANCE.getHYEXPRESSION_7_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_7_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRestriction(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_7_0_0 = INSTANCE.getHYEXPRESSION_7_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_7_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_7_0_0_0, HYEXPRESSION_7_0_0_1, HYEXPRESSION_7_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_7_0 = INSTANCE.getHYEXPRESSION_7_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_7_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_7_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyConditionalFeatureReferenceExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_7 = INSTANCE.getHYEXPRESSION_7();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_7() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), HYEXPRESSION_7_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionBooleanTerminal HYEXPRESSION_8_0_0_0 = INSTANCE.getHYEXPRESSION_8_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionBooleanTerminal getHYEXPRESSION_8_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyBooleanValueExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), "true", "false", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_8_0_0 = INSTANCE.getHYEXPRESSION_8_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_8_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_8_0_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_8_0 = INSTANCE.getHYEXPRESSION_8_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_8_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_8_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyBooleanValueExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_8 = INSTANCE.getHYEXPRESSION_8();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_8() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyBooleanValueExpression(), HYEXPRESSION_8_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_9_0_0_0 = INSTANCE.getHYEXPRESSION_9_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_9_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("{", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_9_0_0_1 = INSTANCE.getHYEXPRESSION_9_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_9_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERAND1), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionEnumerationTerminal HYEXPRESSION_9_0_0_2 = INSTANCE.getHYEXPRESSION_9_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionEnumerationTerminal getHYEXPRESSION_9_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionEnumerationTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), new String[] {"HyLessOperator", "<", "HyLessOrEqualOperator", "<=", "HyEqualOperator", "=", "HyNotEqualOperator", "!=", "HyGreaterOrEqualOperator", ">=", "HyGreaterOperator", ">", }, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_9_0_0_3 = INSTANCE.getHYEXPRESSION_9_0_0_3();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_9_0_0_3() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERAND2), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_9_0_0_4 = INSTANCE.getHYEXPRESSION_9_0_0_4();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_9_0_0_4() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("}", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_9_0_0 = INSTANCE.getHYEXPRESSION_9_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_9_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_9_0_0_0, HYEXPRESSION_9_0_0_1, HYEXPRESSION_9_0_0_2, HYEXPRESSION_9_0_0_3, HYEXPRESSION_9_0_0_4);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_9_0 = INSTANCE.getHYEXPRESSION_9_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_9_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_9_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyArithmeticalComparisonExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_9 = INSTANCE.getHYEXPRESSION_9();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_9() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(), HYEXPRESSION_9_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_10_0_0_0 = INSTANCE.getHYEXPRESSION_10_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_10_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND1), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_10_0_0_1 = INSTANCE.getHYEXPRESSION_10_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_10_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("+", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_10_0_0_2 = INSTANCE.getHYEXPRESSION_10_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_10_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND2), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_10_0_0 = INSTANCE.getHYEXPRESSION_10_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_10_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_10_0_0_0, HYEXPRESSION_10_0_0_1, HYEXPRESSION_10_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_10_0 = INSTANCE.getHYEXPRESSION_10_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_10_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_10_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyAdditionExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_10 = INSTANCE.getHYEXPRESSION_10();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_10() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), HYEXPRESSION_10_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_11_0_0_0 = INSTANCE.getHYEXPRESSION_11_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_11_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND1), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_11_0_0_1 = INSTANCE.getHYEXPRESSION_11_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_11_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("-", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_11_0_0_2 = INSTANCE.getHYEXPRESSION_11_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_11_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND2), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_11_0_0 = INSTANCE.getHYEXPRESSION_11_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_11_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_11_0_0_0, HYEXPRESSION_11_0_0_1, HYEXPRESSION_11_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_11_0 = INSTANCE.getHYEXPRESSION_11_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_11_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_11_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HySubtractionExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_11 = INSTANCE.getHYEXPRESSION_11();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_11() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), HYEXPRESSION_11_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_12_0_0_0 = INSTANCE.getHYEXPRESSION_12_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_12_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND1), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_12_0_0_1 = INSTANCE.getHYEXPRESSION_12_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_12_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("%", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_12_0_0_2 = INSTANCE.getHYEXPRESSION_12_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_12_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND2), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_12_0_0 = INSTANCE.getHYEXPRESSION_12_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_12_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_12_0_0_0, HYEXPRESSION_12_0_0_1, HYEXPRESSION_12_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_12_0 = INSTANCE.getHYEXPRESSION_12_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_12_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_12_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyModuloExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_12 = INSTANCE.getHYEXPRESSION_12();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_12() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), HYEXPRESSION_12_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_13_0_0_0 = INSTANCE.getHYEXPRESSION_13_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_13_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND1), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_13_0_0_1 = INSTANCE.getHYEXPRESSION_13_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_13_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("*", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_13_0_0_2 = INSTANCE.getHYEXPRESSION_13_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_13_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND2), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_13_0_0 = INSTANCE.getHYEXPRESSION_13_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_13_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_13_0_0_0, HYEXPRESSION_13_0_0_1, HYEXPRESSION_13_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_13_0 = INSTANCE.getHYEXPRESSION_13_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_13_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_13_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyMultiplicationExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_13 = INSTANCE.getHYEXPRESSION_13();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_13() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), HYEXPRESSION_13_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_14_0_0_0 = INSTANCE.getHYEXPRESSION_14_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_14_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND1), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_14_0_0_1 = INSTANCE.getHYEXPRESSION_14_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_14_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("/", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_14_0_0_2 = INSTANCE.getHYEXPRESSION_14_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_14_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND2), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_14_0_0 = INSTANCE.getHYEXPRESSION_14_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_14_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_14_0_0_0, HYEXPRESSION_14_0_0_1, HYEXPRESSION_14_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_14_0 = INSTANCE.getHYEXPRESSION_14_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_14_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_14_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyDivisionExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_14 = INSTANCE.getHYEXPRESSION_14();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_14() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), HYEXPRESSION_14_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_15_0_0_0 = INSTANCE.getHYEXPRESSION_15_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_15_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("-", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_15_0_0_1 = INSTANCE.getHYEXPRESSION_15_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_15_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NEGATION_EXPRESSION__OPERAND), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_15_0_0 = INSTANCE.getHYEXPRESSION_15_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_15_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_15_0_0_0, HYEXPRESSION_15_0_0_1);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_15_0 = INSTANCE.getHYEXPRESSION_15_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_15_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_15_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyNegationExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_15 = INSTANCE.getHYEXPRESSION_15();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_15() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), HYEXPRESSION_15_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_16_0_0_0 = INSTANCE.getHYEXPRESSION_16_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_16_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("(", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_16_0_0_1 = INSTANCE.getHYEXPRESSION_16_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_16_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedArithmeticalValueExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NESTED_ARITHMETICAL_VALUE_EXPRESSION__OPERAND), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_16_0_0_2 = INSTANCE.getHYEXPRESSION_16_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_16_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword(")", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_16_0_0 = INSTANCE.getHYEXPRESSION_16_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_16_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_16_0_0_0, HYEXPRESSION_16_0_0_1, HYEXPRESSION_16_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_16_0 = INSTANCE.getHYEXPRESSION_16_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_16_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_16_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyNestedArithmeticalValueExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_16 = INSTANCE.getHYEXPRESSION_16();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_16() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedArithmeticalValueExpression(), HYEXPRESSION_16_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYEXPRESSION_17_0_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_17_0_0_0_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYEXPRESSION_17_0_0_0_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_17_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_17_0_0_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_17_0_0_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_17_0_0_0_0_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYEXPRESSION_17_0_0_0_0_1_0 = INSTANCE.getHYEXPRESSION_17_0_0_0_0_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYEXPRESSION_17_0_0_0_0_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_17_0_0_0_0_1 = INSTANCE.getHYEXPRESSION_17_0_0_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_17_0_0_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_17_0_0_0_0_1_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_17_0_0_0_0 = INSTANCE.getHYEXPRESSION_17_0_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_17_0_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_17_0_0_0_0_0, HYEXPRESSION_17_0_0_0_0_1);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound HYEXPRESSION_17_0_0_0 = INSTANCE.getHYEXPRESSION_17_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound getHYEXPRESSION_17_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound(HYEXPRESSION_17_0_0_0_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_17_0_0_1 = INSTANCE.getHYEXPRESSION_17_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_17_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword(".", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYEXPRESSION_17_0_0_2 = INSTANCE.getHYEXPRESSION_17_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYEXPRESSION_17_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), "IDENTIFIER_TOKEN", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_17_0_0 = INSTANCE.getHYEXPRESSION_17_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_17_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_17_0_0_0, HYEXPRESSION_17_0_0_1, HYEXPRESSION_17_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_17_0 = INSTANCE.getHYEXPRESSION_17_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_17_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_17_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyAttributeReferenceExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_17 = INSTANCE.getHYEXPRESSION_17();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_17() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression(), HYEXPRESSION_17_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_18_0_0_0 = INSTANCE.getHYEXPRESSION_18_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_18_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("context:", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYEXPRESSION_18_0_0_1_0_0_0 = INSTANCE.getHYEXPRESSION_18_0_0_1_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYEXPRESSION_18_0_0_1_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), "QUOTED_34_34", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_18_0_0_1_0_0 = INSTANCE.getHYEXPRESSION_18_0_0_1_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_18_0_0_1_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_18_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYEXPRESSION_18_0_0_1_0_1_0 = INSTANCE.getHYEXPRESSION_18_0_0_1_0_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYEXPRESSION_18_0_0_1_0_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), "IDENTIFIER_TOKEN", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_18_0_0_1_0_1 = INSTANCE.getHYEXPRESSION_18_0_0_1_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_18_0_0_1_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_18_0_0_1_0_1_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_18_0_0_1_0 = INSTANCE.getHYEXPRESSION_18_0_0_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_18_0_0_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_18_0_0_1_0_0, HYEXPRESSION_18_0_0_1_0_1);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound HYEXPRESSION_18_0_0_1 = INSTANCE.getHYEXPRESSION_18_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound getHYEXPRESSION_18_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound(HYEXPRESSION_18_0_0_1_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_18_0_0 = INSTANCE.getHYEXPRESSION_18_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_18_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_18_0_0_0, HYEXPRESSION_18_0_0_1);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_18_0 = INSTANCE.getHYEXPRESSION_18_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_18_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_18_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyContextInformationReferenceExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_18 = INSTANCE.getHYEXPRESSION_18();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_18() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression(), HYEXPRESSION_18_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYEXPRESSION_19_0_0_0 = INSTANCE.getHYEXPRESSION_19_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYEXPRESSION_19_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VALUE_EXPRESSION__VALUE), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyValue(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_19_0_0 = INSTANCE.getHYEXPRESSION_19_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_19_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_19_0_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_19_0 = INSTANCE.getHYEXPRESSION_19_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_19_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_19_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyValueExpression
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_19 = INSTANCE.getHYEXPRESSION_19();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_19() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression(), HYEXPRESSION_19_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_20_0_0_0 = INSTANCE.getHYEXPRESSION_20_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_20_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("[", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionEnumerationTerminal HYEXPRESSION_20_0_0_1 = INSTANCE.getHYEXPRESSION_20_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionEnumerationTerminal getHYEXPRESSION_20_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionEnumerationTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), new String[] {"lessThan", "<", "lessThanOrEqual", "<=", "equal", "=", "implicitEqual", "", "greaterThanOrEqual", ">=", "greaterThan", ">", }, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYEXPRESSION_20_0_0_2 = INSTANCE.getHYEXPRESSION_20_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYEXPRESSION_20_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), "QUOTED_34_34", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_20_0_0_3 = INSTANCE.getHYEXPRESSION_20_0_0_3();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_20_0_0_3() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("]", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_20_0_0 = INSTANCE.getHYEXPRESSION_20_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_20_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_20_0_0_0, HYEXPRESSION_20_0_0_1, HYEXPRESSION_20_0_0_2, HYEXPRESSION_20_0_0_3);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_20_0 = INSTANCE.getHYEXPRESSION_20_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_20_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_20_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyRelativeVersionRestriction
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_20 = INSTANCE.getHYEXPRESSION_20();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_20() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction(), HYEXPRESSION_20_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_21_0_0_0 = INSTANCE.getHYEXPRESSION_21_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_21_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("[", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionBooleanTerminal HYEXPRESSION_21_0_0_1 = INSTANCE.getHYEXPRESSION_21_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionBooleanTerminal getHYEXPRESSION_21_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), "", "^", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYEXPRESSION_21_0_0_2 = INSTANCE.getHYEXPRESSION_21_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYEXPRESSION_21_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), "QUOTED_34_34", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_21_0_0_3 = INSTANCE.getHYEXPRESSION_21_0_0_3();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_21_0_0_3() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("-", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionBooleanTerminal HYEXPRESSION_21_0_0_4 = INSTANCE.getHYEXPRESSION_21_0_0_4();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionBooleanTerminal getHYEXPRESSION_21_0_0_4() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), "", "^", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYEXPRESSION_21_0_0_5 = INSTANCE.getHYEXPRESSION_21_0_0_5();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYEXPRESSION_21_0_0_5() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), "QUOTED_34_34", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYEXPRESSION_21_0_0_6 = INSTANCE.getHYEXPRESSION_21_0_0_6();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYEXPRESSION_21_0_0_6() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("]", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYEXPRESSION_21_0_0 = INSTANCE.getHYEXPRESSION_21_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYEXPRESSION_21_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_21_0_0_0, HYEXPRESSION_21_0_0_1, HYEXPRESSION_21_0_0_2, HYEXPRESSION_21_0_0_3, HYEXPRESSION_21_0_0_4, HYEXPRESSION_21_0_0_5, HYEXPRESSION_21_0_0_6);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYEXPRESSION_21_0 = INSTANCE.getHYEXPRESSION_21_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYEXPRESSION_21_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYEXPRESSION_21_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyVersionRangeRestriction
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYEXPRESSION_21 = INSTANCE.getHYEXPRESSION_21();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYEXPRESSION_21() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction(), HYEXPRESSION_21_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_0_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_0_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_NUMBER_VALUE__VALUE), "INTEGER_LITERAL", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_0_0_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYDATAVALUE_0_0 = INSTANCE.getHYDATAVALUE_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYDATAVALUE_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_0_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyNumberValue
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYDATAVALUE_0 = INSTANCE.getHYDATAVALUE_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYDATAVALUE_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue(), HYDATAVALUE_0_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionBooleanTerminal HYDATAVALUE_1_0_0_0 = INSTANCE.getHYDATAVALUE_1_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionBooleanTerminal getHYDATAVALUE_1_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionBooleanTerminal(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), "true", "false", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_1_0_0 = INSTANCE.getHYDATAVALUE_1_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_1_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYDATAVALUE_1_0 = INSTANCE.getHYDATAVALUE_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYDATAVALUE_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_1_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyBooleanValue
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYDATAVALUE_1 = INSTANCE.getHYDATAVALUE_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYDATAVALUE_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue(), HYDATAVALUE_1_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_2_0_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_2_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("enum:", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_2_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_1_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_2_0_0_1_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), "QUOTED_34_34", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_2_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_1_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_2_0_0_1_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_2_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_2_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_2_0_0_1_0_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_2_0_0_1_0_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), "IDENTIFIER_TOKEN", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_2_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_2_0_0_1_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_2_0_0_1_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_2_0_0_1_0_1_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYDATAVALUE_2_0_0_1_0 = INSTANCE.getHYDATAVALUE_2_0_0_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYDATAVALUE_2_0_0_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_2_0_0_1_0_0, HYDATAVALUE_2_0_0_1_0_1);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound HYDATAVALUE_2_0_0_1 = INSTANCE.getHYDATAVALUE_2_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound getHYDATAVALUE_2_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound(HYDATAVALUE_2_0_0_1_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_2_0_0_2 = INSTANCE.getHYDATAVALUE_2_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_2_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword(".", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_2_0_0_3_0_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_3_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_2_0_0_3_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), "QUOTED_34_34", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_2_0_0_3_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_3_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_2_0_0_3_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_2_0_0_3_0_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_2_0_0_3_0_1_0 = INSTANCE.getHYDATAVALUE_2_0_0_3_0_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_2_0_0_3_0_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), "IDENTIFIER_TOKEN", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_2_0_0_3_0_1 = INSTANCE.getHYDATAVALUE_2_0_0_3_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_2_0_0_3_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_2_0_0_3_0_1_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYDATAVALUE_2_0_0_3_0 = INSTANCE.getHYDATAVALUE_2_0_0_3_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYDATAVALUE_2_0_0_3_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_2_0_0_3_0_0, HYDATAVALUE_2_0_0_3_0_1);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound HYDATAVALUE_2_0_0_3 = INSTANCE.getHYDATAVALUE_2_0_0_3();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound getHYDATAVALUE_2_0_0_3() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound(HYDATAVALUE_2_0_0_3_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_2_0_0 = INSTANCE.getHYDATAVALUE_2_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_2_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_2_0_0_0, HYDATAVALUE_2_0_0_1, HYDATAVALUE_2_0_0_2, HYDATAVALUE_2_0_0_3);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYDATAVALUE_2_0 = INSTANCE.getHYDATAVALUE_2_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYDATAVALUE_2_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_2_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class HyEnumValue
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYDATAVALUE_2 = INSTANCE.getHYDATAVALUE_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYDATAVALUE_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue(), HYDATAVALUE_2_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_3_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("Enum(", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_3_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__NAME), "IDENTIFIER_TOKEN", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_3_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_3_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword(",", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYDATAVALUE_3_0_0_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYDATAVALUE_3_0_0_3_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_3_0_0_3_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword(",", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment HYDATAVALUE_3_0_0_3_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_3_0_0_3_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_3_0_0_3_0_0_1_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1_0_0_1);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYDATAVALUE_3_0_0_3_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYDATAVALUE_3_0_0_3_0_0_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound HYDATAVALUE_3_0_0_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound getHYDATAVALUE_3_0_0_3_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound(HYDATAVALUE_3_0_0_3_0_0_1_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.STAR);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_3_0_0_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_3_0_0_3_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYDATAVALUE_3_0_0_3_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYDATAVALUE_3_0_0_3_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound HYDATAVALUE_3_0_0_3 = INSTANCE.getHYDATAVALUE_3_0_0_3();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound getHYDATAVALUE_3_0_0_3() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound(HYDATAVALUE_3_0_0_3_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_3_0_0_4 = INSTANCE.getHYDATAVALUE_3_0_0_4();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_3_0_0_4() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword(")", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_3_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_3_0_0_5_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("[", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("-", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_3_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("-", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_3_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1_1);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("eternity", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("-", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_3_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYDATAVALUE_3_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYDATAVALUE_3_0_0_5_0_0_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound HYDATAVALUE_3_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound getHYDATAVALUE_3_0_0_5_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound(HYDATAVALUE_3_0_0_5_0_0_1_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_3_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_3_0_0_5_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("]", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_3_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_3_0_0_5_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1, HYDATAVALUE_3_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYDATAVALUE_3_0_0_5_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYDATAVALUE_3_0_0_5_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound HYDATAVALUE_3_0_0_5 = INSTANCE.getHYDATAVALUE_3_0_0_5();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound getHYDATAVALUE_3_0_0_5() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound(HYDATAVALUE_3_0_0_5_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_3_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_3_0_0_0, HYDATAVALUE_3_0_0_1, HYDATAVALUE_3_0_0_2, HYDATAVALUE_3_0_0_3, HYDATAVALUE_3_0_0_4, HYDATAVALUE_3_0_0_5);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYDATAVALUE_3_0 = INSTANCE.getHYDATAVALUE_3_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYDATAVALUE_3_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_3_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class HyEnum
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYDATAVALUE_3 = INSTANCE.getHYDATAVALUE_3();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYDATAVALUE_3() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), HYDATAVALUE_3_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_4_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_4_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("EnumLiteral(", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_4_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_4_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__NAME), "IDENTIFIER_TOKEN", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_4_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_4_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword(",", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_4_0_0_3 = INSTANCE.getHYDATAVALUE_4_0_0_3();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_4_0_0_3() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALUE), "INTEGER_LITERAL", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_4_0_0_4 = INSTANCE.getHYDATAVALUE_4_0_0_4();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_4_0_0_4() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword(")", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_4_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_4_0_0_5_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("[", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("-", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_4_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("-", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("eternity", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_4_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, HYDATAVALUE_4_0_0_5_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("eternity", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("-", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_4_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYDATAVALUE_4_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYDATAVALUE_4_0_0_5_0_0_1_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound HYDATAVALUE_4_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound getHYDATAVALUE_4_0_0_5_0_0_1() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound(HYDATAVALUE_4_0_0_5_0_0_1_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword HYDATAVALUE_4_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_2();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword getHYDATAVALUE_4_0_0_5_0_0_2() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword("]", eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_4_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_4_0_0_5_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1, HYDATAVALUE_4_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYDATAVALUE_4_0_0_5_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYDATAVALUE_4_0_0_5_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound HYDATAVALUE_4_0_0_5 = INSTANCE.getHYDATAVALUE_4_0_0_5();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound getHYDATAVALUE_4_0_0_5() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCompound(HYDATAVALUE_4_0_0_5_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence HYDATAVALUE_4_0_0 = INSTANCE.getHYDATAVALUE_4_0_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence getHYDATAVALUE_4_0_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSequence(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_4_0_0_0, HYDATAVALUE_4_0_0_1, HYDATAVALUE_4_0_0_2, HYDATAVALUE_4_0_0_3, HYDATAVALUE_4_0_0_4, HYDATAVALUE_4_0_0_5);
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice HYDATAVALUE_4_0 = INSTANCE.getHYDATAVALUE_4_0();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice getHYDATAVALUE_4_0() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionChoice(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE, HYDATAVALUE_4_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyEnumLiteral
	 */
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule HYDATAVALUE_4 = INSTANCE.getHYDATAVALUE_4();
	private eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule getHYDATAVALUE_4() {
		return new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), HYDATAVALUE_4_0, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality.ONE);
	}
	
	
	public static String getSyntaxElementID(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (Field field : eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.class.getFields()) {
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
	
	public static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement) eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule[] RULES = new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule[] {
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
			for (eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement element, Set<String> keywords) {
		if (element instanceof eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword) {
			keywords.add(((eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionKeyword) element).getValue());
		} else if (element instanceof eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionBooleanTerminal) {
			keywords.add(((eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionBooleanTerminal) element).getTrueLiteral());
			keywords.add(((eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionEnumerationTerminal) {
			eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionEnumerationTerminal terminal = (eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
