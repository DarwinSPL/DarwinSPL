package eu.hyvar.reconfigurator.input.exporter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyStringValue;
import eu.hyvar.dataValues.HyValue;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyAdditionExpression;
import eu.hyvar.feature.expression.HyAndExpression;
import eu.hyvar.feature.expression.HyArithmeticalComparisonExpression;
import eu.hyvar.feature.expression.HyArithmeticalValueAtomicExpression;
import eu.hyvar.feature.expression.HyArithmeticalValueBinaryOperationExpression;
import eu.hyvar.feature.expression.HyArithmeticalValueExpression;
import eu.hyvar.feature.expression.HyArithmeticalValueUnaryOperationExpression;
import eu.hyvar.feature.expression.HyAtomicExpression;
import eu.hyvar.feature.expression.HyAttributeReferenceExpression;
import eu.hyvar.feature.expression.HyBinaryExpression;
import eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyContextInformationReferenceExpression;
import eu.hyvar.feature.expression.HyDivisionExpression;
import eu.hyvar.feature.expression.HyEquivalenceExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyImpliesExpression;
import eu.hyvar.feature.expression.HyMaximumExpression;
import eu.hyvar.feature.expression.HyMinimumExpression;
import eu.hyvar.feature.expression.HyModuloExpression;
import eu.hyvar.feature.expression.HyMultiplicationExpression;
import eu.hyvar.feature.expression.HyNegationExpression;
import eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression;
import eu.hyvar.feature.expression.HyNestedExpression;
import eu.hyvar.feature.expression.HyNotExpression;
import eu.hyvar.feature.expression.HyOrExpression;
import eu.hyvar.feature.expression.HyRelativeVersionRestriction;
import eu.hyvar.feature.expression.HySetExpression;
import eu.hyvar.feature.expression.HySubtractionExpression;
import eu.hyvar.feature.expression.HyUnaryExpression;
import eu.hyvar.feature.expression.HyValueExpression;
import eu.hyvar.feature.expression.HyVersionRangeRestriction;
import eu.hyvar.feature.expression.HyVersionRestriction;

public class DwExpressionExporter {

	private Map<HyFeature, String> featureIdMapping;
	private Map<HyVersion, String> versionIdMapping;
	private Map<HyFeatureAttribute, String> attributeIdMapping;
	private Map<HyContextualInformation, String> contextIdMapping;

	private DwFeatureEncoding featureEncoding;
	
	public DwExpressionExporter(Map<HyFeature, String> featureIdMapping, Map<HyVersion, String> versionIdMapping,
			Map<HyFeatureAttribute, String> attributeIdMapping, Map<HyContextualInformation, String> contextIdMapping, DwFeatureEncoding featureEncoding) {
		this.featureIdMapping = featureIdMapping;
		this.versionIdMapping = versionIdMapping;
		this.attributeIdMapping = attributeIdMapping;
		this.contextIdMapping = contextIdMapping;
		this.featureEncoding = featureEncoding;
	}

	public String exportExpressionToString(HyExpression expression) {
		String expressionString = handleExpression(expression, true);
		return expressionString;
	}

	private String handleExpression(HyExpression expression, boolean isRootExpression) {

		if (expression instanceof HyBinaryExpression) {
			return handleBinaryExpression((HyBinaryExpression) expression, isRootExpression);
		} else if (expression instanceof HyUnaryExpression) {
			return handleUnaryExpression((HyUnaryExpression) expression);
		} else if (expression instanceof HyAtomicExpression) {
			return handleAtomicExpression((HyAtomicExpression) expression, false);
		} else if (expression instanceof HySetExpression) {
			return handleSetExpression((HySetExpression) expression);
		}

		return "";
	}

	private String handleSetExpression(HySetExpression setExpression) {

		System.err.println("Set expressions are currently not working.");
		return "";
		// StringBuilder setString = new StringBuilder("");
		//
		// if (setExpression instanceof HyIfPossibleExpression) {
		//
		// boolean first = true;
		//
		// for (HyExpression operand : setExpression.getOperands()) {
		// if (!first) {
		// setString.append(HyVarRecExporter.ADDITION);
		// } else {
		// first = false;
		// }
		//
		// setString.append(HyVarRecExporter.BRACKETS_OPEN);
		// setString.append(handleExpression(operand));
		// setString.append(HyVarRecExporter.BRACKETS_CLOSING);
		// }
		// }
		//
		// return setString.toString();
	}

