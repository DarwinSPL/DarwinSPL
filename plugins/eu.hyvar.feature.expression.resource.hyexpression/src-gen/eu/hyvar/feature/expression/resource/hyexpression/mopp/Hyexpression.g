grammar Hyexpression;

options {
	superClass = HyexpressionANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package eu.hyvar.feature.expression.resource.hyexpression.mopp;
	
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
	package eu.hyvar.feature.expression.resource.hyexpression.mopp;
	
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
	private eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolverFactory tokenResolverFactory = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTokenResolverFactory();
	
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
	private List<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal> expectedElements = new ArrayList<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal>();
	
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
	
	private eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionLocationMap locationMap;
	
	private eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionSyntaxErrorMessageConverter syntaxErrorMessageConverter = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionSyntaxErrorMessageConverter(tokenNames);
	
	@Override
	public void reportError(RecognitionException re) {
		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
	}
	
	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
		postParseCommands.add(new eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource>() {
			public boolean execute(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionProblem() {
					public eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemSeverity getSeverity() {
						return eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemSeverity.ERROR;
					}
					public eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemType getType() {
						return eu.hyvar.feature.expression.resource.hyexpression.HyexpressionEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	protected void addErrorToResource(eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionLocalizedMessage message) {
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
		eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionExpectedElement terminal = eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionFollowSetProvider.TERMINALS[terminalID];
		eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContainedFeature[] containmentFeatures = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionFollowSetProvider.LINKS[ids[i]];
		}
		eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainmentTrace containmentTrace = new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainmentTrace(eClass, containmentFeatures);
		EObject container = getLastIncompleteElement();
		eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal expectedElement = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
		final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource>() {
			public boolean execute(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource resource) {
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
		final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource>() {
			public boolean execute(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource resource) {
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
	protected void setLocalizationEnd(Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource>() {
			public boolean execute(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource resource) {
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
				return true;
			}
		});
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextParser createInstance(InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new HyexpressionParser(new CommonTokenStream(new HyexpressionLexer(new ANTLRInputStream(actualInputStream))));
			} else {
				return new HyexpressionParser(new CommonTokenStream(new HyexpressionLexer(new ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (IOException e) {
			new eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public HyexpressionParser() {
		super(null);
	}
	
	protected EObject doParse() throws RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((HyexpressionLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((HyexpressionLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof EClass) {
			EClass type = (EClass) typeObject;
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
		throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionUnexpectedContentTypeException(typeObject);
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
			typeObject = options.get(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionParseResult parse() {
		// Reset parser state
		terminateParsing = false;
		postParseCommands = new ArrayList<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource>>();
		eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionParseResult parseResult = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionParseResult();
		if (disableLocationMap) {
			locationMap = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionDevNullLocationMap();
		} else {
			locationMap = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionLocationMap();
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
	
	public List<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal> parseToExpectedElements(EClass type, eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
		eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionParseResult result = parse();
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
			for (eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionCommand<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		Set<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal> currentFollowSet = new LinkedHashSet<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal>();
		List<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal> newFollowSet = new ArrayList<eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 114;
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
				for (eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						Collection<eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionPair<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionExpectedElement, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionPair<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionExpectedElement, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContainedFeature[]> newFollowerPair : newFollowers) {
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionExpectedElement newFollower = newFollowerPair.getLeft();
							EObject container = getLastIncompleteElement();
							eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainmentTrace containmentTrace = new eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionContainmentTrace(null, newFollowerPair.getRight());
							eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal newFollowTerminal = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
		for (eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectedTerminal expectedElement, int tokenIndex) {
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
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[0]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[2]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[3]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[4]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[5]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[6]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[7]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[8]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[9]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[10]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[11]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[12]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[13]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[14]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[15]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[16]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[17]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[18]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[19]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[20]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[21]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[22]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[23]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[24]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[25]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[26]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[28]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[29]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[30]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[31]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[32]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[33]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[34]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[35]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[36]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[37]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[38]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[39]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[40]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[41]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[42]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[43]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[44]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[45]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[46]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[47]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[48]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[49]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[50]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[51]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[52]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[53]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[54]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[55]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[56]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[57]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[58]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[59]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[60]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[61]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[62]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[63]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[64]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[65]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[66]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[67]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[68]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[69]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[70]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[71]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[72]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[73]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[74]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyValueExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[75]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[76]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[77]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[78]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[79]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[80]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[81]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[82]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[83]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[84]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[85]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[86]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[87]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[88]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[89]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[90]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[91]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[92]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[93]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[94]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[95]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[96]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[97]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[98]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[99]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[100]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[101]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[102]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[103]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[104]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[105]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[106]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[107]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[108]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[109]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[110]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[111]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[112]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[113]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[114]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[115]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[116]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[117]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[118]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[119]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[120]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[121]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[122]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[123]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[124]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[125]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[126]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[127]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[128]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[129]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[130]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[131]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[132]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[133]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[134]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[135]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[136]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[137]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[138]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[139]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[140]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[141]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[142]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[143]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[144]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[145]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[146]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[147]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[148]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[149]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[150]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[151]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[152]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[153]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[154]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[155]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[156]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[157]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[158]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[159]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[160]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[161]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[162]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[163]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[164]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[165]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[166]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[167]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[168]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[169]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[170]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[171]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[172]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[173]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[174]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[175]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[176]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[177]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[178]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[179]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[180]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[181]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[182]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[183]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[184]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[185]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[186]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[187]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[188]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[189]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[190]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[191]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[192]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[193]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[194]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[195]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[196]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[197]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[198]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[199]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[200]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[201]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[202]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[203]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[204]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[205]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[206]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[207]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[208]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[209]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[210]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[211]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[212]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[213]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[214]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[215]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[216]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[217]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[218]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[219]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[220]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[221]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[222]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[223]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[224]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[225]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[226]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[227]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[228]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[229]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[230]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[231]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[232]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[233]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[234]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[235]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[236]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[237]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[238]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[239]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[240]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[241]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[242]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[243]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[244]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[245]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[246]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[247]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[248]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[249]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[250]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[251]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[252]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[253]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[254]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[255]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_eu_hyvar_feature_expression_HyExpression{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[256]);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[257]);
	}
	
	(
		a8 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
			}
			if (a8 != null) {
				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
				collectHiddenTokens(element);
				registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyRelativeVersionRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyRelativeVersionRestrictionVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_2, proxy, true);
				copyLocalizationInfos((CommonToken) a8, element);
				copyLocalizationInfos((CommonToken) a8, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[258]);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_27_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[259]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[260]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[261]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[262]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[263]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[264]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[265]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[266]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[267]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[268]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[269]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[270]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[271]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[272]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[273]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[274]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[275]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[276]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[277]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[278]);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_28_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[279]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[280]);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_28_0_0_1, false, true);
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of boolean attribute
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[281]);
	}
	
	(
		a3 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
				collectHiddenTokens(element);
				registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionLowerVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_28_0_0_2, proxy, true);
				copyLocalizationInfos((CommonToken) a3, element);
				copyLocalizationInfos((CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[282]);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_28_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[283]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[284]);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_28_0_0_4, false, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of boolean attribute
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[285]);
	}
	
	(
		a7 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
				collectHiddenTokens(element);
				registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionUpperVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_28_0_0_5, proxy, true);
				copyLocalizationInfos((CommonToken) a7, element);
				copyLocalizationInfos((CommonToken) a7, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[286]);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_28_0_0_6, null, true);
		copyLocalizationInfos((CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[287]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[288]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[289]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[290]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[291]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[292]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[293]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[294]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[295]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[296]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[297]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[298]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[299]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[300]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[301]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[302]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[303]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[304]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[305]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[306]);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[307]);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
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
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_1, resolved, true);
				copyLocalizationInfos((CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[308]);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[309]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[310]);
	}
	
	(
		(
			(
				a3_0 = parse_eu_hyvar_dataValues_HyEnumLiteral				{
					if (terminateParsing) {
						throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
						retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_0, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[311]);
				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[312]);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[313]);
					}
					
					(
						a5_0 = parse_eu_hyvar_dataValues_HyEnumLiteral						{
							if (terminateParsing) {
								throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
								retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_1, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[314]);
						addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[315]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[316]);
				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[317]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[318]);
	}
	
	a6 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[319]);
	}
	
	(
		(
			a7 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[320]);
				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[321]);
				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[322]);
			}
			
			(
				(
					a8 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a8 != null) {
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, resolved, true);
							copyLocalizationInfos((CommonToken) a8, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[323]);
				}
				
				a9 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[324]);
				}
				
				(
					a10 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a10 != null) {
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_2, resolved, true);
							copyLocalizationInfos((CommonToken) a10, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[325]);
				}
				
				
				|				(
					a11 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a11 != null) {
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, resolved, true);
							copyLocalizationInfos((CommonToken) a11, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[326]);
				}
				
				a12 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[327]);
				}
				
				
				|				a13 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[328]);
				}
				
				a14 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[329]);
				}
				
				(
					a15 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a15 != null) {
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_2, resolved, true);
							copyLocalizationInfos((CommonToken) a15, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[330]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[331]);
			}
			
			a16 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[332]);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
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
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_1, resolved, true);
				copyLocalizationInfos((CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[333]);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[334]);
	}
	
	(
		a3 = INTEGER_LITERAL		
		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
				startIncompleteElement(element);
			}
			if (a3 != null) {
				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
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
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_3, resolved, true);
				copyLocalizationInfos((CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[335]);
	}
	
	a4 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[336]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[337]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[338]);
	}
	
	(
		(
			a5 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[339]);
				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[340]);
				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[341]);
			}
			
			(
				(
					a6 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a6 != null) {
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, resolved, true);
							copyLocalizationInfos((CommonToken) a6, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[342]);
				}
				
				a7 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[343]);
				}
				
				(
					a8 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a8 != null) {
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_2, resolved, true);
							copyLocalizationInfos((CommonToken) a8, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[344]);
				}
				
				
				|				(
					a9 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a9 != null) {
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, resolved, true);
							copyLocalizationInfos((CommonToken) a9, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[345]);
				}
				
				a10 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a10, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[346]);
				}
				
				a11 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[347]);
				}
				
				
				|				a12 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[348]);
				}
				
				a13 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[349]);
				}
				
				(
					a14 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a14 != null) {
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_2, resolved, true);
							copyLocalizationInfos((CommonToken) a14, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[350]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[351]);
			}
			
			a15 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[352]);
				addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[353]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[354]);
		addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[355]);
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
			retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_0_0_0_1, null, true);
			copyLocalizationInfos((CommonToken)a0, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[356]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[357]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[358]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[359]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[360]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[361]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[362]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[363]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[364]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[365]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[366]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[367]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[368]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[369]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[370]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[371]);
		}
		
		rightArg = parseop_HyExpression_level_1		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_0_0_0_0, leftArg, true);
				copyLocalizationInfos(leftArg, element);
			}
		}
		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
				retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_0_0_0_2, rightArg, true);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_1_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[372]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[373]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[374]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[375]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[376]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[377]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[378]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[379]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[380]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[381]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[382]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[383]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[384]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[385]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[386]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[387]);
	}
	
	rightArg = parseop_HyExpression_level_4	{
		if (terminateParsing) {
			throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
			retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_1_0_0_0, leftArg, true);
			copyLocalizationInfos(leftArg, element);
		}
	}
	{
		if (terminateParsing) {
			throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
			retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_1_0_0_2, rightArg, true);
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
	retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_2_0_0_1, null, true);
	copyLocalizationInfos((CommonToken)a0, element);
}
{
	// expected elements (follow set)
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[388]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[389]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[390]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[391]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[392]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[393]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[394]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[395]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[396]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[397]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[398]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[399]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[400]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[401]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[402]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[403]);
}

