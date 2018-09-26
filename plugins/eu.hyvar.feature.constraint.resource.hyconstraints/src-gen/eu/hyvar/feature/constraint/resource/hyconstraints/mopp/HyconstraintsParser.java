// $ANTLR 3.4

	package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;
	
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
public class HyconstraintsParser extends HyconstraintsANTLRParserBase {
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
    public HyconstraintsANTLRParserBase[] getDelegates() {
        return new HyconstraintsANTLRParserBase[] {};
    }

    // delegators


    public HyconstraintsParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public HyconstraintsParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(100 + 1);
         

    }

    public String[] getTokenNames() { return HyconstraintsParser.tokenNames; }
    public String getGrammarFileName() { return "Hyconstraints.g"; }


    	private eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolverFactory tokenResolverFactory = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenResolverFactory();
    	
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
    	private List<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal> expectedElements = new ArrayList<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal>();
    	
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
    	
    	private eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsLocationMap locationMap;
    	
    	private eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsSyntaxErrorMessageConverter syntaxErrorMessageConverter = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsSyntaxErrorMessageConverter(tokenNames);
    	
    	@Override
    	public void reportError(RecognitionException re) {
    		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
    	}
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource>() {
    			public boolean execute(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsProblem() {
    					public eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemSeverity getSeverity() {
    						return eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemSeverity.ERROR;
    					}
    					public eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType getType() {
    						return eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	protected void addErrorToResource(eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsLocalizedMessage message) {
    		if (message == null) {
    			return;
    		}
    		addErrorToResource(message.getMessage(), message.getColumn(), message.getLine(), message.getCharStart(), message.getCharEnd());
    	}
    	
    	public void addExpectedElement(EClass eClass, int expectationStartIndex, int expectationEndIndex) {
    		for (int expectationIndex = expectationStartIndex; expectationIndex <= expectationEndIndex; expectationIndex++) {
    			addExpectedElement(eClass, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[expectationIndex]);
    		}
    	}
    	
    	public void addExpectedElement(EClass eClass, int expectationIndex) {
    		addExpectedElement(eClass, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[expectationIndex]);
    	}
    	
    	public void addExpectedElement(EClass eClass, int[] ids) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		int terminalID = ids[0];
    		int followSetID = ids[1];
    		eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsExpectedElement terminal = eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsFollowSetProvider.TERMINALS[terminalID];
    		eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContainedFeature[] containmentFeatures = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsFollowSetProvider.LINKS[ids[i]];
    		}
    		eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainmentTrace containmentTrace = new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainmentTrace(eClass, containmentFeatures);
    		EObject container = getLastIncompleteElement();
    		eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal expectedElement = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		final eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource>() {
    			public boolean execute(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource resource) {
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
    		final eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource>() {
    			public boolean execute(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource resource) {
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
    	protected void setLocalizationEnd(Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		final eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource>() {
    			public boolean execute(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource resource) {
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextParser createInstance(InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new HyconstraintsParser(new CommonTokenStream(new HyconstraintsLexer(new ANTLRInputStream(actualInputStream))));
    			} else {
    				return new HyconstraintsParser(new CommonTokenStream(new HyconstraintsLexer(new ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (IOException e) {
    			new eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public HyconstraintsParser() {
    		super(null);
    	}
    	
    	protected EObject doParse() throws RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((HyconstraintsLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((HyconstraintsLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof EClass) {
    			EClass type = (EClass) typeObject;
    			if (type.getInstanceClass() == eu.hyvar.feature.constraint.HyConstraintModel.class) {
    				return parse_eu_hyvar_feature_constraint_HyConstraintModel();
    			}
    			if (type.getInstanceClass() == eu.hyvar.feature.constraint.HyConstraint.class) {
    				return parse_eu_hyvar_feature_constraint_HyConstraint();
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
    		throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsParseResult parse() {
    		// Reset parser state
    		terminateParsing = false;
    		postParseCommands = new ArrayList<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource>>();
    		eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsParseResult parseResult = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsParseResult();
    		if (disableLocationMap) {
    			locationMap = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsDevNullLocationMap();
    		} else {
    			locationMap = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsLocationMap();
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
    	
    	public List<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal> parseToExpectedElements(EClass type, eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
    		eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsParseResult result = parse();
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
    			for (eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		Set<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal> currentFollowSet = new LinkedHashSet<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal>();
    		List<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal> newFollowSet = new ArrayList<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 119;
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
    				for (eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						Collection<eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsPair<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsExpectedElement, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsPair<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsExpectedElement, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContainedFeature[]> newFollowerPair : newFollowers) {
    							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsExpectedElement newFollower = newFollowerPair.getLeft();
    							EObject container = getLastIncompleteElement();
    							eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainmentTrace containmentTrace = new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainmentTrace(null, newFollowerPair.getRight());
    							eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal newFollowTerminal = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal expectedElement, int tokenIndex) {
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
    // Hyconstraints.g:497:1: start returns [ EObject element = null] : (c0= parse_eu_hyvar_feature_constraint_HyConstraintModel ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        eu.hyvar.feature.constraint.HyConstraintModel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Hyconstraints.g:498:2: ( (c0= parse_eu_hyvar_feature_constraint_HyConstraintModel ) EOF )
            // Hyconstraints.g:499:2: (c0= parse_eu_hyvar_feature_constraint_HyConstraintModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 0, 454);
            		expectedElementsIndexOfLastCompleteElement = 454;
            	}

            // Hyconstraints.g:504:2: (c0= parse_eu_hyvar_feature_constraint_HyConstraintModel )
            // Hyconstraints.g:505:3: c0= parse_eu_hyvar_feature_constraint_HyConstraintModel
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_constraint_HyConstraintModel_in_start82);
            c0=parse_eu_hyvar_feature_constraint_HyConstraintModel();

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



    // $ANTLR start "parse_eu_hyvar_feature_constraint_HyConstraintModel"
    // Hyconstraints.g:513:1: parse_eu_hyvar_feature_constraint_HyConstraintModel returns [eu.hyvar.feature.constraint.HyConstraintModel element = null] : ( (a0_0= parse_eu_hyvar_feature_constraint_HyConstraint ) )* ;
    public final eu.hyvar.feature.constraint.HyConstraintModel parse_eu_hyvar_feature_constraint_HyConstraintModel() throws RecognitionException {
        eu.hyvar.feature.constraint.HyConstraintModel element =  null;

        int parse_eu_hyvar_feature_constraint_HyConstraintModel_StartIndex = input.index();

        eu.hyvar.feature.constraint.HyConstraint a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Hyconstraints.g:516:2: ( ( (a0_0= parse_eu_hyvar_feature_constraint_HyConstraint ) )* )
            // Hyconstraints.g:517:2: ( (a0_0= parse_eu_hyvar_feature_constraint_HyConstraint ) )*
            {
            // Hyconstraints.g:517:2: ( (a0_0= parse_eu_hyvar_feature_constraint_HyConstraint ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IDENTIFIER_TOKEN||LA1_0==QUOTED_34_34||LA1_0==12||LA1_0==15||LA1_0==30||(LA1_0 >= 40 && LA1_0 <= 42)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Hyconstraints.g:518:3: (a0_0= parse_eu_hyvar_feature_constraint_HyConstraint )
            	    {
            	    // Hyconstraints.g:518:3: (a0_0= parse_eu_hyvar_feature_constraint_HyConstraint )
            	    // Hyconstraints.g:519:4: a0_0= parse_eu_hyvar_feature_constraint_HyConstraint
            	    {
            	    pushFollow(FOLLOW_parse_eu_hyvar_feature_constraint_HyConstraint_in_parse_eu_hyvar_feature_constraint_HyConstraintModel124);
            	    a0_0=parse_eu_hyvar_feature_constraint_HyConstraint();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraintModel();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a0_0 != null) {
            	    					if (a0_0 != null) {
            	    						Object value = a0_0;
            	    						addObjectToList(element, eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT_MODEL__CONSTRAINTS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_0_0_0_0, a0_0, true);
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
            		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 455, 909);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_eu_hyvar_feature_constraint_HyConstraintModel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_constraint_HyConstraintModel"



    // $ANTLR start "parse_eu_hyvar_feature_constraint_HyConstraint"
    // Hyconstraints.g:550:1: parse_eu_hyvar_feature_constraint_HyConstraint returns [eu.hyvar.feature.constraint.HyConstraint element = null] : (a0_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )? ;
    public final eu.hyvar.feature.constraint.HyConstraint parse_eu_hyvar_feature_constraint_HyConstraint() throws RecognitionException {
        eu.hyvar.feature.constraint.HyConstraint element =  null;

        int parse_eu_hyvar_feature_constraint_HyConstraint_StartIndex = input.index();

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
        eu.hyvar.feature.expression.HyExpression a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Hyconstraints.g:553:2: ( (a0_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )? )
            // Hyconstraints.g:554:2: (a0_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )?
            {
            // Hyconstraints.g:554:2: (a0_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyconstraints.g:555:3: a0_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_constraint_HyConstraint169);
            a0_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__ROOT_EXPRESSION), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 910);
            		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 911, 1365);
            	}

            // Hyconstraints.g:581:2: ( (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==33) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Hyconstraints.g:582:3: (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' )
                    {
                    // Hyconstraints.g:582:3: (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' )
                    // Hyconstraints.g:583:4: a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']'
                    {
                    a1=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_feature_constraint_HyConstraint196); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 1366, 1368);
                    			}

                    // Hyconstraints.g:597:4: ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) )
                    int alt2=3;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==DATE) ) {
                        int LA2_1 = input.LA(2);

                        if ( (LA2_1==20) ) {
                            int LA2_3 = input.LA(3);

                            if ( (LA2_3==DATE) ) {
                                alt2=1;
                            }
                            else if ( (LA2_3==39) ) {
                                alt2=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 2, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 2, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA2_0==39) ) {
                        alt2=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;

                    }
                    switch (alt2) {
                        case 1 :
                            // Hyconstraints.g:598:5: (a2= DATE ) a3= '-' (a4= DATE )
                            {
                            // Hyconstraints.g:598:5: (a2= DATE )
                            // Hyconstraints.g:599:6: a2= DATE
                            {
                            a2=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_feature_constraint_HyConstraint229); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
                            							startIncompleteElement(element);
                            						}
                            						if (a2 != null) {
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a2, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 1369);
                            				}

                            a3=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_feature_constraint_HyConstraint268); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a3, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 1370);
                            				}

                            // Hyconstraints.g:648:5: (a4= DATE )
                            // Hyconstraints.g:649:6: a4= DATE
                            {
                            a4=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_feature_constraint_HyConstraint298); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
                            							startIncompleteElement(element);
                            						}
                            						if (a4 != null) {
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a4, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 1371);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyconstraints.g:685:10: (a5= DATE ) a6= '-' a7= 'eternity'
                            {
                            // Hyconstraints.g:685:10: (a5= DATE )
                            // Hyconstraints.g:686:6: a5= DATE
                            {
                            a5=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_feature_constraint_HyConstraint354); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
                            							startIncompleteElement(element);
                            						}
                            						if (a5 != null) {
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a5, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 1372);
                            				}

                            a6=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_feature_constraint_HyConstraint393); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a6, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 1373);
                            				}

                            a7=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_feature_constraint_HyConstraint416); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 1374);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyconstraints.g:750:10: a8= 'eternity' a9= '-' (a10= DATE )
                            {
                            a8=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_feature_constraint_HyConstraint449); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a8, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 1375);
                            				}

                            a9=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_feature_constraint_HyConstraint472); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 1376);
                            				}

                            // Hyconstraints.g:778:5: (a10= DATE )
                            // Hyconstraints.g:779:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_feature_constraint_HyConstraint502); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
                            							startIncompleteElement(element);
                            						}
                            						if (a10 != null) {
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a10).getLine(), ((CommonToken) a10).getCharPositionInLine(), ((CommonToken) a10).getStartIndex(), ((CommonToken) a10).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a10, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 1377);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 1378);
                    			}

                    a11=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_feature_constraint_HyConstraint554); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a11, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				// We've found the last token for this rule. The constructed EObject is now
                    				// complete.
                    				completedElement(element, true);
                    				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 1379, 1833);
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
            		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 1834, 2288);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_eu_hyvar_feature_constraint_HyConstraint_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_constraint_HyConstraint"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction"
    // Hyconstraints.g:849:1: parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction returns [eu.hyvar.feature.expression.HyRelativeVersionRestriction element = null] : a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' ;
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

            // Hyconstraints.g:852:2: (a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' )
            // Hyconstraints.g:853:2: a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']'
            {
            a0=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction602); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_20_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 2289, 2290);
            	}

            // Hyconstraints.g:870:2: ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? )
            // Hyconstraints.g:871:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
            {
            // Hyconstraints.g:871:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
            int alt4=6;
            switch ( input.LA(1) ) {
                case 24:
                    {
                    alt4=1;
                    }
                    break;
                case 26:
                    {
                    alt4=2;
                    }
                    break;
                case 27:
                    {
                    alt4=3;
                    }
                    break;
                case 29:
                    {
                    alt4=4;
                    }
                    break;
                case 28:
                    {
                    alt4=5;
                    }
                    break;
            }

            switch (alt4) {
                case 1 :
                    // Hyconstraints.g:872:4: a1= '<'
                    {
                    a1=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction625); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:888:8: a2= '<='
                    {
                    a2=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction640); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Hyconstraints.g:904:8: a3= '='
                    {
                    a3=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction655); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a3, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 4 :
                    // Hyconstraints.g:920:8: a4= '>='
                    {
                    a4=(Token)match(input,29,FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction670); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a4, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 5 :
                    // Hyconstraints.g:936:8: a5= '>'
                    {
                    a5=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction685); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
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
            		addExpectedElement(null, 2291);
            	}

            // Hyconstraints.g:958:2: (a8= QUOTED_34_34 )
            // Hyconstraints.g:959:3: a8= QUOTED_34_34
            {
            a8=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction710); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            				startIncompleteElement(element);
            				// initialize enumeration attribute
            				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            			}
            			if (a8 != null) {
            				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyRelativeVersionRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyRelativeVersionRestrictionVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_20_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a8, element);
            				copyLocalizationInfos((CommonToken) a8, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 2292);
            	}

            a9=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction731); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_20_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		// We've found the last token for this rule. The constructed EObject is now
            		// complete.
            		completedElement(element, true);
            		addExpectedElement(null, 2293);
            		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 2294, 2748);
            		addExpectedElement(null, 2749, 2753);
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
    // Hyconstraints.g:1025:1: parse_eu_hyvar_feature_expression_HyVersionRangeRestriction returns [eu.hyvar.feature.expression.HyVersionRangeRestriction element = null] : a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' ;
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

            // Hyconstraints.g:1028:2: (a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' )
            // Hyconstraints.g:1029:2: a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']'
            {
            a0=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction760); if (state.failed) return element;

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
            		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_21_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 2754, 2755);
            	}

            // Hyconstraints.g:1053:2: ( (a1= '^' )? )
            // Hyconstraints.g:1054:3: (a1= '^' )?
            {
            // Hyconstraints.g:1054:3: (a1= '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==36) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Hyconstraints.g:1055:4: a1= '^'
                    {
                    a1=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction783); if (state.failed) return element;

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
                    				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_21_0_0_1, false, true);
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
            		addExpectedElement(null, 2756);
            	}

            // Hyconstraints.g:1084:2: (a3= QUOTED_34_34 )
            // Hyconstraints.g:1085:3: a3= QUOTED_34_34
            {
            a3=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction808); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
            				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionLowerVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_21_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            				copyLocalizationInfos((CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 2757);
            	}

            a4=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction829); if (state.failed) return element;

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
            		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_21_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 2758, 2759);
            	}

            // Hyconstraints.g:1158:2: ( (a5= '^' )? )
            // Hyconstraints.g:1159:3: (a5= '^' )?
            {
            // Hyconstraints.g:1159:3: (a5= '^' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==36) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Hyconstraints.g:1160:4: a5= '^'
                    {
                    a5=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction852); if (state.failed) return element;

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
                    				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_21_0_0_4, false, true);
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
            		addExpectedElement(null, 2760);
            	}

            // Hyconstraints.g:1189:2: (a7= QUOTED_34_34 )
            // Hyconstraints.g:1190:3: a7= QUOTED_34_34
            {
            a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction877); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
            				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionUpperVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_21_0_0_5, proxy, true);
            				copyLocalizationInfos((CommonToken) a7, element);
            				copyLocalizationInfos((CommonToken) a7, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 2761);
            	}

            a8=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction898); if (state.failed) return element;

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
            		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_21_0_0_6, null, true);
            		copyLocalizationInfos((CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		// We've found the last token for this rule. The constructed EObject is now
            		// complete.
            		completedElement(element, true);
            		addExpectedElement(null, 2762);
            		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 2763, 3217);
            		addExpectedElement(null, 3218, 3222);
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
    // Hyconstraints.g:1270:1: parse_eu_hyvar_dataValues_HyEnum returns [eu.hyvar.dataValues.HyEnum element = null] : a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? ;
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

            // Hyconstraints.g:1273:2: (a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? )
            // Hyconstraints.g:1274:2: a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            {
            a0=(Token)match(input,31,FOLLOW_31_in_parse_eu_hyvar_dataValues_HyEnum927); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 3223);
            	}

            // Hyconstraints.g:1288:2: (a1= IDENTIFIER_TOKEN )
            // Hyconstraints.g:1289:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum945); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 3224);
            	}

            a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum966); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 3225);
            		addExpectedElement(null, 3226);
            	}

            // Hyconstraints.g:1339:2: ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==32) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Hyconstraints.g:1340:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    {
                    // Hyconstraints.g:1340:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    // Hyconstraints.g:1341:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    {
                    // Hyconstraints.g:1341:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    // Hyconstraints.g:1342:5: a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum995);
                    a3_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    						retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 3227, 3228);
                    			}

                    // Hyconstraints.g:1367:4: ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==19) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // Hyconstraints.g:1368:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    {
                    	    // Hyconstraints.g:1368:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    // Hyconstraints.g:1369:6: a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    {
                    	    a4=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum1036); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((CommonToken)a4, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 3229);
                    	    					}

                    	    // Hyconstraints.g:1383:6: (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    // Hyconstraints.g:1384:7: a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1070);
                    	    a5_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    							if (terminateParsing) {
                    	    								throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    								retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_1, a5_0, true);
                    	    								copyLocalizationInfos(a5_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, 3230, 3231);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 3232, 3233);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 3234);
            	}

            a6=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum1144); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 3235);
            	}

            // Hyconstraints.g:1437:2: ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==33) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Hyconstraints.g:1438:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    {
                    // Hyconstraints.g:1438:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    // Hyconstraints.g:1439:4: a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']'
                    {
                    a7=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnum1167); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a7, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 3236, 3238);
                    			}

                    // Hyconstraints.g:1453:4: ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) )
                    int alt9=3;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==DATE) ) {
                        int LA9_1 = input.LA(2);

                        if ( (LA9_1==20) ) {
                            int LA9_3 = input.LA(3);

                            if ( (LA9_3==DATE) ) {
                                alt9=1;
                            }
                            else if ( (LA9_3==35) ) {
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
                    else if ( (LA9_0==39) ) {
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
                            // Hyconstraints.g:1454:5: (a8= DATE ) a9= '-' (a10= DATE )
                            {
                            // Hyconstraints.g:1454:5: (a8= DATE )
                            // Hyconstraints.g:1455:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1200); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3239);
                            				}

                            a9=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1239); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3240);
                            				}

                            // Hyconstraints.g:1504:5: (a10= DATE )
                            // Hyconstraints.g:1505:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1269); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a10 != null) {
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a10, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3241);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyconstraints.g:1541:10: (a11= DATE ) a12= '-'
                            {
                            // Hyconstraints.g:1541:10: (a11= DATE )
                            // Hyconstraints.g:1542:6: a11= DATE
                            {
                            a11=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1325); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a11 != null) {
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a11, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3242);
                            				}

                            a12=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1364); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3243);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyconstraints.g:1592:10: a13= 'eternity' a14= '-' (a15= DATE )
                            {
                            a13=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnum1397); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3244);
                            				}

                            a14=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1420); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a14, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3245);
                            				}

                            // Hyconstraints.g:1620:5: (a15= DATE )
                            // Hyconstraints.g:1621:6: a15= DATE
                            {
                            a15=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1450); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a15 != null) {
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a15, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3246);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 3247);
                    			}

                    a16=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnum1502); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
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
    // Hyconstraints.g:1689:1: parse_eu_hyvar_dataValues_HyEnumLiteral returns [eu.hyvar.dataValues.HyEnumLiteral element = null] : a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
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

            // Hyconstraints.g:1692:2: (a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hyconstraints.g:1693:2: a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            a0=(Token)match(input,32,FOLLOW_32_in_parse_eu_hyvar_dataValues_HyEnumLiteral1550); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 3248);
            	}

            // Hyconstraints.g:1707:2: (a1= IDENTIFIER_TOKEN )
            // Hyconstraints.g:1708:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral1568); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 3249);
            	}

            a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnumLiteral1589); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 3250);
            	}

            // Hyconstraints.g:1757:2: (a3= INTEGER_LITERAL )
            // Hyconstraints.g:1758:3: a3= INTEGER_LITERAL
            {
            a3=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral1607); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_3, resolved, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 3251);
            	}

            a4=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral1628); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 3252, 3254);
            	}

            // Hyconstraints.g:1807:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==33) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // Hyconstraints.g:1808:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hyconstraints.g:1808:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hyconstraints.g:1809:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnumLiteral1651); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 3255, 3257);
                    			}

                    // Hyconstraints.g:1823:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) )
                    int alt11=3;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==DATE) ) {
                        int LA11_1 = input.LA(2);

                        if ( (LA11_1==20) ) {
                            int LA11_3 = input.LA(3);

                            if ( (LA11_3==DATE) ) {
                                alt11=1;
                            }
                            else if ( (LA11_3==39) ) {
                                alt11=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 11, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 11, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA11_0==39) ) {
                        alt11=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;

                    }
                    switch (alt11) {
                        case 1 :
                            // Hyconstraints.g:1824:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hyconstraints.g:1824:5: (a6= DATE )
                            // Hyconstraints.g:1825:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1684); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a6 != null) {
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a6, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3258);
                            				}

                            a7=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1723); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3259);
                            				}

                            // Hyconstraints.g:1874:5: (a8= DATE )
                            // Hyconstraints.g:1875:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1753); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3260);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyconstraints.g:1911:10: (a9= DATE ) a10= '-' a11= 'eternity'
                            {
                            // Hyconstraints.g:1911:10: (a9= DATE )
                            // Hyconstraints.g:1912:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1809); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a9 != null) {
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a9, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3261);
                            				}

                            a10=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1848); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a10, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3262);
                            				}

                            a11=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumLiteral1871); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a11, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3263);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyconstraints.g:1976:10: a12= 'eternity' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumLiteral1904); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3264);
                            				}

                            a13=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1927); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3265);
                            				}

                            // Hyconstraints.g:2004:5: (a14= DATE )
                            // Hyconstraints.g:2005:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1957); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a14 != null) {
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a14, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, 3266);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 3267);
                    			}

                    a15=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnumLiteral2009); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a15, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				// We've found the last token for this rule. The constructed EObject is now
                    				// complete.
                    				completedElement(element, true);
                    				addExpectedElement(null, 3268, 3269);
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
            		addExpectedElement(null, 3270, 3271);
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



    // $ANTLR start "parseop_HyExpression_level_0"
    // Hyconstraints.g:2075:1: parseop_HyExpression_level_0 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_0() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_0_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Hyconstraints.g:2078:2: (leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) )
            // Hyconstraints.g:2079:2: leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02057);
            leftArg=parseop_HyExpression_level_1();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:2079:41: ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            else if ( (LA14_0==EOF||LA14_0==IDENTIFIER_TOKEN||LA14_0==QUOTED_34_34||LA14_0==12||(LA14_0 >= 15 && LA14_0 <= 16)||LA14_0==30||LA14_0==33||(LA14_0 >= 40 && LA14_0 <= 42)) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // Hyconstraints.g:2079:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    {
                    // Hyconstraints.g:2079:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==25) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // Hyconstraints.g:2080:3: () a0= '<->' rightArg= parseop_HyExpression_level_1
                    	    {
                    	    // Hyconstraints.g:2080:3: ()
                    	    // Hyconstraints.g:2080:4: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,25,FOLLOW_25_in_parseop_HyExpression_level_02077); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    			if (element == null) {
                    	    				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyEquivalenceExpression();
                    	    				startIncompleteElement(element);
                    	    			}
                    	    			collectHiddenTokens(element);
                    	    			retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_0_0_0_1, null, true);
                    	    			copyLocalizationInfos((CommonToken)a0, element);
                    	    		}

                    	    if ( state.backtracking==0 ) {
                    	    			// expected elements (follow set)
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), 3272, 3726);
                    	    		}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02094);
                    	    rightArg=parseop_HyExpression_level_1();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    			if (terminateParsing) {
                    	    				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_0_0_0_0, leftArg, true);
                    	    				copyLocalizationInfos(leftArg, element);
                    	    			}
                    	    		}

                    	    if ( state.backtracking==0 ) {
                    	    			if (terminateParsing) {
                    	    				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_0_0_0_2, rightArg, true);
                    	    				copyLocalizationInfos(rightArg, element);
                    	    			}
                    	    		}

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyconstraints.g:2135:21: 
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
            if ( state.backtracking>0 ) { memoize(input, 8, parseop_HyExpression_level_0_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_0"



    // $ANTLR start "parseop_HyExpression_level_1"
    // Hyconstraints.g:2140:1: parseop_HyExpression_level_1 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_2 ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_1() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_1_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Hyconstraints.g:2143:9: (leftArg= parseop_HyExpression_level_2 ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |) )
            // Hyconstraints.g:2144:9: leftArg= parseop_HyExpression_level_2 ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_12140);
            leftArg=parseop_HyExpression_level_2();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:2144:39: ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |)
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==21) ) {
                alt16=1;
            }
            else if ( (LA16_0==EOF||LA16_0==IDENTIFIER_TOKEN||LA16_0==QUOTED_34_34||LA16_0==12||(LA16_0 >= 15 && LA16_0 <= 16)||LA16_0==25||LA16_0==30||LA16_0==33||(LA16_0 >= 40 && LA16_0 <= 42)) ) {
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
                    // Hyconstraints.g:2144:40: ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+
                    {
                    // Hyconstraints.g:2144:40: ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==21) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // Hyconstraints.g:2145:2: () a0= '->' rightArg= parseop_HyExpression_level_2
                    	    {
                    	    // Hyconstraints.g:2145:2: ()
                    	    // Hyconstraints.g:2145:3: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,21,FOLLOW_21_in_parseop_HyExpression_level_12156); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    		if (element == null) {
                    	    			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyImpliesExpression();
                    	    			startIncompleteElement(element);
                    	    		}
                    	    		collectHiddenTokens(element);
                    	    		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_1_0_0_1, null, true);
                    	    		copyLocalizationInfos((CommonToken)a0, element);
                    	    	}

                    	    if ( state.backtracking==0 ) {
                    	    		// expected elements (follow set)
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), 3727, 4181);
                    	    	}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_12170);
                    	    rightArg=parseop_HyExpression_level_2();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    		if (terminateParsing) {
                    	    			throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    			retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_1_0_0_0, leftArg, true);
                    	    			copyLocalizationInfos(leftArg, element);
                    	    		}
                    	    	}

                    	    if ( state.backtracking==0 ) {
                    	    		if (terminateParsing) {
                    	    			throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    			retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_1_0_0_2, rightArg, true);
                    	    			copyLocalizationInfos(rightArg, element);
                    	    		}
                    	    	}

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyconstraints.g:2200:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 9, parseop_HyExpression_level_1_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_1"



    // $ANTLR start "parseop_HyExpression_level_2"
    // Hyconstraints.g:2205:1: parseop_HyExpression_level_2 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_3 ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_2() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_2_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Hyconstraints.g:2208:9: (leftArg= parseop_HyExpression_level_3 ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |) )
            // Hyconstraints.g:2209:9: leftArg= parseop_HyExpression_level_3 ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_22211);
            leftArg=parseop_HyExpression_level_3();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:2209:39: ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |)
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==43) ) {
                alt18=1;
            }
            else if ( (LA18_0==EOF||LA18_0==IDENTIFIER_TOKEN||LA18_0==QUOTED_34_34||LA18_0==12||(LA18_0 >= 15 && LA18_0 <= 16)||LA18_0==21||LA18_0==25||LA18_0==30||LA18_0==33||(LA18_0 >= 40 && LA18_0 <= 42)) ) {
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
                    // Hyconstraints.g:2209:40: ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+
                    {
                    // Hyconstraints.g:2209:40: ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==43) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // Hyconstraints.g:2210:0: () a0= '||' rightArg= parseop_HyExpression_level_3
                    	    {
                    	    // Hyconstraints.g:2210:2: ()
                    	    // Hyconstraints.g:2210:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,43,FOLLOW_43_in_parseop_HyExpression_level_22224); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    	if (element == null) {
                    	    		element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyOrExpression();
                    	    		startIncompleteElement(element);
                    	    	}
                    	    	collectHiddenTokens(element);
                    	    	retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_2_0_0_1, null, true);
                    	    	copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    	// expected elements (follow set)
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), 4182, 4636);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_22235);
                    	    rightArg=parseop_HyExpression_level_3();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    	if (terminateParsing) {
                    	    		throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_2_0_0_0, leftArg, true);
                    	    		copyLocalizationInfos(leftArg, element);
                    	    	}
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    	if (terminateParsing) {
                    	    		throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_2_0_0_2, rightArg, true);
                    	    		copyLocalizationInfos(rightArg, element);
                    	    	}
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Hyconstraints.g:2265:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 10, parseop_HyExpression_level_2_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_2"



    // $ANTLR start "parseop_HyExpression_level_3"
    // Hyconstraints.g:2270:1: parseop_HyExpression_level_3 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_14 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_3() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_3_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Hyconstraints.g:2273:9: (leftArg= parseop_HyExpression_level_14 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |) )
            // Hyconstraints.g:2274:9: leftArg= parseop_HyExpression_level_14 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_32273);
            leftArg=parseop_HyExpression_level_14();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:2274:40: ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |)
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==14) ) {
                alt20=1;
            }
            else if ( (LA20_0==EOF||LA20_0==IDENTIFIER_TOKEN||LA20_0==QUOTED_34_34||LA20_0==12||(LA20_0 >= 15 && LA20_0 <= 16)||LA20_0==21||LA20_0==25||LA20_0==30||LA20_0==33||(LA20_0 >= 40 && LA20_0 <= 43)) ) {
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
                    // Hyconstraints.g:2274:41: ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+
                    {
                    // Hyconstraints.g:2274:41: ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==14) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // Hyconstraints.g:2275:0: () a0= '&&' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Hyconstraints.g:2275:2: ()
                    	    // Hyconstraints.g:2275:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,14,FOLLOW_14_in_parseop_HyExpression_level_32286); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAndExpression();
                    	    	startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_3_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), 4637, 5091);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_32297);
                    	    rightArg=parseop_HyExpression_level_14();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    	throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    	retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_3_0_0_0, leftArg, true);
                    	    	copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    	throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    	retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_3_0_0_2, rightArg, true);
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
                    // Hyconstraints.g:2330:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 11, parseop_HyExpression_level_3_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_3"



    // $ANTLR start "parseop_HyExpression_level_14"
    // Hyconstraints.g:2335:1: parseop_HyExpression_level_14 returns [eu.hyvar.feature.expression.HyExpression element = null] : (a0= '!' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 );
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_14() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_14_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression arg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Hyconstraints.g:2338:0: (a0= '!' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==12) ) {
                alt21=1;
            }
            else if ( (LA21_0==IDENTIFIER_TOKEN||LA21_0==QUOTED_34_34||LA21_0==15||LA21_0==30||(LA21_0 >= 40 && LA21_0 <= 42)) ) {
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
                    // Hyconstraints.g:2339:0: a0= '!' arg= parseop_HyExpression_level_15
                    {
                    a0=(Token)match(input,12,FOLLOW_12_in_parseop_HyExpression_level_142335); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNotExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_4_0_0_0, null, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    }

                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), 5092, 5546);
                    }

                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142346);
                    arg=parseop_HyExpression_level_15();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_4_0_0_1, arg, true);
                    copyLocalizationInfos(arg, element);
                    }
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:2374:5: arg= parseop_HyExpression_level_15
                    {
                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142356);
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
            if ( state.backtracking>0 ) { memoize(input, 12, parseop_HyExpression_level_14_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_14"



    // $ANTLR start "parseop_HyExpression_level_15"
    // Hyconstraints.g:2377:1: parseop_HyExpression_level_15 returns [eu.hyvar.feature.expression.HyExpression element = null] : (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyBooleanValueExpression |c4= parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression );
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_15() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_15_StartIndex = input.index();

        eu.hyvar.feature.expression.HyNestedExpression c0 =null;

        eu.hyvar.feature.expression.HyFeatureReferenceExpression c1 =null;

        eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression c2 =null;

        eu.hyvar.feature.expression.HyBooleanValueExpression c3 =null;

        eu.hyvar.feature.expression.HyArithmeticalComparisonExpression c4 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Hyconstraints.g:2380:0: (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyBooleanValueExpression |c4= parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression )
            int alt22=5;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt22=1;
                }
                break;
            case IDENTIFIER_TOKEN:
            case QUOTED_34_34:
                {
                alt22=2;
                }
                break;
            case 30:
                {
                alt22=3;
                }
                break;
            case 40:
            case 41:
                {
                alt22=4;
                }
                break;
            case 42:
                {
                alt22=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }

            switch (alt22) {
                case 1 :
                    // Hyconstraints.g:2381:0: c0= parse_eu_hyvar_feature_expression_HyNestedExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_152378);
                    c0=parse_eu_hyvar_feature_expression_HyNestedExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:2382:2: c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_152386);
                    c1=parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hyconstraints.g:2383:2: c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_152394);
                    c2=parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Hyconstraints.g:2384:2: c3= parse_eu_hyvar_feature_expression_HyBooleanValueExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_152402);
                    c3=parse_eu_hyvar_feature_expression_HyBooleanValueExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Hyconstraints.g:2385:2: c4= parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression_in_parseop_HyExpression_level_152410);
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
            if ( state.backtracking>0 ) { memoize(input, 13, parseop_HyExpression_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_15"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyNestedExpression"
    // Hyconstraints.g:2388:1: parse_eu_hyvar_feature_expression_HyNestedExpression returns [eu.hyvar.feature.expression.HyNestedExpression element = null] : a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyNestedExpression parse_eu_hyvar_feature_expression_HyNestedExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyNestedExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Hyconstraints.g:2391:4: (a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Hyconstraints.g:2392:4: a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedExpression2432); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_5_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), 5547, 6001);
            }

            // Hyconstraints.g:2406:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyconstraints.g:2407:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression2445);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_5_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 6002);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression2457); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_5_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 6003);
            addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 6004, 6458);
            addExpectedElement(null, 6459, 6463);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyNestedExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression"
    // Hyconstraints.g:2453:1: parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyFeatureReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? ;
    public final eu.hyvar.feature.expression.HyFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        eu.hyvar.feature.expression.HyVersionRestriction a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Hyconstraints.g:2456:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? )
            // Hyconstraints.g:2457:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            {
            // Hyconstraints.g:2457:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==QUOTED_34_34) ) {
                alt23=1;
            }
            else if ( (LA23_0==IDENTIFIER_TOKEN) ) {
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
                    // Hyconstraints.g:2458:0: (a0= QUOTED_34_34 )
                    {
                    // Hyconstraints.g:2458:4: (a0= QUOTED_34_34 )
                    // Hyconstraints.g:2459:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2487); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    	throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                    }
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
                    	startIncompleteElement(element);
                    }
                    if (a0 != null) {
                    	eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    	tokenResolver.setOptions(getOptions());
                    	eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                    	tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    	Object resolvedObject = result.getResolvedToken();
                    	if (resolvedObject == null) {
                    		addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
                    	}
                    	String resolved = (String) resolvedObject;
                    	eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    	collectHiddenTokens(element);
                    	registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    	if (proxy != null) {
                    		Object value = proxy;
                    		element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    		completedElement(value, false);
                    	}
                    	collectHiddenTokens(element);
                    	retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_6_0_0_0_0_0_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a0, element);
                    	copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 6464, 6465);
                    addExpectedElement(null, 6466);
                    addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 6467, 6921);
                    addExpectedElement(null, 6922, 6926);
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:2502:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyconstraints.g:2502:2: (a1= IDENTIFIER_TOKEN )
                    // Hyconstraints.g:2503:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2504); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    	throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                    }
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
                    	startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    	eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    	tokenResolver.setOptions(getOptions());
                    	eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                    	tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    	Object resolvedObject = result.getResolvedToken();
                    	if (resolvedObject == null) {
                    		addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    	}
                    	String resolved = (String) resolvedObject;
                    	eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    	collectHiddenTokens(element);
                    	registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    	if (proxy != null) {
                    		Object value = proxy;
                    		element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    		completedElement(value, false);
                    	}
                    	collectHiddenTokens(element);
                    	retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_6_0_0_0_0_1_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a1, element);
                    	copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 6927, 6928);
                    addExpectedElement(null, 6929);
                    addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 6930, 7384);
                    addExpectedElement(null, 7385, 7389);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 7390, 7391);
            addExpectedElement(null, 7392);
            addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 7393, 7847);
            addExpectedElement(null, 7848, 7852);
            }

            // Hyconstraints.g:2554:0: ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==33) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==QUOTED_34_34||LA24_1==24||(LA24_1 >= 26 && LA24_1 <= 29)||LA24_1==36) ) {
                    alt24=1;
                }
            }
            switch (alt24) {
                case 1 :
                    // Hyconstraints.g:2555:0: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    {
                    // Hyconstraints.g:2555:6: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    // Hyconstraints.g:2556:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    {
                    // Hyconstraints.g:2556:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    // Hyconstraints.g:2557:6: a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2528);
                    a2_0=parse_eu_hyvar_feature_expression_HyVersionRestriction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    	if (terminateParsing) {
                    		throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_6_0_0_1_0_0_0, a2_0, true);
                    		copyLocalizationInfos(a2_0, element);
                    	}
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    // We've found the last token for this rule. The constructed EObject is now
                    // complete.
                    completedElement(element, true);
                    addExpectedElement(null, 7853);
                    addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 7854, 8308);
                    addExpectedElement(null, 8309, 8313);
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
            addExpectedElement(null, 8314);
            addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 8315, 8769);
            addExpectedElement(null, 8770, 8774);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression"
    // Hyconstraints.g:2601:1: parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element = null] : a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ;
    public final eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyVersionRestriction a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Hyconstraints.g:2604:4: (a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
            // Hyconstraints.g:2605:4: a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            {
            a0=(Token)match(input,30,FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2563); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_7_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 8775, 8776);
            }

            // Hyconstraints.g:2619:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==QUOTED_34_34) ) {
                alt25=1;
            }
            else if ( (LA25_0==IDENTIFIER_TOKEN) ) {
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
                    // Hyconstraints.g:2620:0: (a1= QUOTED_34_34 )
                    {
                    // Hyconstraints.g:2620:4: (a1= QUOTED_34_34 )
                    // Hyconstraints.g:2621:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2578); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    	throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                    }
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
                    	startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    	eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    	tokenResolver.setOptions(getOptions());
                    	eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                    	tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    	Object resolvedObject = result.getResolvedToken();
                    	if (resolvedObject == null) {
                    		addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    	}
                    	String resolved = (String) resolvedObject;
                    	eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    	collectHiddenTokens(element);
                    	registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    	if (proxy != null) {
                    		Object value = proxy;
                    		element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    		completedElement(value, false);
                    	}
                    	collectHiddenTokens(element);
                    	retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_0_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a1, element);
                    	copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 8777, 8778);
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:2661:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hyconstraints.g:2661:2: (a2= IDENTIFIER_TOKEN )
                    // Hyconstraints.g:2662:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2595); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    	throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                    }
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
                    	startIncompleteElement(element);
                    }
                    if (a2 != null) {
                    	eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    	tokenResolver.setOptions(getOptions());
                    	eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                    	tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    	Object resolvedObject = result.getResolvedToken();
                    	if (resolvedObject == null) {
                    		addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                    	}
                    	String resolved = (String) resolvedObject;
                    	eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    	collectHiddenTokens(element);
                    	registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    	if (proxy != null) {
                    		Object value = proxy;
                    		element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    		completedElement(value, false);
                    	}
                    	collectHiddenTokens(element);
                    	retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_1_0, proxy, true);
                    	copyLocalizationInfos((CommonToken) a2, element);
                    	copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 8779, 8780);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 8781, 8782);
            }

            // Hyconstraints.g:2707:6: (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            // Hyconstraints.g:2708:6: a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2615);
            a3_0=parse_eu_hyvar_feature_expression_HyVersionRestriction();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_7_0_0_2, a3_0, true);
            copyLocalizationInfos(a3_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 8783);
            addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 8784, 9238);
            addExpectedElement(null, 9239, 9243);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"
    // Hyconstraints.g:2740:1: parse_eu_hyvar_feature_expression_HyBooleanValueExpression returns [eu.hyvar.feature.expression.HyBooleanValueExpression element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.feature.expression.HyBooleanValueExpression parse_eu_hyvar_feature_expression_HyBooleanValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyBooleanValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Hyconstraints.g:2743:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hyconstraints.g:2744:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hyconstraints.g:2744:0: ( (a0= 'true' |a1= 'false' ) )
            // Hyconstraints.g:2745:0: (a0= 'true' |a1= 'false' )
            {
            // Hyconstraints.g:2745:0: (a0= 'true' |a1= 'false' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==41) ) {
                alt26=1;
            }
            else if ( (LA26_0==40) ) {
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
                    // Hyconstraints.g:2746:0: a0= 'true'
                    {
                    a0=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2646); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_8_0_0_0, true, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    // set value of boolean attribute
                    Object value = true;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:2759:2: a1= 'false'
                    {
                    a1=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2655); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_8_0_0_0, false, true);
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
            addExpectedElement(null, 9244);
            addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 9245, 9699);
            addExpectedElement(null, 9700, 9704);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression"
    // Hyconstraints.g:2786:1: parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression returns [eu.hyvar.feature.expression.HyArithmeticalComparisonExpression element = null] : a0= '{' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) ) (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a11= '}' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Hyconstraints.g:2789:4: (a0= '{' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) ) (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a11= '}' )
            // Hyconstraints.g:2790:4: a0= '{' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) ) (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a11= '}'
            {
            a0=(Token)match(input,42,FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2685); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_9_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(), 9705, 12312);
            }

            // Hyconstraints.g:2804:6: (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression )
            // Hyconstraints.g:2805:6: a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2698);
            a1_0=parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_9_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 12313);
            }

            // Hyconstraints.g:2830:0: ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) )
            // Hyconstraints.g:2831:0: (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' )
            {
            // Hyconstraints.g:2831:0: (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' )
            int alt27=6;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt27=1;
                }
                break;
            case 26:
                {
                alt27=2;
                }
                break;
            case 27:
                {
                alt27=3;
                }
                break;
            case 13:
                {
                alt27=4;
                }
                break;
            case 29:
                {
                alt27=5;
                }
                break;
            case 28:
                {
                alt27=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }

            switch (alt27) {
                case 1 :
                    // Hyconstraints.g:2832:0: a2= '<'
                    {
                    a2=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2714); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    copyLocalizationInfos((CommonToken)a2, element);
                    // set value of enumeration attribute
                    Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_LESS_OPERATOR_VALUE).getInstance();
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:2845:2: a3= '<='
                    {
                    a3=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2723); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    copyLocalizationInfos((CommonToken)a3, element);
                    // set value of enumeration attribute
                    Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_LESS_OR_EQUAL_OPERATOR_VALUE).getInstance();
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 3 :
                    // Hyconstraints.g:2858:2: a4= '='
                    {
                    a4=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2732); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    copyLocalizationInfos((CommonToken)a4, element);
                    // set value of enumeration attribute
                    Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_EQUAL_OPERATOR_VALUE).getInstance();
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 4 :
                    // Hyconstraints.g:2871:2: a5= '!='
                    {
                    a5=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2741); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    copyLocalizationInfos((CommonToken)a5, element);
                    // set value of enumeration attribute
                    Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_NOT_EQUAL_OPERATOR_VALUE).getInstance();
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 5 :
                    // Hyconstraints.g:2884:2: a6= '>='
                    {
                    a6=(Token)match(input,29,FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2750); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
                    copyLocalizationInfos((CommonToken)a6, element);
                    // set value of enumeration attribute
                    Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_GREATER_OR_EQUAL_OPERATOR_VALUE).getInstance();
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 6 :
                    // Hyconstraints.g:2897:2: a7= '>'
                    {
                    a7=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2759); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
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
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(), 12314, 14921);
            }

            // Hyconstraints.g:2917:7: (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression )
            // Hyconstraints.g:2918:7: a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2776);
            a10_0=parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_9_0_0_3, a10_0, true);
            copyLocalizationInfos(a10_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 14922);
            }

            a11=(Token)match(input,44,FOLLOW_44_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2788); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_9_0_0_4, null, true);
            copyLocalizationInfos((CommonToken)a11, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 14923);
            addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 14924, 15378);
            addExpectedElement(null, 15379, 15383);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_4"
    // Hyconstraints.g:2964:1: parseop_HyArithmeticalValueExpression_level_4 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_5 ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_4() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_4_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Hyconstraints.g:2967:9: (leftArg= parseop_HyArithmeticalValueExpression_level_5 ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |) )
            // Hyconstraints.g:2968:9: leftArg= parseop_HyArithmeticalValueExpression_level_5 ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_42814);
            leftArg=parseop_HyArithmeticalValueExpression_level_5();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:2968:56: ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |)
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==34) ) {
                alt29=1;
            }
            else if ( (LA29_0==13||LA29_0==16||LA29_0==24||(LA29_0 >= 26 && LA29_0 <= 29)||LA29_0==44) ) {
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
                    // Hyconstraints.g:2968:57: ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+
                    {
                    // Hyconstraints.g:2968:57: ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==34) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // Hyconstraints.g:2969:0: () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5
                    	    {
                    	    // Hyconstraints.g:2969:2: ()
                    	    // Hyconstraints.g:2969:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,34,FOLLOW_34_in_parseop_HyArithmeticalValueExpression_level_42827); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyModuloExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_12_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), 15384, 17991);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_42838);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_5();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_12_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_12_0_0_2, rightArg, true);
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
                    // Hyconstraints.g:3024:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 19, parseop_HyArithmeticalValueExpression_level_4_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_4"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_5"
    // Hyconstraints.g:3029:1: parseop_HyArithmeticalValueExpression_level_5 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_6 ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_5() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_5_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Hyconstraints.g:3032:9: (leftArg= parseop_HyArithmeticalValueExpression_level_6 ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |) )
            // Hyconstraints.g:3033:9: leftArg= parseop_HyArithmeticalValueExpression_level_6 ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_52876);
            leftArg=parseop_HyArithmeticalValueExpression_level_6();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:3033:56: ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |)
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==18) ) {
                alt31=1;
            }
            else if ( (LA31_0==EOF||LA31_0==13||LA31_0==16||LA31_0==24||(LA31_0 >= 26 && LA31_0 <= 29)||LA31_0==34||LA31_0==44) ) {
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
                    // Hyconstraints.g:3033:57: ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+
                    {
                    // Hyconstraints.g:3033:57: ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+
                    int cnt30=0;
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==18) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // Hyconstraints.g:3034:0: () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6
                    	    {
                    	    // Hyconstraints.g:3034:2: ()
                    	    // Hyconstraints.g:3034:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,18,FOLLOW_18_in_parseop_HyArithmeticalValueExpression_level_52889); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAdditionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_10_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), 17992, 20599);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_52900);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_6();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_10_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_10_0_0_2, rightArg, true);
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
                    // Hyconstraints.g:3089:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 20, parseop_HyArithmeticalValueExpression_level_5_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_5"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_6"
    // Hyconstraints.g:3094:1: parseop_HyArithmeticalValueExpression_level_6 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_7 ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_6() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_6_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Hyconstraints.g:3097:9: (leftArg= parseop_HyArithmeticalValueExpression_level_7 ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |) )
            // Hyconstraints.g:3098:9: leftArg= parseop_HyArithmeticalValueExpression_level_7 ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_62938);
            leftArg=parseop_HyArithmeticalValueExpression_level_7();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:3098:56: ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |)
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==20) ) {
                alt33=1;
            }
            else if ( (LA33_0==EOF||LA33_0==13||LA33_0==16||LA33_0==18||LA33_0==24||(LA33_0 >= 26 && LA33_0 <= 29)||LA33_0==34||LA33_0==44) ) {
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
                    // Hyconstraints.g:3098:57: ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+
                    {
                    // Hyconstraints.g:3098:57: ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+
                    int cnt32=0;
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==20) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // Hyconstraints.g:3099:0: () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7
                    	    {
                    	    // Hyconstraints.g:3099:2: ()
                    	    // Hyconstraints.g:3099:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,20,FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_62951); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHySubtractionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_11_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), 20600, 23207);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_62962);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_7();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_11_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_11_0_0_2, rightArg, true);
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
                    // Hyconstraints.g:3154:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 21, parseop_HyArithmeticalValueExpression_level_6_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_6"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_7"
    // Hyconstraints.g:3159:1: parseop_HyArithmeticalValueExpression_level_7 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_8 ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_7() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_7_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Hyconstraints.g:3162:9: (leftArg= parseop_HyArithmeticalValueExpression_level_8 ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |) )
            // Hyconstraints.g:3163:9: leftArg= parseop_HyArithmeticalValueExpression_level_8 ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73000);
            leftArg=parseop_HyArithmeticalValueExpression_level_8();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:3163:56: ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |)
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==17) ) {
                alt35=1;
            }
            else if ( (LA35_0==EOF||LA35_0==13||LA35_0==16||LA35_0==18||LA35_0==20||LA35_0==24||(LA35_0 >= 26 && LA35_0 <= 29)||LA35_0==34||LA35_0==44) ) {
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
                    // Hyconstraints.g:3163:57: ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+
                    {
                    // Hyconstraints.g:3163:57: ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+
                    int cnt34=0;
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==17) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // Hyconstraints.g:3164:0: () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8
                    	    {
                    	    // Hyconstraints.g:3164:2: ()
                    	    // Hyconstraints.g:3164:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,17,FOLLOW_17_in_parseop_HyArithmeticalValueExpression_level_73013); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMultiplicationExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_13_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), 23208, 25815);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73024);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_8();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_13_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_13_0_0_2, rightArg, true);
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
                    // Hyconstraints.g:3219:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 22, parseop_HyArithmeticalValueExpression_level_7_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_7"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_8"
    // Hyconstraints.g:3224:1: parseop_HyArithmeticalValueExpression_level_8 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_11 ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_8() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_8_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Hyconstraints.g:3227:9: (leftArg= parseop_HyArithmeticalValueExpression_level_11 ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |) )
            // Hyconstraints.g:3228:9: leftArg= parseop_HyArithmeticalValueExpression_level_11 ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83062);
            leftArg=parseop_HyArithmeticalValueExpression_level_11();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:3228:57: ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |)
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==23) ) {
                alt37=1;
            }
            else if ( (LA37_0==EOF||LA37_0==13||(LA37_0 >= 16 && LA37_0 <= 18)||LA37_0==20||LA37_0==24||(LA37_0 >= 26 && LA37_0 <= 29)||LA37_0==34||LA37_0==44) ) {
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
                    // Hyconstraints.g:3228:58: ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+
                    {
                    // Hyconstraints.g:3228:58: ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+
                    int cnt36=0;
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==23) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // Hyconstraints.g:3229:0: () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11
                    	    {
                    	    // Hyconstraints.g:3229:2: ()
                    	    // Hyconstraints.g:3229:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,23,FOLLOW_23_in_parseop_HyArithmeticalValueExpression_level_83075); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyDivisionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_14_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), 25816, 28423);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83086);
                    	    rightArg=parseop_HyArithmeticalValueExpression_level_11();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_14_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_14_0_0_2, rightArg, true);
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
                    // Hyconstraints.g:3284:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 23, parseop_HyArithmeticalValueExpression_level_8_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_8"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_11"
    // Hyconstraints.g:3289:1: parseop_HyArithmeticalValueExpression_level_11 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : (c0= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression |c1= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyValueExpression );
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_11() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_11_StartIndex = input.index();

        eu.hyvar.feature.expression.HyAttributeReferenceExpression c0 =null;

        eu.hyvar.feature.expression.HyContextInformationReferenceExpression c1 =null;

        eu.hyvar.feature.expression.HyValueExpression c2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Hyconstraints.g:3292:0: (c0= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression |c1= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyValueExpression )
            int alt38=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER_TOKEN:
            case QUOTED_34_34:
                {
                alt38=1;
                }
                break;
            case 37:
                {
                alt38=2;
                }
                break;
            case INTEGER_LITERAL:
            case 38:
            case 40:
            case 41:
                {
                alt38=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }

            switch (alt38) {
                case 1 :
                    // Hyconstraints.g:3293:0: c0= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_113124);
                    c0=parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:3294:2: c1= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_113132);
                    c1=parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hyconstraints.g:3295:2: c2= parse_eu_hyvar_feature_expression_HyValueExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyArithmeticalValueExpression_level_113140);
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
            if ( state.backtracking>0 ) { memoize(input, 24, parseop_HyArithmeticalValueExpression_level_11_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_11"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression"
    // Hyconstraints.g:3298:1: parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression returns [eu.hyvar.feature.expression.HyAttributeReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) ;
    public final eu.hyvar.feature.expression.HyAttributeReferenceExpression parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyAttributeReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }

            // Hyconstraints.g:3301:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) )
            // Hyconstraints.g:3302:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN )
            {
            // Hyconstraints.g:3302:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==QUOTED_34_34) ) {
                alt39=1;
            }
            else if ( (LA39_0==IDENTIFIER_TOKEN) ) {
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
                    // Hyconstraints.g:3303:0: (a0= QUOTED_34_34 )
                    {
                    // Hyconstraints.g:3303:4: (a0= QUOTED_34_34 )
                    // Hyconstraints.g:3304:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3166); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a0 != null) {
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_17_0_0_0_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a0, element);
                    copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 28424);
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:3344:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyconstraints.g:3344:2: (a1= IDENTIFIER_TOKEN )
                    // Hyconstraints.g:3345:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3183); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_17_0_0_0_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 28425);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 28426);
            }

            a2=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3201); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_17_0_0_1, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 28427);
            }

            // Hyconstraints.g:3404:4: (a3= IDENTIFIER_TOKEN )
            // Hyconstraints.g:3405:4: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3214); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
            startIncompleteElement(element);
            }
            if (a3 != null) {
            eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            tokenResolver.setOptions(getOptions());
            eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
            tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), result);
            Object resolvedObject = result.getResolvedToken();
            if (resolvedObject == null) {
            addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            }
            String resolved = (String) resolvedObject;
            eu.hyvar.feature.HyFeatureAttribute proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyNumberAttribute();
            collectHiddenTokens(element);
            registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeatureAttribute>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionAttributeReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), resolved, proxy);
            if (proxy != null) {
            Object value = proxy;
            element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), value);
            completedElement(value, false);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_17_0_0_2, proxy, true);
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
            addExpectedElement(null, 28428, 28434);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"
    // Hyconstraints.g:3449:1: parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression returns [eu.hyvar.feature.expression.HyContextInformationReferenceExpression element = null] : a0= 'context:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) ;
    public final eu.hyvar.feature.expression.HyContextInformationReferenceExpression parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyContextInformationReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Hyconstraints.g:3452:4: (a0= 'context:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) )
            // Hyconstraints.g:3453:4: a0= 'context:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
            {
            a0=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3242); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_18_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 28435, 28436);
            }

            // Hyconstraints.g:3467:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
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
                    // Hyconstraints.g:3468:0: (a1= QUOTED_34_34 )
                    {
                    // Hyconstraints.g:3468:4: (a1= QUOTED_34_34 )
                    // Hyconstraints.g:3469:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3257); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.context.HyContextualInformation proxy = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextInformationReferenceExpressionContextInformationReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_18_0_0_1_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 28437, 28443);
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:3509:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hyconstraints.g:3509:2: (a2= IDENTIFIER_TOKEN )
                    // Hyconstraints.g:3510:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3274); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a2 != null) {
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.context.HyContextualInformation proxy = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextInformationReferenceExpressionContextInformationReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_18_0_0_1_0_1_0, proxy, true);
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
                    addExpectedElement(null, 28444, 28450);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 28451, 28457);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyValueExpression"
    // Hyconstraints.g:3563:1: parse_eu_hyvar_feature_expression_HyValueExpression returns [eu.hyvar.feature.expression.HyValueExpression element = null] : (a0_0= parse_eu_hyvar_dataValues_HyValue ) ;
    public final eu.hyvar.feature.expression.HyValueExpression parse_eu_hyvar_feature_expression_HyValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Hyconstraints.g:3566:6: ( (a0_0= parse_eu_hyvar_dataValues_HyValue ) )
            // Hyconstraints.g:3567:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            {
            // Hyconstraints.g:3567:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            // Hyconstraints.g:3568:6: a0_0= parse_eu_hyvar_dataValues_HyValue
            {
            pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression3309);
            a0_0=parse_eu_hyvar_dataValues_HyValue();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_19_0_0_0, a0_0, true);
            copyLocalizationInfos(a0_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 28458, 28464);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyValueExpression"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_14"
    // Hyconstraints.g:3598:1: parseop_HyArithmeticalValueExpression_level_14 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : (a0= '-' arg= parseop_HyArithmeticalValueExpression_level_15 |arg= parseop_HyArithmeticalValueExpression_level_15 );
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_14() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_14_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression arg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Hyconstraints.g:3601:0: (a0= '-' arg= parseop_HyArithmeticalValueExpression_level_15 |arg= parseop_HyArithmeticalValueExpression_level_15 )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==20) ) {
                alt41=1;
            }
            else if ( (LA41_0==15) ) {
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
                    // Hyconstraints.g:3602:0: a0= '-' arg= parseop_HyArithmeticalValueExpression_level_15
                    {
                    a0=(Token)match(input,20,FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_143336); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNegationExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_15_0_0_0, null, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    }

                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), 28465, 31072);
                    }

                    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_143347);
                    arg=parseop_HyArithmeticalValueExpression_level_15();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_15_0_0_1, arg, true);
                    copyLocalizationInfos(arg, element);
                    }
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:3637:5: arg= parseop_HyArithmeticalValueExpression_level_15
                    {
                    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_143357);
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
            if ( state.backtracking>0 ) { memoize(input, 28, parseop_HyArithmeticalValueExpression_level_14_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_14"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_15"
    // Hyconstraints.g:3640:1: parseop_HyArithmeticalValueExpression_level_15 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c0= parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_15() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_15_StartIndex = input.index();

        eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Hyconstraints.g:3643:4: (c0= parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression )
            // Hyconstraints.g:3644:4: c0= parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_in_parseop_HyArithmeticalValueExpression_level_153379);
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
            if ( state.backtracking>0 ) { memoize(input, 29, parseop_HyArithmeticalValueExpression_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_15"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression"
    // Hyconstraints.g:3647:1: parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression returns [eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression element = null] : a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Hyconstraints.g:3650:4: (a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a2= ')' )
            // Hyconstraints.g:3651:4: a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a2= ')'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3401); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedArithmeticalValueExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_16_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedArithmeticalValueExpression(), 31073, 33680);
            }

            // Hyconstraints.g:3665:6: (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression )
            // Hyconstraints.g:3666:6: a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3414);
            a1_0=parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_16_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 33681);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3426); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedArithmeticalValueExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_16_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 33682, 33688);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression"



    // $ANTLR start "parseop_HyValue_level_15"
    // Hyconstraints.g:3710:1: parseop_HyValue_level_15 returns [eu.hyvar.dataValues.HyValue element = null] : (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue );
    public final eu.hyvar.dataValues.HyValue parseop_HyValue_level_15() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parseop_HyValue_level_15_StartIndex = input.index();

        eu.hyvar.dataValues.HyNumberValue c0 =null;

        eu.hyvar.dataValues.HyBooleanValue c1 =null;

        eu.hyvar.dataValues.HyEnumValue c2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }

            // Hyconstraints.g:3713:0: (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue )
            int alt42=3;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
                {
                alt42=1;
                }
                break;
            case 40:
            case 41:
                {
                alt42=2;
                }
                break;
            case 38:
                {
                alt42=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }

            switch (alt42) {
                case 1 :
                    // Hyconstraints.g:3714:0: c0= parse_eu_hyvar_dataValues_HyNumberValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_153452);
                    c0=parse_eu_hyvar_dataValues_HyNumberValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:3715:2: c1= parse_eu_hyvar_dataValues_HyBooleanValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_153460);
                    c1=parse_eu_hyvar_dataValues_HyBooleanValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hyconstraints.g:3716:2: c2= parse_eu_hyvar_dataValues_HyEnumValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_153468);
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
            if ( state.backtracking>0 ) { memoize(input, 31, parseop_HyValue_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyValue_level_15"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyNumberValue"
    // Hyconstraints.g:3719:1: parse_eu_hyvar_dataValues_HyNumberValue returns [eu.hyvar.dataValues.HyNumberValue element = null] : (a0= INTEGER_LITERAL ) ;
    public final eu.hyvar.dataValues.HyNumberValue parse_eu_hyvar_dataValues_HyNumberValue() throws RecognitionException {
        eu.hyvar.dataValues.HyNumberValue element =  null;

        int parse_eu_hyvar_dataValues_HyNumberValue_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return element; }

            // Hyconstraints.g:3722:4: ( (a0= INTEGER_LITERAL ) )
            // Hyconstraints.g:3723:4: (a0= INTEGER_LITERAL )
            {
            // Hyconstraints.g:3723:4: (a0= INTEGER_LITERAL )
            // Hyconstraints.g:3724:4: a0= INTEGER_LITERAL
            {
            a0=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3492); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyNumberValue();
            startIncompleteElement(element);
            }
            if (a0 != null) {
            eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            tokenResolver.setOptions(getOptions());
            eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_0_0_0_0, resolved, true);
            copyLocalizationInfos((CommonToken) a0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 33689, 33695);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 32, parse_eu_hyvar_dataValues_HyNumberValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyNumberValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyBooleanValue"
    // Hyconstraints.g:3764:1: parse_eu_hyvar_dataValues_HyBooleanValue returns [eu.hyvar.dataValues.HyBooleanValue element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.dataValues.HyBooleanValue parse_eu_hyvar_dataValues_HyBooleanValue() throws RecognitionException {
        eu.hyvar.dataValues.HyBooleanValue element =  null;

        int parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return element; }

            // Hyconstraints.g:3767:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hyconstraints.g:3768:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hyconstraints.g:3768:0: ( (a0= 'true' |a1= 'false' ) )
            // Hyconstraints.g:3769:0: (a0= 'true' |a1= 'false' )
            {
            // Hyconstraints.g:3769:0: (a0= 'true' |a1= 'false' )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==41) ) {
                alt43=1;
            }
            else if ( (LA43_0==40) ) {
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
                    // Hyconstraints.g:3770:0: a0= 'true'
                    {
                    a0=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_dataValues_HyBooleanValue3524); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_1_0_0_0, true, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    // set value of boolean attribute
                    Object value = true;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:3783:2: a1= 'false'
                    {
                    a1=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_dataValues_HyBooleanValue3533); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_1_0_0_0, false, true);
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
            addExpectedElement(null, 33696, 33702);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 33, parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyBooleanValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumValue"
    // Hyconstraints.g:3808:1: parse_eu_hyvar_dataValues_HyEnumValue returns [eu.hyvar.dataValues.HyEnumValue element = null] : a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return element; }

            // Hyconstraints.g:3811:4: (a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) ) )
            // Hyconstraints.g:3812:4: a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnumValue3563); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 33703, 33704);
            }

            // Hyconstraints.g:3826:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
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
                    // Hyconstraints.g:3827:0: (a1= QUOTED_34_34 )
                    {
                    // Hyconstraints.g:3827:4: (a1= QUOTED_34_34 )
                    // Hyconstraints.g:3828:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3578); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 33705);
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:3868:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hyconstraints.g:3868:2: (a2= IDENTIFIER_TOKEN )
                    // Hyconstraints.g:3869:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3595); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a2 != null) {
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a2, element);
                    copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 33706);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 33707);
            }

            a3=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue3613); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a3, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 33708, 33709);
            }

            // Hyconstraints.g:3928:0: ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
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
                    // Hyconstraints.g:3929:0: (a4= QUOTED_34_34 )
                    {
                    // Hyconstraints.g:3929:4: (a4= QUOTED_34_34 )
                    // Hyconstraints.g:3930:4: a4= QUOTED_34_34
                    {
                    a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3628); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a4 != null) {
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a4, element);
                    copyLocalizationInfos((CommonToken) a4, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 33710, 33716);
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:3970:2: (a5= IDENTIFIER_TOKEN )
                    {
                    // Hyconstraints.g:3970:2: (a5= IDENTIFIER_TOKEN )
                    // Hyconstraints.g:3971:4: a5= IDENTIFIER_TOKEN
                    {
                    a5=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3645); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a5 != null) {
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_1_0, proxy, true);
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
                    addExpectedElement(null, 33717, 33723);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 33724, 33730);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 34, parse_eu_hyvar_dataValues_HyEnumValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumValue"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyExpression"
    // Hyconstraints.g:4024:1: parse_eu_hyvar_feature_expression_HyExpression returns [eu.hyvar.feature.expression.HyExpression element = null] : c= parseop_HyExpression_level_0 ;
    public final eu.hyvar.feature.expression.HyExpression parse_eu_hyvar_feature_expression_HyExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyExpression_StartIndex = input.index();

        eu.hyvar.feature.expression.HyExpression c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return element; }

            // Hyconstraints.g:4025:3: (c= parseop_HyExpression_level_0 )
            // Hyconstraints.g:4026:3: c= parseop_HyExpression_level_0
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression3674);
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
            if ( state.backtracking>0 ) { memoize(input, 35, parse_eu_hyvar_feature_expression_HyExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyVersionRestriction"
    // Hyconstraints.g:4030:1: parse_eu_hyvar_feature_expression_HyVersionRestriction returns [eu.hyvar.feature.expression.HyVersionRestriction element = null] : (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction );
    public final eu.hyvar.feature.expression.HyVersionRestriction parse_eu_hyvar_feature_expression_HyVersionRestriction() throws RecognitionException {
        eu.hyvar.feature.expression.HyVersionRestriction element =  null;

        int parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex = input.index();

        eu.hyvar.feature.expression.HyRelativeVersionRestriction c0 =null;

        eu.hyvar.feature.expression.HyVersionRangeRestriction c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return element; }

            // Hyconstraints.g:4031:0: (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==33) ) {
                switch ( input.LA(2) ) {
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                    {
                    alt46=1;
                    }
                    break;
                case QUOTED_34_34:
                    {
                    int LA46_3 = input.LA(3);

                    if ( (LA46_3==35) ) {
                        alt46=1;
                    }
                    else if ( (LA46_3==20) ) {
                        alt46=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 3, input);

                        throw nvae;

                    }
                    }
                    break;
                case 36:
                    {
                    alt46=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }
            switch (alt46) {
                case 1 :
                    // Hyconstraints.g:4032:0: c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3693);
                    c0=parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:4033:2: c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3701);
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
            if ( state.backtracking>0 ) { memoize(input, 36, parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyVersionRestriction"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression"
    // Hyconstraints.g:4037:1: parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c= parseop_HyArithmeticalValueExpression_level_4 ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_StartIndex = input.index();

        eu.hyvar.feature.expression.HyArithmeticalValueExpression c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return element; }

            // Hyconstraints.g:4038:3: (c= parseop_HyArithmeticalValueExpression_level_4 )
            // Hyconstraints.g:4039:3: c= parseop_HyArithmeticalValueExpression_level_4
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_4_in_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression3720);
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
            if ( state.backtracking>0 ) { memoize(input, 37, parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyValue"
    // Hyconstraints.g:4043:1: parse_eu_hyvar_dataValues_HyValue returns [eu.hyvar.dataValues.HyValue element = null] : c= parseop_HyValue_level_15 ;
    public final eu.hyvar.dataValues.HyValue parse_eu_hyvar_dataValues_HyValue() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parse_eu_hyvar_dataValues_HyValue_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return element; }

            // Hyconstraints.g:4044:3: (c= parseop_HyValue_level_15 )
            // Hyconstraints.g:4045:3: c= parseop_HyValue_level_15
            {
            pushFollow(FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue3739);
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
            if ( state.backtracking>0 ) { memoize(input, 38, parse_eu_hyvar_dataValues_HyValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_eu_hyvar_feature_constraint_HyConstraintModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_constraint_HyConstraint_in_parse_eu_hyvar_feature_constraint_HyConstraintModel124 = new BitSet(new long[]{0x0000070040009222L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_constraint_HyConstraint169 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_feature_constraint_HyConstraint196 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_constraint_HyConstraint229 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_feature_constraint_HyConstraint268 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_constraint_HyConstraint298 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_constraint_HyConstraint354 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_feature_constraint_HyConstraint393 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_feature_constraint_HyConstraint416 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_feature_constraint_HyConstraint449 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_feature_constraint_HyConstraint472 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_constraint_HyConstraint502 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_feature_constraint_HyConstraint554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction602 = new BitSet(new long[]{0x000000003D000200L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction625 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction640 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction655 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction670 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction685 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction710 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction760 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction783 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction808 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction829 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction852 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction877 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_parse_eu_hyvar_dataValues_HyEnum927 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum945 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum966 = new BitSet(new long[]{0x0000000100010000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum995 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum1036 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1070 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum1144 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnum1167 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1200 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1239 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1269 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1325 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1364 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnum1397 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1420 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1450 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnum1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_parse_eu_hyvar_dataValues_HyEnumLiteral1550 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral1568 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnumLiteral1589 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral1607 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral1628 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnumLiteral1651 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1684 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1723 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1753 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1809 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1848 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumLiteral1871 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumLiteral1904 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1927 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1957 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnumLiteral2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02057 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_parseop_HyExpression_level_02077 = new BitSet(new long[]{0x0000070040009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02094 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_12140 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_parseop_HyExpression_level_12156 = new BitSet(new long[]{0x0000070040009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_12170 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_22211 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_parseop_HyExpression_level_22224 = new BitSet(new long[]{0x0000070040009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_22235 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_32273 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_parseop_HyExpression_level_32286 = new BitSet(new long[]{0x0000070040009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_32297 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_12_in_parseop_HyExpression_level_142335 = new BitSet(new long[]{0x0000070040008220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_152378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_152386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_152394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_152402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression_in_parseop_HyExpression_level_152410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedExpression2432 = new BitSet(new long[]{0x0000070040009220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression2445 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression2457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2487 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2504 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2563 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2578 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2595 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2685 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2698 = new BitSet(new long[]{0x000000003D002000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2714 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2723 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2732 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2741 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2750 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2759 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2776 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression2788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_42814 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parseop_HyArithmeticalValueExpression_level_42827 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_42838 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_52876 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_parseop_HyArithmeticalValueExpression_level_52889 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_52900 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_62938 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_62951 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_62962 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73000 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_parseop_HyArithmeticalValueExpression_level_73013 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73024 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83062 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_parseop_HyArithmeticalValueExpression_level_83075 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83086 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_113124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_113132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyArithmeticalValueExpression_level_113140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3166 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3183 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3201 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3242 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression3309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_143336 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_143347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_143357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_in_parseop_HyArithmeticalValueExpression_level_153379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3401 = new BitSet(new long[]{0x0000036000000260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3414 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_153452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_153460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_153468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_dataValues_HyBooleanValue3524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_dataValues_HyBooleanValue3533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnumValue3563 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3578 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3595 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue3613 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression3674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_4_in_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression3720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue3739 = new BitSet(new long[]{0x0000000000000002L});

}