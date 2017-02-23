package de.darwinspl.importer.featureide;

import org.eclipse.core.resources.IFile;

import de.darwinspl.importer.DarwinSPLFeatureModelAndConstraintsImporter;
import de.darwinspl.importer.FeatureModelConstraintsTuple;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;

public class FeatureIDEFeatureModelAndConstraintsImporter implements DarwinSPLFeatureModelAndConstraintsImporter<IFeatureModel> {

	protected FeatureIDEFeatureModelImporter featureModelImporter;
	
	@Override
	public FeatureModelConstraintsTuple importFeatureModel(IFeatureModel featureModel) {
		
		featureModelImporter = new FeatureIDEFeatureModelImporter();
		HyFeatureModel darwinsplFeatureModel = featureModelImporter.importFeatureModel(featureModel);
		
		return createTuple(darwinsplFeatureModel);
	}

	@Override
	public FeatureModelConstraintsTuple importFeatureModel(String pathToFile) {
		featureModelImporter = new FeatureIDEFeatureModelImporter();
		HyFeatureModel darwinsplFeatureModel = featureModelImporter.importFeatureModel(pathToFile);
		
		return createTuple(darwinsplFeatureModel);
	}

	@Override
	public FeatureModelConstraintsTuple importFeatureModel(IFile file) {
		featureModelImporter = new FeatureIDEFeatureModelImporter();
		HyFeatureModel darwinsplFeatureModel = featureModelImporter.importFeatureModel(file);
		
		return createTuple(darwinsplFeatureModel);
	}
	
	private FeatureModelConstraintsTuple createTuple(HyFeatureModel darwinsplFeatureModel) {
		FeatureIDEConstraintsImporter constraintsImporter = new FeatureIDEConstraintsImporter();
		HyConstraintModel constraintModel = constraintsImporter.importConstraints(featureModelImporter.getFeatureIDEfeatureModel().getConstraints(), darwinsplFeatureModel, featureModelImporter.getFeatureMap());
		
		return new FeatureModelConstraintsTuple(darwinsplFeatureModel, constraintModel);
	}
	

}