rightArg = parseop_HyExpression_level_5{
	if (terminateParsing) {
		throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_2_0_0_0, leftArg, true);
		copyLocalizationInfos(leftArg, element);
	}
}
{
	if (terminateParsing) {
		throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
		retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_2_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_3_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[404]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[405]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[406]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[407]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[408]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[409]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[410]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[411]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[412]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[413]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[414]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[415]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[416]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[417]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[418]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[419]);
}

rightArg = parseop_HyExpression_level_9{
if (terminateParsing) {
	throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
	retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_3_0_0_0, leftArg, true);
	copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
	throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
	retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_3_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_16_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[420]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[421]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[422]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[423]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[424]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[425]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[426]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[427]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[428]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[429]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[430]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[431]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[432]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[433]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[434]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[435]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_16_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_16_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_17_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[436]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[437]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[438]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[439]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[440]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[441]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[442]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[443]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[444]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[445]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[446]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[447]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[448]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[449]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[450]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[451]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_17_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_17_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_18_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[452]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[453]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[454]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[455]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[456]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[457]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[458]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[459]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[460]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[461]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[462]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[463]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[464]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[465]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[466]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[467]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_18_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_18_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_19_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[468]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[469]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[470]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[471]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[472]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[473]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[474]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[475]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[476]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[477]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[478]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[479]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[480]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[481]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[482]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[483]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_19_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_19_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_25_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[484]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[485]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[486]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[487]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[488]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[489]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[490]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[491]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[492]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[493]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[494]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[495]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[496]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[497]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[498]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[499]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_25_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_25_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_26_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[500]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[501]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[502]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[503]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[504]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[505]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[506]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[507]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[508]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[509]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[510]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[511]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[512]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[513]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[514]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[515]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_26_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_26_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[516]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[517]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[518]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[519]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[520]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[521]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[522]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[523]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[524]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[525]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[526]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[527]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[528]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[529]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[530]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[531]);
}

