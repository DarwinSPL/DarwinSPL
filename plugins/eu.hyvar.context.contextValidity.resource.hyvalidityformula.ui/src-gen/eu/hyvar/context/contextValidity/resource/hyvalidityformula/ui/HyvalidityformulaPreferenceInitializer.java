/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui;

import java.util.Collection;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * This class can be used to initialize default preference values.
 */
public class HyvalidityformulaPreferenceInitializer extends AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		initializeDefaultsContentAssist();
		
		IPreferenceStore store = eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	protected void initializeDefaultBrackets() {
		IPreferenceStore store = eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaMetaInformation());
	}
	
	protected void initializeDefaultBrackets(IPreferenceStore store, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaBracketSet bracketSet = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaBracketSet();
		final Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside(), bracketPair.isCloseAfterEnter());
			}
		}
		store.setDefault(languageId + eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.serialize());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		IPreferenceStore store = eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaMetaInformation());
	}
	
	protected void initializeDefaultSyntaxHighlighting(IPreferenceStore store, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void initializeDefaultsContentAssist() {
		IPreferenceStore store = eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaUIPlugin.getDefault().getPreferenceStore();
		store.setDefault(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaPreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaPreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED_DEFAULT);
		store.setDefault(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaPreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaPreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY_DEFAULT);
		store.setDefault(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaPreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaPreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS_DEFAULT);
	}
	
	protected void setProperties(IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	protected String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
	
}

