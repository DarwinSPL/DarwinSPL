package eu.hyvar.feature.expression.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.util.EcoreUtil;

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
import eu.hyvar.feature.expression.HyAtomicExpression;
import eu.hyvar.feature.expression.HyAttributeReferenceExpression;
import eu.hyvar.feature.expression.HyBinaryExpression;
import eu.hyvar.feature.expression.HyBooleanValueExpression;
import eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyContextInformationReferenceExpression;
import eu.hyvar.feature.expression.HyDivisionExpression;
import eu.hyvar.feature.expression.HyEqualExpression;
import eu.hyvar.feature.expression.HyEquivalenceExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyGreaterExpression;
import eu.hyvar.feature.expression.HyGreaterOrEqualExpression;
import eu.hyvar.feature.expression.HyIfPossibleExpression;
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
import eu.hyvar.feature.expression.HySetExpression;
import eu.hyvar.feature.expression.HySubtractionExpression;
import eu.hyvar.feature.expression.HyUnaryExpression;
import eu.hyvar.feature.expression.HyValueExpression;
import eu.hyvar.feature.expression.HyVersionRangeRestriction;
import eu.hyvar.feature.expression.HyVersionRestriction;

public class HyExpressionStringExporter {

//	private static final String FEATURE_ATOM = "feature[";
//	private static final String ATTRIBUTE_ATOM = "attribute[";
//	private static final String CONTEXT_ATOM = "context[";

	private static final String EQUALS = " = ";
	private static final String NOT_EQUALS = " != ";
	private static final String GREATER = " > ";
	private static final String LESS = " < ";
	private static final String GEQ = " >= ";
	private static final String LEQ = " <= ";

	private static final String IMPLICATION = " impl ";
	private static final String EQUIVALENCE = " iff ";
	private static final String OR = " or ";
	private static final String XOR = " xor ";
	private static final String AND = " and ";
	private static final String NOT = " not ";

	private static final String MAX = "max";
	private static final String MIN = "min";

	private static final String NEGATION = " - ";
	private static final String ADDITION = " + ";
	private static final String SUBTRACTION = " - ";
	private static final String MULTIPLICATION = " * ";

	private String TRUE = "true";
	private String FALSE = "false";

//	private static final String ARRAY_BRACKETS_OPEN = "[";
//	private static final String ARRAY_BRACKETS_CLOSING = "]";

	private static final String BRACKETS_OPEN = "(";
	private static final String BRACKETS_CLOSING = ")";

	private static final String WHITESPACE = " ";
	
	private Map<HyFeature, String> featureIdMapping;
	private Map<HyVersion, String> versionIdMapping;
	private Map<HyFeatureAttribute, String> attributeIdMapping;
	private Map<HyContextualInformation, String> contextIdMapping;
	
	// TODO default ids and values
	
	public enum BooleanRepresentationOption {
		TRUEFALSE, ONEZERO
	}
	
	public enum FeatureSelectionRepresentationOption {
		PLAIN_BOOLEAN, ONEZERO
	}
	
	private FeatureSelectionRepresentationOption featureSelectionRepresentationOption;
	
	public enum VersionRepresentation {
		AS_ONEZERO_FEATURES, PLAIN
	}
	
	private VersionRepresentation versionRepresentation;
	
	private boolean resolveSetExpression;
	private boolean enumsAsIntValues;
	
	public HyExpressionStringExporter(Map<HyFeature, String> featureIdMapping, Map<HyVersion, String> versionIdMapping, Map<HyFeatureAttribute, String> attributeIdMapping, Map<HyContextualInformation, String> contextIdMapping, BooleanRepresentationOption booleanRepresentationOption, FeatureSelectionRepresentationOption featureSelectionRepresentationOption, VersionRepresentation versionRepresentation, boolean resolveSetExpression, boolean enumsAsIntValues) {
		this.featureIdMapping = featureIdMapping;
		this.versionIdMapping = versionIdMapping;
		this.attributeIdMapping = attributeIdMapping;
		this.contextIdMapping = contextIdMapping;
		
		this.featureSelectionRepresentationOption = featureSelectionRepresentationOption;
		this.versionRepresentation = versionRepresentation;
		this.enumsAsIntValues = enumsAsIntValues;
		
		this.resolveSetExpression = resolveSetExpression;
		
		switch(booleanRepresentationOption) {
		case TRUEFALSE:
			TRUE = "true";
			FALSE = "false";
			break;
		case ONEZERO:
			TRUE = "1";
			FALSE = "0";
			break;
		default:
			TRUE = "true";
			FALSE = "false";
			break;
		}
	}
	
	
	public String exportExpressionToString(HyExpression expression) {		
		return handleExpression(expression);
	}