	private String handleBinaryExpression(HyBinaryExpression binaryExpression, boolean isRootExpression) {
		StringBuilder binaryString = new StringBuilder();

		// TODO sensible?
		// Special case A -> IfPossible(B,C) is syntactic sugar for A -> B + A
		// -> C
		// if (resolveSetExpression && binaryExpression instanceof HyImpliesExpression
		// && binaryExpression.getOperand2() instanceof HyIfPossibleExpression) {
		// HyIfPossibleExpression ifPossible = (HyIfPossibleExpression)
		// binaryExpression.getOperand2();
		//
		// boolean first = true;
		// for (HyExpression ifPossibleOperand : ifPossible.getOperands()) {
		// if (!first) {
		// binaryString.append(HyVarRecExporter.ADDITION);
		// } else {
		// first = false;
		// }
		//
		// HyImpliesExpression operandImplies =
		// HyExpressionFactory.eINSTANCE.createHyImpliesExpression();
		// operandImplies.setOperand1(EcoreUtil.copy(binaryExpression.getOperand1()));
		// operandImplies.setOperand2(EcoreUtil.copy(ifPossibleOperand));
		//
		// binaryString.append(HyVarRecExporter.BRACKETS_OPEN);
		// binaryString.append(handleExpression(operandImplies));
		// binaryString.append(HyVarRecExporter.BRACKETS_CLOSING);
		// }
		//
		// return binaryString.toString();
		// }

		if(!isRootExpression) {
			binaryString.append(HyVarRecExporter.BRACKETS_OPEN);			
		}

		// Simone: patch for n-ary AND and OR
		if (binaryExpression instanceof HyAndExpression) {
			HyExpression expr;
			HyAndExpression andExpr;
			boolean flag = false;
			Stack<HyExpression> elements = new Stack<HyExpression>();
			elements.push(binaryExpression.getOperand1());
			elements.push(binaryExpression.getOperand2());
			while (!elements.empty()) {
				expr = elements.pop();
				if (expr instanceof HyAndExpression) {
					andExpr = (HyAndExpression) expr;
					elements.push(andExpr.getOperand1());
					elements.push(andExpr.getOperand2());
				} else {
					if (flag) {
						binaryString.append(HyVarRecExporter.AND);
					}
					flag = true;
					binaryString.append(handleExpression(expr, false));
				}
			}
		} 
		else if (binaryExpression instanceof HyOrExpression) {
			HyExpression expr;
			HyOrExpression orExpr;
			boolean flag = false;
			Stack<HyExpression> elements = new Stack<HyExpression>();
			elements.push(binaryExpression.getOperand1());
			elements.push(binaryExpression.getOperand2());
			while (!elements.empty()) {
				expr = elements.pop();
				if (expr instanceof HyOrExpression) {
					orExpr = (HyOrExpression) expr;
					elements.push(orExpr.getOperand1());
					elements.push(orExpr.getOperand2());
				} else {
					if (flag) {
						binaryString.append(HyVarRecExporter.OR);
					}
					flag = true;
					binaryString.append(handleExpression(expr, false));
				}
			}
		} else {
			// Simone: end

			binaryString.append(handleExpression(binaryExpression.getOperand1(), false));

			// binaryString.append(" ");
			// if (binaryExpression instanceof HyAndExpression) {
			// binaryString.append(AND);
			// } else if (binaryExpression instanceof HyOrExpression) {
			// binaryString.append(OR);
			// } else if (binaryExpression instanceof HyEquivalenceExpression) {
			if (binaryExpression instanceof HyEquivalenceExpression) {
				binaryString.append(HyVarRecExporter.EQUIVALENCE);
			} else if (binaryExpression instanceof HyImpliesExpression) {
				binaryString.append(HyVarRecExporter.IMPLICATION);
			} 
			// binaryString.append(" ");

			binaryString.append(handleExpression(binaryExpression.getOperand2(), false));

			// Simone: patch for n-ary AND and OR
		}
		// Simone: end
		if(!isRootExpression) {
			binaryString.append(HyVarRecExporter.BRACKETS_CLOSING);			
		}

		return binaryString.toString();
	}

