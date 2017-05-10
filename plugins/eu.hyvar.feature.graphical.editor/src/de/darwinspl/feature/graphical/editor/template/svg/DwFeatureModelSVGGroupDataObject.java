package de.darwinspl.feature.graphical.editor.template.svg;

/**
 * Data container for a group to use with freemarker to generate a svg file from a feature model
 * @author Gil Engel
 *
 */
public class DwFeatureModelSVGGroupDataObject {
	int modifier;
	
	DwFeatureModelSVGGroupArcDataObject arc;
	
	public DwFeatureModelSVGGroupArcDataObject getArc() {
		return arc;
	}
	
	public int getModifier() {
		return modifier;
	}

	public DwFeatureModelSVGGroupDataObject(int modifier, DwFeatureModelSVGGroupArcDataObject arc) {
		super();
		this.modifier = modifier;
		this.arc = arc;
	}
}
