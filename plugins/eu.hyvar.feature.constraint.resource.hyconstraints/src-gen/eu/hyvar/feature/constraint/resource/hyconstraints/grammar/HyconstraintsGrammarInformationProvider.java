/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.grammar;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class HyconstraintsGrammarInformationProvider {
	
	public final static EStructuralFeature ANONYMOUS_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static HyconstraintsGrammarInformationProvider INSTANCE = new HyconstraintsGrammarInformationProvider();
	
	private Set<String> keywords;
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYCONSTRAINTS_0_0_0_0 = INSTANCE.getHYCONSTRAINTS_0_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYCONSTRAINTS_0_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT_MODEL__CONSTRAINTS), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.STAR, new EClass[] {eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraint(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYCONSTRAINTS_0_0_0 = INSTANCE.getHYCONSTRAINTS_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYCONSTRAINTS_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYCONSTRAINTS_0_0_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYCONSTRAINTS_0_0 = INSTANCE.getHYCONSTRAINTS_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYCONSTRAINTS_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYCONSTRAINTS_0_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYCONSTRAINTS_0 = INSTANCE.getHYCONSTRAINTS_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYCONSTRAINTS_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), HYCONSTRAINTS_0_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYCONSTRAINTS_1_0_0_0 = INSTANCE.getHYCONSTRAINTS_1_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYCONSTRAINTS_1_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraint().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__ROOT_EXPRESSION), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYCONSTRAINTS_1_0_0_1_0_0_0 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYCONSTRAINTS_1_0_0_1_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("[", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYCONSTRAINTS_1_0_0_1_0_0_1_0_0_0 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_1_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYCONSTRAINTS_1_0_0_1_0_0_1_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraint().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_SINCE), "DATE", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYCONSTRAINTS_1_0_0_1_0_0_1_0_0_1 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_1_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYCONSTRAINTS_1_0_0_1_0_0_1_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("-", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYCONSTRAINTS_1_0_0_1_0_0_1_0_0_2 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_1_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYCONSTRAINTS_1_0_0_1_0_0_1_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraint().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_UNTIL), "DATE", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYCONSTRAINTS_1_0_0_1_0_0_1_0_0 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_1_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYCONSTRAINTS_1_0_0_1_0_0_1_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYCONSTRAINTS_1_0_0_1_0_0_1_0_0_0, HYCONSTRAINTS_1_0_0_1_0_0_1_0_0_1, HYCONSTRAINTS_1_0_0_1_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYCONSTRAINTS_1_0_0_1_0_0_1_0_1_0 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_1_0_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYCONSTRAINTS_1_0_0_1_0_0_1_0_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraint().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_SINCE), "DATE", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYCONSTRAINTS_1_0_0_1_0_0_1_0_1_1 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_1_0_1_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYCONSTRAINTS_1_0_0_1_0_0_1_0_1_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("-", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYCONSTRAINTS_1_0_0_1_0_0_1_0_1_2 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_1_0_1_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYCONSTRAINTS_1_0_0_1_0_0_1_0_1_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("eternity", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYCONSTRAINTS_1_0_0_1_0_0_1_0_1 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_1_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYCONSTRAINTS_1_0_0_1_0_0_1_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYCONSTRAINTS_1_0_0_1_0_0_1_0_1_0, HYCONSTRAINTS_1_0_0_1_0_0_1_0_1_1, HYCONSTRAINTS_1_0_0_1_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYCONSTRAINTS_1_0_0_1_0_0_1_0_2_0 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_1_0_2_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYCONSTRAINTS_1_0_0_1_0_0_1_0_2_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("eternity", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYCONSTRAINTS_1_0_0_1_0_0_1_0_2_1 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_1_0_2_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYCONSTRAINTS_1_0_0_1_0_0_1_0_2_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("-", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYCONSTRAINTS_1_0_0_1_0_0_1_0_2_2 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_1_0_2_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYCONSTRAINTS_1_0_0_1_0_0_1_0_2_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraint().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_UNTIL), "DATE", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYCONSTRAINTS_1_0_0_1_0_0_1_0_2 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_1_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYCONSTRAINTS_1_0_0_1_0_0_1_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYCONSTRAINTS_1_0_0_1_0_0_1_0_2_0, HYCONSTRAINTS_1_0_0_1_0_0_1_0_2_1, HYCONSTRAINTS_1_0_0_1_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYCONSTRAINTS_1_0_0_1_0_0_1_0 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYCONSTRAINTS_1_0_0_1_0_0_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYCONSTRAINTS_1_0_0_1_0_0_1_0_0, HYCONSTRAINTS_1_0_0_1_0_0_1_0_1, HYCONSTRAINTS_1_0_0_1_0_0_1_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound HYCONSTRAINTS_1_0_0_1_0_0_1 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound getHYCONSTRAINTS_1_0_0_1_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound(HYCONSTRAINTS_1_0_0_1_0_0_1_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYCONSTRAINTS_1_0_0_1_0_0_2 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYCONSTRAINTS_1_0_0_1_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("]", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYCONSTRAINTS_1_0_0_1_0_0 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYCONSTRAINTS_1_0_0_1_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYCONSTRAINTS_1_0_0_1_0_0_0, HYCONSTRAINTS_1_0_0_1_0_0_1, HYCONSTRAINTS_1_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYCONSTRAINTS_1_0_0_1_0 = INSTANCE.getHYCONSTRAINTS_1_0_0_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYCONSTRAINTS_1_0_0_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYCONSTRAINTS_1_0_0_1_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound HYCONSTRAINTS_1_0_0_1 = INSTANCE.getHYCONSTRAINTS_1_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound getHYCONSTRAINTS_1_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound(HYCONSTRAINTS_1_0_0_1_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYCONSTRAINTS_1_0_0 = INSTANCE.getHYCONSTRAINTS_1_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYCONSTRAINTS_1_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYCONSTRAINTS_1_0_0_0, HYCONSTRAINTS_1_0_0_1);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYCONSTRAINTS_1_0 = INSTANCE.getHYCONSTRAINTS_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYCONSTRAINTS_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYCONSTRAINTS_1_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYCONSTRAINTS_1 = INSTANCE.getHYCONSTRAINTS_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYCONSTRAINTS_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraint(), HYCONSTRAINTS_1_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_0_0_0_0 = INSTANCE.getHYEXPRESSION_0_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_0_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND1), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_0_0_0_1 = INSTANCE.getHYEXPRESSION_0_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_0_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("<->", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_0_0_0_2 = INSTANCE.getHYEXPRESSION_0_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_0_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND2), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_0_0_0 = INSTANCE.getHYEXPRESSION_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_0_0_0_0, HYEXPRESSION_0_0_0_1, HYEXPRESSION_0_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_0_0 = INSTANCE.getHYEXPRESSION_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_0_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_0 = INSTANCE.getHYEXPRESSION_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), HYEXPRESSION_0_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_1_0_0_0 = INSTANCE.getHYEXPRESSION_1_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_1_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND1), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_1_0_0_1 = INSTANCE.getHYEXPRESSION_1_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_1_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("->", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_1_0_0_2 = INSTANCE.getHYEXPRESSION_1_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_1_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND2), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_1_0_0 = INSTANCE.getHYEXPRESSION_1_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_1_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_1_0_0_0, HYEXPRESSION_1_0_0_1, HYEXPRESSION_1_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_1_0 = INSTANCE.getHYEXPRESSION_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_1_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_1 = INSTANCE.getHYEXPRESSION_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), HYEXPRESSION_1_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_2_0_0_0 = INSTANCE.getHYEXPRESSION_2_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_2_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND1), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_2_0_0_1 = INSTANCE.getHYEXPRESSION_2_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_2_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("||", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_2_0_0_2 = INSTANCE.getHYEXPRESSION_2_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_2_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND2), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_2_0_0 = INSTANCE.getHYEXPRESSION_2_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_2_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_2_0_0_0, HYEXPRESSION_2_0_0_1, HYEXPRESSION_2_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_2_0 = INSTANCE.getHYEXPRESSION_2_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_2_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_2_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_2 = INSTANCE.getHYEXPRESSION_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), HYEXPRESSION_2_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_3_0_0_0 = INSTANCE.getHYEXPRESSION_3_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_3_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND1), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_3_0_0_1 = INSTANCE.getHYEXPRESSION_3_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_3_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("&&", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_3_0_0_2 = INSTANCE.getHYEXPRESSION_3_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_3_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND2), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_3_0_0 = INSTANCE.getHYEXPRESSION_3_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_3_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_3_0_0_0, HYEXPRESSION_3_0_0_1, HYEXPRESSION_3_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_3_0 = INSTANCE.getHYEXPRESSION_3_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_3_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_3_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_3 = INSTANCE.getHYEXPRESSION_3();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_3() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), HYEXPRESSION_3_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_4_0_0_0 = INSTANCE.getHYEXPRESSION_4_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_4_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("!", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_4_0_0_1 = INSTANCE.getHYEXPRESSION_4_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_4_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EXPRESSION__OPERAND), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_4_0_0 = INSTANCE.getHYEXPRESSION_4_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_4_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_4_0_0_0, HYEXPRESSION_4_0_0_1);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_4_0 = INSTANCE.getHYEXPRESSION_4_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_4_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_4_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_4 = INSTANCE.getHYEXPRESSION_4();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_4() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), HYEXPRESSION_4_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_5_0_0_0 = INSTANCE.getHYEXPRESSION_5_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_5_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("-", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_5_0_0_1 = INSTANCE.getHYEXPRESSION_5_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_5_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NEGATION_EXPRESSION__OPERAND), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_5_0_0 = INSTANCE.getHYEXPRESSION_5_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_5_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_5_0_0_0, HYEXPRESSION_5_0_0_1);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_5_0 = INSTANCE.getHYEXPRESSION_5_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_5_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_5_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_5 = INSTANCE.getHYEXPRESSION_5();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_5() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), HYEXPRESSION_5_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_6_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_6_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("(", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_6_0_0_1 = INSTANCE.getHYEXPRESSION_6_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_6_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NESTED_EXPRESSION__OPERAND), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_6_0_0_2 = INSTANCE.getHYEXPRESSION_6_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_6_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword(")", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_6_0_0 = INSTANCE.getHYEXPRESSION_6_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_6_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_6_0_0_0, HYEXPRESSION_6_0_0_1, HYEXPRESSION_6_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_6_0 = INSTANCE.getHYEXPRESSION_6_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_6_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_6_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_6 = INSTANCE.getHYEXPRESSION_6();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_6() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), HYEXPRESSION_6_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYEXPRESSION_7_0_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_0_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYEXPRESSION_7_0_0_0_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_7_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_7_0_0_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_7_0_0_0_0_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYEXPRESSION_7_0_0_0_0_1_0 = INSTANCE.getHYEXPRESSION_7_0_0_0_0_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYEXPRESSION_7_0_0_0_0_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_7_0_0_0_0_1 = INSTANCE.getHYEXPRESSION_7_0_0_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_7_0_0_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_7_0_0_0_0_1_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_7_0_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_7_0_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_7_0_0_0_0_0, HYEXPRESSION_7_0_0_0_0_1);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound HYEXPRESSION_7_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound getHYEXPRESSION_7_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound(HYEXPRESSION_7_0_0_0_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_7_0_0_1_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_7_0_0_1_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRestriction(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_7_0_0_1_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_7_0_0_1_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_7_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_7_0_0_1_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_7_0_0_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_7_0_0_1_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound HYEXPRESSION_7_0_0_1 = INSTANCE.getHYEXPRESSION_7_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound getHYEXPRESSION_7_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound(HYEXPRESSION_7_0_0_1_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_7_0_0 = INSTANCE.getHYEXPRESSION_7_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_7_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_7_0_0_0, HYEXPRESSION_7_0_0_1);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_7_0 = INSTANCE.getHYEXPRESSION_7_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_7_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_7_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_7 = INSTANCE.getHYEXPRESSION_7();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_7() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), HYEXPRESSION_7_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_8_0_0_0 = INSTANCE.getHYEXPRESSION_8_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_8_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("?", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYEXPRESSION_8_0_0_1_0_0_0 = INSTANCE.getHYEXPRESSION_8_0_0_1_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYEXPRESSION_8_0_0_1_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_8_0_0_1_0_0 = INSTANCE.getHYEXPRESSION_8_0_0_1_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_8_0_0_1_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_8_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYEXPRESSION_8_0_0_1_0_1_0 = INSTANCE.getHYEXPRESSION_8_0_0_1_0_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYEXPRESSION_8_0_0_1_0_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_8_0_0_1_0_1 = INSTANCE.getHYEXPRESSION_8_0_0_1_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_8_0_0_1_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_8_0_0_1_0_1_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_8_0_0_1_0 = INSTANCE.getHYEXPRESSION_8_0_0_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_8_0_0_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_8_0_0_1_0_0, HYEXPRESSION_8_0_0_1_0_1);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound HYEXPRESSION_8_0_0_1 = INSTANCE.getHYEXPRESSION_8_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound getHYEXPRESSION_8_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound(HYEXPRESSION_8_0_0_1_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_8_0_0_2 = INSTANCE.getHYEXPRESSION_8_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_8_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRestriction(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_8_0_0 = INSTANCE.getHYEXPRESSION_8_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_8_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_8_0_0_0, HYEXPRESSION_8_0_0_1, HYEXPRESSION_8_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_8_0 = INSTANCE.getHYEXPRESSION_8_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_8_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_8_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_8 = INSTANCE.getHYEXPRESSION_8();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_8() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), HYEXPRESSION_8_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_9_0_0_0 = INSTANCE.getHYEXPRESSION_9_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_9_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("context:", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYEXPRESSION_9_0_0_1 = INSTANCE.getHYEXPRESSION_9_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYEXPRESSION_9_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), "IDENTIFIER_TOKEN", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_9_0_0 = INSTANCE.getHYEXPRESSION_9_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_9_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_9_0_0_0, HYEXPRESSION_9_0_0_1);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_9_0 = INSTANCE.getHYEXPRESSION_9_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_9_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_9_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_9 = INSTANCE.getHYEXPRESSION_9();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_9() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression(), HYEXPRESSION_9_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYEXPRESSION_10_0_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_10_0_0_0_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYEXPRESSION_10_0_0_0_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_10_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_10_0_0_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_10_0_0_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_10_0_0_0_0_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYEXPRESSION_10_0_0_0_0_1_0 = INSTANCE.getHYEXPRESSION_10_0_0_0_0_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYEXPRESSION_10_0_0_0_0_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_10_0_0_0_0_1 = INSTANCE.getHYEXPRESSION_10_0_0_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_10_0_0_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_10_0_0_0_0_1_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_10_0_0_0_0 = INSTANCE.getHYEXPRESSION_10_0_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_10_0_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_10_0_0_0_0_0, HYEXPRESSION_10_0_0_0_0_1);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound HYEXPRESSION_10_0_0_0 = INSTANCE.getHYEXPRESSION_10_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound getHYEXPRESSION_10_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound(HYEXPRESSION_10_0_0_0_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_10_0_0_1 = INSTANCE.getHYEXPRESSION_10_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_10_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword(".", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYEXPRESSION_10_0_0_2 = INSTANCE.getHYEXPRESSION_10_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYEXPRESSION_10_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), "IDENTIFIER_TOKEN", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_10_0_0 = INSTANCE.getHYEXPRESSION_10_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_10_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_10_0_0_0, HYEXPRESSION_10_0_0_1, HYEXPRESSION_10_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_10_0 = INSTANCE.getHYEXPRESSION_10_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_10_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_10_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_10 = INSTANCE.getHYEXPRESSION_10();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_10() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression(), HYEXPRESSION_10_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_11_0_0_0 = INSTANCE.getHYEXPRESSION_11_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_11_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VALUE_EXPRESSION__VALUE), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyValue(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_11_0_0 = INSTANCE.getHYEXPRESSION_11_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_11_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_11_0_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_11_0 = INSTANCE.getHYEXPRESSION_11_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_11_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_11_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_11 = INSTANCE.getHYEXPRESSION_11();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_11() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression(), HYEXPRESSION_11_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsBooleanTerminal HYEXPRESSION_12_0_0_0 = INSTANCE.getHYEXPRESSION_12_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsBooleanTerminal getHYEXPRESSION_12_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyBooleanValueExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), "true", "false", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_12_0_0 = INSTANCE.getHYEXPRESSION_12_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_12_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_12_0_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_12_0 = INSTANCE.getHYEXPRESSION_12_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_12_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_12_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_12 = INSTANCE.getHYEXPRESSION_12();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_12() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyBooleanValueExpression(), HYEXPRESSION_12_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_13_0_0_0 = INSTANCE.getHYEXPRESSION_13_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_13_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("min(", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_13_0_0_1 = INSTANCE.getHYEXPRESSION_13_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_13_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MINIMUM_EXPRESSION__OPERAND), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_13_0_0_2 = INSTANCE.getHYEXPRESSION_13_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_13_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword(")", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_13_0_0 = INSTANCE.getHYEXPRESSION_13_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_13_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_13_0_0_0, HYEXPRESSION_13_0_0_1, HYEXPRESSION_13_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_13_0 = INSTANCE.getHYEXPRESSION_13_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_13_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_13_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_13 = INSTANCE.getHYEXPRESSION_13();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_13() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), HYEXPRESSION_13_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_14_0_0_0 = INSTANCE.getHYEXPRESSION_14_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_14_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("max(", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_14_0_0_1 = INSTANCE.getHYEXPRESSION_14_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_14_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MAXIMUM_EXPRESSION__OPERAND), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_14_0_0_2 = INSTANCE.getHYEXPRESSION_14_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_14_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword(")", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_14_0_0 = INSTANCE.getHYEXPRESSION_14_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_14_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_14_0_0_0, HYEXPRESSION_14_0_0_1, HYEXPRESSION_14_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_14_0 = INSTANCE.getHYEXPRESSION_14_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_14_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_14_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_14 = INSTANCE.getHYEXPRESSION_14();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_14() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), HYEXPRESSION_14_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_15_0_0_0 = INSTANCE.getHYEXPRESSION_15_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_15_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("ifPossible(", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_15_0_0_1 = INSTANCE.getHYEXPRESSION_15_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_15_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IF_POSSIBLE_EXPRESSION__OPERANDS), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_15_0_0_2_0_0_0 = INSTANCE.getHYEXPRESSION_15_0_0_2_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_15_0_0_2_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword(",", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_15_0_0_2_0_0_1 = INSTANCE.getHYEXPRESSION_15_0_0_2_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_15_0_0_2_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IF_POSSIBLE_EXPRESSION__OPERANDS), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_15_0_0_2_0_0 = INSTANCE.getHYEXPRESSION_15_0_0_2_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_15_0_0_2_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_15_0_0_2_0_0_0, HYEXPRESSION_15_0_0_2_0_0_1);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_15_0_0_2_0 = INSTANCE.getHYEXPRESSION_15_0_0_2_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_15_0_0_2_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_15_0_0_2_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound HYEXPRESSION_15_0_0_2 = INSTANCE.getHYEXPRESSION_15_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound getHYEXPRESSION_15_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound(HYEXPRESSION_15_0_0_2_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.STAR);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_15_0_0_3 = INSTANCE.getHYEXPRESSION_15_0_0_3();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_15_0_0_3() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword(")", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_15_0_0 = INSTANCE.getHYEXPRESSION_15_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_15_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_15_0_0_0, HYEXPRESSION_15_0_0_1, HYEXPRESSION_15_0_0_2, HYEXPRESSION_15_0_0_3);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_15_0 = INSTANCE.getHYEXPRESSION_15_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_15_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_15_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_15 = INSTANCE.getHYEXPRESSION_15();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_15() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), HYEXPRESSION_15_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_16_0_0_0 = INSTANCE.getHYEXPRESSION_16_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_16_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_EXPRESSION__OPERAND1), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_16_0_0_1 = INSTANCE.getHYEXPRESSION_16_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_16_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("<", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_16_0_0_2 = INSTANCE.getHYEXPRESSION_16_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_16_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_EXPRESSION__OPERAND2), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_16_0_0 = INSTANCE.getHYEXPRESSION_16_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_16_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_16_0_0_0, HYEXPRESSION_16_0_0_1, HYEXPRESSION_16_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_16_0 = INSTANCE.getHYEXPRESSION_16_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_16_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_16_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_16 = INSTANCE.getHYEXPRESSION_16();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_16() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), HYEXPRESSION_16_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_17_0_0_0 = INSTANCE.getHYEXPRESSION_17_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_17_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_OR_EQUAL_EXPRESSION__OPERAND1), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_17_0_0_1 = INSTANCE.getHYEXPRESSION_17_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_17_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("<=", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_17_0_0_2 = INSTANCE.getHYEXPRESSION_17_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_17_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_OR_EQUAL_EXPRESSION__OPERAND2), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_17_0_0 = INSTANCE.getHYEXPRESSION_17_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_17_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_17_0_0_0, HYEXPRESSION_17_0_0_1, HYEXPRESSION_17_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_17_0 = INSTANCE.getHYEXPRESSION_17_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_17_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_17_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_17 = INSTANCE.getHYEXPRESSION_17();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_17() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), HYEXPRESSION_17_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_18_0_0_0 = INSTANCE.getHYEXPRESSION_18_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_18_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_EXPRESSION__OPERAND1), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_18_0_0_1 = INSTANCE.getHYEXPRESSION_18_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_18_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword(">", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_18_0_0_2 = INSTANCE.getHYEXPRESSION_18_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_18_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_EXPRESSION__OPERAND2), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_18_0_0 = INSTANCE.getHYEXPRESSION_18_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_18_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_18_0_0_0, HYEXPRESSION_18_0_0_1, HYEXPRESSION_18_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_18_0 = INSTANCE.getHYEXPRESSION_18_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_18_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_18_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_18 = INSTANCE.getHYEXPRESSION_18();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_18() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), HYEXPRESSION_18_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_19_0_0_0 = INSTANCE.getHYEXPRESSION_19_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_19_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_OR_EQUAL_EXPRESSION__OPERAND1), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_19_0_0_1 = INSTANCE.getHYEXPRESSION_19_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_19_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword(">=", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_19_0_0_2 = INSTANCE.getHYEXPRESSION_19_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_19_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_OR_EQUAL_EXPRESSION__OPERAND2), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_19_0_0 = INSTANCE.getHYEXPRESSION_19_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_19_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_19_0_0_0, HYEXPRESSION_19_0_0_1, HYEXPRESSION_19_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_19_0 = INSTANCE.getHYEXPRESSION_19_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_19_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_19_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_19 = INSTANCE.getHYEXPRESSION_19();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_19() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), HYEXPRESSION_19_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_20_0_0_0 = INSTANCE.getHYEXPRESSION_20_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_20_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND1), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_20_0_0_1 = INSTANCE.getHYEXPRESSION_20_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_20_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("-", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_20_0_0_2 = INSTANCE.getHYEXPRESSION_20_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_20_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND2), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_20_0_0 = INSTANCE.getHYEXPRESSION_20_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_20_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_20_0_0_0, HYEXPRESSION_20_0_0_1, HYEXPRESSION_20_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_20_0 = INSTANCE.getHYEXPRESSION_20_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_20_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_20_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_20 = INSTANCE.getHYEXPRESSION_20();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_20() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), HYEXPRESSION_20_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_21_0_0_0 = INSTANCE.getHYEXPRESSION_21_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_21_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND1), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_21_0_0_1 = INSTANCE.getHYEXPRESSION_21_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_21_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("+", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_21_0_0_2 = INSTANCE.getHYEXPRESSION_21_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_21_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND2), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_21_0_0 = INSTANCE.getHYEXPRESSION_21_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_21_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_21_0_0_0, HYEXPRESSION_21_0_0_1, HYEXPRESSION_21_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_21_0 = INSTANCE.getHYEXPRESSION_21_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_21_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_21_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_21 = INSTANCE.getHYEXPRESSION_21();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_21() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), HYEXPRESSION_21_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_22_0_0_0 = INSTANCE.getHYEXPRESSION_22_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_22_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND1), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_22_0_0_1 = INSTANCE.getHYEXPRESSION_22_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_22_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("%", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_22_0_0_2 = INSTANCE.getHYEXPRESSION_22_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_22_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND2), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_22_0_0 = INSTANCE.getHYEXPRESSION_22_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_22_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_22_0_0_0, HYEXPRESSION_22_0_0_1, HYEXPRESSION_22_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_22_0 = INSTANCE.getHYEXPRESSION_22_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_22_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_22_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_22 = INSTANCE.getHYEXPRESSION_22();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_22() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), HYEXPRESSION_22_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_23_0_0_0 = INSTANCE.getHYEXPRESSION_23_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_23_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND1), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_23_0_0_1 = INSTANCE.getHYEXPRESSION_23_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_23_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("*", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_23_0_0_2 = INSTANCE.getHYEXPRESSION_23_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_23_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND2), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_23_0_0 = INSTANCE.getHYEXPRESSION_23_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_23_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_23_0_0_0, HYEXPRESSION_23_0_0_1, HYEXPRESSION_23_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_23_0 = INSTANCE.getHYEXPRESSION_23_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_23_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_23_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_23 = INSTANCE.getHYEXPRESSION_23();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_23() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), HYEXPRESSION_23_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_24_0_0_0 = INSTANCE.getHYEXPRESSION_24_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_24_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND1), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_24_0_0_1 = INSTANCE.getHYEXPRESSION_24_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_24_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("/", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_24_0_0_2 = INSTANCE.getHYEXPRESSION_24_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_24_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND2), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_24_0_0 = INSTANCE.getHYEXPRESSION_24_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_24_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_24_0_0_0, HYEXPRESSION_24_0_0_1, HYEXPRESSION_24_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_24_0 = INSTANCE.getHYEXPRESSION_24_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_24_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_24_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_24 = INSTANCE.getHYEXPRESSION_24();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_24() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), HYEXPRESSION_24_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_25_0_0_0 = INSTANCE.getHYEXPRESSION_25_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_25_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUAL_EXPRESSION__OPERAND1), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_25_0_0_1 = INSTANCE.getHYEXPRESSION_25_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_25_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("=", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_25_0_0_2 = INSTANCE.getHYEXPRESSION_25_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_25_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUAL_EXPRESSION__OPERAND2), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_25_0_0 = INSTANCE.getHYEXPRESSION_25_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_25_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_25_0_0_0, HYEXPRESSION_25_0_0_1, HYEXPRESSION_25_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_25_0 = INSTANCE.getHYEXPRESSION_25_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_25_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_25_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_25 = INSTANCE.getHYEXPRESSION_25();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_25() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), HYEXPRESSION_25_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_26_0_0_0 = INSTANCE.getHYEXPRESSION_26_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_26_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EQUAL_EXPRESSION__OPERAND1), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_26_0_0_1 = INSTANCE.getHYEXPRESSION_26_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_26_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("!=", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYEXPRESSION_26_0_0_2 = INSTANCE.getHYEXPRESSION_26_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYEXPRESSION_26_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EQUAL_EXPRESSION__OPERAND2), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_26_0_0 = INSTANCE.getHYEXPRESSION_26_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_26_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_26_0_0_0, HYEXPRESSION_26_0_0_1, HYEXPRESSION_26_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_26_0 = INSTANCE.getHYEXPRESSION_26_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_26_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_26_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_26 = INSTANCE.getHYEXPRESSION_26();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_26() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), HYEXPRESSION_26_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_27_0_0_0 = INSTANCE.getHYEXPRESSION_27_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_27_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("[", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsEnumerationTerminal HYEXPRESSION_27_0_0_1 = INSTANCE.getHYEXPRESSION_27_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsEnumerationTerminal getHYEXPRESSION_27_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsEnumerationTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), new String[] {"lessThan", "<", "lessThanOrEqual", "<=", "equal", "=", "implicitEqual", "", "greaterThanOrEqual", ">=", "greaterThan", ">", }, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYEXPRESSION_27_0_0_2 = INSTANCE.getHYEXPRESSION_27_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYEXPRESSION_27_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), "QUOTED_34_34", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_27_0_0_3 = INSTANCE.getHYEXPRESSION_27_0_0_3();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_27_0_0_3() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("]", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_27_0_0 = INSTANCE.getHYEXPRESSION_27_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_27_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_27_0_0_0, HYEXPRESSION_27_0_0_1, HYEXPRESSION_27_0_0_2, HYEXPRESSION_27_0_0_3);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_27_0 = INSTANCE.getHYEXPRESSION_27_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_27_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_27_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_27 = INSTANCE.getHYEXPRESSION_27();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_27() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction(), HYEXPRESSION_27_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_28_0_0_0 = INSTANCE.getHYEXPRESSION_28_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_28_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("[", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsBooleanTerminal HYEXPRESSION_28_0_0_1 = INSTANCE.getHYEXPRESSION_28_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsBooleanTerminal getHYEXPRESSION_28_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), "", "^", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYEXPRESSION_28_0_0_2 = INSTANCE.getHYEXPRESSION_28_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYEXPRESSION_28_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), "QUOTED_34_34", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_28_0_0_3 = INSTANCE.getHYEXPRESSION_28_0_0_3();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_28_0_0_3() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("-", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsBooleanTerminal HYEXPRESSION_28_0_0_4 = INSTANCE.getHYEXPRESSION_28_0_0_4();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsBooleanTerminal getHYEXPRESSION_28_0_0_4() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), "", "^", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYEXPRESSION_28_0_0_5 = INSTANCE.getHYEXPRESSION_28_0_0_5();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYEXPRESSION_28_0_0_5() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), "QUOTED_34_34", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYEXPRESSION_28_0_0_6 = INSTANCE.getHYEXPRESSION_28_0_0_6();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYEXPRESSION_28_0_0_6() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("]", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYEXPRESSION_28_0_0 = INSTANCE.getHYEXPRESSION_28_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYEXPRESSION_28_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_28_0_0_0, HYEXPRESSION_28_0_0_1, HYEXPRESSION_28_0_0_2, HYEXPRESSION_28_0_0_3, HYEXPRESSION_28_0_0_4, HYEXPRESSION_28_0_0_5, HYEXPRESSION_28_0_0_6);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYEXPRESSION_28_0 = INSTANCE.getHYEXPRESSION_28_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYEXPRESSION_28_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYEXPRESSION_28_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYEXPRESSION_28 = INSTANCE.getHYEXPRESSION_28();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYEXPRESSION_28() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction(), HYEXPRESSION_28_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYDATAVALUE_0_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYDATAVALUE_0_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_NUMBER_VALUE__VALUE), "INTEGER_LITERAL", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYDATAVALUE_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYDATAVALUE_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_0_0_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYDATAVALUE_0_0 = INSTANCE.getHYDATAVALUE_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYDATAVALUE_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_0_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYDATAVALUE_0 = INSTANCE.getHYDATAVALUE_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYDATAVALUE_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue(), HYDATAVALUE_0_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsBooleanTerminal HYDATAVALUE_1_0_0_0 = INSTANCE.getHYDATAVALUE_1_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsBooleanTerminal getHYDATAVALUE_1_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsBooleanTerminal(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), "true", "false", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYDATAVALUE_1_0_0 = INSTANCE.getHYDATAVALUE_1_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYDATAVALUE_1_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_1_0_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYDATAVALUE_1_0 = INSTANCE.getHYDATAVALUE_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYDATAVALUE_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_1_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYDATAVALUE_1 = INSTANCE.getHYDATAVALUE_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYDATAVALUE_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue(), HYDATAVALUE_1_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_2_0_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_2_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("enum:", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYDATAVALUE_2_0_0_1 = INSTANCE.getHYDATAVALUE_2_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYDATAVALUE_2_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), "IDENTIFIER_TOKEN", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_2_0_0_2 = INSTANCE.getHYDATAVALUE_2_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_2_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword(".", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYDATAVALUE_2_0_0_3 = INSTANCE.getHYDATAVALUE_2_0_0_3();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYDATAVALUE_2_0_0_3() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), "IDENTIFIER_TOKEN", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYDATAVALUE_2_0_0 = INSTANCE.getHYDATAVALUE_2_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYDATAVALUE_2_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_2_0_0_0, HYDATAVALUE_2_0_0_1, HYDATAVALUE_2_0_0_2, HYDATAVALUE_2_0_0_3);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYDATAVALUE_2_0 = INSTANCE.getHYDATAVALUE_2_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYDATAVALUE_2_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_2_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYDATAVALUE_2 = INSTANCE.getHYDATAVALUE_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYDATAVALUE_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue(), HYDATAVALUE_2_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_3_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("Enum(", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYDATAVALUE_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYDATAVALUE_3_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__NAME), "IDENTIFIER_TOKEN", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_3_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_3_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword(",", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYDATAVALUE_3_0_0_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYDATAVALUE_3_0_0_3_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_3_0_0_3_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword(",", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment HYDATAVALUE_3_0_0_3_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYDATAVALUE_3_0_0_3_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYDATAVALUE_3_0_0_3_0_0_1_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1_0_0_1);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYDATAVALUE_3_0_0_3_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYDATAVALUE_3_0_0_3_0_0_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound HYDATAVALUE_3_0_0_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound getHYDATAVALUE_3_0_0_3_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound(HYDATAVALUE_3_0_0_3_0_0_1_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.STAR);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYDATAVALUE_3_0_0_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYDATAVALUE_3_0_0_3_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYDATAVALUE_3_0_0_3_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYDATAVALUE_3_0_0_3_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound HYDATAVALUE_3_0_0_3 = INSTANCE.getHYDATAVALUE_3_0_0_3();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound getHYDATAVALUE_3_0_0_3() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound(HYDATAVALUE_3_0_0_3_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_3_0_0_4 = INSTANCE.getHYDATAVALUE_3_0_0_4();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_3_0_0_4() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword(")", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_3_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_3_0_0_5_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("[", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("-", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYDATAVALUE_3_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("-", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYDATAVALUE_3_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1_1);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("eternity", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("-", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYDATAVALUE_3_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYDATAVALUE_3_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYDATAVALUE_3_0_0_5_0_0_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound HYDATAVALUE_3_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound getHYDATAVALUE_3_0_0_5_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound(HYDATAVALUE_3_0_0_5_0_0_1_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_3_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_3_0_0_5_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("]", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYDATAVALUE_3_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYDATAVALUE_3_0_0_5_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1, HYDATAVALUE_3_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYDATAVALUE_3_0_0_5_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYDATAVALUE_3_0_0_5_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound HYDATAVALUE_3_0_0_5 = INSTANCE.getHYDATAVALUE_3_0_0_5();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound getHYDATAVALUE_3_0_0_5() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound(HYDATAVALUE_3_0_0_5_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYDATAVALUE_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYDATAVALUE_3_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_3_0_0_0, HYDATAVALUE_3_0_0_1, HYDATAVALUE_3_0_0_2, HYDATAVALUE_3_0_0_3, HYDATAVALUE_3_0_0_4, HYDATAVALUE_3_0_0_5);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYDATAVALUE_3_0 = INSTANCE.getHYDATAVALUE_3_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYDATAVALUE_3_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_3_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYDATAVALUE_3 = INSTANCE.getHYDATAVALUE_3();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYDATAVALUE_3() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), HYDATAVALUE_3_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_4_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_4_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("EnumLiteral(", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYDATAVALUE_4_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYDATAVALUE_4_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__NAME), "IDENTIFIER_TOKEN", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_4_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_4_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword(",", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYDATAVALUE_4_0_0_3 = INSTANCE.getHYDATAVALUE_4_0_0_3();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYDATAVALUE_4_0_0_3() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALUE), "INTEGER_LITERAL", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_4_0_0_4 = INSTANCE.getHYDATAVALUE_4_0_0_4();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_4_0_0_4() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword(")", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_4_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_4_0_0_5_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("[", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("-", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYDATAVALUE_4_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("-", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("eternity", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYDATAVALUE_4_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, HYDATAVALUE_4_0_0_5_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("eternity", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("-", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYDATAVALUE_4_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYDATAVALUE_4_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYDATAVALUE_4_0_0_5_0_0_1_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound HYDATAVALUE_4_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound getHYDATAVALUE_4_0_0_5_0_0_1() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound(HYDATAVALUE_4_0_0_5_0_0_1_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword HYDATAVALUE_4_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_2();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword getHYDATAVALUE_4_0_0_5_0_0_2() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword("]", eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYDATAVALUE_4_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYDATAVALUE_4_0_0_5_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1, HYDATAVALUE_4_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYDATAVALUE_4_0_0_5_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYDATAVALUE_4_0_0_5_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound HYDATAVALUE_4_0_0_5 = INSTANCE.getHYDATAVALUE_4_0_0_5();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound getHYDATAVALUE_4_0_0_5() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCompound(HYDATAVALUE_4_0_0_5_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence HYDATAVALUE_4_0_0 = INSTANCE.getHYDATAVALUE_4_0_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence getHYDATAVALUE_4_0_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSequence(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_4_0_0_0, HYDATAVALUE_4_0_0_1, HYDATAVALUE_4_0_0_2, HYDATAVALUE_4_0_0_3, HYDATAVALUE_4_0_0_4, HYDATAVALUE_4_0_0_5);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice HYDATAVALUE_4_0 = INSTANCE.getHYDATAVALUE_4_0();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice getHYDATAVALUE_4_0() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsChoice(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE, HYDATAVALUE_4_0_0);
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule HYDATAVALUE_4 = INSTANCE.getHYDATAVALUE_4();
	private eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule getHYDATAVALUE_4() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), HYDATAVALUE_4_0, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality.ONE);
	}
	
	
	public static String getSyntaxElementID(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (Field field : eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.class.getFields()) {
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
	
	public static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement) eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule[] RULES = new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule[] {
		HYCONSTRAINTS_0,
		HYCONSTRAINTS_1,
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
			for (eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement element, Set<String> keywords) {
		if (element instanceof eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword) {
			keywords.add(((eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsKeyword) element).getValue());
		} else if (element instanceof eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsBooleanTerminal) {
			keywords.add(((eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsBooleanTerminal) element).getTrueLiteral());
			keywords.add(((eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsEnumerationTerminal) {
			eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsEnumerationTerminal terminal = (eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
