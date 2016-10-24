grammar Hycontextinformation;

options {
	superClass = HycontextinformationANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package eu.hyvar.context.resource.hycontextinformation.mopp;
	
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
}

@members{
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
	
}

start returns [ EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[0]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[1]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[2]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[3]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_eu_hyvar_context_HyContextModel{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_eu_hyvar_context_HyContextModel returns [eu.hyvar.context.HyContextModel element = null]
@init{
}
:
	(
		(
			a0_0 = parse_eu_hyvar_dataValues_HyEnum			{
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
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[4]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[5]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[6]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[7]);
	}
	
	(
		(
			a1_0 = parse_eu_hyvar_context_HyContextualInformation			{
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
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[8]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[9]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[10]);
	}
	
;

parse_eu_hyvar_context_HyContextualInformationNumber returns [eu.hyvar.context.HyContextualInformationNumber element = null]
@init{
}
:
	a0 = 'NumberContext(' {
		if (element == null) {
			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[11]);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[12]);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[13]);
	}
	
	(
		a3 = INTEGER_LITERAL		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[14]);
	}
	
	a4 = ',' {
		if (element == null) {
			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[15]);
	}
	
	(
		a5 = INTEGER_LITERAL		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[16]);
	}
	
	a6 = ')' {
		if (element == null) {
			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_6, null, true);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[17]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[18]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[19]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[20]);
	}
	
	(
		(
			a7 = '[' {
				if (element == null) {
					element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[21]);
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[22]);
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[23]);
			}
			
			(
				(
					a8 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[24]);
				}
				
				a9 = '-' {
					if (element == null) {
						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[25]);
				}
				
				(
					a10 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[26]);
				}
				
				
				|				(
					a11 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[27]);
				}
				
				a12 = '-' {
					if (element == null) {
						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[28]);
				}
				
				a13 = 'null' {
					if (element == null) {
						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[29]);
				}
				
				
				|				a14 = 'null' {
					if (element == null) {
						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[30]);
				}
				
				a15 = '-' {
					if (element == null) {
						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a15, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[31]);
				}
				
				(
					a16 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[32]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[33]);
			}
			
			a17 = ']' {
				if (element == null) {
					element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationNumber();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_1_0_0_7_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a17, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[34]);
				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[35]);
				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[36]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[37]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[38]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[39]);
	}
	
;

parse_eu_hyvar_context_HyContextualInformationBoolean returns [eu.hyvar.context.HyContextualInformationBoolean element = null]
@init{
}
:
	a0 = 'BooleanContext(' {
		if (element == null) {
			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[40]);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[41]);
	}
	
	a2 = ')' {
		if (element == null) {
			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[42]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[43]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[44]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[45]);
	}
	
	(
		(
			a3 = '[' {
				if (element == null) {
					element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[46]);
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[47]);
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[48]);
			}
			
			(
				(
					a4 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[49]);
				}
				
				a5 = '-' {
					if (element == null) {
						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a5, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[50]);
				}
				
				(
					a6 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[51]);
				}
				
				
				|				(
					a7 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[52]);
				}
				
				a8 = '-' {
					if (element == null) {
						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a8, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[53]);
				}
				
				a9 = 'null' {
					if (element == null) {
						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[54]);
				}
				
				
				|				a10 = 'null' {
					if (element == null) {
						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a10, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[55]);
				}
				
				a11 = '-' {
					if (element == null) {
						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[56]);
				}
				
				(
					a12 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[57]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[58]);
			}
			
			a13 = ']' {
				if (element == null) {
					element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationBoolean();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_2_0_0_3_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a13, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[59]);
				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[60]);
				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[61]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[62]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[63]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[64]);
	}
	
;

