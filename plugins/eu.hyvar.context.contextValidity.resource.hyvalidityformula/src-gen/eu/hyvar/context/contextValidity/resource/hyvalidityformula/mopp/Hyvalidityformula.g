grammar Hyvalidityformula;

options {
	superClass = HyvalidityformulaANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;
	
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
	package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;
	
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
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolverFactory tokenResolverFactory = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTokenResolverFactory();
	
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
	private List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal> expectedElements = new ArrayList<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal>();
	
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
	
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaLocationMap locationMap;
	
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaSyntaxErrorMessageConverter syntaxErrorMessageConverter = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaSyntaxErrorMessageConverter(tokenNames);
	
	@Override
	public void reportError(RecognitionException re) {
		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
	}
	
	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
		postParseCommands.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource>() {
			public boolean execute(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaProblem() {
					public eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemSeverity getSeverity() {
						return eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemSeverity.ERROR;
					}
					public eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemType getType() {
						return eu.hyvar.context.contextValidity.resource.hyvalidityformula.HyvalidityformulaEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	protected void addErrorToResource(eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaLocalizedMessage message) {
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
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaExpectedElement terminal = eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaFollowSetProvider.TERMINALS[terminalID];
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContainedFeature[] containmentFeatures = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaFollowSetProvider.LINKS[ids[i]];
		}
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainmentTrace containmentTrace = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainmentTrace(eClass, containmentFeatures);
		EObject container = getLastIncompleteElement();
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal expectedElement = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
		final eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource>() {
			public boolean execute(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource resource) {
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
		final eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource>() {
			public boolean execute(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource resource) {
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
	protected void setLocalizationEnd(Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		final eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource>() {
			public boolean execute(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource resource) {
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
				return true;
			}
		});
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextParser createInstance(InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new HyvalidityformulaParser(new CommonTokenStream(new HyvalidityformulaLexer(new ANTLRInputStream(actualInputStream))));
			} else {
				return new HyvalidityformulaParser(new CommonTokenStream(new HyvalidityformulaLexer(new ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (IOException e) {
			new eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public HyvalidityformulaParser() {
		super(null);
	}
	
	protected EObject doParse() throws RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((HyvalidityformulaLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((HyvalidityformulaLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof EClass) {
			EClass type = (EClass) typeObject;
			if (type.getInstanceClass() == eu.hyvar.context.contextValidity.HyValidityModel.class) {
				return parse_eu_hyvar_context_contextValidity_HyValidityModel();
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
		throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaUnexpectedContentTypeException(typeObject);
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
			typeObject = options.get(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaParseResult parse() {
		// Reset parser state
		terminateParsing = false;
		postParseCommands = new ArrayList<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource>>();
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaParseResult parseResult = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaParseResult();
		if (disableLocationMap) {
			locationMap = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaDevNullLocationMap();
		} else {
			locationMap = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaLocationMap();
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
	
	public List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal> parseToExpectedElements(EClass type, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaParseResult result = parse();
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
			for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaCommand<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		Set<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal> currentFollowSet = new LinkedHashSet<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal>();
		List<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal> newFollowSet = new ArrayList<eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 148;
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
				for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaPair<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaExpectedElement, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaPair<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaExpectedElement, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContainedFeature[]> newFollowerPair : newFollowers) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaExpectedElement newFollower = newFollowerPair.getLeft();
							EObject container = getLastIncompleteElement();
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainmentTrace containmentTrace = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaContainmentTrace(null, newFollowerPair.getRight());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal newFollowTerminal = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
		for (eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectedTerminal expectedElement, int tokenIndex) {
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
	
}

start returns [ EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[0]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[2]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[3]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_eu_hyvar_context_contextValidity_HyValidityModel{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_eu_hyvar_context_contextValidity_HyValidityModel returns [eu.hyvar.context.contextValidity.HyValidityModel element = null]
@init{
}
:
	(
		(
			a0_0 = parse_eu_hyvar_context_contextValidity_HyValidityFormula			{
				if (terminateParsing) {
					throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
				}
				if (element == null) {
					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyValidityModel();
					startIncompleteElement(element);
				}
				if (a0_0 != null) {
					if (a0_0 != null) {
						Object value = a0_0;
						addObjectToList(element, eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_VALIDITY_MODEL__VALIDITY_FORMULAS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_0_0_0_0, a0_0, true);
					copyLocalizationInfos(a0_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[4]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[5]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[6]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[7]);
	}
	
;

parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction returns [eu.hyvar.feature.expression.HyRelativeVersionRestriction element = null]
@init{
}
:
	a0 = '[' {
		if (element == null) {
			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[8]);
	}
	
	(
		(
			a1 = '<' {
				if (element == null) {
					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
				completedElement(value, false);
			}
			|			a2 = '<=' {
				if (element == null) {
					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
				completedElement(value, false);
			}
			|			a3 = '=' {
				if (element == null) {
					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.EQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
				completedElement(value, false);
			}
			|			a4 = '>=' {
				if (element == null) {
					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
				completedElement(value, false);
			}
			|			a5 = '>' {
				if (element == null) {
					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[9]);
	}
	
	(
		a8 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
			}
			if (a8 != null) {
				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
				collectHiddenTokens(element);
				registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyRelativeVersionRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyRelativeVersionRestrictionVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_2, proxy, true);
				copyLocalizationInfos((CommonToken) a8, element);
				copyLocalizationInfos((CommonToken) a8, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[10]);
	}
	
	a9 = ']' {
		if (element == null) {
			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_27_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[11]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[12]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[13]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[14]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[15]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[16]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[17]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[18]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[19]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[20]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[21]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[22]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[23]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[24]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[25]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[26]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[28]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[29]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[30]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[31]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[32]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[33]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[34]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[35]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[36]);
	}
	
;

parse_eu_hyvar_feature_expression_HyVersionRangeRestriction returns [eu.hyvar.feature.expression.HyVersionRangeRestriction element = null]
@init{
}
:
	a0 = '[' {
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
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_28_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[37]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[38]);
	}
	
	(
		(
			a1 = '^' {
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
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_28_0_0_1, false, true);
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of boolean attribute
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[39]);
	}
	
	(
		a3 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
				collectHiddenTokens(element);
				registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionLowerVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_28_0_0_2, proxy, true);
				copyLocalizationInfos((CommonToken) a3, element);
				copyLocalizationInfos((CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[40]);
	}
	
	a4 = '-' {
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
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_28_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[41]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[42]);
	}
	
	(
		(
			a5 = '^' {
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
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_28_0_0_4, false, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of boolean attribute
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[43]);
	}
	
	(
		a7 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
				collectHiddenTokens(element);
				registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionUpperVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_28_0_0_5, proxy, true);
				copyLocalizationInfos((CommonToken) a7, element);
				copyLocalizationInfos((CommonToken) a7, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[44]);
	}
	
	a8 = ']' {
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
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_28_0_0_6, null, true);
		copyLocalizationInfos((CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[45]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[46]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[47]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[48]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[49]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[50]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[51]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[52]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[53]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[54]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[55]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[56]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[57]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[58]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[59]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[60]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[61]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[62]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[63]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[64]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[65]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[66]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[67]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[68]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[69]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[70]);
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
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[71]);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
			if (terminateParsing) {
				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_1, resolved, true);
				copyLocalizationInfos((CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[72]);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[73]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[74]);
	}
	
	(
		(
			(
				a3_0 = parse_eu_hyvar_dataValues_HyEnumLiteral				{
					if (terminateParsing) {
						throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
						retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_0, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[75]);
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[76]);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[77]);
					}
					
					(
						a5_0 = parse_eu_hyvar_dataValues_HyEnumLiteral						{
							if (terminateParsing) {
								throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
								retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_1, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[78]);
						addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[79]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[80]);
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[81]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[82]);
	}
	
	a6 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[83]);
	}
	
	(
		(
			a7 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[84]);
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[85]);
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[86]);
			}
			
			(
				(
					a8 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a8 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, resolved, true);
							copyLocalizationInfos((CommonToken) a8, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[87]);
				}
				
				a9 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[88]);
				}
				
				(
					a10 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a10 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_2, resolved, true);
							copyLocalizationInfos((CommonToken) a10, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[89]);
				}
				
				
				|				(
					a11 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a11 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, resolved, true);
							copyLocalizationInfos((CommonToken) a11, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[90]);
				}
				
				a12 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[91]);
				}
				
				a13 = 'null' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[92]);
				}
				
				
				|				a14 = 'null' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[93]);
				}
				
				a15 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a15, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[94]);
				}
				
				(
					a16 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a16 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_2, resolved, true);
							copyLocalizationInfos((CommonToken) a16, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[95]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[96]);
			}
			
			a17 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a17, element);
			}
			{
				// expected elements (follow set)
			}
			
		)
		
	)?	{
		// expected elements (follow set)
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
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[97]);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
			if (terminateParsing) {
				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_1, resolved, true);
				copyLocalizationInfos((CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[98]);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[99]);
	}
	
	(
		a3 = INTEGER_LITERAL		
		{
			if (terminateParsing) {
				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
				startIncompleteElement(element);
			}
			if (a3 != null) {
				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_3, resolved, true);
				copyLocalizationInfos((CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[100]);
	}
	
	a4 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[101]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[102]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[103]);
	}
	
	(
		(
			a5 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[104]);
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[105]);
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[106]);
			}
			
			(
				(
					a6 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a6 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, resolved, true);
							copyLocalizationInfos((CommonToken) a6, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[107]);
				}
				
				a7 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[108]);
				}
				
				(
					a8 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a8 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_2, resolved, true);
							copyLocalizationInfos((CommonToken) a8, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[109]);
				}
				
				
				|				(
					a9 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a9 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, resolved, true);
							copyLocalizationInfos((CommonToken) a9, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[110]);
				}
				
				a10 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a10, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[111]);
				}
				
				a11 = 'null' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[112]);
				}
				
				
				|				a12 = 'null' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[113]);
				}
				
				a13 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[114]);
				}
				
				(
					a14 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a14 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_2, resolved, true);
							copyLocalizationInfos((CommonToken) a14, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[115]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[116]);
			}
			
			a15 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[117]);
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[118]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[119]);
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[120]);
	}
	
