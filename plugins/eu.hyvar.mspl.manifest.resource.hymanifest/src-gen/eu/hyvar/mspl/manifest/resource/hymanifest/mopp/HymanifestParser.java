// $ANTLR 3.4

	package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;
	
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
public class HymanifestParser extends HymanifestANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DATE", "IDENTIFIER_TOKEN", "INTEGER_LITERAL", "LINEBREAK", "ML_COMMENT", "QUOTED_34_34", "QUOTED_60_62", "SL_COMMENT", "WHITESPACE", "'('", "')'", "','", "'-'", "'->'", "'.'", "':'", "'@['", "'Enum('", "'EnumLiteral('", "'Implementation '", "'Signature '", "'['", "']'", "'enum:'", "'eternity'", "'false'", "'true'", "'{'", "'}'"
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
    public static final int DATE=4;
    public static final int IDENTIFIER_TOKEN=5;
    public static final int INTEGER_LITERAL=6;
    public static final int LINEBREAK=7;
    public static final int ML_COMMENT=8;
    public static final int QUOTED_34_34=9;
    public static final int QUOTED_60_62=10;
    public static final int SL_COMMENT=11;
    public static final int WHITESPACE=12;

    // delegates
    public HymanifestANTLRParserBase[] getDelegates() {
        return new HymanifestANTLRParserBase[] {};
    }

    // delegators


    public HymanifestParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public HymanifestParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(47 + 1);
         

    }

    public String[] getTokenNames() { return HymanifestParser.tokenNames; }
    public String getGrammarFileName() { return "Hymanifest.g"; }


    	private eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolverFactory tokenResolverFactory = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenResolverFactory();
    	
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
    	private List<eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal> expectedElements = new ArrayList<eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal>();
    	
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
    	
    	private eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestLocationMap locationMap;
    	
    	private eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestSyntaxErrorMessageConverter syntaxErrorMessageConverter = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestSyntaxErrorMessageConverter(tokenNames);
    	
    	@Override
    	public void reportError(RecognitionException re) {
    		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
    	}
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestCommand<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource>() {
    			public boolean execute(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestProblem() {
    					public eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemSeverity getSeverity() {
    						return eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemSeverity.ERROR;
    					}
    					public eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemType getType() {
    						return eu.hyvar.mspl.manifest.resource.hymanifest.HymanifestEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public Collection<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	protected void addErrorToResource(eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestLocalizedMessage message) {
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
    		eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestExpectedElement terminal = eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestFollowSetProvider.TERMINALS[terminalID];
    		eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContainedFeature[] containmentFeatures = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestFollowSetProvider.LINKS[ids[i]];
    		}
    		eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainmentTrace containmentTrace = new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainmentTrace(eClass, containmentFeatures);
    		EObject container = getLastIncompleteElement();
    		eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal expectedElement = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		final eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestCommand<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource>() {
    			public boolean execute(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource resource) {
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
    		final eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestCommand<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource>() {
    			public boolean execute(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource resource) {
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
    	protected void setLocalizationEnd(Collection<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestCommand<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		final eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestCommand<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource>() {
    			public boolean execute(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource resource) {
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextParser createInstance(InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new HymanifestParser(new CommonTokenStream(new HymanifestLexer(new ANTLRInputStream(actualInputStream))));
    			} else {
    				return new HymanifestParser(new CommonTokenStream(new HymanifestLexer(new ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (IOException e) {
    			new eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public HymanifestParser() {
    		super(null);
    	}
    	
    	protected EObject doParse() throws RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((HymanifestLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((HymanifestLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof EClass) {
    			EClass type = (EClass) typeObject;
    			if (type.getInstanceClass() == eu.hyvar.mspl.manifest.HySPLImplementation.class) {
    				return parse_eu_hyvar_mspl_manifest_HySPLImplementation();
    			}
    			if (type.getInstanceClass() == eu.hyvar.mspl.manifest.HyTimedDependencies.class) {
    				return parse_eu_hyvar_mspl_manifest_HyTimedDependencies();
    			}
    			if (type.getInstanceClass() == eu.hyvar.mspl.manifest.HyTimedImplementations.class) {
    				return parse_eu_hyvar_mspl_manifest_HyTimedImplementations();
    			}
    			if (type.getInstanceClass() == eu.hyvar.mspl.manifest.HyTimedImplementationLink.class) {
    				return parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink();
    			}
    			if (type.getInstanceClass() == eu.hyvar.mspl.manifest.HySPLSignature.class) {
    				return parse_eu_hyvar_mspl_manifest_HySPLSignature();
    			}
    			if (type.getInstanceClass() == eu.hyvar.evolution.HyName.class) {
    				return parse_eu_hyvar_evolution_HyName();
    			}
    			if (type.getInstanceClass() == eu.hyvar.dataValues.HyEnum.class) {
    				return parse_eu_hyvar_dataValues_HyEnum();
    			}
    			if (type.getInstanceClass() == eu.hyvar.dataValues.HyEnumLiteral.class) {
    				return parse_eu_hyvar_dataValues_HyEnumLiteral();
    			}
    		}
    		throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestParseResult parse() {
    		// Reset parser state
    		terminateParsing = false;
    		postParseCommands = new ArrayList<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestCommand<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource>>();
    		eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestParseResult parseResult = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestParseResult();
    		if (disableLocationMap) {
    			locationMap = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestDevNullLocationMap();
    		} else {
    			locationMap = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestLocationMap();
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
    	
    	public List<eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal> parseToExpectedElements(EClass type, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
    		eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestParseResult result = parse();
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
    			for (eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestCommand<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		Set<eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal> currentFollowSet = new LinkedHashSet<eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal>();
    		List<eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal> newFollowSet = new ArrayList<eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 138;
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
    				for (eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						Collection<eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestPair<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestExpectedElement, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestPair<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestExpectedElement, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContainedFeature[]> newFollowerPair : newFollowers) {
    							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestExpectedElement newFollower = newFollowerPair.getLeft();
    							EObject container = getLastIncompleteElement();
    							eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainmentTrace containmentTrace = new eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestContainmentTrace(null, newFollowerPair.getRight());
    							eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal newFollowTerminal = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectedTerminal expectedElement, int tokenIndex) {
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
    // Hymanifest.g:502:1: start returns [ EObject element = null] : (c0= parse_eu_hyvar_mspl_manifest_HySPLImplementation |c1= parse_eu_hyvar_mspl_manifest_HySPLSignature ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        eu.hyvar.mspl.manifest.HySPLImplementation c0 =null;

        eu.hyvar.mspl.manifest.HySPLSignature c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Hymanifest.g:503:2: ( (c0= parse_eu_hyvar_mspl_manifest_HySPLImplementation |c1= parse_eu_hyvar_mspl_manifest_HySPLSignature ) EOF )
            // Hymanifest.g:504:2: (c0= parse_eu_hyvar_mspl_manifest_HySPLImplementation |c1= parse_eu_hyvar_mspl_manifest_HySPLSignature ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[1]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Hymanifest.g:510:2: (c0= parse_eu_hyvar_mspl_manifest_HySPLImplementation |c1= parse_eu_hyvar_mspl_manifest_HySPLSignature )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==23) ) {
                alt1=1;
            }
            else if ( (LA1_0==24) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // Hymanifest.g:511:3: c0= parse_eu_hyvar_mspl_manifest_HySPLImplementation
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_mspl_manifest_HySPLImplementation_in_start82);
                    c0=parse_eu_hyvar_mspl_manifest_HySPLImplementation();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; }

                    }
                    break;
                case 2 :
                    // Hymanifest.g:512:8: c1= parse_eu_hyvar_mspl_manifest_HySPLSignature
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_mspl_manifest_HySPLSignature_in_start96);
                    c1=parse_eu_hyvar_mspl_manifest_HySPLSignature();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; }

                    }
                    break;

            }


            match(input,EOF,FOLLOW_EOF_in_start103); if (state.failed) return element;

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



    // $ANTLR start "parse_eu_hyvar_mspl_manifest_HySPLImplementation"
    // Hymanifest.g:520:1: parse_eu_hyvar_mspl_manifest_HySPLImplementation returns [eu.hyvar.mspl.manifest.HySPLImplementation element = null] : a0= 'Implementation ' (a1_0= parse_eu_hyvar_evolution_HyName ) ( (a2= ',' (a3_0= parse_eu_hyvar_evolution_HyName ) ) )* ( (a4= '(' (a5_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ( (a6= ',' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )* a8= ')' ) )? ( (a9= ':' (a10_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ( (a11= ',' (a12_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )* ) )? ;
    public final eu.hyvar.mspl.manifest.HySPLImplementation parse_eu_hyvar_mspl_manifest_HySPLImplementation() throws RecognitionException {
        eu.hyvar.mspl.manifest.HySPLImplementation element =  null;

        int parse_eu_hyvar_mspl_manifest_HySPLImplementation_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        Token a8=null;
        Token a9=null;
        Token a11=null;
        eu.hyvar.evolution.HyName a1_0 =null;

        eu.hyvar.evolution.HyName a3_0 =null;

        eu.hyvar.mspl.manifest.HyTimedDependencies a5_0 =null;

        eu.hyvar.mspl.manifest.HyTimedDependencies a7_0 =null;

        eu.hyvar.mspl.manifest.HyTimedImplementations a10_0 =null;

        eu.hyvar.mspl.manifest.HyTimedImplementations a12_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Hymanifest.g:523:2: (a0= 'Implementation ' (a1_0= parse_eu_hyvar_evolution_HyName ) ( (a2= ',' (a3_0= parse_eu_hyvar_evolution_HyName ) ) )* ( (a4= '(' (a5_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ( (a6= ',' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )* a8= ')' ) )? ( (a9= ':' (a10_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ( (a11= ',' (a12_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )* ) )? )
            // Hymanifest.g:524:2: a0= 'Implementation ' (a1_0= parse_eu_hyvar_evolution_HyName ) ( (a2= ',' (a3_0= parse_eu_hyvar_evolution_HyName ) ) )* ( (a4= '(' (a5_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ( (a6= ',' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )* a8= ')' ) )? ( (a9= ':' (a10_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ( (a11= ',' (a12_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )* ) )?
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation129); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[2]);
            	}

            // Hymanifest.g:538:2: (a1_0= parse_eu_hyvar_evolution_HyName )
            // Hymanifest.g:539:3: a1_0= parse_eu_hyvar_evolution_HyName
            {
            pushFollow(FOLLOW_parse_eu_hyvar_evolution_HyName_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation147);
            a1_0=parse_eu_hyvar_evolution_HyName();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
            				startIncompleteElement(element);
            			}
            			if (a1_0 != null) {
            				if (a1_0 != null) {
            					Object value = a1_0;
            					addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__NAMES, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[3]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[4]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[5]);
            	}

            // Hymanifest.g:566:2: ( (a2= ',' (a3_0= parse_eu_hyvar_evolution_HyName ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Hymanifest.g:567:3: (a2= ',' (a3_0= parse_eu_hyvar_evolution_HyName ) )
            	    {
            	    // Hymanifest.g:567:3: (a2= ',' (a3_0= parse_eu_hyvar_evolution_HyName ) )
            	    // Hymanifest.g:568:4: a2= ',' (a3_0= parse_eu_hyvar_evolution_HyName )
            	    {
            	    a2=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation174); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_2_0_0_0, null, true);
            	    				copyLocalizationInfos((CommonToken)a2, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[6]);
            	    			}

            	    // Hymanifest.g:582:4: (a3_0= parse_eu_hyvar_evolution_HyName )
            	    // Hymanifest.g:583:5: a3_0= parse_eu_hyvar_evolution_HyName
            	    {
            	    pushFollow(FOLLOW_parse_eu_hyvar_evolution_HyName_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation200);
            	    a3_0=parse_eu_hyvar_evolution_HyName();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a3_0 != null) {
            	    						if (a3_0 != null) {
            	    							Object value = a3_0;
            	    							addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__NAMES, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_2_0_0_1, a3_0, true);
            	    						copyLocalizationInfos(a3_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[7]);
            	    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[8]);
            	    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[9]);
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
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[10]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[11]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[12]);
            	}

            // Hymanifest.g:619:2: ( (a4= '(' (a5_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ( (a6= ',' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )* a8= ')' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Hymanifest.g:620:3: (a4= '(' (a5_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ( (a6= ',' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )* a8= ')' )
                    {
                    // Hymanifest.g:620:3: (a4= '(' (a5_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ( (a6= ',' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )* a8= ')' )
                    // Hymanifest.g:621:4: a4= '(' (a5_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ( (a6= ',' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )* a8= ')'
                    {
                    a4=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation250); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_3_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a4, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[13]);
                    			}

                    // Hymanifest.g:635:4: (a5_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies )
                    // Hymanifest.g:636:5: a5_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedDependencies_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation276);
                    a5_0=parse_eu_hyvar_mspl_manifest_HyTimedDependencies();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
                    						startIncompleteElement(element);
                    					}
                    					if (a5_0 != null) {
                    						if (a5_0 != null) {
                    							Object value = a5_0;
                    							addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__DEPENDENCIES, value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_3_0_0_1, a5_0, true);
                    						copyLocalizationInfos(a5_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[14]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[15]);
                    			}

                    // Hymanifest.g:662:4: ( (a6= ',' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==15) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // Hymanifest.g:663:5: (a6= ',' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) )
                    	    {
                    	    // Hymanifest.g:663:5: (a6= ',' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) )
                    	    // Hymanifest.g:664:6: a6= ',' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies )
                    	    {
                    	    a6=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation317); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_3_0_0_2_0_0_0, null, true);
                    	    						copyLocalizationInfos((CommonToken)a6, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[16]);
                    	    					}

                    	    // Hymanifest.g:678:6: (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies )
                    	    // Hymanifest.g:679:7: a7_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedDependencies_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation351);
                    	    a7_0=parse_eu_hyvar_mspl_manifest_HyTimedDependencies();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    							if (terminateParsing) {
                    	    								throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    	    							}
                    	    							if (element == null) {
                    	    								element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
                    	    								startIncompleteElement(element);
                    	    							}
                    	    							if (a7_0 != null) {
                    	    								if (a7_0 != null) {
                    	    									Object value = a7_0;
                    	    									addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__DEPENDENCIES, value);
                    	    									completedElement(value, true);
                    	    								}
                    	    								collectHiddenTokens(element);
                    	    								retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_3_0_0_2_0_0_1, a7_0, true);
                    	    								copyLocalizationInfos(a7_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[17]);
                    	    						addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[18]);
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
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[19]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[20]);
                    			}

                    a8=(Token)match(input,14,FOLLOW_14_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation412); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_3_0_0_3, null, true);
                    				copyLocalizationInfos((CommonToken)a8, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[21]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[22]);
            	}

            // Hymanifest.g:734:2: ( (a9= ':' (a10_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ( (a11= ',' (a12_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )* ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Hymanifest.g:735:3: (a9= ':' (a10_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ( (a11= ',' (a12_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )* )
                    {
                    // Hymanifest.g:735:3: (a9= ':' (a10_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ( (a11= ',' (a12_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )* )
                    // Hymanifest.g:736:4: a9= ':' (a10_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ( (a11= ',' (a12_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )*
                    {
                    a9=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation454); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_4_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a9, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[23]);
                    			}

                    // Hymanifest.g:750:4: (a10_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations )
                    // Hymanifest.g:751:5: a10_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementations_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation480);
                    a10_0=parse_eu_hyvar_mspl_manifest_HyTimedImplementations();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
                    						startIncompleteElement(element);
                    					}
                    					if (a10_0 != null) {
                    						if (a10_0 != null) {
                    							Object value = a10_0;
                    							addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__IMPLEMENTATIONS, value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_4_0_0_1, a10_0, true);
                    						copyLocalizationInfos(a10_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[24]);
                    			}

                    // Hymanifest.g:776:4: ( (a11= ',' (a12_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==15) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // Hymanifest.g:777:5: (a11= ',' (a12_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) )
                    	    {
                    	    // Hymanifest.g:777:5: (a11= ',' (a12_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) )
                    	    // Hymanifest.g:778:6: a11= ',' (a12_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations )
                    	    {
                    	    a11=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation521); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_4_0_0_2_0_0_0, null, true);
                    	    						copyLocalizationInfos((CommonToken)a11, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[25]);
                    	    					}

                    	    // Hymanifest.g:792:6: (a12_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations )
                    	    // Hymanifest.g:793:7: a12_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementations_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation555);
                    	    a12_0=parse_eu_hyvar_mspl_manifest_HyTimedImplementations();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    							if (terminateParsing) {
                    	    								throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    	    							}
                    	    							if (element == null) {
                    	    								element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
                    	    								startIncompleteElement(element);
                    	    							}
                    	    							if (a12_0 != null) {
                    	    								if (a12_0 != null) {
                    	    									Object value = a12_0;
                    	    									addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__IMPLEMENTATIONS, value);
                    	    									completedElement(value, true);
                    	    								}
                    	    								collectHiddenTokens(element);
                    	    								retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_4_0_0_2_0_0_1, a12_0, true);
                    	    								copyLocalizationInfos(a12_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[26]);
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
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[27]);
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
            if ( state.backtracking>0 ) { memoize(input, 2, parse_eu_hyvar_mspl_manifest_HySPLImplementation_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_mspl_manifest_HySPLImplementation"



    // $ANTLR start "parse_eu_hyvar_mspl_manifest_HyTimedDependencies"
    // Hymanifest.g:833:1: parse_eu_hyvar_mspl_manifest_HyTimedDependencies returns [eu.hyvar.mspl.manifest.HyTimedDependencies element = null] : (a0= QUOTED_60_62 ) ( (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )? ;
    public final eu.hyvar.mspl.manifest.HyTimedDependencies parse_eu_hyvar_mspl_manifest_HyTimedDependencies() throws RecognitionException {
        eu.hyvar.mspl.manifest.HyTimedDependencies element =  null;

        int parse_eu_hyvar_mspl_manifest_HyTimedDependencies_StartIndex = input.index();

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



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Hymanifest.g:836:2: ( (a0= QUOTED_60_62 ) ( (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )? )
            // Hymanifest.g:837:2: (a0= QUOTED_60_62 ) ( (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )?
            {
            // Hymanifest.g:837:2: (a0= QUOTED_60_62 )
            // Hymanifest.g:838:3: a0= QUOTED_60_62
            {
            a0=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies648); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__SIGNATURE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.mspl.manifest.HySPLSignature proxy = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLSignature();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContextDependentURIFragmentFactory<eu.hyvar.mspl.manifest.HyTimedDependencies, eu.hyvar.mspl.manifest.HySPLSignature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedDependenciesSignatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__SIGNATURE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__SIGNATURE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_0, proxy, true);
            				copyLocalizationInfos((CommonToken) a0, element);
            				copyLocalizationInfos((CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[28]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[29]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[30]);
            	}

            // Hymanifest.g:879:2: ( (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Hymanifest.g:880:3: (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' )
                    {
                    // Hymanifest.g:880:3: (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' )
                    // Hymanifest.g:881:4: a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']'
                    {
                    a1=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies678); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[31]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[32]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[33]);
                    			}

                    // Hymanifest.g:897:4: ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) )
                    int alt7=3;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==DATE) ) {
                        int LA7_1 = input.LA(2);

                        if ( (LA7_1==16) ) {
                            int LA7_3 = input.LA(3);

                            if ( (LA7_3==DATE) ) {
                                alt7=1;
                            }
                            else if ( (LA7_3==28) ) {
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
                    else if ( (LA7_0==28) ) {
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
                            // Hymanifest.g:898:5: (a2= DATE ) a3= '-' (a4= DATE )
                            {
                            // Hymanifest.g:898:5: (a2= DATE )
                            // Hymanifest.g:899:6: a2= DATE
                            {
                            a2=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies711); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            							startIncompleteElement(element);
                            						}
                            						if (a2 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a2, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[34]);
                            				}

                            a3=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies750); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a3, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[35]);
                            				}

                            // Hymanifest.g:948:5: (a4= DATE )
                            // Hymanifest.g:949:6: a4= DATE
                            {
                            a4=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies780); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            							startIncompleteElement(element);
                            						}
                            						if (a4 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a4, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[36]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymanifest.g:985:10: (a5= DATE ) a6= '-' a7= 'eternity'
                            {
                            // Hymanifest.g:985:10: (a5= DATE )
                            // Hymanifest.g:986:6: a5= DATE
                            {
                            a5=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies836); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            							startIncompleteElement(element);
                            						}
                            						if (a5 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a5, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[37]);
                            				}

                            a6=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies875); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a6, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[38]);
                            				}

                            a7=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies898); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[39]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymanifest.g:1050:10: a8= 'eternity' a9= '-' (a10= DATE )
                            {
                            a8=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies931); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a8, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[40]);
                            				}

                            a9=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies954); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[41]);
                            				}

                            // Hymanifest.g:1078:5: (a10= DATE )
                            // Hymanifest.g:1079:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies984); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            							startIncompleteElement(element);
                            						}
                            						if (a10 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a10).getLine(), ((CommonToken) a10).getCharPositionInLine(), ((CommonToken) a10).getStartIndex(), ((CommonToken) a10).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a10, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[42]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[43]);
                    			}

                    a11=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies1036); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a11, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[44]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[45]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[46]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[47]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_eu_hyvar_mspl_manifest_HyTimedDependencies_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_mspl_manifest_HyTimedDependencies"



    // $ANTLR start "parse_eu_hyvar_mspl_manifest_HyTimedImplementations"
    // Hymanifest.g:1145:1: parse_eu_hyvar_mspl_manifest_HyTimedImplementations returns [eu.hyvar.mspl.manifest.HyTimedImplementations element = null] : (a0= QUOTED_60_62 ) ( (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )? a12= '{' ( ( (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )* ) )? a16= '}' ;
    public final eu.hyvar.mspl.manifest.HyTimedImplementations parse_eu_hyvar_mspl_manifest_HyTimedImplementations() throws RecognitionException {
        eu.hyvar.mspl.manifest.HyTimedImplementations element =  null;

        int parse_eu_hyvar_mspl_manifest_HyTimedImplementations_StartIndex = input.index();

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
        Token a14=null;
        Token a16=null;
        eu.hyvar.mspl.manifest.HyTimedImplementationLink a13_0 =null;

        eu.hyvar.mspl.manifest.HyTimedImplementationLink a15_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Hymanifest.g:1148:2: ( (a0= QUOTED_60_62 ) ( (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )? a12= '{' ( ( (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )* ) )? a16= '}' )
            // Hymanifest.g:1149:2: (a0= QUOTED_60_62 ) ( (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )? a12= '{' ( ( (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )* ) )? a16= '}'
            {
            // Hymanifest.g:1149:2: (a0= QUOTED_60_62 )
            // Hymanifest.g:1150:3: a0= QUOTED_60_62
            {
            a0=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1088); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__SIGNATURE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.mspl.manifest.HySPLSignature proxy = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLSignature();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContextDependentURIFragmentFactory<eu.hyvar.mspl.manifest.HyTimedImplementations, eu.hyvar.mspl.manifest.HySPLSignature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedImplementationsSignatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__SIGNATURE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__SIGNATURE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_0, proxy, true);
            				copyLocalizationInfos((CommonToken) a0, element);
            				copyLocalizationInfos((CommonToken) a0, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[48]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[49]);
            	}

            // Hymanifest.g:1190:2: ( (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Hymanifest.g:1191:3: (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' )
                    {
                    // Hymanifest.g:1191:3: (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' )
                    // Hymanifest.g:1192:4: a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']'
                    {
                    a1=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1118); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[50]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[51]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[52]);
                    			}

                    // Hymanifest.g:1208:4: ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) )
                    int alt9=3;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==DATE) ) {
                        int LA9_1 = input.LA(2);

                        if ( (LA9_1==16) ) {
                            int LA9_3 = input.LA(3);

                            if ( (LA9_3==DATE) ) {
                                alt9=1;
                            }
                            else if ( (LA9_3==28) ) {
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
                    else if ( (LA9_0==28) ) {
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
                            // Hymanifest.g:1209:5: (a2= DATE ) a3= '-' (a4= DATE )
                            {
                            // Hymanifest.g:1209:5: (a2= DATE )
                            // Hymanifest.g:1210:6: a2= DATE
                            {
                            a2=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1151); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            							startIncompleteElement(element);
                            						}
                            						if (a2 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a2, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[53]);
                            				}

                            a3=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1190); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a3, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[54]);
                            				}

                            // Hymanifest.g:1259:5: (a4= DATE )
                            // Hymanifest.g:1260:6: a4= DATE
                            {
                            a4=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1220); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            							startIncompleteElement(element);
                            						}
                            						if (a4 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a4, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[55]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymanifest.g:1296:10: (a5= DATE ) a6= '-' a7= 'eternity'
                            {
                            // Hymanifest.g:1296:10: (a5= DATE )
                            // Hymanifest.g:1297:6: a5= DATE
                            {
                            a5=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1276); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            							startIncompleteElement(element);
                            						}
                            						if (a5 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a5, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[56]);
                            				}

                            a6=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1315); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a6, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[57]);
                            				}

                            a7=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1338); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[58]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymanifest.g:1361:10: a8= 'eternity' a9= '-' (a10= DATE )
                            {
                            a8=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1371); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a8, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[59]);
                            				}

                            a9=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1394); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[60]);
                            				}

                            // Hymanifest.g:1389:5: (a10= DATE )
                            // Hymanifest.g:1390:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1424); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            							startIncompleteElement(element);
                            						}
                            						if (a10 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a10).getLine(), ((CommonToken) a10).getCharPositionInLine(), ((CommonToken) a10).getStartIndex(), ((CommonToken) a10).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a10, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[61]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[62]);
                    			}

                    a11=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1476); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a11, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[63]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[64]);
            	}

            a12=(Token)match(input,31,FOLLOW_31_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1509); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a12, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[65]);
            		addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[66]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[67]);
            	}

            // Hymanifest.g:1468:2: ( ( (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )* ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==IDENTIFIER_TOKEN||LA12_0==QUOTED_34_34) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // Hymanifest.g:1469:3: ( (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )* )
                    {
                    // Hymanifest.g:1469:3: ( (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )* )
                    // Hymanifest.g:1470:4: (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )*
                    {
                    // Hymanifest.g:1470:4: (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink )
                    // Hymanifest.g:1471:5: a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1538);
                    a13_0=parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                    						startIncompleteElement(element);
                    					}
                    					if (a13_0 != null) {
                    						if (a13_0 != null) {
                    							Object value = a13_0;
                    							addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__ASSOCIATIONS, value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_3_0_0_0, a13_0, true);
                    						copyLocalizationInfos(a13_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[68]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[69]);
                    			}

                    // Hymanifest.g:1497:4: ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==15) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // Hymanifest.g:1498:5: (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) )
                    	    {
                    	    // Hymanifest.g:1498:5: (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) )
                    	    // Hymanifest.g:1499:6: a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink )
                    	    {
                    	    a14=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1579); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_3_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((CommonToken)a14, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[70]);
                    	    						addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[71]);
                    	    					}

                    	    // Hymanifest.g:1514:6: (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink )
                    	    // Hymanifest.g:1515:7: a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1613);
                    	    a15_0=parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    							if (terminateParsing) {
                    	    								throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    	    							}
                    	    							if (element == null) {
                    	    								element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                    	    								startIncompleteElement(element);
                    	    							}
                    	    							if (a15_0 != null) {
                    	    								if (a15_0 != null) {
                    	    									Object value = a15_0;
                    	    									addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__ASSOCIATIONS, value);
                    	    									completedElement(value, true);
                    	    								}
                    	    								collectHiddenTokens(element);
                    	    								retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_3_0_0_1_0_0_1, a15_0, true);
                    	    								copyLocalizationInfos(a15_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[72]);
                    	    						addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[73]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[74]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[75]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[76]);
            	}

            a16=(Token)match(input,32,FOLLOW_32_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1687); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a16, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[77]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_eu_hyvar_mspl_manifest_HyTimedImplementations_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_mspl_manifest_HyTimedImplementations"



    // $ANTLR start "parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink"
    // Hymanifest.g:1572:1: parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink returns [eu.hyvar.mspl.manifest.HyTimedImplementationLink element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '->' ( (a3= QUOTED_34_34 ) | (a4= IDENTIFIER_TOKEN ) ) ( (a5= '@[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
    public final eu.hyvar.mspl.manifest.HyTimedImplementationLink parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink() throws RecognitionException {
        eu.hyvar.mspl.manifest.HyTimedImplementationLink element =  null;

        int parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink_StartIndex = input.index();

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

            // Hymanifest.g:1575:2: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '->' ( (a3= QUOTED_34_34 ) | (a4= IDENTIFIER_TOKEN ) ) ( (a5= '@[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hymanifest.g:1576:2: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '->' ( (a3= QUOTED_34_34 ) | (a4= IDENTIFIER_TOKEN ) ) ( (a5= '@[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            // Hymanifest.g:1576:2: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
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
                    // Hymanifest.g:1577:3: (a0= QUOTED_34_34 )
                    {
                    // Hymanifest.g:1577:3: (a0= QUOTED_34_34 )
                    // Hymanifest.g:1578:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1725); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                    					startIncompleteElement(element);
                    				}
                    				if (a0 != null) {
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContextDependentURIFragmentFactory<eu.hyvar.mspl.manifest.HyTimedImplementationLink, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedImplementationLinkLocalReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL, value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_0_0_0_0, proxy, true);
                    					copyLocalizationInfos((CommonToken) a0, element);
                    					copyLocalizationInfos((CommonToken) a0, proxy);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[78]);
                    		}

                    }
                    break;
                case 2 :
                    // Hymanifest.g:1618:6: (a1= IDENTIFIER_TOKEN )
                    {
                    // Hymanifest.g:1618:6: (a1= IDENTIFIER_TOKEN )
                    // Hymanifest.g:1619:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1763); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                    					startIncompleteElement(element);
                    				}
                    				if (a1 != null) {
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContextDependentURIFragmentFactory<eu.hyvar.mspl.manifest.HyTimedImplementationLink, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedImplementationLinkLocalReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL, value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_0_0_1_0, proxy, true);
                    					copyLocalizationInfos((CommonToken) a1, element);
                    					copyLocalizationInfos((CommonToken) a1, proxy);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[79]);
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[80]);
            	}

            a2=(Token)match(input,17,FOLLOW_17_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1797); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_1, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[81]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[82]);
            	}

            // Hymanifest.g:1679:2: ( (a3= QUOTED_34_34 ) | (a4= IDENTIFIER_TOKEN ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==QUOTED_34_34) ) {
                alt14=1;
            }
            else if ( (LA14_0==IDENTIFIER_TOKEN) ) {
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
                    // Hymanifest.g:1680:3: (a3= QUOTED_34_34 )
                    {
                    // Hymanifest.g:1680:3: (a3= QUOTED_34_34 )
                    // Hymanifest.g:1681:4: a3= QUOTED_34_34
                    {
                    a3=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1820); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                    					startIncompleteElement(element);
                    				}
                    				if (a3 != null) {
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContextDependentURIFragmentFactory<eu.hyvar.mspl.manifest.HyTimedImplementationLink, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedImplementationLinkSignatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE, value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_2_0_0_0, proxy, true);
                    					copyLocalizationInfos((CommonToken) a3, element);
                    					copyLocalizationInfos((CommonToken) a3, proxy);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[83]);
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[84]);
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[85]);
                    		}

                    }
                    break;
                case 2 :
                    // Hymanifest.g:1723:6: (a4= IDENTIFIER_TOKEN )
                    {
                    // Hymanifest.g:1723:6: (a4= IDENTIFIER_TOKEN )
                    // Hymanifest.g:1724:4: a4= IDENTIFIER_TOKEN
                    {
                    a4=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1858); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                    					startIncompleteElement(element);
                    				}
                    				if (a4 != null) {
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContextDependentURIFragmentFactory<eu.hyvar.mspl.manifest.HyTimedImplementationLink, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedImplementationLinkSignatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE, value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_2_0_1_0, proxy, true);
                    					copyLocalizationInfos((CommonToken) a4, element);
                    					copyLocalizationInfos((CommonToken) a4, proxy);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[86]);
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[87]);
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[88]);
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[89]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[90]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[91]);
            	}

            // Hymanifest.g:1773:2: ( (a5= '@[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==20) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Hymanifest.g:1774:3: (a5= '@[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hymanifest.g:1774:3: (a5= '@[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hymanifest.g:1775:4: a5= '@[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1901); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[92]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[93]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[94]);
                    			}

                    // Hymanifest.g:1791:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) )
                    int alt15=3;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==DATE) ) {
                        int LA15_1 = input.LA(2);

                        if ( (LA15_1==16) ) {
                            int LA15_3 = input.LA(3);

                            if ( (LA15_3==DATE) ) {
                                alt15=1;
                            }
                            else if ( (LA15_3==28) ) {
                                alt15=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 15, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA15_0==28) ) {
                        alt15=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;

                    }
                    switch (alt15) {
                        case 1 :
                            // Hymanifest.g:1792:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hymanifest.g:1792:5: (a6= DATE )
                            // Hymanifest.g:1793:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1934); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            							startIncompleteElement(element);
                            						}
                            						if (a6 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a6).getLine(), ((CommonToken) a6).getCharPositionInLine(), ((CommonToken) a6).getStartIndex(), ((CommonToken) a6).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a6, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[95]);
                            				}

                            a7=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1973); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[96]);
                            				}

                            // Hymanifest.g:1842:5: (a8= DATE )
                            // Hymanifest.g:1843:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2003); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[97]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymanifest.g:1879:10: (a9= DATE ) a10= '-' a11= 'eternity'
                            {
                            // Hymanifest.g:1879:10: (a9= DATE )
                            // Hymanifest.g:1880:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2059); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            							startIncompleteElement(element);
                            						}
                            						if (a9 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a9).getLine(), ((CommonToken) a9).getCharPositionInLine(), ((CommonToken) a9).getStartIndex(), ((CommonToken) a9).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a9, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[98]);
                            				}

                            a10=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2098); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a10, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[99]);
                            				}

                            a11=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2121); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a11, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[100]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymanifest.g:1944:10: a12= 'eternity' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2154); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[101]);
                            				}

                            a13=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2177); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[102]);
                            				}

                            // Hymanifest.g:1972:5: (a14= DATE )
                            // Hymanifest.g:1973:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2207); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            							startIncompleteElement(element);
                            						}
                            						if (a14 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a14).getLine(), ((CommonToken) a14).getCharPositionInLine(), ((CommonToken) a14).getStartIndex(), ((CommonToken) a14).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a14, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[103]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[104]);
                    			}

                    a15=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2259); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a15, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[105]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[106]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[107]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[108]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink"



    // $ANTLR start "parse_eu_hyvar_mspl_manifest_HySPLSignature"
    // Hymanifest.g:2039:1: parse_eu_hyvar_mspl_manifest_HySPLSignature returns [eu.hyvar.mspl.manifest.HySPLSignature element = null] : a0= 'Signature ' (a1_0= parse_eu_hyvar_evolution_HyName ) ( (a2= ',' (a3_0= parse_eu_hyvar_evolution_HyName ) ) )* ;
    public final eu.hyvar.mspl.manifest.HySPLSignature parse_eu_hyvar_mspl_manifest_HySPLSignature() throws RecognitionException {
        eu.hyvar.mspl.manifest.HySPLSignature element =  null;

        int parse_eu_hyvar_mspl_manifest_HySPLSignature_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.evolution.HyName a1_0 =null;

        eu.hyvar.evolution.HyName a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Hymanifest.g:2042:2: (a0= 'Signature ' (a1_0= parse_eu_hyvar_evolution_HyName ) ( (a2= ',' (a3_0= parse_eu_hyvar_evolution_HyName ) ) )* )
            // Hymanifest.g:2043:2: a0= 'Signature ' (a1_0= parse_eu_hyvar_evolution_HyName ) ( (a2= ',' (a3_0= parse_eu_hyvar_evolution_HyName ) ) )*
            {
            a0=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_mspl_manifest_HySPLSignature2307); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLSignature();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLSignature(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[109]);
            	}

            // Hymanifest.g:2057:2: (a1_0= parse_eu_hyvar_evolution_HyName )
            // Hymanifest.g:2058:3: a1_0= parse_eu_hyvar_evolution_HyName
            {
            pushFollow(FOLLOW_parse_eu_hyvar_evolution_HyName_in_parse_eu_hyvar_mspl_manifest_HySPLSignature2325);
            a1_0=parse_eu_hyvar_evolution_HyName();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLSignature();
            				startIncompleteElement(element);
            			}
            			if (a1_0 != null) {
            				if (a1_0 != null) {
            					Object value = a1_0;
            					addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_SIGNATURE__NAMES, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_1, a1_0, true);
            				copyLocalizationInfos(a1_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[110]);
            	}

            // Hymanifest.g:2083:2: ( (a2= ',' (a3_0= parse_eu_hyvar_evolution_HyName ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==15) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // Hymanifest.g:2084:3: (a2= ',' (a3_0= parse_eu_hyvar_evolution_HyName ) )
            	    {
            	    // Hymanifest.g:2084:3: (a2= ',' (a3_0= parse_eu_hyvar_evolution_HyName ) )
            	    // Hymanifest.g:2085:4: a2= ',' (a3_0= parse_eu_hyvar_evolution_HyName )
            	    {
            	    a2=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HySPLSignature2352); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLSignature();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_2_0_0_0, null, true);
            	    				copyLocalizationInfos((CommonToken)a2, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLSignature(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[111]);
            	    			}

            	    // Hymanifest.g:2099:4: (a3_0= parse_eu_hyvar_evolution_HyName )
            	    // Hymanifest.g:2100:5: a3_0= parse_eu_hyvar_evolution_HyName
            	    {
            	    pushFollow(FOLLOW_parse_eu_hyvar_evolution_HyName_in_parse_eu_hyvar_mspl_manifest_HySPLSignature2378);
            	    a3_0=parse_eu_hyvar_evolution_HyName();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLSignature();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a3_0 != null) {
            	    						if (a3_0 != null) {
            	    							Object value = a3_0;
            	    							addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_SIGNATURE__NAMES, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_2_0_0_1, a3_0, true);
            	    						copyLocalizationInfos(a3_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[112]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[113]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_eu_hyvar_mspl_manifest_HySPLSignature_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_mspl_manifest_HySPLSignature"



    // $ANTLR start "parse_eu_hyvar_evolution_HyName"
    // Hymanifest.g:2134:1: parse_eu_hyvar_evolution_HyName returns [eu.hyvar.evolution.HyName element = null] : (a0= IDENTIFIER_TOKEN ) ( (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )? ;
    public final eu.hyvar.evolution.HyName parse_eu_hyvar_evolution_HyName() throws RecognitionException {
        eu.hyvar.evolution.HyName element =  null;

        int parse_eu_hyvar_evolution_HyName_StartIndex = input.index();

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



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Hymanifest.g:2137:2: ( (a0= IDENTIFIER_TOKEN ) ( (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )? )
            // Hymanifest.g:2138:2: (a0= IDENTIFIER_TOKEN ) ( (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )?
            {
            // Hymanifest.g:2138:2: (a0= IDENTIFIER_TOKEN )
            // Hymanifest.g:2139:3: a0= IDENTIFIER_TOKEN
            {
            a0=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_evolution_HyName2438); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_0, resolved, true);
            				copyLocalizationInfos((CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[114]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[115]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[116]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[117]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[118]);
            	}

            // Hymanifest.g:2178:2: ( (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==20) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // Hymanifest.g:2179:3: (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' )
                    {
                    // Hymanifest.g:2179:3: (a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' )
                    // Hymanifest.g:2180:4: a1= '@[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']'
                    {
                    a1=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_evolution_HyName2468); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[119]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[120]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[121]);
                    			}

                    // Hymanifest.g:2196:4: ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) )
                    int alt18=3;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==DATE) ) {
                        int LA18_1 = input.LA(2);

                        if ( (LA18_1==16) ) {
                            int LA18_3 = input.LA(3);

                            if ( (LA18_3==DATE) ) {
                                alt18=1;
                            }
                            else if ( (LA18_3==28) ) {
                                alt18=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 18, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA18_0==28) ) {
                        alt18=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;

                    }
                    switch (alt18) {
                        case 1 :
                            // Hymanifest.g:2197:5: (a2= DATE ) a3= '-' (a4= DATE )
                            {
                            // Hymanifest.g:2197:5: (a2= DATE )
                            // Hymanifest.g:2198:6: a2= DATE
                            {
                            a2=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_evolution_HyName2501); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
                            							startIncompleteElement(element);
                            						}
                            						if (a2 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a2, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[122]);
                            				}

                            a3=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_evolution_HyName2540); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a3, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[123]);
                            				}

                            // Hymanifest.g:2247:5: (a4= DATE )
                            // Hymanifest.g:2248:6: a4= DATE
                            {
                            a4=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_evolution_HyName2570); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
                            							startIncompleteElement(element);
                            						}
                            						if (a4 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a4, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[124]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymanifest.g:2284:10: (a5= DATE ) a6= '-' a7= 'eternity'
                            {
                            // Hymanifest.g:2284:10: (a5= DATE )
                            // Hymanifest.g:2285:6: a5= DATE
                            {
                            a5=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_evolution_HyName2626); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
                            							startIncompleteElement(element);
                            						}
                            						if (a5 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a5, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[125]);
                            				}

                            a6=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_evolution_HyName2665); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a6, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[126]);
                            				}

                            a7=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_evolution_HyName2688); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[127]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymanifest.g:2349:10: a8= 'eternity' a9= '-' (a10= DATE )
                            {
                            a8=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_evolution_HyName2721); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a8, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[128]);
                            				}

                            a9=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_evolution_HyName2744); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[129]);
                            				}

                            // Hymanifest.g:2377:5: (a10= DATE )
                            // Hymanifest.g:2378:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_evolution_HyName2774); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
                            							startIncompleteElement(element);
                            						}
                            						if (a10 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a10).getLine(), ((CommonToken) a10).getCharPositionInLine(), ((CommonToken) a10).getStartIndex(), ((CommonToken) a10).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.evolution.HyEvolutionPackage.HY_NAME__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a10, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[130]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[131]);
                    			}

                    a11=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_evolution_HyName2826); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a11, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[132]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[133]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[134]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[135]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[136]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[137]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[138]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[139]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_eu_hyvar_evolution_HyName_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_evolution_HyName"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnum"
    // Hymanifest.g:2448:1: parse_eu_hyvar_dataValues_HyEnum returns [eu.hyvar.dataValues.HyEnum element = null] : a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? ;
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

            // Hymanifest.g:2451:2: (a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? )
            // Hymanifest.g:2452:2: a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum2874); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[140]);
            	}

            // Hymanifest.g:2466:2: (a1= IDENTIFIER_TOKEN )
            // Hymanifest.g:2467:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum2892); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[141]);
            	}

            a2=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_dataValues_HyEnum2913); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[142]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[143]);
            	}

            // Hymanifest.g:2517:2: ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==22) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // Hymanifest.g:2518:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    {
                    // Hymanifest.g:2518:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    // Hymanifest.g:2519:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    {
                    // Hymanifest.g:2519:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    // Hymanifest.g:2520:5: a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum2942);
                    a3_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
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
                    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[144]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[145]);
                    			}

                    // Hymanifest.g:2546:4: ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==15) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // Hymanifest.g:2547:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    {
                    	    // Hymanifest.g:2547:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    // Hymanifest.g:2548:6: a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    {
                    	    a4=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_dataValues_HyEnum2983); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((CommonToken)a4, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[146]);
                    	    					}

                    	    // Hymanifest.g:2562:6: (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    // Hymanifest.g:2563:7: a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum3017);
                    	    a5_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    							if (terminateParsing) {
                    	    								throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
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
                    	    								retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_1, a5_0, true);
                    	    								copyLocalizationInfos(a5_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[147]);
                    	    						addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[148]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[149]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[150]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[151]);
            	}

            a6=(Token)match(input,14,FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnum3091); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[152]);
            	}

            // Hymanifest.g:2618:2: ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==25) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // Hymanifest.g:2619:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    {
                    // Hymanifest.g:2619:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    // Hymanifest.g:2620:4: a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']'
                    {
                    a7=(Token)match(input,25,FOLLOW_25_in_parse_eu_hyvar_dataValues_HyEnum3114); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a7, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[153]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[154]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[155]);
                    			}

                    // Hymanifest.g:2636:4: ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) )
                    int alt22=3;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==DATE) ) {
                        int LA22_1 = input.LA(2);

                        if ( (LA22_1==16) ) {
                            int LA22_3 = input.LA(3);

                            if ( (LA22_3==DATE) ) {
                                alt22=1;
                            }
                            else if ( (LA22_3==26) ) {
                                alt22=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 22, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 22, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA22_0==28) ) {
                        alt22=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;

                    }
                    switch (alt22) {
                        case 1 :
                            // Hymanifest.g:2637:5: (a8= DATE ) a9= '-' (a10= DATE )
                            {
                            // Hymanifest.g:2637:5: (a8= DATE )
                            // Hymanifest.g:2638:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum3147); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[156]);
                            				}

                            a9=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum3186); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[157]);
                            				}

                            // Hymanifest.g:2687:5: (a10= DATE )
                            // Hymanifest.g:2688:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum3216); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a10 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a10, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[158]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymanifest.g:2724:10: (a11= DATE ) a12= '-'
                            {
                            // Hymanifest.g:2724:10: (a11= DATE )
                            // Hymanifest.g:2725:6: a11= DATE
                            {
                            a11=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum3272); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a11 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a11, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[159]);
                            				}

                            a12=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum3311); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[160]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymanifest.g:2775:10: a13= 'eternity' a14= '-' (a15= DATE )
                            {
                            a13=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_dataValues_HyEnum3344); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[161]);
                            				}

                            a14=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum3367); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a14, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[162]);
                            				}

                            // Hymanifest.g:2803:5: (a15= DATE )
                            // Hymanifest.g:2804:6: a15= DATE
                            {
                            a15=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum3397); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a15 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a15, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[163]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[164]);
                    			}

                    a16=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_dataValues_HyEnum3449); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
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
            if ( state.backtracking>0 ) { memoize(input, 8, parse_eu_hyvar_dataValues_HyEnum_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnum"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumLiteral"
    // Hymanifest.g:2866:1: parse_eu_hyvar_dataValues_HyEnumLiteral returns [eu.hyvar.dataValues.HyEnumLiteral element = null] : a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
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

            // Hymanifest.g:2869:2: (a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hymanifest.g:2870:2: a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            a0=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumLiteral3497); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[165]);
            	}

            // Hymanifest.g:2884:2: (a1= IDENTIFIER_TOKEN )
            // Hymanifest.g:2885:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral3515); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[166]);
            	}

            a2=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_dataValues_HyEnumLiteral3536); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[167]);
            	}

            // Hymanifest.g:2934:2: (a3= INTEGER_LITERAL )
            // Hymanifest.g:2935:3: a3= INTEGER_LITERAL
            {
            a3=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral3554); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_3, resolved, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[168]);
            	}

            a4=(Token)match(input,14,FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnumLiteral3575); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[169]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[170]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[171]);
            	}

            // Hymanifest.g:2986:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==25) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // Hymanifest.g:2987:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hymanifest.g:2987:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hymanifest.g:2988:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,25,FOLLOW_25_in_parse_eu_hyvar_dataValues_HyEnumLiteral3598); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[172]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[173]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[174]);
                    			}

                    // Hymanifest.g:3004:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) )
                    int alt24=3;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==DATE) ) {
                        int LA24_1 = input.LA(2);

                        if ( (LA24_1==16) ) {
                            int LA24_3 = input.LA(3);

                            if ( (LA24_3==DATE) ) {
                                alt24=1;
                            }
                            else if ( (LA24_3==28) ) {
                                alt24=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 24, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 24, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA24_0==28) ) {
                        alt24=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;

                    }
                    switch (alt24) {
                        case 1 :
                            // Hymanifest.g:3005:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hymanifest.g:3005:5: (a6= DATE )
                            // Hymanifest.g:3006:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3631); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a6 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a6, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[175]);
                            				}

                            a7=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral3670); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[176]);
                            				}

                            // Hymanifest.g:3055:5: (a8= DATE )
                            // Hymanifest.g:3056:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3700); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[177]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymanifest.g:3092:10: (a9= DATE ) a10= '-' a11= 'eternity'
                            {
                            // Hymanifest.g:3092:10: (a9= DATE )
                            // Hymanifest.g:3093:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3756); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a9 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a9, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[178]);
                            				}

                            a10=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral3795); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a10, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[179]);
                            				}

                            a11=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_dataValues_HyEnumLiteral3818); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a11, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[180]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymanifest.g:3157:10: a12= 'eternity' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_dataValues_HyEnumLiteral3851); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[181]);
                            				}

                            a13=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral3874); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[182]);
                            				}

                            // Hymanifest.g:3185:5: (a14= DATE )
                            // Hymanifest.g:3186:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3904); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a14 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a14, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[183]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[184]);
                    			}

                    a15=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_dataValues_HyEnumLiteral3956); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a15, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[185]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[186]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[187]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[188]);
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



    // $ANTLR start "parseop_HyValue_level_15"
    // Hymanifest.g:3252:1: parseop_HyValue_level_15 returns [eu.hyvar.dataValues.HyValue element = null] : (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue );
    public final eu.hyvar.dataValues.HyValue parseop_HyValue_level_15() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parseop_HyValue_level_15_StartIndex = input.index();

        eu.hyvar.dataValues.HyNumberValue c0 =null;

        eu.hyvar.dataValues.HyBooleanValue c1 =null;

        eu.hyvar.dataValues.HyEnumValue c2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Hymanifest.g:3255:2: (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue )
            int alt26=3;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
                {
                alt26=1;
                }
                break;
            case 29:
            case 30:
                {
                alt26=2;
                }
                break;
            case 27:
                {
                alt26=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }

            switch (alt26) {
                case 1 :
                    // Hymanifest.g:3256:2: c0= parse_eu_hyvar_dataValues_HyNumberValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_154004);
                    c0=parse_eu_hyvar_dataValues_HyNumberValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hymanifest.g:3257:4: c1= parse_eu_hyvar_dataValues_HyBooleanValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_154014);
                    c1=parse_eu_hyvar_dataValues_HyBooleanValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hymanifest.g:3258:4: c2= parse_eu_hyvar_dataValues_HyEnumValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_154024);
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
            if ( state.backtracking>0 ) { memoize(input, 10, parseop_HyValue_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyValue_level_15"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyNumberValue"
    // Hymanifest.g:3261:1: parse_eu_hyvar_dataValues_HyNumberValue returns [eu.hyvar.dataValues.HyNumberValue element = null] : (a0= INTEGER_LITERAL ) ;
    public final eu.hyvar.dataValues.HyNumberValue parse_eu_hyvar_dataValues_HyNumberValue() throws RecognitionException {
        eu.hyvar.dataValues.HyNumberValue element =  null;

        int parse_eu_hyvar_dataValues_HyNumberValue_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Hymanifest.g:3264:2: ( (a0= INTEGER_LITERAL ) )
            // Hymanifest.g:3265:2: (a0= INTEGER_LITERAL )
            {
            // Hymanifest.g:3265:2: (a0= INTEGER_LITERAL )
            // Hymanifest.g:3266:3: a0= INTEGER_LITERAL
            {
            a0=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue4051); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyNumberValue();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_0_0_0_0, resolved, true);
            				copyLocalizationInfos((CommonToken) a0, element);
            			}
            		}

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
            if ( state.backtracking>0 ) { memoize(input, 11, parse_eu_hyvar_dataValues_HyNumberValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyNumberValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyBooleanValue"
    // Hymanifest.g:3302:1: parse_eu_hyvar_dataValues_HyBooleanValue returns [eu.hyvar.dataValues.HyBooleanValue element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.dataValues.HyBooleanValue parse_eu_hyvar_dataValues_HyBooleanValue() throws RecognitionException {
        eu.hyvar.dataValues.HyBooleanValue element =  null;

        int parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Hymanifest.g:3305:2: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hymanifest.g:3306:2: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hymanifest.g:3306:2: ( (a0= 'true' |a1= 'false' ) )
            // Hymanifest.g:3307:3: (a0= 'true' |a1= 'false' )
            {
            // Hymanifest.g:3307:3: (a0= 'true' |a1= 'false' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==30) ) {
                alt27=1;
            }
            else if ( (LA27_0==29) ) {
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
                    // Hymanifest.g:3308:4: a0= 'true'
                    {
                    a0=(Token)match(input,30,FOLLOW_30_in_parse_eu_hyvar_dataValues_HyBooleanValue4096); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_1_0_0_0, true, true);
                    				copyLocalizationInfos((CommonToken)a0, element);
                    				// set value of boolean attribute
                    				Object value = true;
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Hymanifest.g:3321:8: a1= 'false'
                    {
                    a1=(Token)match(input,29,FOLLOW_29_in_parse_eu_hyvar_dataValues_HyBooleanValue4111); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_1_0_0_0, false, true);
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
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyBooleanValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumValue"
    // Hymanifest.g:3342:1: parse_eu_hyvar_dataValues_HyEnumValue returns [eu.hyvar.dataValues.HyEnumValue element = null] : a0= 'enum:' (a1= IDENTIFIER_TOKEN ) a2= '.' (a3= IDENTIFIER_TOKEN ) ;
    public final eu.hyvar.dataValues.HyEnumValue parse_eu_hyvar_dataValues_HyEnumValue() throws RecognitionException {
        eu.hyvar.dataValues.HyEnumValue element =  null;

        int parse_eu_hyvar_dataValues_HyEnumValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Hymanifest.g:3345:2: (a0= 'enum:' (a1= IDENTIFIER_TOKEN ) a2= '.' (a3= IDENTIFIER_TOKEN ) )
            // Hymanifest.g:3346:2: a0= 'enum:' (a1= IDENTIFIER_TOKEN ) a2= '.' (a3= IDENTIFIER_TOKEN )
            {
            a0=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_dataValues_HyEnumValue4147); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[189]);
            	}

            // Hymanifest.g:3360:2: (a1= IDENTIFIER_TOKEN )
            // Hymanifest.g:3361:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue4165); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_2_0_0_1, proxy, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            				copyLocalizationInfos((CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[190]);
            	}

            a2=(Token)match(input,18,FOLLOW_18_in_parse_eu_hyvar_dataValues_HyEnumValue4186); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[191]);
            	}

            // Hymanifest.g:3414:2: (a3= IDENTIFIER_TOKEN )
            // Hymanifest.g:3415:3: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue4204); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_2_0_0_3, proxy, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            				copyLocalizationInfos((CommonToken) a3, proxy);
            			}
            		}

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
            if ( state.backtracking>0 ) { memoize(input, 13, parse_eu_hyvar_dataValues_HyEnumValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HySPLImplementation_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HySPLSignature_in_start96 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation129 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_eu_hyvar_evolution_HyName_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation147 = new BitSet(new long[]{0x000000000008A002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation174 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_eu_hyvar_evolution_HyName_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation200 = new BitSet(new long[]{0x000000000008A002L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation250 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedDependencies_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation276 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation317 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedDependencies_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation351 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation412 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation454 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementations_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation480 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation521 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementations_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation555 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies648 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies678 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies711 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies750 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies780 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies836 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies875 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies898 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies931 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies954 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies984 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1088 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1118 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1151 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1190 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1220 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1276 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1315 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1338 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1371 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1394 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1424 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1476 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1509 = new BitSet(new long[]{0x0000000100000220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1538 = new BitSet(new long[]{0x0000000100008000L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1579 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1613 = new BitSet(new long[]{0x0000000100008000L});
    public static final BitSet FOLLOW_32_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1725 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1763 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1797 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1820 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1858 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1901 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1934 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1973 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2003 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2059 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2098 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2121 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2154 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2177 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2207 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_mspl_manifest_HySPLSignature2307 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_eu_hyvar_evolution_HyName_in_parse_eu_hyvar_mspl_manifest_HySPLSignature2325 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HySPLSignature2352 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_eu_hyvar_evolution_HyName_in_parse_eu_hyvar_mspl_manifest_HySPLSignature2378 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_evolution_HyName2438 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_evolution_HyName2468 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_evolution_HyName2501 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_evolution_HyName2540 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_evolution_HyName2570 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_evolution_HyName2626 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_evolution_HyName2665 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_evolution_HyName2688 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_evolution_HyName2721 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_evolution_HyName2744 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_evolution_HyName2774 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_evolution_HyName2826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum2874 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum2892 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_dataValues_HyEnum2913 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum2942 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_dataValues_HyEnum2983 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum3017 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnum3091 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_parse_eu_hyvar_dataValues_HyEnum3114 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum3147 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum3186 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum3216 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum3272 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum3311 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_dataValues_HyEnum3344 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum3367 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum3397 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_dataValues_HyEnum3449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumLiteral3497 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral3515 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_dataValues_HyEnumLiteral3536 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral3554 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnumLiteral3575 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_parse_eu_hyvar_dataValues_HyEnumLiteral3598 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3631 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral3670 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3700 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3756 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral3795 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_dataValues_HyEnumLiteral3818 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_dataValues_HyEnumLiteral3851 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral3874 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3904 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_dataValues_HyEnumLiteral3956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_154004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_154014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_154024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue4051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_parse_eu_hyvar_dataValues_HyBooleanValue4096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_parse_eu_hyvar_dataValues_HyBooleanValue4111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_dataValues_HyEnumValue4147 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue4165 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_eu_hyvar_dataValues_HyEnumValue4186 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue4204 = new BitSet(new long[]{0x0000000000000002L});

}