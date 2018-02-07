package eu.hyvar.reconfigurator.input.exporter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.HyContextualInformationBoolean;
import eu.hyvar.context.HyContextualInformationEnum;
import eu.hyvar.context.HyContextualInformationNumber;
import eu.hyvar.context.information.contextValue.ContextValueFactory;
import eu.hyvar.context.information.contextValue.HyContextValue;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyValue;

public class DwContextValueExporter {

	private Map<HyContextualInformation, String> contextReconfiguratorIdMapping;

	public DwContextValueExporter(Map<HyContextualInformation, String> contextReconfiguratorIdMapping) {
		this.contextReconfiguratorIdMapping = contextReconfiguratorIdMapping;
	}

	public List<eu.hyvar.reconfigurator.input.format.ContextValue> getContextValuesWithValuesForContextsWithoutValues(
			List<HyContextValueModel> contextValueModels, List<HyContextModel> contextModels) {
		
		List<eu.hyvar.reconfigurator.input.format.ContextValue> exportedContextValues = new ArrayList<eu.hyvar.reconfigurator.input.format.ContextValue>();
		
		// Add default values for all unset context values
		List<HyContextualInformation> contextsWithoutValues = new ArrayList<HyContextualInformation>();
		if (contextModels != null) {
			for (HyContextModel contextModel : contextModels) {
				contextsWithoutValues.addAll(contextModel.getContextualInformations());
			}
		}

		if (contextValueModels != null) {
			for (HyContextValueModel contextValueModel : contextValueModels) {
				if(contextValueModel != null && contextValueModel.getValues() != null) {
					for (HyContextValue contextValue : contextValueModel.getValues()) {
						
						contextsWithoutValues.remove(contextValue.getContext());
						
						exportedContextValues.add(getContextValue(contextValue));
					}					
				}
			}
		}

		HyContextValueModel contextValueModelForContextsWithoutValues = createContextValueModelForContextsWithoutValues(contextsWithoutValues);
		exportedContextValues.addAll(getContextValues(contextValueModelForContextsWithoutValues));
		
		return exportedContextValues;
	}
	
	private HyContextValueModel createContextValueModelForContextsWithoutValues(List<HyContextualInformation> contextsWithoutValues) {
		HyContextValueModel contextValueModelForContextsWithoutValues = ContextValueFactory.eINSTANCE
				.createHyContextValueModel();

		for (HyContextualInformation contextWithoutValue : contextsWithoutValues) {
			HyContextValue contextValue = ContextValueFactory.eINSTANCE.createHyContextValue();
			HyValue value = null;

			if (contextWithoutValue instanceof HyContextualInformationNumber) {
				HyNumberValue numberValue = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
				numberValue.setValue(((HyContextualInformationNumber) contextWithoutValue).getMin());
				value = numberValue;
			} else if (contextWithoutValue instanceof HyContextualInformationBoolean) {
				HyBooleanValue booleanValue = HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
				booleanValue.setValue(false);
				value = booleanValue;
			} else if (contextWithoutValue instanceof HyContextualInformationEnum) {
				HyEnum enumType = ((HyContextualInformationEnum) contextWithoutValue).getEnumType();
				HyEnumValue enumValue = HyDataValuesFactory.eINSTANCE.createHyEnumValue();
				if (enumType.getLiterals().isEmpty()) {
					System.err.println(
							"Translation Failed! An enum for a context information does not have any literal. Not possible!");
				}

				enumValue.setEnum(enumType);
				for (HyEnumLiteral enumLiteral : enumType.getLiterals()) {
					enumValue.setEnumLiteral(enumLiteral);
					break;
				}
				value = enumValue;
			}

			contextValue.setContext(contextWithoutValue);
			contextValue.setValue(value);
			contextValueModelForContextsWithoutValues.getValues().add(contextValue);
		}
		
		return contextValueModelForContextsWithoutValues;
	}

	public List<eu.hyvar.reconfigurator.input.format.ContextValue> getContextValues(
			HyContextValueModel contextValueModel) {
		List<eu.hyvar.reconfigurator.input.format.ContextValue> exportedContextValues = new ArrayList<eu.hyvar.reconfigurator.input.format.ContextValue>();

		for (HyContextValue contextValue : contextValueModel.getValues()) {
			exportedContextValues.add(getContextValue(contextValue));
		}

		return exportedContextValues;
	}
	
	private eu.hyvar.reconfigurator.input.format.ContextValue getContextValue(HyContextValue contextValue) {
		eu.hyvar.reconfigurator.input.format.ContextValue exportedContextValue = new eu.hyvar.reconfigurator.input.format.ContextValue();

		exportedContextValue.setId(contextReconfiguratorIdMapping.get(contextValue.getContext()));
		exportedContextValue.setValue(exportValue(contextValue.getValue()));

		return exportedContextValue;
	}

	private Integer exportValue(HyValue value) {
		if (value instanceof HyNumberValue) {
			return ((HyNumberValue) value).getValue();
		} else if (value instanceof HyBooleanValue) {
			if (((HyBooleanValue) value).isValue()) {
				return 1;
			} else {
				return 0;
			}
		} else if (value instanceof HyEnumValue) {
			HyEnumValue enumValue = (HyEnumValue) value;
			return enumValue.getEnumLiteral().getValue();
		}

		return 0;
	}

}
