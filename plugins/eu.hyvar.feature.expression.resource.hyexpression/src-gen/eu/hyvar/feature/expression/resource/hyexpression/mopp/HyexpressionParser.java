// $ANTLR 3.4

	package eu.hyvar.feature.expression.resource.hyexpression.mopp;
	
	import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.antlr.runtime3_4_0.ANTLRInputStream;
import org.antlr.runtime3_4_0.BitSet;
import org.antlr.runtime3_4_0.CommonToken;
import org.antlr.runtime3_4_0.CommonTokenStream;
import org.antlr.runtime3_4_0.IntStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.RecognitionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class HyexpressionParser extends HyexpressionANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DATE", "IDENTIFIER_TOKEN", "INTEGER_LITERAL", "LINEBREAK", "ML_COMMENT", "QUOTED_34_34", "SL_COMMENT", "WHITESPACE", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'->'", "'.'", "'/'", "'<'", "'<->'", "'<='", "'='", "'>'", "'>='", "'?'", "'Enum('", "'EnumLiteral('", "'['", "'\\u0025'", "']'", "'^'", "'context:'", "'enum:'", "'false'", "'ifPossible('", "'max('", "'min('", "'null'", "'true'", "'||'"
    };

    public static final int EOF=-1;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int DATE=4;
    public static final int IDENTIFIER_TOKEN=5;
    public static final int INTEGER_LITERAL=6;
    public static final int LINEBREAK=7;
    public static final int ML_COMMENT=8;
    public static final int QUOTED_34_34=9;
    public static final int SL_COMMENT=10;
    public static final int WHITESPACE=11;

    // delegates
    public HyexpressionANTLRParserBase[] getDelegates() {
        return new HyexpressionANTLRParserBase[] {};
    }

    // delegators


    public HyexpressionParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public HyexpressionParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(89 + 1);
         

    }

    public String[] getTokenNames() { return HyexpressionParser.tokenNames; }
    public String getGrammarFileName() { return "Hyexpression.g"; }


    	private eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolverFactory tokenResolverFactory = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTokenResolverFactory();
    	
    	/**
    	 * the index of the last token that was handled by collectHiddenTokens()
    	 */
    	private int lastPosition;
    	
    	/**
    	 * A flag that indicates whether the parser should remember all expected elements.
    	 * This flag is set to true when using the parse for code completion. Otherwise it
    	 * is set to false.
    	 */
    	private boolean rememberExpectedElements = false;
    	
    	private Object parseToIndexTypeObject;
    	private int lastTokenIndex = 0;
    	
    	/**
    	 * A list of expected elements the were collected while parsing the input stream.
    	 * This list is only filled if <code>rememberExpectedElements</code> is set to
    	 * true.
    	 */
    	private List<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal> expectedElements = new ArrayList<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal>();
    	
    	private int mismatchedTokenRecoveryTries = 0;
    	/**
    	 * A helper list to allow a lexer to pass errors to its parser
    	 */
    	protected List<RecognitionException> lexerExceptions = Collections.synchronizedList(new ArrayList<RecognitionException>());
    	
    	/**
    	 * Another helper list to allow a lexer to pass positions of errors to its parser
    	 */
    	protected List<Integer> lexerExceptionPositions = Collections.synchronizedList(new ArrayList<Integer>());
    	
    	/**
    	 * A stack for incomplete objects. This stack is used filled when the parser is
    	 * used for code completion. Whenever the parser starts to read an object it is
    	 * pushed on the stack. Once the element was parser completely it is popped from
    	 * the stack.
    	 */
    	List<EObject> incompleteObjects = new ArrayList<EObject>();
    	
    	private int stopIncludingHiddenTokens;
    	private int stopExcludingHiddenTokens;
    	private int tokenIndexOfLastCompleteElement;
    	
    	private int expectedElementsIndexOfLastCompleteElement;
    	
    	/**
    	 * The offset indicating the cursor position when the parser is used for code
    	 * completion by calling parseToExpectedElements().
    	 */
    	private int cursorOffset;
    	
    	/**
    	 * The offset of the first hidden token of the last expected element. This offset
    	 * is used to discard expected elements, which are not needed for code completion.
    	 */
    	private int lastStartIncludingHidden;
    	
    	private eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionLocationMap locationMap;
    	
    	private eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionSyntaxErrorMessageConverter syntaxErrorMessageConverter = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionSyntaxErrorMessageConverter(tokenNames);
    	
    	@Override
    	public void reportError(RecognitionException re) {
    		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
    	}
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource>() {
    			public boolean execute(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionProblem() {
    					public eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemSeverity getSeverity() {
    						return eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemSeverity.ERROR;
    					}
    					public eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemType getType() {
    						return eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	protected void addErrorToResource(eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionLocalizedMessage message) {
    		if (message == null) {
    			return;
    		}
    		addErrorToResource(message.getMessage(), message.getColumn(), message.getLine(), message.getCharStart(), message.getCharEnd());
    	}
    	
    	public void addExpectedElement(EClass eClass, int[] ids) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		int terminalID = ids[0];
    		int followSetID = ids[1];
    		eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionExpectedElement terminal = eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionFollowSetProvider.TERMINALS[terminalID];
    		eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContainedFeature[] containmentFeatures = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionFollowSetProvider.LINKS[ids[i]];
    		}
    		eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainmentTrace containmentTrace = new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainmentTrace(eClass, containmentFeatures);
    		EObject container = getLastIncompleteElement();
    		eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal expectedElement = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal(container, terminal, followSetID, containmentTrace);
    		setPosition(expectedElement, input.index());
    		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
    		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
    			// clear list of expected elements
    			this.expectedElements.clear();
    			this.expectedElementsIndexOfLastCompleteElement = 0;
    		}
    		lastStartIncludingHidden = startIncludingHiddenTokens;
    		this.expectedElements.add(expectedElement);
    	}
    	
    	protected void collectHiddenTokens(EObject element) {
    	}
    	
    	protected void copyLocalizationInfos(final EObject source, final EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource>() {
    			public boolean execute(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource resource) {
    				locationMap.setCharStart(target, locationMap.getCharStart(source));
    				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
    				locationMap.setColumn(target, locationMap.getColumn(source));
    				locationMap.setLine(target, locationMap.getLine(source));
    				return true;
    			}
    		});
    	}
    	
    	protected void copyLocalizationInfos(final CommonToken source, final EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource>() {
    			public boolean execute(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource resource) {
    				if (source == null) {
    					return true;
    				}
    				locationMap.setCharStart(target, source.getStartIndex());
    				locationMap.setCharEnd(target, source.getStopIndex());
    				locationMap.setColumn(target, source.getCharPositionInLine());
    				locationMap.setLine(target, source.getLine());
    				return true;
    			}
    		});
    	}
    	
    	/**
    	 * Sets the end character index and the last line for the given object in the
    	 * location map.
    	 */
    	protected void setLocalizationEnd(Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource>() {
    			public boolean execute(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource resource) {
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextParser createInstance(InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new HyexpressionParser(new CommonTokenStream(new HyexpressionLexer(new ANTLRInputStream(actualInputStream))));
    			} else {
    				return new HyexpressionParser(new CommonTokenStream(new HyexpressionLexer(new ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (IOException e) {
    			new eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public HyexpressionParser() {
    		super(null);
    	}
    	
    	protected EObject doParse() throws RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((HyexpressionLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((HyexpressionLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof EClass) {
    			EClass type = (EClass) typeObject;
    			if (type.getInstanceClass() == eu.hyvar.feature.expression.HyRelativeVersionRestriction.class) {
    				return parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction();
    			}
    			if (type.getInstanceClass() == eu.hyvar.feature.expression.HyVersionRangeRestriction.class) {
    				return parse_eu_hyvar_feature_expression_HyVersionRangeRestriction();
    			}
    			if (type.getInstanceClass() == eu.hyvar.dataValues.HyEnum.class) {
    				return parse_eu_hyvar_dataValues_HyEnum();
    			}
    			if (type.getInstanceClass() == eu.hyvar.dataValues.HyEnumLiteral.class) {
    				return parse_eu_hyvar_dataValues_HyEnumLiteral();
    			}
    		}
    		throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionUnexpectedContentTypeException(typeObject);
    	}
    	
    	public int getMismatchedTokenRecoveryTries() {
    		return mismatchedTokenRecoveryTries;
    	}
    	
    	public Object getMissingSymbol(IntStream arg0, RecognitionException arg1, int arg2, BitSet arg3) {
    		mismatchedTokenRecoveryTries++;
    		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
    	}
    	
    	public Object getParseToIndexTypeObject() {
    		return parseToIndexTypeObject;
    	}
    	
    	protected Object getTypeObject() {
    		Object typeObject = getParseToIndexTypeObject();
    		if (typeObject != null) {
    			return typeObject;
    		}
    		Map<?,?> options = getOptions();
    		if (options != null) {
    			typeObject = options.get(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionParseResult parse() {
    		// Reset parser state
    		terminateParsing = false;
    		postParseCommands = new ArrayList<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource>>();
    		eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionParseResult parseResult = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionParseResult();
    		if (disableLocationMap) {
    			locationMap = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionDevNullLocationMap();
    		} else {
    			locationMap = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionLocationMap();
    		}
    		// Run parser
    		try {
    			EObject result =  doParse();
    			if (lexerExceptions.isEmpty()) {
    				parseResult.setRoot(result);
    				parseResult.setLocationMap(locationMap);
    			}
    		} catch (RecognitionException re) {
    			addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
    		} catch (IllegalArgumentException iae) {
    			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
    				// can be caused if a null is set on EMF models where not allowed. this will just
    				// happen if other errors occurred before
    			} else {
    				iae.printStackTrace();
    			}
    		}
    		for (RecognitionException re : lexerExceptions) {
    			addErrorToResource(syntaxErrorMessageConverter.translateLexicalError(re, lexerExceptions, lexerExceptionPositions));
    		}
    		parseResult.getPostParseCommands().addAll(postParseCommands);
    		return parseResult;
    	}
    	
    	public List<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal> parseToExpectedElements(EClass type, eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
    		eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionParseResult result = parse();
    		for (EObject incompleteObject : incompleteObjects) {
    			Lexer lexer = (Lexer) tokenStream.getTokenSource();
    			int endChar = lexer.getCharIndex();
    			int endLine = lexer.getLine();
    			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
    		}
    		if (result != null) {
    			EObject root = result.getRoot();
    			if (root != null) {
    				dummyResource.getContentsInternal().add(root);
    			}
    			for (eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		Set<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal> currentFollowSet = new LinkedHashSet<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal>();
    		List<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal> newFollowSet = new ArrayList<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 109;
    		int i;
    		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
    			CommonToken nextToken = (CommonToken) tokenStream.get(i);
    			if (nextToken.getType() < 0) {
    				break;
    			}
    			if (nextToken.getChannel() == 99) {
    				// hidden tokens do not reduce the follow set
    			} else {
    				// now that we have found the next visible token the position for that expected
    				// terminals can be set
    				for (eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						Collection<eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionPair<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionExpectedElement, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionPair<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionExpectedElement, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContainedFeature[]> newFollowerPair : newFollowers) {
    							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionExpectedElement newFollower = newFollowerPair.getLeft();
    							EObject container = getLastIncompleteElement();
    							eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainmentTrace containmentTrace = new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainmentTrace(null, newFollowerPair.getRight());
    							eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal newFollowTerminal = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal(container, newFollower, followSetID, containmentTrace);
    							newFollowSet.add(newFollowTerminal);
    							expectedElements.add(newFollowTerminal);
    						}
    					}
    				}
    				currentFollowSet.clear();
    				currentFollowSet.addAll(newFollowSet);
    			}
    			followSetID++;
    		}
    		// after the last token in the stream we must set the position for the elements
    		// that were added during the last iteration of the loop
    		for (eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal expectedElement, int tokenIndex) {
    		int currentIndex = Math.max(0, tokenIndex);
    		for (int index = lastTokenIndex; index < currentIndex; index++) {
    			if (index >= input.size()) {
    				break;
    			}
    			CommonToken tokenAtIndex = (CommonToken) input.get(index);
    			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
    				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			}
    		}
    		lastTokenIndex = Math.max(0, currentIndex);
    		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
    	}
    	
    	public Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException {
    		if (!rememberExpectedElements) {
    			return super.recoverFromMismatchedToken(input, ttype, follow);
    		} else {
    			return null;
    		}
    	}
    	
    	private void startIncompleteElement(Object object) {
    		if (object instanceof EObject) {
    			this.incompleteObjects.add((EObject) object);
    		}
    	}
    	
    	private void completedElement(Object object, boolean isContainment) {
    		if (isContainment && !this.incompleteObjects.isEmpty()) {
    			boolean exists = this.incompleteObjects.remove(object);
    			if (!exists) {
    			}
    		}
    		if (object instanceof EObject) {
    			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
    			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
    		}
    	}
    	
    	private EObject getLastIncompleteElement() {
    		if (incompleteObjects.isEmpty()) {
    			return null;
    		}
    		return incompleteObjects.get(incompleteObjects.size() - 1);
    	}
    	



    // $ANTLR start "start"
    // Hyexpression.g:490:1: start returns [ EObject element = null] : (c0= parse_eu_hyvar_feature_expression_HyExpression ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        eu.hyvar.feature.expression.HyExpression c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Hyexpression.g:491:2: ( (c0= parse_eu_hyvar_feature_expression_HyExpression ) EOF )
            // Hyexpression.g:492:2: (c0= parse_eu_hyvar_feature_expression_HyExpression ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[2]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[3]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[4]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[6]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[7]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[8]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[10]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[11]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[12]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[13]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[14]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[15]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[16]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[17]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[18]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[19]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[20]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[21]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[22]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[23]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[24]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[25]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[27]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[28]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[29]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[30]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[31]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[32]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[33]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[34]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[35]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[36]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[37]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[38]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[39]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[40]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[41]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[42]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[43]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[44]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[45]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[46]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[47]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[48]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[49]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[50]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[51]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[52]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[53]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[54]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[55]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[56]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[57]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[58]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[59]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[60]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[61]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[62]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[63]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[64]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[65]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[66]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[67]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[68]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[69]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[70]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[71]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[72]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[73]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[74]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[75]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[76]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[77]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[78]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[79]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[80]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[81]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[82]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[83]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[84]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[85]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[86]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[87]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[88]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[89]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[90]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[91]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[92]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[93]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[94]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[95]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[96]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[97]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[98]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[99]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[100]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[101]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[102]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[103]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[104]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[105]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[106]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[107]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[108]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[109]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[110]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[111]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[112]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[113]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[114]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[115]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[116]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[117]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[118]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[119]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[120]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[121]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[122]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[123]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[124]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[125]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[126]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[127]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[128]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[129]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[130]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[131]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[132]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[133]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[134]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[135]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[136]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[137]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[138]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[139]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[140]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[141]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[142]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[143]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[144]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[145]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[146]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[147]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[148]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[149]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[150]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[151]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[152]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[153]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[154]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[155]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[156]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[157]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[158]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[159]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[160]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[161]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[162]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[163]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[164]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[165]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[166]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[167]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[168]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[169]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[170]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[171]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[172]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[173]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[174]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[175]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[176]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[177]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[178]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[179]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[180]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[181]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[182]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[183]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[184]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[185]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[186]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[187]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[188]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[189]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[190]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[191]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[192]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[193]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[194]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[195]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[196]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[197]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[198]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[199]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[200]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[201]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[202]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[203]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[204]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[205]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[206]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[207]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[208]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[209]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[210]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[211]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[212]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[213]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[214]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[215]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[216]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[217]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[218]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[219]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[220]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[221]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[222]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[223]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[224]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[225]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[226]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[227]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[228]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[229]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[230]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[231]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[232]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[233]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[234]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[235]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[236]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[237]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[238]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[239]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[240]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[241]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[242]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[243]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[244]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[245]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[246]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[247]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[248]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[249]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[250]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[251]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[252]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[253]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[254]);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[255]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Hyexpression.g:752:2: (c0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyexpression.g:753:3: c0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_start82);
            c0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; }

            }


            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		retrieveLayoutInformation(element, null, null, false);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "start"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction"
    // Hyexpression.g:761:1: parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction returns [eu.hyvar.feature.expression.HyRelativeVersionRestriction element = null] : a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' ;
    public final eu.hyvar.feature.expression.HyRelativeVersionRestriction parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction() throws RecognitionException {
        eu.hyvar.feature.expression.HyRelativeVersionRestriction element =  null;

        int parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a8=null;
        Token a9=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Hyexpression.g:764:2: (a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' )
            // Hyexpression.g:765:2: a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']'
            {
            a0=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction115); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[256]);
            	}

            // Hyexpression.g:782:2: ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? )
            // Hyexpression.g:783:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
            {
            // Hyexpression.g:783:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
            int alt1=6;
            switch ( input.LA(1) ) {
                case 24:
                    {
                    alt1=1;
                    }
                    break;
                case 26:
                    {
                    alt1=2;
                    }
                    break;
                case 27:
                    {
                    alt1=3;
                    }
                    break;
                case 29:
                    {
                    alt1=4;
                    }
                    break;
                case 28:
                    {
                    alt1=5;
                    }
                    break;
            }

            switch (alt1) {
                case 1 :
                    // Hyexpression.g:784:4: a1= '<'
                    {
                    a1=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction138); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Hyexpression.g:800:8: a2= '<='
                    {
                    a2=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction153); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Hyexpression.g:816:8: a3= '='
                    {
                    a3=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction168); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a3, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 4 :
                    // Hyexpression.g:832:8: a4= '>='
                    {
                    a4=(Token)match(input,29,FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction183); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a4, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 5 :
                    // Hyexpression.g:848:8: a5= '>'
                    {
                    a5=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction198); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[257]);
            	}

            // Hyexpression.g:870:2: (a8= QUOTED_34_34 )
            // Hyexpression.g:871:3: a8= QUOTED_34_34
            {
            a8=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction223); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            				startIncompleteElement(element);
            				// initialize enumeration attribute
            				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            			}
            			if (a8 != null) {
            				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyRelativeVersionRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyRelativeVersionRestrictionVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a8, element);
            				copyLocalizationInfos((CommonToken) a8, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[258]);
            	}

            a9=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction244); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[259]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[260]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[261]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[262]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[263]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[264]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[265]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[266]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[267]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[268]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[269]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[270]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[271]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[272]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[273]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[274]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[275]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[276]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[277]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[278]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyVersionRangeRestriction"
    // Hyexpression.g:951:1: parse_eu_hyvar_feature_expression_HyVersionRangeRestriction returns [eu.hyvar.feature.expression.HyVersionRangeRestriction element = null] : a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' ;
    public final eu.hyvar.feature.expression.HyVersionRangeRestriction parse_eu_hyvar_feature_expression_HyVersionRangeRestriction() throws RecognitionException {
        eu.hyvar.feature.expression.HyVersionRangeRestriction element =  null;

        int parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a7=null;
        Token a8=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Hyexpression.g:954:2: (a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' )
            // Hyexpression.g:955:2: a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']'
            {
            a0=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction273); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyVersionRangeRestriction();
            			startIncompleteElement(element);
            			// initialize boolean attribute
            			{
            				Object value = true;
            				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), value);
            			}
            			// initialize boolean attribute
            			{
            				Object value = true;
            				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), value);
            			}
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_28_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[279]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[280]);
            	}

            // Hyexpression.g:980:2: ( (a1= '^' )? )
            // Hyexpression.g:981:3: (a1= '^' )?
            {
            // Hyexpression.g:981:3: (a1= '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==36) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Hyexpression.g:982:4: a1= '^'
                    {
                    a1=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction296); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyVersionRangeRestriction();
                    					startIncompleteElement(element);
                    					// initialize boolean attribute
                    					{
                    						Object value = true;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), value);
                    					}
                    					// initialize boolean attribute
                    					{
                    						Object value = true;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), value);
                    					}
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_28_0_0_1, false, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    				// set value of boolean attribute
                    				Object value = false;
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[281]);
            	}

            // Hyexpression.g:1011:2: (a3= QUOTED_34_34 )
            // Hyexpression.g:1012:3: a3= QUOTED_34_34
            {
            a3=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction321); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyVersionRangeRestriction();
            				startIncompleteElement(element);
            				// initialize boolean attribute
            				{
            					Object value = true;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), value);
            				}
            				// initialize boolean attribute
            				{
            					Object value = true;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), value);
            				}
            			}
            			if (a3 != null) {
            				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionLowerVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_28_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            				copyLocalizationInfos((CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[282]);
            	}

            a4=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction342); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyVersionRangeRestriction();
            			startIncompleteElement(element);
            			// initialize boolean attribute
            			{
            				Object value = true;
            				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), value);
            			}
            			// initialize boolean attribute
            			{
            				Object value = true;
            				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), value);
            			}
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_28_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[283]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[284]);
            	}

            // Hyexpression.g:1086:2: ( (a5= '^' )? )
            // Hyexpression.g:1087:3: (a5= '^' )?
            {
            // Hyexpression.g:1087:3: (a5= '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==36) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Hyexpression.g:1088:4: a5= '^'
                    {
                    a5=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction365); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyVersionRangeRestriction();
                    					startIncompleteElement(element);
                    					// initialize boolean attribute
                    					{
                    						Object value = true;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), value);
                    					}
                    					// initialize boolean attribute
                    					{
                    						Object value = true;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), value);
                    					}
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_28_0_0_4, false, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    				// set value of boolean attribute
                    				Object value = false;
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[285]);
            	}

            // Hyexpression.g:1117:2: (a7= QUOTED_34_34 )
            // Hyexpression.g:1118:3: a7= QUOTED_34_34
            {
            a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction390); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyVersionRangeRestriction();
            				startIncompleteElement(element);
            				// initialize boolean attribute
            				{
            					Object value = true;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), value);
            				}
            				// initialize boolean attribute
            				{
            					Object value = true;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), value);
            				}
            			}
            			if (a7 != null) {
            				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionUpperVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_28_0_0_5, proxy, true);
            				copyLocalizationInfos((CommonToken) a7, element);
            				copyLocalizationInfos((CommonToken) a7, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[286]);
            	}

            a8=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction411); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyVersionRangeRestriction();
            			startIncompleteElement(element);
            			// initialize boolean attribute
            			{
            				Object value = true;
            				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), value);
            			}
            			// initialize boolean attribute
            			{
            				Object value = true;
            				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), value);
            			}
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_28_0_0_6, null, true);
            		copyLocalizationInfos((CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[287]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[288]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[289]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[290]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[291]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[292]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[293]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[294]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[295]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[296]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[297]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[298]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[299]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[300]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[301]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[302]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[303]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[304]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[305]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[306]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyVersionRangeRestriction"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnum"
    // Hyexpression.g:1212:1: parse_eu_hyvar_dataValues_HyEnum returns [eu.hyvar.dataValues.HyEnum element = null] : a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' ) )? ;
    public final eu.hyvar.dataValues.HyEnum parse_eu_hyvar_dataValues_HyEnum() throws RecognitionException {
        eu.hyvar.dataValues.HyEnum element =  null;

        int parse_eu_hyvar_dataValues_HyEnum_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a16=null;
        Token a17=null;
        eu.hyvar.dataValues.HyEnumLiteral a3_0 =null;

        eu.hyvar.dataValues.HyEnumLiteral a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Hyexpression.g:1215:2: (a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' ) )? )
            // Hyexpression.g:1216:2: a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' ) )?
            {
            a0=(Token)match(input,31,FOLLOW_31_in_parse_eu_hyvar_dataValues_HyEnum440); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[307]);
            	}

            // Hyexpression.g:1230:2: (a1= IDENTIFIER_TOKEN )
            // Hyexpression.g:1231:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum458); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[308]);
            	}

            a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum479); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[309]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[310]);
            	}

            // Hyexpression.g:1281:2: ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==32) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Hyexpression.g:1282:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    {
                    // Hyexpression.g:1282:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    // Hyexpression.g:1283:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    {
                    // Hyexpression.g:1283:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    // Hyexpression.g:1284:5: a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum508);
                    a3_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    						startIncompleteElement(element);
                    					}
                    					if (a3_0 != null) {
                    						if (a3_0 != null) {
                    							Object value = a3_0;
                    							addObjectToList(element, eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS, value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[311]);
                    				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[312]);
                    			}

                    // Hyexpression.g:1310:4: ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==19) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Hyexpression.g:1311:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    {
                    	    // Hyexpression.g:1311:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    // Hyexpression.g:1312:6: a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    {
                    	    a4=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum549); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((CommonToken)a4, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[313]);
                    	    					}

                    	    // Hyexpression.g:1326:6: (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    // Hyexpression.g:1327:7: a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum583);
                    	    a5_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    							if (terminateParsing) {
                    	    								throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    							}
                    	    							if (element == null) {
                    	    								element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    	    								startIncompleteElement(element);
                    	    							}
                    	    							if (a5_0 != null) {
                    	    								if (a5_0 != null) {
                    	    									Object value = a5_0;
                    	    									addObjectToList(element, eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__LITERALS, value);
                    	    									completedElement(value, true);
                    	    								}
                    	    								collectHiddenTokens(element);
                    	    								retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_1, a5_0, true);
                    	    								copyLocalizationInfos(a5_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[314]);
                    	    						addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[315]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[316]);
                    				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[317]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[318]);
            	}

            a6=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum657); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[319]);
            	}

            // Hyexpression.g:1382:2: ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==33) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Hyexpression.g:1383:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' )
                    {
                    // Hyexpression.g:1383:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' )
                    // Hyexpression.g:1384:4: a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']'
                    {
                    a7=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnum680); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a7, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[320]);
                    				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[321]);
                    				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[322]);
                    			}

                    // Hyexpression.g:1400:4: ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) )
                    int alt6=3;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==DATE) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==20) ) {
                            int LA6_3 = input.LA(3);

                            if ( (LA6_3==DATE) ) {
                                alt6=1;
                            }
                            else if ( (LA6_3==43) ) {
                                alt6=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA6_0==43) ) {
                        alt6=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;

                    }
                    switch (alt6) {
                        case 1 :
                            // Hyexpression.g:1401:5: (a8= DATE ) a9= '-' (a10= DATE )
                            {
                            // Hyexpression.g:1401:5: (a8= DATE )
                            // Hyexpression.g:1402:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum713); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[323]);
                            				}

                            a9=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum752); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[324]);
                            				}

                            // Hyexpression.g:1451:5: (a10= DATE )
                            // Hyexpression.g:1452:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum782); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a10 != null) {
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a10).getLine(), ((CommonToken) a10).getCharPositionInLine(), ((CommonToken) a10).getStartIndex(), ((CommonToken) a10).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a10, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[325]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyexpression.g:1488:10: (a11= DATE ) a12= '-' a13= 'null'
                            {
                            // Hyexpression.g:1488:10: (a11= DATE )
                            // Hyexpression.g:1489:6: a11= DATE
                            {
                            a11=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum838); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a11 != null) {
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a11).getLine(), ((CommonToken) a11).getCharPositionInLine(), ((CommonToken) a11).getStartIndex(), ((CommonToken) a11).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a11, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[326]);
                            				}

                            a12=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum877); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[327]);
                            				}

                            a13=(Token)match(input,43,FOLLOW_43_in_parse_eu_hyvar_dataValues_HyEnum900); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[328]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyexpression.g:1553:10: a14= 'null' a15= '-' (a16= DATE )
                            {
                            a14=(Token)match(input,43,FOLLOW_43_in_parse_eu_hyvar_dataValues_HyEnum933); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a14, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[329]);
                            				}

                            a15=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum956); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a15, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[330]);
                            				}

                            // Hyexpression.g:1581:5: (a16= DATE )
                            // Hyexpression.g:1582:6: a16= DATE
                            {
                            a16=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum986); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a16 != null) {
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a16.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a16).getLine(), ((CommonToken) a16).getCharPositionInLine(), ((CommonToken) a16).getStartIndex(), ((CommonToken) a16).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a16, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[331]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[332]);
                    			}

                    a17=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnum1038); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a17, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_eu_hyvar_dataValues_HyEnum_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnum"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumLiteral"
    // Hyexpression.g:1644:1: parse_eu_hyvar_dataValues_HyEnumLiteral returns [eu.hyvar.dataValues.HyEnumLiteral element = null] : a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
    public final eu.hyvar.dataValues.HyEnumLiteral parse_eu_hyvar_dataValues_HyEnumLiteral() throws RecognitionException {
        eu.hyvar.dataValues.HyEnumLiteral element =  null;

        int parse_eu_hyvar_dataValues_HyEnumLiteral_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Hyexpression.g:1647:2: (a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hyexpression.g:1648:2: a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            a0=(Token)match(input,32,FOLLOW_32_in_parse_eu_hyvar_dataValues_HyEnumLiteral1086); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[333]);
            	}

            // Hyexpression.g:1662:2: (a1= IDENTIFIER_TOKEN )
            // Hyexpression.g:1663:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral1104); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[334]);
            	}

            a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnumLiteral1125); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[335]);
            	}

            // Hyexpression.g:1712:2: (a3= INTEGER_LITERAL )
            // Hyexpression.g:1713:3: a3= INTEGER_LITERAL
            {
            a3=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral1143); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALUE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            				}
            				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALUE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_3, resolved, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[336]);
            	}

            a4=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral1164); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[337]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[338]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[339]);
            	}

            // Hyexpression.g:1764:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==33) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Hyexpression.g:1765:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hyexpression.g:1765:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hyexpression.g:1766:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnumLiteral1187); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[340]);
                    				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[341]);
                    				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[342]);
                    			}

                    // Hyexpression.g:1782:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) )
                    int alt8=3;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==DATE) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==20) ) {
                            int LA8_3 = input.LA(3);

                            if ( (LA8_3==DATE) ) {
                                alt8=1;
                            }
                            else if ( (LA8_3==43) ) {
                                alt8=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 8, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 8, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA8_0==43) ) {
                        alt8=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;

                    }
                    switch (alt8) {
                        case 1 :
                            // Hyexpression.g:1783:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hyexpression.g:1783:5: (a6= DATE )
                            // Hyexpression.g:1784:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1220); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a6 != null) {
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a6).getLine(), ((CommonToken) a6).getCharPositionInLine(), ((CommonToken) a6).getStartIndex(), ((CommonToken) a6).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a6, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[343]);
                            				}

                            a7=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1259); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[344]);
                            				}

                            // Hyexpression.g:1833:5: (a8= DATE )
                            // Hyexpression.g:1834:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1289); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[345]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyexpression.g:1870:10: (a9= DATE ) a10= '-' a11= 'null'
                            {
                            // Hyexpression.g:1870:10: (a9= DATE )
                            // Hyexpression.g:1871:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1345); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a9 != null) {
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a9).getLine(), ((CommonToken) a9).getCharPositionInLine(), ((CommonToken) a9).getStartIndex(), ((CommonToken) a9).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a9, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[346]);
                            				}

                            a10=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1384); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a10, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[347]);
                            				}

                            a11=(Token)match(input,43,FOLLOW_43_in_parse_eu_hyvar_dataValues_HyEnumLiteral1407); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a11, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[348]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyexpression.g:1935:10: a12= 'null' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,43,FOLLOW_43_in_parse_eu_hyvar_dataValues_HyEnumLiteral1440); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[349]);
                            				}

                            a13=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1463); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[350]);
                            				}

                            // Hyexpression.g:1963:5: (a14= DATE )
                            // Hyexpression.g:1964:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1493); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a14 != null) {
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a14).getLine(), ((CommonToken) a14).getCharPositionInLine(), ((CommonToken) a14).getStartIndex(), ((CommonToken) a14).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_LITERAL__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a14, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[351]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[352]);
                    			}

                    a15=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnumLiteral1545); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a15, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[353]);
                    				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[354]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[355]);
            		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[356]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_eu_hyvar_dataValues_HyEnumLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumLiteral"



    // $ANTLR start "parseop_HyExpression_level_0"
    // Hyexpression.g:2030:1: parseop_HyExpression_level_0 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_0() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_0_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Hyexpression.g:2033:2: (leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) )
            // Hyexpression.g:2034:2: leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_01593);
            leftArg=parseop_HyExpression_level_1();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:2034:41: ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            else if ( (LA11_0==EOF||LA11_0==16||LA11_0==19) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // Hyexpression.g:2034:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    {
                    // Hyexpression.g:2034:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==25) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // Hyexpression.g:2035:3: () a0= '<->' rightArg= parseop_HyExpression_level_1
                    	    {
                    	    // Hyexpression.g:2035:3: ()
                    	    // Hyexpression.g:2035:4: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,25,FOLLOW_25_in_parseop_HyExpression_level_01613); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    			if (element == null) {
                    	    				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyEquivalenceExpression();
                    	    				startIncompleteElement(element);
                    	    			}
                    	    			collectHiddenTokens(element);
                    	    			retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_0_0_0_1, null, true);
                    	    			copyLocalizationInfos((CommonToken)a0, element);
                    	    		}

                    	    if ( state.backtracking==0 ) {
                    	    			// expected elements (follow set)
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[357]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[358]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[359]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[360]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[361]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[362]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[363]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[364]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[365]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[366]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[367]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[368]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[369]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[370]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[371]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[372]);
                    	    		}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_01630);
                    	    rightArg=parseop_HyExpression_level_1();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    			if (terminateParsing) {
                    	    				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    			}
                    	    			if (element == null) {
                    	    				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyEquivalenceExpression();
                    	    				startIncompleteElement(element);
                    	    			}
                    	    			if (leftArg != null) {
                    	    				if (leftArg != null) {
                    	    					Object value = leftArg;
                    	    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND1), value);
                    	    					completedElement(value, true);
                    	    				}
                    	    				collectHiddenTokens(element);
                    	    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_0_0_0_0, leftArg, true);
                    	    				copyLocalizationInfos(leftArg, element);
                    	    			}
                    	    		}

                    	    if ( state.backtracking==0 ) {
                    	    			if (terminateParsing) {
                    	    				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    			}
                    	    			if (element == null) {
                    	    				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyEquivalenceExpression();
                    	    				startIncompleteElement(element);
                    	    			}
                    	    			if (rightArg != null) {
                    	    				if (rightArg != null) {
                    	    					Object value = rightArg;
                    	    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUIVALENCE_EXPRESSION__OPERAND2), value);
                    	    					completedElement(value, true);
                    	    				}
                    	    				collectHiddenTokens(element);
                    	    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_0_0_0_2, rightArg, true);
                    	    				copyLocalizationInfos(rightArg, element);
                    	    			}
                    	    		}

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyexpression.g:2105:21: 
                    {
                    if ( state.backtracking==0 ) { element = leftArg; }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parseop_HyExpression_level_0_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_0"



    // $ANTLR start "parseop_HyExpression_level_1"
    // Hyexpression.g:2110:1: parseop_HyExpression_level_1 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_4 ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_1() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_1_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Hyexpression.g:2113:9: (leftArg= parseop_HyExpression_level_4 ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |) )
            // Hyexpression.g:2114:9: leftArg= parseop_HyExpression_level_4 ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_11676);
            leftArg=parseop_HyExpression_level_4();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:2114:39: ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |)
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            else if ( (LA13_0==EOF||LA13_0==16||LA13_0==19||LA13_0==25) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // Hyexpression.g:2114:40: ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+
                    {
                    // Hyexpression.g:2114:40: ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==21) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // Hyexpression.g:2115:2: () a0= '->' rightArg= parseop_HyExpression_level_4
                    	    {
                    	    // Hyexpression.g:2115:2: ()
                    	    // Hyexpression.g:2115:3: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,21,FOLLOW_21_in_parseop_HyExpression_level_11692); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    		if (element == null) {
                    	    			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyImpliesExpression();
                    	    			startIncompleteElement(element);
                    	    		}
                    	    		collectHiddenTokens(element);
                    	    		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_1_0_0_1, null, true);
                    	    		copyLocalizationInfos((CommonToken)a0, element);
                    	    	}

                    	    if ( state.backtracking==0 ) {
                    	    		// expected elements (follow set)
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[373]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[374]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[375]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[376]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[377]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[378]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[379]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[380]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[381]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[382]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[383]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[384]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[385]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[386]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[387]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[388]);
                    	    	}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_11706);
                    	    rightArg=parseop_HyExpression_level_4();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    		if (terminateParsing) {
                    	    			throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    		}
                    	    		if (element == null) {
                    	    			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyImpliesExpression();
                    	    			startIncompleteElement(element);
                    	    		}
                    	    		if (leftArg != null) {
                    	    			if (leftArg != null) {
                    	    				Object value = leftArg;
                    	    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND1), value);
                    	    				completedElement(value, true);
                    	    			}
                    	    			collectHiddenTokens(element);
                    	    			retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_1_0_0_0, leftArg, true);
                    	    			copyLocalizationInfos(leftArg, element);
                    	    		}
                    	    	}

                    	    if ( state.backtracking==0 ) {
                    	    		if (terminateParsing) {
                    	    			throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    		}
                    	    		if (element == null) {
                    	    			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyImpliesExpression();
                    	    			startIncompleteElement(element);
                    	    		}
                    	    		if (rightArg != null) {
                    	    			if (rightArg != null) {
                    	    				Object value = rightArg;
                    	    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_IMPLIES_EXPRESSION__OPERAND2), value);
                    	    				completedElement(value, true);
                    	    			}
                    	    			collectHiddenTokens(element);
                    	    			retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_1_0_0_2, rightArg, true);
                    	    			copyLocalizationInfos(rightArg, element);
                    	    		}
                    	    	}

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyexpression.g:2185:20: 
                    {
                    if ( state.backtracking==0 ) { element = leftArg; }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parseop_HyExpression_level_1_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_1"



    // $ANTLR start "parseop_HyExpression_level_4"
    // Hyexpression.g:2190:1: parseop_HyExpression_level_4 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_5 ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_4() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_4_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Hyexpression.g:2193:9: (leftArg= parseop_HyExpression_level_5 ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |) )
            // Hyexpression.g:2194:9: leftArg= parseop_HyExpression_level_5 ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_41747);
            leftArg=parseop_HyExpression_level_5();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:2194:39: ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |)
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==45) ) {
                alt15=1;
            }
            else if ( (LA15_0==EOF||LA15_0==16||LA15_0==19||LA15_0==21||LA15_0==25) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // Hyexpression.g:2194:40: ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+
                    {
                    // Hyexpression.g:2194:40: ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==45) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // Hyexpression.g:2195:0: () a0= '||' rightArg= parseop_HyExpression_level_5
                    	    {
                    	    // Hyexpression.g:2195:2: ()
                    	    // Hyexpression.g:2195:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,45,FOLLOW_45_in_parseop_HyExpression_level_41760); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    	if (element == null) {
                    	    		element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyOrExpression();
                    	    		startIncompleteElement(element);
                    	    	}
                    	    	collectHiddenTokens(element);
                    	    	retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_2_0_0_1, null, true);
                    	    	copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    	// expected elements (follow set)
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[389]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[390]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[391]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[392]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[393]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[394]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[395]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[396]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[397]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[398]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[399]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[400]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[401]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[402]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[403]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[404]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_41771);
                    	    rightArg=parseop_HyExpression_level_5();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    	if (terminateParsing) {
                    	    		throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    	}
                    	    	if (element == null) {
                    	    		element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyOrExpression();
                    	    		startIncompleteElement(element);
                    	    	}
                    	    	if (leftArg != null) {
                    	    		if (leftArg != null) {
                    	    			Object value = leftArg;
                    	    			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND1), value);
                    	    			completedElement(value, true);
                    	    		}
                    	    		collectHiddenTokens(element);
                    	    		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_2_0_0_0, leftArg, true);
                    	    		copyLocalizationInfos(leftArg, element);
                    	    	}
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    	if (terminateParsing) {
                    	    		throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    	}
                    	    	if (element == null) {
                    	    		element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyOrExpression();
                    	    		startIncompleteElement(element);
                    	    	}
                    	    	if (rightArg != null) {
                    	    		if (rightArg != null) {
                    	    			Object value = rightArg;
                    	    			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_OR_EXPRESSION__OPERAND2), value);
                    	    			completedElement(value, true);
                    	    		}
                    	    		collectHiddenTokens(element);
                    	    		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_2_0_0_2, rightArg, true);
                    	    		copyLocalizationInfos(rightArg, element);
                    	    	}
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyexpression.g:2265:20: 
                    {
                    if ( state.backtracking==0 ) { element = leftArg; }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parseop_HyExpression_level_4_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_4"



    // $ANTLR start "parseop_HyExpression_level_5"
    // Hyexpression.g:2270:1: parseop_HyExpression_level_5 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_9 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_5() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_5_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Hyexpression.g:2273:9: (leftArg= parseop_HyExpression_level_9 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |) )
            // Hyexpression.g:2274:9: leftArg= parseop_HyExpression_level_9 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_51809);
            leftArg=parseop_HyExpression_level_9();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:2274:39: ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |)
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==14) ) {
                alt17=1;
            }
            else if ( (LA17_0==EOF||LA17_0==16||LA17_0==19||LA17_0==21||LA17_0==25||LA17_0==45) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // Hyexpression.g:2274:40: ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+
                    {
                    // Hyexpression.g:2274:40: ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==14) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // Hyexpression.g:2275:0: () a0= '&&' rightArg= parseop_HyExpression_level_9
                    	    {
                    	    // Hyexpression.g:2275:2: ()
                    	    // Hyexpression.g:2275:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,14,FOLLOW_14_in_parseop_HyExpression_level_51822); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAndExpression();
                    	    	startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_3_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[405]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[406]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[407]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[408]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[409]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[410]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[411]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[412]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[413]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[414]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[415]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[416]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[417]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[418]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[419]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[420]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_51833);
                    	    rightArg=parseop_HyExpression_level_9();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    	throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAndExpression();
                    	    	startIncompleteElement(element);
                    	    }
                    	    if (leftArg != null) {
                    	    	if (leftArg != null) {
                    	    		Object value = leftArg;
                    	    		element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND1), value);
                    	    		completedElement(value, true);
                    	    	}
                    	    	collectHiddenTokens(element);
                    	    	retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_3_0_0_0, leftArg, true);
                    	    	copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    	throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAndExpression();
                    	    	startIncompleteElement(element);
                    	    }
                    	    if (rightArg != null) {
                    	    	if (rightArg != null) {
                    	    		Object value = rightArg;
                    	    		element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_AND_EXPRESSION__OPERAND2), value);
                    	    		completedElement(value, true);
                    	    	}
                    	    	collectHiddenTokens(element);
                    	    	retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_3_0_0_2, rightArg, true);
                    	    	copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyexpression.g:2345:20: 
                    {
                    if ( state.backtracking==0 ) { element = leftArg; }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parseop_HyExpression_level_5_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_5"



    // $ANTLR start "parseop_HyExpression_level_9"
    // Hyexpression.g:2350:1: parseop_HyExpression_level_9 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_12 ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_9() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_9_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Hyexpression.g:2353:9: (leftArg= parseop_HyExpression_level_12 ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |) )
            // Hyexpression.g:2354:9: leftArg= parseop_HyExpression_level_12 ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_91871);
            leftArg=parseop_HyExpression_level_12();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:2354:40: ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |)
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==13||LA19_0==24||(LA19_0 >= 26 && LA19_0 <= 29)) ) {
                alt19=1;
            }
            else if ( (LA19_0==EOF||LA19_0==14||LA19_0==16||LA19_0==19||LA19_0==21||LA19_0==25||LA19_0==45) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // Hyexpression.g:2354:41: ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+
                    {
                    // Hyexpression.g:2354:41: ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=7;
                        switch ( input.LA(1) ) {
                        case 24:
                            {
                            alt18=1;
                            }
                            break;
                        case 26:
                            {
                            alt18=2;
                            }
                            break;
                        case 28:
                            {
                            alt18=3;
                            }
                            break;
                        case 29:
                            {
                            alt18=4;
                            }
                            break;
                        case 27:
                            {
                            alt18=5;
                            }
                            break;
                        case 13:
                            {
                            alt18=6;
                            }
                            break;

                        }

                        switch (alt18) {
                    	case 1 :
                    	    // Hyexpression.g:2355:0: () a0= '<' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hyexpression.g:2355:2: ()
                    	    // Hyexpression.g:2355:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,24,FOLLOW_24_in_parseop_HyExpression_level_91884); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyLessExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_16_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[421]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[422]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[423]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[424]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[425]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[426]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[427]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[428]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[429]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[430]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[431]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[432]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[433]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[434]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[435]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[436]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_91895);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyLessExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (leftArg != null) {
                    	    if (leftArg != null) {
                    	    	Object value = leftArg;
                    	    	element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_EXPRESSION__OPERAND1), value);
                    	    	completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_16_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyLessExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (rightArg != null) {
                    	    if (rightArg != null) {
                    	    	Object value = rightArg;
                    	    	element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_EXPRESSION__OPERAND2), value);
                    	    	completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_16_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 2 :
                    	    // Hyexpression.g:2426:0: () a0= '<=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hyexpression.g:2426:2: ()
                    	    // Hyexpression.g:2426:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,26,FOLLOW_26_in_parseop_HyExpression_level_91913); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyLessOrEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_17_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[437]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[438]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[439]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[440]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[441]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[442]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[443]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[444]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[445]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[446]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[447]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[448]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[449]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[450]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[451]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[452]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_91924);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyLessOrEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (leftArg != null) {
                    	    if (leftArg != null) {
                    	    	Object value = leftArg;
                    	    	element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_OR_EQUAL_EXPRESSION__OPERAND1), value);
                    	    	completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_17_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyLessOrEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (rightArg != null) {
                    	    if (rightArg != null) {
                    	    	Object value = rightArg;
                    	    	element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_LESS_OR_EQUAL_EXPRESSION__OPERAND2), value);
                    	    	completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_17_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 3 :
                    	    // Hyexpression.g:2497:0: () a0= '>' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hyexpression.g:2497:2: ()
                    	    // Hyexpression.g:2497:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,28,FOLLOW_28_in_parseop_HyExpression_level_91942); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyGreaterExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_18_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[453]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[454]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[455]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[456]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[457]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[458]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[459]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[460]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[461]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[462]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[463]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[464]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[465]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[466]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[467]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[468]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_91953);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyGreaterExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (leftArg != null) {
                    	    if (leftArg != null) {
                    	    	Object value = leftArg;
                    	    	element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_EXPRESSION__OPERAND1), value);
                    	    	completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_18_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyGreaterExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (rightArg != null) {
                    	    if (rightArg != null) {
                    	    	Object value = rightArg;
                    	    	element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_EXPRESSION__OPERAND2), value);
                    	    	completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_18_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 4 :
                    	    // Hyexpression.g:2568:0: () a0= '>=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hyexpression.g:2568:2: ()
                    	    // Hyexpression.g:2568:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,29,FOLLOW_29_in_parseop_HyExpression_level_91971); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyGreaterOrEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_19_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[469]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[470]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[471]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[472]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[473]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[474]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[475]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[476]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[477]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[478]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[479]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[480]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[481]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[482]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[483]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[484]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_91982);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyGreaterOrEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (leftArg != null) {
                    	    if (leftArg != null) {
                    	    	Object value = leftArg;
                    	    	element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_OR_EQUAL_EXPRESSION__OPERAND1), value);
                    	    	completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_19_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyGreaterOrEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (rightArg != null) {
                    	    if (rightArg != null) {
                    	    	Object value = rightArg;
                    	    	element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_GREATER_OR_EQUAL_EXPRESSION__OPERAND2), value);
                    	    	completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_19_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 5 :
                    	    // Hyexpression.g:2639:0: () a0= '=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hyexpression.g:2639:2: ()
                    	    // Hyexpression.g:2639:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,27,FOLLOW_27_in_parseop_HyExpression_level_92000); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_25_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[485]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[486]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[487]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[488]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[489]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[490]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[491]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[492]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[493]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[494]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[495]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[496]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[497]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[498]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[499]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[500]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92011);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (leftArg != null) {
                    	    if (leftArg != null) {
                    	    	Object value = leftArg;
                    	    	element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUAL_EXPRESSION__OPERAND1), value);
                    	    	completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_25_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (rightArg != null) {
                    	    if (rightArg != null) {
                    	    	Object value = rightArg;
                    	    	element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_EQUAL_EXPRESSION__OPERAND2), value);
                    	    	completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_25_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 6 :
                    	    // Hyexpression.g:2710:0: () a0= '!=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hyexpression.g:2710:2: ()
                    	    // Hyexpression.g:2710:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,13,FOLLOW_13_in_parseop_HyExpression_level_92029); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNotEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_26_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[501]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[502]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[503]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[504]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[505]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[506]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[507]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[508]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[509]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[510]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[511]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[512]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[513]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[514]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[515]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[516]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92040);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNotEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (leftArg != null) {
                    	    if (leftArg != null) {
                    	    	Object value = leftArg;
                    	    	element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EQUAL_EXPRESSION__OPERAND1), value);
                    	    	completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_26_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNotEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (rightArg != null) {
                    	    if (rightArg != null) {
                    	    	Object value = rightArg;
                    	    	element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EQUAL_EXPRESSION__OPERAND2), value);
                    	    	completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_26_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyexpression.g:2780:20: 
                    {
                    if ( state.backtracking==0 ) { element = leftArg; }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parseop_HyExpression_level_9_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_9"



    // $ANTLR start "parseop_HyExpression_level_12"
    // Hyexpression.g:2785:1: parseop_HyExpression_level_12 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_13 ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_12() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_12_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Hyexpression.g:2788:9: (leftArg= parseop_HyExpression_level_13 ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |) )
            // Hyexpression.g:2789:9: leftArg= parseop_HyExpression_level_13 ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122078);
            leftArg=parseop_HyExpression_level_13();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:2789:40: ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |)
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==18||LA21_0==20) ) {
                alt21=1;
            }
            else if ( (LA21_0==EOF||(LA21_0 >= 13 && LA21_0 <= 14)||LA21_0==16||LA21_0==19||LA21_0==21||(LA21_0 >= 24 && LA21_0 <= 29)||LA21_0==45) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // Hyexpression.g:2789:41: ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+
                    {
                    // Hyexpression.g:2789:41: ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=3;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==20) ) {
                            alt20=1;
                        }
                        else if ( (LA20_0==18) ) {
                            alt20=2;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // Hyexpression.g:2790:0: () a0= '-' rightArg= parseop_HyExpression_level_13
                    	    {
                    	    // Hyexpression.g:2790:2: ()
                    	    // Hyexpression.g:2790:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,20,FOLLOW_20_in_parseop_HyExpression_level_122091); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHySubtractionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[517]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[518]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[519]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[520]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[521]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[522]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[523]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[524]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[525]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[526]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[527]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[528]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[529]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[530]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[531]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[532]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122102);
                    	    rightArg=parseop_HyExpression_level_13();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHySubtractionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (leftArg != null) {
                    	    if (leftArg != null) {
                    	    Object value = leftArg;
                    	    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND1), value);
                    	    completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_20_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHySubtractionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (rightArg != null) {
                    	    if (rightArg != null) {
                    	    Object value = rightArg;
                    	    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_SUBTRACTION_EXPRESSION__OPERAND2), value);
                    	    completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_20_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 2 :
                    	    // Hyexpression.g:2861:0: () a0= '+' rightArg= parseop_HyExpression_level_13
                    	    {
                    	    // Hyexpression.g:2861:2: ()
                    	    // Hyexpression.g:2861:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,18,FOLLOW_18_in_parseop_HyExpression_level_122120); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAdditionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_21_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[533]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[534]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[535]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[536]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[537]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[538]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[539]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[540]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[541]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[542]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[543]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[544]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[545]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[546]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[547]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[548]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122131);
                    	    rightArg=parseop_HyExpression_level_13();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAdditionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (leftArg != null) {
                    	    if (leftArg != null) {
                    	    Object value = leftArg;
                    	    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND1), value);
                    	    completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_21_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAdditionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (rightArg != null) {
                    	    if (rightArg != null) {
                    	    Object value = rightArg;
                    	    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ADDITION_EXPRESSION__OPERAND2), value);
                    	    completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_21_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyexpression.g:2931:20: 
                    {
                    if ( state.backtracking==0 ) { element = leftArg; }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, parseop_HyExpression_level_12_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_12"



    // $ANTLR start "parseop_HyExpression_level_13"
    // Hyexpression.g:2936:1: parseop_HyExpression_level_13 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_14 ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_13() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_13_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Hyexpression.g:2939:9: (leftArg= parseop_HyExpression_level_14 ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |) )
            // Hyexpression.g:2940:9: leftArg= parseop_HyExpression_level_14 ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132169);
            leftArg=parseop_HyExpression_level_14();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:2940:40: ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |)
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==17||LA23_0==23||LA23_0==34) ) {
                alt23=1;
            }
            else if ( (LA23_0==EOF||(LA23_0 >= 13 && LA23_0 <= 14)||LA23_0==16||(LA23_0 >= 18 && LA23_0 <= 21)||(LA23_0 >= 24 && LA23_0 <= 29)||LA23_0==45) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }
            switch (alt23) {
                case 1 :
                    // Hyexpression.g:2940:41: ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+
                    {
                    // Hyexpression.g:2940:41: ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=4;
                        switch ( input.LA(1) ) {
                        case 34:
                            {
                            alt22=1;
                            }
                            break;
                        case 17:
                            {
                            alt22=2;
                            }
                            break;
                        case 23:
                            {
                            alt22=3;
                            }
                            break;

                        }

                        switch (alt22) {
                    	case 1 :
                    	    // Hyexpression.g:2941:0: () a0= '\\u0025' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Hyexpression.g:2941:2: ()
                    	    // Hyexpression.g:2941:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,34,FOLLOW_34_in_parseop_HyExpression_level_132182); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyModuloExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_22_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[549]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[550]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[551]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[552]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[553]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[554]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[555]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[556]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[557]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[558]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[559]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[560]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[561]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[562]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[563]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[564]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132193);
                    	    rightArg=parseop_HyExpression_level_14();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyModuloExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (leftArg != null) {
                    	    if (leftArg != null) {
                    	    Object value = leftArg;
                    	    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND1), value);
                    	    completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_22_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyModuloExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (rightArg != null) {
                    	    if (rightArg != null) {
                    	    Object value = rightArg;
                    	    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MODULO_EXPRESSION__OPERAND2), value);
                    	    completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_22_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 2 :
                    	    // Hyexpression.g:3012:0: () a0= '*' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Hyexpression.g:3012:2: ()
                    	    // Hyexpression.g:3012:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,17,FOLLOW_17_in_parseop_HyExpression_level_132211); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMultiplicationExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_23_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[565]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[566]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[567]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[568]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[569]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[570]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[571]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[572]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[573]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[574]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[575]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[576]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[577]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[578]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[579]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[580]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132222);
                    	    rightArg=parseop_HyExpression_level_14();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMultiplicationExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (leftArg != null) {
                    	    if (leftArg != null) {
                    	    Object value = leftArg;
                    	    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND1), value);
                    	    completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_23_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMultiplicationExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (rightArg != null) {
                    	    if (rightArg != null) {
                    	    Object value = rightArg;
                    	    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MULTIPLICATION_EXPRESSION__OPERAND2), value);
                    	    completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_23_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 3 :
                    	    // Hyexpression.g:3083:0: () a0= '/' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Hyexpression.g:3083:2: ()
                    	    // Hyexpression.g:3083:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,23,FOLLOW_23_in_parseop_HyExpression_level_132240); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyDivisionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_24_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[581]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[582]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[583]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[584]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[585]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[586]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[587]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[588]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[589]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[590]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[591]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[592]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[593]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[594]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[595]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[596]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132251);
                    	    rightArg=parseop_HyExpression_level_14();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyDivisionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (leftArg != null) {
                    	    if (leftArg != null) {
                    	    Object value = leftArg;
                    	    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND1), value);
                    	    completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_24_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    	    }
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyDivisionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    if (rightArg != null) {
                    	    if (rightArg != null) {
                    	    Object value = rightArg;
                    	    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_DIVISION_EXPRESSION__OPERAND2), value);
                    	    completedElement(value, true);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_24_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyexpression.g:3153:20: 
                    {
                    if ( state.backtracking==0 ) { element = leftArg; }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, parseop_HyExpression_level_13_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_13"



    // $ANTLR start "parseop_HyExpression_level_14"
    // Hyexpression.g:3158:1: parseop_HyExpression_level_14 returns [eu.hyvar.feature.expression.HyExpression element = null] : (a0= '!' arg= parseop_HyExpression_level_15 |a2= '-' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 );
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_14() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_14_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression arg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Hyexpression.g:3161:0: (a0= '!' arg= parseop_HyExpression_level_15 |a2= '-' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 )
            int alt24=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt24=1;
                }
                break;
            case 20:
                {
                alt24=2;
                }
                break;
            case IDENTIFIER_TOKEN:
            case INTEGER_LITERAL:
            case QUOTED_34_34:
            case 15:
            case 30:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 44:
                {
                alt24=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // Hyexpression.g:3162:0: a0= '!' arg= parseop_HyExpression_level_15
                    {
                    a0=(Token)match(input,12,FOLLOW_12_in_parseop_HyExpression_level_142289); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNotExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_4_0_0_0, null, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    }

                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[597]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[598]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[599]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[600]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[601]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[602]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[603]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[604]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[605]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[606]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[607]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[608]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[609]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[610]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[611]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[612]);
                    }

                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142300);
                    arg=parseop_HyExpression_level_15();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNotExpression();
                    startIncompleteElement(element);
                    }
                    if (arg != null) {
                    if (arg != null) {
                    Object value = arg;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NOT_EXPRESSION__OPERAND), value);
                    completedElement(value, true);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_4_0_0_1, arg, true);
                    copyLocalizationInfos(arg, element);
                    }
                    }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:3211:0: a2= '-' arg= parseop_HyExpression_level_15
                    {
                    a2=(Token)match(input,20,FOLLOW_20_in_parseop_HyExpression_level_142309); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNegationExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_5_0_0_0, null, true);
                    copyLocalizationInfos((CommonToken)a2, element);
                    }

                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[613]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[614]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[615]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[616]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[617]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[618]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[619]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[620]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[621]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[622]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[623]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[624]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[625]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[626]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[627]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[628]);
                    }

                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142320);
                    arg=parseop_HyExpression_level_15();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNegationExpression();
                    startIncompleteElement(element);
                    }
                    if (arg != null) {
                    if (arg != null) {
                    Object value = arg;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NEGATION_EXPRESSION__OPERAND), value);
                    completedElement(value, true);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_5_0_0_1, arg, true);
                    copyLocalizationInfos(arg, element);
                    }
                    }

                    }
                    break;
                case 3 :
                    // Hyexpression.g:3261:5: arg= parseop_HyExpression_level_15
                    {
                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142330);
                    arg=parseop_HyExpression_level_15();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = arg; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, parseop_HyExpression_level_14_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_14"



    // $ANTLR start "parseop_HyExpression_level_15"
    // Hyexpression.g:3264:1: parseop_HyExpression_level_15 returns [eu.hyvar.feature.expression.HyExpression element = null] : (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression |c4= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression |c5= parse_eu_hyvar_feature_expression_HyValueExpression |c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression |c7= parse_eu_hyvar_feature_expression_HyMinimumExpression |c8= parse_eu_hyvar_feature_expression_HyMaximumExpression |c9= parse_eu_hyvar_feature_expression_HyIfPossibleExpression );
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_15() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_15_StartIndex = input.index();

        eu.hyvar.feature.expression.HyNestedExpression c0 =null;

        eu.hyvar.feature.expression.HyFeatureReferenceExpression c1 =null;

        eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression c2 =null;

        eu.hyvar.feature.expression.HyContextInformationReferenceExpression c3 =null;

        eu.hyvar.feature.expression.HyAttributeReferenceExpression c4 =null;

        eu.hyvar.feature.expression.HyValueExpression c5 =null;

        eu.hyvar.feature.expression.HyBooleanValueExpression c6 =null;

        eu.hyvar.feature.expression.HyMinimumExpression c7 =null;

        eu.hyvar.feature.expression.HyMaximumExpression c8 =null;

        eu.hyvar.feature.expression.HyIfPossibleExpression c9 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Hyexpression.g:3267:0: (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression |c4= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression |c5= parse_eu_hyvar_feature_expression_HyValueExpression |c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression |c7= parse_eu_hyvar_feature_expression_HyMinimumExpression |c8= parse_eu_hyvar_feature_expression_HyMaximumExpression |c9= parse_eu_hyvar_feature_expression_HyIfPossibleExpression )
            int alt25=10;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt25=1;
                }
                break;
            case QUOTED_34_34:
                {
                int LA25_2 = input.LA(2);

                if ( (LA25_2==EOF||(LA25_2 >= 13 && LA25_2 <= 14)||(LA25_2 >= 16 && LA25_2 <= 21)||(LA25_2 >= 23 && LA25_2 <= 29)||(LA25_2 >= 33 && LA25_2 <= 34)||LA25_2==45) ) {
                    alt25=2;
                }
                else if ( (LA25_2==22) ) {
                    alt25=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 2, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER_TOKEN:
                {
                int LA25_3 = input.LA(2);

                if ( (LA25_3==EOF||(LA25_3 >= 13 && LA25_3 <= 14)||(LA25_3 >= 16 && LA25_3 <= 21)||(LA25_3 >= 23 && LA25_3 <= 29)||(LA25_3 >= 33 && LA25_3 <= 34)||LA25_3==45) ) {
                    alt25=2;
                }
                else if ( (LA25_3==22) ) {
                    alt25=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 3, input);

                    throw nvae;

                }
                }
                break;
            case 30:
                {
                alt25=3;
                }
                break;
            case 37:
                {
                alt25=4;
                }
                break;
            case INTEGER_LITERAL:
            case 38:
                {
                alt25=6;
                }
                break;
            case 44:
                {
                int LA25_7 = input.LA(2);

                if ( (synpred45_Hyexpression()) ) {
                    alt25=6;
                }
                else if ( (synpred46_Hyexpression()) ) {
                    alt25=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 7, input);

                    throw nvae;

                }
                }
                break;
            case 39:
                {
                int LA25_8 = input.LA(2);

                if ( (synpred45_Hyexpression()) ) {
                    alt25=6;
                }
                else if ( (synpred46_Hyexpression()) ) {
                    alt25=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 8, input);

                    throw nvae;

                }
                }
                break;
            case 42:
                {
                alt25=8;
                }
                break;
            case 41:
                {
                alt25=9;
                }
                break;
            case 40:
                {
                alt25=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }

            switch (alt25) {
                case 1 :
                    // Hyexpression.g:3268:0: c0= parse_eu_hyvar_feature_expression_HyNestedExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_152352);
                    c0=parse_eu_hyvar_feature_expression_HyNestedExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:3269:2: c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_152360);
                    c1=parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hyexpression.g:3270:2: c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_152368);
                    c2=parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Hyexpression.g:3271:2: c3= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyExpression_level_152376);
                    c3=parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Hyexpression.g:3272:2: c4= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyExpression_level_152384);
                    c4=parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Hyexpression.g:3273:2: c5= parse_eu_hyvar_feature_expression_HyValueExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyExpression_level_152392);
                    c5=parse_eu_hyvar_feature_expression_HyValueExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Hyexpression.g:3274:2: c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_152400);
                    c6=parse_eu_hyvar_feature_expression_HyBooleanValueExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Hyexpression.g:3275:2: c7= parse_eu_hyvar_feature_expression_HyMinimumExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyMinimumExpression_in_parseop_HyExpression_level_152408);
                    c7=parse_eu_hyvar_feature_expression_HyMinimumExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Hyexpression.g:3276:2: c8= parse_eu_hyvar_feature_expression_HyMaximumExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyMaximumExpression_in_parseop_HyExpression_level_152416);
                    c8=parse_eu_hyvar_feature_expression_HyMaximumExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c8; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 10 :
                    // Hyexpression.g:3277:2: c9= parse_eu_hyvar_feature_expression_HyIfPossibleExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyIfPossibleExpression_in_parseop_HyExpression_level_152424);
                    c9=parse_eu_hyvar_feature_expression_HyIfPossibleExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c9; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, parseop_HyExpression_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_15"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyNestedExpression"
    // Hyexpression.g:3280:1: parse_eu_hyvar_feature_expression_HyNestedExpression returns [eu.hyvar.feature.expression.HyNestedExpression element = null] : a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyNestedExpression parse_eu_hyvar_feature_expression_HyNestedExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyNestedExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Hyexpression.g:3283:4: (a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Hyexpression.g:3284:4: a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedExpression2446); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_6_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[629]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[630]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[631]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[632]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[633]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[634]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[635]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[636]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[637]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[638]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[639]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[640]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[641]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[642]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[643]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[644]);
            }

            // Hyexpression.g:3313:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyexpression.g:3314:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression2459);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            if (a1_0 != null) {
            if (a1_0 != null) {
            Object value = a1_0;
            element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NESTED_EXPRESSION__OPERAND), value);
            completedElement(value, true);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_6_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[645]);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression2471); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_6_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[646]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[647]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[648]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[649]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[650]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[651]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[652]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[653]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[654]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[655]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[656]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[657]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[658]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[659]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[660]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[661]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[662]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[663]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[664]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[665]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyNestedExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression"
    // Hyexpression.g:3374:1: parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyFeatureReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? ;
    public final eu.hyvar.feature.expression.HyFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        eu.hyvar.feature.expression.HyVersionRestriction a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Hyexpression.g:3377:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? )
            // Hyexpression.g:3378:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            {
            // Hyexpression.g:3378:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==QUOTED_34_34) ) {
                alt26=1;
            }
            else if ( (LA26_0==IDENTIFIER_TOKEN) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }
            switch (alt26) {
                case 1 :
                    // Hyexpression.g:3379:0: (a0= QUOTED_34_34 )
                    {
                    // Hyexpression.g:3379:4: (a0= QUOTED_34_34 )
                    // Hyexpression.g:3380:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2501); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a0 != null) {
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a0, element);
                    copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[666]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[667]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[668]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[669]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[670]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[671]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[672]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[673]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[674]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[675]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[676]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[677]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[678]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[679]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[680]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[681]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[682]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[683]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[684]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[685]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[686]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[687]);
                    }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:3441:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyexpression.g:3441:2: (a1= IDENTIFIER_TOKEN )
                    // Hyexpression.g:3442:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2518); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[688]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[689]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[690]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[691]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[692]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[693]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[694]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[695]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[696]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[697]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[698]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[699]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[700]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[701]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[702]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[703]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[704]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[705]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[706]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[707]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[708]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[709]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[710]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[711]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[712]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[713]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[714]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[715]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[716]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[717]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[718]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[719]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[720]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[721]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[722]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[723]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[724]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[725]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[726]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[727]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[728]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[729]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[730]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[731]);
            }

            // Hyexpression.g:3529:0: ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==33) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // Hyexpression.g:3530:0: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    {
                    // Hyexpression.g:3530:6: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    // Hyexpression.g:3531:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    {
                    // Hyexpression.g:3531:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    // Hyexpression.g:3532:6: a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2542);
                    a2_0=parse_eu_hyvar_feature_expression_HyVersionRestriction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a2_0 != null) {
                    if (a2_0 != null) {
                    Object value = a2_0;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION), value);
                    completedElement(value, true);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_0_0, a2_0, true);
                    copyLocalizationInfos(a2_0, element);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[732]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[733]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[734]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[735]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[736]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[737]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[738]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[739]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[740]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[741]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[742]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[743]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[744]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[745]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[746]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[747]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[748]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[749]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[750]);
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[751]);
                    }

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[752]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[753]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[754]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[755]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[756]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[757]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[758]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[759]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[760]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[761]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[762]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[763]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[764]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[765]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[766]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[767]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[768]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[769]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[770]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[771]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression"
    // Hyexpression.g:3604:1: parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element = null] : a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ;
    public final eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyVersionRestriction a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Hyexpression.g:3607:4: (a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
            // Hyexpression.g:3608:4: a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            {
            a0=(Token)match(input,30,FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2577); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_8_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[772]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[773]);
            }

            // Hyexpression.g:3623:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==QUOTED_34_34) ) {
                alt28=1;
            }
            else if ( (LA28_0==IDENTIFIER_TOKEN) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }
            switch (alt28) {
                case 1 :
                    // Hyexpression.g:3624:0: (a1= QUOTED_34_34 )
                    {
                    // Hyexpression.g:3624:4: (a1= QUOTED_34_34 )
                    // Hyexpression.g:3625:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2592); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[774]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[775]);
                    }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:3666:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hyexpression.g:3666:2: (a2= IDENTIFIER_TOKEN )
                    // Hyexpression.g:3667:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2609); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a2 != null) {
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a2, element);
                    copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[776]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[777]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[778]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[779]);
            }

            // Hyexpression.g:3714:6: (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            // Hyexpression.g:3715:6: a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2629);
            a3_0=parse_eu_hyvar_feature_expression_HyVersionRestriction();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
            startIncompleteElement(element);
            }
            if (a3_0 != null) {
            if (a3_0 != null) {
            Object value = a3_0;
            element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__VERSION_RESTRICTION), value);
            completedElement(value, true);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_8_0_0_2, a3_0, true);
            copyLocalizationInfos(a3_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[780]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[781]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[782]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[783]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[784]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[785]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[786]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[787]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[788]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[789]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[790]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[791]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[792]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[793]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[794]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[795]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[796]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[797]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[798]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[799]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"
    // Hyexpression.g:3761:1: parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression returns [eu.hyvar.feature.expression.HyContextInformationReferenceExpression element = null] : a0= 'context:' (a1= IDENTIFIER_TOKEN ) ;
    public final eu.hyvar.feature.expression.HyContextInformationReferenceExpression parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyContextInformationReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Hyexpression.g:3764:4: (a0= 'context:' (a1= IDENTIFIER_TOKEN ) )
            // Hyexpression.g:3765:4: a0= 'context:' (a1= IDENTIFIER_TOKEN )
            {
            a0=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression2656); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_9_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[800]);
            }

            // Hyexpression.g:3779:4: (a1= IDENTIFIER_TOKEN )
            // Hyexpression.g:3780:4: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression2669); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
            startIncompleteElement(element);
            }
            if (a1 != null) {
            eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            tokenResolver.setOptions(getOptions());
            eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
            tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
            Object resolvedObject = result.getResolvedToken();
            if (resolvedObject == null) {
            addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
            }
            String resolved = (String) resolvedObject;
            eu.hyvar.context.HyContextualInformation proxy = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
            collectHiddenTokens(element);
            registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextInformationReferenceExpressionContextInformationReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), resolved, proxy);
            if (proxy != null) {
            Object value = proxy;
            element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), value);
            completedElement(value, false);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_9_0_0_1, proxy, true);
            copyLocalizationInfos((CommonToken) a1, element);
            copyLocalizationInfos((CommonToken) a1, proxy);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[801]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[802]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[803]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[804]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[805]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[806]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[807]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[808]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[809]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[810]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[811]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[812]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[813]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[814]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[815]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[816]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[817]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[818]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[819]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[820]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression"
    // Hyexpression.g:3840:1: parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression returns [eu.hyvar.feature.expression.HyAttributeReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) ;
    public final eu.hyvar.feature.expression.HyAttributeReferenceExpression parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyAttributeReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Hyexpression.g:3843:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) )
            // Hyexpression.g:3844:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN )
            {
            // Hyexpression.g:3844:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==QUOTED_34_34) ) {
                alt29=1;
            }
            else if ( (LA29_0==IDENTIFIER_TOKEN) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // Hyexpression.g:3845:0: (a0= QUOTED_34_34 )
                    {
                    // Hyexpression.g:3845:4: (a0= QUOTED_34_34 )
                    // Hyexpression.g:3846:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2701); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a0 != null) {
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a0, element);
                    copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[821]);
                    }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:3886:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyexpression.g:3886:2: (a1= IDENTIFIER_TOKEN )
                    // Hyexpression.g:3887:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2718); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[822]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[823]);
            }

            a2=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2736); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_10_0_0_1, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[824]);
            }

            // Hyexpression.g:3946:4: (a3= IDENTIFIER_TOKEN )
            // Hyexpression.g:3947:4: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2749); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
            startIncompleteElement(element);
            }
            if (a3 != null) {
            eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            tokenResolver.setOptions(getOptions());
            eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
            tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), result);
            Object resolvedObject = result.getResolvedToken();
            if (resolvedObject == null) {
            addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            }
            String resolved = (String) resolvedObject;
            eu.hyvar.feature.HyFeatureAttribute proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyNumberAttribute();
            collectHiddenTokens(element);
            registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeatureAttribute>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionAttributeReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), resolved, proxy);
            if (proxy != null) {
            Object value = proxy;
            element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), value);
            completedElement(value, false);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_10_0_0_2, proxy, true);
            copyLocalizationInfos((CommonToken) a3, element);
            copyLocalizationInfos((CommonToken) a3, proxy);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[825]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[826]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[827]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[828]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[829]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[830]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[831]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[832]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[833]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[834]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[835]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[836]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[837]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[838]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[839]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[840]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[841]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[842]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[843]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[844]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyValueExpression"
    // Hyexpression.g:4007:1: parse_eu_hyvar_feature_expression_HyValueExpression returns [eu.hyvar.feature.expression.HyValueExpression element = null] : (a0_0= parse_eu_hyvar_dataValues_HyValue ) ;
    public final eu.hyvar.feature.expression.HyValueExpression parse_eu_hyvar_feature_expression_HyValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Hyexpression.g:4010:6: ( (a0_0= parse_eu_hyvar_dataValues_HyValue ) )
            // Hyexpression.g:4011:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            {
            // Hyexpression.g:4011:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            // Hyexpression.g:4012:6: a0_0= parse_eu_hyvar_dataValues_HyValue
            {
            pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression2779);
            a0_0=parse_eu_hyvar_dataValues_HyValue();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyValueExpression();
            startIncompleteElement(element);
            }
            if (a0_0 != null) {
            if (a0_0 != null) {
            Object value = a0_0;
            element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VALUE_EXPRESSION__VALUE), value);
            completedElement(value, true);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_11_0_0_0, a0_0, true);
            copyLocalizationInfos(a0_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[845]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[846]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[847]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[848]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[849]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[850]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[851]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[852]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[853]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[854]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[855]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[856]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[857]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[858]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[859]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[860]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[861]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[862]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[863]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[864]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyValueExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"
    // Hyexpression.g:4058:1: parse_eu_hyvar_feature_expression_HyBooleanValueExpression returns [eu.hyvar.feature.expression.HyBooleanValueExpression element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.feature.expression.HyBooleanValueExpression parse_eu_hyvar_feature_expression_HyBooleanValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyBooleanValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Hyexpression.g:4061:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hyexpression.g:4062:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hyexpression.g:4062:0: ( (a0= 'true' |a1= 'false' ) )
            // Hyexpression.g:4063:0: (a0= 'true' |a1= 'false' )
            {
            // Hyexpression.g:4063:0: (a0= 'true' |a1= 'false' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==44) ) {
                alt30=1;
            }
            else if ( (LA30_0==39) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }
            switch (alt30) {
                case 1 :
                    // Hyexpression.g:4064:0: a0= 'true'
                    {
                    a0=(Token)match(input,44,FOLLOW_44_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2810); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_12_0_0_0, true, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    // set value of boolean attribute
                    Object value = true;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:4077:2: a1= 'false'
                    {
                    a1=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2819); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_12_0_0_0, false, true);
                    copyLocalizationInfos((CommonToken)a1, element);
                    // set value of boolean attribute
                    Object value = false;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), value);
                    completedElement(value, false);
                    }

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[865]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[866]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[867]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[868]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[869]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[870]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[871]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[872]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[873]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[874]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[875]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[876]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[877]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[878]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[879]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[880]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[881]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[882]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[883]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[884]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyMinimumExpression"
    // Hyexpression.g:4118:1: parse_eu_hyvar_feature_expression_HyMinimumExpression returns [eu.hyvar.feature.expression.HyMinimumExpression element = null] : a0= 'min(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyMinimumExpression parse_eu_hyvar_feature_expression_HyMinimumExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyMinimumExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyMinimumExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Hyexpression.g:4121:4: (a0= 'min(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Hyexpression.g:4122:4: a0= 'min(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,42,FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyMinimumExpression2849); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMinimumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_13_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[885]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[886]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[887]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[888]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[889]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[890]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[891]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[892]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[893]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[894]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[895]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[896]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[897]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[898]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[899]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[900]);
            }

            // Hyexpression.g:4151:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyexpression.g:4152:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMinimumExpression2862);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMinimumExpression();
            startIncompleteElement(element);
            }
            if (a1_0 != null) {
            if (a1_0 != null) {
            Object value = a1_0;
            element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MINIMUM_EXPRESSION__OPERAND), value);
            completedElement(value, true);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_13_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[901]);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyMinimumExpression2874); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMinimumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_13_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[902]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[903]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[904]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[905]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[906]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[907]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[908]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[909]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[910]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[911]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[912]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[913]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[914]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[915]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[916]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[917]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[918]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[919]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[920]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[921]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, parse_eu_hyvar_feature_expression_HyMinimumExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyMinimumExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyMaximumExpression"
    // Hyexpression.g:4212:1: parse_eu_hyvar_feature_expression_HyMaximumExpression returns [eu.hyvar.feature.expression.HyMaximumExpression element = null] : a0= 'max(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyMaximumExpression parse_eu_hyvar_feature_expression_HyMaximumExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyMaximumExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyMaximumExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Hyexpression.g:4215:4: (a0= 'max(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Hyexpression.g:4216:4: a0= 'max(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyMaximumExpression2900); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMaximumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_14_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[922]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[923]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[924]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[925]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[926]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[927]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[928]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[929]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[930]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[931]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[932]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[933]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[934]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[935]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[936]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[937]);
            }

            // Hyexpression.g:4245:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyexpression.g:4246:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMaximumExpression2913);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMaximumExpression();
            startIncompleteElement(element);
            }
            if (a1_0 != null) {
            if (a1_0 != null) {
            Object value = a1_0;
            element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_MAXIMUM_EXPRESSION__OPERAND), value);
            completedElement(value, true);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_14_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[938]);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyMaximumExpression2925); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMaximumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_14_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[939]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[940]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[941]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[942]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[943]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[944]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[945]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[946]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[947]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[948]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[949]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[950]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[951]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[952]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[953]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[954]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[955]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[956]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[957]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[958]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, parse_eu_hyvar_feature_expression_HyMaximumExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyMaximumExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyIfPossibleExpression"
    // Hyexpression.g:4306:1: parse_eu_hyvar_feature_expression_HyIfPossibleExpression returns [eu.hyvar.feature.expression.HyIfPossibleExpression element = null] : a0= 'ifPossible(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )* a4= ')' ;
    public final eu.hyvar.feature.expression.HyIfPossibleExpression parse_eu_hyvar_feature_expression_HyIfPossibleExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyIfPossibleExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyIfPossibleExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;

        eu.hyvar.feature.expression.HyExpression a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Hyexpression.g:4309:4: (a0= 'ifPossible(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )* a4= ')' )
            // Hyexpression.g:4310:4: a0= 'ifPossible(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )* a4= ')'
            {
            a0=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression2951); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_15_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[959]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[960]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[961]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[962]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[963]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[964]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[965]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[966]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[967]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[968]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[969]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[970]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[971]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[972]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[973]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[974]);
            }

            // Hyexpression.g:4339:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyexpression.g:4340:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression2964);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
            startIncompleteElement(element);
            }
            if (a1_0 != null) {
            if (a1_0 != null) {
            Object value = a1_0;
            addObjectToList(element, eu.hyvar.feature.expression.HyExpressionPackage.HY_IF_POSSIBLE_EXPRESSION__OPERANDS, value);
            completedElement(value, true);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_15_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[975]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[976]);
            }

            // Hyexpression.g:4366:0: ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==19) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // Hyexpression.g:4367:0: (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) )
            	    {
            	    // Hyexpression.g:4367:4: (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) )
            	    // Hyexpression.g:4368:4: a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression )
            	    {
            	    a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression2980); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    if (element == null) {
            	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
            	    startIncompleteElement(element);
            	    }
            	    collectHiddenTokens(element);
            	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_0, null, true);
            	    copyLocalizationInfos((CommonToken)a2, element);
            	    }

            	    if ( state.backtracking==0 ) {
            	    // expected elements (follow set)
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[977]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[978]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[979]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[980]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[981]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[982]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[983]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[984]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[985]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[986]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[987]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[988]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[989]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[990]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[991]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[992]);
            	    }

            	    // Hyexpression.g:4397:6: (a3_0= parse_eu_hyvar_feature_expression_HyExpression )
            	    // Hyexpression.g:4398:6: a3_0= parse_eu_hyvar_feature_expression_HyExpression
            	    {
            	    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression2993);
            	    a3_0=parse_eu_hyvar_feature_expression_HyExpression();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    if (terminateParsing) {
            	    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            	    }
            	    if (element == null) {
            	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
            	    startIncompleteElement(element);
            	    }
            	    if (a3_0 != null) {
            	    if (a3_0 != null) {
            	    Object value = a3_0;
            	    addObjectToList(element, eu.hyvar.feature.expression.HyExpressionPackage.HY_IF_POSSIBLE_EXPRESSION__OPERANDS, value);
            	    completedElement(value, true);
            	    }
            	    collectHiddenTokens(element);
            	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_1, a3_0, true);
            	    copyLocalizationInfos(a3_0, element);
            	    }
            	    }

            	    }


            	    if ( state.backtracking==0 ) {
            	    // expected elements (follow set)
            	    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[993]);
            	    addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[994]);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[995]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[996]);
            }

            a4=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3013); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_15_0_0_3, null, true);
            copyLocalizationInfos((CommonToken)a4, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[997]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[998]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[999]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1000]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1001]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1002]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1003]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1004]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1005]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1006]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1007]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1008]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1009]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1010]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1011]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1012]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1013]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1014]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1015]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1016]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 24, parse_eu_hyvar_feature_expression_HyIfPossibleExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyIfPossibleExpression"



    // $ANTLR start "parseop_HyValue_level_15"
    // Hyexpression.g:4467:1: parseop_HyValue_level_15 returns [eu.hyvar.dataValues.HyValue element = null] : (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue );
    public final eu.hyvar.dataValues.HyValue parseop_HyValue_level_15() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parseop_HyValue_level_15_StartIndex = input.index();

        eu.hyvar.dataValues.HyNumberValue c0 =null;

        eu.hyvar.dataValues.HyBooleanValue c1 =null;

        eu.hyvar.dataValues.HyEnumValue c2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }

            // Hyexpression.g:4470:0: (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue )
            int alt32=3;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
                {
                alt32=1;
                }
                break;
            case 39:
            case 44:
                {
                alt32=2;
                }
                break;
            case 38:
                {
                alt32=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;

            }

            switch (alt32) {
                case 1 :
                    // Hyexpression.g:4471:0: c0= parse_eu_hyvar_dataValues_HyNumberValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_153039);
                    c0=parse_eu_hyvar_dataValues_HyNumberValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:4472:2: c1= parse_eu_hyvar_dataValues_HyBooleanValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_153047);
                    c1=parse_eu_hyvar_dataValues_HyBooleanValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hyexpression.g:4473:2: c2= parse_eu_hyvar_dataValues_HyEnumValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_153055);
                    c2=parse_eu_hyvar_dataValues_HyEnumValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, parseop_HyValue_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyValue_level_15"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyNumberValue"
    // Hyexpression.g:4476:1: parse_eu_hyvar_dataValues_HyNumberValue returns [eu.hyvar.dataValues.HyNumberValue element = null] : (a0= INTEGER_LITERAL ) ;
    public final eu.hyvar.dataValues.HyNumberValue parse_eu_hyvar_dataValues_HyNumberValue() throws RecognitionException {
        eu.hyvar.dataValues.HyNumberValue element =  null;

        int parse_eu_hyvar_dataValues_HyNumberValue_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Hyexpression.g:4479:4: ( (a0= INTEGER_LITERAL ) )
            // Hyexpression.g:4480:4: (a0= INTEGER_LITERAL )
            {
            // Hyexpression.g:4480:4: (a0= INTEGER_LITERAL )
            // Hyexpression.g:4481:4: a0= INTEGER_LITERAL
            {
            a0=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3079); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyNumberValue();
            startIncompleteElement(element);
            }
            if (a0 != null) {
            eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            tokenResolver.setOptions(getOptions());
            eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
            tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_NUMBER_VALUE__VALUE), result);
            Object resolvedObject = result.getResolvedToken();
            if (resolvedObject == null) {
            addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
            }
            java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            if (resolved != null) {
            Object value = resolved;
            element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_NUMBER_VALUE__VALUE), value);
            completedElement(value, false);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_0_0_0_0, resolved, true);
            copyLocalizationInfos((CommonToken) a0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1017]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1018]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1019]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1020]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1021]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1022]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1023]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1024]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1025]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1026]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1027]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1028]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1029]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1030]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1031]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1032]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1033]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1034]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1035]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1036]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, parse_eu_hyvar_dataValues_HyNumberValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyNumberValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyBooleanValue"
    // Hyexpression.g:4537:1: parse_eu_hyvar_dataValues_HyBooleanValue returns [eu.hyvar.dataValues.HyBooleanValue element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.dataValues.HyBooleanValue parse_eu_hyvar_dataValues_HyBooleanValue() throws RecognitionException {
        eu.hyvar.dataValues.HyBooleanValue element =  null;

        int parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Hyexpression.g:4540:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hyexpression.g:4541:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hyexpression.g:4541:0: ( (a0= 'true' |a1= 'false' ) )
            // Hyexpression.g:4542:0: (a0= 'true' |a1= 'false' )
            {
            // Hyexpression.g:4542:0: (a0= 'true' |a1= 'false' )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==44) ) {
                alt33=1;
            }
            else if ( (LA33_0==39) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }
            switch (alt33) {
                case 1 :
                    // Hyexpression.g:4543:0: a0= 'true'
                    {
                    a0=(Token)match(input,44,FOLLOW_44_in_parse_eu_hyvar_dataValues_HyBooleanValue3111); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_1_0_0_0, true, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    // set value of boolean attribute
                    Object value = true;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:4556:2: a1= 'false'
                    {
                    a1=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyBooleanValue3120); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_1_0_0_0, false, true);
                    copyLocalizationInfos((CommonToken)a1, element);
                    // set value of boolean attribute
                    Object value = false;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), value);
                    completedElement(value, false);
                    }

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1037]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1038]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1039]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1040]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1041]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1042]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1043]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1044]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1045]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1046]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1047]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1048]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1049]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1050]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1051]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1052]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1053]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1054]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1055]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1056]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyBooleanValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumValue"
    // Hyexpression.g:4597:1: parse_eu_hyvar_dataValues_HyEnumValue returns [eu.hyvar.dataValues.HyEnumValue element = null] : a0= 'enum:' (a1= IDENTIFIER_TOKEN ) a2= '.' (a3= IDENTIFIER_TOKEN ) ;
    public final eu.hyvar.dataValues.HyEnumValue parse_eu_hyvar_dataValues_HyEnumValue() throws RecognitionException {
        eu.hyvar.dataValues.HyEnumValue element =  null;

        int parse_eu_hyvar_dataValues_HyEnumValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Hyexpression.g:4600:4: (a0= 'enum:' (a1= IDENTIFIER_TOKEN ) a2= '.' (a3= IDENTIFIER_TOKEN ) )
            // Hyexpression.g:4601:4: a0= 'enum:' (a1= IDENTIFIER_TOKEN ) a2= '.' (a3= IDENTIFIER_TOKEN )
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnumValue3150); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1057]);
            }

            // Hyexpression.g:4615:4: (a1= IDENTIFIER_TOKEN )
            // Hyexpression.g:4616:4: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3163); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            if (a1 != null) {
            eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            tokenResolver.setOptions(getOptions());
            eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
            tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
            Object resolvedObject = result.getResolvedToken();
            if (resolvedObject == null) {
            addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
            }
            String resolved = (String) resolvedObject;
            eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            collectHiddenTokens(element);
            registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
            if (proxy != null) {
            Object value = proxy;
            element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
            completedElement(value, false);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_2_0_0_1, proxy, true);
            copyLocalizationInfos((CommonToken) a1, element);
            copyLocalizationInfos((CommonToken) a1, proxy);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1058]);
            }

            a2=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue3176); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1059]);
            }

            // Hyexpression.g:4669:4: (a3= IDENTIFIER_TOKEN )
            // Hyexpression.g:4670:4: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3189); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            if (a3 != null) {
            eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            tokenResolver.setOptions(getOptions());
            eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
            tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
            Object resolvedObject = result.getResolvedToken();
            if (resolvedObject == null) {
            addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            }
            String resolved = (String) resolvedObject;
            eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            collectHiddenTokens(element);
            registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
            if (proxy != null) {
            Object value = proxy;
            element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
            completedElement(value, false);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_2_0_0_3, proxy, true);
            copyLocalizationInfos((CommonToken) a3, element);
            copyLocalizationInfos((CommonToken) a3, proxy);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1060]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1061]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1062]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1063]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1064]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1065]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1066]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1067]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1068]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1069]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1070]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1071]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1072]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1073]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1074]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1075]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1076]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1077]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1078]);
            addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1079]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 28, parse_eu_hyvar_dataValues_HyEnumValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumValue"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyExpression"
    // Hyexpression.g:4730:1: parse_eu_hyvar_feature_expression_HyExpression returns [eu.hyvar.feature.expression.HyExpression element = null] : c= parseop_HyExpression_level_0 ;
    public final eu.hyvar.feature.expression.HyExpression parse_eu_hyvar_feature_expression_HyExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyExpression_StartIndex = input.index();

        eu.hyvar.feature.expression.HyExpression c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Hyexpression.g:4731:3: (c= parseop_HyExpression_level_0 )
            // Hyexpression.g:4732:3: c= parseop_HyExpression_level_0
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression3213);
            c=parseop_HyExpression_level_0();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c; /* this rule is an expression root */ }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 29, parse_eu_hyvar_feature_expression_HyExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyVersionRestriction"
    // Hyexpression.g:4736:1: parse_eu_hyvar_feature_expression_HyVersionRestriction returns [eu.hyvar.feature.expression.HyVersionRestriction element = null] : (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction );
    public final eu.hyvar.feature.expression.HyVersionRestriction parse_eu_hyvar_feature_expression_HyVersionRestriction() throws RecognitionException {
        eu.hyvar.feature.expression.HyVersionRestriction element =  null;

        int parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex = input.index();

        eu.hyvar.feature.expression.HyRelativeVersionRestriction c0 =null;

        eu.hyvar.feature.expression.HyVersionRangeRestriction c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Hyexpression.g:4737:0: (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==33) ) {
                switch ( input.LA(2) ) {
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                    {
                    alt34=1;
                    }
                    break;
                case QUOTED_34_34:
                    {
                    int LA34_3 = input.LA(3);

                    if ( (LA34_3==35) ) {
                        alt34=1;
                    }
                    else if ( (LA34_3==20) ) {
                        alt34=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 3, input);

                        throw nvae;

                    }
                    }
                    break;
                case 36:
                    {
                    alt34=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }
            switch (alt34) {
                case 1 :
                    // Hyexpression.g:4738:0: c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3232);
                    c0=parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:4739:2: c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3240);
                    c1=parse_eu_hyvar_feature_expression_HyVersionRangeRestriction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyVersionRestriction"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyValue"
    // Hyexpression.g:4743:1: parse_eu_hyvar_dataValues_HyValue returns [eu.hyvar.dataValues.HyValue element = null] : c= parseop_HyValue_level_15 ;
    public final eu.hyvar.dataValues.HyValue parse_eu_hyvar_dataValues_HyValue() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parse_eu_hyvar_dataValues_HyValue_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }

            // Hyexpression.g:4744:3: (c= parseop_HyValue_level_15 )
            // Hyexpression.g:4745:3: c= parseop_HyValue_level_15
            {
            pushFollow(FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue3259);
            c=parseop_HyValue_level_15();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c; /* this rule is an expression root */ }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 31, parse_eu_hyvar_dataValues_HyValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyValue"

    // $ANTLR start synpred45_Hyexpression
    public final void synpred45_Hyexpression_fragment() throws RecognitionException {
        eu.hyvar.feature.expression.HyValueExpression c5 =null;


        // Hyexpression.g:3273:2: (c5= parse_eu_hyvar_feature_expression_HyValueExpression )
        // Hyexpression.g:3273:2: c5= parse_eu_hyvar_feature_expression_HyValueExpression
        {
        pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_synpred45_Hyexpression2392);
        c5=parse_eu_hyvar_feature_expression_HyValueExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred45_Hyexpression

    // $ANTLR start synpred46_Hyexpression
    public final void synpred46_Hyexpression_fragment() throws RecognitionException {
        eu.hyvar.feature.expression.HyBooleanValueExpression c6 =null;


        // Hyexpression.g:3274:2: (c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression )
        // Hyexpression.g:3274:2: c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression
        {
        pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_synpred46_Hyexpression2400);
        c6=parse_eu_hyvar_feature_expression_HyBooleanValueExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred46_Hyexpression

    // Delegated rules

    public final boolean synpred46_Hyexpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_Hyexpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_Hyexpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_Hyexpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction115 = new BitSet(new long[]{0x000000003D000200L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction138 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction153 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction168 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction183 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction198 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction223 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction273 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction296 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction321 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction342 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction365 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction390 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_parse_eu_hyvar_dataValues_HyEnum440 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum458 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum479 = new BitSet(new long[]{0x0000000100010000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum508 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum549 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum583 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum657 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnum680 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum713 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum752 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum782 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum838 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum877 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_parse_eu_hyvar_dataValues_HyEnum900 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_43_in_parse_eu_hyvar_dataValues_HyEnum933 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum956 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum986 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnum1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_parse_eu_hyvar_dataValues_HyEnumLiteral1086 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral1104 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnumLiteral1125 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral1143 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral1164 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnumLiteral1187 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1220 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1259 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1289 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1345 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1384 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_parse_eu_hyvar_dataValues_HyEnumLiteral1407 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_43_in_parse_eu_hyvar_dataValues_HyEnumLiteral1440 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1463 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1493 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnumLiteral1545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_01593 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_parseop_HyExpression_level_01613 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_01630 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_11676 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_parseop_HyExpression_level_11692 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_11706 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_41747 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_parseop_HyExpression_level_41760 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_41771 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_51809 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_parseop_HyExpression_level_51822 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_51833 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_91871 = new BitSet(new long[]{0x000000003D002002L});
    public static final BitSet FOLLOW_24_in_parseop_HyExpression_level_91884 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_91895 = new BitSet(new long[]{0x000000003D002002L});
    public static final BitSet FOLLOW_26_in_parseop_HyExpression_level_91913 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_91924 = new BitSet(new long[]{0x000000003D002002L});
    public static final BitSet FOLLOW_28_in_parseop_HyExpression_level_91942 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_91953 = new BitSet(new long[]{0x000000003D002002L});
    public static final BitSet FOLLOW_29_in_parseop_HyExpression_level_91971 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_91982 = new BitSet(new long[]{0x000000003D002002L});
    public static final BitSet FOLLOW_27_in_parseop_HyExpression_level_92000 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92011 = new BitSet(new long[]{0x000000003D002002L});
    public static final BitSet FOLLOW_13_in_parseop_HyExpression_level_92029 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92040 = new BitSet(new long[]{0x000000003D002002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122078 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_20_in_parseop_HyExpression_level_122091 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122102 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_18_in_parseop_HyExpression_level_122120 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122131 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132169 = new BitSet(new long[]{0x0000000400820002L});
    public static final BitSet FOLLOW_34_in_parseop_HyExpression_level_132182 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132193 = new BitSet(new long[]{0x0000000400820002L});
    public static final BitSet FOLLOW_17_in_parseop_HyExpression_level_132211 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132222 = new BitSet(new long[]{0x0000000400820002L});
    public static final BitSet FOLLOW_23_in_parseop_HyExpression_level_132240 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132251 = new BitSet(new long[]{0x0000000400820002L});
    public static final BitSet FOLLOW_12_in_parseop_HyExpression_level_142289 = new BitSet(new long[]{0x000017E040008260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parseop_HyExpression_level_142309 = new BitSet(new long[]{0x000017E040008260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_152352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_152360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_152368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyExpression_level_152376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyExpression_level_152384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyExpression_level_152392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_152400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyMinimumExpression_in_parseop_HyExpression_level_152408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyMaximumExpression_in_parseop_HyExpression_level_152416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyIfPossibleExpression_in_parseop_HyExpression_level_152424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedExpression2446 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression2459 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression2471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2501 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2518 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2577 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2592 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2609 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression2656 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2701 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2718 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2736 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression2779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyMinimumExpression2849 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMinimumExpression2862 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyMinimumExpression2874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyMaximumExpression2900 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMaximumExpression2913 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyMaximumExpression2925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression2951 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression2964 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression2980 = new BitSet(new long[]{0x000017E040109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression2993 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_153039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_153047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_153055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_eu_hyvar_dataValues_HyBooleanValue3111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_dataValues_HyBooleanValue3120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnumValue3150 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3163 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue3176 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue3259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_synpred45_Hyexpression2392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_synpred46_Hyexpression2400 = new BitSet(new long[]{0x0000000000000002L});

}