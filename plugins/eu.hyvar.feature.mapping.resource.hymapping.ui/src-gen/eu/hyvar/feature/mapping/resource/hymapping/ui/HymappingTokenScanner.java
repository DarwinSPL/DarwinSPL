/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.ui;

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
public class HymappingTokenScanner implements eu.hyvar.feature.mapping.resource.hymapping.ui.IHymappingTokenScanner {
	
	private eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextScanner lexer;
	private eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextToken currentToken;
	private List<eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextToken> nextTokens;
	private int offset;
	private String languageId;
	private IPreferenceStore store;
	private eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingColorManager colorManager;
	private eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource resource;
	
	/**
	 * <p>
	 * Creates a new HymappingTokenScanner. Uses the preference store belonging to the
	 * corresponding eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingUIPlugin.
	 * </p>
	 * 
	 * @param resource The resource to scan
	 * @param colorManager A manager to obtain color objects
	 */
	public HymappingTokenScanner(eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource resource, eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingColorManager colorManager) {
		this(resource, colorManager, (eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingUIPlugin.getDefault() == null ? null : eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingUIPlugin.getDefault().getPreferenceStore()));
	}
	
	/**
	 * <p>
	 * Creates a new HymappingTokenScanner.
	 * </p>
	 * 
	 * @param resource The resource to scan
	 * @param colorManager A manager to obtain color objects
	 * @param preferenceStore The preference store to retrieve the defined token colors
	 */
	public HymappingTokenScanner(eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource resource, eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingColorManager colorManager, IPreferenceStore preferenceStore) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingMetaInformation().createLexer();
		this.languageId = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingMetaInformation().getSyntaxName();
		this.store = preferenceStore;
		this.nextTokens = new ArrayList<eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextToken>();
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
			eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenStyle staticStyle = getStaticTokenStyle();
			// now call dynamic token styler to allow to apply modifications to the static
			// style
			eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenStyle dynamicStyle = getDynamicTokenStyle(staticStyle);
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
	
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenStyle getStaticTokenStyle() {
		String tokenName = currentToken.getName();
		String enableKey = eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingSyntaxColoringHelper.StyleProperty.ENABLE);
		if (store == null) {
			return null;
		}
		
		boolean enabled = store.getBoolean(enableKey);
		if (!enabled) {
			return null;
		}
		
		String colorKey = eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingSyntaxColoringHelper.StyleProperty.COLOR);
		RGB foregroundRGB = PreferenceConverter.getColor(store, colorKey);
		RGB backgroundRGB = null;
		boolean bold = store.getBoolean(eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingSyntaxColoringHelper.StyleProperty.BOLD));
		boolean italic = store.getBoolean(eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingSyntaxColoringHelper.StyleProperty.ITALIC));
		boolean strikethrough = store.getBoolean(eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
		boolean underline = store.getBoolean(eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingSyntaxColoringHelper.StyleProperty.UNDERLINE));
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenStyle getDynamicTokenStyle(eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenStyle staticStyle) {
		eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingDynamicTokenStyler dynamicTokenStyler = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingDynamicTokenStyler();
		dynamicTokenStyler.setOffset(offset);
		eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
		return dynamicStyle;
	}
	
	public TextAttribute getTextAttribute(eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenStyle tokeStyle) {
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
		
		List<eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTaskItem> taskItems = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTaskItemDetector().findTaskItems(text, line, charStart);
		
		// this is the offset for the next token to be added
		int offset = charStart;
		int itemBeginRelative;
		List<eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextToken> newItems = new ArrayList<eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextToken>();
		for (eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTaskItem taskItem : taskItems) {
			int itemBegin = taskItem.getCharStart();
			int itemLine = taskItem.getLine();
			int itemColumn = 0;
			
			itemBeginRelative = itemBegin - charStart;
			// create token before task item
			String textBefore = text.substring(offset - charStart, itemBeginRelative);
			int textBeforeLength = textBefore.length();
			newItems.add(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTextToken(name, textBefore, offset, textBeforeLength, line, column, true));
			
			// create token for the task item itself
			offset = offset + textBeforeLength;
			String itemText = taskItem.getKeyword();
			int itemTextLength = itemText.length();
			newItems.add(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTextToken(eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME, itemText, offset, itemTextLength, itemLine, itemColumn, true));
			
			offset = offset + itemTextLength;
		}
		
		if (!taskItems.isEmpty()) {
			// create token after last task item
			String textAfter = text.substring(offset - charStart);
			newItems.add(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTextToken(name, textAfter, offset, textAfter.length(), line, column, true));
		}
		
		if (!newItems.isEmpty()) {
			// replace tokens
			currentToken = newItems.remove(0);
			nextTokens = newItems;
		}
		
	}
}
