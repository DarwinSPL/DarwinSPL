package eu.hyvar.feature.graphical.editor.template.svg;

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

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.HyGeometryUtil;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version.HyVersionLayouterManager;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version.HyVersionTreeLayouter;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;
import eu.hyvar.feature.graphical.editor.template.EclipseWorkspaceUtil;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

/**
 * A generator which uses a feature model and a date to generate a SVG representation of the feature model at the
 * given date. The generated file will be placed in a separate directory which is placed in the same directory
 * as the feature model. 
 * 
 * @author Gil Engel
 *
 */
public class HyFeatureModelSVGGenerator {
	private Date date;

	/**
	 * Converts a version as specified as in the model and converts it into a data object for freemarker.
	 * All superseding elements are converted as well.
	 * @param version to convert and print in the svg file
	 * @param feature corresponding feature to specified version
	 * @return A freemarker data object @see{HyFeatureModelSVGVersionDataObject}
	 */
	private HyFeatureModelSVGVersionDataObject convertVersion(HyVersion version, HyFeature feature){

		List<HyFeatureModelSVGVersionDataObject> children = new ArrayList<HyFeatureModelSVGVersionDataObject>();
		HyVersionTreeLayouter versionTreeLayouter = HyVersionLayouterManager.getLayouter(feature, date);

		for(HyVersion child : HyEvolutionUtil.getValidTemporalElements(version.getSupersedingVersions(), date)){
			children.add(convertVersion(child, feature));
		}

		int x = 0;
		int y = 0;
		if(versionTreeLayouter != null){
			Rectangle bounds = versionTreeLayouter.getBounds(version);
			x = bounds.x;
			y = bounds.y;
		}


		return new HyFeatureModelSVGVersionDataObject(version.getNumber(), x, y, children);
	}
	
	/**
	 * Searches all versions of a feature for the root version and converts this using @see{convertVersion}.
	 * @param featureWrapped
	 * @return Root version in a data object @see{HyFeatureModelSVGVersionDataObject}
	 */
	private HyFeatureModelSVGVersionDataObject convertVersionsDataObjectList(HyFeatureWrapped featureWrapped){
		HyFeature feature = featureWrapped.getWrappedModelElement();
		HyVersion rootVersion = null;
		for(HyVersion version :	HyEvolutionUtil.getValidTemporalElements(feature.getVersions(), date)){
			if(version.getSupersededVersion() == null){
				rootVersion = version;
				break;
			}
		}	

		if(rootVersion != null){
			return convertVersion(rootVersion, feature);
		}else{
			return null;
		}
	}

	/**
	 * Converts all groups of a feature model in a list of data objects
	 * @param featureModelWrapped
	 * @return
	 */
	private List<HyFeatureModelSVGGroupDataObject> convertGroups(HyFeatureModelWrapped featureModelWrapped){		
		List<HyFeatureModelSVGGroupDataObject> groups = new ArrayList<HyFeatureModelSVGGroupDataObject>();
		for(HyGroupWrapped group : featureModelWrapped.getGroups(date)){
				if(HyEvolutionUtil.getValidTemporalElements(HyEvolutionUtil.getValidTemporalElement(group.getWrappedModelElement().getParentOf(), date).getFeatures(), date).size() > 1){
					DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
					
					HyFeatureWrapped parentFeature = featureModelWrapped.getParentFeatureForGroup(group, featureModelWrapped.getSelectedDate());
					Point position = parentFeature.getPosition(date).getCopy();
					position.x += parentFeature.getSize().width() / 2;
					position.y += HyGeometryUtil.calculateFeatureHeight(parentFeature.getWrappedModelElement(), date) - theme.getFeatureVariationTypeExtent() / 2+1;

					HyFeatureWrapped leftest = null;
					HyFeatureWrapped rightest = null;
					for(HyFeature feature : group.getFeatures(date)){
						HyFeatureWrapped featureWrapped = featureModelWrapped.getWrappedFeature(feature);
						if(HyEvolutionUtil.isValid(featureWrapped.getWrappedModelElement(), date)){
							if(leftest == null){
								leftest = featureWrapped;
							}
							if(rightest == null){
								rightest = featureWrapped;
							}

							if(leftest.getPosition(date).x > featureWrapped.getPosition(date).x){
								leftest = featureWrapped;
							}

							if(rightest.getPosition(date).x < featureWrapped.getPosition(date).x){
								rightest = featureWrapped;
							}
						}
					}

					if(leftest != null && rightest != null){
						Point leftestPosition = leftest.getPosition(date).getCopy();
						leftestPosition.x += leftest.getSize().getCopy().width / 2;

						Point rightestPosition = rightest.getPosition(date).getCopy();
						rightestPosition.x += rightest.getSize().getCopy().width / 2;

						int modifier = HyEvolutionUtil.getValidTemporalElement(group.getWrappedModelElement().getTypes(), date).getType().getValue();

						HyFeatureModelSVGGroupArcDataObject arc = new HyFeatureModelSVGGroupArcDataObject(leftestPosition.x, leftestPosition.y, position.x, position.y, rightestPosition.x, rightestPosition.y);
						groups.add(new HyFeatureModelSVGGroupDataObject(modifier, arc));

					}
				}
			
		}

		return groups;
	}

