grammar Hyconstraints;

options {
	superClass = HyconstraintsANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;
	
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
	package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;
	
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
	private eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolverFactory tokenResolverFactory = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenResolverFactory();
	
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
	private List<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal> expectedElements = new ArrayList<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal>();
	
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
	
	private eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsLocationMap locationMap;
	
	private eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsSyntaxErrorMessageConverter syntaxErrorMessageConverter = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsSyntaxErrorMessageConverter(tokenNames);
	
	@Override
	public void reportError(RecognitionException re) {
		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
	}
	
	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
		postParseCommands.add(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource>() {
			public boolean execute(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsProblem() {
					public eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemSeverity getSeverity() {
						return eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemSeverity.ERROR;
					}
					public eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType getType() {
						return eu.hyvar.feature.constraint.resource.hyconstraints.HyconstraintsEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	protected void addErrorToResource(eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsLocalizedMessage message) {
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
		eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsExpectedElement terminal = eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsFollowSetProvider.TERMINALS[terminalID];
		eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContainedFeature[] containmentFeatures = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsFollowSetProvider.LINKS[ids[i]];
		}
		eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainmentTrace containmentTrace = new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainmentTrace(eClass, containmentFeatures);
		EObject container = getLastIncompleteElement();
		eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal expectedElement = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
		final eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource>() {
			public boolean execute(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource resource) {
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
		final eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource>() {
			public boolean execute(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource resource) {
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
	protected void setLocalizationEnd(Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		final eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource>() {
			public boolean execute(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource resource) {
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
				return true;
			}
		});
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextParser createInstance(InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new HyconstraintsParser(new CommonTokenStream(new HyconstraintsLexer(new ANTLRInputStream(actualInputStream))));
			} else {
				return new HyconstraintsParser(new CommonTokenStream(new HyconstraintsLexer(new ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (IOException e) {
			new eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public HyconstraintsParser() {
		super(null);
	}
	
	protected EObject doParse() throws RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((HyconstraintsLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((HyconstraintsLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof EClass) {
			EClass type = (EClass) typeObject;
			if (type.getInstanceClass() == eu.hyvar.feature.constraint.HyConstraintModel.class) {
				return parse_eu_hyvar_feature_constraint_HyConstraintModel();
			}
			if (type.getInstanceClass() == eu.hyvar.feature.constraint.HyConstraint.class) {
				return parse_eu_hyvar_feature_constraint_HyConstraint();
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
		throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsUnexpectedContentTypeException(typeObject);
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
			typeObject = options.get(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsParseResult parse() {
		// Reset parser state
		terminateParsing = false;
		postParseCommands = new ArrayList<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource>>();
		eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsParseResult parseResult = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsParseResult();
		if (disableLocationMap) {
			locationMap = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsDevNullLocationMap();
		} else {
			locationMap = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsLocationMap();
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
	
	public List<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal> parseToExpectedElements(EClass type, eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
		eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsParseResult result = parse();
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
			for (eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsCommand<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		Set<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal> currentFollowSet = new LinkedHashSet<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal>();
		List<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal> newFollowSet = new ArrayList<eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 124;
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
				for (eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						Collection<eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsPair<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsExpectedElement, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsPair<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsExpectedElement, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContainedFeature[]> newFollowerPair : newFollowers) {
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsExpectedElement newFollower = newFollowerPair.getLeft();
							EObject container = getLastIncompleteElement();
							eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainmentTrace containmentTrace = new eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainmentTrace(null, newFollowerPair.getRight());
							eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal newFollowTerminal = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
		for (eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectedTerminal expectedElement, int tokenIndex) {
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
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[0]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[2]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[3]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[4]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[5]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[6]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[7]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[8]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[9]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[10]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[11]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[12]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[13]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[14]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[15]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_eu_hyvar_feature_constraint_HyConstraintModel{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_eu_hyvar_feature_constraint_HyConstraintModel returns [eu.hyvar.feature.constraint.HyConstraintModel element = null]
@init{
}
:
	(
		(
			a0_0 = parse_eu_hyvar_feature_constraint_HyConstraint			{
				if (terminateParsing) {
					throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
				}
				if (element == null) {
					element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraintModel();
					startIncompleteElement(element);
				}
				if (a0_0 != null) {
					if (a0_0 != null) {
						Object value = a0_0;
						addObjectToList(element, eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT_MODEL__CONSTRAINTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_0_0_0_0, a0_0, true);
					copyLocalizationInfos(a0_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[16]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[17]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[18]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[19]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[20]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[21]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[22]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[23]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[24]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[25]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[26]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[28]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[29]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[30]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[31]);
	}
	
;

parse_eu_hyvar_feature_constraint_HyConstraint returns [eu.hyvar.feature.constraint.HyConstraint element = null]
@init{
}
:
	(
		a0_0 = parse_eu_hyvar_feature_expression_HyExpression		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__ROOT_EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[32]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[33]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[34]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[35]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[36]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[37]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[38]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[39]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[40]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[41]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[42]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[43]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[44]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[45]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[46]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[47]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[48]);
	}
	
	(
		(
			a1 = '[' {
				if (element == null) {
					element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[49]);
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[50]);
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[51]);
			}
			
			(
				(
					a2 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
							startIncompleteElement(element);
						}
						if (a2 != null) {
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_SINCE), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
							}
							java.util.Date resolved = (java.util.Date) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_SINCE), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_0_0, resolved, true);
							copyLocalizationInfos((CommonToken) a2, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[52]);
				}
				
				a3 = '-' {
					if (element == null) {
						element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a3, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[53]);
				}
				
				(
					a4 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
							startIncompleteElement(element);
						}
						if (a4 != null) {
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_UNTIL), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
							}
							java.util.Date resolved = (java.util.Date) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_UNTIL), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_0_2, resolved, true);
							copyLocalizationInfos((CommonToken) a4, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[54]);
				}
				
				
				|				(
					a5 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
							startIncompleteElement(element);
						}
						if (a5 != null) {
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_SINCE), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
							}
							java.util.Date resolved = (java.util.Date) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_SINCE), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_1_0, resolved, true);
							copyLocalizationInfos((CommonToken) a5, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[55]);
				}
				
				a6 = '-' {
					if (element == null) {
						element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[56]);
				}
				
				a7 = 'null' {
					if (element == null) {
						element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[57]);
				}
				
				
				|				a8 = 'null' {
					if (element == null) {
						element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a8, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[58]);
				}
				
				a9 = '-' {
					if (element == null) {
						element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[59]);
				}
				
				(
					a10 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
							startIncompleteElement(element);
						}
						if (a10 != null) {
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_UNTIL), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a10).getLine(), ((CommonToken) a10).getCharPositionInLine(), ((CommonToken) a10).getStartIndex(), ((CommonToken) a10).getStopIndex());
							}
							java.util.Date resolved = (java.util.Date) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.constraint.HyConstraintPackage.HY_CONSTRAINT__VALID_UNTIL), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_1_0_2_2, resolved, true);
							copyLocalizationInfos((CommonToken) a10, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[60]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[61]);
			}
			
			a11 = ']' {
				if (element == null) {
					element = eu.hyvar.feature.constraint.HyConstraintFactory.eINSTANCE.createHyConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYCONSTRAINTS_1_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[62]);
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[63]);
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[64]);
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[65]);
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[66]);
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[67]);
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[68]);
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[69]);
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[70]);
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[71]);
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[72]);
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[73]);
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[74]);
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[75]);
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[76]);
				addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[77]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[78]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[79]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[80]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[81]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[82]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[83]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[84]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[85]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[86]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[87]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[88]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[89]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[90]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[91]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[92]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[93]);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_27_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[94]);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[95]);
	}
	
	(
		a8 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyRelativeVersionRestriction();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
			}
			if (a8 != null) {
				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
				collectHiddenTokens(element);
				registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyRelativeVersionRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyRelativeVersionRestrictionVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__VERSION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_27_0_0_2, proxy, true);
				copyLocalizationInfos((CommonToken) a8, element);
				copyLocalizationInfos((CommonToken) a8, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[96]);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_27_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[97]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[98]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[99]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[100]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[101]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[102]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[103]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[104]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[105]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[106]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[107]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[108]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[109]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[110]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[111]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[112]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[113]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[114]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[115]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[116]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[117]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[118]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[119]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[120]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[121]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[122]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[123]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[124]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[125]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[126]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[127]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[128]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[129]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[130]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[131]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[132]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[133]);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_28_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[134]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[135]);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_28_0_0_1, false, true);
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of boolean attribute
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[136]);
	}
	
	(
		a3 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
				collectHiddenTokens(element);
				registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionLowerVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_VERSION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_28_0_0_2, proxy, true);
				copyLocalizationInfos((CommonToken) a3, element);
				copyLocalizationInfos((CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[137]);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_28_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[138]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[139]);
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
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_28_0_0_4, false, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of boolean attribute
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[140]);
	}
	
	(
		a7 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				eu.hyvar.feature.HyVersion proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyVersion();
				collectHiddenTokens(element);
				registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyVersionRangeRestriction, eu.hyvar.feature.HyVersion>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyVersionRangeRestrictionUpperVersionReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_VERSION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_28_0_0_5, proxy, true);
				copyLocalizationInfos((CommonToken) a7, element);
				copyLocalizationInfos((CommonToken) a7, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[141]);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_28_0_0_6, null, true);
		copyLocalizationInfos((CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[142]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[143]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[144]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[145]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[146]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[147]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[148]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[149]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[150]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[151]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[152]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[153]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[154]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[155]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[156]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[157]);
		addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[158]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[159]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[160]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[161]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[162]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[163]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[164]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[165]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[166]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[167]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[168]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[169]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[170]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[171]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[172]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[173]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[174]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[175]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[176]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[177]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[178]);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[179]);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_1, resolved, true);
				copyLocalizationInfos((CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[180]);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[181]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[182]);
	}
	
	(
		(
			(
				a3_0 = parse_eu_hyvar_dataValues_HyEnumLiteral				{
					if (terminateParsing) {
						throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
						retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_0, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[183]);
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[184]);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[185]);
					}
					
					(
						a5_0 = parse_eu_hyvar_dataValues_HyEnumLiteral						{
							if (terminateParsing) {
								throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
								retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_1, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[186]);
						addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[187]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[188]);
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[189]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[190]);
	}
	
	a6 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[191]);
	}
	
	(
		(
			a7 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[192]);
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[193]);
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[194]);
			}
			
			(
				(
					a8 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a8 != null) {
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_0, resolved, true);
							copyLocalizationInfos((CommonToken) a8, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[195]);
				}
				
				a9 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[196]);
				}
				
				(
					a10 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a10 != null) {
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_2, resolved, true);
							copyLocalizationInfos((CommonToken) a10, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[197]);
				}
				
				
				|				(
					a11 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a11 != null) {
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_0, resolved, true);
							copyLocalizationInfos((CommonToken) a11, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[198]);
				}
				
				a12 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[199]);
				}
				
				a13 = 'null' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[200]);
				}
				
				
				|				a14 = 'null' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[201]);
				}
				
				a15 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a15, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[202]);
				}
				
				(
					a16 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						if (a16 != null) {
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_2, resolved, true);
							copyLocalizationInfos((CommonToken) a16, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[203]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[204]);
			}
			
			a17 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[205]);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_1, resolved, true);
				copyLocalizationInfos((CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[206]);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[207]);
	}
	
	(
		a3 = INTEGER_LITERAL		
		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
			}
			if (element == null) {
				element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
				startIncompleteElement(element);
			}
			if (a3 != null) {
				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				tokenResolver.setOptions(getOptions());
				eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_3, resolved, true);
				copyLocalizationInfos((CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[208]);
	}
	
	a4 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[209]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[210]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[211]);
	}
	
	(
		(
			a5 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[212]);
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[213]);
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[214]);
			}
			
			(
				(
					a6 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a6 != null) {
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_0, resolved, true);
							copyLocalizationInfos((CommonToken) a6, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[215]);
				}
				
				a7 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[216]);
				}
				
				(
					a8 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a8 != null) {
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_2, resolved, true);
							copyLocalizationInfos((CommonToken) a8, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[217]);
				}
				
				
				|				(
					a9 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a9 != null) {
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_0, resolved, true);
							copyLocalizationInfos((CommonToken) a9, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[218]);
				}
				
				a10 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a10, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[219]);
				}
				
				a11 = 'null' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[220]);
				}
				
				
				|				a12 = 'null' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[221]);
				}
				
				a13 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[222]);
				}
				
				(
					a14 = DATE					
					{
						if (terminateParsing) {
							throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
						}
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
							startIncompleteElement(element);
						}
						if (a14 != null) {
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DATE");
							tokenResolver.setOptions(getOptions());
							eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
							retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_2, resolved, true);
							copyLocalizationInfos((CommonToken) a14, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[223]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[224]);
			}
			
			a15 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[225]);
				addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[226]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[227]);
		addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[228]);
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
			retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_0_0_0_1, null, true);
			copyLocalizationInfos((CommonToken)a0, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[229]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[230]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[231]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[232]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[233]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[234]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[235]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[236]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[237]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[238]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[239]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[240]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[241]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[242]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[243]);
			addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEquivalenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[244]);
		}
		
		rightArg = parseop_HyExpression_level_1		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_0_0_0_0, leftArg, true);
				copyLocalizationInfos(leftArg, element);
			}
		}
		{
			if (terminateParsing) {
				throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
				retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_0_0_0_2, rightArg, true);
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
		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_1_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[245]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[246]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[247]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[248]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[249]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[250]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[251]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[252]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[253]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[254]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[255]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[256]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[257]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[258]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[259]);
		addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyImpliesExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[260]);
	}
	
	rightArg = parseop_HyExpression_level_4	{
		if (terminateParsing) {
			throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
			retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_1_0_0_0, leftArg, true);
			copyLocalizationInfos(leftArg, element);
		}
	}
	{
		if (terminateParsing) {
			throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
			retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_1_0_0_2, rightArg, true);
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
	retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_2_0_0_1, null, true);
	copyLocalizationInfos((CommonToken)a0, element);
}
{
	// expected elements (follow set)
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[261]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[262]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[263]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[264]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[265]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[266]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[267]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[268]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[269]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[270]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[271]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[272]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[273]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[274]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[275]);
	addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyOrExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[276]);
}

