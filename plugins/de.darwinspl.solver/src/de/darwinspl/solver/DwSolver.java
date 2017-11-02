package de.darwinspl.solver;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.constraints.nary.cnf.LogOp;
import org.chocosolver.solver.variables.BoolVar;
import org.chocosolver.solver.variables.IntVar;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.HyContextualInformationBoolean;
import eu.hyvar.context.HyContextualInformationEnum;
import eu.hyvar.context.HyContextualInformationNumber;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyAdditionExpression;
import eu.hyvar.feature.expression.HyAndExpression;
import eu.hyvar.feature.expression.HyAtomicExpression;
import eu.hyvar.feature.expression.HyBinaryExpression;
import eu.hyvar.feature.expression.HyDivisionExpression;
import eu.hyvar.feature.expression.HyEqualExpression;
import eu.hyvar.feature.expression.HyEquivalenceExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyGreaterExpression;
import eu.hyvar.feature.expression.HyGreaterOrEqualExpression;
import eu.hyvar.feature.expression.HyImpliesExpression;
import eu.hyvar.feature.expression.HyLessExpression;
import eu.hyvar.feature.expression.HyLessOrEqualExpression;
import eu.hyvar.feature.expression.HyModuloExpression;
import eu.hyvar.feature.expression.HyMultiplicationExpression;
import eu.hyvar.feature.expression.HyNotEqualExpression;
import eu.hyvar.feature.expression.HyOrExpression;
import eu.hyvar.feature.expression.HySubtractionExpression;
import eu.hyvar.feature.expression.HyValueExpression;

public class DwSolver {

	protected HyFeatureModel featureModel;
	protected HyContextModel contextModel;

	protected HyConstraintModel constraintModel;

	protected Model chocoModel;

	protected Solver solver;

	protected DwSolverModelVariableMapping featureModelMapping;

	public DwSolver(HyFeatureModel featureModel, HyContextModel contextModel, Date date) {
		setModels(featureModel, contextModel, date);
	}

	public void setModels(HyFeatureModel featureModel, HyContextModel contextModel, Date date) {
		if (featureModel == null) {
			throw new UnsupportedOperationException("Cannot proceed for null feature model");
		} else if (date == null) {
			throw new UnsupportedOperationException("Currently, a date has to be specified. Null is not supported.");
		}

		this.featureModel = featureModel;
		this.contextModel = contextModel;
		createNewChocoModel();

		this.featureModelMapping = translateModels(featureModel, contextModel, chocoModel, date);

		createNewSolver();
	}

	public void setConstraintModel(HyConstraintModel constraintModel, Date date) {
		if (constraintModel == null) {
			throw new UnsupportedOperationException("Cannot proceed for null constraint model");
		}

		this.constraintModel = constraintModel;

		for (HyConstraint constraint : HyEvolutionUtil.getValidTemporalElements(constraintModel.getConstraints(),
				date)) {
			chocoModel
					.post(createExpressionConstraints(constraint.getRootExpression(), chocoModel, featureModelMapping));
		}
	}

	protected void createNewChocoModel() {
		this.chocoModel = new Model();
	}

	protected void createNewSolver() {
		this.solver = chocoModel.getSolver();
	}

	/**
	 * 
	 * @param featureModel
	 * @param chocoModel
	 * @param date
	 *            optional. If null, date will be encoded as integer variable
	 * @return
	 */
	protected DwSolverModelVariableMapping translateModels(HyFeatureModel featureModel, HyContextModel contextModel, Model chocoModel,
			Date date) {
		DwSolverModelVariableMapping featureModelMapping = new DwSolverModelVariableMapping();

		createFeatureAndVersionVariables(featureModel, chocoModel, featureModelMapping, date);

		if(contextModel != null) {
			createContextVariables(contextModel, chocoModel, featureModelMapping, date);			
		}
		
		return featureModelMapping;
	}

