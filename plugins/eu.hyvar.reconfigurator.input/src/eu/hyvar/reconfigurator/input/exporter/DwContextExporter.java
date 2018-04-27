package eu.hyvar.reconfigurator.input.exporter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.HyContextualInformationBoolean;
import eu.hyvar.context.HyContextualInformationEnum;
import eu.hyvar.context.HyContextualInformationNumber;
import eu.hyvar.evolution.util.HyEvolutionUtil;

public class DwContextExporter {
	
	private Map<HyContextualInformation, String> contextReconfiguratorIdMapping;
	
	public DwContextExporter(Map<HyContextualInformation, String> contextReconfiguratorIdMapping) {
		this.contextReconfiguratorIdMapping = contextReconfiguratorIdMapping;
	}
	
	
	public List<eu.hyvar.reconfigurator.input.format.Context> getExportedContexts(HyContextModel contextModel,
			Date date) {
		List<eu.hyvar.reconfigurator.input.format.Context> exportedContexts = new ArrayList<eu.hyvar.reconfigurator.input.format.Context>();

		for (HyContextualInformation context : HyEvolutionUtil
				.getValidTemporalElements(contextModel.getContextualInformations(), date)) {

			int min = 0;
			int max = 0;

			if (context instanceof HyContextualInformationBoolean) {
				min = 0;
				max = 1;
			} else if (context instanceof HyContextualInformationNumber) {
				HyContextualInformationNumber numberContext = (HyContextualInformationNumber) context;

				min = numberContext.getMin();
				max = numberContext.getMax();
			} else if (context instanceof HyContextualInformationEnum) {
				HyContextualInformationEnum enumContext = (HyContextualInformationEnum) context;
				DomainTuple<Integer> domain = HyVarRecExporter.getEnumDomain(enumContext.getEnumType());
				min = domain.getMin();
				max = domain.getMax();
			}

			eu.hyvar.reconfigurator.input.format.Context exportedContext = new eu.hyvar.reconfigurator.input.format.Context();
			exportedContext.setId(contextReconfiguratorIdMapping.get(context));
			exportedContext.setMin(min);
			exportedContext.setMax(max);

			exportedContexts.add(exportedContext);
		}

		return exportedContexts;
	}
}
