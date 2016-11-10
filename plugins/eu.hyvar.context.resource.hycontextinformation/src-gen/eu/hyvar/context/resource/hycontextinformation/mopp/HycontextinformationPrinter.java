/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

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

public class HycontextinformationPrinter implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextPrinter {
	
	protected eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolverFactory tokenResolverFactory = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTokenResolverFactory();
	
	protected OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource resource;
	
	private Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public HycontextinformationPrinter(OutputStream outputStream, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource resource) {
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
		
		if (element instanceof eu.hyvar.context.HyContextModel) {
			print_eu_hyvar_context_HyContextModel((eu.hyvar.context.HyContextModel) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.context.HyContextualInformationNumber) {
			print_eu_hyvar_context_HyContextualInformationNumber((eu.hyvar.context.HyContextualInformationNumber) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.context.HyContextualInformationBoolean) {
			print_eu_hyvar_context_HyContextualInformationBoolean((eu.hyvar.context.HyContextualInformationBoolean) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.context.HyContextualInformationEnum) {
			print_eu_hyvar_context_HyContextualInformationEnum((eu.hyvar.context.HyContextualInformationEnum) element, globaltab, out);
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
	
	protected eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationReferenceResolverSwitch getReferenceResolverSwitch() {
		return (eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationReferenceResolverSwitch) new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, EObject cause) {
		eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationProblem(errorMessage, eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemType.PRINT_PROBLEM, eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemSeverity.WARNING), cause);
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
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource getResource() {
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
	
	public void print_eu_hyvar_context_HyContextModel(eu.hyvar.context.HyContextModel element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXT_MODEL__CONTEXTUAL_INFORMATIONS));
		printCountingMap.put("contextualInformations", temp == null ? 0 : ((Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXT_MODEL__ENUMS));
		printCountingMap.put("enums", temp == null ? 0 : ((Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("enums");
		if (count > 0) {
			List<?> list = (List<?>)element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXT_MODEL__ENUMS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("enums", 0);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("contextualInformations");
		if (count > 0) {
			List<?> list = (List<?>)element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXT_MODEL__CONTEXTUAL_INFORMATIONS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("contextualInformations", 0);
		}
	}
	
	
	public void print_eu_hyvar_context_HyContextualInformationNumber(eu.hyvar.context.HyContextualInformationNumber element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_SINCE));
		printCountingMap.put("validSince", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_UNTIL));
		printCountingMap.put("validUntil", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__MIN));
		printCountingMap.put("min", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__MAX));
		printCountingMap.put("max", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("NumberContext(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__NAME));
			if (o != null) {
				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("min");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__MIN));
			if (o != null) {
				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__MIN), element));
				out.print(" ");
			}
			printCountingMap.put("min", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("max");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__MAX));
			if (o != null) {
				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__MAX), element));
				out.print(" ");
			}
			printCountingMap.put("max", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_eu_hyvar_context_HyContextualInformationNumber_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_eu_hyvar_context_HyContextualInformationNumber_0(eu.hyvar.context.HyContextualInformationNumber element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_context_HyContextualInformationNumber_0_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	public void print_eu_hyvar_context_HyContextualInformationNumber_0_0(eu.hyvar.context.HyContextualInformationNumber element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_SINCE));
					if (o != null) {
						eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_SINCE), element));
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_UNTIL));
					if (o != null) {
						eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_UNTIL), element));
						out.print(" ");
					}
					printCountingMap.put("validUntil", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("validSince");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_SINCE));
				if (o != null) {
					eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_SINCE), element));
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
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_UNTIL));
				if (o != null) {
					eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_UNTIL), element));
					out.print(" ");
				}
				printCountingMap.put("validUntil", count - 1);
			}
		}
	}
	
	
	public void print_eu_hyvar_context_HyContextualInformationBoolean(eu.hyvar.context.HyContextualInformationBoolean element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_SINCE));
		printCountingMap.put("validSince", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_UNTIL));
		printCountingMap.put("validUntil", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("BooleanContext(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__NAME));
			if (o != null) {
				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_eu_hyvar_context_HyContextualInformationBoolean_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_eu_hyvar_context_HyContextualInformationBoolean_0(eu.hyvar.context.HyContextualInformationBoolean element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_context_HyContextualInformationBoolean_0_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	public void print_eu_hyvar_context_HyContextualInformationBoolean_0_0(eu.hyvar.context.HyContextualInformationBoolean element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_SINCE));
					if (o != null) {
						eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_SINCE), element));
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_UNTIL));
					if (o != null) {
						eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_UNTIL), element));
						out.print(" ");
					}
					printCountingMap.put("validUntil", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("validSince");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_SINCE));
				if (o != null) {
					eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_SINCE), element));
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
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_UNTIL));
				if (o != null) {
					eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_UNTIL), element));
					out.print(" ");
				}
				printCountingMap.put("validUntil", count - 1);
			}
		}
	}
	
	
	public void print_eu_hyvar_context_HyContextualInformationEnum(eu.hyvar.context.HyContextualInformationEnum element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_SINCE));
		printCountingMap.put("validSince", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_UNTIL));
		printCountingMap.put("validUntil", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__ENUM_TYPE));
		printCountingMap.put("enumType", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("EnumContext(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__NAME));
			if (o != null) {
				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("enumType");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__ENUM_TYPE));
			if (o != null) {
				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextualInformationEnumEnumTypeReferenceResolver().deResolve((eu.hyvar.dataValues.HyEnum) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__ENUM_TYPE)), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__ENUM_TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("enumType", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_eu_hyvar_context_HyContextualInformationEnum_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_eu_hyvar_context_HyContextualInformationEnum_0(eu.hyvar.context.HyContextualInformationEnum element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_context_HyContextualInformationEnum_0_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	public void print_eu_hyvar_context_HyContextualInformationEnum_0_0(eu.hyvar.context.HyContextualInformationEnum element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_SINCE));
					if (o != null) {
						eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_SINCE), element));
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_UNTIL));
					if (o != null) {
						eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_UNTIL), element));
						out.print(" ");
					}
					printCountingMap.put("validUntil", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("validSince");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_SINCE));
				if (o != null) {
					eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_SINCE), element));
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
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_UNTIL));
				if (o != null) {
					eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_UNTIL), element));
					out.print(" ");
				}
				printCountingMap.put("validUntil", count - 1);
			}
		}
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
				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
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
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("enum:");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("enum");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM));
			if (o != null) {
				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver().deResolve((eu.hyvar.dataValues.HyEnum) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM)), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), element));
				out.print(" ");
			}
			printCountingMap.put("enum", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("enumLiteral");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL));
			if (o != null) {
				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver().deResolve((eu.hyvar.dataValues.HyEnumLiteral) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL)), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), element));
				out.print(" ");
			}
			printCountingMap.put("enumLiteral", count - 1);
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
				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
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
						eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
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
						eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
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
					eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
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
					eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
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
				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
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
				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
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
						eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
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
						eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
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
					eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
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
					eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), element));
					out.print(" ");
				}
				printCountingMap.put("validUntil", count - 1);
			}
		}
	}
	
	
}
