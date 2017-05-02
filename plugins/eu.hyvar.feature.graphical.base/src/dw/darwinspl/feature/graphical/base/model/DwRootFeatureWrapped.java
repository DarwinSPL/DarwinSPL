package dw.darwinspl.feature.graphical.base.model;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

public class DwRootFeatureWrapped extends DwFeatureWrapped {

	public DwRootFeatureWrapped(EObject wrappedModelElement, DwFeatureModelWrapped featureModel) {
		super(wrappedModelElement, featureModel);
	}

	@Override
	public boolean isWithoutModifier(Date date){
		return true;
	}

}
