// $ANTLR 3.4

	package eu.hyvar.feature.mapping.resource.hymapping.mopp;
	
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
public class HymappingParser extends HymappingANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DATE", "IDENTIFIER_TOKEN", "INTEGER_LITERAL", "LINEBREAK", "ML_COMMENT", "QUOTED_34_34", "QUOTED_6060_6262", "SL_COMMENT", "WHITESPACE", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'->'", "'.'", "'/'", "':'", "'<'", "'<->'", "'<='", "'='", "'>'", "'>='", "'?'", "'Enum('", "'EnumLiteral('", "'['", "'\\u0025'", "']'", "'^'", "'enum:'", "'eternity'", "'false'", "'true'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
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
    public static final int QUOTED_6060_6262=10;
    public static final int SL_COMMENT=11;
    public static final int WHITESPACE=12;

    // delegates
    public HymappingANTLRParserBase[] getDelegates() {
        return new HymappingANTLRParserBase[] {};
    }

    // delegators


    public HymappingParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public HymappingParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(102 + 1);
         

    }

    public String[] getTokenNames() { return HymappingParser.tokenNames; }
    public String getGrammarFileName() { return "Hymapping.g"; }


    	private eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolverFactory tokenResolverFactory = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTokenResolverFactory();
    	
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
    	private List<eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal> expectedElements = new ArrayList<eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal>();
    	
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
    	
    	private eu.hyvar.feature.mapping.resource.hymapping.IHymappingLocationMap locationMap;
    	
    	private eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingSyntaxErrorMessageConverter syntaxErrorMessageConverter = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingSyntaxErrorMessageConverter(tokenNames);
    	
    	@Override
    	public void reportError(RecognitionException re) {
    		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
    	}
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new eu.hyvar.feature.mapping.resource.hymapping.IHymappingCommand<eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource>() {
    			public boolean execute(eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new eu.hyvar.feature.mapping.resource.hymapping.IHymappingProblem() {
    					public eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemSeverity getSeverity() {
    						return eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemSeverity.ERROR;
    					}
    					public eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemType getType() {
    						return eu.hyvar.feature.mapping.resource.hymapping.HymappingEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	protected void addErrorToResource(eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLocalizedMessage message) {
    		if (message == null) {
    			return;
    		}
    		addErrorToResource(message.getMessage(), message.getColumn(), message.getLine(), message.getCharStart(), message.getCharEnd());
    	}
    	
    	public void addExpectedElement(EClass eClass, int expectationStartIndex, int expectationEndIndex) {
    		for (int expectationIndex = expectationStartIndex; expectationIndex <= expectationEndIndex; expectationIndex++) {
    			addExpectedElement(eClass, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[expectationIndex]);
    		}
    	}
    	
    	public void addExpectedElement(EClass eClass, int expectationIndex) {
    		addExpectedElement(eClass, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[expectationIndex]);
    	}
    	
    	public void addExpectedElement(EClass eClass, int[] ids) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		int terminalID = ids[0];
    		int followSetID = ids[1];
    		eu.hyvar.feature.mapping.resource.hymapping.IHymappingExpectedElement terminal = eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingFollowSetProvider.TERMINALS[terminalID];
    		eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContainedFeature[] containmentFeatures = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingFollowSetProvider.LINKS[ids[i]];
    		}
    		eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainmentTrace containmentTrace = new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainmentTrace(eClass, containmentFeatures);
    		EObject container = getLastIncompleteElement();
    		eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal expectedElement = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		final eu.hyvar.feature.mapping.resource.hymapping.IHymappingLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.feature.mapping.resource.hymapping.IHymappingCommand<eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource>() {
    			public boolean execute(eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource resource) {
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
    		final eu.hyvar.feature.mapping.resource.hymapping.IHymappingLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.feature.mapping.resource.hymapping.IHymappingCommand<eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource>() {
    			public boolean execute(eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource resource) {
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
    	protected void setLocalizationEnd(Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingCommand<eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		final eu.hyvar.feature.mapping.resource.hymapping.IHymappingLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.feature.mapping.resource.hymapping.IHymappingCommand<eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource>() {
    			public boolean execute(eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource resource) {
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextParser createInstance(InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new HymappingParser(new CommonTokenStream(new HymappingLexer(new ANTLRInputStream(actualInputStream))));
    			} else {
    				return new HymappingParser(new CommonTokenStream(new HymappingLexer(new ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (IOException e) {
    			new eu.hyvar.feature.mapping.resource.hymapping.util.HymappingRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public HymappingParser() {
    		super(null);
    	}
    	
    	protected EObject doParse() throws RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((HymappingLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((HymappingLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof EClass) {
    			EClass type = (EClass) typeObject;
    			if (type.getInstanceClass() == eu.hyvar.feature.mapping.HyMappingModel.class) {
    				return parse_eu_hyvar_feature_mapping_HyMappingModel();
    			}
    			if (type.getInstanceClass() == org.deltaecore.core.decore.DEDeltaInvokation.class) {
    				return parse_org_deltaecore_core_decore_DEDeltaInvokation();
    			}
    			if (type.getInstanceClass() == eu.hyvar.feature.mapping.HyMapping.class) {
    				return parse_eu_hyvar_feature_mapping_HyMapping();
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
    		throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(eu.hyvar.feature.mapping.resource.hymapping.IHymappingOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingParseResult parse() {
    		// Reset parser state
    		terminateParsing = false;
    		postParseCommands = new ArrayList<eu.hyvar.feature.mapping.resource.hymapping.IHymappingCommand<eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource>>();
    		eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingParseResult parseResult = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingParseResult();
    		if (disableLocationMap) {
    			locationMap = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingDevNullLocationMap();
    		} else {
    			locationMap = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLocationMap();
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
    	
    	public List<eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal> parseToExpectedElements(EClass type, eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
    		eu.hyvar.feature.mapping.resource.hymapping.IHymappingParseResult result = parse();
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
    			for (eu.hyvar.feature.mapping.resource.hymapping.IHymappingCommand<eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		Set<eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal> currentFollowSet = new LinkedHashSet<eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal>();
    		List<eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal> newFollowSet = new ArrayList<eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 127;
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
    				for (eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						Collection<eu.hyvar.feature.mapping.resource.hymapping.util.HymappingPair<eu.hyvar.feature.mapping.resource.hymapping.IHymappingExpectedElement, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (eu.hyvar.feature.mapping.resource.hymapping.util.HymappingPair<eu.hyvar.feature.mapping.resource.hymapping.IHymappingExpectedElement, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContainedFeature[]> newFollowerPair : newFollowers) {
    							eu.hyvar.feature.mapping.resource.hymapping.IHymappingExpectedElement newFollower = newFollowerPair.getLeft();
    							EObject container = getLastIncompleteElement();
    							eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainmentTrace containmentTrace = new eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainmentTrace(null, newFollowerPair.getRight());
    							eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal newFollowTerminal = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectedTerminal expectedElement, int tokenIndex) {
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
    // Hymapping.g:503:1: start returns [ EObject element = null] : (c0= parse_eu_hyvar_feature_mapping_HyMappingModel ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        eu.hyvar.feature.mapping.HyMappingModel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Hymapping.g:504:2: ( (c0= parse_eu_hyvar_feature_mapping_HyMappingModel ) EOF )
            // Hymapping.g:505:2: (c0= parse_eu_hyvar_feature_mapping_HyMappingModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 0, 454);
            		expectedElementsIndexOfLastCompleteElement = 454;
            	}

            // Hymapping.g:510:2: (c0= parse_eu_hyvar_feature_mapping_HyMappingModel )
            // Hymapping.g:511:3: c0= parse_eu_hyvar_feature_mapping_HyMappingModel
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_mapping_HyMappingModel_in_start82);
            c0=parse_eu_hyvar_feature_mapping_HyMappingModel();

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



    // $ANTLR start "parse_eu_hyvar_feature_mapping_HyMappingModel"
    // Hymapping.g:519:1: parse_eu_hyvar_feature_mapping_HyMappingModel returns [eu.hyvar.feature.mapping.HyMappingModel element = null] : ( ( (a0_0= parse_eu_hyvar_feature_mapping_HyMapping ) ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )* ) )? ;
    public final eu.hyvar.feature.mapping.HyMappingModel parse_eu_hyvar_feature_mapping_HyMappingModel() throws RecognitionException {
        eu.hyvar.feature.mapping.HyMappingModel element =  null;

        int parse_eu_hyvar_feature_mapping_HyMappingModel_StartIndex = input.index();

        eu.hyvar.feature.mapping.HyMapping a0_0 =null;

        eu.hyvar.feature.mapping.HyMapping a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Hymapping.g:522:2: ( ( ( (a0_0= parse_eu_hyvar_feature_mapping_HyMapping ) ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )* ) )? )
            // Hymapping.g:523:2: ( ( (a0_0= parse_eu_hyvar_feature_mapping_HyMapping ) ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )* ) )?
            {
            // Hymapping.g:523:2: ( ( (a0_0= parse_eu_hyvar_feature_mapping_HyMapping ) ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )* ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IDENTIFIER_TOKEN||LA2_0==QUOTED_34_34||LA2_0==13||LA2_0==16||LA2_0==32||(LA2_0 >= 41 && LA2_0 <= 42)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Hymapping.g:524:3: ( (a0_0= parse_eu_hyvar_feature_mapping_HyMapping ) ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )* )
                    {
                    // Hymapping.g:524:3: ( (a0_0= parse_eu_hyvar_feature_mapping_HyMapping ) ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )* )
                    // Hymapping.g:525:4: (a0_0= parse_eu_hyvar_feature_mapping_HyMapping ) ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )*
                    {
                    // Hymapping.g:525:4: (a0_0= parse_eu_hyvar_feature_mapping_HyMapping )
                    // Hymapping.g:526:5: a0_0= parse_eu_hyvar_feature_mapping_HyMapping
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_mapping_HyMapping_in_parse_eu_hyvar_feature_mapping_HyMappingModel130);
                    a0_0=parse_eu_hyvar_feature_mapping_HyMapping();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMappingModel();
                    						startIncompleteElement(element);
                    					}
                    					if (a0_0 != null) {
                    						if (a0_0 != null) {
                    							Object value = a0_0;
                    							addObjectToList(element, eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING_MODEL__MAPPINGS, value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_0_0_0_0_0_0_0, a0_0, true);
                    						copyLocalizationInfos(a0_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 455, 909);
                    			}

                    // Hymapping.g:551:4: ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==IDENTIFIER_TOKEN||LA1_0==QUOTED_34_34||LA1_0==13||LA1_0==16||LA1_0==32||(LA1_0 >= 41 && LA1_0 <= 42)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // Hymapping.g:552:5: ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) )
                    	    {
                    	    // Hymapping.g:552:5: ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) )
                    	    // Hymapping.g:553:6: (a1_0= parse_eu_hyvar_feature_mapping_HyMapping )
                    	    {
                    	    // Hymapping.g:553:6: (a1_0= parse_eu_hyvar_feature_mapping_HyMapping )
                    	    // Hymapping.g:554:7: a1_0= parse_eu_hyvar_feature_mapping_HyMapping
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_feature_mapping_HyMapping_in_parse_eu_hyvar_feature_mapping_HyMappingModel179);
                    	    a1_0=parse_eu_hyvar_feature_mapping_HyMapping();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    							if (terminateParsing) {
                    	    								throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                    	    							}
                    	    							if (element == null) {
                    	    								element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMappingModel();
                    	    								startIncompleteElement(element);
                    	    							}
                    	    							if (a1_0 != null) {
                    	    								if (a1_0 != null) {
                    	    									Object value = a1_0;
                    	    									addObjectToList(element, eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING_MODEL__MAPPINGS, value);
                    	    									completedElement(value, true);
                    	    								}
                    	    								collectHiddenTokens(element);
                    	    								retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_0_0_0_0_0_0_1_0_0_2, a1_0, true);
                    	    								copyLocalizationInfos(a1_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						// We've found the last token for this rule. The constructed EObject is now
                    	    						// complete.
                    	    						completedElement(element, true);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 910, 1364);
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
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 1365, 1819);
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
            if ( state.backtracking>0 ) { memoize(input, 2, parse_eu_hyvar_feature_mapping_HyMappingModel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_mapping_HyMappingModel"



    // $ANTLR start "parse_org_deltaecore_core_decore_DEDeltaInvokation"
    // Hymapping.g:603:1: parse_org_deltaecore_core_decore_DEDeltaInvokation returns [org.deltaecore.core.decore.DEDeltaInvokation element = null] : (a0= QUOTED_6060_6262 ) ;
    public final org.deltaecore.core.decore.DEDeltaInvokation parse_org_deltaecore_core_decore_DEDeltaInvokation() throws RecognitionException {
        org.deltaecore.core.decore.DEDeltaInvokation element =  null;

        int parse_org_deltaecore_core_decore_DEDeltaInvokation_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Hymapping.g:606:2: ( (a0= QUOTED_6060_6262 ) )
            // Hymapping.g:607:2: (a0= QUOTED_6060_6262 )
            {
            // Hymapping.g:607:2: (a0= QUOTED_6060_6262 )
            // Hymapping.g:608:3: a0= QUOTED_6060_6262
            {
            a0=(Token)match(input,QUOTED_6060_6262,FOLLOW_QUOTED_6060_6262_in_parse_org_deltaecore_core_decore_DEDeltaInvokation272); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.deltaecore.core.decore.DEcoreFactory.eINSTANCE.createDEDeltaInvokation();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_6060_6262");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.deltaecore.core.decore.DEcorePackage.DE_DELTA_INVOKATION__DELTA), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				org.deltaecore.core.decore.DEDelta proxy = org.deltaecore.core.decore.DEcoreFactory.eINSTANCE.createDEDelta();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<org.deltaecore.core.decore.DEDeltaInvokation, org.deltaecore.core.decore.DEDelta>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getDEDeltaInvokationDeltaReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.deltaecore.core.decore.DEcorePackage.DE_DELTA_INVOKATION__DELTA), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(org.deltaecore.core.decore.DEcorePackage.DE_DELTA_INVOKATION__DELTA), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_1_0_0_0, proxy, true);
            				copyLocalizationInfos((CommonToken) a0, element);
            				copyLocalizationInfos((CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		// We've found the last token for this rule. The constructed EObject is now
            		// complete.
            		completedElement(element, true);
            		addExpectedElement(null, 1820, 1821);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 1822, 2276);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_deltaecore_core_decore_DEDeltaInvokation_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_deltaecore_core_decore_DEDeltaInvokation"



    // $ANTLR start "parse_eu_hyvar_feature_mapping_HyMapping"
    // Hymapping.g:653:1: parse_eu_hyvar_feature_mapping_HyMapping returns [eu.hyvar.feature.mapping.HyMapping element = null] : (a0_0= parse_eu_hyvar_feature_expression_HyExpression ) a1= ':' (a2_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) ( (a3= ',' (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) ) )* ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
    public final eu.hyvar.feature.mapping.HyMapping parse_eu_hyvar_feature_mapping_HyMapping() throws RecognitionException {
        eu.hyvar.feature.mapping.HyMapping element =  null;

        int parse_eu_hyvar_feature_mapping_HyMapping_StartIndex = input.index();

        Token a1=null;
        Token a3=null;
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
        eu.hyvar.feature.expression.HyExpression a0_0 =null;

        org.deltaecore.core.decore.DEDeltaInvokation a2_0 =null;

        org.deltaecore.core.decore.DEDeltaInvokation a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Hymapping.g:656:2: ( (a0_0= parse_eu_hyvar_feature_expression_HyExpression ) a1= ':' (a2_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) ( (a3= ',' (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) ) )* ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hymapping.g:657:2: (a0_0= parse_eu_hyvar_feature_expression_HyExpression ) a1= ':' (a2_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) ( (a3= ',' (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) ) )* ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            // Hymapping.g:657:2: (a0_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hymapping.g:658:3: a0_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_mapping_HyMapping312);
            a0_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__EXPRESSION), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 2277);
            	}

            a1=(Token)match(input,25,FOLLOW_25_in_parse_eu_hyvar_feature_mapping_HyMapping330); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping(), 2278);
            	}

            // Hymapping.g:697:2: (a2_0= parse_org_deltaecore_core_decore_DEDeltaInvokation )
            // Hymapping.g:698:3: a2_0= parse_org_deltaecore_core_decore_DEDeltaInvokation
            {
            pushFollow(FOLLOW_parse_org_deltaecore_core_decore_DEDeltaInvokation_in_parse_eu_hyvar_feature_mapping_HyMapping348);
            a2_0=parse_org_deltaecore_core_decore_DEDeltaInvokation();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
            				startIncompleteElement(element);
            			}
            			if (a2_0 != null) {
            				if (a2_0 != null) {
            					Object value = a2_0;
            					addObjectToList(element, eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__DELTA_INVOKATIONS, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_4, a2_0, true);
            				copyLocalizationInfos(a2_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 2279, 2280);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 2281, 2735);
            	}

            // Hymapping.g:724:2: ( (a3= ',' (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==20) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Hymapping.g:725:3: (a3= ',' (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) )
            	    {
            	    // Hymapping.g:725:3: (a3= ',' (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) )
            	    // Hymapping.g:726:4: a3= ',' (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation )
            	    {
            	    a3=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_feature_mapping_HyMapping375); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_5_0_0_0, null, true);
            	    				copyLocalizationInfos((CommonToken)a3, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping(), 2736);
            	    			}

            	    // Hymapping.g:740:4: (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation )
            	    // Hymapping.g:741:5: a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation
            	    {
            	    pushFollow(FOLLOW_parse_org_deltaecore_core_decore_DEDeltaInvokation_in_parse_eu_hyvar_feature_mapping_HyMapping401);
            	    a4_0=parse_org_deltaecore_core_decore_DEDeltaInvokation();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a4_0 != null) {
            	    						if (a4_0 != null) {
            	    							Object value = a4_0;
            	    							addObjectToList(element, eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__DELTA_INVOKATIONS, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_5_0_0_2, a4_0, true);
            	    						copyLocalizationInfos(a4_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, 2737, 2738);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 2739, 3193);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 3194, 3195);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 3196, 3650);
            	}

            // Hymapping.g:775:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==35) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Hymapping.g:776:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hymapping.g:776:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hymapping.g:777:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_feature_mapping_HyMapping451); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 3651, 3653);
                    			}

                    // Hymapping.g:791:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) )
                    int alt4=3;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==DATE) ) {
                        int LA4_1 = input.LA(2);

                        if ( (LA4_1==21) ) {
                            int LA4_3 = input.LA(3);

                            if ( (LA4_3==DATE) ) {
                                alt4=1;
                            }
                            else if ( (LA4_3==40) ) {
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
                    else if ( (LA4_0==40) ) {
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
                            // Hymapping.g:792:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hymapping.g:792:5: (a6= DATE )
                            // Hymapping.g:793:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_feature_mapping_HyMapping484); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
                            							startIncompleteElement(element);
                            						}
                            						if (a6 != null) {
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a6).getLine(), ((CommonToken) a6).getCharPositionInLine(), ((CommonToken) a6).getStartIndex(), ((CommonToken) a6).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a6, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3654);
                            				}

                            a7=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_feature_mapping_HyMapping523); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3655);
                            				}

                            // Hymapping.g:842:5: (a8= DATE )
                            // Hymapping.g:843:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_feature_mapping_HyMapping553); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3656);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymapping.g:879:10: (a9= DATE ) a10= '-' a11= 'eternity'
                            {
                            // Hymapping.g:879:10: (a9= DATE )
                            // Hymapping.g:880:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_feature_mapping_HyMapping609); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
                            							startIncompleteElement(element);
                            						}
                            						if (a9 != null) {
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a9).getLine(), ((CommonToken) a9).getCharPositionInLine(), ((CommonToken) a9).getStartIndex(), ((CommonToken) a9).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a9, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3657);
                            				}

                            a10=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_feature_mapping_HyMapping648); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a10, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3658);
                            				}

                            a11=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_feature_mapping_HyMapping671); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a11, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3659);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymapping.g:944:10: a12= 'eternity' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_feature_mapping_HyMapping704); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3660);
                            				}

                            a13=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_feature_mapping_HyMapping727); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3661);
                            				}

                            // Hymapping.g:972:5: (a14= DATE )
                            // Hymapping.g:973:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_feature_mapping_HyMapping757); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
                            							startIncompleteElement(element);
                            						}
                            						if (a14 != null) {
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a14).getLine(), ((CommonToken) a14).getCharPositionInLine(), ((CommonToken) a14).getStartIndex(), ((CommonToken) a14).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.mapping.MappingPackage.HY_MAPPING__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a14, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3662);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 3663);
                    			}

                    a15=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_feature_mapping_HyMapping809); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a15, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				// We've found the last token for this rule. The constructed EObject is now
                    				// complete.
                    				completedElement(element, true);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 3664, 4118);
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
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 4119, 4573);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_eu_hyvar_feature_mapping_HyMapping_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_mapping_HyMapping"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression"
    // Hymapping.g:1043:1: parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression returns [eu.hyvar.feature.expression.HyArithmeticalComparisonExpression element = null] : a0= '{' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) ) (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a11= '}' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Hymapping.g:1046:2: (a0= '{' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) ) (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a11= '}' )
            // Hymapping.g:1047:2: a0= '{' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) ) (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a11= '}'
            {
            a0=(Token)match(input,43,FOLLOW_43_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression857); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(), 4574, 7507);
            	}

            // Hymapping.g:1061:2: (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression )
            // Hymapping.g:1062:3: a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression875);
            a1_0=parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
            				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 7508);
            	}

            // Hymapping.g:1087:2: ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) )
            // Hymapping.g:1088:3: (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' )
            {
            // Hymapping.g:1088:3: (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' )
            int alt6=6;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt6=1;
                }
                break;
            case 28:
                {
                alt6=2;
                }
                break;
            case 29:
                {
                alt6=3;
                }
                break;
            case 14:
                {
                alt6=4;
                }
                break;
            case 31:
                {
                alt6=5;
                }
                break;
            case 30:
                {
                alt6=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // Hymapping.g:1089:4: a2= '<'
                    {
                    a2=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression902); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_LESS_OPERATOR_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Hymapping.g:1102:8: a3= '<='
                    {
                    a3=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression917); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a3, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_LESS_OR_EQUAL_OPERATOR_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Hymapping.g:1115:8: a4= '='
                    {
                    a4=(Token)match(input,29,FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression932); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a4, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_EQUAL_OPERATOR_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 4 :
                    // Hymapping.g:1128:8: a5= '!='
                    {
                    a5=(Token)match(input,14,FOLLOW_14_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression947); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_NOT_EQUAL_OPERATOR_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 5 :
                    // Hymapping.g:1141:8: a6= '>='
                    {
                    a6=(Token)match(input,31,FOLLOW_31_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression962); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a6, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_GREATER_OR_EQUAL_OPERATOR_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 6 :
                    // Hymapping.g:1154:8: a7= '>'
                    {
                    a7=(Token)match(input,30,FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression977); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
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
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(), 7509, 10442);
            	}

            // Hymapping.g:1174:2: (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression )
            // Hymapping.g:1175:3: a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression1002);
            a10_0=parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
            				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_3, a10_0, true);
            				copyLocalizationInfos(a10_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10443);
            	}

            a11=(Token)match(input,45,FOLLOW_45_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression1020); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a11, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		// We've found the last token for this rule. The constructed EObject is now
            		// complete.
            		completedElement(element, true);
            		addExpectedElement(null, 10444, 10449);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction"
    // Hymapping.g:1219:1: parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction returns [eu.hyvar.feature.expression.HyRelativeVersionRestriction element = null] : a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Hymapping.g:1222:2: (a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' )
            // Hymapping.g:1223:2: a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']'
            {
            a0=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1049); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10450, 10451);
            	}

            // Hymapping.g:1240:2: ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? )
            // Hymapping.g:1241:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
            {
            // Hymapping.g:1241:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
            int alt7=6;
            switch ( input.LA(1) ) {
                case 26:
                    {
                    alt7=1;
                    }
                    break;
                case 28:
                    {
                    alt7=2;
                    }
                    break;
                case 29:
                    {
                    alt7=3;
                    }
                    break;
                case 31:
                    {
                    alt7=4;
                    }
                    break;
                case 30:
                    {
                    alt7=5;
                    }
                    break;
            }

            switch (alt7) {
                case 1 :
                    // Hymapping.g:1242:4: a1= '<'
                    {
                    a1=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1072); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Hymapping.g:1258:8: a2= '<='
                    {
                    a2=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1087); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Hymapping.g:1274:8: a3= '='
                    {
                    a3=(Token)match(input,29,FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1102); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a3, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 4 :
                    // Hymapping.g:1290:8: a4= '>='
                    {
                    a4=(Token)match(input,31,FOLLOW_31_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1117); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a4, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 5 :
                    // Hymapping.g:1306:8: a5= '>'
                    {
                    a5=(Token)match(input,30,FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1132); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
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
            		addExpectedElement(null, 10452);
            	}

            // Hymapping.g:1328:2: (a8= QUOTED_34_34 )
            // Hymapping.g:1329:3: a8= QUOTED_34_34
            {
            a8=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1157); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            				startIncompleteElement(element);
            				// initialize enumeration attribute
            				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            			}
            			if (a8 != null) {
            				eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyRelativeVersionRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyRelativeVersionRestrictionVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a8, element);
            				copyLocalizationInfos((CommonToken) a8, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10453);
            	}

            a9=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1178); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		// We've found the last token for this rule. The constructed EObject is now
            		// complete.
            		completedElement(element, true);
            		addExpectedElement(null, 10454, 10459);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyVersionRangeRestriction"
    // Hymapping.g:1393:1: parse_eu_hyvar_feature_expression_HyVersionRangeRestriction returns [eu.hyvar.feature.expression.HyVersionRangeRestriction element = null] : a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Hymapping.g:1396:2: (a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' )
            // Hymapping.g:1397:2: a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']'
            {
            a0=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1207); if (state.failed) return element;

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
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10460, 10461);
            	}

            // Hymapping.g:1421:2: ( (a1= '^' )? )
            // Hymapping.g:1422:3: (a1= '^' )?
            {
            // Hymapping.g:1422:3: (a1= '^' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==38) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Hymapping.g:1423:4: a1= '^'
                    {
                    a1=(Token)match(input,38,FOLLOW_38_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1230); if (state.failed) return element;

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
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_1, false, true);
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
            		addExpectedElement(null, 10462);
            	}

            // Hymapping.g:1452:2: (a3= QUOTED_34_34 )
            // Hymapping.g:1453:3: a3= QUOTED_34_34
            {
            a3=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1255); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
            				eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionLowerVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            				copyLocalizationInfos((CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10463);
            	}

            a4=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1276); if (state.failed) return element;

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
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10464, 10465);
            	}

            // Hymapping.g:1526:2: ( (a5= '^' )? )
            // Hymapping.g:1527:3: (a5= '^' )?
            {
            // Hymapping.g:1527:3: (a5= '^' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==38) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Hymapping.g:1528:4: a5= '^'
                    {
                    a5=(Token)match(input,38,FOLLOW_38_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1299); if (state.failed) return element;

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
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_4, false, true);
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
            		addExpectedElement(null, 10466);
            	}

            // Hymapping.g:1557:2: (a7= QUOTED_34_34 )
            // Hymapping.g:1558:3: a7= QUOTED_34_34
            {
            a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1324); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
            				eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionUpperVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_5, proxy, true);
            				copyLocalizationInfos((CommonToken) a7, element);
            				copyLocalizationInfos((CommonToken) a7, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10467);
            	}

            a8=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1345); if (state.failed) return element;

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
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_6, null, true);
            		copyLocalizationInfos((CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		// We've found the last token for this rule. The constructed EObject is now
            		// complete.
            		completedElement(element, true);
            		addExpectedElement(null, 10468, 10473);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyVersionRangeRestriction"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnum"
    // Hymapping.g:1636:1: parse_eu_hyvar_dataValues_HyEnum returns [eu.hyvar.dataValues.HyEnum element = null] : a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Hymapping.g:1639:2: (a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? )
            // Hymapping.g:1640:2: a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            {
            a0=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnum1374); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10474);
            	}

            // Hymapping.g:1654:2: (a1= IDENTIFIER_TOKEN )
            // Hymapping.g:1655:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum1392); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10475);
            	}

            a2=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1413); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 10476);
            		addExpectedElement(null, 10477);
            	}

            // Hymapping.g:1705:2: ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==34) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // Hymapping.g:1706:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    {
                    // Hymapping.g:1706:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    // Hymapping.g:1707:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    {
                    // Hymapping.g:1707:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    // Hymapping.g:1708:5: a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1442);
                    a3_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    						retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 10478, 10479);
                    			}

                    // Hymapping.g:1733:4: ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==20) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // Hymapping.g:1734:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    {
                    	    // Hymapping.g:1734:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    // Hymapping.g:1735:6: a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    {
                    	    a4=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1483); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((CommonToken)a4, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 10480);
                    	    					}

                    	    // Hymapping.g:1749:6: (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    // Hymapping.g:1750:7: a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1517);
                    	    a5_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    							if (terminateParsing) {
                    	    								throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    								retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_1, a5_0, true);
                    	    								copyLocalizationInfos(a5_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, 10481, 10482);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 10483, 10484);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10485);
            	}

            a6=(Token)match(input,17,FOLLOW_17_in_parse_eu_hyvar_dataValues_HyEnum1591); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10486);
            	}

            // Hymapping.g:1803:2: ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==35) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Hymapping.g:1804:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    {
                    // Hymapping.g:1804:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    // Hymapping.g:1805:4: a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']'
                    {
                    a7=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnum1614); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a7, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 10487, 10489);
                    			}

                    // Hymapping.g:1819:4: ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) )
                    int alt12=3;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==DATE) ) {
                        int LA12_1 = input.LA(2);

                        if ( (LA12_1==21) ) {
                            int LA12_3 = input.LA(3);

                            if ( (LA12_3==DATE) ) {
                                alt12=1;
                            }
                            else if ( (LA12_3==37) ) {
                                alt12=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 12, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 12, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA12_0==40) ) {
                        alt12=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;

                    }
                    switch (alt12) {
                        case 1 :
                            // Hymapping.g:1820:5: (a8= DATE ) a9= '-' (a10= DATE )
                            {
                            // Hymapping.g:1820:5: (a8= DATE )
                            // Hymapping.g:1821:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1647); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10490);
                            				}

                            a9=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum1686); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10491);
                            				}

                            // Hymapping.g:1870:5: (a10= DATE )
                            // Hymapping.g:1871:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1716); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a10 != null) {
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a10, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10492);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymapping.g:1907:10: (a11= DATE ) a12= '-'
                            {
                            // Hymapping.g:1907:10: (a11= DATE )
                            // Hymapping.g:1908:6: a11= DATE
                            {
                            a11=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1772); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a11 != null) {
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a11, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10493);
                            				}

                            a12=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum1811); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10494);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymapping.g:1958:10: a13= 'eternity' a14= '-' (a15= DATE )
                            {
                            a13=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_dataValues_HyEnum1844); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10495);
                            				}

                            a14=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum1867); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a14, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10496);
                            				}

                            // Hymapping.g:1986:5: (a15= DATE )
                            // Hymapping.g:1987:6: a15= DATE
                            {
                            a15=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1897); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a15 != null) {
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a15, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10497);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 10498);
                    			}

                    a16=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_dataValues_HyEnum1949); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
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
            if ( state.backtracking>0 ) { memoize(input, 8, parse_eu_hyvar_dataValues_HyEnum_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnum"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumLiteral"
    // Hymapping.g:2055:1: parse_eu_hyvar_dataValues_HyEnumLiteral returns [eu.hyvar.dataValues.HyEnumLiteral element = null] : a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Hymapping.g:2058:2: (a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hymapping.g:2059:2: a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            a0=(Token)match(input,34,FOLLOW_34_in_parse_eu_hyvar_dataValues_HyEnumLiteral1997); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10499);
            	}

            // Hymapping.g:2073:2: (a1= IDENTIFIER_TOKEN )
            // Hymapping.g:2074:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral2015); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10500);
            	}

            a2=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral2036); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10501);
            	}

            // Hymapping.g:2123:2: (a3= INTEGER_LITERAL )
            // Hymapping.g:2124:3: a3= INTEGER_LITERAL
            {
            a3=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral2054); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_3, resolved, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10502);
            	}

            a4=(Token)match(input,17,FOLLOW_17_in_parse_eu_hyvar_dataValues_HyEnumLiteral2075); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 10503, 10505);
            	}

            // Hymapping.g:2173:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==35) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // Hymapping.g:2174:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hymapping.g:2174:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hymapping.g:2175:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnumLiteral2098); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 10506, 10508);
                    			}

                    // Hymapping.g:2189:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) )
                    int alt14=3;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==DATE) ) {
                        int LA14_1 = input.LA(2);

                        if ( (LA14_1==21) ) {
                            int LA14_3 = input.LA(3);

                            if ( (LA14_3==DATE) ) {
                                alt14=1;
                            }
                            else if ( (LA14_3==40) ) {
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
                    else if ( (LA14_0==40) ) {
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
                            // Hymapping.g:2190:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hymapping.g:2190:5: (a6= DATE )
                            // Hymapping.g:2191:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2131); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a6 != null) {
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a6, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10509);
                            				}

                            a7=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral2170); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10510);
                            				}

                            // Hymapping.g:2240:5: (a8= DATE )
                            // Hymapping.g:2241:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2200); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10511);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymapping.g:2277:10: (a9= DATE ) a10= '-' a11= 'eternity'
                            {
                            // Hymapping.g:2277:10: (a9= DATE )
                            // Hymapping.g:2278:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2256); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a9 != null) {
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a9, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10512);
                            				}

                            a10=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral2295); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a10, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10513);
                            				}

                            a11=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_dataValues_HyEnumLiteral2318); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a11, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10514);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymapping.g:2342:10: a12= 'eternity' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_dataValues_HyEnumLiteral2351); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10515);
                            				}

                            a13=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral2374); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10516);
                            				}

                            // Hymapping.g:2370:5: (a14= DATE )
                            // Hymapping.g:2371:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2404); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a14 != null) {
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a14, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 10517);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 10518);
                    			}

                    a15=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_dataValues_HyEnumLiteral2456); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a15, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				// We've found the last token for this rule. The constructed EObject is now
                    				// complete.
                    				completedElement(element, true);
                    				addExpectedElement(null, 10519, 10520);
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
            		addExpectedElement(null, 10521, 10522);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_eu_hyvar_dataValues_HyEnumLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumLiteral"



    // $ANTLR start "parseop_HyExpression_level_0"
    // Hymapping.g:2441:1: parseop_HyExpression_level_0 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_0() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_0_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Hymapping.g:2444:2: (leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) )
            // Hymapping.g:2445:2: leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02504);
            leftArg=parseop_HyExpression_level_1();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:2445:41: ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            else if ( (LA17_0==17||LA17_0==25) ) {
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
                    // Hymapping.g:2445:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    {
                    // Hymapping.g:2445:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==27) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // Hymapping.g:2446:3: () a0= '<->' rightArg= parseop_HyExpression_level_1
                    	    {
                    	    // Hymapping.g:2446:3: ()
                    	    // Hymapping.g:2446:4: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,27,FOLLOW_27_in_parseop_HyExpression_level_02524); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    			if (element == null) {
                    	    				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyEquivalenceExpression();
                    	    				startIncompleteElement(element);
                    	    			}
                    	    			collectHiddenTokens(element);
                    	    			retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_0_0_0_1, null, true);
                    	    			copyLocalizationInfos((CommonToken)a0, element);
                    	    		}

                    	    if ( state.backtracking==0 ) {
                    	    			// expected elements (follow set)
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), 10523, 10977);
                    	    		}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02541);
                    	    rightArg=parseop_HyExpression_level_1();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    			if (terminateParsing) {
                    	    				throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_0_0_0_0, leftArg, true);
                    	    				copyLocalizationInfos(leftArg, element);
                    	    			}
                    	    		}

                    	    if ( state.backtracking==0 ) {
                    	    			if (terminateParsing) {
                    	    				throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_0_0_0_2, rightArg, true);
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
                    // Hymapping.g:2501:21: 
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
    // Hymapping.g:2506:1: parseop_HyExpression_level_1 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_2 ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_1() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_1_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Hymapping.g:2509:9: (leftArg= parseop_HyExpression_level_2 ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |) )
            // Hymapping.g:2510:9: leftArg= parseop_HyExpression_level_2 ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_12587);
            leftArg=parseop_HyExpression_level_2();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:2510:39: ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |)
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==22) ) {
                alt19=1;
            }
            else if ( (LA19_0==EOF||LA19_0==17||LA19_0==25||LA19_0==27) ) {
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
                    // Hymapping.g:2510:40: ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+
                    {
                    // Hymapping.g:2510:40: ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==22) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // Hymapping.g:2511:2: () a0= '->' rightArg= parseop_HyExpression_level_2
                    	    {
                    	    // Hymapping.g:2511:2: ()
                    	    // Hymapping.g:2511:3: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,22,FOLLOW_22_in_parseop_HyExpression_level_12603); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    		if (element == null) {
                    	    			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyImpliesExpression();
                    	    			startIncompleteElement(element);
                    	    		}
                    	    		collectHiddenTokens(element);
                    	    		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_1_0_0_1, null, true);
                    	    		copyLocalizationInfos((CommonToken)a0, element);
                    	    	}

                    	    if ( state.backtracking==0 ) {
                    	    		// expected elements (follow set)
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), 10978, 11432);
                    	    	}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_12617);
                    	    rightArg=parseop_HyExpression_level_2();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    		if (terminateParsing) {
                    	    			throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    			retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_1_0_0_0, leftArg, true);
                    	    			copyLocalizationInfos(leftArg, element);
                    	    		}
                    	    	}

                    	    if ( state.backtracking==0 ) {
                    	    		if (terminateParsing) {
                    	    			throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    			retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_1_0_0_2, rightArg, true);
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
                    // Hymapping.g:2566:20: 
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



    // $ANTLR start "parseop_HyExpression_level_2"
    // Hymapping.g:2571:1: parseop_HyExpression_level_2 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_3 ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_2() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_2_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Hymapping.g:2574:9: (leftArg= parseop_HyExpression_level_3 ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |) )
            // Hymapping.g:2575:9: leftArg= parseop_HyExpression_level_3 ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_22658);
            leftArg=parseop_HyExpression_level_3();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:2575:39: ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |)
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==44) ) {
                alt21=1;
            }
            else if ( (LA21_0==EOF||LA21_0==17||LA21_0==22||LA21_0==25||LA21_0==27) ) {
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
                    // Hymapping.g:2575:40: ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+
                    {
                    // Hymapping.g:2575:40: ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==44) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // Hymapping.g:2576:0: () a0= '||' rightArg= parseop_HyExpression_level_3
                    	    {
                    	    // Hymapping.g:2576:2: ()
                    	    // Hymapping.g:2576:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,44,FOLLOW_44_in_parseop_HyExpression_level_22671); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    	if (element == null) {
                    	    		element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyOrExpression();
                    	    		startIncompleteElement(element);
                    	    	}
                    	    	collectHiddenTokens(element);
                    	    	retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_2_0_0_1, null, true);
                    	    	copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    	// expected elements (follow set)
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), 11433, 11887);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_22682);
                    	    rightArg=parseop_HyExpression_level_3();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    	if (terminateParsing) {
                    	    		throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_2_0_0_0, leftArg, true);
                    	    		copyLocalizationInfos(leftArg, element);
                    	    	}
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    	if (terminateParsing) {
                    	    		throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_2_0_0_2, rightArg, true);
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
                    // Hymapping.g:2631:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 12, parseop_HyExpression_level_2_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_2"



    // $ANTLR start "parseop_HyExpression_level_3"
    // Hymapping.g:2636:1: parseop_HyExpression_level_3 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_14 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_3() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_3_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Hymapping.g:2639:9: (leftArg= parseop_HyExpression_level_14 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |) )
            // Hymapping.g:2640:9: leftArg= parseop_HyExpression_level_14 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_32720);
            leftArg=parseop_HyExpression_level_14();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:2640:40: ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |)
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==15) ) {
                alt23=1;
            }
            else if ( (LA23_0==EOF||LA23_0==17||LA23_0==22||LA23_0==25||LA23_0==27||LA23_0==44) ) {
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
                    // Hymapping.g:2640:41: ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+
                    {
                    // Hymapping.g:2640:41: ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==15) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // Hymapping.g:2641:0: () a0= '&&' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Hymapping.g:2641:2: ()
                    	    // Hymapping.g:2641:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,15,FOLLOW_15_in_parseop_HyExpression_level_32733); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAndExpression();
                    	    	startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_3_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), 11888, 12342);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_32744);
                    	    rightArg=parseop_HyExpression_level_14();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    	throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    	retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_3_0_0_0, leftArg, true);
                    	    	copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    	throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    	retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_3_0_0_2, rightArg, true);
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
                    // Hymapping.g:2696:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 13, parseop_HyExpression_level_3_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_3"



    // $ANTLR start "parseop_HyExpression_level_14"
    // Hymapping.g:2701:1: parseop_HyExpression_level_14 returns [eu.hyvar.feature.expression.HyExpression element = null] : (a0= '!' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 );
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_14() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_14_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression arg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Hymapping.g:2704:0: (a0= '!' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==13) ) {
                alt24=1;
            }
            else if ( (LA24_0==IDENTIFIER_TOKEN||LA24_0==QUOTED_34_34||LA24_0==16||LA24_0==32||(LA24_0 >= 41 && LA24_0 <= 42)) ) {
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
                    // Hymapping.g:2705:0: a0= '!' arg= parseop_HyExpression_level_15
                    {
                    a0=(Token)match(input,13,FOLLOW_13_in_parseop_HyExpression_level_142782); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNotExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_4_0_0_0, null, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    }

                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), 12343, 12797);
                    }

                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142793);
                    arg=parseop_HyExpression_level_15();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_4_0_0_1, arg, true);
                    copyLocalizationInfos(arg, element);
                    }
                    }

                    }
                    break;
                case 2 :
                    // Hymapping.g:2740:5: arg= parseop_HyExpression_level_15
                    {
                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142803);
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
            if ( state.backtracking>0 ) { memoize(input, 14, parseop_HyExpression_level_14_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_14"



    // $ANTLR start "parseop_HyExpression_level_15"
    // Hymapping.g:2743:1: parseop_HyExpression_level_15 returns [eu.hyvar.feature.expression.HyExpression element = null] : (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyBooleanValueExpression );
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_15() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_15_StartIndex = input.index();

        eu.hyvar.feature.expression.HyNestedExpression c0 =null;

        eu.hyvar.feature.expression.HyFeatureReferenceExpression c1 =null;

        eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression c2 =null;

        eu.hyvar.feature.expression.HyBooleanValueExpression c3 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Hymapping.g:2746:0: (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyBooleanValueExpression )
            int alt25=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt25=1;
                }
                break;
            case IDENTIFIER_TOKEN:
            case QUOTED_34_34:
                {
                alt25=2;
                }
                break;
            case 32:
                {
                alt25=3;
                }
                break;
            case 41:
            case 42:
                {
                alt25=4;
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
                    // Hymapping.g:2747:0: c0= parse_eu_hyvar_feature_expression_HyNestedExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_152825);
                    c0=parse_eu_hyvar_feature_expression_HyNestedExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hymapping.g:2748:2: c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_152833);
                    c1=parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hymapping.g:2749:2: c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_152841);
                    c2=parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Hymapping.g:2750:2: c3= parse_eu_hyvar_feature_expression_HyBooleanValueExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_152849);
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
            if ( state.backtracking>0 ) { memoize(input, 15, parseop_HyExpression_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_15"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyNestedExpression"
    // Hymapping.g:2753:1: parse_eu_hyvar_feature_expression_HyNestedExpression returns [eu.hyvar.feature.expression.HyNestedExpression element = null] : a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyNestedExpression parse_eu_hyvar_feature_expression_HyNestedExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyNestedExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Hymapping.g:2756:4: (a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Hymapping.g:2757:4: a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression2871); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_5_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), 12798, 13252);
            }

            // Hymapping.g:2771:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hymapping.g:2772:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression2884);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_5_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 13253);
            }

            a2=(Token)match(input,17,FOLLOW_17_in_parse_eu_hyvar_feature_expression_HyNestedExpression2896); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_5_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 13254, 13259);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyNestedExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression"
    // Hymapping.g:2816:1: parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyFeatureReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? ;
    public final eu.hyvar.feature.expression.HyFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        eu.hyvar.feature.expression.HyVersionRestriction a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Hymapping.g:2819:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? )
            // Hymapping.g:2820:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            {
            // Hymapping.g:2820:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
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
                    // Hymapping.g:2821:0: (a0= QUOTED_34_34 )
                    {
                    // Hymapping.g:2821:4: (a0= QUOTED_34_34 )
                    // Hymapping.g:2822:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2926); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    	throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                    }
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
                    	startIncompleteElement(element);
                    }
                    if (a0 != null) {
                    	eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    	tokenResolver.setOptions(getOptions());
                    	eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                    	tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    	Object resolvedObject = result.getResolvedToken();
                    	if (resolvedObject == null) {
                    		addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
                    	}
                    	String resolved = (String) resolvedObject;
                    	eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    	collectHiddenTokens(element);
                    	registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    	if (proxy != null) {
                    		Object value = proxy;
                    		element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    		completedElement(value, false);
                    	}
                    	collectHiddenTokens(element);
                    	retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_6_0_0_0_0_0_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a0, element);
                    	copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 13260, 13261);
                    addExpectedElement(null, 13262, 13267);
                    }

                    }
                    break;
                case 2 :
                    // Hymapping.g:2863:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hymapping.g:2863:2: (a1= IDENTIFIER_TOKEN )
                    // Hymapping.g:2864:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2943); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    	throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                    }
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
                    	startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    	eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    	tokenResolver.setOptions(getOptions());
                    	eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                    	tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    	Object resolvedObject = result.getResolvedToken();
                    	if (resolvedObject == null) {
                    		addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    	}
                    	String resolved = (String) resolvedObject;
                    	eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    	collectHiddenTokens(element);
                    	registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    	if (proxy != null) {
                    		Object value = proxy;
                    		element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    		completedElement(value, false);
                    	}
                    	collectHiddenTokens(element);
                    	retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_6_0_0_0_0_1_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a1, element);
                    	copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 13268, 13269);
                    addExpectedElement(null, 13270, 13275);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 13276, 13277);
            addExpectedElement(null, 13278, 13283);
            }

            // Hymapping.g:2911:0: ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==35) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // Hymapping.g:2912:0: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    {
                    // Hymapping.g:2912:6: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    // Hymapping.g:2913:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    {
                    // Hymapping.g:2913:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    // Hymapping.g:2914:6: a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2967);
                    a2_0=parse_eu_hyvar_feature_expression_HyVersionRestriction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    	if (terminateParsing) {
                    		throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_6_0_0_1_0_0_0, a2_0, true);
                    		copyLocalizationInfos(a2_0, element);
                    	}
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    // We've found the last token for this rule. The constructed EObject is now
                    // complete.
                    completedElement(element, true);
                    addExpectedElement(null, 13284, 13289);
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
            addExpectedElement(null, 13290, 13295);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression"
    // Hymapping.g:2954:1: parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element = null] : a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ;
    public final eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyVersionRestriction a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Hymapping.g:2957:4: (a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
            // Hymapping.g:2958:4: a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            {
            a0=(Token)match(input,32,FOLLOW_32_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3002); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_7_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 13296, 13297);
            }

            // Hymapping.g:2972:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
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
                    // Hymapping.g:2973:0: (a1= QUOTED_34_34 )
                    {
                    // Hymapping.g:2973:4: (a1= QUOTED_34_34 )
                    // Hymapping.g:2974:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3017); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    	throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                    }
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
                    	startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    	eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    	tokenResolver.setOptions(getOptions());
                    	eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                    	tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    	Object resolvedObject = result.getResolvedToken();
                    	if (resolvedObject == null) {
                    		addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    	}
                    	String resolved = (String) resolvedObject;
                    	eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    	collectHiddenTokens(element);
                    	registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    	if (proxy != null) {
                    		Object value = proxy;
                    		element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    		completedElement(value, false);
                    	}
                    	collectHiddenTokens(element);
                    	retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_0_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a1, element);
                    	copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 13298, 13299);
                    }

                    }
                    break;
                case 2 :
                    // Hymapping.g:3014:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hymapping.g:3014:2: (a2= IDENTIFIER_TOKEN )
                    // Hymapping.g:3015:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3034); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    	throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                    }
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
                    	startIncompleteElement(element);
                    }
                    if (a2 != null) {
                    	eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    	tokenResolver.setOptions(getOptions());
                    	eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                    	tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    	Object resolvedObject = result.getResolvedToken();
                    	if (resolvedObject == null) {
                    		addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                    	}
                    	String resolved = (String) resolvedObject;
                    	eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    	collectHiddenTokens(element);
                    	registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    	if (proxy != null) {
                    		Object value = proxy;
                    		element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    		completedElement(value, false);
                    	}
                    	collectHiddenTokens(element);
                    	retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_1_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a2, element);
                    	copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 13300, 13301);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 13302, 13303);
            }

            // Hymapping.g:3060:6: (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            // Hymapping.g:3061:6: a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3054);
            a3_0=parse_eu_hyvar_feature_expression_HyVersionRestriction();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_7_0_0_2, a3_0, true);
            copyLocalizationInfos(a3_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 13304, 13309);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"
    // Hymapping.g:3091:1: parse_eu_hyvar_feature_expression_HyBooleanValueExpression returns [eu.hyvar.feature.expression.HyBooleanValueExpression element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.feature.expression.HyBooleanValueExpression parse_eu_hyvar_feature_expression_HyBooleanValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyBooleanValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Hymapping.g:3094:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hymapping.g:3095:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hymapping.g:3095:0: ( (a0= 'true' |a1= 'false' ) )
            // Hymapping.g:3096:0: (a0= 'true' |a1= 'false' )
            {
            // Hymapping.g:3096:0: (a0= 'true' |a1= 'false' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==42) ) {
                alt29=1;
            }
            else if ( (LA29_0==41) ) {
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
                    // Hymapping.g:3097:0: a0= 'true'
                    {
                    a0=(Token)match(input,42,FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3085); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_8_0_0_0, true, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    // set value of boolean attribute
                    Object value = true;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 2 :
                    // Hymapping.g:3110:2: a1= 'false'
                    {
                    a1=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3094); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_8_0_0_0, false, true);
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
            addExpectedElement(null, 13310, 13315);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_4"
    // Hymapping.g:3135:1: parseop_HyArithmeticalValueExpression_level_4 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_5 ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_4() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_4_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Hymapping.g:3138:9: (leftArg= parseop_HyArithmeticalValueExpression_level_5 ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |) )
            // Hymapping.g:3139:9: leftArg= parseop_HyArithmeticalValueExpression_level_5 ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_43124);
            leftArg=parseop_HyArithmeticalValueExpression_level_5();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:3139:56: ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |)
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==36) ) {
                alt31=1;
            }
            else if ( (LA31_0==14||LA31_0==17||LA31_0==26||(LA31_0 >= 28 && LA31_0 <= 31)||LA31_0==45) ) {
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
                    // Hymapping.g:3139:57: ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+
                    {
                    // Hymapping.g:3139:57: ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+
                    int cnt30=0;
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==36) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // Hymapping.g:3140:0: () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5
                    	    {
                    	    // Hymapping.g:3140:2: ()
                    	    // Hymapping.g:3140:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,36,FOLLOW_36_in_parseop_HyArithmeticalValueExpression_level_43137); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyModuloExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_12_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), 13316, 16249);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_43148);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_5();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_12_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_12_0_0_2, rightArg, true);
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
                    // Hymapping.g:3195:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 20, parseop_HyArithmeticalValueExpression_level_4_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_4"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_5"
    // Hymapping.g:3200:1: parseop_HyArithmeticalValueExpression_level_5 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_6 ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_5() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_5_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Hymapping.g:3203:9: (leftArg= parseop_HyArithmeticalValueExpression_level_6 ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |) )
            // Hymapping.g:3204:9: leftArg= parseop_HyArithmeticalValueExpression_level_6 ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_53186);
            leftArg=parseop_HyArithmeticalValueExpression_level_6();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:3204:56: ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |)
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==19) ) {
                alt33=1;
            }
            else if ( (LA33_0==EOF||LA33_0==14||LA33_0==17||LA33_0==26||(LA33_0 >= 28 && LA33_0 <= 31)||LA33_0==36||LA33_0==45) ) {
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
                    // Hymapping.g:3204:57: ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+
                    {
                    // Hymapping.g:3204:57: ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+
                    int cnt32=0;
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==19) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // Hymapping.g:3205:0: () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6
                    	    {
                    	    // Hymapping.g:3205:2: ()
                    	    // Hymapping.g:3205:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,19,FOLLOW_19_in_parseop_HyArithmeticalValueExpression_level_53199); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAdditionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_10_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), 16250, 19183);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_53210);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_6();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_10_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_10_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt32 >= 1 ) break loop32;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(32, input);
                                throw eee;
                        }
                        cnt32++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hymapping.g:3260:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 21, parseop_HyArithmeticalValueExpression_level_5_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_5"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_6"
    // Hymapping.g:3265:1: parseop_HyArithmeticalValueExpression_level_6 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_7 ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_6() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_6_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Hymapping.g:3268:9: (leftArg= parseop_HyArithmeticalValueExpression_level_7 ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |) )
            // Hymapping.g:3269:9: leftArg= parseop_HyArithmeticalValueExpression_level_7 ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_63248);
            leftArg=parseop_HyArithmeticalValueExpression_level_7();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:3269:56: ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |)
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==21) ) {
                alt35=1;
            }
            else if ( (LA35_0==EOF||LA35_0==14||LA35_0==17||LA35_0==19||LA35_0==26||(LA35_0 >= 28 && LA35_0 <= 31)||LA35_0==36||LA35_0==45) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }
            switch (alt35) {
                case 1 :
                    // Hymapping.g:3269:57: ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+
                    {
                    // Hymapping.g:3269:57: ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+
                    int cnt34=0;
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==21) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // Hymapping.g:3270:0: () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7
                    	    {
                    	    // Hymapping.g:3270:2: ()
                    	    // Hymapping.g:3270:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,21,FOLLOW_21_in_parseop_HyArithmeticalValueExpression_level_63261); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHySubtractionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_11_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), 19184, 22117);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_63272);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_7();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_11_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_11_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt34 >= 1 ) break loop34;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(34, input);
                                throw eee;
                        }
                        cnt34++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hymapping.g:3325:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 22, parseop_HyArithmeticalValueExpression_level_6_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_6"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_7"
    // Hymapping.g:3330:1: parseop_HyArithmeticalValueExpression_level_7 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_8 ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_7() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_7_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Hymapping.g:3333:9: (leftArg= parseop_HyArithmeticalValueExpression_level_8 ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |) )
            // Hymapping.g:3334:9: leftArg= parseop_HyArithmeticalValueExpression_level_8 ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73310);
            leftArg=parseop_HyArithmeticalValueExpression_level_8();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:3334:56: ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |)
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==18) ) {
                alt37=1;
            }
            else if ( (LA37_0==EOF||LA37_0==14||LA37_0==17||LA37_0==19||LA37_0==21||LA37_0==26||(LA37_0 >= 28 && LA37_0 <= 31)||LA37_0==36||LA37_0==45) ) {
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
                    // Hymapping.g:3334:57: ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+
                    {
                    // Hymapping.g:3334:57: ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+
                    int cnt36=0;
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==18) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // Hymapping.g:3335:0: () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8
                    	    {
                    	    // Hymapping.g:3335:2: ()
                    	    // Hymapping.g:3335:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,18,FOLLOW_18_in_parseop_HyArithmeticalValueExpression_level_73323); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMultiplicationExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_13_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), 22118, 25051);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73334);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_8();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_13_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_13_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt36 >= 1 ) break loop36;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(36, input);
                                throw eee;
                        }
                        cnt36++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hymapping.g:3390:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 23, parseop_HyArithmeticalValueExpression_level_7_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_7"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_8"
    // Hymapping.g:3395:1: parseop_HyArithmeticalValueExpression_level_8 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_11 ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_8() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_8_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Hymapping.g:3398:9: (leftArg= parseop_HyArithmeticalValueExpression_level_11 ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |) )
            // Hymapping.g:3399:9: leftArg= parseop_HyArithmeticalValueExpression_level_11 ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83372);
            leftArg=parseop_HyArithmeticalValueExpression_level_11();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:3399:57: ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |)
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==24) ) {
                alt39=1;
            }
            else if ( (LA39_0==EOF||LA39_0==14||(LA39_0 >= 17 && LA39_0 <= 19)||LA39_0==21||LA39_0==26||(LA39_0 >= 28 && LA39_0 <= 31)||LA39_0==36||LA39_0==45) ) {
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
                    // Hymapping.g:3399:58: ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+
                    {
                    // Hymapping.g:3399:58: ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+
                    int cnt38=0;
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==24) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // Hymapping.g:3400:0: () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11
                    	    {
                    	    // Hymapping.g:3400:2: ()
                    	    // Hymapping.g:3400:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,24,FOLLOW_24_in_parseop_HyArithmeticalValueExpression_level_83385); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyDivisionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_14_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), 25052, 27985);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83396);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_11();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_14_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_14_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt38 >= 1 ) break loop38;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(38, input);
                                throw eee;
                        }
                        cnt38++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hymapping.g:3455:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 24, parseop_HyArithmeticalValueExpression_level_8_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_8"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_11"
    // Hymapping.g:3460:1: parseop_HyArithmeticalValueExpression_level_11 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c0= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_11() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_11_StartIndex = input.index();

        eu.hyvar.feature.expression.HyAttributeReferenceExpression c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }

            // Hymapping.g:3463:4: (c0= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression )
            // Hymapping.g:3464:4: c0= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_113434);
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
            if ( state.backtracking>0 ) { memoize(input, 25, parseop_HyArithmeticalValueExpression_level_11_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_11"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression"
    // Hymapping.g:3467:1: parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression returns [eu.hyvar.feature.expression.HyAttributeReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) ;
    public final eu.hyvar.feature.expression.HyAttributeReferenceExpression parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyAttributeReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Hymapping.g:3470:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) )
            // Hymapping.g:3471:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN )
            {
            // Hymapping.g:3471:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==QUOTED_34_34) ) {
                alt40=1;
            }
            else if ( (LA40_0==IDENTIFIER_TOKEN) ) {
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
                    // Hymapping.g:3472:0: (a0= QUOTED_34_34 )
                    {
                    // Hymapping.g:3472:4: (a0= QUOTED_34_34 )
                    // Hymapping.g:3473:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3460); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a0 != null) {
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_17_0_0_0_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a0, element);
                    copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 27986);
                    }

                    }
                    break;
                case 2 :
                    // Hymapping.g:3513:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hymapping.g:3513:2: (a1= IDENTIFIER_TOKEN )
                    // Hymapping.g:3514:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3477); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_17_0_0_0_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 27987);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 27988);
            }

            a2=(Token)match(input,23,FOLLOW_23_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3495); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_17_0_0_1, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 27989);
            }

            // Hymapping.g:3573:4: (a3= IDENTIFIER_TOKEN )
            // Hymapping.g:3574:4: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3508); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
            startIncompleteElement(element);
            }
            if (a3 != null) {
            eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            tokenResolver.setOptions(getOptions());
            eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
            tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), result);
            Object resolvedObject = result.getResolvedToken();
            if (resolvedObject == null) {
            addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            }
            String resolved = (String) resolvedObject;
            eu.hyvar.feature.HyFeatureAttribute proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyNumberAttribute();
            collectHiddenTokens(element);
            registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeatureAttribute>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionAttributeReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), resolved, proxy);
            if (proxy != null) {
            Object value = proxy;
            element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), value);
            completedElement(value, false);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_17_0_0_2, proxy, true);
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
            addExpectedElement(null, 27990, 27996);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_12"
    // Hymapping.g:3618:1: parseop_HyArithmeticalValueExpression_level_12 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c0= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_12() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_12_StartIndex = input.index();

        eu.hyvar.feature.expression.HyContextInformationReferenceExpression c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Hymapping.g:3621:4: (c0= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression )
            // Hymapping.g:3622:4: c0= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_123536);
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
            if ( state.backtracking>0 ) { memoize(input, 27, parseop_HyArithmeticalValueExpression_level_12_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_12"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"
    // Hymapping.g:3625:1: parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression returns [eu.hyvar.feature.expression.HyContextInformationReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ;
    public final eu.hyvar.feature.expression.HyContextInformationReferenceExpression parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyContextInformationReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Hymapping.g:3628:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) )
            // Hymapping.g:3629:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            {
            // Hymapping.g:3629:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
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
                    // Hymapping.g:3630:0: (a0= QUOTED_34_34 )
                    {
                    // Hymapping.g:3630:4: (a0= QUOTED_34_34 )
                    // Hymapping.g:3631:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3562); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a0 != null) {
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.context.HyContextualInformation proxy = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextInformationReferenceExpressionContextInformationReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_18_0_0_0_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a0, element);
                    copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 27997, 28003);
                    }

                    }
                    break;
                case 2 :
                    // Hymapping.g:3671:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hymapping.g:3671:2: (a1= IDENTIFIER_TOKEN )
                    // Hymapping.g:3672:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3579); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.context.HyContextualInformation proxy = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextInformationReferenceExpressionContextInformationReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_18_0_0_0_0_1_0, proxy, true);
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
                    addExpectedElement(null, 28004, 28010);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 28011, 28017);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 28, parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_13"
    // Hymapping.g:3725:1: parseop_HyArithmeticalValueExpression_level_13 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c0= parse_eu_hyvar_feature_expression_HyValueExpression ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_13() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_13_StartIndex = input.index();

        eu.hyvar.feature.expression.HyValueExpression c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Hymapping.g:3728:4: (c0= parse_eu_hyvar_feature_expression_HyValueExpression )
            // Hymapping.g:3729:4: c0= parse_eu_hyvar_feature_expression_HyValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyArithmeticalValueExpression_level_133612);
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
            if ( state.backtracking>0 ) { memoize(input, 29, parseop_HyArithmeticalValueExpression_level_13_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_13"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyValueExpression"
    // Hymapping.g:3732:1: parse_eu_hyvar_feature_expression_HyValueExpression returns [eu.hyvar.feature.expression.HyValueExpression element = null] : (a0_0= parse_eu_hyvar_dataValues_HyValue ) ;
    public final eu.hyvar.feature.expression.HyValueExpression parse_eu_hyvar_feature_expression_HyValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Hymapping.g:3735:6: ( (a0_0= parse_eu_hyvar_dataValues_HyValue ) )
            // Hymapping.g:3736:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            {
            // Hymapping.g:3736:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            // Hymapping.g:3737:6: a0_0= parse_eu_hyvar_dataValues_HyValue
            {
            pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression3636);
            a0_0=parse_eu_hyvar_dataValues_HyValue();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_19_0_0_0, a0_0, true);
            copyLocalizationInfos(a0_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 28018, 28024);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyValueExpression"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_14"
    // Hymapping.g:3767:1: parseop_HyArithmeticalValueExpression_level_14 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : (a0= '-' arg= parseop_HyArithmeticalValueExpression_level_15 |arg= parseop_HyArithmeticalValueExpression_level_15 );
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_14() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_14_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression arg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }

            // Hymapping.g:3770:0: (a0= '-' arg= parseop_HyArithmeticalValueExpression_level_15 |arg= parseop_HyArithmeticalValueExpression_level_15 )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==21) ) {
                alt42=1;
            }
            else if ( (LA42_0==16) ) {
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
                    // Hymapping.g:3771:0: a0= '-' arg= parseop_HyArithmeticalValueExpression_level_15
                    {
                    a0=(Token)match(input,21,FOLLOW_21_in_parseop_HyArithmeticalValueExpression_level_143663); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNegationExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_15_0_0_0, null, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    }

                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), 28025, 30958);
                    }

                    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_143674);
                    arg=parseop_HyArithmeticalValueExpression_level_15();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_15_0_0_1, arg, true);
                    copyLocalizationInfos(arg, element);
                    }
                    }

                    }
                    break;
                case 2 :
                    // Hymapping.g:3806:5: arg= parseop_HyArithmeticalValueExpression_level_15
                    {
                    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_143684);
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
            if ( state.backtracking>0 ) { memoize(input, 31, parseop_HyArithmeticalValueExpression_level_14_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_14"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_15"
    // Hymapping.g:3809:1: parseop_HyArithmeticalValueExpression_level_15 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c0= parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_15() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_15_StartIndex = input.index();

        eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return element; }

            // Hymapping.g:3812:4: (c0= parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression )
            // Hymapping.g:3813:4: c0= parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_in_parseop_HyArithmeticalValueExpression_level_153706);
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
            if ( state.backtracking>0 ) { memoize(input, 32, parseop_HyArithmeticalValueExpression_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_15"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression"
    // Hymapping.g:3816:1: parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression returns [eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression element = null] : a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return element; }

            // Hymapping.g:3819:4: (a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a2= ')' )
            // Hymapping.g:3820:4: a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a2= ')'
            {
            a0=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3728); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedArithmeticalValueExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_16_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedArithmeticalValueExpression(), 30959, 33892);
            }

            // Hymapping.g:3834:6: (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression )
            // Hymapping.g:3835:6: a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3741);
            a1_0=parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_16_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 33893);
            }

            a2=(Token)match(input,17,FOLLOW_17_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3753); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedArithmeticalValueExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_16_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 33894, 33900);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 33, parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression"



    // $ANTLR start "parseop_HyValue_level_15"
    // Hymapping.g:3879:1: parseop_HyValue_level_15 returns [eu.hyvar.dataValues.HyValue element = null] : (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue );
    public final eu.hyvar.dataValues.HyValue parseop_HyValue_level_15() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parseop_HyValue_level_15_StartIndex = input.index();

        eu.hyvar.dataValues.HyNumberValue c0 =null;

        eu.hyvar.dataValues.HyBooleanValue c1 =null;

        eu.hyvar.dataValues.HyEnumValue c2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return element; }

            // Hymapping.g:3882:0: (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue )
            int alt43=3;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
                {
                alt43=1;
                }
                break;
            case 41:
            case 42:
                {
                alt43=2;
                }
                break;
            case 39:
                {
                alt43=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }

            switch (alt43) {
                case 1 :
                    // Hymapping.g:3883:0: c0= parse_eu_hyvar_dataValues_HyNumberValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_153779);
                    c0=parse_eu_hyvar_dataValues_HyNumberValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hymapping.g:3884:2: c1= parse_eu_hyvar_dataValues_HyBooleanValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_153787);
                    c1=parse_eu_hyvar_dataValues_HyBooleanValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hymapping.g:3885:2: c2= parse_eu_hyvar_dataValues_HyEnumValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_153795);
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
            if ( state.backtracking>0 ) { memoize(input, 34, parseop_HyValue_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyValue_level_15"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyNumberValue"
    // Hymapping.g:3888:1: parse_eu_hyvar_dataValues_HyNumberValue returns [eu.hyvar.dataValues.HyNumberValue element = null] : (a0= INTEGER_LITERAL ) ;
    public final eu.hyvar.dataValues.HyNumberValue parse_eu_hyvar_dataValues_HyNumberValue() throws RecognitionException {
        eu.hyvar.dataValues.HyNumberValue element =  null;

        int parse_eu_hyvar_dataValues_HyNumberValue_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return element; }

            // Hymapping.g:3891:4: ( (a0= INTEGER_LITERAL ) )
            // Hymapping.g:3892:4: (a0= INTEGER_LITERAL )
            {
            // Hymapping.g:3892:4: (a0= INTEGER_LITERAL )
            // Hymapping.g:3893:4: a0= INTEGER_LITERAL
            {
            a0=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3819); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyNumberValue();
            startIncompleteElement(element);
            }
            if (a0 != null) {
            eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            tokenResolver.setOptions(getOptions());
            eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
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
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_0_0_0_0, resolved, true);
            copyLocalizationInfos((CommonToken) a0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 33901, 33907);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 35, parse_eu_hyvar_dataValues_HyNumberValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyNumberValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyBooleanValue"
    // Hymapping.g:3933:1: parse_eu_hyvar_dataValues_HyBooleanValue returns [eu.hyvar.dataValues.HyBooleanValue element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.dataValues.HyBooleanValue parse_eu_hyvar_dataValues_HyBooleanValue() throws RecognitionException {
        eu.hyvar.dataValues.HyBooleanValue element =  null;

        int parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return element; }

            // Hymapping.g:3936:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hymapping.g:3937:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hymapping.g:3937:0: ( (a0= 'true' |a1= 'false' ) )
            // Hymapping.g:3938:0: (a0= 'true' |a1= 'false' )
            {
            // Hymapping.g:3938:0: (a0= 'true' |a1= 'false' )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==42) ) {
                alt44=1;
            }
            else if ( (LA44_0==41) ) {
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
                    // Hymapping.g:3939:0: a0= 'true'
                    {
                    a0=(Token)match(input,42,FOLLOW_42_in_parse_eu_hyvar_dataValues_HyBooleanValue3851); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_1_0_0_0, true, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    // set value of boolean attribute
                    Object value = true;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 2 :
                    // Hymapping.g:3952:2: a1= 'false'
                    {
                    a1=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_dataValues_HyBooleanValue3860); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_1_0_0_0, false, true);
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
            addExpectedElement(null, 33908, 33914);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 36, parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyBooleanValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumValue"
    // Hymapping.g:3977:1: parse_eu_hyvar_dataValues_HyEnumValue returns [eu.hyvar.dataValues.HyEnumValue element = null] : a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return element; }

            // Hymapping.g:3980:4: (a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) ) )
            // Hymapping.g:3981:4: a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
            {
            a0=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumValue3890); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 33915, 33916);
            }

            // Hymapping.g:3995:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==QUOTED_34_34) ) {
                alt45=1;
            }
            else if ( (LA45_0==IDENTIFIER_TOKEN) ) {
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
                    // Hymapping.g:3996:0: (a1= QUOTED_34_34 )
                    {
                    // Hymapping.g:3996:4: (a1= QUOTED_34_34 )
                    // Hymapping.g:3997:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3905); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 33917);
                    }

                    }
                    break;
                case 2 :
                    // Hymapping.g:4037:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hymapping.g:4037:2: (a2= IDENTIFIER_TOKEN )
                    // Hymapping.g:4038:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3922); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a2 != null) {
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a2, element);
                    copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 33918);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 33919);
            }

            a3=(Token)match(input,23,FOLLOW_23_in_parse_eu_hyvar_dataValues_HyEnumValue3940); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a3, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 33920, 33921);
            }

            // Hymapping.g:4097:0: ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==QUOTED_34_34) ) {
                alt46=1;
            }
            else if ( (LA46_0==IDENTIFIER_TOKEN) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }
            switch (alt46) {
                case 1 :
                    // Hymapping.g:4098:0: (a4= QUOTED_34_34 )
                    {
                    // Hymapping.g:4098:4: (a4= QUOTED_34_34 )
                    // Hymapping.g:4099:4: a4= QUOTED_34_34
                    {
                    a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3955); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a4 != null) {
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a4, element);
                    copyLocalizationInfos((CommonToken) a4, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 33922, 33928);
                    }

                    }
                    break;
                case 2 :
                    // Hymapping.g:4139:2: (a5= IDENTIFIER_TOKEN )
                    {
                    // Hymapping.g:4139:2: (a5= IDENTIFIER_TOKEN )
                    // Hymapping.g:4140:4: a5= IDENTIFIER_TOKEN
                    {
                    a5=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3972); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a5 != null) {
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_1_0, proxy, true);
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
                    addExpectedElement(null, 33929, 33935);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 33936, 33942);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 37, parse_eu_hyvar_dataValues_HyEnumValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumValue"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyExpression"
    // Hymapping.g:4193:1: parse_eu_hyvar_feature_expression_HyExpression returns [eu.hyvar.feature.expression.HyExpression element = null] : c= parseop_HyExpression_level_0 ;
    public final eu.hyvar.feature.expression.HyExpression parse_eu_hyvar_feature_expression_HyExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyExpression_StartIndex = input.index();

        eu.hyvar.feature.expression.HyExpression c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return element; }

            // Hymapping.g:4194:3: (c= parseop_HyExpression_level_0 )
            // Hymapping.g:4195:3: c= parseop_HyExpression_level_0
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression4001);
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
            if ( state.backtracking>0 ) { memoize(input, 38, parse_eu_hyvar_feature_expression_HyExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression"
    // Hymapping.g:4199:1: parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c= parseop_HyArithmeticalValueExpression_level_4 ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_StartIndex = input.index();

        eu.hyvar.feature.expression.HyArithmeticalValueExpression c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return element; }

            // Hymapping.g:4200:3: (c= parseop_HyArithmeticalValueExpression_level_4 )
            // Hymapping.g:4201:3: c= parseop_HyArithmeticalValueExpression_level_4
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_4_in_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression4020);
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
            if ( state.backtracking>0 ) { memoize(input, 39, parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyVersionRestriction"
    // Hymapping.g:4205:1: parse_eu_hyvar_feature_expression_HyVersionRestriction returns [eu.hyvar.feature.expression.HyVersionRestriction element = null] : (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction );
    public final eu.hyvar.feature.expression.HyVersionRestriction parse_eu_hyvar_feature_expression_HyVersionRestriction() throws RecognitionException {
        eu.hyvar.feature.expression.HyVersionRestriction element =  null;

        int parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex = input.index();

        eu.hyvar.feature.expression.HyRelativeVersionRestriction c0 =null;

        eu.hyvar.feature.expression.HyVersionRangeRestriction c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return element; }

            // Hymapping.g:4206:0: (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==35) ) {
                switch ( input.LA(2) ) {
                case 26:
                case 28:
                case 29:
                case 30:
                case 31:
                    {
                    alt47=1;
                    }
                    break;
                case QUOTED_34_34:
                    {
                    int LA47_3 = input.LA(3);

                    if ( (LA47_3==37) ) {
                        alt47=1;
                    }
                    else if ( (LA47_3==21) ) {
                        alt47=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 3, input);

                        throw nvae;

                    }
                    }
                    break;
                case 38:
                    {
                    alt47=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }
            switch (alt47) {
                case 1 :
                    // Hymapping.g:4207:0: c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction4039);
                    c0=parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hymapping.g:4208:2: c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction4047);
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
            if ( state.backtracking>0 ) { memoize(input, 40, parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyVersionRestriction"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyValue"
    // Hymapping.g:4212:1: parse_eu_hyvar_dataValues_HyValue returns [eu.hyvar.dataValues.HyValue element = null] : c= parseop_HyValue_level_15 ;
    public final eu.hyvar.dataValues.HyValue parse_eu_hyvar_dataValues_HyValue() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parse_eu_hyvar_dataValues_HyValue_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return element; }

            // Hymapping.g:4213:3: (c= parseop_HyValue_level_15 )
            // Hymapping.g:4214:3: c= parseop_HyValue_level_15
            {
            pushFollow(FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue4066);
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
            if ( state.backtracking>0 ) { memoize(input, 41, parse_eu_hyvar_dataValues_HyValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_eu_hyvar_feature_mapping_HyMappingModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_mapping_HyMapping_in_parse_eu_hyvar_feature_mapping_HyMappingModel130 = new BitSet(new long[]{0x0000060100012222L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_mapping_HyMapping_in_parse_eu_hyvar_feature_mapping_HyMappingModel179 = new BitSet(new long[]{0x0000060100012222L});
    public static final BitSet FOLLOW_QUOTED_6060_6262_in_parse_org_deltaecore_core_decore_DEDeltaInvokation272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_mapping_HyMapping312 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_eu_hyvar_feature_mapping_HyMapping330 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_parse_org_deltaecore_core_decore_DEDeltaInvokation_in_parse_eu_hyvar_feature_mapping_HyMapping348 = new BitSet(new long[]{0x0000000800100002L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_feature_mapping_HyMapping375 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_parse_org_deltaecore_core_decore_DEDeltaInvokation_in_parse_eu_hyvar_feature_mapping_HyMapping401 = new BitSet(new long[]{0x0000000800100002L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_feature_mapping_HyMapping451 = new BitSet(new long[]{0x0000010000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_mapping_HyMapping484 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_feature_mapping_HyMapping523 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_mapping_HyMapping553 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_mapping_HyMapping609 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_feature_mapping_HyMapping648 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_feature_mapping_HyMapping671 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_feature_mapping_HyMapping704 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_feature_mapping_HyMapping727 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_mapping_HyMapping757 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_feature_mapping_HyMapping809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression857 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression875 = new BitSet(new long[]{0x00000000F4004000L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression902 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression917 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression932 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_14_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression947 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_31_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression962 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression977 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression1002 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1049 = new BitSet(new long[]{0x00000000F4000200L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1072 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1087 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1102 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_31_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1117 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1132 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1157 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction1178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1207 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_38_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1230 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1255 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1276 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_38_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1299 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1324 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnum1374 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum1392 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1413 = new BitSet(new long[]{0x0000000400020000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1442 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1483 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1517 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_parse_eu_hyvar_dataValues_HyEnum1591 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnum1614 = new BitSet(new long[]{0x0000010000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1647 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum1686 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1716 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1772 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum1811 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_dataValues_HyEnum1844 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum1867 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1897 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_dataValues_HyEnum1949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_parse_eu_hyvar_dataValues_HyEnumLiteral1997 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral2015 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral2036 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral2054 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_eu_hyvar_dataValues_HyEnumLiteral2075 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnumLiteral2098 = new BitSet(new long[]{0x0000010000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2131 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral2170 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2200 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2256 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral2295 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_dataValues_HyEnumLiteral2318 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_dataValues_HyEnumLiteral2351 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral2374 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2404 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_dataValues_HyEnumLiteral2456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02504 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_parseop_HyExpression_level_02524 = new BitSet(new long[]{0x0000060100012220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02541 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_12587 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_parseop_HyExpression_level_12603 = new BitSet(new long[]{0x0000060100012220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_12617 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_22658 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_parseop_HyExpression_level_22671 = new BitSet(new long[]{0x0000060100012220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_22682 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_32720 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_parseop_HyExpression_level_32733 = new BitSet(new long[]{0x0000060100012220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_32744 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_13_in_parseop_HyExpression_level_142782 = new BitSet(new long[]{0x0000060100010220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_152825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_152833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_152841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_152849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression2871 = new BitSet(new long[]{0x0000060100012220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression2884 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_eu_hyvar_feature_expression_HyNestedExpression2896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2926 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2943 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3002 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3017 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3034 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_43124 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_parseop_HyArithmeticalValueExpression_level_43137 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_43148 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_53186 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_parseop_HyArithmeticalValueExpression_level_53199 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_53210 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_63248 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_parseop_HyArithmeticalValueExpression_level_63261 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_63272 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73310 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_parseop_HyArithmeticalValueExpression_level_73323 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73334 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83372 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_parseop_HyArithmeticalValueExpression_level_83385 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83396 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_113434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3460 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3477 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3495 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_123536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyArithmeticalValueExpression_level_133612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression3636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parseop_HyArithmeticalValueExpression_level_143663 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_143674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_143684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_in_parseop_HyArithmeticalValueExpression_level_153706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3728 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3741 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_153779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_153787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_153795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_parse_eu_hyvar_dataValues_HyBooleanValue3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_dataValues_HyBooleanValue3860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumValue3890 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3905 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3922 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_eu_hyvar_dataValues_HyEnumValue3940 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression4001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_4_in_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression4020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction4039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction4047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue4066 = new BitSet(new long[]{0x0000000000000002L});

}