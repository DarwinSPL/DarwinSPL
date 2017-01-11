/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.ui;

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
public class HycontextinformationTokenScanner implements eu.hyvar.context.resource.hycontextinformation.ui.IHycontextinformationTokenScanner {
	
	private eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextScanner lexer;
	private eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextToken currentToken;
	private List<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextToken> nextTokens;
	private int offset;
	private String languageId;
	private IPreferenceStore store;
	private eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationColorManager colorManager;
	private eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource resource;
	
	/**
	 * <p>
	 * Creates a new HycontextinformationTokenScanner.
	 * </p>
	 * 
	 * @param resource The resource to scan
	 * @param colorManager A manager to obtain color objects
	 */
	public HycontextinformationTokenScanner(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource resource, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationColorManager colorManager) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationMetaInformation().createLexer();
		this.languageId = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationMetaInformation().getSyntaxName();
		eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationUIPlugin plugin = eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationUIPlugin.getDefault();
		if (plugin != null) {
			this.store = plugin.getPreferenceStore();
		}
		this.nextTokens = new ArrayList<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextToken>();
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
			eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenStyle staticStyle = getStaticTokenStyle();
			// now call dynamic token styler to allow to apply modifications to the static
			// style
			eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenStyle dynamicStyle = getDynamicTokenStyle(staticStyle);
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
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenStyle getStaticTokenStyle() {
		String tokenName = currentToken.getName();
		String enableKey = eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.StyleProperty.ENABLE);
		if (store == null) {
			return null;
		}
		
		boolean enabled = store.getBoolean(enableKey);
		if (!enabled) {
			return null;
		}
		
		String colorKey = eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.StyleProperty.COLOR);
		RGB foregroundRGB = PreferenceConverter.getColor(store, colorKey);
		RGB backgroundRGB = null;
		boolean bold = store.getBoolean(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.StyleProperty.BOLD));
		boolean italic = store.getBoolean(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.StyleProperty.ITALIC));
		boolean strikethrough = store.getBoolean(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
		boolean underline = store.getBoolean(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationSyntaxColoringHelper.StyleProperty.UNDERLINE));
		return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenStyle getDynamicTokenStyle(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenStyle staticStyle) {
		eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationDynamicTokenStyler dynamicTokenStyler = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationDynamicTokenStyler();
		dynamicTokenStyler.setOffset(offset);
		eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
		return dynamicStyle;
	}
	
	public TextAttribute getTextAttribute(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenStyle tokeStyle) {
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
		
		List<eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTaskItem> taskItems = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTaskItemDetector().findTaskItems(text, line, charStart);
		
		// this is the offset for the next token to be added
		int offset = charStart;
		int itemBeginRelative;
		List<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextToken> newItems = new ArrayList<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextToken>();
		for (eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTaskItem taskItem : taskItems) {
			int itemBegin = taskItem.getCharStart();
			int itemLine = taskItem.getLine();
			int itemColumn = 0;
			
			itemBeginRelative = itemBegin - charStart;
			// create token before task item
			String textBefore = text.substring(offset - charStart, itemBeginRelative);
			int textBeforeLength = textBefore.length();
			newItems.add(new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTextToken(name, textBefore, offset, textBeforeLength, line, column, true));
			
			// create token for the task item itself
			offset = offset + textBeforeLength;
			String itemText = taskItem.getKeyword();
			int itemTextLength = itemText.length();
			newItems.add(new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTextToken(eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME, itemText, offset, itemTextLength, itemLine, itemColumn, true));
			
			offset = offset + itemTextLength;
		}
		
		if (!taskItems.isEmpty()) {
			// create token after last task item
			String textAfter = text.substring(offset - charStart);
			newItems.add(new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTextToken(name, textAfter, offset, textAfter.length(), line, column, true));
		}
		
		if (!newItems.isEmpty()) {
			// replace tokens
			currentToken = newItems.remove(0);
			nextTokens = newItems;
		}
		
	}
}
