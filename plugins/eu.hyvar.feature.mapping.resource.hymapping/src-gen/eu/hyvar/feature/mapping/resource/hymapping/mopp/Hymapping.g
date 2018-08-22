grammar Hymapping;

options {
	superClass = HymappingANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package eu.hyvar.feature.mapping.resource.hymapping.mopp;
	
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
}

@members{
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
	
	public void addExpectedElement(EClass eClass, int expectationStartIndex, int expectationEndIndex) {
		for (int expectationIndex = expectationStartIndex; expectationIndex <= expectationEndIndex; expectationIndex++) {
			addExpectedElement(eClass, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[expectationIndex]);
		}
	}
	
	public void addExpectedElement(EClass eClass, int expectationIndex) {
		addExpectedElement(eClass, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[expectationIndex]);
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
		int followSetID = 127;
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
		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 0, 454);
		expectedElementsIndexOfLastCompleteElement = 454;
	}
	(
		c0 = parse_eu_hyvar_feature_mapping_HyMappingModel{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_eu_hyvar_feature_mapping_HyMappingModel returns [eu.hyvar.feature.mapping.HyMappingModel element = null]
@init{
}
:
	(
		(
			(
				a0_0 = parse_eu_hyvar_feature_mapping_HyMapping				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 455, 909);
			}
			
			(
				(
					(
						a1_0 = parse_eu_hyvar_feature_mapping_HyMapping						{
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
					)
					{
						// expected elements (follow set)
						// We've found the last token for this rule. The constructed EObject is now
						// complete.
						completedElement(element, true);
						addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 910, 1364);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 1365, 1819);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
	}
	
;

parse_org_deltaecore_core_decore_DEDeltaInvokation returns [org.deltaecore.core.decore.DEDeltaInvokation element = null]
@init{
}
:
	(
		a0 = QUOTED_6060_6262		
		{
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
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 1820, 1821);
		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 1822, 2276);
	}
	
;

parse_eu_hyvar_feature_mapping_HyMapping returns [eu.hyvar.feature.mapping.HyMapping element = null]
@init{
}
:
	(
		a0_0 = parse_eu_hyvar_feature_expression_HyExpression		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 2277);
	}
	
	a1 = ':' {
		if (element == null) {
			element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping(), 2278);
	}
	
	(
		a2_0 = parse_org_deltaecore_core_decore_DEDeltaInvokation		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 2279, 2280);
		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 2281, 2735);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping(), 2736);
			}
			
			(
				a4_0 = parse_org_deltaecore_core_decore_DEDeltaInvokation				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 2737, 2738);
				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 2739, 3193);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, 3194, 3195);
		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 3196, 3650);
	}
	
	(
		(
			a5 = '[' {
				if (element == null) {
					element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 3651, 3653);
			}
			
			(
				(
					a6 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 3654);
				}
				
				a7 = '-' {
					if (element == null) {
						element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 3655);
				}
				
				(
					a8 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 3656);
				}
				
				
				|				(
					a9 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 3657);
				}
				
				a10 = '-' {
					if (element == null) {
						element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a10, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 3658);
				}
				
				a11 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 3659);
				}
				
				
				|				a12 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 3660);
				}
				
				a13 = '-' {
					if (element == null) {
						element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 3661);
				}
				
				(
					a14 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 3662);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 3663);
			}
			
			a15 = ']' {
				if (element == null) {
					element = eu.hyvar.feature.mapping.MappingFactory.eINSTANCE.createHyMapping();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYMAPPING_2_0_0_6_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 3664, 4118);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMappingModel(), 4119, 4573);
	}
	
;

