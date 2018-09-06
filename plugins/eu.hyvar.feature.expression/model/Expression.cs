SYNTAXDEF hyexpression
FOR <http://hyvar-project.eu/feature/expression/1.0> <Expression.genmodel>
START HyExpression

IMPORTS {
	hydatavalue : <http://hyvar-project.eu/feature/dataValues/1.0> WITH SYNTAX expression <../../eu.hyvar.feature.data/model/DataValues.cs>
}

OPTIONS {
	reloadGeneratorModel = "false";
	usePredefinedTokens = "false";
	
	defaultTokenName = "IDENTIFIER_TOKEN";
	disableNewProjectWizard = "true";
	disableBuilder = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	
//	autofixSimpleLeftrecursion = "true";
}

//TOKENS {
//	DEFINE IDENTIFIER_TOKEN $('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'_'|'0'..'9')*$;
//	
//	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
//	DEFINE ML_COMMENT $'/*'.*'*/'$;
//	
//	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;
//	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
//}

TOKENSTYLES  {
	"SL_COMMENT", "ML_COMMENT" COLOR #008000;
		
	"<->", "->", "||", "&&", "!", "/", "*", "%", "+", "-" COLOR #800040, BOLD;
	
	//"^" COLOR #800040, BOLD;
	"?" COLOR #800040, BOLD;
	
	"<", "<=", "=", ">", ">=" COLOR #800040, BOLD;
	"[", "]", "(", ")" COLOR #0000CC;
}

RULES {	
	@Operator(type="binary_left_associative",  weight="0", superclass="HyExpression")
	HyEquivalenceExpression ::= operand1 "<->" operand2;
	
	@Operator(type="binary_left_associative", weight="1", superclass="HyExpression")
	HyImpliesExpression ::= operand1 "->" operand2;
	
	@Operator(type="binary_left_associative", weight="2", superclass="HyExpression")
	HyOrExpression ::= operand1 "||" operand2;
	
	@Operator(type="binary_left_associative", weight="3", superclass="HyExpression")
	HyAndExpression ::= operand1 "&&" operand2;
	
	@Operator(type="unary_prefix", weight="14", superclass="HyExpression")
	HyNotExpression ::= "!" operand;
	
	@Operator(type="primitive", weight="15", superclass="HyExpression")
	HyNestedExpression ::= "(" operand ")";
	
	@SuppressWarnings(explicitSyntaxChoice)
	@Operator(type="primitive", weight="15", superclass="HyExpression")
	HyFeatureReferenceExpression ::= (feature['"', '"'] | feature[]) (versionRestriction)?;
	
	@SuppressWarnings(explicitSyntaxChoice)
	@SuppressWarnings(minOccurenceMismatch)
	@Operator(type="primitive", weight="15", superclass="HyExpression")
	HyConditionalFeatureReferenceExpression ::= "?" (feature['"', '"'] | feature[]) versionRestriction;	
	
	@Operator(type="primitive", weight="15", superclass="HyExpression")
	HyBooleanValueExpression ::= value["true" : "false"];
	
//	@Operator(type="primitive", weight="15", superclass="HyExpression")
//	HyMinimumExpression ::= "min(" operand ")";
//	
//	@Operator(type="primitive", weight="15", superclass="HyExpression")
//	HyMaximumExpression ::= "max(" operand ")";
//	
//	@Operator(type="primitive", weight="15", superclass="HyExpression")
//	HyIfPossibleExpression ::= "ifPossible(" operands ("," operands)* ")";
	
	@SuppressWarnings(explicitSyntaxChoice)
	@Operator(type="primitive", weight="15", superclass="HyExpression")
	HyArithmeticalComparisonExpression ::= "{" operand1 operator[HyLessOperator : "<", HyLessOrEqualOperator : "<=", HyEqualOperator : "=", HyNotEqualOperator : "!=", HyGreaterOrEqualOperator : ">=", HyGreaterOperator : ">"] operand2 "}";
	
	
	@Operator(type="binary_left_associative", weight="5", superclass="HyArithmeticalValueExpression")
	HyAdditionExpression ::= operand1 "+" operand2;
	
	@Operator(type="binary_left_associative", weight="6", superclass="HyArithmeticalValueExpression")
	HySubtractionExpression ::= operand1 "-" operand2;
	
	@Operator(type="binary_left_associative", weight="4", superclass="HyArithmeticalValueExpression")
	HyModuloExpression ::= operand1 "%" operand2;
	
	@Operator(type="binary_left_associative", weight="7", superclass="HyArithmeticalValueExpression")
	HyMultiplicationExpression ::= operand1 "*" operand2;
	
	@Operator(type="binary_left_associative", weight="8", superclass="HyArithmeticalValueExpression")
	HyDivisionExpression ::= operand1 "/" operand2;
	
	@Operator(type="unary_prefix", weight="14", superclass="HyArithmeticalValueExpression")
	HyNegationExpression ::= "-" operand;
	
	@Operator(type="primitive", weight="15", superclass="HyArithmeticalValueExpression")
	HyNestedArithmeticalValueExpression ::= "(" operand ")";
	
	@SuppressWarnings(explicitSyntaxChoice)
	@SuppressWarnings(minOccurenceMismatch)
	@Operator(type="primitive", weight="11", superclass="HyArithmeticalValueExpression")
	HyAttributeReferenceExpression ::= (feature['"', '"'] | feature[]) "." attribute[];
	
	@SuppressWarnings(explicitSyntaxChoice)
	@Operator(type="primitive", weight="12", superclass="HyArithmeticalValueExpression")
	HyContextInformationReferenceExpression ::= (contextInformation['"', '"'] | contextInformation[]);
	
	@Operator(type="primitive", weight="13", superclass="HyArithmeticalValueExpression")
	HyValueExpression ::= value;
	
	HyRelativeVersionRestriction ::= "[" operator[lessThan : "<", lessThanOrEqual : "<=", equal : "=", implicitEqual : "", greaterThanOrEqual : ">=", greaterThan : ">"] version['"','"'] "]";
	HyVersionRangeRestriction ::= "[" lowerIncluded["" : "^"] lowerVersion['"','"'] "-" upperIncluded["" : "^"] upperVersion['"','"'] "]";
}
