/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.ui;

import java.util.Collection;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * This class can be used to initialize default preference values.
 */
public class HyconstraintsPreferenceInitializer extends AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		initializeDefaultsContentAssist();
		
		IPreferenceStore store = eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	protected void initializeDefaultBrackets() {
		IPreferenceStore store = eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsMetaInformation());
	}
	
	protected void initializeDefaultBrackets(IPreferenceStore store, eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets
		eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsBracketSet bracketSet = new eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsBracketSet();
		final Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside(), bracketPair.isCloseAfterEnter());
			}
		}
		store.setDefault(languageId + eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.serialize());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		IPreferenceStore store = eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsMetaInformation());
	}
	
	protected void initializeDefaultSyntaxHighlighting(IPreferenceStore store, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void initializeDefaultsContentAssist() {
		IPreferenceStore store = eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsUIPlugin.getDefault().getPreferenceStore();
		store.setDefault(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsPreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED, eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsPreferenceConstants.EDITOR_CONTENT_ASSIST_ENABLED_DEFAULT);
		store.setDefault(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsPreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY, eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsPreferenceConstants.EDITOR_CONTENT_ASSIST_DELAY_DEFAULT);
		store.setDefault(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsPreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS, eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsPreferenceConstants.EDITOR_CONTENT_ASSIST_TRIGGERS_DEFAULT);
	}
	
	protected void setProperties(IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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

