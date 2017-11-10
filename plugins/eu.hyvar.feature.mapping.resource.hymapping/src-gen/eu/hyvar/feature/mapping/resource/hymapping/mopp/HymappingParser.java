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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DATE", "IDENTIFIER_TOKEN", "INTEGER_LITERAL", "LINEBREAK", "ML_COMMENT", "QUOTED_34_34", "QUOTED_6060_6262", "SL_COMMENT", "WHITESPACE", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'->'", "'.'", "'/'", "':'", "'<'", "'<->'", "'<='", "'='", "'>'", "'>='", "'?'", "'Enum('", "'EnumLiteral('", "'['", "'\\u0025'", "']'", "'^'", "'context:'", "'enum:'", "'eternity'", "'false'", "'ifPossible('", "'max('", "'min('", "'true'", "'||'"
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
    public static final int T__46=46;
    public static final int T__47=47;
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
        this.state.initializeRuleMemo(98 + 1);
         

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
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
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
    		int followSetID = 132;
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
    // Hymapping.g:499:1: start returns [ EObject element = null] : (c0= parse_eu_hyvar_feature_mapping_HyMappingModel ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        eu.hyvar.feature.mapping.HyMappingModel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Hymapping.g:500:2: ( (c0= parse_eu_hyvar_feature_mapping_HyMappingModel ) EOF )
            // Hymapping.g:501:2: (c0= parse_eu_hyvar_feature_mapping_HyMappingModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[2]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[3]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[4]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[6]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[7]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[8]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[10]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[11]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[12]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[13]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[14]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[15]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Hymapping.g:521:2: (c0= parse_eu_hyvar_feature_mapping_HyMappingModel )
            // Hymapping.g:522:3: c0= parse_eu_hyvar_feature_mapping_HyMappingModel
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
    // Hymapping.g:530:1: parse_eu_hyvar_feature_mapping_HyMappingModel returns [eu.hyvar.feature.mapping.HyMappingModel element = null] : ( ( (a0_0= parse_eu_hyvar_feature_mapping_HyMapping ) ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )* ) )? ;
    public final eu.hyvar.feature.mapping.HyMappingModel parse_eu_hyvar_feature_mapping_HyMappingModel() throws RecognitionException {
        eu.hyvar.feature.mapping.HyMappingModel element =  null;

        int parse_eu_hyvar_feature_mapping_HyMappingModel_StartIndex = input.index();

        eu.hyvar.feature.mapping.HyMapping a0_0 =null;

        eu.hyvar.feature.mapping.HyMapping a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Hymapping.g:533:2: ( ( ( (a0_0= parse_eu_hyvar_feature_mapping_HyMapping ) ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )* ) )? )
            // Hymapping.g:534:2: ( ( (a0_0= parse_eu_hyvar_feature_mapping_HyMapping ) ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )* ) )?
            {
            // Hymapping.g:534:2: ( ( (a0_0= parse_eu_hyvar_feature_mapping_HyMapping ) ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )* ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0 >= IDENTIFIER_TOKEN && LA2_0 <= INTEGER_LITERAL)||LA2_0==QUOTED_34_34||LA2_0==13||LA2_0==16||LA2_0==21||LA2_0==32||(LA2_0 >= 39 && LA2_0 <= 40)||(LA2_0 >= 42 && LA2_0 <= 46)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Hymapping.g:535:3: ( (a0_0= parse_eu_hyvar_feature_mapping_HyMapping ) ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )* )
                    {
                    // Hymapping.g:535:3: ( (a0_0= parse_eu_hyvar_feature_mapping_HyMapping ) ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )* )
                    // Hymapping.g:536:4: (a0_0= parse_eu_hyvar_feature_mapping_HyMapping ) ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )*
                    {
                    // Hymapping.g:536:4: (a0_0= parse_eu_hyvar_feature_mapping_HyMapping )
                    // Hymapping.g:537:5: a0_0= parse_eu_hyvar_feature_mapping_HyMapping
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
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[16]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[17]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[18]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[19]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[20]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[21]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[22]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[23]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[24]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[25]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[26]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[27]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[28]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[29]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[30]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[31]);
                    			}

                    // Hymapping.g:577:4: ( ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0 >= IDENTIFIER_TOKEN && LA1_0 <= INTEGER_LITERAL)||LA1_0==QUOTED_34_34||LA1_0==13||LA1_0==16||LA1_0==21||LA1_0==32||(LA1_0 >= 39 && LA1_0 <= 40)||(LA1_0 >= 42 && LA1_0 <= 46)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // Hymapping.g:578:5: ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) )
                    	    {
                    	    // Hymapping.g:578:5: ( (a1_0= parse_eu_hyvar_feature_mapping_HyMapping ) )
                    	    // Hymapping.g:579:6: (a1_0= parse_eu_hyvar_feature_mapping_HyMapping )
                    	    {
                    	    // Hymapping.g:579:6: (a1_0= parse_eu_hyvar_feature_mapping_HyMapping )
                    	    // Hymapping.g:580:7: a1_0= parse_eu_hyvar_feature_mapping_HyMapping
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
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[32]);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[33]);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[34]);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[35]);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[36]);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[37]);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[38]);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[39]);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[40]);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[41]);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[42]);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[43]);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[44]);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[45]);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[46]);
                    	    						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[47]);
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
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[48]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[49]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[50]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[51]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[52]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[53]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[54]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[55]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[56]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[57]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[58]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[59]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[60]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[61]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[62]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[63]);
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
            if ( state.backtracking>0 ) { memoize(input, 2, parse_eu_hyvar_feature_mapping_HyMappingModel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_mapping_HyMappingModel"



    // $ANTLR start "parse_org_deltaecore_core_decore_DEDeltaInvokation"
    // Hymapping.g:650:1: parse_org_deltaecore_core_decore_DEDeltaInvokation returns [org.deltaecore.core.decore.DEDeltaInvokation element = null] : (a0= QUOTED_6060_6262 ) ;
    public final org.deltaecore.core.decore.DEDeltaInvokation parse_org_deltaecore_core_decore_DEDeltaInvokation() throws RecognitionException {
        org.deltaecore.core.decore.DEDeltaInvokation element =  null;

        int parse_org_deltaecore_core_decore_DEDeltaInvokation_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Hymapping.g:653:2: ( (a0= QUOTED_6060_6262 ) )
            // Hymapping.g:654:2: (a0= QUOTED_6060_6262 )
            {
            // Hymapping.g:654:2: (a0= QUOTED_6060_6262 )
            // Hymapping.g:655:3: a0= QUOTED_6060_6262
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
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[64]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[65]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[66]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[67]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[68]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[69]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[70]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[71]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[72]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[73]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[74]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[75]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[76]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[77]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[78]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[79]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[80]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[81]);
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
    // Hymapping.g:713:1: parse_eu_hyvar_feature_mapping_HyMapping returns [eu.hyvar.feature.mapping.HyMapping element = null] : (a0_0= parse_eu_hyvar_feature_expression_HyExpression ) a1= ':' (a2_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) ( (a3= ',' (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) ) )* ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
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

            // Hymapping.g:716:2: ( (a0_0= parse_eu_hyvar_feature_expression_HyExpression ) a1= ':' (a2_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) ( (a3= ',' (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) ) )* ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hymapping.g:717:2: (a0_0= parse_eu_hyvar_feature_expression_HyExpression ) a1= ':' (a2_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) ( (a3= ',' (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) ) )* ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            // Hymapping.g:717:2: (a0_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hymapping.g:718:3: a0_0= parse_eu_hyvar_feature_expression_HyExpression
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
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[82]);
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
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[83]);
            	}

            // Hymapping.g:757:2: (a2_0= parse_org_deltaecore_core_decore_DEDeltaInvokation )
            // Hymapping.g:758:3: a2_0= parse_org_deltaecore_core_decore_DEDeltaInvokation
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
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[84]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[85]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[86]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[87]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[88]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[89]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[90]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[91]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[92]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[93]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[94]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[95]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[96]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[97]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[98]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[99]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[100]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[101]);
            	}

            // Hymapping.g:800:2: ( (a3= ',' (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==20) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Hymapping.g:801:3: (a3= ',' (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) )
            	    {
            	    // Hymapping.g:801:3: (a3= ',' (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation ) )
            	    // Hymapping.g:802:4: a3= ',' (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation )
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
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[102]);
            	    			}

            	    // Hymapping.g:816:4: (a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation )
            	    // Hymapping.g:817:5: a4_0= parse_org_deltaecore_core_decore_DEDeltaInvokation
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
            	    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[103]);
            	    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[104]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[105]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[106]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[107]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[108]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[109]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[110]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[111]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[112]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[113]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[114]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[115]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[116]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[117]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[118]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[119]);
            	    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[120]);
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
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[121]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[122]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[123]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[124]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[125]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[126]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[127]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[128]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[129]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[130]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[131]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[132]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[133]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[134]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[135]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[136]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[137]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[138]);
            	}

            // Hymapping.g:883:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==35) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Hymapping.g:884:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hymapping.g:884:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hymapping.g:885:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']'
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
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[139]);
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[140]);
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[141]);
                    			}

                    // Hymapping.g:901:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) )
                    int alt4=3;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==DATE) ) {
                        int LA4_1 = input.LA(2);

                        if ( (LA4_1==21) ) {
                            int LA4_3 = input.LA(3);

                            if ( (LA4_3==DATE) ) {
                                alt4=1;
                            }
                            else if ( (LA4_3==41) ) {
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
                    else if ( (LA4_0==41) ) {
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
                            // Hymapping.g:902:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hymapping.g:902:5: (a6= DATE )
                            // Hymapping.g:903:6: a6= DATE
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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[142]);
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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[143]);
                            				}

                            // Hymapping.g:952:5: (a8= DATE )
                            // Hymapping.g:953:6: a8= DATE
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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[144]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymapping.g:989:10: (a9= DATE ) a10= '-' a11= 'eternity'
                            {
                            // Hymapping.g:989:10: (a9= DATE )
                            // Hymapping.g:990:6: a9= DATE
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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[145]);
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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[146]);
                            				}

                            a11=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_feature_mapping_HyMapping671); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[147]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymapping.g:1054:10: a12= 'eternity' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_feature_mapping_HyMapping704); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[148]);
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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[149]);
                            				}

                            // Hymapping.g:1082:5: (a14= DATE )
                            // Hymapping.g:1083:6: a14= DATE
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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[150]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[151]);
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
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[152]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[153]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[154]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[155]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[156]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[157]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[158]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[159]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[160]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[161]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[162]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[163]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[164]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[165]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[166]);
                    				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[167]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[168]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[169]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[170]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[171]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[172]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[173]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[174]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[175]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[176]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[177]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[178]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[179]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[180]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[181]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[182]);
            		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[183]);
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



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction"
    // Hymapping.g:1177:1: parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction returns [eu.hyvar.feature.expression.HyRelativeVersionRestriction element = null] : a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' ;
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

            // Hymapping.g:1180:2: (a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' )
            // Hymapping.g:1181:2: a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']'
            {
            a0=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction857); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[184]);
            	}

            // Hymapping.g:1198:2: ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? )
            // Hymapping.g:1199:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
            {
            // Hymapping.g:1199:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
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
                case 31:
                    {
                    alt6=4;
                    }
                    break;
                case 30:
                    {
                    alt6=5;
                    }
                    break;
            }

            switch (alt6) {
                case 1 :
                    // Hymapping.g:1200:4: a1= '<'
                    {
                    a1=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction880); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Hymapping.g:1216:8: a2= '<='
                    {
                    a2=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction895); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Hymapping.g:1232:8: a3= '='
                    {
                    a3=(Token)match(input,29,FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction910); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a3, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 4 :
                    // Hymapping.g:1248:8: a4= '>='
                    {
                    a4=(Token)match(input,31,FOLLOW_31_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction925); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a4, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 5 :
                    // Hymapping.g:1264:8: a5= '>'
                    {
                    a5=(Token)match(input,30,FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction940); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
                    					startIncompleteElement(element);
                    					// initialize enumeration attribute
                    					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[185]);
            	}

            // Hymapping.g:1286:2: (a8= QUOTED_34_34 )
            // Hymapping.g:1287:3: a8= QUOTED_34_34
            {
            a8=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction965); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a8, element);
            				copyLocalizationInfos((CommonToken) a8, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[186]);
            	}

            a9=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction986); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            			startIncompleteElement(element);
            			// initialize enumeration attribute
            			Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[187]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[188]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[189]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[190]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[191]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[192]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[193]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[194]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[195]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[196]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[197]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[198]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[199]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[200]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[201]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[202]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[203]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[204]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[205]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[206]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[207]);
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
    // Hymapping.g:1368:1: parse_eu_hyvar_feature_expression_HyVersionRangeRestriction returns [eu.hyvar.feature.expression.HyVersionRangeRestriction element = null] : a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' ;
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

            // Hymapping.g:1371:2: (a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' )
            // Hymapping.g:1372:2: a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']'
            {
            a0=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1015); if (state.failed) return element;

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
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_28_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[208]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[209]);
            	}

            // Hymapping.g:1397:2: ( (a1= '^' )? )
            // Hymapping.g:1398:3: (a1= '^' )?
            {
            // Hymapping.g:1398:3: (a1= '^' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==38) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Hymapping.g:1399:4: a1= '^'
                    {
                    a1=(Token)match(input,38,FOLLOW_38_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1038); if (state.failed) return element;

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
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_28_0_0_1, false, true);
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
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[210]);
            	}

            // Hymapping.g:1428:2: (a3= QUOTED_34_34 )
            // Hymapping.g:1429:3: a3= QUOTED_34_34
            {
            a3=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1063); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_28_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            				copyLocalizationInfos((CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[211]);
            	}

            a4=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1084); if (state.failed) return element;

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
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_28_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[212]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[213]);
            	}

            // Hymapping.g:1503:2: ( (a5= '^' )? )
            // Hymapping.g:1504:3: (a5= '^' )?
            {
            // Hymapping.g:1504:3: (a5= '^' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==38) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Hymapping.g:1505:4: a5= '^'
                    {
                    a5=(Token)match(input,38,FOLLOW_38_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1107); if (state.failed) return element;

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
                    				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_28_0_0_4, false, true);
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
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[214]);
            	}

            // Hymapping.g:1534:2: (a7= QUOTED_34_34 )
            // Hymapping.g:1535:3: a7= QUOTED_34_34
            {
            a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1132); if (state.failed) return element;

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
            				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_28_0_0_5, proxy, true);
            				copyLocalizationInfos((CommonToken) a7, element);
            				copyLocalizationInfos((CommonToken) a7, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[215]);
            	}

            a8=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1153); if (state.failed) return element;

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
            		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_28_0_0_6, null, true);
            		copyLocalizationInfos((CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[216]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[217]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[218]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[219]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[220]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[221]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[222]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[223]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[224]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[225]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[226]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[227]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[228]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[229]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[230]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[231]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[232]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[233]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[234]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[235]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[236]);
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
    // Hymapping.g:1630:1: parse_eu_hyvar_dataValues_HyEnum returns [eu.hyvar.dataValues.HyEnum element = null] : a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? ;
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

            // Hymapping.g:1633:2: (a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? )
            // Hymapping.g:1634:2: a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            {
            a0=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnum1182); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[237]);
            	}

            // Hymapping.g:1648:2: (a1= IDENTIFIER_TOKEN )
            // Hymapping.g:1649:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum1200); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[238]);
            	}

            a2=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1221); if (state.failed) return element;

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
            		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[239]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[240]);
            	}

            // Hymapping.g:1699:2: ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==34) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Hymapping.g:1700:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    {
                    // Hymapping.g:1700:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    // Hymapping.g:1701:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    {
                    // Hymapping.g:1701:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    // Hymapping.g:1702:5: a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1250);
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
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[241]);
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[242]);
                    			}

                    // Hymapping.g:1728:4: ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==20) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // Hymapping.g:1729:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    {
                    	    // Hymapping.g:1729:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    // Hymapping.g:1730:6: a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    {
                    	    a4=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1291); if (state.failed) return element;

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
                    	    						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[243]);
                    	    					}

                    	    // Hymapping.g:1744:6: (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    // Hymapping.g:1745:7: a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1325);
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
                    	    						addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[244]);
                    	    						addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[245]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[246]);
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[247]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[248]);
            	}

            a6=(Token)match(input,17,FOLLOW_17_in_parse_eu_hyvar_dataValues_HyEnum1399); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[249]);
            	}

            // Hymapping.g:1800:2: ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==35) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // Hymapping.g:1801:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    {
                    // Hymapping.g:1801:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    // Hymapping.g:1802:4: a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']'
                    {
                    a7=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnum1422); if (state.failed) return element;

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
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[250]);
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[251]);
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[252]);
                    			}

                    // Hymapping.g:1818:4: ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) )
                    int alt11=3;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==DATE) ) {
                        int LA11_1 = input.LA(2);

                        if ( (LA11_1==21) ) {
                            int LA11_3 = input.LA(3);

                            if ( (LA11_3==DATE) ) {
                                alt11=1;
                            }
                            else if ( (LA11_3==37) ) {
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
                    else if ( (LA11_0==41) ) {
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
                            // Hymapping.g:1819:5: (a8= DATE ) a9= '-' (a10= DATE )
                            {
                            // Hymapping.g:1819:5: (a8= DATE )
                            // Hymapping.g:1820:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1455); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[253]);
                            				}

                            a9=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum1494); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[254]);
                            				}

                            // Hymapping.g:1869:5: (a10= DATE )
                            // Hymapping.g:1870:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1524); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[255]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymapping.g:1906:10: (a11= DATE ) a12= '-'
                            {
                            // Hymapping.g:1906:10: (a11= DATE )
                            // Hymapping.g:1907:6: a11= DATE
                            {
                            a11=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1580); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[256]);
                            				}

                            a12=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum1619); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[257]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymapping.g:1957:10: a13= 'eternity' a14= '-' (a15= DATE )
                            {
                            a13=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_dataValues_HyEnum1652); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[258]);
                            				}

                            a14=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum1675); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[259]);
                            				}

                            // Hymapping.g:1985:5: (a15= DATE )
                            // Hymapping.g:1986:6: a15= DATE
                            {
                            a15=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1705); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[260]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[261]);
                    			}

                    a16=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_dataValues_HyEnum1757); if (state.failed) return element;

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
            if ( state.backtracking>0 ) { memoize(input, 7, parse_eu_hyvar_dataValues_HyEnum_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnum"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumLiteral"
    // Hymapping.g:2048:1: parse_eu_hyvar_dataValues_HyEnumLiteral returns [eu.hyvar.dataValues.HyEnumLiteral element = null] : a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
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

            // Hymapping.g:2051:2: (a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hymapping.g:2052:2: a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            a0=(Token)match(input,34,FOLLOW_34_in_parse_eu_hyvar_dataValues_HyEnumLiteral1805); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[262]);
            	}

            // Hymapping.g:2066:2: (a1= IDENTIFIER_TOKEN )
            // Hymapping.g:2067:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral1823); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[263]);
            	}

            a2=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1844); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[264]);
            	}

            // Hymapping.g:2116:2: (a3= INTEGER_LITERAL )
            // Hymapping.g:2117:3: a3= INTEGER_LITERAL
            {
            a3=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral1862); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[265]);
            	}

            a4=(Token)match(input,17,FOLLOW_17_in_parse_eu_hyvar_dataValues_HyEnumLiteral1883); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[266]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[267]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[268]);
            	}

            // Hymapping.g:2168:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==35) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Hymapping.g:2169:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hymapping.g:2169:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hymapping.g:2170:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnumLiteral1906); if (state.failed) return element;

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
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[269]);
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[270]);
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[271]);
                    			}

                    // Hymapping.g:2186:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) )
                    int alt13=3;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==DATE) ) {
                        int LA13_1 = input.LA(2);

                        if ( (LA13_1==21) ) {
                            int LA13_3 = input.LA(3);

                            if ( (LA13_3==DATE) ) {
                                alt13=1;
                            }
                            else if ( (LA13_3==41) ) {
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
                    else if ( (LA13_0==41) ) {
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
                            // Hymapping.g:2187:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hymapping.g:2187:5: (a6= DATE )
                            // Hymapping.g:2188:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1939); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[272]);
                            				}

                            a7=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral1978); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[273]);
                            				}

                            // Hymapping.g:2237:5: (a8= DATE )
                            // Hymapping.g:2238:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2008); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[274]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymapping.g:2274:10: (a9= DATE ) a10= '-' a11= 'eternity'
                            {
                            // Hymapping.g:2274:10: (a9= DATE )
                            // Hymapping.g:2275:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2064); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[275]);
                            				}

                            a10=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral2103); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[276]);
                            				}

                            a11=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_dataValues_HyEnumLiteral2126); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[277]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymapping.g:2339:10: a12= 'eternity' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_dataValues_HyEnumLiteral2159); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[278]);
                            				}

                            a13=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral2182); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[279]);
                            				}

                            // Hymapping.g:2367:5: (a14= DATE )
                            // Hymapping.g:2368:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2212); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[280]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[281]);
                    			}

                    a15=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_dataValues_HyEnumLiteral2264); if (state.failed) return element;

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
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[282]);
                    				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[283]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[284]);
            		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[285]);
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
    // Hymapping.g:2434:1: parseop_HyExpression_level_0 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_0() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_0_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Hymapping.g:2437:2: (leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) )
            // Hymapping.g:2438:2: leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02312);
            leftArg=parseop_HyExpression_level_1();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:2438:41: ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            else if ( (LA16_0==EOF||LA16_0==17||LA16_0==20||LA16_0==25) ) {
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
                    // Hymapping.g:2438:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    {
                    // Hymapping.g:2438:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==27) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // Hymapping.g:2439:3: () a0= '<->' rightArg= parseop_HyExpression_level_1
                    	    {
                    	    // Hymapping.g:2439:3: ()
                    	    // Hymapping.g:2439:4: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,27,FOLLOW_27_in_parseop_HyExpression_level_02332); if (state.failed) return element;

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
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[286]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[287]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[288]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[289]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[290]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[291]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[292]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[293]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[294]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[295]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[296]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[297]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[298]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[299]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[300]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[301]);
                    	    		}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02349);
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
                    // Hymapping.g:2509:21: 
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
    // Hymapping.g:2514:1: parseop_HyExpression_level_1 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_4 ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_1() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_1_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Hymapping.g:2517:9: (leftArg= parseop_HyExpression_level_4 ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |) )
            // Hymapping.g:2518:9: leftArg= parseop_HyExpression_level_4 ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_12395);
            leftArg=parseop_HyExpression_level_4();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:2518:39: ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |)
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==22) ) {
                alt18=1;
            }
            else if ( (LA18_0==EOF||LA18_0==17||LA18_0==20||LA18_0==25||LA18_0==27) ) {
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
                    // Hymapping.g:2518:40: ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+
                    {
                    // Hymapping.g:2518:40: ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==22) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // Hymapping.g:2519:2: () a0= '->' rightArg= parseop_HyExpression_level_4
                    	    {
                    	    // Hymapping.g:2519:2: ()
                    	    // Hymapping.g:2519:3: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,22,FOLLOW_22_in_parseop_HyExpression_level_12411); if (state.failed) return element;

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
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[302]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[303]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[304]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[305]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[306]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[307]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[308]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[309]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[310]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[311]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[312]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[313]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[314]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[315]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[316]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[317]);
                    	    	}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_12425);
                    	    rightArg=parseop_HyExpression_level_4();

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
                    // Hymapping.g:2589:20: 
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



    // $ANTLR start "parseop_HyExpression_level_4"
    // Hymapping.g:2594:1: parseop_HyExpression_level_4 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_5 ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_4() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_4_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Hymapping.g:2597:9: (leftArg= parseop_HyExpression_level_5 ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |) )
            // Hymapping.g:2598:9: leftArg= parseop_HyExpression_level_5 ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_42466);
            leftArg=parseop_HyExpression_level_5();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:2598:39: ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |)
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==47) ) {
                alt20=1;
            }
            else if ( (LA20_0==EOF||LA20_0==17||LA20_0==20||LA20_0==22||LA20_0==25||LA20_0==27) ) {
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
                    // Hymapping.g:2598:40: ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+
                    {
                    // Hymapping.g:2598:40: ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==47) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // Hymapping.g:2599:0: () a0= '||' rightArg= parseop_HyExpression_level_5
                    	    {
                    	    // Hymapping.g:2599:2: ()
                    	    // Hymapping.g:2599:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,47,FOLLOW_47_in_parseop_HyExpression_level_42479); if (state.failed) return element;

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
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[318]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[319]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[320]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[321]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[322]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[323]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[324]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[325]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[326]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[327]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[328]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[329]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[330]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[331]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[332]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[333]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_42490);
                    	    rightArg=parseop_HyExpression_level_5();

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
                    // Hymapping.g:2669:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 11, parseop_HyExpression_level_4_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_4"



    // $ANTLR start "parseop_HyExpression_level_5"
    // Hymapping.g:2674:1: parseop_HyExpression_level_5 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_9 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_5() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_5_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Hymapping.g:2677:9: (leftArg= parseop_HyExpression_level_9 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |) )
            // Hymapping.g:2678:9: leftArg= parseop_HyExpression_level_9 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_52528);
            leftArg=parseop_HyExpression_level_9();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:2678:39: ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |)
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==15) ) {
                alt22=1;
            }
            else if ( (LA22_0==EOF||LA22_0==17||LA22_0==20||LA22_0==22||LA22_0==25||LA22_0==27||LA22_0==47) ) {
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
                    // Hymapping.g:2678:40: ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+
                    {
                    // Hymapping.g:2678:40: ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==15) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // Hymapping.g:2679:0: () a0= '&&' rightArg= parseop_HyExpression_level_9
                    	    {
                    	    // Hymapping.g:2679:2: ()
                    	    // Hymapping.g:2679:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,15,FOLLOW_15_in_parseop_HyExpression_level_52541); if (state.failed) return element;

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
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[334]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[335]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[336]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[337]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[338]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[339]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[340]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[341]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[342]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[343]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[344]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[345]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[346]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[347]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[348]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[349]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_52552);
                    	    rightArg=parseop_HyExpression_level_9();

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
                    // Hymapping.g:2749:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 12, parseop_HyExpression_level_5_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_5"



    // $ANTLR start "parseop_HyExpression_level_9"
    // Hymapping.g:2754:1: parseop_HyExpression_level_9 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_12 ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_9() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_9_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Hymapping.g:2757:9: (leftArg= parseop_HyExpression_level_12 ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |) )
            // Hymapping.g:2758:9: leftArg= parseop_HyExpression_level_12 ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92590);
            leftArg=parseop_HyExpression_level_12();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:2758:40: ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |)
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==14||LA24_0==26||(LA24_0 >= 28 && LA24_0 <= 31)) ) {
                alt24=1;
            }
            else if ( (LA24_0==EOF||LA24_0==15||LA24_0==17||LA24_0==20||LA24_0==22||LA24_0==25||LA24_0==27||LA24_0==47) ) {
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
                    // Hymapping.g:2758:41: ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+
                    {
                    // Hymapping.g:2758:41: ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=7;
                        switch ( input.LA(1) ) {
                        case 26:
                            {
                            alt23=1;
                            }
                            break;
                        case 28:
                            {
                            alt23=2;
                            }
                            break;
                        case 30:
                            {
                            alt23=3;
                            }
                            break;
                        case 31:
                            {
                            alt23=4;
                            }
                            break;
                        case 29:
                            {
                            alt23=5;
                            }
                            break;
                        case 14:
                            {
                            alt23=6;
                            }
                            break;

                        }

                        switch (alt23) {
                    	case 1 :
                    	    // Hymapping.g:2759:0: () a0= '<' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hymapping.g:2759:2: ()
                    	    // Hymapping.g:2759:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,26,FOLLOW_26_in_parseop_HyExpression_level_92603); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyLessExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_16_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[350]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[351]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[352]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[353]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[354]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[355]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[356]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[357]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[358]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[359]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[360]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[361]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[362]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[363]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[364]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[365]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92614);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_16_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_16_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 2 :
                    	    // Hymapping.g:2830:0: () a0= '<=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hymapping.g:2830:2: ()
                    	    // Hymapping.g:2830:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,28,FOLLOW_28_in_parseop_HyExpression_level_92632); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyLessOrEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_17_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[366]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[367]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[368]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[369]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[370]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[371]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[372]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[373]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[374]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[375]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[376]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[377]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[378]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[379]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[380]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[381]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92643);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_17_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_17_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 3 :
                    	    // Hymapping.g:2901:0: () a0= '>' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hymapping.g:2901:2: ()
                    	    // Hymapping.g:2901:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,30,FOLLOW_30_in_parseop_HyExpression_level_92661); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyGreaterExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_18_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[382]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[383]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[384]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[385]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[386]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[387]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[388]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[389]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[390]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[391]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[392]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[393]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[394]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[395]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[396]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[397]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92672);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_18_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_18_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 4 :
                    	    // Hymapping.g:2972:0: () a0= '>=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hymapping.g:2972:2: ()
                    	    // Hymapping.g:2972:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,31,FOLLOW_31_in_parseop_HyExpression_level_92690); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyGreaterOrEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_19_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[398]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[399]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[400]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[401]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[402]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[403]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[404]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[405]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[406]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[407]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[408]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[409]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[410]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[411]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[412]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[413]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92701);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_19_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_19_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 5 :
                    	    // Hymapping.g:3043:0: () a0= '=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hymapping.g:3043:2: ()
                    	    // Hymapping.g:3043:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,29,FOLLOW_29_in_parseop_HyExpression_level_92719); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_25_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[414]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[415]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[416]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[417]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[418]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[419]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[420]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[421]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[422]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[423]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[424]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[425]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[426]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[427]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[428]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[429]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92730);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_25_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_25_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 6 :
                    	    // Hymapping.g:3114:0: () a0= '!=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Hymapping.g:3114:2: ()
                    	    // Hymapping.g:3114:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,14,FOLLOW_14_in_parseop_HyExpression_level_92748); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNotEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_26_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[430]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[431]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[432]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[433]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[434]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[435]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[436]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[437]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[438]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[439]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[440]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[441]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[442]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[443]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[444]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[445]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92759);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_26_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_26_0_0_2, rightArg, true);
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
                    // Hymapping.g:3184:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 13, parseop_HyExpression_level_9_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_9"



    // $ANTLR start "parseop_HyExpression_level_12"
    // Hymapping.g:3189:1: parseop_HyExpression_level_12 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_13 ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_12() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_12_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Hymapping.g:3192:9: (leftArg= parseop_HyExpression_level_13 ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |) )
            // Hymapping.g:3193:9: leftArg= parseop_HyExpression_level_13 ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122797);
            leftArg=parseop_HyExpression_level_13();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:3193:40: ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |)
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==19||LA26_0==21) ) {
                alt26=1;
            }
            else if ( (LA26_0==EOF||(LA26_0 >= 14 && LA26_0 <= 15)||LA26_0==17||LA26_0==20||LA26_0==22||(LA26_0 >= 25 && LA26_0 <= 31)||LA26_0==47) ) {
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
                    // Hymapping.g:3193:41: ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+
                    {
                    // Hymapping.g:3193:41: ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=3;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==21) ) {
                            alt25=1;
                        }
                        else if ( (LA25_0==19) ) {
                            alt25=2;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // Hymapping.g:3194:0: () a0= '-' rightArg= parseop_HyExpression_level_13
                    	    {
                    	    // Hymapping.g:3194:2: ()
                    	    // Hymapping.g:3194:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,21,FOLLOW_21_in_parseop_HyExpression_level_122810); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHySubtractionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[446]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[447]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[448]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[449]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[450]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[451]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[452]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[453]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[454]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[455]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[456]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[457]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[458]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[459]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[460]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[461]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122821);
                    	    rightArg=parseop_HyExpression_level_13();

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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_0, leftArg, true);
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 2 :
                    	    // Hymapping.g:3265:0: () a0= '+' rightArg= parseop_HyExpression_level_13
                    	    {
                    	    // Hymapping.g:3265:2: ()
                    	    // Hymapping.g:3265:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,19,FOLLOW_19_in_parseop_HyExpression_level_122839); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAdditionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[462]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[463]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[464]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[465]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[466]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[467]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[468]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[469]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[470]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[471]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[472]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[473]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[474]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[475]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[476]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[477]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122850);
                    	    rightArg=parseop_HyExpression_level_13();

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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_0, leftArg, true);
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_2, rightArg, true);
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
                    // Hymapping.g:3335:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 14, parseop_HyExpression_level_12_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_12"



    // $ANTLR start "parseop_HyExpression_level_13"
    // Hymapping.g:3340:1: parseop_HyExpression_level_13 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_14 ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_13() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_13_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Hymapping.g:3343:9: (leftArg= parseop_HyExpression_level_14 ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |) )
            // Hymapping.g:3344:9: leftArg= parseop_HyExpression_level_14 ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132888);
            leftArg=parseop_HyExpression_level_14();

            state._fsp--;
            if (state.failed) return element;

            // Hymapping.g:3344:40: ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |)
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==18||LA28_0==24||LA28_0==36) ) {
                alt28=1;
            }
            else if ( (LA28_0==EOF||(LA28_0 >= 14 && LA28_0 <= 15)||LA28_0==17||(LA28_0 >= 19 && LA28_0 <= 22)||(LA28_0 >= 25 && LA28_0 <= 31)||LA28_0==47) ) {
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
                    // Hymapping.g:3344:41: ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+
                    {
                    // Hymapping.g:3344:41: ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=4;
                        switch ( input.LA(1) ) {
                        case 36:
                            {
                            alt27=1;
                            }
                            break;
                        case 18:
                            {
                            alt27=2;
                            }
                            break;
                        case 24:
                            {
                            alt27=3;
                            }
                            break;

                        }

                        switch (alt27) {
                    	case 1 :
                    	    // Hymapping.g:3345:0: () a0= '\\u0025' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Hymapping.g:3345:2: ()
                    	    // Hymapping.g:3345:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,36,FOLLOW_36_in_parseop_HyExpression_level_132901); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyModuloExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_22_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[478]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[479]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[480]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[481]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[482]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[483]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[484]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[485]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[486]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[487]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[488]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[489]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[490]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[491]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[492]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[493]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132912);
                    	    rightArg=parseop_HyExpression_level_14();

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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_22_0_0_0, leftArg, true);
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_22_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 2 :
                    	    // Hymapping.g:3416:0: () a0= '*' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Hymapping.g:3416:2: ()
                    	    // Hymapping.g:3416:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,18,FOLLOW_18_in_parseop_HyExpression_level_132930); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMultiplicationExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_23_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[494]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[495]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[496]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[497]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[498]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[499]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[500]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[501]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[502]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[503]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[504]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[505]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[506]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[507]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[508]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[509]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132941);
                    	    rightArg=parseop_HyExpression_level_14();

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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_23_0_0_0, leftArg, true);
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_23_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 3 :
                    	    // Hymapping.g:3487:0: () a0= '/' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Hymapping.g:3487:2: ()
                    	    // Hymapping.g:3487:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,24,FOLLOW_24_in_parseop_HyExpression_level_132959); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyDivisionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_24_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[510]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[511]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[512]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[513]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[514]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[515]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[516]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[517]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[518]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[519]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[520]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[521]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[522]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[523]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[524]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[525]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132970);
                    	    rightArg=parseop_HyExpression_level_14();

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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_24_0_0_0, leftArg, true);
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
                    	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_24_0_0_2, rightArg, true);
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
                    // Hymapping.g:3557:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 15, parseop_HyExpression_level_13_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_13"



    // $ANTLR start "parseop_HyExpression_level_14"
    // Hymapping.g:3562:1: parseop_HyExpression_level_14 returns [eu.hyvar.feature.expression.HyExpression element = null] : (a0= '!' arg= parseop_HyExpression_level_15 |a2= '-' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 );
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_14() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_14_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression arg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Hymapping.g:3565:0: (a0= '!' arg= parseop_HyExpression_level_15 |a2= '-' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt29=1;
                }
                break;
            case 21:
                {
                alt29=2;
                }
                break;
            case IDENTIFIER_TOKEN:
            case INTEGER_LITERAL:
            case QUOTED_34_34:
            case 16:
            case 32:
            case 39:
            case 40:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                {
                alt29=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }

            switch (alt29) {
                case 1 :
                    // Hymapping.g:3566:0: a0= '!' arg= parseop_HyExpression_level_15
                    {
                    a0=(Token)match(input,13,FOLLOW_13_in_parseop_HyExpression_level_143008); if (state.failed) return element;

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
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[526]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[527]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[528]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[529]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[530]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[531]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[532]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[533]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[534]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[535]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[536]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[537]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[538]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[539]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[540]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[541]);
                    }

                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143019);
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
                    // Hymapping.g:3615:0: a2= '-' arg= parseop_HyExpression_level_15
                    {
                    a2=(Token)match(input,21,FOLLOW_21_in_parseop_HyExpression_level_143028); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNegationExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_5_0_0_0, null, true);
                    copyLocalizationInfos((CommonToken)a2, element);
                    }

                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[542]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[543]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[544]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[545]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[546]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[547]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[548]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[549]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[550]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[551]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[552]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[553]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[554]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[555]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[556]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[557]);
                    }

                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143039);
                    arg=parseop_HyExpression_level_15();

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
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_5_0_0_1, arg, true);
                    copyLocalizationInfos(arg, element);
                    }
                    }

                    }
                    break;
                case 3 :
                    // Hymapping.g:3665:5: arg= parseop_HyExpression_level_15
                    {
                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143049);
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
            if ( state.backtracking>0 ) { memoize(input, 16, parseop_HyExpression_level_14_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_14"



    // $ANTLR start "parseop_HyExpression_level_15"
    // Hymapping.g:3668:1: parseop_HyExpression_level_15 returns [eu.hyvar.feature.expression.HyExpression element = null] : (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression |c4= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression |c5= parse_eu_hyvar_feature_expression_HyValueExpression |c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression |c7= parse_eu_hyvar_feature_expression_HyMinimumExpression |c8= parse_eu_hyvar_feature_expression_HyMaximumExpression |c9= parse_eu_hyvar_feature_expression_HyIfPossibleExpression );
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Hymapping.g:3671:0: (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression |c4= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression |c5= parse_eu_hyvar_feature_expression_HyValueExpression |c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression |c7= parse_eu_hyvar_feature_expression_HyMinimumExpression |c8= parse_eu_hyvar_feature_expression_HyMaximumExpression |c9= parse_eu_hyvar_feature_expression_HyIfPossibleExpression )
            int alt30=10;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt30=1;
                }
                break;
            case QUOTED_34_34:
                {
                int LA30_2 = input.LA(2);

                if ( (LA30_2==EOF||(LA30_2 >= 14 && LA30_2 <= 15)||(LA30_2 >= 17 && LA30_2 <= 22)||(LA30_2 >= 24 && LA30_2 <= 31)||(LA30_2 >= 35 && LA30_2 <= 36)||LA30_2==47) ) {
                    alt30=2;
                }
                else if ( (LA30_2==23) ) {
                    alt30=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 2, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER_TOKEN:
                {
                int LA30_3 = input.LA(2);

                if ( (LA30_3==EOF||(LA30_3 >= 14 && LA30_3 <= 15)||(LA30_3 >= 17 && LA30_3 <= 22)||(LA30_3 >= 24 && LA30_3 <= 31)||(LA30_3 >= 35 && LA30_3 <= 36)||LA30_3==47) ) {
                    alt30=2;
                }
                else if ( (LA30_3==23) ) {
                    alt30=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 3, input);

                    throw nvae;

                }
                }
                break;
            case 32:
                {
                alt30=3;
                }
                break;
            case 39:
                {
                alt30=4;
                }
                break;
            case INTEGER_LITERAL:
            case 40:
                {
                alt30=6;
                }
                break;
            case 46:
                {
                int LA30_7 = input.LA(2);

                if ( (synpred51_Hymapping()) ) {
                    alt30=6;
                }
                else if ( (synpred52_Hymapping()) ) {
                    alt30=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 7, input);

                    throw nvae;

                }
                }
                break;
            case 42:
                {
                int LA30_8 = input.LA(2);

                if ( (synpred51_Hymapping()) ) {
                    alt30=6;
                }
                else if ( (synpred52_Hymapping()) ) {
                    alt30=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 8, input);

                    throw nvae;

                }
                }
                break;
            case 45:
                {
                alt30=8;
                }
                break;
            case 44:
                {
                alt30=9;
                }
                break;
            case 43:
                {
                alt30=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }

            switch (alt30) {
                case 1 :
                    // Hymapping.g:3672:0: c0= parse_eu_hyvar_feature_expression_HyNestedExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_153071);
                    c0=parse_eu_hyvar_feature_expression_HyNestedExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hymapping.g:3673:2: c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_153079);
                    c1=parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hymapping.g:3674:2: c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_153087);
                    c2=parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Hymapping.g:3675:2: c3= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyExpression_level_153095);
                    c3=parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Hymapping.g:3676:2: c4= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyExpression_level_153103);
                    c4=parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Hymapping.g:3677:2: c5= parse_eu_hyvar_feature_expression_HyValueExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyExpression_level_153111);
                    c5=parse_eu_hyvar_feature_expression_HyValueExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Hymapping.g:3678:2: c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_153119);
                    c6=parse_eu_hyvar_feature_expression_HyBooleanValueExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Hymapping.g:3679:2: c7= parse_eu_hyvar_feature_expression_HyMinimumExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyMinimumExpression_in_parseop_HyExpression_level_153127);
                    c7=parse_eu_hyvar_feature_expression_HyMinimumExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Hymapping.g:3680:2: c8= parse_eu_hyvar_feature_expression_HyMaximumExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyMaximumExpression_in_parseop_HyExpression_level_153135);
                    c8=parse_eu_hyvar_feature_expression_HyMaximumExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c8; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 10 :
                    // Hymapping.g:3681:2: c9= parse_eu_hyvar_feature_expression_HyIfPossibleExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyIfPossibleExpression_in_parseop_HyExpression_level_153143);
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
            if ( state.backtracking>0 ) { memoize(input, 17, parseop_HyExpression_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_15"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyNestedExpression"
    // Hymapping.g:3684:1: parse_eu_hyvar_feature_expression_HyNestedExpression returns [eu.hyvar.feature.expression.HyNestedExpression element = null] : a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyNestedExpression parse_eu_hyvar_feature_expression_HyNestedExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyNestedExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Hymapping.g:3687:4: (a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Hymapping.g:3688:4: a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression3165); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_6_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[558]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[559]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[560]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[561]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[562]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[563]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[564]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[565]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[566]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[567]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[568]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[569]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[570]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[571]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[572]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[573]);
            }

            // Hymapping.g:3717:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hymapping.g:3718:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression3178);
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
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_6_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[574]);
            }

            a2=(Token)match(input,17,FOLLOW_17_in_parse_eu_hyvar_feature_expression_HyNestedExpression3190); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_6_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[575]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[576]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[577]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[578]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[579]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[580]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[581]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[582]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[583]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[584]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[585]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[586]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[587]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[588]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[589]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[590]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[591]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[592]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[593]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[594]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[595]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyNestedExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression"
    // Hymapping.g:3779:1: parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyFeatureReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? ;
    public final eu.hyvar.feature.expression.HyFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        eu.hyvar.feature.expression.HyVersionRestriction a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Hymapping.g:3782:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? )
            // Hymapping.g:3783:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            {
            // Hymapping.g:3783:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
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
                    // Hymapping.g:3784:0: (a0= QUOTED_34_34 )
                    {
                    // Hymapping.g:3784:4: (a0= QUOTED_34_34 )
                    // Hymapping.g:3785:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3220); if (state.failed) return element;

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
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a0, element);
                    copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[596]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[597]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[598]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[599]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[600]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[601]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[602]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[603]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[604]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[605]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[606]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[607]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[608]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[609]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[610]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[611]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[612]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[613]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[614]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[615]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[616]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[617]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[618]);
                    }

                    }
                    break;
                case 2 :
                    // Hymapping.g:3847:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hymapping.g:3847:2: (a1= IDENTIFIER_TOKEN )
                    // Hymapping.g:3848:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3237); if (state.failed) return element;

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
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[619]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[620]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[621]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[622]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[623]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[624]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[625]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[626]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[627]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[628]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[629]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[630]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[631]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[632]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[633]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[634]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[635]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[636]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[637]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[638]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[639]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[640]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[641]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[642]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[643]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[644]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[645]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[646]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[647]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[648]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[649]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[650]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[651]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[652]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[653]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[654]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[655]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[656]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[657]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[658]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[659]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[660]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[661]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[662]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[663]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[664]);
            }

            // Hymapping.g:3937:0: ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==35) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // Hymapping.g:3938:0: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    {
                    // Hymapping.g:3938:6: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    // Hymapping.g:3939:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    {
                    // Hymapping.g:3939:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    // Hymapping.g:3940:6: a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3261);
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
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_0_0, a2_0, true);
                    copyLocalizationInfos(a2_0, element);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[665]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[666]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[667]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[668]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[669]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[670]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[671]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[672]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[673]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[674]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[675]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[676]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[677]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[678]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[679]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[680]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[681]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[682]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[683]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[684]);
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[685]);
                    }

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[686]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[687]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[688]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[689]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[690]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[691]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[692]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[693]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[694]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[695]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[696]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[697]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[698]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[699]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[700]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[701]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[702]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[703]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[704]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[705]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[706]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression"
    // Hymapping.g:4014:1: parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element = null] : a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ;
    public final eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyVersionRestriction a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Hymapping.g:4017:4: (a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
            // Hymapping.g:4018:4: a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            {
            a0=(Token)match(input,32,FOLLOW_32_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3296); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_8_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[707]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[708]);
            }

            // Hymapping.g:4033:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==QUOTED_34_34) ) {
                alt33=1;
            }
            else if ( (LA33_0==IDENTIFIER_TOKEN) ) {
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
                    // Hymapping.g:4034:0: (a1= QUOTED_34_34 )
                    {
                    // Hymapping.g:4034:4: (a1= QUOTED_34_34 )
                    // Hymapping.g:4035:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3311); if (state.failed) return element;

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
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[709]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[710]);
                    }

                    }
                    break;
                case 2 :
                    // Hymapping.g:4076:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Hymapping.g:4076:2: (a2= IDENTIFIER_TOKEN )
                    // Hymapping.g:4077:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3328); if (state.failed) return element;

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
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a2, element);
                    copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[711]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[712]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[713]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[714]);
            }

            // Hymapping.g:4124:6: (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            // Hymapping.g:4125:6: a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3348);
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
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_8_0_0_2, a3_0, true);
            copyLocalizationInfos(a3_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[715]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[716]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[717]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[718]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[719]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[720]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[721]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[722]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[723]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[724]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[725]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[726]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[727]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[728]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[729]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[730]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[731]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[732]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[733]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[734]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[735]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"
    // Hymapping.g:4172:1: parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression returns [eu.hyvar.feature.expression.HyContextInformationReferenceExpression element = null] : a0= 'context:' (a1= IDENTIFIER_TOKEN ) ;
    public final eu.hyvar.feature.expression.HyContextInformationReferenceExpression parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyContextInformationReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Hymapping.g:4175:4: (a0= 'context:' (a1= IDENTIFIER_TOKEN ) )
            // Hymapping.g:4176:4: a0= 'context:' (a1= IDENTIFIER_TOKEN )
            {
            a0=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3375); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[736]);
            }

            // Hymapping.g:4190:4: (a1= IDENTIFIER_TOKEN )
            // Hymapping.g:4191:4: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3388); if (state.failed) return element;

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
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_1, proxy, true);
            copyLocalizationInfos((CommonToken) a1, element);
            copyLocalizationInfos((CommonToken) a1, proxy);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[737]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[738]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[739]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[740]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[741]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[742]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[743]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[744]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[745]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[746]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[747]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[748]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[749]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[750]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[751]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[752]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[753]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[754]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[755]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[756]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[757]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression"
    // Hymapping.g:4252:1: parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression returns [eu.hyvar.feature.expression.HyAttributeReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) ;
    public final eu.hyvar.feature.expression.HyAttributeReferenceExpression parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyAttributeReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Hymapping.g:4255:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) )
            // Hymapping.g:4256:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN )
            {
            // Hymapping.g:4256:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
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
                    // Hymapping.g:4257:0: (a0= QUOTED_34_34 )
                    {
                    // Hymapping.g:4257:4: (a0= QUOTED_34_34 )
                    // Hymapping.g:4258:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3420); if (state.failed) return element;

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
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a0, element);
                    copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[758]);
                    }

                    }
                    break;
                case 2 :
                    // Hymapping.g:4298:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hymapping.g:4298:2: (a1= IDENTIFIER_TOKEN )
                    // Hymapping.g:4299:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3437); if (state.failed) return element;

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
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[759]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[760]);
            }

            a2=(Token)match(input,23,FOLLOW_23_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3455); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_10_0_0_1, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[761]);
            }

            // Hymapping.g:4358:4: (a3= IDENTIFIER_TOKEN )
            // Hymapping.g:4359:4: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3468); if (state.failed) return element;

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
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_10_0_0_2, proxy, true);
            copyLocalizationInfos((CommonToken) a3, element);
            copyLocalizationInfos((CommonToken) a3, proxy);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[762]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[763]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[764]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[765]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[766]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[767]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[768]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[769]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[770]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[771]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[772]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[773]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[774]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[775]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[776]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[777]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[778]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[779]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[780]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[781]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[782]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyValueExpression"
    // Hymapping.g:4420:1: parse_eu_hyvar_feature_expression_HyValueExpression returns [eu.hyvar.feature.expression.HyValueExpression element = null] : (a0_0= parse_eu_hyvar_dataValues_HyValue ) ;
    public final eu.hyvar.feature.expression.HyValueExpression parse_eu_hyvar_feature_expression_HyValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Hymapping.g:4423:6: ( (a0_0= parse_eu_hyvar_dataValues_HyValue ) )
            // Hymapping.g:4424:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            {
            // Hymapping.g:4424:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            // Hymapping.g:4425:6: a0_0= parse_eu_hyvar_dataValues_HyValue
            {
            pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression3498);
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
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_11_0_0_0, a0_0, true);
            copyLocalizationInfos(a0_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[783]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[784]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[785]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[786]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[787]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[788]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[789]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[790]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[791]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[792]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[793]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[794]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[795]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[796]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[797]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[798]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[799]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[800]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[801]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[802]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[803]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyValueExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"
    // Hymapping.g:4472:1: parse_eu_hyvar_feature_expression_HyBooleanValueExpression returns [eu.hyvar.feature.expression.HyBooleanValueExpression element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.feature.expression.HyBooleanValueExpression parse_eu_hyvar_feature_expression_HyBooleanValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyBooleanValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Hymapping.g:4475:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hymapping.g:4476:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hymapping.g:4476:0: ( (a0= 'true' |a1= 'false' ) )
            // Hymapping.g:4477:0: (a0= 'true' |a1= 'false' )
            {
            // Hymapping.g:4477:0: (a0= 'true' |a1= 'false' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==46) ) {
                alt35=1;
            }
            else if ( (LA35_0==42) ) {
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
                    // Hymapping.g:4478:0: a0= 'true'
                    {
                    a0=(Token)match(input,46,FOLLOW_46_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3529); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_12_0_0_0, true, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    // set value of boolean attribute
                    Object value = true;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 2 :
                    // Hymapping.g:4491:2: a1= 'false'
                    {
                    a1=(Token)match(input,42,FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3538); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_12_0_0_0, false, true);
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
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[804]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[805]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[806]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[807]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[808]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[809]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[810]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[811]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[812]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[813]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[814]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[815]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[816]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[817]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[818]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[819]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[820]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[821]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[822]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[823]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[824]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 24, parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyMinimumExpression"
    // Hymapping.g:4533:1: parse_eu_hyvar_feature_expression_HyMinimumExpression returns [eu.hyvar.feature.expression.HyMinimumExpression element = null] : a0= 'min(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyMinimumExpression parse_eu_hyvar_feature_expression_HyMinimumExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyMinimumExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyMinimumExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }

            // Hymapping.g:4536:4: (a0= 'min(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Hymapping.g:4537:4: a0= 'min(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,45,FOLLOW_45_in_parse_eu_hyvar_feature_expression_HyMinimumExpression3568); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMinimumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_13_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[825]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[826]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[827]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[828]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[829]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[830]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[831]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[832]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[833]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[834]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[835]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[836]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[837]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[838]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[839]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[840]);
            }

            // Hymapping.g:4566:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hymapping.g:4567:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMinimumExpression3581);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_13_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[841]);
            }

            a2=(Token)match(input,17,FOLLOW_17_in_parse_eu_hyvar_feature_expression_HyMinimumExpression3593); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMinimumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_13_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[842]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[843]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[844]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[845]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[846]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[847]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[848]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[849]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[850]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[851]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[852]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[853]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[854]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[855]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[856]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[857]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[858]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[859]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[860]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[861]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[862]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, parse_eu_hyvar_feature_expression_HyMinimumExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyMinimumExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyMaximumExpression"
    // Hymapping.g:4628:1: parse_eu_hyvar_feature_expression_HyMaximumExpression returns [eu.hyvar.feature.expression.HyMaximumExpression element = null] : a0= 'max(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyMaximumExpression parse_eu_hyvar_feature_expression_HyMaximumExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyMaximumExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyMaximumExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Hymapping.g:4631:4: (a0= 'max(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Hymapping.g:4632:4: a0= 'max(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,44,FOLLOW_44_in_parse_eu_hyvar_feature_expression_HyMaximumExpression3619); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMaximumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_14_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[863]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[864]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[865]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[866]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[867]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[868]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[869]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[870]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[871]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[872]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[873]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[874]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[875]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[876]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[877]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[878]);
            }

            // Hymapping.g:4661:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hymapping.g:4662:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMaximumExpression3632);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_14_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[879]);
            }

            a2=(Token)match(input,17,FOLLOW_17_in_parse_eu_hyvar_feature_expression_HyMaximumExpression3644); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMaximumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_14_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[880]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[881]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[882]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[883]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[884]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[885]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[886]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[887]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[888]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[889]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[890]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[891]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[892]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[893]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[894]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[895]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[896]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[897]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[898]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[899]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[900]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, parse_eu_hyvar_feature_expression_HyMaximumExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyMaximumExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyIfPossibleExpression"
    // Hymapping.g:4723:1: parse_eu_hyvar_feature_expression_HyIfPossibleExpression returns [eu.hyvar.feature.expression.HyIfPossibleExpression element = null] : a0= 'ifPossible(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )* a4= ')' ;
    public final eu.hyvar.feature.expression.HyIfPossibleExpression parse_eu_hyvar_feature_expression_HyIfPossibleExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyIfPossibleExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyIfPossibleExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;

        eu.hyvar.feature.expression.HyExpression a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Hymapping.g:4726:4: (a0= 'ifPossible(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )* a4= ')' )
            // Hymapping.g:4727:4: a0= 'ifPossible(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )* a4= ')'
            {
            a0=(Token)match(input,43,FOLLOW_43_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3670); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_15_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[901]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[902]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[903]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[904]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[905]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[906]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[907]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[908]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[909]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[910]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[911]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[912]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[913]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[914]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[915]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[916]);
            }

            // Hymapping.g:4756:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Hymapping.g:4757:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3683);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_15_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[917]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[918]);
            }

            // Hymapping.g:4783:0: ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==20) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // Hymapping.g:4784:0: (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) )
            	    {
            	    // Hymapping.g:4784:4: (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) )
            	    // Hymapping.g:4785:4: a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression )
            	    {
            	    a2=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3699); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    if (element == null) {
            	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
            	    startIncompleteElement(element);
            	    }
            	    collectHiddenTokens(element);
            	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_0, null, true);
            	    copyLocalizationInfos((CommonToken)a2, element);
            	    }

            	    if ( state.backtracking==0 ) {
            	    // expected elements (follow set)
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[919]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[920]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[921]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[922]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[923]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[924]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[925]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[926]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[927]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[928]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[929]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[930]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[931]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[932]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[933]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[934]);
            	    }

            	    // Hymapping.g:4814:6: (a3_0= parse_eu_hyvar_feature_expression_HyExpression )
            	    // Hymapping.g:4815:6: a3_0= parse_eu_hyvar_feature_expression_HyExpression
            	    {
            	    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3712);
            	    a3_0=parse_eu_hyvar_feature_expression_HyExpression();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    if (terminateParsing) {
            	    throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
            	    retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_1, a3_0, true);
            	    copyLocalizationInfos(a3_0, element);
            	    }
            	    }

            	    }


            	    if ( state.backtracking==0 ) {
            	    // expected elements (follow set)
            	    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[935]);
            	    addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[936]);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[937]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[938]);
            }

            a4=(Token)match(input,17,FOLLOW_17_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3732); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_15_0_0_3, null, true);
            copyLocalizationInfos((CommonToken)a4, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[939]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[940]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[941]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[942]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[943]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[944]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[945]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[946]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[947]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[948]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[949]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[950]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[951]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[952]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[953]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[954]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[955]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[956]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[957]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[958]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[959]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, parse_eu_hyvar_feature_expression_HyIfPossibleExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyIfPossibleExpression"



    // $ANTLR start "parseop_HyValue_level_15"
    // Hymapping.g:4885:1: parseop_HyValue_level_15 returns [eu.hyvar.dataValues.HyValue element = null] : (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue );
    public final eu.hyvar.dataValues.HyValue parseop_HyValue_level_15() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parseop_HyValue_level_15_StartIndex = input.index();

        eu.hyvar.dataValues.HyNumberValue c0 =null;

        eu.hyvar.dataValues.HyBooleanValue c1 =null;

        eu.hyvar.dataValues.HyEnumValue c2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Hymapping.g:4888:0: (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue )
            int alt37=3;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
                {
                alt37=1;
                }
                break;
            case 42:
            case 46:
                {
                alt37=2;
                }
                break;
            case 40:
                {
                alt37=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }

            switch (alt37) {
                case 1 :
                    // Hymapping.g:4889:0: c0= parse_eu_hyvar_dataValues_HyNumberValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_153758);
                    c0=parse_eu_hyvar_dataValues_HyNumberValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hymapping.g:4890:2: c1= parse_eu_hyvar_dataValues_HyBooleanValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_153766);
                    c1=parse_eu_hyvar_dataValues_HyBooleanValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hymapping.g:4891:2: c2= parse_eu_hyvar_dataValues_HyEnumValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_153774);
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
            if ( state.backtracking>0 ) { memoize(input, 28, parseop_HyValue_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyValue_level_15"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyNumberValue"
    // Hymapping.g:4894:1: parse_eu_hyvar_dataValues_HyNumberValue returns [eu.hyvar.dataValues.HyNumberValue element = null] : (a0= INTEGER_LITERAL ) ;
    public final eu.hyvar.dataValues.HyNumberValue parse_eu_hyvar_dataValues_HyNumberValue() throws RecognitionException {
        eu.hyvar.dataValues.HyNumberValue element =  null;

        int parse_eu_hyvar_dataValues_HyNumberValue_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Hymapping.g:4897:4: ( (a0= INTEGER_LITERAL ) )
            // Hymapping.g:4898:4: (a0= INTEGER_LITERAL )
            {
            // Hymapping.g:4898:4: (a0= INTEGER_LITERAL )
            // Hymapping.g:4899:4: a0= INTEGER_LITERAL
            {
            a0=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3798); if (state.failed) return element;

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
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[960]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[961]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[962]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[963]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[964]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[965]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[966]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[967]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[968]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[969]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[970]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[971]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[972]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[973]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[974]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[975]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[976]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[977]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[978]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[979]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[980]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 29, parse_eu_hyvar_dataValues_HyNumberValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyNumberValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyBooleanValue"
    // Hymapping.g:4956:1: parse_eu_hyvar_dataValues_HyBooleanValue returns [eu.hyvar.dataValues.HyBooleanValue element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.dataValues.HyBooleanValue parse_eu_hyvar_dataValues_HyBooleanValue() throws RecognitionException {
        eu.hyvar.dataValues.HyBooleanValue element =  null;

        int parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Hymapping.g:4959:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hymapping.g:4960:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hymapping.g:4960:0: ( (a0= 'true' |a1= 'false' ) )
            // Hymapping.g:4961:0: (a0= 'true' |a1= 'false' )
            {
            // Hymapping.g:4961:0: (a0= 'true' |a1= 'false' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==46) ) {
                alt38=1;
            }
            else if ( (LA38_0==42) ) {
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
                    // Hymapping.g:4962:0: a0= 'true'
                    {
                    a0=(Token)match(input,46,FOLLOW_46_in_parse_eu_hyvar_dataValues_HyBooleanValue3830); if (state.failed) return element;

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
                    // Hymapping.g:4975:2: a1= 'false'
                    {
                    a1=(Token)match(input,42,FOLLOW_42_in_parse_eu_hyvar_dataValues_HyBooleanValue3839); if (state.failed) return element;

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
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[981]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[982]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[983]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[984]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[985]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[986]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[987]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[988]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[989]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[990]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[991]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[992]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[993]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[994]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[995]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[996]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[997]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[998]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[999]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1000]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1001]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyBooleanValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumValue"
    // Hymapping.g:5017:1: parse_eu_hyvar_dataValues_HyEnumValue returns [eu.hyvar.dataValues.HyEnumValue element = null] : a0= 'enum:' (a1= IDENTIFIER_TOKEN ) a2= '.' (a3= IDENTIFIER_TOKEN ) ;
    public final eu.hyvar.dataValues.HyEnumValue parse_eu_hyvar_dataValues_HyEnumValue() throws RecognitionException {
        eu.hyvar.dataValues.HyEnumValue element =  null;

        int parse_eu_hyvar_dataValues_HyEnumValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }

            // Hymapping.g:5020:4: (a0= 'enum:' (a1= IDENTIFIER_TOKEN ) a2= '.' (a3= IDENTIFIER_TOKEN ) )
            // Hymapping.g:5021:4: a0= 'enum:' (a1= IDENTIFIER_TOKEN ) a2= '.' (a3= IDENTIFIER_TOKEN )
            {
            a0=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_dataValues_HyEnumValue3869); if (state.failed) return element;

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
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1002]);
            }

            // Hymapping.g:5035:4: (a1= IDENTIFIER_TOKEN )
            // Hymapping.g:5036:4: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3882); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            if (a1 != null) {
            eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
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
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_1, proxy, true);
            copyLocalizationInfos((CommonToken) a1, element);
            copyLocalizationInfos((CommonToken) a1, proxy);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1003]);
            }

            a2=(Token)match(input,23,FOLLOW_23_in_parse_eu_hyvar_dataValues_HyEnumValue3895); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1004]);
            }

            // Hymapping.g:5089:4: (a3= IDENTIFIER_TOKEN )
            // Hymapping.g:5090:4: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3908); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            if (a3 != null) {
            eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            tokenResolver.setOptions(getOptions());
            eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
            tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
            Object resolvedObject = result.getResolvedToken();
            if (resolvedObject == null) {
            addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
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
            retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_3, proxy, true);
            copyLocalizationInfos((CommonToken) a3, element);
            copyLocalizationInfos((CommonToken) a3, proxy);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1005]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1006]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1007]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1008]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1009]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1010]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1011]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1012]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1013]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1014]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1015]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1016]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1017]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1018]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1019]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1020]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1021]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1022]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1023]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1024]);
            addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1025]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 31, parse_eu_hyvar_dataValues_HyEnumValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumValue"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyExpression"
    // Hymapping.g:5151:1: parse_eu_hyvar_feature_expression_HyExpression returns [eu.hyvar.feature.expression.HyExpression element = null] : c= parseop_HyExpression_level_0 ;
    public final eu.hyvar.feature.expression.HyExpression parse_eu_hyvar_feature_expression_HyExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyExpression_StartIndex = input.index();

        eu.hyvar.feature.expression.HyExpression c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return element; }

            // Hymapping.g:5152:3: (c= parseop_HyExpression_level_0 )
            // Hymapping.g:5153:3: c= parseop_HyExpression_level_0
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression3932);
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
            if ( state.backtracking>0 ) { memoize(input, 32, parse_eu_hyvar_feature_expression_HyExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyVersionRestriction"
    // Hymapping.g:5157:1: parse_eu_hyvar_feature_expression_HyVersionRestriction returns [eu.hyvar.feature.expression.HyVersionRestriction element = null] : (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction );
    public final eu.hyvar.feature.expression.HyVersionRestriction parse_eu_hyvar_feature_expression_HyVersionRestriction() throws RecognitionException {
        eu.hyvar.feature.expression.HyVersionRestriction element =  null;

        int parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex = input.index();

        eu.hyvar.feature.expression.HyRelativeVersionRestriction c0 =null;

        eu.hyvar.feature.expression.HyVersionRangeRestriction c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return element; }

            // Hymapping.g:5158:0: (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==35) ) {
                switch ( input.LA(2) ) {
                case 26:
                case 28:
                case 29:
                case 30:
                case 31:
                    {
                    alt39=1;
                    }
                    break;
                case QUOTED_34_34:
                    {
                    int LA39_3 = input.LA(3);

                    if ( (LA39_3==37) ) {
                        alt39=1;
                    }
                    else if ( (LA39_3==21) ) {
                        alt39=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 3, input);

                        throw nvae;

                    }
                    }
                    break;
                case 38:
                    {
                    alt39=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }
            switch (alt39) {
                case 1 :
                    // Hymapping.g:5159:0: c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3951);
                    c0=parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hymapping.g:5160:2: c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3959);
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
            if ( state.backtracking>0 ) { memoize(input, 33, parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyVersionRestriction"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyValue"
    // Hymapping.g:5164:1: parse_eu_hyvar_dataValues_HyValue returns [eu.hyvar.dataValues.HyValue element = null] : c= parseop_HyValue_level_15 ;
    public final eu.hyvar.dataValues.HyValue parse_eu_hyvar_dataValues_HyValue() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parse_eu_hyvar_dataValues_HyValue_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return element; }

            // Hymapping.g:5165:3: (c= parseop_HyValue_level_15 )
            // Hymapping.g:5166:3: c= parseop_HyValue_level_15
            {
            pushFollow(FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue3978);
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
            if ( state.backtracking>0 ) { memoize(input, 34, parse_eu_hyvar_dataValues_HyValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyValue"

    // $ANTLR start synpred51_Hymapping
    public final void synpred51_Hymapping_fragment() throws RecognitionException {
        eu.hyvar.feature.expression.HyValueExpression c5 =null;


        // Hymapping.g:3677:2: (c5= parse_eu_hyvar_feature_expression_HyValueExpression )
        // Hymapping.g:3677:2: c5= parse_eu_hyvar_feature_expression_HyValueExpression
        {
        pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_synpred51_Hymapping3111);
        c5=parse_eu_hyvar_feature_expression_HyValueExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred51_Hymapping

    // $ANTLR start synpred52_Hymapping
    public final void synpred52_Hymapping_fragment() throws RecognitionException {
        eu.hyvar.feature.expression.HyBooleanValueExpression c6 =null;


        // Hymapping.g:3678:2: (c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression )
        // Hymapping.g:3678:2: c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression
        {
        pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_synpred52_Hymapping3119);
        c6=parse_eu_hyvar_feature_expression_HyBooleanValueExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred52_Hymapping

    // Delegated rules

    public final boolean synpred52_Hymapping() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_Hymapping_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_Hymapping() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_Hymapping_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_parse_eu_hyvar_feature_mapping_HyMappingModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_mapping_HyMapping_in_parse_eu_hyvar_feature_mapping_HyMappingModel130 = new BitSet(new long[]{0x00007D8100212262L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_mapping_HyMapping_in_parse_eu_hyvar_feature_mapping_HyMappingModel179 = new BitSet(new long[]{0x00007D8100212262L});
    public static final BitSet FOLLOW_QUOTED_6060_6262_in_parse_org_deltaecore_core_decore_DEDeltaInvokation272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_mapping_HyMapping312 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_eu_hyvar_feature_mapping_HyMapping330 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_parse_org_deltaecore_core_decore_DEDeltaInvokation_in_parse_eu_hyvar_feature_mapping_HyMapping348 = new BitSet(new long[]{0x0000000800100002L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_feature_mapping_HyMapping375 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_parse_org_deltaecore_core_decore_DEDeltaInvokation_in_parse_eu_hyvar_feature_mapping_HyMapping401 = new BitSet(new long[]{0x0000000800100002L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_feature_mapping_HyMapping451 = new BitSet(new long[]{0x0000020000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_mapping_HyMapping484 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_feature_mapping_HyMapping523 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_mapping_HyMapping553 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_mapping_HyMapping609 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_feature_mapping_HyMapping648 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_feature_mapping_HyMapping671 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_feature_mapping_HyMapping704 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_feature_mapping_HyMapping727 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_feature_mapping_HyMapping757 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_feature_mapping_HyMapping809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction857 = new BitSet(new long[]{0x00000000F4000200L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction880 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction895 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_29_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction910 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_31_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction925 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction940 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction965 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1015 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_38_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1038 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1063 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1084 = new BitSet(new long[]{0x0000004000000200L});
    public static final BitSet FOLLOW_38_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1107 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1132 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction1153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnum1182 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum1200 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1221 = new BitSet(new long[]{0x0000000400020000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1250 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1291 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1325 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_parse_eu_hyvar_dataValues_HyEnum1399 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnum1422 = new BitSet(new long[]{0x0000020000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1455 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum1494 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1524 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1580 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum1619 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_dataValues_HyEnum1652 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum1675 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1705 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_dataValues_HyEnum1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_parse_eu_hyvar_dataValues_HyEnumLiteral1805 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral1823 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1844 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral1862 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_eu_hyvar_dataValues_HyEnumLiteral1883 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnumLiteral1906 = new BitSet(new long[]{0x0000020000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1939 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral1978 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2008 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2064 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral2103 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_dataValues_HyEnumLiteral2126 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_dataValues_HyEnumLiteral2159 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral2182 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2212 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_dataValues_HyEnumLiteral2264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02312 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_parseop_HyExpression_level_02332 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02349 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_12395 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_parseop_HyExpression_level_12411 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_12425 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_42466 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_parseop_HyExpression_level_42479 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_42490 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_52528 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_parseop_HyExpression_level_52541 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_52552 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92590 = new BitSet(new long[]{0x00000000F4004002L});
    public static final BitSet FOLLOW_26_in_parseop_HyExpression_level_92603 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92614 = new BitSet(new long[]{0x00000000F4004002L});
    public static final BitSet FOLLOW_28_in_parseop_HyExpression_level_92632 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92643 = new BitSet(new long[]{0x00000000F4004002L});
    public static final BitSet FOLLOW_30_in_parseop_HyExpression_level_92661 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92672 = new BitSet(new long[]{0x00000000F4004002L});
    public static final BitSet FOLLOW_31_in_parseop_HyExpression_level_92690 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92701 = new BitSet(new long[]{0x00000000F4004002L});
    public static final BitSet FOLLOW_29_in_parseop_HyExpression_level_92719 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92730 = new BitSet(new long[]{0x00000000F4004002L});
    public static final BitSet FOLLOW_14_in_parseop_HyExpression_level_92748 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92759 = new BitSet(new long[]{0x00000000F4004002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122797 = new BitSet(new long[]{0x0000000000280002L});
    public static final BitSet FOLLOW_21_in_parseop_HyExpression_level_122810 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122821 = new BitSet(new long[]{0x0000000000280002L});
    public static final BitSet FOLLOW_19_in_parseop_HyExpression_level_122839 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122850 = new BitSet(new long[]{0x0000000000280002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132888 = new BitSet(new long[]{0x0000001001040002L});
    public static final BitSet FOLLOW_36_in_parseop_HyExpression_level_132901 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132912 = new BitSet(new long[]{0x0000001001040002L});
    public static final BitSet FOLLOW_18_in_parseop_HyExpression_level_132930 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132941 = new BitSet(new long[]{0x0000001001040002L});
    public static final BitSet FOLLOW_24_in_parseop_HyExpression_level_132959 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132970 = new BitSet(new long[]{0x0000001001040002L});
    public static final BitSet FOLLOW_13_in_parseop_HyExpression_level_143008 = new BitSet(new long[]{0x00007D8100010260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parseop_HyExpression_level_143028 = new BitSet(new long[]{0x00007D8100010260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_143049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_153071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_153079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_153087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyExpression_level_153095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyExpression_level_153103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyExpression_level_153111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_153119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyMinimumExpression_in_parseop_HyExpression_level_153127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyMaximumExpression_in_parseop_HyExpression_level_153135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyIfPossibleExpression_in_parseop_HyExpression_level_153143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression3165 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression3178 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_eu_hyvar_feature_expression_HyNestedExpression3190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3220 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3237 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3296 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3311 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3328 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3375 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3420 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3437 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3455 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression3498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_parse_eu_hyvar_feature_expression_HyMinimumExpression3568 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMinimumExpression3581 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_eu_hyvar_feature_expression_HyMinimumExpression3593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_eu_hyvar_feature_expression_HyMaximumExpression3619 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMaximumExpression3632 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_eu_hyvar_feature_expression_HyMaximumExpression3644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3670 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3683 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3699 = new BitSet(new long[]{0x00007D8100212260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3712 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_153758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_153766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_153774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_parse_eu_hyvar_dataValues_HyBooleanValue3830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_parse_eu_hyvar_dataValues_HyBooleanValue3839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_dataValues_HyEnumValue3869 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3882 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_eu_hyvar_dataValues_HyEnumValue3895 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression3932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue3978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_synpred51_Hymapping3111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_synpred52_Hymapping3119 = new BitSet(new long[]{0x0000000000000002L});

}