;

parseop_HyValidityFormula_level_15 returns [eu.hyvar.context.contextValidity.HyValidityFormula element = null]
@init{
}
:
	c0 = parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula{ element = c1; /* this is a subclass or primitive expression choice */ }
;

parse_eu_hyvar_context_contextValidity_HyFeatureValidityFormula returns [eu.hyvar.context.contextValidity.HyFeatureValidityFormula element = null]
@init{
}
:
	(
		(
			a0 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
				}
				if (element == null) {
					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
					startIncompleteElement(element);
				}
				if (a0 != null) {
					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__FEATURE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
					collectHiddenTokens(element);
					registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.context.contextValidity.HyFeatureValidityFormula, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyFeatureValidityFormulaFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__FEATURE), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__FEATURE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_0_0_0_0, proxy, true);
					copyLocalizationInfos((CommonToken) a0, element);
					copyLocalizationInfos((CommonToken) a0, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[121]);
		}
		
		
		|		(
			a1 = IDENTIFIER_TOKEN			
			{
				if (terminateParsing) {
					throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
				}
				if (element == null) {
					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
					startIncompleteElement(element);
				}
				if (a1 != null) {
					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
					tokenResolver.setOptions(getOptions());
					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__FEATURE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
					collectHiddenTokens(element);
					registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.context.contextValidity.HyFeatureValidityFormula, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyFeatureValidityFormulaFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__FEATURE), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__FEATURE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_0_0_1_0, proxy, true);
					copyLocalizationInfos((CommonToken) a1, element);
					copyLocalizationInfos((CommonToken) a1, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[122]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[123]);
	}
	
	a2 = ':' {
		if (element == null) {
			element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[124]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[125]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[126]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[127]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[128]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[129]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[130]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[131]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[132]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[133]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[134]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[135]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[136]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[137]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[138]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyFeatureValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[139]);
	}
	
	(
		a3_0 = parse_eu_hyvar_feature_expression_HyExpression		{
			if (terminateParsing) {
				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALIDITY_FORMULA), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_2, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[140]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[141]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[142]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[143]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[144]);
	}
	
	(
		(
			a4 = '[' {
				if (element == null) {
					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[145]);
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[146]);
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[147]);
			}
			
			(
				(
					a5 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
							startIncompleteElement(element);
						}
						if (a5 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_SINCE), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
							}
							java.util.Date resolved = (java.util.Date) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_SINCE), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_0, resolved, true);
							copyLocalizationInfos((CommonToken) a5, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[148]);
				}
				
				a6 = '-' {
					if (element == null) {
						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[149]);
				}
				
				(
					a7 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
							startIncompleteElement(element);
						}
						if (a7 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_UNTIL), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
							}
							java.util.Date resolved = (java.util.Date) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_UNTIL), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_0_2, resolved, true);
							copyLocalizationInfos((CommonToken) a7, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[150]);
				}
				
				
				|				(
					a8 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
							startIncompleteElement(element);
						}
						if (a8 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_SINCE), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
							}
							java.util.Date resolved = (java.util.Date) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_SINCE), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_0, resolved, true);
							copyLocalizationInfos((CommonToken) a8, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[151]);
				}
				
				a9 = '-' {
					if (element == null) {
						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[152]);
				}
				
				a10 = 'null' {
					if (element == null) {
						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a10, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[153]);
				}
				
				
				|				a11 = 'null' {
					if (element == null) {
						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[154]);
				}
				
				a12 = '-' {
					if (element == null) {
						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[155]);
				}
				
				(
					a13 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
							startIncompleteElement(element);
						}
						if (a13 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_UNTIL), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a13).getLine(), ((CommonToken) a13).getCharPositionInLine(), ((CommonToken) a13).getStartIndex(), ((CommonToken) a13).getStopIndex());
							}
							java.util.Date resolved = (java.util.Date) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_FEATURE_VALIDITY_FORMULA__VALID_UNTIL), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_1_0_2_2, resolved, true);
							copyLocalizationInfos((CommonToken) a13, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[156]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[157]);
			}
			
			a14 = ']' {
				if (element == null) {
					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyFeatureValidityFormula();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_1_0_0_3_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a14, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[158]);
				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[159]);
				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[160]);
				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[161]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[162]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[163]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[164]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[165]);
	}
	
