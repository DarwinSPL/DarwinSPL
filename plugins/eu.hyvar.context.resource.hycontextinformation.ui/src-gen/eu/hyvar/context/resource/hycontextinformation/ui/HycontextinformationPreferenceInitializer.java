/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.ui;

import java.util.Collection;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * This class can be used to initialize default preference values.
 */
public class HycontextinformationPreferenceInitializer extends AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		initializeDefaultsContentAssist();
		
		IPreferenceStore store = eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	protected void initializeDefaultBrackets() {
		IPreferenceStore store = eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationMetaInformation());
	}
	
	protected void initializeDefaultBrackets(IPreferenceStore store, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets
		eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationBracketSet bracketSet = new eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationBracketSet();
		final Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (eu.hyvar.context.resource.hycontextinformation.IHycontextinformationBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside(), bracketPair.isCloseAfterEnter());
			}
		}
		store.setDefault(languageId + eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.serialize());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		IPreferenceStore store = eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationMetaInformation());
	}
	
	protected void initializeDefaultSyntaxHighlighting(IPreferenceStore store, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void initializeDefaultsContentAssist() {
		IPreferenceStore store = eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationUIPlugin.getDefault().getPreferenceStore();
		store.setDefault(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationPreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationPreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED_DEFAULT);
		store.setDefault(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationPreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationPreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY_DEFAULT);
		store.setDefault(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationPreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationPreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS_DEFAULT);
	}
	
	protected void setProperties(IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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

