/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.ui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IInformationControlExtension4;
import org.eclipse.jface.text.IInputChangedListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextHoverExtension;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.EditorsUI;
import org.osgi.framework.Bundle;

/**
 * A class to display the information of an element. Most of the code is taken
 * from <code>org.eclipse.jdt.internal.ui.text.java.hover.JavadocHover</code>.
 */
public class HymappingTextHover implements ITextHover, ITextHoverExtension, ITextHoverExtension2 {
	
	private static final String FONT = JFaceResources.DIALOG_FONT;
	
	private eu.hyvar.feature.mapping.resource.hymapping.IHymappingResourceProvider resourceProvider;
	private eu.hyvar.feature.mapping.resource.hymapping.IHymappingHoverTextProvider hoverTextProvider;
	/**
	 * The style sheet (css).
	 */
	private static String styleSheet;
	
	/**
	 * The hover control creator.
	 */
	private IInformationControlCreator hoverControlCreator;
	
	/**
	 * The presentation control creator.
	 */
	private IInformationControlCreator presenterControlCreator;
	
	/**
	 * A simple default implementation of a {@link ISelectionProvider}. It stores the
	 * selection and notifies all selection change listeners when the selection is set.
	 */
	public static class SimpleSelectionProvider implements ISelectionProvider {
		
		private final ListenerList selectionChangedListeners;
		private ISelection selection;
		
		public SimpleSelectionProvider() {
			selectionChangedListeners = new ListenerList();
		}
		
		public ISelection getSelection() {
			return selection;
		}
		
		public void setSelection(ISelection selection) {
			this.selection = selection;
			
			Object[] listeners = selectionChangedListeners.getListeners();
			for (int i = 0; i < listeners.length; i++) {
				((ISelectionChangedListener) listeners[i]).selectionChanged(new SelectionChangedEvent(this, selection));
			}
		}
		
		public void removeSelectionChangedListener(ISelectionChangedListener listener) {
			selectionChangedListeners.remove(listener);
		}
		
		public void addSelectionChangedListener(ISelectionChangedListener listener) {
			selectionChangedListeners.add(listener);
		}
		
	}
	
	/**
	 * This action will be activated if the button in the hover window is pushed to
	 * jump to the declaration.
	 */
	public static class OpenDeclarationAction extends Action {
		
		private final eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingBrowserInformationControl infoControl;
		