	private String handleExpression(HyExpression expression) {

		if (expression instanceof HyBinaryExpression) {
			return handleBinaryExpression((HyBinaryExpression) expression);
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

		StringBuilder setString = new StringBuilder("");

		if (setExpression instanceof HyIfPossibleExpression) {

			boolean first = true;

			for (HyExpression operand : setExpression.getOperands()) {
				if (!first) {
					setString.append(ADDITION);
				} else {
					first = false;
				}

				setString.append(BRACKETS_OPEN);
				setString.append(handleExpression(operand));
				setString.append(BRACKETS_CLOSING);
			}
		}

		return setString.toString();
	}
	

	private String handleBinaryExpression(HyBinaryExpression binaryExpression) {
		StringBuilder binaryString = new StringBuilder();

		// TODO sensible?
		// Special case A -> IfPossible(B,C) is syntactic sugar for A -> B + A
		// -> C
		if (resolveSetExpression && binaryExpression instanceof HyImpliesExpression
				&& binaryExpression.getOperand2() instanceof HyIfPossibleExpression) {
			HyIfPossibleExpression ifPossible = (HyIfPossibleExpression) binaryExpression.getOperand2();

			boolean first = true;
			for (HyExpression ifPossibleOperand : ifPossible.getOperands()) {
				if (!first) {
					binaryString.append(ADDITION);
				} else {
					first = false;
				}
				
				HyImpliesExpression operandImplies = HyExpressionFactory.eINSTANCE.createHyImpliesExpression();
				operandImplies.setOperand1(EcoreUtil.copy(binaryExpression.getOperand1()));
				operandImplies.setOperand2(EcoreUtil.copy(ifPossibleOperand));

				binaryString.append(BRACKETS_OPEN);
				binaryString.append(handleExpression(operandImplies));
				binaryString.append(BRACKETS_CLOSING);
			}

			return binaryString.toString();
		}

		binaryString.append(BRACKETS_OPEN);

		
		// Simone: patch for n-ary AND and OR
		if (binaryExpression instanceof HyAndExpression) {
			HyExpression expr;
			HyAndExpression andExpr;
			boolean flag = false;
			Stack<HyExpression> elements = new Stack<HyExpression> ();
			elements.push(binaryExpression.getOperand1());
			elements.push(binaryExpression.getOperand2());
			while (!elements.empty()) {
				expr = elements.pop();
				if (expr instanceof HyAndExpression) {
					andExpr = (HyAndExpression)expr;
					elements.push(andExpr.getOperand1());
					elements.push(andExpr.getOperand2());
				} else {
					if (flag) {
						binaryString.append(AND);
					}
					flag=true;
					binaryString.append(handleExpression(expr));
				}
			}
		} else if (binaryExpression instanceof HyOrExpression) {
			HyExpression expr;
			HyOrExpression orExpr;
			boolean flag = false;
			Stack<HyExpression> elements = new Stack<HyExpression> ();
			elements.push(binaryExpression.getOperand1());
			elements.push(binaryExpression.getOperand2());
			while (!elements.empty()) {
				expr = elements.pop();
				if (expr instanceof HyOrExpression) {
					orExpr = (HyOrExpression)expr;
					elements.push(orExpr.getOperand1());
					elements.push(orExpr.getOperand2());
				} else {
					if (flag) {
						binaryString.append(OR);
					}
					flag=true;
					binaryString.append(handleExpression(expr));
				}
			}
		} else {
		// Simone: end
		
		binaryString.append(handleExpression(binaryExpression.getOperand1()));

		// binaryString.append(" ");
//		if (binaryExpression instanceof HyAndExpression) {
//			binaryString.append(AND);
//		} else if (binaryExpression instanceof HyOrExpression) {
//			binaryString.append(OR);
//		} else if (binaryExpression instanceof HyEquivalenceExpression) {
		if (binaryExpression instanceof HyEquivalenceExpression) {
			binaryString.append(EQUIVALENCE);
		} else if (binaryExpression instanceof HyImpliesExpression) {
			binaryString.append(IMPLICATION);
		} else if (binaryExpression instanceof HyGreaterExpression) {
			binaryString.append(GREATER);
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
		// binaryString.append(" ");

		binaryString.append(handleExpression(binaryExpression.getOperand2()));
		
		// Simone: patch for n-ary AND and OR 
		}
		// Simone: end
		binaryString.append(BRACKETS_CLOSING);
		
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
				unaryString.append(NOT);
			}
		} else if (unaryExpression instanceof HyNestedExpression) {
			unaryString.append(BRACKETS_OPEN);
			nested = true;
		} else if (unaryExpression instanceof HyNegationExpression) {
			unaryString.append(NEGATION);
		} else if (unaryExpression instanceof HyMaximumExpression) {
			maxOrMin = true;
			unaryString.append(MAX);
			unaryString.append(BRACKETS_OPEN);
		} else if (unaryExpression instanceof HyMinimumExpression) {
			maxOrMin = true;
			unaryString.append(MIN);
			unaryString.append(BRACKETS_OPEN);
		}

		// unaryString.append(" ");

		if (!notFeature) {
			unaryString.append(handleExpression(unaryExpression.getOperand()));
		}

		if (maxOrMin || nested) {
			unaryString.append(BRACKETS_CLOSING);
		}

		return unaryString.toString();
	}
	
