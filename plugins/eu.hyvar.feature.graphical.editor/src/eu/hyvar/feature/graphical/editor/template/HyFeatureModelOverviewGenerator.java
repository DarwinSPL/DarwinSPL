package eu.hyvar.feature.graphical.editor.template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyNamedElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;
import freemarker.core.ParseException;
import freemarker.core.TemplateDateFormatFactory;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

public class HyFeatureModelOverviewGenerator {
	private HyFeature getParentFeature(HyGroupComposition composition, Date date){
		return HyEvolutionUtil.getValidTemporalElement(composition.getCompositionOf().getChildOf(), date).getParent();		
	}

	private String getGroupTypeEnumString(HyGroupTypeEnum groupEnum){
		if(groupEnum == HyGroupTypeEnum.ALTERNATIVE){
			return "alternative";
		}else if(groupEnum == HyGroupTypeEnum.AND){
			return "and";
		}else if(groupEnum == HyGroupTypeEnum.OR){
			return "or";
		}else{
			return "invalid enum";
		}
	}

	private void addNameChanges(String identifier, String elementName, HyNamedElement element, Date date, List<HyFeatureModelOverviewChangeDataObject> changes){
		HyName oldName = null;
		for(HyName name : element.getNames()){
			if(name.getValidSince() == null)
				oldName = name;
			else if(name.getValidUntil() != null && name.getValidUntil() .equals(date)){
				oldName = name;
			}	

			if(name.getValidSince() != null && name.getValidSince().equals(date)){
				if(oldName != null){
					changes.add(new HyFeatureModelOverviewChangeDataObject(identifier+" ", elementName, " changed name from "+ oldName.getName() +" to "+ name.getName()));
				}
			}	
		}		
	}
	private Map<String, Object> fillOverviewFile(){
		Map<String, Object> input = new HashMap<String, Object>();



		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		HyGraphicalFeatureModelViewer editor = (HyGraphicalFeatureModelViewer)page.getActiveEditor();
		List<Date> dates = HyEvolutionUtil.collectDates(editor.getModelWrapped().getModel());
		List<HyFeatureModelOverviewDataObject> templateDates = new ArrayList<HyFeatureModelOverviewDataObject>();

		HyFeatureModel model = editor.getModelWrapped().getModel();

		for(Date date : dates){
//			int index = dates.indexOf(date);

			List<HyFeatureModelOverviewChangeDataObject> changes = new ArrayList<HyFeatureModelOverviewChangeDataObject>();

			for(HyFeature feature : model.getFeatures()){
				boolean featureIsValid = HyEvolutionUtil.isValid(feature, date);
				
				boolean featureAdded = false;
				
				
				HyName hyName = HyFeatureEvolutionUtil.getName(feature.getNames(), date);
				
				if(hyName == null) {
					hyName = HyFeatureEvolutionUtil.getLastValidName(feature);
				}
				
				
				String featureName = hyName.getName();
				
				if(feature.getValidSince()!=null && feature.getValidSince().equals(date)) {
					changes.add(new HyFeatureModelOverviewChangeDataObject("Feature.", featureName, " was added"));
					featureAdded = true;
				} 
				else if(feature.getValidUntil()!=null && feature.getValidUntil().equals(date)) {
					changes.add(new HyFeatureModelOverviewChangeDataObject("Feature.", featureName, " was removed"));
				}

				if(!featureIsValid) {
					continue;					
				}
				
				for(HyVersion version : feature.getVersions()){
					if(version.getValidSince() != null && version.getValidSince().equals(date)){
						changes.add(new HyFeatureModelOverviewChangeDataObject(featureName+".", version.getNumber(), " was added"));
					}
					if(version.getValidUntil() != null && version.getValidUntil().equals(date)){
						changes.add(new HyFeatureModelOverviewChangeDataObject(featureName+".", version.getNumber(), " was removed"));
					}
				}

				for(HyFeatureAttribute attribute : feature.getAttributes()){
					String attributeName = HyEvolutionUtil.getValidTemporalElement(attribute.getNames(), date).getName();

					if(attribute.getValidSince() != null && attribute.getValidSince().equals(date)){
						changes.add(new HyFeatureModelOverviewChangeDataObject(featureName+".", attributeName, " was added"));
					}
					if(attribute.getValidUntil() != null && attribute.getValidUntil().equals(date)){
						changes.add(new HyFeatureModelOverviewChangeDataObject(featureName+".", attributeName, " was removed"));
					}		

					addNameChanges("Attribute", attributeName, attribute, date, changes);
				}

				addNameChanges("Feature", featureName, feature, date, changes);

				// types and moves only interesting if feature was not new
				if(!featureAdded) {			
					HyFeatureType oldType = null;
					for(HyFeatureType type : feature.getTypes()){
						if(type.getValidSince() == null)
							oldType = type;
						else if(type.getValidUntil() != null && type.getValidUntil().equals(date)){
							oldType = type;
						}	
						
						if(type.getValidSince() != null && type.getValidSince().equals(date)){
							String oldTypeString = oldType.getType() == HyFeatureTypeEnum.MANDATORY ? "mandatory": "optional";
							String newTypeString = type.getType() == HyFeatureTypeEnum.MANDATORY ? "mandatory": "optional";
							changes.add(new HyFeatureModelOverviewChangeDataObject("Feature ", featureName, " changed type from "+ oldTypeString + " to " + newTypeString));
						}	
					}
					
					HyFeature oldParentFeature = null;;
					for(HyGroupComposition composition : feature.getGroupMembership()){
						if(composition.getValidSince() == null){
							oldParentFeature = getParentFeature(composition, date);
						}else if(composition.getValidUntil() != null && composition.getValidUntil().equals(date)){
							oldParentFeature = getParentFeature(composition, date);
						}	
						
						if(composition.getValidSince() != null && composition.getValidSince().equals(date)){
							if(oldParentFeature != null){
								HyName oldName = HyEvolutionUtil.getValidTemporalElement(oldParentFeature.getNames(), date);
								HyName newName = HyEvolutionUtil.getValidTemporalElement(getParentFeature(composition, date).getNames(), date);
								
								String old = oldParentFeature.getId();
								if(oldName != null) {
									old = oldName.getName();								
								}
								
								String _new = getParentFeature(composition, date).getId();
								if(newName != null) {
									_new = newName.getName();								
								}
								
								if(!newName.equals(oldName)) {
									changes.add(new HyFeatureModelOverviewChangeDataObject("Feature ", featureName, " moved from " +	old + " to "+ _new));									
								}
							}
						}	
					}
				}
			}



			for(HyGroup group : model.getGroups()){
//				if(group.getValidSince() != null && group.getValidSince() .equals(date)){					
//					changes.add(new HyFeatureModelOverviewChangeDataObject("Group", group.getId(), " changed validity", "invalid", "valid"));
//				}
//				if(group.getValidUntil() != null && group.getValidUntil() .equals(date)){
//					changes.add(new HyFeatureModelOverviewChangeDataObject("Group", group.getId(), " changed validity", "valid", "invalid"));
//				}

				HyGroupType oldType = null;
				for(HyGroupType type : group.getTypes()){
					if(type.getValidSince() == null)
						oldType = type;
					else if(type.getValidUntil() != null && type.getValidUntil() .equals(date)){
						oldType = type;
					}	

					if(oldType != null && type.getValidSince() != null && type.getValidSince().equals(date)){
						
						changes.add(new HyFeatureModelOverviewChangeDataObject("Group ", group.getId(), " changed type from " + getGroupTypeEnumString(oldType.getType()) + " to " +getGroupTypeEnumString(type.getType())));
					}	
				}
			}


			templateDates.add(new HyFeatureModelOverviewDataObject(date, changes));

		}
		input.put("dates", templateDates);		




		return input;
	}

