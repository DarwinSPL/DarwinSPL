/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.grammar;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class HymanifestGrammarInformationProvider {
	
	public final static EStructuralFeature ANONYMOUS_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static HymanifestGrammarInformationProvider INSTANCE = new HymanifestGrammarInformationProvider();
	
	private Set<String> keywords;
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_0_0_0_0 = INSTANCE.getHYMANIFEST_0_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_0_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("Signature ", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_0_0_0 = INSTANCE.getHYMANIFEST_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_0_0_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_0_0 = INSTANCE.getHYMANIFEST_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_0_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule HYMANIFEST_0 = INSTANCE.getHYMANIFEST_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule getHYMANIFEST_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLSignature(), HYMANIFEST_0_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_1_0_0_0 = INSTANCE.getHYMANIFEST_1_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_1_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("Implementation ", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_1_0_0_1_0_0_0 = INSTANCE.getHYMANIFEST_1_0_0_1_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_1_0_0_1_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("(", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment HYMANIFEST_1_0_0_1_0_0_1 = INSTANCE.getHYMANIFEST_1_0_0_1_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment getHYMANIFEST_1_0_0_1_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__DEPENDENCIES), eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, new EClass[] {eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedDependencies(), }, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_1_0_0_1_0_0_2_0_0_0 = INSTANCE.getHYMANIFEST_1_0_0_1_0_0_2_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_1_0_0_1_0_0_2_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword(",", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment HYMANIFEST_1_0_0_1_0_0_2_0_0_1 = INSTANCE.getHYMANIFEST_1_0_0_1_0_0_2_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment getHYMANIFEST_1_0_0_1_0_0_2_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__DEPENDENCIES), eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, new EClass[] {eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedDependencies(), }, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_1_0_0_1_0_0_2_0_0 = INSTANCE.getHYMANIFEST_1_0_0_1_0_0_2_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_1_0_0_1_0_0_2_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_1_0_0_1_0_0_2_0_0_0, HYMANIFEST_1_0_0_1_0_0_2_0_0_1);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_1_0_0_1_0_0_2_0 = INSTANCE.getHYMANIFEST_1_0_0_1_0_0_2_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_1_0_0_1_0_0_2_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_1_0_0_1_0_0_2_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYMANIFEST_1_0_0_1_0_0_2 = INSTANCE.getHYMANIFEST_1_0_0_1_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYMANIFEST_1_0_0_1_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYMANIFEST_1_0_0_1_0_0_2_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.STAR);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_1_0_0_1_0_0_3 = INSTANCE.getHYMANIFEST_1_0_0_1_0_0_3();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_1_0_0_1_0_0_3() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword(")", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_1_0_0_1_0_0 = INSTANCE.getHYMANIFEST_1_0_0_1_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_1_0_0_1_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_1_0_0_1_0_0_0, HYMANIFEST_1_0_0_1_0_0_1, HYMANIFEST_1_0_0_1_0_0_2, HYMANIFEST_1_0_0_1_0_0_3);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_1_0_0_1_0 = INSTANCE.getHYMANIFEST_1_0_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_1_0_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_1_0_0_1_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYMANIFEST_1_0_0_1 = INSTANCE.getHYMANIFEST_1_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYMANIFEST_1_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYMANIFEST_1_0_0_1_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_1_0_0_2_0_0_0 = INSTANCE.getHYMANIFEST_1_0_0_2_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_1_0_0_2_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword(":", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment HYMANIFEST_1_0_0_2_0_0_1 = INSTANCE.getHYMANIFEST_1_0_0_2_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment getHYMANIFEST_1_0_0_2_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__IMPLEMENTATIONS), eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, new EClass[] {eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(), }, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_1_0_0_2_0_0_2_0_0_0 = INSTANCE.getHYMANIFEST_1_0_0_2_0_0_2_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_1_0_0_2_0_0_2_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword(",", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment HYMANIFEST_1_0_0_2_0_0_2_0_0_1 = INSTANCE.getHYMANIFEST_1_0_0_2_0_0_2_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment getHYMANIFEST_1_0_0_2_0_0_2_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__IMPLEMENTATIONS), eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, new EClass[] {eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(), }, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_1_0_0_2_0_0_2_0_0 = INSTANCE.getHYMANIFEST_1_0_0_2_0_0_2_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_1_0_0_2_0_0_2_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_1_0_0_2_0_0_2_0_0_0, HYMANIFEST_1_0_0_2_0_0_2_0_0_1);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_1_0_0_2_0_0_2_0 = INSTANCE.getHYMANIFEST_1_0_0_2_0_0_2_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_1_0_0_2_0_0_2_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_1_0_0_2_0_0_2_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYMANIFEST_1_0_0_2_0_0_2 = INSTANCE.getHYMANIFEST_1_0_0_2_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYMANIFEST_1_0_0_2_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYMANIFEST_1_0_0_2_0_0_2_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.STAR);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_1_0_0_2_0_0 = INSTANCE.getHYMANIFEST_1_0_0_2_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_1_0_0_2_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_1_0_0_2_0_0_0, HYMANIFEST_1_0_0_2_0_0_1, HYMANIFEST_1_0_0_2_0_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_1_0_0_2_0 = INSTANCE.getHYMANIFEST_1_0_0_2_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_1_0_0_2_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_1_0_0_2_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYMANIFEST_1_0_0_2 = INSTANCE.getHYMANIFEST_1_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYMANIFEST_1_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYMANIFEST_1_0_0_2_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_1_0_0 = INSTANCE.getHYMANIFEST_1_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_1_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_1_0_0_0, HYMANIFEST_1_0_0_1, HYMANIFEST_1_0_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_1_0 = INSTANCE.getHYMANIFEST_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_1_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule HYMANIFEST_1 = INSTANCE.getHYMANIFEST_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule getHYMANIFEST_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), HYMANIFEST_1_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_2_0_0_0_0_0_0 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_2_0_0_0_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("[", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_2_0_0_0_0_0_1_0_0_0 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_1_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_2_0_0_0_0_0_1_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedDependencies().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_SINCE), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_2_0_0_0_0_0_1_0_0_1 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_1_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_2_0_0_0_0_0_1_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("-", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_2_0_0_0_0_0_1_0_0_2 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_1_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_2_0_0_0_0_0_1_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedDependencies().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_UNTIL), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_2_0_0_0_0_0_1_0_0 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_1_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_2_0_0_0_0_0_1_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_2_0_0_0_0_0_1_0_0_0, HYMANIFEST_2_0_0_0_0_0_1_0_0_1, HYMANIFEST_2_0_0_0_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_2_0_0_0_0_0_1_0_1_0 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_1_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_2_0_0_0_0_0_1_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedDependencies().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_SINCE), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_2_0_0_0_0_0_1_0_1_1 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_1_0_1_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_2_0_0_0_0_0_1_0_1_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("-", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_2_0_0_0_0_0_1_0_1_2 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_1_0_1_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_2_0_0_0_0_0_1_0_1_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("eternity", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_2_0_0_0_0_0_1_0_1 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_1_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_2_0_0_0_0_0_1_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_2_0_0_0_0_0_1_0_1_0, HYMANIFEST_2_0_0_0_0_0_1_0_1_1, HYMANIFEST_2_0_0_0_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_2_0_0_0_0_0_1_0_2_0 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_1_0_2_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_2_0_0_0_0_0_1_0_2_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("eternity", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_2_0_0_0_0_0_1_0_2_1 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_1_0_2_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_2_0_0_0_0_0_1_0_2_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("-", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_2_0_0_0_0_0_1_0_2_2 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_1_0_2_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_2_0_0_0_0_0_1_0_2_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedDependencies().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_UNTIL), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_2_0_0_0_0_0_1_0_2 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_1_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_2_0_0_0_0_0_1_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_2_0_0_0_0_0_1_0_2_0, HYMANIFEST_2_0_0_0_0_0_1_0_2_1, HYMANIFEST_2_0_0_0_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_2_0_0_0_0_0_1_0 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_2_0_0_0_0_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_2_0_0_0_0_0_1_0_0, HYMANIFEST_2_0_0_0_0_0_1_0_1, HYMANIFEST_2_0_0_0_0_0_1_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYMANIFEST_2_0_0_0_0_0_1 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYMANIFEST_2_0_0_0_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYMANIFEST_2_0_0_0_0_0_1_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_2_0_0_0_0_0_2 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_2_0_0_0_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("]", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_2_0_0_0_0_0 = INSTANCE.getHYMANIFEST_2_0_0_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_2_0_0_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_2_0_0_0_0_0_0, HYMANIFEST_2_0_0_0_0_0_1, HYMANIFEST_2_0_0_0_0_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_2_0_0_0_0 = INSTANCE.getHYMANIFEST_2_0_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_2_0_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_2_0_0_0_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYMANIFEST_2_0_0_0 = INSTANCE.getHYMANIFEST_2_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYMANIFEST_2_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYMANIFEST_2_0_0_0_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_2_0_0_1_0_0_0 = INSTANCE.getHYMANIFEST_2_0_0_1_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_2_0_0_1_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedDependencies().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__ALIAS), "QUOTED_34_34", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_2_0_0_1_0_0 = INSTANCE.getHYMANIFEST_2_0_0_1_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_2_0_0_1_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_2_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_2_0_0_1_0_1_0 = INSTANCE.getHYMANIFEST_2_0_0_1_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_2_0_0_1_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedDependencies().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__ALIAS), "IDENTIFIER_TOKEN", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_2_0_0_1_0_1 = INSTANCE.getHYMANIFEST_2_0_0_1_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_2_0_0_1_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_2_0_0_1_0_1_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_2_0_0_1_0 = INSTANCE.getHYMANIFEST_2_0_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_2_0_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_2_0_0_1_0_0, HYMANIFEST_2_0_0_1_0_1);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYMANIFEST_2_0_0_1 = INSTANCE.getHYMANIFEST_2_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYMANIFEST_2_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYMANIFEST_2_0_0_1_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_2_0_0_2 = INSTANCE.getHYMANIFEST_2_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_2_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword(":", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_2_0_0_3 = INSTANCE.getHYMANIFEST_2_0_0_3();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_2_0_0_3() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedDependencies().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__SIGNATURE), "QUOTED_60_62", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_2_0_0 = INSTANCE.getHYMANIFEST_2_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_2_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_2_0_0_0, HYMANIFEST_2_0_0_1, HYMANIFEST_2_0_0_2, HYMANIFEST_2_0_0_3);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_2_0 = INSTANCE.getHYMANIFEST_2_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_2_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_2_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule HYMANIFEST_2 = INSTANCE.getHYMANIFEST_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule getHYMANIFEST_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedDependencies(), HYMANIFEST_2_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_3_0_0_0_0_0_0 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_3_0_0_0_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("[", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_3_0_0_0_0_0_1_0_0_0 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_1_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_3_0_0_0_0_0_1_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_SINCE), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_3_0_0_0_0_0_1_0_0_1 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_1_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_3_0_0_0_0_0_1_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("-", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_3_0_0_0_0_0_1_0_0_2 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_1_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_3_0_0_0_0_0_1_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_UNTIL), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_3_0_0_0_0_0_1_0_0 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_1_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_3_0_0_0_0_0_1_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_3_0_0_0_0_0_1_0_0_0, HYMANIFEST_3_0_0_0_0_0_1_0_0_1, HYMANIFEST_3_0_0_0_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_3_0_0_0_0_0_1_0_1_0 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_1_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_3_0_0_0_0_0_1_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_SINCE), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_3_0_0_0_0_0_1_0_1_1 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_1_0_1_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_3_0_0_0_0_0_1_0_1_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("-", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_3_0_0_0_0_0_1_0_1_2 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_1_0_1_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_3_0_0_0_0_0_1_0_1_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("eternity", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_3_0_0_0_0_0_1_0_1 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_1_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_3_0_0_0_0_0_1_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_3_0_0_0_0_0_1_0_1_0, HYMANIFEST_3_0_0_0_0_0_1_0_1_1, HYMANIFEST_3_0_0_0_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_3_0_0_0_0_0_1_0_2_0 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_1_0_2_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_3_0_0_0_0_0_1_0_2_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("eternity", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_3_0_0_0_0_0_1_0_2_1 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_1_0_2_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_3_0_0_0_0_0_1_0_2_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("-", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_3_0_0_0_0_0_1_0_2_2 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_1_0_2_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_3_0_0_0_0_0_1_0_2_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_UNTIL), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_3_0_0_0_0_0_1_0_2 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_1_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_3_0_0_0_0_0_1_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_3_0_0_0_0_0_1_0_2_0, HYMANIFEST_3_0_0_0_0_0_1_0_2_1, HYMANIFEST_3_0_0_0_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_3_0_0_0_0_0_1_0 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_3_0_0_0_0_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_3_0_0_0_0_0_1_0_0, HYMANIFEST_3_0_0_0_0_0_1_0_1, HYMANIFEST_3_0_0_0_0_0_1_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYMANIFEST_3_0_0_0_0_0_1 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYMANIFEST_3_0_0_0_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYMANIFEST_3_0_0_0_0_0_1_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_3_0_0_0_0_0_2 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_3_0_0_0_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("]", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_3_0_0_0_0_0 = INSTANCE.getHYMANIFEST_3_0_0_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_3_0_0_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_3_0_0_0_0_0_0, HYMANIFEST_3_0_0_0_0_0_1, HYMANIFEST_3_0_0_0_0_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_3_0_0_0_0 = INSTANCE.getHYMANIFEST_3_0_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_3_0_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_3_0_0_0_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYMANIFEST_3_0_0_0 = INSTANCE.getHYMANIFEST_3_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYMANIFEST_3_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYMANIFEST_3_0_0_0_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_3_0_0_1 = INSTANCE.getHYMANIFEST_3_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_3_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__SIGNATURE), "QUOTED_60_62", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_3_0_0_2 = INSTANCE.getHYMANIFEST_3_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_3_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("{", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment HYMANIFEST_3_0_0_3_0_0_0 = INSTANCE.getHYMANIFEST_3_0_0_3_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment getHYMANIFEST_3_0_0_3_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__ASSOCIATIONS), eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, new EClass[] {eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationLink(), }, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_3_0_0_3_0_0_1_0_0_0 = INSTANCE.getHYMANIFEST_3_0_0_3_0_0_1_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_3_0_0_3_0_0_1_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword(",", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment HYMANIFEST_3_0_0_3_0_0_1_0_0_1 = INSTANCE.getHYMANIFEST_3_0_0_3_0_0_1_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment getHYMANIFEST_3_0_0_3_0_0_1_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__ASSOCIATIONS), eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, new EClass[] {eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationLink(), }, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_3_0_0_3_0_0_1_0_0 = INSTANCE.getHYMANIFEST_3_0_0_3_0_0_1_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_3_0_0_3_0_0_1_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_3_0_0_3_0_0_1_0_0_0, HYMANIFEST_3_0_0_3_0_0_1_0_0_1);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_3_0_0_3_0_0_1_0 = INSTANCE.getHYMANIFEST_3_0_0_3_0_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_3_0_0_3_0_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_3_0_0_3_0_0_1_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYMANIFEST_3_0_0_3_0_0_1 = INSTANCE.getHYMANIFEST_3_0_0_3_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYMANIFEST_3_0_0_3_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYMANIFEST_3_0_0_3_0_0_1_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.STAR);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_3_0_0_3_0_0 = INSTANCE.getHYMANIFEST_3_0_0_3_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_3_0_0_3_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_3_0_0_3_0_0_0, HYMANIFEST_3_0_0_3_0_0_1);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_3_0_0_3_0 = INSTANCE.getHYMANIFEST_3_0_0_3_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_3_0_0_3_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_3_0_0_3_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYMANIFEST_3_0_0_3 = INSTANCE.getHYMANIFEST_3_0_0_3();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYMANIFEST_3_0_0_3() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYMANIFEST_3_0_0_3_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_3_0_0_4 = INSTANCE.getHYMANIFEST_3_0_0_4();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_3_0_0_4() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("}", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_3_0_0 = INSTANCE.getHYMANIFEST_3_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_3_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_3_0_0_0, HYMANIFEST_3_0_0_1, HYMANIFEST_3_0_0_2, HYMANIFEST_3_0_0_3, HYMANIFEST_3_0_0_4);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_3_0 = INSTANCE.getHYMANIFEST_3_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_3_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_3_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule HYMANIFEST_3 = INSTANCE.getHYMANIFEST_3();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule getHYMANIFEST_3() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(), HYMANIFEST_3_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_4_0_0_0_0_0_0 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_4_0_0_0_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("[", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_4_0_0_0_0_0_1_0_0_0 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_1_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_4_0_0_0_0_0_1_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationLink().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_SINCE), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_4_0_0_0_0_0_1_0_0_1 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_1_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_4_0_0_0_0_0_1_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("-", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_4_0_0_0_0_0_1_0_0_2 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_1_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_4_0_0_0_0_0_1_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationLink().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_UNTIL), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_4_0_0_0_0_0_1_0_0 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_1_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_4_0_0_0_0_0_1_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_4_0_0_0_0_0_1_0_0_0, HYMANIFEST_4_0_0_0_0_0_1_0_0_1, HYMANIFEST_4_0_0_0_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_4_0_0_0_0_0_1_0_1_0 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_1_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_4_0_0_0_0_0_1_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationLink().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_SINCE), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_4_0_0_0_0_0_1_0_1_1 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_1_0_1_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_4_0_0_0_0_0_1_0_1_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("-", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_4_0_0_0_0_0_1_0_1_2 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_1_0_1_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_4_0_0_0_0_0_1_0_1_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("eternity", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_4_0_0_0_0_0_1_0_1 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_1_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_4_0_0_0_0_0_1_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_4_0_0_0_0_0_1_0_1_0, HYMANIFEST_4_0_0_0_0_0_1_0_1_1, HYMANIFEST_4_0_0_0_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_4_0_0_0_0_0_1_0_2_0 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_1_0_2_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_4_0_0_0_0_0_1_0_2_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("eternity", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_4_0_0_0_0_0_1_0_2_1 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_1_0_2_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_4_0_0_0_0_0_1_0_2_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("-", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_4_0_0_0_0_0_1_0_2_2 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_1_0_2_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_4_0_0_0_0_0_1_0_2_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationLink().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_UNTIL), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_4_0_0_0_0_0_1_0_2 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_1_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_4_0_0_0_0_0_1_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_4_0_0_0_0_0_1_0_2_0, HYMANIFEST_4_0_0_0_0_0_1_0_2_1, HYMANIFEST_4_0_0_0_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_4_0_0_0_0_0_1_0 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_4_0_0_0_0_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_4_0_0_0_0_0_1_0_0, HYMANIFEST_4_0_0_0_0_0_1_0_1, HYMANIFEST_4_0_0_0_0_0_1_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYMANIFEST_4_0_0_0_0_0_1 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYMANIFEST_4_0_0_0_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYMANIFEST_4_0_0_0_0_0_1_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_4_0_0_0_0_0_2 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_4_0_0_0_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("]", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_4_0_0_0_0_0 = INSTANCE.getHYMANIFEST_4_0_0_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_4_0_0_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_4_0_0_0_0_0_0, HYMANIFEST_4_0_0_0_0_0_1, HYMANIFEST_4_0_0_0_0_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_4_0_0_0_0 = INSTANCE.getHYMANIFEST_4_0_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_4_0_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_4_0_0_0_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYMANIFEST_4_0_0_0 = INSTANCE.getHYMANIFEST_4_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYMANIFEST_4_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYMANIFEST_4_0_0_0_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_4_0_0_1_0_0_0 = INSTANCE.getHYMANIFEST_4_0_0_1_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_4_0_0_1_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationLink().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), "QUOTED_34_34", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_4_0_0_1_0_0 = INSTANCE.getHYMANIFEST_4_0_0_1_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_4_0_0_1_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_4_0_0_1_0_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_4_0_0_1_0_1_0 = INSTANCE.getHYMANIFEST_4_0_0_1_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_4_0_0_1_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationLink().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), "IDENTIFIER_TOKEN", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_4_0_0_1_0_1 = INSTANCE.getHYMANIFEST_4_0_0_1_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_4_0_0_1_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_4_0_0_1_0_1_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_4_0_0_1_0 = INSTANCE.getHYMANIFEST_4_0_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_4_0_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_4_0_0_1_0_0, HYMANIFEST_4_0_0_1_0_1);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYMANIFEST_4_0_0_1 = INSTANCE.getHYMANIFEST_4_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYMANIFEST_4_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYMANIFEST_4_0_0_1_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYMANIFEST_4_0_0_2 = INSTANCE.getHYMANIFEST_4_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYMANIFEST_4_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("->", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_4_0_0_3_0_0_0 = INSTANCE.getHYMANIFEST_4_0_0_3_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_4_0_0_3_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationLink().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), "QUOTED_34_34", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_4_0_0_3_0_0 = INSTANCE.getHYMANIFEST_4_0_0_3_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_4_0_0_3_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_4_0_0_3_0_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYMANIFEST_4_0_0_3_0_1_0 = INSTANCE.getHYMANIFEST_4_0_0_3_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYMANIFEST_4_0_0_3_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationLink().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), "IDENTIFIER_TOKEN", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_4_0_0_3_0_1 = INSTANCE.getHYMANIFEST_4_0_0_3_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_4_0_0_3_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_4_0_0_3_0_1_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_4_0_0_3_0 = INSTANCE.getHYMANIFEST_4_0_0_3_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_4_0_0_3_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_4_0_0_3_0_0, HYMANIFEST_4_0_0_3_0_1);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYMANIFEST_4_0_0_3 = INSTANCE.getHYMANIFEST_4_0_0_3();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYMANIFEST_4_0_0_3() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYMANIFEST_4_0_0_3_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYMANIFEST_4_0_0 = INSTANCE.getHYMANIFEST_4_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYMANIFEST_4_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_4_0_0_0, HYMANIFEST_4_0_0_1, HYMANIFEST_4_0_0_2, HYMANIFEST_4_0_0_3);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYMANIFEST_4_0 = INSTANCE.getHYMANIFEST_4_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYMANIFEST_4_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYMANIFEST_4_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule HYMANIFEST_4 = INSTANCE.getHYMANIFEST_4();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule getHYMANIFEST_4() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementationLink(), HYMANIFEST_4_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYDATAVALUE_0_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYDATAVALUE_0_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_NUMBER_VALUE__VALUE), "INTEGER_LITERAL", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYDATAVALUE_0_0_0 = INSTANCE.getHYDATAVALUE_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYDATAVALUE_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_0_0_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYDATAVALUE_0_0 = INSTANCE.getHYDATAVALUE_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYDATAVALUE_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_0_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule HYDATAVALUE_0 = INSTANCE.getHYDATAVALUE_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule getHYDATAVALUE_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyNumberValue(), HYDATAVALUE_0_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestBooleanTerminal HYDATAVALUE_1_0_0_0 = INSTANCE.getHYDATAVALUE_1_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestBooleanTerminal getHYDATAVALUE_1_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestBooleanTerminal(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), "true", "false", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYDATAVALUE_1_0_0 = INSTANCE.getHYDATAVALUE_1_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYDATAVALUE_1_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_1_0_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYDATAVALUE_1_0 = INSTANCE.getHYDATAVALUE_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYDATAVALUE_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_1_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule HYDATAVALUE_1 = INSTANCE.getHYDATAVALUE_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule getHYDATAVALUE_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyBooleanValue(), HYDATAVALUE_1_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_2_0_0_0 = INSTANCE.getHYDATAVALUE_2_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_2_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("enum:", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYDATAVALUE_2_0_0_1 = INSTANCE.getHYDATAVALUE_2_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYDATAVALUE_2_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), "IDENTIFIER_TOKEN", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_2_0_0_2 = INSTANCE.getHYDATAVALUE_2_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_2_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword(".", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYDATAVALUE_2_0_0_3 = INSTANCE.getHYDATAVALUE_2_0_0_3();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYDATAVALUE_2_0_0_3() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), "IDENTIFIER_TOKEN", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYDATAVALUE_2_0_0 = INSTANCE.getHYDATAVALUE_2_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYDATAVALUE_2_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_2_0_0_0, HYDATAVALUE_2_0_0_1, HYDATAVALUE_2_0_0_2, HYDATAVALUE_2_0_0_3);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYDATAVALUE_2_0 = INSTANCE.getHYDATAVALUE_2_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYDATAVALUE_2_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_2_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule HYDATAVALUE_2 = INSTANCE.getHYDATAVALUE_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule getHYDATAVALUE_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumValue(), HYDATAVALUE_2_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_3_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("Enum(", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYDATAVALUE_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYDATAVALUE_3_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__NAME), "IDENTIFIER_TOKEN", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_3_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_3_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword(",", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment HYDATAVALUE_3_0_0_3_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment getHYDATAVALUE_3_0_0_3_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_3_0_0_3_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_3_0_0_3_0_0_1_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword(",", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment HYDATAVALUE_3_0_0_3_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment getHYDATAVALUE_3_0_0_3_0_0_1_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainment(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS), eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, new EClass[] {eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), }, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYDATAVALUE_3_0_0_3_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYDATAVALUE_3_0_0_3_0_0_1_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1_0_0_1);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYDATAVALUE_3_0_0_3_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYDATAVALUE_3_0_0_3_0_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_1_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYDATAVALUE_3_0_0_3_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYDATAVALUE_3_0_0_3_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYDATAVALUE_3_0_0_3_0_0_1_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.STAR);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYDATAVALUE_3_0_0_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYDATAVALUE_3_0_0_3_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0_0, HYDATAVALUE_3_0_0_3_0_0_1);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYDATAVALUE_3_0_0_3_0 = INSTANCE.getHYDATAVALUE_3_0_0_3_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYDATAVALUE_3_0_0_3_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_3_0_0_3_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYDATAVALUE_3_0_0_3 = INSTANCE.getHYDATAVALUE_3_0_0_3();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYDATAVALUE_3_0_0_3() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYDATAVALUE_3_0_0_3_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_3_0_0_4 = INSTANCE.getHYDATAVALUE_3_0_0_4();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_3_0_0_4() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword(")", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_3_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_3_0_0_5_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("[", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("-", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYDATAVALUE_3_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("-", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYDATAVALUE_3_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1_1);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("eternity", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_3_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_3_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("-", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYDATAVALUE_3_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYDATAVALUE_3_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYDATAVALUE_3_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYDATAVALUE_3_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYDATAVALUE_3_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYDATAVALUE_3_0_0_5_0_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_1_0_0, HYDATAVALUE_3_0_0_5_0_0_1_0_1, HYDATAVALUE_3_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYDATAVALUE_3_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYDATAVALUE_3_0_0_5_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYDATAVALUE_3_0_0_5_0_0_1_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_3_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_3_0_0_5_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("]", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYDATAVALUE_3_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYDATAVALUE_3_0_0_5_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0_0, HYDATAVALUE_3_0_0_5_0_0_1, HYDATAVALUE_3_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYDATAVALUE_3_0_0_5_0 = INSTANCE.getHYDATAVALUE_3_0_0_5_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYDATAVALUE_3_0_0_5_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_3_0_0_5_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYDATAVALUE_3_0_0_5 = INSTANCE.getHYDATAVALUE_3_0_0_5();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYDATAVALUE_3_0_0_5() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYDATAVALUE_3_0_0_5_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYDATAVALUE_3_0_0 = INSTANCE.getHYDATAVALUE_3_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYDATAVALUE_3_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_3_0_0_0, HYDATAVALUE_3_0_0_1, HYDATAVALUE_3_0_0_2, HYDATAVALUE_3_0_0_3, HYDATAVALUE_3_0_0_4, HYDATAVALUE_3_0_0_5);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYDATAVALUE_3_0 = INSTANCE.getHYDATAVALUE_3_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYDATAVALUE_3_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_3_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule HYDATAVALUE_3 = INSTANCE.getHYDATAVALUE_3();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule getHYDATAVALUE_3() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), HYDATAVALUE_3_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_4_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_4_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("EnumLiteral(", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYDATAVALUE_4_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYDATAVALUE_4_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__NAME), "IDENTIFIER_TOKEN", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_4_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_4_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword(",", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYDATAVALUE_4_0_0_3 = INSTANCE.getHYDATAVALUE_4_0_0_3();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYDATAVALUE_4_0_0_3() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALUE), "INTEGER_LITERAL", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_4_0_0_4 = INSTANCE.getHYDATAVALUE_4_0_0_4();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_4_0_0_4() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword(")", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_4_0_0_5_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_4_0_0_5_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("[", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("-", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYDATAVALUE_4_0_0_5_0_0_1_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("-", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_1_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_1_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("eternity", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYDATAVALUE_4_0_0_5_0_0_1_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, HYDATAVALUE_4_0_0_5_0_0_1_0_1_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("eternity", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_4_0_0_5_0_0_1_0_2_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_4_0_0_5_0_0_1_0_2_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("-", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder HYDATAVALUE_4_0_0_5_0_0_1_0_2_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder getHYDATAVALUE_4_0_0_5_0_0_1_0_2_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestPlaceholder(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), "DATE", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, 0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYDATAVALUE_4_0_0_5_0_0_1_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYDATAVALUE_4_0_0_5_0_0_1_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYDATAVALUE_4_0_0_5_0_0_1_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYDATAVALUE_4_0_0_5_0_0_1_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_1_0_0, HYDATAVALUE_4_0_0_5_0_0_1_0_1, HYDATAVALUE_4_0_0_5_0_0_1_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYDATAVALUE_4_0_0_5_0_0_1 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_1();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYDATAVALUE_4_0_0_5_0_0_1() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYDATAVALUE_4_0_0_5_0_0_1_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword HYDATAVALUE_4_0_0_5_0_0_2 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0_2();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword getHYDATAVALUE_4_0_0_5_0_0_2() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword("]", eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYDATAVALUE_4_0_0_5_0_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYDATAVALUE_4_0_0_5_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0_0, HYDATAVALUE_4_0_0_5_0_0_1, HYDATAVALUE_4_0_0_5_0_0_2);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYDATAVALUE_4_0_0_5_0 = INSTANCE.getHYDATAVALUE_4_0_0_5_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYDATAVALUE_4_0_0_5_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_4_0_0_5_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound HYDATAVALUE_4_0_0_5 = INSTANCE.getHYDATAVALUE_4_0_0_5();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound getHYDATAVALUE_4_0_0_5() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCompound(HYDATAVALUE_4_0_0_5_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.QUESTIONMARK);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence HYDATAVALUE_4_0_0 = INSTANCE.getHYDATAVALUE_4_0_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence getHYDATAVALUE_4_0_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSequence(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_4_0_0_0, HYDATAVALUE_4_0_0_1, HYDATAVALUE_4_0_0_2, HYDATAVALUE_4_0_0_3, HYDATAVALUE_4_0_0_4, HYDATAVALUE_4_0_0_5);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice HYDATAVALUE_4_0 = INSTANCE.getHYDATAVALUE_4_0();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice getHYDATAVALUE_4_0() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestChoice(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE, HYDATAVALUE_4_0_0);
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule HYDATAVALUE_4 = INSTANCE.getHYDATAVALUE_4();
	private eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule getHYDATAVALUE_4() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnumLiteral(), HYDATAVALUE_4_0, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestCardinality.ONE);
	}
	
	
	public static String getSyntaxElementID(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (Field field : eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.class.getFields()) {
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
	
	public static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement) eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule[] RULES = new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule[] {
		HYMANIFEST_0,
		HYMANIFEST_1,
		HYMANIFEST_2,
		HYMANIFEST_3,
		HYMANIFEST_4,
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
			for (eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement element, Set<String> keywords) {
		if (element instanceof eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword) {
			keywords.add(((eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestKeyword) element).getValue());
		} else if (element instanceof eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestBooleanTerminal) {
			keywords.add(((eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestBooleanTerminal) element).getTrueLiteral());
			keywords.add(((eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestEnumerationTerminal) {
			eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestEnumerationTerminal terminal = (eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
