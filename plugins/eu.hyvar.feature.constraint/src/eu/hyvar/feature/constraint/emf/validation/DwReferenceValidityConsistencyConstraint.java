package eu.hyvar.feature.constraint.emf.validation;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import de.darwinspl.common.analyses.DwAnalyses;
import de.darwinspl.common.analyses.DwAnalysesMarker;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyNamedElement;
import eu.hyvar.feature.constraint.HyConstraint;

public class DwReferenceValidityConsistencyConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		
		// In the case of batch mode.
		if (eType == EMFEventType.NULL) {
			if (eObj instanceof HyConstraint) {
				HyConstraint constraint = (HyConstraint) eObj;
				List<DwAnalysesMarker> markers = DwAnalyses.checkReferenceValidityConsistencyForExpression(constraint.getRootExpression(), constraint);
				
				if(markers == null || markers.size() <= 0) {
					return ctx.createSuccessStatus();
				}
				
				String message = "";
				boolean first = true;
				for(DwAnalysesMarker marker: markers) {
					if(!first) {
						message += ", ";
					}
					else {
						first = false;
					}
					
					for(EObject affectedObject: marker.getAffectedObjects()) {
						message = "(";
						if(affectedObject instanceof HyNamedElement) {
							for(HyName name: ((HyNamedElement)affectedObject).getNames()) {
								message += name.getName();
								message += ",";
							}
						}
						message += ")";
					}
				}
				
				return ctx.createFailureStatus(message);
			}
		}

		return ctx.createSuccessStatus();
	}

}