parse_eu_hyvar_feature_expression_HyArithmeticalComparisonExpression returns [eu.hyvar.feature.expression.HyArithmeticalComparisonExpression element = null]
@init{
}
:
	a0 = '{' {
		if (element == null) {
			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(), 4574, 7507);
	}
	
	(
		a1_0 = parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 7508);
	}
	
	(
		(
			a2 = '<' {
				if (element == null) {
					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_LESS_OPERATOR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
				completedElement(value, false);
			}
			|			a3 = '<=' {
				if (element == null) {
					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_LESS_OR_EQUAL_OPERATOR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
				completedElement(value, false);
			}
			|			a4 = '=' {
				if (element == null) {
					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_EQUAL_OPERATOR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
				completedElement(value, false);
			}
			|			a5 = '!=' {
				if (element == null) {
					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_NOT_EQUAL_OPERATOR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
				completedElement(value, false);
			}
			|			a6 = '>=' {
				if (element == null) {
					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_GREATER_OR_EQUAL_OPERATOR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
				completedElement(value, false);
			}
			|			a7 = '>' {
				if (element == null) {
					element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a7, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyArithmeticalComparisonOperator.HY_GREATER_OPERATOR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ARITHMETICAL_COMPARISON_EXPRESSION__OPERATOR), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyArithmeticalComparisonExpression(), 7509, 10442);
	}
	
	(
		a10_0 = parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_3, a10_0, true);
				copyLocalizationInfos(a10_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 10443);
	}
	
	a11 = '}' {
		if (element == null) {
			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyArithmeticalComparisonExpression();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 10444, 10449);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 10450, 10451);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 10452);
	}
	
	(
		a8 = QUOTED_34_34		
		{
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_2, proxy, true);
				copyLocalizationInfos((CommonToken) a8, element);
				copyLocalizationInfos((CommonToken) a8, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 10453);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 10454, 10459);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 10460, 10461);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_1, false, true);
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of boolean attribute
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 10462);
	}
	
	(
		a3 = QUOTED_34_34		
		{
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_2, proxy, true);
				copyLocalizationInfos((CommonToken) a3, element);
				copyLocalizationInfos((CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 10463);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 10464, 10465);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_4, false, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of boolean attribute
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 10466);
	}
	
	(
		a7 = QUOTED_34_34		
		{
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_5, proxy, true);
				copyLocalizationInfos((CommonToken) a7, element);
				copyLocalizationInfos((CommonToken) a7, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 10467);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_6, null, true);
		copyLocalizationInfos((CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 10468, 10473);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 10474);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 10475);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 10476);
		addExpectedElement(null, 10477);
	}
	
	(
		(
			(
				a3_0 = parse_eu_hyvar_dataValues_HyEnumLiteral				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 10478, 10479);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), 10480);
					}
					
					(
						a5_0 = parse_eu_hyvar_dataValues_HyEnumLiteral						{
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
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, 10481, 10482);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, 10483, 10484);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, 10485);
	}
	
	a6 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 10486);
	}
	
	(
		(
			a7 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 10487, 10489);
			}
			
			(
				(
					a8 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 10490);
				}
				
				a9 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 10491);
				}
				
				(
					a10 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 10492);
				}
				
				
				|				(
					a11 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 10493);
				}
				
				a12 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 10494);
				}
				
				
				|				a13 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 10495);
				}
				
				a14 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 10496);
				}
				
				(
					a15 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 10497);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 10498);
			}
			
			a16 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 10499);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 10500);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 10501);
	}
	
	(
		a3 = INTEGER_LITERAL		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 10502);
	}
	
	a4 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 10503, 10505);
	}
	
	(
		(
			a5 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 10506, 10508);
			}
			
			(
				(
					a6 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 10509);
				}
				
				a7 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 10510);
				}
				
				(
					a8 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 10511);
				}
				
				
				|				(
					a9 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 10512);
				}
				
				a10 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a10, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 10513);
				}
				
				a11 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 10514);
				}
				
				
				|				a12 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 10515);
				}
				
				a13 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, 10516);
				}
				
				(
					a14 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 10517);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 10518);
			}
			
			a15 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 10519, 10520);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 10521, 10522);
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
			retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_0_0_0_1, null, true);
			copyLocalizationInfos((CommonToken)a0, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), 10523, 10977);
		}
		
		rightArg = parseop_HyExpression_level_1		{
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
		{
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
		{ leftArg = element; /* this may become an argument in the next iteration */ }
	)+ | /* epsilon */ { element = leftArg; }
	
)
;