rightArg = parseop_HyExpression_level_5{
	if (terminateParsing) {
		throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_2_0_0_0, leftArg, true);
		copyLocalizationInfos(leftArg, element);
	}
}
{
	if (terminateParsing) {
		throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
		retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_2_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_3_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[277]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[278]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[279]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[280]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[281]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[282]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[283]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[284]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[285]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[286]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[287]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[288]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[289]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[290]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[291]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAndExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[292]);
}

rightArg = parseop_HyExpression_level_9{
if (terminateParsing) {
	throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
	retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_3_0_0_0, leftArg, true);
	copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
	throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
	retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_3_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_16_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[293]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[294]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[295]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[296]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[297]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[298]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[299]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[300]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[301]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[302]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[303]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[304]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[305]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[306]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[307]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[308]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_16_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_16_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_17_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[309]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[310]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[311]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[312]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[313]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[314]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[315]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[316]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[317]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[318]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[319]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[320]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[321]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[322]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[323]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyLessOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[324]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_17_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_17_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_18_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[325]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[326]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[327]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[328]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[329]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[330]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[331]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[332]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[333]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[334]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[335]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[336]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[337]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[338]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[339]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[340]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_18_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_18_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_19_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[341]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[342]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[343]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[344]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[345]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[346]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[347]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[348]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[349]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[350]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[351]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[352]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[353]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[354]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[355]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyGreaterOrEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[356]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_19_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_19_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_25_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[357]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[358]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[359]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[360]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[361]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[362]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[363]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[364]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[365]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[366]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[367]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[368]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[369]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[370]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[371]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[372]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_25_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_25_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_26_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[373]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[374]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[375]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[376]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[377]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[378]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[379]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[380]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[381]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[382]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[383]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[384]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[385]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[386]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[387]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotEqualExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[388]);
}

