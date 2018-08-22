// $ANTLR 3.4

	package eu.hyvar.dataValues.resource.hydatavalue.mopp;
	
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
public class HydatavalueParser extends HydatavalueANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DATE", "IDENTIFIER_TOKEN", "INTEGER_LITERAL", "LINEBREAK", "ML_COMMENT", "QUOTED_34_34", "SL_COMMENT", "WHITESPACE", "')'", "','", "'-'", "'.'", "'Enum('", "'EnumLiteral('", "'['", "']'", "'enum:'", "'eternity'", "'false'", "'true'"
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
    public static final int DATE=4;
    public static final int IDENTIFIER_TOKEN=5;
    public static final int INTEGER_LITERAL=6;
    public static final int LINEBREAK=7;
    public static final int ML_COMMENT=8;
    public static final int QUOTED_34_34=9;
    public static final int SL_COMMENT=10;
    public static final int WHITESPACE=11;

    // delegates
    public HydatavalueANTLRParserBase[] getDelegates() {
        return new HydatavalueANTLRParserBase[] {};
    }

    // delegators


    public HydatavalueParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public HydatavalueParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(23 + 1);
         

    }

    public String[] getTokenNames() { return HydatavalueParser.tokenNames; }
    public String getGrammarFileName() { return "Hydatavalue.g"; }


    	private eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolverFactory tokenResolverFactory = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTokenResolverFactory();
    	
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
    	private List<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal> expectedElements = new ArrayList<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal>();
    	
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
    	
    	private eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueLocationMap locationMap;
    	
    	private eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueSyntaxErrorMessageConverter syntaxErrorMessageConverter = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueSyntaxErrorMessageConverter(tokenNames);
    	
    	@Override
    	public void reportError(RecognitionException re) {
    		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
    	}
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueCommand<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource>() {
    			public boolean execute(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueProblem() {
    					public eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemSeverity getSeverity() {
    						return eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemSeverity.ERROR;
    					}
    					public eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemType getType() {
    						return eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	protected void addErrorToResource(eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueLocalizedMessage message) {
    		if (message == null) {
    			return;
    		}
    		addErrorToResource(message.getMessage(), message.getColumn(), message.getLine(), message.getCharStart(), message.getCharEnd());
    	}
    	
    	public void addExpectedElement(EClass eClass, int expectationStartIndex, int expectationEndIndex) {
    		for (int expectationIndex = expectationStartIndex; expectationIndex <= expectationEndIndex; expectationIndex++) {
    			addExpectedElement(eClass, eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectationConstants.EXPECTATIONS[expectationIndex]);
    		}
    	}
    	
    	public void addExpectedElement(EClass eClass, int expectationIndex) {
    		addExpectedElement(eClass, eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectationConstants.EXPECTATIONS[expectationIndex]);
    	}
    	
    	public void addExpectedElement(EClass eClass, int[] ids) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		int terminalID = ids[0];
    		int followSetID = ids[1];
    		eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueExpectedElement terminal = eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueFollowSetProvider.TERMINALS[terminalID];
    		eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[] containmentFeatures = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueFollowSetProvider.LINKS[ids[i]];
    		}
    		eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueContainmentTrace containmentTrace = new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueContainmentTrace(eClass, containmentFeatures);
    		EObject container = getLastIncompleteElement();
    		eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal expectedElement = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		final eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueCommand<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource>() {
    			public boolean execute(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource resource) {
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
    		final eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueCommand<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource>() {
    			public boolean execute(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource resource) {
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
    	protected void setLocalizationEnd(Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueCommand<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		final eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueCommand<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource>() {
    			public boolean execute(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource resource) {
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextParser createInstance(InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new HydatavalueParser(new CommonTokenStream(new HydatavalueLexer(new ANTLRInputStream(actualInputStream))));
    			} else {
    				return new HydatavalueParser(new CommonTokenStream(new HydatavalueLexer(new ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (IOException e) {
    			new eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public HydatavalueParser() {
    		super(null);
    	}
    	
    	protected EObject doParse() throws RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((HydatavalueLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((HydatavalueLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof EClass) {
    			EClass type = (EClass) typeObject;
    			if (type.getInstanceClass() == eu.hyvar.dataValues.HyEnum.class) {
    				return parse_eu_hyvar_dataValues_HyEnum();
    			}
    			if (type.getInstanceClass() == eu.hyvar.dataValues.HyEnumLiteral.class) {
    				return parse_eu_hyvar_dataValues_HyEnumLiteral();
    			}
    		}
    		throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueParseResult parse() {
    		// Reset parser state
    		terminateParsing = false;
    		postParseCommands = new ArrayList<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueCommand<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource>>();
    		eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueParseResult parseResult = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueParseResult();
    		if (disableLocationMap) {
    			locationMap = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueDevNullLocationMap();
    		} else {
    			locationMap = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueLocationMap();
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
    	
    	public List<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal> parseToExpectedElements(EClass type, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
    		eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueParseResult result = parse();
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
    			for (eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueCommand<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		Set<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal> currentFollowSet = new LinkedHashSet<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal>();
    		List<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal> newFollowSet = new ArrayList<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 50;
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
    				for (eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						Collection<eu.hyvar.dataValues.resource.hydatavalue.util.HydatavaluePair<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueExpectedElement, eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (eu.hyvar.dataValues.resource.hydatavalue.util.HydatavaluePair<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueExpectedElement, eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[]> newFollowerPair : newFollowers) {
    							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueExpectedElement newFollower = newFollowerPair.getLeft();
    							EObject container = getLastIncompleteElement();
    							eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueContainmentTrace containmentTrace = new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueContainmentTrace(null, newFollowerPair.getRight());
    							eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal newFollowTerminal = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal expectedElement, int tokenIndex) {
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
    // Hydatavalue.g:485:1: start returns [ EObject element = null] : (c0= parse_eu_hyvar_dataValues_HyValue |c1= parse_eu_hyvar_dataValues_HyEnum |c2= parse_eu_hyvar_dataValues_HyEnumLiteral ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue c0 =null;

        eu.hyvar.dataValues.HyEnum c1 =null;

        eu.hyvar.dataValues.HyEnumLiteral c2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Hydatavalue.g:486:2: ( (c0= parse_eu_hyvar_dataValues_HyValue |c1= parse_eu_hyvar_dataValues_HyEnum |c2= parse_eu_hyvar_dataValues_HyEnumLiteral ) EOF )
            // Hydatavalue.g:487:2: (c0= parse_eu_hyvar_dataValues_HyValue |c1= parse_eu_hyvar_dataValues_HyEnum |c2= parse_eu_hyvar_dataValues_HyEnumLiteral ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, 0, 4);
            		expectedElementsIndexOfLastCompleteElement = 4;
            	}

            // Hydatavalue.g:492:2: (c0= parse_eu_hyvar_dataValues_HyValue |c1= parse_eu_hyvar_dataValues_HyEnum |c2= parse_eu_hyvar_dataValues_HyEnumLiteral )
            int alt1=3;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
            case 20:
            case 22:
            case 23:
                {
                alt1=1;
                }
                break;
            case 16:
                {
                alt1=2;
                }
                break;
            case 17:
                {
                alt1=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // Hydatavalue.g:493:3: c0= parse_eu_hyvar_dataValues_HyValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_start82);
                    c0=parse_eu_hyvar_dataValues_HyValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; }

                    }
                    break;
                case 2 :
                    // Hydatavalue.g:494:8: c1= parse_eu_hyvar_dataValues_HyEnum
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnum_in_start96);
                    c1=parse_eu_hyvar_dataValues_HyEnum();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; }

                    }
                    break;
                case 3 :
                    // Hydatavalue.g:495:8: c2= parse_eu_hyvar_dataValues_HyEnumLiteral
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_start110);
                    c2=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; }

                    }
                    break;

            }


            match(input,EOF,FOLLOW_EOF_in_start117); if (state.failed) return element;

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



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnum"
    // Hydatavalue.g:503:1: parse_eu_hyvar_dataValues_HyEnum returns [eu.hyvar.dataValues.HyEnum element = null] : a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Hydatavalue.g:506:2: (a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? )
            // Hydatavalue.g:507:2: a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            {
            a0=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum143); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5);
            	}

            // Hydatavalue.g:521:2: (a1= IDENTIFIER_TOKEN )
            // Hydatavalue.g:522:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum161); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 6);
            	}

            a2=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnum182); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 7);
            		addExpectedElement(null, 8);
            	}

            // Hydatavalue.g:572:2: ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Hydatavalue.g:573:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    {
                    // Hydatavalue.g:573:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    // Hydatavalue.g:574:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    {
                    // Hydatavalue.g:574:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    // Hydatavalue.g:575:5: a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum211);
                    a3_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
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
                    						retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 9, 10);
                    			}

                    // Hydatavalue.g:600:4: ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==13) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // Hydatavalue.g:601:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    {
                    	    // Hydatavalue.g:601:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    // Hydatavalue.g:602:6: a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    {
                    	    a4=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnum252); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((CommonToken)a4, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 11);
                    	    					}

                    	    // Hydatavalue.g:616:6: (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    // Hydatavalue.g:617:7: a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum286);
                    	    a5_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    							if (terminateParsing) {
                    	    								throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
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
                    	    								retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_1, a5_0, true);
                    	    								copyLocalizationInfos(a5_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, 12, 13);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 14, 15);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 16);
            	}

            a6=(Token)match(input,12,FOLLOW_12_in_parse_eu_hyvar_dataValues_HyEnum360); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 17);
            	}

            // Hydatavalue.g:670:2: ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Hydatavalue.g:671:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    {
                    // Hydatavalue.g:671:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    // Hydatavalue.g:672:4: a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']'
                    {
                    a7=(Token)match(input,18,FOLLOW_18_in_parse_eu_hyvar_dataValues_HyEnum383); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a7, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 18, 20);
                    			}

                    // Hydatavalue.g:686:4: ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) )
                    int alt4=3;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==DATE) ) {
                        int LA4_1 = input.LA(2);

                        if ( (LA4_1==14) ) {
                            int LA4_3 = input.LA(3);

                            if ( (LA4_3==DATE) ) {
                                alt4=1;
                            }
                            else if ( (LA4_3==19) ) {
                                alt4=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA4_0==21) ) {
                        alt4=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;

                    }
                    switch (alt4) {
                        case 1 :
                            // Hydatavalue.g:687:5: (a8= DATE ) a9= '-' (a10= DATE )
                            {
                            // Hydatavalue.g:687:5: (a8= DATE )
                            // Hydatavalue.g:688:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum416); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 21);
                            				}

                            a9=(Token)match(input,14,FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnum455); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 22);
                            				}

                            // Hydatavalue.g:737:5: (a10= DATE )
                            // Hydatavalue.g:738:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum485); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a10 != null) {
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a10, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 23);
                            				}

                            }
                            break;
                        case 2 :
                            // Hydatavalue.g:774:10: (a11= DATE ) a12= '-'
                            {
                            // Hydatavalue.g:774:10: (a11= DATE )
                            // Hydatavalue.g:775:6: a11= DATE
                            {
                            a11=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum541); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a11 != null) {
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a11, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 24);
                            				}

                            a12=(Token)match(input,14,FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnum580); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 25);
                            				}

                            }
                            break;
                        case 3 :
                            // Hydatavalue.g:825:10: a13= 'eternity' a14= '-' (a15= DATE )
                            {
                            a13=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum613); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 26);
                            				}

                            a14=(Token)match(input,14,FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnum636); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a14, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 27);
                            				}

                            // Hydatavalue.g:853:5: (a15= DATE )
                            // Hydatavalue.g:854:6: a15= DATE
                            {
                            a15=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum666); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a15 != null) {
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a15, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 28);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 29);
                    			}

                    a16=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum718); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
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
            if ( state.backtracking>0 ) { memoize(input, 2, parse_eu_hyvar_dataValues_HyEnum_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnum"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumLiteral"
    // Hydatavalue.g:922:1: parse_eu_hyvar_dataValues_HyEnumLiteral returns [eu.hyvar.dataValues.HyEnumLiteral element = null] : a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Hydatavalue.g:925:2: (a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hydatavalue.g:926:2: a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            a0=(Token)match(input,17,FOLLOW_17_in_parse_eu_hyvar_dataValues_HyEnumLiteral766); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 30);
            	}

            // Hydatavalue.g:940:2: (a1= IDENTIFIER_TOKEN )
            // Hydatavalue.g:941:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral784); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 31);
            	}

            a2=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnumLiteral805); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 32);
            	}

            // Hydatavalue.g:990:2: (a3= INTEGER_LITERAL )
            // Hydatavalue.g:991:3: a3= INTEGER_LITERAL
            {
            a3=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral823); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_3, resolved, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 33);
            	}

            a4=(Token)match(input,12,FOLLOW_12_in_parse_eu_hyvar_dataValues_HyEnumLiteral844); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 34, 36);
            	}

            // Hydatavalue.g:1040:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Hydatavalue.g:1041:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hydatavalue.g:1041:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hydatavalue.g:1042:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,18,FOLLOW_18_in_parse_eu_hyvar_dataValues_HyEnumLiteral867); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 37, 39);
                    			}

                    // Hydatavalue.g:1056:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) )
                    int alt6=3;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==DATE) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==14) ) {
                            int LA6_3 = input.LA(3);

                            if ( (LA6_3==DATE) ) {
                                alt6=1;
                            }
                            else if ( (LA6_3==21) ) {
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
                    else if ( (LA6_0==21) ) {
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
                            // Hydatavalue.g:1057:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hydatavalue.g:1057:5: (a6= DATE )
                            // Hydatavalue.g:1058:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral900); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a6 != null) {
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a6, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 40);
                            				}

                            a7=(Token)match(input,14,FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnumLiteral939); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 41);
                            				}

                            // Hydatavalue.g:1107:5: (a8= DATE )
                            // Hydatavalue.g:1108:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral969); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 42);
                            				}

                            }
                            break;
                        case 2 :
                            // Hydatavalue.g:1144:10: (a9= DATE ) a10= '-' a11= 'eternity'
                            {
                            // Hydatavalue.g:1144:10: (a9= DATE )
                            // Hydatavalue.g:1145:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1025); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a9 != null) {
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a9, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 43);
                            				}

                            a10=(Token)match(input,14,FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnumLiteral1064); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a10, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 44);
                            				}

                            a11=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral1087); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a11, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 45);
                            				}

                            }
                            break;
                        case 3 :
                            // Hydatavalue.g:1209:10: a12= 'eternity' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral1120); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 46);
                            				}

                            a13=(Token)match(input,14,FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnumLiteral1143); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 47);
                            				}

                            // Hydatavalue.g:1237:5: (a14= DATE )
                            // Hydatavalue.g:1238:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1173); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a14 != null) {
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a14, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 48);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 49);
                    			}

                    a15=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnumLiteral1225); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a15, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				// We've found the last token for this rule. The constructed EObject is now
                    				// complete.
                    				completedElement(element, true);
                    				addExpectedElement(null, 50, 51);
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
            		addExpectedElement(null, 52, 53);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_eu_hyvar_dataValues_HyEnumLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumLiteral"



    // $ANTLR start "parseop_HyValue_level_15"
    // Hydatavalue.g:1308:1: parseop_HyValue_level_15 returns [eu.hyvar.dataValues.HyValue element = null] : (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue );
    public final eu.hyvar.dataValues.HyValue parseop_HyValue_level_15() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parseop_HyValue_level_15_StartIndex = input.index();

        eu.hyvar.dataValues.HyNumberValue c0 =null;

        eu.hyvar.dataValues.HyBooleanValue c1 =null;

        eu.hyvar.dataValues.HyEnumValue c2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Hydatavalue.g:1311:2: (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue )
            int alt8=3;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
                {
                alt8=1;
                }
                break;
            case 22:
            case 23:
                {
                alt8=2;
                }
                break;
            case 20:
                {
                alt8=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // Hydatavalue.g:1312:2: c0= parse_eu_hyvar_dataValues_HyNumberValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_151273);
                    c0=parse_eu_hyvar_dataValues_HyNumberValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hydatavalue.g:1313:4: c1= parse_eu_hyvar_dataValues_HyBooleanValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_151283);
                    c1=parse_eu_hyvar_dataValues_HyBooleanValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hydatavalue.g:1314:4: c2= parse_eu_hyvar_dataValues_HyEnumValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_151293);
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
            if ( state.backtracking>0 ) { memoize(input, 4, parseop_HyValue_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyValue_level_15"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyNumberValue"
    // Hydatavalue.g:1317:1: parse_eu_hyvar_dataValues_HyNumberValue returns [eu.hyvar.dataValues.HyNumberValue element = null] : (a0= INTEGER_LITERAL ) ;
    public final eu.hyvar.dataValues.HyNumberValue parse_eu_hyvar_dataValues_HyNumberValue() throws RecognitionException {
        eu.hyvar.dataValues.HyNumberValue element =  null;

        int parse_eu_hyvar_dataValues_HyNumberValue_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Hydatavalue.g:1320:2: ( (a0= INTEGER_LITERAL ) )
            // Hydatavalue.g:1321:2: (a0= INTEGER_LITERAL )
            {
            // Hydatavalue.g:1321:2: (a0= INTEGER_LITERAL )
            // Hydatavalue.g:1322:3: a0= INTEGER_LITERAL
            {
            a0=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue1320); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyNumberValue();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_0_0_0_0, resolved, true);
            				copyLocalizationInfos((CommonToken) a0, element);
            			}
            		}

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
            if ( state.backtracking>0 ) { memoize(input, 5, parse_eu_hyvar_dataValues_HyNumberValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyNumberValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyBooleanValue"
    // Hydatavalue.g:1361:1: parse_eu_hyvar_dataValues_HyBooleanValue returns [eu.hyvar.dataValues.HyBooleanValue element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.dataValues.HyBooleanValue parse_eu_hyvar_dataValues_HyBooleanValue() throws RecognitionException {
        eu.hyvar.dataValues.HyBooleanValue element =  null;

        int parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Hydatavalue.g:1364:2: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hydatavalue.g:1365:2: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hydatavalue.g:1365:2: ( (a0= 'true' |a1= 'false' ) )
            // Hydatavalue.g:1366:3: (a0= 'true' |a1= 'false' )
            {
            // Hydatavalue.g:1366:3: (a0= 'true' |a1= 'false' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==23) ) {
                alt9=1;
            }
            else if ( (LA9_0==22) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // Hydatavalue.g:1367:4: a0= 'true'
                    {
                    a0=(Token)match(input,23,FOLLOW_23_in_parse_eu_hyvar_dataValues_HyBooleanValue1365); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_1_0_0_0, true, true);
                    				copyLocalizationInfos((CommonToken)a0, element);
                    				// set value of boolean attribute
                    				Object value = true;
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Hydatavalue.g:1380:8: a1= 'false'
                    {
                    a1=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_dataValues_HyBooleanValue1380); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_1_0_0_0, false, true);
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
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyBooleanValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumValue"
    // Hydatavalue.g:1404:1: parse_eu_hyvar_dataValues_HyEnumValue returns [eu.hyvar.dataValues.HyEnumValue element = null] : a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Hydatavalue.g:1407:2: (a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) ) )
            // Hydatavalue.g:1408:2: a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
            {
            a0=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumValue1416); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 54, 55);
            	}

            // Hydatavalue.g:1422:2: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==QUOTED_34_34) ) {
                alt10=1;
            }
            else if ( (LA10_0==IDENTIFIER_TOKEN) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // Hydatavalue.g:1423:3: (a1= QUOTED_34_34 )
                    {
                    // Hydatavalue.g:1423:3: (a1= QUOTED_34_34 )
                    // Hydatavalue.g:1424:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue1439); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    					startIncompleteElement(element);
                    				}
                    				if (a1 != null) {
                    					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_0_0, proxy, true);
                    					copyLocalizationInfos((CommonToken) a1, element);
                    					copyLocalizationInfos((CommonToken) a1, proxy);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, 56);
                    		}

                    }
                    break;
                case 2 :
                    // Hydatavalue.g:1464:6: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hydatavalue.g:1464:6: (a2= IDENTIFIER_TOKEN )
                    // Hydatavalue.g:1465:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue1477); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    					startIncompleteElement(element);
                    				}
                    				if (a2 != null) {
                    					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_1_0, proxy, true);
                    					copyLocalizationInfos((CommonToken) a2, element);
                    					copyLocalizationInfos((CommonToken) a2, proxy);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, 57);
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 58);
            	}

            a3=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_dataValues_HyEnumValue1511); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 59, 60);
            	}

            // Hydatavalue.g:1524:2: ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==QUOTED_34_34) ) {
                alt11=1;
            }
            else if ( (LA11_0==IDENTIFIER_TOKEN) ) {
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
                    // Hydatavalue.g:1525:3: (a4= QUOTED_34_34 )
                    {
                    // Hydatavalue.g:1525:3: (a4= QUOTED_34_34 )
                    // Hydatavalue.g:1526:4: a4= QUOTED_34_34
                    {
                    a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue1534); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    					startIncompleteElement(element);
                    				}
                    				if (a4 != null) {
                    					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_0_0, proxy, true);
                    					copyLocalizationInfos((CommonToken) a4, element);
                    					copyLocalizationInfos((CommonToken) a4, proxy);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    		}

                    }
                    break;
                case 2 :
                    // Hydatavalue.g:1565:6: (a5= IDENTIFIER_TOKEN )
                    {
                    // Hydatavalue.g:1565:6: (a5= IDENTIFIER_TOKEN )
                    // Hydatavalue.g:1566:4: a5= IDENTIFIER_TOKEN
                    {
                    a5=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue1572); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    					startIncompleteElement(element);
                    				}
                    				if (a5 != null) {
                    					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_1_0, proxy, true);
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
            if ( state.backtracking>0 ) { memoize(input, 7, parse_eu_hyvar_dataValues_HyEnumValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyValue"
    // Hydatavalue.g:1617:1: parse_eu_hyvar_dataValues_HyValue returns [eu.hyvar.dataValues.HyValue element = null] : c= parseop_HyValue_level_15 ;
    public final eu.hyvar.dataValues.HyValue parse_eu_hyvar_dataValues_HyValue() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parse_eu_hyvar_dataValues_HyValue_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Hydatavalue.g:1618:2: (c= parseop_HyValue_level_15 )
            // Hydatavalue.g:1619:2: c= parseop_HyValue_level_15
            {
            pushFollow(FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue1617);
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
            if ( state.backtracking>0 ) { memoize(input, 8, parse_eu_hyvar_dataValues_HyValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnum_in_start96 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_start110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum143 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum161 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnum182 = new BitSet(new long[]{0x0000000000021000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum211 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnum252 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum286 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_parse_eu_hyvar_dataValues_HyEnum360 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_parse_eu_hyvar_dataValues_HyEnum383 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum416 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnum455 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum485 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum541 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnum580 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum613 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnum636 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum666 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_eu_hyvar_dataValues_HyEnumLiteral766 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral784 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnumLiteral805 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral823 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_eu_hyvar_dataValues_HyEnumLiteral844 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_parse_eu_hyvar_dataValues_HyEnumLiteral867 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral900 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnumLiteral939 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral969 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1025 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnumLiteral1064 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral1087 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral1120 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnumLiteral1143 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1173 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnumLiteral1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_151273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_151283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_151293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_eu_hyvar_dataValues_HyBooleanValue1365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_dataValues_HyBooleanValue1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumValue1416 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue1439 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue1477 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_dataValues_HyEnumValue1511 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue1617 = new BitSet(new long[]{0x0000000000000002L});

}