parseop_HyExpression_level_1 returns [eu.hyvar.feature.expression.HyExpression element = null]
@init{
}
:
leftArg = parseop_HyExpression_level_2((
	()
	{ element = null; }
	a0 = '->' {
		if (element == null) {
			element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyImpliesExpression();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_1_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), 10978, 11432);
	}
	
	rightArg = parseop_HyExpression_level_2	{
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
	{
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
	{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_HyExpression_level_2 returns [eu.hyvar.feature.expression.HyExpression element = null]
@init{
}
:
leftArg = parseop_HyExpression_level_3((
()
{ element = null; }
a0 = '||' {
	if (element == null) {
		element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyOrExpression();
		startIncompleteElement(element);
	}
	collectHiddenTokens(element);
	retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_2_0_0_1, null, true);
	copyLocalizationInfos((CommonToken)a0, element);
}
{
	// expected elements (follow set)
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), 11433, 11887);
}

rightArg = parseop_HyExpression_level_3{
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
{
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
{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_HyExpression_level_3 returns [eu.hyvar.feature.expression.HyExpression element = null]
@init{
}
:
leftArg = parseop_HyExpression_level_14((
()
{ element = null; }
a0 = '&&' {
if (element == null) {
	element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAndExpression();
	startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_3_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), 11888, 12342);
}

rightArg = parseop_HyExpression_level_14{
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
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_4_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), 12343, 12797);
}

arg = parseop_HyExpression_level_15{
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
|c3 = parse_eu_hyvar_feature_expression_HyBooleanValueExpression{ element = c3; /* this is a subclass or primitive expression choice */ }
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_5_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), 12798, 13252);
}

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_5_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, 13253);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_5_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
// We've found the last token for this rule. The constructed EObject is now
// complete.
completedElement(element, true);
addExpectedElement(null, 13254, 13259);
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
	retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_6_0_0_0_0_0_0, proxy, true);
	copyLocalizationInfos((CommonToken) a0, element);
	copyLocalizationInfos((CommonToken) a0, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 13260, 13261);
addExpectedElement(null, 13262, 13267);
}


|(
a1 = IDENTIFIER_TOKEN
{
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
	retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_6_0_0_0_0_1_0, proxy, true);
	copyLocalizationInfos((CommonToken) a1, element);
	copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 13268, 13269);
addExpectedElement(null, 13270, 13275);
}

)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), 13276, 13277);
addExpectedElement(null, 13278, 13283);
}

(
(
(
a2_0 = parse_eu_hyvar_feature_expression_HyVersionRestriction{
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
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_6_0_0_1_0_0_0, a2_0, true);
		copyLocalizationInfos(a2_0, element);
	}
}
)
{
// expected elements (follow set)
// We've found the last token for this rule. The constructed EObject is now
// complete.
completedElement(element, true);
addExpectedElement(null, 13284, 13289);
}

)

)?{
// expected elements (follow set)
// We've found the last token for this rule. The constructed EObject is now
// complete.
completedElement(element, true);
addExpectedElement(null, 13290, 13295);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_7_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, 13296, 13297);
}

(
(
a1 = QUOTED_34_34
{
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
	retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_0_0, proxy, true);
	copyLocalizationInfos((CommonToken) a1, element);
	copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 13298, 13299);
}


|(
a2 = IDENTIFIER_TOKEN
{
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
	retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_1_0, proxy, true);
	copyLocalizationInfos((CommonToken) a2, element);
	copyLocalizationInfos((CommonToken) a2, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 13300, 13301);
}

)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), 13302, 13303);
}