rightArg = parseop_HyExpression_level_12{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_26_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_26_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[389]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[390]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[391]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[392]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[393]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[394]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[395]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[396]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[397]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[398]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[399]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[400]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[401]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[402]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[403]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHySubtractionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[404]);
}

rightArg = parseop_HyExpression_level_13{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_20_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_20_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_21_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[405]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[406]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[407]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[408]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[409]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[410]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[411]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[412]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[413]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[414]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[415]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[416]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[417]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[418]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[419]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyAdditionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[420]);
}

rightArg = parseop_HyExpression_level_13{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_21_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_21_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_22_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[421]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[422]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[423]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[424]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[425]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[426]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[427]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[428]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[429]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[430]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[431]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[432]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[433]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[434]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[435]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyModuloExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[436]);
}

rightArg = parseop_HyExpression_level_14{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_22_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_22_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_23_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[437]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[438]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[439]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[440]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[441]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[442]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[443]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[444]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[445]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[446]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[447]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[448]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[449]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[450]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[451]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMultiplicationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[452]);
}

rightArg = parseop_HyExpression_level_14{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_23_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_23_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_24_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[453]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[454]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[455]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[456]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[457]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[458]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[459]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[460]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[461]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[462]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[463]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[464]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[465]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[466]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[467]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyDivisionExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[468]);
}

