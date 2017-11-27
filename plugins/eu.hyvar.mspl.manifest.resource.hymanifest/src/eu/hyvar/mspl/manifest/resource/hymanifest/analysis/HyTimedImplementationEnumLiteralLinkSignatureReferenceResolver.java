/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.analysis;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.HyInterval;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.mspl.manifest.HyTimedImplementationEnumLink;

public class HyTimedImplementationEnumLiteralLinkSignatureReferenceResolver implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.mspl.manifest.HyTimedImplementationEnumLiteralLink, eu.hyvar.dataValues.HyEnumLiteral> {
	
	private eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestDefaultResolverDelegate<eu.hyvar.mspl.manifest.HyTimedImplementationEnumLiteralLink, eu.hyvar.dataValues.HyEnumLiteral> delegate = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestDefaultResolverDelegate<eu.hyvar.mspl.manifest.HyTimedImplementationEnumLiteralLink, eu.hyvar.dataValues.HyEnumLiteral>();
	
	public void resolve(String identifier, eu.hyvar.mspl.manifest.HyTimedImplementationEnumLiteralLink container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolveResult<eu.hyvar.dataValues.HyEnumLiteral> result) {
		//System.out.println("UNITO DEBUG EnumLiteralLinkSignature: identifier= "+identifier);

		if(identifier!=null){
			EObject eobject = container.eContainer();
			if(eobject instanceof HyTimedImplementationEnumLink) {
				HyTimedImplementationEnumLink hyEnumLink = (HyTimedImplementationEnumLink) eobject;
				HyEnum hyEnum = hyEnumLink.getSignature();
				
				Iterator<HyEnumLiteral> iterator = hyEnum.getLiterals().iterator();
				while(iterator.hasNext()) {
					HyEnumLiteral hyEnumLiteral = (HyEnumLiteral)iterator.next();
					
					if(identifier.equals(hyEnumLiteral.getName())) {

						EList<eu.hyvar.evolution.HyTemporalElement> manifestElements = new BasicEList<eu.hyvar.evolution.HyTemporalElement>();
						manifestElements.add(container);
						manifestElements.add((eu.hyvar.evolution.HyTemporalElement)container.eContainer());
						manifestElements.add((eu.hyvar.evolution.HyTemporalElement)(container.eContainer().eContainer()));
						HyInterval manifestInterval = HyEvolutionUtil.computeTemporalIntersection(manifestElements);

						EList<eu.hyvar.evolution.HyTemporalElement> enumElements = new BasicEList<eu.hyvar.evolution.HyTemporalElement>();
						enumElements.add(hyEnum);
						enumElements.add(hyEnumLiteral);
						HyInterval enumInterval = HyEvolutionUtil.computeTemporalIntersection(enumElements);

						if(HyEvolutionUtil.isWithinValidityOf(manifestInterval, enumInterval)) {
							//System.out.println("UNITO DEBUG EnumLiteralLinkSignature: enum= "+hyEnumLiteral);

							result.addMapping(identifier, hyEnumLiteral);
						}
					}
				}
			}
		}

		//delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(eu.hyvar.dataValues.HyEnumLiteral element, eu.hyvar.mspl.manifest.HyTimedImplementationEnumLiteralLink container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