;

parse_eu_hyvar_context_contextValidity_HyAttributeValidityFormula returns [eu.hyvar.context.contextValidity.HyAttributeValidityFormula element = null]
@init{
}
:
	(
		(
			a0 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
				}
				if (element == null) {
					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
					startIncompleteElement(element);
				}
				if (a0 != null) {
					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__FEATURE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
					collectHiddenTokens(element);
					registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.context.contextValidity.HyAttributeValidityFormula, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeValidityFormulaFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__FEATURE), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__FEATURE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_0_0_0_0, proxy, true);
					copyLocalizationInfos((CommonToken) a0, element);
					copyLocalizationInfos((CommonToken) a0, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[166]);
		}
		
		
		|		(
			a1 = IDENTIFIER_TOKEN			
			{
				if (terminateParsing) {
					throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
				}
				if (element == null) {
					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
					startIncompleteElement(element);
				}
				if (a1 != null) {
					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
					tokenResolver.setOptions(getOptions());
					eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__FEATURE), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
					collectHiddenTokens(element);
					registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.context.contextValidity.HyAttributeValidityFormula, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeValidityFormulaFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__FEATURE), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__FEATURE), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_0_0_1_0, proxy, true);
					copyLocalizationInfos((CommonToken) a1, element);
					copyLocalizationInfos((CommonToken) a1, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[167]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[168]);
	}
	
	a2 = '.' {
		if (element == null) {
			element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[169]);
	}
	
	(
		a3 = IDENTIFIER_TOKEN		
		{
			if (terminateParsing) {
				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
				startIncompleteElement(element);
			}
			if (a3 != null) {
				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__ATTRIBUTE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				eu.hyvar.feature.HyFeatureAttribute proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyNumberAttribute();
				collectHiddenTokens(element);
				registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.context.contextValidity.HyAttributeValidityFormula, eu.hyvar.feature.HyFeatureAttribute>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeValidityFormulaAttributeReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__ATTRIBUTE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__ATTRIBUTE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_2, proxy, true);
				copyLocalizationInfos((CommonToken) a3, element);
				copyLocalizationInfos((CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[170]);
	}
	
	a4 = ':' {
		if (element == null) {
			element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[171]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[172]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[173]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[174]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[175]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[176]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[177]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[178]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[179]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[180]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[181]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[182]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[183]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[184]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[185]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyAttributeValidityFormula(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[186]);
	}
	
	(
		a5_0 = parse_eu_hyvar_feature_expression_HyExpression		{
			if (terminateParsing) {
				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
				startIncompleteElement(element);
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALIDITY_FORMULA), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_4, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[187]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[188]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[189]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[190]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[191]);
	}
	
	(
		(
			a6 = '[' {
				if (element == null) {
					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[192]);
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[193]);
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[194]);
			}
			
			(
				(
					a7 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
							startIncompleteElement(element);
						}
						if (a7 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_SINCE), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
							}
							java.util.Date resolved = (java.util.Date) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_SINCE), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_0, resolved, true);
							copyLocalizationInfos((CommonToken) a7, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[195]);
				}
				
				a8 = '-' {
					if (element == null) {
						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a8, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[196]);
				}
				
				(
					a9 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
							startIncompleteElement(element);
						}
						if (a9 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_UNTIL), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a9).getLine(), ((CommonToken) a9).getCharPositionInLine(), ((CommonToken) a9).getStartIndex(), ((CommonToken) a9).getStopIndex());
							}
							java.util.Date resolved = (java.util.Date) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_UNTIL), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_0_2, resolved, true);
							copyLocalizationInfos((CommonToken) a9, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[197]);
				}
				
				
				|				(
					a10 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
							startIncompleteElement(element);
						}
						if (a10 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_SINCE), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a10).getLine(), ((CommonToken) a10).getCharPositionInLine(), ((CommonToken) a10).getStartIndex(), ((CommonToken) a10).getStopIndex());
							}
							java.util.Date resolved = (java.util.Date) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_SINCE), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_0, resolved, true);
							copyLocalizationInfos((CommonToken) a10, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[198]);
				}
				
				a11 = '-' {
					if (element == null) {
						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[199]);
				}
				
				a12 = 'null' {
					if (element == null) {
						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[200]);
				}
				
				
				|				a13 = 'null' {
					if (element == null) {
						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[201]);
				}
				
				a14 = '-' {
					if (element == null) {
						element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[202]);
				}
				
				(
					a15 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
							startIncompleteElement(element);
						}
						if (a15 != null) {
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a15.getText(), element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_UNTIL), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a15).getLine(), ((CommonToken) a15).getCharPositionInLine(), ((CommonToken) a15).getStartIndex(), ((CommonToken) a15).getStopIndex());
							}
							java.util.Date resolved = (java.util.Date) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.context.contextValidity.HyContextValidityPackage.HY_ATTRIBUTE_VALIDITY_FORMULA__VALID_UNTIL), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_1_0_2_2, resolved, true);
							copyLocalizationInfos((CommonToken) a15, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[203]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[204]);
			}
			
			a16 = ']' {
				if (element == null) {
					element = eu.hyvar.context.contextValidity.HyContextValidityFactory.eINSTANCE.createHyAttributeValidityFormula();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYVALIDITYFORMULA_2_0_0_5_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a16, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[205]);
				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[206]);
				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[207]);
				addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[208]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[209]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[210]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[211]);
		addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[212]);
	}
	
