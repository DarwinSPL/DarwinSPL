package de.darwinspl.feature.graphical.editor.template.svg;

import java.util.List;

/**
 * Data container for a version to use with freemarker to generate a svg file from a feature model
 * @author Gil Engel
 *
 */
public class DwFeatureModelSVGVersionDataObject {
	private String number;
	
	private int x;
	
	private int y;
	
	public List<DwFeatureModelSVGVersionDataObject> children;

	public String getNumber() {
		return number;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public List<DwFeatureModelSVGVersionDataObject> getChildren() {
		return children;
	}

	public DwFeatureModelSVGVersionDataObject(String number, int x, int y,
			List<DwFeatureModelSVGVersionDataObject> children) {
		super();
		this.number = number;
		this.x = x;
		this.y = y;
		this.children = children;
	}
}
