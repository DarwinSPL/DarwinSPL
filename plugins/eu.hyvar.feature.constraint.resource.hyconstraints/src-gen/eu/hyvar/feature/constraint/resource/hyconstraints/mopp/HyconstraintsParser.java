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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DATE", "IDENTIFIER_TOKEN", "INTEGER_LITERAL", "LINEBREAK", "ML_COMMENT", "QUOTED_34_34", "SL_COMMENT", "WHITESPACE", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'->'", "'.'", "'/'", "'<'", "'<->'", "'<='", "'='", "'>'", "'>='", "'?'", "'Enum('", "'EnumLiteral('", "'['", "'\\u0025'", "']'", "'^'", "'enum:'", "'eternity'", "'false'", "'true'", "'{'", "'||'", "'}'"
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
        this.state.initializeRuleMemo(99 + 1);
         

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
    		int followSetID = 118;
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
    // Hyconstraints.g:500:1: start returns [ EObject element = null] : (c0= parse_eu_hyvar_feature_constraint_HyConstraintModel ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        eu.hyvar.feature.constraint.HyConstraintModel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Hyconstraints.g:501:2: ( (c0= parse_eu_hyvar_feature_constraint_HyConstraintModel ) EOF )
            // Hyconstraints.g:502:2: (c0= parse_eu_hyvar_feature_constraint_HyConstraintModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 0, 454);
            		expectedElementsIndexOfLastCompleteElement = 454;
            	}

            // Hyconstraints.g:507:2: (c0= parse_eu_hyvar_feature_constraint_HyConstraintModel )
            // Hyconstraints.g:508:3: c0= parse_eu_hyvar_feature_constraint_HyConstraintModel
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
    // Hyconstraints.g:516:1: parse_eu_hyvar_feature_constraint_HyConstraintModel returns [eu.hyvar.feature.constraint.HyConstraintModel element = null] : ( (a0_0= parse_eu_hyvar_feature_constraint_HyConstraint ) )* ;
    public final eu.hyvar.feature.constraint.HyConstraintModel parse_eu_hyvar_feature_constraint_HyConstraintModel() throws RecognitionException {
        eu.hyvar.feature.constraint.HyConstraintModel element =  null;

        int parse_eu_hyvar_feature_constraint_HyConstraintModel_StartIndex = input.index();

        eu.hyvar.feature.constraint.HyConstraint a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Hyconstraints.g:519:2: ( ( (a0_0= parse_eu_hyvar_feature_constraint_HyConstraint ) )* )
            // Hyconstraints.g:520:2: ( (a0_0= parse_eu_hyvar_feature_constraint_HyConstraint ) )*
            {
            // Hyconstraints.g:520:2: ( (a0_0= parse_eu_hyvar_feature_constraint_HyConstraint ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IDENTIFIER_TOKEN||LA1_0==QUOTED_34_34||LA1_0==12||LA1_0==15||LA1_0==30||(LA1_0 >= 39 && LA1_0 <= 40)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Hyconstraints.g:521:3: (a0_0= parse_eu_hyvar_feature_constraint_HyConstraint )
            	    {
            	    // Hyconstraints.g:521:3: (a0_0= parse_eu_hyvar_feature_constraint_HyConstraint )
            	    // Hyconstraints.g:522:4: a0_0= parse_eu_hyvar_feature_constraint_HyConstraint
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
    // Hyconstraints.g:553:1: parse_eu_hyvar_feature_constraint_HyConstraint returns [eu.hyvar.feature.constraint.HyConstraint element = null] : (a0_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )? ;
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

            // Hyconstraints.g:556:2: ( (a0_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )? )
            // Hyconstraints.g:557:2: (a0_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )?
            {
            // Hyconstraints.g:557:2: (a0_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyconstraints.g:558:3: a0_0= parse_eu_hyvar_feature_expression_HyExpression
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

            // Hyconstraints.g:584:2: ( (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==33) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Hyconstraints.g:585:3: (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' )
                    {
                    // Hyconstraints.g:585:3: (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' )
                    // Hyconstraints.g:586:4: a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']'
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

                    // Hyconstraints.g:600:4: ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) )
                    int alt2=3;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==DATE) ) {
                        int LA2_1 = input.LA(2);

                        if ( (LA2_1==20) ) {
                            int LA2_3 = input.LA(3);

                            if ( (LA2_3==DATE) ) {
                                alt2=1;
                            }
                            else if ( (LA2_3==38) ) {
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
                    else if ( (LA2_0==38) ) {
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
                            // Hyconstraints.g:601:5: (a2= DATE ) a3= '-' (a4= DATE )
                            {
                            // Hyconstraints.g:601:5: (a2= DATE )
                            // Hyconstraints.g:602:6: a2= DATE
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

                            // Hyconstraints.g:651:5: (a4= DATE )
                            // Hyconstraints.g:652:6: a4= DATE
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
                            // Hyconstraints.g:688:10: (a5= DATE ) a6= '-' a7= 'eternity'
                            {
                            // Hyconstraints.g:688:10: (a5= DATE )
                            // Hyconstraints.g:689:6: a5= DATE
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

                            a7=(Token)match(input,38,FOLLOW_38_in_parse_eu_hyvar_feature_constraint_HyConstraint416); if (state.failed) return element;

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
                            // Hyconstraints.g:753:10: a8= 'eternity' a9= '-' (a10= DATE )
                            {
                            a8=(Token)match(input,38,FOLLOW_38_in_parse_eu_hyvar_feature_constraint_HyConstraint449); if (state.failed) return element;

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

                            // Hyconstraints.g:781:5: (a10= DATE )
                            // Hyconstraints.g:782:6: a10= DATE
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



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression"
    // Hyconstraints.g:852:1: parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression returns [eu.hyvar.feature.expression.HyArithmeticalComparisonExpression element = null] : a0= '{' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) ) (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a11= '}' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Hyconstraints.g:855:2: (a0= '{' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) ) (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a11= '}' )
            // Hyconstraints.g:856:2: a0= '{' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) ) (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a11= '}'
            {
            a0=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression602); if (state.failed) return element;

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
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(), 2289, 5222);
            	}

            // Hyconstraints.g:870:2: (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression )
            // Hyconstraints.g:871:3: a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression620);
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
            		addExpectedElement(null, 5223);
            	}

            // Hyconstraints.g:896:2: ( (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' ) )
            // Hyconstraints.g:897:3: (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' )
            {
            // Hyconstraints.g:897:3: (a2= '<' |a3= '<=' |a4= '=' |a5= '!=' |a6= '>=' |a7= '>' )
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
            case 13:
                {
                alt4=4;
                }
                break;
            case 29:
                {
                alt4=5;
                }
                break;
            case 28:
                {
                alt4=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // Hyconstraints.g:898:4: a2= '<'
                    {
                    a2=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression647); if (state.failed) return element;

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
                    // Hyconstraints.g:911:8: a3= '<='
                    {
                    a3=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression662); if (state.failed) return element;

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
                    // Hyconstraints.g:924:8: a4= '='
                    {
                    a4=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression677); if (state.failed) return element;

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
                    // Hyconstraints.g:937:8: a5= '!='
                    {
                    a5=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression692); if (state.failed) return element;

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
                    // Hyconstraints.g:950:8: a6= '>='
                    {
                    a6=(Token)match(input,29,FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression707); if (state.failed) return element;

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
                    // Hyconstraints.g:963:8: a7= '>'
                    {
                    a7=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression722); if (state.failed) return element;

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
            		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(), 5224, 8157);
            	}

            // Hyconstraints.g:983:2: (a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression )
            // Hyconstraints.g:984:3: a10_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression747);
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
            		addExpectedElement(null, 8158);
            	}

            a11=(Token)match(input,43,FOLLOW_43_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression765); if (state.failed) return element;

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
            		addExpectedElement(null, 8159);
            		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 8160, 8614);
            		addExpectedElement(null, 8615, 8619);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction"
    // Hyconstraints.g:1030:1: parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction returns [eu.hyvar.feature.expression.HyRelativeVersionRestriction element = null] : a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Hyconstraints.g:1033:2: (a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' )
            // Hyconstraints.g:1034:2: a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']'
            {
            a0=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction794); if (state.failed) return element;

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
            		addExpectedElement(null, 8620, 8621);
            	}

            // Hyconstraints.g:1051:2: ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? )
            // Hyconstraints.g:1052:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
            {
            // Hyconstraints.g:1052:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
            int alt5=6;
            switch ( input.LA(1) ) {
                case 24:
                    {
                    alt5=1;
                    }
                    break;
                case 26:
                    {
                    alt5=2;
                    }
                    break;
                case 27:
                    {
                    alt5=3;
                    }
                    break;
                case 29:
                    {
                    alt5=4;
                    }
                    break;
                case 28:
                    {
                    alt5=5;
                    }
                    break;
            }

            switch (alt5) {
                case 1 :
                    // Hyconstraints.g:1053:4: a1= '<'
                    {
                    a1=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction817); if (state.failed) return element;

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
                    // Hyconstraints.g:1069:8: a2= '<='
                    {
                    a2=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction832); if (state.failed) return element;

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
                    // Hyconstraints.g:1085:8: a3= '='
                    {
                    a3=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction847); if (state.failed) return element;

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
                    // Hyconstraints.g:1101:8: a4= '>='
                    {
                    a4=(Token)match(input,29,FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction862); if (state.failed) return element;

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
                    // Hyconstraints.g:1117:8: a5= '>'
                    {
                    a5=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction877); if (state.failed) return element;

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
            		addExpectedElement(null, 8622);
            	}

            // Hyconstraints.g:1139:2: (a8= QUOTED_34_34 )
            // Hyconstraints.g:1140:3: a8= QUOTED_34_34
            {
            a8=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction902); if (state.failed) return element;

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
            		addExpectedElement(null, 8623);
            	}

            a9=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction923); if (state.failed) return element;

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
            		addExpectedElement(null, 8624);
            		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 8625, 9079);
            		addExpectedElement(null, 9080, 9084);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyVersionRangeRestriction"
    // Hyconstraints.g:1206:1: parse_eu_hyvar_feature_expression_HyVersionRangeRestriction returns [eu.hyvar.feature.expression.HyVersionRangeRestriction element = null] : a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Hyconstraints.g:1209:2: (a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' )
            // Hyconstraints.g:1210:2: a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']'
            {
            a0=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction952); if (state.failed) return element;

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
            		addExpectedElement(null, 9085, 9086);
            	}

            // Hyconstraints.g:1234:2: ( (a1= '^' )? )
            // Hyconstraints.g:1235:3: (a1= '^' )?
            {
            // Hyconstraints.g:1235:3: (a1= '^' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==36) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Hyconstraints.g:1236:4: a1= '^'
                    {
                    a1=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction975); if (state.failed) return element;

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
            		addExpectedElement(null, 9087);
            	}

            // Hyconstraints.g:1265:2: (a3= QUOTED_34_34 )
            // Hyconstraints.g:1266:3: a3= QUOTED_34_34
            {
            a3=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1000); if (state.failed) return element;

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
            		addExpectedElement(null, 9088);
            	}

            a4=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1021); if (state.failed) return element;

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
            		addExpectedElement(null, 9089, 9090);
            	}

            // Hyconstraints.g:1339:2: ( (a5= '^' )? )
            // Hyconstraints.g:1340:3: (a5= '^' )?
            {
            // Hyconstraints.g:1340:3: (a5= '^' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==36) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Hyconstraints.g:1341:4: a5= '^'
                    {
                    a5=(Token)match(input,36,FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1044); if (state.failed) return element;

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
            		addExpectedElement(null, 9091);
            	}

            // Hyconstraints.g:1370:2: (a7= QUOTED_34_34 )
            // Hyconstraints.g:1371:3: a7= QUOTED_34_34
            {
            a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1069); if (state.failed) return element;

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
            		addExpectedElement(null, 9092);
            	}

            a8=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1090); if (state.failed) return element;

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
            		addExpectedElement(null, 9093);
            		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 9094, 9548);
            		addExpectedElement(null, 9549, 9553);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyVersionRangeRestriction"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnum"
    // Hyconstraints.g:1451:1: parse_eu_hyvar_dataValues_HyEnum returns [eu.hyvar.dataValues.HyEnum element = null] : a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Hyconstraints.g:1454:2: (a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? )
            // Hyconstraints.g:1455:2: a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            {
            a0=(Token)match(input,31,FOLLOW_31_in_parse_eu_hyvar_dataValues_HyEnum1119); if (state.failed) return element;

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
            		addExpectedElement(null, 9554);
            	}

            // Hyconstraints.g:1469:2: (a1= IDENTIFIER_TOKEN )
            // Hyconstraints.g:1470:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum1137); if (state.failed) return element;

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
            		addExpectedElement(null, 9555);
            	}

            a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum1158); if (state.failed) return element;

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
            		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 9556);
            		addExpectedElement(null, 9557);
            	}

            // Hyconstraints.g:1520:2: ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==32) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Hyconstraints.g:1521:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    {
                    // Hyconstraints.g:1521:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    // Hyconstraints.g:1522:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    {
                    // Hyconstraints.g:1522:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    // Hyconstraints.g:1523:5: a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1187);
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
                    				addExpectedElement(null, 9558, 9559);
                    			}

                    // Hyconstraints.g:1548:4: ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==19) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Hyconstraints.g:1549:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    {
                    	    // Hyconstraints.g:1549:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    // Hyconstraints.g:1550:6: a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    {
                    	    a4=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum1228); if (state.failed) return element;

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
                    	    						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 9560);
                    	    					}

                    	    // Hyconstraints.g:1564:6: (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    // Hyconstraints.g:1565:7: a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1262);
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
                    	    						addExpectedElement(null, 9561, 9562);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 9563, 9564);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, 9565);
            	}

            a6=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum1336); if (state.failed) return element;

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
            		addExpectedElement(null, 9566);
            	}

            // Hyconstraints.g:1618:2: ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==33) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // Hyconstraints.g:1619:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    {
                    // Hyconstraints.g:1619:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    // Hyconstraints.g:1620:4: a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']'
                    {
                    a7=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnum1359); if (state.failed) return element;

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
                    				addExpectedElement(null, 9567, 9569);
                    			}

                    // Hyconstraints.g:1634:4: ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) )
                    int alt10=3;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==DATE) ) {
                        int LA10_1 = input.LA(2);

                        if ( (LA10_1==20) ) {
                            int LA10_3 = input.LA(3);

                            if ( (LA10_3==DATE) ) {
                                alt10=1;
                            }
                            else if ( (LA10_3==35) ) {
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
                    else if ( (LA10_0==38) ) {
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
                            // Hyconstraints.g:1635:5: (a8= DATE ) a9= '-' (a10= DATE )
                            {
                            // Hyconstraints.g:1635:5: (a8= DATE )
                            // Hyconstraints.g:1636:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1392); if (state.failed) return element;

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
                            					addExpectedElement(null, 9570);
                            				}

                            a9=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1431); if (state.failed) return element;

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
                            					addExpectedElement(null, 9571);
                            				}

                            // Hyconstraints.g:1685:5: (a10= DATE )
                            // Hyconstraints.g:1686:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1461); if (state.failed) return element;

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
                            					addExpectedElement(null, 9572);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyconstraints.g:1722:10: (a11= DATE ) a12= '-'
                            {
                            // Hyconstraints.g:1722:10: (a11= DATE )
                            // Hyconstraints.g:1723:6: a11= DATE
                            {
                            a11=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1517); if (state.failed) return element;

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
                            					addExpectedElement(null, 9573);
                            				}

                            a12=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1556); if (state.failed) return element;

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
                            					addExpectedElement(null, 9574);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyconstraints.g:1773:10: a13= 'eternity' a14= '-' (a15= DATE )
                            {
                            a13=(Token)match(input,38,FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnum1589); if (state.failed) return element;

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
                            					addExpectedElement(null, 9575);
                            				}

                            a14=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1612); if (state.failed) return element;

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
                            					addExpectedElement(null, 9576);
                            				}

                            // Hyconstraints.g:1801:5: (a15= DATE )
                            // Hyconstraints.g:1802:6: a15= DATE
                            {
                            a15=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1642); if (state.failed) return element;

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
                            					addExpectedElement(null, 9577);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 9578);
                    			}

                    a16=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnum1694); if (state.failed) return element;

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
            if ( state.backtracking>0 ) { memoize(input, 7, parse_eu_hyvar_dataValues_HyEnum_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnum"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumLiteral"
    // Hyconstraints.g:1870:1: parse_eu_hyvar_dataValues_HyEnumLiteral returns [eu.hyvar.dataValues.HyEnumLiteral element = null] : a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Hyconstraints.g:1873:2: (a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hyconstraints.g:1874:2: a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            a0=(Token)match(input,32,FOLLOW_32_in_parse_eu_hyvar_dataValues_HyEnumLiteral1742); if (state.failed) return element;

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
            		addExpectedElement(null, 9579);
            	}

            // Hyconstraints.g:1888:2: (a1= IDENTIFIER_TOKEN )
            // Hyconstraints.g:1889:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral1760); if (state.failed) return element;

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
            		addExpectedElement(null, 9580);
            	}

            a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnumLiteral1781); if (state.failed) return element;

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
            		addExpectedElement(null, 9581);
            	}

            // Hyconstraints.g:1938:2: (a3= INTEGER_LITERAL )
            // Hyconstraints.g:1939:3: a3= INTEGER_LITERAL
            {
            a3=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral1799); if (state.failed) return element;

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
            		addExpectedElement(null, 9582);
            	}

            a4=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral1820); if (state.failed) return element;

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
            		addExpectedElement(null, 9583, 9585);
            	}

            // Hyconstraints.g:1988:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==33) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Hyconstraints.g:1989:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hyconstraints.g:1989:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hyconstraints.g:1990:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnumLiteral1843); if (state.failed) return element;

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
                    				addExpectedElement(null, 9586, 9588);
                    			}

                    // Hyconstraints.g:2004:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) )
                    int alt12=3;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==DATE) ) {
                        int LA12_1 = input.LA(2);

                        if ( (LA12_1==20) ) {
                            int LA12_3 = input.LA(3);

                            if ( (LA12_3==DATE) ) {
                                alt12=1;
                            }
                            else if ( (LA12_3==38) ) {
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
                    else if ( (LA12_0==38) ) {
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
                            // Hyconstraints.g:2005:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hyconstraints.g:2005:5: (a6= DATE )
                            // Hyconstraints.g:2006:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1876); if (state.failed) return element;

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
                            					addExpectedElement(null, 9589);
                            				}

                            a7=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1915); if (state.failed) return element;

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
                            					addExpectedElement(null, 9590);
                            				}

                            // Hyconstraints.g:2055:5: (a8= DATE )
                            // Hyconstraints.g:2056:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1945); if (state.failed) return element;

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
                            					addExpectedElement(null, 9591);
                            				}

                            }
                            break;
                        case 2 :
                            // Hyconstraints.g:2092:10: (a9= DATE ) a10= '-' a11= 'eternity'
                            {
                            // Hyconstraints.g:2092:10: (a9= DATE )
                            // Hyconstraints.g:2093:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2001); if (state.failed) return element;

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
                            					addExpectedElement(null, 9592);
                            				}

                            a10=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral2040); if (state.failed) return element;

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
                            					addExpectedElement(null, 9593);
                            				}

                            a11=(Token)match(input,38,FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnumLiteral2063); if (state.failed) return element;

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
                            					addExpectedElement(null, 9594);
                            				}

                            }
                            break;
                        case 3 :
                            // Hyconstraints.g:2157:10: a12= 'eternity' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,38,FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnumLiteral2096); if (state.failed) return element;

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
                            					addExpectedElement(null, 9595);
                            				}

                            a13=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral2119); if (state.failed) return element;

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
                            					addExpectedElement(null, 9596);
                            				}

                            // Hyconstraints.g:2185:5: (a14= DATE )
                            // Hyconstraints.g:2186:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2149); if (state.failed) return element;

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
                            					addExpectedElement(null, 9597);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, 9598);
                    			}

                    a15=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnumLiteral2201); if (state.failed) return element;

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
                    				addExpectedElement(null, 9599, 9600);
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
            		addExpectedElement(null, 9601, 9602);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_eu_hyvar_dataValues_HyEnumLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumLiteral"



    // $ANTLR start "parseop_HyExpression_level_0"
    // Hyconstraints.g:2256:1: parseop_HyExpression_level_0 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_0() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_0_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Hyconstraints.g:2259:2: (leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) )
            // Hyconstraints.g:2260:2: leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02249);
            leftArg=parseop_HyExpression_level_1();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:2260:41: ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            else if ( (LA15_0==EOF||LA15_0==IDENTIFIER_TOKEN||LA15_0==QUOTED_34_34||LA15_0==12||(LA15_0 >= 15 && LA15_0 <= 16)||LA15_0==30||LA15_0==33||(LA15_0 >= 39 && LA15_0 <= 40)) ) {
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
                    // Hyconstraints.g:2260:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    {
                    // Hyconstraints.g:2260:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==25) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // Hyconstraints.g:2261:3: () a0= '<->' rightArg= parseop_HyExpression_level_1
                    	    {
                    	    // Hyconstraints.g:2261:3: ()
                    	    // Hyconstraints.g:2261:4: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,25,FOLLOW_25_in_parseop_HyExpression_level_02269); if (state.failed) return element;

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
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), 9603, 10057);
                    	    		}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02286);
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
                    // Hyconstraints.g:2316:21: 
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
            if ( state.backtracking>0 ) { memoize(input, 9, parseop_HyExpression_level_0_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_0"



    // $ANTLR start "parseop_HyExpression_level_1"
    // Hyconstraints.g:2321:1: parseop_HyExpression_level_1 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_2 ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_1() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_1_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Hyconstraints.g:2324:9: (leftArg= parseop_HyExpression_level_2 ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |) )
            // Hyconstraints.g:2325:9: leftArg= parseop_HyExpression_level_2 ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_12332);
            leftArg=parseop_HyExpression_level_2();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:2325:39: ( ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+ |)
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==21) ) {
                alt17=1;
            }
            else if ( (LA17_0==EOF||LA17_0==IDENTIFIER_TOKEN||LA17_0==QUOTED_34_34||LA17_0==12||(LA17_0 >= 15 && LA17_0 <= 16)||LA17_0==25||LA17_0==30||LA17_0==33||(LA17_0 >= 39 && LA17_0 <= 40)) ) {
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
                    // Hyconstraints.g:2325:40: ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+
                    {
                    // Hyconstraints.g:2325:40: ( () a0= '->' rightArg= parseop_HyExpression_level_2 )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==21) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // Hyconstraints.g:2326:2: () a0= '->' rightArg= parseop_HyExpression_level_2
                    	    {
                    	    // Hyconstraints.g:2326:2: ()
                    	    // Hyconstraints.g:2326:3: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,21,FOLLOW_21_in_parseop_HyExpression_level_12348); if (state.failed) return element;

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
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), 10058, 10512);
                    	    	}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_12362);
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
                    // Hyconstraints.g:2381:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 10, parseop_HyExpression_level_1_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_1"



    // $ANTLR start "parseop_HyExpression_level_2"
    // Hyconstraints.g:2386:1: parseop_HyExpression_level_2 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_3 ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_2() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_2_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Hyconstraints.g:2389:9: (leftArg= parseop_HyExpression_level_3 ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |) )
            // Hyconstraints.g:2390:9: leftArg= parseop_HyExpression_level_3 ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_22403);
            leftArg=parseop_HyExpression_level_3();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:2390:39: ( ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+ |)
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==42) ) {
                alt19=1;
            }
            else if ( (LA19_0==EOF||LA19_0==IDENTIFIER_TOKEN||LA19_0==QUOTED_34_34||LA19_0==12||(LA19_0 >= 15 && LA19_0 <= 16)||LA19_0==21||LA19_0==25||LA19_0==30||LA19_0==33||(LA19_0 >= 39 && LA19_0 <= 40)) ) {
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
                    // Hyconstraints.g:2390:40: ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+
                    {
                    // Hyconstraints.g:2390:40: ( () a0= '||' rightArg= parseop_HyExpression_level_3 )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==42) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // Hyconstraints.g:2391:0: () a0= '||' rightArg= parseop_HyExpression_level_3
                    	    {
                    	    // Hyconstraints.g:2391:2: ()
                    	    // Hyconstraints.g:2391:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,42,FOLLOW_42_in_parseop_HyExpression_level_22416); if (state.failed) return element;

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
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), 10513, 10967);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_22427);
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
                    // Hyconstraints.g:2446:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 11, parseop_HyExpression_level_2_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_2"



    // $ANTLR start "parseop_HyExpression_level_3"
    // Hyconstraints.g:2451:1: parseop_HyExpression_level_3 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_14 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_3() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_3_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Hyconstraints.g:2454:9: (leftArg= parseop_HyExpression_level_14 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |) )
            // Hyconstraints.g:2455:9: leftArg= parseop_HyExpression_level_14 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_32465);
            leftArg=parseop_HyExpression_level_14();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:2455:40: ( ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+ |)
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==14) ) {
                alt21=1;
            }
            else if ( (LA21_0==EOF||LA21_0==IDENTIFIER_TOKEN||LA21_0==QUOTED_34_34||LA21_0==12||(LA21_0 >= 15 && LA21_0 <= 16)||LA21_0==21||LA21_0==25||LA21_0==30||LA21_0==33||(LA21_0 >= 39 && LA21_0 <= 40)||LA21_0==42) ) {
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
                    // Hyconstraints.g:2455:41: ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+
                    {
                    // Hyconstraints.g:2455:41: ( () a0= '&&' rightArg= parseop_HyExpression_level_14 )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==14) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // Hyconstraints.g:2456:0: () a0= '&&' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Hyconstraints.g:2456:2: ()
                    	    // Hyconstraints.g:2456:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,14,FOLLOW_14_in_parseop_HyExpression_level_32478); if (state.failed) return element;

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
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), 10968, 11422);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_32489);
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
                    // Hyconstraints.g:2511:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 12, parseop_HyExpression_level_3_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_3"



    // $ANTLR start "parseop_HyExpression_level_14"
    // Hyconstraints.g:2516:1: parseop_HyExpression_level_14 returns [eu.hyvar.feature.expression.HyExpression element = null] : (a0= '!' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 );
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_14() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_14_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression arg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Hyconstraints.g:2519:0: (a0= '!' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==12) ) {
                alt22=1;
            }
            else if ( (LA22_0==IDENTIFIER_TOKEN||LA22_0==QUOTED_34_34||LA22_0==15||LA22_0==30||(LA22_0 >= 39 && LA22_0 <= 40)) ) {
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
                    // Hyconstraints.g:2520:0: a0= '!' arg= parseop_HyExpression_level_15
                    {
                    a0=(Token)match(input,12,FOLLOW_12_in_parseop_HyExpression_level_142527); if (state.failed) return element;

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
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), 11423, 11877);
                    }

                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142538);
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
                    // Hyconstraints.g:2555:5: arg= parseop_HyExpression_level_15
                    {
                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142548);
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
    // Hyconstraints.g:2558:1: parseop_HyExpression_level_15 returns [eu.hyvar.feature.expression.HyExpression element = null] : (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyBooleanValueExpression );
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_15() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_15_StartIndex = input.index();

        eu.hyvar.feature.expression.HyNestedExpression c0 =null;

        eu.hyvar.feature.expression.HyFeatureReferenceExpression c1 =null;

        eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression c2 =null;

        eu.hyvar.feature.expression.HyBooleanValueExpression c3 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Hyconstraints.g:2561:0: (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyBooleanValueExpression )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt23=1;
                }
                break;
            case IDENTIFIER_TOKEN:
            case QUOTED_34_34:
                {
                alt23=2;
                }
                break;
            case 30:
                {
                alt23=3;
                }
                break;
            case 39:
            case 40:
                {
                alt23=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }

            switch (alt23) {
                case 1 :
                    // Hyconstraints.g:2562:0: c0= parse_eu_hyvar_feature_expression_HyNestedExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_152570);
                    c0=parse_eu_hyvar_feature_expression_HyNestedExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:2563:2: c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_152578);
                    c1=parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hyconstraints.g:2564:2: c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_152586);
                    c2=parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Hyconstraints.g:2565:2: c3= parse_eu_hyvar_feature_expression_HyBooleanValueExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_152594);
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
            if ( state.backtracking>0 ) { memoize(input, 14, parseop_HyExpression_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_15"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyNestedExpression"
    // Hyconstraints.g:2568:1: parse_eu_hyvar_feature_expression_HyNestedExpression returns [eu.hyvar.feature.expression.HyNestedExpression element = null] : a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyNestedExpression parse_eu_hyvar_feature_expression_HyNestedExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyNestedExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Hyconstraints.g:2571:4: (a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Hyconstraints.g:2572:4: a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedExpression2616); if (state.failed) return element;

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
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), 11878, 12332);
            }

            // Hyconstraints.g:2586:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hyconstraints.g:2587:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression2629);
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
            addExpectedElement(null, 12333);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression2641); if (state.failed) return element;

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
            addExpectedElement(null, 12334);
            addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 12335, 12789);
            addExpectedElement(null, 12790, 12794);
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
    // Hyconstraints.g:2633:1: parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyFeatureReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? ;
    public final eu.hyvar.feature.expression.HyFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        eu.hyvar.feature.expression.HyVersionRestriction a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Hyconstraints.g:2636:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? )
            // Hyconstraints.g:2637:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            {
            // Hyconstraints.g:2637:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==QUOTED_34_34) ) {
                alt24=1;
            }
            else if ( (LA24_0==IDENTIFIER_TOKEN) ) {
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
                    // Hyconstraints.g:2638:0: (a0= QUOTED_34_34 )
                    {
                    // Hyconstraints.g:2638:4: (a0= QUOTED_34_34 )
                    // Hyconstraints.g:2639:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2671); if (state.failed) return element;

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
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 12795, 12796);
                    addExpectedElement(null, 12797);
                    addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 12798, 13252);
                    addExpectedElement(null, 13253, 13257);
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:2682:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyconstraints.g:2682:2: (a1= IDENTIFIER_TOKEN )
                    // Hyconstraints.g:2683:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2688); if (state.failed) return element;

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
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 13258, 13259);
                    addExpectedElement(null, 13260);
                    addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 13261, 13715);
                    addExpectedElement(null, 13716, 13720);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 13721, 13722);
            addExpectedElement(null, 13723);
            addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 13724, 14178);
            addExpectedElement(null, 14179, 14183);
            }

            // Hyconstraints.g:2734:0: ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==QUOTED_34_34||LA25_1==24||(LA25_1 >= 26 && LA25_1 <= 29)||LA25_1==36) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // Hyconstraints.g:2735:0: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    {
                    // Hyconstraints.g:2735:6: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    // Hyconstraints.g:2736:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    {
                    // Hyconstraints.g:2736:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    // Hyconstraints.g:2737:6: a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2712);
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
                    addExpectedElement(null, 14184);
                    addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 14185, 14639);
                    addExpectedElement(null, 14640, 14644);
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
            addExpectedElement(null, 14645);
            addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 14646, 15100);
            addExpectedElement(null, 15101, 15105);
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
    // Hyconstraints.g:2781:1: parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element = null] : a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ;
    public final eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyVersionRestriction a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Hyconstraints.g:2784:4: (a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
            // Hyconstraints.g:2785:4: a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            {
            a0=(Token)match(input,30,FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2747); if (state.failed) return element;

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
            addExpectedElement(null, 15106, 15107);
            }

            // Hyconstraints.g:2799:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
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
                    // Hyconstraints.g:2800:0: (a1= QUOTED_34_34 )
                    {
                    // Hyconstraints.g:2800:4: (a1= QUOTED_34_34 )
                    // Hyconstraints.g:2801:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2762); if (state.failed) return element;

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
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 15108, 15109);
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:2841:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hyconstraints.g:2841:2: (a2= IDENTIFIER_TOKEN )
                    // Hyconstraints.g:2842:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2779); if (state.failed) return element;

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
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 15110, 15111);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 15112, 15113);
            }

            // Hyconstraints.g:2887:6: (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            // Hyconstraints.g:2888:6: a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2799);
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
            addExpectedElement(null, 15114);
            addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 15115, 15569);
            addExpectedElement(null, 15570, 15574);
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



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"
    // Hyconstraints.g:2920:1: parse_eu_hyvar_feature_expression_HyBooleanValueExpression returns [eu.hyvar.feature.expression.HyBooleanValueExpression element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.feature.expression.HyBooleanValueExpression parse_eu_hyvar_feature_expression_HyBooleanValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyBooleanValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Hyconstraints.g:2923:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hyconstraints.g:2924:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hyconstraints.g:2924:0: ( (a0= 'true' |a1= 'false' ) )
            // Hyconstraints.g:2925:0: (a0= 'true' |a1= 'false' )
            {
            // Hyconstraints.g:2925:0: (a0= 'true' |a1= 'false' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==40) ) {
                alt27=1;
            }
            else if ( (LA27_0==39) ) {
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
                    // Hyconstraints.g:2926:0: a0= 'true'
                    {
                    a0=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2830); if (state.failed) return element;

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
                    // Hyconstraints.g:2939:2: a1= 'false'
                    {
                    a1=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2839); if (state.failed) return element;

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
            addExpectedElement(null, 15575);
            addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), 15576, 16030);
            addExpectedElement(null, 16031, 16035);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_4"
    // Hyconstraints.g:2966:1: parseop_HyArithmeticalValueExpression_level_4 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_5 ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_4() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_4_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Hyconstraints.g:2969:9: (leftArg= parseop_HyArithmeticalValueExpression_level_5 ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |) )
            // Hyconstraints.g:2970:9: leftArg= parseop_HyArithmeticalValueExpression_level_5 ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_42869);
            leftArg=parseop_HyArithmeticalValueExpression_level_5();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:2970:56: ( ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+ |)
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==34) ) {
                alt29=1;
            }
            else if ( (LA29_0==13||LA29_0==16||LA29_0==24||(LA29_0 >= 26 && LA29_0 <= 29)||LA29_0==43) ) {
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
                    // Hyconstraints.g:2970:57: ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+
                    {
                    // Hyconstraints.g:2970:57: ( () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5 )+
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
                    	    // Hyconstraints.g:2971:0: () a0= '\\u0025' rightArg= parseop_HyArithmeticalValueExpression_level_5
                    	    {
                    	    // Hyconstraints.g:2971:2: ()
                    	    // Hyconstraints.g:2971:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,34,FOLLOW_34_in_parseop_HyArithmeticalValueExpression_level_42882); if (state.failed) return element;

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
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), 16036, 18969);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_42893);
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
                    // Hyconstraints.g:3026:20: 
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
    // Hyconstraints.g:3031:1: parseop_HyArithmeticalValueExpression_level_5 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_6 ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_5() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_5_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Hyconstraints.g:3034:9: (leftArg= parseop_HyArithmeticalValueExpression_level_6 ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |) )
            // Hyconstraints.g:3035:9: leftArg= parseop_HyArithmeticalValueExpression_level_6 ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_52931);
            leftArg=parseop_HyArithmeticalValueExpression_level_6();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:3035:56: ( ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+ |)
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==18) ) {
                alt31=1;
            }
            else if ( (LA31_0==EOF||LA31_0==13||LA31_0==16||LA31_0==24||(LA31_0 >= 26 && LA31_0 <= 29)||LA31_0==34||LA31_0==43) ) {
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
                    // Hyconstraints.g:3035:57: ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+
                    {
                    // Hyconstraints.g:3035:57: ( () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6 )+
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
                    	    // Hyconstraints.g:3036:0: () a0= '+' rightArg= parseop_HyArithmeticalValueExpression_level_6
                    	    {
                    	    // Hyconstraints.g:3036:2: ()
                    	    // Hyconstraints.g:3036:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,18,FOLLOW_18_in_parseop_HyArithmeticalValueExpression_level_52944); if (state.failed) return element;

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
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), 18970, 21903);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_52955);
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
                    // Hyconstraints.g:3091:20: 
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
    // Hyconstraints.g:3096:1: parseop_HyArithmeticalValueExpression_level_6 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_7 ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_6() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_6_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Hyconstraints.g:3099:9: (leftArg= parseop_HyArithmeticalValueExpression_level_7 ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |) )
            // Hyconstraints.g:3100:9: leftArg= parseop_HyArithmeticalValueExpression_level_7 ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_62993);
            leftArg=parseop_HyArithmeticalValueExpression_level_7();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:3100:56: ( ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+ |)
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==20) ) {
                alt33=1;
            }
            else if ( (LA33_0==EOF||LA33_0==13||LA33_0==16||LA33_0==18||LA33_0==24||(LA33_0 >= 26 && LA33_0 <= 29)||LA33_0==34||LA33_0==43) ) {
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
                    // Hyconstraints.g:3100:57: ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+
                    {
                    // Hyconstraints.g:3100:57: ( () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7 )+
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
                    	    // Hyconstraints.g:3101:0: () a0= '-' rightArg= parseop_HyArithmeticalValueExpression_level_7
                    	    {
                    	    // Hyconstraints.g:3101:2: ()
                    	    // Hyconstraints.g:3101:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,20,FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_63006); if (state.failed) return element;

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
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), 21904, 24837);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_63017);
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
                    // Hyconstraints.g:3156:20: 
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
    // Hyconstraints.g:3161:1: parseop_HyArithmeticalValueExpression_level_7 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_8 ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_7() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_7_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Hyconstraints.g:3164:9: (leftArg= parseop_HyArithmeticalValueExpression_level_8 ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |) )
            // Hyconstraints.g:3165:9: leftArg= parseop_HyArithmeticalValueExpression_level_8 ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73055);
            leftArg=parseop_HyArithmeticalValueExpression_level_8();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:3165:56: ( ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+ |)
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==17) ) {
                alt35=1;
            }
            else if ( (LA35_0==EOF||LA35_0==13||LA35_0==16||LA35_0==18||LA35_0==20||LA35_0==24||(LA35_0 >= 26 && LA35_0 <= 29)||LA35_0==34||LA35_0==43) ) {
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
                    // Hyconstraints.g:3165:57: ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+
                    {
                    // Hyconstraints.g:3165:57: ( () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8 )+
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
                    	    // Hyconstraints.g:3166:0: () a0= '*' rightArg= parseop_HyArithmeticalValueExpression_level_8
                    	    {
                    	    // Hyconstraints.g:3166:2: ()
                    	    // Hyconstraints.g:3166:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,17,FOLLOW_17_in_parseop_HyArithmeticalValueExpression_level_73068); if (state.failed) return element;

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
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), 24838, 27771);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73079);
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
                    // Hyconstraints.g:3221:20: 
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
    // Hyconstraints.g:3226:1: parseop_HyArithmeticalValueExpression_level_8 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : leftArg= parseop_HyArithmeticalValueExpression_level_11 ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |) ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_8() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_8_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyArithmeticalValueExpression leftArg =null;

        eu.hyvar.feature.expression.HyArithmeticalValueExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Hyconstraints.g:3229:9: (leftArg= parseop_HyArithmeticalValueExpression_level_11 ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |) )
            // Hyconstraints.g:3230:9: leftArg= parseop_HyArithmeticalValueExpression_level_11 ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83117);
            leftArg=parseop_HyArithmeticalValueExpression_level_11();

            state._fsp--;
            if (state.failed) return element;

            // Hyconstraints.g:3230:57: ( ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+ |)
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==23) ) {
                alt37=1;
            }
            else if ( (LA37_0==EOF||LA37_0==13||(LA37_0 >= 16 && LA37_0 <= 18)||LA37_0==20||LA37_0==24||(LA37_0 >= 26 && LA37_0 <= 29)||LA37_0==34||LA37_0==43) ) {
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
                    // Hyconstraints.g:3230:58: ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+
                    {
                    // Hyconstraints.g:3230:58: ( () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11 )+
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
                    	    // Hyconstraints.g:3231:0: () a0= '/' rightArg= parseop_HyArithmeticalValueExpression_level_11
                    	    {
                    	    // Hyconstraints.g:3231:2: ()
                    	    // Hyconstraints.g:3231:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,23,FOLLOW_23_in_parseop_HyArithmeticalValueExpression_level_83130); if (state.failed) return element;

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
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), 27772, 30705);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83141);
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
                    // Hyconstraints.g:3286:20: 
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
    // Hyconstraints.g:3291:1: parseop_HyArithmeticalValueExpression_level_11 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c0= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_11() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_11_StartIndex = input.index();

        eu.hyvar.feature.expression.HyAttributeReferenceExpression c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Hyconstraints.g:3294:4: (c0= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression )
            // Hyconstraints.g:3295:4: c0= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_113179);
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
                    // Hyconstraints.g:3303:0: (a0= QUOTED_34_34 )
                    {
                    // Hyconstraints.g:3303:4: (a0= QUOTED_34_34 )
                    // Hyconstraints.g:3304:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3205); if (state.failed) return element;

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
                    addExpectedElement(null, 30706);
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:3344:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyconstraints.g:3344:2: (a1= IDENTIFIER_TOKEN )
                    // Hyconstraints.g:3345:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3222); if (state.failed) return element;

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
                    addExpectedElement(null, 30707);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 30708);
            }

            a2=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3240); if (state.failed) return element;

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
            addExpectedElement(null, 30709);
            }

            // Hyconstraints.g:3404:4: (a3= IDENTIFIER_TOKEN )
            // Hyconstraints.g:3405:4: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3253); if (state.failed) return element;

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
            addExpectedElement(null, 30710, 30716);
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



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_12"
    // Hyconstraints.g:3449:1: parseop_HyArithmeticalValueExpression_level_12 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c0= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_12() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_12_StartIndex = input.index();

        eu.hyvar.feature.expression.HyContextInformationReferenceExpression c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Hyconstraints.g:3452:4: (c0= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression )
            // Hyconstraints.g:3453:4: c0= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_123281);
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
            if ( state.backtracking>0 ) { memoize(input, 26, parseop_HyArithmeticalValueExpression_level_12_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_12"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"
    // Hyconstraints.g:3456:1: parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression returns [eu.hyvar.feature.expression.HyContextInformationReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ;
    public final eu.hyvar.feature.expression.HyContextInformationReferenceExpression parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyContextInformationReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Hyconstraints.g:3459:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) )
            // Hyconstraints.g:3460:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
            {
            // Hyconstraints.g:3460:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
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
                    // Hyconstraints.g:3461:0: (a0= QUOTED_34_34 )
                    {
                    // Hyconstraints.g:3461:4: (a0= QUOTED_34_34 )
                    // Hyconstraints.g:3462:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3307); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a0 != null) {
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
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
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_18_0_0_0_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a0, element);
                    copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, 30717, 30723);
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:3502:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hyconstraints.g:3502:2: (a1= IDENTIFIER_TOKEN )
                    // Hyconstraints.g:3503:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3324); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
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
                    retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_18_0_0_0_0_1_0, proxy, true);
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
                    addExpectedElement(null, 30724, 30730);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 30731, 30737);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"



    // $ANTLR start "parseop_HyArithmeticalValueExpression_level_13"
    // Hyconstraints.g:3556:1: parseop_HyArithmeticalValueExpression_level_13 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c0= parse_eu_hyvar_feature_expression_HyValueExpression ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parseop_HyArithmeticalValueExpression_level_13() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parseop_HyArithmeticalValueExpression_level_13_StartIndex = input.index();

        eu.hyvar.feature.expression.HyValueExpression c0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Hyconstraints.g:3559:4: (c0= parse_eu_hyvar_feature_expression_HyValueExpression )
            // Hyconstraints.g:3560:4: c0= parse_eu_hyvar_feature_expression_HyValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyArithmeticalValueExpression_level_133357);
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
            if ( state.backtracking>0 ) { memoize(input, 28, parseop_HyArithmeticalValueExpression_level_13_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyArithmeticalValueExpression_level_13"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyValueExpression"
    // Hyconstraints.g:3563:1: parse_eu_hyvar_feature_expression_HyValueExpression returns [eu.hyvar.feature.expression.HyValueExpression element = null] : (a0_0= parse_eu_hyvar_dataValues_HyValue ) ;
    public final eu.hyvar.feature.expression.HyValueExpression parse_eu_hyvar_feature_expression_HyValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Hyconstraints.g:3566:6: ( (a0_0= parse_eu_hyvar_dataValues_HyValue ) )
            // Hyconstraints.g:3567:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            {
            // Hyconstraints.g:3567:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            // Hyconstraints.g:3568:6: a0_0= parse_eu_hyvar_dataValues_HyValue
            {
            pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression3381);
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
            addExpectedElement(null, 30738, 30744);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 29, parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex); }

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
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Hyconstraints.g:3601:0: (a0= '-' arg= parseop_HyArithmeticalValueExpression_level_15 |arg= parseop_HyArithmeticalValueExpression_level_15 )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==20) ) {
                alt40=1;
            }
            else if ( (LA40_0==15) ) {
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
                    // Hyconstraints.g:3602:0: a0= '-' arg= parseop_HyArithmeticalValueExpression_level_15
                    {
                    a0=(Token)match(input,20,FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_143408); if (state.failed) return element;

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
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), 30745, 33678);
                    }

                    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_143419);
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
                    pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_143429);
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
            if ( state.backtracking>0 ) { memoize(input, 30, parseop_HyArithmeticalValueExpression_level_14_StartIndex); }

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
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }

            // Hyconstraints.g:3643:4: (c0= parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression )
            // Hyconstraints.g:3644:4: c0= parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_in_parseop_HyArithmeticalValueExpression_level_153451);
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
            if ( state.backtracking>0 ) { memoize(input, 31, parseop_HyArithmeticalValueExpression_level_15_StartIndex); }

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
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return element; }

            // Hyconstraints.g:3650:4: (a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a2= ')' )
            // Hyconstraints.g:3651:4: a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression ) a2= ')'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3473); if (state.failed) return element;

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
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedArithmeticalValueExpression(), 33679, 36612);
            }

            // Hyconstraints.g:3665:6: (a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression )
            // Hyconstraints.g:3666:6: a1_0= parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3486);
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
            addExpectedElement(null, 36613);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3498); if (state.failed) return element;

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
            addExpectedElement(null, 36614, 36620);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 32, parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_StartIndex); }

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
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return element; }

            // Hyconstraints.g:3713:0: (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue )
            int alt41=3;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
                {
                alt41=1;
                }
                break;
            case 39:
            case 40:
                {
                alt41=2;
                }
                break;
            case 37:
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
                    // Hyconstraints.g:3714:0: c0= parse_eu_hyvar_dataValues_HyNumberValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_153524);
                    c0=parse_eu_hyvar_dataValues_HyNumberValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:3715:2: c1= parse_eu_hyvar_dataValues_HyBooleanValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_153532);
                    c1=parse_eu_hyvar_dataValues_HyBooleanValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hyconstraints.g:3716:2: c2= parse_eu_hyvar_dataValues_HyEnumValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_153540);
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
            if ( state.backtracking>0 ) { memoize(input, 33, parseop_HyValue_level_15_StartIndex); }

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
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return element; }

            // Hyconstraints.g:3722:4: ( (a0= INTEGER_LITERAL ) )
            // Hyconstraints.g:3723:4: (a0= INTEGER_LITERAL )
            {
            // Hyconstraints.g:3723:4: (a0= INTEGER_LITERAL )
            // Hyconstraints.g:3724:4: a0= INTEGER_LITERAL
            {
            a0=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3564); if (state.failed) return element;

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
            addExpectedElement(null, 36621, 36627);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 34, parse_eu_hyvar_dataValues_HyNumberValue_StartIndex); }

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
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return element; }

            // Hyconstraints.g:3767:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hyconstraints.g:3768:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hyconstraints.g:3768:0: ( (a0= 'true' |a1= 'false' ) )
            // Hyconstraints.g:3769:0: (a0= 'true' |a1= 'false' )
            {
            // Hyconstraints.g:3769:0: (a0= 'true' |a1= 'false' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==40) ) {
                alt42=1;
            }
            else if ( (LA42_0==39) ) {
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
                    // Hyconstraints.g:3770:0: a0= 'true'
                    {
                    a0=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_dataValues_HyBooleanValue3596); if (state.failed) return element;

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
                    a1=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyBooleanValue3605); if (state.failed) return element;

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
            addExpectedElement(null, 36628, 36634);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 35, parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex); }

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
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return element; }

            // Hyconstraints.g:3811:4: (a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) ) )
            // Hyconstraints.g:3812:4: a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
            {
            a0=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_dataValues_HyEnumValue3635); if (state.failed) return element;

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
            addExpectedElement(null, 36635, 36636);
            }

            // Hyconstraints.g:3826:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
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
                    // Hyconstraints.g:3827:0: (a1= QUOTED_34_34 )
                    {
                    // Hyconstraints.g:3827:4: (a1= QUOTED_34_34 )
                    // Hyconstraints.g:3828:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3650); if (state.failed) return element;

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
                    addExpectedElement(null, 36637);
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:3868:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hyconstraints.g:3868:2: (a2= IDENTIFIER_TOKEN )
                    // Hyconstraints.g:3869:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3667); if (state.failed) return element;

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
                    addExpectedElement(null, 36638);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, 36639);
            }

            a3=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue3685); if (state.failed) return element;

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
            addExpectedElement(null, 36640, 36641);
            }

            // Hyconstraints.g:3928:0: ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
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
                    // Hyconstraints.g:3929:0: (a4= QUOTED_34_34 )
                    {
                    // Hyconstraints.g:3929:4: (a4= QUOTED_34_34 )
                    // Hyconstraints.g:3930:4: a4= QUOTED_34_34
                    {
                    a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3700); if (state.failed) return element;

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
                    addExpectedElement(null, 36642, 36648);
                    }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:3970:2: (a5= IDENTIFIER_TOKEN )
                    {
                    // Hyconstraints.g:3970:2: (a5= IDENTIFIER_TOKEN )
                    // Hyconstraints.g:3971:4: a5= IDENTIFIER_TOKEN
                    {
                    a5=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3717); if (state.failed) return element;

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
                    addExpectedElement(null, 36649, 36655);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            // We've found the last token for this rule. The constructed EObject is now
            // complete.
            completedElement(element, true);
            addExpectedElement(null, 36656, 36662);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 36, parse_eu_hyvar_dataValues_HyEnumValue_StartIndex); }

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
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return element; }

            // Hyconstraints.g:4025:3: (c= parseop_HyExpression_level_0 )
            // Hyconstraints.g:4026:3: c= parseop_HyExpression_level_0
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression3746);
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
            if ( state.backtracking>0 ) { memoize(input, 37, parse_eu_hyvar_feature_expression_HyExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression"
    // Hyconstraints.g:4030:1: parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null] : c= parseop_HyArithmeticalValueExpression_level_4 ;
    public final eu.hyvar.feature.expression.HyArithmeticalValueExpression parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyArithmeticalValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_StartIndex = input.index();

        eu.hyvar.feature.expression.HyArithmeticalValueExpression c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return element; }

            // Hyconstraints.g:4031:3: (c= parseop_HyArithmeticalValueExpression_level_4 )
            // Hyconstraints.g:4032:3: c= parseop_HyArithmeticalValueExpression_level_4
            {
            pushFollow(FOLLOW_parseop_HyArithmeticalValueExpression_level_4_in_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression3765);
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
            if ( state.backtracking>0 ) { memoize(input, 38, parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyVersionRestriction"
    // Hyconstraints.g:4036:1: parse_eu_hyvar_feature_expression_HyVersionRestriction returns [eu.hyvar.feature.expression.HyVersionRestriction element = null] : (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction );
    public final eu.hyvar.feature.expression.HyVersionRestriction parse_eu_hyvar_feature_expression_HyVersionRestriction() throws RecognitionException {
        eu.hyvar.feature.expression.HyVersionRestriction element =  null;

        int parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex = input.index();

        eu.hyvar.feature.expression.HyRelativeVersionRestriction c0 =null;

        eu.hyvar.feature.expression.HyVersionRangeRestriction c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return element; }

            // Hyconstraints.g:4037:0: (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==33) ) {
                switch ( input.LA(2) ) {
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                    {
                    alt45=1;
                    }
                    break;
                case QUOTED_34_34:
                    {
                    int LA45_3 = input.LA(3);

                    if ( (LA45_3==35) ) {
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
                case 36:
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
                    // Hyconstraints.g:4038:0: c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3784);
                    c0=parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hyconstraints.g:4039:2: c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3792);
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
            if ( state.backtracking>0 ) { memoize(input, 39, parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyVersionRestriction"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyValue"
    // Hyconstraints.g:4043:1: parse_eu_hyvar_dataValues_HyValue returns [eu.hyvar.dataValues.HyValue element = null] : c= parseop_HyValue_level_15 ;
    public final eu.hyvar.dataValues.HyValue parse_eu_hyvar_dataValues_HyValue() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parse_eu_hyvar_dataValues_HyValue_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return element; }

            // Hyconstraints.g:4044:3: (c= parseop_HyValue_level_15 )
            // Hyconstraints.g:4045:3: c= parseop_HyValue_level_15
            {
            pushFollow(FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue3811);
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
            if ( state.backtracking>0 ) { memoize(input, 40, parse_eu_hyvar_dataValues_HyValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_eu_hyvar_feature_constraint_HyConstraintModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_constraint_HyConstraint_in_parse_eu_hyvar_feature_constraint_HyConstraintModel124 = new BitSet(new long[]{0x0000018040009222L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_constraint_HyConstraint169 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_feature_constraint_HyConstraint196 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_constraint_HyConstraint229 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_feature_constraint_HyConstraint268 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_constraint_HyConstraint298 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_constraint_HyConstraint354 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_feature_constraint_HyConstraint393 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_parse_eu_hyvar_feature_constraint_HyConstraint416 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_38_in_parse_eu_hyvar_feature_constraint_HyConstraint449 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_feature_constraint_HyConstraint472 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_constraint_HyConstraint502 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_feature_constraint_HyConstraint554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression602 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression620 = new BitSet(new long[]{0x000000003D002000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression647 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression662 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression677 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression692 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression707 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression722 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression747 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction794 = new BitSet(new long[]{0x000000003D000200L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction817 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction832 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction847 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction862 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction877 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction902 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction952 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction975 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1000 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1021 = new BitSet(new long[]{0x0000001000000200L});
    public static final BitSet FOLLOW_36_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1044 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1069 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_parse_eu_hyvar_dataValues_HyEnum1119 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum1137 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum1158 = new BitSet(new long[]{0x0000000100010000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1187 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum1228 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1262 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum1336 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnum1359 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1392 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1431 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1461 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1517 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1556 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnum1589 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1612 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1642 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnum1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_parse_eu_hyvar_dataValues_HyEnumLiteral1742 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral1760 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnumLiteral1781 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral1799 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral1820 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnumLiteral1843 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1876 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1915 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1945 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2001 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral2040 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnumLiteral2063 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnumLiteral2096 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral2119 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2149 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnumLiteral2201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02249 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_parseop_HyExpression_level_02269 = new BitSet(new long[]{0x0000018040009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02286 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_12332 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_parseop_HyExpression_level_12348 = new BitSet(new long[]{0x0000018040009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_2_in_parseop_HyExpression_level_12362 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_22403 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_parseop_HyExpression_level_22416 = new BitSet(new long[]{0x0000018040009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_3_in_parseop_HyExpression_level_22427 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_32465 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_parseop_HyExpression_level_32478 = new BitSet(new long[]{0x0000018040009220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_32489 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_12_in_parseop_HyExpression_level_142527 = new BitSet(new long[]{0x0000018040008220L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_152570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_152578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_152586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_152594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedExpression2616 = new BitSet(new long[]{0x0000018040009220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression2629 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression2641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2671 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2688 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2747 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2762 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2779 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression2799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression2839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_42869 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parseop_HyArithmeticalValueExpression_level_42882 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_5_in_parseop_HyArithmeticalValueExpression_level_42893 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_52931 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_parseop_HyArithmeticalValueExpression_level_52944 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_6_in_parseop_HyArithmeticalValueExpression_level_52955 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_62993 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_63006 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_7_in_parseop_HyArithmeticalValueExpression_level_63017 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73055 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_parseop_HyArithmeticalValueExpression_level_73068 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_8_in_parseop_HyArithmeticalValueExpression_level_73079 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83117 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_parseop_HyArithmeticalValueExpression_level_83130 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_11_in_parseop_HyArithmeticalValueExpression_level_83141 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_113179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3205 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3222 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3240 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyArithmeticalValueExpression_level_123281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyArithmeticalValueExpression_level_133357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression3381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parseop_HyArithmeticalValueExpression_level_143408 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_143419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_15_in_parseop_HyArithmeticalValueExpression_level_143429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression_in_parseop_HyArithmeticalValueExpression_level_153451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3473 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3486 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression3498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_153524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_153532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_153540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_dataValues_HyBooleanValue3596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_dataValues_HyBooleanValue3605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_dataValues_HyEnumValue3635 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3650 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3667 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue3685 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression3746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyArithmeticalValueExpression_level_4_in_parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression3765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue3811 = new BitSet(new long[]{0x0000000000000002L});

}