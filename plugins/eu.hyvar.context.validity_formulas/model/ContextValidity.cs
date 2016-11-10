SYNTAXDEF hyvalidityformula
FOR <http://hyvar-project.eu/context/validity/1.0>
START HyValidityModel

IMPORTS {
	hyexpression : <http://hyvar-project.eu/feature/expression/1.0> WITH SYNTAX expression <../../eu.hyvar.feature.expression/model/Expression.cs>
}

OPTIONS {
	reloadGeneratorModel = "false";
	usePredefinedTokens = "false";
	
	defaultTokenName = "IDENTIFIER_TOKEN";
	disableNewProjectWizard = "true";
	disableBuilder = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	
	editorName = "Validity Formula Editor (HyVar)";
	newFileWizardCategory = "eu.hyvar.newwizards.Category";
	newFileWizardName = "HyVar Validity Formulas (*.hyvalidityformula)";
}

RULES {
	// syntax definition for class 'HyValidityModel'
	HyValidityModel ::= validityFormulas*;
	
	@SuppressWarnings(explicitSyntaxChoice)
	@Operator(type="primitive", weight="15", superclass="HyValidityFormula")
	HyFeatureValidityFormula ::= (feature['"', '"'] | feature[]) ":" validityFormula ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "eternity" | "eternity" "-" validUntil[DATE])  "]")?;
	
//	@Operator(type="primitive",  weight="15", superclass="HyValidityFormula")
//	HyAttributeValidityFormula ::= attribute[] ":" validityFormula ;
	
//	("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "null" | "null" "-" validUntil[DATE])  "]")?
	@SuppressWarnings(explicitSyntaxChoice)
	@SuppressWarnings(minOccurenceMismatch)
	@Operator(type="primitive",  weight="15", superclass="HyValidityFormula")
	HyAttributeValidityFormula ::= (feature['"', '"'] | feature[]) "." attribute[] ":" validityFormula ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "eternity" | "eternity" "-" validUntil[DATE])  "]")?;
}
