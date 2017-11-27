// $ANTLR 3.4

	package de.darwinspl.preferences.resource.dwprofile.mopp;
	
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
public class DwprofileParser extends DwprofileANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DATE", "IDENTIFIER_TOKEN", "INTEGER_LITERAL", "LINEBREAK", "ML_COMMENT", "QUOTED_34_34", "SL_COMMENT", "WHITESPACE", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'->'", "'.'", "'/'", "'<'", "'<->'", "'<='", "'='", "'>'", "'>='", "'?'", "'Enum('", "'EnumLiteral('", "'['", "'\\u0025'", "']'", "'^'", "'context:'", "'enum:'", "'eternity'", "'false'", "'ifPossible('", "'max('", "'min('", "'true'", "'||'"
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
    public static final int DATE=4;
    public static final int IDENTIFIER_TOKEN=5;
    public static final int INTEGER_LITERAL=6;
    public static final int LINEBREAK=7;
    public static final int ML_COMMENT=8;
    public static final int QUOTED_34_34=9;
    public static final int SL_COMMENT=10;
    public static final int WHITESPACE=11;

    // delegates
    public DwprofileANTLRParserBase[] getDelegates() {
        return new DwprofileANTLRParserBase[] {};
    }

    // delegators


    public DwprofileParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public DwprofileParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(98 + 1);
         

    }

    public String[] getTokenNames() { return DwprofileParser.tokenNames; }
    public String getGrammarFileName() { return "Dwprofile.g"; }


    	private de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolverFactory tokenResolverFactory = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTokenResolverFactory();
    	
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
    	private List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> expectedElements = new ArrayList<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal>();
    	
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
    	
    	private de.darwinspl.preferences.resource.dwprofile.IDwprofileLocationMap locationMap;
    	
    	private de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileSyntaxErrorMessageConverter syntaxErrorMessageConverter = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileSyntaxErrorMessageConverter(tokenNames);
    	
    	@Override
    	public void reportError(RecognitionException re) {
    		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
    	}
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new de.darwinspl.preferences.resource.dwprofile.IDwprofileCommand<de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource>() {
    			public boolean execute(de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new de.darwinspl.preferences.resource.dwprofile.IDwprofileProblem() {
    					public de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemSeverity getSeverity() {
    						return de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemSeverity.ERROR;
    					}
    					public de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemType getType() {
    						return de.darwinspl.preferences.resource.dwprofile.DwprofileEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	protected void addErrorToResource(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileLocalizedMessage message) {
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
    		de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement terminal = de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileFollowSetProvider.TERMINALS[terminalID];
    		de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature[] containmentFeatures = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileFollowSetProvider.LINKS[ids[i]];
    		}
    		de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainmentTrace containmentTrace = new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainmentTrace(eClass, containmentFeatures);
    		EObject container = getLastIncompleteElement();
    		de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedElement = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		final de.darwinspl.preferences.resource.dwprofile.IDwprofileLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new de.darwinspl.preferences.resource.dwprofile.IDwprofileCommand<de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource>() {
    			public boolean execute(de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource) {
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
    		final de.darwinspl.preferences.resource.dwprofile.IDwprofileLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new de.darwinspl.preferences.resource.dwprofile.IDwprofileCommand<de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource>() {
    			public boolean execute(de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource) {
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
    	protected void setLocalizationEnd(Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileCommand<de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		final de.darwinspl.preferences.resource.dwprofile.IDwprofileLocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new de.darwinspl.preferences.resource.dwprofile.IDwprofileCommand<de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource>() {
    			public boolean execute(de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource) {
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public de.darwinspl.preferences.resource.dwprofile.IDwprofileTextParser createInstance(InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new DwprofileParser(new CommonTokenStream(new DwprofileLexer(new ANTLRInputStream(actualInputStream))));
    			} else {
    				return new DwprofileParser(new CommonTokenStream(new DwprofileLexer(new ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (IOException e) {
    			new de.darwinspl.preferences.resource.dwprofile.util.DwprofileRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public DwprofileParser() {
    		super(null);
    	}
    	
    	protected EObject doParse() throws RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((DwprofileLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((DwprofileLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof EClass) {
    			EClass type = (EClass) typeObject;
    			if (type.getInstanceClass() == de.darwinspl.preferences.DwProfile.class) {
    				return parse_de_darwinspl_preferences_DwProfile();
    			}
    			if (type.getInstanceClass() == de.darwinspl.preferences.DwPreference.class) {
    				return parse_de_darwinspl_preferences_DwPreference();
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
    		throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileUnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(de.darwinspl.preferences.resource.dwprofile.IDwprofileOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public de.darwinspl.preferences.resource.dwprofile.IDwprofileParseResult parse() {
    		// Reset parser state
    		terminateParsing = false;
    		postParseCommands = new ArrayList<de.darwinspl.preferences.resource.dwprofile.IDwprofileCommand<de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource>>();
    		de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileParseResult parseResult = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileParseResult();
    		if (disableLocationMap) {
    			locationMap = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileDevNullLocationMap();
    		} else {
    			locationMap = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileLocationMap();
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
    	
    	public List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> parseToExpectedElements(EClass type, de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
    		de.darwinspl.preferences.resource.dwprofile.IDwprofileParseResult result = parse();
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
    			for (de.darwinspl.preferences.resource.dwprofile.IDwprofileCommand<de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		Set<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> currentFollowSet = new LinkedHashSet<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal>();
    		List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> newFollowSet = new ArrayList<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 129;
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
    				for (de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						Collection<de.darwinspl.preferences.resource.dwprofile.util.DwprofilePair<de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (de.darwinspl.preferences.resource.dwprofile.util.DwprofilePair<de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature[]> newFollowerPair : newFollowers) {
    							de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement newFollower = newFollowerPair.getLeft();
    							EObject container = getLastIncompleteElement();
    							de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainmentTrace containmentTrace = new de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainmentTrace(null, newFollowerPair.getRight());
    							de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal newFollowTerminal = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedElement, int tokenIndex) {
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
    // Dwprofile.g:496:1: start returns [ EObject element = null] : (c0= parse_de_darwinspl_preferences_DwProfile ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        de.darwinspl.preferences.DwProfile c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Dwprofile.g:497:2: ( (c0= parse_de_darwinspl_preferences_DwProfile ) EOF )
            // Dwprofile.g:498:2: (c0= parse_de_darwinspl_preferences_DwProfile ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[2]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[3]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[4]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[6]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[7]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[8]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[9]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[10]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[11]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[12]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[13]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[14]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[15]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Dwprofile.g:518:2: (c0= parse_de_darwinspl_preferences_DwProfile )
            // Dwprofile.g:519:3: c0= parse_de_darwinspl_preferences_DwProfile
            {
            pushFollow(FOLLOW_parse_de_darwinspl_preferences_DwProfile_in_start82);
            c0=parse_de_darwinspl_preferences_DwProfile();

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



    // $ANTLR start "parse_de_darwinspl_preferences_DwProfile"
    // Dwprofile.g:527:1: parse_de_darwinspl_preferences_DwProfile returns [de.darwinspl.preferences.DwProfile element = null] : ( (a0_0= parse_de_darwinspl_preferences_DwPreference ) )* ;
    public final de.darwinspl.preferences.DwProfile parse_de_darwinspl_preferences_DwProfile() throws RecognitionException {
        de.darwinspl.preferences.DwProfile element =  null;

        int parse_de_darwinspl_preferences_DwProfile_StartIndex = input.index();

        de.darwinspl.preferences.DwPreference a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Dwprofile.g:530:2: ( ( (a0_0= parse_de_darwinspl_preferences_DwPreference ) )* )
            // Dwprofile.g:531:2: ( (a0_0= parse_de_darwinspl_preferences_DwPreference ) )*
            {
            // Dwprofile.g:531:2: ( (a0_0= parse_de_darwinspl_preferences_DwPreference ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= IDENTIFIER_TOKEN && LA1_0 <= INTEGER_LITERAL)||LA1_0==QUOTED_34_34||LA1_0==12||LA1_0==15||LA1_0==20||LA1_0==30||(LA1_0 >= 37 && LA1_0 <= 38)||(LA1_0 >= 40 && LA1_0 <= 44)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Dwprofile.g:532:3: (a0_0= parse_de_darwinspl_preferences_DwPreference )
            	    {
            	    // Dwprofile.g:532:3: (a0_0= parse_de_darwinspl_preferences_DwPreference )
            	    // Dwprofile.g:533:4: a0_0= parse_de_darwinspl_preferences_DwPreference
            	    {
            	    pushFollow(FOLLOW_parse_de_darwinspl_preferences_DwPreference_in_parse_de_darwinspl_preferences_DwProfile124);
            	    a0_0=parse_de_darwinspl_preferences_DwPreference();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwProfile();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a0_0 != null) {
            	    					if (a0_0 != null) {
            	    						Object value = a0_0;
            	    						addObjectToList(element, de.darwinspl.preferences.PreferencesPackage.DW_PROFILE__PREFERENCES, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_0_0_0_0, a0_0, true);
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
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[16]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[17]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[18]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[19]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[20]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[21]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[22]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[23]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[24]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[25]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[27]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[28]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[29]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[30]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[31]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_de_darwinspl_preferences_DwProfile_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_de_darwinspl_preferences_DwProfile"



    // $ANTLR start "parse_de_darwinspl_preferences_DwPreference"
    // Dwprofile.g:576:1: parse_de_darwinspl_preferences_DwPreference returns [de.darwinspl.preferences.DwPreference element = null] : (a0_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )? ;
    public final de.darwinspl.preferences.DwPreference parse_de_darwinspl_preferences_DwPreference() throws RecognitionException {
        de.darwinspl.preferences.DwPreference element =  null;

        int parse_de_darwinspl_preferences_DwPreference_StartIndex = input.index();

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

            // Dwprofile.g:579:2: ( (a0_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )? )
            // Dwprofile.g:580:2: (a0_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )?
            {
            // Dwprofile.g:580:2: (a0_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Dwprofile.g:581:3: a0_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_de_darwinspl_preferences_DwPreference169);
            a0_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
            			}
            			if (element == null) {
            				element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					element.eSet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__ROOT_EXPRESSION), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[32]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[33]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[34]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[35]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[36]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[37]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[38]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[39]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[40]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[41]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[42]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[43]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[44]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[45]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[46]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[47]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[48]);
            	}

            // Dwprofile.g:622:2: ( (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==33) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Dwprofile.g:623:3: (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' )
                    {
                    // Dwprofile.g:623:3: (a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']' )
                    // Dwprofile.g:624:4: a1= '[' ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) ) a11= ']'
                    {
                    a1=(Token)match(input,33,FOLLOW_33_in_parse_de_darwinspl_preferences_DwPreference196); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[49]);
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[50]);
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[51]);
                    			}

                    // Dwprofile.g:640:4: ( (a2= DATE ) a3= '-' (a4= DATE ) | (a5= DATE ) a6= '-' a7= 'eternity' |a8= 'eternity' a9= '-' (a10= DATE ) )
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
                            // Dwprofile.g:641:5: (a2= DATE ) a3= '-' (a4= DATE )
                            {
                            // Dwprofile.g:641:5: (a2= DATE )
                            // Dwprofile.g:642:6: a2= DATE
                            {
                            a2=(Token)match(input,DATE,FOLLOW_DATE_in_parse_de_darwinspl_preferences_DwPreference229); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
                            							startIncompleteElement(element);
                            						}
                            						if (a2 != null) {
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a2, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[52]);
                            				}

                            a3=(Token)match(input,20,FOLLOW_20_in_parse_de_darwinspl_preferences_DwPreference268); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a3, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[53]);
                            				}

                            // Dwprofile.g:691:5: (a4= DATE )
                            // Dwprofile.g:692:6: a4= DATE
                            {
                            a4=(Token)match(input,DATE,FOLLOW_DATE_in_parse_de_darwinspl_preferences_DwPreference298); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
                            							startIncompleteElement(element);
                            						}
                            						if (a4 != null) {
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a4, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[54]);
                            				}

                            }
                            break;
                        case 2 :
                            // Dwprofile.g:728:10: (a5= DATE ) a6= '-' a7= 'eternity'
                            {
                            // Dwprofile.g:728:10: (a5= DATE )
                            // Dwprofile.g:729:6: a5= DATE
                            {
                            a5=(Token)match(input,DATE,FOLLOW_DATE_in_parse_de_darwinspl_preferences_DwPreference354); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
                            							startIncompleteElement(element);
                            						}
                            						if (a5 != null) {
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_SINCE), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_SINCE), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a5, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[55]);
                            				}

                            a6=(Token)match(input,20,FOLLOW_20_in_parse_de_darwinspl_preferences_DwPreference393); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a6, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[56]);
                            				}

                            a7=(Token)match(input,39,FOLLOW_39_in_parse_de_darwinspl_preferences_DwPreference416); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[57]);
                            				}

                            }
                            break;
                        case 3 :
                            // Dwprofile.g:793:10: a8= 'eternity' a9= '-' (a10= DATE )
                            {
                            a8=(Token)match(input,39,FOLLOW_39_in_parse_de_darwinspl_preferences_DwPreference449); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a8, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[58]);
                            				}

                            a9=(Token)match(input,20,FOLLOW_20_in_parse_de_darwinspl_preferences_DwPreference472); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[59]);
                            				}

                            // Dwprofile.g:821:5: (a10= DATE )
                            // Dwprofile.g:822:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_de_darwinspl_preferences_DwPreference502); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
                            							startIncompleteElement(element);
                            						}
                            						if (a10 != null) {
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                            							tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_UNTIL), result);
                            							Object resolvedObject = result.getResolvedToken();
                            							if (resolvedObject == null) {
                            								addErrorToResource(result.getErrorMessage(), ((CommonToken) a10).getLine(), ((CommonToken) a10).getCharPositionInLine(), ((CommonToken) a10).getStartIndex(), ((CommonToken) a10).getStopIndex());
                            							}
                            							java.util.Date resolved = (java.util.Date) resolvedObject;
                            							if (resolved != null) {
                            								Object value = resolved;
                            								element.eSet(element.eClass().getEStructuralFeature(de.darwinspl.preferences.PreferencesPackage.DW_PREFERENCE__VALID_UNTIL), value);
                            								completedElement(value, false);
                            							}
                            							collectHiddenTokens(element);
                            							retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a10, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[60]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[61]);
                    			}

                    a11=(Token)match(input,35,FOLLOW_35_in_parse_de_darwinspl_preferences_DwPreference554); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a11, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[62]);
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[63]);
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[64]);
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[65]);
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[66]);
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[67]);
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[68]);
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[69]);
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[70]);
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[71]);
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[72]);
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[73]);
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[74]);
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[75]);
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[76]);
                    				addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[77]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[78]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[79]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[80]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[81]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[82]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[83]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[84]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[85]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[86]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[87]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[88]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[89]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[90]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[91]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[92]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[93]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_de_darwinspl_preferences_DwPreference_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_de_darwinspl_preferences_DwPreference"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction"
    // Dwprofile.g:916:1: parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction returns [eu.hyvar.feature.expression.HyRelativeVersionRestriction element = null] : a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' ;
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

            // Dwprofile.g:919:2: (a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']' )
            // Dwprofile.g:920:2: a0= '[' ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? ) (a8= QUOTED_34_34 ) a9= ']'
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
            		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_27_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[94]);
            	}

            // Dwprofile.g:937:2: ( (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )? )
            // Dwprofile.g:938:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
            {
            // Dwprofile.g:938:3: (a1= '<' |a2= '<=' |a3= '=' |a4= '>=' |a5= '>' )?
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
                    // Dwprofile.g:939:4: a1= '<'
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
                    				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 2 :
                    // Dwprofile.g:955:8: a2= '<='
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
                    				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a2, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 3 :
                    // Dwprofile.g:971:8: a3= '='
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
                    				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a3, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 4 :
                    // Dwprofile.g:987:8: a4= '>='
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
                    				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
                    				copyLocalizationInfos((CommonToken)a4, element);
                    				// set value of enumeration attribute
                    				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL_VALUE).getInstance();
                    				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
                    				completedElement(value, false);
                    			}

                    }
                    break;
                case 5 :
                    // Dwprofile.g:1003:8: a5= '>'
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
                    				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[95]);
            	}

            // Dwprofile.g:1025:2: (a8= QUOTED_34_34 )
            // Dwprofile.g:1026:3: a8= QUOTED_34_34
            {
            a8=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction710); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
            				startIncompleteElement(element);
            				// initialize enumeration attribute
            				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
            				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
            			}
            			if (a8 != null) {
            				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyRelativeVersionRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyRelativeVersionRestrictionVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_27_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a8, element);
            				copyLocalizationInfos((CommonToken) a8, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[96]);
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
            		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_27_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[97]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[98]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[99]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[100]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[101]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[102]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[103]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[104]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[105]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[106]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[107]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[108]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[109]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[110]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[111]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[112]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[113]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[114]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[115]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[116]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[117]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[118]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[119]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[120]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[121]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[122]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[123]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[124]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[125]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[126]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[127]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[128]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[129]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[130]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[131]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[132]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[133]);
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
    // Dwprofile.g:1123:1: parse_eu_hyvar_feature_expression_HyVersionRangeRestriction returns [eu.hyvar.feature.expression.HyVersionRangeRestriction element = null] : a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' ;
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

            // Dwprofile.g:1126:2: (a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']' )
            // Dwprofile.g:1127:2: a0= '[' ( (a1= '^' )? ) (a3= QUOTED_34_34 ) a4= '-' ( (a5= '^' )? ) (a7= QUOTED_34_34 ) a8= ']'
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
            		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_28_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[134]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[135]);
            	}

            // Dwprofile.g:1152:2: ( (a1= '^' )? )
            // Dwprofile.g:1153:3: (a1= '^' )?
            {
            // Dwprofile.g:1153:3: (a1= '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==36) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Dwprofile.g:1154:4: a1= '^'
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
                    				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_28_0_0_1, false, true);
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
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[136]);
            	}

            // Dwprofile.g:1183:2: (a3= QUOTED_34_34 )
            // Dwprofile.g:1184:3: a3= QUOTED_34_34
            {
            a3=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction808); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
            				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionLowerVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_28_0_0_2, proxy, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            				copyLocalizationInfos((CommonToken) a3, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[137]);
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
            		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_28_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[138]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[139]);
            	}

            // Dwprofile.g:1258:2: ( (a5= '^' )? )
            // Dwprofile.g:1259:3: (a5= '^' )?
            {
            // Dwprofile.g:1259:3: (a5= '^' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==36) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Dwprofile.g:1260:4: a5= '^'
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
                    				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_28_0_0_4, false, true);
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
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[140]);
            	}

            // Dwprofile.g:1289:2: (a7= QUOTED_34_34 )
            // Dwprofile.g:1290:3: a7= QUOTED_34_34
            {
            a7=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction877); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
            				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            				tokenResolver.setOptions(getOptions());
            				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
            				}
            				String resolved = (String) resolvedObject;
            				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
            				collectHiddenTokens(element);
            				registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionUpperVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), resolved, proxy);
            				if (proxy != null) {
            					Object value = proxy;
            					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_28_0_0_5, proxy, true);
            				copyLocalizationInfos((CommonToken) a7, element);
            				copyLocalizationInfos((CommonToken) a7, proxy);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[141]);
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
            		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_28_0_0_6, null, true);
            		copyLocalizationInfos((CommonToken)a8, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[142]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[143]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[144]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[145]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[146]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[147]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[148]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[149]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[150]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[151]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[152]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[153]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[154]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[155]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[156]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[157]);
            		addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[158]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[159]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[160]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[161]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[162]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[163]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[164]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[165]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[166]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[167]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[168]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[169]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[170]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[171]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[172]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[173]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[174]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[175]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[176]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[177]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[178]);
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
    // Dwprofile.g:1401:1: parse_eu_hyvar_dataValues_HyEnum returns [eu.hyvar.dataValues.HyEnum element = null] : a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? ;
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

            // Dwprofile.g:1404:2: (a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )? )
            // Dwprofile.g:1405:2: a0= 'Enum(' (a1= IDENTIFIER_TOKEN ) a2= ',' ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )? a6= ')' ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            {
            a0=(Token)match(input,31,FOLLOW_31_in_parse_eu_hyvar_dataValues_HyEnum927); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[179]);
            	}

            // Dwprofile.g:1419:2: (a1= IDENTIFIER_TOKEN )
            // Dwprofile.g:1420:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnum945); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[180]);
            	}

            a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum966); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[181]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[182]);
            	}

            // Dwprofile.g:1470:2: ( ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==32) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Dwprofile.g:1471:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    {
                    // Dwprofile.g:1471:3: ( (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )* )
                    // Dwprofile.g:1472:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    {
                    // Dwprofile.g:1472:4: (a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    // Dwprofile.g:1473:5: a3_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum995);
                    a3_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    						retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_0, a3_0, true);
                    						copyLocalizationInfos(a3_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[183]);
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[184]);
                    			}

                    // Dwprofile.g:1499:4: ( (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==19) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // Dwprofile.g:1500:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    {
                    	    // Dwprofile.g:1500:5: (a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral ) )
                    	    // Dwprofile.g:1501:6: a4= ',' (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    {
                    	    a4=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnum1036); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
                    	    						copyLocalizationInfos((CommonToken)a4, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[185]);
                    	    					}

                    	    // Dwprofile.g:1515:6: (a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral )
                    	    // Dwprofile.g:1516:7: a5_0= parse_eu_hyvar_dataValues_HyEnumLiteral
                    	    {
                    	    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumLiteral_in_parse_eu_hyvar_dataValues_HyEnum1070);
                    	    a5_0=parse_eu_hyvar_dataValues_HyEnumLiteral();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    							if (terminateParsing) {
                    	    								throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    								retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_1, a5_0, true);
                    	    								copyLocalizationInfos(a5_0, element);
                    	    							}
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[186]);
                    	    						addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[187]);
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
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[188]);
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[189]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[190]);
            	}

            a6=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnum1144); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[191]);
            	}

            // Dwprofile.g:1571:2: ( (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==33) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Dwprofile.g:1572:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    {
                    // Dwprofile.g:1572:3: (a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']' )
                    // Dwprofile.g:1573:4: a7= '[' ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) ) a16= ']'
                    {
                    a7=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnum1167); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a7, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[192]);
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[193]);
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[194]);
                    			}

                    // Dwprofile.g:1589:4: ( (a8= DATE ) a9= '-' (a10= DATE ) | (a11= DATE ) a12= '-' |a13= 'eternity' a14= '-' (a15= DATE ) )
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
                            // Dwprofile.g:1590:5: (a8= DATE ) a9= '-' (a10= DATE )
                            {
                            // Dwprofile.g:1590:5: (a8= DATE )
                            // Dwprofile.g:1591:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1200); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[195]);
                            				}

                            a9=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1239); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a9, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[196]);
                            				}

                            // Dwprofile.g:1640:5: (a10= DATE )
                            // Dwprofile.g:1641:6: a10= DATE
                            {
                            a10=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1269); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a10 != null) {
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a10, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[197]);
                            				}

                            }
                            break;
                        case 2 :
                            // Dwprofile.g:1677:10: (a11= DATE ) a12= '-'
                            {
                            // Dwprofile.g:1677:10: (a11= DATE )
                            // Dwprofile.g:1678:6: a11= DATE
                            {
                            a11=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1325); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a11 != null) {
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a11, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[198]);
                            				}

                            a12=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1364); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[199]);
                            				}

                            }
                            break;
                        case 3 :
                            // Dwprofile.g:1728:10: a13= 'eternity' a14= '-' (a15= DATE )
                            {
                            a13=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnum1397); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[200]);
                            				}

                            a14=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnum1420); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a14, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[201]);
                            				}

                            // Dwprofile.g:1756:5: (a15= DATE )
                            // Dwprofile.g:1757:6: a15= DATE
                            {
                            a15=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnum1450); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                            							startIncompleteElement(element);
                            						}
                            						if (a15 != null) {
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a15, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[202]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[203]);
                    			}

                    a16=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnum1502); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
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
            if ( state.backtracking>0 ) { memoize(input, 6, parse_eu_hyvar_dataValues_HyEnum_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnum"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumLiteral"
    // Dwprofile.g:1819:1: parse_eu_hyvar_dataValues_HyEnumLiteral returns [eu.hyvar.dataValues.HyEnumLiteral element = null] : a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? ;
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

            // Dwprofile.g:1822:2: (a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )? )
            // Dwprofile.g:1823:2: a0= 'EnumLiteral(' (a1= IDENTIFIER_TOKEN ) a2= ',' (a3= INTEGER_LITERAL ) a4= ')' ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            {
            a0=(Token)match(input,32,FOLLOW_32_in_parse_eu_hyvar_dataValues_HyEnumLiteral1550); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[204]);
            	}

            // Dwprofile.g:1837:2: (a1= IDENTIFIER_TOKEN )
            // Dwprofile.g:1838:3: a1= IDENTIFIER_TOKEN
            {
            a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumLiteral1568); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            				tokenResolver.setOptions(getOptions());
            				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[205]);
            	}

            a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_dataValues_HyEnumLiteral1589); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[206]);
            	}

            // Dwprofile.g:1887:2: (a3= INTEGER_LITERAL )
            // Dwprofile.g:1888:3: a3= INTEGER_LITERAL
            {
            a3=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyEnumLiteral1607); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
            			}
            			if (element == null) {
            				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            				tokenResolver.setOptions(getOptions());
            				de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_3, resolved, true);
            				copyLocalizationInfos((CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[207]);
            	}

            a4=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_dataValues_HyEnumLiteral1628); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[208]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[209]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[210]);
            	}

            // Dwprofile.g:1939:2: ( (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==33) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // Dwprofile.g:1940:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    {
                    // Dwprofile.g:1940:3: (a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']' )
                    // Dwprofile.g:1941:4: a5= '[' ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) ) a15= ']'
                    {
                    a5=(Token)match(input,33,FOLLOW_33_in_parse_eu_hyvar_dataValues_HyEnumLiteral1651); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[211]);
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[212]);
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[213]);
                    			}

                    // Dwprofile.g:1957:4: ( (a6= DATE ) a7= '-' (a8= DATE ) | (a9= DATE ) a10= '-' a11= 'eternity' |a12= 'eternity' a13= '-' (a14= DATE ) )
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
                            // Dwprofile.g:1958:5: (a6= DATE ) a7= '-' (a8= DATE )
                            {
                            // Dwprofile.g:1958:5: (a6= DATE )
                            // Dwprofile.g:1959:6: a6= DATE
                            {
                            a6=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1684); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a6 != null) {
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a6, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[214]);
                            				}

                            a7=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1723); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
                            					copyLocalizationInfos((CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[215]);
                            				}

                            // Dwprofile.g:2008:5: (a8= DATE )
                            // Dwprofile.g:2009:6: a8= DATE
                            {
                            a8=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1753); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a8 != null) {
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a8, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[216]);
                            				}

                            }
                            break;
                        case 2 :
                            // Dwprofile.g:2045:10: (a9= DATE ) a10= '-' a11= 'eternity'
                            {
                            // Dwprofile.g:2045:10: (a9= DATE )
                            // Dwprofile.g:2046:6: a9= DATE
                            {
                            a9=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1809); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a9 != null) {
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, resolved, true);
                            							copyLocalizationInfos((CommonToken) a9, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[217]);
                            				}

                            a10=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1848); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
                            					copyLocalizationInfos((CommonToken)a10, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[218]);
                            				}

                            a11=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumLiteral1871); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
                            					copyLocalizationInfos((CommonToken)a11, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[219]);
                            				}

                            }
                            break;
                        case 3 :
                            // Dwprofile.g:2110:10: a12= 'eternity' a13= '-' (a14= DATE )
                            {
                            a12=(Token)match(input,39,FOLLOW_39_in_parse_eu_hyvar_dataValues_HyEnumLiteral1904); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
                            					copyLocalizationInfos((CommonToken)a12, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[220]);
                            				}

                            a13=(Token)match(input,20,FOLLOW_20_in_parse_eu_hyvar_dataValues_HyEnumLiteral1927); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
                            					copyLocalizationInfos((CommonToken)a13, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[221]);
                            				}

                            // Dwprofile.g:2138:5: (a14= DATE )
                            // Dwprofile.g:2139:6: a14= DATE
                            {
                            a14=(Token)match(input,DATE,FOLLOW_DATE_in_parse_eu_hyvar_dataValues_HyEnumLiteral1957); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            						if (terminateParsing) {
                            							throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                            						}
                            						if (element == null) {
                            							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                            							startIncompleteElement(element);
                            						}
                            						if (a14 != null) {
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
                            							tokenResolver.setOptions(getOptions());
                            							de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
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
                            							retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_2, resolved, true);
                            							copyLocalizationInfos((CommonToken) a14, element);
                            						}
                            					}

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[222]);
                            				}

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[223]);
                    			}

                    a15=(Token)match(input,35,FOLLOW_35_in_parse_eu_hyvar_dataValues_HyEnumLiteral2009); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
                    				copyLocalizationInfos((CommonToken)a15, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[224]);
                    				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[225]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[226]);
            		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[227]);
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
    // Dwprofile.g:2205:1: parseop_HyExpression_level_0 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_0() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_0_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Dwprofile.g:2208:2: (leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |) )
            // Dwprofile.g:2209:2: leftArg= parseop_HyExpression_level_1 ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02057);
            leftArg=parseop_HyExpression_level_1();

            state._fsp--;
            if (state.failed) return element;

            // Dwprofile.g:2209:41: ( ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+ |)
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            else if ( (LA14_0==EOF||(LA14_0 >= IDENTIFIER_TOKEN && LA14_0 <= INTEGER_LITERAL)||LA14_0==QUOTED_34_34||LA14_0==12||(LA14_0 >= 15 && LA14_0 <= 16)||(LA14_0 >= 19 && LA14_0 <= 20)||LA14_0==30||LA14_0==33||(LA14_0 >= 37 && LA14_0 <= 38)||(LA14_0 >= 40 && LA14_0 <= 44)) ) {
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
                    // Dwprofile.g:2209:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
                    {
                    // Dwprofile.g:2209:42: ( () a0= '<->' rightArg= parseop_HyExpression_level_1 )+
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
                    	    // Dwprofile.g:2210:3: () a0= '<->' rightArg= parseop_HyExpression_level_1
                    	    {
                    	    // Dwprofile.g:2210:3: ()
                    	    // Dwprofile.g:2210:4: 
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
                    	    			retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_0_0_0_1, null, true);
                    	    			copyLocalizationInfos((CommonToken)a0, element);
                    	    		}

                    	    if ( state.backtracking==0 ) {
                    	    			// expected elements (follow set)
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[228]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[229]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[230]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[231]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[232]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[233]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[234]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[235]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[236]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[237]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[238]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[239]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[240]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[241]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[242]);
                    	    			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[243]);
                    	    		}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02094);
                    	    rightArg=parseop_HyExpression_level_1();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    			if (terminateParsing) {
                    	    				throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_0_0_0_0, leftArg, true);
                    	    				copyLocalizationInfos(leftArg, element);
                    	    			}
                    	    		}

                    	    if ( state.backtracking==0 ) {
                    	    			if (terminateParsing) {
                    	    				throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_0_0_0_2, rightArg, true);
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
                    // Dwprofile.g:2280:21: 
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
    // Dwprofile.g:2285:1: parseop_HyExpression_level_1 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_4 ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_1() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_1_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Dwprofile.g:2288:9: (leftArg= parseop_HyExpression_level_4 ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |) )
            // Dwprofile.g:2289:9: leftArg= parseop_HyExpression_level_4 ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_12140);
            leftArg=parseop_HyExpression_level_4();

            state._fsp--;
            if (state.failed) return element;

            // Dwprofile.g:2289:39: ( ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+ |)
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==21) ) {
                alt16=1;
            }
            else if ( (LA16_0==EOF||(LA16_0 >= IDENTIFIER_TOKEN && LA16_0 <= INTEGER_LITERAL)||LA16_0==QUOTED_34_34||LA16_0==12||(LA16_0 >= 15 && LA16_0 <= 16)||(LA16_0 >= 19 && LA16_0 <= 20)||LA16_0==25||LA16_0==30||LA16_0==33||(LA16_0 >= 37 && LA16_0 <= 38)||(LA16_0 >= 40 && LA16_0 <= 44)) ) {
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
                    // Dwprofile.g:2289:40: ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+
                    {
                    // Dwprofile.g:2289:40: ( () a0= '->' rightArg= parseop_HyExpression_level_4 )+
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
                    	    // Dwprofile.g:2290:2: () a0= '->' rightArg= parseop_HyExpression_level_4
                    	    {
                    	    // Dwprofile.g:2290:2: ()
                    	    // Dwprofile.g:2290:3: 
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
                    	    		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_1_0_0_1, null, true);
                    	    		copyLocalizationInfos((CommonToken)a0, element);
                    	    	}

                    	    if ( state.backtracking==0 ) {
                    	    		// expected elements (follow set)
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[244]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[245]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[246]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[247]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[248]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[249]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[250]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[251]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[252]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[253]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[254]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[255]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[256]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[257]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[258]);
                    	    		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[259]);
                    	    	}

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_12170);
                    	    rightArg=parseop_HyExpression_level_4();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    		if (terminateParsing) {
                    	    			throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    			retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_1_0_0_0, leftArg, true);
                    	    			copyLocalizationInfos(leftArg, element);
                    	    		}
                    	    	}

                    	    if ( state.backtracking==0 ) {
                    	    		if (terminateParsing) {
                    	    			throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    			retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_1_0_0_2, rightArg, true);
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
                    // Dwprofile.g:2360:20: 
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



    // $ANTLR start "parseop_HyExpression_level_4"
    // Dwprofile.g:2365:1: parseop_HyExpression_level_4 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_5 ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_4() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_4_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Dwprofile.g:2368:9: (leftArg= parseop_HyExpression_level_5 ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |) )
            // Dwprofile.g:2369:9: leftArg= parseop_HyExpression_level_5 ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_42211);
            leftArg=parseop_HyExpression_level_5();

            state._fsp--;
            if (state.failed) return element;

            // Dwprofile.g:2369:39: ( ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+ |)
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==45) ) {
                alt18=1;
            }
            else if ( (LA18_0==EOF||(LA18_0 >= IDENTIFIER_TOKEN && LA18_0 <= INTEGER_LITERAL)||LA18_0==QUOTED_34_34||LA18_0==12||(LA18_0 >= 15 && LA18_0 <= 16)||(LA18_0 >= 19 && LA18_0 <= 21)||LA18_0==25||LA18_0==30||LA18_0==33||(LA18_0 >= 37 && LA18_0 <= 38)||(LA18_0 >= 40 && LA18_0 <= 44)) ) {
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
                    // Dwprofile.g:2369:40: ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+
                    {
                    // Dwprofile.g:2369:40: ( () a0= '||' rightArg= parseop_HyExpression_level_5 )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==45) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // Dwprofile.g:2370:0: () a0= '||' rightArg= parseop_HyExpression_level_5
                    	    {
                    	    // Dwprofile.g:2370:2: ()
                    	    // Dwprofile.g:2370:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,45,FOLLOW_45_in_parseop_HyExpression_level_42224); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    	if (element == null) {
                    	    		element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyOrExpression();
                    	    		startIncompleteElement(element);
                    	    	}
                    	    	collectHiddenTokens(element);
                    	    	retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_2_0_0_1, null, true);
                    	    	copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    	// expected elements (follow set)
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[260]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[261]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[262]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[263]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[264]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[265]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[266]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[267]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[268]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[269]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[270]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[271]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[272]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[273]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[274]);
                    	    	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[275]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_42235);
                    	    rightArg=parseop_HyExpression_level_5();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    	if (terminateParsing) {
                    	    		throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_2_0_0_0, leftArg, true);
                    	    		copyLocalizationInfos(leftArg, element);
                    	    	}
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    	if (terminateParsing) {
                    	    		throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_2_0_0_2, rightArg, true);
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
                    // Dwprofile.g:2440:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 10, parseop_HyExpression_level_4_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_4"



    // $ANTLR start "parseop_HyExpression_level_5"
    // Dwprofile.g:2445:1: parseop_HyExpression_level_5 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_9 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_5() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_5_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Dwprofile.g:2448:9: (leftArg= parseop_HyExpression_level_9 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |) )
            // Dwprofile.g:2449:9: leftArg= parseop_HyExpression_level_9 ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_52273);
            leftArg=parseop_HyExpression_level_9();

            state._fsp--;
            if (state.failed) return element;

            // Dwprofile.g:2449:39: ( ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+ |)
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==14) ) {
                alt20=1;
            }
            else if ( (LA20_0==EOF||(LA20_0 >= IDENTIFIER_TOKEN && LA20_0 <= INTEGER_LITERAL)||LA20_0==QUOTED_34_34||LA20_0==12||(LA20_0 >= 15 && LA20_0 <= 16)||(LA20_0 >= 19 && LA20_0 <= 21)||LA20_0==25||LA20_0==30||LA20_0==33||(LA20_0 >= 37 && LA20_0 <= 38)||(LA20_0 >= 40 && LA20_0 <= 45)) ) {
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
                    // Dwprofile.g:2449:40: ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+
                    {
                    // Dwprofile.g:2449:40: ( () a0= '&&' rightArg= parseop_HyExpression_level_9 )+
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
                    	    // Dwprofile.g:2450:0: () a0= '&&' rightArg= parseop_HyExpression_level_9
                    	    {
                    	    // Dwprofile.g:2450:2: ()
                    	    // Dwprofile.g:2450:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,14,FOLLOW_14_in_parseop_HyExpression_level_52286); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAndExpression();
                    	    	startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_3_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[276]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[277]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[278]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[279]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[280]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[281]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[282]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[283]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[284]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[285]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[286]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[287]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[288]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[289]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[290]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[291]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_52297);
                    	    rightArg=parseop_HyExpression_level_9();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    	throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    	retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_3_0_0_0, leftArg, true);
                    	    	copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    	throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    	retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_3_0_0_2, rightArg, true);
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
                    // Dwprofile.g:2520:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 11, parseop_HyExpression_level_5_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_5"



    // $ANTLR start "parseop_HyExpression_level_9"
    // Dwprofile.g:2525:1: parseop_HyExpression_level_9 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_12 ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_9() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_9_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Dwprofile.g:2528:9: (leftArg= parseop_HyExpression_level_12 ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |) )
            // Dwprofile.g:2529:9: leftArg= parseop_HyExpression_level_12 ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92335);
            leftArg=parseop_HyExpression_level_12();

            state._fsp--;
            if (state.failed) return element;

            // Dwprofile.g:2529:40: ( ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+ |)
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==13||LA22_0==24||(LA22_0 >= 26 && LA22_0 <= 29)) ) {
                alt22=1;
            }
            else if ( (LA22_0==EOF||(LA22_0 >= IDENTIFIER_TOKEN && LA22_0 <= INTEGER_LITERAL)||LA22_0==QUOTED_34_34||LA22_0==12||(LA22_0 >= 14 && LA22_0 <= 16)||(LA22_0 >= 19 && LA22_0 <= 21)||LA22_0==25||LA22_0==30||LA22_0==33||(LA22_0 >= 37 && LA22_0 <= 38)||(LA22_0 >= 40 && LA22_0 <= 45)) ) {
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
                    // Dwprofile.g:2529:41: ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+
                    {
                    // Dwprofile.g:2529:41: ( () a0= '<' rightArg= parseop_HyExpression_level_12 | () a0= '<=' rightArg= parseop_HyExpression_level_12 | () a0= '>' rightArg= parseop_HyExpression_level_12 | () a0= '>=' rightArg= parseop_HyExpression_level_12 | () a0= '=' rightArg= parseop_HyExpression_level_12 | () a0= '!=' rightArg= parseop_HyExpression_level_12 )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=7;
                        switch ( input.LA(1) ) {
                        case 24:
                            {
                            alt21=1;
                            }
                            break;
                        case 26:
                            {
                            alt21=2;
                            }
                            break;
                        case 28:
                            {
                            alt21=3;
                            }
                            break;
                        case 29:
                            {
                            alt21=4;
                            }
                            break;
                        case 27:
                            {
                            alt21=5;
                            }
                            break;
                        case 13:
                            {
                            alt21=6;
                            }
                            break;

                        }

                        switch (alt21) {
                    	case 1 :
                    	    // Dwprofile.g:2530:0: () a0= '<' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Dwprofile.g:2530:2: ()
                    	    // Dwprofile.g:2530:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,24,FOLLOW_24_in_parseop_HyExpression_level_92348); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyLessExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_16_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[292]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[293]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[294]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[295]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[296]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[297]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[298]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[299]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[300]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[301]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[302]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[303]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[304]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[305]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[306]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[307]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92359);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_16_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_16_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 2 :
                    	    // Dwprofile.g:2601:0: () a0= '<=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Dwprofile.g:2601:2: ()
                    	    // Dwprofile.g:2601:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,26,FOLLOW_26_in_parseop_HyExpression_level_92377); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyLessOrEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_17_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[308]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[309]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[310]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[311]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[312]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[313]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[314]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[315]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[316]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[317]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[318]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[319]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[320]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[321]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[322]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[323]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92388);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_17_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_17_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 3 :
                    	    // Dwprofile.g:2672:0: () a0= '>' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Dwprofile.g:2672:2: ()
                    	    // Dwprofile.g:2672:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,28,FOLLOW_28_in_parseop_HyExpression_level_92406); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyGreaterExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_18_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[324]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[325]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[326]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[327]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[328]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[329]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[330]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[331]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[332]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[333]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[334]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[335]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[336]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[337]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[338]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[339]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92417);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_18_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_18_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 4 :
                    	    // Dwprofile.g:2743:0: () a0= '>=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Dwprofile.g:2743:2: ()
                    	    // Dwprofile.g:2743:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,29,FOLLOW_29_in_parseop_HyExpression_level_92435); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyGreaterOrEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_19_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[340]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[341]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[342]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[343]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[344]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[345]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[346]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[347]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[348]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[349]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[350]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[351]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[352]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[353]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[354]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[355]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92446);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_19_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_19_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 5 :
                    	    // Dwprofile.g:2814:0: () a0= '=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Dwprofile.g:2814:2: ()
                    	    // Dwprofile.g:2814:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,27,FOLLOW_27_in_parseop_HyExpression_level_92464); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_25_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[356]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[357]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[358]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[359]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[360]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[361]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[362]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[363]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[364]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[365]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[366]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[367]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[368]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[369]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[370]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[371]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92475);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_25_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_25_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 6 :
                    	    // Dwprofile.g:2885:0: () a0= '!=' rightArg= parseop_HyExpression_level_12
                    	    {
                    	    // Dwprofile.g:2885:2: ()
                    	    // Dwprofile.g:2885:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,13,FOLLOW_13_in_parseop_HyExpression_level_92493); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNotEqualExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_26_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[372]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[373]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[374]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[375]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[376]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[377]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[378]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[379]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[380]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[381]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[382]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[383]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[384]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[385]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[386]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[387]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92504);
                    	    rightArg=parseop_HyExpression_level_12();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_26_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_26_0_0_2, rightArg, true);
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
                    // Dwprofile.g:2955:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 12, parseop_HyExpression_level_9_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_9"



    // $ANTLR start "parseop_HyExpression_level_12"
    // Dwprofile.g:2960:1: parseop_HyExpression_level_12 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_13 ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_12() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_12_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Dwprofile.g:2963:9: (leftArg= parseop_HyExpression_level_13 ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |) )
            // Dwprofile.g:2964:9: leftArg= parseop_HyExpression_level_13 ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122542);
            leftArg=parseop_HyExpression_level_13();

            state._fsp--;
            if (state.failed) return element;

            // Dwprofile.g:2964:40: ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ |)
            int alt24=2;
            switch ( input.LA(1) ) {
            case 20:
                {
                int LA24_1 = input.LA(2);

                if ( (synpred37_Dwprofile()) ) {
                    alt24=1;
                }
                else if ( (true) ) {
                    alt24=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;

                }
                }
                break;
            case 18:
                {
                alt24=1;
                }
                break;
            case EOF:
            case IDENTIFIER_TOKEN:
            case INTEGER_LITERAL:
            case QUOTED_34_34:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 19:
            case 21:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 33:
            case 37:
            case 38:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
                {
                alt24=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // Dwprofile.g:2964:41: ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+
                    {
                    // Dwprofile.g:2964:41: ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=3;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==20) ) {
                            int LA23_14 = input.LA(2);

                            if ( (synpred35_Dwprofile()) ) {
                                alt23=1;
                            }


                        }
                        else if ( (LA23_0==18) ) {
                            alt23=2;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // Dwprofile.g:2965:0: () a0= '-' rightArg= parseop_HyExpression_level_13
                    	    {
                    	    // Dwprofile.g:2965:2: ()
                    	    // Dwprofile.g:2965:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,20,FOLLOW_20_in_parseop_HyExpression_level_122555); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHySubtractionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[388]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[389]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[390]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[391]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[392]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[393]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[394]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[395]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[396]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[397]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[398]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[399]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[400]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[401]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[402]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[403]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122566);
                    	    rightArg=parseop_HyExpression_level_13();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_20_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_20_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 2 :
                    	    // Dwprofile.g:3036:0: () a0= '+' rightArg= parseop_HyExpression_level_13
                    	    {
                    	    // Dwprofile.g:3036:2: ()
                    	    // Dwprofile.g:3036:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,18,FOLLOW_18_in_parseop_HyExpression_level_122584); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAdditionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_21_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[404]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[405]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[406]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[407]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[408]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[409]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[410]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[411]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[412]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[413]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[414]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[415]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[416]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[417]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[418]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[419]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122595);
                    	    rightArg=parseop_HyExpression_level_13();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_21_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_21_0_0_2, rightArg, true);
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
                    // Dwprofile.g:3106:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 13, parseop_HyExpression_level_12_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_12"



    // $ANTLR start "parseop_HyExpression_level_13"
    // Dwprofile.g:3111:1: parseop_HyExpression_level_13 returns [eu.hyvar.feature.expression.HyExpression element = null] : leftArg= parseop_HyExpression_level_14 ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |) ;
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_13() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_13_StartIndex = input.index();

        Token a0=null;
        eu.hyvar.feature.expression.HyExpression leftArg =null;

        eu.hyvar.feature.expression.HyExpression rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Dwprofile.g:3114:9: (leftArg= parseop_HyExpression_level_14 ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |) )
            // Dwprofile.g:3115:9: leftArg= parseop_HyExpression_level_14 ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |)
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132633);
            leftArg=parseop_HyExpression_level_14();

            state._fsp--;
            if (state.failed) return element;

            // Dwprofile.g:3115:40: ( ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+ |)
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==17||LA26_0==23||LA26_0==34) ) {
                alt26=1;
            }
            else if ( (LA26_0==EOF||(LA26_0 >= IDENTIFIER_TOKEN && LA26_0 <= INTEGER_LITERAL)||LA26_0==QUOTED_34_34||(LA26_0 >= 12 && LA26_0 <= 16)||(LA26_0 >= 18 && LA26_0 <= 21)||(LA26_0 >= 24 && LA26_0 <= 30)||LA26_0==33||(LA26_0 >= 37 && LA26_0 <= 38)||(LA26_0 >= 40 && LA26_0 <= 45)) ) {
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
                    // Dwprofile.g:3115:41: ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+
                    {
                    // Dwprofile.g:3115:41: ( () a0= '\\u0025' rightArg= parseop_HyExpression_level_14 | () a0= '*' rightArg= parseop_HyExpression_level_14 | () a0= '/' rightArg= parseop_HyExpression_level_14 )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=4;
                        switch ( input.LA(1) ) {
                        case 34:
                            {
                            alt25=1;
                            }
                            break;
                        case 17:
                            {
                            alt25=2;
                            }
                            break;
                        case 23:
                            {
                            alt25=3;
                            }
                            break;

                        }

                        switch (alt25) {
                    	case 1 :
                    	    // Dwprofile.g:3116:0: () a0= '\\u0025' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Dwprofile.g:3116:2: ()
                    	    // Dwprofile.g:3116:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,34,FOLLOW_34_in_parseop_HyExpression_level_132646); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyModuloExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_22_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[420]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[421]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[422]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[423]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[424]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[425]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[426]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[427]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[428]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[429]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[430]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[431]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[432]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[433]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[434]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[435]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132657);
                    	    rightArg=parseop_HyExpression_level_14();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_22_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_22_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 2 :
                    	    // Dwprofile.g:3187:0: () a0= '*' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Dwprofile.g:3187:2: ()
                    	    // Dwprofile.g:3187:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,17,FOLLOW_17_in_parseop_HyExpression_level_132675); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMultiplicationExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_23_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[436]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[437]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[438]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[439]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[440]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[441]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[442]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[443]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[444]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[445]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[446]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[447]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[448]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[449]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[450]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[451]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132686);
                    	    rightArg=parseop_HyExpression_level_14();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_23_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_23_0_0_2, rightArg, true);
                    	    copyLocalizationInfos(rightArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;
                    	case 3 :
                    	    // Dwprofile.g:3258:0: () a0= '/' rightArg= parseop_HyExpression_level_14
                    	    {
                    	    // Dwprofile.g:3258:2: ()
                    	    // Dwprofile.g:3258:2: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,23,FOLLOW_23_in_parseop_HyExpression_level_132704); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (element == null) {
                    	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyDivisionExpression();
                    	    startIncompleteElement(element);
                    	    }
                    	    collectHiddenTokens(element);
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_24_0_0_1, null, true);
                    	    copyLocalizationInfos((CommonToken)a0, element);
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    // expected elements (follow set)
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[452]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[453]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[454]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[455]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[456]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[457]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[458]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[459]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[460]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[461]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[462]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[463]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[464]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[465]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[466]);
                    	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[467]);
                    	    }

                    	    pushFollow(FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132715);
                    	    rightArg=parseop_HyExpression_level_14();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_24_0_0_0, leftArg, true);
                    	    copyLocalizationInfos(leftArg, element);
                    	    }
                    	    }

                    	    if ( state.backtracking==0 ) {
                    	    if (terminateParsing) {
                    	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_24_0_0_2, rightArg, true);
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
                    // Dwprofile.g:3328:20: 
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
            if ( state.backtracking>0 ) { memoize(input, 14, parseop_HyExpression_level_13_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_13"



    // $ANTLR start "parseop_HyExpression_level_14"
    // Dwprofile.g:3333:1: parseop_HyExpression_level_14 returns [eu.hyvar.feature.expression.HyExpression element = null] : (a0= '!' arg= parseop_HyExpression_level_15 |a2= '-' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 );
    public final eu.hyvar.feature.expression.HyExpression parseop_HyExpression_level_14() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parseop_HyExpression_level_14_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression arg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Dwprofile.g:3336:0: (a0= '!' arg= parseop_HyExpression_level_15 |a2= '-' arg= parseop_HyExpression_level_15 |arg= parseop_HyExpression_level_15 )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt27=1;
                }
                break;
            case 20:
                {
                alt27=2;
                }
                break;
            case IDENTIFIER_TOKEN:
            case INTEGER_LITERAL:
            case QUOTED_34_34:
            case 15:
            case 30:
            case 37:
            case 38:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
                {
                alt27=3;
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
                    // Dwprofile.g:3337:0: a0= '!' arg= parseop_HyExpression_level_15
                    {
                    a0=(Token)match(input,12,FOLLOW_12_in_parseop_HyExpression_level_142753); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNotExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_4_0_0_0, null, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    }

                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[468]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[469]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[470]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[471]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[472]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[473]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[474]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[475]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[476]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[477]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[478]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[479]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[480]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[481]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[482]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[483]);
                    }

                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142764);
                    arg=parseop_HyExpression_level_15();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_4_0_0_1, arg, true);
                    copyLocalizationInfos(arg, element);
                    }
                    }

                    }
                    break;
                case 2 :
                    // Dwprofile.g:3386:0: a2= '-' arg= parseop_HyExpression_level_15
                    {
                    a2=(Token)match(input,20,FOLLOW_20_in_parseop_HyExpression_level_142773); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNegationExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_5_0_0_0, null, true);
                    copyLocalizationInfos((CommonToken)a2, element);
                    }

                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[484]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[485]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[486]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[487]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[488]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[489]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[490]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[491]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[492]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[493]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[494]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[495]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[496]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[497]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[498]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[499]);
                    }

                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142784);
                    arg=parseop_HyExpression_level_15();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_5_0_0_1, arg, true);
                    copyLocalizationInfos(arg, element);
                    }
                    }

                    }
                    break;
                case 3 :
                    // Dwprofile.g:3436:5: arg= parseop_HyExpression_level_15
                    {
                    pushFollow(FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142794);
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
    // Dwprofile.g:3439:1: parseop_HyExpression_level_15 returns [eu.hyvar.feature.expression.HyExpression element = null] : (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression |c4= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression |c5= parse_eu_hyvar_feature_expression_HyValueExpression |c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression |c7= parse_eu_hyvar_feature_expression_HyMinimumExpression |c8= parse_eu_hyvar_feature_expression_HyMaximumExpression |c9= parse_eu_hyvar_feature_expression_HyIfPossibleExpression );
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Dwprofile.g:3442:0: (c0= parse_eu_hyvar_feature_expression_HyNestedExpression |c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression |c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression |c3= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression |c4= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression |c5= parse_eu_hyvar_feature_expression_HyValueExpression |c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression |c7= parse_eu_hyvar_feature_expression_HyMinimumExpression |c8= parse_eu_hyvar_feature_expression_HyMaximumExpression |c9= parse_eu_hyvar_feature_expression_HyIfPossibleExpression )
            int alt28=10;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt28=1;
                }
                break;
            case QUOTED_34_34:
                {
                int LA28_2 = input.LA(2);

                if ( (LA28_2==EOF||(LA28_2 >= IDENTIFIER_TOKEN && LA28_2 <= INTEGER_LITERAL)||LA28_2==QUOTED_34_34||(LA28_2 >= 12 && LA28_2 <= 21)||(LA28_2 >= 23 && LA28_2 <= 30)||(LA28_2 >= 33 && LA28_2 <= 34)||(LA28_2 >= 37 && LA28_2 <= 38)||(LA28_2 >= 40 && LA28_2 <= 45)) ) {
                    alt28=2;
                }
                else if ( (LA28_2==22) ) {
                    alt28=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 2, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER_TOKEN:
                {
                int LA28_3 = input.LA(2);

                if ( (LA28_3==EOF||(LA28_3 >= IDENTIFIER_TOKEN && LA28_3 <= INTEGER_LITERAL)||LA28_3==QUOTED_34_34||(LA28_3 >= 12 && LA28_3 <= 21)||(LA28_3 >= 23 && LA28_3 <= 30)||(LA28_3 >= 33 && LA28_3 <= 34)||(LA28_3 >= 37 && LA28_3 <= 38)||(LA28_3 >= 40 && LA28_3 <= 45)) ) {
                    alt28=2;
                }
                else if ( (LA28_3==22) ) {
                    alt28=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 3, input);

                    throw nvae;

                }
                }
                break;
            case 30:
                {
                alt28=3;
                }
                break;
            case 37:
                {
                alt28=4;
                }
                break;
            case INTEGER_LITERAL:
            case 38:
                {
                alt28=6;
                }
                break;
            case 44:
                {
                int LA28_7 = input.LA(2);

                if ( (synpred49_Dwprofile()) ) {
                    alt28=6;
                }
                else if ( (synpred50_Dwprofile()) ) {
                    alt28=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 7, input);

                    throw nvae;

                }
                }
                break;
            case 40:
                {
                int LA28_8 = input.LA(2);

                if ( (synpred49_Dwprofile()) ) {
                    alt28=6;
                }
                else if ( (synpred50_Dwprofile()) ) {
                    alt28=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 8, input);

                    throw nvae;

                }
                }
                break;
            case 43:
                {
                alt28=8;
                }
                break;
            case 42:
                {
                alt28=9;
                }
                break;
            case 41:
                {
                alt28=10;
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
                    // Dwprofile.g:3443:0: c0= parse_eu_hyvar_feature_expression_HyNestedExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_152816);
                    c0=parse_eu_hyvar_feature_expression_HyNestedExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Dwprofile.g:3444:2: c1= parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_152824);
                    c1=parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Dwprofile.g:3445:2: c2= parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_152832);
                    c2=parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Dwprofile.g:3446:2: c3= parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyExpression_level_152840);
                    c3=parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Dwprofile.g:3447:2: c4= parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyExpression_level_152848);
                    c4=parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Dwprofile.g:3448:2: c5= parse_eu_hyvar_feature_expression_HyValueExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyExpression_level_152856);
                    c5=parse_eu_hyvar_feature_expression_HyValueExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Dwprofile.g:3449:2: c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_152864);
                    c6=parse_eu_hyvar_feature_expression_HyBooleanValueExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Dwprofile.g:3450:2: c7= parse_eu_hyvar_feature_expression_HyMinimumExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyMinimumExpression_in_parseop_HyExpression_level_152872);
                    c7=parse_eu_hyvar_feature_expression_HyMinimumExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Dwprofile.g:3451:2: c8= parse_eu_hyvar_feature_expression_HyMaximumExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyMaximumExpression_in_parseop_HyExpression_level_152880);
                    c8=parse_eu_hyvar_feature_expression_HyMaximumExpression();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c8; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 10 :
                    // Dwprofile.g:3452:2: c9= parse_eu_hyvar_feature_expression_HyIfPossibleExpression
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyIfPossibleExpression_in_parseop_HyExpression_level_152888);
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
            if ( state.backtracking>0 ) { memoize(input, 16, parseop_HyExpression_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyExpression_level_15"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyNestedExpression"
    // Dwprofile.g:3455:1: parse_eu_hyvar_feature_expression_HyNestedExpression returns [eu.hyvar.feature.expression.HyNestedExpression element = null] : a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyNestedExpression parse_eu_hyvar_feature_expression_HyNestedExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyNestedExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyNestedExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Dwprofile.g:3458:4: (a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Dwprofile.g:3459:4: a0= '(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedExpression2910); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_6_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[500]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[501]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[502]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[503]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[504]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[505]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[506]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[507]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[508]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[509]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[510]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[511]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[512]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[513]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[514]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[515]);
            }

            // Dwprofile.g:3488:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Dwprofile.g:3489:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression2923);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_6_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[516]);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression2935); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_6_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[517]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[518]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[519]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[520]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[521]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[522]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[523]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[524]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[525]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[526]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[527]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[528]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[529]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[530]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[531]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[532]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[533]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[534]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[535]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[536]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[537]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[538]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[539]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[540]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[541]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[542]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[543]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[544]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[545]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[546]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[547]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[548]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[549]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[550]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[551]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[552]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[553]);
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
    // Dwprofile.g:3566:1: parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyFeatureReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? ;
    public final eu.hyvar.feature.expression.HyFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        eu.hyvar.feature.expression.HyVersionRestriction a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Dwprofile.g:3569:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )? )
            // Dwprofile.g:3570:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            {
            // Dwprofile.g:3570:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
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
                    // Dwprofile.g:3571:0: (a0= QUOTED_34_34 )
                    {
                    // Dwprofile.g:3571:4: (a0= QUOTED_34_34 )
                    // Dwprofile.g:3572:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2965); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a0 != null) {
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a0, element);
                    copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[554]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[555]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[556]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[557]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[558]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[559]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[560]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[561]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[562]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[563]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[564]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[565]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[566]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[567]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[568]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[569]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[570]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[571]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[572]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[573]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[574]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[575]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[576]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[577]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[578]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[579]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[580]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[581]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[582]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[583]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[584]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[585]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[586]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[587]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[588]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[589]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[590]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[591]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[592]);
                    }

                    }
                    break;
                case 2 :
                    // Dwprofile.g:3650:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Dwprofile.g:3650:2: (a1= IDENTIFIER_TOKEN )
                    // Dwprofile.g:3651:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2982); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[593]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[594]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[595]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[596]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[597]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[598]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[599]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[600]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[601]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[602]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[603]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[604]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[605]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[606]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[607]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[608]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[609]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[610]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[611]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[612]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[613]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[614]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[615]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[616]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[617]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[618]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[619]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[620]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[621]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[622]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[623]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[624]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[625]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[626]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[627]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[628]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[629]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[630]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[631]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[632]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[633]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[634]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[635]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[636]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[637]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[638]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[639]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[640]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[641]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[642]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[643]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[644]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[645]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[646]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[647]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[648]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[649]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[650]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[651]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[652]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[653]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[654]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[655]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[656]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[657]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[658]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[659]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[660]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[661]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[662]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[663]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[664]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[665]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[666]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[667]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[668]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[669]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[670]);
            }

            // Dwprofile.g:3772:0: ( ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==33) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==QUOTED_34_34||LA30_1==24||(LA30_1 >= 26 && LA30_1 <= 29)||LA30_1==36) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // Dwprofile.g:3773:0: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    {
                    // Dwprofile.g:3773:6: ( (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
                    // Dwprofile.g:3774:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    {
                    // Dwprofile.g:3774:6: (a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
                    // Dwprofile.g:3775:6: a2_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3006);
                    a2_0=parse_eu_hyvar_feature_expression_HyVersionRestriction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_0_0, a2_0, true);
                    copyLocalizationInfos(a2_0, element);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[671]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[672]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[673]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[674]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[675]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[676]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[677]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[678]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[679]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[680]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[681]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[682]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[683]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[684]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[685]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[686]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[687]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[688]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[689]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[690]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[691]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[692]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[693]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[694]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[695]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[696]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[697]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[698]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[699]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[700]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[701]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[702]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[703]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[704]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[705]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[706]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[707]);
                    }

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[708]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[709]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[710]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[711]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[712]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[713]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[714]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[715]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[716]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[717]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[718]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[719]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[720]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[721]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[722]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[723]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[724]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[725]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[726]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[727]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[728]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[729]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[730]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[731]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[732]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[733]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[734]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[735]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[736]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[737]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[738]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[739]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[740]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[741]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[742]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[743]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[744]);
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
    // Dwprofile.g:3881:1: parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element = null] : a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) ;
    public final eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyVersionRestriction a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Dwprofile.g:3884:4: (a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction ) )
            // Dwprofile.g:3885:4: a0= '?' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            {
            a0=(Token)match(input,30,FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3041); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_8_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[745]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[746]);
            }

            // Dwprofile.g:3900:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
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
                    // Dwprofile.g:3901:0: (a1= QUOTED_34_34 )
                    {
                    // Dwprofile.g:3901:4: (a1= QUOTED_34_34 )
                    // Dwprofile.g:3902:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3056); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[747]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[748]);
                    }

                    }
                    break;
                case 2 :
                    // Dwprofile.g:3943:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Dwprofile.g:3943:2: (a2= IDENTIFIER_TOKEN )
                    // Dwprofile.g:3944:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3073); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a2 != null) {
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a2, element);
                    copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[749]);
                    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[750]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[751]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[752]);
            }

            // Dwprofile.g:3991:6: (a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction )
            // Dwprofile.g:3992:6: a3_0= parse_eu_hyvar_feature_expression_HyVersionRestriction
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3093);
            a3_0=parse_eu_hyvar_feature_expression_HyVersionRestriction();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_8_0_0_2, a3_0, true);
            copyLocalizationInfos(a3_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[753]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[754]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[755]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[756]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[757]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[758]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[759]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[760]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[761]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[762]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[763]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[764]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[765]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[766]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[767]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[768]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[769]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[770]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[771]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[772]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[773]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[774]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[775]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[776]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[777]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[778]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[779]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[780]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[781]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[782]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[783]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[784]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[785]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[786]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[787]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[788]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[789]);
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



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"
    // Dwprofile.g:4055:1: parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression returns [eu.hyvar.feature.expression.HyContextInformationReferenceExpression element = null] : a0= 'context:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) ;
    public final eu.hyvar.feature.expression.HyContextInformationReferenceExpression parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyContextInformationReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Dwprofile.g:4058:4: (a0= 'context:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) )
            // Dwprofile.g:4059:4: a0= 'context:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
            {
            a0=(Token)match(input,37,FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3120); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_9_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[790]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[791]);
            }

            // Dwprofile.g:4074:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==QUOTED_34_34) ) {
                alt32=1;
            }
            else if ( (LA32_0==IDENTIFIER_TOKEN) ) {
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
                    // Dwprofile.g:4075:0: (a1= QUOTED_34_34 )
                    {
                    // Dwprofile.g:4075:4: (a1= QUOTED_34_34 )
                    // Dwprofile.g:4076:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3135); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.context.HyContextualInformation proxy = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextInformationReferenceExpressionContextInformationReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_9_0_0_1_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[792]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[793]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[794]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[795]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[796]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[797]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[798]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[799]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[800]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[801]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[802]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[803]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[804]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[805]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[806]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[807]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[808]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[809]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[810]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[811]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[812]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[813]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[814]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[815]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[816]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[817]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[818]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[819]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[820]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[821]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[822]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[823]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[824]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[825]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[826]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[827]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[828]);
                    }

                    }
                    break;
                case 2 :
                    // Dwprofile.g:4152:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Dwprofile.g:4152:2: (a2= IDENTIFIER_TOKEN )
                    // Dwprofile.g:4153:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3152); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a2 != null) {
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.context.HyContextualInformation proxy = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextInformationReferenceExpressionContextInformationReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_9_0_0_1_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a2, element);
                    copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[829]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[830]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[831]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[832]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[833]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[834]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[835]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[836]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[837]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[838]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[839]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[840]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[841]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[842]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[843]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[844]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[845]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[846]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[847]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[848]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[849]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[850]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[851]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[852]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[853]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[854]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[855]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[856]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[857]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[858]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[859]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[860]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[861]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[862]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[863]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[864]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[865]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[866]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[867]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[868]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[869]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[870]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[871]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[872]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[873]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[874]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[875]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[876]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[877]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[878]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[879]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[880]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[881]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[882]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[883]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[884]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[885]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[886]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[887]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[888]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[889]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[890]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[891]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[892]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[893]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[894]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[895]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[896]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[897]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[898]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[899]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[900]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[901]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[902]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression"
    // Dwprofile.g:4272:1: parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression returns [eu.hyvar.feature.expression.HyAttributeReferenceExpression element = null] : ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) ;
    public final eu.hyvar.feature.expression.HyAttributeReferenceExpression parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyAttributeReferenceExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Dwprofile.g:4275:0: ( ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN ) )
            // Dwprofile.g:4276:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) ) a2= '.' (a3= IDENTIFIER_TOKEN )
            {
            // Dwprofile.g:4276:0: ( (a0= QUOTED_34_34 ) | (a1= IDENTIFIER_TOKEN ) )
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
                    // Dwprofile.g:4277:0: (a0= QUOTED_34_34 )
                    {
                    // Dwprofile.g:4277:4: (a0= QUOTED_34_34 )
                    // Dwprofile.g:4278:4: a0= QUOTED_34_34
                    {
                    a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3189); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a0 != null) {
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a0, element);
                    copyLocalizationInfos((CommonToken) a0, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[903]);
                    }

                    }
                    break;
                case 2 :
                    // Dwprofile.g:4318:2: (a1= IDENTIFIER_TOKEN )
                    {
                    // Dwprofile.g:4318:2: (a1= IDENTIFIER_TOKEN )
                    // Dwprofile.g:4319:4: a1= IDENTIFIER_TOKEN
                    {
                    a1=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3206); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[904]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[905]);
            }

            a2=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3224); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_10_0_0_1, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[906]);
            }

            // Dwprofile.g:4378:4: (a3= IDENTIFIER_TOKEN )
            // Dwprofile.g:4379:4: a3= IDENTIFIER_TOKEN
            {
            a3=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3237); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
            startIncompleteElement(element);
            }
            if (a3 != null) {
            de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
            tokenResolver.setOptions(getOptions());
            de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
            tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), result);
            Object resolvedObject = result.getResolvedToken();
            if (resolvedObject == null) {
            addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
            }
            String resolved = (String) resolvedObject;
            eu.hyvar.feature.HyFeatureAttribute proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyNumberAttribute();
            collectHiddenTokens(element);
            registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeatureAttribute>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionAttributeReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), resolved, proxy);
            if (proxy != null) {
            Object value = proxy;
            element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), value);
            completedElement(value, false);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_10_0_0_2, proxy, true);
            copyLocalizationInfos((CommonToken) a3, element);
            copyLocalizationInfos((CommonToken) a3, proxy);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[907]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[908]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[909]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[910]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[911]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[912]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[913]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[914]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[915]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[916]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[917]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[918]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[919]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[920]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[921]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[922]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[923]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[924]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[925]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[926]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[927]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[928]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[929]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[930]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[931]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[932]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[933]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[934]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[935]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[936]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[937]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[938]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[939]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[940]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[941]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[942]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[943]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyValueExpression"
    // Dwprofile.g:4456:1: parse_eu_hyvar_feature_expression_HyValueExpression returns [eu.hyvar.feature.expression.HyValueExpression element = null] : (a0_0= parse_eu_hyvar_dataValues_HyValue ) ;
    public final eu.hyvar.feature.expression.HyValueExpression parse_eu_hyvar_feature_expression_HyValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Dwprofile.g:4459:6: ( (a0_0= parse_eu_hyvar_dataValues_HyValue ) )
            // Dwprofile.g:4460:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            {
            // Dwprofile.g:4460:6: (a0_0= parse_eu_hyvar_dataValues_HyValue )
            // Dwprofile.g:4461:6: a0_0= parse_eu_hyvar_dataValues_HyValue
            {
            pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression3267);
            a0_0=parse_eu_hyvar_dataValues_HyValue();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_11_0_0_0, a0_0, true);
            copyLocalizationInfos(a0_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[944]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[945]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[946]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[947]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[948]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[949]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[950]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[951]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[952]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[953]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[954]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[955]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[956]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[957]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[958]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[959]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[960]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[961]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[962]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[963]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[964]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[965]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[966]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[967]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[968]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[969]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[970]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[971]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[972]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[973]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[974]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[975]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[976]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[977]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[978]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[979]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[980]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, parse_eu_hyvar_feature_expression_HyValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyValueExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"
    // Dwprofile.g:4524:1: parse_eu_hyvar_feature_expression_HyBooleanValueExpression returns [eu.hyvar.feature.expression.HyBooleanValueExpression element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.feature.expression.HyBooleanValueExpression parse_eu_hyvar_feature_expression_HyBooleanValueExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyBooleanValueExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Dwprofile.g:4527:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Dwprofile.g:4528:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Dwprofile.g:4528:0: ( (a0= 'true' |a1= 'false' ) )
            // Dwprofile.g:4529:0: (a0= 'true' |a1= 'false' )
            {
            // Dwprofile.g:4529:0: (a0= 'true' |a1= 'false' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==44) ) {
                alt34=1;
            }
            else if ( (LA34_0==40) ) {
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
                    // Dwprofile.g:4530:0: a0= 'true'
                    {
                    a0=(Token)match(input,44,FOLLOW_44_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3298); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_12_0_0_0, true, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    // set value of boolean attribute
                    Object value = true;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 2 :
                    // Dwprofile.g:4543:2: a1= 'false'
                    {
                    a1=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3307); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_12_0_0_0, false, true);
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
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[981]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[982]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[983]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[984]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[985]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[986]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[987]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[988]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[989]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[990]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[991]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[992]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[993]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[994]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[995]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[996]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[997]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[998]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[999]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1000]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1001]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1002]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1003]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1004]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1005]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1006]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1007]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1008]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1009]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1010]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1011]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1012]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1013]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1014]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1015]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1016]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1017]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, parse_eu_hyvar_feature_expression_HyBooleanValueExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyBooleanValueExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyMinimumExpression"
    // Dwprofile.g:4601:1: parse_eu_hyvar_feature_expression_HyMinimumExpression returns [eu.hyvar.feature.expression.HyMinimumExpression element = null] : a0= 'min(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyMinimumExpression parse_eu_hyvar_feature_expression_HyMinimumExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyMinimumExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyMinimumExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Dwprofile.g:4604:4: (a0= 'min(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Dwprofile.g:4605:4: a0= 'min(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,43,FOLLOW_43_in_parse_eu_hyvar_feature_expression_HyMinimumExpression3337); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMinimumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_13_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1018]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1019]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1020]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1021]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1022]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1023]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1024]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1025]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1026]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1027]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1028]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1029]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1030]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1031]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1032]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1033]);
            }

            // Dwprofile.g:4634:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Dwprofile.g:4635:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMinimumExpression3350);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_13_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1034]);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyMinimumExpression3362); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMinimumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_13_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1035]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1036]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1037]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1038]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1039]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1040]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1041]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1042]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1043]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1044]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1045]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1046]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1047]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1048]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1049]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1050]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1051]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1052]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1053]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1054]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1055]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1056]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1057]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1058]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1059]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1060]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1061]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1062]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1063]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1064]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1065]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1066]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1067]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1068]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1069]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1070]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1071]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 24, parse_eu_hyvar_feature_expression_HyMinimumExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyMinimumExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyMaximumExpression"
    // Dwprofile.g:4712:1: parse_eu_hyvar_feature_expression_HyMaximumExpression returns [eu.hyvar.feature.expression.HyMaximumExpression element = null] : a0= 'max(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' ;
    public final eu.hyvar.feature.expression.HyMaximumExpression parse_eu_hyvar_feature_expression_HyMaximumExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyMaximumExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyMaximumExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }

            // Dwprofile.g:4715:4: (a0= 'max(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')' )
            // Dwprofile.g:4716:4: a0= 'max(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) a2= ')'
            {
            a0=(Token)match(input,42,FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyMaximumExpression3388); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMaximumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_14_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1072]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1073]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1074]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1075]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1076]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1077]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1078]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1079]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1080]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1081]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1082]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1083]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1084]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1085]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1086]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1087]);
            }

            // Dwprofile.g:4745:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Dwprofile.g:4746:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMaximumExpression3401);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_14_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1088]);
            }

            a2=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyMaximumExpression3413); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMaximumExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_14_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1089]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1090]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1091]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1092]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1093]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1094]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1095]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1096]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1097]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1098]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1099]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1100]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1101]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1102]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1103]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1104]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1105]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1106]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1107]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1108]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1109]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1110]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1111]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1112]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1113]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1114]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1115]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1116]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1117]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1118]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1119]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1120]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1121]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1122]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1123]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1124]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1125]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, parse_eu_hyvar_feature_expression_HyMaximumExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyMaximumExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyIfPossibleExpression"
    // Dwprofile.g:4823:1: parse_eu_hyvar_feature_expression_HyIfPossibleExpression returns [eu.hyvar.feature.expression.HyIfPossibleExpression element = null] : a0= 'ifPossible(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )* a4= ')' ;
    public final eu.hyvar.feature.expression.HyIfPossibleExpression parse_eu_hyvar_feature_expression_HyIfPossibleExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyIfPossibleExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyIfPossibleExpression_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a4=null;
        eu.hyvar.feature.expression.HyExpression a1_0 =null;

        eu.hyvar.feature.expression.HyExpression a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Dwprofile.g:4826:4: (a0= 'ifPossible(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )* a4= ')' )
            // Dwprofile.g:4827:4: a0= 'ifPossible(' (a1_0= parse_eu_hyvar_feature_expression_HyExpression ) ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )* a4= ')'
            {
            a0=(Token)match(input,41,FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3439); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_15_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1126]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1127]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1128]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1129]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1130]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1131]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1132]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1133]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1134]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1135]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1136]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1137]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1138]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1139]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1140]);
            addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1141]);
            }

            // Dwprofile.g:4856:6: (a1_0= parse_eu_hyvar_feature_expression_HyExpression )
            // Dwprofile.g:4857:6: a1_0= parse_eu_hyvar_feature_expression_HyExpression
            {
            pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3452);
            a1_0=parse_eu_hyvar_feature_expression_HyExpression();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_15_0_0_1, a1_0, true);
            copyLocalizationInfos(a1_0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1142]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1143]);
            }

            // Dwprofile.g:4883:0: ( (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==19) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // Dwprofile.g:4884:0: (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) )
            	    {
            	    // Dwprofile.g:4884:4: (a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression ) )
            	    // Dwprofile.g:4885:4: a2= ',' (a3_0= parse_eu_hyvar_feature_expression_HyExpression )
            	    {
            	    a2=(Token)match(input,19,FOLLOW_19_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3468); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    if (element == null) {
            	    element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
            	    startIncompleteElement(element);
            	    }
            	    collectHiddenTokens(element);
            	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_0, null, true);
            	    copyLocalizationInfos((CommonToken)a2, element);
            	    }

            	    if ( state.backtracking==0 ) {
            	    // expected elements (follow set)
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1144]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1145]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1146]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1147]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1148]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1149]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1150]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1151]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1152]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1153]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1154]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1155]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1156]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1157]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1158]);
            	    addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1159]);
            	    }

            	    // Dwprofile.g:4914:6: (a3_0= parse_eu_hyvar_feature_expression_HyExpression )
            	    // Dwprofile.g:4915:6: a3_0= parse_eu_hyvar_feature_expression_HyExpression
            	    {
            	    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3481);
            	    a3_0=parse_eu_hyvar_feature_expression_HyExpression();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    if (terminateParsing) {
            	    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
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
            	    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_1, a3_0, true);
            	    copyLocalizationInfos(a3_0, element);
            	    }
            	    }

            	    }


            	    if ( state.backtracking==0 ) {
            	    // expected elements (follow set)
            	    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1160]);
            	    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1161]);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1162]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1163]);
            }

            a4=(Token)match(input,16,FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3501); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_15_0_0_3, null, true);
            copyLocalizationInfos((CommonToken)a4, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1164]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1165]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1166]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1167]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1168]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1169]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1170]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1171]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1172]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1173]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1174]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1175]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1176]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1177]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1178]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1179]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1180]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1181]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1182]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1183]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1184]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1185]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1186]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1187]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1188]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1189]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1190]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1191]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1192]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1193]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1194]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1195]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1196]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1197]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1198]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1199]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1200]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, parse_eu_hyvar_feature_expression_HyIfPossibleExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyIfPossibleExpression"



    // $ANTLR start "parseop_HyValue_level_15"
    // Dwprofile.g:5001:1: parseop_HyValue_level_15 returns [eu.hyvar.dataValues.HyValue element = null] : (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue );
    public final eu.hyvar.dataValues.HyValue parseop_HyValue_level_15() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parseop_HyValue_level_15_StartIndex = input.index();

        eu.hyvar.dataValues.HyNumberValue c0 =null;

        eu.hyvar.dataValues.HyBooleanValue c1 =null;

        eu.hyvar.dataValues.HyEnumValue c2 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Dwprofile.g:5004:0: (c0= parse_eu_hyvar_dataValues_HyNumberValue |c1= parse_eu_hyvar_dataValues_HyBooleanValue |c2= parse_eu_hyvar_dataValues_HyEnumValue )
            int alt36=3;
            switch ( input.LA(1) ) {
            case INTEGER_LITERAL:
                {
                alt36=1;
                }
                break;
            case 40:
            case 44:
                {
                alt36=2;
                }
                break;
            case 38:
                {
                alt36=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }

            switch (alt36) {
                case 1 :
                    // Dwprofile.g:5005:0: c0= parse_eu_hyvar_dataValues_HyNumberValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_153527);
                    c0=parse_eu_hyvar_dataValues_HyNumberValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Dwprofile.g:5006:2: c1= parse_eu_hyvar_dataValues_HyBooleanValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_153535);
                    c1=parse_eu_hyvar_dataValues_HyBooleanValue();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Dwprofile.g:5007:2: c2= parse_eu_hyvar_dataValues_HyEnumValue
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_153543);
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
            if ( state.backtracking>0 ) { memoize(input, 27, parseop_HyValue_level_15_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_HyValue_level_15"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyNumberValue"
    // Dwprofile.g:5010:1: parse_eu_hyvar_dataValues_HyNumberValue returns [eu.hyvar.dataValues.HyNumberValue element = null] : (a0= INTEGER_LITERAL ) ;
    public final eu.hyvar.dataValues.HyNumberValue parse_eu_hyvar_dataValues_HyNumberValue() throws RecognitionException {
        eu.hyvar.dataValues.HyNumberValue element =  null;

        int parse_eu_hyvar_dataValues_HyNumberValue_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Dwprofile.g:5013:4: ( (a0= INTEGER_LITERAL ) )
            // Dwprofile.g:5014:4: (a0= INTEGER_LITERAL )
            {
            // Dwprofile.g:5014:4: (a0= INTEGER_LITERAL )
            // Dwprofile.g:5015:4: a0= INTEGER_LITERAL
            {
            a0=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3567); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (terminateParsing) {
            throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
            }
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyNumberValue();
            startIncompleteElement(element);
            }
            if (a0 != null) {
            de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            tokenResolver.setOptions(getOptions());
            de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
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
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_0_0_0_0, resolved, true);
            copyLocalizationInfos((CommonToken) a0, element);
            }
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1201]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1202]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1203]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1204]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1205]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1206]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1207]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1208]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1209]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1210]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1211]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1212]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1213]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1214]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1215]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1216]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1217]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1218]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1219]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1220]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1221]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1222]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1223]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1224]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1225]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1226]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1227]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1228]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1229]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1230]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1231]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1232]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1233]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1234]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1235]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1236]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1237]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 28, parse_eu_hyvar_dataValues_HyNumberValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyNumberValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyBooleanValue"
    // Dwprofile.g:5088:1: parse_eu_hyvar_dataValues_HyBooleanValue returns [eu.hyvar.dataValues.HyBooleanValue element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final eu.hyvar.dataValues.HyBooleanValue parse_eu_hyvar_dataValues_HyBooleanValue() throws RecognitionException {
        eu.hyvar.dataValues.HyBooleanValue element =  null;

        int parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Dwprofile.g:5091:0: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Dwprofile.g:5092:0: ( (a0= 'true' |a1= 'false' ) )
            {
            // Dwprofile.g:5092:0: ( (a0= 'true' |a1= 'false' ) )
            // Dwprofile.g:5093:0: (a0= 'true' |a1= 'false' )
            {
            // Dwprofile.g:5093:0: (a0= 'true' |a1= 'false' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==44) ) {
                alt37=1;
            }
            else if ( (LA37_0==40) ) {
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
                    // Dwprofile.g:5094:0: a0= 'true'
                    {
                    a0=(Token)match(input,44,FOLLOW_44_in_parse_eu_hyvar_dataValues_HyBooleanValue3599); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_1_0_0_0, true, true);
                    copyLocalizationInfos((CommonToken)a0, element);
                    // set value of boolean attribute
                    Object value = true;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), value);
                    completedElement(value, false);
                    }

                    }
                    break;
                case 2 :
                    // Dwprofile.g:5107:2: a1= 'false'
                    {
                    a1=(Token)match(input,40,FOLLOW_40_in_parse_eu_hyvar_dataValues_HyBooleanValue3608); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
                    startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_1_0_0_0, false, true);
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
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1238]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1239]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1240]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1241]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1242]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1243]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1244]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1245]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1246]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1247]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1248]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1249]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1250]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1251]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1252]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1253]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1254]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1255]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1256]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1257]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1258]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1259]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1260]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1261]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1262]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1263]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1264]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1265]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1266]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1267]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1268]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1269]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1270]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1271]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1272]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1273]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1274]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 29, parse_eu_hyvar_dataValues_HyBooleanValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyBooleanValue"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyEnumValue"
    // Dwprofile.g:5165:1: parse_eu_hyvar_dataValues_HyEnumValue returns [eu.hyvar.dataValues.HyEnumValue element = null] : a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Dwprofile.g:5168:4: (a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) ) )
            // Dwprofile.g:5169:4: a0= 'enum:' ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) ) a3= '.' ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnumValue3638); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
            copyLocalizationInfos((CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1275]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1276]);
            }

            // Dwprofile.g:5184:0: ( (a1= QUOTED_34_34 ) | (a2= IDENTIFIER_TOKEN ) )
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
                    // Dwprofile.g:5185:0: (a1= QUOTED_34_34 )
                    {
                    // Dwprofile.g:5185:4: (a1= QUOTED_34_34 )
                    // Dwprofile.g:5186:4: a1= QUOTED_34_34
                    {
                    a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3653); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a1 != null) {
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a1, element);
                    copyLocalizationInfos((CommonToken) a1, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1277]);
                    }

                    }
                    break;
                case 2 :
                    // Dwprofile.g:5226:2: (a2= IDENTIFIER_TOKEN )
                    {
                    // Dwprofile.g:5226:2: (a2= IDENTIFIER_TOKEN )
                    // Dwprofile.g:5227:4: a2= IDENTIFIER_TOKEN
                    {
                    a2=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3670); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a2 != null) {
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a2, element);
                    copyLocalizationInfos((CommonToken) a2, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1278]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1279]);
            }

            a3=(Token)match(input,22,FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue3688); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
            startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
            copyLocalizationInfos((CommonToken)a3, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1280]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1281]);
            }

            // Dwprofile.g:5287:0: ( (a4= QUOTED_34_34 ) | (a5= IDENTIFIER_TOKEN ) )
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
                    // Dwprofile.g:5288:0: (a4= QUOTED_34_34 )
                    {
                    // Dwprofile.g:5288:4: (a4= QUOTED_34_34 )
                    // Dwprofile.g:5289:4: a4= QUOTED_34_34
                    {
                    a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3703); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a4 != null) {
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    tokenResolver.setOptions(getOptions());
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_0_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a4, element);
                    copyLocalizationInfos((CommonToken) a4, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1282]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1283]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1284]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1285]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1286]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1287]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1288]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1289]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1290]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1291]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1292]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1293]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1294]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1295]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1296]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1297]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1298]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1299]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1300]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1301]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1302]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1303]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1304]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1305]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1306]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1307]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1308]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1309]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1310]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1311]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1312]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1313]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1314]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1315]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1316]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1317]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1318]);
                    }

                    }
                    break;
                case 2 :
                    // Dwprofile.g:5365:2: (a5= IDENTIFIER_TOKEN )
                    {
                    // Dwprofile.g:5365:2: (a5= IDENTIFIER_TOKEN )
                    // Dwprofile.g:5366:4: a5= IDENTIFIER_TOKEN
                    {
                    a5=(Token)match(input,IDENTIFIER_TOKEN,FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3720); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    throw new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTerminateParsingException();
                    }
                    if (element == null) {
                    element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
                    startIncompleteElement(element);
                    }
                    if (a5 != null) {
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
                    tokenResolver.setOptions(getOptions());
                    de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result = getFreshTokenResolveResult();
                    tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
                    Object resolvedObject = result.getResolvedToken();
                    if (resolvedObject == null) {
                    addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
                    }
                    String resolved = (String) resolvedObject;
                    eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
                    collectHiddenTokens(element);
                    registerContextDependentProxy(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
                    if (proxy != null) {
                    Object value = proxy;
                    element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
                    completedElement(value, false);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_1_0, proxy, true);
                    copyLocalizationInfos((CommonToken) a5, element);
                    copyLocalizationInfos((CommonToken) a5, proxy);
                    }
                    }

                    }


                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1319]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1320]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1321]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1322]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1323]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1324]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1325]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1326]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1327]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1328]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1329]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1330]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1331]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1332]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1333]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1334]);
                    addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1335]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1336]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1337]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1338]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1339]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1340]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1341]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1342]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1343]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1344]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1345]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1346]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1347]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1348]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1349]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1350]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1351]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1352]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1353]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1354]);
                    addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1355]);
                    }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1356]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1357]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1358]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1359]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1360]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1361]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1362]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1363]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1364]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1365]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1366]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1367]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1368]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1369]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1370]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1371]);
            addExpectedElement(de.darwinspl.preferences.PreferencesPackage.eINSTANCE.getDwProfile(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1372]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1373]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1374]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1375]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1376]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1377]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1378]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1379]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1380]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1381]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1382]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1383]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1384]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1385]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1386]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1387]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1388]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1389]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1390]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1391]);
            addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1392]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, parse_eu_hyvar_dataValues_HyEnumValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyEnumValue"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyExpression"
    // Dwprofile.g:5485:1: parse_eu_hyvar_feature_expression_HyExpression returns [eu.hyvar.feature.expression.HyExpression element = null] : c= parseop_HyExpression_level_0 ;
    public final eu.hyvar.feature.expression.HyExpression parse_eu_hyvar_feature_expression_HyExpression() throws RecognitionException {
        eu.hyvar.feature.expression.HyExpression element =  null;

        int parse_eu_hyvar_feature_expression_HyExpression_StartIndex = input.index();

        eu.hyvar.feature.expression.HyExpression c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }

            // Dwprofile.g:5486:3: (c= parseop_HyExpression_level_0 )
            // Dwprofile.g:5487:3: c= parseop_HyExpression_level_0
            {
            pushFollow(FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression3749);
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
            if ( state.backtracking>0 ) { memoize(input, 31, parse_eu_hyvar_feature_expression_HyExpression_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyExpression"



    // $ANTLR start "parse_eu_hyvar_feature_expression_HyVersionRestriction"
    // Dwprofile.g:5491:1: parse_eu_hyvar_feature_expression_HyVersionRestriction returns [eu.hyvar.feature.expression.HyVersionRestriction element = null] : (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction );
    public final eu.hyvar.feature.expression.HyVersionRestriction parse_eu_hyvar_feature_expression_HyVersionRestriction() throws RecognitionException {
        eu.hyvar.feature.expression.HyVersionRestriction element =  null;

        int parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex = input.index();

        eu.hyvar.feature.expression.HyRelativeVersionRestriction c0 =null;

        eu.hyvar.feature.expression.HyVersionRangeRestriction c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return element; }

            // Dwprofile.g:5492:0: (c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction |c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==33) ) {
                switch ( input.LA(2) ) {
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                    {
                    alt40=1;
                    }
                    break;
                case QUOTED_34_34:
                    {
                    int LA40_3 = input.LA(3);

                    if ( (LA40_3==35) ) {
                        alt40=1;
                    }
                    else if ( (LA40_3==20) ) {
                        alt40=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 3, input);

                        throw nvae;

                    }
                    }
                    break;
                case 36:
                    {
                    alt40=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }
            switch (alt40) {
                case 1 :
                    // Dwprofile.g:5493:0: c0= parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3768);
                    c0=parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Dwprofile.g:5494:2: c1= parse_eu_hyvar_feature_expression_HyVersionRangeRestriction
                    {
                    pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3776);
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
            if ( state.backtracking>0 ) { memoize(input, 32, parse_eu_hyvar_feature_expression_HyVersionRestriction_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_feature_expression_HyVersionRestriction"



    // $ANTLR start "parse_eu_hyvar_dataValues_HyValue"
    // Dwprofile.g:5498:1: parse_eu_hyvar_dataValues_HyValue returns [eu.hyvar.dataValues.HyValue element = null] : c= parseop_HyValue_level_15 ;
    public final eu.hyvar.dataValues.HyValue parse_eu_hyvar_dataValues_HyValue() throws RecognitionException {
        eu.hyvar.dataValues.HyValue element =  null;

        int parse_eu_hyvar_dataValues_HyValue_StartIndex = input.index();

        eu.hyvar.dataValues.HyValue c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return element; }

            // Dwprofile.g:5499:3: (c= parseop_HyValue_level_15 )
            // Dwprofile.g:5500:3: c= parseop_HyValue_level_15
            {
            pushFollow(FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue3795);
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
            if ( state.backtracking>0 ) { memoize(input, 33, parse_eu_hyvar_dataValues_HyValue_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_eu_hyvar_dataValues_HyValue"

    // $ANTLR start synpred35_Dwprofile
    public final void synpred35_Dwprofile_fragment() throws RecognitionException {
        Token a0=null;
        eu.hyvar.feature.expression.HyExpression rightArg =null;


        // Dwprofile.g:2965:2: ( () a0= '-' rightArg= parseop_HyExpression_level_13 )
        // Dwprofile.g:2965:2: () a0= '-' rightArg= parseop_HyExpression_level_13
        {
        // Dwprofile.g:2965:2: ()
        // Dwprofile.g:2965:2: 
        {
        }


        a0=(Token)match(input,20,FOLLOW_20_in_synpred35_Dwprofile2555); if (state.failed) return ;

        pushFollow(FOLLOW_parseop_HyExpression_level_13_in_synpred35_Dwprofile2566);
        rightArg=parseop_HyExpression_level_13();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred35_Dwprofile

    // $ANTLR start synpred37_Dwprofile
    public final void synpred37_Dwprofile_fragment() throws RecognitionException {
        Token a0=null;
        eu.hyvar.feature.expression.HyExpression rightArg =null;


        // Dwprofile.g:2964:41: ( ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+ )
        // Dwprofile.g:2964:41: ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+
        {
        // Dwprofile.g:2964:41: ( () a0= '-' rightArg= parseop_HyExpression_level_13 | () a0= '+' rightArg= parseop_HyExpression_level_13 )+
        int cnt50=0;
        loop50:
        do {
            int alt50=3;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==20) ) {
                alt50=1;
            }
            else if ( (LA50_0==18) ) {
                alt50=2;
            }


            switch (alt50) {
        	case 1 :
        	    // Dwprofile.g:2965:0: () a0= '-' rightArg= parseop_HyExpression_level_13
        	    {
        	    // Dwprofile.g:2965:2: ()
        	    // Dwprofile.g:2965:2: 
        	    {
        	    }


        	    a0=(Token)match(input,20,FOLLOW_20_in_synpred37_Dwprofile2555); if (state.failed) return ;

        	    pushFollow(FOLLOW_parseop_HyExpression_level_13_in_synpred37_Dwprofile2566);
        	    rightArg=parseop_HyExpression_level_13();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;
        	case 2 :
        	    // Dwprofile.g:3036:0: () a0= '+' rightArg= parseop_HyExpression_level_13
        	    {
        	    // Dwprofile.g:3036:2: ()
        	    // Dwprofile.g:3036:2: 
        	    {
        	    }


        	    a0=(Token)match(input,18,FOLLOW_18_in_synpred37_Dwprofile2584); if (state.failed) return ;

        	    pushFollow(FOLLOW_parseop_HyExpression_level_13_in_synpred37_Dwprofile2595);
        	    rightArg=parseop_HyExpression_level_13();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt50 >= 1 ) break loop50;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(50, input);
                    throw eee;
            }
            cnt50++;
        } while (true);


        }

    }
    // $ANTLR end synpred37_Dwprofile

    // $ANTLR start synpred49_Dwprofile
    public final void synpred49_Dwprofile_fragment() throws RecognitionException {
        eu.hyvar.feature.expression.HyValueExpression c5 =null;


        // Dwprofile.g:3448:2: (c5= parse_eu_hyvar_feature_expression_HyValueExpression )
        // Dwprofile.g:3448:2: c5= parse_eu_hyvar_feature_expression_HyValueExpression
        {
        pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_synpred49_Dwprofile2856);
        c5=parse_eu_hyvar_feature_expression_HyValueExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred49_Dwprofile

    // $ANTLR start synpred50_Dwprofile
    public final void synpred50_Dwprofile_fragment() throws RecognitionException {
        eu.hyvar.feature.expression.HyBooleanValueExpression c6 =null;


        // Dwprofile.g:3449:2: (c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression )
        // Dwprofile.g:3449:2: c6= parse_eu_hyvar_feature_expression_HyBooleanValueExpression
        {
        pushFollow(FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_synpred50_Dwprofile2864);
        c6=parse_eu_hyvar_feature_expression_HyBooleanValueExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred50_Dwprofile

    // Delegated rules

    public final boolean synpred35_Dwprofile() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_Dwprofile_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_Dwprofile() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_Dwprofile_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_Dwprofile() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_Dwprofile_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_Dwprofile() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_Dwprofile_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_parse_de_darwinspl_preferences_DwProfile_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_de_darwinspl_preferences_DwPreference_in_parse_de_darwinspl_preferences_DwProfile124 = new BitSet(new long[]{0x00001F6040109262L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_de_darwinspl_preferences_DwPreference169 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_parse_de_darwinspl_preferences_DwPreference196 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_de_darwinspl_preferences_DwPreference229 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_de_darwinspl_preferences_DwPreference268 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_de_darwinspl_preferences_DwPreference298 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_DATE_in_parse_de_darwinspl_preferences_DwPreference354 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_de_darwinspl_preferences_DwPreference393 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_parse_de_darwinspl_preferences_DwPreference416 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_39_in_parse_de_darwinspl_preferences_DwPreference449 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_de_darwinspl_preferences_DwPreference472 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DATE_in_parse_de_darwinspl_preferences_DwPreference502 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_de_darwinspl_preferences_DwPreference554 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_25_in_parseop_HyExpression_level_02077 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_1_in_parseop_HyExpression_level_02094 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_12140 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_parseop_HyExpression_level_12156 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_4_in_parseop_HyExpression_level_12170 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_42211 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_parseop_HyExpression_level_42224 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_5_in_parseop_HyExpression_level_42235 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_52273 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_parseop_HyExpression_level_52286 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_9_in_parseop_HyExpression_level_52297 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92335 = new BitSet(new long[]{0x000000003D002002L});
    public static final BitSet FOLLOW_24_in_parseop_HyExpression_level_92348 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92359 = new BitSet(new long[]{0x000000003D002002L});
    public static final BitSet FOLLOW_26_in_parseop_HyExpression_level_92377 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92388 = new BitSet(new long[]{0x000000003D002002L});
    public static final BitSet FOLLOW_28_in_parseop_HyExpression_level_92406 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92417 = new BitSet(new long[]{0x000000003D002002L});
    public static final BitSet FOLLOW_29_in_parseop_HyExpression_level_92435 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92446 = new BitSet(new long[]{0x000000003D002002L});
    public static final BitSet FOLLOW_27_in_parseop_HyExpression_level_92464 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92475 = new BitSet(new long[]{0x000000003D002002L});
    public static final BitSet FOLLOW_13_in_parseop_HyExpression_level_92493 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_12_in_parseop_HyExpression_level_92504 = new BitSet(new long[]{0x000000003D002002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122542 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_20_in_parseop_HyExpression_level_122555 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122566 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_18_in_parseop_HyExpression_level_122584 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_13_in_parseop_HyExpression_level_122595 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132633 = new BitSet(new long[]{0x0000000400820002L});
    public static final BitSet FOLLOW_34_in_parseop_HyExpression_level_132646 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132657 = new BitSet(new long[]{0x0000000400820002L});
    public static final BitSet FOLLOW_17_in_parseop_HyExpression_level_132675 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132686 = new BitSet(new long[]{0x0000000400820002L});
    public static final BitSet FOLLOW_23_in_parseop_HyExpression_level_132704 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_14_in_parseop_HyExpression_level_132715 = new BitSet(new long[]{0x0000000400820002L});
    public static final BitSet FOLLOW_12_in_parseop_HyExpression_level_142753 = new BitSet(new long[]{0x00001F6040008260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parseop_HyExpression_level_142773 = new BitSet(new long[]{0x00001F6040008260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_15_in_parseop_HyExpression_level_142794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyNestedExpression_in_parseop_HyExpression_level_152816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression_in_parseop_HyExpression_level_152824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression_in_parseop_HyExpression_level_152832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression_in_parseop_HyExpression_level_152840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression_in_parseop_HyExpression_level_152848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_parseop_HyExpression_level_152856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_parseop_HyExpression_level_152864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyMinimumExpression_in_parseop_HyExpression_level_152872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyMaximumExpression_in_parseop_HyExpression_level_152880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyIfPossibleExpression_in_parseop_HyExpression_level_152888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_eu_hyvar_feature_expression_HyNestedExpression2910 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyNestedExpression2923 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyNestedExpression2935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2965 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression2982 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression3006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3041 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3056 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3073 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRestriction_in_parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression3093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3120 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression3152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3189 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3206 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3224 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression3237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyValue_in_parse_eu_hyvar_feature_expression_HyValueExpression3267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_feature_expression_HyBooleanValueExpression3307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_parse_eu_hyvar_feature_expression_HyMinimumExpression3337 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMinimumExpression3350 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyMinimumExpression3362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_parse_eu_hyvar_feature_expression_HyMaximumExpression3388 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyMaximumExpression3401 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyMaximumExpression3413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3439 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3452 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_19_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3468 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyExpression_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3481 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_16_in_parse_eu_hyvar_feature_expression_HyIfPossibleExpression3501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyNumberValue_in_parseop_HyValue_level_153527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyBooleanValue_in_parseop_HyValue_level_153535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_dataValues_HyEnumValue_in_parseop_HyValue_level_153543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_eu_hyvar_dataValues_HyNumberValue3567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_eu_hyvar_dataValues_HyBooleanValue3599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_eu_hyvar_dataValues_HyBooleanValue3608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_eu_hyvar_dataValues_HyEnumValue3638 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3653 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3670 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_eu_hyvar_dataValues_HyEnumValue3688 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_eu_hyvar_dataValues_HyEnumValue3703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_TOKEN_in_parse_eu_hyvar_dataValues_HyEnumValue3720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_0_in_parse_eu_hyvar_feature_expression_HyExpression3749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyVersionRangeRestriction_in_parse_eu_hyvar_feature_expression_HyVersionRestriction3776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_HyValue_level_15_in_parse_eu_hyvar_dataValues_HyValue3795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_synpred35_Dwprofile2555 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_13_in_synpred35_Dwprofile2566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_synpred37_Dwprofile2555 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_13_in_synpred37_Dwprofile2566 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_18_in_synpred37_Dwprofile2584 = new BitSet(new long[]{0x00001F6040109260L});
    public static final BitSet FOLLOW_parseop_HyExpression_level_13_in_synpred37_Dwprofile2595 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyValueExpression_in_synpred49_Dwprofile2856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_eu_hyvar_feature_expression_HyBooleanValueExpression_in_synpred50_Dwprofile2864 = new BitSet(new long[]{0x0000000000000002L});

}