	/**
	 * Converts a feature as specified by the model to a data object.
	 * @param featureWrapped
	 * @return
	 */
	private HyFeatureModelSVGFeatureDataObject convertFeature(HyFeatureWrapped featureWrapped){
		Point position = featureWrapped.getPosition(date);

		HyName name = HyEvolutionUtil.getValidTemporalElement(featureWrapped.getWrappedModelElement().getNames(), date);



		List<HyFeatureModelSVGAttributeDataObject> attributes = new ArrayList<HyFeatureModelSVGAttributeDataObject>();
		for(HyFeatureAttribute attribute : HyEvolutionUtil.getValidTemporalElements(featureWrapped.getWrappedModelElement().getAttributes(), date)){
			HyName attributeName = HyEvolutionUtil.getValidTemporalElement(attribute.getNames(), date);

			int type = -1;
			if(attribute instanceof HyNumberAttribute){
				type = 0;
			}
			if(attribute instanceof HyBooleanAttribute){
				type = 1;
			}
			if(attribute instanceof HyEnumAttribute){
				type = 2;
			}

			attributes.add(new HyFeatureModelSVGAttributeDataObject(attributeName.getName(), type));
		}

		List<HyFeatureModelSVGFeatureDataObject> children = new ArrayList<HyFeatureModelSVGFeatureDataObject>();
		for(HyParentChildConnection connection : featureWrapped.getChildrenConnections(date)){
			children.add(convertFeature(connection.getTarget()));
		}



		HyGroupTypeEnum type = featureWrapped.getModfierAtDate(date);
		int modifier = -1;
		if(type != null && type.getValue() != HyGroupTypeEnum.ALTERNATIVE_VALUE && type.getValue() != HyGroupTypeEnum.OR_VALUE){
			HyFeatureType featureType = HyEvolutionUtil.getValidTemporalElement(featureWrapped.getWrappedModelElement().getTypes(), date);
			modifier = (featureType.getType() == HyFeatureTypeEnum.OPTIONAL) ? 0 : 1;
		}

		Dimension dimension = featureWrapped.getSize();

		HyVersionTreeLayouter versionTreeLayouter = HyVersionLayouterManager.getLayouter(featureWrapped.getWrappedModelElement(), date);

		int versionAreaWidth = 0;
		int versionAreaHeight = 0;
		if(versionTreeLayouter != null){
			DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
			versionAreaWidth = versionTreeLayouter.getTreeBounds().width;
			versionAreaHeight = versionTreeLayouter.getTreeBounds().height+theme.getVersionTriangleEdgeLength();
		}

		return new HyFeatureModelSVGFeatureDataObject(
				name.getName(), 
				position.x(), 
				position.y(), 
				dimension.width(), 
				dimension.height, 
				versionAreaWidth,
				versionAreaHeight,
				modifier, 
				attributes, 
				children,
				convertVersionsDataObjectList(featureWrapped));
	}
	
	
	private List<HyFeatureModelSVGEnumDataObject> convertEnumerations(HyFeatureModelWrapped modelWrapped){
		List<HyFeatureModelSVGEnumDataObject> enums = new ArrayList<HyFeatureModelSVGEnumDataObject>();
		Date date = modelWrapped.getSelectedDate();
		
		for(HyEnum enumeration : HyEvolutionUtil.getValidTemporalElements(modelWrapped.getModel().getEnums(), date)){
			enums.add(convertEnumeration(enumeration, date));
		}
		
		return enums;
	}
	/**
	 * Converts a enumeration as specified by the model to a data object.
	 * @param featureWrapped
	 * @return
	 */
	private HyFeatureModelSVGEnumDataObject convertEnumeration(HyEnum enumeration, Date date){
		List<String> literals = new ArrayList<String>();
		for(HyEnumLiteral literal : HyEvolutionUtil.getValidTemporalElements(enumeration.getLiterals(), date)){
			literals.add(literal.getName());
		}
		
		return new HyFeatureModelSVGEnumDataObject(enumeration.getName(), literals);
	}

