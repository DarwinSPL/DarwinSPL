/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class HyvalidityformulaGrammarInformationProvider {
	
	public final static EStructuralFeature ANONYMOUS_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static HyvalidityformulaGrammarInformationProvider INSTANCE = new HyvalidityformulaGrammarInformationProvider();
	
	private Set<String> keywords;
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYVALIDITYFORMULA_0_0_0_0 = INSTANCE.getHYVALIDITYFORMULA_0_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYVALIDITYFORMULA_0_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_VALIDITY_MODEL__VALIDITY_FORMULAS), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.STAR, new EClass[] {eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityFormula(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYVALIDITYFORMULA_0_0_0 = INSTANCE.getHYVALIDITYFORMULA_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYVALIDITYFORMULA_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_0_0_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYVALIDITYFORMULA_0_0 = INSTANCE.getHYVALIDITYFORMULA_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYVALIDITYFORMULA_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_0_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYVALIDITYFORMULA_0 = INSTANCE.getHYVALIDITYFORMULA_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYVALIDITYFORMULA_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), HYVALIDITYFORMULA_0_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYVALIDITYFORMULA_1_0_0_0_0_0_0 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_0_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYVALIDITYFORMULA_1_0_0_0_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__FEATURE), "QUOTED_34_34", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYVALIDITYFORMULA_1_0_0_0_0_0 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYVALIDITYFORMULA_1_0_0_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_1_0_0_0_0_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYVALIDITYFORMULA_1_0_0_0_0_1_0 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_0_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYVALIDITYFORMULA_1_0_0_0_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYVALIDITYFORMULA_1_0_0_0_0_1 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYVALIDITYFORMULA_1_0_0_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_1_0_0_0_0_1_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYVALIDITYFORMULA_1_0_0_0_0 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYVALIDITYFORMULA_1_0_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_1_0_0_0_0_0, HYVALIDITYFORMULA_1_0_0_0_0_1);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYVALIDITYFORMULA_1_0_0_0 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYVALIDITYFORMULA_1_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYVALIDITYFORMULA_1_0_0_0_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_1_0_0_1 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_1_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(":", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYVALIDITYFORMULA_1_0_0_2 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYVALIDITYFORMULA_1_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALIDITY_FORMULA), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_1_0_0_3_0_0_0 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_1_0_0_3_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("[", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_0 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_SINCE), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_1 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("-", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_2 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_UNTIL), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_0, HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_1, HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_0 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_SINCE), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_1 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("-", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_2 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("null", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_0, HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_1, HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_0 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("null", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_1 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("-", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_2 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_UNTIL), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_0, HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_1, HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYVALIDITYFORMULA_1_0_0_3_0_0_1_0 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYVALIDITYFORMULA_1_0_0_3_0_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0, HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1, HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYVALIDITYFORMULA_1_0_0_3_0_0_1 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYVALIDITYFORMULA_1_0_0_3_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYVALIDITYFORMULA_1_0_0_3_0_0_1_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_1_0_0_3_0_0_2 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_1_0_0_3_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("]", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYVALIDITYFORMULA_1_0_0_3_0_0 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYVALIDITYFORMULA_1_0_0_3_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_1_0_0_3_0_0_0, HYVALIDITYFORMULA_1_0_0_3_0_0_1, HYVALIDITYFORMULA_1_0_0_3_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYVALIDITYFORMULA_1_0_0_3_0 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYVALIDITYFORMULA_1_0_0_3_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_1_0_0_3_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYVALIDITYFORMULA_1_0_0_3 = INSTANCE.getHYVALIDITYFORMULA_1_0_0_3();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYVALIDITYFORMULA_1_0_0_3() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYVALIDITYFORMULA_1_0_0_3_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYVALIDITYFORMULA_1_0_0 = INSTANCE.getHYVALIDITYFORMULA_1_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYVALIDITYFORMULA_1_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_1_0_0_0, HYVALIDITYFORMULA_1_0_0_1, HYVALIDITYFORMULA_1_0_0_2, HYVALIDITYFORMULA_1_0_0_3);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYVALIDITYFORMULA_1_0 = INSTANCE.getHYVALIDITYFORMULA_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYVALIDITYFORMULA_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_1_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYVALIDITYFORMULA_1 = INSTANCE.getHYVALIDITYFORMULA_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYVALIDITYFORMULA_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), HYVALIDITYFORMULA_1_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYVALIDITYFORMULA_2_0_0_0_0_0_0 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_0_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYVALIDITYFORMULA_2_0_0_0_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__FEATURE), "QUOTED_34_34", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYVALIDITYFORMULA_2_0_0_0_0_0 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYVALIDITYFORMULA_2_0_0_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_2_0_0_0_0_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYVALIDITYFORMULA_2_0_0_0_0_1_0 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_0_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYVALIDITYFORMULA_2_0_0_0_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYVALIDITYFORMULA_2_0_0_0_0_1 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYVALIDITYFORMULA_2_0_0_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_2_0_0_0_0_1_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYVALIDITYFORMULA_2_0_0_0_0 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYVALIDITYFORMULA_2_0_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_2_0_0_0_0_0, HYVALIDITYFORMULA_2_0_0_0_0_1);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYVALIDITYFORMULA_2_0_0_0 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYVALIDITYFORMULA_2_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYVALIDITYFORMULA_2_0_0_0_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_2_0_0_1 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_2_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(".", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYVALIDITYFORMULA_2_0_0_2 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYVALIDITYFORMULA_2_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__ATTRIBUTE), "IDENTIFIER_TOKEN", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_2_0_0_3 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_3();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_2_0_0_3() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(":", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYVALIDITYFORMULA_2_0_0_4 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_4();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYVALIDITYFORMULA_2_0_0_4() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALIDITY_FORMULA), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_2_0_0_5_0_0_0 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_2_0_0_5_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("[", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_SINCE), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("-", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_UNTIL), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_0, HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_1, HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_SINCE), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("-", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_2 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("null", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_0, HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_1, HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("null", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("-", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_UNTIL), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_0, HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_1, HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYVALIDITYFORMULA_2_0_0_5_0_0_1_0 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYVALIDITYFORMULA_2_0_0_5_0_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0, HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1, HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYVALIDITYFORMULA_2_0_0_5_0_0_1 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYVALIDITYFORMULA_2_0_0_5_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYVALIDITYFORMULA_2_0_0_5_0_0_1_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYVALIDITYFORMULA_2_0_0_5_0_0_2 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYVALIDITYFORMULA_2_0_0_5_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("]", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYVALIDITYFORMULA_2_0_0_5_0_0 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYVALIDITYFORMULA_2_0_0_5_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_2_0_0_5_0_0_0, HYVALIDITYFORMULA_2_0_0_5_0_0_1, HYVALIDITYFORMULA_2_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYVALIDITYFORMULA_2_0_0_5_0 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYVALIDITYFORMULA_2_0_0_5_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_2_0_0_5_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYVALIDITYFORMULA_2_0_0_5 = INSTANCE.getHYVALIDITYFORMULA_2_0_0_5();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYVALIDITYFORMULA_2_0_0_5() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYVALIDITYFORMULA_2_0_0_5_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYVALIDITYFORMULA_2_0_0 = INSTANCE.getHYVALIDITYFORMULA_2_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYVALIDITYFORMULA_2_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_2_0_0_0, HYVALIDITYFORMULA_2_0_0_1, HYVALIDITYFORMULA_2_0_0_2, HYVALIDITYFORMULA_2_0_0_3, HYVALIDITYFORMULA_2_0_0_4, HYVALIDITYFORMULA_2_0_0_5);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYVALIDITYFORMULA_2_0 = INSTANCE.getHYVALIDITYFORMULA_2_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYVALIDITYFORMULA_2_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYVALIDITYFORMULA_2_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYVALIDITYFORMULA_2 = INSTANCE.getHYVALIDITYFORMULA_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYVALIDITYFORMULA_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), HYVALIDITYFORMULA_2_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_0_0_0_0 = INSTANCE.getHYEXPRESSION_0_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_0_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND1), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_0_0_0_1 = INSTANCE.getHYEXPRESSION_0_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_0_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("<->", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_0_0_0_2 = INSTANCE.getHYEXPRESSION_0_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_0_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND2), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_0_0_0 = INSTANCE.getHYEXPRESSION_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_0_0_0_0, HYEXPRESSION_0_0_0_1, HYEXPRESSION_0_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_0_0 = INSTANCE.getHYEXPRESSION_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_0_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_0 = INSTANCE.getHYEXPRESSION_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), HYEXPRESSION_0_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_1_0_0_0 = INSTANCE.getHYEXPRESSION_1_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_1_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND1), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_1_0_0_1 = INSTANCE.getHYEXPRESSION_1_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_1_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("->", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_1_0_0_2 = INSTANCE.getHYEXPRESSION_1_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_1_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND2), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_1_0_0 = INSTANCE.getHYEXPRESSION_1_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_1_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_1_0_0_0, HYEXPRESSION_1_0_0_1, HYEXPRESSION_1_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_1_0 = INSTANCE.getHYEXPRESSION_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_1_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_1 = INSTANCE.getHYEXPRESSION_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), HYEXPRESSION_1_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_2_0_0_0 = INSTANCE.getHYEXPRESSION_2_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_2_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND1), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_2_0_0_1 = INSTANCE.getHYEXPRESSION_2_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_2_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("||", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_2_0_0_2 = INSTANCE.getHYEXPRESSION_2_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_2_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND2), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_2_0_0 = INSTANCE.getHYEXPRESSION_2_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_2_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_2_0_0_0, HYEXPRESSION_2_0_0_1, HYEXPRESSION_2_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_2_0 = INSTANCE.getHYEXPRESSION_2_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_2_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_2_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_2 = INSTANCE.getHYEXPRESSION_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), HYEXPRESSION_2_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_3_0_0_0 = INSTANCE.getHYEXPRESSION_3_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_3_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND1), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_3_0_0_1 = INSTANCE.getHYEXPRESSION_3_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_3_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("&&", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_3_0_0_2 = INSTANCE.getHYEXPRESSION_3_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_3_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND2), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_3_0_0 = INSTANCE.getHYEXPRESSION_3_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_3_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_3_0_0_0, HYEXPRESSION_3_0_0_1, HYEXPRESSION_3_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_3_0 = INSTANCE.getHYEXPRESSION_3_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_3_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_3_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_3 = INSTANCE.getHYEXPRESSION_3();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_3() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), HYEXPRESSION_3_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_4_0_0_0 = INSTANCE.getHYEXPRESSION_4_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_4_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("!", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_4_0_0_1 = INSTANCE.getHYEXPRESSION_4_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_4_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EXPRESSION__OPERAND), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_4_0_0 = INSTANCE.getHYEXPRESSION_4_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_4_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_4_0_0_0, HYEXPRESSION_4_0_0_1);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_4_0 = INSTANCE.getHYEXPRESSION_4_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_4_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_4_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_4 = INSTANCE.getHYEXPRESSION_4();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_4() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), HYEXPRESSION_4_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_5_0_0_0 = INSTANCE.getHYEXPRESSION_5_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_5_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("-", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_5_0_0_1 = INSTANCE.getHYEXPRESSION_5_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_5_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NEGATION_EXPRESSION__OPERAND), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_5_0_0 = INSTANCE.getHYEXPRESSION_5_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_5_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_5_0_0_0, HYEXPRESSION_5_0_0_1);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_5_0 = INSTANCE.getHYEXPRESSION_5_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_5_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_5_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_5 = INSTANCE.getHYEXPRESSION_5();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_5() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), HYEXPRESSION_5_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_6_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_6_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("(", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_6_0_0_1 = INSTANCE.getHYEXPRESSION_6_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_6_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NESTED_EXPRESSION__OPERAND), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_6_0_0_2 = INSTANCE.getHYEXPRESSION_6_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_6_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(")", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_6_0_0 = INSTANCE.getHYEXPRESSION_6_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_6_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_6_0_0_0, HYEXPRESSION_6_0_0_1, HYEXPRESSION_6_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_6_0 = INSTANCE.getHYEXPRESSION_6_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_6_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_6_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_6 = INSTANCE.getHYEXPRESSION_6();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_6() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), HYEXPRESSION_6_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYEXPRESSION_7_0_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_0_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYEXPRESSION_7_0_0_0_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_7_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_7_0_0_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_7_0_0_0_0_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYEXPRESSION_7_0_0_0_0_1_0 = INSTANCE.getHYEXPRESSION_7_0_0_0_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYEXPRESSION_7_0_0_0_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_7_0_0_0_0_1 = INSTANCE.getHYEXPRESSION_7_0_0_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_7_0_0_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_7_0_0_0_0_1_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_7_0_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_7_0_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_7_0_0_0_0_0, HYEXPRESSION_7_0_0_0_0_1);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYEXPRESSION_7_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYEXPRESSION_7_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYEXPRESSION_7_0_0_0_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_7_0_0_1_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_7_0_0_1_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRestriction(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_7_0_0_1_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_7_0_0_1_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_7_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_7_0_0_1_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_7_0_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_7_0_0_1_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYEXPRESSION_7_0_0_1 = INSTANCE.getHYEXPRESSION_7_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYEXPRESSION_7_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYEXPRESSION_7_0_0_1_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_7_0_0 = INSTANCE.getHYEXPRESSION_7_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_7_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_7_0_0_0, HYEXPRESSION_7_0_0_1);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_7_0 = INSTANCE.getHYEXPRESSION_7_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_7_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_7_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_7 = INSTANCE.getHYEXPRESSION_7();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_7() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), HYEXPRESSION_7_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_8_0_0_0 = INSTANCE.getHYEXPRESSION_8_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_8_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("?", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYEXPRESSION_8_0_0_1_0_0_0 = INSTANCE.getHYEXPRESSION_8_0_0_1_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYEXPRESSION_8_0_0_1_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_8_0_0_1_0_0 = INSTANCE.getHYEXPRESSION_8_0_0_1_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_8_0_0_1_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_8_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYEXPRESSION_8_0_0_1_0_1_0 = INSTANCE.getHYEXPRESSION_8_0_0_1_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYEXPRESSION_8_0_0_1_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_8_0_0_1_0_1 = INSTANCE.getHYEXPRESSION_8_0_0_1_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_8_0_0_1_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_8_0_0_1_0_1_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_8_0_0_1_0 = INSTANCE.getHYEXPRESSION_8_0_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_8_0_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_8_0_0_1_0_0, HYEXPRESSION_8_0_0_1_0_1);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYEXPRESSION_8_0_0_1 = INSTANCE.getHYEXPRESSION_8_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYEXPRESSION_8_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYEXPRESSION_8_0_0_1_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_8_0_0_2 = INSTANCE.getHYEXPRESSION_8_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_8_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRestriction(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_8_0_0 = INSTANCE.getHYEXPRESSION_8_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_8_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_8_0_0_0, HYEXPRESSION_8_0_0_1, HYEXPRESSION_8_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_8_0 = INSTANCE.getHYEXPRESSION_8_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_8_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_8_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_8 = INSTANCE.getHYEXPRESSION_8();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_8() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), HYEXPRESSION_8_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_9_0_0_0 = INSTANCE.getHYEXPRESSION_9_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_9_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("context:", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYEXPRESSION_9_0_0_1 = INSTANCE.getHYEXPRESSION_9_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYEXPRESSION_9_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), "IDENTIFIER_TOKEN", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_9_0_0 = INSTANCE.getHYEXPRESSION_9_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_9_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_9_0_0_0, HYEXPRESSION_9_0_0_1);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_9_0 = INSTANCE.getHYEXPRESSION_9_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_9_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_9_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_9 = INSTANCE.getHYEXPRESSION_9();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_9() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression(), HYEXPRESSION_9_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYEXPRESSION_10_0_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_10_0_0_0_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYEXPRESSION_10_0_0_0_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_10_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_10_0_0_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_10_0_0_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_10_0_0_0_0_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYEXPRESSION_10_0_0_0_0_1_0 = INSTANCE.getHYEXPRESSION_10_0_0_0_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYEXPRESSION_10_0_0_0_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_10_0_0_0_0_1 = INSTANCE.getHYEXPRESSION_10_0_0_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_10_0_0_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_10_0_0_0_0_1_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_10_0_0_0_0 = INSTANCE.getHYEXPRESSION_10_0_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_10_0_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_10_0_0_0_0_0, HYEXPRESSION_10_0_0_0_0_1);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYEXPRESSION_10_0_0_0 = INSTANCE.getHYEXPRESSION_10_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYEXPRESSION_10_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYEXPRESSION_10_0_0_0_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_10_0_0_1 = INSTANCE.getHYEXPRESSION_10_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_10_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(".", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYEXPRESSION_10_0_0_2 = INSTANCE.getHYEXPRESSION_10_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYEXPRESSION_10_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), "IDENTIFIER_TOKEN", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_10_0_0 = INSTANCE.getHYEXPRESSION_10_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_10_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_10_0_0_0, HYEXPRESSION_10_0_0_1, HYEXPRESSION_10_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_10_0 = INSTANCE.getHYEXPRESSION_10_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_10_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_10_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_10 = INSTANCE.getHYEXPRESSION_10();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_10() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression(), HYEXPRESSION_10_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_11_0_0_0 = INSTANCE.getHYEXPRESSION_11_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_11_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VALUE_EXPRESSION__VALUE), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyValue(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_11_0_0 = INSTANCE.getHYEXPRESSION_11_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_11_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_11_0_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_11_0 = INSTANCE.getHYEXPRESSION_11_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_11_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_11_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_11 = INSTANCE.getHYEXPRESSION_11();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_11() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression(), HYEXPRESSION_11_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaBooleanTerminal HYEXPRESSION_12_0_0_0 = INSTANCE.getHYEXPRESSION_12_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaBooleanTerminal getHYEXPRESSION_12_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyBooleanValueExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), "true", "false", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_12_0_0 = INSTANCE.getHYEXPRESSION_12_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_12_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_12_0_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_12_0 = INSTANCE.getHYEXPRESSION_12_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_12_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_12_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_12 = INSTANCE.getHYEXPRESSION_12();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_12() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyBooleanValueExpression(), HYEXPRESSION_12_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_13_0_0_0 = INSTANCE.getHYEXPRESSION_13_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_13_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("min(", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_13_0_0_1 = INSTANCE.getHYEXPRESSION_13_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_13_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MINIMUM_EXPRESSION__OPERAND), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_13_0_0_2 = INSTANCE.getHYEXPRESSION_13_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_13_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(")", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_13_0_0 = INSTANCE.getHYEXPRESSION_13_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_13_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_13_0_0_0, HYEXPRESSION_13_0_0_1, HYEXPRESSION_13_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_13_0 = INSTANCE.getHYEXPRESSION_13_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_13_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_13_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_13 = INSTANCE.getHYEXPRESSION_13();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_13() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), HYEXPRESSION_13_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_14_0_0_0 = INSTANCE.getHYEXPRESSION_14_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_14_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("max(", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_14_0_0_1 = INSTANCE.getHYEXPRESSION_14_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_14_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MAXIMUM_EXPRESSION__OPERAND), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_14_0_0_2 = INSTANCE.getHYEXPRESSION_14_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_14_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(")", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_14_0_0 = INSTANCE.getHYEXPRESSION_14_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_14_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_14_0_0_0, HYEXPRESSION_14_0_0_1, HYEXPRESSION_14_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_14_0 = INSTANCE.getHYEXPRESSION_14_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_14_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_14_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_14 = INSTANCE.getHYEXPRESSION_14();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_14() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), HYEXPRESSION_14_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_15_0_0_0 = INSTANCE.getHYEXPRESSION_15_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_15_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("ifPossible(", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_15_0_0_1 = INSTANCE.getHYEXPRESSION_15_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_15_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IF_POSSIBLE_EXPRESSION__OPERANDS), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_15_0_0_2_0_0_0 = INSTANCE.getHYEXPRESSION_15_0_0_2_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_15_0_0_2_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(",", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_15_0_0_2_0_0_1 = INSTANCE.getHYEXPRESSION_15_0_0_2_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_15_0_0_2_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IF_POSSIBLE_EXPRESSION__OPERANDS), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_15_0_0_2_0_0 = INSTANCE.getHYEXPRESSION_15_0_0_2_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_15_0_0_2_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_15_0_0_2_0_0_0, HYEXPRESSION_15_0_0_2_0_0_1);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_15_0_0_2_0 = INSTANCE.getHYEXPRESSION_15_0_0_2_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_15_0_0_2_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_15_0_0_2_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYEXPRESSION_15_0_0_2 = INSTANCE.getHYEXPRESSION_15_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYEXPRESSION_15_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYEXPRESSION_15_0_0_2_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.STAR);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_15_0_0_3 = INSTANCE.getHYEXPRESSION_15_0_0_3();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_15_0_0_3() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(")", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_15_0_0 = INSTANCE.getHYEXPRESSION_15_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_15_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_15_0_0_0, HYEXPRESSION_15_0_0_1, HYEXPRESSION_15_0_0_2, HYEXPRESSION_15_0_0_3);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_15_0 = INSTANCE.getHYEXPRESSION_15_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_15_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_15_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_15 = INSTANCE.getHYEXPRESSION_15();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_15() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), HYEXPRESSION_15_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_16_0_0_0 = INSTANCE.getHYEXPRESSION_16_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_16_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_EXPRESSION__OPERAND1), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_16_0_0_1 = INSTANCE.getHYEXPRESSION_16_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_16_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("<", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_16_0_0_2 = INSTANCE.getHYEXPRESSION_16_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_16_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_EXPRESSION__OPERAND2), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_16_0_0 = INSTANCE.getHYEXPRESSION_16_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_16_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_16_0_0_0, HYEXPRESSION_16_0_0_1, HYEXPRESSION_16_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_16_0 = INSTANCE.getHYEXPRESSION_16_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_16_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_16_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_16 = INSTANCE.getHYEXPRESSION_16();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_16() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), HYEXPRESSION_16_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_17_0_0_0 = INSTANCE.getHYEXPRESSION_17_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_17_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_OR_EQUAL_EXPRESSION__OPERAND1), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_17_0_0_1 = INSTANCE.getHYEXPRESSION_17_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_17_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("<=", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_17_0_0_2 = INSTANCE.getHYEXPRESSION_17_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_17_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_OR_EQUAL_EXPRESSION__OPERAND2), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_17_0_0 = INSTANCE.getHYEXPRESSION_17_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_17_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_17_0_0_0, HYEXPRESSION_17_0_0_1, HYEXPRESSION_17_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_17_0 = INSTANCE.getHYEXPRESSION_17_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_17_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_17_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_17 = INSTANCE.getHYEXPRESSION_17();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_17() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), HYEXPRESSION_17_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_18_0_0_0 = INSTANCE.getHYEXPRESSION_18_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_18_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_EXPRESSION__OPERAND1), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_18_0_0_1 = INSTANCE.getHYEXPRESSION_18_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_18_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(">", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_18_0_0_2 = INSTANCE.getHYEXPRESSION_18_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_18_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_EXPRESSION__OPERAND2), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_18_0_0 = INSTANCE.getHYEXPRESSION_18_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_18_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_18_0_0_0, HYEXPRESSION_18_0_0_1, HYEXPRESSION_18_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_18_0 = INSTANCE.getHYEXPRESSION_18_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_18_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_18_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_18 = INSTANCE.getHYEXPRESSION_18();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_18() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), HYEXPRESSION_18_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_19_0_0_0 = INSTANCE.getHYEXPRESSION_19_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_19_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_OR_EQUAL_EXPRESSION__OPERAND1), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_19_0_0_1 = INSTANCE.getHYEXPRESSION_19_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_19_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(">=", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_19_0_0_2 = INSTANCE.getHYEXPRESSION_19_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_19_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_OR_EQUAL_EXPRESSION__OPERAND2), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_19_0_0 = INSTANCE.getHYEXPRESSION_19_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_19_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_19_0_0_0, HYEXPRESSION_19_0_0_1, HYEXPRESSION_19_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_19_0 = INSTANCE.getHYEXPRESSION_19_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_19_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_19_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_19 = INSTANCE.getHYEXPRESSION_19();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_19() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), HYEXPRESSION_19_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_20_0_0_0 = INSTANCE.getHYEXPRESSION_20_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_20_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND1), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_20_0_0_1 = INSTANCE.getHYEXPRESSION_20_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_20_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("-", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_20_0_0_2 = INSTANCE.getHYEXPRESSION_20_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_20_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND2), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_20_0_0 = INSTANCE.getHYEXPRESSION_20_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_20_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_20_0_0_0, HYEXPRESSION_20_0_0_1, HYEXPRESSION_20_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_20_0 = INSTANCE.getHYEXPRESSION_20_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_20_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_20_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_20 = INSTANCE.getHYEXPRESSION_20();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_20() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), HYEXPRESSION_20_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_21_0_0_0 = INSTANCE.getHYEXPRESSION_21_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_21_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND1), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_21_0_0_1 = INSTANCE.getHYEXPRESSION_21_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_21_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("+", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_21_0_0_2 = INSTANCE.getHYEXPRESSION_21_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_21_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND2), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_21_0_0 = INSTANCE.getHYEXPRESSION_21_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_21_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_21_0_0_0, HYEXPRESSION_21_0_0_1, HYEXPRESSION_21_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_21_0 = INSTANCE.getHYEXPRESSION_21_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_21_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_21_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_21 = INSTANCE.getHYEXPRESSION_21();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_21() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), HYEXPRESSION_21_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_22_0_0_0 = INSTANCE.getHYEXPRESSION_22_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_22_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND1), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_22_0_0_1 = INSTANCE.getHYEXPRESSION_22_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_22_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("%", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_22_0_0_2 = INSTANCE.getHYEXPRESSION_22_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_22_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND2), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_22_0_0 = INSTANCE.getHYEXPRESSION_22_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_22_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_22_0_0_0, HYEXPRESSION_22_0_0_1, HYEXPRESSION_22_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_22_0 = INSTANCE.getHYEXPRESSION_22_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_22_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_22_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_22 = INSTANCE.getHYEXPRESSION_22();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_22() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), HYEXPRESSION_22_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_23_0_0_0 = INSTANCE.getHYEXPRESSION_23_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_23_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND1), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_23_0_0_1 = INSTANCE.getHYEXPRESSION_23_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_23_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("*", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_23_0_0_2 = INSTANCE.getHYEXPRESSION_23_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_23_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND2), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_23_0_0 = INSTANCE.getHYEXPRESSION_23_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_23_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_23_0_0_0, HYEXPRESSION_23_0_0_1, HYEXPRESSION_23_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_23_0 = INSTANCE.getHYEXPRESSION_23_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_23_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_23_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_23 = INSTANCE.getHYEXPRESSION_23();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_23() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), HYEXPRESSION_23_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_24_0_0_0 = INSTANCE.getHYEXPRESSION_24_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_24_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND1), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_24_0_0_1 = INSTANCE.getHYEXPRESSION_24_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_24_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("/", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_24_0_0_2 = INSTANCE.getHYEXPRESSION_24_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_24_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND2), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_24_0_0 = INSTANCE.getHYEXPRESSION_24_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_24_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_24_0_0_0, HYEXPRESSION_24_0_0_1, HYEXPRESSION_24_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_24_0 = INSTANCE.getHYEXPRESSION_24_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_24_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_24_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_24 = INSTANCE.getHYEXPRESSION_24();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_24() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), HYEXPRESSION_24_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_25_0_0_0 = INSTANCE.getHYEXPRESSION_25_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_25_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUAL_EXPRESSION__OPERAND1), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_25_0_0_1 = INSTANCE.getHYEXPRESSION_25_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_25_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("=", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_25_0_0_2 = INSTANCE.getHYEXPRESSION_25_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_25_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUAL_EXPRESSION__OPERAND2), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_25_0_0 = INSTANCE.getHYEXPRESSION_25_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_25_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_25_0_0_0, HYEXPRESSION_25_0_0_1, HYEXPRESSION_25_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_25_0 = INSTANCE.getHYEXPRESSION_25_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_25_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_25_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_25 = INSTANCE.getHYEXPRESSION_25();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_25() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), HYEXPRESSION_25_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_26_0_0_0 = INSTANCE.getHYEXPRESSION_26_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_26_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EQUAL_EXPRESSION__OPERAND1), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_26_0_0_1 = INSTANCE.getHYEXPRESSION_26_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_26_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("!=", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYEXPRESSION_26_0_0_2 = INSTANCE.getHYEXPRESSION_26_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYEXPRESSION_26_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EQUAL_EXPRESSION__OPERAND2), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_26_0_0 = INSTANCE.getHYEXPRESSION_26_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_26_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_26_0_0_0, HYEXPRESSION_26_0_0_1, HYEXPRESSION_26_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_26_0 = INSTANCE.getHYEXPRESSION_26_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_26_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_26_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_26 = INSTANCE.getHYEXPRESSION_26();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_26() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), HYEXPRESSION_26_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_27_0_0_0 = INSTANCE.getHYEXPRESSION_27_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_27_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("[", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaEnumerationTerminal HYEXPRESSION_27_0_0_1 = INSTANCE.getHYEXPRESSION_27_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaEnumerationTerminal getHYEXPRESSION_27_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaEnumerationTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), new String[] {"lessThan", "<", "lessThanOrEqual", "<=", "equal", "=", "implicitEqual", "", "greaterThanOrEqual", ">=", "greaterThan", ">", }, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYEXPRESSION_27_0_0_2 = INSTANCE.getHYEXPRESSION_27_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYEXPRESSION_27_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), "QUOTED_34_34", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_27_0_0_3 = INSTANCE.getHYEXPRESSION_27_0_0_3();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_27_0_0_3() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("]", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_27_0_0 = INSTANCE.getHYEXPRESSION_27_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_27_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_27_0_0_0, HYEXPRESSION_27_0_0_1, HYEXPRESSION_27_0_0_2, HYEXPRESSION_27_0_0_3);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_27_0 = INSTANCE.getHYEXPRESSION_27_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_27_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_27_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_27 = INSTANCE.getHYEXPRESSION_27();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_27() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction(), HYEXPRESSION_27_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_28_0_0_0 = INSTANCE.getHYEXPRESSION_28_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_28_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("[", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaBooleanTerminal HYEXPRESSION_28_0_0_1 = INSTANCE.getHYEXPRESSION_28_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaBooleanTerminal getHYEXPRESSION_28_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), "", "^", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYEXPRESSION_28_0_0_2 = INSTANCE.getHYEXPRESSION_28_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYEXPRESSION_28_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), "QUOTED_34_34", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_28_0_0_3 = INSTANCE.getHYEXPRESSION_28_0_0_3();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_28_0_0_3() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("-", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaBooleanTerminal HYEXPRESSION_28_0_0_4 = INSTANCE.getHYEXPRESSION_28_0_0_4();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaBooleanTerminal getHYEXPRESSION_28_0_0_4() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), "", "^", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYEXPRESSION_28_0_0_5 = INSTANCE.getHYEXPRESSION_28_0_0_5();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYEXPRESSION_28_0_0_5() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), "QUOTED_34_34", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYEXPRESSION_28_0_0_6 = INSTANCE.getHYEXPRESSION_28_0_0_6();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYEXPRESSION_28_0_0_6() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("]", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYEXPRESSION_28_0_0 = INSTANCE.getHYEXPRESSION_28_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYEXPRESSION_28_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_28_0_0_0, HYEXPRESSION_28_0_0_1, HYEXPRESSION_28_0_0_2, HYEXPRESSION_28_0_0_3, HYEXPRESSION_28_0_0_4, HYEXPRESSION_28_0_0_5, HYEXPRESSION_28_0_0_6);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYEXPRESSION_28_0 = INSTANCE.getHYEXPRESSION_28_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYEXPRESSION_28_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYEXPRESSION_28_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYEXPRESSION_28 = INSTANCE.getHYEXPRESSION_28();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYEXPRESSION_28() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction(), HYEXPRESSION_28_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYDATAVALUE_0_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYDATAVALUE_0_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_NUMBER_VALUE__VALUE), "INTEGER_LITERAL", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYDATAVALUE_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYDATAVALUE_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_0_0_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYDATAVALUE_0_0 = INSTANCE.getHYDATAVALUE_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYDATAVALUE_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_0_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYDATAVALUE_0 = INSTANCE.getHYDATAVALUE_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYDATAVALUE_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue(), HYDATAVALUE_0_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaBooleanTerminal HYDATAVALUE_1_0_0_0 = INSTANCE.getHYDATAVALUE_1_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaBooleanTerminal getHYDATAVALUE_1_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaBooleanTerminal(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), "true", "false", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYDATAVALUE_1_0_0 = INSTANCE.getHYDATAVALUE_1_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYDATAVALUE_1_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_1_0_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYDATAVALUE_1_0 = INSTANCE.getHYDATAVALUE_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYDATAVALUE_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_1_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYDATAVALUE_1 = INSTANCE.getHYDATAVALUE_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYDATAVALUE_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue(), HYDATAVALUE_1_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_2_0_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_2_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("enum:", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYDATAVALUE_2_0_0_1 = INSTANCE.getHYDATAVALUE_2_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYDATAVALUE_2_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), "IDENTIFIER_TOKEN", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_2_0_0_2 = INSTANCE.getHYDATAVALUE_2_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_2_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(".", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYDATAVALUE_2_0_0_3 = INSTANCE.getHYDATAVALUE_2_0_0_3();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYDATAVALUE_2_0_0_3() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), "IDENTIFIER_TOKEN", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYDATAVALUE_2_0_0 = INSTANCE.getHYDATAVALUE_2_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYDATAVALUE_2_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_2_0_0_0, HYDATAVALUE_2_0_0_1, HYDATAVALUE_2_0_0_2, HYDATAVALUE_2_0_0_3);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYDATAVALUE_2_0 = INSTANCE.getHYDATAVALUE_2_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYDATAVALUE_2_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_2_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYDATAVALUE_2 = INSTANCE.getHYDATAVALUE_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYDATAVALUE_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue(), HYDATAVALUE_2_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_3_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("Enum(", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYDATAVALUE_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYDATAVALUE_3_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__NAME), "IDENTIFIER_TOKEN", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_3_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_3_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(",", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYDATAVALUE_3_0_0_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYDATAVALUE_3_0_0_3_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_3_0_0_3_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(",", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment HYDATAVALUE_3_0_0_3_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYDATAVALUE_3_0_0_3_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYDATAVALUE_3_0_0_3_0_0_1_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1_0_0_1);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYDATAVALUE_3_0_0_3_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYDATAVALUE_3_0_0_3_0_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYDATAVALUE_3_0_0_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYDATAVALUE_3_0_0_3_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYDATAVALUE_3_0_0_3_0_0_1_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.STAR);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYDATAVALUE_3_0_0_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYDATAVALUE_3_0_0_3_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYDATAVALUE_3_0_0_3_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYDATAVALUE_3_0_0_3_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYDATAVALUE_3_0_0_3 = INSTANCE.getHYDATAVALUE_3_0_0_3();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYDATAVALUE_3_0_0_3() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYDATAVALUE_3_0_0_3_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_3_0_0_4 = INSTANCE.getHYDATAVALUE_3_0_0_4();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_3_0_0_4() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(")", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_3_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_3_0_0_5_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("[", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("-", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYDATAVALUE_3_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("-", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_1_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_1_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("null", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYDATAVALUE_3_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, HYDATAVALUE_3_0_0_5_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("null", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("-", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYDATAVALUE_3_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYDATAVALUE_3_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYDATAVALUE_3_0_0_5_0_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYDATAVALUE_3_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYDATAVALUE_3_0_0_5_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYDATAVALUE_3_0_0_5_0_0_1_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_3_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_3_0_0_5_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("]", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYDATAVALUE_3_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYDATAVALUE_3_0_0_5_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1, HYDATAVALUE_3_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYDATAVALUE_3_0_0_5_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYDATAVALUE_3_0_0_5_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYDATAVALUE_3_0_0_5 = INSTANCE.getHYDATAVALUE_3_0_0_5();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYDATAVALUE_3_0_0_5() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYDATAVALUE_3_0_0_5_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYDATAVALUE_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYDATAVALUE_3_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_3_0_0_0, HYDATAVALUE_3_0_0_1, HYDATAVALUE_3_0_0_2, HYDATAVALUE_3_0_0_3, HYDATAVALUE_3_0_0_4, HYDATAVALUE_3_0_0_5);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYDATAVALUE_3_0 = INSTANCE.getHYDATAVALUE_3_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYDATAVALUE_3_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_3_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYDATAVALUE_3 = INSTANCE.getHYDATAVALUE_3();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYDATAVALUE_3() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), HYDATAVALUE_3_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_4_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_4_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("EnumLiteral(", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYDATAVALUE_4_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYDATAVALUE_4_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__NAME), "IDENTIFIER_TOKEN", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_4_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_4_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(",", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYDATAVALUE_4_0_0_3 = INSTANCE.getHYDATAVALUE_4_0_0_3();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYDATAVALUE_4_0_0_3() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALUE), "INTEGER_LITERAL", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_4_0_0_4 = INSTANCE.getHYDATAVALUE_4_0_0_4();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_4_0_0_4() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword(")", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_4_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_4_0_0_5_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("[", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("-", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYDATAVALUE_4_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("-", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("null", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYDATAVALUE_4_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, HYDATAVALUE_4_0_0_5_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("null", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("-", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYDATAVALUE_4_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYDATAVALUE_4_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYDATAVALUE_4_0_0_5_0_0_1_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYDATAVALUE_4_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYDATAVALUE_4_0_0_5_0_0_1() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYDATAVALUE_4_0_0_5_0_0_1_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword HYDATAVALUE_4_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_2();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword getHYDATAVALUE_4_0_0_5_0_0_2() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword("]", eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYDATAVALUE_4_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYDATAVALUE_4_0_0_5_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1, HYDATAVALUE_4_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYDATAVALUE_4_0_0_5_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYDATAVALUE_4_0_0_5_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound HYDATAVALUE_4_0_0_5 = INSTANCE.getHYDATAVALUE_4_0_0_5();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound getHYDATAVALUE_4_0_0_5() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCompound(HYDATAVALUE_4_0_0_5_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence HYDATAVALUE_4_0_0 = INSTANCE.getHYDATAVALUE_4_0_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence getHYDATAVALUE_4_0_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSequence(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_4_0_0_0, HYDATAVALUE_4_0_0_1, HYDATAVALUE_4_0_0_2, HYDATAVALUE_4_0_0_3, HYDATAVALUE_4_0_0_4, HYDATAVALUE_4_0_0_5);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice HYDATAVALUE_4_0 = INSTANCE.getHYDATAVALUE_4_0();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice getHYDATAVALUE_4_0() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaChoice(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE, HYDATAVALUE_4_0_0);
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule HYDATAVALUE_4 = INSTANCE.getHYDATAVALUE_4();
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule getHYDATAVALUE_4() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), HYDATAVALUE_4_0, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality.ONE);
	}
	
	
	public static String getSyntaxElementID(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (Field field : eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.class.getFields()) {
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
	
	public static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSyntaxElement) eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule[] RULES = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule[] {
		HYVALIDITYFORMULA_0,
		HYVALIDITYFORMULA_1,
		HYVALIDITYFORMULA_2,
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
			for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSyntaxElement element, Set<String> keywords) {
		if (element instanceof eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword) {
			keywords.add(((eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaKeyword) element).getValue());
		} else if (element instanceof eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaBooleanTerminal) {
			keywords.add(((eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaBooleanTerminal) element).getTrueLiteral());
			keywords.add(((eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaEnumerationTerminal) {
			eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaEnumerationTerminal terminal = (eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
