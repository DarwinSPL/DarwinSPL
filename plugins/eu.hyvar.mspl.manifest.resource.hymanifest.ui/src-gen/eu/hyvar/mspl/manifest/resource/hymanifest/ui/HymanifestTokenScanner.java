/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.ui;

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
public class HymanifestTokenScanner implements eu.hyvar.mspl.manifest.resource.hymanifest.ui.IHymanifestTokenScanner {
	
	private eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextScanner lexer;
	private eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextToken currentToken;
	private List<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextToken> nextTokens;
	private int offset;
	private String languageId;
	private IPreferenceStore store;
	private eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestColorManager colorManager;
	private eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource resource;
	
	/**
	 * <p>
	 * Creates a new HymanifestTokenScanner.
	 * </p>
	 * 
	 * @param resource The resource to scan
	 * @param colorManager A manager to obtain color objects
	 */
	public HymanifestTokenScanner(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource resource, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestColorManager colorManager) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestMetaInformation().createLexer();
		this.languageId = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestMetaInformation().getSyntaxName();
		eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestUIPlugin plugin = eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestUIPlugin.getDefault();
		if (plugin != null) {
			this.store = plugin.getPreferenceStore();
		}
		this.nextTokens = new ArrayList<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextToken>();
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
			eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenStyle staticStyle = getStaticTokenStyle();
			// now call dynamic token styler to allow to apply modifications to the static
			// style
			eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenStyle dynamicStyle = getDynamicTokenStyle(staticStyle);
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
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenStyle getStaticTokenStyle() {
		String tokenName = currentToken.getName();
		String enableKey = eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.StyleProperty.ENABLE);
		if (store == null) {
			return null;
		}
		
		boolean enabled = store.getBoolean(enableKey);
		if (!enabled) {
			return null;
		}
		
		String colorKey = eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.StyleProperty.COLOR);
		RGB foregroundRGB = PreferenceConverter.getColor(store, colorKey);
		RGB backgroundRGB = null;
		boolean bold = store.getBoolean(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.StyleProperty.BOLD));
		boolean italic = store.getBoolean(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.StyleProperty.ITALIC));
		boolean strikethrough = store.getBoolean(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
		boolean underline = store.getBoolean(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestSyntaxColoringHelper.StyleProperty.UNDERLINE));
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenStyle getDynamicTokenStyle(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenStyle staticStyle) {
		eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestDynamicTokenStyler dynamicTokenStyler = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestDynamicTokenStyler();
		dynamicTokenStyler.setOffset(offset);
		eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
		return dynamicStyle;
	}
	
	public TextAttribute getTextAttribute(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenStyle tokeStyle) {
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
		
		List<eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTaskItem> taskItems = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTaskItemDetector().findTaskItems(text, line, charStart);
		
		// this is the offset for the next token to be added
		int offset = charStart;
		int itemBeginRelative;
		List<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextToken> newItems = new ArrayList<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextToken>();
		for (eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTaskItem taskItem : taskItems) {
			int itemBegin = taskItem.getCharStart();
			int itemLine = taskItem.getLine();
			int itemColumn = 0;
			
			itemBeginRelative = itemBegin - charStart;
			// create token before task item
			String textBefore = text.substring(offset - charStart, itemBeginRelative);
			int textBeforeLength = textBefore.length();
			newItems.add(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTextToken(name, textBefore, offset, textBeforeLength, line, column, true));
			
			// create token for the task item itself
			offset = offset + textBeforeLength;
			String itemText = taskItem.getKeyword();
			int itemTextLength = itemText.length();
			newItems.add(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTextToken(eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME, itemText, offset, itemTextLength, itemLine, itemColumn, true));
			
			offset = offset + itemTextLength;
		}
		
		if (!taskItems.isEmpty()) {
			// create token after last task item
			String textAfter = text.substring(offset - charStart);
			newItems.add(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTextToken(name, textAfter, offset, textAfter.length(), line, column, true));
		}
		
		if (!newItems.isEmpty()) {
			// replace tokens
			currentToken = newItems.remove(0);
			nextTokens = newItems;
		}
		
	}
}
