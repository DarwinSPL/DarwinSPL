package eu.hyvar.feature.graphical.editor.template.svg;

import java.util.List;

/**
 * Data container for a feature to use with freemarker to generate a svg file from a feature model
 * @author Gil Engel
 *
 */
public class HyFeatureModelSVGFeatureDataObject {
	private String name;
	
	private int x;
	
	private int y;
	
	private int width;
	
	private int height;
	
	private int versionAreaWidth;
	
	private int versionAreaHeight;
	
	private int modifier;
	
	private List<HyFeatureModelSVGAttributeDataObject> attributes;
	
	private List<HyFeatureModelSVGFeatureDataObject> children;
	
	private HyFeatureModelSVGVersionDataObject rootVersion;

	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getVersionAreaWidth() {
		return versionAreaWidth;
	}

	public int getVersionAreaHeight() {
		return versionAreaHeight;
	}

	public int getModifier() {
		return modifier;
	}

	public List<HyFeatureModelSVGAttributeDataObject> getAttributes() {
		return attributes;
	}

	public List<HyFeatureModelSVGFeatureDataObject> getChildren() {
		return children;
	}

	public HyFeatureModelSVGVersionDataObject getRootVersion() {
		return rootVersion;
	}


	public HyFeatureModelSVGFeatureDataObject(String name, int x, int y, int width, int height, int versionAreaWidth,
			int versionAreaHeight, int modifier, List<HyFeatureModelSVGAttributeDataObject> attributes,
			List<HyFeatureModelSVGFeatureDataObject> children, HyFeatureModelSVGVersionDataObject rootVersion) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.versionAreaWidth = versionAreaWidth;
		this.versionAreaHeight = versionAreaHeight;
		this.modifier = modifier;
		this.attributes = attributes;
		this.children = children;
		this.rootVersion = rootVersion;
	}
}
