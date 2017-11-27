package de.darwinspl.solver;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.variables.BoolVar;
import org.chocosolver.solver.variables.IntVar;
import org.eclipse.emf.common.util.EList;

import de.darwinspl.solver.exception.DwAttributeValueOfSelectedFeatureNotSetException;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.HyContextualInformationBoolean;
import eu.hyvar.context.HyContextualInformationEnum;
import eu.hyvar.context.HyContextualInformationNumber;
import eu.hyvar.context.information.contextValue.HyContextValue;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyStringValue;
import eu.hyvar.dataValues.HyValue;
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
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.HyFeatureDeselected;
import eu.hyvar.feature.configuration.HyFeatureSelection;
import eu.hyvar.feature.configuration.HyVersionDeselected;
import eu.hyvar.feature.configuration.HyVersionSelection;
import eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyAdditionExpression;
import eu.hyvar.feature.expression.HyAndExpression;
import eu.hyvar.feature.expression.HyAtomicExpression;
import eu.hyvar.feature.expression.HyAttributeReferenceExpression;
import eu.hyvar.feature.expression.HyBinaryExpression;
import eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyContextInformationReferenceExpression;
import eu.hyvar.feature.expression.HyDivisionExpression;
import eu.hyvar.feature.expression.HyEqualExpression;
import eu.hyvar.feature.expression.HyEquivalenceExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyGreaterExpression;
import eu.hyvar.feature.expression.HyGreaterOrEqualExpression;
import eu.hyvar.feature.expression.HyImpliesExpression;
import eu.hyvar.feature.expression.HyLessExpression;
import eu.hyvar.feature.expression.HyLessOrEqualExpression;
import eu.hyvar.feature.expression.HyMaximumExpression;
import eu.hyvar.feature.expression.HyMinimumExpression;
import eu.hyvar.feature.expression.HyModuloExpression;
import eu.hyvar.feature.expression.HyMultiplicationExpression;
import eu.hyvar.feature.expression.HyNegationExpression;
import eu.hyvar.feature.expression.HyNestedExpression;
import eu.hyvar.feature.expression.HyNotEqualExpression;
import eu.hyvar.feature.expression.HyNotExpression;
import eu.hyvar.feature.expression.HyOrExpression;
import eu.hyvar.feature.expression.HyRelativeVersionRestriction;
import eu.hyvar.feature.expression.HySubtractionExpression;
import eu.hyvar.feature.expression.HyUnaryExpression;
import eu.hyvar.feature.expression.HyValueExpression;
import eu.hyvar.feature.expression.HyVersionRangeRestriction;
import eu.hyvar.feature.expression.HyVersionRestriction;

public class DwSolverModelTranslation {

	/**
	 * 
	 * @param featureModel
	 * @param chocoModel
	 * @param date
	 *            optional. If null, date will be encoded as integer variable
	 * @return
	 */
	public static DwSolverModelVariableMapping translateModels(HyFeatureModel featureModel, HyContextModel contextModel,
			Model chocoModel, Date date) {
		DwSolverModelVariableMapping featureModelMapping = new DwSolverModelVariableMapping();

		createFeatureAndVersionVariables(featureModel, chocoModel, featureModelMapping, date);

		if (contextModel != null) {
			createContextVariables(contextModel, chocoModel, featureModelMapping, date);
		}

		return featureModelMapping;
	}

