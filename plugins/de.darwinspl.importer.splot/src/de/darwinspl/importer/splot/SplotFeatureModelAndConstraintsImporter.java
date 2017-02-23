package de.darwinspl.importer.splot;

import org.eclipse.core.resources.IFile;

import de.darwinspl.importer.DarwinSPLFeatureModelAndConstraintsImporter;
import de.darwinspl.importer.FeatureModelConstraintsTuple;
import de.darwinspl.importer.featureide.FeatureIDEConstraintsImporter;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;

public class SplotFeatureModelAndConstraintsImporter implements DarwinSPLFeatureModelAndConstraintsImporter<IFile> {

	protected SplotFeatureModelImporter featureModelImporter;

	@Override
	public FeatureModelConstraintsTuple importFeatureModel(String pathToFile) {
		featureModelImporter = new SplotFeatureModelImporter();
		HyFeatureModel darwinsplFeatureModel = featureModelImporter.importFeatureModel(pathToFile);
		
		return createTuple(darwinsplFeatureModel);
	}

	@Override
	public FeatureModelConstraintsTuple importFeatureModel(IFile file) {
		featureModelImporter = new SplotFeatureModelImporter();
		HyFeatureModel darwinsplFeatureModel = featureModelImporter.importFeatureModel(file);
		
		return createTuple(darwinsplFeatureModel);
	}
	
	private FeatureModelConstraintsTuple createTuple(HyFeatureModel darwinsplFeatureModel) {
		FeatureIDEConstraintsImporter constraintsImporter = new FeatureIDEConstraintsImporter();
		HyConstraintModel constraintModel = constraintsImporter.importConstraints(featureModelImporter.getFeatureIDEImporter().getFeatureIDEfeatureModel().getConstraints(), darwinsplFeatureModel, featureModelImporter.getFeatureIDEImporter().getFeatureMap());
		
		return new FeatureModelConstraintsTuple(darwinsplFeatureModel, constraintModel);
	}

}
