package eu.hyvar.feature.graphical.editor.template.svg;

/**
 * Data container for a group to use with freemarker to generate a svg file from a feature model
 * @author Gil Engel
 *
 */
public class HyFeatureModelSVGGroupDataObject {
	int modifier;
	
	HyFeatureModelSVGGroupArcDataObject arc;
	
	public HyFeatureModelSVGGroupArcDataObject getArc() {
		return arc;
	}
	
	public int getModifier() {
		return modifier;
	}

	public HyFeatureModelSVGGroupDataObject(int modifier, HyFeatureModelSVGGroupArcDataObject arc) {
		super();
		this.modifier = modifier;
		this.arc = arc;
	}
}