;

parseop_HyExpression_level_0 returns [eu.hyvar.feature.expression.HyExpression element = null]
@init{
}
:
	leftArg = parseop_HyExpression_level_1	((
		()
		{ element = null; }
		a0 = '<->' {
			if (element == null) {
				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyEquivalenceExpression();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_0_0_0_1, null, true);
			copyLocalizationInfos((CommonToken)a0, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[213]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[214]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[215]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[216]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[217]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[218]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[219]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[220]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[221]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[222]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[223]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[224]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[225]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[226]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[227]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[228]);
		}
		
		rightArg = parseop_HyExpression_level_1		{
			if (terminateParsing) {
				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_0_0_0_0, leftArg, true);
				copyLocalizationInfos(leftArg, element);
			}
		}
		{
			if (terminateParsing) {
				throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
				retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_0_0_0_2, rightArg, true);
				copyLocalizationInfos(rightArg, element);
			}
		}
		{ leftArg = element; /* this may become an argument in the next iteration */ }
	)+ | /* epsilon */ { element = leftArg; }
	
)
;

parseop_HyExpression_level_1 returns [eu.hyvar.feature.expression.HyExpression element = null]
@init{
}
:
leftArg = parseop_HyExpression_level_4((
	()
	{ element = null; }
	a0 = '->' {
		if (element == null) {
			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyImpliesExpression();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_1_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[229]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[230]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[231]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[232]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[233]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[234]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[235]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[236]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[237]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[238]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[239]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[240]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[241]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[242]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[243]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[244]);
	}
	
	rightArg = parseop_HyExpression_level_4	{
		if (terminateParsing) {
			throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
			retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_1_0_0_0, leftArg, true);
			copyLocalizationInfos(leftArg, element);
		}
	}
	{
		if (terminateParsing) {
			throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
			retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_1_0_0_2, rightArg, true);
			copyLocalizationInfos(rightArg, element);
		}
	}
	{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_HyExpression_level_4 returns [eu.hyvar.feature.expression.HyExpression element = null]
@init{
}
:
leftArg = parseop_HyExpression_level_5((
()
{ element = null; }
a0 = '||' {
	if (element == null) {
		element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyOrExpression();
		startIncompleteElement(element);
	}
	collectHiddenTokens(element);
	retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_2_0_0_1, null, true);
	copyLocalizationInfos((CommonToken)a0, element);
}
{
	// expected elements (follow set)
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[245]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[246]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[247]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[248]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[249]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[250]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[251]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[252]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[253]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[254]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[255]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[256]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[257]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[258]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[259]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[260]);
}

rightArg = parseop_HyExpression_level_5{
	if (terminateParsing) {
		throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_2_0_0_0, leftArg, true);
		copyLocalizationInfos(leftArg, element);
	}
}
{
	if (terminateParsing) {
		throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
		retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_2_0_0_2, rightArg, true);
		copyLocalizationInfos(rightArg, element);
	}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_HyExpression_level_5 returns [eu.hyvar.feature.expression.HyExpression element = null]
