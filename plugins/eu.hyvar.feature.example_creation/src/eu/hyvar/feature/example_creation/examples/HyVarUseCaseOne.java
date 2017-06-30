package eu.hyvar.feature.example_creation.examples;

import org.deltaecore.core.decore.DEDeltaInvokation;
import org.deltaecore.core.decore.DEcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.context.HyContextInformationFactory;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformationEnum;
import eu.hyvar.context.contextValidity.HyContextValidityFactory;
import eu.hyvar.context.contextValidity.HyFeatureValidityFormula;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationFactory;
import eu.hyvar.feature.configuration.HyFeatureSelection;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintFactory;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyAndExpression;
import eu.hyvar.feature.expression.HyContextInformationReferenceExpression;
import eu.hyvar.feature.expression.HyEqualExpression;
import eu.hyvar.feature.expression.HyEquivalenceExpression;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyImpliesExpression;
import eu.hyvar.feature.expression.HyNotExpression;
import eu.hyvar.feature.expression.HyValueExpression;
import eu.hyvar.feature.mapping.HyMapping;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.feature.mapping.MappingFactory;
import eu.hyvar.preferences.HyProfile;;


public class HyVarUseCaseOne extends HyFMExample {

	private HyFeatureModel featureModel;
	private HyContextModel contextModel;
	
	private HyConstraintModel constraintModel;
	
	private HyValidityModel validityModel;
	
	private HyConfiguration configuration;
	
	private HyMappingModel mappingModel;
	
	public HyVarUseCaseOne() {
		// TODO create Models
		
		createModels();
	}
	
