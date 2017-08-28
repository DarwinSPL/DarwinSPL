package de.darwinspl.feature.graphical.editor.actions.feature;

import java.util.Date;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.HyFeature;
import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.editor.commands.feature.DwSetFeatureLinkCommand;
import eu.hyvar.mspl.manifest.HySPLImplementation;
import eu.hyvar.mspl.manifest.HySPLSignature;

public class DwSetFeatureLinkAction extends DwFeatureSelectionAction {

	public static final String ID = "SetFeatureLink";
	public static final String REQUEST = "SetFeatureLink"; 
	
	public DwSetFeatureLinkAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);
			
		setId(ID);
		setText("Set Link to Signature");
		request = new Request(REQUEST);
	}
	
	@Override
	protected Command createCommand(Object acceptedModel) {
		Date date = editor.getCurrentSelectedDate();
		HyFeature localFeature = getSelectedFeature().getWrappedModelElement();
		
		// TODO for Simone: Here you have to call the menu to select the link and fill all variables below
		
		// TODO get the HyFeature of the signature Feature
		HyFeature signatureFeature = null;
		// TODO get the implementation Manifest
		HySPLImplementation implementation = null;
		// TODO get the implementing signature
		HySPLSignature implementingSignature = null;
		
		
		DwSetFeatureLinkCommand command = new DwSetFeatureLinkCommand(implementation, implementingSignature, localFeature, signatureFeature, date);
		return command;
	}

}