	protected void createFeatureAndVersionVariables(HyFeatureModel featureModel, Model chocoModel,
			DwSolverModelVariableMapping featureModelMapping, Date date) {
		Map<HyFeature, BoolVar> featureVariableMapping = featureModelMapping.getFeatureVariableMapping();
		Map<HyVersion, BoolVar> versionVariableMapping = featureModelMapping.getVersionVariableMapping();
		Map<HyFeatureAttribute, IntVar> attributeVariableMapping = featureModelMapping.getAttributeVariableMapping();

		if (featureVariableMapping == null) {
			featureVariableMapping = new HashMap<HyFeature, BoolVar>();
		}

		if (versionVariableMapping == null) {
			versionVariableMapping = new HashMap<HyVersion, BoolVar>();
		}

		if (attributeVariableMapping == null) {
			attributeVariableMapping = new HashMap<HyFeatureAttribute, IntVar>();
		}

		for (HyFeature feature : featureModel.getFeatures()) {
			if (date == null || HyEvolutionUtil.isValid(feature, date)) {
				BoolVar featureBoolVar = chocoModel.boolVar(feature.getId());
				featureVariableMapping.put(feature, featureBoolVar);

				for (HyVersion version : feature.getVersions()) {
					if (date == null || HyEvolutionUtil.isValid(version, date)) {
						BoolVar vesionBoolVar = chocoModel.boolVar(version.getId());
						versionVariableMapping.put(version, vesionBoolVar);
					}
				}

				for (HyFeatureAttribute attribute : feature.getAttributes()) {
					if (date == null || HyEvolutionUtil.isValid(attribute, date)) {
						IntVar attributeIntVar = null;

						if (attribute instanceof HyBooleanAttribute) {
							attributeIntVar = chocoModel.intVar(attribute.getId(), 0, 1);
						} else if (attribute instanceof HyNumberAttribute) {
							HyNumberAttribute numberAttribute = (HyNumberAttribute) attribute;
							attributeIntVar = chocoModel.intVar(attribute.getId(), numberAttribute.getMin(),
									numberAttribute.getMax());
						} else if (attribute instanceof HyEnumAttribute) {
							HyEnumAttribute enumAttribute = (HyEnumAttribute) attribute;
							List<HyEnumLiteral> enumLiterals = enumAttribute.getEnumType().getLiterals();

							int[] intArray = new int[enumLiterals.size()];

							for (int i = 0; i < enumLiterals.size(); i++) {
								intArray[i] = enumLiterals.get(i).getValue();
							}

							attributeIntVar = chocoModel.intVar(attribute.getId(), intArray);
						}

						if (attributeIntVar != null) {
							attributeVariableMapping.put(attribute, attributeIntVar);
						} else {
							throw new UnsupportedOperationException(
									"It seems a new attribute type has been added which couldn't be handled by the solver. Look at de.darwinspl.solver.DwSolver to check support.");
						}
					}
				}
			}
		}

		featureModelMapping.setFeatureVariableMapping(featureVariableMapping);
		featureModelMapping.setAttributeVariableMapping(attributeVariableMapping);
		featureModelMapping.setVersionVariableMapping(versionVariableMapping);
	}

	protected void createContextVariables(HyContextModel contextModel, Model chocoModel, DwSolverModelVariableMapping modelVariableMapping, Date date) {
		List<HyContextualInformation> validContextInformations = HyEvolutionUtil.getValidTemporalElements(contextModel.getContextualInformations(), date);
		
		Map<HyContextualInformation, IntVar> contextVariableMapping = modelVariableMapping.getContextVariableMapping();
		
		if(contextVariableMapping == null) {
			contextVariableMapping = new HashMap<HyContextualInformation, IntVar>();
		}
		
		for(HyContextualInformation contextInfo: validContextInformations) {
			IntVar intVar = null;
			
			if(contextInfo instanceof HyContextualInformationBoolean) {
				intVar = chocoModel.intVar(contextInfo.getId(), 0, 1);
			}
			else if(contextInfo instanceof HyContextualInformationNumber) {
				HyContextualInformationNumber numberContext = (HyContextualInformationNumber) contextInfo;
				intVar = chocoModel.intVar(contextInfo.getId(), numberContext.getMin(), numberContext.getMax());
			}
			else if(contextInfo instanceof HyContextualInformationEnum) {
				HyContextualInformationEnum enumContext = (HyContextualInformationEnum) contextInfo;
				List<HyEnumLiteral> enumLiterals = enumContext.getEnumType().getLiterals();

				int[] intArray = new int[enumLiterals.size()];

				for (int i = 0; i < enumLiterals.size(); i++) {
					intArray[i] = enumLiterals.get(i).getValue();
				}

				intVar = chocoModel.intVar(contextInfo.getId(), intArray);
			}
			
			if(intVar != null) {
				contextVariableMapping.put(contextInfo, intVar);
			}
			else {
				throw new UnsupportedOperationException(
						"It seems a new context type has been added which couldn't be handled by the solver. Look at de.darwinspl.solver.DwSolver to check support.");
			}
		}
		
		modelVariableMapping.setContextVariableMapping(contextVariableMapping);
	}
	
