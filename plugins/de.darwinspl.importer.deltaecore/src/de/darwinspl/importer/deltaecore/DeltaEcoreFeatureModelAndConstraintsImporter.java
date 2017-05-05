package de.darwinspl.importer.deltaecore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.deltaecore.feature.DEFeatureModel;
import org.deltaecore.feature.constraint.DEConstraintModel;
import org.deltaecore.feature.constraint.util.DEConstraintIOUtil;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.importer.DarwinSPLFeatureModelAndConstraintsImporter;
import de.darwinspl.importer.FeatureModelConstraintsTuple;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;

public class DeltaEcoreFeatureModelAndConstraintsImporter implements DarwinSPLFeatureModelAndConstraintsImporter<DEFeatureModel> {

	
	@Override
	public FeatureModelConstraintsTuple importFeatureModel(DEFeatureModel featureModel) {
		EObject loadedConstraintModel = EcoreIOUtil.loadAccompanyingModel(featureModel, DEConstraintIOUtil.getDefaultFileExtension(), DEConstraintIOUtil.FILE_EXTENSIONS);

		DEConstraintModel constraintModel = null;
		
		if(loadedConstraintModel instanceof DEConstraintModel) {
			constraintModel = (DEConstraintModel) loadedConstraintModel;
		}
		
		return importFeatureModelAndConstraints(featureModel, constraintModel);
	}

	@Override
	public FeatureModelConstraintsTuple importFeatureModel(String pathToFile) {
		File file = new File(pathToFile);
		
		if(file.exists()) {
			IFile ifile = ResourceUtil.fileToFile(file);
			
			if(ifile != null) {
				return importFeatureModel(ifile);
			}			
		}
		
		return null;
	}

	@Override
	public FeatureModelConstraintsTuple importFeatureModel(IFile file) {
		EObject loadedModel = EcoreIOUtil.loadModel(file);
		
		if(loadedModel != null && loadedModel instanceof DEFeatureModel) {
			return importFeatureModel((DEFeatureModel) loadedModel);
		}
		
		return null;
	}
	
	public FeatureModelConstraintsTuple importFeatureModelAndConstraints(DEFeatureModel featureModel, DEConstraintModel constraintModel) {
		if(featureModel == null) {
			return null;
		}
		
		FeatureModelConstraintsTuple tuple = new FeatureModelConstraintsTuple();
		
		DeltaEcoreFeatureModelImporter fmImporter = new DeltaEcoreFeatureModelImporter();
		
		HyFeatureModel dwFeatureModel = fmImporter.importFeatureModel(featureModel);
		tuple.setFeatureModel(dwFeatureModel);
		
		if(constraintModel != null) {
			DeltaEcoreConstraintsImporter constraintImporter = new DeltaEcoreConstraintsImporter(fmImporter.getVersionMap());
			
			List<DEConstraintModel> constraintModels = new ArrayList<DEConstraintModel>(1);
			constraintModels.add(constraintModel);
			
			HyConstraintModel dwConstraintModel = constraintImporter.importConstraints(dwFeatureModel, fmImporter.getFeatureMap(), featureModel, constraintModels);
			
			tuple.setConstraintModel(dwConstraintModel);
		}
		
		
		
		return tuple;
	}

}
