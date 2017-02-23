package de.darwinspl.importer.splot;

import java.nio.file.Paths;

import org.eclipse.core.resources.IFile;

import de.darwinspl.importer.DarwinSPLFeatureModelImporter;
import de.darwinspl.importer.featureide.FeatureIDEFeatureModelImporter;
import de.ovgu.featureide.fm.core.ExtensionManager.NoSuchExtensionException;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.base.impl.FMFactoryManager;
import de.ovgu.featureide.fm.core.io.IFeatureModelFormat;
import de.ovgu.featureide.fm.core.io.Problem;
import de.ovgu.featureide.fm.core.io.ProblemList;
import de.ovgu.featureide.fm.core.io.manager.FileHandler;
import de.ovgu.featureide.fm.core.io.sxfm.SXFMFormat;
import eu.hyvar.feature.HyFeatureModel;

public class SplotFeatureModelImporter implements DarwinSPLFeatureModelImporter<IFile> {

	private FeatureIDEFeatureModelImporter featureIDEImporter;
	
	public SplotFeatureModelImporter() {
		featureIDEImporter = new FeatureIDEFeatureModelImporter();
	}
	
	@Override
	public HyFeatureModel importFeatureModel(String pathToFile) {
		SXFMFormat format = new SXFMFormat();
		try {
			IFeatureModel featureModel = loadFeatureModel(pathToFile, format);
			return featureIDEImporter.importFeatureModel(featureModel);
		} catch (NoSuchExtensionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static IFeatureModel loadFeatureModel(String filepath, IFeatureModelFormat format)
			throws NoSuchExtensionException {
		IFeatureModel fm = null;

		fm = FMFactoryManager.getFactory(filepath, format).createFeatureModel();

		final ProblemList errors = FileHandler.load(Paths.get(filepath), fm, format).getErrors();

		if (!errors.isEmpty()) {
			for (Problem p : errors) {
				System.err.println(p);
			}
		}

		return fm;
	}

	@Override
	public HyFeatureModel importFeatureModel(IFile file) {
		return importFeatureModel(file.getRawLocation().makeAbsolute().toOSString());
	}

	
	public FeatureIDEFeatureModelImporter getFeatureIDEImporter() {
		return featureIDEImporter;
	}
	
	

}
