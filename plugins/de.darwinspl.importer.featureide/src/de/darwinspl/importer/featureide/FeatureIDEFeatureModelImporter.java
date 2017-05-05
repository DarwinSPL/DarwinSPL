package de.darwinspl.importer.featureide;

import java.nio.file.Paths;
import java.util.HashMap;
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
	public HyFeatureModel importFeatureModel(IFeatureModel featureModel) {
		this.featureIDEfeatureModel = featureModel;
		
		if (featureModel == null) {
			// TODO proper logging
			System.err.println("Could not import FeatureIDE feature model as it was null");
			return null;
		}

		if (featureModel.getStructure().getRoot() == null) {
			// TODO proper logging
			System.err.println("Could not import FeatureIDE feature model as its root was null");
			return null;
		}

		featureMap = new HashMap<IFeature, HyFeature>();
		
		HyFeatureModel hyFeatureModel = featureFactory.createHyFeatureModel();

		IFeature rootFeature = featureModel.getStructure().getRoot().getFeature();
		
		HyFeature hyRootFeature = processRoot(hyFeatureModel, rootFeature);
		
		processSubTree(hyFeatureModel, hyRootFeature, featureModel, rootFeature);
		
		this.darwinSPLfeatureModel = hyFeatureModel;
		
		return hyFeatureModel;
	}

	/**
	 * 
	 * @param hyFeatureModel
	 * @param rootFeature
	 * @return
	 */
	private HyFeature processRoot(HyFeatureModel hyFeatureModel, IFeature rootFeature) {
		HyRootFeature hyRootFeature = featureFactory.createHyRootFeature();
		hyFeatureModel.getRootFeature().add(hyRootFeature);
		HyFeature hyRootFeatureFeature = featureFactory.createHyFeature();
		
		HyName rootFeatureName = evolutionFactory.createHyName();
		rootFeatureName.setName(rootFeature.getName());
		hyRootFeatureFeature.getNames().add(rootFeatureName);
		
		HyFeatureType featureType = featureFactory.createHyFeatureType();
		featureType.setType(HyFeatureTypeEnum.MANDATORY);
		hyRootFeatureFeature.getTypes().add(featureType);
		
		hyRootFeature.setFeature(hyRootFeatureFeature);
		hyFeatureModel.getFeatures().add(hyRootFeatureFeature);
		
		featureMap.put(rootFeature, hyRootFeatureFeature);
		
		return hyRootFeatureFeature;
	}
	
	/**
	 * 
	 * @param hyFeatureModel New Feature Model
	 * @param hyFeature Parent feature of this subtree
	 * @param featureModel FeatureIDE feature model
	 * @param feature FeatureIDE parent feature of this subtree
	 */
	private void processSubTree(HyFeatureModel hyFeatureModel, HyFeature hyFeature, IFeatureModel featureModel, IFeature feature) {
		if(feature.getStructure().getChildren() == null || feature.getStructure().getChildren().isEmpty()) {
			return;
		}
		
		HyGroup group = featureFactory.createHyGroup();
		hyFeatureModel.getGroups().add(group);
		
		HyFeatureChild featureChild = featureFactory.createHyFeatureChild();
		featureChild.setChildGroup(group);
		featureChild.setParent(hyFeature);
		
		HyGroupComposition groupComposition = featureFactory.createHyGroupComposition();
		groupComposition.setCompositionOf(group);
		
		HyGroupType groupType = featureFactory.createHyGroupType();
		group.getTypes().add(groupType);
		
		
		boolean groupTypeSet = false;
		
		for(IFeatureStructure childFeatureStructure: feature.getStructure().getChildren()) {
			
			if(!groupTypeSet) {
				
				if(childFeatureStructure.isAnd()) {
					groupType.setType(HyGroupTypeEnum.AND);
				}
				else if(childFeatureStructure.isAlternative()) {
					groupType.setType(HyGroupTypeEnum.ALTERNATIVE);
				}
				else if(childFeatureStructure.isOr()) {
					groupType.setType(HyGroupTypeEnum.OR);
				}
			}
			
			IFeature childFeature = childFeatureStructure.getFeature();
			
			HyFeature hyChildFeature = featureFactory.createHyFeature();
			hyFeatureModel.getFeatures().add(hyChildFeature);
			groupComposition.getFeatures().add(hyChildFeature);
			
			HyName childFeatureName = evolutionFactory.createHyName();
			childFeatureName.setName(childFeature.getName());
			hyChildFeature.getNames().add(childFeatureName);
			
			HyFeatureType featureType = featureFactory.createHyFeatureType();
			
			if(childFeatureStructure.isMandatory()) {
				featureType.setType(HyFeatureTypeEnum.MANDATORY);				
			}
			else {
				featureType.setType(HyFeatureTypeEnum.OPTIONAL);		
			}
			
			hyChildFeature.getTypes().add(featureType);
			
			featureMap.put(childFeature, hyChildFeature);
			
			processSubTree(hyFeatureModel, hyChildFeature, featureModel, childFeature);
		}
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
