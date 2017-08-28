/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.ui;

import java.util.Collection;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * This class can be used to initialize default preference values.
 */
public class HymanifestPreferenceInitializer extends AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		initializeDefaultsContentAssist();
		
		IPreferenceStore store = eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	protected void initializeDefaultBrackets() {
		IPreferenceStore store = eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestMetaInformation());
	}
	
	protected void initializeDefaultBrackets(IPreferenceStore store, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets
		eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestBracketSet bracketSet = new eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestBracketSet();
		final Collection<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside(), bracketPair.isCloseAfterEnter());
			}
		}
		store.setDefault(languageId + eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.serialize());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		IPreferenceStore store = eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestMetaInformation());
	}
	
	protected void initializeDefaultSyntaxHighlighting(IPreferenceStore store, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void initializeDefaultsContentAssist() {
		IPreferenceStore store = eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestUIPlugin.getDefault().getPreferenceStore();
		store.setDefault(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestPreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestPreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED_DEFAULT);
		store.setDefault(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestPreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestPreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY_DEFAULT);
		store.setDefault(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestPreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestPreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS_DEFAULT);
	}
	
	protected void setProperties(IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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

