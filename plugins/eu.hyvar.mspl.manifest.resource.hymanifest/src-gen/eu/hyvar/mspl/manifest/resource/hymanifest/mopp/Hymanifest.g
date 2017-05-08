grammar Hymanifest;

options {
	superClass = HymanifestANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;
	
	import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.RecognitionException;
}

@lexer::members {
	public List<RecognitionException> lexerExceptions  = new ArrayList<RecognitionException>();
	public List<Integer> lexerExceptionPositions = new ArrayList<Integer>();
	
	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionPositions.add(((ANTLRStringStream) input).index());
	}
}
@header{
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
}

@members{
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
	
	public void addExpectedElement(EClass eClass, int expectationStartIndex, int expectationEndIndex) {
		for (int expectationIndex = expectationStartIndex; expectationIndex <= expectationEndIndex; expectationIndex++) {
			addExpectedElement(eClass, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[expectationIndex]);
		}
	}
	
	public void addExpectedElement(EClass eClass, int expectationIndex) {
		addExpectedElement(eClass, eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestExpectationConstants.EXPECTATIONS[expectationIndex]);
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
	
}

start returns [ EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(null, 0, 1);
		expectedElementsIndexOfLastCompleteElement = 1;
	}
	(
		c0 = parse_eu_hyvar_mspl_manifest_HySPLImplementation{ element = c0; }
		|  		c1 = parse_eu_hyvar_mspl_manifest_HySPLSignature{ element = c1; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_eu_hyvar_mspl_manifest_HySPLImplementation returns [eu.hyvar.mspl.manifest.HySPLImplementation element = null]
@init{
}
:
	a0 = 'Implementation ' {
		if (element == null) {
			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), 2);
	}
	
	(
		a1_0 = parse_eu_hyvar_evolution_HyName		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 3, 5);
	}
	
	(
		(
			a2 = ',' {
				if (element == null) {
					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), 6);
			}
			
			(
				a3_0 = parse_eu_hyvar_evolution_HyName				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 7, 9);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, 10, 12);
	}
	
	(
		(
			a4 = '(' {
				if (element == null) {
					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), 13);
			}
			
			(
				a5_0 = parse_eu_hyvar_mspl_manifest_HyTimedDependencies				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 14, 15);
			}
			
			(
				(
					a6 = ',' {
						if (element == null) {
							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_3_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((CommonToken)a6, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), 16);
					}
					
					(
						a7_0 = parse_eu_hyvar_mspl_manifest_HyTimedDependencies						{
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
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, 17, 18);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, 19, 20);
			}
			
			a8 = ')' {
				if (element == null) {
					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_3_0_0_3, null, true);
				copyLocalizationInfos((CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 21);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, 22);
	}
	
	(
		(
			a9 = ':' {
				if (element == null) {
					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), 23);
			}
			
			(
				a10_0 = parse_eu_hyvar_mspl_manifest_HyTimedImplementations				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 24);
			}
			
			(
				(
					a11 = ',' {
						if (element == null) {
							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLImplementation();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_0_0_0_4_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((CommonToken)a11, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(), 25);
					}
					
					(
						a12_0 = parse_eu_hyvar_mspl_manifest_HyTimedImplementations						{
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
					)
					{
						// expected elements (follow set)
						// We've found the last token for this rule. The constructed EObject is now
						// complete.
						completedElement(element, true);
						addExpectedElement(null, 26);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 27);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
	}
	
;

parse_eu_hyvar_mspl_manifest_HyTimedDependencies returns [eu.hyvar.mspl.manifest.HyTimedDependencies element = null]
@init{
}
:
	(
		a0 = QUOTED_60_62		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 28, 30);
	}
	
	(
		(
			a1 = '@[' {
				if (element == null) {
					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 31, 33);
			}
			
			(
				(
					a2 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 34);
				}
				
				a3 = '-' {
					if (element == null) {
						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a3, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 35);
				}
				
				(
					a4 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 36);
				}
				
				
				|				(
					a5 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 37);
				}
				
				a6 = '-' {
					if (element == null) {
						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 38);
				}
				
				a7 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 39);
				}
				
				
				|				a8 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a8, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 40);
				}
				
				a9 = '-' {
					if (element == null) {
						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 41);
				}
				
				(
					a10 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 42);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 43);
			}
			
			a11 = ']' {
				if (element == null) {
					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedDependencies();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_1_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 44, 45);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 46, 47);
	}
	
;