rightArg = parseop_HyExpression_level_14{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_24_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_24_0_0_2, rightArg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_4_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[469]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[470]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[471]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[472]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[473]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[474]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[475]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[476]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[477]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[478]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[479]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[480]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[481]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[482]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[483]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNotExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[484]);
}

arg = parseop_HyExpression_level_15{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_4_0_0_1, arg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_5_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[485]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[486]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[487]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[488]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[489]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[490]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[491]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[492]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[493]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[494]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[495]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[496]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[497]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[498]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[499]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNegationExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[500]);
}

arg = parseop_HyExpression_level_15{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_5_0_0_1, arg, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_6_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[501]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[502]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[503]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[504]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[505]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[506]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[507]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[508]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[509]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[510]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[511]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[512]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[513]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[514]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[515]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyNestedExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[516]);
}

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_6_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[517]);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_6_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[518]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[519]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[520]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[521]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[522]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[523]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[524]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[525]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[526]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[527]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[528]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[529]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[530]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[531]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[532]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[533]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[534]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[535]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[536]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[537]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[538]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[539]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[540]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[541]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[542]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[543]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[544]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[545]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[546]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[547]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[548]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[549]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[550]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[551]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[552]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[553]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[554]);
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
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
startIncompleteElement(element);
}
if (a0 != null) {
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a0, element);
copyLocalizationInfos((CommonToken) a0, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[555]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[556]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[557]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[558]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[559]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[560]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[561]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[562]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[563]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[564]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[565]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[566]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[567]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[568]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[569]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[570]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[571]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[572]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[573]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[574]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[575]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[576]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[577]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[578]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[579]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[580]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[581]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[582]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[583]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[584]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[585]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[586]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[587]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[588]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[589]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[590]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[591]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[592]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[593]);
}