	/**
	 * Sets the template intern variables in order to generate the SVG file
	 * @return
	 */
	private Map<String, Object> prepareDataForExportFile(){
		Map<String, Object> input = new HashMap<String, Object>();



		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		HyGraphicalFeatureModelViewer editor = (HyGraphicalFeatureModelViewer)page.getActiveEditor();

		HyFeatureModelWrapped modelWrapped = editor.getModelWrapped();
		HyFeatureModel model = modelWrapped.getModel();

		HyRootFeature rootFeature = HyEvolutionUtil.getValidTemporalElement(model.getRootFeature(), date);
		HyFeatureWrapped featureWrapped = modelWrapped.getWrappedFeature(rootFeature.getFeature());

	
		HyFeatureModelSVGFeatureDataObject root = convertFeature(featureWrapped);
		input.put("rootFeature", root);

		List<HyFeatureModelSVGGroupDataObject> groups = convertGroups(modelWrapped);
		input.put("groups", groups);	
		
		List<HyFeatureModelSVGEnumDataObject> enums = convertEnumerations(modelWrapped);
		input.put("enums", enums);	
		// add theme
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		input.put("theme", theme);	


		return input;
	}

	/**
	 * Configures freemarker for usage.
	 * @return
	 * @throws URISyntaxException
	 * @throws TemplateNotFoundException
	 * @throws MalformedTemplateNameException
	 * @throws ParseException
	 * @throws IOException
	 * @throws TemplateException
	 */
	private Configuration initializeConfiguration() throws URISyntaxException, TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException{
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		cfg.setClassForTemplateLoading(HyFeatureModelSVGGenerator.class, "templates");
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.US);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

		Bundle bundle = Platform.getBundle("eu.hyvar.feature.graphical.editor");
		URL fileURL = bundle.getEntry("templates/");

		File file = new File(FileLocator.resolve(fileURL).toURI());
		cfg.setDirectoryForTemplateLoading(file);

		return cfg;
	}


	/**
	 * Starts the generation process and generates on success a SVG file containing the feature model at a given
	 * date
	 * @param date
	 */
	public void createFile(Date date){
		this.date = date;

		Template template = null;
		try{
			Configuration cfg = initializeConfiguration();

			template = cfg.getTemplate("svg_exporter.ftl");
		}catch(Exception ex){
			return;
		}


		String modelName = EclipseWorkspaceUtil.getFilenameFromCurrentOpenEditorFile();

		// create the folder where the overview file will be generated and
		// all style related files will copied
		IPath overviewPath = EclipseWorkspaceUtil.createFolderInPathFromCurrentOpenEditorFile("overview");

		try{
			File oFile = EclipseWorkspaceUtil.createFileInPath(modelName+".svg", overviewPath);
			Writer fileWriter = new FileWriter(oFile);

			Map<String, Object> input = prepareDataForExportFile();
			template.process(input, fileWriter);

			fileWriter.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}catch(TemplateException ex){
			ex.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
