/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui;

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
public class HyvalidityformulaTokenScanner implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.IHyvalidityformulaTokenScanner {
	
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextScanner lexer;
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextToken currentToken;
	private List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextToken> nextTokens;
	private int offset;
	private String languageId;
	private IPreferenceStore store;
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaColorManager colorManager;
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource resource;
	
	/**
	 * <p>
	 * Creates a new HyvalidityformulaTokenScanner.
	 * </p>
	 * 
	 * @param resource The resource to scan
	 * @param colorManager A manager to obtain color objects
	 */
	public HyvalidityformulaTokenScanner(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource resource, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaColorManager colorManager) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaMetaInformation().createLexer();
		this.languageId = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaMetaInformation().getSyntaxName();
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaUIPlugin plugin = eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaUIPlugin.getDefault();
		if (plugin != null) {
			this.store = plugin.getPreferenceStore();
		}
		this.nextTokens = new ArrayList<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextToken>();
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
			eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenStyle staticStyle = getStaticTokenStyle();
			// now call dynamic token styler to allow to apply modifications to the static
			// style
			eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenStyle dynamicStyle = getDynamicTokenStyle(staticStyle);
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
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenStyle getStaticTokenStyle() {
		String tokenName = currentToken.getName();
		String enableKey = eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.StyleProperty.ENABLE);
		if (store == null) {
			return null;
		}
		
		boolean enabled = store.getBoolean(enableKey);
		if (!enabled) {
			return null;
		}
		
		String colorKey = eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.StyleProperty.COLOR);
		RGB foregroundRGB = PreferenceConverter.getColor(store, colorKey);
		RGB backgroundRGB = null;
		boolean bold = store.getBoolean(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.StyleProperty.BOLD));
		boolean italic = store.getBoolean(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.StyleProperty.ITALIC));
		boolean strikethrough = store.getBoolean(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
		boolean underline = store.getBoolean(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaSyntaxColoringHelper.StyleProperty.UNDERLINE));
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenStyle getDynamicTokenStyle(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenStyle staticStyle) {
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaDynamicTokenStyler dynamicTokenStyler = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaDynamicTokenStyler();
		dynamicTokenStyler.setOffset(offset);
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
		return dynamicStyle;
	}
	
	public TextAttribute getTextAttribute(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenStyle tokeStyle) {
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
		
		List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTaskItem> taskItems = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTaskItemDetector().findTaskItems(text, line, charStart);
		
		// this is the offset for the next token to be added
		int offset = charStart;
		int itemBeginRelative;
		List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextToken> newItems = new ArrayList<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextToken>();
		for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTaskItem taskItem : taskItems) {
			int itemBegin = taskItem.getCharStart();
			int itemLine = taskItem.getLine();
			int itemColumn = 0;
			
			itemBeginRelative = itemBegin - charStart;
			// create token before task item
			String textBefore = text.substring(offset - charStart, itemBeginRelative);
			int textBeforeLength = textBefore.length();
			newItems.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTextToken(name, textBefore, offset, textBeforeLength, line, column, true));
			
			// create token for the task item itself
			offset = offset + textBeforeLength;
			String itemText = taskItem.getKeyword();
			int itemTextLength = itemText.length();
			newItems.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTextToken(eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME, itemText, offset, itemTextLength, itemLine, itemColumn, true));
			
			offset = offset + itemTextLength;
		}
		
		if (!taskItems.isEmpty()) {
			// create token after last task item
			String textAfter = text.substring(offset - charStart);
			newItems.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTextToken(name, textAfter, offset, textAfter.length(), line, column, true));
		}
		
		if (!newItems.isEmpty()) {
			// replace tokens
			currentToken = newItems.remove(0);
			nextTokens = newItems;
		}
		
	}
}
