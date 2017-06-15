package eu.hyvar.mspl.emf.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import eu.hyvar.mspl.manifest.HySPLImplementation;
import eu.hyvar.mspl.manifest.HyTimedDependencies;

public class CheckManifestDependencies extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		//System.out.println("\n\n CheckManifestDependencies: ");
		//System.out.println("Target:"+ctx.getTarget());
		//System.out.println("Type:"+ctx.getEventType());

		HyTimedDependencies dependency;
		HySPLImplementation implementations;

		if(ctx.getTarget() instanceof eu.hyvar.mspl.manifest.HyTimedDependencies) {
			dependency = (eu.hyvar.mspl.manifest.HyTimedDependencies) ctx.getTarget();
			
			if(dependency.eContainer() instanceof eu.hyvar.mspl.manifest.HySPLImplementation) {
				implementations = (eu.hyvar.mspl.manifest.HySPLImplementation) dependency.eContainer();
				
				EList<HyTimedDependencies> dependencies = implementations.getDependencies();
				for(HyTimedDependencies toCheck: dependencies) {
					//System.out.println("Feature instance check:  "+dependency.getSignature()+" - "+toCheck.getSignature()+" ");
					//System.out.println("Feature instance check:  "+dependency.getSignature().getName()+" - "+toCheck.getSignature().getName()+" ");
					if(dependency==toCheck) {
						//System.out.println(" The same instance! \n");
					} else {
						//if(dependency.getSignature()==toCheck.getSignature()) {
						if(dependency.getSignature().getName()!=null && dependency.getSignature().getName().equals(toCheck.getSignature().getName())) {
							
							//System.out.println("ERROR: the same instance\n");
							ctx.addResult(toCheck);
							ctx.skipCurrentConstraintFor(toCheck);
							//HySPLSignature a = (eu.hyvar.mspl.manifest.HySPLSignature) dependency.getSignature();
							return ctx.createFailureStatus(new Object[] { "hymanifest", dependency.getSignature().getName() });
						} else {
							//System.out.println("ok.\n");
						}
					}

					//System.out.print("Feature alias:  "+dependency.getAlias()+" - "+toCheck.getAlias()+" => ");
					if(dependency==toCheck) {
						//System.out.println(" The same instance! \n");
					} else {
						//System.out.print(" Check:  ");
						if(dependency.getAlias().equals(toCheck.getAlias())) {
							//System.out.println("ERROR: the same alias\n");
							ctx.addResult(toCheck);
							ctx.skipCurrentConstraintFor(toCheck);

							return ctx.createFailureStatus(new Object[] { "alias", dependency.getAlias() });
						} else {
							//System.out.println("ok.\n");
						}
					}
				}
				return ctx.createSuccessStatus();
			}
		}

		// Default error
		//System.out.println("ERROR: "+"Wrong class.");
		return ctx.createFailureStatus(new Object[] {"", "Wrong class."});
	}

}
