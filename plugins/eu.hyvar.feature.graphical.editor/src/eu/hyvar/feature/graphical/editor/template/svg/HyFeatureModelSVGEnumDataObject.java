package eu.hyvar.feature.graphical.editor.template.svg;

import java.util.List;

public class HyFeatureModelSVGEnumDataObject {
	String name;
	
	List<String> literals;

	public String getName() {
		return name;
	}

	public List<String> getLiterals() {
		return literals;
	}

	public HyFeatureModelSVGEnumDataObject(String name, List<String> literals) {
		super();
		this.name = name;
		this.literals = literals;
	}
}
