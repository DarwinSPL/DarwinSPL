SYNTAXDEF hymanifest
FOR <http://hyvar-project.eu/mspl/manifest/1.0> <Manifest.genmodel>
START HySPLImplementation, HySPLSignature

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
}


TOKENSTYLES  {
	"SL_COMMENT", "ML_COMMENT" COLOR #008000;
		
	"Implementation", "Signature", ":", "->" COLOR #800040, BOLD;
	
	"[", "]", "(", ")" COLOR #0000CC;
}

RULES {
	// syntax definition for class 'HySPLImplementation'
	HySPLImplementation ::= "Implementation "  names ("," names)*  ("(" dependencies ("," dependencies)* ")")? (":" implementations ("," implementations)* )?  ;
	HyTimedDependencies ::= signature['<','>'] ("@[" validSince[DATE] "-" validUntil[DATE] "]")? ;
	HyTimedImplementations ::= signature['<','>'] ("@[" validSince[DATE] "-" validUntil[DATE] "]")? "{" (associations ("," associations)*)? "}";
	
	@SuppressWarnings(explicitSyntaxChoice)
	HyTimedImplementationLink ::= (local['"','"'] | local[]) "->" (signature['"','"'] | signature[]) ("@[" validSince[DATE] "-" validUntil[DATE] "]")?;

	// syntax definition for class 'HySPLSignature'
	HySPLSignature ::= "Signature "  names ("," names)* ;

	@SuppressWarnings(featureWithoutSyntax) 
	HyName ::= name[IDENTIFIER_TOKEN] ("@[" validSince[DATE] "-" validUntil[DATE] "]")? ;
}
