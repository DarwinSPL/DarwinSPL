SYNTAXDEF hyconstraints
FOR <http://hyvar-project.eu/feature/constraint/1.0>
START HyConstraintModel

IMPORTS {
	hyexpression : <http://hyvar-project.eu/feature/expression/1.0> WITH SYNTAX expression <../../eu.hyvar.feature.expression/model/Expression.cs>
}

OPTIONS {
	reloadGeneratorModel = "false";
	usePredefinedTokens = "false";
	
	editorName = "Constraints Editor (HyVar)";
	newFileWizardCategory = "eu.hyvar.newwizards.Category";
	newFileWizardName = "HyVar Feature Model Constraints (*.hyconstraints)";
	
	disableNewProjectWizard = "true";
	disableBuilder = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

RULES {
	HyConstraintModel ::= constraints*;

	@SuppressWarnings(explicitSyntaxChoice)
	HyConstraint ::= rootExpression ("[" (validSince[DATE] "-" validUntil[DATE] | validSince[DATE] "-" "eternity" | "eternity" "-" validUntil[DATE])  "]")?;
}
