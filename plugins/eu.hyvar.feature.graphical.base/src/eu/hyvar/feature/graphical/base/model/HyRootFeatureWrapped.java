package eu.hyvar.feature.graphical.base.model;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

public class HyRootFeatureWrapped extends HyFeatureWrapped {

	public HyRootFeatureWrapped(EObject wrappedModelElement, HyFeatureModelWrapped featureModel) {
		super(wrappedModelElement, featureModel);
	}

	@Override
	public boolean isWithoutModifier(Date date){
		return true;
	}

}
