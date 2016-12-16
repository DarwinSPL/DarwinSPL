package de.darwinspl.importer.featureide;

import eu.hyvar.feature.HyFeatureModel;

public class FeatureIDEImportTester {

	public static void main(String[] args) {
		FeatureIDEFeatureModelImporter importer = new FeatureIDEFeatureModelImporter();
		HyFeatureModel hyFeatureModel = importer.importFeatureModel("C:\\Users\\mnieke\\Desktop\\featureideexmaple\\model.xml");
		System.out.println("Test");
	}
}