parse_eu_hyvar_mspl_manifest_HyTimedImplementations returns [eu.hyvar.mspl.manifest.HyTimedImplementations element = null]
@init{
}
:
	(
		a0 = QUOTED_60_62		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 48, 49);
	}
	
	(
		(
			a1 = '@[' {
				if (element == null) {
					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 50, 52);
			}
			
			(
				(
					a2 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 53);
				}
				
				a3 = '-' {
					if (element == null) {
						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a3, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 54);
				}
				
				(
					a4 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 55);
				}
				
				
				|				(
					a5 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 56);
				}
				
				a6 = '-' {
					if (element == null) {
						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 57);
				}
				
				a7 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 58);
				}
				
				
				|				a8 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a8, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 59);
				}
				
				a9 = '-' {
					if (element == null) {
						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 60);
				}
				
				(
					a10 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 61);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 62);
			}
			
			a11 = ']' {
				if (element == null) {
					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 63);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, 64);
	}
	
	a12 = '{' {
		if (element == null) {
			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a12, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(), 65, 66);
		addExpectedElement(null, 67);
	}
	
	(
		(
			(
				a13_0 = parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 68, 69);
			}
			
			(
				(
					a14 = ',' {
						if (element == null) {
							element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((CommonToken)a14, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHyTimedImplementations(), 70, 71);
					}
					
					(
						a15_0 = parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink						{
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
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, 72, 73);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, 74, 75);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, 76);
	}
	
	a16 = '}' {
		if (element == null) {
			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementations();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_2_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a16, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 77);
	}
	
;

parse_eu_hyvar_mspl_manifest_HyTimedImplementationLink returns [eu.hyvar.mspl.manifest.HyTimedImplementationLink element = null]
@init{
}
:
	(
		(
			a0 = QUOTED_34_34			
			{
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
						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_0_0_0_0, proxy, true);
					copyLocalizationInfos((CommonToken) a0, element);
					copyLocalizationInfos((CommonToken) a0, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 78);
		}
		
		
		|		(
			a1 = IDENTIFIER_TOKEN			
			{
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
						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__LOCAL), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_0_0_1_0, proxy, true);
					copyLocalizationInfos((CommonToken) a1, element);
					copyLocalizationInfos((CommonToken) a1, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 79);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 80);
	}
	
	a2 = '->' {
		if (element == null) {
			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 81, 82);
	}
	
	(
		(
			a3 = QUOTED_34_34			
			{
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
						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_2_0_0_0, proxy, true);
					copyLocalizationInfos((CommonToken) a3, element);
					copyLocalizationInfos((CommonToken) a3, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 83, 85);
		}
		
		
		|		(
			a4 = IDENTIFIER_TOKEN			
			{
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
						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.mspl.manifest.ManifestPackage.HY_TIMED_IMPLEMENTATION_LINK__SIGNATURE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_2_0_1_0, proxy, true);
					copyLocalizationInfos((CommonToken) a4, element);
					copyLocalizationInfos((CommonToken) a4, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 86, 88);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 89, 91);
	}
	
	(
		(
			a5 = '@[' {
				if (element == null) {
					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 92, 94);
			}
			
			(
				(
					a6 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 95);
				}
				
				a7 = '-' {
					if (element == null) {
						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 96);
				}
				
				(
					a8 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 97);
				}
				
				
				|				(
					a9 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 98);
				}
				
				a10 = '-' {
					if (element == null) {
						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a10, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 99);
				}
				
				a11 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 100);
				}
				
				
				|				a12 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 101);
				}
				
				a13 = '-' {
					if (element == null) {
						element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 102);
				}
				
				(
					a14 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 103);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 104);
			}
			
			a15 = ']' {
				if (element == null) {
					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHyTimedImplementationLink();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_3_0_0_3_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 105, 106);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 107, 108);
	}
	
;

parse_eu_hyvar_mspl_manifest_HySPLSignature returns [eu.hyvar.mspl.manifest.HySPLSignature element = null]
@init{
}
:
	a0 = 'Signature ' {
		if (element == null) {
			element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLSignature();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLSignature(), 109);
	}
	
	(
		a1_0 = parse_eu_hyvar_evolution_HyName		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 110);
	}
	
	(
		(
			a2 = ',' {
				if (element == null) {
					element = eu.hyvar.mspl.manifest.ManifestFactory.eINSTANCE.createHySPLSignature();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_4_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLSignature(), 111);
			}
			
			(
				a3_0 = parse_eu_hyvar_evolution_HyName				{
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
			)
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 112);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 113);
	}
	
;

parse_eu_hyvar_evolution_HyName returns [eu.hyvar.evolution.HyName element = null]
@init{
}
:
	(
		a0 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 114, 118);
	}
	
	(
		(
			a1 = '@[' {
				if (element == null) {
					element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 119, 121);
			}
			
			(
				(
					a2 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 122);
				}
				
				a3 = '-' {
					if (element == null) {
						element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a3, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 123);
				}
				
				(
					a4 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 124);
				}
				
				
				|				(
					a5 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 125);
				}
				
				a6 = '-' {
					if (element == null) {
						element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 126);
				}
				
				a7 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 127);
				}
				
				
				|				a8 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a8, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 128);
				}
				
				a9 = '-' {
					if (element == null) {
						element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 129);
				}
				
				(
					a10 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 130);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 131);
			}
			
			a11 = ']' {
				if (element == null) {
					element = eu.hyvar.evolution.HyEvolutionFactory.eINSTANCE.createHyName();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYMANIFEST_5_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 132, 135);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 136, 139);
	}
	
