package de.darwinspl.reconfigurator.client.ui.commands;

import java.io.IOException;
import java.nio.channels.UnresolvedAddressException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.christophseidl.util.eclipse.ui.SelectionUtil;
import de.darwinspl.anomaly.DwAnomaly;
import de.darwinspl.anomaly.DwFeatureAnomaly;
import de.darwinspl.anomaly.explanation.DwAnomalyExplanation;
import de.darwinspl.eclipse.ui.DwModelSelection;
import de.darwinspl.reconfigurator.client.hyvarrec.DwAnalysesClient;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;
import eu.hyvar.context.information.util.ContextInformationResolverUtil;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.HyConstraintIOUtil;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter.FeatureEncoding;
import eu.hyvar.reconfigurator.input.format.InputForHyVarRec;

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
		Set<Date> rawDates = new HashSet<Date>();
		if(contextModel!=null) {
			rawDates.addAll(HyEvolutionUtil.collectDates(contextModel));
		}
		if(constraintModel != null) {
			rawDates.addAll(HyEvolutionUtil.collectDates(constraintModel));			
		}
		if(validityModel != null) {
			rawDates.addAll(HyEvolutionUtil.collectDates(validityModel));				
		}
		
		rawDates.addAll(HyEvolutionUtil.collectDates(selectedFeatureModel));		
		
		dates.addAll(rawDates);
		
		Date date = null;
		
		if(dates.size() == 0) {
			date = new Date();
		}
		
		
//		DwSolver dwSolver = new DwSolver(selectedFeatureModel, contextModel, date);
//		dwSolver.setConstraintModel(constraintModel, date);
//		System.err.println("Solver sat: "+dwSolver.isSatisfiable());
		
		DwAnalysesClient analysesClient = new DwAnalysesClient();
		System.out.println("Creating Message");
		
		String hyVarRecMessage = analysesClient.createHyVarRecMessage(contextModel, validityModel, selectedFeatureModel, constraintModel, null, null, null, date, null, DwAnalysesClient.VALIDATE_MODALITY);
		
		HyVarRecExporter integerExporter = new HyVarRecExporter(FeatureEncoding.INTEGER);
		InputForHyVarRec inputForHyVarRec = integerExporter.exportSPL(contextModel, validityModel, selectedFeatureModel, constraintModel, null, null, null, date, date);
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		Gson gson = gsonBuilder.disableHtmlEscaping().create();
		String hyVarRecMessage_integer = gson.toJson(inputForHyVarRec);
		
		
		try {
			
//			
//			
//			
//			
////			DwVoidFeatureModelAnomaly voidFM = analysesClient.validateFeatureModelWithContext("http://localhost:9001", null, null, contextModel, validityModel, selectedFeatureModel, constraintModel, null, null, null, date);
////			System.err.println(voidFM);
//			System.err.println("Checking features");
			List<DwAnomaly> featureAnomalies = analysesClient.checkFeatures("http://localhost:9001", null, null, contextModel, validityModel, selectedFeatureModel, constraintModel, null, date);
			for(DwAnomaly anomaly: featureAnomalies) {
				System.err.println(anomaly);
			}
			if(featureAnomalies != null) {
				for(DwAnomaly anomaly: featureAnomalies) {
					if(anomaly instanceof DwFeatureAnomaly) {
						System.err.println("Getting explanation");
						DwFeatureAnomaly fo = (DwFeatureAnomaly) anomaly;
						DwAnomalyExplanation anomalyExplanation = analysesClient.explainAnomaly("http://localhost:9001", null, null, contextModel, validityModel, selectedFeatureModel, constraintModel, anomaly);
						System.err.println("Explanation for "+fo);
						System.err.println(anomalyExplanation.getExplanations().toString());
					}

				}
				System.err.println(featureAnomalies.size());				
			}
//			if(featureAnomalies != null) {
//				int fo = 0;
//				int dead = 0;
//				for(DwAnomaly anomaly: featureAnomalies) {
//					if(anomaly instanceof DwFalseOptionalFeatureAnomaly) {
//						fo++;
//					}
//					else if(anomaly instanceof DwDeadFeatureAnomaly) {
//						dead++;
//					}
//				}	
//				
//				System.err.println("Dead features: "+dead);
//				System.err.println("FOs: "+fo);
//			}
//			else {
//				System.err.println("No anomalies");
//			}
		} catch (UnresolvedAddressException | TimeoutException | InterruptedException
				| java.util.concurrent.ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Writing file");
		List<String> lines = new ArrayList<String>();
		lines.add(hyVarRecMessage);
		
		List<String> lines_integer = new ArrayList<String>(1);
		lines_integer.add(hyVarRecMessage_integer);
		
		Path file = Paths.get(jsonFilePath);
		Path file_integer = Paths.get(jsonFilePath+"_integer");
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
			Files.write(file_integer, lines_integer, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Collections.sort(dates);
		
		if(dates.isEmpty()) {
			System.out.println("#Features "+HyEvolutionUtil.getValidTemporalElements(selectedFeatureModel.getFeatures(), null).size());
			System.out.println("#Groups  "+HyEvolutionUtil.getValidTemporalElements(selectedFeatureModel.getGroups(),null).size());
			if(constraintModel != null) {
				System.out.println("#Constraints "+HyEvolutionUtil.getValidTemporalElements(constraintModel.getConstraints(), null).size());				
			}
		}
		
		if(dates.size() != 0) {
			Date firstDate = dates.get(0);
			Calendar cal = new GregorianCalendar();
			cal.setTime(firstDate);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			Date beforeFirstDate = cal.getTime();
			dates.add(beforeFirstDate);
			
			if(dates.size() > 1) {
				Date lastDate = dates.get(dates.size()-1);
				cal.setTime(lastDate);
				cal.add(Calendar.DAY_OF_MONTH, 1);
				Date afterLastDate = cal.getTime();
				dates.add(afterLastDate);
			}
			
			Collections.sort(dates);
		}
		
//		for(int i=0;i<dates.size();i++) {			
//			System.out.println("#Features at "+dates.get(i)+": "+HyEvolutionUtil.getValidTemporalElements(selectedFeatureModel.getFeatures(), dates.get(i)).size());
//			System.out.println("#Groups at "+dates.get(i)+": "+HyEvolutionUtil.getValidTemporalElements(selectedFeatureModel.getGroups(), dates.get(i)).size());
//			if(constraintModel != null) {
//				System.out.println("#Constraints at "+dates.get(i)+": "+HyEvolutionUtil.getValidTemporalElements(constraintModel.getConstraints(), dates.get(i)).size());				
//			}
//			hyVarRecMessage = analysesClient.createHyVarRecMessage(contextModel, validityModel, selectedFeatureModel, constraintModel, null, null, null, dates.get(i), null);
//			
//			System.out.println("Writing file");
//			lines = new ArrayList<String>();
//			lines.add(hyVarRecMessage);
//			file = Paths.get(jsonFilePath+"t_"+i);
//			try {
//				Files.write(file, lines, Charset.forName("UTF-8"));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
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
