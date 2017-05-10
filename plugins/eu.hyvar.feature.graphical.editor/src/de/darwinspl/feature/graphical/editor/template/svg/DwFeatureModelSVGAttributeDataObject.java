package de.darwinspl.feature.graphical.editor.template.svg;

/**
 * Data container for an attribute to use with freemarker to generate a svg file from a feature model
 * @author Gil Engel
 *
 */
public class DwFeatureModelSVGAttributeDataObject {
	private String name;
	
	private int type;

	public String getName() {
		return name;
	}

	public int getType() {
		return type;
	}

	public DwFeatureModelSVGAttributeDataObject(String name, int type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	
}
