package eu.hyvar.feature.example_creation.wizard;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;
import eu.hyvar.context.information.util.HyContextInformationUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;
import eu.hyvar.feature.example_creation.examples.CarAssistanceExample;
import eu.hyvar.feature.example_creation.examples.HyFMExample;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.feature.mapping.util.HyMappingModelUtil;
import eu.hyvar.feature.util.HyFeatureUtil;
import eu.hyvar.preferences.HyProfile;
import eu.hyvar.preferences.util.HyPreferenceModelUtil;

public class ExampleSelectionWizard extends Wizard {

	 protected ExampleSelectionWizardPage exampleSelectionPage;

	 private Map<String, Class<? extends HyFMExample>> availableExamples;
	 
	public ExampleSelectionWizard(Map<String, Class<? extends HyFMExample>> availableExamples) {
	    super();
	    setNeedsProgressMonitor(true);
	    this.availableExamples = availableExamples;
	}
	 
	 @Override
	  public String getWindowTitle() {
	    return "Create HyFM Example";
	  }

	
	 @Override
	  public void addPages() {
		 exampleSelectionPage = new ExampleSelectionWizardPage(availableExamples);
		 addPage(exampleSelectionPage);
	 }

		 
	 
	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		String selection = exampleSelectionPage.getSelection();
		HyFMExample example = createExample(selection);
		saveExample(example, selection);
		return true;
	}
	
	private void saveExample(HyFMExample example, String fileName) {
		HyFeatureModel featureModel = example.createExample();
		
		HyConstraintModel constraintModel = example.createConstraintModel();
		
		HyContextModel contextModel = example.createContextModel();
		
		HyValidityModel validityModel = example.createValidityModel();
		
		HyProfile preferenceModel = example.createPreferenceModel();
		
		HyMappingModel mappingModel = example.createMappingModel();
		
		HyConfiguration config = example.createConfiguration();
		
		
		if(featureModel != null) {
			// TODO take folder selected in eclipse
			IFile file = ResourceUtil.getLocalFile("Example/" + fileName + "."+ HyFeatureUtil.getFeatureModelFileExtensionForXmi());
			EcoreIOUtil.saveModelAs(featureModel, file);
		} else {
			MessageDialog.openError(getShell(), "Error", "The model created by the example "+example.getClass().getCanonicalName()+" was null. Aborting.");
		}
		
		if(constraintModel != null) {
			IFile file = ResourceUtil.getLocalFile("Example/" + fileName +"."+HyConstraintUtil.getConstraintModelFileExtensionForXmi());
			EcoreIOUtil.saveModelAs(constraintModel, file);
		} else {
			System.out.println("Constraint Model was null");
		}
		
		if(contextModel != null) {
			IFile file = ResourceUtil.getLocalFile("Example/" + fileName + "."+HyContextInformationUtil.getContextModelFileExtensionForXmi());
			EcoreIOUtil.saveModelAs(contextModel, file);
		} else {
			System.out.println("Context Model was null");
		}
		
		if(validityModel != null) {
			IFile file = ResourceUtil.getLocalFile("Example/" + fileName + "." + HyValidityModelUtil.getValidityModelFileExtensionForXmi());
			EcoreIOUtil.saveModelAs(validityModel, file);
		} else {
			System.out.println("Validity Model was null");
		}
		
		if(preferenceModel != null) {
			IFile file = ResourceUtil.getLocalFile("Example/" + fileName + "." + HyPreferenceModelUtil.getPreferenceModelFileExtensionForXmi());
			EcoreIOUtil.saveModelAs(preferenceModel, file);
		} else {
			System.out.println("Preference Model was null");
		}
		
		if(mappingModel != null) {
			IFile file = ResourceUtil.getLocalFile("Example/" + fileName + "." + HyMappingModelUtil.getMappingModelFileExtensionForXmi());
			EcoreIOUtil.saveModelAs(mappingModel, file);
		} else {
			System.out.println("Mapping Model was null");
		}
		
		if(config != null) {
			IFile file = ResourceUtil.getLocalFile("Example/" + fileName + "."+HyConfigurationUtil.getConfigurationModelFileExtensionForXmi());
			EcoreIOUtil.saveModelAs(config, file);
		} else {
			System.out.println("Configuration was null");
		}

	}

	private HyFMExample createExample(String selection) {
		HyFMExample example = null;
		
		if (selection == null || !availableExamples.containsKey(selection)) {
			example = new CarAssistanceExample();
		} else {
			try {
				example = availableExamples.get(selection).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(example == null) {
			example = new CarAssistanceExample();
		}
		
		return example;
	}
	
}