|(
a1 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_7_0_0_0_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[594]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[595]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[596]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[597]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[598]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[599]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[600]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[601]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[602]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[603]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[604]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[605]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[606]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[607]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[608]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[609]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[610]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[611]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[612]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[613]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[614]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[615]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[616]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[617]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[618]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[619]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[620]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[621]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[622]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[623]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[624]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[625]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[626]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[627]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[628]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[629]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[630]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[631]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[632]);
}

)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[633]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyFeatureReferenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[634]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[635]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[636]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[637]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[638]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[639]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[640]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[641]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[642]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[643]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[644]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[645]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[646]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[647]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[648]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[649]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[650]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[651]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[652]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[653]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[654]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[655]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[656]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[657]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[658]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[659]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[660]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[661]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[662]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[663]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[664]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[665]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[666]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[667]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[668]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[669]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[670]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[671]);
}

(
(
(
a2_0 = parse_eu_hyvar_feature_expression_HyVersionRestriction{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_7_0_0_1_0_0_0, a2_0, true);
copyLocalizationInfos(a2_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[672]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[673]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[674]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[675]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[676]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[677]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[678]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[679]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[680]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[681]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[682]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[683]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[684]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[685]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[686]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[687]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[688]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[689]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[690]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[691]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[692]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[693]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[694]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[695]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[696]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[697]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[698]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[699]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[700]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[701]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[702]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[703]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[704]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[705]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[706]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[707]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[708]);
}

)

)?{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[709]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[710]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[711]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[712]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[713]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[714]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[715]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[716]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[717]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[718]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[719]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[720]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[721]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[722]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[723]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[724]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[725]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[726]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[727]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[728]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[729]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[730]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[731]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[732]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[733]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[734]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[735]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[736]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[737]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[738]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[739]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[740]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[741]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[742]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[743]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[744]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[745]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_8_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[746]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[747]);
}

(
(
a1 = QUOTED_34_34
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[748]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[749]);
}


|(
a2 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyConditionalFeatureReferenceExpression();
startIncompleteElement(element);
}
if (a2 != null) {
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAbstractFeatureReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONDITIONAL_FEATURE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_8_0_0_1_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a2, element);
copyLocalizationInfos((CommonToken) a2, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[750]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[751]);
}

)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[752]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[753]);
}