;

parse_eu_hyvar_dataValues_HyEnum returns [eu.hyvar.dataValues.HyEnum element = null]
@init{
}
:
	a0 = 'Enum(' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 140);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 141);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 142);
		addExpectedElement(null, 143);
	}
	
	(
		(
			(
				a3_0 = parse_eu_hyvar_dataValues_HyEnumLiteral				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 144, 145);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 146);
					}
					
					(
						a5_0 = parse_eu_hyvar_dataValues_HyEnumLiteral						{
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
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, 147, 148);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, 149, 150);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, 151);
	}
	
	a6 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 152);
	}
	
	(
		(
			a7 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 153, 155);
			}
			
			(
				(
					a8 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 156);
				}
				
				a9 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 157);
				}
				
				(
					a10 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 158);
				}
				
				
				|				(
					a11 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 159);
				}
				
				a12 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 160);
				}
				
				
				|				a13 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 161);
				}
				
				a14 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 162);
				}
				
				(
					a15 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 163);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 164);
			}
			
			a16 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a16, element);
			}
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
	}
	
;

parse_eu_hyvar_dataValues_HyEnumLiteral returns [eu.hyvar.dataValues.HyEnumLiteral element = null]
@init{
}
:
	a0 = 'EnumLiteral(' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 165);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 166);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 167);
	}
	
	(
		a3 = INTEGER_LITERAL		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 168);
	}
	
	a4 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 169, 171);
	}
	
	(
		(
			a5 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 172, 174);
			}
			
			(
				(
					a6 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 175);
				}
				
				a7 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 176);
				}
				
				(
					a8 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 177);
				}
				
				
				|				(
					a9 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 178);
				}
				
				a10 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a10, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 179);
				}
				
				a11 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 180);
				}
				
				
				|				a12 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 181);
				}
				
				a13 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 182);
				}
				
				(
					a14 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 183);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 184);
			}
			
			a15 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 185, 186);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 187, 188);
	}
	
;

parseop_HyValue_level_15 returns [eu.hyvar.dataValues.HyValue element = null]
@init{
}
:
	c0 = parse_eu_hyvar_dataValues_HyNumberValue{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_eu_hyvar_dataValues_HyBooleanValue{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_eu_hyvar_dataValues_HyEnumValue{ element = c2; /* this is a subclass or primitive expression choice */ }
;

parse_eu_hyvar_dataValues_HyNumberValue returns [eu.hyvar.dataValues.HyNumberValue element = null]
@init{
}
:
	(
		a0 = INTEGER_LITERAL		
		{
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
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
	}
	
;

parse_eu_hyvar_dataValues_HyBooleanValue returns [eu.hyvar.dataValues.HyBooleanValue element = null]
@init{
}
:
	(
		(
			a0 = 'true' {
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
			|			a1 = 'false' {
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
		)
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
	}
	
;

parse_eu_hyvar_dataValues_HyEnumValue returns [eu.hyvar.dataValues.HyEnumValue element = null]
@init{
}
:
	a0 = 'enum:' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 189);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 190);
	}
	
	a2 = '.' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 191);
	}
	
	(
		a3 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
	}
	
;

QUOTED_60_62:
	(('<')(~('>'))*('>'))
;
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;
IDENTIFIER_TOKEN:
	(('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'_'|'0'..'9')* ('@'(('-')? ('0'..'9')+ '/'('-')? ('0'..'9')+ '/'('-')? ('0'..'9')+ ( 'T'('-')? ('0'..'9')+ ':'('-')? ('0'..'9')+ (':' ('-')? ('0'..'9')+ )?)?))?)
;
DATE:
	((('-')? ('0'..'9')+ '/'('-')? ('0'..'9')+ '/'('-')? ('0'..'9')+ ( 'T'('-')? ('0'..'9')+ ':'('-')? ('0'..'9')+ (':' ('-')? ('0'..'9')+ )?)?))
;
INTEGER_LITERAL:
	(('-')? ('0'..'9')+ )
;
SL_COMMENT:
	('//'(~('\n'|'\r'|'\uffff'))*)
	{ _channel = 99; }
;
ML_COMMENT:
	('/*'.*'*/')
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n'|'\r'|'\n'))
	{ _channel = 99; }
;
WHITESPACE:
	((' '|'\t'|'\f'))
	{ _channel = 99; }
;