	private void createModels() {
		HyFeatureModel featureModel = factory.createHyFeatureModel();
		
		HyRootFeature rootFeature = factory.createHyRootFeature();
		featureModel.getRootFeature().add(rootFeature);
		
		HyFeature emergencyCallFeature = factory.createHyFeature();
		HyName emergencyCallName = HyEvolutionFactory.eINSTANCE.createHyName();
		emergencyCallName.setName("EmergencyCall");
		emergencyCallFeature.getNames().add(emergencyCallName);
		HyFeatureType emergencyCallType = factory.createHyFeatureType();
		emergencyCallType.setType(HyFeatureTypeEnum.MANDATORY);
		emergencyCallFeature.getTypes().add(emergencyCallType);
		featureModel.getFeatures().add(emergencyCallFeature);
		rootFeature.setFeature(emergencyCallFeature);
		
		HyGroup emergencyCallAndGroup = factory.createHyGroup();
		HyGroupType emergencyCallAndGroupType = factory.createHyGroupType();
		emergencyCallAndGroupType.setType(HyGroupTypeEnum.AND);
		emergencyCallAndGroup.getTypes().add(emergencyCallAndGroupType);
		featureModel.getGroups().add(emergencyCallAndGroup);
		
		HyFeatureChild emergencyCallAndGroupChild = factory.createHyFeatureChild();
		emergencyCallAndGroupChild.setParent(emergencyCallFeature);
		emergencyCallAndGroupChild.setChildGroup(emergencyCallAndGroup);
		
		HyGroupComposition emergencyCallAndGroupComposition = factory.createHyGroupComposition();
		emergencyCallAndGroupComposition.setCompositionOf(emergencyCallAndGroup);

		// --- Sub features
		HyFeature baseFeature = factory.createHyFeature();
		HyName baseName = HyEvolutionFactory.eINSTANCE.createHyName();
		baseName.setName("Base");
		baseFeature.getNames().add(baseName);
		HyFeatureType baseType = factory.createHyFeatureType();
		baseType.setType(HyFeatureTypeEnum.MANDATORY);
		baseFeature.getTypes().add(baseType);
		featureModel.getFeatures().add(baseFeature);
		emergencyCallAndGroupComposition.getFeatures().add(baseFeature);
		
		HyFeature languagesFeature = factory.createHyFeature();
		HyName languagesName = HyEvolutionFactory.eINSTANCE.createHyName();
		languagesName.setName("Languages");
		languagesFeature.getNames().add(languagesName);
		HyFeatureType languagesType = factory.createHyFeatureType();
		languagesType.setType(HyFeatureTypeEnum.MANDATORY);
		languagesFeature.getTypes().add(languagesType);
		featureModel.getFeatures().add(languagesFeature);
		emergencyCallAndGroupComposition.getFeatures().add(languagesFeature);
		
		HyFeature gnssFeature = factory.createHyFeature();
		HyName gnssName = HyEvolutionFactory.eINSTANCE.createHyName();
		gnssName.setName("GNSS");
		gnssFeature.getNames().add(gnssName);
		HyFeatureType gnssType = factory.createHyFeatureType();
		gnssType.setType(HyFeatureTypeEnum.MANDATORY);
		gnssFeature.getTypes().add(gnssType);
		featureModel.getFeatures().add(gnssFeature);
		emergencyCallAndGroupComposition.getFeatures().add(gnssFeature);
		
		HyFeature diagnosticFeature = factory.createHyFeature();
		HyName diagnosticName = HyEvolutionFactory.eINSTANCE.createHyName();
		diagnosticName.setName("Diagnostic");
		diagnosticFeature.getNames().add(diagnosticName);
		HyFeatureType diagnosticType = factory.createHyFeatureType();
		diagnosticType.setType(HyFeatureTypeEnum.OPTIONAL);
		diagnosticFeature.getTypes().add(diagnosticType);
		featureModel.getFeatures().add(diagnosticFeature);
		emergencyCallAndGroupComposition.getFeatures().add(diagnosticFeature);
		
		// -- create group under base
		HyGroup baseAlternativeGroup = factory.createHyGroup();
		HyGroupType baseAlternativeGroupType = factory.createHyGroupType();
		baseAlternativeGroupType.setType(HyGroupTypeEnum.ALTERNATIVE);
		baseAlternativeGroup.getTypes().add(baseAlternativeGroupType);
		featureModel.getGroups().add(baseAlternativeGroup);
		
		HyFeatureChild baseAlternativeGroupChild = factory.createHyFeatureChild();
		baseAlternativeGroupChild.setParent(baseFeature);
		baseAlternativeGroupChild.setChildGroup(baseAlternativeGroup);
		
		HyGroupComposition baseAlternativeGroupComposition = factory.createHyGroupComposition();
		baseAlternativeGroupComposition.setCompositionOf(baseAlternativeGroup);
		
		// -- create sub features of base
		HyFeature eCallFeature = factory.createHyFeature();
		HyName eCallName = HyEvolutionFactory.eINSTANCE.createHyName();
		eCallName.setName("eCall");
		eCallFeature.getNames().add(eCallName);
		HyFeatureType eCallType = factory.createHyFeatureType();
		eCallType.setType(HyFeatureTypeEnum.OPTIONAL);
		eCallFeature.getTypes().add(eCallType);
		featureModel.getFeatures().add(eCallFeature);
		baseAlternativeGroupComposition.getFeatures().add(eCallFeature);

		HyFeature eraGlonassFeature = factory.createHyFeature();
		HyName eraGlonassName = HyEvolutionFactory.eINSTANCE.createHyName();
		eraGlonassName.setName("EraGlonass");
		eraGlonassFeature.getNames().add(eraGlonassName);
		HyFeatureType eraGlonassType = factory.createHyFeatureType();
		eraGlonassType.setType(HyFeatureTypeEnum.OPTIONAL);
		eraGlonassFeature.getTypes().add(eraGlonassType);
		featureModel.getFeatures().add(eraGlonassFeature);
		baseAlternativeGroupComposition.getFeatures().add(eraGlonassFeature);
		
		// -- create group under languages
		HyGroup languagesOrGroup = factory.createHyGroup();
		HyGroupType languagesAlternativeGroupCardinality = factory.createHyGroupType();
		languagesAlternativeGroupCardinality.setType(HyGroupTypeEnum.ALTERNATIVE);
		languagesOrGroup.getTypes().add(languagesAlternativeGroupCardinality);
		featureModel.getGroups().add(languagesOrGroup);

		HyFeatureChild languagesOrGroupChild = factory.createHyFeatureChild();
		languagesOrGroupChild.setParent(languagesFeature);
		languagesOrGroupChild.setChildGroup(languagesOrGroup);

		HyGroupComposition languagesOrGroupComposition = factory.createHyGroupComposition();
		languagesOrGroupComposition.setCompositionOf(languagesOrGroup);
		
		// -- create sub features of languages
		HyFeature russianFeature = factory.createHyFeature();
		HyName russianName = HyEvolutionFactory.eINSTANCE.createHyName();
		russianName.setName("Russian");
		russianFeature.getNames().add(russianName);
		HyFeatureType russianCardinality = factory.createHyFeatureType();
		russianCardinality.setType(HyFeatureTypeEnum.OPTIONAL);
		russianFeature.getTypes().add(russianCardinality);
		featureModel.getFeatures().add(russianFeature);
		languagesOrGroupComposition.getFeatures().add(russianFeature);

		HyFeature euLanguagesFeature = factory.createHyFeature();
		HyName euLanguagesName = HyEvolutionFactory.eINSTANCE.createHyName();
		euLanguagesName.setName("EU_Languages");
		euLanguagesFeature.getNames().add(euLanguagesName);
		HyFeatureType euLanguagesType = factory.createHyFeatureType();
		euLanguagesType.setType(HyFeatureTypeEnum.OPTIONAL);
		euLanguagesFeature.getTypes().add(euLanguagesType);
		featureModel.getFeatures().add(euLanguagesFeature);
		languagesOrGroupComposition.getFeatures().add(euLanguagesFeature);
		
		
		// -- create group under languages
		HyGroup gnssOrGroup = factory.createHyGroup();
		HyGroupType gnssOrGroupCardinality = factory.createHyGroupType();
		gnssOrGroupCardinality.setType(HyGroupTypeEnum.OR);
		gnssOrGroup.getTypes().add(gnssOrGroupCardinality);
		featureModel.getGroups().add(gnssOrGroup);

		HyFeatureChild gnssOrGroupChild = factory.createHyFeatureChild();
		gnssOrGroupChild.setParent(gnssFeature);
		gnssOrGroupChild.setChildGroup(gnssOrGroup);

		HyGroupComposition gnssOrGroupComposition = factory.createHyGroupComposition();
		gnssOrGroupComposition.setCompositionOf(gnssOrGroup);
		
		// -- create sub features of gnss
		HyFeature gpsFeature = factory.createHyFeature();
		HyName gpsName = HyEvolutionFactory.eINSTANCE.createHyName();
		gpsName.setName("GPS");
		gpsFeature.getNames().add(gpsName);
		HyFeatureType gpsCardinality = factory.createHyFeatureType();
		gpsCardinality.setType(HyFeatureTypeEnum.OPTIONAL);
		gpsFeature.getTypes().add(gpsCardinality);
		featureModel.getFeatures().add(gpsFeature);
		gnssOrGroupComposition.getFeatures().add(gpsFeature);

		HyFeature glonassFeature = factory.createHyFeature();
		HyName glonassName = HyEvolutionFactory.eINSTANCE.createHyName();
		glonassName.setName("Glonass");
		glonassFeature.getNames().add(glonassName);
		HyFeatureType glonassCardinality = factory.createHyFeatureType();
		glonassCardinality.setType(HyFeatureTypeEnum.OPTIONAL);
		glonassFeature.getTypes().add(glonassCardinality);
		featureModel.getFeatures().add(glonassFeature);
		gnssOrGroupComposition.getFeatures().add(glonassFeature);
		
		this.featureModel = featureModel;
		
		
		// -- constraint model
		HyConstraintModel constraintModel = HyConstraintFactory.eINSTANCE.createHyConstraintModel();
		
		// EraGlonass <-> Russian
		HyConstraint eraGlonassEquivalentRussianConstraint = HyConstraintFactory.eINSTANCE.createHyConstraint();
		HyEquivalenceExpression eraGlonassEquivalentRussianExpression = HyExpressionFactory.eINSTANCE.createHyEquivalenceExpression();
		HyFeatureReferenceExpression eraGlonassReferenceExpression1 = HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
		eraGlonassReferenceExpression1.setFeature(eraGlonassFeature);
		HyFeatureReferenceExpression russianReferenceExpression1 = HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
		russianReferenceExpression1.setFeature(russianFeature);
		eraGlonassEquivalentRussianExpression.setOperand1(eraGlonassReferenceExpression1);
		eraGlonassEquivalentRussianExpression.setOperand2(russianReferenceExpression1);
		eraGlonassEquivalentRussianConstraint.setRootExpression(eraGlonassEquivalentRussianExpression);
		constraintModel.getConstraints().add(eraGlonassEquivalentRussianConstraint);
		
		// EraClonass -> Diagnostic
		HyConstraint eraGlonassImpliesDiagnostic = HyConstraintFactory.eINSTANCE.createHyConstraint();
		HyImpliesExpression eraGlonassImpliesDiagnosticExpression = HyExpressionFactory.eINSTANCE.createHyImpliesExpression();
		HyFeatureReferenceExpression eraGlonassReferenceExpression2 = EcoreUtil.copy(eraGlonassReferenceExpression1);
		HyFeatureReferenceExpression diagnosticReferenceExpression = HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
		diagnosticReferenceExpression.setFeature(diagnosticFeature);
		eraGlonassImpliesDiagnosticExpression.setOperand1(eraGlonassReferenceExpression2);
		eraGlonassImpliesDiagnosticExpression.setOperand2(diagnosticReferenceExpression);
		eraGlonassImpliesDiagnostic.setRootExpression(eraGlonassImpliesDiagnosticExpression);
		constraintModel.getConstraints().add(eraGlonassImpliesDiagnostic);
		
		// eCall -> EU_Languages
		HyConstraint eCallImpliesEuLanguages = HyConstraintFactory.eINSTANCE.createHyConstraint();
		HyImpliesExpression eCallImpliesEuLanguagesExpression = HyExpressionFactory.eINSTANCE.createHyImpliesExpression();
		HyFeatureReferenceExpression eCallReference1 = HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
		eCallReference1.setFeature(eCallFeature);
		HyFeatureReferenceExpression euLanguagesReference = HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
		euLanguagesReference.setFeature(euLanguagesFeature);
		eCallImpliesEuLanguagesExpression.setOperand1(eCallReference1);
		eCallImpliesEuLanguagesExpression.setOperand2(euLanguagesReference);
		eCallImpliesEuLanguages.setRootExpression(eCallImpliesEuLanguagesExpression);
		constraintModel.getConstraints().add(eCallImpliesEuLanguages);
		
		// eCall -> GPS
		HyConstraint eCallImpliesGPS = HyConstraintFactory.eINSTANCE.createHyConstraint();
		HyImpliesExpression eCallImpliesGPSExpression = HyExpressionFactory.eINSTANCE.createHyImpliesExpression();
		HyFeatureReferenceExpression eCallReference2 = EcoreUtil.copy(eCallReference1);
		HyFeatureReferenceExpression gpsReference = HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
		gpsReference.setFeature(gpsFeature);
		eCallImpliesGPSExpression.setOperand1(eCallReference2);
		eCallImpliesGPSExpression.setOperand2(gpsReference);
		eCallImpliesGPS.setRootExpression(eCallImpliesGPSExpression);
		constraintModel.getConstraints().add(eCallImpliesGPS);
		
		// EraGlonass -> Glonass
		HyConstraint eraGlonassImpliesGlonass = HyConstraintFactory.eINSTANCE.createHyConstraint();
		HyImpliesExpression eraGlonassImpliesGlonassExpression = HyExpressionFactory.eINSTANCE.createHyImpliesExpression();
		HyFeatureReferenceExpression eraGlonassReference2 = EcoreUtil.copy(eraGlonassReferenceExpression2);
		HyFeatureReferenceExpression glonassReference = HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
		glonassReference.setFeature(glonassFeature);
		eraGlonassImpliesGlonassExpression.setOperand1(eraGlonassReference2);
		eraGlonassImpliesGlonassExpression.setOperand2(glonassReference);
		eraGlonassImpliesGlonass.setRootExpression(eraGlonassImpliesGlonassExpression);
		constraintModel.getConstraints().add(eraGlonassImpliesGlonass);
		
		this.constraintModel = constraintModel;
		
		// -- context model
		HyContextModel contextModel = HyContextInformationFactory.eINSTANCE.createHyContextModel();
		
		HyEnum locationEnum = HyDataValuesFactory.eINSTANCE.createHyEnum();
		locationEnum.setId("GPS_Position_enum");
		HyEnumLiteral russiaLiteral = HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
		russiaLiteral.setName("GPS_Position_Russia");
		russiaLiteral.setValue(0);
		russiaLiteral.setEnum(locationEnum);
		HyEnumLiteral europeLiteral = HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
		europeLiteral.setName("GPS_Position_Europe");
		europeLiteral.setValue(1);
		europeLiteral.setEnum(locationEnum);
		
		contextModel.getEnums().add(locationEnum);
		
		HyContextualInformationEnum locationContext = HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
		locationContext.setName("GPS_Positions");
		locationContext.setEnumType(locationEnum);
		contextModel.getContextualInformations().add(locationContext);
		
		this.contextModel = contextModel;
		
		
		// -- Validity Formulas
		HyValidityModel validityModel = HyContextValidityFactory.eINSTANCE.createHyValidityModel();
		
		HyFeatureValidityFormula eCallInEurope = HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
		eCallInEurope.setFeature(eCallFeature);
		HyEqualExpression locationEqualsEurope = HyExpressionFactory.eINSTANCE.createHyEqualExpression();
		HyContextInformationReferenceExpression locationReference = HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
		locationReference.setContextInformation(locationContext);
		HyEnumValue gpsEuropeValue = HyDataValuesFactory.eINSTANCE.createHyEnumValue();
		gpsEuropeValue.setEnum(locationEnum);
		gpsEuropeValue.setEnumLiteral(europeLiteral);
		HyValueExpression gpsEuropeValueExpression = HyExpressionFactory.eINSTANCE.createHyValueExpression();
		gpsEuropeValueExpression.setValue(gpsEuropeValue);
		locationEqualsEurope.setOperand1(locationReference);
		locationEqualsEurope.setOperand2(gpsEuropeValueExpression);
		eCallInEurope.setValidityFormula(locationEqualsEurope);
		validityModel.getValidityFormulas().add(eCallInEurope);
		
		this.validityModel = validityModel;
		
		// -- Mapping
		// Create dummy deltas
//		IWorkspace workspace = ResourcesPlugin.getWorkspace();
//		IWorkspaceRoot root = workspace.getRoot();
//		IProject project = root.getProject("abcdefg7778");
//		IFolder folder = project.getFolder("Folder");
//		IFolder deltaFolder = folder.getFolder("deltas");
//		
//		if(!project.exists()) {
//			try {
//				project.create(new NullProgressMonitor());
//			} catch (CoreException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
//		DEDelta europaCombDelta = DEcoreFactory.eINSTANCE.createDEDelta();
//		europaCombDelta.setName("Europa_Comb");
		
		
		HyMappingModel mappingModel = MappingFactory.eINSTANCE.createHyMappingModel();
		
		HyMapping europaCoreMapping = MappingFactory.eINSTANCE.createHyMapping();
		HyAndExpression europaCoreExpression = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		
		HyAndExpression eCallAndEUlanguages = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression eCallReference3 = EcoreUtil.copy(eCallReference2);
		HyFeatureReferenceExpression euLanguagesReference2 = EcoreUtil.copy(euLanguagesReference);
		eCallAndEUlanguages.setOperand1(eCallReference3);
		eCallAndEUlanguages.setOperand2(euLanguagesReference2);
		
		HyAndExpression eCallEULangAndGps = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression gpsReference2 = EcoreUtil.copy(gpsReference);
		eCallEULangAndGps.setOperand1(eCallAndEUlanguages);
		eCallEULangAndGps.setOperand2(gpsReference2);
		
		HyAndExpression eCallEuLangGpsAndNotGlonass = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyNotExpression notGlonassExpression = HyExpressionFactory.eINSTANCE.createHyNotExpression();
		HyFeatureReferenceExpression glonassReference2 = EcoreUtil.copy(glonassReference);
		notGlonassExpression.setOperand(glonassReference2);
		eCallEuLangGpsAndNotGlonass.setOperand1(eCallEULangAndGps);
		eCallEuLangGpsAndNotGlonass.setOperand2(notGlonassExpression);
		
		HyNotExpression notDiagnosticExpression = HyExpressionFactory.eINSTANCE.createHyNotExpression();
		HyFeatureReferenceExpression diagnosticReference2 = EcoreUtil.copy(diagnosticReferenceExpression);
		notDiagnosticExpression.setOperand(diagnosticReference2);
		
		europaCoreExpression.setOperand1(eCallEuLangGpsAndNotGlonass);
		europaCoreExpression.setOperand2(notDiagnosticExpression);
		
		europaCoreMapping.setExpression(europaCoreExpression);
		mappingModel.getMappings().add(europaCoreMapping);
		
		
		HyMapping europaCombMapping = MappingFactory.eINSTANCE.createHyMapping();
		HyAndExpression europaCombExpression = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		
		HyAndExpression eCallAndEUlanguages2 = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression eCallReference4 = EcoreUtil.copy(eCallReference3);
		HyFeatureReferenceExpression euLanguagesReference3 = EcoreUtil.copy(euLanguagesReference2);
		eCallAndEUlanguages2.setOperand1(eCallReference4);
		eCallAndEUlanguages2.setOperand2(euLanguagesReference3);
		
		HyAndExpression eCallEULangAndGps2 = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression gpsReference3 = EcoreUtil.copy(gpsReference2);
		eCallEULangAndGps2.setOperand1(eCallAndEUlanguages2);
		eCallEULangAndGps2.setOperand2(gpsReference3);
		
		HyAndExpression eCallEuLangGpsAndGlonass = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression glonassReference3 = EcoreUtil.copy(glonassReference2);
		eCallEuLangGpsAndGlonass.setOperand1(eCallEULangAndGps2);
		eCallEuLangGpsAndGlonass.setOperand2(glonassReference3);
		
		HyNotExpression notDiagnosticExpression2 = HyExpressionFactory.eINSTANCE.createHyNotExpression();
		HyFeatureReferenceExpression diagnosticReference3 = EcoreUtil.copy(diagnosticReference2);
		notDiagnosticExpression2.setOperand(diagnosticReference3);
		
		europaCombExpression.setOperand1(eCallEuLangGpsAndGlonass);
		europaCombExpression.setOperand2(notDiagnosticExpression2);
		
		europaCombMapping.setExpression(europaCombExpression);
		mappingModel.getMappings().add(europaCombMapping);
		
		
		
		
		HyMapping europaDiagGpsMapping = MappingFactory.eINSTANCE.createHyMapping();
		HyAndExpression europaDiagGpsExpression = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		
		HyAndExpression eCallAndEUlanguages3 = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression eCallReference5 = EcoreUtil.copy(eCallReference4);
		HyFeatureReferenceExpression euLanguagesReference4 = EcoreUtil.copy(euLanguagesReference3);
		eCallAndEUlanguages3.setOperand1(eCallReference5);
		eCallAndEUlanguages3.setOperand2(euLanguagesReference4);
		
		HyAndExpression eCallEULangAndGps3 = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression gpsReference4 = EcoreUtil.copy(gpsReference3);
		eCallEULangAndGps3.setOperand1(eCallAndEUlanguages3);
		eCallEULangAndGps3.setOperand2(gpsReference4);
		
		HyAndExpression eCallEuLangGpsAndNotGlonass2 = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyNotExpression notGlonassExpression2 = HyExpressionFactory.eINSTANCE.createHyNotExpression();
		HyFeatureReferenceExpression glonassReference4 = EcoreUtil.copy(glonassReference3);
		notGlonassExpression2.setOperand(glonassReference4);
		eCallEuLangGpsAndNotGlonass2.setOperand1(eCallEULangAndGps3);
		eCallEuLangGpsAndNotGlonass2.setOperand2(notGlonassExpression2);
		
		HyFeatureReferenceExpression diagnosticReference4 = EcoreUtil.copy(diagnosticReference2);
		
		europaDiagGpsExpression.setOperand1(eCallEuLangGpsAndNotGlonass2);
		europaDiagGpsExpression.setOperand2(diagnosticReference4);
		
		europaDiagGpsMapping.setExpression(europaDiagGpsExpression);
		mappingModel.getMappings().add(europaDiagGpsMapping);
		
		
		HyMapping europaDiagCombMapping = MappingFactory.eINSTANCE.createHyMapping();
		HyAndExpression europaDiagCombExpression = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		
		HyAndExpression eCallAndEUlanguages4 = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression eCallReference6 = EcoreUtil.copy(eCallReference5);
		HyFeatureReferenceExpression euLanguagesReference5 = EcoreUtil.copy(euLanguagesReference4);
		eCallAndEUlanguages4.setOperand1(eCallReference6);
		eCallAndEUlanguages4.setOperand2(euLanguagesReference5);
		
		HyAndExpression eCallEULangAndGps4 = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression gpsReference5 = EcoreUtil.copy(gpsReference);
		eCallEULangAndGps4.setOperand1(eCallAndEUlanguages4);
		eCallEULangAndGps4.setOperand2(gpsReference5);
		
		HyAndExpression eCallEuLangGpsAndGlonass2 = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression glonassReference5 = EcoreUtil.copy(glonassReference);
		eCallEuLangGpsAndGlonass2.setOperand1(eCallEULangAndGps4);
		eCallEuLangGpsAndGlonass2.setOperand2(glonassReference5);
		
		HyFeatureReferenceExpression diagnosticReference5 = EcoreUtil.copy(diagnosticReferenceExpression);
		
		europaDiagCombExpression.setOperand1(eCallEuLangGpsAndGlonass2);
		europaDiagCombExpression.setOperand2(diagnosticReference5);
		
		europaDiagCombMapping.setExpression(europaDiagCombExpression);
		mappingModel.getMappings().add(europaDiagCombMapping);
		
		
		// EraGlonass && Russian && Diagnostic && Glonass && !GPS && !EU_Languages
		
		HyMapping russiaGlonassMapping = MappingFactory.eINSTANCE.createHyMapping();
		HyAndExpression russiaGlonassExpression = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		
		HyAndExpression eraGlonassAndRussianExpression = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression eraGlonassReference3 = EcoreUtil.copy(eraGlonassReference2);
		HyFeatureReferenceExpression russianReference2 = EcoreUtil.copy(russianReferenceExpression1);
		eraGlonassAndRussianExpression.setOperand1(eraGlonassReference3);
		eraGlonassAndRussianExpression.setOperand2(russianReference2);
		
		HyAndExpression eraGlonassRussianAndDiagnosticExpression = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression diagnosticReference6 = EcoreUtil.copy(diagnosticReferenceExpression);
		eraGlonassRussianAndDiagnosticExpression.setOperand1(eraGlonassAndRussianExpression);
		eraGlonassRussianAndDiagnosticExpression.setOperand2(diagnosticReference6);
		
		HyAndExpression eraGlonassRussianDiagnosticAndGlonassExpression = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression glonassReference6 = EcoreUtil.copy(glonassReference);
		eraGlonassRussianDiagnosticAndGlonassExpression.setOperand1(eraGlonassRussianAndDiagnosticExpression);
		eraGlonassRussianDiagnosticAndGlonassExpression.setOperand2(glonassReference6);
		
		HyAndExpression eraGlonassRussianDiagnosticGlonassAndNotGpsExpression = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyNotExpression notGpsExpression = HyExpressionFactory.eINSTANCE.createHyNotExpression();
		HyFeatureReferenceExpression gpsReference6 = EcoreUtil.copy(gpsReference);
		notGpsExpression.setOperand(gpsReference6);
		eraGlonassRussianDiagnosticGlonassAndNotGpsExpression.setOperand1(eraGlonassRussianDiagnosticAndGlonassExpression);
		eraGlonassRussianDiagnosticGlonassAndNotGpsExpression.setOperand2(notGpsExpression);
		
		HyNotExpression notEuLangExpression = HyExpressionFactory.eINSTANCE.createHyNotExpression();
		HyFeatureReferenceExpression euLanguagesReference6 = EcoreUtil.copy(euLanguagesReference);
		notEuLangExpression.setOperand(euLanguagesReference6);
		
		russiaGlonassExpression.setOperand1(eraGlonassRussianDiagnosticGlonassAndNotGpsExpression);
		russiaGlonassExpression.setOperand2(notEuLangExpression);
		
		russiaGlonassMapping.setExpression(russiaGlonassExpression);
		mappingModel.getMappings().add(russiaGlonassMapping);
		
		
		// EraGlonass && Glonass && Diagnostic && Russian && GPS && !EU_Languages
		
		HyMapping russiaCombMapping = MappingFactory.eINSTANCE.createHyMapping();
		HyAndExpression russiaCombExpression = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		
		HyAndExpression eraGlonassAndRussianExpression2 = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression eraGlonassReference4 = EcoreUtil.copy(eraGlonassReference2);
		HyFeatureReferenceExpression russianReference3 = EcoreUtil.copy(russianReferenceExpression1);
		eraGlonassAndRussianExpression2.setOperand1(eraGlonassReference4);
		eraGlonassAndRussianExpression2.setOperand2(russianReference3);
		
		HyAndExpression eraGlonassRussianAndDiagnosticExpression2 = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression diagnosticReference7 = EcoreUtil.copy(diagnosticReferenceExpression);
		eraGlonassRussianAndDiagnosticExpression2.setOperand1(eraGlonassAndRussianExpression2);
		eraGlonassRussianAndDiagnosticExpression2.setOperand2(diagnosticReference7);
		
		HyAndExpression eraGlonassRussianDiagnosticAndGlonassExpression2 = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression glonassReference7 = EcoreUtil.copy(glonassReference);
		eraGlonassRussianDiagnosticAndGlonassExpression2.setOperand1(eraGlonassRussianAndDiagnosticExpression2);
		eraGlonassRussianDiagnosticAndGlonassExpression2.setOperand2(glonassReference7);
		
		HyAndExpression eraGlonassRussianDiagnosticGlonassAndGpsExpression = HyExpressionFactory.eINSTANCE.createHyAndExpression();
		HyFeatureReferenceExpression gpsReference7 = EcoreUtil.copy(gpsReference);
		eraGlonassRussianDiagnosticGlonassAndGpsExpression.setOperand1(eraGlonassRussianDiagnosticAndGlonassExpression2);
		eraGlonassRussianDiagnosticGlonassAndGpsExpression.setOperand2(gpsReference7);
		
		HyNotExpression notEuLangExpression2 = HyExpressionFactory.eINSTANCE.createHyNotExpression();
		HyFeatureReferenceExpression euLanguagesReference7 = EcoreUtil.copy(euLanguagesReference);
		notEuLangExpression2.setOperand(euLanguagesReference7);
		
		russiaCombExpression.setOperand1(eraGlonassRussianDiagnosticGlonassAndGpsExpression);
		russiaCombExpression.setOperand2(notEuLangExpression2);
		
		russiaCombMapping.setExpression(russiaCombExpression);
		mappingModel.getMappings().add(russiaCombMapping);
		
		
		
		this.mappingModel = mappingModel;
		
		
		// -- create Configuration
		HyConfiguration oldConfiguration = HyConfigurationFactory.eINSTANCE.createHyConfiguration();
		oldConfiguration.setFeatureModel(featureModel);
		
		HyFeatureSelection emergencyCallSelected = HyConfigurationFactory.eINSTANCE.createHyFeatureSelected();
		emergencyCallSelected.setSelectedFeature(emergencyCallFeature);
		oldConfiguration.getElements().add(emergencyCallSelected);
		
		HyFeatureSelection baseSelected = HyConfigurationFactory.eINSTANCE.createHyFeatureSelected();
		baseSelected.setSelectedFeature(baseFeature);
		oldConfiguration.getElements().add(baseSelected);
		
		HyFeatureSelection eCallSelected = HyConfigurationFactory.eINSTANCE.createHyFeatureSelected();
		eCallSelected.setSelectedFeature(eCallFeature);
		oldConfiguration.getElements().add(eCallSelected);
		
		HyFeatureSelection euLanguagesSelected = HyConfigurationFactory.eINSTANCE.createHyFeatureSelected();
		euLanguagesSelected.setSelectedFeature(euLanguagesFeature);
		oldConfiguration.getElements().add(euLanguagesSelected);
		
		HyFeatureSelection gpsSelected = HyConfigurationFactory.eINSTANCE.createHyFeatureSelected();
		gpsSelected.setSelectedFeature(gpsFeature);
		oldConfiguration.getElements().add(gpsSelected);
		
		HyFeatureSelection gnssSelected = HyConfigurationFactory.eINSTANCE.createHyFeatureSelected();
		gnssSelected.setSelectedFeature(gnssFeature);
		oldConfiguration.getElements().add(gnssSelected);
		
		HyFeatureSelection languagesSelected = HyConfigurationFactory.eINSTANCE.createHyFeatureSelected();
		languagesSelected.setSelectedFeature(languagesFeature);
		oldConfiguration.getElements().add(languagesSelected);
		
		this.configuration = oldConfiguration;
	}
	
	@Override
	public HyFeatureModel createExample() {
		return featureModel;
	}

	@Override
	public HyMappingModel createMappingModel() {
		return mappingModel;
	}

	@Override
	public HyConstraintModel createConstraintModel() {
		return constraintModel;
	}

	@Override
	public HyContextModel createContextModel() {
		return contextModel;
	}

	@Override
	public HyValidityModel createValidityModel() {
		return validityModel;
	}

	@Override
	public HyProfile createPreferenceModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HyConfiguration createConfiguration() {
		return configuration;
	}

}