parse_eu_hyvar_context_HyContextualInformationEnum returns [eu.hyvar.context.HyContextualInformationEnum element = null]
@init{
}
:
	a0 = 'EnumContext(' {
		if (element == null) {
			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[65]);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[66]);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[67]);
	}
	
	(
		a3 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[68]);
	}
	
	a4 = ')' {
		if (element == null) {
			element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[69]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[70]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[71]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[72]);
	}
	
	(
		(
			a5 = '[' {
				if (element == null) {
					element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[73]);
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[74]);
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[75]);
			}
			
			(
				(
					a6 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[76]);
				}
				
				a7 = '-' {
					if (element == null) {
						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[77]);
				}
				
				(
					a8 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[78]);
				}
				
				
				|				(
					a9 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[79]);
				}
				
				a10 = '-' {
					if (element == null) {
						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a10, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[80]);
				}
				
				a11 = 'null' {
					if (element == null) {
						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[81]);
				}
				
				
				|				a12 = 'null' {
					if (element == null) {
						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[82]);
				}
				
				a13 = '-' {
					if (element == null) {
						element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[83]);
				}
				
				(
					a14 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[84]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[85]);
			}
			
			a15 = ']' {
				if (element == null) {
					element = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYCONTEXTINFORMATION_3_0_0_5_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[86]);
				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[87]);
				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[88]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[89]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[90]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[91]);
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
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[92]);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[93]);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[94]);
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[95]);
	}
	
	(
		(
			(
				a3_0 = parse_eu_hyvar_dataValues_HyEnumLiteral				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[96]);
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[97]);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[98]);
					}
					
					(
						a5_0 = parse_eu_hyvar_dataValues_HyEnumLiteral						{
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
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[99]);
						addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[100]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[101]);
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[102]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[103]);
	}
	
	a6 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[104]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[105]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[106]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[107]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[108]);
	}
	
	(
		(
			a7 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[109]);
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[110]);
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[111]);
			}
			
			(
				(
					a8 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[112]);
				}
				
				a9 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[113]);
				}
				
				(
					a10 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[114]);
				}
				
				
				|				(
					a11 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[115]);
				}
				
				a12 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[116]);
				}
				
				a13 = 'null' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[117]);
				}
				
				
				|				a14 = 'null' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[118]);
				}
				
				a15 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a15, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[119]);
				}
				
				(
					a16 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[120]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[121]);
			}
			
			a17 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a17, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[122]);
				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[123]);
				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[124]);
				addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[125]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[126]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[127]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[128]);
		addExpectedElement(eu.hyvar.context.HyContextInformationPackage.eINSTANCE.getHyContextModel(), eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[129]);
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
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[130]);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[131]);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[132]);
	}
	
	(
		a3 = INTEGER_LITERAL		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[133]);
	}
	
	a4 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[134]);
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[135]);
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[136]);
	}
	
	(
		(
			a5 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[137]);
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[138]);
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[139]);
			}
			
			(
				(
					a6 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[140]);
				}
				
				a7 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[141]);
				}
				
				(
					a8 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[142]);
				}
				
				
				|				(
					a9 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[143]);
				}
				
				a10 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a10, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[144]);
				}
				
				a11 = 'null' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[145]);
				}
				
				
				|				a12 = 'null' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[146]);
				}
				
				a13 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[147]);
				}
				
				(
					a14 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[148]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[149]);
			}
			
			a15 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[150]);
				addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[151]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[152]);
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[153]);
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
	)
	{
		// expected elements (follow set)
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
				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_1_0_0_0, true, true);
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
				retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_1_0_0_0, false, true);
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
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[154]);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[155]);
	}
	
	a2 = '.' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationExpectationConstants.EXPECTATIONS[156]);
	}
	
	(
		a3 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
	}
	
;

parse_eu_hyvar_context_HyContextualInformation returns [eu.hyvar.context.HyContextualInformation element = null]
:
	c0 = parse_eu_hyvar_context_HyContextualInformationNumber{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_eu_hyvar_context_HyContextualInformationBoolean{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_eu_hyvar_context_HyContextualInformationEnum{ element = c2; /* this is a subclass or primitive expression choice */ }
	
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