(
a3_0 = parse_eu_hyvar_feature_expression_HyVersionRestriction{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_8_0_0_2, a3_0, true);
copyLocalizationInfos(a3_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[754]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[755]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[756]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[757]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[758]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[759]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[760]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[761]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[762]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[763]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[764]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[765]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[766]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[767]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[768]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[769]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[770]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[771]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[772]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[773]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[774]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[775]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[776]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[777]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[778]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[779]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[780]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[781]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[782]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[783]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[784]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[785]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[786]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[787]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[788]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[789]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[790]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_9_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[791]);
}

(
a1 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyContextInformationReferenceExpression();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.context.HyContextualInformation proxy = eu.hyvar.context.HyContextInformationFactory.eINSTANCE.createHyContextualInformationEnum();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyContextInformationReferenceExpressionContextInformationReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_CONTEXT_INFORMATION_REFERENCE_EXPRESSION__CONTEXT_INFORMATION), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_9_0_0_1, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[792]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[793]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[794]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[795]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[796]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[797]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[798]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[799]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[800]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[801]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[802]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[803]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[804]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[805]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[806]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[807]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[808]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[809]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[810]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[811]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[812]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[813]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[814]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[815]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[816]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[817]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[818]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[819]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[820]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[821]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[822]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[823]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[824]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[825]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[826]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[827]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[828]);
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
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
startIncompleteElement(element);
}
if (a0 != null) {
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_0_0, proxy, true);
copyLocalizationInfos((CommonToken) a0, element);
copyLocalizationInfos((CommonToken) a0, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[829]);
}


|(
a1 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeature proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyFeature();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__FEATURE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_10_0_0_0_0_1_0, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[830]);
}

)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[831]);
}

a2 = '.' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_10_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[832]);
}

(
a3 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
startIncompleteElement(element);
}
if (a3 != null) {
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.feature.HyFeatureAttribute proxy = eu.hyvar.feature.HyFeatureFactory.eINSTANCE.createHyNumberAttribute();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeatureAttribute>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyAttributeReferenceExpressionAttributeReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_ATTRIBUTE_REFERENCE_EXPRESSION__ATTRIBUTE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_10_0_0_2, proxy, true);
copyLocalizationInfos((CommonToken) a3, element);
copyLocalizationInfos((CommonToken) a3, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[833]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[834]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[835]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[836]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[837]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[838]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[839]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[840]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[841]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[842]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[843]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[844]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[845]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[846]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[847]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[848]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[849]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[850]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[851]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[852]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[853]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[854]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[855]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[856]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[857]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[858]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[859]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[860]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[861]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[862]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[863]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[864]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[865]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[866]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[867]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[868]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[869]);
}

;

parse_eu_hyvar_feature_expression_HyValueExpression returns [eu.hyvar.feature.expression.HyValueExpression element = null]
@init{
}
:
(
a0_0 = parse_eu_hyvar_dataValues_HyValue{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_11_0_0_0, a0_0, true);
copyLocalizationInfos(a0_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[870]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[871]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[872]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[873]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[874]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[875]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[876]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[877]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[878]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[879]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[880]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[881]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[882]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[883]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[884]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[885]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[886]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[887]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[888]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[889]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[890]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[891]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[892]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[893]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[894]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[895]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[896]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[897]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[898]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[899]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[900]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[901]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[902]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[903]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[904]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[905]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[906]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_12_0_0_0, true, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_12_0_0_0, false, true);
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
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[907]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[908]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[909]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[910]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[911]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[912]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[913]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[914]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[915]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[916]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[917]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[918]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[919]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[920]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[921]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[922]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[923]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[924]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[925]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[926]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[927]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[928]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[929]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[930]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[931]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[932]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[933]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[934]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[935]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[936]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[937]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[938]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[939]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[940]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[941]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[942]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[943]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_13_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[944]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[945]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[946]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[947]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[948]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[949]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[950]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[951]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[952]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[953]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[954]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[955]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[956]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[957]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[958]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMinimumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[959]);
}

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_13_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[960]);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMinimumExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_13_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[961]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[962]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[963]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[964]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[965]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[966]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[967]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[968]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[969]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[970]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[971]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[972]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[973]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[974]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[975]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[976]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[977]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[978]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[979]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[980]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[981]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[982]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[983]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[984]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[985]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[986]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[987]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[988]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[989]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[990]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[991]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[992]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[993]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[994]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[995]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[996]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[997]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_14_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[998]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[999]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1000]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1001]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1002]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1003]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1004]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1005]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1006]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1007]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1008]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1009]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1010]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1011]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1012]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyMaximumExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1013]);
}

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_14_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1014]);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMaximumExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_14_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1015]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1016]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1017]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1018]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1019]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1020]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1021]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1022]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1023]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1024]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1025]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1026]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1027]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1028]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1029]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1030]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1031]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1032]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1033]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1034]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1035]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1036]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1037]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1038]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1039]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1040]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1041]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1042]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1043]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1044]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1045]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1046]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1047]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1048]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1049]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1050]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1051]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_15_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1052]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1053]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1054]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1055]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1056]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1057]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1058]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1059]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1060]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1061]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1062]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1063]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1064]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1065]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1066]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1067]);
}

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_15_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1068]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1069]);
}

