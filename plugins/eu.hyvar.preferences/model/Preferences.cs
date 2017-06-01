SYNTAXDEF dwprofile
FOR <http://hyvar-project.eu/feature/preferences/1.0>
START HyProfile

IMPORTS {
	hyexpression : <http://hyvar-project.eu/feature/expression/1.0> WITH SYNTAX expression <../../eu.hyvar.feature.expression/model/Expression.cs>
}

OPTIONS {
	reloadGeneratorModel = "false";
	usePredefinedTokens = "false";
	
	editorName = "Profile Editor (DarwinSPL)";
	newFileWizardCategory = "de.darwinspl.wizards";
	newFileWizardName = "DarwinSPL Profile (*.dwprofile)";
	
	disableNewProjectWizard = "true";
	disableBuilder = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

RULES {
	HyProfile ::= preferences*;

	@SuppressWarnings(explicitSyntaxChoice)
	HyPreference ::= rootExpression ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "eternity" | "eternity" "-" validUntil[DATE])  "]")?;
}
