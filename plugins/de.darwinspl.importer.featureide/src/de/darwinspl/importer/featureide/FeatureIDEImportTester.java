package de.darwinspl.importer.featureide;

import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;

public class FeatureIDEImportTester {

	public static void main(String[] args) {
		FeatureIDEFeatureModelImporter featureModelimporter = new FeatureIDEFeatureModelImporter();
		HyFeatureModel hyFeatureModel = featureModelimporter.importFeatureModel("C:\\Users\\mnieke\\Desktop\\featureideexmaple\\model.xml");
		
		FeatureIDEConstraintsImporter constraintsImporter = new FeatureIDEConstraintsImporter();
		HyConstraintModel constraintModel = constraintsImporter.importConstraints(featureModelimporter.getFeatureIDEfeatureModel().getConstraints(), featureModelimporter.getDarwinSPLfeatureModel(), featureModelimporter.getFeatureMap());
		System.out.println("Test");
	}
}
