/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * This class provides an implementation of the
 * de.darwinspl.preferences.resource.dwprofile.IDwprofileTextDiagnostic interface.
 * However, it is recommended to use the
 * de.darwinspl.preferences.resource.dwprofile.mopp.DwprofilePrinter2 instead,
 * because it provides advanced printing features. There are even some features
 * (e.g., printing enumeration terminals) which are only supported by that class.
 */
public class DwprofilePrinter implements de.darwinspl.preferences.resource.dwprofile.IDwprofileTextPrinter {
	
	protected de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolverFactory tokenResolverFactory = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTokenResolverFactory();
	
	protected OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource;
	
	private Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public DwprofilePrinter(OutputStream outputStream, de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(Map<String, Integer> featureCounter, Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(EObject element, PrintWriter out, String globaltab) {
		if (element == null) {
			throw new IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof de.darwinspl.preferences.DwProfile) {
			print_de_darwinspl_preferences_DwProfile((de.darwinspl.preferences.DwProfile) element, globaltab, out);
			return;
		}
		if (element instanceof de.darwinspl.preferences.DwPreference) {
			print_de_darwinspl_preferences_DwPreference((de.darwinspl.preferences.DwPreference) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyEquivalenceExpression) {
			print_eu_hyvar_feature_expression_HyEquivalenceExpression((eu.hyvar.feature.expression.HyEquivalenceExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyImpliesExpression) {
			print_eu_hyvar_feature_expression_HyImpliesExpression((eu.hyvar.feature.expression.HyImpliesExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyOrExpression) {
			print_eu_hyvar_feature_expression_HyOrExpression((eu.hyvar.feature.expression.HyOrExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyAndExpression) {
			print_eu_hyvar_feature_expression_HyAndExpression((eu.hyvar.feature.expression.HyAndExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyNotExpression) {
			print_eu_hyvar_feature_expression_HyNotExpression((eu.hyvar.feature.expression.HyNotExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyNestedExpression) {
			print_eu_hyvar_feature_expression_HyNestedExpression((eu.hyvar.feature.expression.HyNestedExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyFeatureReferenceExpression) {
			print_eu_hyvar_feature_expression_HyFeatureReferenceExpression((eu.hyvar.feature.expression.HyFeatureReferenceExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression) {
			print_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression((eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyBooleanValueExpression) {
			print_eu_hyvar_feature_expression_HyBooleanValueExpression((eu.hyvar.feature.expression.HyBooleanValueExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyArithmeticalComparisonExpression) {
			print_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression((eu.hyvar.feature.expression.HyArithmeticalComparisonExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyAdditionExpression) {
			print_eu_hyvar_feature_expression_HyAdditionExpression((eu.hyvar.feature.expression.HyAdditionExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HySubtractionExpression) {
			print_eu_hyvar_feature_expression_HySubtractionExpression((eu.hyvar.feature.expression.HySubtractionExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyModuloExpression) {
			print_eu_hyvar_feature_expression_HyModuloExpression((eu.hyvar.feature.expression.HyModuloExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyMultiplicationExpression) {
			print_eu_hyvar_feature_expression_HyMultiplicationExpression((eu.hyvar.feature.expression.HyMultiplicationExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyDivisionExpression) {
			print_eu_hyvar_feature_expression_HyDivisionExpression((eu.hyvar.feature.expression.HyDivisionExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyNegationExpression) {
			print_eu_hyvar_feature_expression_HyNegationExpression((eu.hyvar.feature.expression.HyNegationExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression) {
			print_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression((eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyAttributeReferenceExpression) {
			print_eu_hyvar_feature_expression_HyAttributeReferenceExpression((eu.hyvar.feature.expression.HyAttributeReferenceExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyContextInformationReferenceExpression) {
			print_eu_hyvar_feature_expression_HyContextInformationReferenceExpression((eu.hyvar.feature.expression.HyContextInformationReferenceExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyValueExpression) {
			print_eu_hyvar_feature_expression_HyValueExpression((eu.hyvar.feature.expression.HyValueExpression) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyRelativeVersionRestriction) {
			print_eu_hyvar_feature_expression_HyRelativeVersionRestriction((eu.hyvar.feature.expression.HyRelativeVersionRestriction) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.feature.expression.HyVersionRangeRestriction) {
			print_eu_hyvar_feature_expression_HyVersionRangeRestriction((eu.hyvar.feature.expression.HyVersionRangeRestriction) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.dataValues.HyNumberValue) {
			print_eu_hyvar_dataValues_HyNumberValue((eu.hyvar.dataValues.HyNumberValue) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.dataValues.HyBooleanValue) {
			print_eu_hyvar_dataValues_HyBooleanValue((eu.hyvar.dataValues.HyBooleanValue) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.dataValues.HyEnumValue) {
			print_eu_hyvar_dataValues_HyEnumValue((eu.hyvar.dataValues.HyEnumValue) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.dataValues.HyEnum) {
			print_eu_hyvar_dataValues_HyEnum((eu.hyvar.dataValues.HyEnum) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.dataValues.HyEnumLiteral) {
			print_eu_hyvar_dataValues_HyEnumLiteral((eu.hyvar.dataValues.HyEnumLiteral) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileReferenceResolverSwitch getReferenceResolverSwitch() {
		return (de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileReferenceResolverSwitch) new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, EObject cause) {
		de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileProblem(errorMessage, de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemType.PRINT_PROBLEM, de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(Map<?,?> options) {
		this.options = options;
	}
	
	public Map<?,?> getOptions() {
		return options;
	}
	
	public void setEncoding(String encoding) {
		if (encoding != null) {
			this.encoding = encoding;
		}
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(EObject element) throws java.io.IOException {
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(outputStream), encoding));
		doPrint(element, out, "");
		out.flush();
	}
	
	public void print_de_darwinspl_preferences_DwProfile(de.darwinspl.preferences.DwProfile element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PROFILE__PREFERENCES));
		printCountingMap.put("preferences", temp == null ? 0 : ((Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PROFILE__FEATURE_MODEL));
		printCountingMap.put("featureModel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PROFILE__CONTEXT_MODEL));
		printCountingMap.put("contextModel", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("preferences");
		if (count > 0) {
			List<?> list = (List<?>)element.eGet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PROFILE__PREFERENCES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("preferences", 0);
		}
	}
	
	
	public void print_de_darwinspl_preferences_DwPreference(de.darwinspl.preferences.DwPreference element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_SINCE));
		printCountingMap.put("validSince", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_UNTIL));
		printCountingMap.put("validUntil", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__ROOT_EXPRESSION));
		printCountingMap.put("rootExpression", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("rootExpression");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__ROOT_EXPRESSION));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("rootExpression", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_de_darwinspl_preferences_DwPreference_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_de_darwinspl_preferences_DwPreference_0(de.darwinspl.preferences.DwPreference element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_de_darwinspl_preferences_DwPreference_0_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	public void print_de_darwinspl_preferences_DwPreference_0_0(de.darwinspl.preferences.DwPreference element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, Arrays.asList(		"validSince"		,
		"validUntil"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, Arrays.asList(		"validSince"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, Arrays.asList(		"validUntil"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
				count = printCountingMap.get("validSince");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_SINCE));
					if (o != null) {
						de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_SINCE), element));
						out.print(" ");
					}
					printCountingMap.put("validSince", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("-");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("eternity");
				out.print(" ");
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("eternity");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("-");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
				count = printCountingMap.get("validUntil");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_UNTIL));
					if (o != null) {
						de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_UNTIL), element));
						out.print(" ");
					}
					printCountingMap.put("validUntil", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("validSince");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_SINCE));
				if (o != null) {
					de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_SINCE), element));
					out.print(" ");
				}
				printCountingMap.put("validSince", count - 1);
			}
			// DEFINITION PART BEGINS (CsString)
			out.print("-");
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("validUntil");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_UNTIL));
				if (o != null) {
					de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_UNTIL), element));
					out.print(" ");
				}
				printCountingMap.put("validUntil", count - 1);
			}
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyEquivalenceExpression(eu.hyvar.feature.expression.HyEquivalenceExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND1));
		printCountingMap.put("operand1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND2));
		printCountingMap.put("operand2", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand1");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND1));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand1", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("<->");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand2");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND2));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand2", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyImpliesExpression(eu.hyvar.feature.expression.HyImpliesExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND1));
		printCountingMap.put("operand1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND2));
		printCountingMap.put("operand2", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand1");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND1));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand1", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand2");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND2));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand2", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyOrExpression(eu.hyvar.feature.expression.HyOrExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND1));
		printCountingMap.put("operand1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND2));
		printCountingMap.put("operand2", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand1");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND1));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand1", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("||");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand2");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND2));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand2", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyAndExpression(eu.hyvar.feature.expression.HyAndExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND1));
		printCountingMap.put("operand1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND2));
		printCountingMap.put("operand2", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand1");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND1));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand1", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("&&");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand2");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND2));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand2", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyNotExpression(eu.hyvar.feature.expression.HyNotExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EXPRESSION__OPERAND));
		printCountingMap.put("operand", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("!");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EXPRESSION__OPERAND));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyNestedExpression(eu.hyvar.feature.expression.HyNestedExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NESTED_EXPRESSION__OPERAND));
		printCountingMap.put("operand", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NESTED_EXPRESSION__OPERAND));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	
	public void print_eu_hyvar_feature_expression_HyFeatureReferenceExpression(eu.hyvar.feature.expression.HyFeatureReferenceExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION));
		printCountingMap.put("versionRestriction", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		// print collected hidden tokens
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_feature_expression_HyFeatureReferenceExpression_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_eu_hyvar_feature_expression_HyFeatureReferenceExpression_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_eu_hyvar_feature_expression_HyFeatureReferenceExpression_0(eu.hyvar.feature.expression.HyFeatureReferenceExpression element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, Arrays.asList(		"feature"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, Arrays.asList(		"feature"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("feature");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE));
					if (o != null) {
						de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver().deResolve((eu.hyvar.feature.HyFeature) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE)), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), element));
						out.print(" ");
					}
					printCountingMap.put("feature", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("feature");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE));
				if (o != null) {
					de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver().deResolve((eu.hyvar.feature.HyFeature) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE)), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), element));
					out.print(" ");
				}
				printCountingMap.put("feature", count - 1);
			}
		}
	}
	
	public void print_eu_hyvar_feature_expression_HyFeatureReferenceExpression_1(eu.hyvar.feature.expression.HyFeatureReferenceExpression element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("versionRestriction");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("versionRestriction", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression(eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION));
		printCountingMap.put("versionRestriction", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("?");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("versionRestriction");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("versionRestriction", count - 1);
		}
	}
	
	public void print_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_0(eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, Arrays.asList(		"feature"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, Arrays.asList(		"feature"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("feature");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE));
					if (o != null) {
						de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver().deResolve((eu.hyvar.feature.HyFeature) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE)), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), element));
						out.print(" ");
					}
					printCountingMap.put("feature", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("feature");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE));
				if (o != null) {
					de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver().deResolve((eu.hyvar.feature.HyFeature) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE)), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), element));
					out.print(" ");
				}
				printCountingMap.put("feature", count - 1);
			}
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyBooleanValueExpression(eu.hyvar.feature.expression.HyBooleanValueExpression element, String outertab, PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE));
			if (o != null) {
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression(eu.hyvar.feature.expression.HyArithmeticalComparisonExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR));
		printCountingMap.put("operator", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERAND1));
		printCountingMap.put("operand1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERAND2));
		printCountingMap.put("operand2", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand1");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERAND1));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand1", count - 1);
		}
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("operator");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR));
			if (o != null) {
			}
			printCountingMap.put("operator", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand2");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERAND2));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand2", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	
	public void print_eu_hyvar_feature_expression_HyAdditionExpression(eu.hyvar.feature.expression.HyAdditionExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND1));
		printCountingMap.put("operand1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND2));
		printCountingMap.put("operand2", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand1");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND1));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand1", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("+");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand2");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND2));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand2", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HySubtractionExpression(eu.hyvar.feature.expression.HySubtractionExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND1));
		printCountingMap.put("operand1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND2));
		printCountingMap.put("operand2", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand1");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND1));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand1", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("-");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand2");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND2));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand2", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyModuloExpression(eu.hyvar.feature.expression.HyModuloExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND1));
		printCountingMap.put("operand1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND2));
		printCountingMap.put("operand2", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand1");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND1));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand1", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("%");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand2");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND2));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand2", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyMultiplicationExpression(eu.hyvar.feature.expression.HyMultiplicationExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND1));
		printCountingMap.put("operand1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND2));
		printCountingMap.put("operand2", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand1");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND1));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand1", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("*");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand2");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND2));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand2", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyDivisionExpression(eu.hyvar.feature.expression.HyDivisionExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND1));
		printCountingMap.put("operand1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND2));
		printCountingMap.put("operand2", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand1");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND1));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand1", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("/");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand2");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND2));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand2", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyNegationExpression(eu.hyvar.feature.expression.HyNegationExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NEGATION_EXPRESSION__OPERAND));
		printCountingMap.put("operand", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("-");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NEGATION_EXPRESSION__OPERAND));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression(eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NESTED_ARITHMETICAL_VALUE_EXPRESSION__OPERAND));
		printCountingMap.put("operand", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NESTED_ARITHMETICAL_VALUE_EXPRESSION__OPERAND));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("operand", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	
	public void print_eu_hyvar_feature_expression_HyAttributeReferenceExpression(eu.hyvar.feature.expression.HyAttributeReferenceExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE));
		printCountingMap.put("attribute", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_feature_expression_HyAttributeReferenceExpression_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("attribute");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE));
			if (o != null) {
				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionAttributeReferenceResolver().deResolve((eu.hyvar.feature.HyFeatureAttribute) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE)), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), element));
				out.print(" ");
			}
			printCountingMap.put("attribute", count - 1);
		}
	}
	
	public void print_eu_hyvar_feature_expression_HyAttributeReferenceExpression_0(eu.hyvar.feature.expression.HyAttributeReferenceExpression element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, Arrays.asList(		"feature"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, Arrays.asList(		"feature"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("feature");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE));
					if (o != null) {
						de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver().deResolve((eu.hyvar.feature.HyFeature) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE)), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), element));
						out.print(" ");
					}
					printCountingMap.put("feature", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("feature");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE));
				if (o != null) {
					de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver().deResolve((eu.hyvar.feature.HyFeature) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE)), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), element));
					out.print(" ");
				}
				printCountingMap.put("feature", count - 1);
			}
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyContextInformationReferenceExpression(eu.hyvar.feature.expression.HyContextInformationReferenceExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION));
		printCountingMap.put("contextInformation", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_0(element, localtab, out, printCountingMap);
	}
	
	public void print_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_0(eu.hyvar.feature.expression.HyContextInformationReferenceExpression element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, Arrays.asList(		"contextInformation"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, Arrays.asList(		"contextInformation"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("contextInformation");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION));
					if (o != null) {
						de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextInformationReferenceExpressionContextInformationReferenceResolver().deResolve((eu.hyvar.context.HyContextualInformation) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION)), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), element));
						out.print(" ");
					}
					printCountingMap.put("contextInformation", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("contextInformation");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION));
				if (o != null) {
					de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextInformationReferenceExpressionContextInformationReferenceResolver().deResolve((eu.hyvar.context.HyContextualInformation) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION)), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), element));
					out.print(" ");
				}
				printCountingMap.put("contextInformation", count - 1);
			}
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyValueExpression(eu.hyvar.feature.expression.HyValueExpression element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VALUE_EXPRESSION__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VALUE_EXPRESSION__VALUE));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_feature_expression_HyRelativeVersionRestriction(eu.hyvar.feature.expression.HyRelativeVersionRestriction element, String outertab, PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__RESTRICTED_FEATURE_REFERENCE_EXPRESSION));
		printCountingMap.put("restrictedFeatureReferenceExpression", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION));
		printCountingMap.put("version", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR));
		printCountingMap.put("operator", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("operator");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR));
			if (o != null) {
			}
			printCountingMap.put("operator", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("version");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION));
			if (o != null) {
				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyRelativeVersionRestrictionVersionReferenceResolver().deResolve((eu.hyvar.feature.HyVersion) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION)), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), element));
				out.print(" ");
			}
			printCountingMap.put("version", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	
	public void print_eu_hyvar_feature_expression_HyVersionRangeRestriction(eu.hyvar.feature.expression.HyVersionRangeRestriction element, String outertab, PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__RESTRICTED_FEATURE_REFERENCE_EXPRESSION));
		printCountingMap.put("restrictedFeatureReferenceExpression", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED));
		printCountingMap.put("lowerIncluded", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED));
		printCountingMap.put("upperIncluded", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION));
		printCountingMap.put("lowerVersion", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION));
		printCountingMap.put("upperVersion", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("lowerIncluded");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED));
			if (o != null) {
			}
			printCountingMap.put("lowerIncluded", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("lowerVersion");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION));
			if (o != null) {
				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionLowerVersionReferenceResolver().deResolve((eu.hyvar.feature.HyVersion) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION)), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), element));
				out.print(" ");
			}
			printCountingMap.put("lowerVersion", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("-");
		out.print(" ");
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("upperIncluded");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED));
			if (o != null) {
			}
			printCountingMap.put("upperIncluded", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("upperVersion");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION));
			if (o != null) {
				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionUpperVersionReferenceResolver().deResolve((eu.hyvar.feature.HyVersion) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION)), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), element));
				out.print(" ");
			}
			printCountingMap.put("upperVersion", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	
	public void print_eu_hyvar_dataValues_HyNumberValue(eu.hyvar.dataValues.HyNumberValue element, String outertab, PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_NUMBER_VALUE__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_NUMBER_VALUE__VALUE));
			if (o != null) {
				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_NUMBER_VALUE__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_dataValues_HyBooleanValue(eu.hyvar.dataValues.HyBooleanValue element, String outertab, PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE));
			if (o != null) {
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_dataValues_HyEnumValue(eu.hyvar.dataValues.HyEnumValue element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL));
		printCountingMap.put("enumLiteral", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM));
		printCountingMap.put("enum", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("enum:");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_dataValues_HyEnumValue_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_dataValues_HyEnumValue_1(element, localtab, out, printCountingMap);
	}
	
	public void print_eu_hyvar_dataValues_HyEnumValue_0(eu.hyvar.dataValues.HyEnumValue element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, Arrays.asList(		"enum"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, Arrays.asList(		"enum"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("enum");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM));
					if (o != null) {
						de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver().deResolve((eu.hyvar.dataValues.HyEnum) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM)), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), element));
						out.print(" ");
					}
					printCountingMap.put("enum", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("enum");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM));
				if (o != null) {
					de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver().deResolve((eu.hyvar.dataValues.HyEnum) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM)), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), element));
					out.print(" ");
				}
				printCountingMap.put("enum", count - 1);
			}
		}
	}
	
	public void print_eu_hyvar_dataValues_HyEnumValue_1(eu.hyvar.dataValues.HyEnumValue element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, Arrays.asList(		"enumLiteral"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, Arrays.asList(		"enumLiteral"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("enumLiteral");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL));
					if (o != null) {
						de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver().deResolve((eu.hyvar.dataValues.HyEnumLiteral) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL)), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), element));
						out.print(" ");
					}
					printCountingMap.put("enumLiteral", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("enumLiteral");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL));
				if (o != null) {
					de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver().deResolve((eu.hyvar.dataValues.HyEnumLiteral) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL)), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), element));
					out.print(" ");
				}
				printCountingMap.put("enumLiteral", count - 1);
			}
		}
	}
	
	
	public void print_eu_hyvar_dataValues_HyEnum(eu.hyvar.dataValues.HyEnum element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE));
		printCountingMap.put("validSince", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL));
		printCountingMap.put("validUntil", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS));
		printCountingMap.put("literals", temp == null ? 0 : ((Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Enum(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__NAME));
			if (o != null) {
				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_eu_hyvar_dataValues_HyEnum_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_eu_hyvar_dataValues_HyEnum_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_eu_hyvar_dataValues_HyEnum_0(eu.hyvar.dataValues.HyEnum element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS));
			List<?> list = (List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
			print_eu_hyvar_dataValues_HyEnum_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_eu_hyvar_dataValues_HyEnum_0_0(eu.hyvar.dataValues.HyEnum element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS));
			List<?> list = (List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("literals", count - 1);
		}
	}
	
	public void print_eu_hyvar_dataValues_HyEnum_1(eu.hyvar.dataValues.HyEnum element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_dataValues_HyEnum_1_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	public void print_eu_hyvar_dataValues_HyEnum_1_0(eu.hyvar.dataValues.HyEnum element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, Arrays.asList(		"validSince"		,
		"validUntil"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, Arrays.asList(		"validSince"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, Arrays.asList(		"validUntil"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
				count = printCountingMap.get("validSince");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE));
					if (o != null) {
						de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), element));
						out.print(" ");
					}
					printCountingMap.put("validSince", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("-");
				out.print(" ");
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("eternity");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("-");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
				count = printCountingMap.get("validUntil");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL));
					if (o != null) {
						de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), element));
						out.print(" ");
					}
					printCountingMap.put("validUntil", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("validSince");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE));
				if (o != null) {
					de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), element));
					out.print(" ");
				}
				printCountingMap.put("validSince", count - 1);
			}
			// DEFINITION PART BEGINS (CsString)
			out.print("-");
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("validUntil");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL));
				if (o != null) {
					de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), element));
					out.print(" ");
				}
				printCountingMap.put("validUntil", count - 1);
			}
		}
	}
	
	
	public void print_eu_hyvar_dataValues_HyEnumLiteral(eu.hyvar.dataValues.HyEnumLiteral element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE));
		printCountingMap.put("validSince", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL));
		printCountingMap.put("validUntil", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__ENUM));
		printCountingMap.put("enum", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("EnumLiteral(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__NAME));
			if (o != null) {
				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALUE));
			if (o != null) {
				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_eu_hyvar_dataValues_HyEnumLiteral_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_eu_hyvar_dataValues_HyEnumLiteral_0(eu.hyvar.dataValues.HyEnumLiteral element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_dataValues_HyEnumLiteral_0_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	public void print_eu_hyvar_dataValues_HyEnumLiteral_0_0(eu.hyvar.dataValues.HyEnumLiteral element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, Arrays.asList(		"validSince"		,
		"validUntil"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, Arrays.asList(		"validSince"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, Arrays.asList(		"validUntil"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
				count = printCountingMap.get("validSince");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE));
					if (o != null) {
						de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), element));
						out.print(" ");
					}
					printCountingMap.put("validSince", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("-");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("eternity");
				out.print(" ");
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("eternity");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("-");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
				count = printCountingMap.get("validUntil");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL));
					if (o != null) {
						de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), element));
						out.print(" ");
					}
					printCountingMap.put("validUntil", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("validSince");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE));
				if (o != null) {
					de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), element));
					out.print(" ");
				}
				printCountingMap.put("validSince", count - 1);
			}
			// DEFINITION PART BEGINS (CsString)
			out.print("-");
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("validUntil");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL));
				if (o != null) {
					de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), element));
					out.print(" ");
				}
				printCountingMap.put("validUntil", count - 1);
			}
		}
	}
	
	
}
