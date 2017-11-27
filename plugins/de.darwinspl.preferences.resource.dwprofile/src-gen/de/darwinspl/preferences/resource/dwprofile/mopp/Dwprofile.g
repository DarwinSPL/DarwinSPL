grammar Dwprofile;

options {
	superClass = DwprofileANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package de.darwinspl.preferences.resource.dwprofile.mopp;
	
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
}

@members{
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
	
}

start returns [ EObject element = null]
:
	{
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
	(
		c0 = parse_de_darwinspl_preferences_DwProfile{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_de_darwinspl_preferences_DwProfile returns [de.darwinspl.preferences.DwProfile element = null]
@init{
}
:
	(
		(
			a0_0 = parse_de_darwinspl_preferences_DwPreference			{
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
		)
		
	)*	{
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
	
;

parse_de_darwinspl_preferences_DwPreference returns [de.darwinspl.preferences.DwPreference element = null]
@init{
}
:
	(
		a0_0 = parse_eu_hyvar_feature_expression_HyExpression		{
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
	)
	{
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
	
	(
		(
			a1 = '[' {
				if (element == null) {
					element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[49]);
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[50]);
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[51]);
			}
			
			(
				(
					a2 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[52]);
				}
				
				a3 = '-' {
					if (element == null) {
						element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a3, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[53]);
				}
				
				(
					a4 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[54]);
				}
				
				
				|				(
					a5 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[55]);
				}
				
				a6 = '-' {
					if (element == null) {
						element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a6, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[56]);
				}
				
				a7 = 'eternity' {
					if (element == null) {
						element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[57]);
				}
				
				
				|				a8 = 'eternity' {
					if (element == null) {
						element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a8, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[58]);
				}
				
				a9 = '-' {
					if (element == null) {
						element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[59]);
				}
				
				(
					a10 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[60]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[61]);
			}
			
			a11 = ']' {
				if (element == null) {
					element = de.darwinspl.preferences.PreferencesFactory.eINSTANCE.createDwPreference();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.DWPROFILE_1_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a11, element);
			}
			{
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
			
		)
		
	)?	{
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
		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_27_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[94]);
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
				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
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
				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_27_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyRelativeVersionRestrictionOperator().getEEnumLiteral(eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator.GREATER_THAN_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_RELATIVE_VERSION_RESTRICTION__OPERATOR), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[95]);
	}
	
	(
		a8 = QUOTED_34_34		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[96]);
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
		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_27_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a9, element);
	}
	{
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
		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_28_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[134]);
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[135]);
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
				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_28_0_0_1, false, true);
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of boolean attribute
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__LOWER_INCLUDED), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[136]);
	}
	
	(
		a3 = QUOTED_34_34		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[137]);
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
		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_28_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[138]);
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[139]);
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
				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_28_0_0_4, false, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of boolean attribute
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(eu.hyvar.feature.expression.HyExpressionPackage.HY_VERSION_RANGE_RESTRICTION__UPPER_INCLUDED), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[140]);
	}
	
	(
		a7 = QUOTED_34_34		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[141]);
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
		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_28_0_0_6, null, true);
		copyLocalizationInfos((CommonToken)a8, element);
	}
	{
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
		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[179]);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[180]);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[181]);
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[182]);
	}
	
	(
		(
			(
				a3_0 = parse_eu_hyvar_dataValues_HyEnumLiteral				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[183]);
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[184]);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_3_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(eu.hyvar.dataValues.HyDataValuesPackage.eINSTANCE.getHyEnum(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[185]);
					}
					
					(
						a5_0 = parse_eu_hyvar_dataValues_HyEnumLiteral						{
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
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[186]);
						addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[187]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[188]);
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[189]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[190]);
	}
	
	a6 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[191]);
	}
	
	(
		(
			a7 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[192]);
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[193]);
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[194]);
			}
			
			(
				(
					a8 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[195]);
				}
				
				a9 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[196]);
				}
				
				(
					a10 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[197]);
				}
				
				
				|				(
					a11 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[198]);
				}
				
				a12 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[199]);
				}
				
				
				|				a13 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[200]);
				}
				
				a14 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a14, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[201]);
				}
				
				(
					a15 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[202]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[203]);
			}
			
			a16 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnum();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_3_0_0_5_0_0_2, null, true);
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
		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[204]);
	}
	
	(
		a1 = IDENTIFIER_TOKEN		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[205]);
	}
	
	a2 = ',' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[206]);
	}
	
	(
		a3 = INTEGER_LITERAL		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[207]);
	}
	
	a4 = ')' {
		if (element == null) {
			element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[208]);
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[209]);
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[210]);
	}
	
	(
		(
			a5 = '[' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[211]);
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[212]);
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[213]);
			}
			
			(
				(
					a6 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[214]);
				}
				
				a7 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_0_1, null, true);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[215]);
				}
				
				(
					a8 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[216]);
				}
				
				
				|				(
					a9 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[217]);
				}
				
				a10 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_1, null, true);
					copyLocalizationInfos((CommonToken)a10, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[218]);
				}
				
				a11 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_1_2, null, true);
					copyLocalizationInfos((CommonToken)a11, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[219]);
				}
				
				
				|				a12 = 'eternity' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_0, null, true);
					copyLocalizationInfos((CommonToken)a12, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[220]);
				}
				
				a13 = '-' {
					if (element == null) {
						element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_1_0_2_1, null, true);
					copyLocalizationInfos((CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[221]);
				}
				
				(
					a14 = DATE					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[222]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[223]);
			}
			
			a15 = ']' {
				if (element == null) {
					element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_4_0_0_5_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[224]);
				addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[225]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[226]);
		addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[227]);
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
			retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_0_0_0_1, null, true);
			copyLocalizationInfos((CommonToken)a0, element);
		}
		{
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
		
		rightArg = parseop_HyExpression_level_1		{
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
		{
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
		retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_1_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
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
	
	rightArg = parseop_HyExpression_level_4	{
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
	{
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
	retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_2_0_0_1, null, true);
	copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_5{
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
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_3_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_9{
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
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_16_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_12{
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
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_17_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_12{
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
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_18_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_12{
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
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_19_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_12{
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
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_25_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_12{
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
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_26_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_12{
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
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_20_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_13{
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
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_21_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_13{
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
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_22_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_14{
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
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_23_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_14{
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
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_24_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

rightArg = parseop_HyExpression_level_14{
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
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_4_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

arg = parseop_HyExpression_level_15{
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
|
a2 = '-' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNegationExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_5_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
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

arg = parseop_HyExpression_level_15{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_6_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
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
)
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[516]);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyNestedExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_6_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
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
)
{
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


|(
a1 = IDENTIFIER_TOKEN
{
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
)
{
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

)
{
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

(
(
(
a2_0 = parse_eu_hyvar_feature_expression_HyVersionRestriction{
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
)
{
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

)

)?{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_8_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[745]);
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[746]);
}

(
(
a1 = QUOTED_34_34
{
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
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[747]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[748]);
}


|(
a2 = IDENTIFIER_TOKEN
{
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
)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[749]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[750]);
}

)
{
// expected elements (follow set)
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[751]);
addExpectedElement(eu.hyvar.feature.expression.HyExpressionPackage.eINSTANCE.getHyConditionalFeatureReferenceExpression(), de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[752]);
}

(
a3_0 = parse_eu_hyvar_feature_expression_HyVersionRestriction{
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
)
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_9_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[790]);
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[791]);
}

(
(
a1 = QUOTED_34_34
{
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
)
{
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


|(
a2 = IDENTIFIER_TOKEN
{
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
)
{
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

)
{
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
)
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[903]);
}


|(
a1 = IDENTIFIER_TOKEN
{
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
)
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[904]);
}

)
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[905]);
}

a2 = '.' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyAttributeReferenceExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_10_0_0_1, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[906]);
}

(
a3 = IDENTIFIER_TOKEN
{
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
)
{
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

;

parse_eu_hyvar_feature_expression_HyValueExpression returns [eu.hyvar.feature.expression.HyValueExpression element = null]
@init{
}
:
(
a0_0 = parse_eu_hyvar_dataValues_HyValue{
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
)
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_12_0_0_0, true, true);
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_12_0_0_0, false, true);
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_13_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
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
)
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1034]);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMinimumExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_13_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_14_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
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
)
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1088]);
}

a2 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyMaximumExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_14_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_15_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
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

(
a1_0 = parse_eu_hyvar_feature_expression_HyExpression{
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
)
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1142]);
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1143]);
}

(
(
a2 = ',' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_15_0_0_2_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a2, element);
}
{
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

(
a3_0 = parse_eu_hyvar_feature_expression_HyExpression{
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
)
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1160]);
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1161]);
}

)

)*{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1162]);
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1163]);
}

