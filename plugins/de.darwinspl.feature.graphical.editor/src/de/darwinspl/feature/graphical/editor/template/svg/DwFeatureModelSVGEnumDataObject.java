package de.darwinspl.feature.graphical.editor.template.svg;

import java.util.List;

public class DwFeatureModelSVGEnumDataObject {
	String name;
	
	List<String> literals;

	public String getName() {
		return name;
	}

	public List<String> getLiterals() {
		return literals;
	}

	public DwFeatureModelSVGEnumDataObject(String name, List<String> literals) {
		super();
		this.name = name;
		this.literals = literals;
	}
}
