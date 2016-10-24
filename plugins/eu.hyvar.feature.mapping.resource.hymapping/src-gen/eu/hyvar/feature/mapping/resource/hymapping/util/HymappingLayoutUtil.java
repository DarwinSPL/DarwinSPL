/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * A utility class to inject/extract layout information into/from a model.
 */
public class HymappingLayoutUtil {
	
	public final String LAYOUT_PACKAGE_NS_URI = "http://www.emftext.org/commons/layout";
	public final String LAYOUT_INFORMATION_ECLASS_NAME = "LayoutInformation";
	public final String ATTRIBUTE_LAYOUT_INFORMATION_ECLASS_NAME = "AttributeLayoutInformation";
	public final String REFERENCE_LAYOUT_INFORMATION_ECLASS_NAME = "ReferenceLayoutInformation";
	public final String KEYWORD_LAYOUT_INFORMATION_ECLASS_NAME = "KeywordLayoutInformation";
	
	public final String SYNTAX_ELEMENT_ID_EATTRIBUTE_NAME = "syntaxElementID";
	public final String OBJECT_EATTRIBUTE_NAME = "object";
	public final String VISIBLE_TOKEN_TEXT_EATTRIBUTE_NAME = "visibleTokenText";
	public final String HIDDEN_TOKEN_TEXT_EATTRIBUTE_NAME = "hiddenTokenText";
	public final String START_OFFSET_EATTRIBUTE_NAME = "startOffset";
	
	public void transferAllLayoutInformationToModel(EObject root) {
		transferLayoutInformationToModel(root);
		for (Iterator<EObject> i = root.eAllContents(); i.hasNext(); ) {
			transferLayoutInformationToModel(i.next());
		}
	}
	
	public void transferAllLayoutInformationFromModel(EObject root) {
		transferLayoutInformationFromModel(root);
		for (EObject next : new ArrayList<EObject>(root.eContents())) {
			transferAllLayoutInformationFromModel(next);
		}
	}
	
	public void transferLayoutInformationToModel(EObject element) {
		eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(element);
		layoutInformationAdapter.getLayoutInformations();
		for (Iterator<eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLayoutInformation> i = layoutInformationAdapter.getLayoutInformations().iterator(); i.hasNext(); ) {
			eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLayoutInformation layoutInformation = i.next();
			EReference layoutReference = findLayoutReference(element.eClass());
			if (layoutReference != null) {
				EObject layoutInformationModelElement = createLayoutInformationModelElement(layoutInformation, layoutReference.getEType().getEPackage());
				if (layoutInformationModelElement != null) {
					@SuppressWarnings("unchecked")
					List<EObject> list = (List<EObject>) element.eGet(layoutReference);
					list.add(layoutInformationModelElement);
					i.remove();
				}
			}
		}
	}
	
	public void transferLayoutInformationFromModel(EObject element) {
		EReference layoutReference = findLayoutReference(element.eClass());
		if (layoutReference != null) {
			eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(element);
			@SuppressWarnings("unchecked")
			List<EObject> list = (List<EObject>) element.eGet(layoutReference);
			for (Iterator<EObject> i = list.iterator(); i.hasNext(); ) {
				EObject layoutModelElement = i.next();
				eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLayoutInformation layoutInformation = createLayoutInformation(layoutModelElement);
				if (layoutInformation != null) {
					layoutInformationAdapter.getLayoutInformations().add(layoutInformation);
					i.remove();
				}
			}
		}
	}
	
