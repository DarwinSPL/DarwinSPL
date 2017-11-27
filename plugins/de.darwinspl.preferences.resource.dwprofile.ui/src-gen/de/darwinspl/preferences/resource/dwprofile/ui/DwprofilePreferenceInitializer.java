/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.ui;

import java.util.Collection;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * This class can be used to initialize default preference values.
 */
public class DwprofilePreferenceInitializer extends AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		initializeDefaultsContentAssist();
		
		IPreferenceStore store = de.darwinspl.preferences.resource.dwprofile.ui.DwprofileUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(de.darwinspl.preferences.resource.dwprofile.ui.DwprofilePreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(de.darwinspl.preferences.resource.dwprofile.ui.DwprofilePreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	protected void initializeDefaultBrackets() {
		IPreferenceStore store = de.darwinspl.preferences.resource.dwprofile.ui.DwprofileUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileMetaInformation());
	}
	
	protected void initializeDefaultBrackets(IPreferenceStore store, de.darwinspl.preferences.resource.dwprofile.IDwprofileMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets
		de.darwinspl.preferences.resource.dwprofile.ui.DwprofileBracketSet bracketSet = new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileBracketSet();
		final Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (de.darwinspl.preferences.resource.dwprofile.IDwprofileBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside(), bracketPair.isCloseAfterEnter());
			}
		}
		store.setDefault(languageId + de.darwinspl.preferences.resource.dwprofile.ui.DwprofilePreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.serialize());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		IPreferenceStore store = de.darwinspl.preferences.resource.dwprofile.ui.DwprofileUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileMetaInformation());
	}
	
	protected void initializeDefaultSyntaxHighlighting(IPreferenceStore store, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void initializeDefaultsContentAssist() {
		IPreferenceStore store = de.darwinspl.preferences.resource.dwprofile.ui.DwprofileUIPlugin.getDefault().getPreferenceStore();
		store.setDefault(de.darwinspl.preferences.resource.dwprofile.ui.DwprofilePreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED, de.darwinspl.preferences.resource.dwprofile.ui.DwprofilePreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED_DEFAULT);
		store.setDefault(de.darwinspl.preferences.resource.dwprofile.ui.DwprofilePreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY, de.darwinspl.preferences.resource.dwprofile.ui.DwprofilePreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY_DEFAULT);
		store.setDefault(de.darwinspl.preferences.resource.dwprofile.ui.DwprofilePreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS, de.darwinspl.preferences.resource.dwprofile.ui.DwprofilePreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS_DEFAULT);
	}
	
	protected void setProperties(IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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

