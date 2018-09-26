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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DATE", "IDENTIFIER_TOKEN", "INTEGER_LITERAL", "LINEBREAK", "ML_COMMENT", "QUOTED_34_34", "SL_COMMENT", "WHITESPACE", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'->'", "'.'", "'/'", "'<'", "'<->'", "'<='", "'='", "'>'", "'>='", "'?'", "'Enum('", "'EnumLiteral('", "'['", "'\\u0025'", "']'", "'^'", "'context:'", "'enum:'", "'eternity'", "'false'", "'true'", "'{'", "'||'", "'}'"
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
        this.state.initializeRuleMemo(94 + 1);
         

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
    	
    	public void addExpectedElement(EClass eClass, int expectationStartIndex, int expectationEndIndex) {
    		for (int expectationIndex = expectationStartIndex; expectationIndex <= expectationEndIndex; expectationIndex++) {
    			addExpectedElement(eClass, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[expectationIndex]);
    		}
    	}
    	
    	public void addExpectedElement(EClass eClass, int expectationIndex) {
    		addExpectedElement(eClass, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[expectationIndex]);
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
    		int followSetID = 104;
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
    			this.incompleteObjects.remove(object);
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
    // Hyexpression.g:491:1: start returns [ EObject element = null] : (c0= parse_eu_hyvar_feature_expression_HyExpression ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        eu.hyvar.feature.expression.HyExpression c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Hyexpression.g:492:2: ( (c0= parse_eu_hyvar_feature_expression_HyExpression ) EOF )
            // Hyexpression.g:493:2: (c0= parse_eu_hyvar_feature_expression_HyExpression ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), 0, 454);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), 455, 909);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), 910, 1364);
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), 1365, 1819);
            		addExpectedElement(null, 1820, 1826);
            		expectedElementsIndexOfLastCompleteElement = 1826;
            	}

            // Hyexpression.g:502:2: (c0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyexpression.g:503:3: c0= parse_eu_hyvar_feature_expression_HyExpression
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
    // Hyexpression.g:511:1: parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction returns [eu.hyvar.feature.expression.HyRelativeVersionRestriction element = null] : a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' ;
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

            // Hyexpression.g:514:2: (a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' )
            // Hyexpression.g:515:2: a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']'
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
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_20_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 1827, 1828);
            	}

            // Hyexpression.g:532:2: ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? )
            // Hyexpression.g:533:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
            {
            // Hyexpression.g:533:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
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
                    // Hyexpression.g:534:4: a1= '<'
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
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Hyexpression.g:550:8: a2= '<='
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
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Hyexpression.g:566:8: a3= '='
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
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a3, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 4 :
                    // Hyexpression.g:582:8: a4= '>='
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
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a4, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 5 :
                    // Hyexpression.g:598:8: a5= '>'
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
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
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
            		addExpectedElement(null, 1829);
            	}

            // Hyexpression.g:620:2: (a8= QUOTED_34_34 )
            // Hyexpression.g:621:3: a8= QUOTED_34_34
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
            				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_20_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a8, element);
            				copyLocalizationInfos((CommonToken) a8, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 1830);
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
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_20_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		// We've found the last token for this rule. The constructed EObject is now
            		// complete.
            		completedElement(element, true);
            		addExpectedElement(null, 1831, 1835);
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
    // Hyexpression.g:685:1: parse_eu_hyvar_feature_expression_HyVersionRangeRestriction returns [eu.hyvar.feature.expression.HyVersionRangeRestriction element = null] : a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' ;
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

            // Hyexpression.g:688:2: (a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' )
            // Hyexpression.g:689:2: a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']'
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
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_21_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 1836, 1837);
            	}

            // Hyexpression.g:713:2: ( (a1= '^' )? )
            // Hyexpression.g:714:3: (a1= '^' )?
            {
            // Hyexpression.g:714:3: (a1= '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==36) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Hyexpression.g:715:4: a1= '^'
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
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_21_0_0_1, false, true);
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
            		addExpectedElement(null, 1838);
            	}

            // Hyexpression.g:744:2: (a3= QUOTED_34_34 )
            // Hyexpression.g:745:3: a3= QUOTED_34_34
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
            				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_21_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            				copyLocalizationInfos((CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 1839);
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
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_21_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 1840, 1841);
            	}

            // Hyexpression.g:818:2: ( (a5= '^' )? )
            // Hyexpression.g:819:3: (a5= '^' )?
            {
            // Hyexpression.g:819:3: (a5= '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==36) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Hyexpression.g:820:4: a5= '^'
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
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_21_0_0_4, false, true);
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
            		addExpectedElement(null, 1842);
            	}

            // Hyexpression.g:849:2: (a7= QUOTED_34_34 )
            // Hyexpression.g:850:3: a7= QUOTED_34_34
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
            				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_21_0_0_5, proxy, true);
            				copyLocalizationInfos((CommonToken) a7, element);
            				copyLocalizationInfos((CommonToken) a7, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 1843);
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
            		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_21_0_0_6, null, true);
            		copyLocalizationInfos((CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		// We've found the last token for this rule. The constructed EObject is now
            		// complete.
            		completedElement(element, true);
            		addExpectedElement(null, 1844, 1848);
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
    // Hyexpression.g:928:1: parse_eu_hyvar_dataValues_HyEnum returns [eu.hyvar.dataValues.HyEnum element = null] : a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? ;
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
        eu.hyvar.dataValues.HyEnumLiteral a3_0 =null;

        eu.hyvar.dataValues.HyEnumLiteral a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Hyexpression.g:931:2: (a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? )
            // Hyexpression.g:932:2: a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
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
            		addExpectedElement(null, 1849);
            	}

            // Hyexpression.g:946:2: (a1= IDENTIFIER_TOKEN )
            // Hyexpression.g:947:3: a1= IDENTIFIER_TOKEN
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
            		addExpectedElement(null, 1850);
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
            		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 1851);
            		addExpectedElement(null, 1852);
            	}

            // Hyexpression.g:997:2: ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==32) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Hyexpression.g:998:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    {
                    // Hyexpression.g:998:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    // Hyexpression.g:999:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    {
                    // Hyexpression.g:999:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    // Hyexpression.g:1000:5: a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral
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
                    				addExpectedElement(null, 1853, 1854);
                    			}

                    // Hyexpression.g:1025:4: ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==19) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Hyexpression.g:1026:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    {
                    	    // Hyexpression.g:1026:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    // Hyexpression.g:1027:6: a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
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
                    	    						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 1855);
                    	    					}

                    	    // Hyexpression.g:1041:6: (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    // Hyexpression.g:1042:7: a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral
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
                    	    						addExpectedElement(null, 1856, 1857);
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
                    				addExpectedElement(null, 1858, 1859);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 1860);
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
            		addExpectedElement(null, 1861);
            	}

            // Hyexpression.g:1095:2: ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==33) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Hyexpression.g:1096:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    {
                    // Hyexpression.g:1096:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    // Hyexpression.g:1097:4: a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']'
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
                    				addExpectedElement(null, 1862, 1864);
                    			}

                    // Hyexpression.g:1111:4: ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) )
                    int alt6=3;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==DATE) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==20) ) {
                            int LA6_3 = input.LA(3);

                            if ( (LA6_3==DATE) ) {
                                alt6=1;
                            }
                            else if ( (LA6_3==35) ) {
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
                    else if ( (LA6_0==39) ) {
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
                            // Hyexpression.g:1112:5: (a8= DATE ) a9= '-' (a10= DATE )
                            {
                            // Hyexpression.g:1112:5: (a8= DATE )
                            // Hyexpression.g:1113:6: a8= DATE
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
                            					addExpectedElement(null, 1865);
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
                            					addExpectedElement(null, 1866);
                            				}

                            // Hyexpression.g:1162:5: (a10= DATE )
                            // Hyexpression.g:1163:6: a10= DATE
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
                            					addExpectedElement(null, 1867);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyexpression.g:1199:10: (a11= DATE ) a12= '-'
                            {
                            // Hyexpression.g:1199:10: (a11= DATE )
                            // Hyexpression.g:1200:6: a11= DATE
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
                            					addExpectedElement(null, 1868);
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
                            					addExpectedElement(null, 1869);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyexpression.g:1250:10: a13= 'eternity' a14= '-' (a15= DATE )
                            {
                            a13=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnum910); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 1870);
                            				}

                            a14=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum933); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a14, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 1871);
                            				}

                            // Hyexpression.g:1278:5: (a15= DATE )
                            // Hyexpression.g:1279:6: a15= DATE
                            {
                            a15=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum963); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a15 != null) {
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a15.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a15).getLine(), ((CommonToken) a15).getCharPositionInLine(), ((CommonToken) a15).getStartIndex(), ((CommonToken) a15).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a15, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 1872);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 1873);
                    			}

                    a16=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnum1015); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a16, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				// We've found the last token for this rule. The constructed EObject is now
                    				// complete.
                    				completedElement(element, true);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		// We've found the last token for this rule. The constructed EObject is now
            		// complete.
            		completedElement(element, true);
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
    // Hyexpression.g:1347:1: parse_eu_hyvar_dataValues_HyEnumLiteral returns [eu.hyvar.dataValues.HyEnumLiteral element = null] : a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
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

            // Hyexpression.g:1350:2: (a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hyexpression.g:1351:2: a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            a0=(Token)match(input,32,FOLLOW_32_in_parse_eu_hyvar_dataValues_HyEnumLiteral1063); if (state.failed) return element;

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
            		addExpectedElement(null, 1874);
            	}

            // Hyexpression.g:1365:2: (a1= IDENTIFIER_TOKEN )
            // Hyexpression.g:1366:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral1081); if (state.failed) return element;

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
            		addExpectedElement(null, 1875);
            	}

            a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnumLiteral1102); if (state.failed) return element;

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
            		addExpectedElement(null, 1876);
            	}

            // Hyexpression.g:1415:2: (a3= INTEGER_LITERAL )
            // Hyexpression.g:1416:3: a3= INTEGER_LITERAL
            {
            a3=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral1120); if (state.failed) return element;

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
            		addExpectedElement(null, 1877);
            	}

            a4=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral1141); if (state.failed) return element;

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
            		addExpectedElement(null, 1878, 1880);
            	}

            // Hyexpression.g:1465:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==33) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Hyexpression.g:1466:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hyexpression.g:1466:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hyexpression.g:1467:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnumLiteral1164); if (state.failed) return element;

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
                    				addExpectedElement(null, 1881, 1883);
                    			}

                    // Hyexpression.g:1481:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) )
                    int alt8=3;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==DATE) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==20) ) {
                            int LA8_3 = input.LA(3);

                            if ( (LA8_3==DATE) ) {
                                alt8=1;
                            }
                            else if ( (LA8_3==39) ) {
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
                    else if ( (LA8_0==39) ) {
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
                            // Hyexpression.g:1482:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hyexpression.g:1482:5: (a6= DATE )
                            // Hyexpression.g:1483:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1197); if (state.failed) return element;

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
                            					addExpectedElement(null, 1884);
                            				}

                            a7=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1236); if (state.failed) return element;

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
                            					addExpectedElement(null, 1885);
                            				}

                            // Hyexpression.g:1532:5: (a8= DATE )
                            // Hyexpression.g:1533:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1266); if (state.failed) return element;

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
                            					addExpectedElement(null, 1886);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyexpression.g:1569:10: (a9= DATE ) a10= '-' a11= 'eternity'
                            {
                            // Hyexpression.g:1569:10: (a9= DATE )
                            // Hyexpression.g:1570:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1322); if (state.failed) return element;

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
                            					addExpectedElement(null, 1887);
                            				}

                            a10=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1361); if (state.failed) return element;

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
                            					addExpectedElement(null, 1888);
                            				}

                            a11=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumLiteral1384); if (state.failed) return element;

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
                            					addExpectedElement(null, 1889);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyexpression.g:1634:10: a12= 'eternity' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumLiteral1417); if (state.failed) return element;

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
                            					addExpectedElement(null, 1890);
                            				}

                            a13=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1440); if (state.failed) return element;

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
                            					addExpectedElement(null, 1891);
                            				}

                            // Hyexpression.g:1662:5: (a14= DATE )
                            // Hyexpression.g:1663:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1470); if (state.failed) return element;

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
                            					addExpectedElement(null, 1892);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 1893);
                    			}

                    a15=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnumLiteral1522); if (state.failed) return element;

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
                    				// We've found the last token for this rule. The constructed EObject is now
                    				// complete.
                    				completedElement(element, true);
                    				addExpectedElement(null, 1894, 1895);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		// We've found the last token for this rule. The constructed EObject is now
            		// complete.
            		completedElement(element, true);
            		addExpectedElement(null, 1896, 1897);
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
    // Hyexpression.g:1733:1: parseop_HyExpression_level_0 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_0() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_0_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Hyexpression.g:1736:2: (leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) )
            // Hyexpression.g:1737:2: leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_01570);
            leftArg=parseop_HyExpression_level_1();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:1737:41: ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            else if ( (LA11_0==EOF||LA11_0==16) ) {
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
                    // Hyexpression.g:1737:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    {
                    // Hyexpression.g:1737:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
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
                    	    // Hyexpression.g:1738:3: () a0= '<->' rightArg= parseop_HyExpression_level_1
                    	    {
                    	    // Hyexpression.g:1738:3: ()
                    	    // Hyexpression.g:1738:4: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,25,FOLLOW_25_in_parseop_HyExpression_level_01590); if (state.failed) return element;

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
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), 1898, 2352);
                    	    		}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_01607);
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
                    // Hyexpression.g:1793:21: 
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
    // Hyexpression.g:1798:1: parseop_HyExpression_level_1 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_2 ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_1() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_1_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Hyexpression.g:1801:9: (leftArg= parseop_HyExpression_level_2 ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |) )
            // Hyexpression.g:1802:9: leftArg= parseop_HyExpression_level_2 ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_11653);
            leftArg=parseop_HyExpression_level_2();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:1802:39: ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |)
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            else if ( (LA13_0==EOF||LA13_0==16||LA13_0==25) ) {
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
                    // Hyexpression.g:1802:40: ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+
                    {
                    // Hyexpression.g:1802:40: ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+
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
                    	    // Hyexpression.g:1803:2: () a0= '->' rightArg= parseop_HyExpression_level_2
                    	    {
                    	    // Hyexpression.g:1803:2: ()
                    	    // Hyexpression.g:1803:3: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,21,FOLLOW_21_in_parseop_HyExpression_level_11669); if (state.failed) return element;

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
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), 2353, 2807);
                    	    	}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_11683);
                    	    rightArg=parseop_HyExpression_level_2();

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
                    // Hyexpression.g:1858:20: 
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



    // $ANTLR start "parseop_HyExpression_level_2"
    // Hyexpression.g:1863:1: parseop_HyExpression_level_2 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_3 ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_2() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_2_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Hyexpression.g:1866:9: (leftArg= parseop_HyExpression_level_3 ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |) )
            // Hyexpression.g:1867:9: leftArg= parseop_HyExpression_level_3 ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_21724);
            leftArg=parseop_HyExpression_level_3();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:1867:39: ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |)
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==43) ) {
                alt15=1;
            }
            else if ( (LA15_0==EOF||LA15_0==16||LA15_0==21||LA15_0==25) ) {
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
                    // Hyexpression.g:1867:40: ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+
                    {
                    // Hyexpression.g:1867:40: ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==43) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // Hyexpression.g:1868:0: () a0= '||' rightArg= parseop_HyExpression_level_3
                    	    {
                    	    // Hyexpression.g:1868:2: ()
                    	    // Hyexpression.g:1868:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,43,FOLLOW_43_in_parseop_HyExpression_level_21737); if (state.failed) return element;

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
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), 2808, 3262);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_21748);
                    	    rightArg=parseop_HyExpression_level_3();

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
                    // Hyexpression.g:1923:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 8, parseop_HyExpression_level_2_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_2"



    // $ANTLR start "parseop_HyExpression_level_3"
    // Hyexpression.g:1928:1: parseop_HyExpression_level_3 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_14 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_3() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_3_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Hyexpression.g:1931:9: (leftArg= parseop_HyExpression_level_14 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |) )
            // Hyexpression.g:1932:9: leftArg= parseop_HyExpression_level_14 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_31786);
            leftArg=parseop_HyExpression_level_14();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:1932:40: ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |)
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==14) ) {
                alt17=1;
            }
            else if ( (LA17_0==EOF||LA17_0==16||LA17_0==21||LA17_0==25||LA17_0==43) ) {
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
                    // Hyexpression.g:1932:41: ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+
                    {
                    // Hyexpression.g:1932:41: ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+
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
                    	    // Hyexpression.g:1933:0: () a0= '&&' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Hyexpression.g:1933:2: ()
                    	    // Hyexpression.g:1933:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,14,FOLLOW_14_in_parseop_HyExpression_level_31799); if (state.failed) return element;

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
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), 3263, 3717);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_31810);
                    	    rightArg=parseop_HyExpression_level_14();

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
                    // Hyexpression.g:1988:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 9, parseop_HyExpression_level_3_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_3"



    // $ANTLR start "parseop_HyExpression_level_14"
    // Hyexpression.g:1993:1: parseop_HyExpression_level_14 returns [eu.hyvar.feature.expression.HyExpression element = null] : (a0= '!' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 );
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_14() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_14_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression arg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Hyexpression.g:1996:0: (a0= '!' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==12) ) {
                alt18=1;
            }
            else if ( (LA18_0==IDENTIFIER_TOKEN||LA18_0==QUOTED_34_34||LA18_0==15||LA18_0==30||(LA18_0 >= 40 && LA18_0 <= 42)) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }
            switch (alt18) {
                case 1 :
                    // Hyexpression.g:1997:0: a0= '!' arg= parseop_HyExpression_level_15
                    {
                    a0=(Token)match(input,12,FOLLOW_12_in_parseop_HyExpression_level_141848); if (state.failed) return element;

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
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), 3718, 4172);
                    }

                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_141859);
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
                    // Hyexpression.g:2032:5: arg= parseop_HyExpression_level_15
                    {
                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_141869);
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
            if ( state.backtracking>0 ) { memoize(input, 10, parseop_HyExpression_level_14_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_14"



    // $ANTLR start "parseop_HyExpression_level_15"
    // Hyexpression.g:2035:1: parseop_HyExpression_level_15 returns [eu.hyvar.feature.expression.HyExpression element = null] : (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyBooleanValueExpression |c4= parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression );
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_15() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_15_StartIndex = input.index();

        eu.hyvar.feature.expression.HyNestedExpression c0 =null;

        eu.hyvar.feature.expression.HyFeatureReferenceExpression c1 =null;

        eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression c2 =null;

        eu.hyvar.feature.expression.HyBooleanValueExpression c3 =null;

        eu.hyvar.feature.expression.HyArithmeticalComparisonExpression c4 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Hyexpression.g:2038:0: (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyBooleanValueExpression |c4= parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression )
            int alt19=5;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt19=1;
                }
                break;
            case IDENTIFIER_TOKEN:
            case QUOTED_34_34:
                {
                alt19=2;
                }
                break;
            case 30:
                {
                alt19=3;
                }
                break;
            case 40:
            case 41:
                {
                alt19=4;
                }
                break;
            case 42:
                {
                alt19=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }

            switch (alt19) {
                case 1 :
                    // Hyexpression.g:2039:0: c0= parse_eu_hyvar_feature_expression_HyNestedExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_151891);
                    c0=parse_eu_hyvar_feature_expression_HyNestedExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:2040:2: c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_151899);
                    c1=parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hyexpression.g:2041:2: c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_151907);
                    c2=parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Hyexpression.g:2042:2: c3= parse_eu_hyvar_feature_expression_HyBooleanValueExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_151915);
                    c3=parse_eu_hyvar_feature_expression_HyBooleanValueExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Hyexpression.g:2043:2: c4= parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression_in_parseop_HyExpression_level_151923);
                    c4=parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 11, parseop_HyExpression_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_15"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyNestedExpression"
    // Hyexpression.g:2046:1: parse_eu_hyvar_feature_expression_HyNestedExpression returns [eu.hyvar.feature.expression.HyNestedExpression element = null] : a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyNestedExpression parse_eu_hyvar_feature_expression_HyNestedExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyNestedExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Hyexpression.g:2049:4: (a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Hyexpression.g:2050:4: a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedExpression1945); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_5_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), 4173, 4627);
            }

            // Hyexpression.g:2064:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyexpression.g:2065:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression1958);
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
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_5_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 4628);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression1970); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_5_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 4629, 4633);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyNestedExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression"
    // Hyexpression.g:2109:1: parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyFeatureReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? ;
    public final eu.hyvar.feature.expression.HyFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        eu.hyvar.feature.expression.HyVersionRestriction a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Hyexpression.g:2112:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? )
            // Hyexpression.g:2113:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            {
            // Hyexpression.g:2113:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==QUOTED_34_34) ) {
                alt20=1;
            }
            else if ( (LA20_0==IDENTIFIER_TOKEN) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // Hyexpression.g:2114:0: (a0= QUOTED_34_34 )
                    {
                    // Hyexpression.g:2114:4: (a0= QUOTED_34_34 )
                    // Hyexpression.g:2115:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2000); if (state.failed) return element;

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
                    	retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_6_0_0_0_0_0_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a0, element);
                    	copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 4634, 4635);
                    addExpectedElement(null, 4636, 4640);
                    }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:2156:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyexpression.g:2156:2: (a1= IDENTIFIER_TOKEN )
                    // Hyexpression.g:2157:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2017); if (state.failed) return element;

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
                    	retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_6_0_0_0_0_1_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a1, element);
                    	copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 4641, 4642);
                    addExpectedElement(null, 4643, 4647);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 4648, 4649);
            addExpectedElement(null, 4650, 4654);
            }

            // Hyexpression.g:2204:0: ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==33) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // Hyexpression.g:2205:0: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    {
                    // Hyexpression.g:2205:6: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    // Hyexpression.g:2206:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    {
                    // Hyexpression.g:2206:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    // Hyexpression.g:2207:6: a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2041);
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
                    		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_6_0_0_1_0_0_0, a2_0, true);
                    		copyLocalizationInfos(a2_0, element);
                    	}
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    // We've found the last token for this rule. The constructed EObject is now
                    // complete.
                    completedElement(element, true);
                    addExpectedElement(null, 4655, 4659);
                    }

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 4660, 4664);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression"
    // Hyexpression.g:2247:1: parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element = null] : a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ;
    public final eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyVersionRestriction a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Hyexpression.g:2250:4: (a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
            // Hyexpression.g:2251:4: a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            {
            a0=(Token)match(input,30,FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2076); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_7_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 4665, 4666);
            }

            // Hyexpression.g:2265:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==QUOTED_34_34) ) {
                alt22=1;
            }
            else if ( (LA22_0==IDENTIFIER_TOKEN) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // Hyexpression.g:2266:0: (a1= QUOTED_34_34 )
                    {
                    // Hyexpression.g:2266:4: (a1= QUOTED_34_34 )
                    // Hyexpression.g:2267:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2091); if (state.failed) return element;

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
                    	retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_0_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a1, element);
                    	copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 4667, 4668);
                    }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:2307:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hyexpression.g:2307:2: (a2= IDENTIFIER_TOKEN )
                    // Hyexpression.g:2308:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2108); if (state.failed) return element;

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
                    	retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_1_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a2, element);
                    	copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 4669, 4670);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 4671, 4672);
            }

            // Hyexpression.g:2353:6: (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            // Hyexpression.g:2354:6: a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2128);
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
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_7_0_0_2, a3_0, true);
            copyLocalizationInfos(a3_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 4673, 4677);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"
    // Hyexpression.g:2384:1: parse_eu_hyvar_feature_expression_HyBooleanValueExpression returns [eu.hyvar.feature.expression.HyBooleanValueExpression element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.feature.expression.HyBooleanValueExpression parse_eu_hyvar_feature_expression_HyBooleanValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyBooleanValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Hyexpression.g:2387:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hyexpression.g:2388:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hyexpression.g:2388:0: ( (a0= 'true' |a1= 'false' ) )
            // Hyexpression.g:2389:0: (a0= 'true' |a1= 'false' )
            {
            // Hyexpression.g:2389:0: (a0= 'true' |a1= 'false' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==41) ) {
                alt23=1;
            }
            else if ( (LA23_0==40) ) {
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
                    // Hyexpression.g:2390:0: a0= 'true'
                    {
                    a0=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2159); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_8_0_0_0, true, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    // set value of boolean attribute
                    Object value = true;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:2403:2: a1= 'false'
                    {
                    a1=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2168); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_8_0_0_0, false, true);
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
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 4678, 4682);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression"
    // Hyexpression.g:2428:1: parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression returns [eu.hyvar.feature.expression.HyArithmeticalComparisonExpression element = null] : a0= '{' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) ) (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a11= '}' ;
    public final eu.hyvar.feature.expression.HyArithmeticalComparisonExpression parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalComparisonExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a11=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression a1_0 =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression a10_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Hyexpression.g:2431:4: (a0= '{' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) ) (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a11= '}' )
            // Hyexpression.g:2432:4: a0= '{' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) ) (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a11= '}'
            {
            a0=(Token)match(input,42,FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2198); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_9_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(), 4683, 7290);
            }

            // Hyexpression.g:2446:6: (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression )
            // Hyexpression.g:2447:6: a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2211);
            a1_0=parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
            startIncompleteElement(element);
            }
            if (a1_0 != null) {
            if (a1_0 != null) {
            	Object value = a1_0;
            	element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERAND1), value);
            	completedElement(value, true);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_9_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 7291);
            }

            // Hyexpression.g:2472:0: ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) )
            // Hyexpression.g:2473:0: (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' )
            {
            // Hyexpression.g:2473:0: (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' )
            int alt24=6;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt24=1;
                }
                break;
            case 26:
                {
                alt24=2;
                }
                break;
            case 27:
                {
                alt24=3;
                }
                break;
            case 13:
                {
                alt24=4;
                }
                break;
            case 29:
                {
                alt24=5;
                }
                break;
            case 28:
                {
                alt24=6;
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
                    // Hyexpression.g:2474:0: a2= '<'
                    {
                    a2=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2227); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    copyLocalizationInfos((CommonToken)a2, element);
                    // set value of enumeration attribute
                    Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_LESS_OPERATOR_VALUE).getInstance();
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:2487:2: a3= '<='
                    {
                    a3=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2236); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    copyLocalizationInfos((CommonToken)a3, element);
                    // set value of enumeration attribute
                    Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_LESS_OR_EQUAL_OPERATOR_VALUE).getInstance();
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 3 :
                    // Hyexpression.g:2500:2: a4= '='
                    {
                    a4=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2245); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    copyLocalizationInfos((CommonToken)a4, element);
                    // set value of enumeration attribute
                    Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_EQUAL_OPERATOR_VALUE).getInstance();
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 4 :
                    // Hyexpression.g:2513:2: a5= '!='
                    {
                    a5=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2254); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    copyLocalizationInfos((CommonToken)a5, element);
                    // set value of enumeration attribute
                    Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_NOT_EQUAL_OPERATOR_VALUE).getInstance();
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 5 :
                    // Hyexpression.g:2526:2: a6= '>='
                    {
                    a6=(Token)match(input,29,FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2263); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    copyLocalizationInfos((CommonToken)a6, element);
                    // set value of enumeration attribute
                    Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_GREATER_OR_EQUAL_OPERATOR_VALUE).getInstance();
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 6 :
                    // Hyexpression.g:2539:2: a7= '>'
                    {
                    a7=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2272); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    copyLocalizationInfos((CommonToken)a7, element);
                    // set value of enumeration attribute
                    Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_GREATER_OPERATOR_VALUE).getInstance();
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    completedElement(value, false);
                    }

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(), 7292, 9899);
            }

            // Hyexpression.g:2559:7: (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression )
            // Hyexpression.g:2560:7: a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2289);
            a10_0=parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
            startIncompleteElement(element);
            }
            if (a10_0 != null) {
            if (a10_0 != null) {
            	Object value = a10_0;
            	element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERAND2), value);
            	completedElement(value, true);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_9_0_0_3, a10_0, true);
            copyLocalizationInfos(a10_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 9900);
            }

            a11=(Token)match(input,44,FOLLOW_44_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2301); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_9_0_0_4, null, true);
            copyLocalizationInfos((CommonToken)a11, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 9901, 9905);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_4"
    // Hyexpression.g:2604:1: parseop_HyArithmeticalValueExpression_level_4 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_5 ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_4() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_4_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Hyexpression.g:2607:9: (leftArg= parseop_HyArithmeticalValueExpression_level_5 ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |) )
            // Hyexpression.g:2608:9: leftArg= parseop_HyArithmeticalValueExpression_level_5 ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_42327);
            leftArg=parseop_HyArithmeticalValueExpression_level_5();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:2608:56: ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |)
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==34) ) {
                alt26=1;
            }
            else if ( (LA26_0==13||LA26_0==16||LA26_0==24||(LA26_0 >= 26 && LA26_0 <= 29)||LA26_0==44) ) {
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
                    // Hyexpression.g:2608:57: ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+
                    {
                    // Hyexpression.g:2608:57: ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==34) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // Hyexpression.g:2609:0: () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5
                    	    {
                    	    // Hyexpression.g:2609:2: ()
                    	    // Hyexpression.g:2609:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,34,FOLLOW_34_in_parseop_HyArithmeticalValueExpression_level_42340); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyModuloExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_12_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), 9906, 12513);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_42351);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_5();

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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_12_0_0_0, leftArg, true);
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_12_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyexpression.g:2664:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 17, parseop_HyArithmeticalValueExpression_level_4_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_4"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_5"
    // Hyexpression.g:2669:1: parseop_HyArithmeticalValueExpression_level_5 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_6 ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_5() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_5_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Hyexpression.g:2672:9: (leftArg= parseop_HyArithmeticalValueExpression_level_6 ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |) )
            // Hyexpression.g:2673:9: leftArg= parseop_HyArithmeticalValueExpression_level_6 ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_52389);
            leftArg=parseop_HyArithmeticalValueExpression_level_6();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:2673:56: ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |)
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==18) ) {
                alt28=1;
            }
            else if ( (LA28_0==EOF||LA28_0==13||LA28_0==16||LA28_0==24||(LA28_0 >= 26 && LA28_0 <= 29)||LA28_0==34||LA28_0==44) ) {
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
                    // Hyexpression.g:2673:57: ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+
                    {
                    // Hyexpression.g:2673:57: ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==18) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // Hyexpression.g:2674:0: () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6
                    	    {
                    	    // Hyexpression.g:2674:2: ()
                    	    // Hyexpression.g:2674:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,18,FOLLOW_18_in_parseop_HyArithmeticalValueExpression_level_52402); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAdditionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_10_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), 12514, 15121);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_52413);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_6();

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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_10_0_0_0, leftArg, true);
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_10_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyexpression.g:2729:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 18, parseop_HyArithmeticalValueExpression_level_5_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_5"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_6"
    // Hyexpression.g:2734:1: parseop_HyArithmeticalValueExpression_level_6 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_7 ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_6() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_6_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Hyexpression.g:2737:9: (leftArg= parseop_HyArithmeticalValueExpression_level_7 ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |) )
            // Hyexpression.g:2738:9: leftArg= parseop_HyArithmeticalValueExpression_level_7 ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_62451);
            leftArg=parseop_HyArithmeticalValueExpression_level_7();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:2738:56: ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |)
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==20) ) {
                alt30=1;
            }
            else if ( (LA30_0==EOF||LA30_0==13||LA30_0==16||LA30_0==18||LA30_0==24||(LA30_0 >= 26 && LA30_0 <= 29)||LA30_0==34||LA30_0==44) ) {
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
                    // Hyexpression.g:2738:57: ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+
                    {
                    // Hyexpression.g:2738:57: ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+
                    int cnt29=0;
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==20) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // Hyexpression.g:2739:0: () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7
                    	    {
                    	    // Hyexpression.g:2739:2: ()
                    	    // Hyexpression.g:2739:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,20,FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_62464); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHySubtractionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_11_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), 15122, 17729);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_62475);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_7();

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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_11_0_0_0, leftArg, true);
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_11_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt29 >= 1 ) break loop29;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(29, input);
                                throw eee;
                        }
                        cnt29++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyexpression.g:2794:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 19, parseop_HyArithmeticalValueExpression_level_6_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_6"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_7"
    // Hyexpression.g:2799:1: parseop_HyArithmeticalValueExpression_level_7 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_8 ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_7() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_7_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Hyexpression.g:2802:9: (leftArg= parseop_HyArithmeticalValueExpression_level_8 ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |) )
            // Hyexpression.g:2803:9: leftArg= parseop_HyArithmeticalValueExpression_level_8 ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_72513);
            leftArg=parseop_HyArithmeticalValueExpression_level_8();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:2803:56: ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |)
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==17) ) {
                alt32=1;
            }
            else if ( (LA32_0==EOF||LA32_0==13||LA32_0==16||LA32_0==18||LA32_0==20||LA32_0==24||(LA32_0 >= 26 && LA32_0 <= 29)||LA32_0==34||LA32_0==44) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;

            }
            switch (alt32) {
                case 1 :
                    // Hyexpression.g:2803:57: ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+
                    {
                    // Hyexpression.g:2803:57: ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+
                    int cnt31=0;
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==17) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // Hyexpression.g:2804:0: () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8
                    	    {
                    	    // Hyexpression.g:2804:2: ()
                    	    // Hyexpression.g:2804:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,17,FOLLOW_17_in_parseop_HyArithmeticalValueExpression_level_72526); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMultiplicationExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_13_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), 17730, 20337);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_72537);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_8();

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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_13_0_0_0, leftArg, true);
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_13_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt31 >= 1 ) break loop31;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(31, input);
                                throw eee;
                        }
                        cnt31++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyexpression.g:2859:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 20, parseop_HyArithmeticalValueExpression_level_7_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_7"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_8"
    // Hyexpression.g:2864:1: parseop_HyArithmeticalValueExpression_level_8 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_11 ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_8() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_8_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Hyexpression.g:2867:9: (leftArg= parseop_HyArithmeticalValueExpression_level_11 ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |) )
            // Hyexpression.g:2868:9: leftArg= parseop_HyArithmeticalValueExpression_level_11 ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_82575);
            leftArg=parseop_HyArithmeticalValueExpression_level_11();

            state._fsp--;
            if (state.failed) return element;

            // Hyexpression.g:2868:57: ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |)
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==23) ) {
                alt34=1;
            }
            else if ( (LA34_0==EOF||LA34_0==13||(LA34_0 >= 16 && LA34_0 <= 18)||LA34_0==20||LA34_0==24||(LA34_0 >= 26 && LA34_0 <= 29)||LA34_0==34||LA34_0==44) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }
            switch (alt34) {
                case 1 :
                    // Hyexpression.g:2868:58: ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+
                    {
                    // Hyexpression.g:2868:58: ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==23) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // Hyexpression.g:2869:0: () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11
                    	    {
                    	    // Hyexpression.g:2869:2: ()
                    	    // Hyexpression.g:2869:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,23,FOLLOW_23_in_parseop_HyArithmeticalValueExpression_level_82588); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyDivisionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_14_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), 20338, 22945);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_82599);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_11();

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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_14_0_0_0, leftArg, true);
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_14_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt33 >= 1 ) break loop33;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(33, input);
                                throw eee;
                        }
                        cnt33++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyexpression.g:2924:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 21, parseop_HyArithmeticalValueExpression_level_8_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_8"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_11"
    // Hyexpression.g:2929:1: parseop_HyArithmeticalValueExpression_level_11 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : (c0= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression |c1= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyValueExpression );
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_11() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_11_StartIndex = input.index();

        eu.hyvar.feature.expression.HyAttributeReferenceExpression c0 =null;

        eu.hyvar.feature.expression.HyContextInformationReferenceExpression c1 =null;

        eu.hyvar.feature.expression.HyValueExpression c2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Hyexpression.g:2932:0: (c0= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression |c1= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyValueExpression )
            int alt35=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER_TOKEN:
            case QUOTED_34_34:
                {
                alt35=1;
                }
                break;
            case 37:
                {
                alt35=2;
                }
                break;
            case INTEGER_LITERAL:
            case 38:
            case 40:
            case 41:
                {
                alt35=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }

            switch (alt35) {
                case 1 :
                    // Hyexpression.g:2933:0: c0= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_112637);
                    c0=parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:2934:2: c1= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_112645);
                    c1=parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hyexpression.g:2935:2: c2= parse_eu_hyvar_feature_expression_HyValueExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyArithmeticalValueExpression_level_112653);
                    c2=parse_eu_hyvar_feature_expression_HyValueExpression();

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
            if ( state.backtracking>0 ) { memoize(input, 22, parseop_HyArithmeticalValueExpression_level_11_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_11"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression"
    // Hyexpression.g:2938:1: parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression returns [eu.hyvar.feature.expression.HyAttributeReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) ;
    public final eu.hyvar.feature.expression.HyAttributeReferenceExpression parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyAttributeReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Hyexpression.g:2941:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) )
            // Hyexpression.g:2942:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN )
            {
            // Hyexpression.g:2942:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==QUOTED_34_34) ) {
                alt36=1;
            }
            else if ( (LA36_0==IDENTIFIER_TOKEN) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // Hyexpression.g:2943:0: (a0= QUOTED_34_34 )
                    {
                    // Hyexpression.g:2943:4: (a0= QUOTED_34_34 )
                    // Hyexpression.g:2944:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2679); if (state.failed) return element;

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
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_17_0_0_0_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a0, element);
                    copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 22946);
                    }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:2984:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyexpression.g:2984:2: (a1= IDENTIFIER_TOKEN )
                    // Hyexpression.g:2985:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2696); if (state.failed) return element;

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
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_17_0_0_0_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 22947);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 22948);
            }

            a2=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2714); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_17_0_0_1, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 22949);
            }

            // Hyexpression.g:3044:4: (a3= IDENTIFIER_TOKEN )
            // Hyexpression.g:3045:4: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2727); if (state.failed) return element;

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
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_17_0_0_2, proxy, true);
            copyLocalizationInfos((CommonToken) a3, element);
            copyLocalizationInfos((CommonToken) a3, proxy);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 22950, 22956);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"
    // Hyexpression.g:3089:1: parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression returns [eu.hyvar.feature.expression.HyContextInformationReferenceExpression element = null] : a0= 'context:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) ;
    public final eu.hyvar.feature.expression.HyContextInformationReferenceExpression parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyContextInformationReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Hyexpression.g:3092:4: (a0= 'context:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) )
            // Hyexpression.g:3093:4: a0= 'context:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
            {
            a0=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression2755); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_18_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 22957, 22958);
            }

            // Hyexpression.g:3107:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==QUOTED_34_34) ) {
                alt37=1;
            }
            else if ( (LA37_0==IDENTIFIER_TOKEN) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }
            switch (alt37) {
                case 1 :
                    // Hyexpression.g:3108:0: (a1= QUOTED_34_34 )
                    {
                    // Hyexpression.g:3108:4: (a1= QUOTED_34_34 )
                    // Hyexpression.g:3109:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression2770); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
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
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_18_0_0_1_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 22959, 22965);
                    }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:3149:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hyexpression.g:3149:2: (a2= IDENTIFIER_TOKEN )
                    // Hyexpression.g:3150:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression2787); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a2 != null) {
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
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
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_18_0_0_1_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a2, element);
                    copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    // We've found the last token for this rule. The constructed EObject is now
                    // complete.
                    completedElement(element, true);
                    addExpectedElement(null, 22966, 22972);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 22973, 22979);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 24, parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyValueExpression"
    // Hyexpression.g:3203:1: parse_eu_hyvar_feature_expression_HyValueExpression returns [eu.hyvar.feature.expression.HyValueExpression element = null] : (a0_0= parse_eu_hyvar_dataValues_HyValue ) ;
    public final eu.hyvar.feature.expression.HyValueExpression parse_eu_hyvar_feature_expression_HyValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }

            // Hyexpression.g:3206:6: ( (a0_0= parse_eu_hyvar_dataValues_HyValue ) )
            // Hyexpression.g:3207:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            {
            // Hyexpression.g:3207:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            // Hyexpression.g:3208:6: a0_0= parse_eu_hyvar_dataValues_HyValue
            {
            pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression2822);
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
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_19_0_0_0, a0_0, true);
            copyLocalizationInfos(a0_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 22980, 22986);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyValueExpression"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_14"
    // Hyexpression.g:3238:1: parseop_HyArithmeticalValueExpression_level_14 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : (a0= '-' arg= parseop_HyArithmeticalValueExpression_level_15 |arg= parseop_HyArithmeticalValueExpression_level_15 );
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_14() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_14_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression arg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Hyexpression.g:3241:0: (a0= '-' arg= parseop_HyArithmeticalValueExpression_level_15 |arg= parseop_HyArithmeticalValueExpression_level_15 )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==20) ) {
                alt38=1;
            }
            else if ( (LA38_0==15) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }
            switch (alt38) {
                case 1 :
                    // Hyexpression.g:3242:0: a0= '-' arg= parseop_HyArithmeticalValueExpression_level_15
                    {
                    a0=(Token)match(input,20,FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_142849); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNegationExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_15_0_0_0, null, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    }

                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), 22987, 25594);
                    }

                    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_142860);
                    arg=parseop_HyArithmeticalValueExpression_level_15();

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
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_15_0_0_1, arg, true);
                    copyLocalizationInfos(arg, element);
                    }
                    }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:3277:5: arg= parseop_HyArithmeticalValueExpression_level_15
                    {
                    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_142870);
                    arg=parseop_HyArithmeticalValueExpression_level_15();

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
            if ( state.backtracking>0 ) { memoize(input, 26, parseop_HyArithmeticalValueExpression_level_14_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_14"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_15"
    // Hyexpression.g:3280:1: parseop_HyArithmeticalValueExpression_level_15 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c0= parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_15() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_15_StartIndex = input.index();

        eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Hyexpression.g:3283:4: (c0= parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression )
            // Hyexpression.g:3284:4: c0= parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_in_parseop_HyArithmeticalValueExpression_level_152892);
            c0=parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, parseop_HyArithmeticalValueExpression_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_15"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression"
    // Hyexpression.g:3287:1: parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression returns [eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression element = null] : a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Hyexpression.g:3290:4: (a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a2= ')' )
            // Hyexpression.g:3291:4: a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a2= ')'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression2914); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedArithmeticalValueExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_16_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedArithmeticalValueExpression(), 25595, 28202);
            }

            // Hyexpression.g:3305:6: (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression )
            // Hyexpression.g:3306:6: a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression2927);
            a1_0=parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedArithmeticalValueExpression();
            startIncompleteElement(element);
            }
            if (a1_0 != null) {
            if (a1_0 != null) {
            Object value = a1_0;
            element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_NESTED_ARITHMETICAL_VALUE_EXPRESSION__OPERAND), value);
            completedElement(value, true);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_16_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 28203);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression2939); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedArithmeticalValueExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_16_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 28204, 28210);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 28, parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression"



    // $ANTLR start "parseop_HyValue_level_15"
    // Hyexpression.g:3350:1: parseop_HyValue_level_15 returns [eu.hyvar.dataValues.HyValue element = null] : (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue );
    public final eu.hyvar.dataValues.HyValue parseop_HyValue_level_15() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parseop_HyValue_level_15_StartIndex = input.index();

        eu.hyvar.dataValues.HyNumberValue c0 =null;

        eu.hyvar.dataValues.HyBooleanValue c1 =null;

        eu.hyvar.dataValues.HyEnumValue c2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Hyexpression.g:3353:0: (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue )
            int alt39=3;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
                {
                alt39=1;
                }
                break;
            case 40:
            case 41:
                {
                alt39=2;
                }
                break;
            case 38:
                {
                alt39=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }

            switch (alt39) {
                case 1 :
                    // Hyexpression.g:3354:0: c0= parse_eu_hyvar_dataValues_HyNumberValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_152965);
                    c0=parse_eu_hyvar_dataValues_HyNumberValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:3355:2: c1= parse_eu_hyvar_dataValues_HyBooleanValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_152973);
                    c1=parse_eu_hyvar_dataValues_HyBooleanValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hyexpression.g:3356:2: c2= parse_eu_hyvar_dataValues_HyEnumValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_152981);
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
            if ( state.backtracking>0 ) { memoize(input, 29, parseop_HyValue_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyValue_level_15"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyNumberValue"
    // Hyexpression.g:3359:1: parse_eu_hyvar_dataValues_HyNumberValue returns [eu.hyvar.dataValues.HyNumberValue element = null] : (a0= INTEGER_LITERAL ) ;
    public final eu.hyvar.dataValues.HyNumberValue parse_eu_hyvar_dataValues_HyNumberValue() throws RecognitionException {
        eu.hyvar.dataValues.HyNumberValue element =  null;

        int parse_eu_hyvar_dataValues_HyNumberValue_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Hyexpression.g:3362:4: ( (a0= INTEGER_LITERAL ) )
            // Hyexpression.g:3363:4: (a0= INTEGER_LITERAL )
            {
            // Hyexpression.g:3363:4: (a0= INTEGER_LITERAL )
            // Hyexpression.g:3364:4: a0= INTEGER_LITERAL
            {
            a0=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3005); if (state.failed) return element;

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
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 28211, 28217);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, parse_eu_hyvar_dataValues_HyNumberValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyNumberValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyBooleanValue"
    // Hyexpression.g:3404:1: parse_eu_hyvar_dataValues_HyBooleanValue returns [eu.hyvar.dataValues.HyBooleanValue element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.dataValues.HyBooleanValue parse_eu_hyvar_dataValues_HyBooleanValue() throws RecognitionException {
        eu.hyvar.dataValues.HyBooleanValue element =  null;

        int parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }

            // Hyexpression.g:3407:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hyexpression.g:3408:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hyexpression.g:3408:0: ( (a0= 'true' |a1= 'false' ) )
            // Hyexpression.g:3409:0: (a0= 'true' |a1= 'false' )
            {
            // Hyexpression.g:3409:0: (a0= 'true' |a1= 'false' )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==41) ) {
                alt40=1;
            }
            else if ( (LA40_0==40) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }
            switch (alt40) {
                case 1 :
                    // Hyexpression.g:3410:0: a0= 'true'
                    {
                    a0=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_dataValues_HyBooleanValue3037); if (state.failed) return element;

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
                    // Hyexpression.g:3423:2: a1= 'false'
                    {
                    a1=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_dataValues_HyBooleanValue3046); if (state.failed) return element;

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
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 28218, 28224);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 31, parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyBooleanValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumValue"
    // Hyexpression.g:3448:1: parse_eu_hyvar_dataValues_HyEnumValue returns [eu.hyvar.dataValues.HyEnumValue element = null] : a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) ) ;
    public final eu.hyvar.dataValues.HyEnumValue parse_eu_hyvar_dataValues_HyEnumValue() throws RecognitionException {
        eu.hyvar.dataValues.HyEnumValue element =  null;

        int parse_eu_hyvar_dataValues_HyEnumValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return element; }

            // Hyexpression.g:3451:4: (a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) ) )
            // Hyexpression.g:3452:4: a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnumValue3076); if (state.failed) return element;

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
            addExpectedElement(null, 28225, 28226);
            }

            // Hyexpression.g:3466:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==QUOTED_34_34) ) {
                alt41=1;
            }
            else if ( (LA41_0==IDENTIFIER_TOKEN) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1 :
                    // Hyexpression.g:3467:0: (a1= QUOTED_34_34 )
                    {
                    // Hyexpression.g:3467:4: (a1= QUOTED_34_34 )
                    // Hyexpression.g:3468:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3091); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
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
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 28227);
                    }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:3508:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hyexpression.g:3508:2: (a2= IDENTIFIER_TOKEN )
                    // Hyexpression.g:3509:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3108); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a2 != null) {
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
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
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a2, element);
                    copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 28228);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 28229);
            }

            a3=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue3126); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a3, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 28230, 28231);
            }

            // Hyexpression.g:3568:0: ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==QUOTED_34_34) ) {
                alt42=1;
            }
            else if ( (LA42_0==IDENTIFIER_TOKEN) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }
            switch (alt42) {
                case 1 :
                    // Hyexpression.g:3569:0: (a4= QUOTED_34_34 )
                    {
                    // Hyexpression.g:3569:4: (a4= QUOTED_34_34 )
                    // Hyexpression.g:3570:4: a4= QUOTED_34_34
                    {
                    a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3141); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a4 != null) {
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
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
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a4, element);
                    copyLocalizationInfos((CommonToken) a4, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 28232, 28238);
                    }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:3610:2: (a5= IDENTIFIER_TOKEN )
                    {
                    // Hyexpression.g:3610:2: (a5= IDENTIFIER_TOKEN )
                    // Hyexpression.g:3611:4: a5= IDENTIFIER_TOKEN
                    {
                    a5=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3158); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a5 != null) {
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
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
                    retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a5, element);
                    copyLocalizationInfos((CommonToken) a5, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    // We've found the last token for this rule. The constructed EObject is now
                    // complete.
                    completedElement(element, true);
                    addExpectedElement(null, 28239, 28245);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 28246, 28252);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 32, parse_eu_hyvar_dataValues_HyEnumValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumValue"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyExpression"
    // Hyexpression.g:3664:1: parse_eu_hyvar_feature_expression_HyExpression returns [eu.hyvar.feature.expression.HyExpression element = null] : c= parseop_HyExpression_level_0 ;
    public final eu.hyvar.feature.expression.HyExpression parse_eu_hyvar_feature_expression_HyExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyExpression_StartIndex = input.index();

        eu.hyvar.feature.expression.HyExpression c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return element; }

            // Hyexpression.g:3665:3: (c= parseop_HyExpression_level_0 )
            // Hyexpression.g:3666:3: c= parseop_HyExpression_level_0
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression3187);
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
            if ( state.backtracking>0 ) { memoize(input, 33, parse_eu_hyvar_feature_expression_HyExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyVersionRestriction"
    // Hyexpression.g:3670:1: parse_eu_hyvar_feature_expression_HyVersionRestriction returns [eu.hyvar.feature.expression.HyVersionRestriction element = null] : (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction );
    public final eu.hyvar.feature.expression.HyVersionRestriction parse_eu_hyvar_feature_expression_HyVersionRestriction() throws RecognitionException {
        eu.hyvar.feature.expression.HyVersionRestriction element =  null;

        int parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex = input.index();

        eu.hyvar.feature.expression.HyRelativeVersionRestriction c0 =null;

        eu.hyvar.feature.expression.HyVersionRangeRestriction c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return element; }

            // Hyexpression.g:3671:0: (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==33) ) {
                switch ( input.LA(2) ) {
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                    {
                    alt43=1;
                    }
                    break;
                case QUOTED_34_34:
                    {
                    int LA43_3 = input.LA(3);

                    if ( (LA43_3==35) ) {
                        alt43=1;
                    }
                    else if ( (LA43_3==20) ) {
                        alt43=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 43, 3, input);

                        throw nvae;

                    }
                    }
                    break;
                case 36:
                    {
                    alt43=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }
            switch (alt43) {
                case 1 :
                    // Hyexpression.g:3672:0: c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3206);
                    c0=parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyexpression.g:3673:2: c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3214);
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
            if ( state.backtracking>0 ) { memoize(input, 34, parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyVersionRestriction"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression"
    // Hyexpression.g:3677:1: parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c= parseop_HyArithmeticalValueExpression_level_4 ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_StartIndex = input.index();

        eu.hyvar.feature.expression.HyArithmeticalValueExpression c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return element; }

            // Hyexpression.g:3678:3: (c= parseop_HyArithmeticalValueExpression_level_4 )
            // Hyexpression.g:3679:3: c= parseop_HyArithmeticalValueExpression_level_4
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_4_in_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression3233);
            c=parseop_HyArithmeticalValueExpression_level_4();

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
            if ( state.backtracking>0 ) { memoize(input, 35, parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyValue"
    // Hyexpression.g:3683:1: parse_eu_hyvar_dataValues_HyValue returns [eu.hyvar.dataValues.HyValue element = null] : c= parseop_HyValue_level_15 ;
    public final eu.hyvar.dataValues.HyValue parse_eu_hyvar_dataValues_HyValue() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parse_eu_hyvar_dataValues_HyValue_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return element; }

            // Hyexpression.g:3684:3: (c= parseop_HyValue_level_15 )
            // Hyexpression.g:3685:3: c= parseop_HyValue_level_15
            {
            pushFollow(FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue3252);
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
            if ( state.backtracking>0 ) { memoize(input, 36, parse_eu_hyvar_dataValues_HyValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyValue"

    // Delegated rules


 

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
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnum680 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum713 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum752 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum782 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum838 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum877 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnum910 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum933 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum963 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnum1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_parse_eu_hyvar_dataValues_HyEnumLiteral1063 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral1081 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnumLiteral1102 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral1120 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral1141 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnumLiteral1164 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1197 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1236 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1266 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1322 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1361 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumLiteral1384 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumLiteral1417 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1440 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1470 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnumLiteral1522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_01570 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_parseop_HyExpression_level_01590 = new BitSet(new long[]{0x0000070040009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_01607 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_11653 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_parseop_HyExpression_level_11669 = new BitSet(new long[]{0x0000070040009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_11683 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_21724 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_parseop_HyExpression_level_21737 = new BitSet(new long[]{0x0000070040009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_21748 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_31786 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_parseop_HyExpression_level_31799 = new BitSet(new long[]{0x0000070040009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_31810 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_12_in_parseop_HyExpression_level_141848 = new BitSet(new long[]{0x0000070040008220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_141859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_141869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_151891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_151899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_151907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_151915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression_in_parseop_HyExpression_level_151923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedExpression1945 = new BitSet(new long[]{0x0000070040009220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression1958 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2000 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2017 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2076 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2091 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2108 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2198 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2211 = new BitSet(new long[]{0x000000003D002000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2227 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2236 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2245 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2254 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2263 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2272 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2289 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_42327 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parseop_HyArithmeticalValueExpression_level_42340 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_42351 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_52389 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_parseop_HyArithmeticalValueExpression_level_52402 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_52413 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_62451 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_62464 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_62475 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_72513 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_parseop_HyArithmeticalValueExpression_level_72526 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_72537 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_82575 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_parseop_HyArithmeticalValueExpression_level_82588 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_82599 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_112637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_112645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyArithmeticalValueExpression_level_112653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2679 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2696 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2714 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression2727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression2755 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression2770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression2787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression2822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_142849 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_142860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_142870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_in_parseop_HyArithmeticalValueExpression_level_152892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression2914 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression2927 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression2939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_152965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_152973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_152981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_dataValues_HyBooleanValue3037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_dataValues_HyBooleanValue3046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnumValue3076 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3091 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3108 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue3126 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression3187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_4_in_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression3233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue3252 = new BitSet(new long[]{0x0000000000000002L});

}