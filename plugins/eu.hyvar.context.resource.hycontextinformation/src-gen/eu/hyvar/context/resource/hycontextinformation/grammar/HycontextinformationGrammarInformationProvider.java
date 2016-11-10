/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.grammar;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class HycontextinformationGrammarInformationProvider {
	
	public final static EStructuralFeature ANONYMOUS_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static HycontextinformationGrammarInformationProvider INSTANCE = new HycontextinformationGrammarInformationProvider();
	
	private Set<String> keywords;
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainment HYCONTEXTINFORMATION_0_0_0_0 = INSTANCE.getHYCONTEXTINFORMATION_0_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainment getHYCONTEXTINFORMATION_0_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainment(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXT_MODEL__ENUMS), eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.STAR, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), }, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainment HYCONTEXTINFORMATION_0_0_0_1 = INSTANCE.getHYCONTEXTINFORMATION_0_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainment getHYCONTEXTINFORMATION_0_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainment(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXT_MODEL__CONTEXTUAL_INFORMATIONS), eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.STAR, new EClass[] {eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformation(), }, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_0_0_0 = INSTANCE.getHYCONTEXTINFORMATION_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_0_0_0_0, HYCONTEXTINFORMATION_0_0_0_1);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYCONTEXTINFORMATION_0_0 = INSTANCE.getHYCONTEXTINFORMATION_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYCONTEXTINFORMATION_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_0_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule HYCONTEXTINFORMATION_0 = INSTANCE.getHYCONTEXTINFORMATION_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule getHYCONTEXTINFORMATION_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), HYCONTEXTINFORMATION_0_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_1_0_0_0 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_1_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("NumberContext(", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_1_0_0_1 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_1_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationNumber().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__NAME), "IDENTIFIER_TOKEN", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_1_0_0_2 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_1_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword(",", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_1_0_0_3 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_3();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_1_0_0_3() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationNumber().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__MIN), "INTEGER_LITERAL", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_1_0_0_4 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_4();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_1_0_0_4() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword(",", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_1_0_0_5 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_5();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_1_0_0_5() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationNumber().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__MAX), "INTEGER_LITERAL", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_1_0_0_6 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_6();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_1_0_0_6() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword(")", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_1_0_0_7_0_0_0 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_1_0_0_7_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("[", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_0 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationNumber().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_SINCE), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_1 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("-", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_2 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationNumber().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_UNTIL), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_0, HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_1, HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_0 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationNumber().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_SINCE), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_1 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("-", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_2 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("eternity", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_0, HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_1, HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_0 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("eternity", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_1 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("-", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_2 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationNumber().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_UNTIL), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_0, HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_1, HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYCONTEXTINFORMATION_1_0_0_7_0_0_1_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0, HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1, HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound HYCONTEXTINFORMATION_1_0_0_7_0_0_1 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound getHYCONTEXTINFORMATION_1_0_0_7_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound(HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_1_0_0_7_0_0_2 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_1_0_0_7_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("]", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_1_0_0_7_0_0 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_1_0_0_7_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_1_0_0_7_0_0_0, HYCONTEXTINFORMATION_1_0_0_7_0_0_1, HYCONTEXTINFORMATION_1_0_0_7_0_0_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYCONTEXTINFORMATION_1_0_0_7_0 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYCONTEXTINFORMATION_1_0_0_7_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_1_0_0_7_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound HYCONTEXTINFORMATION_1_0_0_7 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0_7();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound getHYCONTEXTINFORMATION_1_0_0_7() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound(HYCONTEXTINFORMATION_1_0_0_7_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_1_0_0 = INSTANCE.getHYCONTEXTINFORMATION_1_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_1_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_1_0_0_0, HYCONTEXTINFORMATION_1_0_0_1, HYCONTEXTINFORMATION_1_0_0_2, HYCONTEXTINFORMATION_1_0_0_3, HYCONTEXTINFORMATION_1_0_0_4, HYCONTEXTINFORMATION_1_0_0_5, HYCONTEXTINFORMATION_1_0_0_6, HYCONTEXTINFORMATION_1_0_0_7);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYCONTEXTINFORMATION_1_0 = INSTANCE.getHYCONTEXTINFORMATION_1_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYCONTEXTINFORMATION_1_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_1_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule HYCONTEXTINFORMATION_1 = INSTANCE.getHYCONTEXTINFORMATION_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule getHYCONTEXTINFORMATION_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationNumber(), HYCONTEXTINFORMATION_1_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_2_0_0_0 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_2_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("BooleanContext(", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_2_0_0_1 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_2_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationBoolean().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__NAME), "IDENTIFIER_TOKEN", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_2_0_0_2 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_2_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword(")", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_2_0_0_3_0_0_0 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_2_0_0_3_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("[", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_0 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationBoolean().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_SINCE), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_1 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("-", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_2 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationBoolean().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_UNTIL), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_0, HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_1, HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_0 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationBoolean().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_SINCE), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_1 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("-", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_2 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("eternity", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_0, HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_1, HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_0 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("eternity", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_1 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("-", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_2 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationBoolean().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_UNTIL), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_0, HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_1, HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYCONTEXTINFORMATION_2_0_0_3_0_0_1_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0, HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1, HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound HYCONTEXTINFORMATION_2_0_0_3_0_0_1 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound getHYCONTEXTINFORMATION_2_0_0_3_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound(HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_2_0_0_3_0_0_2 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_2_0_0_3_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("]", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_2_0_0_3_0_0 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_2_0_0_3_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_2_0_0_3_0_0_0, HYCONTEXTINFORMATION_2_0_0_3_0_0_1, HYCONTEXTINFORMATION_2_0_0_3_0_0_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYCONTEXTINFORMATION_2_0_0_3_0 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYCONTEXTINFORMATION_2_0_0_3_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_2_0_0_3_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound HYCONTEXTINFORMATION_2_0_0_3 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0_3();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound getHYCONTEXTINFORMATION_2_0_0_3() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound(HYCONTEXTINFORMATION_2_0_0_3_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_2_0_0 = INSTANCE.getHYCONTEXTINFORMATION_2_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_2_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_2_0_0_0, HYCONTEXTINFORMATION_2_0_0_1, HYCONTEXTINFORMATION_2_0_0_2, HYCONTEXTINFORMATION_2_0_0_3);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYCONTEXTINFORMATION_2_0 = INSTANCE.getHYCONTEXTINFORMATION_2_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYCONTEXTINFORMATION_2_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_2_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule HYCONTEXTINFORMATION_2 = INSTANCE.getHYCONTEXTINFORMATION_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule getHYCONTEXTINFORMATION_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationBoolean(), HYCONTEXTINFORMATION_2_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_3_0_0_0 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_3_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("EnumContext(", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_3_0_0_1 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_3_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationEnum().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__NAME), "IDENTIFIER_TOKEN", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_3_0_0_2 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_3_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword(",", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_3_0_0_3 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_3();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_3_0_0_3() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationEnum().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__ENUM_TYPE), "IDENTIFIER_TOKEN", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_3_0_0_4 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_4();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_3_0_0_4() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword(")", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_3_0_0_5_0_0_0 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_3_0_0_5_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("[", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationEnum().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_SINCE), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("-", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationEnum().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_UNTIL), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_0, HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_1, HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationEnum().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_SINCE), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("-", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_2 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("eternity", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_0, HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_1, HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("eternity", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("-", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationEnum().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_UNTIL), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_0, HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_1, HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYCONTEXTINFORMATION_3_0_0_5_0_0_1_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0, HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1, HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound HYCONTEXTINFORMATION_3_0_0_5_0_0_1 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound getHYCONTEXTINFORMATION_3_0_0_5_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound(HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYCONTEXTINFORMATION_3_0_0_5_0_0_2 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYCONTEXTINFORMATION_3_0_0_5_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("]", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_3_0_0_5_0_0 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_3_0_0_5_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_3_0_0_5_0_0_0, HYCONTEXTINFORMATION_3_0_0_5_0_0_1, HYCONTEXTINFORMATION_3_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYCONTEXTINFORMATION_3_0_0_5_0 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYCONTEXTINFORMATION_3_0_0_5_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_3_0_0_5_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound HYCONTEXTINFORMATION_3_0_0_5 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0_5();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound getHYCONTEXTINFORMATION_3_0_0_5() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound(HYCONTEXTINFORMATION_3_0_0_5_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYCONTEXTINFORMATION_3_0_0 = INSTANCE.getHYCONTEXTINFORMATION_3_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYCONTEXTINFORMATION_3_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_3_0_0_0, HYCONTEXTINFORMATION_3_0_0_1, HYCONTEXTINFORMATION_3_0_0_2, HYCONTEXTINFORMATION_3_0_0_3, HYCONTEXTINFORMATION_3_0_0_4, HYCONTEXTINFORMATION_3_0_0_5);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYCONTEXTINFORMATION_3_0 = INSTANCE.getHYCONTEXTINFORMATION_3_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYCONTEXTINFORMATION_3_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYCONTEXTINFORMATION_3_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule HYCONTEXTINFORMATION_3 = INSTANCE.getHYCONTEXTINFORMATION_3();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule getHYCONTEXTINFORMATION_3() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextualInformationEnum(), HYCONTEXTINFORMATION_3_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYDATAVALUE_0_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYDATAVALUE_0_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_NUMBER_VALUE__VALUE), "INTEGER_LITERAL", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYDATAVALUE_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYDATAVALUE_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_0_0_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYDATAVALUE_0_0 = INSTANCE.getHYDATAVALUE_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYDATAVALUE_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_0_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule HYDATAVALUE_0 = INSTANCE.getHYDATAVALUE_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule getHYDATAVALUE_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue(), HYDATAVALUE_0_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationBooleanTerminal HYDATAVALUE_1_0_0_0 = INSTANCE.getHYDATAVALUE_1_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationBooleanTerminal getHYDATAVALUE_1_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationBooleanTerminal(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), "true", "false", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYDATAVALUE_1_0_0 = INSTANCE.getHYDATAVALUE_1_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYDATAVALUE_1_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_1_0_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYDATAVALUE_1_0 = INSTANCE.getHYDATAVALUE_1_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYDATAVALUE_1_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_1_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule HYDATAVALUE_1 = INSTANCE.getHYDATAVALUE_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule getHYDATAVALUE_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue(), HYDATAVALUE_1_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_2_0_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_2_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("enum:", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYDATAVALUE_2_0_0_1 = INSTANCE.getHYDATAVALUE_2_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYDATAVALUE_2_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), "IDENTIFIER_TOKEN", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_2_0_0_2 = INSTANCE.getHYDATAVALUE_2_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_2_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword(".", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYDATAVALUE_2_0_0_3 = INSTANCE.getHYDATAVALUE_2_0_0_3();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYDATAVALUE_2_0_0_3() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), "IDENTIFIER_TOKEN", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYDATAVALUE_2_0_0 = INSTANCE.getHYDATAVALUE_2_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYDATAVALUE_2_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_2_0_0_0, HYDATAVALUE_2_0_0_1, HYDATAVALUE_2_0_0_2, HYDATAVALUE_2_0_0_3);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYDATAVALUE_2_0 = INSTANCE.getHYDATAVALUE_2_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYDATAVALUE_2_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_2_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule HYDATAVALUE_2 = INSTANCE.getHYDATAVALUE_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule getHYDATAVALUE_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue(), HYDATAVALUE_2_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_3_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("Enum(", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYDATAVALUE_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYDATAVALUE_3_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__NAME), "IDENTIFIER_TOKEN", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_3_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_3_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword(",", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainment HYDATAVALUE_3_0_0_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainment getHYDATAVALUE_3_0_0_3_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_3_0_0_3_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword(",", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainment HYDATAVALUE_3_0_0_3_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainment getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYDATAVALUE_3_0_0_3_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYDATAVALUE_3_0_0_3_0_0_1_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1_0_0_1);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYDATAVALUE_3_0_0_3_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYDATAVALUE_3_0_0_3_0_0_1_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound HYDATAVALUE_3_0_0_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound getHYDATAVALUE_3_0_0_3_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound(HYDATAVALUE_3_0_0_3_0_0_1_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.STAR);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYDATAVALUE_3_0_0_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYDATAVALUE_3_0_0_3_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYDATAVALUE_3_0_0_3_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYDATAVALUE_3_0_0_3_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound HYDATAVALUE_3_0_0_3 = INSTANCE.getHYDATAVALUE_3_0_0_3();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound getHYDATAVALUE_3_0_0_3() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound(HYDATAVALUE_3_0_0_3_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_3_0_0_4 = INSTANCE.getHYDATAVALUE_3_0_0_4();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_3_0_0_4() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword(")", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_3_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_3_0_0_5_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("[", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("-", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYDATAVALUE_3_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("-", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYDATAVALUE_3_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1_1);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("eternity", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("-", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYDATAVALUE_3_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYDATAVALUE_3_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYDATAVALUE_3_0_0_5_0_0_1_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound HYDATAVALUE_3_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound getHYDATAVALUE_3_0_0_5_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound(HYDATAVALUE_3_0_0_5_0_0_1_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_3_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_3_0_0_5_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("]", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYDATAVALUE_3_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYDATAVALUE_3_0_0_5_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1, HYDATAVALUE_3_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYDATAVALUE_3_0_0_5_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYDATAVALUE_3_0_0_5_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound HYDATAVALUE_3_0_0_5 = INSTANCE.getHYDATAVALUE_3_0_0_5();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound getHYDATAVALUE_3_0_0_5() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound(HYDATAVALUE_3_0_0_5_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYDATAVALUE_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYDATAVALUE_3_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_3_0_0_0, HYDATAVALUE_3_0_0_1, HYDATAVALUE_3_0_0_2, HYDATAVALUE_3_0_0_3, HYDATAVALUE_3_0_0_4, HYDATAVALUE_3_0_0_5);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYDATAVALUE_3_0 = INSTANCE.getHYDATAVALUE_3_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYDATAVALUE_3_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_3_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule HYDATAVALUE_3 = INSTANCE.getHYDATAVALUE_3();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule getHYDATAVALUE_3() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), HYDATAVALUE_3_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_4_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_4_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("EnumLiteral(", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYDATAVALUE_4_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYDATAVALUE_4_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__NAME), "IDENTIFIER_TOKEN", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_4_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_4_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword(",", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYDATAVALUE_4_0_0_3 = INSTANCE.getHYDATAVALUE_4_0_0_3();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYDATAVALUE_4_0_0_3() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALUE), "INTEGER_LITERAL", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_4_0_0_4 = INSTANCE.getHYDATAVALUE_4_0_0_4();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_4_0_0_4() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword(")", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_4_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_4_0_0_5_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("[", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("-", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYDATAVALUE_4_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("-", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("eternity", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYDATAVALUE_4_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, HYDATAVALUE_4_0_0_5_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("eternity", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("-", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYDATAVALUE_4_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYDATAVALUE_4_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYDATAVALUE_4_0_0_5_0_0_1_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound HYDATAVALUE_4_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound getHYDATAVALUE_4_0_0_5_0_0_1() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound(HYDATAVALUE_4_0_0_5_0_0_1_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword HYDATAVALUE_4_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_2();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword getHYDATAVALUE_4_0_0_5_0_0_2() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword("]", eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYDATAVALUE_4_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYDATAVALUE_4_0_0_5_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1, HYDATAVALUE_4_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYDATAVALUE_4_0_0_5_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYDATAVALUE_4_0_0_5_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound HYDATAVALUE_4_0_0_5 = INSTANCE.getHYDATAVALUE_4_0_0_5();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound getHYDATAVALUE_4_0_0_5() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCompound(HYDATAVALUE_4_0_0_5_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence HYDATAVALUE_4_0_0 = INSTANCE.getHYDATAVALUE_4_0_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence getHYDATAVALUE_4_0_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSequence(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_4_0_0_0, HYDATAVALUE_4_0_0_1, HYDATAVALUE_4_0_0_2, HYDATAVALUE_4_0_0_3, HYDATAVALUE_4_0_0_4, HYDATAVALUE_4_0_0_5);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice HYDATAVALUE_4_0 = INSTANCE.getHYDATAVALUE_4_0();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice getHYDATAVALUE_4_0() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationChoice(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE, HYDATAVALUE_4_0_0);
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule HYDATAVALUE_4 = INSTANCE.getHYDATAVALUE_4();
	private eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule getHYDATAVALUE_4() {
		return new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), HYDATAVALUE_4_0, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality.ONE);
	}
	
	
	public static String getSyntaxElementID(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (Field field : eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.class.getFields()) {
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
	
	public static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement) eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule[] RULES = new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule[] {
		HYCONTEXTINFORMATION_0,
		HYCONTEXTINFORMATION_1,
		HYCONTEXTINFORMATION_2,
		HYCONTEXTINFORMATION_3,
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
			for (eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement element, Set<String> keywords) {
		if (element instanceof eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword) {
			keywords.add(((eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationKeyword) element).getValue());
		} else if (element instanceof eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationBooleanTerminal) {
			keywords.add(((eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationBooleanTerminal) element).getTrueLiteral());
			keywords.add(((eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationEnumerationTerminal) {
			eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationEnumerationTerminal terminal = (eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
