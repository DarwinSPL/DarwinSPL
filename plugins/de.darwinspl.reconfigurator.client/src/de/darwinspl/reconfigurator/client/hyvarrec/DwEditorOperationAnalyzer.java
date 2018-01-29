package de.darwinspl.reconfigurator.client.hyvarrec;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.darwinspl.feature.evolution.editoroperation.DwEditorOperation;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeature;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeatureGroup;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeatureRename;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeatureType;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationGroupType;
import de.darwinspl.feature.evolution.editoroperation.EditoroperationFactory;
import de.darwinspl.reconfigurator.client.hyvarrec.format.HyVarRecExplainAnswer;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.contextValidity.HyValidityFormula;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;

public class DwEditorOperationAnalyzer {
	
	private HyContextModel contextModel;
	private HyValidityModel contextValidityModel;
	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	private HyContextValueModel contextValues;
	private Date date;
	private Date evolutionContextValueDate;
	
	private DwAnalysesClient client;
	
	public DwEditorOperationAnalyzer(DwAnalysesClient client) {
		this.client = client;
	}
	
	public void constructEditorOperations() {
		List<DwEditorOperation> opList = new ArrayList<DwEditorOperation>();
		DwEditorOperation obj = null;
		for(HyFeature feature : featureModel.getFeatures()) {
			// => create EditorOperationFeatureCreate
			obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureCreate();
			obj.setEvoStep(feature.getValidSince());
			((DwEditorOperationFeature) obj).setFeature(feature);
			opList.add(obj);
			
			if (feature.getValidUntil() != null) {
				// => create EditorOperationFeatureDelete
				obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureDelete();
				obj.setEvoStep(feature.getValidUntil());
				((DwEditorOperationFeature) obj).setFeature(feature);
				opList.add(obj);
			}
			
			for (HyName name : feature.getNames()) {
				if (name.getValidSince() != feature.getValidSince()) { // don't interpret default as change
					// => create EditorOperationFeatureRename
					HyName predecessor = (HyName) name.getSupersededElement();
					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureRename();
					obj.setEvoStep(feature.getValidSince());
					((DwEditorOperationFeature) obj).setFeature(feature);
					((DwEditorOperationFeatureRename) obj).setOldName(predecessor);
					((DwEditorOperationFeatureRename) obj).setNewName(name);
					opList.add(obj);
				}
			}
			
			for (HyFeatureType type : feature.getTypes()) {
				if (type.getValidSince() != feature.getValidSince()) { // don't interpret default as change
					HyFeatureType predecessor = (HyFeatureType) type.getSupersededElement();
					// => create EditorOperationFeatureType
					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureType();
					obj.setEvoStep(feature.getValidSince());
					((DwEditorOperationFeature) obj).setFeature(feature);
					((DwEditorOperationFeatureType) obj).setOldType(predecessor);
					((DwEditorOperationFeatureType) obj).setNewType(type);
					opList.add(obj);
				}
			}
			
			for (HyVersion version : feature.getVersions()) {
				// => create editorOperationFeatureVersionCreate
				// => create editorOperationFeatureVersionDelete
				// => create editorOperationFeatureVersionRename
			}
			
			for (HyGroupComposition group : feature.getGroupMembership()) {
				if (group.getValidSince() != feature.getValidSince()) { // don't interpret default as change
					HyGroupComposition predecessor = (HyGroupComposition) group.getSupersededElement();
					// => create editorOperationFeatureGroup
					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureGroup();
					obj.setEvoStep(feature.getValidSince());
					((DwEditorOperationFeature) obj).setFeature(feature);
					((DwEditorOperationFeatureGroup) obj).setOldGroup(predecessor);
					((DwEditorOperationFeatureGroup) obj).setNewGroup(group);
					opList.add(obj);
				}
			}
		}
		
		// lookup group type changes
		for (HyGroup group : featureModel.getGroups()) {				
			for (HyGroupType type : group.getTypes()) {
				if (type.getValidSince() != group.getValidSince()) { // don't interpret default as change
					HyGroupType predecessor = (HyGroupType) type.getSupersededElement();
					// => create editorOperationGroup type change
					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationGroupType();
					obj.setEvoStep(type.getValidSince());
					((DwEditorOperationGroupType) obj).setGroup(group);
					((DwEditorOperationGroupType) obj).setOldType(predecessor);
					((DwEditorOperationGroupType) obj).setNewType(type);
					opList.add(obj);
				}
			}
		}
		
		/* are they equal???? */
		// TODO
		featureModel.getEnums();
		contextModel.getEnums();
		for (int i = 0; i < featureModel.getEnums().size() + contextModel.getEnums().size() - 1; ++i) {
			HyEnum hyEnum = null;
			if (i / featureModel.getEnums().size() > 0) {
				hyEnum = contextModel.getEnums().get(i % featureModel.getEnums().size());
			} else {
				hyEnum = featureModel.getEnums().get(i);
			}
		}
	
		for (HyContextualInformation context : contextModel.getContextualInformations()) {
			// => create editorOperationContextCreate
			
			if (context.getValidUntil() != null) {
				// => create editorOperationContextDelete
			}
		}
	
		for (HyValidityFormula validityFormula : contextValidityModel.getValidityFormulas()) {
			// => create editorOperationValidityFormulaCreate
			
			if (validityFormula.getValidUntil() != null) {
				// => create editorOperationValidityFormulaDelete
			}
		}
		
		for (HyConstraint constraint : constraintModel.getConstraints()) {
			// => create editorOperationConstraintCreate
			
			if (constraint.getValidUntil() != null) {
				// => create editorOperationConstraintDelete
			}
		}
	}
	
	public List<String> processAnomaly(HyVarRecExplainAnswer hyVarRecAnswer, HyVarRecExporter exporter) {
		// TODO
		return client.translateIdsBackToNames(hyVarRecAnswer.getConstraints(), date, exporter);
	}
	

	public HyContextModel getContextModel() {
		return contextModel;
	}

	public void setContextModel(HyContextModel contextModel) {
		this.contextModel = contextModel;
	}

	public HyValidityModel getContextValidityModel() {
		return contextValidityModel;
	}

	public void setContextValidityModel(HyValidityModel contextValidityModel) {
		this.contextValidityModel = contextValidityModel;
	}

	public HyFeatureModel getFeatureModel() {
		return featureModel;
	}

	public void setFeatureModel(HyFeatureModel featureModel) {
		this.featureModel = featureModel;
	}

	public HyConstraintModel getConstraintModel() {
		return constraintModel;
	}

	public void setConstraintModel(HyConstraintModel constraintModel) {
		this.constraintModel = constraintModel;
	}

	public HyContextValueModel getContextValues() {
		return contextValues;
	}

	public void setContextValues(HyContextValueModel contextValues) {
		this.contextValues = contextValues;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getEvolutionContextValueDate() {
		return evolutionContextValueDate;
	}

	public void setEvolutionContextValueDate(Date evolutionContextValueDate) {
		this.evolutionContextValueDate = evolutionContextValueDate;
	}

}
