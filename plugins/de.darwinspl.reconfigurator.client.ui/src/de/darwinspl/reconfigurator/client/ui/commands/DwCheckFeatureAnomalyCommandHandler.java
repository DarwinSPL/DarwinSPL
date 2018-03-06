package de.darwinspl.reconfigurator.client.ui.commands;

import java.io.IOException;
import java.nio.channels.UnresolvedAddressException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import de.christophseidl.util.eclipse.ui.SelectionUtil;
import de.darwinspl.anomaly.DwVoidFeatureModelAnomaly;
import de.darwinspl.eclipse.ui.DwModelSelection;
import de.darwinspl.reconfigurator.client.hyvarrec.DwAnalysesClient;
import de.darwinspl.reconfigurator.client.hyvarrec.HyVarRecNoSolutionException;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;
import eu.hyvar.context.information.util.ContextInformationResolverUtil;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.HyConstraintIOUtil;

public class DwCheckFeatureAnomalyCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		List<IResource> resources = SelectionUtil.getSelectedResources();
		
		if(resources.size() < 1) {
			return null;
		}
		
		FileDialog fileDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
		String[] extensions ={".json"};
		fileDialog.setFilterExtensions(extensions);
		fileDialog.setFilterPath(resources.get(0).getLocation().toString());
		
		String jsonFilePath = fileDialog.open();
		
		if(jsonFilePath == null) {
			return null;
		}
		
		System.out.println("Loading feature model");
		HyFeatureModel selectedFeatureModel = DwModelSelection.retrieveFirstFeatureModelFromSelection();
		
		if(selectedFeatureModel == null) {
			// TODO error handling
			System.err.println("No feature model has been selected");
			return null;
		}
		
		EcoreUtil.resolveAll(selectedFeatureModel);
		
		System.out.println("Loading context model");
		HyContextModel contextModel = ContextInformationResolverUtil.getAccompanyingContextModel(selectedFeatureModel);
		System.out.println("Loading constraint model");
		HyConstraintModel constraintModel = HyConstraintIOUtil.loadAccompanyingConstraintModel(selectedFeatureModel);
		System.out.println("Loading validity model");
		HyValidityModel validityModel = HyValidityModelUtil.getAccompanyingValidityModel(selectedFeatureModel);
		
		List<Date> dates = new ArrayList<Date>();
		
		if(contextModel!=null) {
			dates.addAll(HyEvolutionUtil.collectDates(contextModel));
		}
		if(constraintModel != null) {
			dates.addAll(HyEvolutionUtil.collectDates(constraintModel));			
		}
		if(validityModel != null) {
			dates.addAll(HyEvolutionUtil.collectDates(validityModel));				
		}
		
		dates.addAll(HyEvolutionUtil.collectDates(selectedFeatureModel));		
		
		
		
		Date date = null;
		
		if(dates.size() == 0) {
			date = new Date();
		}
		
		
//		DwSolver dwSolver = new DwSolver(selectedFeatureModel, contextModel, date);
//		dwSolver.setConstraintModel(constraintModel, date);
//		System.err.println("Solver sat: "+dwSolver.isSatisfiable());
		
		DwAnalysesClient analysesClient = new DwAnalysesClient();
		System.out.println("Creating Message");
		String hyVarRecMessage = analysesClient.createHyVarRecMessage(contextModel, validityModel, selectedFeatureModel, constraintModel, null, null, null, date, null);
		
		System.out.println("Writing file");
		List<String> lines = new ArrayList<String>();
		lines.add(hyVarRecMessage);
		Path file = Paths.get(jsonFilePath);
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		try {
//			System.out.println("validating");
//			@SuppressWarnings("unused")
//			DwVoidFeatureModelAnomaly voidFeatureAnomaly = analysesClient.validateFeatureModelWithContext("http://localhost:9001/", null, null, contextModel, null, selectedFeatureModel, constraintModel, null, null, null, date);
////			List<DwAnomaly> anomalies = analysesClient.checkFeatures("http://localhost/", null, null, contextModel, null, selectedFeatureModel, constraintModel, null, date);
//			System.out.println("Wurst");
//		} catch (UnresolvedAddressException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (TimeoutException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (java.util.concurrent.ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (HyVarRecNoSolutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return null;
	}

}