@init{
}
:
leftArg = parseop_HyExpression_level_9((
()
{ element = null; }
a0 = '&&' {
if (element == null) {
	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAndExpression();
	startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_3_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[261]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[262]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[263]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[264]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[265]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[266]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[267]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[268]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[269]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[270]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[271]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[272]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[273]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[274]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[275]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[276]);
}

rightArg = parseop_HyExpression_level_9{
if (terminateParsing) {
	throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
	retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_3_0_0_0, leftArg, true);
	copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
	throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
	retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_3_0_0_2, rightArg, true);
	copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_HyExpression_level_9 returns [eu.hyvar.feature.expression.HyExpression element = null]
@init{
}
:
leftArg = parseop_HyExpression_level_12((
()
{ element = null; }
a0 = '<' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyLessExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_16_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[277]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[278]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[279]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[280]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[281]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[282]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[283]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[284]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[285]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[286]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[287]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[288]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[289]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[290]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[291]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[292]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_16_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_16_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
a0 = '<=' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyLessOrEqualExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_17_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[293]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[294]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[295]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[296]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[297]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[298]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[299]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[300]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[301]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[302]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[303]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[304]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[305]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[306]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[307]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[308]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_17_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_17_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
a0 = '>' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyGreaterExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_18_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[309]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[310]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[311]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[312]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[313]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[314]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[315]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[316]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[317]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[318]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[319]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[320]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[321]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[322]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[323]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[324]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_18_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_18_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
a0 = '>=' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyGreaterOrEqualExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_19_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[325]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[326]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[327]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[328]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[329]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[330]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[331]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[332]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[333]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[334]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[335]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[336]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[337]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[338]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[339]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[340]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_19_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_19_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
a0 = '=' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyEqualExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_25_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[341]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[342]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[343]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[344]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[345]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[346]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[347]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[348]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[349]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[350]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[351]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[352]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[353]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[354]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[355]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[356]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_25_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_25_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
a0 = '!=' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNotEqualExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_26_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[357]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[358]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[359]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[360]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[361]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[362]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[363]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[364]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[365]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[366]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[367]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[368]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[369]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[370]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[371]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[372]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_26_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_26_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_HyExpression_level_12 returns [eu.hyvar.feature.expression.HyExpression element = null]
@init{
}
:
leftArg = parseop_HyExpression_level_13((
()
{ element = null; }
a0 = '-' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHySubtractionExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[373]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[374]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[375]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[376]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[377]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[378]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[379]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[380]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[381]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[382]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[383]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[384]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[385]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[386]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[387]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[388]);
}

rightArg = parseop_HyExpression_level_13{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_20_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_20_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
a0 = '+' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAdditionExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_21_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[389]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[390]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[391]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[392]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[393]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[394]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[395]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[396]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[397]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[398]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[399]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[400]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[401]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[402]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[403]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[404]);
}

rightArg = parseop_HyExpression_level_13{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_21_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_21_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_HyExpression_level_13 returns [eu.hyvar.feature.expression.HyExpression element = null]
@init{
}
:
leftArg = parseop_HyExpression_level_14((
()
{ element = null; }
a0 = '\u0025' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyModuloExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_22_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[405]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[406]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[407]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[408]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[409]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[410]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[411]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[412]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[413]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[414]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[415]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[416]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[417]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[418]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[419]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[420]);
}

rightArg = parseop_HyExpression_level_14{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_22_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_22_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
a0 = '*' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMultiplicationExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_23_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[421]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[422]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[423]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[424]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[425]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[426]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[427]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[428]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[429]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[430]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[431]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[432]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[433]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[434]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[435]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[436]);
}

rightArg = parseop_HyExpression_level_14{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_23_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_23_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
a0 = '/' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyDivisionExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_24_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[437]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[438]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[439]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[440]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[441]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[442]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[443]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[444]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[445]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[446]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[447]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[448]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[449]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[450]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[451]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[452]);
}

rightArg = parseop_HyExpression_level_14{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_24_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_24_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_HyExpression_level_14 returns [eu.hyvar.feature.expression.HyExpression element = null]
@init{
}
:
a0 = '!' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNotExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_4_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[453]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[454]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[455]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[456]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[457]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[458]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[459]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[460]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[461]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[462]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[463]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[464]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[465]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[466]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[467]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[468]);
}

arg = parseop_HyExpression_level_15{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_4_0_0_1, arg, true);
copyLocalizationInfos(arg, element);
}
}
|
a2 = '-' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNegationExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_5_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[469]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[470]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[471]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[472]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[473]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[474]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[475]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[476]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[477]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[478]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[479]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[480]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[481]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[482]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[483]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[484]);
}