rightArg = parseop_HyExpression_level_13{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_20_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_20_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_21_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[532]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[533]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[534]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[535]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[536]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[537]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[538]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[539]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[540]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[541]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[542]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[543]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[544]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[545]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[546]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[547]);
}

rightArg = parseop_HyExpression_level_13{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_21_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_21_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_22_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[548]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[549]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[550]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[551]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[552]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[553]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[554]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[555]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[556]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[557]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[558]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[559]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[560]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[561]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[562]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[563]);
}

rightArg = parseop_HyExpression_level_14{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_22_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_22_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_23_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[564]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[565]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[566]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[567]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[568]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[569]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[570]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[571]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[572]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[573]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[574]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[575]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[576]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[577]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[578]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[579]);
}

rightArg = parseop_HyExpression_level_14{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_23_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_23_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_24_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[580]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[581]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[582]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[583]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[584]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[585]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[586]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[587]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[588]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[589]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[590]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[591]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[592]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[593]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[594]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[595]);
}

rightArg = parseop_HyExpression_level_14{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_24_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_24_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_4_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[596]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[597]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[598]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[599]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[600]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[601]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[602]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[603]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[604]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[605]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[606]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[607]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[608]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[609]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[610]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[611]);
}

arg = parseop_HyExpression_level_15{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_4_0_0_1, arg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_5_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[612]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[613]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[614]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[615]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[616]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[617]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[618]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[619]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[620]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[621]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[622]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[623]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[624]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[625]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[626]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[627]);
}