		/**
		 * <p>
		 * Creates the action to jump to the declaration.
		 * </p>
		 * 
		 * @param infoControl the info control holds the hover information and the target
		 * element
		 */
		public OpenDeclarationAction(eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingBrowserInformationControl infoControl) {
			this.infoControl = infoControl;
			setText("Open Declaration");
			ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
			setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_ETOOL_HOME_NAV));
		}
		
		/**
		 * Creates, sets, activates a hyperlink.
		 */
		public void run() {
			eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingDocBrowserInformationControlInput infoInput = (eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingDocBrowserInformationControlInput) infoControl.getInput();
			infoControl.notifyDelayedInputChange(null);
			infoControl.dispose();
			if (infoInput.getInputElement() instanceof EObject) {
				EObject decEO = (EObject) infoInput.getInputElement();
				if (decEO != null && decEO.eResource() != null) {
					eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingHyperlink hyperlink = new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingHyperlink(null, decEO, infoInput.getTokenText());
					hyperlink.open();
				}
			}
		}
	}
	
	/**
	 * Presenter control creator. Creates a hover control after focus.
	 */
	public static final class PresenterControlCreator extends AbstractReusableInformationControlCreator {
		
		public IInformationControl doCreateInformationControl(Shell parent) {
			if (eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingBrowserInformationControl.isAvailable(parent)) {
				ToolBarManager tbm = new ToolBarManager(SWT.FLAT);
				eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingBrowserInformationControl iControl = new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingBrowserInformationControl(parent, FONT, tbm);
				final OpenDeclarationAction openDeclarationAction = new OpenDeclarationAction(iControl);
				tbm.add(openDeclarationAction);
				final SimpleSelectionProvider selectionProvider = new SimpleSelectionProvider();
				
				IInputChangedListener inputChangeListener = new IInputChangedListener() {
					public void inputChanged(Object newInput) {
						if (newInput == null) {
							selectionProvider.setSelection(new StructuredSelection());
						} else if (newInput instanceof eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingDocBrowserInformationControlInput) {
							eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingDocBrowserInformationControlInput input = (eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingDocBrowserInformationControlInput) newInput;
							Object inputElement = input.getInputElement();
							selectionProvider.setSelection(new StructuredSelection(inputElement));
							// If there is an element of type EObject in the input element, the button to open
							// the declaration will be set enable
							boolean isEObjectInput = inputElement instanceof EObject;
							openDeclarationAction.setEnabled(isEObjectInput);
							if (isEObjectInput) {
								String simpleName = inputElement.getClass().getSimpleName();
								simpleName = simpleName.substring(0, simpleName.length() - 4);
								openDeclarationAction.setText("Open " + simpleName);
							} else							openDeclarationAction.setText("Open Declaration");
						}
					}
				};
				iControl.addInputChangeListener(inputChangeListener);
				
				tbm.update(true);
				return iControl;
			} else {
				return new DefaultInformationControl(parent, true);
			}
		}
	}
	
	/**
	 * Hover control creator. Creates a hover control before focus.
	 */
	public static final class HoverControlCreator extends AbstractReusableInformationControlCreator {
		
		/**
		 * The information presenter control creator.
		 */
		private final IInformationControlCreator fInformationPresenterControlCreator;
		
		/**
		 * 
		 * @param informationPresenterControlCreator control creator for enriched hover
		 */
		public HoverControlCreator(IInformationControlCreator informationPresenterControlCreator) {
			fInformationPresenterControlCreator = informationPresenterControlCreator;
		}
		
		public IInformationControl doCreateInformationControl(Shell parent) {
			String tooltipAffordanceString = EditorsUI.getTooltipAffordanceString();
			if (eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingBrowserInformationControl.isAvailable(parent)) {
				eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingBrowserInformationControl iControl = new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingBrowserInformationControl(parent, FONT, tooltipAffordanceString) {
					public IInformationControlCreator getInformationPresenterControlCreator() {
						return fInformationPresenterControlCreator;
					}
				};
				return iControl;
			} else {
				return new DefaultInformationControl(parent, tooltipAffordanceString);
			}
		}
		
		public boolean canReuse(IInformationControl control) {
			if (!super.canReuse(control)) {
				return false;
			}
			
			if (control instanceof IInformationControlExtension4) {
				String tooltipAffordanceString = EditorsUI.getTooltipAffordanceString();
				((IInformationControlExtension4) control).setStatusText(tooltipAffordanceString);
			}
			
			return true;
		}
	}
	
	/**
	 * Creates a new TextHover to collect the information about the hovered element.
	 */
	public HymappingTextHover(eu.hyvar.feature.mapping.resource.hymapping.IHymappingResourceProvider resourceProvider) {
		super();
		this.resourceProvider = resourceProvider;
		this.hoverTextProvider = new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingUIMetaInformation().getHoverTextProvider();
	}
	
	// The warning about overriding or implementing a deprecated API cannot be avoided
	// because the SourceViewerConfiguration class depends on ITextHover.
	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		Object hoverInfo = getHoverInfo2(textViewer, hoverRegion);
		if (hoverInfo == null) {
			return null;
		}
		return ((eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingDocBrowserInformationControlInput) hoverInfo).getHtml();
	}
	
	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		Point selection = textViewer.getSelectedRange();
		if (selection.x <= offset && offset < selection.x + selection.y) {
			return new Region(selection.x, selection.y);
		}
		return new Region(offset, 0);
	}
	
	public IInformationControlCreator getHoverControlCreator() {
		if (hoverControlCreator == null) {
			hoverControlCreator = new HoverControlCreator(getInformationPresenterControlCreator());
		}
		return hoverControlCreator;
	}
	
	public IInformationControlCreator getInformationPresenterControlCreator() {
		if (presenterControlCreator == null) {
			presenterControlCreator = new PresenterControlCreator();
		}
		return presenterControlCreator;
	}
	
	public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
		return hoverTextProvider == null ? null : internalGetHoverInfo(textViewer, hoverRegion);
	}
	
	private eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingDocBrowserInformationControlInput internalGetHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return null;
		}
		eu.hyvar.feature.mapping.resource.hymapping.IHymappingLocationMap locationMap = textResource.getLocationMap();
		List<EObject> elementsAtOffset = locationMap.getElementsAt(hoverRegion.getOffset());
		if (elementsAtOffset == null || elementsAtOffset.size() == 0) {
			return null;
		}
		return getHoverInfo(elementsAtOffset, textViewer, null);
	}
	
	/**
	 * <p>
	 * Computes the hover info.
	 * </p>
	 * 
	 * @param elements the resolved elements
	 * @param constantValue a constant value iff result contains exactly 1 constant
	 * field, or <code>null</code>
	 * @param previousInput the previous input, or <code>null</code>
	 * 
	 * @return the HTML hover info for the given element(s) or <code>null</code> if no
	 * information is available
	 */
	private eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingDocBrowserInformationControlInput getHoverInfo(List<EObject> elements, ITextViewer textViewer, eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingDocBrowserInformationControlInput previousInput) {
		StringBuffer buffer = new StringBuffer();
		EObject proxyObject = getFirstProxy(elements);
		EObject containerObject = getFirstNonProxy(elements);
		EObject declarationObject = null;
		// get the token text, which is hovered. It is needed to jump to the declaration.
		String tokenText = "";
		if (proxyObject != null) {
			eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource textResource = resourceProvider.getResource();
			eu.hyvar.feature.mapping.resource.hymapping.IHymappingLocationMap locationMap = textResource.getLocationMap();
			int offset = locationMap.getCharStart(proxyObject);
			int length = locationMap.getCharEnd(proxyObject) + 1 - offset;
			try {
				tokenText = textViewer.getDocument().get(offset, length);
			} catch (BadLocationException e) {
			}
			declarationObject = EcoreUtil.resolve(proxyObject, resourceProvider.getResource());
			if (declarationObject != null) {
				eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingHTMLPrinter.addParagraph(buffer, hoverTextProvider.getHoverText(containerObject, declarationObject));
			}
		} else {
			eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingHTMLPrinter.addParagraph(buffer, hoverTextProvider.getHoverText(elements.get(0)));
		}
		if (buffer.length() > 0) {
			eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingHTMLPrinter.insertPageProlog(buffer, 0, eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingTextHover.getStyleSheet());
			eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingHTMLPrinter.addPageEpilog(buffer);
			return new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingDocBrowserInformationControlInput(previousInput, declarationObject, resourceProvider.getResource(), buffer.toString(), tokenText);
		}
		return null;
	}
	
	/**
	 * <p>
	 * Sets the style sheet font.
	 * </p>
	 * 
	 * @return the hover style sheet
	 */
	private static String getStyleSheet() {
		if (styleSheet == null) {
			styleSheet = loadStyleSheet();
		}
		String css = styleSheet;
		// Sets background color for the hover text window
		css += "body {background-color:#FFFFE1;}\n";
		FontData fontData = JFaceResources.getFontRegistry().getFontData(FONT)[0];
		css = eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingHTMLPrinter.convertTopLevelFont(css, fontData);
		
		return css;
	}
	
	/**
	 * <p>
	 * Loads and returns the hover style sheet.
	 * </p>
	 * 
	 * @return the style sheet, or <code>null</code> if unable to load
	 */
	private static String loadStyleSheet() {
		Bundle bundle = Platform.getBundle(eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingUIPlugin.PLUGIN_ID);
		URL styleSheetURL = bundle.getEntry("/css/hover_style.css");
		if (styleSheetURL != null) {
			try {
				return eu.hyvar.feature.mapping.resource.hymapping.util.HymappingStreamUtil.getContent(styleSheetURL.openStream());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return "";
	}
	
	private static EObject getFirstProxy(List<EObject> elements) {
		return getFirstObject(elements, true);
	}
	
	private static EObject getFirstNonProxy(List<EObject> elements) {
		return getFirstObject(elements, false);
	}
	
	private static EObject getFirstObject(List<EObject> elements, boolean proxy) {
		for (EObject object : elements) {
			if (proxy == object.eIsProxy()) {
				return object;
			}
		}
		return null;
	}
	
}
