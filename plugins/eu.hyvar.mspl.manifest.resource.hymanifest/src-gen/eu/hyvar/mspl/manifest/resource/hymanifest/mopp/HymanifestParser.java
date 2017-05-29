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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DATE", "IDENTIFIER_TOKEN", "INTEGER_LITERAL", "LINEBREAK", "ML_COMMENT", "QUOTED_34_34", "QUOTED_60_62", "SL_COMMENT", "WHITESPACE", "'('", "')'", "','", "'-'", "'->'", "'.'", "':'", "'Enum('", "'EnumLiteral('", "'Implementation '", "'Signature '", "'['", "']'", "'enum:'", "'eternity'", "'false'", "'true'", "'{'", "'}'"
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
        this.state.initializeRuleMemo(42 + 1);
         

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
    			if (type.getInstanceClass() == eu.hyvar.mspl.manifest.HySPLSignature.class) {
    				return parse_eu_hyvar_mspl_manifest_HySPLSignature();
    			}
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
    		int followSetID = 120;
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
    // Hymanifest.g:499:1: start returns [ EObject element = null] : (c0= parse_eu_hyvar_mspl_manifest_HySPLImplementation |c1= parse_eu_hyvar_mspl_manifest_HySPLSignature ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        eu.hyvar.mspl.manifest.HySPLImplementation c0 =null;

        eu.hyvar.mspl.manifest.HySPLSignature c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Hymanifest.g:500:2: ( (c0= parse_eu_hyvar_mspl_manifest_HySPLImplementation |c1= parse_eu_hyvar_mspl_manifest_HySPLSignature ) EOF )
            // Hymanifest.g:501:2: (c0= parse_eu_hyvar_mspl_manifest_HySPLImplementation |c1= parse_eu_hyvar_mspl_manifest_HySPLSignature ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[1]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Hymanifest.g:507:2: (c0= parse_eu_hyvar_mspl_manifest_HySPLImplementation |c1= parse_eu_hyvar_mspl_manifest_HySPLSignature )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==22) ) {
                alt1=1;
            }
            else if ( (LA1_0==23) ) {
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
                    // Hymanifest.g:508:3: c0= parse_eu_hyvar_mspl_manifest_HySPLImplementation
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_mspl_manifest_HySPLImplementation_in_start82);
                    c0=parse_eu_hyvar_mspl_manifest_HySPLImplementation();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; }

                    }
                    break;
                case 2 :
                    // Hymanifest.g:509:8: c1= parse_eu_hyvar_mspl_manifest_HySPLSignature
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



    // $ANTLR start "parse_eu_hyvar_mspl_manifest_HySPLSignature"
    // Hymanifest.g:517:1: parse_eu_hyvar_mspl_manifest_HySPLSignature returns [eu.hyvar.mspl.manifest.HySPLSignature element = null] : a0= 'Signature ' ;
    public final eu.hyvar.mspl.manifest.HySPLSignature parse_eu_hyvar_mspl_manifest_HySPLSignature() throws RecognitionException {
        eu.hyvar.mspl.manifest.HySPLSignature element =  null;

        int parse_eu_hyvar_mspl_manifest_HySPLSignature_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Hymanifest.g:520:2: (a0= 'Signature ' )
            // Hymanifest.g:521:2: a0= 'Signature '
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_eu_hyvar_mspl_manifest_HySPLSignature129); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLSignature();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
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
            if ( state.backtracking>0 ) { memoize(input, 2, parse_eu_hyvar_mspl_manifest_HySPLSignature_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_mspl_manifest_HySPLSignature"



    // $ANTLR start "parse_eu_hyvar_mspl_manifest_HySPLImplementation"
    // Hymanifest.g:536:1: parse_eu_hyvar_mspl_manifest_HySPLImplementation returns [eu.hyvar.mspl.manifest.HySPLImplementation element = null] : a0= 'Implementation ' ( (a1= '(' (a2_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ( (a3= ',' (a4_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )* a5= ')' ) )? ( (a6= ':' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ( (a8= ',' (a9_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )* ) )? ;
    public final eu.hyvar.mspl.manifest.HySPLImplementation parse_eu_hyvar_mspl_manifest_HySPLImplementation() throws RecognitionException {
        eu.hyvar.mspl.manifest.HySPLImplementation element =  null;

        int parse_eu_hyvar_mspl_manifest_HySPLImplementation_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a5=null;
        Token a6=null;
        Token a8=null;
        eu.hyvar.mspl.manifest.HyTimedDependencies a2_0 =null;

        eu.hyvar.mspl.manifest.HyTimedDependencies a4_0 =null;

        eu.hyvar.mspl.manifest.HyTimedImplementations a7_0 =null;

        eu.hyvar.mspl.manifest.HyTimedImplementations a9_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Hymanifest.g:539:2: (a0= 'Implementation ' ( (a1= '(' (a2_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ( (a3= ',' (a4_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )* a5= ')' ) )? ( (a6= ':' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ( (a8= ',' (a9_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )* ) )? )
            // Hymanifest.g:540:2: a0= 'Implementation ' ( (a1= '(' (a2_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ( (a3= ',' (a4_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )* a5= ')' ) )? ( (a6= ':' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ( (a8= ',' (a9_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )* ) )?
            {
            a0=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation158); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[2]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[3]);
            	}

            // Hymanifest.g:555:2: ( (a1= '(' (a2_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ( (a3= ',' (a4_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )* a5= ')' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Hymanifest.g:556:3: (a1= '(' (a2_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ( (a3= ',' (a4_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )* a5= ')' )
                    {
                    // Hymanifest.g:556:3: (a1= '(' (a2_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ( (a3= ',' (a4_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )* a5= ')' )
                    // Hymanifest.g:557:4: a1= '(' (a2_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ( (a3= ',' (a4_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )* a5= ')'
                    {
                    a1=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation181); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[4]);
                    				addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[5]);
                    				addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[6]);
                    			}

                    // Hymanifest.g:573:4: (a2_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies )
                    // Hymanifest.g:574:5: a2_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedDependencies_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation207);
                    a2_0=parse_eu_hyvar_mspl_manifest_HyTimedDependencies();

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
                    					if (a2_0 != null) {
                    						if (a2_0 != null) {
                    							Object value = a2_0;
                    							addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__DEPENDENCIES, value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_1, a2_0, true);
                    						copyLocalizationInfos(a2_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[7]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[8]);
                    			}

                    // Hymanifest.g:600:4: ( (a3= ',' (a4_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==15) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // Hymanifest.g:601:5: (a3= ',' (a4_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) )
                    	    {
                    	    // Hymanifest.g:601:5: (a3= ',' (a4_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies ) )
                    	    // Hymanifest.g:602:6: a3= ',' (a4_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies )
                    	    {
                    	    a3=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation248); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_2_0_0_0, null, true);
                    	    						copyLocalizationInfos((CommonToken)a3, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[9]);
                    	    						addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[10]);
                    	    						addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[11]);
                    	    					}

                    	    // Hymanifest.g:618:6: (a4_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies )
                    	    // Hymanifest.g:619:7: a4_0= parse_eu_hyvar_mspl_manifest_HyTimedDependencies
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedDependencies_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation282);
                    	    a4_0=parse_eu_hyvar_mspl_manifest_HyTimedDependencies();

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
                    	    							if (a4_0 != null) {
                    	    								if (a4_0 != null) {
                    	    									Object value = a4_0;
                    	    									addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__DEPENDENCIES, value);
                    	    									completedElement(value, true);
                    	    								}
                    	    								collectHiddenTokens(element);
                    	    								retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_2_0_0_1, a4_0, true);
                    	    								copyLocalizationInfos(a4_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[12]);
                    	    						addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[13]);
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
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[14]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[15]);
                    			}

                    a5=(Token)match(input,14,FOLLOW_14_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation343); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_3, null, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[16]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[17]);
            	}

            // Hymanifest.g:674:2: ( (a6= ':' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ( (a8= ',' (a9_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )* ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Hymanifest.g:675:3: (a6= ':' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ( (a8= ',' (a9_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )* )
                    {
                    // Hymanifest.g:675:3: (a6= ':' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ( (a8= ',' (a9_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )* )
                    // Hymanifest.g:676:4: a6= ':' (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ( (a8= ',' (a9_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )*
                    {
                    a6=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation385); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_2_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a6, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[18]);
                    				addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[19]);
                    			}

                    // Hymanifest.g:691:4: (a7_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations )
                    // Hymanifest.g:692:5: a7_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementations_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation411);
                    a7_0=parse_eu_hyvar_mspl_manifest_HyTimedImplementations();

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
                    							addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__IMPLEMENTATIONS, value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_2_0_0_1, a7_0, true);
                    						copyLocalizationInfos(a7_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[20]);
                    			}

                    // Hymanifest.g:717:4: ( (a8= ',' (a9_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Hymanifest.g:718:5: (a8= ',' (a9_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) )
                    	    {
                    	    // Hymanifest.g:718:5: (a8= ',' (a9_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations ) )
                    	    // Hymanifest.g:719:6: a8= ',' (a9_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations )
                    	    {
                    	    a8=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation452); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_2_0_0_2_0_0_0, null, true);
                    	    						copyLocalizationInfos((CommonToken)a8, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[21]);
                    	    						addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[22]);
                    	    					}

                    	    // Hymanifest.g:734:6: (a9_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations )
                    	    // Hymanifest.g:735:7: a9_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementations
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementations_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation486);
                    	    a9_0=parse_eu_hyvar_mspl_manifest_HyTimedImplementations();

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
                    	    							if (a9_0 != null) {
                    	    								if (a9_0 != null) {
                    	    									Object value = a9_0;
                    	    									addObjectToList(element, eu.hyvar.mspl.manifest.ManifestPackage.HY_SPL_IMPLEMENTATION__IMPLEMENTATIONS, value);
                    	    									completedElement(value, true);
                    	    								}
                    	    								collectHiddenTokens(element);
                    	    								retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_2_0_0_2_0_0_1, a9_0, true);
                    	    								copyLocalizationInfos(a9_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[23]);
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
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[24]);
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
            if ( state.backtracking>0 ) { memoize(input, 3, parse_eu_hyvar_mspl_manifest_HySPLImplementation_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_mspl_manifest_HySPLImplementation"



    // $ANTLR start "parse_eu_hyvar_mspl_manifest_HyTimedDependencies"
    // Hymanifest.g:775:1: parse_eu_hyvar_mspl_manifest_HyTimedDependencies returns [eu.hyvar.mspl.manifest.HyTimedDependencies element = null] : ( (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' ) )? ( (a11= QUOTED_34_34 ) | (a12= IDENTIFIER_TOKEN ) ) a13= ':' (a14= QUOTED_60_62 ) ;
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
        Token a12=null;
        Token a13=null;
        Token a14=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Hymanifest.g:778:2: ( ( (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' ) )? ( (a11= QUOTED_34_34 ) | (a12= IDENTIFIER_TOKEN ) ) a13= ':' (a14= QUOTED_60_62 ) )
            // Hymanifest.g:779:2: ( (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' ) )? ( (a11= QUOTED_34_34 ) | (a12= IDENTIFIER_TOKEN ) ) a13= ':' (a14= QUOTED_60_62 )
            {
            // Hymanifest.g:779:2: ( (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Hymanifest.g:780:3: (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' )
                    {
                    // Hymanifest.g:780:3: (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' )
                    // Hymanifest.g:781:4: a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']'
                    {
                    a0=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies584); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_0_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a0, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[25]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[26]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[27]);
                    			}

                    // Hymanifest.g:797:4: ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) )
                    int alt6=3;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==DATE) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==16) ) {
                            int LA6_3 = input.LA(3);

                            if ( (LA6_3==DATE) ) {
                                alt6=1;
                            }
                            else if ( (LA6_3==27) ) {
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
                    else if ( (LA6_0==27) ) {
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
                            // Hymanifest.g:798:5: (a1= DATE ) a2= '-' (a3= DATE )
                            {
                            // Hymanifest.g:798:5: (a1= DATE )
                            // Hymanifest.g:799:6: a1= DATE
                            {
                            a1=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies617); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            							startIncompleteElement(element);
                            						}
                            						if (a1 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_0_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a1, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[28]);
                            				}

                            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies656); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_0_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a2, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[29]);
                            				}

                            // Hymanifest.g:848:5: (a3= DATE )
                            // Hymanifest.g:849:6: a3= DATE
                            {
                            a3=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies686); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            							startIncompleteElement(element);
                            						}
                            						if (a3 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_0_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a3, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[30]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymanifest.g:885:10: (a4= DATE ) a5= '-' a6= 'eternity'
                            {
                            // Hymanifest.g:885:10: (a4= DATE )
                            // Hymanifest.g:886:6: a4= DATE
                            {
                            a4=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies742); if (state.failed) return element;

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
                            							tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_0_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a4, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[31]);
                            				}

                            a5=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies781); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_0_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a5, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[32]);
                            				}

                            a6=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies804); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_0_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a6, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[33]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymanifest.g:950:10: a7= 'eternity' a8= '-' (a9= DATE )
                            {
                            a7=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies837); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_0_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[34]);
                            				}

                            a8=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies860); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_0_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a8, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[35]);
                            				}

                            // Hymanifest.g:978:5: (a9= DATE )
                            // Hymanifest.g:979:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies890); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                            							startIncompleteElement(element);
                            						}
                            						if (a9 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a9).getLine(), ((CommonToken) a9).getCharPositionInLine(), ((CommonToken) a9).getStartIndex(), ((CommonToken) a9).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_0_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a9, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[36]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[37]);
                    			}

                    a10=(Token)match(input,25,FOLLOW_25_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies942); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_0_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a10, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[38]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[39]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[40]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[41]);
            	}

            // Hymanifest.g:1043:2: ( (a11= QUOTED_34_34 ) | (a12= IDENTIFIER_TOKEN ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==QUOTED_34_34) ) {
                alt8=1;
            }
            else if ( (LA8_0==IDENTIFIER_TOKEN) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // Hymanifest.g:1044:3: (a11= QUOTED_34_34 )
                    {
                    // Hymanifest.g:1044:3: (a11= QUOTED_34_34 )
                    // Hymanifest.g:1045:4: a11= QUOTED_34_34
                    {
                    a11=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies984); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                    					startIncompleteElement(element);
                    				}
                    				if (a11 != null) {
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__ALIAS), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a11).getLine(), ((CommonToken) a11).getCharPositionInLine(), ((CommonToken) a11).getStartIndex(), ((CommonToken) a11).getStopIndex());
                    					}
                    					java.lang.String resolved = (java.lang.String) resolvedObject;
                    					if (resolved != null) {
                    						Object value = resolved;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__ALIAS), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_0, resolved, true);
                    					copyLocalizationInfos((CommonToken) a11, element);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[42]);
                    		}

                    }
                    break;
                case 2 :
                    // Hymanifest.g:1081:6: (a12= IDENTIFIER_TOKEN )
                    {
                    // Hymanifest.g:1081:6: (a12= IDENTIFIER_TOKEN )
                    // Hymanifest.g:1082:4: a12= IDENTIFIER_TOKEN
                    {
                    a12=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies1022); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
                    					startIncompleteElement(element);
                    				}
                    				if (a12 != null) {
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__ALIAS), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a12).getLine(), ((CommonToken) a12).getCharPositionInLine(), ((CommonToken) a12).getStartIndex(), ((CommonToken) a12).getStopIndex());
                    					}
                    					java.lang.String resolved = (java.lang.String) resolvedObject;
                    					if (resolved != null) {
                    						Object value = resolved;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__ALIAS), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_1_0, resolved, true);
                    					copyLocalizationInfos((CommonToken) a12, element);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[43]);
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[44]);
            	}

            a13=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies1056); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a13, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[45]);
            	}

            // Hymanifest.g:1137:2: (a14= QUOTED_60_62 )
            // Hymanifest.g:1138:3: a14= QUOTED_60_62
            {
            a14=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies1074); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
            				startIncompleteElement(element);
            			}
            			if (a14 != null) {
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_DEPENDENCIES__SIGNATURE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a14).getLine(), ((CommonToken) a14).getCharPositionInLine(), ((CommonToken) a14).getStartIndex(), ((CommonToken) a14).getStopIndex());
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
            				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_3, proxy, true);
            				copyLocalizationInfos((CommonToken) a14, element);
            				copyLocalizationInfos((CommonToken) a14, proxy);
            			}
            		}

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
            if ( state.backtracking>0 ) { memoize(input, 4, parse_eu_hyvar_mspl_manifest_HyTimedDependencies_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_mspl_manifest_HyTimedDependencies"



    // $ANTLR start "parse_eu_hyvar_mspl_manifest_HyTimedImplementations"
    // Hymanifest.g:1180:1: parse_eu_hyvar_mspl_manifest_HyTimedImplementations returns [eu.hyvar.mspl.manifest.HyTimedImplementations element = null] : ( (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' ) )? (a11= QUOTED_60_62 ) a12= '{' ( ( (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )* ) )? a16= '}' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Hymanifest.g:1183:2: ( ( (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' ) )? (a11= QUOTED_60_62 ) a12= '{' ( ( (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )* ) )? a16= '}' )
            // Hymanifest.g:1184:2: ( (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' ) )? (a11= QUOTED_60_62 ) a12= '{' ( ( (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )* ) )? a16= '}'
            {
            // Hymanifest.g:1184:2: ( (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==24) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Hymanifest.g:1185:3: (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' )
                    {
                    // Hymanifest.g:1185:3: (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' )
                    // Hymanifest.g:1186:4: a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']'
                    {
                    a0=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1119); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_0_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a0, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[48]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[49]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[50]);
                    			}

                    // Hymanifest.g:1202:4: ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) )
                    int alt9=3;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==DATE) ) {
                        int LA9_1 = input.LA(2);

                        if ( (LA9_1==16) ) {
                            int LA9_3 = input.LA(3);

                            if ( (LA9_3==DATE) ) {
                                alt9=1;
                            }
                            else if ( (LA9_3==27) ) {
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
                    else if ( (LA9_0==27) ) {
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
                            // Hymanifest.g:1203:5: (a1= DATE ) a2= '-' (a3= DATE )
                            {
                            // Hymanifest.g:1203:5: (a1= DATE )
                            // Hymanifest.g:1204:6: a1= DATE
                            {
                            a1=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1152); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            							startIncompleteElement(element);
                            						}
                            						if (a1 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_0_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a1, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[51]);
                            				}

                            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1191); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_0_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a2, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[52]);
                            				}

                            // Hymanifest.g:1253:5: (a3= DATE )
                            // Hymanifest.g:1254:6: a3= DATE
                            {
                            a3=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1221); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            							startIncompleteElement(element);
                            						}
                            						if (a3 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_0_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a3, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[53]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymanifest.g:1290:10: (a4= DATE ) a5= '-' a6= 'eternity'
                            {
                            // Hymanifest.g:1290:10: (a4= DATE )
                            // Hymanifest.g:1291:6: a4= DATE
                            {
                            a4=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1277); if (state.failed) return element;

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
                            							tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_0_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a4, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[54]);
                            				}

                            a5=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1316); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_0_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a5, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[55]);
                            				}

                            a6=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1339); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_0_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a6, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[56]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymanifest.g:1355:10: a7= 'eternity' a8= '-' (a9= DATE )
                            {
                            a7=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1372); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_0_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[57]);
                            				}

                            a8=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1395); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_0_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a8, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[58]);
                            				}

                            // Hymanifest.g:1383:5: (a9= DATE )
                            // Hymanifest.g:1384:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1425); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                            							startIncompleteElement(element);
                            						}
                            						if (a9 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a9).getLine(), ((CommonToken) a9).getCharPositionInLine(), ((CommonToken) a9).getStartIndex(), ((CommonToken) a9).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_0_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a9, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[59]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[60]);
                    			}

                    a10=(Token)match(input,25,FOLLOW_25_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1477); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_0_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a10, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[61]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[62]);
            	}

            // Hymanifest.g:1446:2: (a11= QUOTED_60_62 )
            // Hymanifest.g:1447:3: a11= QUOTED_60_62
            {
            a11=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1514); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
            				startIncompleteElement(element);
            			}
            			if (a11 != null) {
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATIONS__SIGNATURE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a11).getLine(), ((CommonToken) a11).getCharPositionInLine(), ((CommonToken) a11).getStartIndex(), ((CommonToken) a11).getStopIndex());
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
            				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_1, proxy, true);
            				copyLocalizationInfos((CommonToken) a11, element);
            				copyLocalizationInfos((CommonToken) a11, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[63]);
            	}

            a12=(Token)match(input,30,FOLLOW_30_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1535); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a12, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[64]);
            		addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[65]);
            		addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[66]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[67]);
            	}

            // Hymanifest.g:1503:2: ( ( (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )* ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==IDENTIFIER_TOKEN||LA12_0==QUOTED_34_34||LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // Hymanifest.g:1504:3: ( (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )* )
                    {
                    // Hymanifest.g:1504:3: ( (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )* )
                    // Hymanifest.g:1505:4: (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )*
                    {
                    // Hymanifest.g:1505:4: (a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink )
                    // Hymanifest.g:1506:5: a13_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1564);
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
                    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_0, a13_0, true);
                    						copyLocalizationInfos(a13_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[68]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[69]);
                    			}

                    // Hymanifest.g:1532:4: ( (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==15) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // Hymanifest.g:1533:5: (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) )
                    	    {
                    	    // Hymanifest.g:1533:5: (a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink ) )
                    	    // Hymanifest.g:1534:6: a14= ',' (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink )
                    	    {
                    	    a14=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1605); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((CommonToken)a14, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[70]);
                    	    						addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[71]);
                    	    						addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[72]);
                    	    					}

                    	    // Hymanifest.g:1550:6: (a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink )
                    	    // Hymanifest.g:1551:7: a15_0= parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1639);
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
                    	    								retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_0_1, a15_0, true);
                    	    								copyLocalizationInfos(a15_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[73]);
                    	    						addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[74]);
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
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[75]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[76]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[77]);
            	}

            a16=(Token)match(input,31,FOLLOW_31_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1713); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a16, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[78]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_eu_hyvar_mspl_manifest_HyTimedImplementations_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_mspl_manifest_HyTimedImplementations"



    // $ANTLR start "parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink"
    // Hymanifest.g:1608:1: parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink returns [eu.hyvar.mspl.manifest.HyTimedImplementationLink element = null] : ( (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' ) )? ( (a11= QUOTED_34_34 ) | (a12= IDENTIFIER_TOKEN ) ) a13= '->' ( (a14= QUOTED_34_34 ) | (a15= IDENTIFIER_TOKEN ) ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Hymanifest.g:1611:2: ( ( (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' ) )? ( (a11= QUOTED_34_34 ) | (a12= IDENTIFIER_TOKEN ) ) a13= '->' ( (a14= QUOTED_34_34 ) | (a15= IDENTIFIER_TOKEN ) ) )
            // Hymanifest.g:1612:2: ( (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' ) )? ( (a11= QUOTED_34_34 ) | (a12= IDENTIFIER_TOKEN ) ) a13= '->' ( (a14= QUOTED_34_34 ) | (a15= IDENTIFIER_TOKEN ) )
            {
            // Hymanifest.g:1612:2: ( (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==24) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Hymanifest.g:1613:3: (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' )
                    {
                    // Hymanifest.g:1613:3: (a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']' )
                    // Hymanifest.g:1614:4: a0= '[' ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) ) a10= ']'
                    {
                    a0=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1751); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_0_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a0, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[79]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[80]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[81]);
                    			}

                    // Hymanifest.g:1630:4: ( (a1= DATE ) a2= '-' (a3= DATE ) | (a4= DATE ) a5= '-' a6= 'eternity' |a7= 'eternity' a8= '-' (a9= DATE ) )
                    int alt13=3;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==DATE) ) {
                        int LA13_1 = input.LA(2);

                        if ( (LA13_1==16) ) {
                            int LA13_3 = input.LA(3);

                            if ( (LA13_3==DATE) ) {
                                alt13=1;
                            }
                            else if ( (LA13_3==27) ) {
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
                    else if ( (LA13_0==27) ) {
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
                            // Hymanifest.g:1631:5: (a1= DATE ) a2= '-' (a3= DATE )
                            {
                            // Hymanifest.g:1631:5: (a1= DATE )
                            // Hymanifest.g:1632:6: a1= DATE
                            {
                            a1=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1784); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            							startIncompleteElement(element);
                            						}
                            						if (a1 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_0_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a1, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[82]);
                            				}

                            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1823); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_0_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a2, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[83]);
                            				}

                            // Hymanifest.g:1681:5: (a3= DATE )
                            // Hymanifest.g:1682:6: a3= DATE
                            {
                            a3=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1853); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            							startIncompleteElement(element);
                            						}
                            						if (a3 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_0_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a3, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[84]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymanifest.g:1718:10: (a4= DATE ) a5= '-' a6= 'eternity'
                            {
                            // Hymanifest.g:1718:10: (a4= DATE )
                            // Hymanifest.g:1719:6: a4= DATE
                            {
                            a4=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1909); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            							startIncompleteElement(element);
                            						}
                            						if (a4 != null) {
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_0_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a4, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[85]);
                            				}

                            a5=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1948); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_0_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a5, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[86]);
                            				}

                            a6=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1971); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_0_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a6, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[87]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymanifest.g:1783:10: a7= 'eternity' a8= '-' (a9= DATE )
                            {
                            a7=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2004); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_0_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[88]);
                            				}

                            a8=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2027); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_0_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a8, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[89]);
                            				}

                            // Hymanifest.g:1811:5: (a9= DATE )
                            // Hymanifest.g:1812:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2057); if (state.failed) return element;

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
                            							tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a9).getLine(), ((CommonToken) a9).getCharPositionInLine(), ((CommonToken) a9).getStartIndex(), ((CommonToken) a9).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_0_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a9, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[90]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[91]);
                    			}

                    a10=(Token)match(input,25,FOLLOW_25_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2109); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_0_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a10, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[92]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[93]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[94]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[95]);
            	}

            // Hymanifest.g:1876:2: ( (a11= QUOTED_34_34 ) | (a12= IDENTIFIER_TOKEN ) )
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
                    // Hymanifest.g:1877:3: (a11= QUOTED_34_34 )
                    {
                    // Hymanifest.g:1877:3: (a11= QUOTED_34_34 )
                    // Hymanifest.g:1878:4: a11= QUOTED_34_34
                    {
                    a11=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2151); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                    					startIncompleteElement(element);
                    				}
                    				if (a11 != null) {
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a11).getLine(), ((CommonToken) a11).getCharPositionInLine(), ((CommonToken) a11).getStartIndex(), ((CommonToken) a11).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContextDependentURIFragmentFactory<eu.hyvar.mspl.manifest.HyTimedImplementationLink, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedImplementationLinkLocalReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_1_0_0_0, proxy, true);
                    					copyLocalizationInfos((CommonToken) a11, element);
                    					copyLocalizationInfos((CommonToken) a11, proxy);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[96]);
                    		}

                    }
                    break;
                case 2 :
                    // Hymanifest.g:1918:6: (a12= IDENTIFIER_TOKEN )
                    {
                    // Hymanifest.g:1918:6: (a12= IDENTIFIER_TOKEN )
                    // Hymanifest.g:1919:4: a12= IDENTIFIER_TOKEN
                    {
                    a12=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2189); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                    					startIncompleteElement(element);
                    				}
                    				if (a12 != null) {
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a12).getLine(), ((CommonToken) a12).getCharPositionInLine(), ((CommonToken) a12).getStartIndex(), ((CommonToken) a12).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContextDependentURIFragmentFactory<eu.hyvar.mspl.manifest.HyTimedImplementationLink, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedImplementationLinkLocalReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_1_0_1_0, proxy, true);
                    					copyLocalizationInfos((CommonToken) a12, element);
                    					copyLocalizationInfos((CommonToken) a12, proxy);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[97]);
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[98]);
            	}

            a13=(Token)match(input,17,FOLLOW_17_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2223); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a13, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[99]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[100]);
            	}

            // Hymanifest.g:1979:2: ( (a14= QUOTED_34_34 ) | (a15= IDENTIFIER_TOKEN ) )
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
                    // Hymanifest.g:1980:3: (a14= QUOTED_34_34 )
                    {
                    // Hymanifest.g:1980:3: (a14= QUOTED_34_34 )
                    // Hymanifest.g:1981:4: a14= QUOTED_34_34
                    {
                    a14=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2246); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                    					startIncompleteElement(element);
                    				}
                    				if (a14 != null) {
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a14).getLine(), ((CommonToken) a14).getCharPositionInLine(), ((CommonToken) a14).getStartIndex(), ((CommonToken) a14).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContextDependentURIFragmentFactory<eu.hyvar.mspl.manifest.HyTimedImplementationLink, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedImplementationLinkSignatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_3_0_0_0, proxy, true);
                    					copyLocalizationInfos((CommonToken) a14, element);
                    					copyLocalizationInfos((CommonToken) a14, proxy);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[101]);
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[102]);
                    		}

                    }
                    break;
                case 2 :
                    // Hymanifest.g:2022:6: (a15= IDENTIFIER_TOKEN )
                    {
                    // Hymanifest.g:2022:6: (a15= IDENTIFIER_TOKEN )
                    // Hymanifest.g:2023:4: a15= IDENTIFIER_TOKEN
                    {
                    a15=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2284); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (terminateParsing) {
                    					throw new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTerminateParsingException();
                    				}
                    				if (element == null) {
                    					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
                    					startIncompleteElement(element);
                    				}
                    				if (a15 != null) {
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    					tokenResolver.setOptions(getOptions());
                    					eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result = getFreshTokenResolveResult();
                    					tokenResolver.resolve(a15.getText(), element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), result);
                    					Object resolvedObject = result.getResolvedToken();
                    					if (resolvedObject == null) {
                    						addErrorToResource(result.getErrorMessage(), ((CommonToken) a15).getLine(), ((CommonToken) a15).getCharPositionInLine(), ((CommonToken) a15).getStartIndex(), ((CommonToken) a15).getStopIndex());
                    					}
                    					String resolved = (String) resolvedObject;
                    					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    					collectHiddenTokens(element);
                    					registerContextDependentProxy(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestContextDependentURIFragmentFactory<eu.hyvar.mspl.manifest.HyTimedImplementationLink, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyTimedImplementationLinkSignatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), resolved, proxy);
                    					if (proxy != null) {
                    						Object value = proxy;
                    						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), value);
                    						completedElement(value, false);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_3_0_1_0, proxy, true);
                    					copyLocalizationInfos((CommonToken) a15, element);
                    					copyLocalizationInfos((CommonToken) a15, proxy);
                    				}
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[103]);
                    			addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[104]);
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[105]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[106]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnum"
    // Hymanifest.g:2072:1: parse_eu_hyvar_dataValues_HyEnum returns [eu.hyvar.dataValues.HyEnum element = null] : a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? ;
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

            // Hymanifest.g:2075:2: (a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? )
            // Hymanifest.g:2076:2: a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            {
            a0=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum2333); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[107]);
            	}

            // Hymanifest.g:2090:2: (a1= IDENTIFIER_TOKEN )
            // Hymanifest.g:2091:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum2351); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[108]);
            	}

            a2=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_dataValues_HyEnum2372); if (state.failed) return element;

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
            		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[109]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[110]);
            	}

            // Hymanifest.g:2141:2: ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==21) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Hymanifest.g:2142:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    {
                    // Hymanifest.g:2142:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    // Hymanifest.g:2143:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    {
                    // Hymanifest.g:2143:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    // Hymanifest.g:2144:5: a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum2401);
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
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[111]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[112]);
                    			}

                    // Hymanifest.g:2170:4: ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==15) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // Hymanifest.g:2171:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    {
                    	    // Hymanifest.g:2171:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    // Hymanifest.g:2172:6: a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    {
                    	    a4=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_dataValues_HyEnum2442); if (state.failed) return element;

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
                    	    						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[113]);
                    	    					}

                    	    // Hymanifest.g:2186:6: (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    // Hymanifest.g:2187:7: a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum2476);
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
                    	    						addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[114]);
                    	    						addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[115]);
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
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[116]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[117]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[118]);
            	}

            a6=(Token)match(input,14,FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnum2550); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[119]);
            	}

            // Hymanifest.g:2242:2: ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==24) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // Hymanifest.g:2243:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    {
                    // Hymanifest.g:2243:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    // Hymanifest.g:2244:4: a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']'
                    {
                    a7=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_dataValues_HyEnum2573); if (state.failed) return element;

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
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[120]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[121]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[122]);
                    			}

                    // Hymanifest.g:2260:4: ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) )
                    int alt19=3;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==DATE) ) {
                        int LA19_1 = input.LA(2);

                        if ( (LA19_1==16) ) {
                            int LA19_3 = input.LA(3);

                            if ( (LA19_3==DATE) ) {
                                alt19=1;
                            }
                            else if ( (LA19_3==25) ) {
                                alt19=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 19, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 19, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA19_0==27) ) {
                        alt19=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;

                    }
                    switch (alt19) {
                        case 1 :
                            // Hymanifest.g:2261:5: (a8= DATE ) a9= '-' (a10= DATE )
                            {
                            // Hymanifest.g:2261:5: (a8= DATE )
                            // Hymanifest.g:2262:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum2606); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[123]);
                            				}

                            a9=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum2645); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[124]);
                            				}

                            // Hymanifest.g:2311:5: (a10= DATE )
                            // Hymanifest.g:2312:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum2675); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[125]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymanifest.g:2348:10: (a11= DATE ) a12= '-'
                            {
                            // Hymanifest.g:2348:10: (a11= DATE )
                            // Hymanifest.g:2349:6: a11= DATE
                            {
                            a11=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum2731); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[126]);
                            				}

                            a12=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum2770); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[127]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymanifest.g:2399:10: a13= 'eternity' a14= '-' (a15= DATE )
                            {
                            a13=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_dataValues_HyEnum2803); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[128]);
                            				}

                            a14=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum2826); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[129]);
                            				}

                            // Hymanifest.g:2427:5: (a15= DATE )
                            // Hymanifest.g:2428:6: a15= DATE
                            {
                            a15=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum2856); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[130]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[131]);
                    			}

                    a16=(Token)match(input,25,FOLLOW_25_in_parse_eu_hyvar_dataValues_HyEnum2908); if (state.failed) return element;

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
            if ( state.backtracking>0 ) { memoize(input, 7, parse_eu_hyvar_dataValues_HyEnum_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnum"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumLiteral"
    // Hymanifest.g:2490:1: parse_eu_hyvar_dataValues_HyEnumLiteral returns [eu.hyvar.dataValues.HyEnumLiteral element = null] : a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
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

            // Hymanifest.g:2493:2: (a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hymanifest.g:2494:2: a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral2956); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[132]);
            	}

            // Hymanifest.g:2508:2: (a1= IDENTIFIER_TOKEN )
            // Hymanifest.g:2509:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral2974); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[133]);
            	}

            a2=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_dataValues_HyEnumLiteral2995); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[134]);
            	}

            // Hymanifest.g:2558:2: (a3= INTEGER_LITERAL )
            // Hymanifest.g:2559:3: a3= INTEGER_LITERAL
            {
            a3=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral3013); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[135]);
            	}

            a4=(Token)match(input,14,FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnumLiteral3034); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[136]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[137]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[138]);
            	}

            // Hymanifest.g:2610:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==24) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // Hymanifest.g:2611:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hymanifest.g:2611:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hymanifest.g:2612:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_dataValues_HyEnumLiteral3057); if (state.failed) return element;

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
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[139]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[140]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[141]);
                    			}

                    // Hymanifest.g:2628:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) )
                    int alt21=3;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==DATE) ) {
                        int LA21_1 = input.LA(2);

                        if ( (LA21_1==16) ) {
                            int LA21_3 = input.LA(3);

                            if ( (LA21_3==DATE) ) {
                                alt21=1;
                            }
                            else if ( (LA21_3==27) ) {
                                alt21=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 21, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 21, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA21_0==27) ) {
                        alt21=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;

                    }
                    switch (alt21) {
                        case 1 :
                            // Hymanifest.g:2629:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hymanifest.g:2629:5: (a6= DATE )
                            // Hymanifest.g:2630:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3090); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[142]);
                            				}

                            a7=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral3129); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[143]);
                            				}

                            // Hymanifest.g:2679:5: (a8= DATE )
                            // Hymanifest.g:2680:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3159); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[144]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hymanifest.g:2716:10: (a9= DATE ) a10= '-' a11= 'eternity'
                            {
                            // Hymanifest.g:2716:10: (a9= DATE )
                            // Hymanifest.g:2717:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3215); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[145]);
                            				}

                            a10=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral3254); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[146]);
                            				}

                            a11=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_dataValues_HyEnumLiteral3277); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[147]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hymanifest.g:2781:10: a12= 'eternity' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,27,FOLLOW_27_in_parse_eu_hyvar_dataValues_HyEnumLiteral3310); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[148]);
                            				}

                            a13=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral3333); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[149]);
                            				}

                            // Hymanifest.g:2809:5: (a14= DATE )
                            // Hymanifest.g:2810:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3363); if (state.failed) return element;

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
                            					addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[150]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[151]);
                    			}

                    a15=(Token)match(input,25,FOLLOW_25_in_parse_eu_hyvar_dataValues_HyEnumLiteral3415); if (state.failed) return element;

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
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[152]);
                    				addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[153]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[154]);
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[155]);
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



    // $ANTLR start "parseop_HyValue_level_15"
    // Hymanifest.g:2876:1: parseop_HyValue_level_15 returns [eu.hyvar.dataValues.HyValue element = null] : (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue );
    public final eu.hyvar.dataValues.HyValue parseop_HyValue_level_15() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parseop_HyValue_level_15_StartIndex = input.index();

        eu.hyvar.dataValues.HyNumberValue c0 =null;

        eu.hyvar.dataValues.HyBooleanValue c1 =null;

        eu.hyvar.dataValues.HyEnumValue c2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Hymanifest.g:2879:2: (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue )
            int alt23=3;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
                {
                alt23=1;
                }
                break;
            case 28:
            case 29:
                {
                alt23=2;
                }
                break;
            case 26:
                {
                alt23=3;
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
                    // Hymanifest.g:2880:2: c0= parse_eu_hyvar_dataValues_HyNumberValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_153463);
                    c0=parse_eu_hyvar_dataValues_HyNumberValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hymanifest.g:2881:4: c1= parse_eu_hyvar_dataValues_HyBooleanValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_153473);
                    c1=parse_eu_hyvar_dataValues_HyBooleanValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hymanifest.g:2882:4: c2= parse_eu_hyvar_dataValues_HyEnumValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_153483);
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
            if ( state.backtracking>0 ) { memoize(input, 9, parseop_HyValue_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyValue_level_15"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyNumberValue"
    // Hymanifest.g:2885:1: parse_eu_hyvar_dataValues_HyNumberValue returns [eu.hyvar.dataValues.HyNumberValue element = null] : (a0= INTEGER_LITERAL ) ;
    public final eu.hyvar.dataValues.HyNumberValue parse_eu_hyvar_dataValues_HyNumberValue() throws RecognitionException {
        eu.hyvar.dataValues.HyNumberValue element =  null;

        int parse_eu_hyvar_dataValues_HyNumberValue_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Hymanifest.g:2888:2: ( (a0= INTEGER_LITERAL ) )
            // Hymanifest.g:2889:2: (a0= INTEGER_LITERAL )
            {
            // Hymanifest.g:2889:2: (a0= INTEGER_LITERAL )
            // Hymanifest.g:2890:3: a0= INTEGER_LITERAL
            {
            a0=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3510); if (state.failed) return element;

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
            if ( state.backtracking>0 ) { memoize(input, 10, parse_eu_hyvar_dataValues_HyNumberValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyNumberValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyBooleanValue"
    // Hymanifest.g:2926:1: parse_eu_hyvar_dataValues_HyBooleanValue returns [eu.hyvar.dataValues.HyBooleanValue element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.dataValues.HyBooleanValue parse_eu_hyvar_dataValues_HyBooleanValue() throws RecognitionException {
        eu.hyvar.dataValues.HyBooleanValue element =  null;

        int parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Hymanifest.g:2929:2: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hymanifest.g:2930:2: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hymanifest.g:2930:2: ( (a0= 'true' |a1= 'false' ) )
            // Hymanifest.g:2931:3: (a0= 'true' |a1= 'false' )
            {
            // Hymanifest.g:2931:3: (a0= 'true' |a1= 'false' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==29) ) {
                alt24=1;
            }
            else if ( (LA24_0==28) ) {
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
                    // Hymanifest.g:2932:4: a0= 'true'
                    {
                    a0=(Token)match(input,29,FOLLOW_29_in_parse_eu_hyvar_dataValues_HyBooleanValue3555); if (state.failed) return element;

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
                    // Hymanifest.g:2945:8: a1= 'false'
                    {
                    a1=(Token)match(input,28,FOLLOW_28_in_parse_eu_hyvar_dataValues_HyBooleanValue3570); if (state.failed) return element;

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
            if ( state.backtracking>0 ) { memoize(input, 11, parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyBooleanValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumValue"
    // Hymanifest.g:2966:1: parse_eu_hyvar_dataValues_HyEnumValue returns [eu.hyvar.dataValues.HyEnumValue element = null] : a0= 'enum:' (a1= IDENTIFIER_TOKEN ) a2= '.' (a3= IDENTIFIER_TOKEN ) ;
    public final eu.hyvar.dataValues.HyEnumValue parse_eu_hyvar_dataValues_HyEnumValue() throws RecognitionException {
        eu.hyvar.dataValues.HyEnumValue element =  null;

        int parse_eu_hyvar_dataValues_HyEnumValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Hymanifest.g:2969:2: (a0= 'enum:' (a1= IDENTIFIER_TOKEN ) a2= '.' (a3= IDENTIFIER_TOKEN ) )
            // Hymanifest.g:2970:2: a0= 'enum:' (a1= IDENTIFIER_TOKEN ) a2= '.' (a3= IDENTIFIER_TOKEN )
            {
            a0=(Token)match(input,26,FOLLOW_26_in_parse_eu_hyvar_dataValues_HyEnumValue3606); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[156]);
            	}

            // Hymanifest.g:2984:2: (a1= IDENTIFIER_TOKEN )
            // Hymanifest.g:2985:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3624); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[157]);
            	}

            a2=(Token)match(input,18,FOLLOW_18_in_parse_eu_hyvar_dataValues_HyEnumValue3645); if (state.failed) return element;

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
            		addExpectedElement(null, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[158]);
            	}

            // Hymanifest.g:3038:2: (a3= IDENTIFIER_TOKEN )
            // Hymanifest.g:3039:3: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3663); if (state.failed) return element;

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
            if ( state.backtracking>0 ) { memoize(input, 12, parse_eu_hyvar_dataValues_HyEnumValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HySPLImplementation_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HySPLSignature_in_start96 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_eu_hyvar_mspl_manifest_HySPLSignature129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation158 = new BitSet(new long[]{0x0000000000082002L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation181 = new BitSet(new long[]{0x0000000001000220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedDependencies_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation207 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation248 = new BitSet(new long[]{0x0000000001000220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedDependencies_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation282 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation343 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation385 = new BitSet(new long[]{0x0000000001000400L});
    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementations_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation411 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation452 = new BitSet(new long[]{0x0000000001000400L});
    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementations_in_parse_eu_hyvar_mspl_manifest_HySPLImplementation486 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies584 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies617 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies656 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies686 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies742 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies781 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies804 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies837 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies860 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies890 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies942 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies984 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies1022 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies1056 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_eu_hyvar_mspl_manifest_HyTimedDependencies1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1119 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1152 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1191 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1221 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1277 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1316 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1339 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1372 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1395 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1425 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1477 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1514 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1535 = new BitSet(new long[]{0x0000000081000220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1564 = new BitSet(new long[]{0x0000000080008000L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1605 = new BitSet(new long[]{0x0000000001000220L});
    public static final BitSet FOLLOW_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1639 = new BitSet(new long[]{0x0000000080008000L});
    public static final BitSet FOLLOW_31_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementations1713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1751 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1784 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1823 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1853 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1909 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1948 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink1971 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2004 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2027 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2057 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2109 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2151 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2189 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2223 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum2333 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum2351 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_dataValues_HyEnum2372 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum2401 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_dataValues_HyEnum2442 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum2476 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnum2550 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_dataValues_HyEnum2573 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum2606 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum2645 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum2675 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum2731 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum2770 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_dataValues_HyEnum2803 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum2826 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum2856 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_eu_hyvar_dataValues_HyEnum2908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral2956 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral2974 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_dataValues_HyEnumLiteral2995 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral3013 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnumLiteral3034 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_dataValues_HyEnumLiteral3057 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3090 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral3129 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3159 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3215 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral3254 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_dataValues_HyEnumLiteral3277 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_27_in_parse_eu_hyvar_dataValues_HyEnumLiteral3310 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral3333 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral3363 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_eu_hyvar_dataValues_HyEnumLiteral3415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_153463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_153473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_153483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_parse_eu_hyvar_dataValues_HyBooleanValue3555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_parse_eu_hyvar_dataValues_HyBooleanValue3570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_parse_eu_hyvar_dataValues_HyEnumValue3606 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3624 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_eu_hyvar_dataValues_HyEnumValue3645 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3663 = new BitSet(new long[]{0x0000000000000002L});

}