arg = parseop_HyExpression_level_15{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_5_0_0_1, arg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_6_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[628]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[629]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[630]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[631]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[632]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[633]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[634]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[635]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[636]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[637]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[638]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[639]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[640]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[641]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[642]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[643]);
}

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_6_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[644]);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_6_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[645]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[646]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[647]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[648]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[649]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[650]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[651]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[652]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[653]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[654]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[655]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[656]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[657]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[658]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[659]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[660]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[661]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[662]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[663]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[664]);
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
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
startIncompleteElement(element);
}
if (a0 != null) {
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a0, element);
copyLocalizationInfos((CommonToken) a0, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[665]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[666]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[667]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[668]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[669]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[670]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[671]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[672]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[673]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[674]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[675]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[676]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[677]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[678]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[679]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[680]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[681]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[682]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[683]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[684]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[685]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[686]);
}


|(
a1 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[687]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[688]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[689]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[690]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[691]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[692]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[693]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[694]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[695]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[696]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[697]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[698]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[699]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[700]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[701]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[702]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[703]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[704]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[705]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[706]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[707]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[708]);
}

)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[709]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[710]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[711]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[712]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[713]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[714]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[715]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[716]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[717]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[718]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[719]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[720]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[721]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[722]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[723]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[724]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[725]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[726]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[727]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[728]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[729]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[730]);
}