a4 = ')' {
if (element == null) {
element = eu.hyvar.feature.expression.HyExpressionFactory.eINSTANCE.createHyIfPossibleExpression();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYEXPRESSION_15_0_0_3, null, true);
copyLocalizationInfos((CommonToken)a4, element);
}
{
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
)
{
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_1_0_0_0, true, true);
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_1_0_0_0, false, true);
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
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_2_0_0_0, null, true);
copyLocalizationInfos((CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1275]);
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1276]);
}

(
(
a1 = QUOTED_34_34
{
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
)
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1277]);
}


|(
a2 = IDENTIFIER_TOKEN
{
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
)
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1278]);
}

)
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1279]);
}

a3 = '.' {
if (element == null) {
element = eu.hyvar.dataValues.HyDataValuesFactory.eINSTANCE.createHyEnumValue();
startIncompleteElement(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileGrammarInformationProvider.HYDATAVALUE_2_0_0_2, null, true);
copyLocalizationInfos((CommonToken)a3, element);
}
{
// expected elements (follow set)
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1280]);
addExpectedElement(null, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectationConstants.EXPECTATIONS[1281]);
}

(
(
a4 = QUOTED_34_34
{
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
)
{
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


|(
a5 = IDENTIFIER_TOKEN
{
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
)
{
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

)
{
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

