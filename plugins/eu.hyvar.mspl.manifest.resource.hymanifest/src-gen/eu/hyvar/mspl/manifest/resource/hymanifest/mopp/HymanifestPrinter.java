/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class HymanifestPrinter implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextPrinter {
	
	protected eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolverFactory tokenResolverFactory = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenResolverFactory();
	
	protected OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource resource;
	
	private Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public HymanifestPrinter(OutputStream outputStream, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource resource) {
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
		
		if (element instanceof eu.hyvar.mspl.manifest.HySPLImplementation) {
			print_eu_hyvar_mspl_manifest_HySPLImplementation((eu.hyvar.mspl.manifest.HySPLImplementation) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.mspl.manifest.HyTimedDependencies) {
			print_eu_hyvar_mspl_manifest_HyTimedDependencies((eu.hyvar.mspl.manifest.HyTimedDependencies) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.mspl.manifest.HyTimedImplementations) {
			print_eu_hyvar_mspl_manifest_HyTimedImplementations((eu.hyvar.mspl.manifest.HyTimedImplementations) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.mspl.manifest.HyTimedImplementationLink) {
			print_eu_hyvar_mspl_manifest_HyTimedImplementationLink((eu.hyvar.mspl.manifest.HyTimedImplementationLink) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.mspl.manifest.HySPLSignature) {
			print_eu_hyvar_mspl_manifest_HySPLSignature((eu.hyvar.mspl.manifest.HySPLSignature) element, globaltab, out);
			return;
		}
		if (element instanceof eu.hyvar.evolution.HyName) {
			print_eu_hyvar_evolution_HyName((eu.hyvar.evolution.HyName) element, globaltab, out);
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
	
	protected eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestReferenceResolverSwitch getReferenceResolverSwitch() {
		return (eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestReferenceResolverSwitch) new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, EObject cause) {
		eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestProblem(errorMessage, eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemType.PRINT_PROBLEM, eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemSeverity.WARNING), cause);
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
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource getResource() {
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
	
	public void print_eu_hyvar_mspl_manifest_HySPLImplementation(eu.hyvar.mspl.manifest.HySPLImplementation element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__NAMES));
		printCountingMap.put("names", temp == null ? 0 : ((Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__DEPENDENCIES));
		printCountingMap.put("dependencies", temp == null ? 0 : ((Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__IMPLEMENTATIONS));
		printCountingMap.put("implementations", temp == null ? 0 : ((Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Implementation ");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("names");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__NAMES));
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
			printCountingMap.put("names", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
			print_eu_hyvar_mspl_manifest_HySPLImplementation_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_eu_hyvar_mspl_manifest_HySPLImplementation_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_eu_hyvar_mspl_manifest_HySPLImplementation_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_eu_hyvar_mspl_manifest_HySPLImplementation_0(eu.hyvar.mspl.manifest.HySPLImplementation element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("names");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__NAMES));
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
			printCountingMap.put("names", count - 1);
		}
	}
	
	public void print_eu_hyvar_mspl_manifest_HySPLImplementation_1(eu.hyvar.mspl.manifest.HySPLImplementation element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("dependencies");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__DEPENDENCIES));
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
			printCountingMap.put("dependencies", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
			print_eu_hyvar_mspl_manifest_HySPLImplementation_1_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	public void print_eu_hyvar_mspl_manifest_HySPLImplementation_1_0(eu.hyvar.mspl.manifest.HySPLImplementation element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("dependencies");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__DEPENDENCIES));
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
			printCountingMap.put("dependencies", count - 1);
		}
	}
	
	public void print_eu_hyvar_mspl_manifest_HySPLImplementation_2(eu.hyvar.mspl.manifest.HySPLImplementation element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("implementations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__IMPLEMENTATIONS));
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
			printCountingMap.put("implementations", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
			print_eu_hyvar_mspl_manifest_HySPLImplementation_2_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_eu_hyvar_mspl_manifest_HySPLImplementation_2_0(eu.hyvar.mspl.manifest.HySPLImplementation element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("implementations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__IMPLEMENTATIONS));
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
			printCountingMap.put("implementations", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_mspl_manifest_HyTimedDependencies(eu.hyvar.mspl.manifest.HyTimedDependencies element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_SINCE));
		printCountingMap.put("validSince", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_UNTIL));
		printCountingMap.put("validUntil", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__SIGNATURE));
		printCountingMap.put("signature", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("signature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__SIGNATURE));
			if (o != null) {
				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedDependenciesSignatureReferenceResolver().deResolve((eu.hyvar.mspl.manifest.HySPLSignature) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__SIGNATURE)), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__SIGNATURE), element));
				out.print(" ");
			}
			printCountingMap.put("signature", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_eu_hyvar_mspl_manifest_HyTimedDependencies_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_eu_hyvar_mspl_manifest_HyTimedDependencies_0(eu.hyvar.mspl.manifest.HyTimedDependencies element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		// DEFINITION PART BEGINS (CsString)
		out.print("@[");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_mspl_manifest_HyTimedDependencies_0_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	public void print_eu_hyvar_mspl_manifest_HyTimedDependencies_0_0(eu.hyvar.mspl.manifest.HyTimedDependencies element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_SINCE));
					if (o != null) {
						eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_SINCE), element));
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_UNTIL));
					if (o != null) {
						eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_UNTIL), element));
						out.print(" ");
					}
					printCountingMap.put("validUntil", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("validSince");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_SINCE));
				if (o != null) {
					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_SINCE), element));
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
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_UNTIL));
				if (o != null) {
					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_UNTIL), element));
					out.print(" ");
				}
				printCountingMap.put("validUntil", count - 1);
			}
		}
	}
	
	
	public void print_eu_hyvar_mspl_manifest_HyTimedImplementations(eu.hyvar.mspl.manifest.HyTimedImplementations element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_SINCE));
		printCountingMap.put("validSince", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_UNTIL));
		printCountingMap.put("validUntil", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__SIGNATURE));
		printCountingMap.put("signature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__ASSOCIATIONS));
		printCountingMap.put("associations", temp == null ? 0 : ((Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("signature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__SIGNATURE));
			if (o != null) {
				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedImplementationsSignatureReferenceResolver().deResolve((eu.hyvar.mspl.manifest.HySPLSignature) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__SIGNATURE)), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__SIGNATURE), element));
				out.print(" ");
			}
			printCountingMap.put("signature", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_eu_hyvar_mspl_manifest_HyTimedImplementations_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_eu_hyvar_mspl_manifest_HyTimedImplementations_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_eu_hyvar_mspl_manifest_HyTimedImplementations_0(eu.hyvar.mspl.manifest.HyTimedImplementations element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		// DEFINITION PART BEGINS (CsString)
		out.print("@[");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_mspl_manifest_HyTimedImplementations_0_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	public void print_eu_hyvar_mspl_manifest_HyTimedImplementations_0_0(eu.hyvar.mspl.manifest.HyTimedImplementations element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_SINCE));
					if (o != null) {
						eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_SINCE), element));
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_UNTIL));
					if (o != null) {
						eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_UNTIL), element));
						out.print(" ");
					}
					printCountingMap.put("validUntil", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("validSince");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_SINCE));
				if (o != null) {
					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_SINCE), element));
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
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_UNTIL));
				if (o != null) {
					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_UNTIL), element));
					out.print(" ");
				}
				printCountingMap.put("validUntil", count - 1);
			}
		}
	}
	
	public void print_eu_hyvar_mspl_manifest_HyTimedImplementations_1(eu.hyvar.mspl.manifest.HyTimedImplementations element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("associations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__ASSOCIATIONS));
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
			printCountingMap.put("associations", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
			print_eu_hyvar_mspl_manifest_HyTimedImplementations_1_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_eu_hyvar_mspl_manifest_HyTimedImplementations_1_0(eu.hyvar.mspl.manifest.HyTimedImplementations element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("associations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__ASSOCIATIONS));
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
			printCountingMap.put("associations", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_mspl_manifest_HyTimedImplementationLink(eu.hyvar.mspl.manifest.HyTimedImplementationLink element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_SINCE));
		printCountingMap.put("validSince", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_UNTIL));
		printCountingMap.put("validUntil", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL));
		printCountingMap.put("local", temp == null ? 0 : ((Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE));
		printCountingMap.put("signature", temp == null ? 0 : ((Collection<?>) temp).size());
		// print collected hidden tokens
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_mspl_manifest_HyTimedImplementationLink_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_mspl_manifest_HyTimedImplementationLink_1(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_eu_hyvar_mspl_manifest_HyTimedImplementationLink_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_eu_hyvar_mspl_manifest_HyTimedImplementationLink_0(eu.hyvar.mspl.manifest.HyTimedImplementationLink element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, Arrays.asList(		"local"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, Arrays.asList(		"local"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("local");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL));
					List<?> list = (List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedImplementationLinkLocalReferenceResolver().deResolve((eu.hyvar.feature.HyFeature) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL)), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), element));
						out.print(" ");
					}
					printCountingMap.put("local", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("local");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL));
				List<?> list = (List<?>) o;
				int index = list.size() - count;
				if (index >= 0) {
					o = list.get(index);
				} else {
					o = null;
				}
				if (o != null) {
					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedImplementationLinkLocalReferenceResolver().deResolve((eu.hyvar.feature.HyFeature) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL)), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), element));
					out.print(" ");
				}
				printCountingMap.put("local", count - 1);
			}
		}
	}
	
	public void print_eu_hyvar_mspl_manifest_HyTimedImplementationLink_1(eu.hyvar.mspl.manifest.HyTimedImplementationLink element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, Arrays.asList(		"signature"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, Arrays.asList(		"signature"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("signature");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE));
					List<?> list = (List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedImplementationLinkSignatureReferenceResolver().deResolve((eu.hyvar.feature.HyFeature) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE)), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), element));
						out.print(" ");
					}
					printCountingMap.put("signature", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("signature");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE));
				List<?> list = (List<?>) o;
				int index = list.size() - count;
				if (index >= 0) {
					o = list.get(index);
				} else {
					o = null;
				}
				if (o != null) {
					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedImplementationLinkSignatureReferenceResolver().deResolve((eu.hyvar.feature.HyFeature) o, element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE)), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), element));
					out.print(" ");
				}
				printCountingMap.put("signature", count - 1);
			}
		}
	}
	
	public void print_eu_hyvar_mspl_manifest_HyTimedImplementationLink_2(eu.hyvar.mspl.manifest.HyTimedImplementationLink element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		// DEFINITION PART BEGINS (CsString)
		out.print("@[");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_mspl_manifest_HyTimedImplementationLink_2_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	public void print_eu_hyvar_mspl_manifest_HyTimedImplementationLink_2_0(eu.hyvar.mspl.manifest.HyTimedImplementationLink element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_SINCE));
					if (o != null) {
						eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_SINCE), element));
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_UNTIL));
					if (o != null) {
						eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_UNTIL), element));
						out.print(" ");
					}
					printCountingMap.put("validUntil", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("validSince");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_SINCE));
				if (o != null) {
					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_SINCE), element));
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
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_UNTIL));
				if (o != null) {
					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_UNTIL), element));
					out.print(" ");
				}
				printCountingMap.put("validUntil", count - 1);
			}
		}
	}
	
	
	public void print_eu_hyvar_mspl_manifest_HySPLSignature(eu.hyvar.mspl.manifest.HySPLSignature element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_SIGNATURE__NAMES));
		printCountingMap.put("names", temp == null ? 0 : ((Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Signature ");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("names");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_SIGNATURE__NAMES));
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
			printCountingMap.put("names", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
			print_eu_hyvar_mspl_manifest_HySPLSignature_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_eu_hyvar_mspl_manifest_HySPLSignature_0(eu.hyvar.mspl.manifest.HySPLSignature element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("names");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_SIGNATURE__NAMES));
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
			printCountingMap.put("names", count - 1);
		}
	}
	
	
	public void print_eu_hyvar_evolution_HyName(eu.hyvar.evolution.HyName element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_SINCE));
		printCountingMap.put("validSince", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_UNTIL));
		printCountingMap.put("validUntil", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__SUPERSEDING_ELEMENT));
		printCountingMap.put("supersedingElement", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__SUPERSEDED_ELEMENT));
		printCountingMap.put("supersededElement", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__NAME));
			if (o != null) {
				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_eu_hyvar_evolution_HyName_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_eu_hyvar_evolution_HyName_0(eu.hyvar.evolution.HyName element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		// DEFINITION PART BEGINS (CsString)
		out.print("@[");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_eu_hyvar_evolution_HyName_0_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
		out.print(" ");
	}
	
	public void print_eu_hyvar_evolution_HyName_0_0(eu.hyvar.evolution.HyName element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_SINCE));
					if (o != null) {
						eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_SINCE), element));
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_UNTIL));
					if (o != null) {
						eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_UNTIL), element));
						out.print(" ");
					}
					printCountingMap.put("validUntil", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("validSince");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_SINCE));
				if (o != null) {
					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_SINCE), element));
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
				Object o = element.eGet(element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_UNTIL));
				if (o != null) {
					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_UNTIL), element));
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
				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
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
				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
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
				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
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
				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
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
						eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
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
						eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
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
					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
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
					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
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
				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
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
				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
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
						eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
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
						eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
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
					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
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
					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver = tokenResolverFactory.createTokenResolver("DATE");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), element));
					out.print(" ");
				}
				printCountingMap.put("validUntil", count - 1);
			}
		}
	}
	
	
}
