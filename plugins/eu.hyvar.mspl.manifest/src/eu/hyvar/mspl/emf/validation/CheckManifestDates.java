package eu.hyvar.mspl.emf.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import eu.hyvar.mspl.manifest.HyTimedImplementationLink;
import eu.hyvar.mspl.manifest.HyTimedImplementations;

public class CheckManifestDates extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		// TODO Auto-generated method stub
		//System.out.println("\n\n CheckManifestDates: ");
		//System.out.println("Target:"+ctx.getTarget());
		//System.out.println("Type:"+ctx.getEventType());

		HyTimedImplementations implementation;
		HyTimedImplementationLink link;
		
		// Check the right order for the dates in Implementation
		if(ctx.getTarget() instanceof eu.hyvar.mspl.manifest.HyTimedImplementations) {
			implementation = (eu.hyvar.mspl.manifest.HyTimedImplementations) ctx.getTarget();
			
			if( implementation.getValidSince()!=null && implementation.getValidUntil()!=null && implementation.getValidSince().after(implementation.getValidUntil()) ) {
				//System.out.println("ERROR: "+"The end date of the interval is before the start date.");
				return ctx.createFailureStatus(new Object[] {""+implementation.getValidUntil(), "The end date of the interval is before the start date."});
			}
			return ctx.createSuccessStatus();
		}

		// Check the link
		if(ctx.getTarget() instanceof eu.hyvar.mspl.manifest.HyTimedImplementationLink) {
			link = (eu.hyvar.mspl.manifest.HyTimedImplementationLink) ctx.getTarget();
			
			// Check the right order for the dates in link
			if( link.getValidSince()!=null && link.getValidUntil()!=null && link.getValidSince().after(link.getValidUntil()) ) {
				//System.out.println("ERROR (LINK): "+"The end date of the interval of the link is before the start date.");
				return ctx.createFailureStatus(new Object[] {""+link.getValidUntil(), "The end date of the interval of the link is before the start date."});
			}
			
			if(link.eContainer() instanceof eu.hyvar.mspl.manifest.HyTimedImplementations) {
				implementation = (eu.hyvar.mspl.manifest.HyTimedImplementations) link.eContainer();

				if( link.getValidSince()!=null && implementation.getValidUntil()!=null && (!link.getValidSince().before(implementation.getValidUntil())) ) {
					//System.out.println("ERROR: "+"The start date of the interval of the link is after the end date of the implementation.");
					return ctx.createFailureStatus(new Object[] {""+link.getValidSince(), "The start date of the interval of the link is after the end date of the implementation."});
				}

				if( link.getValidUntil()!=null && implementation.getValidSince()!=null && (!link.getValidUntil().after(implementation.getValidSince())) ) {
					//System.out.println("ERROR: "+"The end date of the interval is before the start date.");
					return ctx.createFailureStatus(new Object[] {""+link.getValidSince(), "The end date of the interval of the link is before the start date of the implementation."});
				}

			}
			return ctx.createSuccessStatus();
		}
		
		// Default error
		//System.out.println("ERROR: "+"Wrong class.");
		return ctx.createFailureStatus(new Object[] {"", "Wrong class."});
	}

}
