/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.ui;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * A CodeCompletionHelper can be used to derive completion proposals for partial
 * documents. It runs the parser generated by EMFText in a special mode (i.e., the
 * rememberExpectedElements mode). Based on the elements that are expected by the
 * parser for different regions in the document, valid proposals are computed.
 */
public class DwprofileCodeCompletionHelper {
	
	private de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileAttributeValueProvider attributeValueProvider = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileAttributeValueProvider();
	
	private de.darwinspl.preferences.resource.dwprofile.IDwprofileMetaInformation metaInformation = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileMetaInformation();
	
	/**
	 * <p>
	 * Computes a set of proposals for the given document assuming the cursor is at
	 * 'cursorOffset'. The proposals are derived using the meta information, i.e., the
	 * generated language plug-in.
	 * </p>
	 * 
	 * @param originalResource the resource to compute completions for
	 * @param content the documents content
	 * @param cursorOffset the current offset of the cursor
	 * 
	 * @return an array of completion proposals
	 */
	public de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal[] computeCompletionProposals(de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource originalResource, String content, int cursorOffset) {
		ResourceSet resourceSet = new ResourceSetImpl();
		// the shadow resource needs the same URI because reference resolvers may use the
		// URI to resolve external references
		de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource = (de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource) resourceSet.createResource(originalResource.getURI());
		ByteArrayInputStream inputStream = new ByteArrayInputStream(content.getBytes());
		de.darwinspl.preferences.resource.dwprofile.IDwprofileMetaInformation metaInformation = resource.getMetaInformation();
		de.darwinspl.preferences.resource.dwprofile.IDwprofileTextParser parser = metaInformation.createParser(inputStream, null);
		de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal[] expectedElements = parseToExpectedElements(parser, resource, cursorOffset);
		if (expectedElements == null) {
			return new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal[0];
		}
		if (expectedElements.length == 0) {
			return new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal[0];
		}
		List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> expectedAfterCursor = Arrays.asList(getElementsExpectedAt(expectedElements, cursorOffset));
		List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> expectedBeforeCursor = Arrays.asList(getElementsExpectedAt(expectedElements, cursorOffset - 1));
		setPrefixes(expectedAfterCursor, content, cursorOffset);
		setPrefixes(expectedBeforeCursor, content, cursorOffset);
		
		// First, we derive all possible proposals from the set of elements that are
		// expected at the cursor position.
		Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> allProposals = new LinkedHashSet<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal>();
		Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> rightProposals = deriveProposals(expectedAfterCursor, content, resource, cursorOffset);
		Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> leftProposals = deriveProposals(expectedBeforeCursor, content, resource, cursorOffset - 1);
		removeKeywordsEndingBeforeIndex(leftProposals, cursorOffset);
		
		// Second, the set of left proposals (i.e., the ones before the cursor) is checked
		// for emptiness. If the set is empty, the right proposals (i.e., the ones after
		// the cursor) are also considered. If the set is not empty, the right proposal
		// are discarded, because it does not make sense to propose them until the element
		// before the cursor was completed.
		allProposals.addAll(leftProposals);
		// Count the proposals before the cursor that match the prefix
		int leftMatchingProposals = 0;
		for (de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal leftProposal : leftProposals) {
			if (leftProposal.isMatchesPrefix()) {
				leftMatchingProposals++;
			}
		}
		if (leftMatchingProposals == 0) {
			allProposals.addAll(rightProposals);
		}
		
		// Third, the proposals are sorted according to their relevance. Proposals that
		// matched the prefix are preferred over ones that did not. Finally, proposals are
		// sorted alphabetically.
		final List<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> sortedProposals = new ArrayList<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal>(allProposals);
		Collections.sort(sortedProposals);
		EObject root = null;
		if (!resource.getContents().isEmpty()) {
			root = resource.getContents().get(0);
		}
		for (de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal proposal : sortedProposals) {
			proposal.setRoot(root);
		}
		
		return sortedProposals.toArray(new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal[sortedProposals.size()]);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal[] parseToExpectedElements(de.darwinspl.preferences.resource.dwprofile.IDwprofileTextParser parser, de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource, int cursorOffset) {
		final List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> expectedElements = parser.parseToExpectedElements(null, resource, cursorOffset);
		if (expectedElements == null) {
			return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal[0];
		}
		removeDuplicateEntries(expectedElements);
		removeInvalidEntriesAtEnd(expectedElements);
		return expectedElements.toArray(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal[expectedElements.size()]);
	}
	
	/**
	 * Removes all expected elements that refer to the same terminal and that start at
	 * the same position.
	 */
	protected void removeDuplicateEntries(List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> expectedElements) {
		int size = expectedElements.size();
		// We split the list of expected elements into buckets where each bucket contains
		// the elements that start at the same position.
		Map<Integer, List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal>> map = new LinkedHashMap<Integer, List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal>>();
		for (int i = 0; i < size; i++) {
			de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal elementAtIndex = expectedElements.get(i);
			int start1 = elementAtIndex.getStartExcludingHiddenTokens();
			List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> list = map.get(start1);
			if (list == null) {
				list = new ArrayList<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal>();
				map.put(start1, list);
			}
			list.add(elementAtIndex);
		}
		
		// Then, we remove all duplicate elements from each bucket individually.
		for (int position : map.keySet()) {
			List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> list = map.get(position);
			removeDuplicateEntriesFromBucket(list);
		}
		
		// After removing all duplicates, we merge the buckets.
		expectedElements.clear();
		for (int position : map.keySet()) {
			List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> list = map.get(position);
			expectedElements.addAll(list);
		}
	}
	
	/**
	 * Removes all expected elements that refer to the same terminal. Attention: This
	 * method assumes that the given list of expected terminals contains only elements
	 * that start at the same position.
	 */
	protected void removeDuplicateEntriesFromBucket(List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> expectedElements) {
		int size = expectedElements.size();
		for (int i = 0; i < size - 1; i++) {
			de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal elementAtIndex = expectedElements.get(i);
			de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement terminal = elementAtIndex.getTerminal();
			for (int j = i + 1; j < size;) {
				de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal elementAtNext = expectedElements.get(j);
				if (terminal.equals(elementAtNext.getTerminal())) {
					expectedElements.remove(j);
					size--;
				} else {
					j++;
				}
			}
		}
	}
	
	protected void removeInvalidEntriesAtEnd(List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> expectedElements) {
		for (int i = 0; i < expectedElements.size() - 1;) {
			de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal elementAtIndex = expectedElements.get(i);
			de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal elementAtNext = expectedElements.get(i + 1);
			
			// If the two expected elements have a different parent in the syntax definition,
			// we must not discard the second element, because it probably stems from a parent
			// rule.
			de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement symtaxElementOfThis = elementAtIndex.getTerminal().getSymtaxElement();
			de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileSyntaxElement symtaxElementOfNext = elementAtNext.getTerminal().getSymtaxElement();
			boolean differentParent = symtaxElementOfNext.getParent() != symtaxElementOfThis.getParent();
			
			boolean sameStartExcludingHiddenTokens = elementAtIndex.getStartExcludingHiddenTokens() == elementAtNext.getStartExcludingHiddenTokens();
			boolean differentFollowSet = elementAtIndex.getFollowSetID() != elementAtNext.getFollowSetID();
			if (sameStartExcludingHiddenTokens && differentFollowSet && !differentParent) {
				expectedElements.remove(i + 1);
			} else {
				i++;
			}
		}
	}
	
	/**
	 * Removes all proposals for keywords that end before the given index.
	 */
	protected void removeKeywordsEndingBeforeIndex(Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> proposals, int index) {
		List<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> toRemove = new ArrayList<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal>();
		for (de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal proposal : proposals) {
			de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedTerminal = proposal.getExpectedTerminal();
			de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement terminal = expectedTerminal.getTerminal();
			if (terminal instanceof de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedCsString) {
				de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedCsString csString = (de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedCsString) terminal;
				int startExcludingHiddenTokens = expectedTerminal.getStartExcludingHiddenTokens();
				if (startExcludingHiddenTokens + csString.getValue().length() - 1 < index) {
					toRemove.add(proposal);
				}
			}
		}
		proposals.removeAll(toRemove);
	}
	
	protected String findPrefix(List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> expectedElements, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedAtCursor, String content, int cursorOffset) {
		if (cursorOffset < 0) {
			return "";
		}
		
		int end = 0;
		for (de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedElement : expectedElements) {
			if (expectedElement == expectedAtCursor) {
				final int start = expectedElement.getStartExcludingHiddenTokens();
				if (start >= 0  && start < Integer.MAX_VALUE) {
					end = start;
				}
				break;
			}
		}
		end = Math.min(end, cursorOffset);
		final String prefix = content.substring(end, Math.min(content.length(), cursorOffset));
		return prefix;
	}
	
	protected Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> deriveProposals(List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> expectedElements, String content, de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource, int cursorOffset) {
		Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> resultSet = new LinkedHashSet<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal>();
		for (de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedElement : expectedElements) {
			resultSet.addAll(deriveProposals(expectedElement, content, resource, cursorOffset));
		}
		return resultSet;
	}
	
	protected Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> deriveProposals(final de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedTerminal, String content, de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource, int cursorOffset) {
		de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement expectedElement = (de.darwinspl.preferences.resource.dwprofile.IDwprofileExpectedElement) expectedTerminal.getTerminal();
		if (expectedElement instanceof de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedCsString) {
			de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedCsString csString = (de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedCsString) expectedElement;
			return handleKeyword(expectedTerminal, csString, expectedTerminal.getPrefix(), expectedTerminal.getContainer());
		} else if (expectedElement instanceof de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedBooleanTerminal) {
			de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedBooleanTerminal expectedBooleanTerminal = (de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedBooleanTerminal) expectedElement;
			return handleBooleanTerminal(expectedTerminal, expectedBooleanTerminal, expectedTerminal.getPrefix());
		} else if (expectedElement instanceof de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedEnumerationTerminal) {
			de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedEnumerationTerminal expectedEnumerationTerminal = (de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedEnumerationTerminal) expectedElement;
			return handleEnumerationTerminal(expectedTerminal, expectedEnumerationTerminal, expectedTerminal.getPrefix());
		} else if (expectedElement instanceof de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedStructuralFeature) {
			final de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedStructuralFeature expectedFeature = (de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedStructuralFeature) expectedElement;
			final EStructuralFeature feature = expectedFeature.getFeature();
			final EClassifier featureType = feature.getEType();
			final EObject container = findCorrectContainer(expectedTerminal);
			
			// Here it gets really crazy. We need to modify the model in a way that reflects
			// the state the model would be in, if the expected terminal were present. After
			// computing the corresponding completion proposals, the original state of the
			// model is restored. This procedure is required, because different models can be
			// required for different completion situations. This can be particularly observed
			// when the user has not yet typed a character that starts an element to be
			// completed.
			final Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> proposals = new ArrayList<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal>();
			expectedTerminal.materialize(new Runnable() {
				
				public void run() {
					if (feature instanceof EReference) {
						EReference reference = (EReference) feature;
						if (featureType instanceof EClass) {
							if (reference.isContainment()) {
								// the FOLLOW set should contain only non-containment references
								assert false;
							} else {
								proposals.addAll(handleNCReference(expectedTerminal, container, reference, expectedTerminal.getPrefix(), expectedFeature.getTokenName()));
							}
						}
					} else if (feature instanceof EAttribute) {
						EAttribute attribute = (EAttribute) feature;
						if (featureType instanceof EEnum) {
							EEnum enumType = (EEnum) featureType;
							proposals.addAll(handleEnumAttribute(expectedTerminal, expectedFeature, enumType, expectedTerminal.getPrefix(), container));
						} else {
							// handle EAttributes (derive default value depending on the type of the
							// attribute, figure out token resolver, and call deResolve())
							proposals.addAll(handleAttribute(expectedTerminal, expectedFeature, container, attribute, expectedTerminal.getPrefix()));
						}
					} else {
						// there should be no other subclass of EStructuralFeature
						assert false;
					}
				}
			});
			// Return the proposals that were computed in the closure call.
			return proposals;
		} else {
			// there should be no other class implementing IExpectedElement
			assert false;
		}
		return Collections.emptyList();
	}
	
	protected Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> handleEnumAttribute(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedTerminal, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedStructuralFeature expectedFeature, EEnum enumType, String prefix, EObject container) {
		Collection<EEnumLiteral> enumLiterals = enumType.getELiterals();
		Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> result = new LinkedHashSet<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal>();
		for (EEnumLiteral literal : enumLiterals) {
			String unResolvedLiteral = literal.getLiteral();
			// use token resolver to get de-resolved value of the literal
			de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolverFactory tokenResolverFactory = metaInformation.getTokenResolverFactory();
			de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(expectedFeature.getTokenName());
			String resolvedLiteral = tokenResolver.deResolve(unResolvedLiteral, expectedFeature.getFeature(), container);
			boolean matchesPrefix = matches(resolvedLiteral, prefix);
			result.add(new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal(expectedTerminal, resolvedLiteral, prefix, matchesPrefix, expectedFeature.getFeature(), container));
		}
		return result;
	}
	
	protected Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> handleNCReference(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedTerminal, EObject container, EReference reference, String prefix, String tokenName) {
		// proposals for non-containment references are derived by calling the reference
		// resolver switch in fuzzy mode.
		de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolverSwitch resolverSwitch = metaInformation.getReferenceResolverSwitch();
		de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolverFactory tokenResolverFactory = metaInformation.getTokenResolverFactory();
		de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolveResult<EObject> result = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileReferenceResolveResult<EObject>(true);
		resolverSwitch.resolveFuzzy(prefix, container, reference, 0, result);
		Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceMapping<EObject>> mappings = result.getMappings();
		if (mappings != null) {
			Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> resultSet = new LinkedHashSet<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal>();
			for (de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceMapping<EObject> mapping : mappings) {
				Image image = null;
				if (mapping instanceof de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileElementMapping<?>) {
					de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileElementMapping<?> elementMapping = (de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileElementMapping<?>) mapping;
					Object target = elementMapping.getTargetElement();
					// de-resolve reference to obtain correct identifier
					de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
					final String identifier = tokenResolver.deResolve(elementMapping.getIdentifier(), reference, container);
					if (target instanceof EObject) {
						image = getImage((EObject) target);
					}
					boolean matchesPrefix = matches(identifier, prefix);
					de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal proposal = new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal(expectedTerminal, identifier, prefix, matchesPrefix, reference, container, image);
					proposal.setReferenceTarget(target);
					resultSet.add(proposal);
				}
			}
			return resultSet;
		}
		return Collections.emptyList();
	}
	
	protected Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> handleAttribute(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedTerminal, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedStructuralFeature expectedFeature, EObject container, EAttribute attribute, String prefix) {
		Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> resultSet = new LinkedHashSet<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal>();
		Object[] defaultValues = attributeValueProvider.getDefaultValues(attribute);
		if (defaultValues != null) {
			for (Object defaultValue : defaultValues) {
				if (defaultValue != null) {
					de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolverFactory tokenResolverFactory = metaInformation.getTokenResolverFactory();
					String tokenName = expectedFeature.getTokenName();
					if (tokenName != null) {
						de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
						if (tokenResolver != null) {
							String defaultValueAsString = tokenResolver.deResolve(defaultValue, attribute, container);
							boolean matchesPrefix = matches(defaultValueAsString, prefix);
							resultSet.add(new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal(expectedTerminal, defaultValueAsString, prefix, matchesPrefix, expectedFeature.getFeature(), container));
						}
					}
				}
			}
		}
		return resultSet;
	}
	
	/**
	 * Creates a set of completion proposals from the given keyword.
	 */
	protected Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> handleKeyword(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedTerminal, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedCsString csString, String prefix, EObject container) {
		String proposal = csString.getValue();
		boolean matchesPrefix = matches(proposal, prefix);
		return Collections.singleton(new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal(expectedTerminal, proposal, prefix, matchesPrefix, null, container));
	}
	
	/**
	 * Creates a set of (two) completion proposals from the given boolean terminal.
	 */
	protected Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> handleBooleanTerminal(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedTerminal, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedBooleanTerminal expectedBooleanTerminal, String prefix) {
		Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> result = new LinkedHashSet<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal>(2);
		de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileBooleanTerminal booleanTerminal = expectedBooleanTerminal.getBooleanTerminal();
		result.addAll(handleLiteral(expectedTerminal, booleanTerminal.getAttribute(), prefix, booleanTerminal.getTrueLiteral()));
		result.addAll(handleLiteral(expectedTerminal, booleanTerminal.getAttribute(), prefix, booleanTerminal.getFalseLiteral()));
		return result;
	}
	
	/**
	 * Creates a set of completion proposals from the given enumeration terminal. For
	 * each enumeration literal one proposal is created.
	 */
	protected Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> handleEnumerationTerminal(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedTerminal, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedEnumerationTerminal expectedEnumerationTerminal, String prefix) {
		Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> result = new LinkedHashSet<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal>(2);
		de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileEnumerationTerminal enumerationTerminal = expectedEnumerationTerminal.getEnumerationTerminal();
		Map<String, String> literalMapping = enumerationTerminal.getLiteralMapping();
		for (String literalName : literalMapping.keySet()) {
			result.addAll(handleLiteral(expectedTerminal, enumerationTerminal.getAttribute(), prefix, literalMapping.get(literalName)));
		}
		return result;
	}
	
	protected Collection<de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal> handleLiteral(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedTerminal, EAttribute attribute, String prefix, String literal) {
		if ("".equals(literal)) {
			return Collections.emptySet();
		}
		boolean matchesPrefix = matches(literal, prefix);
		return Collections.singleton(new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileCompletionProposal(expectedTerminal, literal, prefix, matchesPrefix, null, null));
	}
	
	/**
	 * Calculates the prefix for each given expected element. The prefix depends on
	 * the current document content, the cursor position, and the position where the
	 * element is expected.
	 */
	protected void setPrefixes(List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> expectedElements, String content, int cursorOffset) {
		if (cursorOffset < 0) {
			return;
		}
		for (de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedElement : expectedElements) {
			String prefix = findPrefix(expectedElements, expectedElement, content, cursorOffset);
			expectedElement.setPrefix(prefix);
		}
	}
	
	public de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal[] getElementsExpectedAt(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal[] allExpectedElements, int cursorOffset) {
		List<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal> expectedAtCursor = new ArrayList<de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal>();
		for (int i = 0; i < allExpectedElements.length; i++) {
			de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedElement = allExpectedElements[i];
			int startIncludingHidden = expectedElement.getStartIncludingHiddenTokens();
			int end = getEnd(allExpectedElements, i);
			if (cursorOffset >= startIncludingHidden && cursorOffset <= end) {
				expectedAtCursor.add(expectedElement);
			}
		}
		return expectedAtCursor.toArray(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal[expectedAtCursor.size()]);
	}
	
	/**
	 * Calculates the end index of the expected element at allExpectedElements[index].
	 * To determine the end, the subsequent expected elements from the array of all
	 * expected elements are used. An element is considered to end one character
	 * before the next elements starts.
	 */
	protected int getEnd(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal[] allExpectedElements, int indexInList) {
		de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal elementAtIndex = allExpectedElements[indexInList];
		int startIncludingHidden = elementAtIndex.getStartIncludingHiddenTokens();
		int startExcludingHidden = elementAtIndex.getStartExcludingHiddenTokens();
		for (int i = indexInList + 1; i < allExpectedElements.length; i++) {
			de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal elementAtI = allExpectedElements[i];
			int startIncludingHiddenForI = elementAtI.getStartIncludingHiddenTokens();
			int startExcludingHiddenForI = elementAtI.getStartExcludingHiddenTokens();
			if (startIncludingHidden != startIncludingHiddenForI || startExcludingHidden != startExcludingHiddenForI) {
				return startIncludingHiddenForI - 1;
			}
		}
		return Integer.MAX_VALUE;
	}
	
	/**
	 * Checks whether the given proposed string matches the prefix. The two strings
	 * are compared ignoring the case. The prefix is also considered to match if is a
	 * camel case representation of the proposal.
	 */
	protected boolean matches(String proposal, String prefix) {
		if (proposal == null || prefix == null) {
			return false;
		}
		return (proposal.toLowerCase().startsWith(prefix.toLowerCase()) || de.darwinspl.preferences.resource.dwprofile.util.DwprofileStringUtil.matchCamelCase(prefix, proposal) != null) && !proposal.equals(prefix);
	}
	
	protected Image getImage(EObject element) {
		if (!Platform.isRunning()) {
			return null;
		}
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		return labelProvider.getImage(element);
	}
	
	protected EObject findCorrectContainer(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileExpectedTerminal expectedTerminal) {
		EObject container = expectedTerminal.getContainer();
		EClass ruleMetaclass = expectedTerminal.getTerminal().getRuleMetaclass();
		if (ruleMetaclass.isInstance(container)) {
			// container is correct for expected terminal
			return container;
		}
		// the container is wrong
		EObject parent = null;
		EObject previousParent = null;
		EObject correctContainer = null;
		EObject hookableParent = null;
		de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileContainmentTrace containmentTrace = expectedTerminal.getContainmentTrace();
		EClass startClass = containmentTrace.getStartClass();
		de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature currentLink = null;
		de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature previousLink = null;
		de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature[] containedFeatures = containmentTrace.getPath();
		for (int i = 0; i < containedFeatures.length; i++) {
			currentLink = containedFeatures[i];
			if (i > 0) {
				previousLink = containedFeatures[i - 1];
			}
			EClass containerClass = currentLink.getContainerClass();
			hookableParent = findHookParent(container, startClass, currentLink, parent);
			if (hookableParent != null) {
				// we found the correct parent
				break;
			} else {
				previousParent = parent;
				parent = containerClass.getEPackage().getEFactoryInstance().create(containerClass);
				if (parent != null) {
					if (previousParent == null) {
						// replace container for expectedTerminal with correctContainer
						correctContainer = parent;
					} else {
						// This assignment is only performed to get rid of a warning about a potential
						// null pointer access. Variable 'previousLink' cannot be null here, because it is
						// initialized for all loop iterations where 'i' is greather than 0 and for the
						// case where 'i' equals zero, this path is never executed, because
						// 'previousParent' is null in this case.
						de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature link = previousLink;
						de.darwinspl.preferences.resource.dwprofile.util.DwprofileEObjectUtil.setFeature(parent, link.getFeature(), previousParent, false);
					}
				}
			}
		}
		
		if (correctContainer == null) {
			correctContainer = container;
		}
		
		if (currentLink == null) {
			return correctContainer;
		}
		
		hookableParent = findHookParent(container, startClass, currentLink, parent);
		
		final EObject finalHookableParent = hookableParent;
		final EStructuralFeature finalFeature = currentLink.getFeature();
		final EObject finalParent = parent;
		if (parent != null && hookableParent != null) {
			expectedTerminal.setAttachmentCode(new Runnable() {
				
				public void run() {
					de.darwinspl.preferences.resource.dwprofile.util.DwprofileEObjectUtil.setFeature(finalHookableParent, finalFeature, finalParent, false);
				}
			});
		}
		return correctContainer;
	}
	
	/**
	 * Walks up the containment hierarchy to find an EObject that is able to hold
	 * (contain) the given object.
	 */
	protected EObject findHookParent(EObject container, EClass startClass, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature currentLink, EObject object) {
		EClass containerClass = currentLink.getContainerClass();
		while (container != null) {
			if (containerClass.isInstance(object)) {
				if (startClass.equals(container.eClass())) {
					return container;
				}
			}
			container = container.eContainer();
		}
		return null;
	}
	
}