(
a3_0 = parse_eu_hyvar_feature_expression_HyVersionRestriction{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_7_0_0_2, a3_0, true);
copyLocalizationInfos(a3_0, element);
}
}
)
{
// expected elements (follow set)
// We've found the last token for this rule. The constructed EObject is now
// complete.
completedElement(element, true);
addExpectedElement(null, 13304, 13309);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_8_0_0_0, true, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_8_0_0_0, false, true);
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
// We've found the last token for this rule. The constructed EObject is now
// complete.
completedElement(element, true);
addExpectedElement(null, 13310, 13315);
}

;

parseop_HyArithmeticalValueExpression_level_4 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null]
@init{
}
:
leftArg = parseop_HyArithmeticalValueExpression_level_5((
()
{ element = null; }
a0 = '\u0025' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyModuloExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_12_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), 13316, 16249);
}

rightArg = parseop_HyArithmeticalValueExpression_level_5{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_12_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_12_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_HyArithmeticalValueExpression_level_5 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null]
@init{
}
:
leftArg = parseop_HyArithmeticalValueExpression_level_6((
()
{ element = null; }
a0 = '+' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAdditionExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_10_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), 16250, 19183);
}

rightArg = parseop_HyArithmeticalValueExpression_level_6{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_10_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_10_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_HyArithmeticalValueExpression_level_6 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null]
@init{
}
:
leftArg = parseop_HyArithmeticalValueExpression_level_7((
()
{ element = null; }
a0 = '-' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHySubtractionExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_11_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), 19184, 22117);
}

rightArg = parseop_HyArithmeticalValueExpression_level_7{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_11_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_11_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_HyArithmeticalValueExpression_level_7 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null]
@init{
}
:
leftArg = parseop_HyArithmeticalValueExpression_level_8((
()
{ element = null; }
a0 = '*' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMultiplicationExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_13_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), 22118, 25051);
}

rightArg = parseop_HyArithmeticalValueExpression_level_8{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_13_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_13_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_HyArithmeticalValueExpression_level_8 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null]
@init{
}
:
leftArg = parseop_HyArithmeticalValueExpression_level_11((
()
{ element = null; }
a0 = '/' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyDivisionExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_14_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), 25052, 27985);
}

rightArg = parseop_HyArithmeticalValueExpression_level_11{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_14_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_14_0_0_2, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_HyArithmeticalValueExpression_level_11 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null]
@init{
}
:
c0 = parse_eu_hyvar_feature_expression_HyAttributeReferenceExpression{ element = c0; /* this is a subclass or primitive expression choice */ }
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_17_0_0_0_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a0, element);
copyLocalizationInfos((CommonToken) a0, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, 27986);
}


|(
a1 = IDENTIFIER_TOKEN
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_17_0_0_0_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, 27987);
}

)
{
// expected elements (follow set)
addExpectedElement(null, 27988);
}

a2 = '.' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_17_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, 27989);
}

(
a3 = IDENTIFIER_TOKEN
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_17_0_0_2, proxy, true);
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
addExpectedElement(null, 27990, 27996);
}

;

parseop_HyArithmeticalValueExpression_level_12 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null]
@init{
}
:
c0 = parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression{ element = c0; /* this is a subclass or primitive expression choice */ }
;

parse_eu_hyvar_feature_expression_HyContextInformationReferenceExpression returns [eu.hyvar.feature.expression.HyContextInformationReferenceExpression element = null]
@init{
}
:
(
(
a0 = QUOTED_34_34
{
if (terminateParsing) {
throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
startIncompleteElement(element);
}
if (a0 != null) {
eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_18_0_0_0_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a0, element);
copyLocalizationInfos((CommonToken) a0, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, 27997, 28003);
}


|(
a1 = IDENTIFIER_TOKEN
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_18_0_0_0_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
// We've found the last token for this rule. The constructed EObject is now
// complete.
completedElement(element, true);
addExpectedElement(null, 28004, 28010);
}

)
{
// expected elements (follow set)
// We've found the last token for this rule. The constructed EObject is now
// complete.
completedElement(element, true);
addExpectedElement(null, 28011, 28017);
}

;

parseop_HyArithmeticalValueExpression_level_13 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null]
@init{
}
:
c0 = parse_eu_hyvar_feature_expression_HyValueExpression{ element = c0; /* this is a subclass or primitive expression choice */ }
;

