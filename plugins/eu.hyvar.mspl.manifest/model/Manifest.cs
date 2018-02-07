SYNTAXDEF hymanifest
FOR <http://hyvar-project.eu/mspl/manifest/1.0> <Manifest.genmodel>
START HySPLImplementation, HySPLSignature

IMPORTS {
  hydatavalue : <http://hyvar-project.eu/feature/dataValues/1.0> WITH SYNTAX expression <../../eu.hyvar.feature.data/model/DataValues.cs>	
}

OPTIONS {
	reloadGeneratorModel = "false";
	usePredefinedTokens = "false";
	
	editorName = "Manifest Editor (HyVar)";
	newFileWizardName = "HyVar MSPL Model Constraints (*.hymanifest)";
	
	defaultTokenName = "IDENTIFIER_TOKEN";
	disableNewProjectWizard = "true";
	disableBuilder = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}


TOKENSTYLES  {
	"SL_COMMENT", "ML_COMMENT" COLOR #008000;
	"Implementation", "Signature", ":", "->" COLOR #800040, BOLD;
	"[", "]", "(", ")" COLOR #0000CC;
}

RULES {

	// syntax definition for class 'HySPLSignature'
	HySPLSignature ::= "Signature ";

	// syntax definition for class 'HySPLImplementation'
	HySPLImplementation ::= "Implementation " ("(" dependencies ("," dependencies)* ")")? (":" implementations ("," implementations)* )?  ;

	@SuppressWarnings(explicitSyntaxChoice)
	HyTimedDependencies ::= ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "eternity" | "eternity" "-" validUntil[DATE])  "]")? (alias['"','"'] | alias[]) ":"  signature['<','>'] ;
	
	@SuppressWarnings(explicitSyntaxChoice)
	HyTimedImplementations ::= ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "eternity" | "eternity" "-" validUntil[DATE])  "]")? signature['<','>'] "{" (associations ("," associations)*)? "}";
	
	@SuppressWarnings(explicitSyntaxChoice)
	HyTimedImplementationFeatureLink ::= ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "eternity" | "eternity" "-" validUntil[DATE])  "]")? (local['"','"'] | local[]) "->" (signature['"','"'] | signature[])  ("{" (associations ("," associations)*)? "}")? ;

	@SuppressWarnings(explicitSyntaxChoice)
	HyTimedImplementationFeatureAttributeLink ::= ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "eternity" | "eternity" "-" validUntil[DATE])  "]")? (local['"','"'] | local[]) "->" (signature['"','"'] | signature[]) ;

	@SuppressWarnings(explicitSyntaxChoice)
	HyTimedImplementationEnumLink ::= "enum:" ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "eternity" | "eternity" "-" validUntil[DATE])  "]")? (local['"','"'] | local[]) "->" (signature['"','"'] | signature[]) ("{" (associations ("," associations)*)? "}")? ;

	@SuppressWarnings(explicitSyntaxChoice)
	HyTimedImplementationEnumLiteralLink ::= ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "eternity" | "eternity" "-" validUntil[DATE])  "]")? (local['"','"'] | local[]) "->" (signature['"','"'] | signature[]) ;



}
