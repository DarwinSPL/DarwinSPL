/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.ui;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

/**
 * An adapter from the Eclipse
 * <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface to the
 * generated lexer.
 */
public class DwprofileTokenScanner implements de.darwinspl.preferences.resource.dwprofile.ui.IDwprofileTokenScanner {
	
	private de.darwinspl.preferences.resource.dwprofile.IDwprofileTextScanner lexer;
	private de.darwinspl.preferences.resource.dwprofile.IDwprofileTextToken currentToken;
	private List<de.darwinspl.preferences.resource.dwprofile.IDwprofileTextToken> nextTokens;
	private int offset;
	private String languageId;
	private IPreferenceStore store;
	private de.darwinspl.preferences.resource.dwprofile.ui.DwprofileColorManager colorManager;
	private de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource;
	
	/**
	 * <p>
	 * Creates a new DwprofileTokenScanner. Uses the preference store belonging to the
	 * corresponding de.darwinspl.preferences.resource.dwprofile.ui.DwprofileUIPlugin.
	 * </p>
	 * 
	 * @param resource The resource to scan
	 * @param colorManager A manager to obtain color objects
	 */
	public DwprofileTokenScanner(de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileColorManager colorManager) {
		this(resource, colorManager, (de.darwinspl.preferences.resource.dwprofile.ui.DwprofileUIPlugin.getDefault() == null ? null : de.darwinspl.preferences.resource.dwprofile.ui.DwprofileUIPlugin.getDefault().getPreferenceStore()));
	}
	
