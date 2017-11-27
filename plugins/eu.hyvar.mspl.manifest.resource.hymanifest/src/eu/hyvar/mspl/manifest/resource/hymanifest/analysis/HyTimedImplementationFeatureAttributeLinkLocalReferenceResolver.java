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
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.mspl.manifest.HyTimedImplementationEnumLink;
import eu.hyvar.mspl.manifest.HyTimedImplementationFeatureLink;

public class HyTimedImplementationFeatureAttributeLinkLocalReferenceResolver implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolver<eu.hyvar.mspl.manifest.HyTimedImplementationFeatureAttributeLink, eu.hyvar.feature.HyFeatureAttribute> {
	
	private eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestDefaultResolverDelegate<eu.hyvar.mspl.manifest.HyTimedImplementationFeatureAttributeLink, eu.hyvar.feature.HyFeatureAttribute> delegate = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestDefaultResolverDelegate<eu.hyvar.mspl.manifest.HyTimedImplementationFeatureAttributeLink, eu.hyvar.feature.HyFeatureAttribute>();
	
	public void resolve(String identifier, eu.hyvar.mspl.manifest.HyTimedImplementationFeatureAttributeLink container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolveResult<eu.hyvar.feature.HyFeatureAttribute> result) {
		//System.out.println("UNITO DEBUG FeatureAttributeLinkLocal: identifier= "+identifier);

		if(identifier!=null){
			EObject eobject = container.eContainer();
			if(eobject instanceof HyTimedImplementationFeatureLink) {
				HyTimedImplementationFeatureLink hyFeatureLink = (HyTimedImplementationFeatureLink) eobject;
				HyFeature feature = hyFeatureLink.getLocal();
				
				Iterator<HyFeatureAttribute> iterator = feature.getAttributes().iterator();
				while(iterator.hasNext()) {
					HyFeatureAttribute featureAttribute = (HyFeatureAttribute)iterator.next();
					
					EList<HyName> names = featureAttribute.getNames();
					Iterator<HyName> namesIterator = names.iterator();
					while(namesIterator.hasNext()) {
						HyName name = (HyName)namesIterator.next();
						if(identifier.equals(name.getName())) {
	
							EList<eu.hyvar.evolution.HyTemporalElement> manifestElements = new BasicEList<eu.hyvar.evolution.HyTemporalElement>();
							manifestElements.add(container);
							manifestElements.add((eu.hyvar.evolution.HyTemporalElement)container.eContainer());
							manifestElements.add((eu.hyvar.evolution.HyTemporalElement)(container.eContainer().eContainer()));
							HyInterval manifestInterval = HyEvolutionUtil.computeTemporalIntersection(manifestElements);
	
							EList<eu.hyvar.evolution.HyTemporalElement> enumElements = new BasicEList<eu.hyvar.evolution.HyTemporalElement>();
							enumElements.add(feature);
							enumElements.add(featureAttribute);
							enumElements.add(name);
							HyInterval enumInterval = HyEvolutionUtil.computeTemporalIntersection(enumElements);
	
							if(HyEvolutionUtil.isWithinValidityOf(manifestInterval, enumInterval)) {
								//System.out.println("UNITO DEBUG FeatureAttributeLinkLocal: enum= "+featureAttribute);
	
								result.addMapping(identifier, featureAttribute);
							}
						}
					}
				}
			}
		}

		//delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(eu.hyvar.feature.HyFeatureAttribute element, eu.hyvar.mspl.manifest.HyTimedImplementationFeatureAttributeLink container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