	protected static void createFeatureAndVersionVariables(HyFeatureModel featureModel, Model chocoModel,
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

	protected static void createContextVariables(HyContextModel contextModel, Model chocoModel,
			DwSolverModelVariableMapping modelVariableMapping, Date date) {
		List<HyContextualInformation> validContextInformations = HyEvolutionUtil
				.getValidTemporalElements(contextModel.getContextualInformations(), date);

		Map<HyContextualInformation, IntVar> contextVariableMapping = modelVariableMapping.getContextVariableMapping();

		if (contextVariableMapping == null) {
			contextVariableMapping = new HashMap<HyContextualInformation, IntVar>();
		}

		for (HyContextualInformation contextInfo : validContextInformations) {
			IntVar intVar = null;

			if (contextInfo instanceof HyContextualInformationBoolean) {
				intVar = chocoModel.intVar(contextInfo.getId(), 0, 1);
			} else if (contextInfo instanceof HyContextualInformationNumber) {
				HyContextualInformationNumber numberContext = (HyContextualInformationNumber) contextInfo;
				intVar = chocoModel.intVar(contextInfo.getId(), numberContext.getMin(), numberContext.getMax());
			} else if (contextInfo instanceof HyContextualInformationEnum) {
				HyContextualInformationEnum enumContext = (HyContextualInformationEnum) contextInfo;
				List<HyEnumLiteral> enumLiterals = enumContext.getEnumType().getLiterals();

				int[] intArray = new int[enumLiterals.size()];

				for (int i = 0; i < enumLiterals.size(); i++) {
					intArray[i] = enumLiterals.get(i).getValue();
				}

				intVar = chocoModel.intVar(contextInfo.getId(), intArray);
			}

			if (intVar != null) {
				contextVariableMapping.put(contextInfo, intVar);
			} else {
				throw new UnsupportedOperationException(
						"It seems a new context type has been added which couldn't be handled by the solver. Look at de.darwinspl.solver.DwSolver to check support.");
			}
		}

		modelVariableMapping.setContextVariableMapping(contextVariableMapping);
	}

	protected static List<Constraint> createFeatureModelConstraints(HyFeatureModel featureModel, Model chocoModel,
			DwSolverModelVariableMapping featureModelMapping, Date date) {
		List<Constraint> constraints = new ArrayList<Constraint>();
		
		HyFeature rootFeature = HyEvolutionUtil.getValidTemporalElement(featureModel.getRootFeature(), date)
				.getFeature();

		// root feature has to be selected.
		constraints.add(chocoModel.and(featureModelMapping.getFeatureVariableMapping().get(rootFeature)));
//		chocoModel.addClauseTrue(featureModelMapping.getFeatureVariableMapping().get(rootFeature));
		Constraint versionConstraint = createVersionConstraints(rootFeature, chocoModel, featureModelMapping, date);
		if(versionConstraint != null) {
			constraints.add(versionConstraint);			
		}

		// TODO attribute

		List<HyFeatureChild> children = HyEvolutionUtil.getValidTemporalElements(rootFeature.getParentOf(), date);
		for (HyFeatureChild child : children) {
			constraints.addAll(createGroupConstraints(child.getChildGroup(), rootFeature, chocoModel, featureModelMapping, date));
		}

		return constraints;
	}

	protected static List<Constraint> createGroupConstraints(HyGroup group, HyFeature parent, Model chocoModel,
			DwSolverModelVariableMapping featureModelMapping, Date date) {
		List<Constraint> constraints = new ArrayList<Constraint>();
		
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
			// constraint means sum(childVars_i) = parentVar
//			chocoModel.addClausesMaxBoolArrayLessEqVar(childVars, parentVar);
			constraints.add(chocoModel.sum(childVars, "=", parentVar));
			break;
		case AND:

			List<BoolVar> optionalVarList = new ArrayList<BoolVar>();
			List<BoolVar> mandatoryVarList = new ArrayList<BoolVar>();

			for (HyFeature child : childFeatures) {
				switch (HyEvolutionUtil.getValidTemporalElement(child.getTypes(), date).getType()) {
				case MANDATORY:
					mandatoryVarList.add(featureModelMapping.getFeatureVariableMapping().get(child));
					break;
				case OPTIONAL:
					 optionalVarList.add(featureModelMapping.getFeatureVariableMapping().get(child));
					break;
				default:
					throw new UnsupportedOperationException("Unkown feature type! Cannot be translated for solver.");
				}
			}
			
			
			if(mandatoryVarList.size() > 0) {
				BoolVar[] mandatoryAndParentVars = new BoolVar[mandatoryVarList.size()+1];
				
				for(int i=0;i<mandatoryVarList.size();i++) {
					mandatoryAndParentVars[i] = mandatoryVarList.get(i);
				}
				
				mandatoryAndParentVars[mandatoryAndParentVars.length-1] = parentVar;
				
				// mandatory_0 = .... = mandatory_i = parent
				constraints.add(chocoModel.allEqual(mandatoryAndParentVars));
			}
			
			// parent or not(child_0 or ... or child_i)
			if(optionalVarList.size() > 0) {
				constraints.add(chocoModel.or(chocoModel.and(parentVar), chocoModel.not(chocoModel.or(optionalVarList.toArray(new BoolVar[0])))));				
			}
			break;
		case OR:
			// constraint means sum(childVars_i) >= parentVar
			constraints.add(chocoModel.sum(childVars, ">=", parentVar));
			break;
		default:
			throw new UnsupportedOperationException("Unkown group type! Cannot be translated for solver.");
		}

		// go further for subtrees under child features
		for (HyFeature child : childFeatures) {
			Constraint versionConstraint = createVersionConstraints(child, chocoModel, featureModelMapping, date);
			if(versionConstraint != null) {
				constraints.add(versionConstraint);
			}
			
			for (HyFeatureChild featureChild : HyEvolutionUtil.getValidTemporalElements(child.getParentOf(), date)) {
				constraints.addAll(createGroupConstraints(featureChild.getChildGroup(), child, chocoModel, featureModelMapping, date));
			}
		}
		
		return constraints;
	}