	private String handleUnaryExpression(HyUnaryExpression unaryExpression) {
		StringBuilder unaryString = new StringBuilder();

		boolean nested = false;
		boolean notFeature = false;
		boolean maxOrMin = false;

		if (unaryExpression instanceof HyNotExpression) {
			if (unaryExpression.getOperand() instanceof HyAbstractFeatureReferenceExpression) {
				notFeature = true;
				unaryString.append(handleAtomicExpression(
						(HyAbstractFeatureReferenceExpression) unaryExpression.getOperand(), notFeature));
			} else {
				unaryString.append(HyVarRecExporter.NOT);
				unaryString.append(HyVarRecExporter.BRACKETS_OPEN);
				nested = true;
			}
		} else if (unaryExpression instanceof HyNestedExpression) {
			unaryString.append(HyVarRecExporter.BRACKETS_OPEN);
			nested = true;
		} else if (unaryExpression instanceof HyMaximumExpression) {
			maxOrMin = true;
			unaryString.append(HyVarRecExporter.MAX);
			unaryString.append(HyVarRecExporter.BRACKETS_OPEN);
		} else if (unaryExpression instanceof HyMinimumExpression) {
			maxOrMin = true;
			unaryString.append(HyVarRecExporter.MIN);
			unaryString.append(HyVarRecExporter.BRACKETS_OPEN);
		} 

		// unaryString.append(" ");

		if (!notFeature) {
			unaryString.append(handleExpression(unaryExpression.getOperand(), false));
		}

		if (maxOrMin || nested) {
			unaryString.append(HyVarRecExporter.BRACKETS_CLOSING);
		}

		return unaryString.toString();
	}

	private String handleAtomicExpression(HyAtomicExpression atomicExpression, boolean negated) {
		StringBuilder atomicString = new StringBuilder();

		if (atomicExpression instanceof HyAbstractFeatureReferenceExpression) {
			HyAbstractFeatureReferenceExpression abstractFeatureReferenceExpression = (HyAbstractFeatureReferenceExpression) atomicExpression;
			String featureId = featureIdMapping.get(abstractFeatureReferenceExpression.getFeature());

			if (abstractFeatureReferenceExpression.getVersionRestriction() == null) {

				if(!negated) {
					atomicString.append(featureEncoding.getFeatureSelected(featureId));					
				}
				else {
					atomicString.append(featureEncoding.getFeatureDeselected(featureId));
				}
			} 
			else {
				HyVersionRestriction versionRestriction = abstractFeatureReferenceExpression.getVersionRestriction();

				if (abstractFeatureReferenceExpression instanceof HyConditionalFeatureReferenceExpression) {
					
					if(!negated) {
						atomicString.append(featureEncoding.getFeatureSelected(featureId));					
					}
					else {
						atomicString.append(featureEncoding.getFeatureDeselected(featureId));

					atomicString.append(HyVarRecExporter.IMPLICATION);
					}
					atomicString.append(HyVarRecExporter.BRACKETS_OPEN);
					atomicString.append(handleVersionRangeRestriction(versionRestriction));
					atomicString.append(HyVarRecExporter.BRACKETS_CLOSING);
				} else {
					atomicString.append(handleVersionRangeRestriction(versionRestriction));
				}
			}

		}  else if (atomicExpression instanceof HyArithmeticalComparisonExpression) {
			HyArithmeticalComparisonExpression arithmeticalComparisonExpression = (HyArithmeticalComparisonExpression) atomicExpression;

			atomicString.append(handleArithmeticalValueExpression(arithmeticalComparisonExpression.getOperand1()));

			switch (arithmeticalComparisonExpression.getOperator()) {
			case HY_EQUAL_OPERATOR:
				atomicString.append(HyVarRecExporter.EQUALS);
				break;
			case HY_GREATER_OPERATOR:
				atomicString.append(HyVarRecExporter.GREATER);
				break;
			case HY_GREATER_OR_EQUAL_OPERATOR:
				atomicString.append(HyVarRecExporter.GEQ);
				break;
			case HY_LESS_OPERATOR:
				atomicString.append(HyVarRecExporter.LESS);
				break;
			case HY_LESS_OR_EQUAL_OPERATOR:
				atomicString.append(HyVarRecExporter.LEQ);
				break;
			case HY_NOT_EQUAL_OPERATOR:
				atomicString.append(HyVarRecExporter.NOT_EQUALS);
				break;
			}

			atomicString.append(handleArithmeticalValueExpression(arithmeticalComparisonExpression.getOperand2()));
		}

		return atomicString.toString();
	}

