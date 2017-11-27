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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DATE", "IDENTIFIER_TOKEN", "INTEGER_LITERAL", "LINEBREAK", "ML_COMMENT", "QUOTED_34_34", "SL_COMMENT", "WHITESPACE", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'->'", "'.'", "'/'", "':'", "'<'", "'<->'", "'<='", "'='", "'>'", "'>='", "'?'", "'Enum('", "'EnumLiteral('", "'['", "'\\u0025'", "']'", "'^'", "'context:'", "'enum:'", "'eternity'", "'false'", "'ifPossible('", "'max('", "'min('", "'true'", "'||'"
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
    public static final int T__46=46;
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
        this.state.initializeRuleMemo(107 + 1);
         

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
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
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
    		int followSetID = 153;
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
    // Hyvalidityformula.g:493:1: start returns [ EObject element = null] : (c0= parse_eu_hyvar_context_contextValidity_HyValidityModel ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        eu.hyvar.context.contextValidity.HyValidityModel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Hyvalidityformula.g:494:2: ( (c0= parse_eu_hyvar_context_contextValidity_HyValidityModel ) EOF )
            // Hyvalidityformula.g:495:2: (c0= parse_eu_hyvar_context_contextValidity_HyValidityModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[2]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[3]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Hyvalidityformula.g:503:2: (c0= parse_eu_hyvar_context_contextValidity_HyValidityModel )
            // Hyvalidityformula.g:504:3: c0= parse_eu_hyvar_context_contextValidity_HyValidityModel
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
    // Hyvalidityformula.g:512:1: parse_eu_hyvar_context_contextValidity_HyValidityModel returns [eu.hyvar.context.contextValidity.HyValidityModel element = null] : ( (a0_0= parse_eu_hyvar_context_contextValidity_HyValidityFormula ) )* ;
    public final eu.hyvar.context.contextValidity.HyValidityModel parse_eu_hyvar_context_contextValidity_HyValidityModel() throws RecognitionException {
        eu.hyvar.context.contextValidity.HyValidityModel element =  null;

        int parse_eu_hyvar_context_contextValidity_HyValidityModel_StartIndex = input.index();

        eu.hyvar.context.contextValidity.HyValidityFormula a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Hyvalidityformula.g:515:2: ( ( (a0_0= parse_eu_hyvar_context_contextValidity_HyValidityFormula ) )* )
            // Hyvalidityformula.g:516:2: ( (a0_0= parse_eu_hyvar_context_contextValidity_HyValidityFormula ) )*
            {
            // Hyvalidityformula.g:516:2: ( (a0_0= parse_eu_hyvar_context_contextValidity_HyValidityFormula ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IDENTIFIER_TOKEN||LA1_0==QUOTED_34_34) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Hyvalidityformula.g:517:3: (a0_0= parse_eu_hyvar_context_contextValidity_HyValidityFormula )
            	    {
            	    // Hyvalidityformula.g:517:3: (a0_0= parse_eu_hyvar_context_contextValidity_HyValidityFormula )
            	    // Hyvalidityformula.g:518:4: a0_0= parse_eu_hyvar_context_contextValidity_HyValidityFormula
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
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[4]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[6]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[7]);
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



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction"
    // Hyvalidityformula.g:549:1: parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction returns [eu.hyvar.feature.expression.HyRelativeVersionRestriction element = null] : a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Hyvalidityformula.g:552:2: (a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' )
            // Hyvalidityformula.g:553:2: a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']'
            {
            a0=(Token)match(input,34,FOLLOW_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction165); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[8]);
            	}

            // Hyvalidityformula.g:570:2: ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? )
            // Hyvalidityformula.g:571:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
            {
            // Hyvalidityformula.g:571:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
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
                case 30:
                    {
                    alt2=4;
                    }
                    break;
                case 29:
                    {
                    alt2=5;
                    }
                    break;
            }

            switch (alt2) {
                case 1 :
                    // Hyvalidityformula.g:572:4: a1= '<'
                    {
                    a1=(Token)match(input,25,FOLLOW_25_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction188); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:588:8: a2= '<='
                    {
                    a2=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction203); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Hyvalidityformula.g:604:8: a3= '='
                    {
                    a3=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction218); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a3, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 4 :
                    // Hyvalidityformula.g:620:8: a4= '>='
                    {
                    a4=(Token)match(input,30,FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction233); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a4, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 5 :
                    // Hyvalidityformula.g:636:8: a5= '>'
                    {
                    a5=(Token)match(input,29,FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction248); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[9]);
            	}

            // Hyvalidityformula.g:658:2: (a8= QUOTED_34_34 )
            // Hyvalidityformula.g:659:3: a8= QUOTED_34_34
            {
            a8=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction273); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a8, element);
            				copyLocalizationInfos((CommonToken) a8, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[10]);
            	}

            a9=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction294); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[11]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[12]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[13]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[14]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[15]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[16]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[17]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[18]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[19]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[20]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[21]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[22]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[23]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[24]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[25]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[27]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[28]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[29]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[30]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[31]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[32]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[33]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[34]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[35]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[36]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyVersionRangeRestriction"
    // Hyvalidityformula.g:745:1: parse_eu_hyvar_feature_expression_HyVersionRangeRestriction returns [eu.hyvar.feature.expression.HyVersionRangeRestriction element = null] : a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Hyvalidityformula.g:748:2: (a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' )
            // Hyvalidityformula.g:749:2: a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']'
            {
            a0=(Token)match(input,34,FOLLOW_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction323); if (state.failed) return element;

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
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_28_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[37]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[38]);
            	}

            // Hyvalidityformula.g:774:2: ( (a1= '^' )? )
            // Hyvalidityformula.g:775:3: (a1= '^' )?
            {
            // Hyvalidityformula.g:775:3: (a1= '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==37) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Hyvalidityformula.g:776:4: a1= '^'
                    {
                    a1=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction346); if (state.failed) return element;

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
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_28_0_0_1, false, true);
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
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[39]);
            	}

            // Hyvalidityformula.g:805:2: (a3= QUOTED_34_34 )
            // Hyvalidityformula.g:806:3: a3= QUOTED_34_34
            {
            a3=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction371); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_28_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            				copyLocalizationInfos((CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[40]);
            	}

            a4=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction392); if (state.failed) return element;

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
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_28_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[41]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[42]);
            	}

            // Hyvalidityformula.g:880:2: ( (a5= '^' )? )
            // Hyvalidityformula.g:881:3: (a5= '^' )?
            {
            // Hyvalidityformula.g:881:3: (a5= '^' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==37) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Hyvalidityformula.g:882:4: a5= '^'
                    {
                    a5=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction415); if (state.failed) return element;

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
                    				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_28_0_0_4, false, true);
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
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[43]);
            	}

            // Hyvalidityformula.g:911:2: (a7= QUOTED_34_34 )
            // Hyvalidityformula.g:912:3: a7= QUOTED_34_34
            {
            a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction440); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_28_0_0_5, proxy, true);
            				copyLocalizationInfos((CommonToken) a7, element);
            				copyLocalizationInfos((CommonToken) a7, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[44]);
            	}

            a8=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction461); if (state.failed) return element;

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
            		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_28_0_0_6, null, true);
            		copyLocalizationInfos((CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[45]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[46]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[47]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[48]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[49]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[50]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[51]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[52]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[53]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[54]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[55]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[56]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[57]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[58]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[59]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[60]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[61]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[62]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[63]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[64]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[65]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[66]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[67]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[68]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[69]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[70]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyVersionRangeRestriction"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnum"
    // Hyvalidityformula.g:1012:1: parse_eu_hyvar_dataValues_HyEnum returns [eu.hyvar.dataValues.HyEnum element = null] : a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Hyvalidityformula.g:1015:2: (a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? )
            // Hyvalidityformula.g:1016:2: a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            {
            a0=(Token)match(input,32,FOLLOW_32_in_parse_eu_hyvar_dataValues_HyEnum490); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[71]);
            	}

            // Hyvalidityformula.g:1030:2: (a1= IDENTIFIER_TOKEN )
            // Hyvalidityformula.g:1031:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum508); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[72]);
            	}

            a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum529); if (state.failed) return element;

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
            		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[73]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[74]);
            	}

            // Hyvalidityformula.g:1081:2: ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==33) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Hyvalidityformula.g:1082:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    {
                    // Hyvalidityformula.g:1082:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    // Hyvalidityformula.g:1083:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    {
                    // Hyvalidityformula.g:1083:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    // Hyvalidityformula.g:1084:5: a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum558);
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
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[75]);
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[76]);
                    			}

                    // Hyvalidityformula.g:1110:4: ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==19) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // Hyvalidityformula.g:1111:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    {
                    	    // Hyvalidityformula.g:1111:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    // Hyvalidityformula.g:1112:6: a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    {
                    	    a4=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum599); if (state.failed) return element;

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
                    	    						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[77]);
                    	    					}

                    	    // Hyvalidityformula.g:1126:6: (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    // Hyvalidityformula.g:1127:7: a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum633);
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
                    	    						addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[78]);
                    	    						addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[79]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[80]);
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[81]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[82]);
            	}

            a6=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum707); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[83]);
            	}

            // Hyvalidityformula.g:1182:2: ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==34) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Hyvalidityformula.g:1183:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    {
                    // Hyvalidityformula.g:1183:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    // Hyvalidityformula.g:1184:4: a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']'
                    {
                    a7=(Token)match(input,34,FOLLOW_34_in_parse_eu_hyvar_dataValues_HyEnum730); if (state.failed) return element;

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
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[84]);
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[85]);
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[86]);
                    			}

                    // Hyvalidityformula.g:1200:4: ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) )
                    int alt7=3;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==DATE) ) {
                        int LA7_1 = input.LA(2);

                        if ( (LA7_1==20) ) {
                            int LA7_3 = input.LA(3);

                            if ( (LA7_3==DATE) ) {
                                alt7=1;
                            }
                            else if ( (LA7_3==36) ) {
                                alt7=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 7, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA7_0==40) ) {
                        alt7=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;

                    }
                    switch (alt7) {
                        case 1 :
                            // Hyvalidityformula.g:1201:5: (a8= DATE ) a9= '-' (a10= DATE )
                            {
                            // Hyvalidityformula.g:1201:5: (a8= DATE )
                            // Hyvalidityformula.g:1202:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum763); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[87]);
                            				}

                            a9=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum802); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[88]);
                            				}

                            // Hyvalidityformula.g:1251:5: (a10= DATE )
                            // Hyvalidityformula.g:1252:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum832); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[89]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyvalidityformula.g:1288:10: (a11= DATE ) a12= '-'
                            {
                            // Hyvalidityformula.g:1288:10: (a11= DATE )
                            // Hyvalidityformula.g:1289:6: a11= DATE
                            {
                            a11=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum888); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[90]);
                            				}

                            a12=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum927); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[91]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyvalidityformula.g:1339:10: a13= 'eternity' a14= '-' (a15= DATE )
                            {
                            a13=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_dataValues_HyEnum960); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[92]);
                            				}

                            a14=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum983); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[93]);
                            				}

                            // Hyvalidityformula.g:1367:5: (a15= DATE )
                            // Hyvalidityformula.g:1368:6: a15= DATE
                            {
                            a15=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1013); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[94]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[95]);
                    			}

                    a16=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_dataValues_HyEnum1065); if (state.failed) return element;

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
            if ( state.backtracking>0 ) { memoize(input, 5, parse_eu_hyvar_dataValues_HyEnum_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnum"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumLiteral"
    // Hyvalidityformula.g:1430:1: parse_eu_hyvar_dataValues_HyEnumLiteral returns [eu.hyvar.dataValues.HyEnumLiteral element = null] : a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Hyvalidityformula.g:1433:2: (a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hyvalidityformula.g:1434:2: a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            a0=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnumLiteral1113); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[96]);
            	}

            // Hyvalidityformula.g:1448:2: (a1= IDENTIFIER_TOKEN )
            // Hyvalidityformula.g:1449:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral1131); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[97]);
            	}

            a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnumLiteral1152); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[98]);
            	}

            // Hyvalidityformula.g:1498:2: (a3= INTEGER_LITERAL )
            // Hyvalidityformula.g:1499:3: a3= INTEGER_LITERAL
            {
            a3=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral1170); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[99]);
            	}

            a4=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral1191); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[100]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[101]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[102]);
            	}

            // Hyvalidityformula.g:1550:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==34) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Hyvalidityformula.g:1551:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hyvalidityformula.g:1551:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hyvalidityformula.g:1552:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,34,FOLLOW_34_in_parse_eu_hyvar_dataValues_HyEnumLiteral1214); if (state.failed) return element;

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
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[103]);
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[104]);
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[105]);
                    			}

                    // Hyvalidityformula.g:1568:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) )
                    int alt9=3;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==DATE) ) {
                        int LA9_1 = input.LA(2);

                        if ( (LA9_1==20) ) {
                            int LA9_3 = input.LA(3);

                            if ( (LA9_3==DATE) ) {
                                alt9=1;
                            }
                            else if ( (LA9_3==40) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA9_0==40) ) {
                        alt9=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;

                    }
                    switch (alt9) {
                        case 1 :
                            // Hyvalidityformula.g:1569:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hyvalidityformula.g:1569:5: (a6= DATE )
                            // Hyvalidityformula.g:1570:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1247); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[106]);
                            				}

                            a7=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1286); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[107]);
                            				}

                            // Hyvalidityformula.g:1619:5: (a8= DATE )
                            // Hyvalidityformula.g:1620:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1316); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[108]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyvalidityformula.g:1656:10: (a9= DATE ) a10= '-' a11= 'eternity'
                            {
                            // Hyvalidityformula.g:1656:10: (a9= DATE )
                            // Hyvalidityformula.g:1657:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1372); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[109]);
                            				}

                            a10=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1411); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[110]);
                            				}

                            a11=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_dataValues_HyEnumLiteral1434); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[111]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyvalidityformula.g:1721:10: a12= 'eternity' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_dataValues_HyEnumLiteral1467); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[112]);
                            				}

                            a13=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1490); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[113]);
                            				}

                            // Hyvalidityformula.g:1749:5: (a14= DATE )
                            // Hyvalidityformula.g:1750:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1520); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[114]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[115]);
                    			}

                    a15=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_dataValues_HyEnumLiteral1572); if (state.failed) return element;

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
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[116]);
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[117]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[118]);
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[119]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_eu_hyvar_dataValues_HyEnumLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumLiteral"



    // $ANTLR start "parseop_HyValidityFormula_level_15"
    // Hyvalidityformula.g:1816:1: parseop_HyValidityFormula_level_15 returns [eu.hyvar.context.contextValidity.HyValidityFormula element = null] : (c0= parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula |c1= parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula );
    public final eu.hyvar.context.contextValidity.HyValidityFormula parseop_HyValidityFormula_level_15() throws RecognitionException {
        eu.hyvar.context.contextValidity.HyValidityFormula element =  null;

        int parseop_HyValidityFormula_level_15_StartIndex = input.index();

        eu.hyvar.context.contextValidity.HyFeatureValidityFormula c0 =null;

        eu.hyvar.context.contextValidity.HyAttributeValidityFormula c1 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Hyvalidityformula.g:1819:2: (c0= parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula |c1= parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==QUOTED_34_34) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==24) ) {
                    alt11=1;
                }
                else if ( (LA11_1==22) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA11_0==IDENTIFIER_TOKEN) ) {
                int LA11_2 = input.LA(2);

                if ( (LA11_2==24) ) {
                    alt11=1;
                }
                else if ( (LA11_2==22) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // Hyvalidityformula.g:1820:2: c0= parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula_in_parseop_HyValidityFormula_level_151620);
                    c0=parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:1821:4: c1= parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula_in_parseop_HyValidityFormula_level_151630);
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
            if ( state.backtracking>0 ) { memoize(input, 7, parseop_HyValidityFormula_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyValidityFormula_level_15"



    // $ANTLR start "parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula"
    // Hyvalidityformula.g:1824:1: parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula returns [eu.hyvar.context.contextValidity.HyFeatureValidityFormula element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= ':' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a4= '[' ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) ) a14= ']' ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Hyvalidityformula.g:1827:2: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= ':' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a4= '[' ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) ) a14= ']' ) )? )
            // Hyvalidityformula.g:1828:2: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= ':' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a4= '[' ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) ) a14= ']' ) )?
            {
            // Hyvalidityformula.g:1828:2: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==QUOTED_34_34) ) {
                alt12=1;
            }
            else if ( (LA12_0==IDENTIFIER_TOKEN) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // Hyvalidityformula.g:1829:3: (a0= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:1829:3: (a0= QUOTED_34_34 )
                    // Hyvalidityformula.g:1830:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1662); if (state.failed) return element;

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
                    			addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[120]);
                    		}

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:1870:6: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:1870:6: (a1= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:1871:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1700); if (state.failed) return element;

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
                    			addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[121]);
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[122]);
            	}

            a2=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1734); if (state.failed) return element;

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
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[123]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[124]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[125]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[126]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[127]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[128]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[129]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[130]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[131]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[132]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[133]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[134]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[135]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[136]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[137]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[138]);
            	}

            // Hyvalidityformula.g:1945:2: (a3_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyvalidityformula.g:1946:3: a3_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1752);
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
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[139]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[140]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[141]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[142]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[143]);
            	}

            // Hyvalidityformula.g:1975:2: ( (a4= '[' ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) ) a14= ']' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==34) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Hyvalidityformula.g:1976:3: (a4= '[' ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) ) a14= ']' )
                    {
                    // Hyvalidityformula.g:1976:3: (a4= '[' ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) ) a14= ']' )
                    // Hyvalidityformula.g:1977:4: a4= '[' ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) ) a14= ']'
                    {
                    a4=(Token)match(input,34,FOLLOW_34_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1779); if (state.failed) return element;

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
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[144]);
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[145]);
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[146]);
                    			}

                    // Hyvalidityformula.g:1993:4: ( (a5= DATE ) a6= '-' (a7= DATE ) | (a8= DATE ) a9= '-' a10= 'eternity' |a11= 'eternity' a12= '-' (a13= DATE ) )
                    int alt13=3;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==DATE) ) {
                        int LA13_1 = input.LA(2);

                        if ( (LA13_1==20) ) {
                            int LA13_3 = input.LA(3);

                            if ( (LA13_3==DATE) ) {
                                alt13=1;
                            }
                            else if ( (LA13_3==40) ) {
                                alt13=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 13, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA13_0==40) ) {
                        alt13=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;

                    }
                    switch (alt13) {
                        case 1 :
                            // Hyvalidityformula.g:1994:5: (a5= DATE ) a6= '-' (a7= DATE )
                            {
                            // Hyvalidityformula.g:1994:5: (a5= DATE )
                            // Hyvalidityformula.g:1995:6: a5= DATE
                            {
                            a5=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1812); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[147]);
                            				}

                            a6=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1851); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[148]);
                            				}

                            // Hyvalidityformula.g:2044:5: (a7= DATE )
                            // Hyvalidityformula.g:2045:6: a7= DATE
                            {
                            a7=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1881); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[149]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyvalidityformula.g:2081:10: (a8= DATE ) a9= '-' a10= 'eternity'
                            {
                            // Hyvalidityformula.g:2081:10: (a8= DATE )
                            // Hyvalidityformula.g:2082:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1937); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[150]);
                            				}

                            a9=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1976); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[151]);
                            				}

                            a10=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1999); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[152]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyvalidityformula.g:2146:10: a11= 'eternity' a12= '-' (a13= DATE )
                            {
                            a11=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2032); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[153]);
                            				}

                            a12=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2055); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[154]);
                            				}

                            // Hyvalidityformula.g:2174:5: (a13= DATE )
                            // Hyvalidityformula.g:2175:6: a13= DATE
                            {
                            a13=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2085); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[155]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[156]);
                    			}

                    a14=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2137); if (state.failed) return element;

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
                    				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[157]);
                    				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[158]);
                    				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[159]);
                    				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[160]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[161]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[162]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[163]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[164]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula"



    // $ANTLR start "parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula"
    // Hyvalidityformula.g:2245:1: parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula returns [eu.hyvar.context.contextValidity.HyAttributeValidityFormula element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) a4= ':' (a5_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a6= '[' ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Hyvalidityformula.g:2248:2: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) a4= ':' (a5_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a6= '[' ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? )
            // Hyvalidityformula.g:2249:2: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) a4= ':' (a5_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a6= '[' ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            {
            // Hyvalidityformula.g:2249:2: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==QUOTED_34_34) ) {
                alt15=1;
            }
            else if ( (LA15_0==IDENTIFIER_TOKEN) ) {
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
                    // Hyvalidityformula.g:2250:3: (a0= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:2250:3: (a0= QUOTED_34_34 )
                    // Hyvalidityformula.g:2251:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2194); if (state.failed) return element;

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
                    			addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[165]);
                    		}

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:2291:6: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:2291:6: (a1= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:2292:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2232); if (state.failed) return element;

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
                    			addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[166]);
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[167]);
            	}

            a2=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2266); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[168]);
            	}

            // Hyvalidityformula.g:2351:2: (a3= IDENTIFIER_TOKEN )
            // Hyvalidityformula.g:2352:3: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2284); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[169]);
            	}

            a4=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2305); if (state.failed) return element;

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
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[170]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[171]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[172]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[173]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[174]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[175]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[176]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[177]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[178]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[179]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[180]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[181]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[182]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[183]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[184]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[185]);
            	}

            // Hyvalidityformula.g:2420:2: (a5_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyvalidityformula.g:2421:3: a5_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2323);
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
            		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[186]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[187]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[188]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[189]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[190]);
            	}

            // Hyvalidityformula.g:2450:2: ( (a6= '[' ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==34) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // Hyvalidityformula.g:2451:3: (a6= '[' ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    {
                    // Hyvalidityformula.g:2451:3: (a6= '[' ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    // Hyvalidityformula.g:2452:4: a6= '[' ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']'
                    {
                    a6=(Token)match(input,34,FOLLOW_34_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2350); if (state.failed) return element;

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
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[191]);
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[192]);
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[193]);
                    			}

                    // Hyvalidityformula.g:2468:4: ( (a7= DATE ) a8= '-' (a9= DATE ) | (a10= DATE ) a11= '-' a12= 'eternity' |a13= 'eternity' a14= '-' (a15= DATE ) )
                    int alt16=3;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==DATE) ) {
                        int LA16_1 = input.LA(2);

                        if ( (LA16_1==20) ) {
                            int LA16_3 = input.LA(3);

                            if ( (LA16_3==DATE) ) {
                                alt16=1;
                            }
                            else if ( (LA16_3==40) ) {
                                alt16=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 16, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 16, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA16_0==40) ) {
                        alt16=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;

                    }
                    switch (alt16) {
                        case 1 :
                            // Hyvalidityformula.g:2469:5: (a7= DATE ) a8= '-' (a9= DATE )
                            {
                            // Hyvalidityformula.g:2469:5: (a7= DATE )
                            // Hyvalidityformula.g:2470:6: a7= DATE
                            {
                            a7=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2383); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[194]);
                            				}

                            a8=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2422); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[195]);
                            				}

                            // Hyvalidityformula.g:2519:5: (a9= DATE )
                            // Hyvalidityformula.g:2520:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2452); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[196]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyvalidityformula.g:2556:10: (a10= DATE ) a11= '-' a12= 'eternity'
                            {
                            // Hyvalidityformula.g:2556:10: (a10= DATE )
                            // Hyvalidityformula.g:2557:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2508); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[197]);
                            				}

                            a11=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2547); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[198]);
                            				}

                            a12=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2570); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[199]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyvalidityformula.g:2621:10: a13= 'eternity' a14= '-' (a15= DATE )
                            {
                            a13=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2603); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[200]);
                            				}

                            a14=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2626); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[201]);
                            				}

                            // Hyvalidityformula.g:2649:5: (a15= DATE )
                            // Hyvalidityformula.g:2650:6: a15= DATE
                            {
                            a15=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2656); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[202]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[203]);
                    			}

                    a16=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2708); if (state.failed) return element;

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
                    				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[204]);
                    				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[205]);
                    				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[206]);
                    				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[207]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[208]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[209]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[210]);
            		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[211]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula"



    // $ANTLR start "parseop_HyExpression_level_0"
    // Hyvalidityformula.g:2720:1: parseop_HyExpression_level_0 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_0() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_0_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Hyvalidityformula.g:2723:2: (leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) )
            // Hyvalidityformula.g:2724:2: leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02756);
            leftArg=parseop_HyExpression_level_1();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:2724:41: ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==26) ) {
                alt19=1;
            }
            else if ( (LA19_0==EOF||LA19_0==IDENTIFIER_TOKEN||LA19_0==QUOTED_34_34||LA19_0==16||LA19_0==19||LA19_0==34) ) {
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
                    // Hyvalidityformula.g:2724:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    {
                    // Hyvalidityformula.g:2724:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==26) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // Hyvalidityformula.g:2725:3: () a0= '<->' rightArg= parseop_HyExpression_level_1
                    	    {
                    	    // Hyvalidityformula.g:2725:3: ()
                    	    // Hyvalidityformula.g:2725:4: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,26,FOLLOW_26_in_parseop_HyExpression_level_02776); if (state.failed) return element;

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
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[212]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[213]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[214]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[215]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[216]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[217]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[218]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[219]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[220]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[221]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[222]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[223]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[224]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[225]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[226]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[227]);
                    	    		}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02793);
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
                    // Hyvalidityformula.g:2795:21: 
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
            if ( state.backtracking>0 ) { memoize(input, 10, parseop_HyExpression_level_0_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_0"



    // $ANTLR start "parseop_HyExpression_level_1"
    // Hyvalidityformula.g:2800:1: parseop_HyExpression_level_1 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_4 ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_1() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_1_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Hyvalidityformula.g:2803:9: (leftArg= parseop_HyExpression_level_4 ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |) )
            // Hyvalidityformula.g:2804:9: leftArg= parseop_HyExpression_level_4 ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_12839);
            leftArg=parseop_HyExpression_level_4();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:2804:39: ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |)
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==21) ) {
                alt21=1;
            }
            else if ( (LA21_0==EOF||LA21_0==IDENTIFIER_TOKEN||LA21_0==QUOTED_34_34||LA21_0==16||LA21_0==19||LA21_0==26||LA21_0==34) ) {
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
                    // Hyvalidityformula.g:2804:40: ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+
                    {
                    // Hyvalidityformula.g:2804:40: ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==21) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // Hyvalidityformula.g:2805:2: () a0= '->' rightArg= parseop_HyExpression_level_4
                    	    {
                    	    // Hyvalidityformula.g:2805:2: ()
                    	    // Hyvalidityformula.g:2805:3: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,21,FOLLOW_21_in_parseop_HyExpression_level_12855); if (state.failed) return element;

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
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[228]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[229]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[230]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[231]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[232]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[233]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[234]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[235]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[236]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[237]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[238]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[239]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[240]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[241]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[242]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[243]);
                    	    	}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_12869);
                    	    rightArg=parseop_HyExpression_level_4();

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
                    // Hyvalidityformula.g:2875:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 11, parseop_HyExpression_level_1_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_1"



    // $ANTLR start "parseop_HyExpression_level_4"
    // Hyvalidityformula.g:2880:1: parseop_HyExpression_level_4 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_5 ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_4() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_4_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Hyvalidityformula.g:2883:9: (leftArg= parseop_HyExpression_level_5 ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |) )
            // Hyvalidityformula.g:2884:9: leftArg= parseop_HyExpression_level_5 ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_42910);
            leftArg=parseop_HyExpression_level_5();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:2884:39: ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |)
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==46) ) {
                alt23=1;
            }
            else if ( (LA23_0==EOF||LA23_0==IDENTIFIER_TOKEN||LA23_0==QUOTED_34_34||LA23_0==16||LA23_0==19||LA23_0==21||LA23_0==26||LA23_0==34) ) {
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
                    // Hyvalidityformula.g:2884:40: ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+
                    {
                    // Hyvalidityformula.g:2884:40: ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==46) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // Hyvalidityformula.g:2885:0: () a0= '||' rightArg= parseop_HyExpression_level_5
                    	    {
                    	    // Hyvalidityformula.g:2885:2: ()
                    	    // Hyvalidityformula.g:2885:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,46,FOLLOW_46_in_parseop_HyExpression_level_42923); if (state.failed) return element;

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
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[244]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[245]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[246]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[247]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[248]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[249]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[250]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[251]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[252]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[253]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[254]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[255]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[256]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[257]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[258]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[259]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_42934);
                    	    rightArg=parseop_HyExpression_level_5();

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
                    // Hyvalidityformula.g:2955:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 12, parseop_HyExpression_level_4_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_4"



    // $ANTLR start "parseop_HyExpression_level_5"
    // Hyvalidityformula.g:2960:1: parseop_HyExpression_level_5 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_9 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_5() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_5_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Hyvalidityformula.g:2963:9: (leftArg= parseop_HyExpression_level_9 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |) )
            // Hyvalidityformula.g:2964:9: leftArg= parseop_HyExpression_level_9 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_52972);
            leftArg=parseop_HyExpression_level_9();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:2964:39: ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |)
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==14) ) {
                alt25=1;
            }
            else if ( (LA25_0==EOF||LA25_0==IDENTIFIER_TOKEN||LA25_0==QUOTED_34_34||LA25_0==16||LA25_0==19||LA25_0==21||LA25_0==26||LA25_0==34||LA25_0==46) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }
            switch (alt25) {
                case 1 :
                    // Hyvalidityformula.g:2964:40: ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+
                    {
                    // Hyvalidityformula.g:2964:40: ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==14) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // Hyvalidityformula.g:2965:0: () a0= '&&' rightArg= parseop_HyExpression_level_9
                    	    {
                    	    // Hyvalidityformula.g:2965:2: ()
                    	    // Hyvalidityformula.g:2965:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,14,FOLLOW_14_in_parseop_HyExpression_level_52985); if (state.failed) return element;

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
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[260]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[261]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[262]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[263]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[264]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[265]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[266]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[267]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[268]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[269]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[270]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[271]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[272]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[273]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[274]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[275]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_52996);
                    	    rightArg=parseop_HyExpression_level_9();

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
                    	    if ( cnt24 >= 1 ) break loop24;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3035:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 13, parseop_HyExpression_level_5_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_5"



    // $ANTLR start "parseop_HyExpression_level_9"
    // Hyvalidityformula.g:3040:1: parseop_HyExpression_level_9 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_12 ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_9() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_9_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Hyvalidityformula.g:3043:9: (leftArg= parseop_HyExpression_level_12 ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |) )
            // Hyvalidityformula.g:3044:9: leftArg= parseop_HyExpression_level_12 ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_93034);
            leftArg=parseop_HyExpression_level_12();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:3044:40: ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |)
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==13||LA27_0==25||(LA27_0 >= 27 && LA27_0 <= 30)) ) {
                alt27=1;
            }
            else if ( (LA27_0==EOF||LA27_0==IDENTIFIER_TOKEN||LA27_0==QUOTED_34_34||LA27_0==14||LA27_0==16||LA27_0==19||LA27_0==21||LA27_0==26||LA27_0==34||LA27_0==46) ) {
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
                    // Hyvalidityformula.g:3044:41: ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+
                    {
                    // Hyvalidityformula.g:3044:41: ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=7;
                        switch ( input.LA(1) ) {
                        case 25:
                            {
                            alt26=1;
                            }
                            break;
                        case 27:
                            {
                            alt26=2;
                            }
                            break;
                        case 29:
                            {
                            alt26=3;
                            }
                            break;
                        case 30:
                            {
                            alt26=4;
                            }
                            break;
                        case 28:
                            {
                            alt26=5;
                            }
                            break;
                        case 13:
                            {
                            alt26=6;
                            }
                            break;

                        }

                        switch (alt26) {
                    	case 1 :
                    	    // Hyvalidityformula.g:3045:0: () a0= '<' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hyvalidityformula.g:3045:2: ()
                    	    // Hyvalidityformula.g:3045:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,25,FOLLOW_25_in_parseop_HyExpression_level_93047); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyLessExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_16_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[276]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[277]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[278]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[279]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[280]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[281]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[282]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[283]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[284]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[285]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[286]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[287]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[288]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[289]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[290]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[291]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_93058);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_16_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_16_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 2 :
                    	    // Hyvalidityformula.g:3116:0: () a0= '<=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hyvalidityformula.g:3116:2: ()
                    	    // Hyvalidityformula.g:3116:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,27,FOLLOW_27_in_parseop_HyExpression_level_93076); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyLessOrEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_17_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[292]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[293]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[294]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[295]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[296]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[297]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[298]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[299]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[300]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[301]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[302]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[303]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[304]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[305]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[306]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[307]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_93087);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_17_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_17_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 3 :
                    	    // Hyvalidityformula.g:3187:0: () a0= '>' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hyvalidityformula.g:3187:2: ()
                    	    // Hyvalidityformula.g:3187:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,29,FOLLOW_29_in_parseop_HyExpression_level_93105); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyGreaterExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_18_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[308]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[309]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[310]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[311]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[312]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[313]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[314]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[315]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[316]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[317]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[318]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[319]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[320]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[321]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[322]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[323]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_93116);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_18_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_18_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 4 :
                    	    // Hyvalidityformula.g:3258:0: () a0= '>=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hyvalidityformula.g:3258:2: ()
                    	    // Hyvalidityformula.g:3258:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,30,FOLLOW_30_in_parseop_HyExpression_level_93134); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyGreaterOrEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_19_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[324]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[325]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[326]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[327]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[328]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[329]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[330]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[331]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[332]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[333]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[334]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[335]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[336]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[337]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[338]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[339]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_93145);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_19_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_19_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 5 :
                    	    // Hyvalidityformula.g:3329:0: () a0= '=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hyvalidityformula.g:3329:2: ()
                    	    // Hyvalidityformula.g:3329:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,28,FOLLOW_28_in_parseop_HyExpression_level_93163); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_25_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[340]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[341]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[342]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[343]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[344]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[345]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[346]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[347]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[348]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[349]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[350]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[351]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[352]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[353]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[354]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[355]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_93174);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_25_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_25_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 6 :
                    	    // Hyvalidityformula.g:3400:0: () a0= '!=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hyvalidityformula.g:3400:2: ()
                    	    // Hyvalidityformula.g:3400:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,13,FOLLOW_13_in_parseop_HyExpression_level_93192); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNotEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_26_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[356]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[357]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[358]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[359]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[360]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[361]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[362]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[363]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[364]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[365]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[366]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[367]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[368]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[369]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[370]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[371]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_93203);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_26_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_26_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3470:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 14, parseop_HyExpression_level_9_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_9"



    // $ANTLR start "parseop_HyExpression_level_12"
    // Hyvalidityformula.g:3475:1: parseop_HyExpression_level_12 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_13 ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_12() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_12_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Hyvalidityformula.g:3478:9: (leftArg= parseop_HyExpression_level_13 ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |) )
            // Hyvalidityformula.g:3479:9: leftArg= parseop_HyExpression_level_13 ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_123241);
            leftArg=parseop_HyExpression_level_13();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:3479:40: ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |)
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==18||LA29_0==20) ) {
                alt29=1;
            }
            else if ( (LA29_0==EOF||LA29_0==IDENTIFIER_TOKEN||LA29_0==QUOTED_34_34||(LA29_0 >= 13 && LA29_0 <= 14)||LA29_0==16||LA29_0==19||LA29_0==21||(LA29_0 >= 25 && LA29_0 <= 30)||LA29_0==34||LA29_0==46) ) {
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
                    // Hyvalidityformula.g:3479:41: ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+
                    {
                    // Hyvalidityformula.g:3479:41: ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=3;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==20) ) {
                            alt28=1;
                        }
                        else if ( (LA28_0==18) ) {
                            alt28=2;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // Hyvalidityformula.g:3480:0: () a0= '-' rightArg= parseop_HyExpression_level_13
                    	    {
                    	    // Hyvalidityformula.g:3480:2: ()
                    	    // Hyvalidityformula.g:3480:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,20,FOLLOW_20_in_parseop_HyExpression_level_123254); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHySubtractionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[372]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[373]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[374]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[375]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[376]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[377]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[378]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[379]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[380]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[381]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[382]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[383]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[384]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[385]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[386]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[387]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_123265);
                    	    rightArg=parseop_HyExpression_level_13();

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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_20_0_0_0, leftArg, true);
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_20_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 2 :
                    	    // Hyvalidityformula.g:3551:0: () a0= '+' rightArg= parseop_HyExpression_level_13
                    	    {
                    	    // Hyvalidityformula.g:3551:2: ()
                    	    // Hyvalidityformula.g:3551:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,18,FOLLOW_18_in_parseop_HyExpression_level_123283); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAdditionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_21_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[388]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[389]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[390]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[391]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[392]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[393]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[394]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[395]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[396]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[397]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[398]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[399]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[400]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[401]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[402]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[403]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_123294);
                    	    rightArg=parseop_HyExpression_level_13();

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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_21_0_0_0, leftArg, true);
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_21_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt28 >= 1 ) break loop28;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3621:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 15, parseop_HyExpression_level_12_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_12"



    // $ANTLR start "parseop_HyExpression_level_13"
    // Hyvalidityformula.g:3626:1: parseop_HyExpression_level_13 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_14 ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_13() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_13_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Hyvalidityformula.g:3629:9: (leftArg= parseop_HyExpression_level_14 ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |) )
            // Hyvalidityformula.g:3630:9: leftArg= parseop_HyExpression_level_14 ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_133332);
            leftArg=parseop_HyExpression_level_14();

            state._fsp--;
            if (state.failed) return element;

            // Hyvalidityformula.g:3630:40: ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |)
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==17||LA31_0==23||LA31_0==35) ) {
                alt31=1;
            }
            else if ( (LA31_0==EOF||LA31_0==IDENTIFIER_TOKEN||LA31_0==QUOTED_34_34||(LA31_0 >= 13 && LA31_0 <= 14)||LA31_0==16||(LA31_0 >= 18 && LA31_0 <= 21)||(LA31_0 >= 25 && LA31_0 <= 30)||LA31_0==34||LA31_0==46) ) {
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
                    // Hyvalidityformula.g:3630:41: ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+
                    {
                    // Hyvalidityformula.g:3630:41: ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+
                    int cnt30=0;
                    loop30:
                    do {
                        int alt30=4;
                        switch ( input.LA(1) ) {
                        case 35:
                            {
                            alt30=1;
                            }
                            break;
                        case 17:
                            {
                            alt30=2;
                            }
                            break;
                        case 23:
                            {
                            alt30=3;
                            }
                            break;

                        }

                        switch (alt30) {
                    	case 1 :
                    	    // Hyvalidityformula.g:3631:0: () a0= '\\u0025' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Hyvalidityformula.g:3631:2: ()
                    	    // Hyvalidityformula.g:3631:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,35,FOLLOW_35_in_parseop_HyExpression_level_133345); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyModuloExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_22_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[404]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[405]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[406]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[407]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[408]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[409]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[410]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[411]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[412]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[413]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[414]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[415]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[416]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[417]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[418]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[419]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_133356);
                    	    rightArg=parseop_HyExpression_level_14();

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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_22_0_0_0, leftArg, true);
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_22_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 2 :
                    	    // Hyvalidityformula.g:3702:0: () a0= '*' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Hyvalidityformula.g:3702:2: ()
                    	    // Hyvalidityformula.g:3702:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,17,FOLLOW_17_in_parseop_HyExpression_level_133374); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMultiplicationExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_23_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[420]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[421]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[422]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[423]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[424]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[425]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[426]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[427]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[428]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[429]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[430]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[431]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[432]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[433]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[434]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[435]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_133385);
                    	    rightArg=parseop_HyExpression_level_14();

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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_23_0_0_0, leftArg, true);
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_23_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 3 :
                    	    // Hyvalidityformula.g:3773:0: () a0= '/' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Hyvalidityformula.g:3773:2: ()
                    	    // Hyvalidityformula.g:3773:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,23,FOLLOW_23_in_parseop_HyExpression_level_133403); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyDivisionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_24_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[436]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[437]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[438]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[439]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[440]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[441]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[442]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[443]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[444]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[445]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[446]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[447]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[448]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[449]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[450]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[451]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_133414);
                    	    rightArg=parseop_HyExpression_level_14();

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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_24_0_0_0, leftArg, true);
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
                    	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_24_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt30 >= 1 ) break loop30;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(30, input);
                                throw eee;
                        }
                        cnt30++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3843:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 16, parseop_HyExpression_level_13_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_13"



    // $ANTLR start "parseop_HyExpression_level_14"
    // Hyvalidityformula.g:3848:1: parseop_HyExpression_level_14 returns [eu.hyvar.feature.expression.HyExpression element = null] : (a0= '!' arg= parseop_HyExpression_level_15 |a2= '-' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 );
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_14() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_14_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression arg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Hyvalidityformula.g:3851:0: (a0= '!' arg= parseop_HyExpression_level_15 |a2= '-' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 )
            int alt32=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt32=1;
                }
                break;
            case 20:
                {
                alt32=2;
                }
                break;
            case IDENTIFIER_TOKEN:
            case INTEGER_LITERAL:
            case QUOTED_34_34:
            case 15:
            case 31:
            case 38:
            case 39:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
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
                    // Hyvalidityformula.g:3852:0: a0= '!' arg= parseop_HyExpression_level_15
                    {
                    a0=(Token)match(input,12,FOLLOW_12_in_parseop_HyExpression_level_143452); if (state.failed) return element;

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
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[452]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[453]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[454]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[455]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[456]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[457]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[458]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[459]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[460]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[461]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[462]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[463]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[464]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[465]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[466]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[467]);
                    }

                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143463);
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
                    // Hyvalidityformula.g:3901:0: a2= '-' arg= parseop_HyExpression_level_15
                    {
                    a2=(Token)match(input,20,FOLLOW_20_in_parseop_HyExpression_level_143472); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNegationExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_5_0_0_0, null, true);
                    copyLocalizationInfos((CommonToken)a2, element);
                    }

                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[468]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[469]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[470]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[471]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[472]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[473]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[474]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[475]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[476]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[477]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[478]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[479]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[480]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[481]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[482]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[483]);
                    }

                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143483);
                    arg=parseop_HyExpression_level_15();

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
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_5_0_0_1, arg, true);
                    copyLocalizationInfos(arg, element);
                    }
                    }

                    }
                    break;
                case 3 :
                    // Hyvalidityformula.g:3951:5: arg= parseop_HyExpression_level_15
                    {
                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143493);
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
            if ( state.backtracking>0 ) { memoize(input, 17, parseop_HyExpression_level_14_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_14"



    // $ANTLR start "parseop_HyExpression_level_15"
    // Hyvalidityformula.g:3954:1: parseop_HyExpression_level_15 returns [eu.hyvar.feature.expression.HyExpression element = null] : (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression |c4= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression |c5= parse_eu_hyvar_feature_expression_HyValueExpression |c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression |c7= parse_eu_hyvar_feature_expression_HyMinimumExpression |c8= parse_eu_hyvar_feature_expression_HyMaximumExpression |c9= parse_eu_hyvar_feature_expression_HyIfPossibleExpression );
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Hyvalidityformula.g:3957:0: (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression |c4= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression |c5= parse_eu_hyvar_feature_expression_HyValueExpression |c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression |c7= parse_eu_hyvar_feature_expression_HyMinimumExpression |c8= parse_eu_hyvar_feature_expression_HyMaximumExpression |c9= parse_eu_hyvar_feature_expression_HyIfPossibleExpression )
            int alt33=10;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt33=1;
                }
                break;
            case QUOTED_34_34:
                {
                int LA33_2 = input.LA(2);

                if ( (LA33_2==EOF||LA33_2==IDENTIFIER_TOKEN||LA33_2==QUOTED_34_34||(LA33_2 >= 13 && LA33_2 <= 14)||(LA33_2 >= 16 && LA33_2 <= 21)||LA33_2==23||(LA33_2 >= 25 && LA33_2 <= 30)||(LA33_2 >= 34 && LA33_2 <= 35)||LA33_2==46) ) {
                    alt33=2;
                }
                else if ( (LA33_2==22) ) {
                    alt33=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 2, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER_TOKEN:
                {
                int LA33_3 = input.LA(2);

                if ( (LA33_3==EOF||LA33_3==IDENTIFIER_TOKEN||LA33_3==QUOTED_34_34||(LA33_3 >= 13 && LA33_3 <= 14)||(LA33_3 >= 16 && LA33_3 <= 21)||LA33_3==23||(LA33_3 >= 25 && LA33_3 <= 30)||(LA33_3 >= 34 && LA33_3 <= 35)||LA33_3==46) ) {
                    alt33=2;
                }
                else if ( (LA33_3==22) ) {
                    alt33=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 3, input);

                    throw nvae;

                }
                }
                break;
            case 31:
                {
                alt33=3;
                }
                break;
            case 38:
                {
                alt33=4;
                }
                break;
            case INTEGER_LITERAL:
            case 39:
                {
                alt33=6;
                }
                break;
            case 45:
                {
                int LA33_7 = input.LA(2);

                if ( (synpred55_Hyvalidityformula()) ) {
                    alt33=6;
                }
                else if ( (synpred56_Hyvalidityformula()) ) {
                    alt33=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 7, input);

                    throw nvae;

                }
                }
                break;
            case 41:
                {
                int LA33_8 = input.LA(2);

                if ( (synpred55_Hyvalidityformula()) ) {
                    alt33=6;
                }
                else if ( (synpred56_Hyvalidityformula()) ) {
                    alt33=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 8, input);

                    throw nvae;

                }
                }
                break;
            case 44:
                {
                alt33=8;
                }
                break;
            case 43:
                {
                alt33=9;
                }
                break;
            case 42:
                {
                alt33=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }

            switch (alt33) {
                case 1 :
                    // Hyvalidityformula.g:3958:0: c0= parse_eu_hyvar_feature_expression_HyNestedExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_153515);
                    c0=parse_eu_hyvar_feature_expression_HyNestedExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:3959:2: c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_153523);
                    c1=parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hyvalidityformula.g:3960:2: c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_153531);
                    c2=parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Hyvalidityformula.g:3961:2: c3= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyExpression_level_153539);
                    c3=parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Hyvalidityformula.g:3962:2: c4= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyExpression_level_153547);
                    c4=parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Hyvalidityformula.g:3963:2: c5= parse_eu_hyvar_feature_expression_HyValueExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyExpression_level_153555);
                    c5=parse_eu_hyvar_feature_expression_HyValueExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Hyvalidityformula.g:3964:2: c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_153563);
                    c6=parse_eu_hyvar_feature_expression_HyBooleanValueExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Hyvalidityformula.g:3965:2: c7= parse_eu_hyvar_feature_expression_HyMinimumExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyMinimumExpression_in_parseop_HyExpression_level_153571);
                    c7=parse_eu_hyvar_feature_expression_HyMinimumExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Hyvalidityformula.g:3966:2: c8= parse_eu_hyvar_feature_expression_HyMaximumExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyMaximumExpression_in_parseop_HyExpression_level_153579);
                    c8=parse_eu_hyvar_feature_expression_HyMaximumExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c8; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 10 :
                    // Hyvalidityformula.g:3967:2: c9= parse_eu_hyvar_feature_expression_HyIfPossibleExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyIfPossibleExpression_in_parseop_HyExpression_level_153587);
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
            if ( state.backtracking>0 ) { memoize(input, 18, parseop_HyExpression_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_15"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyNestedExpression"
    // Hyvalidityformula.g:3970:1: parse_eu_hyvar_feature_expression_HyNestedExpression returns [eu.hyvar.feature.expression.HyNestedExpression element = null] : a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyNestedExpression parse_eu_hyvar_feature_expression_HyNestedExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyNestedExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Hyvalidityformula.g:3973:4: (a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Hyvalidityformula.g:3974:4: a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedExpression3609); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_6_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[484]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[485]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[486]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[487]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[488]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[489]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[490]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[491]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[492]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[493]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[494]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[495]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[496]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[497]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[498]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[499]);
            }

            // Hyvalidityformula.g:4003:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyvalidityformula.g:4004:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression3622);
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
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_6_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[500]);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression3634); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_6_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[501]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[502]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[503]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[504]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[505]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[506]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[507]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[508]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[509]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[510]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[511]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[512]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[513]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[514]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[515]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[516]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[517]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[518]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[519]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[520]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[521]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[522]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[523]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[524]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[525]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[526]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyNestedExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression"
    // Hyvalidityformula.g:4070:1: parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyFeatureReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? ;
    public final eu.hyvar.feature.expression.HyFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        eu.hyvar.feature.expression.HyVersionRestriction a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Hyvalidityformula.g:4073:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? )
            // Hyvalidityformula.g:4074:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            {
            // Hyvalidityformula.g:4074:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==QUOTED_34_34) ) {
                alt34=1;
            }
            else if ( (LA34_0==IDENTIFIER_TOKEN) ) {
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
                    // Hyvalidityformula.g:4075:0: (a0= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:4075:4: (a0= QUOTED_34_34 )
                    // Hyvalidityformula.g:4076:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3664); if (state.failed) return element;

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
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a0, element);
                    copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[527]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[528]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[529]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[530]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[531]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[532]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[533]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[534]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[535]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[536]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[537]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[538]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[539]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[540]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[541]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[542]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[543]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[544]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[545]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[546]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[547]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[548]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[549]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[550]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[551]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[552]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[553]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[554]);
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:4143:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:4143:2: (a1= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:4144:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3681); if (state.failed) return element;

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
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[555]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[556]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[557]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[558]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[559]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[560]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[561]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[562]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[563]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[564]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[565]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[566]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[567]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[568]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[569]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[570]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[571]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[572]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[573]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[574]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[575]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[576]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[577]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[578]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[579]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[580]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[581]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[582]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[583]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[584]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[585]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[586]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[587]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[588]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[589]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[590]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[591]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[592]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[593]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[594]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[595]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[596]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[597]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[598]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[599]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[600]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[601]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[602]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[603]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[604]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[605]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[606]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[607]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[608]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[609]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[610]);
            }

            // Hyvalidityformula.g:4243:0: ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==34) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==QUOTED_34_34||LA35_1==25||(LA35_1 >= 27 && LA35_1 <= 30)||LA35_1==37) ) {
                    alt35=1;
                }
            }
            switch (alt35) {
                case 1 :
                    // Hyvalidityformula.g:4244:0: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    {
                    // Hyvalidityformula.g:4244:6: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    // Hyvalidityformula.g:4245:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    {
                    // Hyvalidityformula.g:4245:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    // Hyvalidityformula.g:4246:6: a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3705);
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
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_0_0, a2_0, true);
                    copyLocalizationInfos(a2_0, element);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[611]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[612]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[613]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[614]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[615]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[616]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[617]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[618]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[619]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[620]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[621]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[622]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[623]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[624]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[625]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[626]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[627]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[628]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[629]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[630]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[631]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[632]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[633]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[634]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[635]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[636]);
                    }

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[637]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[638]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[639]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[640]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[641]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[642]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[643]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[644]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[645]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[646]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[647]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[648]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[649]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[650]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[651]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[652]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[653]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[654]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[655]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[656]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[657]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[658]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[659]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[660]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[661]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[662]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression"
    // Hyvalidityformula.g:4330:1: parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element = null] : a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ;
    public final eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyVersionRestriction a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Hyvalidityformula.g:4333:4: (a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
            // Hyvalidityformula.g:4334:4: a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            {
            a0=(Token)match(input,31,FOLLOW_31_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3740); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_8_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[663]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[664]);
            }

            // Hyvalidityformula.g:4349:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
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
                    // Hyvalidityformula.g:4350:0: (a1= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:4350:4: (a1= QUOTED_34_34 )
                    // Hyvalidityformula.g:4351:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3755); if (state.failed) return element;

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
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[665]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[666]);
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:4392:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:4392:2: (a2= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:4393:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3772); if (state.failed) return element;

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
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a2, element);
                    copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[667]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[668]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[669]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[670]);
            }

            // Hyvalidityformula.g:4440:6: (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            // Hyvalidityformula.g:4441:6: a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3792);
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
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_8_0_0_2, a3_0, true);
            copyLocalizationInfos(a3_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[671]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[672]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[673]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[674]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[675]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[676]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[677]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[678]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[679]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[680]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[681]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[682]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[683]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[684]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[685]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[686]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[687]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[688]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[689]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[690]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[691]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[692]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[693]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[694]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[695]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[696]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"
    // Hyvalidityformula.g:4493:1: parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression returns [eu.hyvar.feature.expression.HyContextInformationReferenceExpression element = null] : a0= 'context:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) ;
    public final eu.hyvar.feature.expression.HyContextInformationReferenceExpression parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyContextInformationReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Hyvalidityformula.g:4496:4: (a0= 'context:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) )
            // Hyvalidityformula.g:4497:4: a0= 'context:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3819); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_9_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[697]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[698]);
            }

            // Hyvalidityformula.g:4512:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
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
                    // Hyvalidityformula.g:4513:0: (a1= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:4513:4: (a1= QUOTED_34_34 )
                    // Hyvalidityformula.g:4514:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3834); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
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
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_9_0_0_1_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[699]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[700]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[701]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[702]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[703]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[704]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[705]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[706]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[707]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[708]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[709]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[710]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[711]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[712]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[713]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[714]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[715]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[716]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[717]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[718]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[719]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[720]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[721]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[722]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[723]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[724]);
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:4579:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:4579:2: (a2= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:4580:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3851); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a2 != null) {
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
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
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_9_0_0_1_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a2, element);
                    copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[725]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[726]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[727]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[728]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[729]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[730]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[731]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[732]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[733]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[734]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[735]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[736]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[737]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[738]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[739]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[740]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[741]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[742]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[743]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[744]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[745]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[746]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[747]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[748]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[749]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[750]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[751]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[752]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[753]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[754]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[755]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[756]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[757]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[758]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[759]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[760]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[761]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[762]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[763]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[764]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[765]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[766]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[767]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[768]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[769]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[770]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[771]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[772]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[773]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[774]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[775]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[776]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression"
    // Hyvalidityformula.g:4677:1: parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression returns [eu.hyvar.feature.expression.HyAttributeReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) ;
    public final eu.hyvar.feature.expression.HyAttributeReferenceExpression parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyAttributeReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Hyvalidityformula.g:4680:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) )
            // Hyvalidityformula.g:4681:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN )
            {
            // Hyvalidityformula.g:4681:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==QUOTED_34_34) ) {
                alt38=1;
            }
            else if ( (LA38_0==IDENTIFIER_TOKEN) ) {
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
                    // Hyvalidityformula.g:4682:0: (a0= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:4682:4: (a0= QUOTED_34_34 )
                    // Hyvalidityformula.g:4683:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3888); if (state.failed) return element;

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
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a0, element);
                    copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[777]);
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:4723:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:4723:2: (a1= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:4724:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3905); if (state.failed) return element;

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
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[778]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[779]);
            }

            a2=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3923); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_10_0_0_1, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[780]);
            }

            // Hyvalidityformula.g:4783:4: (a3= IDENTIFIER_TOKEN )
            // Hyvalidityformula.g:4784:4: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3936); if (state.failed) return element;

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
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_10_0_0_2, proxy, true);
            copyLocalizationInfos((CommonToken) a3, element);
            copyLocalizationInfos((CommonToken) a3, proxy);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[781]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[782]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[783]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[784]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[785]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[786]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[787]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[788]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[789]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[790]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[791]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[792]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[793]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[794]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[795]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[796]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[797]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[798]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[799]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[800]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[801]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[802]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[803]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[804]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[805]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[806]);
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



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyValueExpression"
    // Hyvalidityformula.g:4850:1: parse_eu_hyvar_feature_expression_HyValueExpression returns [eu.hyvar.feature.expression.HyValueExpression element = null] : (a0_0= parse_eu_hyvar_dataValues_HyValue ) ;
    public final eu.hyvar.feature.expression.HyValueExpression parse_eu_hyvar_feature_expression_HyValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Hyvalidityformula.g:4853:6: ( (a0_0= parse_eu_hyvar_dataValues_HyValue ) )
            // Hyvalidityformula.g:4854:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            {
            // Hyvalidityformula.g:4854:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            // Hyvalidityformula.g:4855:6: a0_0= parse_eu_hyvar_dataValues_HyValue
            {
            pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression3966);
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
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_11_0_0_0, a0_0, true);
            copyLocalizationInfos(a0_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[807]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[808]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[809]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[810]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[811]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[812]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[813]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[814]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[815]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[816]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[817]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[818]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[819]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[820]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[821]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[822]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[823]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[824]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[825]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[826]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[827]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[828]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[829]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[830]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[831]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[832]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 24, parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyValueExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"
    // Hyvalidityformula.g:4907:1: parse_eu_hyvar_feature_expression_HyBooleanValueExpression returns [eu.hyvar.feature.expression.HyBooleanValueExpression element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.feature.expression.HyBooleanValueExpression parse_eu_hyvar_feature_expression_HyBooleanValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyBooleanValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }

            // Hyvalidityformula.g:4910:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hyvalidityformula.g:4911:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hyvalidityformula.g:4911:0: ( (a0= 'true' |a1= 'false' ) )
            // Hyvalidityformula.g:4912:0: (a0= 'true' |a1= 'false' )
            {
            // Hyvalidityformula.g:4912:0: (a0= 'true' |a1= 'false' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==45) ) {
                alt39=1;
            }
            else if ( (LA39_0==41) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }
            switch (alt39) {
                case 1 :
                    // Hyvalidityformula.g:4913:0: a0= 'true'
                    {
                    a0=(Token)match(input,45,FOLLOW_45_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3997); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_12_0_0_0, true, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    // set value of boolean attribute
                    Object value = true;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:4926:2: a1= 'false'
                    {
                    a1=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression4006); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_12_0_0_0, false, true);
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
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[833]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[834]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[835]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[836]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[837]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[838]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[839]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[840]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[841]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[842]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[843]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[844]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[845]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[846]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[847]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[848]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[849]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[850]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[851]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[852]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[853]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[854]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[855]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[856]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[857]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[858]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyMinimumExpression"
    // Hyvalidityformula.g:4973:1: parse_eu_hyvar_feature_expression_HyMinimumExpression returns [eu.hyvar.feature.expression.HyMinimumExpression element = null] : a0= 'min(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyMinimumExpression parse_eu_hyvar_feature_expression_HyMinimumExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyMinimumExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyMinimumExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Hyvalidityformula.g:4976:4: (a0= 'min(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Hyvalidityformula.g:4977:4: a0= 'min(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,44,FOLLOW_44_in_parse_eu_hyvar_feature_expression_HyMinimumExpression4036); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMinimumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_13_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[859]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[860]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[861]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[862]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[863]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[864]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[865]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[866]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[867]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[868]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[869]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[870]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[871]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[872]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[873]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[874]);
            }

            // Hyvalidityformula.g:5006:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyvalidityformula.g:5007:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMinimumExpression4049);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_13_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[875]);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyMinimumExpression4061); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMinimumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_13_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[876]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[877]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[878]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[879]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[880]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[881]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[882]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[883]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[884]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[885]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[886]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[887]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[888]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[889]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[890]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[891]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[892]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[893]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[894]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[895]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[896]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[897]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[898]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[899]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[900]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[901]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, parse_eu_hyvar_feature_expression_HyMinimumExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyMinimumExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyMaximumExpression"
    // Hyvalidityformula.g:5073:1: parse_eu_hyvar_feature_expression_HyMaximumExpression returns [eu.hyvar.feature.expression.HyMaximumExpression element = null] : a0= 'max(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyMaximumExpression parse_eu_hyvar_feature_expression_HyMaximumExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyMaximumExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyMaximumExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Hyvalidityformula.g:5076:4: (a0= 'max(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Hyvalidityformula.g:5077:4: a0= 'max(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,43,FOLLOW_43_in_parse_eu_hyvar_feature_expression_HyMaximumExpression4087); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMaximumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_14_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[902]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[903]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[904]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[905]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[906]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[907]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[908]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[909]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[910]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[911]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[912]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[913]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[914]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[915]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[916]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[917]);
            }

            // Hyvalidityformula.g:5106:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyvalidityformula.g:5107:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMaximumExpression4100);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_14_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[918]);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyMaximumExpression4112); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMaximumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_14_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[919]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[920]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[921]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[922]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[923]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[924]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[925]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[926]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[927]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[928]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[929]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[930]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[931]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[932]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[933]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[934]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[935]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[936]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[937]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[938]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[939]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[940]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[941]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[942]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[943]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[944]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, parse_eu_hyvar_feature_expression_HyMaximumExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyMaximumExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyIfPossibleExpression"
    // Hyvalidityformula.g:5173:1: parse_eu_hyvar_feature_expression_HyIfPossibleExpression returns [eu.hyvar.feature.expression.HyIfPossibleExpression element = null] : a0= 'ifPossible(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )* a4= ')' ;
    public final eu.hyvar.feature.expression.HyIfPossibleExpression parse_eu_hyvar_feature_expression_HyIfPossibleExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyIfPossibleExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyIfPossibleExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;

        eu.hyvar.feature.expression.HyExpression a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Hyvalidityformula.g:5176:4: (a0= 'ifPossible(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )* a4= ')' )
            // Hyvalidityformula.g:5177:4: a0= 'ifPossible(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )* a4= ')'
            {
            a0=(Token)match(input,42,FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression4138); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_15_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[945]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[946]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[947]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[948]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[949]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[950]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[951]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[952]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[953]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[954]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[955]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[956]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[957]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[958]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[959]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[960]);
            }

            // Hyvalidityformula.g:5206:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyvalidityformula.g:5207:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression4151);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_15_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[961]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[962]);
            }

            // Hyvalidityformula.g:5233:0: ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==19) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // Hyvalidityformula.g:5234:0: (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) )
            	    {
            	    // Hyvalidityformula.g:5234:4: (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) )
            	    // Hyvalidityformula.g:5235:4: a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression )
            	    {
            	    a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression4167); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    if (element == null) {
            	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
            	    startIncompleteElement(element);
            	    }
            	    collectHiddenTokens(element);
            	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_0, null, true);
            	    copyLocalizationInfos((CommonToken)a2, element);
            	    }

            	    if ( state.backtracking==0 ) {
            	    // expected elements (follow set)
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[963]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[964]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[965]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[966]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[967]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[968]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[969]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[970]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[971]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[972]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[973]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[974]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[975]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[976]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[977]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[978]);
            	    }

            	    // Hyvalidityformula.g:5264:6: (a3_0= parse_eu_hyvar_feature_expression_HyExpression )
            	    // Hyvalidityformula.g:5265:6: a3_0= parse_eu_hyvar_feature_expression_HyExpression
            	    {
            	    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression4180);
            	    a3_0=parse_eu_hyvar_feature_expression_HyExpression();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    if (terminateParsing) {
            	    throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
            	    retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_1, a3_0, true);
            	    copyLocalizationInfos(a3_0, element);
            	    }
            	    }

            	    }


            	    if ( state.backtracking==0 ) {
            	    // expected elements (follow set)
            	    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[979]);
            	    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[980]);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[981]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[982]);
            }

            a4=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression4200); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_15_0_0_3, null, true);
            copyLocalizationInfos((CommonToken)a4, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[983]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[984]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[985]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[986]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[987]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[988]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[989]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[990]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[991]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[992]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[993]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[994]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[995]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[996]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[997]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[998]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[999]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1000]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1001]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1002]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1003]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1004]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1005]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1006]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1007]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1008]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 28, parse_eu_hyvar_feature_expression_HyIfPossibleExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyIfPossibleExpression"



    // $ANTLR start "parseop_HyValue_level_15"
    // Hyvalidityformula.g:5340:1: parseop_HyValue_level_15 returns [eu.hyvar.dataValues.HyValue element = null] : (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue );
    public final eu.hyvar.dataValues.HyValue parseop_HyValue_level_15() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parseop_HyValue_level_15_StartIndex = input.index();

        eu.hyvar.dataValues.HyNumberValue c0 =null;

        eu.hyvar.dataValues.HyBooleanValue c1 =null;

        eu.hyvar.dataValues.HyEnumValue c2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Hyvalidityformula.g:5343:0: (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue )
            int alt41=3;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
                {
                alt41=1;
                }
                break;
            case 41:
            case 45:
                {
                alt41=2;
                }
                break;
            case 39:
                {
                alt41=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }

            switch (alt41) {
                case 1 :
                    // Hyvalidityformula.g:5344:0: c0= parse_eu_hyvar_dataValues_HyNumberValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_154226);
                    c0=parse_eu_hyvar_dataValues_HyNumberValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:5345:2: c1= parse_eu_hyvar_dataValues_HyBooleanValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_154234);
                    c1=parse_eu_hyvar_dataValues_HyBooleanValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hyvalidityformula.g:5346:2: c2= parse_eu_hyvar_dataValues_HyEnumValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_154242);
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
    // Hyvalidityformula.g:5349:1: parse_eu_hyvar_dataValues_HyNumberValue returns [eu.hyvar.dataValues.HyNumberValue element = null] : (a0= INTEGER_LITERAL ) ;
    public final eu.hyvar.dataValues.HyNumberValue parse_eu_hyvar_dataValues_HyNumberValue() throws RecognitionException {
        eu.hyvar.dataValues.HyNumberValue element =  null;

        int parse_eu_hyvar_dataValues_HyNumberValue_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Hyvalidityformula.g:5352:4: ( (a0= INTEGER_LITERAL ) )
            // Hyvalidityformula.g:5353:4: (a0= INTEGER_LITERAL )
            {
            // Hyvalidityformula.g:5353:4: (a0= INTEGER_LITERAL )
            // Hyvalidityformula.g:5354:4: a0= INTEGER_LITERAL
            {
            a0=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue4266); if (state.failed) return element;

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
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1009]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1010]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1011]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1012]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1013]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1014]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1015]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1016]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1017]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1018]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1019]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1020]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1021]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1022]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1023]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1024]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1025]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1026]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1027]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1028]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1029]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1030]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1031]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1032]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1033]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1034]);
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
    // Hyvalidityformula.g:5416:1: parse_eu_hyvar_dataValues_HyBooleanValue returns [eu.hyvar.dataValues.HyBooleanValue element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.dataValues.HyBooleanValue parse_eu_hyvar_dataValues_HyBooleanValue() throws RecognitionException {
        eu.hyvar.dataValues.HyBooleanValue element =  null;

        int parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }

            // Hyvalidityformula.g:5419:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hyvalidityformula.g:5420:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hyvalidityformula.g:5420:0: ( (a0= 'true' |a1= 'false' ) )
            // Hyvalidityformula.g:5421:0: (a0= 'true' |a1= 'false' )
            {
            // Hyvalidityformula.g:5421:0: (a0= 'true' |a1= 'false' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==45) ) {
                alt42=1;
            }
            else if ( (LA42_0==41) ) {
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
                    // Hyvalidityformula.g:5422:0: a0= 'true'
                    {
                    a0=(Token)match(input,45,FOLLOW_45_in_parse_eu_hyvar_dataValues_HyBooleanValue4298); if (state.failed) return element;

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
                    // Hyvalidityformula.g:5435:2: a1= 'false'
                    {
                    a1=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_dataValues_HyBooleanValue4307); if (state.failed) return element;

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
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1035]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1036]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1037]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1038]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1039]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1040]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1041]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1042]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1043]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1044]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1045]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1046]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1047]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1048]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1049]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1050]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1051]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1052]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1053]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1054]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1055]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1056]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1057]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1058]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1059]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1060]);
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
    // Hyvalidityformula.g:5482:1: parse_eu_hyvar_dataValues_HyEnumValue returns [eu.hyvar.dataValues.HyEnumValue element = null] : a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) ) ;
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

            // Hyvalidityformula.g:5485:4: (a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) ) )
            // Hyvalidityformula.g:5486:4: a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
            {
            a0=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumValue4337); if (state.failed) return element;

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
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1061]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1062]);
            }

            // Hyvalidityformula.g:5501:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
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
                    // Hyvalidityformula.g:5502:0: (a1= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:5502:4: (a1= QUOTED_34_34 )
                    // Hyvalidityformula.g:5503:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue4352); if (state.failed) return element;

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
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1063]);
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:5543:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:5543:2: (a2= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:5544:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue4369); if (state.failed) return element;

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
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1064]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1065]);
            }

            a3=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue4387); if (state.failed) return element;

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
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1066]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1067]);
            }

            // Hyvalidityformula.g:5604:0: ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
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
                    // Hyvalidityformula.g:5605:0: (a4= QUOTED_34_34 )
                    {
                    // Hyvalidityformula.g:5605:4: (a4= QUOTED_34_34 )
                    // Hyvalidityformula.g:5606:4: a4= QUOTED_34_34
                    {
                    a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue4402); if (state.failed) return element;

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
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1068]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1069]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1070]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1071]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1072]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1073]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1074]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1075]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1076]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1077]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1078]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1079]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1080]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1081]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1082]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1083]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1084]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1085]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1086]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1087]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1088]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1089]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1090]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1091]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1092]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1093]);
                    }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:5671:2: (a5= IDENTIFIER_TOKEN )
                    {
                    // Hyvalidityformula.g:5671:2: (a5= IDENTIFIER_TOKEN )
                    // Hyvalidityformula.g:5672:4: a5= IDENTIFIER_TOKEN
                    {
                    a5=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue4419); if (state.failed) return element;

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
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1094]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1095]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1096]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1097]);
                    addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1098]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1099]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1100]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1101]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1102]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1103]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1104]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1105]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1106]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1107]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1108]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1109]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1110]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1111]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1112]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1113]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1114]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1115]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1116]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1117]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1118]);
                    addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1119]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1120]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1121]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1122]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1123]);
            addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1124]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1125]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1126]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1127]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1128]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1129]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1130]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1131]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1132]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1133]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1134]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1135]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1136]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1137]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1138]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1139]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1140]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1141]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1142]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1143]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1144]);
            addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1145]);
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



    // $ANTLR start "parse_eu_hyvar_context_contextValidity_HyValidityFormula"
    // Hyvalidityformula.g:5769:1: parse_eu_hyvar_context_contextValidity_HyValidityFormula returns [eu.hyvar.context.contextValidity.HyValidityFormula element = null] : c= parseop_HyValidityFormula_level_15 ;
    public final eu.hyvar.context.contextValidity.HyValidityFormula parse_eu_hyvar_context_contextValidity_HyValidityFormula() throws RecognitionException {
        eu.hyvar.context.contextValidity.HyValidityFormula element =  null;

        int parse_eu_hyvar_context_contextValidity_HyValidityFormula_StartIndex = input.index();

        eu.hyvar.context.contextValidity.HyValidityFormula c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return element; }

            // Hyvalidityformula.g:5770:3: (c= parseop_HyValidityFormula_level_15 )
            // Hyvalidityformula.g:5771:3: c= parseop_HyValidityFormula_level_15
            {
            pushFollow(FOLLOW_parseop_HyValidityFormula_level_15_in_parse_eu_hyvar_context_contextValidity_HyValidityFormula4448);
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
            if ( state.backtracking>0 ) { memoize(input, 33, parse_eu_hyvar_context_contextValidity_HyValidityFormula_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_context_contextValidity_HyValidityFormula"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyExpression"
    // Hyvalidityformula.g:5775:1: parse_eu_hyvar_feature_expression_HyExpression returns [eu.hyvar.feature.expression.HyExpression element = null] : c= parseop_HyExpression_level_0 ;
    public final eu.hyvar.feature.expression.HyExpression parse_eu_hyvar_feature_expression_HyExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyExpression_StartIndex = input.index();

        eu.hyvar.feature.expression.HyExpression c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return element; }

            // Hyvalidityformula.g:5776:3: (c= parseop_HyExpression_level_0 )
            // Hyvalidityformula.g:5777:3: c= parseop_HyExpression_level_0
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression4467);
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
            if ( state.backtracking>0 ) { memoize(input, 34, parse_eu_hyvar_feature_expression_HyExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyVersionRestriction"
    // Hyvalidityformula.g:5781:1: parse_eu_hyvar_feature_expression_HyVersionRestriction returns [eu.hyvar.feature.expression.HyVersionRestriction element = null] : (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction );
    public final eu.hyvar.feature.expression.HyVersionRestriction parse_eu_hyvar_feature_expression_HyVersionRestriction() throws RecognitionException {
        eu.hyvar.feature.expression.HyVersionRestriction element =  null;

        int parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex = input.index();

        eu.hyvar.feature.expression.HyRelativeVersionRestriction c0 =null;

        eu.hyvar.feature.expression.HyVersionRangeRestriction c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return element; }

            // Hyvalidityformula.g:5782:0: (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==34) ) {
                switch ( input.LA(2) ) {
                case 25:
                case 27:
                case 28:
                case 29:
                case 30:
                    {
                    alt45=1;
                    }
                    break;
                case QUOTED_34_34:
                    {
                    int LA45_3 = input.LA(3);

                    if ( (LA45_3==36) ) {
                        alt45=1;
                    }
                    else if ( (LA45_3==20) ) {
                        alt45=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 3, input);

                        throw nvae;

                    }
                    }
                    break;
                case 37:
                    {
                    alt45=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }
            switch (alt45) {
                case 1 :
                    // Hyvalidityformula.g:5783:0: c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction4486);
                    c0=parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyvalidityformula.g:5784:2: c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction4494);
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
            if ( state.backtracking>0 ) { memoize(input, 35, parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyVersionRestriction"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyValue"
    // Hyvalidityformula.g:5788:1: parse_eu_hyvar_dataValues_HyValue returns [eu.hyvar.dataValues.HyValue element = null] : c= parseop_HyValue_level_15 ;
    public final eu.hyvar.dataValues.HyValue parse_eu_hyvar_dataValues_HyValue() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parse_eu_hyvar_dataValues_HyValue_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return element; }

            // Hyvalidityformula.g:5789:3: (c= parseop_HyValue_level_15 )
            // Hyvalidityformula.g:5790:3: c= parseop_HyValue_level_15
            {
            pushFollow(FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue4513);
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

    // $ANTLR start synpred55_Hyvalidityformula
    public final void synpred55_Hyvalidityformula_fragment() throws RecognitionException {
        eu.hyvar.feature.expression.HyValueExpression c5 =null;


        // Hyvalidityformula.g:3963:2: (c5= parse_eu_hyvar_feature_expression_HyValueExpression )
        // Hyvalidityformula.g:3963:2: c5= parse_eu_hyvar_feature_expression_HyValueExpression
        {
        pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_synpred55_Hyvalidityformula3555);
        c5=parse_eu_hyvar_feature_expression_HyValueExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred55_Hyvalidityformula

    // $ANTLR start synpred56_Hyvalidityformula
    public final void synpred56_Hyvalidityformula_fragment() throws RecognitionException {
        eu.hyvar.feature.expression.HyBooleanValueExpression c6 =null;


        // Hyvalidityformula.g:3964:2: (c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression )
        // Hyvalidityformula.g:3964:2: c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression
        {
        pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_synpred56_Hyvalidityformula3563);
        c6=parse_eu_hyvar_feature_expression_HyBooleanValueExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred56_Hyvalidityformula

    // Delegated rules

    public final boolean synpred56_Hyvalidityformula() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_Hyvalidityformula_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_Hyvalidityformula() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_Hyvalidityformula_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_parse_eu_hyvar_context_contextValidity_HyValidityModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_context_contextValidity_HyValidityFormula_in_parse_eu_hyvar_context_contextValidity_HyValidityModel124 = new BitSet(new long[]{0x0000000000000222L});
    public static final BitSet FOLLOW_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction165 = new BitSet(new long[]{0x000000007A000200L});
    public static final BitSet FOLLOW_25_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction188 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction203 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction218 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction233 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction248 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction273 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction323 = new BitSet(new long[]{0x0000002000000200L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction346 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction371 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction392 = new BitSet(new long[]{0x0000002000000200L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction415 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction440 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_parse_eu_hyvar_dataValues_HyEnum490 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum508 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum529 = new BitSet(new long[]{0x0000000200010000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum558 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum599 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum633 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum707 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parse_eu_hyvar_dataValues_HyEnum730 = new BitSet(new long[]{0x0000010000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum763 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum802 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum832 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum888 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum927 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_dataValues_HyEnum960 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum983 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1013 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_dataValues_HyEnum1065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnumLiteral1113 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral1131 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnumLiteral1152 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral1170 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral1191 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parse_eu_hyvar_dataValues_HyEnumLiteral1214 = new BitSet(new long[]{0x0000010000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1247 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1286 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1316 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1372 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1411 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_dataValues_HyEnumLiteral1434 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_dataValues_HyEnumLiteral1467 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1490 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1520 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_dataValues_HyEnumLiteral1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula_in_parseop_HyValidityFormula_level_151620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula_in_parseop_HyValidityFormula_level_151630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1662 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1700 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1734 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1752 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1779 = new BitSet(new long[]{0x0000010000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1812 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1851 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1881 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1937 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1976 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula1999 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2032 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2055 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2085 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula2137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2194 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2232 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2266 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2284 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2305 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2323 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2350 = new BitSet(new long[]{0x0000010000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2383 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2422 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2452 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2508 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2547 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2570 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2603 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2626 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2656 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula2708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02756 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_parseop_HyExpression_level_02776 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02793 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_12839 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_parseop_HyExpression_level_12855 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_12869 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_42910 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_parseop_HyExpression_level_42923 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_42934 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_52972 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_parseop_HyExpression_level_52985 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_52996 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_93034 = new BitSet(new long[]{0x000000007A002002L});
    public static final BitSet FOLLOW_25_in_parseop_HyExpression_level_93047 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_93058 = new BitSet(new long[]{0x000000007A002002L});
    public static final BitSet FOLLOW_27_in_parseop_HyExpression_level_93076 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_93087 = new BitSet(new long[]{0x000000007A002002L});
    public static final BitSet FOLLOW_29_in_parseop_HyExpression_level_93105 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_93116 = new BitSet(new long[]{0x000000007A002002L});
    public static final BitSet FOLLOW_30_in_parseop_HyExpression_level_93134 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_93145 = new BitSet(new long[]{0x000000007A002002L});
    public static final BitSet FOLLOW_28_in_parseop_HyExpression_level_93163 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_93174 = new BitSet(new long[]{0x000000007A002002L});
    public static final BitSet FOLLOW_13_in_parseop_HyExpression_level_93192 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_93203 = new BitSet(new long[]{0x000000007A002002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_123241 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_20_in_parseop_HyExpression_level_123254 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_123265 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_18_in_parseop_HyExpression_level_123283 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_123294 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_133332 = new BitSet(new long[]{0x0000000800820002L});
    public static final BitSet FOLLOW_35_in_parseop_HyExpression_level_133345 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_133356 = new BitSet(new long[]{0x0000000800820002L});
    public static final BitSet FOLLOW_17_in_parseop_HyExpression_level_133374 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_133385 = new BitSet(new long[]{0x0000000800820002L});
    public static final BitSet FOLLOW_23_in_parseop_HyExpression_level_133403 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_133414 = new BitSet(new long[]{0x0000000800820002L});
    public static final BitSet FOLLOW_12_in_parseop_HyExpression_level_143452 = new BitSet(new long[]{0x00003EC080008260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parseop_HyExpression_level_143472 = new BitSet(new long[]{0x00003EC080008260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_153515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_153523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_153531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyExpression_level_153539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyExpression_level_153547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyExpression_level_153555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_153563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyMinimumExpression_in_parseop_HyExpression_level_153571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyMaximumExpression_in_parseop_HyExpression_level_153579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyIfPossibleExpression_in_parseop_HyExpression_level_153587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedExpression3609 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression3622 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression3634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3664 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3681 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3740 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3755 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3772 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3819 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3888 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3905 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3923 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression3966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression4006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_eu_hyvar_feature_expression_HyMinimumExpression4036 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMinimumExpression4049 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyMinimumExpression4061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_parse_eu_hyvar_feature_expression_HyMaximumExpression4087 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMaximumExpression4100 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyMaximumExpression4112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression4138 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression4151 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression4167 = new BitSet(new long[]{0x00003EC080109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression4180 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression4200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_154226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_154234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_154242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue4266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_parse_eu_hyvar_dataValues_HyBooleanValue4298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_dataValues_HyBooleanValue4307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumValue4337 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue4352 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue4369 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue4387 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue4402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue4419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyValidityFormula_level_15_in_parse_eu_hyvar_context_contextValidity_HyValidityFormula4448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression4467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction4486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction4494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue4513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_synpred55_Hyvalidityformula3555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_synpred56_Hyvalidityformula3563 = new BitSet(new long[]{0x0000000000000002L});

}