	private String handleAtomicExpression(HyAtomicExpression atomicExpression, boolean negated) {
		StringBuilder atomicString = new StringBuilder();

//		if (atomicExpression instanceof HyBooleanValueExpression) {
//			if (((HyBooleanValueExpression) atomicExpression).isValue()) {
//				atomicString.append(TRUE);
//			} else {
//				atomicString.append(FALSE);
//			}
//		} else
			if (atomicExpression instanceof HyAbstractFeatureReferenceExpression) {
			HyAbstractFeatureReferenceExpression abstractFeatureReferenceExpression = (HyAbstractFeatureReferenceExpression) atomicExpression;
			String featureId = featureIdMapping.get(abstractFeatureReferenceExpression.getFeature());

			if (abstractFeatureReferenceExpression.getVersionRestriction() == null) {
				
				switch(featureSelectionRepresentationOption) {
				case ONEZERO:
					atomicString.append(featureId);
					atomicString.append(EQUALS);
					if (!negated) {
						atomicString.append("1");
					} else {
						atomicString.append("0");
					}
					break;
				case PLAIN_BOOLEAN:
					if (negated) {
						atomicString.append(WHITESPACE);
						atomicString.append(NOT);
						atomicString.append(WHITESPACE);
					} 
					atomicString.append(featureId);
					break;
				default:
					if (negated) {
						atomicString.append(WHITESPACE);
						atomicString.append(NOT);
						atomicString.append(WHITESPACE);
					} 
					atomicString.append(featureId);
					break;				
				}
				
			} else {
				HyVersionRestriction versionRestriction = abstractFeatureReferenceExpression.getVersionRestriction();

				if (abstractFeatureReferenceExpression instanceof HyConditionalFeatureReferenceExpression) {
					switch(featureSelectionRepresentationOption) {
					case ONEZERO:
						atomicString.append(BRACKETS_OPEN);
						atomicString.append(featureId);
						atomicString.append(EQUALS);
						if (!negated) {
							atomicString.append("1");
						} else {
							atomicString.append("0");
						}
						atomicString.append(IMPLICATION);
						atomicString.append(BRACKETS_OPEN);
						atomicString.append(handleVersionRangeRestriction(versionRestriction));
						atomicString.append(BRACKETS_CLOSING);
						atomicString.append(BRACKETS_CLOSING);
						break;
					case PLAIN_BOOLEAN:
						atomicString.append(" ? ");
						atomicString.append(featureId);
						atomicString.append(handleVersionRangeRestriction(versionRestriction));
						break;
					default:
						atomicString.append(" ? ");
						atomicString.append(featureId);
						atomicString.append(handleVersionRangeRestriction(versionRestriction));
						break;
					}
				} else {
					switch(versionRepresentation) {
					case AS_ONEZERO_FEATURES:
						break;
					case PLAIN:
						atomicString.append(featureId);
						break;
					default:
						atomicString.append(featureId);
						break;
					}
					atomicString.append(handleVersionRangeRestriction(versionRestriction));
				}
			}

		} else if (atomicExpression instanceof HyValueExpression) {
			atomicString.append(handleValueExpression((HyValueExpression) atomicExpression));
		} else if (atomicExpression instanceof HyAttributeReferenceExpression) {
			HyAttributeReferenceExpression attributeReferenceExpression = (HyAttributeReferenceExpression) atomicExpression;
			HyFeatureAttribute attribute = attributeReferenceExpression.getAttribute();
//			HyFeature feature = attribute.getFeature();

			String attributeId = attributeIdMapping.get(attribute);

			atomicString.append(attributeId);

		} else if (atomicExpression instanceof HyContextInformationReferenceExpression) {
			String contextId = contextIdMapping.get(((HyContextInformationReferenceExpression) atomicExpression).getContextInformation());
			atomicString.append(contextId);
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
				valueString.append(TRUE);
			} else {
				valueString.append(FALSE);
			}
		} else if (value instanceof HyEnumValue) {
			String enumValueString = "";
			HyEnumLiteral literal = ((HyEnumValue) value).getEnumLiteral();
			if(enumsAsIntValues) {
				enumValueString = ""+literal.getValue();
			} else {
				enumValueString = literal.getName();
			}
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

		switch(versionRepresentation) {
		case AS_ONEZERO_FEATURES:
			versionRestrictionString.append(handleVersionRestrictionAsOneZeroFeatures(versionRestriction));
			break;
		case PLAIN:
			versionRestrictionString.append(handleVersionRestrictionPlain(versionRestriction));
			break;
		default:
			versionRestrictionString.append(handleVersionRestrictionPlain(versionRestriction));
			break;
		}


		return versionRestrictionString.toString();
	}
	