arg = parseop_HyExpression_level_15{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_5_0_0_1, arg, true);
copyLocalizationInfos(arg, element);
}
}
|

arg = parseop_HyExpression_level_15{ element = arg; }
;

parseop_HyExpression_level_15 returns [eu.hyvar.feature.expression.HyExpression element = null]
@init{
}
:
c0 = parse_eu_hyvar_feature_expression_HyNestedExpression{ element = c0; /* this is a subclass or primitive expression choice */ }
|c1 = parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression{ element = c1; /* this is a subclass or primitive expression choice */ }
|c2 = parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression{ element = c2; /* this is a subclass or primitive expression choice */ }
|c3 = parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression{ element = c3; /* this is a subclass or primitive expression choice */ }
|c4 = parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression{ element = c4; /* this is a subclass or primitive expression choice */ }
|c5 = parse_eu_hyvar_feature_expression_HyValueExpression{ element = c5; /* this is a subclass or primitive expression choice */ }
|c6 = parse_eu_hyvar_feature_expression_HyBooleanValueExpression{ element = c6; /* this is a subclass or primitive expression choice */ }
|c7 = parse_eu_hyvar_feature_expression_HyMinimumExpression{ element = c7; /* this is a subclass or primitive expression choice */ }
|c8 = parse_eu_hyvar_feature_expression_HyMaximumExpression{ element = c8; /* this is a subclass or primitive expression choice */ }
|c9 = parse_eu_hyvar_feature_expression_HyIfPossibleExpression{ element = c9; /* this is a subclass or primitive expression choice */ }
;

parse_eu_hyvar_feature_expression_HyNestedExpression returns [eu.hyvar.feature.expression.HyNestedExpression element = null]
@init{
}
:
a0 = '(' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_6_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[485]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[486]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[487]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[488]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[489]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[490]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[491]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[492]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[493]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[494]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[495]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[496]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[497]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[498]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[499]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[500]);
}

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_6_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[501]);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_6_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[502]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[503]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[504]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[505]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[506]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[507]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[508]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[509]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[510]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[511]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[512]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[513]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[514]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[515]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[516]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[517]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[518]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[519]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[520]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[521]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[522]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[523]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[524]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[525]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[526]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[527]);
}

;

parse_eu_hyvar_feature_expression_HyFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyFeatureReferenceExpression element = null]
@init{
}
:
(
(
a0 = QUOTED_34_34
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
startIncompleteElement(element);
}
if (a0 != null) {
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
tokenResolver.setOptions(getOptions());
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a0, element);
copyLocalizationInfos((CommonToken) a0, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[528]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[529]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[530]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[531]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[532]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[533]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[534]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[535]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[536]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[537]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[538]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[539]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[540]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[541]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[542]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[543]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[544]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[545]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[546]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[547]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[548]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[549]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[550]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[551]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[552]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[553]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[554]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[555]);
}


|(
a1 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[556]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[557]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[558]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[559]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[560]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[561]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[562]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[563]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[564]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[565]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[566]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[567]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[568]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[569]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[570]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[571]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[572]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[573]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[574]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[575]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[576]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[577]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[578]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[579]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[580]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[581]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[582]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[583]);
}

)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[584]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[585]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[586]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[587]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[588]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[589]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[590]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[591]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[592]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[593]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[594]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[595]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[596]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[597]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[598]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[599]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[600]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[601]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[602]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[603]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[604]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[605]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[606]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[607]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[608]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[609]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[610]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[611]);
}

(
(
(
a2_0 = parse_eu_hyvar_feature_expression_HyVersionRestriction{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_0_0, a2_0, true);
copyLocalizationInfos(a2_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[612]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[613]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[614]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[615]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[616]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[617]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[618]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[619]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[620]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[621]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[622]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[623]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[624]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[625]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[626]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[627]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[628]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[629]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[630]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[631]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[632]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[633]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[634]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[635]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[636]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[637]);
}

)

)?{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[638]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[639]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[640]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[641]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[642]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[643]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[644]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[645]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[646]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[647]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[648]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[649]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[650]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[651]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[652]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[653]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[654]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[655]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[656]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[657]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[658]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[659]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[660]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[661]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[662]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[663]);
}