(
(
(
a2_0 = parse_eu_hyvar_feature_expression_HyVersionRestriction{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_0_0, a2_0, true);
copyLocalizationInfos(a2_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[731]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[732]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[733]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[734]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[735]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[736]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[737]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[738]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[739]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[740]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[741]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[742]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[743]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[744]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[745]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[746]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[747]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[748]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[749]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[750]);
}

)

)?{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[751]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[752]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[753]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[754]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[755]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[756]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[757]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[758]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[759]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[760]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[761]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[762]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[763]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[764]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[765]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[766]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[767]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[768]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[769]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[770]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_8_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[771]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[772]);
}

(
(
a1 = QUOTED_34_34
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[773]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[774]);
}


|(
a2 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
startIncompleteElement(element);
}
if (a2 != null) {
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a2, element);
copyLocalizationInfos((CommonToken) a2, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[775]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[776]);
}

)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[777]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[778]);
}

(
a3_0 = parse_eu_hyvar_feature_expression_HyVersionRestriction{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_8_0_0_2, a3_0, true);
copyLocalizationInfos(a3_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[779]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[780]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[781]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[782]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[783]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[784]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[785]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[786]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[787]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[788]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[789]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[790]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[791]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[792]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[793]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[794]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[795]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[796]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[797]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[798]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_9_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[799]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[800]);
}

(
(
a1 = QUOTED_34_34
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.context.HyContextualInformation proxy = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextInformationReferenceExpressionContextInformationReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_9_0_0_1_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[801]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[802]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[803]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[804]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[805]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[806]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[807]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[808]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[809]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[810]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[811]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[812]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[813]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[814]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[815]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[816]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[817]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[818]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[819]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[820]);
}


|(
a2 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
startIncompleteElement(element);
}
if (a2 != null) {
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.context.HyContextualInformation proxy = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextInformationReferenceExpressionContextInformationReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_9_0_0_1_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a2, element);
copyLocalizationInfos((CommonToken) a2, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[821]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[822]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[823]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[824]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[825]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[826]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[827]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[828]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[829]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[830]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[831]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[832]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[833]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[834]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[835]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[836]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[837]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[838]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[839]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[840]);
}

)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[841]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[842]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[843]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[844]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[845]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[846]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[847]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[848]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[849]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[850]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[851]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[852]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[853]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[854]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[855]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[856]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[857]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[858]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[859]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[860]);
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
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
startIncompleteElement(element);
}
if (a0 != null) {
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a0, element);
copyLocalizationInfos((CommonToken) a0, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[861]);
}


|(
a1 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[862]);
}

)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[863]);
}

a2 = '.' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_10_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[864]);
}

(
a3 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
startIncompleteElement(element);
}
if (a3 != null) {
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeatureAttribute proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyNumberAttribute();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeatureAttribute>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionAttributeReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_10_0_0_2, proxy, true);
copyLocalizationInfos((CommonToken) a3, element);
copyLocalizationInfos((CommonToken) a3, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[865]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[866]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[867]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[868]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[869]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[870]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[871]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[872]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[873]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[874]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[875]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[876]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[877]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[878]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[879]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[880]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[881]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[882]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[883]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[884]);
}

;