	protected static Constraint createVersionConstraints(HyFeature feature, Model chocoModel,
			DwSolverModelVariableMapping featureModelMapping, Date date) {
		List<HyVersion> validVersions = HyEvolutionUtil.getValidTemporalElements(feature.getVersions(), date);

		BoolVar[] versionVars = new BoolVar[validVersions.size()];

		for (int i = 0; i < validVersions.size(); i++) {
			versionVars[i] = featureModelMapping.getVersionVariableMapping().get(validVersions.get(i));
		}

		BoolVar featureVar = featureModelMapping.getFeatureVariableMapping().get(feature);

		// constraint means sum(versionVars_i) <= featureVar
		if(versionVars.length > 0) {
			return chocoModel.sum(versionVars, "=", featureVar);			
		}
		else {
			return null;
		}
		
//		chocoModel.addClausesMaxBoolArrayLessEqVar(versionVars, featureVar);
	}

	public static Constraint createExpressionConstraint(HyExpression expression, Model chocoModel,
			DwSolverModelVariableMapping featureModelMapping, Date date) {
		if (expression instanceof HyBinaryExpression) {
			return handleBinaryExpression((HyBinaryExpression) expression, chocoModel, featureModelMapping, date);
		} else if (expression instanceof HyUnaryExpression) {
			 return createConstraintForUnaryExpression((HyUnaryExpression) expression, chocoModel, featureModelMapping, date);
		} else if (expression instanceof HyAtomicExpression) {
			 return createConstraintForAtomicExpression((HyAtomicExpression) expression, chocoModel, featureModelMapping, date);
			// } else if (expression instanceof HySetExpression) {
			// return handleSetExpression((HySetExpression) expression);
		}
		// TODO!!
		return null;
	}

