SYNTAXDEF dwprofile
FOR <http://darwinspl.de/feature/preferences/1.0>
START DwProfile

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
	
	overrideUIManifest = "false";
}

RULES {
	DwProfile ::= preferences*;

	@SuppressWarnings(explicitSyntaxChoice)
	DwPreference ::= rootExpression ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "eternity" | "eternity" "-" validUntil[DATE])  "]")?;
}
