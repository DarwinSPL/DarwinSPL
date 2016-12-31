package de.darwinspl.exporter.ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.eclipse.ui.SelectionUtil;
import de.darwinspl.common.eclipse.util.IFileUtils;
import de.darwinspl.exporter.ui.json.JsonConfiguration;
import de.darwinspl.exporter.ui.json.JsonConstraintModel;
import de.darwinspl.exporter.ui.json.JsonContextModel;
import de.darwinspl.exporter.ui.json.JsonFeatureModel;
import de.darwinspl.exporter.ui.json.JsonFormat;
import de.darwinspl.exporter.ui.json.JsonMappingModel;
import de.darwinspl.exporter.ui.json.JsonValidityModel;
import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;
import eu.hyvar.context.information.util.HyContextInformationUtil;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;
import eu.hyvar.feature.mapping.util.HyMappingModelUtil;
import eu.hyvar.feature.util.HyFeatureUtil;

public class ExportToJsonCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		JsonFormat jsonFormat = new JsonFormat();

		IFile featureModelFile = SelectionUtil
				.getFirstSelectedIFileWithExtension(HyFeatureUtil.getFeatureModelFileExtensionForXmi());

		if (featureModelFile == null || !featureModelFile.exists()) {
			// Error
			return null;
		} else {
			JsonFeatureModel jsonFeatureModel = new JsonFeatureModel();
			jsonFeatureModel.setSpecification(IFileUtils.readStringFromFile(featureModelFile));
			jsonFormat.setFeaturemodel(jsonFeatureModel);
		}

		IFile constraintModelFile = ResourceUtil.deriveFile(featureModelFile,
				HyConstraintUtil.getConstraintModelFileExtensionForXmi());
		IFile mappingFile = ResourceUtil.deriveFile(featureModelFile,
				HyMappingModelUtil.getMappingModelFileExtensionForXmi());
		IFile configurationFile = ResourceUtil.deriveFile(featureModelFile,
				HyConfigurationUtil.getConfigurationModelFileExtensionForXmi());
		IFile contextFile = ResourceUtil.deriveFile(featureModelFile,
				HyContextInformationUtil.getContextModelFileExtensionForXmi());
		IFile validityFile = ResourceUtil.deriveFile(featureModelFile,
				HyValidityModelUtil.getValidityModelFileExtensionForXmi());

		if (constraintModelFile != null && constraintModelFile.exists()) {
			JsonConstraintModel jsonConstraintModel = new JsonConstraintModel();
			jsonConstraintModel.setSpecification(IFileUtils.readStringFromFile(constraintModelFile));
			jsonFormat.setConstraints(jsonConstraintModel);
		}

		if (configurationFile != null && configurationFile.exists()) {
			JsonConfiguration jsonConfiguration = new JsonConfiguration();
			jsonConfiguration.setSpecification(IFileUtils.readStringFromFile(configurationFile));
			jsonFormat.setConfiguration(jsonConfiguration);
		}

		if (mappingFile != null && mappingFile.exists()) {
			JsonMappingModel jsonMapping = new JsonMappingModel();
			jsonMapping.setSpecification(IFileUtils.readStringFromFile(mappingFile));
			jsonFormat.setMapping(jsonMapping);
		}

		if (contextFile != null && contextFile.exists()) {
			JsonContextModel jsonContext = new JsonContextModel();
			jsonContext.setSpecification(IFileUtils.readStringFromFile(contextFile));
			jsonFormat.setContextmodel(jsonContext);
		}

		if (validityFile != null && validityFile.exists()) {
			JsonValidityModel jsonValidityFormulas = new JsonValidityModel();
			jsonValidityFormulas.setSpecification(IFileUtils.readStringFromFile(validityFile));
			jsonFormat.setValidity(jsonValidityFormulas);
		}

		Gson gson = new GsonBuilder().create();
		String jsonString = gson.toJson(jsonFormat);
		
		System.out.println("Json output: " + jsonString);

		IFile jsonFile = ResourceUtil.deriveFile(featureModelFile, "json");
		InputStream inputStream = new ByteArrayInputStream(jsonString.getBytes());
		try {
			jsonFile.create(inputStream, true, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
