package de.darwinspl.feature.graphical.base.deltaecore.wrapper.layouter.version;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Date;
import java.util.Map;

import org.abego.treelayout.TreeForTreeLayout;
import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.util.DefaultConfiguration;
import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGeometryUtil;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyVersion;

/**
 * This class performs the layouting process of the tree.
 * model elements.
 * 
 * @author Florian
 * 
 * COPIED FROM DELTAECORE NEED REFACTORING
 * 
 */
public class DwVersionTreeLayouter {
	private TreeLayout<HyVersion> treeLayout;
	private HyFeature feature;
	private Date date;
	
	//private static final int offsetX = calculateOffsetX();
	//private static final int offsetY = calculateOffsetY();
	
	private int calculateOffsetX() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		return theme.getPrimaryMargin();
	}
	
	private int calculateOffsetY() {
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(feature.getGroupMembership(), date);
		
		boolean hasModifier = false;
		if(composition != null){
			HyGroupType type = HyEvolutionUtil.getValidTemporalElement(composition.getCompositionOf().getTypes(), date);
			hasModifier = (type.getType() == HyGroupTypeEnum.AND);
		}
		
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		return (hasModifier ? theme.getFeatureVariationTypeExtent() : 0) + theme.getFeatureNameAreaHeight() + theme.getPrimaryMargin();
	}
	
	
	/*
	public static int getOffsetX() {
		return offsetX;
	}

	public static int getOffsetY() {
		return offsetY;
	}
	*/

	public DwVersionTreeLayouter(HyFeature feature, Date date) {
		this.feature = feature;
		this.date = date;
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		HyVersion initialVersion = DwVersionUtil.getRootVersion(feature, date);
		
		TreeForTreeLayout<HyVersion> tree = new DwVersionTreeForTreeLayout(initialVersion, date);
		DwVersionNodeExtentProvider extentProvider = new DwVersionNodeExtentProvider();

		DefaultConfiguration<HyVersion> configuration = new DefaultConfiguration<HyVersion>(theme.getVersionExtentX(), theme.getVersionExtentY()) {
			@Override
			public Location getRootLocation() {
				return Location.Left;
			}
		};
		
		treeLayout = new TreeLayout<HyVersion>(tree, extentProvider, configuration);
	}

	/**
	 * @return A point representing the upper left point of the rectangle representing the bounds.
	 */
	public Point getCoordinates(HyVersion version) {
		Rectangle2D.Double nodeBounds = getNodeBounds(version);
		
		return new Point((int) nodeBounds.getX(), (int) nodeBounds.getY());
	}

	public Rectangle getBounds(HyVersion version) {
		Rectangle2D.Double nodeBounds = getNodeBounds(version);
		return DEGeometryUtil.rectangle2DToDraw2DRectangle(nodeBounds);
	}
	
	private Rectangle2D.Double adjustNodeBounds(Rectangle2D.Double nodeBounds, HyVersion version) {
		Rectangle2D.Double adjustedNodeBounds = (Rectangle2D.Double) nodeBounds.clone();
		
		adjustedNodeBounds.x += calculateOffsetX();
		adjustedNodeBounds.y += calculateOffsetY();
		
	
		return adjustedNodeBounds;
	}

	private Rectangle2D.Double getNodeBounds(HyVersion version) {
		Map<HyVersion, Double> elements = treeLayout.getNodeBounds();
		Rectangle2D.Double nodeBounds = elements.get(version);
		
		if(nodeBounds == null){
			return new Rectangle2D.Double(0, 0, 50, 50);
		}
		return adjustNodeBounds(nodeBounds, version);
	}
	
	public Rectangle getTreeBounds() {
		Rectangle2D rawBounds = treeLayout.getBounds();
		return DEGeometryUtil.rectangle2DToDraw2DRectangle(rawBounds);
	}
	
}
