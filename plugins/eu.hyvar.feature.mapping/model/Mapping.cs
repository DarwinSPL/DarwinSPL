SYNTAXDEF hymapping
FOR <http://hyvar-project.eu/feature/mapping/1.0>
START HyMappingModel

IMPORTS {
	hyexpression : <http://hyvar-project.eu/feature/expression/1.0> WITH SYNTAX expression <../../eu.hyvar.feature.expression/model/Expression.cs>
}

OPTIONS {	
	reloadGeneratorModel = "false";
	usePredefinedTokens = "false";
	
	editorName = "Feature Mapping Editor (HyVar)";
	newFileWizardCategory = "org.hyvar.newwizards.Category";
	newFileWizardName = "HyVar Feature Mapping (*.hymapping)";
	
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	disableBuilder = "true";
	disableNewProjectWizard = "true";
}

RULES {
	//Explicitly allow that there are no mappings, e.g., for generated empty mapping files.
	HyMappingModel ::= (mappings (!0!0 mappings)*)?;
	
	DEDeltaInvokation ::= delta['<','>'];
	
	@SuppressWarnings(explicitSyntaxChoice)
	HyMapping ::= expression #1 ":" !1 deltaInvokations ("," !0 deltaInvokations)* ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "eternity" | "eternity" "-" validUntil[DATE])  "]")?;
}