;

parse_eu_hyvar_feature_expression_HyConditionalFeatureReferenceExpression returns [eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression element = null]
@init{
}
:
a0 = '?' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_8_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[664]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[665]);
}

(
(
a1 = QUOTED_34_34
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
tokenResolver.setOptions(getOptions());
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[666]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[667]);
}


|(
a2 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
startIncompleteElement(element);
}
if (a2 != null) {
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a2, element);
copyLocalizationInfos((CommonToken) a2, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[668]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[669]);
}

)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[670]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[671]);
}

(
a3_0 = parse_eu_hyvar_feature_expression_HyVersionRestriction{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_8_0_0_2, a3_0, true);
copyLocalizationInfos(a3_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[672]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[673]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[674]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[675]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[676]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[677]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[678]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[679]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[680]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[681]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[682]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[683]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[684]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[685]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[686]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[687]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[688]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[689]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[690]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[691]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[692]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[693]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[694]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[695]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[696]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[697]);
}

;

parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression returns [eu.hyvar.feature.expression.HyContextInformationReferenceExpression element = null]
@init{
}
:
a0 = 'context:' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_9_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[698]);
}

(
a1 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.context.HyContextualInformation proxy = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextInformationReferenceExpressionContextInformationReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_9_0_0_1, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[699]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[700]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[701]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[702]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[703]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[704]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[705]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[706]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[707]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[708]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[709]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[710]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[711]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[712]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[713]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[714]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[715]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[716]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[717]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[718]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[719]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[720]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[721]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[722]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[723]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[724]);
}

;

parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression returns [eu.hyvar.feature.expression.HyAttributeReferenceExpression element = null]
@init{
}
:
(
(
a0 = QUOTED_34_34
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
startIncompleteElement(element);
}
if (a0 != null) {
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
tokenResolver.setOptions(getOptions());
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a0, element);
copyLocalizationInfos((CommonToken) a0, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[725]);
}


|(
a1 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[726]);
}

)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[727]);
}

a2 = '.' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_10_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[728]);
}

(
a3 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
startIncompleteElement(element);
}
if (a3 != null) {
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeatureAttribute proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyNumberAttribute();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeatureAttribute>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionAttributeReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_10_0_0_2, proxy, true);
copyLocalizationInfos((CommonToken) a3, element);
copyLocalizationInfos((CommonToken) a3, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[729]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[730]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[731]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[732]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[733]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[734]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[735]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[736]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[737]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[738]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[739]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[740]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[741]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[742]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[743]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[744]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[745]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[746]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[747]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[748]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[749]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[750]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[751]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[752]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[753]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[754]);
}

;

parse_eu_hyvar_feature_expression_HyValueExpression returns [eu.hyvar.feature.expression.HyValueExpression element = null]
@init{
}
:
(
a0_0 = parse_eu_hyvar_dataValues_HyValue{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_11_0_0_0, a0_0, true);
copyLocalizationInfos(a0_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[755]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[756]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[757]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[758]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[759]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[760]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[761]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[762]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[763]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[764]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[765]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[766]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[767]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[768]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[769]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[770]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[771]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[772]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[773]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[774]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[775]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[776]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[777]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[778]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[779]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[780]);
}

;

parse_eu_hyvar_feature_expression_HyBooleanValueExpression returns [eu.hyvar.feature.expression.HyBooleanValueExpression element = null]
@init{
}
:
(
(
a0 = 'true' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_12_0_0_0, true, true);
copyLocalizationInfos((CommonToken)a0, element);
// set value of boolean attribute
Object value = true;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), value);
completedElement(value, false);
}
|a1 = 'false' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_12_0_0_0, false, true);
copyLocalizationInfos((CommonToken)a1, element);
// set value of boolean attribute
Object value = false;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_BOOLEAN_VALUE_EXPRESSION__VALUE), value);
completedElement(value, false);
}
)
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[781]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[782]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[783]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[784]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[785]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[786]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[787]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[788]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[789]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[790]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[791]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[792]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[793]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[794]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[795]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[796]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[797]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[798]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[799]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[800]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[801]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[802]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[803]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[804]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[805]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[806]);
}

;

parse_eu_hyvar_feature_expression_HyMinimumExpression returns [eu.hyvar.feature.expression.HyMinimumExpression element = null]
@init{
}
:
a0 = 'min(' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMinimumExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_13_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[807]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[808]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[809]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[810]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[811]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[812]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[813]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[814]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[815]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[816]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[817]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[818]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[819]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[820]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[821]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[822]);
}

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_13_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[823]);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMinimumExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_13_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[824]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[825]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[826]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[827]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[828]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[829]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[830]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[831]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[832]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[833]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[834]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[835]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[836]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[837]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[838]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[839]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[840]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[841]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[842]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[843]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[844]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[845]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[846]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[847]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[848]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[849]);
}

;

parse_eu_hyvar_feature_expression_HyMaximumExpression returns [eu.hyvar.feature.expression.HyMaximumExpression element = null]
@init{
}
:
a0 = 'max(' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMaximumExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_14_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[850]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[851]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[852]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[853]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[854]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[855]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[856]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[857]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[858]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[859]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[860]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[861]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[862]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[863]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[864]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[865]);
}

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_14_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[866]);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMaximumExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_14_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[867]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[868]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[869]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[870]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[871]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[872]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[873]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[874]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[875]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[876]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[877]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[878]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[879]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[880]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[881]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[882]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[883]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[884]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[885]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[886]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[887]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[888]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[889]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[890]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[891]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[892]);
}

