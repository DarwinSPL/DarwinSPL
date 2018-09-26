/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.grammar;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class DwprofileGrammarInformationProvider {
	
	public final static EStructuralFeature ANONYMOUS_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static DwprofileGrammarInformationProvider INSTANCE = new DwprofileGrammarInformationProvider();
	
	private Set<String> keywords;
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment DWPROFILE_0_0_0_0 = INSTANCE.getDWPROFILE_0_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getDWPROFILE_0_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PROFILE__PREFERENCES), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.STAR, new EClass[] {de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwPreference(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence DWPROFILE_0_0_0 = INSTANCE.getDWPROFILE_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getDWPROFILE_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, DWPROFILE_0_0_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice DWPROFILE_0_0 = INSTANCE.getDWPROFILE_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getDWPROFILE_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, DWPROFILE_0_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class DwProfile
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule DWPROFILE_0 = INSTANCE.getDWPROFILE_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getDWPROFILE_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), DWPROFILE_0_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment DWPROFILE_1_0_0_0 = INSTANCE.getDWPROFILE_1_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getDWPROFILE_1_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwPreference().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__ROOT_EXPRESSION), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword DWPROFILE_1_0_0_1_0_0_0 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getDWPROFILE_1_0_0_1_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("[", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder DWPROFILE_1_0_0_1_0_0_1_0_0_0 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_1_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getDWPROFILE_1_0_0_1_0_0_1_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwPreference().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_SINCE), "DATE", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword DWPROFILE_1_0_0_1_0_0_1_0_0_1 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_1_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getDWPROFILE_1_0_0_1_0_0_1_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("-", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder DWPROFILE_1_0_0_1_0_0_1_0_0_2 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_1_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getDWPROFILE_1_0_0_1_0_0_1_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwPreference().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_UNTIL), "DATE", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence DWPROFILE_1_0_0_1_0_0_1_0_0 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_1_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getDWPROFILE_1_0_0_1_0_0_1_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, DWPROFILE_1_0_0_1_0_0_1_0_0_0, DWPROFILE_1_0_0_1_0_0_1_0_0_1, DWPROFILE_1_0_0_1_0_0_1_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder DWPROFILE_1_0_0_1_0_0_1_0_1_0 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_1_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getDWPROFILE_1_0_0_1_0_0_1_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwPreference().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_SINCE), "DATE", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword DWPROFILE_1_0_0_1_0_0_1_0_1_1 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_1_0_1_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getDWPROFILE_1_0_0_1_0_0_1_0_1_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("-", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword DWPROFILE_1_0_0_1_0_0_1_0_1_2 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_1_0_1_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getDWPROFILE_1_0_0_1_0_0_1_0_1_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("eternity", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence DWPROFILE_1_0_0_1_0_0_1_0_1 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_1_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getDWPROFILE_1_0_0_1_0_0_1_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, DWPROFILE_1_0_0_1_0_0_1_0_1_0, DWPROFILE_1_0_0_1_0_0_1_0_1_1, DWPROFILE_1_0_0_1_0_0_1_0_1_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword DWPROFILE_1_0_0_1_0_0_1_0_2_0 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_1_0_2_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getDWPROFILE_1_0_0_1_0_0_1_0_2_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("eternity", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword DWPROFILE_1_0_0_1_0_0_1_0_2_1 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_1_0_2_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getDWPROFILE_1_0_0_1_0_0_1_0_2_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("-", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder DWPROFILE_1_0_0_1_0_0_1_0_2_2 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_1_0_2_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getDWPROFILE_1_0_0_1_0_0_1_0_2_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwPreference().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_UNTIL), "DATE", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence DWPROFILE_1_0_0_1_0_0_1_0_2 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_1_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getDWPROFILE_1_0_0_1_0_0_1_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, DWPROFILE_1_0_0_1_0_0_1_0_2_0, DWPROFILE_1_0_0_1_0_0_1_0_2_1, DWPROFILE_1_0_0_1_0_0_1_0_2_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice DWPROFILE_1_0_0_1_0_0_1_0 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getDWPROFILE_1_0_0_1_0_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, DWPROFILE_1_0_0_1_0_0_1_0_0, DWPROFILE_1_0_0_1_0_0_1_0_1, DWPROFILE_1_0_0_1_0_0_1_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound DWPROFILE_1_0_0_1_0_0_1 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound getDWPROFILE_1_0_0_1_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound(DWPROFILE_1_0_0_1_0_0_1_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword DWPROFILE_1_0_0_1_0_0_2 = INSTANCE.getDWPROFILE_1_0_0_1_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getDWPROFILE_1_0_0_1_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("]", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence DWPROFILE_1_0_0_1_0_0 = INSTANCE.getDWPROFILE_1_0_0_1_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getDWPROFILE_1_0_0_1_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, DWPROFILE_1_0_0_1_0_0_0, DWPROFILE_1_0_0_1_0_0_1, DWPROFILE_1_0_0_1_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice DWPROFILE_1_0_0_1_0 = INSTANCE.getDWPROFILE_1_0_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getDWPROFILE_1_0_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, DWPROFILE_1_0_0_1_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound DWPROFILE_1_0_0_1 = INSTANCE.getDWPROFILE_1_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound getDWPROFILE_1_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound(DWPROFILE_1_0_0_1_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.QUESTIONMARK);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence DWPROFILE_1_0_0 = INSTANCE.getDWPROFILE_1_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getDWPROFILE_1_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, DWPROFILE_1_0_0_0, DWPROFILE_1_0_0_1);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice DWPROFILE_1_0 = INSTANCE.getDWPROFILE_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getDWPROFILE_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, DWPROFILE_1_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class DwPreference
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule DWPROFILE_1 = INSTANCE.getDWPROFILE_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getDWPROFILE_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwPreference(), DWPROFILE_1_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_0_0_0_0 = INSTANCE.getHYEXPRESSION_0_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_0_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND1), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_0_0_0_1 = INSTANCE.getHYEXPRESSION_0_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_0_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("<->", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_0_0_0_2 = INSTANCE.getHYEXPRESSION_0_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_0_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND2), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_0_0_0 = INSTANCE.getHYEXPRESSION_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_0_0_0_0, HYEXPRESSION_0_0_0_1, HYEXPRESSION_0_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_0_0 = INSTANCE.getHYEXPRESSION_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_0_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyEquivalenceExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_0 = INSTANCE.getHYEXPRESSION_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), HYEXPRESSION_0_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_1_0_0_0 = INSTANCE.getHYEXPRESSION_1_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_1_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND1), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_1_0_0_1 = INSTANCE.getHYEXPRESSION_1_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_1_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("->", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_1_0_0_2 = INSTANCE.getHYEXPRESSION_1_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_1_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND2), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_1_0_0 = INSTANCE.getHYEXPRESSION_1_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_1_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_1_0_0_0, HYEXPRESSION_1_0_0_1, HYEXPRESSION_1_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_1_0 = INSTANCE.getHYEXPRESSION_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_1_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyImpliesExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_1 = INSTANCE.getHYEXPRESSION_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), HYEXPRESSION_1_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_2_0_0_0 = INSTANCE.getHYEXPRESSION_2_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_2_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND1), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_2_0_0_1 = INSTANCE.getHYEXPRESSION_2_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_2_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("||", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_2_0_0_2 = INSTANCE.getHYEXPRESSION_2_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_2_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND2), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_2_0_0 = INSTANCE.getHYEXPRESSION_2_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_2_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_2_0_0_0, HYEXPRESSION_2_0_0_1, HYEXPRESSION_2_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_2_0 = INSTANCE.getHYEXPRESSION_2_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_2_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_2_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyOrExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_2 = INSTANCE.getHYEXPRESSION_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), HYEXPRESSION_2_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_3_0_0_0 = INSTANCE.getHYEXPRESSION_3_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_3_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND1), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_3_0_0_1 = INSTANCE.getHYEXPRESSION_3_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_3_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("&&", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_3_0_0_2 = INSTANCE.getHYEXPRESSION_3_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_3_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND2), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_3_0_0 = INSTANCE.getHYEXPRESSION_3_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_3_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_3_0_0_0, HYEXPRESSION_3_0_0_1, HYEXPRESSION_3_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_3_0 = INSTANCE.getHYEXPRESSION_3_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_3_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_3_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyAndExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_3 = INSTANCE.getHYEXPRESSION_3();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_3() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), HYEXPRESSION_3_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_4_0_0_0 = INSTANCE.getHYEXPRESSION_4_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_4_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("!", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_4_0_0_1 = INSTANCE.getHYEXPRESSION_4_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_4_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EXPRESSION__OPERAND), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_4_0_0 = INSTANCE.getHYEXPRESSION_4_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_4_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_4_0_0_0, HYEXPRESSION_4_0_0_1);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_4_0 = INSTANCE.getHYEXPRESSION_4_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_4_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_4_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyNotExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_4 = INSTANCE.getHYEXPRESSION_4();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_4() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), HYEXPRESSION_4_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_5_0_0_0 = INSTANCE.getHYEXPRESSION_5_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_5_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("(", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_5_0_0_1 = INSTANCE.getHYEXPRESSION_5_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_5_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NESTED_EXPRESSION__OPERAND), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_5_0_0_2 = INSTANCE.getHYEXPRESSION_5_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_5_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword(")", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_5_0_0 = INSTANCE.getHYEXPRESSION_5_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_5_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_5_0_0_0, HYEXPRESSION_5_0_0_1, HYEXPRESSION_5_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_5_0 = INSTANCE.getHYEXPRESSION_5_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_5_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_5_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyNestedExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_5 = INSTANCE.getHYEXPRESSION_5();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_5() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), HYEXPRESSION_5_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYEXPRESSION_6_0_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_0_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYEXPRESSION_6_0_0_0_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_6_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_6_0_0_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_6_0_0_0_0_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYEXPRESSION_6_0_0_0_0_1_0 = INSTANCE.getHYEXPRESSION_6_0_0_0_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYEXPRESSION_6_0_0_0_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_6_0_0_0_0_1 = INSTANCE.getHYEXPRESSION_6_0_0_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_6_0_0_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_6_0_0_0_0_1_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_6_0_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_6_0_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_6_0_0_0_0_0, HYEXPRESSION_6_0_0_0_0_1);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound HYEXPRESSION_6_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound getHYEXPRESSION_6_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound(HYEXPRESSION_6_0_0_0_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_6_0_0_1_0_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_1_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_6_0_0_1_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRestriction(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_6_0_0_1_0_0 = INSTANCE.getHYEXPRESSION_6_0_0_1_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_6_0_0_1_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_6_0_0_1_0_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_6_0_0_1_0 = INSTANCE.getHYEXPRESSION_6_0_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_6_0_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_6_0_0_1_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound HYEXPRESSION_6_0_0_1 = INSTANCE.getHYEXPRESSION_6_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound getHYEXPRESSION_6_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound(HYEXPRESSION_6_0_0_1_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.QUESTIONMARK);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_6_0_0 = INSTANCE.getHYEXPRESSION_6_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_6_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_6_0_0_0, HYEXPRESSION_6_0_0_1);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_6_0 = INSTANCE.getHYEXPRESSION_6_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_6_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_6_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyFeatureReferenceExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_6 = INSTANCE.getHYEXPRESSION_6();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_6() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), HYEXPRESSION_6_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_7_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_7_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("?", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYEXPRESSION_7_0_0_1_0_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYEXPRESSION_7_0_0_1_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_7_0_0_1_0_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_7_0_0_1_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_7_0_0_1_0_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYEXPRESSION_7_0_0_1_0_1_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYEXPRESSION_7_0_0_1_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_7_0_0_1_0_1 = INSTANCE.getHYEXPRESSION_7_0_0_1_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_7_0_0_1_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_7_0_0_1_0_1_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_7_0_0_1_0 = INSTANCE.getHYEXPRESSION_7_0_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_7_0_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_7_0_0_1_0_0, HYEXPRESSION_7_0_0_1_0_1);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound HYEXPRESSION_7_0_0_1 = INSTANCE.getHYEXPRESSION_7_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound getHYEXPRESSION_7_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound(HYEXPRESSION_7_0_0_1_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_7_0_0_2 = INSTANCE.getHYEXPRESSION_7_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_7_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRestriction(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_7_0_0 = INSTANCE.getHYEXPRESSION_7_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_7_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_7_0_0_0, HYEXPRESSION_7_0_0_1, HYEXPRESSION_7_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_7_0 = INSTANCE.getHYEXPRESSION_7_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_7_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_7_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyConditionalFeatureReferenceExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_7 = INSTANCE.getHYEXPRESSION_7();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_7() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), HYEXPRESSION_7_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal HYEXPRESSION_8_0_0_0 = INSTANCE.getHYEXPRESSION_8_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal getHYEXPRESSION_8_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyBooleanValueExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), "true", "false", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_8_0_0 = INSTANCE.getHYEXPRESSION_8_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_8_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_8_0_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_8_0 = INSTANCE.getHYEXPRESSION_8_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_8_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_8_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyBooleanValueExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_8 = INSTANCE.getHYEXPRESSION_8();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_8() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyBooleanValueExpression(), HYEXPRESSION_8_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_9_0_0_0 = INSTANCE.getHYEXPRESSION_9_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_9_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("{", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_9_0_0_1 = INSTANCE.getHYEXPRESSION_9_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_9_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERAND1), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileEnumerationTerminal HYEXPRESSION_9_0_0_2 = INSTANCE.getHYEXPRESSION_9_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileEnumerationTerminal getHYEXPRESSION_9_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileEnumerationTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), new String[] {"HyLessOperator", "<", "HyLessOrEqualOperator", "<=", "HyEqualOperator", "=", "HyNotEqualOperator", "!=", "HyGreaterOrEqualOperator", ">=", "HyGreaterOperator", ">", }, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_9_0_0_3 = INSTANCE.getHYEXPRESSION_9_0_0_3();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_9_0_0_3() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERAND2), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_9_0_0_4 = INSTANCE.getHYEXPRESSION_9_0_0_4();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_9_0_0_4() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("}", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_9_0_0 = INSTANCE.getHYEXPRESSION_9_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_9_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_9_0_0_0, HYEXPRESSION_9_0_0_1, HYEXPRESSION_9_0_0_2, HYEXPRESSION_9_0_0_3, HYEXPRESSION_9_0_0_4);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_9_0 = INSTANCE.getHYEXPRESSION_9_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_9_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_9_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyArithmeticalComparisonExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_9 = INSTANCE.getHYEXPRESSION_9();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_9() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(), HYEXPRESSION_9_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_10_0_0_0 = INSTANCE.getHYEXPRESSION_10_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_10_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND1), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_10_0_0_1 = INSTANCE.getHYEXPRESSION_10_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_10_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("+", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_10_0_0_2 = INSTANCE.getHYEXPRESSION_10_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_10_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND2), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_10_0_0 = INSTANCE.getHYEXPRESSION_10_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_10_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_10_0_0_0, HYEXPRESSION_10_0_0_1, HYEXPRESSION_10_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_10_0 = INSTANCE.getHYEXPRESSION_10_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_10_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_10_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyAdditionExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_10 = INSTANCE.getHYEXPRESSION_10();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_10() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), HYEXPRESSION_10_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_11_0_0_0 = INSTANCE.getHYEXPRESSION_11_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_11_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND1), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_11_0_0_1 = INSTANCE.getHYEXPRESSION_11_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_11_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("-", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_11_0_0_2 = INSTANCE.getHYEXPRESSION_11_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_11_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND2), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_11_0_0 = INSTANCE.getHYEXPRESSION_11_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_11_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_11_0_0_0, HYEXPRESSION_11_0_0_1, HYEXPRESSION_11_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_11_0 = INSTANCE.getHYEXPRESSION_11_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_11_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_11_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HySubtractionExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_11 = INSTANCE.getHYEXPRESSION_11();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_11() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), HYEXPRESSION_11_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_12_0_0_0 = INSTANCE.getHYEXPRESSION_12_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_12_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND1), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_12_0_0_1 = INSTANCE.getHYEXPRESSION_12_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_12_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("%", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_12_0_0_2 = INSTANCE.getHYEXPRESSION_12_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_12_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND2), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_12_0_0 = INSTANCE.getHYEXPRESSION_12_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_12_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_12_0_0_0, HYEXPRESSION_12_0_0_1, HYEXPRESSION_12_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_12_0 = INSTANCE.getHYEXPRESSION_12_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_12_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_12_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyModuloExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_12 = INSTANCE.getHYEXPRESSION_12();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_12() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), HYEXPRESSION_12_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_13_0_0_0 = INSTANCE.getHYEXPRESSION_13_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_13_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND1), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_13_0_0_1 = INSTANCE.getHYEXPRESSION_13_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_13_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("*", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_13_0_0_2 = INSTANCE.getHYEXPRESSION_13_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_13_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND2), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_13_0_0 = INSTANCE.getHYEXPRESSION_13_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_13_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_13_0_0_0, HYEXPRESSION_13_0_0_1, HYEXPRESSION_13_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_13_0 = INSTANCE.getHYEXPRESSION_13_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_13_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_13_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyMultiplicationExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_13 = INSTANCE.getHYEXPRESSION_13();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_13() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), HYEXPRESSION_13_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_14_0_0_0 = INSTANCE.getHYEXPRESSION_14_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_14_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND1), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_14_0_0_1 = INSTANCE.getHYEXPRESSION_14_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_14_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("/", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_14_0_0_2 = INSTANCE.getHYEXPRESSION_14_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_14_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND2), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_14_0_0 = INSTANCE.getHYEXPRESSION_14_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_14_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_14_0_0_0, HYEXPRESSION_14_0_0_1, HYEXPRESSION_14_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_14_0 = INSTANCE.getHYEXPRESSION_14_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_14_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_14_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyDivisionExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_14 = INSTANCE.getHYEXPRESSION_14();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_14() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), HYEXPRESSION_14_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_15_0_0_0 = INSTANCE.getHYEXPRESSION_15_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_15_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("-", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_15_0_0_1 = INSTANCE.getHYEXPRESSION_15_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_15_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NEGATION_EXPRESSION__OPERAND), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_15_0_0 = INSTANCE.getHYEXPRESSION_15_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_15_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_15_0_0_0, HYEXPRESSION_15_0_0_1);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_15_0 = INSTANCE.getHYEXPRESSION_15_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_15_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_15_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyNegationExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_15 = INSTANCE.getHYEXPRESSION_15();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_15() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), HYEXPRESSION_15_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_16_0_0_0 = INSTANCE.getHYEXPRESSION_16_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_16_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("(", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_16_0_0_1 = INSTANCE.getHYEXPRESSION_16_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_16_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedArithmeticalValueExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NESTED_ARITHMETICAL_VALUE_EXPRESSION__OPERAND), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalValueExpression(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_16_0_0_2 = INSTANCE.getHYEXPRESSION_16_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_16_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword(")", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_16_0_0 = INSTANCE.getHYEXPRESSION_16_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_16_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_16_0_0_0, HYEXPRESSION_16_0_0_1, HYEXPRESSION_16_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_16_0 = INSTANCE.getHYEXPRESSION_16_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_16_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_16_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyNestedArithmeticalValueExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_16 = INSTANCE.getHYEXPRESSION_16();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_16() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedArithmeticalValueExpression(), HYEXPRESSION_16_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYEXPRESSION_17_0_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_17_0_0_0_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYEXPRESSION_17_0_0_0_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), "QUOTED_34_34", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_17_0_0_0_0_0 = INSTANCE.getHYEXPRESSION_17_0_0_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_17_0_0_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_17_0_0_0_0_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYEXPRESSION_17_0_0_0_0_1_0 = INSTANCE.getHYEXPRESSION_17_0_0_0_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYEXPRESSION_17_0_0_0_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), "IDENTIFIER_TOKEN", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_17_0_0_0_0_1 = INSTANCE.getHYEXPRESSION_17_0_0_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_17_0_0_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_17_0_0_0_0_1_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_17_0_0_0_0 = INSTANCE.getHYEXPRESSION_17_0_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_17_0_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_17_0_0_0_0_0, HYEXPRESSION_17_0_0_0_0_1);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound HYEXPRESSION_17_0_0_0 = INSTANCE.getHYEXPRESSION_17_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound getHYEXPRESSION_17_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound(HYEXPRESSION_17_0_0_0_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_17_0_0_1 = INSTANCE.getHYEXPRESSION_17_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_17_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword(".", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYEXPRESSION_17_0_0_2 = INSTANCE.getHYEXPRESSION_17_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYEXPRESSION_17_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), "IDENTIFIER_TOKEN", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_17_0_0 = INSTANCE.getHYEXPRESSION_17_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_17_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_17_0_0_0, HYEXPRESSION_17_0_0_1, HYEXPRESSION_17_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_17_0 = INSTANCE.getHYEXPRESSION_17_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_17_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_17_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyAttributeReferenceExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_17 = INSTANCE.getHYEXPRESSION_17();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_17() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAttributeReferenceExpression(), HYEXPRESSION_17_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_18_0_0_0 = INSTANCE.getHYEXPRESSION_18_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_18_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("context:", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYEXPRESSION_18_0_0_1_0_0_0 = INSTANCE.getHYEXPRESSION_18_0_0_1_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYEXPRESSION_18_0_0_1_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), "QUOTED_34_34", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_18_0_0_1_0_0 = INSTANCE.getHYEXPRESSION_18_0_0_1_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_18_0_0_1_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_18_0_0_1_0_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYEXPRESSION_18_0_0_1_0_1_0 = INSTANCE.getHYEXPRESSION_18_0_0_1_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYEXPRESSION_18_0_0_1_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), "IDENTIFIER_TOKEN", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_18_0_0_1_0_1 = INSTANCE.getHYEXPRESSION_18_0_0_1_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_18_0_0_1_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_18_0_0_1_0_1_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_18_0_0_1_0 = INSTANCE.getHYEXPRESSION_18_0_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_18_0_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_18_0_0_1_0_0, HYEXPRESSION_18_0_0_1_0_1);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound HYEXPRESSION_18_0_0_1 = INSTANCE.getHYEXPRESSION_18_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound getHYEXPRESSION_18_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound(HYEXPRESSION_18_0_0_1_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_18_0_0 = INSTANCE.getHYEXPRESSION_18_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_18_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_18_0_0_0, HYEXPRESSION_18_0_0_1);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_18_0 = INSTANCE.getHYEXPRESSION_18_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_18_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_18_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyContextInformationReferenceExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_18 = INSTANCE.getHYEXPRESSION_18();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_18() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyContextInformationReferenceExpression(), HYEXPRESSION_18_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYEXPRESSION_19_0_0_0 = INSTANCE.getHYEXPRESSION_19_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYEXPRESSION_19_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VALUE_EXPRESSION__VALUE), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyValue(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_19_0_0 = INSTANCE.getHYEXPRESSION_19_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_19_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_19_0_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_19_0 = INSTANCE.getHYEXPRESSION_19_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_19_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_19_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyValueExpression
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_19 = INSTANCE.getHYEXPRESSION_19();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_19() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression(), HYEXPRESSION_19_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_20_0_0_0 = INSTANCE.getHYEXPRESSION_20_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_20_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("[", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileEnumerationTerminal HYEXPRESSION_20_0_0_1 = INSTANCE.getHYEXPRESSION_20_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileEnumerationTerminal getHYEXPRESSION_20_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileEnumerationTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), new String[] {"lessThan", "<", "lessThanOrEqual", "<=", "equal", "=", "implicitEqual", "", "greaterThanOrEqual", ">=", "greaterThan", ">", }, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYEXPRESSION_20_0_0_2 = INSTANCE.getHYEXPRESSION_20_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYEXPRESSION_20_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), "QUOTED_34_34", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_20_0_0_3 = INSTANCE.getHYEXPRESSION_20_0_0_3();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_20_0_0_3() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("]", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_20_0_0 = INSTANCE.getHYEXPRESSION_20_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_20_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_20_0_0_0, HYEXPRESSION_20_0_0_1, HYEXPRESSION_20_0_0_2, HYEXPRESSION_20_0_0_3);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_20_0 = INSTANCE.getHYEXPRESSION_20_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_20_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_20_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyRelativeVersionRestriction
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_20 = INSTANCE.getHYEXPRESSION_20();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_20() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestriction(), HYEXPRESSION_20_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_21_0_0_0 = INSTANCE.getHYEXPRESSION_21_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_21_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("[", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal HYEXPRESSION_21_0_0_1 = INSTANCE.getHYEXPRESSION_21_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal getHYEXPRESSION_21_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), "", "^", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYEXPRESSION_21_0_0_2 = INSTANCE.getHYEXPRESSION_21_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYEXPRESSION_21_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), "QUOTED_34_34", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_21_0_0_3 = INSTANCE.getHYEXPRESSION_21_0_0_3();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_21_0_0_3() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("-", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal HYEXPRESSION_21_0_0_4 = INSTANCE.getHYEXPRESSION_21_0_0_4();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal getHYEXPRESSION_21_0_0_4() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), "", "^", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYEXPRESSION_21_0_0_5 = INSTANCE.getHYEXPRESSION_21_0_0_5();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYEXPRESSION_21_0_0_5() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), "QUOTED_34_34", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYEXPRESSION_21_0_0_6 = INSTANCE.getHYEXPRESSION_21_0_0_6();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYEXPRESSION_21_0_0_6() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("]", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYEXPRESSION_21_0_0 = INSTANCE.getHYEXPRESSION_21_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYEXPRESSION_21_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_21_0_0_0, HYEXPRESSION_21_0_0_1, HYEXPRESSION_21_0_0_2, HYEXPRESSION_21_0_0_3, HYEXPRESSION_21_0_0_4, HYEXPRESSION_21_0_0_5, HYEXPRESSION_21_0_0_6);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYEXPRESSION_21_0 = INSTANCE.getHYEXPRESSION_21_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYEXPRESSION_21_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYEXPRESSION_21_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyVersionRangeRestriction
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYEXPRESSION_21 = INSTANCE.getHYEXPRESSION_21();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYEXPRESSION_21() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyVersionRangeRestriction(), HYEXPRESSION_21_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_0_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_0_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_NUMBER_VALUE__VALUE), "INTEGER_LITERAL", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_0_0_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYDATAVALUE_0_0 = INSTANCE.getHYDATAVALUE_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYDATAVALUE_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_0_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyNumberValue
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYDATAVALUE_0 = INSTANCE.getHYDATAVALUE_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYDATAVALUE_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue(), HYDATAVALUE_0_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal HYDATAVALUE_1_0_0_0 = INSTANCE.getHYDATAVALUE_1_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal getHYDATAVALUE_1_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), "true", "false", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_1_0_0 = INSTANCE.getHYDATAVALUE_1_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_1_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_1_0_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYDATAVALUE_1_0 = INSTANCE.getHYDATAVALUE_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYDATAVALUE_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_1_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyBooleanValue
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYDATAVALUE_1 = INSTANCE.getHYDATAVALUE_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYDATAVALUE_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue(), HYDATAVALUE_1_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_2_0_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_2_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("enum:", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_2_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_1_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_2_0_0_1_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), "QUOTED_34_34", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_2_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_1_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_2_0_0_1_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_2_0_0_1_0_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_2_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_2_0_0_1_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_2_0_0_1_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), "IDENTIFIER_TOKEN", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_2_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_2_0_0_1_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_2_0_0_1_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_2_0_0_1_0_1_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYDATAVALUE_2_0_0_1_0 = INSTANCE.getHYDATAVALUE_2_0_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYDATAVALUE_2_0_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_2_0_0_1_0_0, HYDATAVALUE_2_0_0_1_0_1);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound HYDATAVALUE_2_0_0_1 = INSTANCE.getHYDATAVALUE_2_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound getHYDATAVALUE_2_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound(HYDATAVALUE_2_0_0_1_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_2_0_0_2 = INSTANCE.getHYDATAVALUE_2_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_2_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword(".", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_2_0_0_3_0_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_3_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_2_0_0_3_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), "QUOTED_34_34", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_2_0_0_3_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_3_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_2_0_0_3_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_2_0_0_3_0_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_2_0_0_3_0_1_0 = INSTANCE.getHYDATAVALUE_2_0_0_3_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_2_0_0_3_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), "IDENTIFIER_TOKEN", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_2_0_0_3_0_1 = INSTANCE.getHYDATAVALUE_2_0_0_3_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_2_0_0_3_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_2_0_0_3_0_1_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYDATAVALUE_2_0_0_3_0 = INSTANCE.getHYDATAVALUE_2_0_0_3_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYDATAVALUE_2_0_0_3_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_2_0_0_3_0_0, HYDATAVALUE_2_0_0_3_0_1);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound HYDATAVALUE_2_0_0_3 = INSTANCE.getHYDATAVALUE_2_0_0_3();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound getHYDATAVALUE_2_0_0_3() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound(HYDATAVALUE_2_0_0_3_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_2_0_0 = INSTANCE.getHYDATAVALUE_2_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_2_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_2_0_0_0, HYDATAVALUE_2_0_0_1, HYDATAVALUE_2_0_0_2, HYDATAVALUE_2_0_0_3);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYDATAVALUE_2_0 = INSTANCE.getHYDATAVALUE_2_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYDATAVALUE_2_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_2_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class HyEnumValue
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYDATAVALUE_2 = INSTANCE.getHYDATAVALUE_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYDATAVALUE_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue(), HYDATAVALUE_2_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_3_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("Enum(", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_3_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__NAME), "IDENTIFIER_TOKEN", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_3_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_3_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword(",", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYDATAVALUE_3_0_0_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYDATAVALUE_3_0_0_3_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_3_0_0_3_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword(",", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment HYDATAVALUE_3_0_0_3_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_3_0_0_3_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_3_0_0_3_0_0_1_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1_0_0_1);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYDATAVALUE_3_0_0_3_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYDATAVALUE_3_0_0_3_0_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound HYDATAVALUE_3_0_0_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound getHYDATAVALUE_3_0_0_3_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound(HYDATAVALUE_3_0_0_3_0_0_1_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.STAR);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_3_0_0_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_3_0_0_3_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYDATAVALUE_3_0_0_3_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYDATAVALUE_3_0_0_3_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound HYDATAVALUE_3_0_0_3 = INSTANCE.getHYDATAVALUE_3_0_0_3();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound getHYDATAVALUE_3_0_0_3() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound(HYDATAVALUE_3_0_0_3_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.QUESTIONMARK);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_3_0_0_4 = INSTANCE.getHYDATAVALUE_3_0_0_4();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_3_0_0_4() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword(")", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_3_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_3_0_0_5_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("[", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("-", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_3_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("-", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_3_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1_1);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("eternity", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("-", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_3_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYDATAVALUE_3_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYDATAVALUE_3_0_0_5_0_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound HYDATAVALUE_3_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound getHYDATAVALUE_3_0_0_5_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound(HYDATAVALUE_3_0_0_5_0_0_1_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_3_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_3_0_0_5_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("]", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_3_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_3_0_0_5_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1, HYDATAVALUE_3_0_0_5_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYDATAVALUE_3_0_0_5_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYDATAVALUE_3_0_0_5_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound HYDATAVALUE_3_0_0_5 = INSTANCE.getHYDATAVALUE_3_0_0_5();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound getHYDATAVALUE_3_0_0_5() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound(HYDATAVALUE_3_0_0_5_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.QUESTIONMARK);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_3_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_3_0_0_0, HYDATAVALUE_3_0_0_1, HYDATAVALUE_3_0_0_2, HYDATAVALUE_3_0_0_3, HYDATAVALUE_3_0_0_4, HYDATAVALUE_3_0_0_5);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYDATAVALUE_3_0 = INSTANCE.getHYDATAVALUE_3_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYDATAVALUE_3_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_3_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class HyEnum
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYDATAVALUE_3 = INSTANCE.getHYDATAVALUE_3();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYDATAVALUE_3() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), HYDATAVALUE_3_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_4_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_4_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("EnumLiteral(", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_4_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_4_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__NAME), "IDENTIFIER_TOKEN", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_4_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_4_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword(",", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_4_0_0_3 = INSTANCE.getHYDATAVALUE_4_0_0_3();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_4_0_0_3() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALUE), "INTEGER_LITERAL", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_4_0_0_4 = INSTANCE.getHYDATAVALUE_4_0_0_4();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_4_0_0_4() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword(")", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_4_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_4_0_0_5_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("[", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("-", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_4_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("-", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("eternity", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_4_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, HYDATAVALUE_4_0_0_5_0_0_1_0_1_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("eternity", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("-", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofilePlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, 0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_4_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYDATAVALUE_4_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYDATAVALUE_4_0_0_5_0_0_1_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound HYDATAVALUE_4_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound getHYDATAVALUE_4_0_0_5_0_0_1() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound(HYDATAVALUE_4_0_0_5_0_0_1_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword HYDATAVALUE_4_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_2();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword getHYDATAVALUE_4_0_0_5_0_0_2() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword("]", de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_4_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_4_0_0_5_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1, HYDATAVALUE_4_0_0_5_0_0_2);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYDATAVALUE_4_0_0_5_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYDATAVALUE_4_0_0_5_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound HYDATAVALUE_4_0_0_5 = INSTANCE.getHYDATAVALUE_4_0_0_5();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound getHYDATAVALUE_4_0_0_5() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCompound(HYDATAVALUE_4_0_0_5_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.QUESTIONMARK);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence HYDATAVALUE_4_0_0 = INSTANCE.getHYDATAVALUE_4_0_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence getHYDATAVALUE_4_0_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSequence(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_4_0_0_0, HYDATAVALUE_4_0_0_1, HYDATAVALUE_4_0_0_2, HYDATAVALUE_4_0_0_3, HYDATAVALUE_4_0_0_4, HYDATAVALUE_4_0_0_5);
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice HYDATAVALUE_4_0 = INSTANCE.getHYDATAVALUE_4_0();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice getHYDATAVALUE_4_0() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileChoice(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE, HYDATAVALUE_4_0_0);
	}
	
	/**
	 * This constant refers to the definition of the syntax for meta class
	 * HyEnumLiteral
	 */
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule HYDATAVALUE_4 = INSTANCE.getHYDATAVALUE_4();
	private de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule getHYDATAVALUE_4() {
		return new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), HYDATAVALUE_4_0, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality.ONE);
	}
	
	
	public static String getSyntaxElementID(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (Field field : de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.class.getFields()) {
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
	
	public static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement) de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule[] RULES = new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule[] {
		DWPROFILE_0,
		DWPROFILE_1,
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
			for (de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement element, Set<String> keywords) {
		if (element instanceof de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword) {
			keywords.add(((de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileKeyword) element).getValue());
		} else if (element instanceof de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal) {
			keywords.add(((de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal) element).getTrueLiteral());
			keywords.add(((de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileEnumerationTerminal) {
			de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileEnumerationTerminal terminal = (de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