	protected static Constraint handleBinaryExpression(HyBinaryExpression binaryExpression, Model chocoModel,
			DwSolverModelVariableMapping featureModelMapping, Date date) {
		Constraint constraint = null;

		if (binaryExpression instanceof HyAndExpression) {
			constraint = chocoModel.and(
					createExpressionConstraint(binaryExpression.getOperand1(), chocoModel, featureModelMapping, date),
					createExpressionConstraint(binaryExpression.getOperand2(), chocoModel, featureModelMapping, date));
		} else if (binaryExpression instanceof HyOrExpression) {
			constraint = chocoModel.or(
					createExpressionConstraint(binaryExpression.getOperand1(), chocoModel, featureModelMapping, date),
					createExpressionConstraint(binaryExpression.getOperand2(), chocoModel, featureModelMapping, date));
		} else if (binaryExpression instanceof HyEquivalenceExpression) {
			Constraint andConstraint = chocoModel.and(
					createExpressionConstraint(binaryExpression.getOperand1(), chocoModel, featureModelMapping, date),
					createExpressionConstraint(binaryExpression.getOperand2(), chocoModel, featureModelMapping, date));

			Constraint andNotConstraint = chocoModel.and(
					chocoModel.not(createExpressionConstraint(binaryExpression.getOperand1(), chocoModel,
							featureModelMapping, date)),
					chocoModel.not(createExpressionConstraint(binaryExpression.getOperand2(), chocoModel,
							featureModelMapping, date)));

			constraint = chocoModel.or(andConstraint, andNotConstraint);
		} else if (binaryExpression instanceof HyImpliesExpression) {
			constraint = chocoModel.or(
					chocoModel.not(createExpressionConstraint(binaryExpression.getOperand1(), chocoModel,
							featureModelMapping, date)),
					createExpressionConstraint(binaryExpression.getOperand2(), chocoModel, featureModelMapping, date));
		}
		// Constraints using arithmetic operations. Right and left-hand side can
		// only be atomic expressions!
		else if (binaryExpression instanceof HyGreaterExpression) {
			constraint = chocoModel.arithm(
					getOperandOfArithmeticalOperation(binaryExpression.getOperand1(), chocoModel, featureModelMapping),
					">",
					getOperandOfArithmeticalOperation(binaryExpression.getOperand2(), chocoModel, featureModelMapping));
		} else if (binaryExpression instanceof HyLessExpression) {
			constraint = chocoModel.arithm(
					getOperandOfArithmeticalOperation(binaryExpression.getOperand1(), chocoModel, featureModelMapping),
					"<",
					getOperandOfArithmeticalOperation(binaryExpression.getOperand2(), chocoModel, featureModelMapping));
		} else if (binaryExpression instanceof HyLessOrEqualExpression) {
			constraint = chocoModel.arithm(
					getOperandOfArithmeticalOperation(binaryExpression.getOperand1(), chocoModel, featureModelMapping),
					"<=",
					getOperandOfArithmeticalOperation(binaryExpression.getOperand2(), chocoModel, featureModelMapping));
		} else if (binaryExpression instanceof HyGreaterOrEqualExpression) {
			constraint = chocoModel.arithm(
					getOperandOfArithmeticalOperation(binaryExpression.getOperand1(), chocoModel, featureModelMapping),
					">=",
					getOperandOfArithmeticalOperation(binaryExpression.getOperand2(), chocoModel, featureModelMapping));
		} else if (binaryExpression instanceof HyEqualExpression) {
			constraint = chocoModel.arithm(
					getOperandOfArithmeticalOperation(binaryExpression.getOperand1(), chocoModel, featureModelMapping),
					"=",
					getOperandOfArithmeticalOperation(binaryExpression.getOperand2(), chocoModel, featureModelMapping));
		} else if (binaryExpression instanceof HyNotEqualExpression) {
			constraint = chocoModel.arithm(
					getOperandOfArithmeticalOperation(binaryExpression.getOperand1(), chocoModel, featureModelMapping),
					"!=",
					getOperandOfArithmeticalOperation(binaryExpression.getOperand2(), chocoModel, featureModelMapping));
		} else if (binaryExpression instanceof HyAdditionExpression) {
			throw new UnsupportedOperationException(
					"Addition currently not supported. Check your constraints. ");
		} else if (binaryExpression instanceof HySubtractionExpression) {
			throw new UnsupportedOperationException(
					"Subtraction currently not supported. Check your constraints. ");
		} else if (binaryExpression instanceof HyMultiplicationExpression) {
			throw new UnsupportedOperationException(
					"Multiplication currently not supported. Check your constraints. ");
		} else if (binaryExpression instanceof HyDivisionExpression) {
			throw new UnsupportedOperationException(
					"Division currently not supported. Check your constraints. ");
		} else if (binaryExpression instanceof HyModuloExpression) {
			throw new UnsupportedOperationException(
					"Modulo currently not supported. Check your constraints. ");
		}
		else {
			throw new UnsupportedOperationException(
					"Unkown subclass of HyBinaryExpression. Check solver implementation");
		}
		
		return constraint;
	}

