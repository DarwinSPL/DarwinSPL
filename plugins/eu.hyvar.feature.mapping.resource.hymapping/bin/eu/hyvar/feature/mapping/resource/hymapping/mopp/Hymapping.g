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
	
}

start returns [ EObject element = null]
:
	{
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
					
				)
				
			)*			{
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
			
		)
		
	)?	{
		// expected elements (follow set)
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
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[82]);
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
		addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[83]);
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
				addExpectedElement(eu.hyvar.feature.mapping.MappingPackage.eINSTANCE.getHyMapping(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[102]);
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
			
		)
		
	)*	{
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
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[139]);
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[140]);
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[141]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[142]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[143]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[144]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[145]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[146]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[147]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[148]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[149]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[150]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[151]);
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
			
		)
		
	)?	{
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
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[184]);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[185]);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_2, proxy, true);
				copyLocalizationInfos((CommonToken) a8, element);
				copyLocalizationInfos((CommonToken) a8, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[186]);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_27_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a9, element);
	}
	{
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
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_28_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[208]);
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[209]);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_28_0_0_1, false, true);
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of boolean attribute
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[210]);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_28_0_0_2, proxy, true);
				copyLocalizationInfos((CommonToken) a3, element);
				copyLocalizationInfos((CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[211]);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_28_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[212]);
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[213]);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_28_0_0_4, false, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of boolean attribute
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[214]);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_28_0_0_5, proxy, true);
				copyLocalizationInfos((CommonToken) a7, element);
				copyLocalizationInfos((CommonToken) a7, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[215]);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_28_0_0_6, null, true);
		copyLocalizationInfos((CommonToken)a8, element);
	}
	{
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
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[237]);
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
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[238]);
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
		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[239]);
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[240]);
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
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[241]);
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[242]);
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
						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[243]);
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
						addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[244]);
						addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[245]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[246]);
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[247]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[248]);
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
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[249]);
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
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[250]);
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[251]);
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[252]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[253]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[254]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[255]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[256]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[257]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[258]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[259]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[260]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[261]);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[262]);
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
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[263]);
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
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[264]);
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
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[265]);
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
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[266]);
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[267]);
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[268]);
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
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[269]);
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[270]);
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[271]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[272]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[273]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[274]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[275]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[276]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[277]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[278]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[279]);
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
					addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[280]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[281]);
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
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[282]);
				addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[283]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[284]);
		addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[285]);
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
leftArg = parseop_HyExpression_level_4((
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
	
	rightArg = parseop_HyExpression_level_4	{
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
	retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_2_0_0_1, null, true);
	copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_5{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_3_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_9{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_16_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_12{
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
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_17_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_12{
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
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_18_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_12{
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
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_19_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_12{
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
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_25_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_12{
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
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_26_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_12{
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
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_13{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_20_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_13{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_21_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_22_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_14{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_22_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_23_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_14{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_23_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_24_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_14{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_24_0_0_2, rightArg, true);
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
a2 = '-' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNegationExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_5_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
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

arg = parseop_HyExpression_level_15{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_6_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_6_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[574]);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_6_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a0, element);
copyLocalizationInfos((CommonToken) a0, proxy);
}
}
)
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
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

)
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_0_0, a2_0, true);
copyLocalizationInfos(a2_0, element);
}
}
)
{
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

)

)?{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_8_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[707]);
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[708]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[709]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[710]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a2, element);
copyLocalizationInfos((CommonToken) a2, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[711]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[712]);
}

)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[713]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[714]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_8_0_0_2, a3_0, true);
copyLocalizationInfos(a3_0, element);
}
}
)
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[736]);
}

(
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_9_0_0_1, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a0, element);
copyLocalizationInfos((CommonToken) a0, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[758]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[759]);
}

)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[760]);
}

a2 = '.' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_10_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[761]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_10_0_0_2, proxy, true);
copyLocalizationInfos((CommonToken) a3, element);
copyLocalizationInfos((CommonToken) a3, proxy);
}
}
)
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_11_0_0_0, a0_0, true);
copyLocalizationInfos(a0_0, element);
}
}
)
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_12_0_0_0, true, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_12_0_0_0, false, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_13_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
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
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[841]);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMinimumExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_13_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_14_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
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
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[879]);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMaximumExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_14_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
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
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_15_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
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
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[917]);
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[918]);
}

(
(
a2 = ',' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
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

(
a3_0 = parse_eu_hyvar_feature_expression_HyExpression{
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
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[935]);
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[936]);
}

)

)*{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[937]);
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[938]);
}

a4 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYEXPRESSION_15_0_0_3, null, true);
copyLocalizationInfos((CommonToken)a4, element);
}
{
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
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1002]);
}

(
a1 = IDENTIFIER_TOKEN
{
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
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1003]);
}

a2 = '.' {
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingExpectationConstants.EXPECTATIONS[1004]);
}

(
a3 = IDENTIFIER_TOKEN
{
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
)
{
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

