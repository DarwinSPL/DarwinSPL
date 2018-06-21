package eu.hyvar.feature.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.information.util.ContextInformationResolverUtil;
import eu.hyvar.feature.HyFeatureModel;

public class DwContextFeatureModelResolverUtil {
	
	public static HyContextualInformation resolveContext(String identifier, HyFeatureModel featureModel, Date date) {
		if(identifier == null || identifier.equals("") || featureModel == null) {
			return null;
		}
		
		List<HyContextualInformation> resolvedContexts = new ArrayList<HyContextualInformation>();
		
		for(HyContextModel contextModel: featureModel.getContexts()) {
			resolvedContexts.add(ContextInformationResolverUtil.resolveContextualInformation(identifier, contextModel, date));
		}
		
		if(resolvedContexts.isEmpty() || resolvedContexts.size() > 1) {
			System.err.println("No or multiple contexts could be resolved. Check name ambuiguity.");
			return null;
		}
		else {
			return resolvedContexts.get(0);
		}
	}

}