	private Configuration initializeConfiguration() throws URISyntaxException, TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException{
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		cfg.setClassForTemplateLoading(HyFeatureModelOverviewGenerator.class, "templates");
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.US);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		
		Map<String, TemplateDateFormatFactory> customDateFormats = new HashMap<String, TemplateDateFormatFactory>();
		customDateFormats.put("simple", HySimpleTemplateDateFormatFactory.INSTANCE);
		
		cfg.setCustomDateFormats(customDateFormats);
		cfg.setDateTimeFormat("@simle");

		Bundle bundle = Platform.getBundle("eu.hyvar.feature.graphical.editor");
		URL fileURL = bundle.getEntry("templates/");

		File file = new File(FileLocator.resolve(fileURL).toURI());
		cfg.setDirectoryForTemplateLoading(file);

		return cfg;
	}

	private void copyOverviewStyleFiles(){
		IPath overviewPath = EclipseWorkspaceUtil.createFolderInPathFromCurrentOpenEditorFile("overview");

		try{
			Bundle bundle = Platform.getBundle("eu.hyvar.feature.graphical.editor");
			URL fileURL = bundle.getEntry("templates/style/material.min.js");

			EclipseWorkspaceUtil.copyFile(new File(FileLocator.resolve(fileURL).toURI()), 
					EclipseWorkspaceUtil.createFileInPath("material.min.js", overviewPath));

			fileURL = bundle.getEntry("templates/style/material.min.css");
			EclipseWorkspaceUtil.copyFile(new File(FileLocator.resolve(fileURL).toURI()), 
					EclipseWorkspaceUtil.createFileInPath("material.min.css", overviewPath));			


		}catch(IOException ex){
			ex.printStackTrace();
		}catch(URISyntaxException ex){
			ex.printStackTrace();
		}	
	}

	public void createOverviewFile(Date since, Date until){
		Template template = null;
		try{
			Configuration cfg = initializeConfiguration();

			template = cfg.getTemplate("overview.ftl");
		}catch(Exception ex){

			return;
		}


		String modelName = EclipseWorkspaceUtil.getFilenameFromCurrentOpenEditorFile();

		// create the folder where the overview file will be generated and
		// all style related files will copied
		IPath overviewPath = EclipseWorkspaceUtil.createFolderInPathFromCurrentOpenEditorFile("overview");

		// copy all style files into the new directory
		copyOverviewStyleFiles();




		try{
			File oFile = EclipseWorkspaceUtil.createFileInPath(modelName+".html", overviewPath);
			Writer fileWriter = new FileWriter(oFile);

			Map<String, Object> input = fillOverviewFile();
			input.put("title", modelName+" Change Overview");
			template.process(input, fileWriter);

			fileWriter.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}catch(TemplateException ex){
			ex.printStackTrace();
		}
	}
}