	private String handleValueExpression(HyValueExpression valueExpression) {

		StringBuilder valueString = new StringBuilder(" ");

		HyValue value = valueExpression.getValue();
		if (value instanceof HyNumberValue) {
			valueString.append(((HyNumberValue) value).getValue());
		} else if (value instanceof HyBooleanValue) {
			if (((HyBooleanValue) value).isValue()) {
				valueString.append(HyVarRecExporter.TRUE);
			} else {
				valueString.append(HyVarRecExporter.FALSE);
			}
		} else if (value instanceof HyEnumValue) {
			String enumValueString = "";
			
			HyEnumLiteral literal = ((HyEnumValue) value).getEnumLiteral();
			enumValueString = "" + literal.getValue();
			
			valueString.append(enumValueString);
		} else if (value instanceof HyStringValue) {
			valueString.append("String values not supported!");
		}

		valueString.append(" ");

		return valueString.toString();
	}

	private List<HyVersion> iterateVersionsDownUntil(HyVersion version, HyVersion until) {
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

	private List<HyVersion> iterateVersionsUpUntil(HyVersion version, HyVersion until) {
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

	private String handleVersionRangeRestriction(HyVersionRestriction versionRestriction) {
		StringBuilder versionRestrictionString = new StringBuilder();

		// Assumed addition of versions is possible

		List<HyVersion> validVersions = null;
		if (versionRestriction instanceof HyVersionRangeRestriction) {
			HyVersionRangeRestriction versionRangeRestriction = (HyVersionRangeRestriction) versionRestriction;
			// TODO Only versions in the branch of the upper version? Currently
			// Assumed
			validVersions = iterateVersionsDownUntil(versionRangeRestriction.getUpperVersion(),
					versionRangeRestriction.getLowerVersion());

		} else if (versionRestriction instanceof HyRelativeVersionRestriction) {
			HyRelativeVersionRestriction relativeVersionRestriction = (HyRelativeVersionRestriction) versionRestriction;
			switch (relativeVersionRestriction.getOperator()) {
			case EQUAL:
				validVersions = new ArrayList<HyVersion>();
				validVersions.add(relativeVersionRestriction.getVersion());
				break;
			case GREATER_THAN:
				validVersions = new ArrayList<HyVersion>();
				for (HyVersion version : relativeVersionRestriction.getVersion().getSupersedingVersions()) {
					validVersions.addAll(iterateVersionsUpUntil(version, null));
				}
				break;
			case GREATER_THAN_OR_EQUAL:
				validVersions = iterateVersionsUpUntil(relativeVersionRestriction.getVersion(), null);
				break;
			case IMPLICIT_EQUAL:
				// TODO Dont know what to do her
				validVersions = new ArrayList<HyVersion>();
				break;
			case LESS_THAN:
				validVersions = iterateVersionsDownUntil(relativeVersionRestriction.getVersion().getSupersededVersion(),
						null);
				break;
			case LESS_THAN_OR_EQUAL:
				validVersions = iterateVersionsDownUntil(relativeVersionRestriction.getVersion(), null);
				break;
			default:
				validVersions = new ArrayList<HyVersion>();
				break;
			}
		}

		if (validVersions != null && !validVersions.isEmpty()) {
			if (validVersions.size() > 1) {
				versionRestrictionString.append(HyVarRecExporter.BRACKETS_OPEN);
			}

			boolean first = true;
			for (HyVersion version : validVersions) {
				if (!first) {
					versionRestrictionString.append(HyVarRecExporter.OR);
				} else {
					first = false;
				}
				
				String versionId = versionIdMapping.get(version);
				featureEncoding.getFeatureSelected(versionId);
			}

			if (validVersions.size() > 1) {
				versionRestrictionString.append(HyVarRecExporter.BRACKETS_CLOSING);
			}
		} else {
			System.err.println(
					"Something wrong happened. No valid version for expression available in ContextConstraintExporterJson handleAtomicExpression");
		}

		return versionRestrictionString.toString();
	}



	private String handleArithmeticalValueExpression(HyArithmeticalValueExpression arithmeticalValueExpression) {
		StringBuilder arithmeticalString = new StringBuilder();
		
		if(arithmeticalValueExpression instanceof HyArithmeticalValueUnaryOperationExpression) {
			arithmeticalString.append(handleArithmeticalValueUnaryOperationExpression((HyArithmeticalValueUnaryOperationExpression) arithmeticalValueExpression));
		}
		else if(arithmeticalValueExpression instanceof HyArithmeticalValueAtomicExpression) {
			arithmeticalString.append(handleArithmeticalValueAtomicExpression((HyArithmeticalValueAtomicExpression) arithmeticalValueExpression));
		}
		else if(arithmeticalValueExpression instanceof HyArithmeticalValueBinaryOperationExpression) {
			arithmeticalString.append(handleArithmeticalValueBinaryOperationExpression((HyArithmeticalValueBinaryOperationExpression) arithmeticalValueExpression));
		}
		
		return arithmeticalString.toString();
	}
	
	private String handleArithmeticalValueAtomicExpression(HyArithmeticalValueAtomicExpression arithmeticalAtomicExpression) {

		StringBuilder arithmeticalString = new StringBuilder();
		
		if (arithmeticalAtomicExpression instanceof HyValueExpression) {
			arithmeticalString.append(handleValueExpression((HyValueExpression) arithmeticalAtomicExpression));
		} else if (arithmeticalAtomicExpression instanceof HyAttributeReferenceExpression) {
			HyAttributeReferenceExpression attributeReferenceExpression = (HyAttributeReferenceExpression) arithmeticalAtomicExpression;
			HyFeatureAttribute attribute = attributeReferenceExpression.getAttribute();
			// HyFeature feature = attribute.getFeature();

			String attributeId = attributeIdMapping.get(attribute);

			arithmeticalString.append(attributeId);

		} else if (arithmeticalAtomicExpression instanceof HyContextInformationReferenceExpression) {
			String contextId = contextIdMapping
					.get(((HyContextInformationReferenceExpression) arithmeticalAtomicExpression).getContextInformation());
			arithmeticalString.append(contextId);
		}
		
		return arithmeticalString.toString();
	}
	
	private String handleArithmeticalValueUnaryOperationExpression(HyArithmeticalValueUnaryOperationExpression unaryArithmeticalOperation) {

		StringBuilder arithmeticalString = new StringBuilder();
		
		if(unaryArithmeticalOperation instanceof HyNegationExpression) {
			arithmeticalString.append(HyVarRecExporter.NEGATION);
			arithmeticalString.append(HyVarRecExporter.BRACKETS_OPEN);
			
			arithmeticalString.append(handleArithmeticalValueExpression(unaryArithmeticalOperation.getOperand()));

			arithmeticalString.append(HyVarRecExporter.BRACKETS_CLOSING);
		}
		else if(unaryArithmeticalOperation instanceof HyNestedArithmeticalValueExpression) {
			arithmeticalString.append(HyVarRecExporter.BRACKETS_OPEN);
			
			arithmeticalString.append(handleArithmeticalValueExpression(unaryArithmeticalOperation.getOperand()));

			arithmeticalString.append(HyVarRecExporter.BRACKETS_CLOSING);
		}
		
		return arithmeticalString.toString();
	}
	
	private String handleArithmeticalValueBinaryOperationExpression(HyArithmeticalValueBinaryOperationExpression arithmeticalValueBinaryOperationExpression) {
		StringBuilder binaryString = new StringBuilder();
		
		binaryString.append(handleArithmeticalValueExpression(arithmeticalValueBinaryOperationExpression.getOperand1()));
		
		if (arithmeticalValueBinaryOperationExpression instanceof HyAdditionExpression) {
			binaryString.append(HyVarRecExporter.ADDITION);
		} else if (arithmeticalValueBinaryOperationExpression instanceof HySubtractionExpression) {
			binaryString.append(HyVarRecExporter.SUBTRACTION);
		} else if (arithmeticalValueBinaryOperationExpression instanceof HyMultiplicationExpression) {
			binaryString.append(HyVarRecExporter.MULTIPLICATION);
		} else if (arithmeticalValueBinaryOperationExpression instanceof HyDivisionExpression) {
			binaryString.append(HyVarRecExporter.WHITESPACE);
			binaryString.append("Division is not yet supported!");
			binaryString.append(HyVarRecExporter.WHITESPACE);
		} else if (arithmeticalValueBinaryOperationExpression instanceof HyModuloExpression) {
			binaryString.append(HyVarRecExporter.WHITESPACE);
			binaryString.append("Modulo is not yet supported!");
			binaryString.append(HyVarRecExporter.WHITESPACE);
		}
		
		binaryString.append(handleArithmeticalValueExpression(arithmeticalValueBinaryOperationExpression.getOperand2()));
		
		return binaryString.toString();
	}
	
}
