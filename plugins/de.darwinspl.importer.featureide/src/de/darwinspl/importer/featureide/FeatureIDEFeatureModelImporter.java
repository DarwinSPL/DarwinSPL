package de.darwinspl.importer.featureide;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;

import de.darwinspl.importer.DarwinSPLFeatureModelImporter;
import de.ovgu.featureide.fm.core.ExtensionManager.NoSuchExtensionException;
import de.ovgu.featureide.fm.core.base.IFeature;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.base.IFeatureStructure;
import de.ovgu.featureide.fm.core.base.impl.FMFactoryManager;
import de.ovgu.featureide.fm.core.io.IFeatureModelFormat;
import de.ovgu.featureide.fm.core.io.Problem;
import de.ovgu.featureide.fm.core.io.ProblemList;
import de.ovgu.featureide.fm.core.io.manager.FileHandler;
import de.ovgu.featureide.fm.core.io.xml.XmlFeatureModelFormat;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyRootFeature;

public class FeatureIDEFeatureModelImporter implements DarwinSPLFeatureModelImporter<IFeatureModel> {

	private Map<IFeature, HyFeature> featureMap;
	
	private IFeatureModel featureIDEfeatureModel;
	private HyFeatureModel darwinSPLfeatureModel;
	
	private static final HyFeatureFactory featureFactory = HyFeatureFactory.eINSTANCE;
	private static final HyEvolutionFactory evolutionFactory = HyEvolutionFactory.eINSTANCE;
	
	@Override
	public HyFeatureModel importFeatureModel(String pathToFile) {
		XmlFeatureModelFormat format = new XmlFeatureModelFormat();
		try {
			IFeatureModel featureModel = loadFeatureModel(pathToFile, format);
			return importFeatureModel(featureModel);
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
	public HyFeatureModel importFeatureModel(IFeatureModel featureModelToImport) {
		this.featureIDEfeatureModel = featureModelToImport;
		
		if (featureModelToImport == null) {
			// TODO proper logging
			System.err.println("Could not import FeatureIDE feature model as it was null");
			return null;
		}

		if (featureModelToImport.getStructure().getRoot() == null) {
			// TODO proper logging
			System.err.println("Could not import FeatureIDE feature model as its root was null");
			return null;
		}

		featureMap = new HashMap<IFeature, HyFeature>();
		
		HyFeatureModel hyFeatureModel = featureFactory.createHyFeatureModel();		

		IFeature rootFeature = featureModelToImport.getStructure().getRoot().getFeature();
		
		processRoot(hyFeatureModel, rootFeature);
		
//		processSubTree(hyFeatureModel, hyRootFeature, featureModel, rootFeature);
		
		this.darwinSPLfeatureModel = hyFeatureModel;
		
		return hyFeatureModel;
	}
	
	private HyFeature doImportFeature(IFeature feature, HyFeatureModel dwFeatureModel) {
		String name = feature.getName();
		
		HyFeature dwFeature = featureFactory.createHyFeature();
		dwFeatureModel.getFeatures().add(dwFeature);

		featureMap.put(feature, dwFeature);
		
		HyName dwName = evolutionFactory.createHyName();
		dwName.setName(name);
		dwFeature.getNames().add(dwName);
		
		IFeatureStructure featureStructure = feature.getStructure();
		IFeatureStructure parentFeatureStructure = featureStructure.getParent();
		IFeature parentFeature = parentFeatureStructure == null ? null : parentFeatureStructure.getFeature();
		
		//Variation type of feature
		HyFeatureType featureType = featureFactory.createHyFeatureType();
		if (parentFeature == null) {
			//Root feature is always mandatory
			featureType.setType(HyFeatureTypeEnum.MANDATORY);
		} else if (parentFeatureStructure.isOr() || parentFeatureStructure.isAlternative()) {
			//In dedicated groups, all features are perceived as being optional
			featureType.setType(HyFeatureTypeEnum.OPTIONAL);
		} else if (parentFeatureStructure.isMandatory()) {
			featureType.setType(HyFeatureTypeEnum.MANDATORY);
		} else {
			//Can only be optional
			featureType.setType(HyFeatureTypeEnum.OPTIONAL);
		}
		
		
		List<IFeatureStructure> childStructures = featureStructure.getChildren();
		
		if (!childStructures.isEmpty()) {
			List<HyFeatureChild> dwFeatureChildren = dwFeature.getParentOf();
			
			HyFeatureChild featureChild = featureFactory.createHyFeatureChild();
			dwFeatureChildren.add(featureChild);
			
			HyGroup dwGroup = featureFactory.createHyGroup();
			dwGroup.getChildOf().add(featureChild);
			dwFeatureModel.getGroups().add(dwGroup);
			
			List<HyGroupComposition> groupCompositions = dwGroup.getParentOf();
			HyGroupComposition groupComposition = featureFactory.createHyGroupComposition();
			groupCompositions.add(groupComposition);
			
			//Variation type of group
			HyGroupType groupType = featureFactory.createHyGroupType();
			if (featureStructure.isAlternative()) {
				groupType.setType(HyGroupTypeEnum.ALTERNATIVE);
			} else if (featureStructure.isOr()) {
				groupType.setType(HyGroupTypeEnum.OR);
			} else if (featureStructure.isAnd()) {
				//Minimum is the number of mandatory child features
				groupType.setType(HyGroupTypeEnum.AND);
			}
			
			for (IFeatureStructure childStructure : childStructures) {
				IFeature childFeature = childStructure.getFeature();
				HyFeature dwChildFeature = doImportFeature(childFeature, dwFeatureModel);
				groupComposition.getFeatures().add(dwChildFeature);
			}
		}
		
		return dwFeature;
	}


	
	/**
	 * 
	 * @param hyFeatureModel
	 * @param rootFeature
	 * @return
	 */
	private HyFeature processRoot(HyFeatureModel dwFeatureModel, IFeature rootFeature) {
		HyFeature dwRootFeatureFeature = doImportFeature(rootFeature, dwFeatureModel);
		
		HyRootFeature hyRootFeature = featureFactory.createHyRootFeature();
		dwFeatureModel.getRootFeature().add(hyRootFeature);
		hyRootFeature.setFeature(dwRootFeatureFeature);
		
		
		return dwRootFeatureFeature;
	}
	
	
	public Map<IFeature, HyFeature> getFeatureMap() {
		return featureMap;
	}

	public IFeatureModel getFeatureIDEfeatureModel() {
		return featureIDEfeatureModel;
	}

	public HyFeatureModel getDarwinSPLfeatureModel() {
		return darwinSPLfeatureModel;
	}

	@Override
	public HyFeatureModel importFeatureModel(IFile file) {
		return importFeatureModel(file.getRawLocation().makeAbsolute().toOSString());
	}
	
	
	
}