	/**
	 * <p>
	 * Creates a new DwprofileTokenScanner.
	 * </p>
	 * 
	 * @param resource The resource to scan
	 * @param colorManager A manager to obtain color objects
	 * @param preferenceStore The preference store to retrieve the defined token colors
	 */
	public DwprofileTokenScanner(de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileColorManager colorManager, IPreferenceStore preferenceStore) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileMetaInformation().createLexer();
		this.languageId = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileMetaInformation().getSyntaxName();
		this.store = preferenceStore;
		this.nextTokens = new ArrayList<de.darwinspl.preferences.resource.dwprofile.IDwprofileTextToken>();
	}
	
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	public int getTokenOffset() {
		return offset + currentToken.getOffset();
	}
	
	public IToken nextToken() {
		boolean isOriginalToken = true;
		if (!nextTokens.isEmpty()) {
			currentToken = nextTokens.remove(0);
			isOriginalToken = false;
		} else {
			currentToken = lexer.getNextToken();
		}
		if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
			return Token.EOF;
		}
		
		if (isOriginalToken) {
			splitCurrentToken();
		}
		
		TextAttribute textAttribute = null;
		String tokenName = currentToken.getName();
		if (tokenName != null) {
			de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenStyle staticStyle = getStaticTokenStyle();
			// now call dynamic token styler to allow to apply modifications to the static
			// style
			de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenStyle dynamicStyle = getDynamicTokenStyle(staticStyle);
			if (dynamicStyle != null) {
				textAttribute = getTextAttribute(dynamicStyle);
			}
		}
		
		return new Token(textAttribute);
	}
	
	public void setRange(IDocument document, int offset, int length) {
		this.offset = offset;
		try {
			lexer.setText(document.get(offset, length));
		} catch (BadLocationException e) {
			// ignore this error. It might occur during editing when locations are outdated
			// quickly.
		}
	}
	
	public String getTokenText() {
		return currentToken.getText();
	}
	
	public int[] convertToIntArray(RGB rgb) {
		if (rgb == null) {
			return null;
		}
		return new int[] {rgb.red, rgb.green, rgb.blue};
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenStyle getStaticTokenStyle() {
		String tokenName = currentToken.getName();
		String enableKey = de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.StyleProperty.ENABLE);
		if (store == null) {
			return null;
		}
		
		boolean enabled = store.getBoolean(enableKey);
		if (!enabled) {
			return null;
		}
		
		String colorKey = de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.StyleProperty.COLOR);
		RGB foregroundRGB = PreferenceConverter.getColor(store, colorKey);
		RGB backgroundRGB = null;
		boolean bold = store.getBoolean(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.StyleProperty.BOLD));
		boolean italic = store.getBoolean(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.StyleProperty.ITALIC));
		boolean strikethrough = store.getBoolean(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
		boolean underline = store.getBoolean(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, de.darwinspl.preferences.resource.dwprofile.ui.DwprofileSyntaxColoringHelper.StyleProperty.UNDERLINE));
		return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenStyle getDynamicTokenStyle(de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenStyle staticStyle) {
		de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileDynamicTokenStyler dynamicTokenStyler = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileDynamicTokenStyler();
		dynamicTokenStyler.setOffset(offset);
		de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
		return dynamicStyle;
	}
	
	public TextAttribute getTextAttribute(de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenStyle tokeStyle) {
		int[] foregroundColorArray = tokeStyle.getColorAsRGB();
		Color foregroundColor = null;
		if (colorManager != null) {
			foregroundColor = colorManager.getColor(new RGB(foregroundColorArray[0], foregroundColorArray[1], foregroundColorArray[2]));
		}
		int[] backgroundColorArray = tokeStyle.getBackgroundColorAsRGB();
		Color backgroundColor = null;
		if (backgroundColorArray != null) {
			RGB backgroundRGB = new RGB(backgroundColorArray[0], backgroundColorArray[1], backgroundColorArray[2]);
			if (colorManager != null) {
				backgroundColor = colorManager.getColor(backgroundRGB);
			}
		}
		int style = SWT.NORMAL;
		if (tokeStyle.isBold()) {
			style = style | SWT.BOLD;
		}
		if (tokeStyle.isItalic()) {
			style = style | SWT.ITALIC;
		}
		if (tokeStyle.isStrikethrough()) {
			style = style | TextAttribute.STRIKETHROUGH;
		}
		if (tokeStyle.isUnderline()) {
			style = style | TextAttribute.UNDERLINE;
		}
		return new TextAttribute(foregroundColor, backgroundColor, style);
	}
	
	/**
	 * Tries to split the current token if it contains task items.
	 */
	public void splitCurrentToken() {
		final String text = currentToken.getText();
		final String name = currentToken.getName();
		final int line = currentToken.getLine();
		final int charStart = currentToken.getOffset();
		final int column = currentToken.getColumn();
		
		List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTaskItem> taskItems = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTaskItemDetector().findTaskItems(text, line, charStart);
		
		// this is the offset for the next token to be added
		int offset = charStart;
		int itemBeginRelative;
		List<de.darwinspl.preferences.resource.dwprofile.IDwprofileTextToken> newItems = new ArrayList<de.darwinspl.preferences.resource.dwprofile.IDwprofileTextToken>();
		for (de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTaskItem taskItem : taskItems) {
			int itemBegin = taskItem.getCharStart();
			int itemLine = taskItem.getLine();
			int itemColumn = 0;
			
			itemBeginRelative = itemBegin - charStart;
			// create token before task item
			String textBefore = text.substring(offset - charStart, itemBeginRelative);
			int textBeforeLength = textBefore.length();
			newItems.add(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTextToken(name, textBefore, offset, textBeforeLength, line, column, true));
			
			// create token for the task item itself
			offset = offset + textBeforeLength;
			String itemText = taskItem.getKeyword();
			int itemTextLength = itemText.length();
			newItems.add(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTextToken(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME, itemText, offset, itemTextLength, itemLine, itemColumn, true));
			
			offset = offset + itemTextLength;
		}
		
		if (!taskItems.isEmpty()) {
			// create token after last task item
			String textAfter = text.substring(offset - charStart);
			newItems.add(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTextToken(name, textAfter, offset, textAfter.length(), line, column, true));
		}
		
		if (!newItems.isEmpty()) {
			// replace tokens
			currentToken = newItems.remove(0);
			nextTokens = newItems;
		}
		
	}
}
