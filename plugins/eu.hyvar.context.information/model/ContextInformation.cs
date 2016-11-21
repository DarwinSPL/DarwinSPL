SYNTAXDEF hycontextinformation
FOR <http://hyvar-project.eu/feature/context/1.0>
START HyContextModel

IMPORTS {
	hydatavalue : <http://hyvar-project.eu/feature/dataValues/1.0> WITH SYNTAX expression <../../eu.hyvar.feature.data/model/DataValues.cs>
}

OPTIONS {
	reloadGeneratorModel = "false";
	usePredefinedTokens = "false";
//	
//	defaultTokenName = "IDENTIFIER_TOKEN";
	disableNewProjectWizard = "true";
	disableBuilder = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	
	editorName = "Contextual Information Editor (HyVar)";
	newFileWizardCategory = "eu.hyvar.newwizards.Category";
	newFileWizardName = "HyVar Contextual Information (*.hycontextinformation)";
}


RULES {
	// syntax definition for class 'HyContextModel'
	HyContextModel ::= enums* contextualInformations*;
	
	
	HyContextualInformationNumber ::= "NumberContext(" name[IDENTIFIER_TOKEN] "," min[INTEGER_LITERAL] "," max[INTEGER_LITERAL]  ")" ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "eternity" | "eternity" "-" validUntil[DATE])  "]")?; 
	
	HyContextualInformationBoolean ::= "BooleanContext(" name[IDENTIFIER_TOKEN] ")" ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "eternity" | "eternity" "-" validUntil[DATE])  "]")?;
	
	HyContextualInformationEnum ::= "EnumContext(" name[IDENTIFIER_TOKEN] "," enumType[IDENTIFIER_TOKEN] ")" ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "eternity" | "eternity" "-" validUntil[DATE])  "]")?;
}