;

parse_eu_hyvar_feature_expression_HyIfPossibleExpression returns [eu.hyvar.feature.expression.HyIfPossibleExpression element = null]
@init{
}
:
a0 = 'ifPossible(' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_15_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[893]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[894]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[895]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[896]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[897]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[898]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[899]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[900]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[901]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[902]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[903]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[904]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[905]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[906]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[907]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[908]);
}

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_15_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[909]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[910]);
}

(
(
a2 = ',' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[911]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[912]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[913]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[914]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[915]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[916]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[917]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[918]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[919]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[920]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[921]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[922]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[923]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[924]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[925]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[926]);
}

(
a3_0 = parse_eu_hyvar_feature_expression_HyExpression{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_1, a3_0, true);
copyLocalizationInfos(a3_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[927]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[928]);
}

)

)*{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[929]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[930]);
}

a4 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYEXPRESSION_15_0_0_3, null, true);
copyLocalizationInfos((CommonToken)a4, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[931]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[932]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[933]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[934]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[935]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[936]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[937]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[938]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[939]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[940]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[941]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[942]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[943]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[944]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[945]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[946]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[947]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[948]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[949]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[950]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[951]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[952]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[953]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[954]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[955]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[956]);
}

;

parseop_HyValue_level_15 returns [eu.hyvar.dataValues.HyValue element = null]
@init{
}
:
c0 = parse_eu_hyvar_dataValues_HyNumberValue{ element = c0; /* this is a subclass or primitive expression choice */ }
|c1 = parse_eu_hyvar_dataValues_HyBooleanValue{ element = c1; /* this is a subclass or primitive expression choice */ }
|c2 = parse_eu_hyvar_dataValues_HyEnumValue{ element = c2; /* this is a subclass or primitive expression choice */ }
;

parse_eu_hyvar_dataValues_HyNumberValue returns [eu.hyvar.dataValues.HyNumberValue element = null]
@init{
}
:
(
a0 = INTEGER_LITERAL
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyNumberValue();
startIncompleteElement(element);
}
if (a0 != null) {
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
tokenResolver.setOptions(getOptions());
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_0_0_0_0, resolved, true);
copyLocalizationInfos((CommonToken) a0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[957]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[958]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[959]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[960]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[961]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[962]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[963]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[964]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[965]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[966]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[967]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[968]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[969]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[970]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[971]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[972]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[973]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[974]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[975]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[976]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[977]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[978]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[979]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[980]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[981]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[982]);
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_1_0_0_0, true, true);
copyLocalizationInfos((CommonToken)a0, element);
// set value of boolean attribute
Object value = true;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_BOOLEAN_VALUE__VALUE), value);
completedElement(value, false);
}
|a1 = 'false' {
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_1_0_0_0, false, true);
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
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[983]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[984]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[985]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[986]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[987]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[988]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[989]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[990]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[991]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[992]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[993]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[994]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[995]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[996]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[997]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[998]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[999]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1000]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1001]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1002]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1003]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1004]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1005]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1006]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1007]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1008]);
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
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1009]);
}

(
a1 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_2_0_0_1, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1010]);
}

a2 = '.' {
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1011]);
}

(
a3 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
if (a3 != null) {
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaGrammarInformationProvider.HYDATAVALUE_2_0_0_3, proxy, true);
copyLocalizationInfos((CommonToken) a3, element);
copyLocalizationInfos((CommonToken) a3, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1012]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1013]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1014]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1015]);
addExpectedElement(eu.hyvar.context.contextValidity.HyContextValidityPackage.eINSTANCE.getHyValidityModel(), eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1016]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1017]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1018]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1019]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1020]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1021]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1022]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1023]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1024]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1025]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1026]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1027]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1028]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1029]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1030]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1031]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1032]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1033]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1034]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1035]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1036]);
addExpectedElement(null, eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaExpectationConstants.EXPECTATIONS[1037]);
}

;

parse_eu_hyvar_context_contextValidity_HyValidityFormula returns [eu.hyvar.context.contextValidity.HyValidityFormula element = null]
:
c = parseop_HyValidityFormula_level_15{ element = c; /* this rule is an expression root */ }

;

parse_eu_hyvar_feature_expression_HyExpression returns [eu.hyvar.feature.expression.HyExpression element = null]
:
c = parseop_HyExpression_level_0{ element = c; /* this rule is an expression root */ }

;

parse_eu_hyvar_feature_expression_HyVersionRestriction returns [eu.hyvar.feature.expression.HyVersionRestriction element = null]
:
c0 = parse_eu_hyvar_feature_expression_HyRelativeVersionRestriction{ element = c0; /* this is a subclass or primitive expression choice */ }
|c1 = parse_eu_hyvar_feature_expression_HyVersionRangeRestriction{ element = c1; /* this is a subclass or primitive expression choice */ }

;

parse_eu_hyvar_dataValues_HyValue returns [eu.hyvar.dataValues.HyValue element = null]
:
c = parseop_HyValue_level_15{ element = c; /* this rule is an expression root */ }

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

