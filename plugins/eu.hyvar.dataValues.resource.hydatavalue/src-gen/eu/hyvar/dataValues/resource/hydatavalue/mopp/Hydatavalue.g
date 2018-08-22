grammar Hydatavalue;

options {
	superClass = HydatavalueANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package eu.hyvar.dataValues.resource.hydatavalue.mopp;
	
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
	package eu.hyvar.dataValues.resource.hydatavalue.mopp;
	
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
	private eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolverFactory tokenResolverFactory = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTokenResolverFactory();
	
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
	private List<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal> expectedElements = new ArrayList<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal>();
	
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
	
	private eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueLocationMap locationMap;
	
	private eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueSyntaxErrorMessageConverter syntaxErrorMessageConverter = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueSyntaxErrorMessageConverter(tokenNames);
	
	@Override
	public void reportError(RecognitionException re) {
		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
	}
	
	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
		postParseCommands.add(new eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueCommand<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource>() {
			public boolean execute(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueProblem() {
					public eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemSeverity getSeverity() {
						return eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemSeverity.ERROR;
					}
					public eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemType getType() {
						return eu.hyvar.dataValues.resource.hydatavalue.HydatavalueEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	protected void addErrorToResource(eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueLocalizedMessage message) {
		if (message == null) {
			return;
		}
		addErrorToResource(message.getMessage(), message.getColumn(), message.getLine(), message.getCharStart(), message.getCharEnd());
	}
	
	public void addExpectedElement(EClass eClass, int expectationStartIndex, int expectationEndIndex) {
		for (int expectationIndex = expectationStartIndex; expectationIndex <= expectationEndIndex; expectationIndex++) {
			addExpectedElement(eClass, eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectationConstants.EXPECTATIONS[expectationIndex]);
		}
	}
	
	public void addExpectedElement(EClass eClass, int expectationIndex) {
		addExpectedElement(eClass, eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectationConstants.EXPECTATIONS[expectationIndex]);
	}
	
	public void addExpectedElement(EClass eClass, int[] ids) {
		if (!this.rememberExpectedElements) {
			return;
		}
		int terminalID = ids[0];
		int followSetID = ids[1];
		eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueExpectedElement terminal = eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueFollowSetProvider.TERMINALS[terminalID];
		eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[] containmentFeatures = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueFollowSetProvider.LINKS[ids[i]];
		}
		eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueContainmentTrace containmentTrace = new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueContainmentTrace(eClass, containmentFeatures);
		EObject container = getLastIncompleteElement();
		eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal expectedElement = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
		final eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueCommand<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource>() {
			public boolean execute(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource resource) {
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
		final eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueCommand<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource>() {
			public boolean execute(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource resource) {
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
	protected void setLocalizationEnd(Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueCommand<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		final eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueCommand<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource>() {
			public boolean execute(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource resource) {
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
				return true;
			}
		});
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextParser createInstance(InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new HydatavalueParser(new CommonTokenStream(new HydatavalueLexer(new ANTLRInputStream(actualInputStream))));
			} else {
				return new HydatavalueParser(new CommonTokenStream(new HydatavalueLexer(new ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (IOException e) {
			new eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public HydatavalueParser() {
		super(null);
	}
	
	protected EObject doParse() throws RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((HydatavalueLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((HydatavalueLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof EClass) {
			EClass type = (EClass) typeObject;
			if (type.getInstanceClass() == eu.hyvar.dataValues.HyEnum.class) {
				return parse_eu_hyvar_dataValues_HyEnum();
			}
			if (type.getInstanceClass() == eu.hyvar.dataValues.HyEnumLiteral.class) {
				return parse_eu_hyvar_dataValues_HyEnumLiteral();
			}
		}
		throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueUnexpectedContentTypeException(typeObject);
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
			typeObject = options.get(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueParseResult parse() {
		// Reset parser state
		terminateParsing = false;
		postParseCommands = new ArrayList<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueCommand<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource>>();
		eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueParseResult parseResult = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueParseResult();
		if (disableLocationMap) {
			locationMap = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueDevNullLocationMap();
		} else {
			locationMap = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueLocationMap();
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
	
	public List<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal> parseToExpectedElements(EClass type, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
		eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueParseResult result = parse();
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
			for (eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueCommand<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		Set<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal> currentFollowSet = new LinkedHashSet<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal>();
		List<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal> newFollowSet = new ArrayList<eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 50;
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
				for (eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						Collection<eu.hyvar.dataValues.resource.hydatavalue.util.HydatavaluePair<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueExpectedElement, eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (eu.hyvar.dataValues.resource.hydatavalue.util.HydatavaluePair<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueExpectedElement, eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[]> newFollowerPair : newFollowers) {
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueExpectedElement newFollower = newFollowerPair.getLeft();
							EObject container = getLastIncompleteElement();
							eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueContainmentTrace containmentTrace = new eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueContainmentTrace(null, newFollowerPair.getRight());
							eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal newFollowTerminal = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
		for (eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueExpectedTerminal expectedElement, int tokenIndex) {
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
		addExpectedElement(null, 0, 4);
		expectedElementsIndexOfLastCompleteElement = 4;
	}
	(
		c0 = parse_eu_hyvar_dataValues_HyValue{ element = c0; }
		|  		c1 = parse_eu_hyvar_dataValues_HyEnum{ element = c1; }
		|  		c2 = parse_eu_hyvar_dataValues_HyEnumLiteral{ element = c2; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
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
		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
			if (terminateParsing) {
				throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_1, resolved, true);
				copyLocalizationInfos((CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 6);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 7);
		addExpectedElement(null, 8);
	}
	
	(
		(
			(
				a3_0 = parse_eu_hyvar_dataValues_HyEnumLiteral				{
					if (terminateParsing) {
						throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
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
						retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_0, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 9, 10);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 11);
					}
					
					(
						a5_0 = parse_eu_hyvar_dataValues_HyEnumLiteral						{
							if (terminateParsing) {
								throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
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
								retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_1, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, 12, 13);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, 14, 15);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, 16);
	}
	
	a6 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 17);
	}
	
	(
		(
			a7 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 18, 20);
			}
			
			(
				(
					a8 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a8 != null) {
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, resolved, true);
							copyLocalizationInfos((CommonToken) a8, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 21);
				}
				
				a9 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 22);
				}
				
				(
					a10 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a10 != null) {
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_2, resolved, true);
							copyLocalizationInfos((CommonToken) a10, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 23);
				}
				
				
				|				(
					a11 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a11 != null) {
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, resolved, true);
							copyLocalizationInfos((CommonToken) a11, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 24);
				}
				
				a12 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 25);
				}
				
				
				|				a13 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 26);
				}
				
				a14 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 27);
				}
				
				(
					a15 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a15 != null) {
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_2, resolved, true);
							copyLocalizationInfos((CommonToken) a15, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 28);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 29);
			}
			
			a16 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
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
		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 30);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
			if (terminateParsing) {
				throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_1, resolved, true);
				copyLocalizationInfos((CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 31);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 32);
	}
	
	(
		a3 = INTEGER_LITERAL		
		{
			if (terminateParsing) {
				throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
				startIncompleteElement(element);
			}
			if (a3 != null) {
				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_3, resolved, true);
				copyLocalizationInfos((CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 33);
	}
	
	a4 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 34, 36);
	}
	
	(
		(
			a5 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 37, 39);
			}
			
			(
				(
					a6 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a6 != null) {
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, resolved, true);
							copyLocalizationInfos((CommonToken) a6, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 40);
				}
				
				a7 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 41);
				}
				
				(
					a8 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a8 != null) {
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_2, resolved, true);
							copyLocalizationInfos((CommonToken) a8, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 42);
				}
				
				
				|				(
					a9 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a9 != null) {
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, resolved, true);
							copyLocalizationInfos((CommonToken) a9, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 43);
				}
				
				a10 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a10, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 44);
				}
				
				a11 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 45);
				}
				
				
				|				a12 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 46);
				}
				
				a13 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 47);
				}
				
				(
					a14 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a14 != null) {
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_2, resolved, true);
							copyLocalizationInfos((CommonToken) a14, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 48);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 49);
			}
			
			a15 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 50, 51);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 52, 53);
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
				throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyNumberValue();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
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
				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_0_0_0_0, resolved, true);
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
				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_1_0_0_0, true, true);
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
				retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_1_0_0_0, false, true);
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
		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 54, 55);
	}
	
	(
		(
			a1 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
				}
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
					startIncompleteElement(element);
				}
				if (a1 != null) {
					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					collectHiddenTokens(element);
					registerContextDependentProxy(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_0_0, proxy, true);
					copyLocalizationInfos((CommonToken) a1, element);
					copyLocalizationInfos((CommonToken) a1, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 56);
		}
		
		
		|		(
			a2 = IDENTIFIER_TOKEN			
			{
				if (terminateParsing) {
					throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
				}
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
					startIncompleteElement(element);
				}
				if (a2 != null) {
					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
					tokenResolver.setOptions(getOptions());
					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					collectHiddenTokens(element);
					registerContextDependentProxy(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_1_0, proxy, true);
					copyLocalizationInfos((CommonToken) a2, element);
					copyLocalizationInfos((CommonToken) a2, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 57);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 58);
	}
	
	a3 = '.' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 59, 60);
	}
	
	(
		(
			a4 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
				}
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
					startIncompleteElement(element);
				}
				if (a4 != null) {
					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					collectHiddenTokens(element);
					registerContextDependentProxy(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_0_0, proxy, true);
					copyLocalizationInfos((CommonToken) a4, element);
					copyLocalizationInfos((CommonToken) a4, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
		}
		
		
		|		(
			a5 = IDENTIFIER_TOKEN			
			{
				if (terminateParsing) {
					throw new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTerminateParsingException();
				}
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
					startIncompleteElement(element);
				}
				if (a5 != null) {
					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
					tokenResolver.setOptions(getOptions());
					eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					collectHiddenTokens(element);
					registerContextDependentProxy(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_1_0, proxy, true);
					copyLocalizationInfos((CommonToken) a5, element);
					copyLocalizationInfos((CommonToken) a5, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			// We've found the last token for this rule. The constructed EObject is now
			// complete.
			completedElement(element, true);
		}
		
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
	}
	
;

parse_eu_hyvar_dataValues_HyValue returns [eu.hyvar.dataValues.HyValue element = null]
:
	c = parseop_HyValue_level_15{ element = c; /* this rule is an expression root */ }
	
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
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;