	protected static IntVar getOperandOfArithmeticalOperation(HyExpression expression, Model chocoModel,
			DwSolverModelVariableMapping featureModelMapping) {
		if (expression instanceof HyAtomicExpression) {
			return handleAtomicExpressionOfArithmeticOperation((HyAtomicExpression) expression, chocoModel,
					featureModelMapping);
		} else {
			// exception after arithmetic operations only values or other atomic
			// expressions are allowed
			throw new UnsupportedOperationException(
					"After an arithmetic operator, a ValueExpression or AtomicExpression need to follow. Check your constraints. ");
		}
	}

	protected static IntVar handleAtomicExpressionOfArithmeticOperation(HyAtomicExpression atomicExpression, Model chocoModel,
			DwSolverModelVariableMapping featureModelMapping) {
		if (atomicExpression instanceof HyValueExpression) {
			HyValue value = ((HyValueExpression) atomicExpression).getValue();

			if (value instanceof HyNumberValue) {
				int intValue = ((HyNumberValue) value).getValue();
				return chocoModel.intVar("" + intValue, intValue);
			} else if (value instanceof HyBooleanValue) {
				if (((HyBooleanValue) value).isValue()) {
					return chocoModel.intVar("true", 1);
				} else {
					return chocoModel.intVar("false", 0);
				}
			} else if (value instanceof HyEnumValue) {
				HyEnumValue enumValue = (HyEnumValue) value;
				HyEnumLiteral literal = enumValue.getEnumLiteral();
				return chocoModel.intVar(literal.getName(), literal.getValue());
			} else if (value instanceof HyStringValue) {
				throw new UnsupportedOperationException("Strings are currently not supported");
			} else {
				throw new UnsupportedOperationException(
						"Unsupported subclass of HyValueExpression. Check your constraints. ");
			}
		} 
		else if(atomicExpression instanceof HyAttributeReferenceExpression) {
			return featureModelMapping.getAttributeVariableMapping().get(((HyAttributeReferenceExpression)atomicExpression).getAttribute());
		}
		else if(atomicExpression instanceof HyContextInformationReferenceExpression) {
			return featureModelMapping.getContextVariableMapping().get(((HyContextInformationReferenceExpression)atomicExpression).getContextInformation());
		}
		else if (atomicExpression instanceof HyAbstractFeatureReferenceExpression) {
			throw new UnsupportedOperationException(
					"Feature references are not allowed in arithmetic operations. Check your constraints. ");
			
//			HyAbstractFeatureReferenceExpression abstractFeatureReferenceExpression = (HyAbstractFeatureReferenceExpression) atomicExpression;
//
//			if (abstractFeatureReferenceExpression.getVersionRestriction() == null) {
//				return featureModelMapping.getFeatureVariableMapping()
//						.get(abstractFeatureReferenceExpression.getFeature());
//			} else {
//				HyVersionRestriction versionRestriction = abstractFeatureReferenceExpression.getVersionRestriction();
//
//				if (abstractFeatureReferenceExpression instanceof HyConditionalFeatureReferenceExpression) {
//					throw new UnsupportedOperationException(
//							"HyConditionalFeatureReferenceExpression are not allowed in arithmetic operations. Check your constraints. ");
//				} else {
//					switch (versionRepresentation) {
//					case AS_ONEZERO_FEATURES:
//						break;
//					case PLAIN:
//						atomicString.append(featureId);
//						break;
//					default:
//						atomicString.append(featureId);
//						break;
//					}
//					atomicString.append(handleVersionRangeRestriction(versionRestriction));
//				}
			}
		else {
			throw new UnsupportedOperationException(
					"Unknown subclass of HyAtomicExpression. Check solver implementation. ");
			
		}

	}

