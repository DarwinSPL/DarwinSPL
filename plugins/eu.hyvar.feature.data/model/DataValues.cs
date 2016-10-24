SYNTAXDEF hydatavalue
FOR <http://hyvar-project.eu/feature/dataValues/1.0>
START HyValue, HyEnum, HyEnumLiteral

//IMPORTS {
//	evolution : <http://hyvar-project.eu/evolution/1.0> WITH SYNTAX hyevolution <../../eu.hyvar.evolution/model/Evolution.cs>
//}

OPTIONS {
	reloadGeneratorModel = "false";
	usePredefinedTokens = "false";
	
	defaultTokenName = "IDENTIFIER_TOKEN";
	disableNewProjectWizard = "true";
	disableBuilder = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE IDENTIFIER_TOKEN $('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'_'|'0'..'9')* ('@'$ +DATE+ $)?$;
	// FORMAT: YYYY / MM / DD (T hh:mm(:ss)?)?
	DEFINE DATE $($ + INTEGER_LITERAL + $'/'$ + INTEGER_LITERAL + $'/'$ + INTEGER_LITERAL + $( 'T'$ + INTEGER_LITERAL + $':'$ + INTEGER_LITERAL + $(':' $ + INTEGER_LITERAL + $)?$ + $)?)$;
	DEFINE INTEGER_LITERAL $('-')? ('0'..'9')+ $;
	
	
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE ML_COMMENT $'/*'.*'*/'$;
	
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
}

RULES {
	// syntax definition for class 'HyNumberValue'
	@Operator(type="primitive", weight="15", superclass="HyValue")
	HyNumberValue ::= value[INTEGER_LITERAL];
	
	// syntax definition for class 'AnotherMetaClass'
	@Operator(type="primitive", weight="15", superclass="HyValue")
	HyBooleanValue ::= value["true" : "false"];
	
	@SuppressWarnings(minOccurenceMismatch)
	@Operator(type="primitive", weight="15", superclass="HyValue")
	HyEnumValue ::= "enum:"enum[IDENTIFIER_TOKEN] "." enumLiteral[IDENTIFIER_TOKEN];
	
	@SuppressWarnings(explicitSyntaxChoice)
	HyEnum ::= "Enum(" name[IDENTIFIER_TOKEN]"," (literals ("," literals)*)? ")" ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "null" | "null" "-" validUntil[DATE])  "]")?;
	
	@SuppressWarnings(explicitSyntaxChoice)
	HyEnumLiteral ::= "EnumLiteral(" name[IDENTIFIER_TOKEN] "," value[INTEGER_LITERAL] ")" ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "null" | "null" "-" validUntil[DATE])  "]")?;
}
