package eu.hyvar.feature.graphical.editor.template.svg;

import java.util.List;

/**
 * Data container for a version to use with freemarker to generate a svg file from a feature model
 * @author Gil Engel
 *
 */
public class HyFeatureModelSVGVersionDataObject {
	private String number;
	
	private int x;
	
	private int y;
	
	public List<HyFeatureModelSVGVersionDataObject> children;

	public String getNumber() {
		return number;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public List<HyFeatureModelSVGVersionDataObject> getChildren() {
		return children;
	}

	public HyFeatureModelSVGVersionDataObject(String number, int x, int y,
			List<HyFeatureModelSVGVersionDataObject> children) {
		super();
		this.number = number;
		this.x = x;
		this.y = y;
		this.children = children;
	}
}