	private String handleVersionRestrictionPlain(HyVersionRestriction versionRestriction) {
		StringBuilder versionRestrictionString = new StringBuilder();
		versionRestrictionString.append("[");
		if (versionRestriction instanceof HyVersionRangeRestriction) {
			HyVersionRangeRestriction versionRangeRestriction = (HyVersionRangeRestriction) versionRestriction;
			
			String versionIdLower = versionIdMapping.get(versionRangeRestriction.getLowerVersion());
			String versionIdUpper = versionIdMapping.get(versionRangeRestriction.getUpperVersion());
			
			versionRestrictionString.append(versionIdLower);
			versionRestrictionString.append(" - ");
			versionRestrictionString.append(versionIdUpper);
			
		} else if (versionRestriction instanceof HyRelativeVersionRestriction) {
			HyRelativeVersionRestriction relativeVersionRestriction = (HyRelativeVersionRestriction) versionRestriction;
			
			String versionId = versionIdMapping.get(relativeVersionRestriction.getVersion());
			
			switch (relativeVersionRestriction.getOperator()) {
			case EQUAL:
				break;
			case GREATER_THAN:
				versionRestrictionString.append(GREATER);
				break;
			case GREATER_THAN_OR_EQUAL:
				versionRestrictionString.append(GEQ);
				break;
			case IMPLICIT_EQUAL:
				// Dont know what to do here
				break;
			case LESS_THAN:
				versionRestrictionString.append(LESS);
				break;
			case LESS_THAN_OR_EQUAL:
				versionRestrictionString.append(LEQ);
				break;
			default:
				break;
			}
			
			versionRestrictionString.append(versionId);
		}
		
		versionRestrictionString.append("]");
		return versionRestrictionString.toString();
	}
	
	private String handleVersionRestrictionAsOneZeroFeatures(HyVersionRestriction versionRestriction) {
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
				versionRestrictionString.append(BRACKETS_OPEN);
			}

			boolean first = true;
			for (HyVersion version : validVersions) {
				if (!first) {
					 versionRestrictionString.append(ADDITION);
//					atomicString.append(OR);
				} else {
					first = false;
				}
				String versionId = versionIdMapping.get(version);
				versionRestrictionString.append(versionId);
			}

			if (validVersions.size() > 1) {
				versionRestrictionString.append(BRACKETS_CLOSING);
			}
			versionRestrictionString.append(EQUALS);
			versionRestrictionString.append("1");
		} else {
			System.err.println(
					"Something wrong happened. No valid version for expression available in ContextConstraintExporterJson handleAtomicExpression");
		}

		return versionRestrictionString.toString();
	}
}