parse_eu_hyvar_feature_expression_HyValueExpression returns [eu.hyvar.feature.expression.HyValueExpression element = null]
@init{
}
:
(
a0_0 = parse_eu_hyvar_dataValues_HyValue{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_11_0_0_0, a0_0, true);
copyLocalizationInfos(a0_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[885]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[886]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[887]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[888]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[889]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[890]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[891]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[892]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[893]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[894]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[895]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[896]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[897]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[898]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[899]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[900]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[901]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[902]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[903]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[904]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_12_0_0_0, true, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_12_0_0_0, false, true);
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
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[905]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[906]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[907]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[908]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[909]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[910]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[911]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[912]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[913]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[914]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[915]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[916]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[917]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[918]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[919]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[920]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[921]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[922]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[923]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[924]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_13_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[925]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[926]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[927]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[928]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[929]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[930]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[931]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[932]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[933]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[934]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[935]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[936]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[937]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[938]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[939]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[940]);
}

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_13_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[941]);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMinimumExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_13_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[942]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[943]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[944]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[945]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[946]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[947]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[948]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[949]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[950]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[951]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[952]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[953]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[954]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[955]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[956]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[957]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[958]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[959]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[960]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[961]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_14_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[962]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[963]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[964]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[965]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[966]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[967]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[968]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[969]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[970]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[971]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[972]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[973]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[974]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[975]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[976]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[977]);
}

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_14_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[978]);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMaximumExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_14_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[979]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[980]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[981]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[982]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[983]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[984]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[985]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[986]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[987]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[988]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[989]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[990]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[991]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[992]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[993]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[994]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[995]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[996]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[997]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[998]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_15_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[999]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1000]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1001]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1002]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1003]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1004]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1005]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1006]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1007]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1008]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1009]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1010]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1011]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1012]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1013]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1014]);
}

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_15_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1015]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1016]);
}

(
(
a2 = ',' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1017]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1018]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1019]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1020]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1021]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1022]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1023]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1024]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1025]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1026]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1027]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1028]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1029]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1030]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1031]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1032]);
}

(
a3_0 = parse_eu_hyvar_feature_expression_HyExpression{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_1, a3_0, true);
copyLocalizationInfos(a3_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1033]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1034]);
}

)

)*{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1035]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1036]);
}

a4 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYEXPRESSION_15_0_0_3, null, true);
copyLocalizationInfos((CommonToken)a4, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1037]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1038]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1039]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1040]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1041]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1042]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1043]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1044]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1045]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1046]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1047]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1048]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1049]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1050]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1051]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1052]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1053]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1054]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1055]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1056]);
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
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyNumberValue();
startIncompleteElement(element);
}
if (a0 != null) {
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_0_0_0_0, resolved, true);
copyLocalizationInfos((CommonToken) a0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1057]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1058]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1059]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1060]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1061]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1062]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1063]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1064]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1065]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1066]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1067]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1068]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1069]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1070]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1071]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1072]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1073]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1074]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1075]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1076]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_1_0_0_0, true, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_1_0_0_0, false, true);
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
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1077]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1078]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1079]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1080]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1081]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1082]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1083]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1084]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1085]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1086]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1087]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1088]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1089]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1090]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1091]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1092]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1093]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1094]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1095]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1096]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1097]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1098]);
}

(
(
a1 = QUOTED_34_34
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1099]);
}


|(
a2 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
if (a2 != null) {
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_2_0_0_1_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a2, element);
copyLocalizationInfos((CommonToken) a2, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1100]);
}

)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1101]);
}

a3 = '.' {
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a3, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1102]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1103]);
}

(
(
a4 = QUOTED_34_34
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
if (a4 != null) {
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a4, element);
copyLocalizationInfos((CommonToken) a4, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1104]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1105]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1106]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1107]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1108]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1109]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1110]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1111]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1112]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1113]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1114]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1115]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1116]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1117]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1118]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1119]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1120]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1121]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1122]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1123]);
}


|(
a5 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
if (a5 != null) {
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionGrammarInformationProvider.HYDATAVALUE_2_0_0_3_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a5, element);
copyLocalizationInfos((CommonToken) a5, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1124]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1125]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1126]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1127]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1128]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1129]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1130]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1131]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1132]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1133]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1134]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1135]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1136]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1137]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1138]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1139]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1140]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1141]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1142]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1143]);
}

)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1144]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1145]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1146]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1147]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1148]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1149]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1150]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1151]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1152]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1153]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1154]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1155]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1156]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1157]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1158]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1159]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1160]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1161]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1162]);
addExpectedElement(null, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionExpectationConstants.EXPECTATIONS[1163]);
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