(
(
a2 = ',' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1070]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1071]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1072]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1073]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1074]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1075]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1076]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1077]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1078]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1079]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1080]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1081]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1082]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1083]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1084]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyIfPossibleExpression(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1085]);
}

(
a3_0 = parse_eu_hyvar_feature_expression_HyExpression{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_1, a3_0, true);
copyLocalizationInfos(a3_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1086]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1087]);
}

)

)*{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1088]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1089]);
}

a4 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYEXPRESSION_15_0_0_3, null, true);
copyLocalizationInfos((CommonToken)a4, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1090]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1091]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1092]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1093]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1094]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1095]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1096]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1097]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1098]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1099]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1100]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1101]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1102]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1103]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1104]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1105]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1106]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1107]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1108]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1109]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1110]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1111]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1112]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1113]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1114]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1115]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1116]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1117]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1118]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1119]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1120]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1121]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1122]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1123]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1124]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1125]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1126]);
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
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyNumberValue();
startIncompleteElement(element);
}
if (a0 != null) {
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_0_0_0_0, resolved, true);
copyLocalizationInfos((CommonToken) a0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1127]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1128]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1129]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1130]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1131]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1132]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1133]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1134]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1135]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1136]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1137]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1138]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1139]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1140]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1141]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1142]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1143]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1144]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1145]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1146]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1147]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1148]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1149]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1150]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1151]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1152]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1153]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1154]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1155]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1156]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1157]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1158]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1159]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1160]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1161]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1162]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1163]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_1_0_0_0, true, true);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_1_0_0_0, false, true);
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
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1164]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1165]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1166]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1167]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1168]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1169]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1170]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1171]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1172]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1173]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1174]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1175]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1176]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1177]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1178]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1179]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1180]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1181]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1182]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1183]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1184]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1185]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1186]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1187]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1188]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1189]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1190]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1191]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1192]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1193]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1194]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1195]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1196]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1197]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1198]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1199]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1200]);
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
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1201]);
}

(
a1 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
if (a1 != null) {
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.dataValues.HyEnum proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnum>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_2_0_0_1, proxy, true);
copyLocalizationInfos((CommonToken) a1, element);
copyLocalizationInfos((CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1202]);
}

a2 = '.' {
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1203]);
}

(
a3 = IDENTIFIER_TOKEN
{
if (terminateParsing) {
throw new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTerminateParsingException();
}
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
if (a3 != null) {
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER_TOKEN");
tokenResolver.setOptions(getOptions());
eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
}
String resolved = (String) resolvedObject;
eu.hyvar.dataValues.HyEnumLiteral proxy = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
collectHiddenTokens(element);
registerContextDependentProxy(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsContextDependentURIFragmentFactory<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getHyEnumValueEnumLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.dataValues.HyDataValuesPackage.HY_ENUM_VALUE__ENUM_LITERAL), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsGrammarInformationProvider.HYDATAVALUE_2_0_0_3, proxy, true);
copyLocalizationInfos((CommonToken) a3, element);
copyLocalizationInfos((CommonToken) a3, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1204]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1205]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1206]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1207]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1208]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1209]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1210]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1211]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1212]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1213]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1214]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1215]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1216]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1217]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1218]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1219]);
addExpectedElement(eu.hyvar.feature.constraint.HyConstraintPackage.eINSTANCE.getHyConstraintModel(), eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1220]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1221]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1222]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1223]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1224]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1225]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1226]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1227]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1228]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1229]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1230]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1231]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1232]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1233]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1234]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1235]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1236]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1237]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1238]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1239]);
addExpectedElement(null, eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsExpectationConstants.EXPECTATIONS[1240]);
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

