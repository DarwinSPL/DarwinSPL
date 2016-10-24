/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.ui;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.ui.IMarkerResolutionGenerator;

public class HyexpressionMarkerResolutionGenerator implements IMarkerResolutionGenerator {
	
	public IMarkerResolution[] getResolutions(IMarker marker) {
		try {
			if (!hasQuickFixes(marker)) {
				return new IMarkerResolution[] {};
			}
			IResource resource = marker.getResource();
			if (resource instanceof IFile) {
				// load model
				final IFile file = (IFile) resource;
				URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				ResourceSet rs = new ResourceSetImpl();
				rs.getLoadOptions().put(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionOptions.DISABLE_CREATING_MARKERS_FOR_PROBLEMS, "true");
				Resource emfResource = rs.getResource(uri, true);
				if (emfResource instanceof eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionResource) {
					eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionResource customResource = (eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionResource) emfResource;
					EcoreUtil.resolveAll(customResource);
					Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix> quickFixes = getQuickFixes(customResource, marker);
					List<IMarkerResolution2> resolutions = new ArrayList<IMarkerResolution2>();
					for (final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix quickFix : quickFixes) {
						resolutions.add(new IMarkerResolution2() {
							
							public void run(IMarker marker) {
								String newText = quickFix.apply(null);
								// set new text as content for resource
								try {
									file.setContents(new ByteArrayInputStream(newText.getBytes()), true, true, null);
								} catch (CoreException e) {
									eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionUIPlugin.logError("Exception while applying quick fix", e);
								}
							}
							
							public String getLabel() {
								return quickFix.getDisplayString();
							}
							
							public Image getImage() {
								return new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionUIMetaInformation().getImageProvider().getImage(quickFix.getImageKey());
							}
							
							public String getDescription() {
								return null;
							}
							
						});
					}
					return resolutions.toArray(new IMarkerResolution[resolutions.size()]);
				}
			}
		} catch (Exception e) {
			eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionUIPlugin.logError("Exception while computing quick fix resolutions", e);
		}
		return new IMarkerResolution[] {};
	}
	
	public Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix> getQuickFixes(eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource resource, IMarker marker) {
		Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix> foundQuickFixes = new ArrayList<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix>();
		try {
			String quickFixContexts = getQuickFixContextString(marker);
			if (quickFixContexts != null) {
				String[] quickFixContextParts = quickFixContexts.split("\\|");
				for (String quickFixContext : quickFixContextParts) {
					eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionQuickFix quickFix = resource.getQuickFix(quickFixContext);
					if (quickFix != null) {
						foundQuickFixes.add(quickFix);
					}
				}
			}
		} catch (CoreException ce) {
			if (ce.getMessage().matches("Marker.*not found.")) {
				// ignore
				System.out.println("getQuickFixes() marker not found: " + ce.getMessage());
			} else {
				ce.printStackTrace();
			}
		}
		return foundQuickFixes;
	}
	
	private String getQuickFixContextString(IMarker marker) throws CoreException {
		Object quickFixValue = marker.getAttribute(IMarker.SOURCE_ID);
		if (quickFixValue != null && quickFixValue instanceof String) {
			return (String) quickFixValue;
		}
		return null;
	}
	private boolean hasQuickFixes(IMarker marker) throws CoreException {
		return getQuickFixContextString(marker) != null;
	}
}
