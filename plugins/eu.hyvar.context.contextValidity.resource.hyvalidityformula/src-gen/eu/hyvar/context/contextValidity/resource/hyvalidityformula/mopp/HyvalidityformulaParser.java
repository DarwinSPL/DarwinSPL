// $ANTLR 3.4

	package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;
	
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
public class HyvalidityformulaParser extends HyvalidityformulaANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DATE", "IDENTIFIER_TOKEN", "INTEGER_LITERAL", "LINEBREAK", "ML_COMMENT", "QUOTED_34_34", "SL_COMMENT", "WHITESPACE", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'->'", "'.'", "'/'", "':'", "'<'", "'<->'", "'<='", "'='", "'>'", "'>='", "'?'", "'Enum('", "'EnumLiteral('", "'['", "'\\u0025'", "']'", "'^'", "'enum:'", "'eternity'", "'false'", "'true'", "'{'", "'||'", "'}'"
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
    public HyvalidityformulaANTLRParserBase[] getDelegates() {
        return new HyvalidityformulaANTLRParserBase[] {};
    }

    // delegators


    public HyvalidityformulaParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public HyvalidityformulaParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(108 + 1);
         

    }

    public String[] getTokenNames() { return HyvalidityformulaParser.tokenNames; }
    public String getGrammarFileName() { return "Hyvalidityformula.g"; }


    	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolverFactory tokenResolverFactory = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTokenResolverFactory();
    	
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
    	private List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal> expectedElements = new ArrayList<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal>();
    	
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
    	
    	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaLocationMap locationMap;
    	
    	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaSyntaxErrorMessageConverter syntaxErrorMessageConverter = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaSyntaxErrorMessageConverter(tokenNames);
    	
    	@Override
    	public void reportError(RecognitionException re) {
    		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
    	}
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource>() {
    			public boolean execute(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaProblem() {
    					public eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemSeverity getSeverity() {
    						return eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemSeverity.ERROR;
    					}
    					public eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemType getType() {
    						return eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	protected void addErrorToResource(eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaLocalizedMessage message) {
    		if (message == null) {
    			return;
    		}
    		addErrorToResource(message.getMessage(), message.getColumn(), message.getLine(), message.getCharStart(), message.getCharEnd());
    	}
    	
    	public void addExpectedElement(EClass eClass, int expectationStartIndex, int expectationEndIndex) {
    		for (int expectationIndex = expectationStartIndex; expectationIndex <= expectationEndIndex; expectationIndex++) {
    			addExpectedElement(eClass, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[expectationIndex]);
    		}
    	}
    	
    	public void addExpectedElement(EClass eClass, int expectationIndex) {
    		addExpectedElement(eClass, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[expectationIndex]);
    	}
    	
    	public void addExpectedElement(EClass eClass, int[] ids) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		int terminalID = ids[0];
    		int followSetID = ids[1];
    		eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaExpectedElement terminal = eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaFollowSetProvider.TERMINALS[terminalID];
    		eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContainedFeature[] containmentFeatures = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaFollowSetProvider.LINKS[ids[i]];
    		}
    		eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainmentTrace containmentTrace = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainmentTrace(eClass, containmentFeatures);
    		EObject container = getLastIncompleteElement();
    		eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal expectedElement = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		final eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource>() {
    			public boolean execute(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource resource) {
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
    		final eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource>() {
    			public boolean execute(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource resource) {
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
    	protected void setLocalizationEnd(Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		final eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource>() {
    			public boolean execute(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource resource) {
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextParser createInstance(InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new HyvalidityformulaParser(new CommonTokenStream(new HyvalidityformulaLexer(new ANTLRInputStream(actualInputStream))));
    			} else {
    				return new HyvalidityformulaParser(new CommonTokenStream(new HyvalidityformulaLexer(new ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (IOException e) {
    			new eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public HyvalidityformulaParser() {
    		super(null);
    	}
    	
    	protected EObject doParse() throws RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((HyvalidityformulaLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((HyvalidityformulaLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof EClass) {
    			EClass type = (EClass) typeObject;
    			if (type.getInstanceClass() == eu.hyvar.context.contextValidity.HyValidityModel.class) {
    				return parse_eu_hyvar_context_contextValidity_HyValidityModel();
    			}
    			if (type.getInstanceClass() == eu.hyvar.feature.expression.HyArithmeticalComparisonExpression.class) {
    				return parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression();
    			}
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
    		throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaParseResult parse() {
    		// Reset parser state
    		terminateParsing = false;
    		postParseCommands = new ArrayList<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource>>();
    		eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaParseResult parseResult = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaParseResult();
    		if (disableLocationMap) {
    			locationMap = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaDevNullLocationMap();
    		} else {
    			locationMap = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaLocationMap();
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
    	
    	public List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal> parseToExpectedElements(EClass type, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
    		eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaParseResult result = parse();
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
    			for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		Set<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal> currentFollowSet = new LinkedHashSet<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal>();
    		List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal> newFollowSet = new ArrayList<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 142;
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
    				for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaPair<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaExpectedElement, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaPair<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaExpectedElement, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContainedFeature[]> newFollowerPair : newFollowers) {
    							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaExpectedElement newFollower = newFollowerPair.getLeft();
    							EObject container = getLastIncompleteElement();
    							eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainmentTrace containmentTrace = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainmentTrace(null, newFollowerPair.getRight());
    							eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal newFollowTerminal = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal expectedElement, int tokenIndex) {
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
    // Hyvalidityformula.g:497:1: start returns [ EObject element = null] : (c0= parse_eu_hyvar_context_contextValidity_HyValidityModel ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        eu.hyvar.context.contextValidity.HyValidityModel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Hyvalidityformula.g:498:2: ( (c0= parse_eu_hyvar_context_contextValidity_HyValidityModel ) EOF )
            // Hyvalidityformula.g:499:2: (c0= parse_eu_hyvar_context_contextValidity_HyValidityModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 0, 3);
            		expectedElementsIndexOfLastCompleteElement = 3;
            	}

            // Hyvalidityformula.g:504:2: (c0= parse_eu_hyvar_context_contextValidity_HyValidityModel )
            // Hyvalidityformula.g:505:3: c0= parse_eu_hyvar_context_contextValidity_HyValidityModel
            {
            pushFollow(FOLLOW_parse_eu_hyvar_context_contextValidity_HyValidityModel_in_start82);
            c0=parse_eu_hyvar_context_contextValidity_HyValidityModel();

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



    // $ANTLR start "parse_eu_hyvar_context_contextValidity_HyValidityModel"
    // Hyvalidityformula.g:513:1: parse_eu_hyvar_context_contextValidity_HyValidityModel returns [eu.hyvar.context.contextValidity.HyValidityModel element = null] : ( (a0_0= parse_eu_hyvar_context_contextValidity_HyValidityFormula ) )* ;
    public final eu.hyvar.context.contextValidity.HyValidityModel parse_eu_hyvar_context_contextValidity_HyValidityModel() throws RecognitionException {
        eu.hyvar.context.contextValidity.HyValidityModel element =  null;

        int parse_eu_hyvar_context_contextValidity_HyValidityModel_StartIndex = input.index();

        eu.hyvar.context.contextValidity.HyValidityFormula a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Hyvalidityformula.g:516:2: ( ( (a0_0= parse_eu_hyvar_context_contextValidity_HyValidityFormula ) )* )
            // Hyvalidityformula.g:517:2: ( (a0_0= parse_eu_hyvar_context_contextValidity_HyValidityFormula ) )*
            {
            // Hyvalidityformula.g:517:2: ( (a0_0= parse_eu_hyvar_context_contextValidity_HyValidityFormula ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IDENTIFIER_TOKEN||LA1_0==QUOTED_34_34) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Hyvalidityformula.g:518:3: (a0_0= parse_eu_hyvar_context_contextValidity_HyValidityFormula )
            	    {
            	    // Hyvalidityformula.g:518:3: (a0_0= parse_eu_hyvar_context_contextValidity_HyValidityFormula )
            	    // Hyvalidityformula.g:519:4: a0_0= parse_eu_hyvar_context_contextValidity_HyValidityFormula
            	    {
            	    pushFollow(FOLLOW_parse_eu_hyvar_context_contextValidity_HyValidityFormula_in_parse_eu_hyvar_context_contextValidity_HyValidityModel124);
            	    a0_0=parse_eu_hyvar_context_contextValidity_HyValidityFormula();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyValidityModel();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a0_0 != null) {
            	    					if (a0_0 != null) {
            	    						Object value = a0_0;
            	    						addObjectToList(element, eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_VALIDITY_MODEL__VALIDITY_FORMULAS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_0_0_0_0, a0_0, true);
            	    					copyLocalizationInfos(a0_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		// We've found the last token for this rule. The constructed EObject is now
            		// complete.
            		completedElement(element, true);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 4, 7);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_eu_hyvar_context_contextValidity_HyValidityModel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_context_contextValidity_HyValidityModel"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression"
    // Hyvalidityformula.g:550:1: parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression returns [eu.hyvar.feature.expression.HyArithmeticalComparisonExpression element = null] : a0= '{' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) ) (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a11= '}' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Hyvalidityformula.g:553:2: (a0= '{' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) ) (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a11= '}' )
            // Hyvalidityformula.g:554:2: a0= '{' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) ) (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a11= '}'
            {
            a0=(Token)match(input,42,FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression165); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_9_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(), 8, 2941);
            	}

            // Hyvalidityformula.g:568:2: (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression )
            // Hyvalidityformula.g:569:3: a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression183);
            a1_0=parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
            				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_9_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 2942);
            	}

            // Hyvalidityformula.g:594:2: ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) )
            // Hyvalidityformula.g:595:3: (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' )
            {
            // Hyvalidityformula.g:595:3: (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' )
            int alt2=6;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt2=1;
                }
                break;
            case 27:
                {
                alt2=2;
                }
                break;
            case 28:
                {
                alt2=3;
                }
                break;
            case 13:
                {
                alt2=4;
                }
                break;
            case 30:
                {
                alt2=5;
                }
                break;
            case 29:
                {
                alt2=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // Hyvalidityformula.g:596:4: a2= '<'
                    {
                    a2=(Token)match(input,25,FOLLOW_25_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression210); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_LESS_OPERATOR_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:609:8: a3= '<='
                    {
                    a3=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression225); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a3, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_LESS_OR_EQUAL_OPERATOR_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Hyvalidityformula.g:622:8: a4= '='
                    {
                    a4=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression240); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a4, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_EQUAL_OPERATOR_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 4 :
                    // Hyvalidityformula.g:635:8: a5= '!='
                    {
                    a5=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression255); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_NOT_EQUAL_OPERATOR_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 5 :
                    // Hyvalidityformula.g:648:8: a6= '>='
                    {
                    a6=(Token)match(input,30,FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression270); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a6, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_GREATER_OR_EQUAL_OPERATOR_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 6 :
                    // Hyvalidityformula.g:661:8: a7= '>'
                    {
                    a7=(Token)match(input,29,FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression285); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
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
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(), 2943, 5876);
            	}

            // Hyvalidityformula.g:681:2: (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression )
            // Hyvalidityformula.g:682:3: a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression310);
            a10_0=parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
            				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_9_0_0_3, a10_0, true);
            				copyLocalizationInfos(a10_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5877);
            	}

            a11=(Token)match(input,44,FOLLOW_44_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression328); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_9_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a11, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		// We've found the last token for this rule. The constructed EObject is now
            		// complete.
            		completedElement(element, true);
            		addExpectedElement(null, 5878);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 5879, 5882);
            		addExpectedElement(null, 5883, 5888);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction"
    // Hyvalidityformula.g:728:1: parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction returns [eu.hyvar.feature.expression.HyRelativeVersionRestriction element = null] : a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Hyvalidityformula.g:731:2: (a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' )
            // Hyvalidityformula.g:732:2: a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']'
            {
            a0=(Token)match(input,34,FOLLOW_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction357); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_20_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5889, 5890);
            	}

            // Hyvalidityformula.g:749:2: ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? )
            // Hyvalidityformula.g:750:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
            {
            // Hyvalidityformula.g:750:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
            int alt3=6;
            switch ( input.LA(1) ) {
                case 25:
                    {
                    alt3=1;
                    }
                    break;
                case 27:
                    {
                    alt3=2;
                    }
                    break;
                case 28:
                    {
                    alt3=3;
                    }
                    break;
                case 30:
                    {
                    alt3=4;
                    }
                    break;
                case 29:
                    {
                    alt3=5;
                    }
                    break;
            }

            switch (alt3) {
                case 1 :
                    // Hyvalidityformula.g:751:4: a1= '<'
                    {
                    a1=(Token)match(input,25,FOLLOW_25_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction380); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:767:8: a2= '<='
                    {
                    a2=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction395); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Hyvalidityformula.g:783:8: a3= '='
                    {
                    a3=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction410); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a3, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 4 :
                    // Hyvalidityformula.g:799:8: a4= '>='
                    {
                    a4=(Token)match(input,30,FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction425); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a4, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 5 :
                    // Hyvalidityformula.g:815:8: a5= '>'
                    {
                    a5=(Token)match(input,29,FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction440); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
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
            		addExpectedElement(null, 5891);
            	}

            // Hyvalidityformula.g:837:2: (a8= QUOTED_34_34 )
            // Hyvalidityformula.g:838:3: a8= QUOTED_34_34
            {
            a8=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction465); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            				startIncompleteElement(element);
            				// initialize enumeration attribute
            				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            			}
            			if (a8 != null) {
            				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyRelativeVersionRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyRelativeVersionRestrictionVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_20_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a8, element);
            				copyLocalizationInfos((CommonToken) a8, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5892);
            	}

            a9=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction486); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_20_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		// We've found the last token for this rule. The constructed EObject is now
            		// complete.
            		completedElement(element, true);
            		addExpectedElement(null, 5893);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 5894, 5897);
            		addExpectedElement(null, 5898, 5903);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyVersionRangeRestriction"
    // Hyvalidityformula.g:904:1: parse_eu_hyvar_feature_expression_HyVersionRangeRestriction returns [eu.hyvar.feature.expression.HyVersionRangeRestriction element = null] : a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Hyvalidityformula.g:907:2: (a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' )
            // Hyvalidityformula.g:908:2: a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']'
            {
            a0=(Token)match(input,34,FOLLOW_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction515); if (state.failed) return element;

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
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_21_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5904, 5905);
            	}

            // Hyvalidityformula.g:932:2: ( (a1= '^' )? )
            // Hyvalidityformula.g:933:3: (a1= '^' )?
            {
            // Hyvalidityformula.g:933:3: (a1= '^' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==37) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Hyvalidityformula.g:934:4: a1= '^'
                    {
                    a1=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction538); if (state.failed) return element;

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
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_21_0_0_1, false, true);
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
            		addExpectedElement(null, 5906);
            	}

            // Hyvalidityformula.g:963:2: (a3= QUOTED_34_34 )
            // Hyvalidityformula.g:964:3: a3= QUOTED_34_34
            {
            a3=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction563); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
            				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionLowerVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_21_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            				copyLocalizationInfos((CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5907);
            	}

            a4=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction584); if (state.failed) return element;

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
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_21_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5908, 5909);
            	}

            // Hyvalidityformula.g:1037:2: ( (a5= '^' )? )
            // Hyvalidityformula.g:1038:3: (a5= '^' )?
            {
            // Hyvalidityformula.g:1038:3: (a5= '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==37) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Hyvalidityformula.g:1039:4: a5= '^'
                    {
                    a5=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction607); if (state.failed) return element;

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
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_21_0_0_4, false, true);
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
            		addExpectedElement(null, 5910);
            	}

            // Hyvalidityformula.g:1068:2: (a7= QUOTED_34_34 )
            // Hyvalidityformula.g:1069:3: a7= QUOTED_34_34
            {
            a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction632); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
            				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionUpperVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_21_0_0_5, proxy, true);
            				copyLocalizationInfos((CommonToken) a7, element);
            				copyLocalizationInfos((CommonToken) a7, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5911);
            	}

            a8=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction653); if (state.failed) return element;

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
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_21_0_0_6, null, true);
            		copyLocalizationInfos((CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		// We've found the last token for this rule. The constructed EObject is now
            		// complete.
            		completedElement(element, true);
            		addExpectedElement(null, 5912);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 5913, 5916);
            		addExpectedElement(null, 5917, 5922);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyVersionRangeRestriction"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnum"
    // Hyvalidityformula.g:1149:1: parse_eu_hyvar_dataValues_HyEnum returns [eu.hyvar.dataValues.HyEnum element = null] : a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Hyvalidityformula.g:1152:2: (a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? )
            // Hyvalidityformula.g:1153:2: a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            {
            a0=(Token)match(input,32,FOLLOW_32_in_parse_eu_hyvar_dataValues_HyEnum682); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5923);
            	}

            // Hyvalidityformula.g:1167:2: (a1= IDENTIFIER_TOKEN )
            // Hyvalidityformula.g:1168:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum700); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5924);
            	}

            a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum721); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 5925);
            		addExpectedElement(null, 5926);
            	}

            // Hyvalidityformula.g:1218:2: ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==33) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Hyvalidityformula.g:1219:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    {
                    // Hyvalidityformula.g:1219:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    // Hyvalidityformula.g:1220:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    {
                    // Hyvalidityformula.g:1220:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    // Hyvalidityformula.g:1221:5: a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum750);
                    a3_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    						retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 5927, 5928);
                    			}

                    // Hyvalidityformula.g:1246:4: ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==19) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Hyvalidityformula.g:1247:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    {
                    	    // Hyvalidityformula.g:1247:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    // Hyvalidityformula.g:1248:6: a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    {
                    	    a4=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum791); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((CommonToken)a4, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 5929);
                    	    					}

                    	    // Hyvalidityformula.g:1262:6: (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    // Hyvalidityformula.g:1263:7: a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum825);
                    	    a5_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    							if (terminateParsing) {
                    	    								throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    								retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_1, a5_0, true);
                    	    								copyLocalizationInfos(a5_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, 5930, 5931);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 5932, 5933);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5934);
            	}

            a6=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum899); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5935);
            	}

            // Hyvalidityformula.g:1316:2: ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==34) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Hyvalidityformula.g:1317:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    {
                    // Hyvalidityformula.g:1317:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    // Hyvalidityformula.g:1318:4: a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']'
                    {
                    a7=(Token)match(input,34,FOLLOW_34_in_parse_eu_hyvar_dataValues_HyEnum922); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a7, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 5936, 5938);
                    			}

                    // Hyvalidityformula.g:1332:4: ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) )
                    int alt8=3;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==DATE) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==20) ) {
                            int LA8_3 = input.LA(3);

                            if ( (LA8_3==DATE) ) {
                                alt8=1;
                            }
                            else if ( (LA8_3==36) ) {
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
                            // Hyvalidityformula.g:1333:5: (a8= DATE ) a9= '-' (a10= DATE )
                            {
                            // Hyvalidityformula.g:1333:5: (a8= DATE )
                            // Hyvalidityformula.g:1334:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum955); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5939);
                            				}

                            a9=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum994); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5940);
                            				}

                            // Hyvalidityformula.g:1383:5: (a10= DATE )
                            // Hyvalidityformula.g:1384:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1024); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a10 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a10, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5941);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyvalidityformula.g:1420:10: (a11= DATE ) a12= '-'
                            {
                            // Hyvalidityformula.g:1420:10: (a11= DATE )
                            // Hyvalidityformula.g:1421:6: a11= DATE
                            {
                            a11=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1080); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a11 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a11, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5942);
                            				}

                            a12=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1119); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5943);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyvalidityformula.g:1471:10: a13= 'eternity' a14= '-' (a15= DATE )
                            {
                            a13=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnum1152); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5944);
                            				}

                            a14=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1175); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a14, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5945);
                            				}

                            // Hyvalidityformula.g:1499:5: (a15= DATE )
                            // Hyvalidityformula.g:1500:6: a15= DATE
                            {
                            a15=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1205); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a15 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a15, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5946);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 5947);
                    			}

                    a16=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_dataValues_HyEnum1257); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
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
            if ( state.backtracking>0 ) { memoize(input, 6, parse_eu_hyvar_dataValues_HyEnum_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnum"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumLiteral"
    // Hyvalidityformula.g:1568:1: parse_eu_hyvar_dataValues_HyEnumLiteral returns [eu.hyvar.dataValues.HyEnumLiteral element = null] : a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Hyvalidityformula.g:1571:2: (a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hyvalidityformula.g:1572:2: a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            a0=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnumLiteral1305); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5948);
            	}

            // Hyvalidityformula.g:1586:2: (a1= IDENTIFIER_TOKEN )
            // Hyvalidityformula.g:1587:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral1323); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5949);
            	}

            a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnumLiteral1344); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5950);
            	}

            // Hyvalidityformula.g:1636:2: (a3= INTEGER_LITERAL )
            // Hyvalidityformula.g:1637:3: a3= INTEGER_LITERAL
            {
            a3=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral1362); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_3, resolved, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5951);
            	}

            a4=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral1383); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5952, 5954);
            	}

            // Hyvalidityformula.g:1686:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==34) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // Hyvalidityformula.g:1687:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hyvalidityformula.g:1687:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hyvalidityformula.g:1688:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,34,FOLLOW_34_in_parse_eu_hyvar_dataValues_HyEnumLiteral1406); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 5955, 5957);
                    			}

                    // Hyvalidityformula.g:1702:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) )
                    int alt10=3;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==DATE) ) {
                        int LA10_1 = input.LA(2);

                        if ( (LA10_1==20) ) {
                            int LA10_3 = input.LA(3);

                            if ( (LA10_3==DATE) ) {
                                alt10=1;
                            }
                            else if ( (LA10_3==39) ) {
                                alt10=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 10, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 10, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA10_0==39) ) {
                        alt10=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;

                    }
                    switch (alt10) {
                        case 1 :
                            // Hyvalidityformula.g:1703:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hyvalidityformula.g:1703:5: (a6= DATE )
                            // Hyvalidityformula.g:1704:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1439); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a6 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a6, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5958);
                            				}

                            a7=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1478); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5959);
                            				}

                            // Hyvalidityformula.g:1753:5: (a8= DATE )
                            // Hyvalidityformula.g:1754:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1508); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5960);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyvalidityformula.g:1790:10: (a9= DATE ) a10= '-' a11= 'eternity'
                            {
                            // Hyvalidityformula.g:1790:10: (a9= DATE )
                            // Hyvalidityformula.g:1791:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1564); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a9 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a9, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5961);
                            				}

                            a10=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1603); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a10, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5962);
                            				}

                            a11=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumLiteral1626); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a11, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5963);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyvalidityformula.g:1855:10: a12= 'eternity' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumLiteral1659); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5964);
                            				}

                            a13=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1682); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5965);
                            				}

                            // Hyvalidityformula.g:1883:5: (a14= DATE )
                            // Hyvalidityformula.g:1884:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1712); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a14 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a14, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 5966);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 5967);
                    			}

                    a15=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_dataValues_HyEnumLiteral1764); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a15, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				// We've found the last token for this rule. The constructed EObject is now
                    				// complete.
                    				completedElement(element, true);
                    				addExpectedElement(null, 5968, 5969);
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
            		addExpectedElement(null, 5970, 5971);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_eu_hyvar_dataValues_HyEnumLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumLiteral"



    // $ANTLR start "parseop_HyValidityFormula_level_15"
    // Hyvalidityformula.g:1954:1: parseop_HyValidityFormula_level_15 returns [eu.hyvar.context.contextValidity.HyValidityFormula element = null] : (c0= parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula |c1= parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula );
    public final eu.hyvar.context.contextValidity.HyValidityFormula parseop_HyValidityFormula_level_15() throws RecognitionException {
        eu.hyvar.context.contextValidity.HyValidityFormula element =  null;

        int parseop_HyValidityFormula_level_15_StartIndex = input.index();

        eu.hyvar.context.contextValidity.HyFeatureValidityFormula c0 =null;

        eu.hyvar.context.contextValidity.HyAttributeValidityFormula c1 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Hyvalidityformula.g:1957:2: (c0= parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula |c1= parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==QUOTED_34_34) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==24) ) {
                    alt12=1;
                }
                else if ( (LA12_1==22) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA12_0==IDENTIFIER_TOKEN) ) {
                int LA12_2 = input.LA(2);

                if ( (LA12_2==24) ) {
                    alt12=1;
                }
                else if ( (LA12_2==22) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // Hyvalidityformula.g:1958:2: c0= parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula_in_parseop_HyValidityFormula_level_151812);
                    c0=parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:1959:4: c1= parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula_in_parseop_HyValidityFormula_level_151822);
                    c1=parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula();

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
            if ( state.backtracking>0 ) { memoize(input, 8, parseop_HyValidityFormula_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyValidityFormula_level_15"



    // $ANTLR start "parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula"
    // Hyvalidityformula.g:1962:1: parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula returns [eu.hyvar.context.contextValidity.HyFeatureValidityFormula element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= ':' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a4= '[' ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) ) a14= ']' ) )? ;
    public final eu.hyvar.context.contextValidity.HyFeatureValidityFormula parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula() throws RecognitionException {
        eu.hyvar.context.contextValidity.HyFeatureValidityFormula element =  null;

        int parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
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
        eu.hyvar.feature.expression.HyExpression a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Hyvalidityformula.g:1965:2: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= ':' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a4= '[' ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) ) a14= ']' ) )? )
            // Hyvalidityformula.g:1966:2: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= ':' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a4= '[' ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) ) a14= ']' ) )?
            {
            // Hyvalidityformula.g:1966:2: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==QUOTED_34_34) ) {
                alt13=1;
            }
            else if ( (LA13_0==IDENTIFIER_TOKEN) ) {
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
                    // Hyvalidityformula.g:1967:3: (a0= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:1967:3: (a0= QUOTED_34_34 )
                    // Hyvalidityformula.g:1968:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1854); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
                    					startIncompleteElement(element);
                    				}
                    				if (a0 != null) {
                    					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__FEATURE), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.context.contextValidity.HyFeatureValidityFormula, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyFeatureValidityFormulaFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__FEATURE), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__FEATURE), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_0_0_0_0, proxy, true);
                    					copyLocalizationInfos((CommonToken) a0, element);
                    					copyLocalizationInfos((CommonToken) a0, proxy);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, 5972);
                    		}

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:2008:6: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:2008:6: (a1= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:2009:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1892); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
                    					startIncompleteElement(element);
                    				}
                    				if (a1 != null) {
                    					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__FEATURE), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.context.contextValidity.HyFeatureValidityFormula, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyFeatureValidityFormulaFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__FEATURE), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__FEATURE), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_0_0_1_0, proxy, true);
                    					copyLocalizationInfos((CommonToken) a1, element);
                    					copyLocalizationInfos((CommonToken) a1, proxy);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, 5973);
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 5974);
            	}

            a2=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1926); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_1, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), 5975, 6429);
            	}

            // Hyvalidityformula.g:2068:2: (a3_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyvalidityformula.g:2069:3: a3_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1944);
            a3_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
            				startIncompleteElement(element);
            			}
            			if (a3_0 != null) {
            				if (a3_0 != null) {
            					Object value = a3_0;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALIDITY_FORMULA), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_2, a3_0, true);
            				copyLocalizationInfos(a3_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 6430);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 6431, 6434);
            	}

            // Hyvalidityformula.g:2095:2: ( (a4= '[' ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) ) a14= ']' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==34) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // Hyvalidityformula.g:2096:3: (a4= '[' ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) ) a14= ']' )
                    {
                    // Hyvalidityformula.g:2096:3: (a4= '[' ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) ) a14= ']' )
                    // Hyvalidityformula.g:2097:4: a4= '[' ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) ) a14= ']'
                    {
                    a4=(Token)match(input,34,FOLLOW_34_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1971); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a4, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 6435, 6437);
                    			}

                    // Hyvalidityformula.g:2111:4: ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) )
                    int alt14=3;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==DATE) ) {
                        int LA14_1 = input.LA(2);

                        if ( (LA14_1==20) ) {
                            int LA14_3 = input.LA(3);

                            if ( (LA14_3==DATE) ) {
                                alt14=1;
                            }
                            else if ( (LA14_3==39) ) {
                                alt14=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA14_0==39) ) {
                        alt14=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;

                    }
                    switch (alt14) {
                        case 1 :
                            // Hyvalidityformula.g:2112:5: (a5= DATE ) a6= '-' (a7= DATE )
                            {
                            // Hyvalidityformula.g:2112:5: (a5= DATE )
                            // Hyvalidityformula.g:2113:6: a5= DATE
                            {
                            a5=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2004); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
                            							startIncompleteElement(element);
                            						}
                            						if (a5 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a5, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6438);
                            				}

                            a6=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2043); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a6, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6439);
                            				}

                            // Hyvalidityformula.g:2162:5: (a7= DATE )
                            // Hyvalidityformula.g:2163:6: a7= DATE
                            {
                            a7=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2073); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
                            							startIncompleteElement(element);
                            						}
                            						if (a7 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a7, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6440);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyvalidityformula.g:2199:10: (a8= DATE ) a9= '-' a10= 'eternity'
                            {
                            // Hyvalidityformula.g:2199:10: (a8= DATE )
                            // Hyvalidityformula.g:2200:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2129); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6441);
                            				}

                            a9=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2168); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6442);
                            				}

                            a10=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2191); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a10, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6443);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyvalidityformula.g:2264:10: a11= 'eternity' a12= '-' (a13= DATE )
                            {
                            a11=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2224); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a11, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6444);
                            				}

                            a12=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2247); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6445);
                            				}

                            // Hyvalidityformula.g:2292:5: (a13= DATE )
                            // Hyvalidityformula.g:2293:6: a13= DATE
                            {
                            a13=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2277); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
                            							startIncompleteElement(element);
                            						}
                            						if (a13 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a13).getLine(), ((CommonToken) a13).getCharPositionInLine(), ((CommonToken) a13).getStartIndex(), ((CommonToken) a13).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a13, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6446);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 6447);
                    			}

                    a14=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2329); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a14, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				// We've found the last token for this rule. The constructed EObject is now
                    				// complete.
                    				completedElement(element, true);
                    				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 6448, 6451);
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
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 6452, 6455);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula"



    // $ANTLR start "parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula"
    // Hyvalidityformula.g:2363:1: parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula returns [eu.hyvar.context.contextValidity.HyAttributeValidityFormula element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) a4= ':' (a5_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a6= '[' ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? ;
    public final eu.hyvar.context.contextValidity.HyAttributeValidityFormula parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula() throws RecognitionException {
        eu.hyvar.context.contextValidity.HyAttributeValidityFormula element =  null;

        int parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
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
        eu.hyvar.feature.expression.HyExpression a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Hyvalidityformula.g:2366:2: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) a4= ':' (a5_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a6= '[' ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? )
            // Hyvalidityformula.g:2367:2: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) a4= ':' (a5_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a6= '[' ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            {
            // Hyvalidityformula.g:2367:2: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==QUOTED_34_34) ) {
                alt16=1;
            }
            else if ( (LA16_0==IDENTIFIER_TOKEN) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }
            switch (alt16) {
                case 1 :
                    // Hyvalidityformula.g:2368:3: (a0= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:2368:3: (a0= QUOTED_34_34 )
                    // Hyvalidityformula.g:2369:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2386); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
                    					startIncompleteElement(element);
                    				}
                    				if (a0 != null) {
                    					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__FEATURE), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.context.contextValidity.HyAttributeValidityFormula, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeValidityFormulaFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__FEATURE), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__FEATURE), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_0_0_0_0, proxy, true);
                    					copyLocalizationInfos((CommonToken) a0, element);
                    					copyLocalizationInfos((CommonToken) a0, proxy);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, 6456);
                    		}

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:2409:6: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:2409:6: (a1= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:2410:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2424); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
                    					startIncompleteElement(element);
                    				}
                    				if (a1 != null) {
                    					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__FEATURE), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.context.contextValidity.HyAttributeValidityFormula, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeValidityFormulaFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__FEATURE), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__FEATURE), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_0_0_1_0, proxy, true);
                    					copyLocalizationInfos((CommonToken) a1, element);
                    					copyLocalizationInfos((CommonToken) a1, proxy);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, 6457);
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 6458);
            	}

            a2=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2458); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_1, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 6459);
            	}

            // Hyvalidityformula.g:2469:2: (a3= IDENTIFIER_TOKEN )
            // Hyvalidityformula.g:2470:3: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2476); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__ATTRIBUTE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyFeatureAttribute proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyNumberAttribute();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.context.contextValidity.HyAttributeValidityFormula, eu.hyvar.feature.HyFeatureAttribute>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeValidityFormulaAttributeReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__ATTRIBUTE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__ATTRIBUTE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            				copyLocalizationInfos((CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 6460);
            	}

            a4=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2497); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), 6461, 6915);
            	}

            // Hyvalidityformula.g:2523:2: (a5_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyvalidityformula.g:2524:3: a5_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2515);
            a5_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
            				startIncompleteElement(element);
            			}
            			if (a5_0 != null) {
            				if (a5_0 != null) {
            					Object value = a5_0;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALIDITY_FORMULA), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_4, a5_0, true);
            				copyLocalizationInfos(a5_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 6916);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 6917, 6920);
            	}

            // Hyvalidityformula.g:2550:2: ( (a6= '[' ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==34) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Hyvalidityformula.g:2551:3: (a6= '[' ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    {
                    // Hyvalidityformula.g:2551:3: (a6= '[' ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    // Hyvalidityformula.g:2552:4: a6= '[' ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']'
                    {
                    a6=(Token)match(input,34,FOLLOW_34_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2542); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a6, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 6921, 6923);
                    			}

                    // Hyvalidityformula.g:2566:4: ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) )
                    int alt17=3;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==DATE) ) {
                        int LA17_1 = input.LA(2);

                        if ( (LA17_1==20) ) {
                            int LA17_3 = input.LA(3);

                            if ( (LA17_3==DATE) ) {
                                alt17=1;
                            }
                            else if ( (LA17_3==39) ) {
                                alt17=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 17, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 17, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA17_0==39) ) {
                        alt17=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;

                    }
                    switch (alt17) {
                        case 1 :
                            // Hyvalidityformula.g:2567:5: (a7= DATE ) a8= '-' (a9= DATE )
                            {
                            // Hyvalidityformula.g:2567:5: (a7= DATE )
                            // Hyvalidityformula.g:2568:6: a7= DATE
                            {
                            a7=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2575); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
                            							startIncompleteElement(element);
                            						}
                            						if (a7 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a7, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6924);
                            				}

                            a8=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2614); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a8, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6925);
                            				}

                            // Hyvalidityformula.g:2617:5: (a9= DATE )
                            // Hyvalidityformula.g:2618:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2644); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
                            							startIncompleteElement(element);
                            						}
                            						if (a9 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a9).getLine(), ((CommonToken) a9).getCharPositionInLine(), ((CommonToken) a9).getStartIndex(), ((CommonToken) a9).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a9, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6926);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyvalidityformula.g:2654:10: (a10= DATE ) a11= '-' a12= 'eternity'
                            {
                            // Hyvalidityformula.g:2654:10: (a10= DATE )
                            // Hyvalidityformula.g:2655:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2700); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
                            							startIncompleteElement(element);
                            						}
                            						if (a10 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a10).getLine(), ((CommonToken) a10).getCharPositionInLine(), ((CommonToken) a10).getStartIndex(), ((CommonToken) a10).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a10, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6927);
                            				}

                            a11=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2739); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a11, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6928);
                            				}

                            a12=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2762); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6929);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyvalidityformula.g:2719:10: a13= 'eternity' a14= '-' (a15= DATE )
                            {
                            a13=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2795); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6930);
                            				}

                            a14=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2818); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a14, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6931);
                            				}

                            // Hyvalidityformula.g:2747:5: (a15= DATE )
                            // Hyvalidityformula.g:2748:6: a15= DATE
                            {
                            a15=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2848); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
                            							startIncompleteElement(element);
                            						}
                            						if (a15 != null) {
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a15.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a15).getLine(), ((CommonToken) a15).getCharPositionInLine(), ((CommonToken) a15).getStartIndex(), ((CommonToken) a15).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a15, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 6932);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 6933);
                    			}

                    a16=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2900); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a16, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				// We've found the last token for this rule. The constructed EObject is now
                    				// complete.
                    				completedElement(element, true);
                    				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 6934, 6937);
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
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 6938, 6941);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula"



    // $ANTLR start "parseop_HyExpression_level_0"
    // Hyvalidityformula.g:2818:1: parseop_HyExpression_level_0 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_0() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_0_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Hyvalidityformula.g:2821:2: (leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) )
            // Hyvalidityformula.g:2822:2: leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02948);
            leftArg=parseop_HyExpression_level_1();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:2822:41: ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==26) ) {
                alt20=1;
            }
            else if ( (LA20_0==EOF||LA20_0==IDENTIFIER_TOKEN||LA20_0==QUOTED_34_34||LA20_0==16||LA20_0==34) ) {
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
                    // Hyvalidityformula.g:2822:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    {
                    // Hyvalidityformula.g:2822:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==26) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // Hyvalidityformula.g:2823:3: () a0= '<->' rightArg= parseop_HyExpression_level_1
                    	    {
                    	    // Hyvalidityformula.g:2823:3: ()
                    	    // Hyvalidityformula.g:2823:4: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,26,FOLLOW_26_in_parseop_HyExpression_level_02968); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    			if (element == null) {
                    	    				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyEquivalenceExpression();
                    	    				startIncompleteElement(element);
                    	    			}
                    	    			collectHiddenTokens(element);
                    	    			retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_0_0_0_1, null, true);
                    	    			copyLocalizationInfos((CommonToken)a0, element);
                    	    		}

                    	    if ( state.backtracking==0 ) {
                    	    			// expected elements (follow set)
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), 6942, 7396);
                    	    		}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02985);
                    	    rightArg=parseop_HyExpression_level_1();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    			if (terminateParsing) {
                    	    				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_0_0_0_0, leftArg, true);
                    	    				copyLocalizationInfos(leftArg, element);
                    	    			}
                    	    		}

                    	    if ( state.backtracking==0 ) {
                    	    			if (terminateParsing) {
                    	    				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_0_0_0_2, rightArg, true);
                    	    				copyLocalizationInfos(rightArg, element);
                    	    			}
                    	    		}

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:2878:21: 
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
            if ( state.backtracking>0 ) { memoize(input, 11, parseop_HyExpression_level_0_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_0"



    // $ANTLR start "parseop_HyExpression_level_1"
    // Hyvalidityformula.g:2883:1: parseop_HyExpression_level_1 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_2 ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_1() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_1_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Hyvalidityformula.g:2886:9: (leftArg= parseop_HyExpression_level_2 ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |) )
            // Hyvalidityformula.g:2887:9: leftArg= parseop_HyExpression_level_2 ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_13031);
            leftArg=parseop_HyExpression_level_2();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:2887:39: ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |)
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==21) ) {
                alt22=1;
            }
            else if ( (LA22_0==EOF||LA22_0==IDENTIFIER_TOKEN||LA22_0==QUOTED_34_34||LA22_0==16||LA22_0==26||LA22_0==34) ) {
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
                    // Hyvalidityformula.g:2887:40: ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+
                    {
                    // Hyvalidityformula.g:2887:40: ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==21) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // Hyvalidityformula.g:2888:2: () a0= '->' rightArg= parseop_HyExpression_level_2
                    	    {
                    	    // Hyvalidityformula.g:2888:2: ()
                    	    // Hyvalidityformula.g:2888:3: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,21,FOLLOW_21_in_parseop_HyExpression_level_13047); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    		if (element == null) {
                    	    			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyImpliesExpression();
                    	    			startIncompleteElement(element);
                    	    		}
                    	    		collectHiddenTokens(element);
                    	    		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_1_0_0_1, null, true);
                    	    		copyLocalizationInfos((CommonToken)a0, element);
                    	    	}

                    	    if ( state.backtracking==0 ) {
                    	    		// expected elements (follow set)
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), 7397, 7851);
                    	    	}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_13061);
                    	    rightArg=parseop_HyExpression_level_2();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    		if (terminateParsing) {
                    	    			throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    			retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_1_0_0_0, leftArg, true);
                    	    			copyLocalizationInfos(leftArg, element);
                    	    		}
                    	    	}

                    	    if ( state.backtracking==0 ) {
                    	    		if (terminateParsing) {
                    	    			throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    			retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_1_0_0_2, rightArg, true);
                    	    			copyLocalizationInfos(rightArg, element);
                    	    		}
                    	    	}

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:2943:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 12, parseop_HyExpression_level_1_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_1"



    // $ANTLR start "parseop_HyExpression_level_2"
    // Hyvalidityformula.g:2948:1: parseop_HyExpression_level_2 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_3 ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_2() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_2_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Hyvalidityformula.g:2951:9: (leftArg= parseop_HyExpression_level_3 ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |) )
            // Hyvalidityformula.g:2952:9: leftArg= parseop_HyExpression_level_3 ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_23102);
            leftArg=parseop_HyExpression_level_3();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:2952:39: ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |)
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==43) ) {
                alt24=1;
            }
            else if ( (LA24_0==EOF||LA24_0==IDENTIFIER_TOKEN||LA24_0==QUOTED_34_34||LA24_0==16||LA24_0==21||LA24_0==26||LA24_0==34) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }
            switch (alt24) {
                case 1 :
                    // Hyvalidityformula.g:2952:40: ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+
                    {
                    // Hyvalidityformula.g:2952:40: ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==43) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // Hyvalidityformula.g:2953:0: () a0= '||' rightArg= parseop_HyExpression_level_3
                    	    {
                    	    // Hyvalidityformula.g:2953:2: ()
                    	    // Hyvalidityformula.g:2953:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,43,FOLLOW_43_in_parseop_HyExpression_level_23115); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    	if (element == null) {
                    	    		element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyOrExpression();
                    	    		startIncompleteElement(element);
                    	    	}
                    	    	collectHiddenTokens(element);
                    	    	retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_2_0_0_1, null, true);
                    	    	copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    	// expected elements (follow set)
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), 7852, 8306);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_23126);
                    	    rightArg=parseop_HyExpression_level_3();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    	if (terminateParsing) {
                    	    		throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_2_0_0_0, leftArg, true);
                    	    		copyLocalizationInfos(leftArg, element);
                    	    	}
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    	if (terminateParsing) {
                    	    		throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_2_0_0_2, rightArg, true);
                    	    		copyLocalizationInfos(rightArg, element);
                    	    	}
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt23 >= 1 ) break loop23;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3008:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 13, parseop_HyExpression_level_2_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_2"



    // $ANTLR start "parseop_HyExpression_level_3"
    // Hyvalidityformula.g:3013:1: parseop_HyExpression_level_3 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_14 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_3() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_3_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Hyvalidityformula.g:3016:9: (leftArg= parseop_HyExpression_level_14 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |) )
            // Hyvalidityformula.g:3017:9: leftArg= parseop_HyExpression_level_14 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_33164);
            leftArg=parseop_HyExpression_level_14();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:3017:40: ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |)
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==14) ) {
                alt26=1;
            }
            else if ( (LA26_0==EOF||LA26_0==IDENTIFIER_TOKEN||LA26_0==QUOTED_34_34||LA26_0==16||LA26_0==21||LA26_0==26||LA26_0==34||LA26_0==43) ) {
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
                    // Hyvalidityformula.g:3017:41: ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+
                    {
                    // Hyvalidityformula.g:3017:41: ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==14) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // Hyvalidityformula.g:3018:0: () a0= '&&' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Hyvalidityformula.g:3018:2: ()
                    	    // Hyvalidityformula.g:3018:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,14,FOLLOW_14_in_parseop_HyExpression_level_33177); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAndExpression();
                    	    	startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_3_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), 8307, 8761);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_33188);
                    	    rightArg=parseop_HyExpression_level_14();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    	throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    	retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_3_0_0_0, leftArg, true);
                    	    	copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    	throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    	retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_3_0_0_2, rightArg, true);
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
                    // Hyvalidityformula.g:3073:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 14, parseop_HyExpression_level_3_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_3"



    // $ANTLR start "parseop_HyExpression_level_14"
    // Hyvalidityformula.g:3078:1: parseop_HyExpression_level_14 returns [eu.hyvar.feature.expression.HyExpression element = null] : (a0= '!' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 );
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_14() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_14_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression arg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Hyvalidityformula.g:3081:0: (a0= '!' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==12) ) {
                alt27=1;
            }
            else if ( (LA27_0==IDENTIFIER_TOKEN||LA27_0==QUOTED_34_34||LA27_0==15||LA27_0==31||(LA27_0 >= 40 && LA27_0 <= 41)) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }
            switch (alt27) {
                case 1 :
                    // Hyvalidityformula.g:3082:0: a0= '!' arg= parseop_HyExpression_level_15
                    {
                    a0=(Token)match(input,12,FOLLOW_12_in_parseop_HyExpression_level_143226); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNotExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_4_0_0_0, null, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    }

                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), 8762, 9216);
                    }

                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143237);
                    arg=parseop_HyExpression_level_15();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_4_0_0_1, arg, true);
                    copyLocalizationInfos(arg, element);
                    }
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3117:5: arg= parseop_HyExpression_level_15
                    {
                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143247);
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
            if ( state.backtracking>0 ) { memoize(input, 15, parseop_HyExpression_level_14_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_14"



    // $ANTLR start "parseop_HyExpression_level_15"
    // Hyvalidityformula.g:3120:1: parseop_HyExpression_level_15 returns [eu.hyvar.feature.expression.HyExpression element = null] : (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyBooleanValueExpression );
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_15() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_15_StartIndex = input.index();

        eu.hyvar.feature.expression.HyNestedExpression c0 =null;

        eu.hyvar.feature.expression.HyFeatureReferenceExpression c1 =null;

        eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression c2 =null;

        eu.hyvar.feature.expression.HyBooleanValueExpression c3 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Hyvalidityformula.g:3123:0: (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyBooleanValueExpression )
            int alt28=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt28=1;
                }
                break;
            case IDENTIFIER_TOKEN:
            case QUOTED_34_34:
                {
                alt28=2;
                }
                break;
            case 31:
                {
                alt28=3;
                }
                break;
            case 40:
            case 41:
                {
                alt28=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }

            switch (alt28) {
                case 1 :
                    // Hyvalidityformula.g:3124:0: c0= parse_eu_hyvar_feature_expression_HyNestedExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_153269);
                    c0=parse_eu_hyvar_feature_expression_HyNestedExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3125:2: c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_153277);
                    c1=parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hyvalidityformula.g:3126:2: c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_153285);
                    c2=parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Hyvalidityformula.g:3127:2: c3= parse_eu_hyvar_feature_expression_HyBooleanValueExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_153293);
                    c3=parse_eu_hyvar_feature_expression_HyBooleanValueExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

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
            if ( state.backtracking>0 ) { memoize(input, 16, parseop_HyExpression_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_15"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyNestedExpression"
    // Hyvalidityformula.g:3130:1: parse_eu_hyvar_feature_expression_HyNestedExpression returns [eu.hyvar.feature.expression.HyNestedExpression element = null] : a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyNestedExpression parse_eu_hyvar_feature_expression_HyNestedExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyNestedExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Hyvalidityformula.g:3133:4: (a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Hyvalidityformula.g:3134:4: a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedExpression3315); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_5_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), 9217, 9671);
            }

            // Hyvalidityformula.g:3148:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyvalidityformula.g:3149:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression3328);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_5_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 9672);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression3340); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_5_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 9673);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 9674, 9677);
            addExpectedElement(null, 9678, 9683);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyNestedExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression"
    // Hyvalidityformula.g:3195:1: parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyFeatureReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? ;
    public final eu.hyvar.feature.expression.HyFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        eu.hyvar.feature.expression.HyVersionRestriction a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Hyvalidityformula.g:3198:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? )
            // Hyvalidityformula.g:3199:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            {
            // Hyvalidityformula.g:3199:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
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
                    // Hyvalidityformula.g:3200:0: (a0= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:3200:4: (a0= QUOTED_34_34 )
                    // Hyvalidityformula.g:3201:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3370); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    	throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    }
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
                    	startIncompleteElement(element);
                    }
                    if (a0 != null) {
                    	eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    	tokenResolver.setOptions(getOptions());
                    	eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    	tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    	Object resolvedObject = result.getResolvedToken();
                    	if (resolvedObject == null) {
                    		addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
                    	}
                    	String resolved = (String) resolvedObject;
                    	eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    	collectHiddenTokens(element);
                    	registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    	if (proxy != null) {
                    		Object value = proxy;
                    		element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    		completedElement(value, false);
                    	}
                    	collectHiddenTokens(element);
                    	retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_6_0_0_0_0_0_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a0, element);
                    	copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 9684, 9685);
                    addExpectedElement(null, 9686);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 9687, 9690);
                    addExpectedElement(null, 9691, 9696);
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3244:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:3244:2: (a1= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:3245:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3387); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    	throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    }
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
                    	startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    	eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    	tokenResolver.setOptions(getOptions());
                    	eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    	tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    	Object resolvedObject = result.getResolvedToken();
                    	if (resolvedObject == null) {
                    		addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    	}
                    	String resolved = (String) resolvedObject;
                    	eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    	collectHiddenTokens(element);
                    	registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    	if (proxy != null) {
                    		Object value = proxy;
                    		element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    		completedElement(value, false);
                    	}
                    	collectHiddenTokens(element);
                    	retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_6_0_0_0_0_1_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a1, element);
                    	copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 9697, 9698);
                    addExpectedElement(null, 9699);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 9700, 9703);
                    addExpectedElement(null, 9704, 9709);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 9710, 9711);
            addExpectedElement(null, 9712);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 9713, 9716);
            addExpectedElement(null, 9717, 9722);
            }

            // Hyvalidityformula.g:3296:0: ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==34) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==QUOTED_34_34||LA30_1==25||(LA30_1 >= 27 && LA30_1 <= 30)||LA30_1==37) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // Hyvalidityformula.g:3297:0: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    {
                    // Hyvalidityformula.g:3297:6: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    // Hyvalidityformula.g:3298:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    {
                    // Hyvalidityformula.g:3298:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    // Hyvalidityformula.g:3299:6: a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3411);
                    a2_0=parse_eu_hyvar_feature_expression_HyVersionRestriction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    	if (terminateParsing) {
                    		throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_6_0_0_1_0_0_0, a2_0, true);
                    		copyLocalizationInfos(a2_0, element);
                    	}
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    // We've found the last token for this rule. The constructed EObject is now
                    // complete.
                    completedElement(element, true);
                    addExpectedElement(null, 9723);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 9724, 9727);
                    addExpectedElement(null, 9728, 9733);
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
            addExpectedElement(null, 9734);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 9735, 9738);
            addExpectedElement(null, 9739, 9744);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression"
    // Hyvalidityformula.g:3343:1: parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element = null] : a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ;
    public final eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyVersionRestriction a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Hyvalidityformula.g:3346:4: (a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
            // Hyvalidityformula.g:3347:4: a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            {
            a0=(Token)match(input,31,FOLLOW_31_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3446); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_7_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 9745, 9746);
            }

            // Hyvalidityformula.g:3361:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==QUOTED_34_34) ) {
                alt31=1;
            }
            else if ( (LA31_0==IDENTIFIER_TOKEN) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }
            switch (alt31) {
                case 1 :
                    // Hyvalidityformula.g:3362:0: (a1= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:3362:4: (a1= QUOTED_34_34 )
                    // Hyvalidityformula.g:3363:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3461); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    	throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    }
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
                    	startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    	eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    	tokenResolver.setOptions(getOptions());
                    	eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    	tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    	Object resolvedObject = result.getResolvedToken();
                    	if (resolvedObject == null) {
                    		addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    	}
                    	String resolved = (String) resolvedObject;
                    	eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    	collectHiddenTokens(element);
                    	registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    	if (proxy != null) {
                    		Object value = proxy;
                    		element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    		completedElement(value, false);
                    	}
                    	collectHiddenTokens(element);
                    	retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_0_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a1, element);
                    	copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 9747, 9748);
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3403:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:3403:2: (a2= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:3404:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3478); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    	throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    }
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
                    	startIncompleteElement(element);
                    }
                    if (a2 != null) {
                    	eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    	tokenResolver.setOptions(getOptions());
                    	eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    	tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    	Object resolvedObject = result.getResolvedToken();
                    	if (resolvedObject == null) {
                    		addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                    	}
                    	String resolved = (String) resolvedObject;
                    	eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    	collectHiddenTokens(element);
                    	registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    	if (proxy != null) {
                    		Object value = proxy;
                    		element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    		completedElement(value, false);
                    	}
                    	collectHiddenTokens(element);
                    	retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_1_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a2, element);
                    	copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 9749, 9750);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 9751, 9752);
            }

            // Hyvalidityformula.g:3449:6: (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            // Hyvalidityformula.g:3450:6: a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3498);
            a3_0=parse_eu_hyvar_feature_expression_HyVersionRestriction();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_7_0_0_2, a3_0, true);
            copyLocalizationInfos(a3_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 9753);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 9754, 9757);
            addExpectedElement(null, 9758, 9763);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"
    // Hyvalidityformula.g:3482:1: parse_eu_hyvar_feature_expression_HyBooleanValueExpression returns [eu.hyvar.feature.expression.HyBooleanValueExpression element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.feature.expression.HyBooleanValueExpression parse_eu_hyvar_feature_expression_HyBooleanValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyBooleanValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Hyvalidityformula.g:3485:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hyvalidityformula.g:3486:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hyvalidityformula.g:3486:0: ( (a0= 'true' |a1= 'false' ) )
            // Hyvalidityformula.g:3487:0: (a0= 'true' |a1= 'false' )
            {
            // Hyvalidityformula.g:3487:0: (a0= 'true' |a1= 'false' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==41) ) {
                alt32=1;
            }
            else if ( (LA32_0==40) ) {
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
                    // Hyvalidityformula.g:3488:0: a0= 'true'
                    {
                    a0=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3529); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_8_0_0_0, true, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    // set value of boolean attribute
                    Object value = true;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3501:2: a1= 'false'
                    {
                    a1=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3538); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_8_0_0_0, false, true);
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
            addExpectedElement(null, 9764);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), 9765, 9768);
            addExpectedElement(null, 9769, 9774);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_4"
    // Hyvalidityformula.g:3528:1: parseop_HyArithmeticalValueExpression_level_4 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_5 ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_4() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_4_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Hyvalidityformula.g:3531:9: (leftArg= parseop_HyArithmeticalValueExpression_level_5 ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |) )
            // Hyvalidityformula.g:3532:9: leftArg= parseop_HyArithmeticalValueExpression_level_5 ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_43568);
            leftArg=parseop_HyArithmeticalValueExpression_level_5();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:3532:56: ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |)
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==35) ) {
                alt34=1;
            }
            else if ( (LA34_0==13||LA34_0==16||LA34_0==25||(LA34_0 >= 27 && LA34_0 <= 30)||LA34_0==44) ) {
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
                    // Hyvalidityformula.g:3532:57: ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+
                    {
                    // Hyvalidityformula.g:3532:57: ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==35) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // Hyvalidityformula.g:3533:0: () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5
                    	    {
                    	    // Hyvalidityformula.g:3533:2: ()
                    	    // Hyvalidityformula.g:3533:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,35,FOLLOW_35_in_parseop_HyArithmeticalValueExpression_level_43581); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyModuloExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_12_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), 9775, 12708);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_43592);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_5();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_12_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_12_0_0_2, rightArg, true);
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
                    // Hyvalidityformula.g:3588:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 21, parseop_HyArithmeticalValueExpression_level_4_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_4"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_5"
    // Hyvalidityformula.g:3593:1: parseop_HyArithmeticalValueExpression_level_5 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_6 ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_5() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_5_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Hyvalidityformula.g:3596:9: (leftArg= parseop_HyArithmeticalValueExpression_level_6 ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |) )
            // Hyvalidityformula.g:3597:9: leftArg= parseop_HyArithmeticalValueExpression_level_6 ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_53630);
            leftArg=parseop_HyArithmeticalValueExpression_level_6();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:3597:56: ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |)
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==18) ) {
                alt36=1;
            }
            else if ( (LA36_0==EOF||LA36_0==13||LA36_0==16||LA36_0==25||(LA36_0 >= 27 && LA36_0 <= 30)||LA36_0==35||LA36_0==44) ) {
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
                    // Hyvalidityformula.g:3597:57: ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+
                    {
                    // Hyvalidityformula.g:3597:57: ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+
                    int cnt35=0;
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==18) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // Hyvalidityformula.g:3598:0: () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6
                    	    {
                    	    // Hyvalidityformula.g:3598:2: ()
                    	    // Hyvalidityformula.g:3598:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,18,FOLLOW_18_in_parseop_HyArithmeticalValueExpression_level_53643); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAdditionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_10_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), 12709, 15642);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_53654);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_6();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_10_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_10_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt35 >= 1 ) break loop35;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(35, input);
                                throw eee;
                        }
                        cnt35++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3653:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 22, parseop_HyArithmeticalValueExpression_level_5_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_5"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_6"
    // Hyvalidityformula.g:3658:1: parseop_HyArithmeticalValueExpression_level_6 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_7 ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_6() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_6_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Hyvalidityformula.g:3661:9: (leftArg= parseop_HyArithmeticalValueExpression_level_7 ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |) )
            // Hyvalidityformula.g:3662:9: leftArg= parseop_HyArithmeticalValueExpression_level_7 ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_63692);
            leftArg=parseop_HyArithmeticalValueExpression_level_7();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:3662:56: ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |)
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==20) ) {
                alt38=1;
            }
            else if ( (LA38_0==EOF||LA38_0==13||LA38_0==16||LA38_0==18||LA38_0==25||(LA38_0 >= 27 && LA38_0 <= 30)||LA38_0==35||LA38_0==44) ) {
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
                    // Hyvalidityformula.g:3662:57: ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+
                    {
                    // Hyvalidityformula.g:3662:57: ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+
                    int cnt37=0;
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==20) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // Hyvalidityformula.g:3663:0: () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7
                    	    {
                    	    // Hyvalidityformula.g:3663:2: ()
                    	    // Hyvalidityformula.g:3663:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,20,FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_63705); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHySubtractionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_11_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), 15643, 18576);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_63716);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_7();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_11_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_11_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt37 >= 1 ) break loop37;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(37, input);
                                throw eee;
                        }
                        cnt37++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3718:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 23, parseop_HyArithmeticalValueExpression_level_6_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_6"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_7"
    // Hyvalidityformula.g:3723:1: parseop_HyArithmeticalValueExpression_level_7 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_8 ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_7() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_7_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Hyvalidityformula.g:3726:9: (leftArg= parseop_HyArithmeticalValueExpression_level_8 ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |) )
            // Hyvalidityformula.g:3727:9: leftArg= parseop_HyArithmeticalValueExpression_level_8 ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73754);
            leftArg=parseop_HyArithmeticalValueExpression_level_8();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:3727:56: ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |)
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==17) ) {
                alt40=1;
            }
            else if ( (LA40_0==EOF||LA40_0==13||LA40_0==16||LA40_0==18||LA40_0==20||LA40_0==25||(LA40_0 >= 27 && LA40_0 <= 30)||LA40_0==35||LA40_0==44) ) {
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
                    // Hyvalidityformula.g:3727:57: ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+
                    {
                    // Hyvalidityformula.g:3727:57: ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+
                    int cnt39=0;
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==17) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // Hyvalidityformula.g:3728:0: () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8
                    	    {
                    	    // Hyvalidityformula.g:3728:2: ()
                    	    // Hyvalidityformula.g:3728:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,17,FOLLOW_17_in_parseop_HyArithmeticalValueExpression_level_73767); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMultiplicationExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_13_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), 18577, 21510);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73778);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_8();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_13_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_13_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt39 >= 1 ) break loop39;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(39, input);
                                throw eee;
                        }
                        cnt39++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3783:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 24, parseop_HyArithmeticalValueExpression_level_7_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_7"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_8"
    // Hyvalidityformula.g:3788:1: parseop_HyArithmeticalValueExpression_level_8 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_11 ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_8() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_8_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }

            // Hyvalidityformula.g:3791:9: (leftArg= parseop_HyArithmeticalValueExpression_level_11 ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |) )
            // Hyvalidityformula.g:3792:9: leftArg= parseop_HyArithmeticalValueExpression_level_11 ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83816);
            leftArg=parseop_HyArithmeticalValueExpression_level_11();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:3792:57: ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |)
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==23) ) {
                alt42=1;
            }
            else if ( (LA42_0==EOF||LA42_0==13||(LA42_0 >= 16 && LA42_0 <= 18)||LA42_0==20||LA42_0==25||(LA42_0 >= 27 && LA42_0 <= 30)||LA42_0==35||LA42_0==44) ) {
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
                    // Hyvalidityformula.g:3792:58: ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+
                    {
                    // Hyvalidityformula.g:3792:58: ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+
                    int cnt41=0;
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==23) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // Hyvalidityformula.g:3793:0: () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11
                    	    {
                    	    // Hyvalidityformula.g:3793:2: ()
                    	    // Hyvalidityformula.g:3793:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,23,FOLLOW_23_in_parseop_HyArithmeticalValueExpression_level_83829); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyDivisionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_14_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), 21511, 24444);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83840);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_11();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_14_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_14_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt41 >= 1 ) break loop41;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(41, input);
                                throw eee;
                        }
                        cnt41++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3848:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 25, parseop_HyArithmeticalValueExpression_level_8_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_8"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_11"
    // Hyvalidityformula.g:3853:1: parseop_HyArithmeticalValueExpression_level_11 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c0= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_11() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_11_StartIndex = input.index();

        eu.hyvar.feature.expression.HyAttributeReferenceExpression c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Hyvalidityformula.g:3856:4: (c0= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression )
            // Hyvalidityformula.g:3857:4: c0= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_113878);
            c0=parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression();

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
            if ( state.backtracking>0 ) { memoize(input, 26, parseop_HyArithmeticalValueExpression_level_11_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_11"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression"
    // Hyvalidityformula.g:3860:1: parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression returns [eu.hyvar.feature.expression.HyAttributeReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) ;
    public final eu.hyvar.feature.expression.HyAttributeReferenceExpression parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyAttributeReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Hyvalidityformula.g:3863:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) )
            // Hyvalidityformula.g:3864:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN )
            {
            // Hyvalidityformula.g:3864:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==QUOTED_34_34) ) {
                alt43=1;
            }
            else if ( (LA43_0==IDENTIFIER_TOKEN) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }
            switch (alt43) {
                case 1 :
                    // Hyvalidityformula.g:3865:0: (a0= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:3865:4: (a0= QUOTED_34_34 )
                    // Hyvalidityformula.g:3866:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3904); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a0 != null) {
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_17_0_0_0_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a0, element);
                    copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 24445);
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3906:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:3906:2: (a1= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:3907:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3921); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_17_0_0_0_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 24446);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 24447);
            }

            a2=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3939); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_17_0_0_1, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 24448);
            }

            // Hyvalidityformula.g:3966:4: (a3= IDENTIFIER_TOKEN )
            // Hyvalidityformula.g:3967:4: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3952); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
            startIncompleteElement(element);
            }
            if (a3 != null) {
            eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            tokenResolver.setOptions(getOptions());
            eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
            tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), result);
            Object resolvedObject = result.getResolvedToken();
            if (resolvedObject == null) {
            addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            }
            String resolved = (String) resolvedObject;
            eu.hyvar.feature.HyFeatureAttribute proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyNumberAttribute();
            collectHiddenTokens(element);
            registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeatureAttribute>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionAttributeReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), resolved, proxy);
            if (proxy != null) {
            Object value = proxy;
            element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), value);
            completedElement(value, false);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_17_0_0_2, proxy, true);
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
            addExpectedElement(null, 24449, 24455);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_12"
    // Hyvalidityformula.g:4011:1: parseop_HyArithmeticalValueExpression_level_12 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c0= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_12() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_12_StartIndex = input.index();

        eu.hyvar.feature.expression.HyContextInformationReferenceExpression c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Hyvalidityformula.g:4014:4: (c0= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression )
            // Hyvalidityformula.g:4015:4: c0= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_123980);
            c0=parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression();

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
            if ( state.backtracking>0 ) { memoize(input, 28, parseop_HyArithmeticalValueExpression_level_12_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_12"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"
    // Hyvalidityformula.g:4018:1: parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression returns [eu.hyvar.feature.expression.HyContextInformationReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ;
    public final eu.hyvar.feature.expression.HyContextInformationReferenceExpression parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyContextInformationReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Hyvalidityformula.g:4021:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) )
            // Hyvalidityformula.g:4022:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            {
            // Hyvalidityformula.g:4022:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==QUOTED_34_34) ) {
                alt44=1;
            }
            else if ( (LA44_0==IDENTIFIER_TOKEN) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }
            switch (alt44) {
                case 1 :
                    // Hyvalidityformula.g:4023:0: (a0= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:4023:4: (a0= QUOTED_34_34 )
                    // Hyvalidityformula.g:4024:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression4006); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a0 != null) {
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.context.HyContextualInformation proxy = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextInformationReferenceExpressionContextInformationReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_18_0_0_0_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a0, element);
                    copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 24456, 24462);
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:4064:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:4064:2: (a1= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:4065:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression4023); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.context.HyContextualInformation proxy = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextInformationReferenceExpressionContextInformationReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_18_0_0_0_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    // We've found the last token for this rule. The constructed EObject is now
                    // complete.
                    completedElement(element, true);
                    addExpectedElement(null, 24463, 24469);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 24470, 24476);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 29, parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_13"
    // Hyvalidityformula.g:4118:1: parseop_HyArithmeticalValueExpression_level_13 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c0= parse_eu_hyvar_feature_expression_HyValueExpression ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_13() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_13_StartIndex = input.index();

        eu.hyvar.feature.expression.HyValueExpression c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Hyvalidityformula.g:4121:4: (c0= parse_eu_hyvar_feature_expression_HyValueExpression )
            // Hyvalidityformula.g:4122:4: c0= parse_eu_hyvar_feature_expression_HyValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyArithmeticalValueExpression_level_134056);
            c0=parse_eu_hyvar_feature_expression_HyValueExpression();

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
            if ( state.backtracking>0 ) { memoize(input, 30, parseop_HyArithmeticalValueExpression_level_13_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_13"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyValueExpression"
    // Hyvalidityformula.g:4125:1: parse_eu_hyvar_feature_expression_HyValueExpression returns [eu.hyvar.feature.expression.HyValueExpression element = null] : (a0_0= parse_eu_hyvar_dataValues_HyValue ) ;
    public final eu.hyvar.feature.expression.HyValueExpression parse_eu_hyvar_feature_expression_HyValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }

            // Hyvalidityformula.g:4128:6: ( (a0_0= parse_eu_hyvar_dataValues_HyValue ) )
            // Hyvalidityformula.g:4129:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            {
            // Hyvalidityformula.g:4129:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            // Hyvalidityformula.g:4130:6: a0_0= parse_eu_hyvar_dataValues_HyValue
            {
            pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression4080);
            a0_0=parse_eu_hyvar_dataValues_HyValue();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_19_0_0_0, a0_0, true);
            copyLocalizationInfos(a0_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 24477, 24483);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 31, parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyValueExpression"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_14"
    // Hyvalidityformula.g:4160:1: parseop_HyArithmeticalValueExpression_level_14 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : (a0= '-' arg= parseop_HyArithmeticalValueExpression_level_15 |arg= parseop_HyArithmeticalValueExpression_level_15 );
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_14() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_14_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression arg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return element; }

            // Hyvalidityformula.g:4163:0: (a0= '-' arg= parseop_HyArithmeticalValueExpression_level_15 |arg= parseop_HyArithmeticalValueExpression_level_15 )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==20) ) {
                alt45=1;
            }
            else if ( (LA45_0==15) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }
            switch (alt45) {
                case 1 :
                    // Hyvalidityformula.g:4164:0: a0= '-' arg= parseop_HyArithmeticalValueExpression_level_15
                    {
                    a0=(Token)match(input,20,FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_144107); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNegationExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_15_0_0_0, null, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    }

                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), 24484, 27417);
                    }

                    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_144118);
                    arg=parseop_HyArithmeticalValueExpression_level_15();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_15_0_0_1, arg, true);
                    copyLocalizationInfos(arg, element);
                    }
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:4199:5: arg= parseop_HyArithmeticalValueExpression_level_15
                    {
                    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_144128);
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
            if ( state.backtracking>0 ) { memoize(input, 32, parseop_HyArithmeticalValueExpression_level_14_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_14"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_15"
    // Hyvalidityformula.g:4202:1: parseop_HyArithmeticalValueExpression_level_15 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c0= parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_15() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_15_StartIndex = input.index();

        eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return element; }

            // Hyvalidityformula.g:4205:4: (c0= parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression )
            // Hyvalidityformula.g:4206:4: c0= parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_in_parseop_HyArithmeticalValueExpression_level_154150);
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
            if ( state.backtracking>0 ) { memoize(input, 33, parseop_HyArithmeticalValueExpression_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_15"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression"
    // Hyvalidityformula.g:4209:1: parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression returns [eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression element = null] : a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return element; }

            // Hyvalidityformula.g:4212:4: (a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a2= ')' )
            // Hyvalidityformula.g:4213:4: a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a2= ')'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression4172); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedArithmeticalValueExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_16_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedArithmeticalValueExpression(), 27418, 30351);
            }

            // Hyvalidityformula.g:4227:6: (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression )
            // Hyvalidityformula.g:4228:6: a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression4185);
            a1_0=parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_16_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 30352);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression4197); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedArithmeticalValueExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_16_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 30353, 30359);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 34, parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression"



    // $ANTLR start "parseop_HyValue_level_15"
    // Hyvalidityformula.g:4272:1: parseop_HyValue_level_15 returns [eu.hyvar.dataValues.HyValue element = null] : (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue );
    public final eu.hyvar.dataValues.HyValue parseop_HyValue_level_15() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parseop_HyValue_level_15_StartIndex = input.index();

        eu.hyvar.dataValues.HyNumberValue c0 =null;

        eu.hyvar.dataValues.HyBooleanValue c1 =null;

        eu.hyvar.dataValues.HyEnumValue c2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return element; }

            // Hyvalidityformula.g:4275:0: (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue )
            int alt46=3;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
                {
                alt46=1;
                }
                break;
            case 40:
            case 41:
                {
                alt46=2;
                }
                break;
            case 38:
                {
                alt46=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }

            switch (alt46) {
                case 1 :
                    // Hyvalidityformula.g:4276:0: c0= parse_eu_hyvar_dataValues_HyNumberValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_154223);
                    c0=parse_eu_hyvar_dataValues_HyNumberValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:4277:2: c1= parse_eu_hyvar_dataValues_HyBooleanValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_154231);
                    c1=parse_eu_hyvar_dataValues_HyBooleanValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hyvalidityformula.g:4278:2: c2= parse_eu_hyvar_dataValues_HyEnumValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_154239);
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
            if ( state.backtracking>0 ) { memoize(input, 35, parseop_HyValue_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyValue_level_15"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyNumberValue"
    // Hyvalidityformula.g:4281:1: parse_eu_hyvar_dataValues_HyNumberValue returns [eu.hyvar.dataValues.HyNumberValue element = null] : (a0= INTEGER_LITERAL ) ;
    public final eu.hyvar.dataValues.HyNumberValue parse_eu_hyvar_dataValues_HyNumberValue() throws RecognitionException {
        eu.hyvar.dataValues.HyNumberValue element =  null;

        int parse_eu_hyvar_dataValues_HyNumberValue_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return element; }

            // Hyvalidityformula.g:4284:4: ( (a0= INTEGER_LITERAL ) )
            // Hyvalidityformula.g:4285:4: (a0= INTEGER_LITERAL )
            {
            // Hyvalidityformula.g:4285:4: (a0= INTEGER_LITERAL )
            // Hyvalidityformula.g:4286:4: a0= INTEGER_LITERAL
            {
            a0=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue4263); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyNumberValue();
            startIncompleteElement(element);
            }
            if (a0 != null) {
            eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            tokenResolver.setOptions(getOptions());
            eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_0_0_0_0, resolved, true);
            copyLocalizationInfos((CommonToken) a0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 30360, 30366);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 36, parse_eu_hyvar_dataValues_HyNumberValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyNumberValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyBooleanValue"
    // Hyvalidityformula.g:4326:1: parse_eu_hyvar_dataValues_HyBooleanValue returns [eu.hyvar.dataValues.HyBooleanValue element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.dataValues.HyBooleanValue parse_eu_hyvar_dataValues_HyBooleanValue() throws RecognitionException {
        eu.hyvar.dataValues.HyBooleanValue element =  null;

        int parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return element; }

            // Hyvalidityformula.g:4329:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hyvalidityformula.g:4330:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hyvalidityformula.g:4330:0: ( (a0= 'true' |a1= 'false' ) )
            // Hyvalidityformula.g:4331:0: (a0= 'true' |a1= 'false' )
            {
            // Hyvalidityformula.g:4331:0: (a0= 'true' |a1= 'false' )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==41) ) {
                alt47=1;
            }
            else if ( (LA47_0==40) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }
            switch (alt47) {
                case 1 :
                    // Hyvalidityformula.g:4332:0: a0= 'true'
                    {
                    a0=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_dataValues_HyBooleanValue4295); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_1_0_0_0, true, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    // set value of boolean attribute
                    Object value = true;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:4345:2: a1= 'false'
                    {
                    a1=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_dataValues_HyBooleanValue4304); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_1_0_0_0, false, true);
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
            addExpectedElement(null, 30367, 30373);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 37, parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyBooleanValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumValue"
    // Hyvalidityformula.g:4370:1: parse_eu_hyvar_dataValues_HyEnumValue returns [eu.hyvar.dataValues.HyEnumValue element = null] : a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return element; }

            // Hyvalidityformula.g:4373:4: (a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) ) )
            // Hyvalidityformula.g:4374:4: a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnumValue4334); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 30374, 30375);
            }

            // Hyvalidityformula.g:4388:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==QUOTED_34_34) ) {
                alt48=1;
            }
            else if ( (LA48_0==IDENTIFIER_TOKEN) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;

            }
            switch (alt48) {
                case 1 :
                    // Hyvalidityformula.g:4389:0: (a1= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:4389:4: (a1= QUOTED_34_34 )
                    // Hyvalidityformula.g:4390:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue4349); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 30376);
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:4430:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:4430:2: (a2= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:4431:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue4366); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a2 != null) {
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a2, element);
                    copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 30377);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 30378);
            }

            a3=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue4384); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a3, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 30379, 30380);
            }

            // Hyvalidityformula.g:4490:0: ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==QUOTED_34_34) ) {
                alt49=1;
            }
            else if ( (LA49_0==IDENTIFIER_TOKEN) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }
            switch (alt49) {
                case 1 :
                    // Hyvalidityformula.g:4491:0: (a4= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:4491:4: (a4= QUOTED_34_34 )
                    // Hyvalidityformula.g:4492:4: a4= QUOTED_34_34
                    {
                    a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue4399); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a4 != null) {
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a4, element);
                    copyLocalizationInfos((CommonToken) a4, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 30381, 30387);
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:4532:2: (a5= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:4532:2: (a5= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:4533:4: a5= IDENTIFIER_TOKEN
                    {
                    a5=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue4416); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a5 != null) {
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_1_0, proxy, true);
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
                    addExpectedElement(null, 30388, 30394);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 30395, 30401);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 38, parse_eu_hyvar_dataValues_HyEnumValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumValue"



    // $ANTLR start "parse_eu_hyvar_context_contextValidity_HyValidityFormula"
    // Hyvalidityformula.g:4586:1: parse_eu_hyvar_context_contextValidity_HyValidityFormula returns [eu.hyvar.context.contextValidity.HyValidityFormula element = null] : c= parseop_HyValidityFormula_level_15 ;
    public final eu.hyvar.context.contextValidity.HyValidityFormula parse_eu_hyvar_context_contextValidity_HyValidityFormula() throws RecognitionException {
        eu.hyvar.context.contextValidity.HyValidityFormula element =  null;

        int parse_eu_hyvar_context_contextValidity_HyValidityFormula_StartIndex = input.index();

        eu.hyvar.context.contextValidity.HyValidityFormula c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return element; }

            // Hyvalidityformula.g:4587:3: (c= parseop_HyValidityFormula_level_15 )
            // Hyvalidityformula.g:4588:3: c= parseop_HyValidityFormula_level_15
            {
            pushFollow(FOLLOW_parseop_HyValidityFormula_level_15_in_parse_eu_hyvar_context_contextValidity_HyValidityFormula4445);
            c=parseop_HyValidityFormula_level_15();

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
            if ( state.backtracking>0 ) { memoize(input, 39, parse_eu_hyvar_context_contextValidity_HyValidityFormula_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_context_contextValidity_HyValidityFormula"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression"
    // Hyvalidityformula.g:4592:1: parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c= parseop_HyArithmeticalValueExpression_level_4 ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_StartIndex = input.index();

        eu.hyvar.feature.expression.HyArithmeticalValueExpression c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return element; }

            // Hyvalidityformula.g:4593:3: (c= parseop_HyArithmeticalValueExpression_level_4 )
            // Hyvalidityformula.g:4594:3: c= parseop_HyArithmeticalValueExpression_level_4
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_4_in_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression4464);
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
            if ( state.backtracking>0 ) { memoize(input, 40, parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyExpression"
    // Hyvalidityformula.g:4598:1: parse_eu_hyvar_feature_expression_HyExpression returns [eu.hyvar.feature.expression.HyExpression element = null] : c= parseop_HyExpression_level_0 ;
    public final eu.hyvar.feature.expression.HyExpression parse_eu_hyvar_feature_expression_HyExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyExpression_StartIndex = input.index();

        eu.hyvar.feature.expression.HyExpression c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return element; }

            // Hyvalidityformula.g:4599:3: (c= parseop_HyExpression_level_0 )
            // Hyvalidityformula.g:4600:3: c= parseop_HyExpression_level_0
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression4483);
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
            if ( state.backtracking>0 ) { memoize(input, 41, parse_eu_hyvar_feature_expression_HyExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyVersionRestriction"
    // Hyvalidityformula.g:4604:1: parse_eu_hyvar_feature_expression_HyVersionRestriction returns [eu.hyvar.feature.expression.HyVersionRestriction element = null] : (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction );
    public final eu.hyvar.feature.expression.HyVersionRestriction parse_eu_hyvar_feature_expression_HyVersionRestriction() throws RecognitionException {
        eu.hyvar.feature.expression.HyVersionRestriction element =  null;

        int parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex = input.index();

        eu.hyvar.feature.expression.HyRelativeVersionRestriction c0 =null;

        eu.hyvar.feature.expression.HyVersionRangeRestriction c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return element; }

            // Hyvalidityformula.g:4605:0: (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==34) ) {
                switch ( input.LA(2) ) {
                case 25:
                case 27:
                case 28:
                case 29:
                case 30:
                    {
                    alt50=1;
                    }
                    break;
                case QUOTED_34_34:
                    {
                    int LA50_3 = input.LA(3);

                    if ( (LA50_3==36) ) {
                        alt50=1;
                    }
                    else if ( (LA50_3==20) ) {
                        alt50=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 50, 3, input);

                        throw nvae;

                    }
                    }
                    break;
                case 37:
                    {
                    alt50=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }
            switch (alt50) {
                case 1 :
                    // Hyvalidityformula.g:4606:0: c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction4502);
                    c0=parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:4607:2: c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction4510);
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
            if ( state.backtracking>0 ) { memoize(input, 42, parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyVersionRestriction"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyValue"
    // Hyvalidityformula.g:4611:1: parse_eu_hyvar_dataValues_HyValue returns [eu.hyvar.dataValues.HyValue element = null] : c= parseop_HyValue_level_15 ;
    public final eu.hyvar.dataValues.HyValue parse_eu_hyvar_dataValues_HyValue() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parse_eu_hyvar_dataValues_HyValue_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return element; }

            // Hyvalidityformula.g:4612:3: (c= parseop_HyValue_level_15 )
            // Hyvalidityformula.g:4613:3: c= parseop_HyValue_level_15
            {
            pushFollow(FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue4529);
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
            if ( state.backtracking>0 ) { memoize(input, 43, parse_eu_hyvar_dataValues_HyValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_eu_hyvar_context_contextValidity_HyValidityModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_context_contextValidity_HyValidityFormula_in_parse_eu_hyvar_context_contextValidity_HyValidityModel124 = new BitSet(new long[]{0x0000000000000222L});
    public static final BitSet FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression165 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression183 = new BitSet(new long[]{0x000000007A002000L});
    public static final BitSet FOLLOW_25_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression210 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression225 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression240 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression255 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression270 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression285 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression310 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction357 = new BitSet(new long[]{0x000000007A000200L});
    public static final BitSet FOLLOW_25_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction380 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction395 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction410 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction425 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction440 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction465 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction515 = new BitSet(new long[]{0x0000002000000200L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction538 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction563 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction584 = new BitSet(new long[]{0x0000002000000200L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction607 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction632 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_parse_eu_hyvar_dataValues_HyEnum682 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum700 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum721 = new BitSet(new long[]{0x0000000200010000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum750 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum791 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum825 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum899 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parse_eu_hyvar_dataValues_HyEnum922 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum955 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum994 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1024 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1080 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1119 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnum1152 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1175 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1205 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_dataValues_HyEnum1257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnumLiteral1305 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral1323 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnumLiteral1344 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral1362 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral1383 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parse_eu_hyvar_dataValues_HyEnumLiteral1406 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1439 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1478 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1508 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1564 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1603 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumLiteral1626 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumLiteral1659 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1682 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1712 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_dataValues_HyEnumLiteral1764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula_in_parseop_HyValidityFormula_level_151812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula_in_parseop_HyValidityFormula_level_151822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1854 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1892 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1926 = new BitSet(new long[]{0x0000030080009220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1944 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1971 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2004 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2043 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2073 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2129 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2168 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2191 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2224 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2247 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2277 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2386 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2424 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2458 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2476 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2497 = new BitSet(new long[]{0x0000030080009220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2515 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2542 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2575 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2614 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2644 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2700 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2739 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2762 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2795 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2818 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2848 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02948 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_parseop_HyExpression_level_02968 = new BitSet(new long[]{0x0000030080009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02985 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_13031 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_parseop_HyExpression_level_13047 = new BitSet(new long[]{0x0000030080009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_13061 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_23102 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_parseop_HyExpression_level_23115 = new BitSet(new long[]{0x0000030080009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_23126 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_33164 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_parseop_HyExpression_level_33177 = new BitSet(new long[]{0x0000030080009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_33188 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_12_in_parseop_HyExpression_level_143226 = new BitSet(new long[]{0x0000030080008220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_153269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_153277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_153285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_153293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedExpression3315 = new BitSet(new long[]{0x0000030080009220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression3328 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression3340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3370 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3387 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3446 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3461 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3478 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_43568 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_parseop_HyArithmeticalValueExpression_level_43581 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_43592 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_53630 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_parseop_HyArithmeticalValueExpression_level_53643 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_53654 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_63692 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_63705 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_63716 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73754 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_parseop_HyArithmeticalValueExpression_level_73767 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73778 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83816 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_parseop_HyArithmeticalValueExpression_level_83829 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83840 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_113878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3904 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3921 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3939 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_123980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression4006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression4023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyArithmeticalValueExpression_level_134056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression4080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_144107 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_144118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_144128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_in_parseop_HyArithmeticalValueExpression_level_154150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression4172 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression4185 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression4197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_154223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_154231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_154239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue4263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_dataValues_HyBooleanValue4295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_dataValues_HyBooleanValue4304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnumValue4334 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue4349 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue4366 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue4384 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue4399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue4416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyValidityFormula_level_15_in_parse_eu_hyvar_context_contextValidity_HyValidityFormula4445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_4_in_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression4464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression4483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction4502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction4510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue4529 = new BitSet(new long[]{0x0000000000000002L});

}