	protected static Constraint createConstraintForUnaryExpression(HyUnaryExpression unaryExpression, Model chocoModel,
			DwSolverModelVariableMapping featureModelMapping, Date date) {
		
		if (unaryExpression instanceof HyNotExpression) {
			return chocoModel.not(createExpressionConstraint(unaryExpression.getOperand(), chocoModel, featureModelMapping, date));
		} else if (unaryExpression instanceof HyNestedExpression) {
			HyNestedExpression nestedExpression = (HyNestedExpression) unaryExpression;
			return createExpressionConstraint(nestedExpression.getOperand(), chocoModel, featureModelMapping, date);
		} else if (unaryExpression instanceof HyNegationExpression) {
			throw new UnsupportedOperationException("Negation Expression currently not supported. Check your constraints.");
		} else if (unaryExpression instanceof HyMaximumExpression) {
			throw new UnsupportedOperationException("Maximum Expression currently not supported. Check your constraints.");
		} else if (unaryExpression instanceof HyMinimumExpression) {
			throw new UnsupportedOperationException("Minimum Expression currently not supported. Check your constraints.");
		}
		
		return null;
	}
	
	protected static Constraint createConstraintForAtomicExpression(HyAtomicExpression atomicExpression, Model chocoModel, DwSolverModelVariableMapping featureModelMapping, Date date) {
		if (atomicExpression instanceof HyAbstractFeatureReferenceExpression) {
			
			HyAbstractFeatureReferenceExpression abstractFeatureReferenceExpression = (HyAbstractFeatureReferenceExpression) atomicExpression;
			HyFeature feature = abstractFeatureReferenceExpression.getFeature();

			if (abstractFeatureReferenceExpression.getVersionRestriction() == null) {
				return chocoModel.and(featureModelMapping.getFeatureVariableMapping().get(feature));
			} else {				
				
				HyVersionRestriction versionRestriction = abstractFeatureReferenceExpression.getVersionRestriction();
				
				Constraint versionSum = createVersionRangeConstraint(versionRestriction, chocoModel, featureModelMapping, date);
				
				
				if (abstractFeatureReferenceExpression instanceof HyConditionalFeatureReferenceExpression) {
					Constraint notFeature = chocoModel.not(chocoModel.and(featureModelMapping.getFeatureVariableMapping().get(feature)));
					return chocoModel.or(notFeature, versionSum);
				} else {
					return versionSum;
				}
			}

		} else if (atomicExpression instanceof HyValueExpression) {
			throw new UnsupportedOperationException("Value Expressions only in arithmetic operations allowed. Check your constraints.");
		} else if (atomicExpression instanceof HyAttributeReferenceExpression) {
			throw new UnsupportedOperationException("Attribute Reference Expressions only in arithmetic operations allowed. Check your constraints.");
		}
		
		return null;
	}
	
	private static Constraint createVersionRangeConstraint(HyVersionRestriction versionRestriction, Model chocoModel, DwSolverModelVariableMapping featureModelMapping, Date date) {
		List<HyVersion> versionsOfRange = null;
		if (versionRestriction instanceof HyVersionRangeRestriction) {
			HyVersionRangeRestriction versionRangeRestriction = (HyVersionRangeRestriction) versionRestriction;
			// TODO Only versions in the branch of the upper version? Currently
			// Assumed
			versionsOfRange = iterateVersionsDownUntil(versionRangeRestriction.getUpperVersion(),
					versionRangeRestriction.getLowerVersion());

		} else if (versionRestriction instanceof HyRelativeVersionRestriction) {
			HyRelativeVersionRestriction relativeVersionRestriction = (HyRelativeVersionRestriction) versionRestriction;
			switch (relativeVersionRestriction.getOperator()) {
			case EQUAL:
				versionsOfRange = new ArrayList<HyVersion>();
				versionsOfRange.add(relativeVersionRestriction.getVersion());
				break;
			case GREATER_THAN:
				versionsOfRange = new ArrayList<HyVersion>();
				for (HyVersion version : relativeVersionRestriction.getVersion().getSupersedingVersions()) {
					versionsOfRange.addAll(iterateVersionsUpUntil(version, null));
				}
				break;
			case GREATER_THAN_OR_EQUAL:
				versionsOfRange = iterateVersionsUpUntil(relativeVersionRestriction.getVersion(), null);
				break;
			case IMPLICIT_EQUAL:
				// TODO Dont know what to do here
				versionsOfRange = new ArrayList<HyVersion>();
				break;
			case LESS_THAN:
				versionsOfRange = iterateVersionsDownUntil(relativeVersionRestriction.getVersion().getSupersededVersion(),
						null);
				break;
			case LESS_THAN_OR_EQUAL:
				versionsOfRange = iterateVersionsDownUntil(relativeVersionRestriction.getVersion(), null);
				break;
			default:
				versionsOfRange = new ArrayList<HyVersion>();
				break;
			}
		}


		if (versionsOfRange != null && !versionsOfRange.isEmpty()) {
			List<HyVersion> validVersionsOfRange = new ArrayList<HyVersion>();
			
			for(HyVersion version: versionsOfRange) {
				if(HyEvolutionUtil.isValid(version, date)) {
					validVersionsOfRange.add(version);
				}
			}
			
			BoolVar[] versionVars = new BoolVar[validVersionsOfRange.size()];
			
			for(int i=0;i<validVersionsOfRange.size();i++) {
				versionVars[i] = featureModelMapping.getVersionVariableMapping().get(validVersionsOfRange.get(i));
			}
			
			return chocoModel.sum(versionVars, "=", 1);
		} else {
			throw new UnsupportedOperationException("Could not create relative version restriction constraint as no valid Version exists at selected Date. Check constraints.");
		}

	}
	