parse_eu_hyvar_feature_expression_HyValueExpression returns [eu.hyvar.feature.expression.HyValueExpression element = null]
@init{
}
:
(
a0_0 = parse_eu_hyvar_dataValues_HyValue{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_19_0_0_0, a0_0, true);
copyLocalizationInfos(a0_0, element);
}
}
)
{
// expected elements (follow set)
// We've found the last token for this rule. The constructed EObject is now
// complete.
completedElement(element, true);
addExpectedElement(null, 28018, 28024);
}

;

parseop_HyArithmeticalValueExpression_level_14 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null]
@init{
}
:
a0 = '-' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNegationExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_15_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), 28025, 30958);
}

arg = parseop_HyArithmeticalValueExpression_level_15{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_15_0_0_1, arg, true);
copyLocalizationInfos(arg, element);
}
}
|

arg = parseop_HyArithmeticalValueExpression_level_15{ element = arg; }
;

parseop_HyArithmeticalValueExpression_level_15 returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null]
@init{
}
:
c0 = parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression{ element = c0; /* this is a subclass or primitive expression choice */ }
;

parse_eu_hyvar_feature_expression_HyNestedArithmeticalValueExpression returns [eu.hyvar.feature.expression.HyNestedArithmeticalValueExpression element = null]
@init{
}
:
a0 = '(' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedArithmeticalValueExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_16_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedArithmeticalValueExpression(), 30959, 33892);
}

(
a1_0 = parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression{
if (terminateParsing) {
throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_16_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, 33893);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedArithmeticalValueExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_16_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
// We've found the last token for this rule. The constructed EObject is now
// complete.
completedElement(element, true);
addExpectedElement(null, 33894, 33900);
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
)
{
// expected elements (follow set)
// We've found the last token for this rule. The constructed EObject is now
// complete.
completedElement(element, true);
addExpectedElement(null, 33901, 33907);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_1_0_0_0, true, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_1_0_0_0, false, true);
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
addExpectedElement(null, 33908, 33914);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, 33915, 33916);
}

(
(
a1 = QUOTED_34_34
{
if (terminateParsing) {
throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, 33917);
}


|(
a2 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
if (a2 != null) {
eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a2, element);
copyLocalizationInfos((CommonToken) a2, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, 33918);
}

)
{
// expected elements (follow set)
addExpectedElement(null, 33919);
}

a3 = '.' {
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a3, element);
}
{
// expected elements (follow set)
addExpectedElement(null, 33920, 33921);
}

(
(
a4 = QUOTED_34_34
{
if (terminateParsing) {
throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
if (a4 != null) {
eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a4, element);
copyLocalizationInfos((CommonToken) a4, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, 33922, 33928);
}


|(
a5 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
if (a5 != null) {
eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_1_0, proxy, true);
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
addExpectedElement(null, 33929, 33935);
}

)
{
// expected elements (follow set)
// We've found the last token for this rule. The constructed EObject is now
// complete.
completedElement(element, true);
addExpectedElement(null, 33936, 33942);
}

;

parse_eu_hyvar_feature_expression_HyExpression returns [eu.hyvar.feature.expression.HyExpression element = null]
:
c = parseop_HyExpression_level_0{ element = c; /* this rule is an expression root */ }

;

parse_eu_hyvar_feature_expression_HyArithmeticalValueExpression returns [eu.hyvar.feature.expression.HyArithmeticalValueExpression element = null]
:
c = parseop_HyArithmeticalValueExpression_level_4{ element = c; /* this rule is an expression root */ }

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

QUOTED_6060_6262:
(('<<')(~('>')|'>'~('>'))*('>>'))
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

