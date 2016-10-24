// $ANTLR 3.4

	package eu.hyvar.context.resource.hycontextinformation.mopp;
	
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
public class HycontextinformationParser extends HycontextinformationANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DATE", "IDENTIFIER_TOKEN", "INTEGER_LITERAL", "LINEBREAK", "ML_COMMENT", "SL_COMMENT", "WHITESPACE", "')'", "','", "'-'", "'.'", "'BooleanContext('", "'Enum('", "'EnumContext('", "'EnumLiteral('", "'NumberContext('", "'['", "']'", "'enum:'", "'false'", "'null'", "'true'"
    };

    public static final int EOF=-1;
    public static final int T__11=11;
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
    public static final int DATE=4;
    public static final int IDENTIFIER_TOKEN=5;
    public static final int INTEGER_LITERAL=6;
    public static final int LINEBREAK=7;
    public static final int ML_COMMENT=8;
    public static final int SL_COMMENT=9;
    public static final int WHITESPACE=10;

    // delegates
    public HycontextinformationANTLRParserBase[] getDelegates() {
        return new HycontextinformationANTLRParserBase[] {};
    }

    // delegators


    public HycontextinformationParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public HycontextinformationParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(36 + 1);
         

    }

    public String[] getTokenNames() { return HycontextinformationParser.tokenNames; }
    public String getGrammarFileName() { return "Hycontextinformation.g"; }


    	private eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolverFactory tokenResolverFactory = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTokenResolverFactory();
    	
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
    	private List<eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal> expectedElements = new ArrayList<eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal>();
    	
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
    	
    	private eu.hyvar.context.resource.hycontextinformation.IHycontextinformationLocationMap locationMap;
    	
    	private eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationSyntaxErrorMessageConverter syntaxErrorMessageConverter = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationSyntaxErrorMessageConverter(tokenNames);
    	
    	@Override
    	public void reportError(RecognitionException re) {
    		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
    	}
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new eu.hyvar.context.resource.hycontextinformation.IHycontextinformationCommand<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource>() {
    			public boolean execute(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new eu.hyvar.context.resource.hycontextinformation.IHycontextinformationProblem() {
    					public eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemSeverity getSeverity() {
    						return eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemSeverity.ERROR;
    					}
    					public eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemType getType() {
    						return eu.hyvar.context.resource.hycontextinformation.HycontextinformationEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	protected void addErrorToResource(eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationLocalizedMessage message) {
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
    		eu.hyvar.context.resource.hycontextinformation.IHycontextinformationExpectedElement terminal = eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationFollowSetProvider.TERMINALS[terminalID];
    		eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContainedFeature[] containmentFeatures = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationFollowSetProvider.LINKS[ids[i]];
    		}
    		eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainmentTrace containmentTrace = new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainmentTrace(eClass, containmentFeatures);
    		EObject container = getLastIncompleteElement();
    		eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal expectedElement = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		final eu.hyvar.context.resource.hycontextinformation.IHycontextinformationLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.context.resource.hycontextinformation.IHycontextinformationCommand<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource>() {
    			public boolean execute(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource resource) {
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
    		final eu.hyvar.context.resource.hycontextinformation.IHycontextinformationLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.context.resource.hycontextinformation.IHycontextinformationCommand<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource>() {
    			public boolean execute(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource resource) {
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
    	protected void setLocalizationEnd(Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationCommand<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		final eu.hyvar.context.resource.hycontextinformation.IHycontextinformationLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new eu.hyvar.context.resource.hycontextinformation.IHycontextinformationCommand<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource>() {
    			public boolean execute(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource resource) {
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextParser createInstance(InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new HycontextinformationParser(new CommonTokenStream(new HycontextinformationLexer(new ANTLRInputStream(actualInputStream))));
    			} else {
    				return new HycontextinformationParser(new CommonTokenStream(new HycontextinformationLexer(new ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (IOException e) {
    			new eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public HycontextinformationParser() {
    		super(null);
    	}
    	
    	protected EObject doParse() throws RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((HycontextinformationLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((HycontextinformationLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof EClass) {
    			EClass type = (EClass) typeObject;
    			if (type.getInstanceClass() == eu.hyvar.context.HyContextModel.class) {
    				return parse_eu_hyvar_context_HyContextModel();
    			}
    			if (type.getInstanceClass() == eu.hyvar.context.HyContextualInformationNumber.class) {
    				return parse_eu_hyvar_context_HyContextualInformationNumber();
    			}
    			if (type.getInstanceClass() == eu.hyvar.context.HyContextualInformationBoolean.class) {
    				return parse_eu_hyvar_context_HyContextualInformationBoolean();
    			}
    			if (type.getInstanceClass() == eu.hyvar.context.HyContextualInformationEnum.class) {
    				return parse_eu_hyvar_context_HyContextualInformationEnum();
    			}
    			if (type.getInstanceClass() == eu.hyvar.dataValues.HyEnum.class) {
    				return parse_eu_hyvar_dataValues_HyEnum();
    			}
    			if (type.getInstanceClass() == eu.hyvar.dataValues.HyEnumLiteral.class) {
    				return parse_eu_hyvar_dataValues_HyEnumLiteral();
    			}
    		}
    		throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationParseResult parse() {
    		// Reset parser state
    		terminateParsing = false;
    		postParseCommands = new ArrayList<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationCommand<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource>>();
    		eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationParseResult parseResult = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationParseResult();
    		if (disableLocationMap) {
    			locationMap = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationDevNullLocationMap();
    		} else {
    			locationMap = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationLocationMap();
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
    	
    	public List<eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal> parseToExpectedElements(EClass type, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
    		eu.hyvar.context.resource.hycontextinformation.IHycontextinformationParseResult result = parse();
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
    			for (eu.hyvar.context.resource.hycontextinformation.IHycontextinformationCommand<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		Set<eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal> currentFollowSet = new LinkedHashSet<eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal>();
    		List<eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal> newFollowSet = new ArrayList<eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 103;
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
    				for (eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						Collection<eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationPair<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationExpectedElement, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationPair<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationExpectedElement, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContainedFeature[]> newFollowerPair : newFollowers) {
    							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationExpectedElement newFollower = newFollowerPair.getLeft();
    							EObject container = getLastIncompleteElement();
    							eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainmentTrace containmentTrace = new eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationContainmentTrace(null, newFollowerPair.getRight());
    							eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal newFollowTerminal = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectedTerminal expectedElement, int tokenIndex) {
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
    // Hycontextinformation.g:496:1: start returns [ EObject element = null] : (c0= parse_eu_hyvar_context_HyContextModel ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        eu.hyvar.context.HyContextModel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Hycontextinformation.g:497:2: ( (c0= parse_eu_hyvar_context_HyContextModel ) EOF )
            // Hycontextinformation.g:498:2: (c0= parse_eu_hyvar_context_HyContextModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[1]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[2]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[3]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Hycontextinformation.g:506:2: (c0= parse_eu_hyvar_context_HyContextModel )
            // Hycontextinformation.g:507:3: c0= parse_eu_hyvar_context_HyContextModel
            {
            pushFollow(FOLLOW_parse_eu_hyvar_context_HyContextModel_in_start82);
            c0=parse_eu_hyvar_context_HyContextModel();

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



    // $ANTLR start "parse_eu_hyvar_context_HyContextModel"
    // Hycontextinformation.g:515:1: parse_eu_hyvar_context_HyContextModel returns [eu.hyvar.context.HyContextModel element = null] : ( (a0_0= parse_eu_hyvar_dataValues_HyEnum ) )* ( (a1_0= parse_eu_hyvar_context_HyContextualInformation ) )* ;
    public final eu.hyvar.context.HyContextModel parse_eu_hyvar_context_HyContextModel() throws RecognitionException {
        eu.hyvar.context.HyContextModel element =  null;

        int parse_eu_hyvar_context_HyContextModel_StartIndex = input.index();

        eu.hyvar.dataValues.HyEnum a0_0 =null;

        eu.hyvar.context.HyContextualInformation a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Hycontextinformation.g:518:2: ( ( (a0_0= parse_eu_hyvar_dataValues_HyEnum ) )* ( (a1_0= parse_eu_hyvar_context_HyContextualInformation ) )* )
            // Hycontextinformation.g:519:2: ( (a0_0= parse_eu_hyvar_dataValues_HyEnum ) )* ( (a1_0= parse_eu_hyvar_context_HyContextualInformation ) )*
            {
            // Hycontextinformation.g:519:2: ( (a0_0= parse_eu_hyvar_dataValues_HyEnum ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Hycontextinformation.g:520:3: (a0_0= parse_eu_hyvar_dataValues_HyEnum )
            	    {
            	    // Hycontextinformation.g:520:3: (a0_0= parse_eu_hyvar_dataValues_HyEnum )
            	    // Hycontextinformation.g:521:4: a0_0= parse_eu_hyvar_dataValues_HyEnum
            	    {
            	    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnum_in_parse_eu_hyvar_context_HyContextModel124);
            	    a0_0=parse_eu_hyvar_dataValues_HyEnum();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextModel();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a0_0 != null) {
            	    					if (a0_0 != null) {
            	    						Object value = a0_0;
            	    						addObjectToList(element, eu.hyvar.context.HyContextInformationPackage.HY_CONTEXT_MODEL__ENUMS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_0_0_0_0, a0_0, true);
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
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[4]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[6]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[7]);
            	}

            // Hycontextinformation.g:550:2: ( (a1_0= parse_eu_hyvar_context_HyContextualInformation ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15||LA2_0==17||LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Hycontextinformation.g:551:3: (a1_0= parse_eu_hyvar_context_HyContextualInformation )
            	    {
            	    // Hycontextinformation.g:551:3: (a1_0= parse_eu_hyvar_context_HyContextualInformation )
            	    // Hycontextinformation.g:552:4: a1_0= parse_eu_hyvar_context_HyContextualInformation
            	    {
            	    pushFollow(FOLLOW_parse_eu_hyvar_context_HyContextualInformation_in_parse_eu_hyvar_context_HyContextModel159);
            	    a1_0=parse_eu_hyvar_context_HyContextualInformation();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextModel();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a1_0 != null) {
            	    					if (a1_0 != null) {
            	    						Object value = a1_0;
            	    						addObjectToList(element, eu.hyvar.context.HyContextInformationPackage.HY_CONTEXT_MODEL__CONTEXTUAL_INFORMATIONS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_0_0_0_1, a1_0, true);
            	    					copyLocalizationInfos(a1_0, element);
            	    				}
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
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[8]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[10]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_eu_hyvar_context_HyContextModel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_context_HyContextModel"



    // $ANTLR start "parse_eu_hyvar_context_HyContextualInformationNumber"
    // Hycontextinformation.g:582:1: parse_eu_hyvar_context_HyContextualInformationNumber returns [eu.hyvar.context.HyContextualInformationNumber element = null] : a0= 'NumberContext(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ',' (a5= INTEGER_LITERAL ) a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' ) )? ;
    public final eu.hyvar.context.HyContextualInformationNumber parse_eu_hyvar_context_HyContextualInformationNumber() throws RecognitionException {
        eu.hyvar.context.HyContextualInformationNumber element =  null;

        int parse_eu_hyvar_context_HyContextualInformationNumber_StartIndex = input.index();

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
        Token a16=null;
        Token a17=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Hycontextinformation.g:585:2: (a0= 'NumberContext(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ',' (a5= INTEGER_LITERAL ) a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' ) )? )
            // Hycontextinformation.g:586:2: a0= 'NumberContext(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ',' (a5= INTEGER_LITERAL ) a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' ) )?
            {
            a0=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_context_HyContextualInformationNumber200); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[11]);
            	}

            // Hycontextinformation.g:600:2: (a1= IDENTIFIER_TOKEN )
            // Hycontextinformation.g:601:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_HyContextualInformationNumber218); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[12]);
            	}

            a2=(Token)match(input,12,FOLLOW_12_in_parse_eu_hyvar_context_HyContextualInformationNumber239); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[13]);
            	}

            // Hycontextinformation.g:650:2: (a3= INTEGER_LITERAL )
            // Hycontextinformation.g:651:3: a3= INTEGER_LITERAL
            {
            a3=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_context_HyContextualInformationNumber257); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__MIN), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            				}
            				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__MIN), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_3, resolved, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[14]);
            	}

            a4=(Token)match(input,12,FOLLOW_12_in_parse_eu_hyvar_context_HyContextualInformationNumber278); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[15]);
            	}

            // Hycontextinformation.g:700:2: (a5= INTEGER_LITERAL )
            // Hycontextinformation.g:701:3: a5= INTEGER_LITERAL
            {
            a5=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_context_HyContextualInformationNumber296); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
            				startIncompleteElement(element);
            			}
            			if (a5 != null) {
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__MAX), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
            				}
            				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__MAX), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_5, resolved, true);
            				copyLocalizationInfos((CommonToken) a5, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[16]);
            	}

            a6=(Token)match(input,11,FOLLOW_11_in_parse_eu_hyvar_context_HyContextualInformationNumber317); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_6, null, true);
            		copyLocalizationInfos((CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[17]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[18]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[19]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[20]);
            	}

            // Hycontextinformation.g:753:2: ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Hycontextinformation.g:754:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' )
                    {
                    // Hycontextinformation.g:754:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' )
                    // Hycontextinformation.g:755:4: a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']'
                    {
                    a7=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_context_HyContextualInformationNumber340); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a7, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[21]);
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[22]);
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[23]);
                    			}

                    // Hycontextinformation.g:771:4: ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) )
                    int alt3=3;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==DATE) ) {
                        int LA3_1 = input.LA(2);

                        if ( (LA3_1==13) ) {
                            int LA3_3 = input.LA(3);

                            if ( (LA3_3==DATE) ) {
                                alt3=1;
                            }
                            else if ( (LA3_3==24) ) {
                                alt3=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA3_0==24) ) {
                        alt3=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;

                    }
                    switch (alt3) {
                        case 1 :
                            // Hycontextinformation.g:772:5: (a8= DATE ) a9= '-' (a10= DATE )
                            {
                            // Hycontextinformation.g:772:5: (a8= DATE )
                            // Hycontextinformation.g:773:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationNumber373); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[24]);
                            				}

                            a9=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationNumber412); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[25]);
                            				}

                            // Hycontextinformation.g:822:5: (a10= DATE )
                            // Hycontextinformation.g:823:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationNumber442); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
                            							startIncompleteElement(element);
                            						}
                            						if (a10 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a10).getLine(), ((CommonToken) a10).getCharPositionInLine(), ((CommonToken) a10).getStartIndex(), ((CommonToken) a10).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a10, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[26]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hycontextinformation.g:859:10: (a11= DATE ) a12= '-' a13= 'null'
                            {
                            // Hycontextinformation.g:859:10: (a11= DATE )
                            // Hycontextinformation.g:860:6: a11= DATE
                            {
                            a11=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationNumber498); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
                            							startIncompleteElement(element);
                            						}
                            						if (a11 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a11).getLine(), ((CommonToken) a11).getCharPositionInLine(), ((CommonToken) a11).getStartIndex(), ((CommonToken) a11).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a11, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[27]);
                            				}

                            a12=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationNumber537); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[28]);
                            				}

                            a13=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_context_HyContextualInformationNumber560); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[29]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hycontextinformation.g:924:10: a14= 'null' a15= '-' (a16= DATE )
                            {
                            a14=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_context_HyContextualInformationNumber593); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a14, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[30]);
                            				}

                            a15=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationNumber616); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a15, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[31]);
                            				}

                            // Hycontextinformation.g:952:5: (a16= DATE )
                            // Hycontextinformation.g:953:6: a16= DATE
                            {
                            a16=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationNumber646); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
                            							startIncompleteElement(element);
                            						}
                            						if (a16 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a16.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a16).getLine(), ((CommonToken) a16).getCharPositionInLine(), ((CommonToken) a16).getStartIndex(), ((CommonToken) a16).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_NUMBER__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a16, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[32]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[33]);
                    			}

                    a17=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_context_HyContextualInformationNumber698); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a17, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[34]);
                    				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[35]);
                    				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[36]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[37]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[38]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[39]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_eu_hyvar_context_HyContextualInformationNumber_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_context_HyContextualInformationNumber"



    // $ANTLR start "parse_eu_hyvar_context_HyContextualInformationBoolean"
    // Hycontextinformation.g:1021:1: parse_eu_hyvar_context_HyContextualInformationBoolean returns [eu.hyvar.context.HyContextualInformationBoolean element = null] : a0= 'BooleanContext(' (a1= IDENTIFIER_TOKEN ) a2= ')' ( (a3= '[' ( (a4= DATE ) a5= '-' (a6= DATE ) | (a7= DATE ) a8= '-' a9= 'null' |a10= 'null' a11= '-' (a12= DATE ) ) a13= ']' ) )? ;
    public final eu.hyvar.context.HyContextualInformationBoolean parse_eu_hyvar_context_HyContextualInformationBoolean() throws RecognitionException {
        eu.hyvar.context.HyContextualInformationBoolean element =  null;

        int parse_eu_hyvar_context_HyContextualInformationBoolean_StartIndex = input.index();

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



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Hycontextinformation.g:1024:2: (a0= 'BooleanContext(' (a1= IDENTIFIER_TOKEN ) a2= ')' ( (a3= '[' ( (a4= DATE ) a5= '-' (a6= DATE ) | (a7= DATE ) a8= '-' a9= 'null' |a10= 'null' a11= '-' (a12= DATE ) ) a13= ']' ) )? )
            // Hycontextinformation.g:1025:2: a0= 'BooleanContext(' (a1= IDENTIFIER_TOKEN ) a2= ')' ( (a3= '[' ( (a4= DATE ) a5= '-' (a6= DATE ) | (a7= DATE ) a8= '-' a9= 'null' |a10= 'null' a11= '-' (a12= DATE ) ) a13= ']' ) )?
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_context_HyContextualInformationBoolean746); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[40]);
            	}

            // Hycontextinformation.g:1039:2: (a1= IDENTIFIER_TOKEN )
            // Hycontextinformation.g:1040:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_HyContextualInformationBoolean764); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[41]);
            	}

            a2=(Token)match(input,11,FOLLOW_11_in_parse_eu_hyvar_context_HyContextualInformationBoolean785); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[42]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[43]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[44]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[45]);
            	}

            // Hycontextinformation.g:1092:2: ( (a3= '[' ( (a4= DATE ) a5= '-' (a6= DATE ) | (a7= DATE ) a8= '-' a9= 'null' |a10= 'null' a11= '-' (a12= DATE ) ) a13= ']' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Hycontextinformation.g:1093:3: (a3= '[' ( (a4= DATE ) a5= '-' (a6= DATE ) | (a7= DATE ) a8= '-' a9= 'null' |a10= 'null' a11= '-' (a12= DATE ) ) a13= ']' )
                    {
                    // Hycontextinformation.g:1093:3: (a3= '[' ( (a4= DATE ) a5= '-' (a6= DATE ) | (a7= DATE ) a8= '-' a9= 'null' |a10= 'null' a11= '-' (a12= DATE ) ) a13= ']' )
                    // Hycontextinformation.g:1094:4: a3= '[' ( (a4= DATE ) a5= '-' (a6= DATE ) | (a7= DATE ) a8= '-' a9= 'null' |a10= 'null' a11= '-' (a12= DATE ) ) a13= ']'
                    {
                    a3=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_context_HyContextualInformationBoolean808); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a3, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[46]);
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[47]);
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[48]);
                    			}

                    // Hycontextinformation.g:1110:4: ( (a4= DATE ) a5= '-' (a6= DATE ) | (a7= DATE ) a8= '-' a9= 'null' |a10= 'null' a11= '-' (a12= DATE ) )
                    int alt5=3;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==DATE) ) {
                        int LA5_1 = input.LA(2);

                        if ( (LA5_1==13) ) {
                            int LA5_3 = input.LA(3);

                            if ( (LA5_3==DATE) ) {
                                alt5=1;
                            }
                            else if ( (LA5_3==24) ) {
                                alt5=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return element;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 3, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA5_0==24) ) {
                        alt5=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;

                    }
                    switch (alt5) {
                        case 1 :
                            // Hycontextinformation.g:1111:5: (a4= DATE ) a5= '-' (a6= DATE )
                            {
                            // Hycontextinformation.g:1111:5: (a4= DATE )
                            // Hycontextinformation.g:1112:6: a4= DATE
                            {
                            a4=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationBoolean841); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
                            							startIncompleteElement(element);
                            						}
                            						if (a4 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a4, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[49]);
                            				}

                            a5=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationBoolean880); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a5, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[50]);
                            				}

                            // Hycontextinformation.g:1161:5: (a6= DATE )
                            // Hycontextinformation.g:1162:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationBoolean910); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
                            							startIncompleteElement(element);
                            						}
                            						if (a6 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a6).getLine(), ((CommonToken) a6).getCharPositionInLine(), ((CommonToken) a6).getStartIndex(), ((CommonToken) a6).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a6, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[51]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hycontextinformation.g:1198:10: (a7= DATE ) a8= '-' a9= 'null'
                            {
                            // Hycontextinformation.g:1198:10: (a7= DATE )
                            // Hycontextinformation.g:1199:6: a7= DATE
                            {
                            a7=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationBoolean966); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
                            							startIncompleteElement(element);
                            						}
                            						if (a7 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a7, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[52]);
                            				}

                            a8=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationBoolean1005); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a8, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[53]);
                            				}

                            a9=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_context_HyContextualInformationBoolean1028); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[54]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hycontextinformation.g:1263:10: a10= 'null' a11= '-' (a12= DATE )
                            {
                            a10=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_context_HyContextualInformationBoolean1061); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a10, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[55]);
                            				}

                            a11=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationBoolean1084); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a11, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[56]);
                            				}

                            // Hycontextinformation.g:1291:5: (a12= DATE )
                            // Hycontextinformation.g:1292:6: a12= DATE
                            {
                            a12=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationBoolean1114); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
                            							startIncompleteElement(element);
                            						}
                            						if (a12 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a12).getLine(), ((CommonToken) a12).getCharPositionInLine(), ((CommonToken) a12).getStartIndex(), ((CommonToken) a12).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_BOOLEAN__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a12, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[57]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[58]);
                    			}

                    a13=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_context_HyContextualInformationBoolean1166); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a13, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[59]);
                    				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[60]);
                    				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[61]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[62]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[63]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[64]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_eu_hyvar_context_HyContextualInformationBoolean_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_context_HyContextualInformationBoolean"



    // $ANTLR start "parse_eu_hyvar_context_HyContextualInformationEnum"
    // Hycontextinformation.g:1360:1: parse_eu_hyvar_context_HyContextualInformationEnum returns [eu.hyvar.context.HyContextualInformationEnum element = null] : a0= 'EnumContext(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= IDENTIFIER_TOKEN ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
    public final eu.hyvar.context.HyContextualInformationEnum parse_eu_hyvar_context_HyContextualInformationEnum() throws RecognitionException {
        eu.hyvar.context.HyContextualInformationEnum element =  null;

        int parse_eu_hyvar_context_HyContextualInformationEnum_StartIndex = input.index();

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

            // Hycontextinformation.g:1363:2: (a0= 'EnumContext(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= IDENTIFIER_TOKEN ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hycontextinformation.g:1364:2: a0= 'EnumContext(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= IDENTIFIER_TOKEN ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            a0=(Token)match(input,17,FOLLOW_17_in_parse_eu_hyvar_context_HyContextualInformationEnum1214); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[65]);
            	}

            // Hycontextinformation.g:1378:2: (a1= IDENTIFIER_TOKEN )
            // Hycontextinformation.g:1379:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_HyContextualInformationEnum1232); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[66]);
            	}

            a2=(Token)match(input,12,FOLLOW_12_in_parse_eu_hyvar_context_HyContextualInformationEnum1253); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[67]);
            	}

            // Hycontextinformation.g:1428:2: (a3= IDENTIFIER_TOKEN )
            // Hycontextinformation.g:1429:3: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_HyContextualInformationEnum1271); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__ENUM_TYPE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContextDependentURIFragmentFactory<eu.hyvar.context.HyContextualInformationEnum, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextualInformationEnumEnumTypeReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__ENUM_TYPE), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__ENUM_TYPE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_3, proxy, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            				copyLocalizationInfos((CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[68]);
            	}

            a4=(Token)match(input,11,FOLLOW_11_in_parse_eu_hyvar_context_HyContextualInformationEnum1292); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[69]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[70]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[71]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[72]);
            	}

            // Hycontextinformation.g:1485:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Hycontextinformation.g:1486:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hycontextinformation.g:1486:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hycontextinformation.g:1487:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_context_HyContextualInformationEnum1315); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[73]);
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[74]);
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[75]);
                    			}

                    // Hycontextinformation.g:1503:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) )
                    int alt7=3;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==DATE) ) {
                        int LA7_1 = input.LA(2);

                        if ( (LA7_1==13) ) {
                            int LA7_3 = input.LA(3);

                            if ( (LA7_3==DATE) ) {
                                alt7=1;
                            }
                            else if ( (LA7_3==24) ) {
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
                    else if ( (LA7_0==24) ) {
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
                            // Hycontextinformation.g:1504:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hycontextinformation.g:1504:5: (a6= DATE )
                            // Hycontextinformation.g:1505:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationEnum1348); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a6 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a6).getLine(), ((CommonToken) a6).getCharPositionInLine(), ((CommonToken) a6).getStartIndex(), ((CommonToken) a6).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a6, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[76]);
                            				}

                            a7=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationEnum1387); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[77]);
                            				}

                            // Hycontextinformation.g:1554:5: (a8= DATE )
                            // Hycontextinformation.g:1555:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationEnum1417); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[78]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hycontextinformation.g:1591:10: (a9= DATE ) a10= '-' a11= 'null'
                            {
                            // Hycontextinformation.g:1591:10: (a9= DATE )
                            // Hycontextinformation.g:1592:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationEnum1473); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a9 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a9).getLine(), ((CommonToken) a9).getCharPositionInLine(), ((CommonToken) a9).getStartIndex(), ((CommonToken) a9).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a9, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[79]);
                            				}

                            a10=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationEnum1512); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a10, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[80]);
                            				}

                            a11=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_context_HyContextualInformationEnum1535); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a11, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[81]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hycontextinformation.g:1656:10: a12= 'null' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_context_HyContextualInformationEnum1568); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[82]);
                            				}

                            a13=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationEnum1591); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[83]);
                            				}

                            // Hycontextinformation.g:1684:5: (a14= DATE )
                            // Hycontextinformation.g:1685:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationEnum1621); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a14 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a14).getLine(), ((CommonToken) a14).getCharPositionInLine(), ((CommonToken) a14).getStartIndex(), ((CommonToken) a14).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.HyContextInformationPackage.HY_CONTEXTUAL_INFORMATION_ENUM__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a14, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[84]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[85]);
                    			}

                    a15=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_context_HyContextualInformationEnum1673); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a15, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[86]);
                    				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[87]);
                    				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[88]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[89]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[90]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[91]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_eu_hyvar_context_HyContextualInformationEnum_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_context_HyContextualInformationEnum"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnum"
    // Hycontextinformation.g:1753:1: parse_eu_hyvar_dataValues_HyEnum returns [eu.hyvar.dataValues.HyEnum element = null] : a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' ) )? ;
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
        Token a17=null;
        eu.hyvar.dataValues.HyEnumLiteral a3_0 =null;

        eu.hyvar.dataValues.HyEnumLiteral a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Hycontextinformation.g:1756:2: (a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' ) )? )
            // Hycontextinformation.g:1757:2: a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' ) )?
            {
            a0=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum1721); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[92]);
            	}

            // Hycontextinformation.g:1771:2: (a1= IDENTIFIER_TOKEN )
            // Hycontextinformation.g:1772:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum1739); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[93]);
            	}

            a2=(Token)match(input,12,FOLLOW_12_in_parse_eu_hyvar_dataValues_HyEnum1760); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[94]);
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[95]);
            	}

            // Hycontextinformation.g:1822:2: ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Hycontextinformation.g:1823:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    {
                    // Hycontextinformation.g:1823:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    // Hycontextinformation.g:1824:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    {
                    // Hycontextinformation.g:1824:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    // Hycontextinformation.g:1825:5: a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1789);
                    a3_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
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
                    						retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[96]);
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[97]);
                    			}

                    // Hycontextinformation.g:1851:4: ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==12) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // Hycontextinformation.g:1852:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    {
                    	    // Hycontextinformation.g:1852:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    // Hycontextinformation.g:1853:6: a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    {
                    	    a4=(Token)match(input,12,FOLLOW_12_in_parse_eu_hyvar_dataValues_HyEnum1830); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((CommonToken)a4, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[98]);
                    	    					}

                    	    // Hycontextinformation.g:1867:6: (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    // Hycontextinformation.g:1868:7: a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1864);
                    	    a5_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    							if (terminateParsing) {
                    	    								throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
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
                    	    								retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_1, a5_0, true);
                    	    								copyLocalizationInfos(a5_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[99]);
                    	    						addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[100]);
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
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[101]);
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[102]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[103]);
            	}

            a6=(Token)match(input,11,FOLLOW_11_in_parse_eu_hyvar_dataValues_HyEnum1938); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[104]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[105]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[106]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[107]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[108]);
            	}

            // Hycontextinformation.g:1927:2: ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // Hycontextinformation.g:1928:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' )
                    {
                    // Hycontextinformation.g:1928:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']' )
                    // Hycontextinformation.g:1929:4: a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) ) a17= ']'
                    {
                    a7=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1961); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a7, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[109]);
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[110]);
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[111]);
                    			}

                    // Hycontextinformation.g:1945:4: ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' a13= 'null' |a14= 'null' a15= '-' (a16= DATE ) )
                    int alt11=3;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==DATE) ) {
                        int LA11_1 = input.LA(2);

                        if ( (LA11_1==13) ) {
                            int LA11_3 = input.LA(3);

                            if ( (LA11_3==DATE) ) {
                                alt11=1;
                            }
                            else if ( (LA11_3==24) ) {
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
                    else if ( (LA11_0==24) ) {
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
                            // Hycontextinformation.g:1946:5: (a8= DATE ) a9= '-' (a10= DATE )
                            {
                            // Hycontextinformation.g:1946:5: (a8= DATE )
                            // Hycontextinformation.g:1947:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1994); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[112]);
                            				}

                            a9=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnum2033); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[113]);
                            				}

                            // Hycontextinformation.g:1996:5: (a10= DATE )
                            // Hycontextinformation.g:1997:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum2063); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a10 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a10, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[114]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hycontextinformation.g:2033:10: (a11= DATE ) a12= '-' a13= 'null'
                            {
                            // Hycontextinformation.g:2033:10: (a11= DATE )
                            // Hycontextinformation.g:2034:6: a11= DATE
                            {
                            a11=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum2119); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a11 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a11, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[115]);
                            				}

                            a12=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnum2158); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[116]);
                            				}

                            a13=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_dataValues_HyEnum2181); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[117]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hycontextinformation.g:2098:10: a14= 'null' a15= '-' (a16= DATE )
                            {
                            a14=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_dataValues_HyEnum2214); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a14, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[118]);
                            				}

                            a15=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnum2237); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a15, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[119]);
                            				}

                            // Hycontextinformation.g:2126:5: (a16= DATE )
                            // Hycontextinformation.g:2127:6: a16= DATE
                            {
                            a16=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum2267); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a16 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a16.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a16).getLine(), ((CommonToken) a16).getCharPositionInLine(), ((CommonToken) a16).getStartIndex(), ((CommonToken) a16).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a16, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[120]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[121]);
                    			}

                    a17=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum2319); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a17, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[122]);
                    				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[123]);
                    				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[124]);
                    				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[125]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[126]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[127]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[128]);
            		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[129]);
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
    // Hycontextinformation.g:2197:1: parse_eu_hyvar_dataValues_HyEnumLiteral returns [eu.hyvar.dataValues.HyEnumLiteral element = null] : a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
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

            // Hycontextinformation.g:2200:2: (a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Hycontextinformation.g:2201:2: a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            a0=(Token)match(input,18,FOLLOW_18_in_parse_eu_hyvar_dataValues_HyEnumLiteral2367); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[130]);
            	}

            // Hycontextinformation.g:2215:2: (a1= IDENTIFIER_TOKEN )
            // Hycontextinformation.g:2216:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral2385); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[131]);
            	}

            a2=(Token)match(input,12,FOLLOW_12_in_parse_eu_hyvar_dataValues_HyEnumLiteral2406); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[132]);
            	}

            // Hycontextinformation.g:2265:2: (a3= INTEGER_LITERAL )
            // Hycontextinformation.g:2266:3: a3= INTEGER_LITERAL
            {
            a3=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral2424); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_3, resolved, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[133]);
            	}

            a4=(Token)match(input,11,FOLLOW_11_in_parse_eu_hyvar_dataValues_HyEnumLiteral2445); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[134]);
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[135]);
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[136]);
            	}

            // Hycontextinformation.g:2317:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Hycontextinformation.g:2318:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Hycontextinformation.g:2318:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Hycontextinformation.g:2319:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral2468); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[137]);
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[138]);
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[139]);
                    			}

                    // Hycontextinformation.g:2335:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'null' |a12= 'null' a13= '-' (a14= DATE ) )
                    int alt13=3;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==DATE) ) {
                        int LA13_1 = input.LA(2);

                        if ( (LA13_1==13) ) {
                            int LA13_3 = input.LA(3);

                            if ( (LA13_3==DATE) ) {
                                alt13=1;
                            }
                            else if ( (LA13_3==24) ) {
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
                    else if ( (LA13_0==24) ) {
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
                            // Hycontextinformation.g:2336:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Hycontextinformation.g:2336:5: (a6= DATE )
                            // Hycontextinformation.g:2337:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2501); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a6 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a6, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[140]);
                            				}

                            a7=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnumLiteral2540); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[141]);
                            				}

                            // Hycontextinformation.g:2386:5: (a8= DATE )
                            // Hycontextinformation.g:2387:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2570); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[142]);
                            				}

                            }
                            break;
                        case 2 :
                            // Hycontextinformation.g:2423:10: (a9= DATE ) a10= '-' a11= 'null'
                            {
                            // Hycontextinformation.g:2423:10: (a9= DATE )
                            // Hycontextinformation.g:2424:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2626); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a9 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a9, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[143]);
                            				}

                            a10=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnumLiteral2665); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a10, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[144]);
                            				}

                            a11=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_dataValues_HyEnumLiteral2688); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a11, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[145]);
                            				}

                            }
                            break;
                        case 3 :
                            // Hycontextinformation.g:2488:10: a12= 'null' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,24,FOLLOW_24_in_parse_eu_hyvar_dataValues_HyEnumLiteral2721); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[146]);
                            				}

                            a13=(Token)match(input,13,FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnumLiteral2744); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[147]);
                            				}

                            // Hycontextinformation.g:2516:5: (a14= DATE )
                            // Hycontextinformation.g:2517:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2774); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a14 != null) {
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a14, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[148]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[149]);
                    			}

                    a15=(Token)match(input,21,FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral2826); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a15, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[150]);
                    				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[151]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[152]);
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[153]);
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



    // $ANTLR start "parseop_HyValue_level_15"
    // Hycontextinformation.g:2583:1: parseop_HyValue_level_15 returns [eu.hyvar.dataValues.HyValue element = null] : (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue );
    public final eu.hyvar.dataValues.HyValue parseop_HyValue_level_15() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parseop_HyValue_level_15_StartIndex = input.index();

        eu.hyvar.dataValues.HyNumberValue c0 =null;

        eu.hyvar.dataValues.HyBooleanValue c1 =null;

        eu.hyvar.dataValues.HyEnumValue c2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Hycontextinformation.g:2586:2: (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue )
            int alt15=3;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
                {
                alt15=1;
                }
                break;
            case 23:
            case 25:
                {
                alt15=2;
                }
                break;
            case 22:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // Hycontextinformation.g:2587:2: c0= parse_eu_hyvar_dataValues_HyNumberValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_152874);
                    c0=parse_eu_hyvar_dataValues_HyNumberValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hycontextinformation.g:2588:4: c1= parse_eu_hyvar_dataValues_HyBooleanValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_152884);
                    c1=parse_eu_hyvar_dataValues_HyBooleanValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hycontextinformation.g:2589:4: c2= parse_eu_hyvar_dataValues_HyEnumValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_152894);
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
            if ( state.backtracking>0 ) { memoize(input, 8, parseop_HyValue_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyValue_level_15"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyNumberValue"
    // Hycontextinformation.g:2592:1: parse_eu_hyvar_dataValues_HyNumberValue returns [eu.hyvar.dataValues.HyNumberValue element = null] : (a0= INTEGER_LITERAL ) ;
    public final eu.hyvar.dataValues.HyNumberValue parse_eu_hyvar_dataValues_HyNumberValue() throws RecognitionException {
        eu.hyvar.dataValues.HyNumberValue element =  null;

        int parse_eu_hyvar_dataValues_HyNumberValue_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Hycontextinformation.g:2595:2: ( (a0= INTEGER_LITERAL ) )
            // Hycontextinformation.g:2596:2: (a0= INTEGER_LITERAL )
            {
            // Hycontextinformation.g:2596:2: (a0= INTEGER_LITERAL )
            // Hycontextinformation.g:2597:3: a0= INTEGER_LITERAL
            {
            a0=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue2921); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyNumberValue();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_0_0_0_0, resolved, true);
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
            if ( state.backtracking>0 ) { memoize(input, 9, parse_eu_hyvar_dataValues_HyNumberValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyNumberValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyBooleanValue"
    // Hycontextinformation.g:2633:1: parse_eu_hyvar_dataValues_HyBooleanValue returns [eu.hyvar.dataValues.HyBooleanValue element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.dataValues.HyBooleanValue parse_eu_hyvar_dataValues_HyBooleanValue() throws RecognitionException {
        eu.hyvar.dataValues.HyBooleanValue element =  null;

        int parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Hycontextinformation.g:2636:2: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Hycontextinformation.g:2637:2: ( (a0= 'true' |a1= 'false' ) )
            {
            // Hycontextinformation.g:2637:2: ( (a0= 'true' |a1= 'false' ) )
            // Hycontextinformation.g:2638:3: (a0= 'true' |a1= 'false' )
            {
            // Hycontextinformation.g:2638:3: (a0= 'true' |a1= 'false' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                alt16=1;
            }
            else if ( (LA16_0==23) ) {
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
                    // Hycontextinformation.g:2639:4: a0= 'true'
                    {
                    a0=(Token)match(input,25,FOLLOW_25_in_parse_eu_hyvar_dataValues_HyBooleanValue2966); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_1_0_0_0, true, true);
                    				copyLocalizationInfos((CommonToken)a0, element);
                    				// set value of boolean attribute
                    				Object value = true;
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Hycontextinformation.g:2652:8: a1= 'false'
                    {
                    a1=(Token)match(input,23,FOLLOW_23_in_parse_eu_hyvar_dataValues_HyBooleanValue2981); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_1_0_0_0, false, true);
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
            if ( state.backtracking>0 ) { memoize(input, 10, parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyBooleanValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumValue"
    // Hycontextinformation.g:2673:1: parse_eu_hyvar_dataValues_HyEnumValue returns [eu.hyvar.dataValues.HyEnumValue element = null] : a0= 'enum:' (a1= IDENTIFIER_TOKEN ) a2= '.' (a3= IDENTIFIER_TOKEN ) ;
    public final eu.hyvar.dataValues.HyEnumValue parse_eu_hyvar_dataValues_HyEnumValue() throws RecognitionException {
        eu.hyvar.dataValues.HyEnumValue element =  null;

        int parse_eu_hyvar_dataValues_HyEnumValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Hycontextinformation.g:2676:2: (a0= 'enum:' (a1= IDENTIFIER_TOKEN ) a2= '.' (a3= IDENTIFIER_TOKEN ) )
            // Hycontextinformation.g:2677:2: a0= 'enum:' (a1= IDENTIFIER_TOKEN ) a2= '.' (a3= IDENTIFIER_TOKEN )
            {
            a0=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue3017); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[154]);
            	}

            // Hycontextinformation.g:2691:2: (a1= IDENTIFIER_TOKEN )
            // Hycontextinformation.g:2692:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3035); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_2_0_0_1, proxy, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            				copyLocalizationInfos((CommonToken) a1, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[155]);
            	}

            a2=(Token)match(input,14,FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnumValue3056); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[156]);
            	}

            // Hycontextinformation.g:2745:2: (a3= IDENTIFIER_TOKEN )
            // Hycontextinformation.g:2746:3: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3074); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_2_0_0_3, proxy, true);
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
            if ( state.backtracking>0 ) { memoize(input, 11, parse_eu_hyvar_dataValues_HyEnumValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumValue"



    // $ANTLR start "parse_eu_hyvar_context_HyContextualInformation"
    // Hycontextinformation.g:2786:1: parse_eu_hyvar_context_HyContextualInformation returns [eu.hyvar.context.HyContextualInformation element = null] : (c0= parse_eu_hyvar_context_HyContextualInformationNumber |c1= parse_eu_hyvar_context_HyContextualInformationBoolean |c2= parse_eu_hyvar_context_HyContextualInformationEnum );
    public final eu.hyvar.context.HyContextualInformation parse_eu_hyvar_context_HyContextualInformation() throws RecognitionException {
        eu.hyvar.context.HyContextualInformation element =  null;

        int parse_eu_hyvar_context_HyContextualInformation_StartIndex = input.index();

        eu.hyvar.context.HyContextualInformationNumber c0 =null;

        eu.hyvar.context.HyContextualInformationBoolean c1 =null;

        eu.hyvar.context.HyContextualInformationEnum c2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Hycontextinformation.g:2787:2: (c0= parse_eu_hyvar_context_HyContextualInformationNumber |c1= parse_eu_hyvar_context_HyContextualInformationBoolean |c2= parse_eu_hyvar_context_HyContextualInformationEnum )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt17=1;
                }
                break;
            case 15:
                {
                alt17=2;
                }
                break;
            case 17:
                {
                alt17=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // Hycontextinformation.g:2788:2: c0= parse_eu_hyvar_context_HyContextualInformationNumber
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_context_HyContextualInformationNumber_in_parse_eu_hyvar_context_HyContextualInformation3106);
                    c0=parse_eu_hyvar_context_HyContextualInformationNumber();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Hycontextinformation.g:2789:4: c1= parse_eu_hyvar_context_HyContextualInformationBoolean
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_context_HyContextualInformationBoolean_in_parse_eu_hyvar_context_HyContextualInformation3116);
                    c1=parse_eu_hyvar_context_HyContextualInformationBoolean();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Hycontextinformation.g:2790:4: c2= parse_eu_hyvar_context_HyContextualInformationEnum
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_context_HyContextualInformationEnum_in_parse_eu_hyvar_context_HyContextualInformation3126);
                    c2=parse_eu_hyvar_context_HyContextualInformationEnum();

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
            if ( state.backtracking>0 ) { memoize(input, 12, parse_eu_hyvar_context_HyContextualInformation_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_context_HyContextualInformation"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_eu_hyvar_context_HyContextModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnum_in_parse_eu_hyvar_context_HyContextModel124 = new BitSet(new long[]{0x00000000000B8002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_context_HyContextualInformation_in_parse_eu_hyvar_context_HyContextModel159 = new BitSet(new long[]{0x00000000000A8002L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_context_HyContextualInformationNumber200 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_HyContextualInformationNumber218 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_eu_hyvar_context_HyContextualInformationNumber239 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_context_HyContextualInformationNumber257 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_eu_hyvar_context_HyContextualInformationNumber278 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_context_HyContextualInformationNumber296 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_eu_hyvar_context_HyContextualInformationNumber317 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_context_HyContextualInformationNumber340 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationNumber373 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationNumber412 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationNumber442 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationNumber498 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationNumber537 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_context_HyContextualInformationNumber560 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_context_HyContextualInformationNumber593 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationNumber616 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationNumber646 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_context_HyContextualInformationNumber698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_context_HyContextualInformationBoolean746 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_HyContextualInformationBoolean764 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_eu_hyvar_context_HyContextualInformationBoolean785 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_context_HyContextualInformationBoolean808 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationBoolean841 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationBoolean880 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationBoolean910 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationBoolean966 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationBoolean1005 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_context_HyContextualInformationBoolean1028 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_context_HyContextualInformationBoolean1061 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationBoolean1084 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationBoolean1114 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_context_HyContextualInformationBoolean1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_eu_hyvar_context_HyContextualInformationEnum1214 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_HyContextualInformationEnum1232 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_eu_hyvar_context_HyContextualInformationEnum1253 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_context_HyContextualInformationEnum1271 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_eu_hyvar_context_HyContextualInformationEnum1292 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_context_HyContextualInformationEnum1315 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationEnum1348 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationEnum1387 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationEnum1417 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationEnum1473 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationEnum1512 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_context_HyContextualInformationEnum1535 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_context_HyContextualInformationEnum1568 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_context_HyContextualInformationEnum1591 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_context_HyContextualInformationEnum1621 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_context_HyContextualInformationEnum1673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum1721 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum1739 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_eu_hyvar_dataValues_HyEnum1760 = new BitSet(new long[]{0x0000000000040800L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1789 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_12_in_parse_eu_hyvar_dataValues_HyEnum1830 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1864 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_11_in_parse_eu_hyvar_dataValues_HyEnum1938 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1961 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1994 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnum2033 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum2063 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum2119 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnum2158 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_dataValues_HyEnum2181 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_dataValues_HyEnum2214 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnum2237 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum2267 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnum2319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_parse_eu_hyvar_dataValues_HyEnumLiteral2367 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral2385 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_eu_hyvar_dataValues_HyEnumLiteral2406 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral2424 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_eu_hyvar_dataValues_HyEnumLiteral2445 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral2468 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2501 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnumLiteral2540 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2570 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2626 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnumLiteral2665 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_dataValues_HyEnumLiteral2688 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_24_in_parse_eu_hyvar_dataValues_HyEnumLiteral2721 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_eu_hyvar_dataValues_HyEnumLiteral2744 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral2774 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_eu_hyvar_dataValues_HyEnumLiteral2826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_152874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_152884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_152894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue2921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_parse_eu_hyvar_dataValues_HyBooleanValue2966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_eu_hyvar_dataValues_HyBooleanValue2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue3017 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3035 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_eu_hyvar_dataValues_HyEnumValue3056 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_context_HyContextualInformationNumber_in_parse_eu_hyvar_context_HyContextualInformation3106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_context_HyContextualInformationBoolean_in_parse_eu_hyvar_context_HyContextualInformation3116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_context_HyContextualInformationEnum_in_parse_eu_hyvar_context_HyContextualInformation3126 = new BitSet(new long[]{0x0000000000000002L});

}