	private static List<HyVersion> iterateVersionsDownUntil(HyVersion version, HyVersion until) {
		List<HyVersion> validVersions = new ArrayList<HyVersion>();

		if (version != null) {
			validVersions.add(version);
		} else {
			return validVersions;
		}

		if (version.getSupersededVersion() != null) {
			validVersions.addAll(iterateVersionsDownUntil(version.getSupersededVersion(), until));
		}

		return validVersions;
	}

	private static List<HyVersion> iterateVersionsUpUntil(HyVersion version, HyVersion until) {
		List<HyVersion> validVersions = new ArrayList<HyVersion>();

		if (version != null) {
			validVersions.add(version);
		} else {
			return validVersions;
		}

		if (version != until && version.getSupersedingVersions() != null
				&& !version.getSupersedingVersions().isEmpty()) {
			for (HyVersion supersedingVersion : version.getSupersedingVersions()) {
				validVersions.addAll(iterateVersionsUpUntil(supersedingVersion, until));
			}
		}

		return validVersions;
	}
	
	
	public static List<Constraint> createConstraintsFromConfiguration(HyConfiguration configuration, Model chocoModel, DwSolverModelVariableMapping featureModelMapping, Date date) throws DwAttributeValueOfSelectedFeatureNotSetException {
		List<Constraint> constraints = new ArrayList<Constraint>();

		List<HyFeature> nonSelectedFeatures = new ArrayList<HyFeature>(
				featureModelMapping.getFeatureVariableMapping().size());
		nonSelectedFeatures.addAll(featureModelMapping.getFeatureVariableMapping().keySet());

		List<HyVersion> nonSelectedVersions = new ArrayList<HyVersion>(
				featureModelMapping.getVersionVariableMapping().keySet().size());
		nonSelectedVersions.addAll(featureModelMapping.getVersionVariableMapping().keySet());

		List<HyFeatureAttribute> allAttributesOfSelectedFeatures = new ArrayList<HyFeatureAttribute>();
		List<HyFeatureAttribute> attributesWithAssignedValues = new ArrayList<HyFeatureAttribute>();

		for (HyConfigurationElement configurationElement : configuration.getElements()) {

			if (configurationElement instanceof HyFeatureSelection) {
				HyFeature feature = ((HyFeatureSelection) configurationElement).getSelectedFeature();
				nonSelectedFeatures.remove(feature);

				Constraint constraint = chocoModel.and(featureModelMapping.getFeatureVariableMapping().get(feature));

				if (configurationElement instanceof HyFeatureDeselected) {
					constraint = chocoModel.not(constraint);
				} else {
					allAttributesOfSelectedFeatures
							.addAll(HyEvolutionUtil.getValidTemporalElements(feature.getAttributes(), date));
				}

//				chocoModel.post(constraint);
				constraints.add(constraint);

			} else if (configurationElement instanceof HyAttributeValueAssignment) {
				HyAttributeValueAssignment attributeValueAssignment = (HyAttributeValueAssignment) configurationElement;

				HyFeatureAttribute attribute = attributeValueAssignment.getAttribute();
				attributesWithAssignedValues.add(attribute);

				HyValue value = attributeValueAssignment.getValue();

				IntVar attributeVar = featureModelMapping.getAttributeVariableMapping().get(attribute);
				
				IntVar valueVar = createIntVarForValue(value, chocoModel);

				Constraint constraint = chocoModel.allEqual(attributeVar, valueVar);

//				chocoModel.post(constraint);
				constraints.add(constraint);

			} else if (configurationElement instanceof HyVersionSelection) {
				HyVersion version = ((HyVersionSelection) configurationElement).getSelectedVersion();

				nonSelectedVersions.remove(version);

				Constraint constraint = chocoModel.and(featureModelMapping.getVersionVariableMapping().get(version));

				if (configurationElement instanceof HyVersionDeselected) {
					constraint = chocoModel.not(constraint);
				}

//				chocoModel.post(constraint);
				constraints.add(constraint);
			}

		}
		
		if (!attributesWithAssignedValues.containsAll(allAttributesOfSelectedFeatures)) {
			// attributes of some selected features don't have a value
			// assignment
			throw new DwAttributeValueOfSelectedFeatureNotSetException();
		}
		
		for (HyFeature nonSelectedFeature : nonSelectedFeatures) {
			Constraint constraint = chocoModel
					.and(featureModelMapping.getFeatureVariableMapping().get(nonSelectedFeature));

			constraint = chocoModel.not(constraint);

//			chocoModel.post(constraint);
			constraints.add(constraint);
		}

		for (HyVersion nonSelectedVersion : nonSelectedVersions) {
			Constraint constraint = chocoModel
					.and(featureModelMapping.getVersionVariableMapping().get(nonSelectedVersion));

			constraint = chocoModel.not(constraint);

//			chocoModel.post(constraint);
			constraints.add(constraint);
		}
		
		return constraints;
	}
	