	public EObject createLayoutInformationModelElement(eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLayoutInformation layoutInformation, EPackage layoutPackage) {
		EFactory factory = layoutPackage.getEFactoryInstance();
		Object object = layoutInformation.getObject(null, false);
		eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement syntaxElement = layoutInformation.getSyntaxElement();
		EClass layoutInformationEClass = null;
		EObject layoutInformationModelElement = null;
		if (object == null) {
			// keyword
			layoutInformationEClass = (EClass) layoutPackage.getEClassifier(KEYWORD_LAYOUT_INFORMATION_ECLASS_NAME);
			layoutInformationModelElement = factory.create(layoutInformationEClass);
		} else if (object instanceof EObject) {
			// reference
			layoutInformationEClass = (EClass) layoutPackage.getEClassifier(REFERENCE_LAYOUT_INFORMATION_ECLASS_NAME);
			layoutInformationModelElement = factory.create(layoutInformationEClass);
			layoutInformationModelElement.eSet(layoutInformationEClass.getEStructuralFeature(OBJECT_EATTRIBUTE_NAME), object);
		} else {
			// attribute
			layoutInformationEClass = (EClass) layoutPackage.getEClassifier(ATTRIBUTE_LAYOUT_INFORMATION_ECLASS_NAME);
			layoutInformationModelElement = factory.create(layoutInformationEClass);
		}
		layoutInformationModelElement.eSet(layoutInformationEClass.getEStructuralFeature(START_OFFSET_EATTRIBUTE_NAME), layoutInformation.getStartOffset());
		layoutInformationModelElement.eSet(layoutInformationEClass.getEStructuralFeature(HIDDEN_TOKEN_TEXT_EATTRIBUTE_NAME), layoutInformation.getHiddenTokenText());
		layoutInformationModelElement.eSet(layoutInformationEClass.getEStructuralFeature(VISIBLE_TOKEN_TEXT_EATTRIBUTE_NAME), layoutInformation.getVisibleTokenText());
		layoutInformationModelElement.eSet(layoutInformationEClass.getEStructuralFeature(SYNTAX_ELEMENT_ID_EATTRIBUTE_NAME), eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.getSyntaxElementID(syntaxElement));
		return layoutInformationModelElement;
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLayoutInformation createLayoutInformation(EObject layoutInformationModelElement) {
		Object object = null;
		EStructuralFeature objectFeature = layoutInformationModelElement.eClass().getEStructuralFeature(OBJECT_EATTRIBUTE_NAME);
		int startOffset = (Integer) layoutInformationModelElement.eGet(layoutInformationModelElement.eClass().getEStructuralFeature(START_OFFSET_EATTRIBUTE_NAME));
		String hiddenTokenText = (String) layoutInformationModelElement.eGet(layoutInformationModelElement.eClass().getEStructuralFeature(HIDDEN_TOKEN_TEXT_EATTRIBUTE_NAME));
		String visibleTokenText = (String) layoutInformationModelElement.eGet(layoutInformationModelElement.eClass().getEStructuralFeature(VISIBLE_TOKEN_TEXT_EATTRIBUTE_NAME));
		eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingSyntaxElement syntaxElement = eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingGrammarInformationProvider.getSyntaxElementByID((String) layoutInformationModelElement.eGet(layoutInformationModelElement.eClass().getEStructuralFeature(SYNTAX_ELEMENT_ID_EATTRIBUTE_NAME)));
		if (objectFeature != null) {
			object = layoutInformationModelElement.eGet(objectFeature);
		} else if (syntaxElement instanceof eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder) {
			eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder placeholder = (eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingPlaceholder) syntaxElement;
			eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver tokenResolver = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTokenResolverFactory().createTokenResolver(placeholder.getTokenName());
			eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTokenResolveResult();
			tokenResolver.resolve(visibleTokenText, placeholder.getFeature(), result);
			object = result.getResolvedToken();
		}
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLayoutInformation(syntaxElement, object, startOffset, hiddenTokenText, visibleTokenText);
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLayoutInformationAdapter getLayoutInformationAdapter(EObject element) {
		for (Adapter adapter : element.eAdapters()) {
			if (adapter instanceof eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLayoutInformationAdapter) {
				return (eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLayoutInformationAdapter) adapter;
			}
		}
		eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLayoutInformationAdapter newAdapter = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLayoutInformationAdapter();
		element.eAdapters().add(newAdapter);
		return newAdapter;
	}
	
	public void removeLayoutInformationAdapter(EObject element) {
		eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLayoutInformationAdapter existingAdapter = getLayoutInformationAdapter(element);
		if (existingAdapter != null) {
			element.eAdapters().remove(existingAdapter);
		}
	}
	
	public void removeLayoutInformationAdapters(Resource resource) {
		Iterator<EObject> it = resource.getAllContents();
		while (it.hasNext()) {
			EObject next = it.next();
			removeLayoutInformationAdapter(next);
		}
	}
	
	public EReference findLayoutReference(EClass eClass) {
		for (EReference ref : eClass.getEAllReferences()) {
			EClass type = ref.getEReferenceType();
			if (LAYOUT_PACKAGE_NS_URI.equals(type.getEPackage().getNsURI()) && ref.isMany() && LAYOUT_INFORMATION_ECLASS_NAME.equals(type.getName())) {
				return ref;
			}
		}
		return null;
	}
	
}