	protected void createFeatureModelConstraints(HyFeatureModel featureModel, Model chocoModel,
			DwSolverModelVariableMapping featureModelMapping, Date date) {
		HyFeature rootFeature = HyEvolutionUtil.getValidTemporalElement(featureModel.getRootFeature(), date)
				.getFeature();

		// root feature has to be selected.
		chocoModel.addClauseTrue(featureModelMapping.getFeatureVariableMapping().get(rootFeature));
		createVersionConstraints(rootFeature, chocoModel, featureModelMapping, date);

		// TODO attributes

		List<HyFeatureChild> children = HyEvolutionUtil.getValidTemporalElements(rootFeature.getParentOf(), date);
		for (HyFeatureChild child : children) {
			createGroupConstraints(child.getChildGroup(), rootFeature, chocoModel, featureModelMapping, date);
		}

	}

	protected void createGroupConstraints(HyGroup group, HyFeature parent, Model chocoModel,
			DwSolverModelVariableMapping featureModelMapping, Date date) {
		HyGroupType groupType = HyEvolutionUtil.getValidTemporalElement(group.getTypes(), date);

		HyGroupComposition groupComposition = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), date);
		List<HyFeature> childFeatures = HyEvolutionUtil.getValidTemporalElements(groupComposition.getFeatures(), date);

		BoolVar parentVar = featureModelMapping.getFeatureVariableMapping().get(parent);

		BoolVar[] childVars = new BoolVar[childFeatures.size()];
		for (int i = 0; i < childFeatures.size(); i++) {
			childVars[i] = featureModelMapping.getFeatureVariableMapping().get(childFeatures.get(i));
		}

		switch (groupType.getType()) {
		case ALTERNATIVE:
			// constraint means sum(childVars_i) <= parentVar
			chocoModel.addClausesMaxBoolArrayLessEqVar(childVars, parentVar);
			break;
		case AND:

			// List<BoolVar> optionalVarList = new ArrayList<BoolVar>();
			List<BoolVar> mandatoryVarList = new ArrayList<BoolVar>();

			for (HyFeature child : childFeatures) {
				switch (HyEvolutionUtil.getValidTemporalElement(child.getTypes(), date).getType()) {
				case MANDATORY:
					mandatoryVarList.add(featureModelMapping.getFeatureVariableMapping().get(child));
					break;
				case OPTIONAL:
					// optionalVarList.add(featureModelMapping.getFeatureVariableMapping().get(child));
					break;
				default:
					throw new UnsupportedOperationException("Unkown feature type! Cannot be translated for solver.");
				}
			}

			// BoolVar[] optionalVars = optionalVarList.toArray(new
			// BoolVar[optionalVarList.size()]);
			BoolVar[] mandatoryVars = mandatoryVarList.toArray(new BoolVar[mandatoryVarList.size()]);
			// (mandatory_0 and ... and mandatory_i) <=> parent
			chocoModel.addClausesBoolAndArrayEqVar(mandatoryVars, parentVar);

			// (child_0 or ... or child_i) => parent
			LogOp disjunctionOfChildren = LogOp.or(childVars);
			chocoModel.addClauses(LogOp.implies(disjunctionOfChildren, parentVar));

			break;
		case OR:
			// (child_0 or ... or child_i) <=> parent
			chocoModel.addClausesBoolOrArrayEqVar(childVars, parentVar);
			break;
		default:
			throw new UnsupportedOperationException("Unkown group type! Cannot be translated for solver.");
		}

		// go further for subtrees under child features
		for (HyFeature child : childFeatures) {
			for (HyFeatureChild featureChild : HyEvolutionUtil.getValidTemporalElements(child.getParentOf(), date)) {
				createGroupConstraints(featureChild.getChildGroup(), child, chocoModel, featureModelMapping, date);
			}
		}
	}

	protected void createVersionConstraints(HyFeature feature, Model chocoModel,
			DwSolverModelVariableMapping featureModelMapping, Date date) {
		List<HyVersion> validVersions = HyEvolutionUtil.getValidTemporalElements(feature.getVersions(), date);

		BoolVar[] versionVars = new BoolVar[validVersions.size()];

		for (int i = 0; i < validVersions.size(); i++) {
			versionVars[i] = featureModelMapping.getVersionVariableMapping().get(validVersions.get(i));
		}

		BoolVar featureVar = featureModelMapping.getFeatureVariableMapping().get(feature);

		// constraint means sum(versionVars_i) <= featureVar
		chocoModel.addClausesMaxBoolArrayLessEqVar(versionVars, featureVar);
	}

	protected Constraint createExpressionConstraints(HyExpression expression, Model chocoModel,
			DwSolverModelVariableMapping featureModelMapping) {
		if (expression instanceof HyBinaryExpression) {
			return handleBinaryExpression((HyBinaryExpression) expression, chocoModel, featureModelMapping);
			// } else if (expression instanceof HyUnaryExpression) {
			// return handleUnaryExpression((HyUnaryExpression) expression);
			// } else if (expression instanceof HyAtomicExpression) {
			// return handleAtomicExpression((HyAtomicExpression) expression,
			// false);
			// } else if (expression instanceof HySetExpression) {
			// return handleSetExpression((HySetExpression) expression);
		}
		return null;
	}

	protected Constraint handleBinaryExpression(HyBinaryExpression binaryExpression,
			Model chocoModel, DwSolverModelVariableMapping featureModelMapping) {
		Constraint constraint = null;

		if (binaryExpression instanceof HyAndExpression) {
			constraint = chocoModel.and(createExpressionConstraints(binaryExpression.getOperand1(), chocoModel, featureModelMapping),
					createExpressionConstraints(binaryExpression.getOperand2(), chocoModel, featureModelMapping));
		} 
		else if (binaryExpression instanceof HyOrExpression) {
			constraint = chocoModel.or(createExpressionConstraints(binaryExpression.getOperand1(), chocoModel, featureModelMapping),
					createExpressionConstraints(binaryExpression.getOperand2(), chocoModel, featureModelMapping));
		} 
		else if (binaryExpression instanceof HyEquivalenceExpression) {
			Constraint andConstraint = chocoModel.and(createExpressionConstraints(binaryExpression.getOperand1(), chocoModel, featureModelMapping),
					createExpressionConstraints(binaryExpression.getOperand2(), chocoModel, featureModelMapping));
			
			Constraint andNotConstraint = chocoModel.and(chocoModel.not(createExpressionConstraints(binaryExpression.getOperand1(), chocoModel, featureModelMapping)), chocoModel.not(createExpressionConstraints(binaryExpression.getOperand2(), chocoModel, featureModelMapping)));
			
			constraint = chocoModel.or(andConstraint,andNotConstraint);
		} 
		else if (binaryExpression instanceof HyImpliesExpression) {
			constraint = chocoModel.or(chocoModel.not(createExpressionConstraints(binaryExpression.getOperand1(), chocoModel, featureModelMapping)),
					createExpressionConstraints(binaryExpression.getOperand2(), chocoModel, featureModelMapping));
		} 
		// Constraints over attributes
		else if (binaryExpression instanceof HyGreaterExpression) {			
			constraint = chocoModel.arithm(getOperatorOfArithmeticalOperation(binaryExpression.getOperand1(), featureModelMapping), ">", getOperatorOfArithmeticalOperation(binaryExpression.getOperand2(), featureModelMapping));
		} else if (binaryExpression instanceof HyLessExpression) {
			binaryString.append(LESS);
		} else if (binaryExpression instanceof HyLessOrEqualExpression) {
			binaryString.append(LEQ);
		} else if (binaryExpression instanceof HyGreaterOrEqualExpression) {
			binaryString.append(GEQ);
		} else if (binaryExpression instanceof HyEqualExpression) {
			binaryString.append(EQUALS);
		} else if (binaryExpression instanceof HyNotEqualExpression) {
			binaryString.append(NOT_EQUALS);
		} else if (binaryExpression instanceof HyAdditionExpression) {
			binaryString.append(ADDITION);
		} else if (binaryExpression instanceof HySubtractionExpression) {
			binaryString.append(SUBTRACTION);
		} else if (binaryExpression instanceof HyMultiplicationExpression) {
			binaryString.append(MULTIPLICATION);
		} else if (binaryExpression instanceof HyDivisionExpression) {
			binaryString.append(WHITESPACE);
			binaryString.append("Division is not yet supported!");
			binaryString.append(WHITESPACE);
		} else if (binaryExpression instanceof HyModuloExpression) {
			binaryString.append(WHITESPACE);
			binaryString.append("Modulo is not yet supported!");
			binaryString.append(WHITESPACE);
		}
	}
	
	protected IntVar getOperatorOfArithmeticalOperation(HyExpression expression, DwSolverModelVariableMapping featureModelMapping) {
		if(expression instanceof HyValueExpression) {
			
		}
		else if(expression instanceof HyAtomicExpression) {
			
		}
	}

}