	public static List<Constraint> createConstraintsFromContextValidityModel(HyContextValueModel contextValueModel, Model chocoModel, DwSolverModelVariableMapping featureModelMapping, Date date) {
		List<Constraint> constraints = new ArrayList<Constraint>();
		
		if(contextValueModel == null || chocoModel == null || featureModelMapping == null) {
			return constraints;
		}
		
		EList<HyContextValue> contextValues = contextValueModel.getValues();
		
		for(HyContextValue contextValue: contextValues) {
			HyContextualInformation context = contextValue.getContext();
			if(!HyEvolutionUtil.isValid(context, date)) {
				continue;
			}
			
			HyValue value = contextValue.getValue();
			
			IntVar contextVar = featureModelMapping.getContextVariableMapping().get(context);
			
			IntVar valueVar = createIntVarForValue(value, chocoModel);
			
			Constraint constraint = chocoModel.allEqual(contextVar, valueVar);
			
			constraints.add(constraint);
		}
		
		return constraints;
	}
	
	protected static IntVar createIntVarForValue(HyValue value, Model chocoModel) {
		IntVar valueVar = null;
		
		if (value instanceof HyBooleanValue) {
			HyBooleanValue booleanValue = (HyBooleanValue) value;

			if (booleanValue.isValue()) {
				valueVar = chocoModel.intVar("true", 1);
			} else {
				valueVar = chocoModel.intVar("false", 0);
			}
		} else if (value instanceof HyEnumValue) {
			HyEnumValue enumValue = (HyEnumValue) value;

			HyEnumLiteral enumLiteral = enumValue.getEnumLiteral();
			valueVar = chocoModel.intVar(enumLiteral.getEnum().getName() + "." + enumLiteral.getName(),
					enumLiteral.getValue());
		} else if (value instanceof HyNumberValue) {
			HyNumberValue numberValue = (HyNumberValue) value;
			valueVar = chocoModel.intVar("" + numberValue.getValue(), numberValue.getValue());
		}

		return valueVar;
	}
}
