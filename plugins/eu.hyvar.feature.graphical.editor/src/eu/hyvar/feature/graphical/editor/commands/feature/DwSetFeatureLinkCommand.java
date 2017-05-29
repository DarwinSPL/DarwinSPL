package eu.hyvar.feature.graphical.editor.commands.feature;

import java.util.Date;

import org.eclipse.gef.commands.Command;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.mspl.manifest.HySPLImplementation;
import eu.hyvar.mspl.manifest.HySPLSignature;
import eu.hyvar.mspl.manifest.HyTimedImplementationLink;
import eu.hyvar.mspl.manifest.HyTimedImplementations;
import eu.hyvar.mspl.manifest.ManifestFactory;

public class DwSetFeatureLinkCommand extends Command {

	HySPLImplementation implementationManifest;
	HySPLSignature implementingSignature;
	HyFeature localFeature;
	HyFeature signatureFeature;
	Date date;
	
	HyTimedImplementationLink removedImplementationLink;
	
	public DwSetFeatureLinkCommand(HySPLImplementation implementation, HySPLSignature implementingSignature, HyFeature localFeature, HyFeature signatureFeature, Date date) {
		this.implementationManifest = implementation;
		this.implementingSignature = implementingSignature;
		this.localFeature = localFeature;
		this.signatureFeature = signatureFeature;
		this.date = date;
	}
	
	
	@Override
	public void execute(){
		redo();
	}
	
	@Override
	public void undo() {
		// TODO
	}
	
	@Override
	public void redo() {
		if(implementationManifest != null) {
			
			HyTimedImplementations relevantTimedImplementations = null;
			
			for(HyTimedImplementations timedImplementations: HyEvolutionUtil.getValidTemporalElements(implementationManifest.getImplementations(), date)) {
				if(timedImplementations.getSignature() == implementingSignature) {
					
					for(HyTimedImplementationLink implementationLink: HyEvolutionUtil.getValidTemporalElements(timedImplementations.getAssociations(), date)) {
						if(implementationLink.getSignature() == signatureFeature) {
							removedImplementationLink = implementationLink;
							break;
						}
					}
					
					if(removedImplementationLink != null) {
						timedImplementations.getAssociations().remove(removedImplementationLink);
					}
					
					relevantTimedImplementations = timedImplementations;
				}
			}
			
			if(relevantTimedImplementations == null) {
				relevantTimedImplementations = ManifestFactory.eINSTANCE.createHyTimedImplementations();
				relevantTimedImplementations.setValidSince(date);
				relevantTimedImplementations.setSignature(implementingSignature);
			}
			
			
			HyTimedImplementationLink newImplementationLink = ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
			// UNITO - Change from list of feature to one feature
			//newImplementationLink.getLocal().add(localFeature);
			//newImplementationLink.getSignature().add(signatureFeature);
			newImplementationLink.setLocal(localFeature);
			newImplementationLink.setSignature(signatureFeature);
			newImplementationLink.setValidSince(date);
			
			relevantTimedImplementations.getAssociations().add(newImplementationLink);
		}
	}
}
