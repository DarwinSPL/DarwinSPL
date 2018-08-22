/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.ui;

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
public class HydatavalueTokenScanner implements eu.hyvar.dataValues.resource.hydatavalue.ui.IHydatavalueTokenScanner {
	
	private eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextScanner lexer;
	private eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextToken currentToken;
	private List<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextToken> nextTokens;
	private int offset;
	private String languageId;
	private IPreferenceStore store;
	private eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueColorManager colorManager;
	private eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource resource;
	
	/**
	 * <p>
	 * Creates a new HydatavalueTokenScanner. Uses the preference store belonging to
	 * the corresponding
	 * eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueUIPlugin.
	 * </p>
	 * 
	 * @param resource The resource to scan
	 * @param colorManager A manager to obtain color objects
	 */
	public HydatavalueTokenScanner(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource resource, eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueColorManager colorManager) {
		this(resource, colorManager, (eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueUIPlugin.getDefault() == null ? null : eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueUIPlugin.getDefault().getPreferenceStore()));
	}
	
	/**
	 * <p>
	 * Creates a new HydatavalueTokenScanner.
	 * </p>
	 * 
	 * @param resource The resource to scan
	 * @param colorManager A manager to obtain color objects
	 * @param preferenceStore The preference store to retrieve the defined token colors
	 */
	public HydatavalueTokenScanner(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource resource, eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueColorManager colorManager, IPreferenceStore preferenceStore) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueMetaInformation().createLexer();
		this.languageId = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueMetaInformation().getSyntaxName();
		this.store = preferenceStore;
		this.nextTokens = new ArrayList<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextToken>();
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
			eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenStyle staticStyle = getStaticTokenStyle();
			// now call dynamic token styler to allow to apply modifications to the static
			// style
			eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenStyle dynamicStyle = getDynamicTokenStyle(staticStyle);
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
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenStyle getStaticTokenStyle() {
		String tokenName = currentToken.getName();
		String enableKey = eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueSyntaxColoringHelper.StyleProperty.ENABLE);
		if (store == null) {
			return null;
		}
		
		boolean enabled = store.getBoolean(enableKey);
		if (!enabled) {
			return null;
		}
		
		String colorKey = eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueSyntaxColoringHelper.StyleProperty.COLOR);
		RGB foregroundRGB = PreferenceConverter.getColor(store, colorKey);
		RGB backgroundRGB = null;
		boolean bold = store.getBoolean(eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueSyntaxColoringHelper.StyleProperty.BOLD));
		boolean italic = store.getBoolean(eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueSyntaxColoringHelper.StyleProperty.ITALIC));
		boolean strikethrough = store.getBoolean(eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
		boolean underline = store.getBoolean(eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueSyntaxColoringHelper.StyleProperty.UNDERLINE));
		return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenStyle getDynamicTokenStyle(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenStyle staticStyle) {
		eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueDynamicTokenStyler dynamicTokenStyler = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueDynamicTokenStyler();
		dynamicTokenStyler.setOffset(offset);
		eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
		return dynamicStyle;
	}
	
	public TextAttribute getTextAttribute(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenStyle tokeStyle) {
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
		
		List<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTaskItem> taskItems = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTaskItemDetector().findTaskItems(text, line, charStart);
		
		// this is the offset for the next token to be added
		int offset = charStart;
		int itemBeginRelative;
		List<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextToken> newItems = new ArrayList<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextToken>();
		for (eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTaskItem taskItem : taskItems) {
			int itemBegin = taskItem.getCharStart();
			int itemLine = taskItem.getLine();
			int itemColumn = 0;
			
			itemBeginRelative = itemBegin - charStart;
			// create token before task item
			String textBefore = text.substring(offset - charStart, itemBeginRelative);
			int textBeforeLength = textBefore.length();
			newItems.add(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTextToken(name, textBefore, offset, textBeforeLength, line, column, true));
			
			// create token for the task item itself
			offset = offset + textBeforeLength;
			String itemText = taskItem.getKeyword();
			int itemTextLength = itemText.length();
			newItems.add(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTextToken(eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME, itemText, offset, itemTextLength, itemLine, itemColumn, true));
			
			offset = offset + itemTextLength;
		}
		
		if (!taskItems.isEmpty()) {
			// create token after last task item
			String textAfter = text.substring(offset - charStart);
			newItems.add(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTextToken(name, textAfter, offset, textAfter.length(), line, column, true));
		}
		
		if (!newItems.isEmpty()) {
			// replace tokens
			currentToken = newItems.remove(0);
			nextTokens = newItems;
		}
		
	}
}
