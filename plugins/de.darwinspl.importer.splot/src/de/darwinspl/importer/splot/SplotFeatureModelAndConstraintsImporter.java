package de.darwinspl.importer.splot;

import org.deltaecore.integration.ie.feature.data.DEFeatureModelImportExportData;
import org.deltaecore.integration.ie.feature.splot.DESPLOTFeatureModelImporter;
import org.eclipse.core.resources.IFile;

import de.darwinspl.importer.DarwinSPLFeatureModelAndConstraintsImporter;
import de.darwinspl.importer.FeatureModelConstraintsTuple;
import de.darwinspl.importer.deltaecore.DeltaEcoreFeatureModelAndConstraintsImporter;

public class SplotFeatureModelAndConstraintsImporter implements DarwinSPLFeatureModelAndConstraintsImporter<IFile> {


	@Override
	public FeatureModelConstraintsTuple importFeatureModel(String pathToFile) {
		return null;
	}

	@Override
	public FeatureModelConstraintsTuple importFeatureModel(IFile file) {
		DESPLOTFeatureModelImporter desplotimporter = new DESPLOTFeatureModelImporter();
		DEFeatureModelImportExportData importedData = desplotimporter.importFeatureModel(file);
		
		DeltaEcoreFeatureModelAndConstraintsImporter deltaEcoreImporter = new DeltaEcoreFeatureModelAndConstraintsImporter();
		return deltaEcoreImporter.importFeatureModelAndConstraints(importedData.getFeatureModel(), importedData.getConstraintModel());
	}

}
