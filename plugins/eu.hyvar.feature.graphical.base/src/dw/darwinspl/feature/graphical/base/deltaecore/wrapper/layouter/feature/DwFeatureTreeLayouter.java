package dw.darwinspl.feature.graphical.base.deltaecore.wrapper.layouter.feature;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Map;

import org.abego.treelayout.TreeForTreeLayout;
import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.util.DefaultConfiguration;
import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGeometryUtil;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import dw.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import eu.hyvar.feature.HyFeature;

public class DwFeatureTreeLayouter {
	private TreeLayout<HyFeature> treeLayout;
	
	private static final int offsetX = calculateOffsetX();
	private static final int offsetY = calculateOffsetY();
	
	private static int calculateOffsetX() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		return theme.getPrimaryMargin();
	}
	
	/**
	 * Returns the vertical offset from top window position to feature model.
	 * @return
	 */
	private static int calculateOffsetY() {
		return 100; //theme.getFeatureVariationTypeExtent() + theme.getFeatureNameAreaHeight() + theme.getPrimaryMargin();
	}
	
	public DwFeatureTreeLayouter(DwFeatureModelWrapped featureModel) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		HyFeature initialVersion = featureModel.getModel().getRootFeature().get(0).getFeature();
		
		
		TreeForTreeLayout<HyFeature> tree = new DwFeatureTreeForTreeLayout(initialVersion, featureModel.getSelectedDate());
		DwFeatureNodeExtentProvider extentProvider = new DwFeatureNodeExtentProvider(featureModel);

		DefaultConfiguration<HyFeature> configuration = new DefaultConfiguration<HyFeature>(theme.getFeatureExtentY()*1.5, theme.getFeatureExtentX()) {
			@Override
			public Location getRootLocation() {
				return Location.Top;
			}
			
			@Override
			public AlignmentInLevel getAlignmentInLevel(){
				return AlignmentInLevel.TowardsRoot;
			}
		};
		
		treeLayout = new TreeLayout<HyFeature>(tree, extentProvider, configuration);
	}

	/**
	 * @return A point representing the upper left point of the rectangle representing the bounds.
	 */
	public Point getCoordinates(HyFeature feature) {
		Rectangle2D.Double nodeBounds = getNodeBounds(feature);
		
		return new Point((int) nodeBounds.getX(), (int) nodeBounds.getY());
	}

	public Rectangle getBounds(HyFeature feature) {
		
		Rectangle2D.Double nodeBounds = getNodeBounds(feature);
		
		try{
			Rectangle result = DEGeometryUtil.rectangle2DToDraw2DRectangle(nodeBounds);
			return result;
		}catch(NullPointerException e){
			e.printStackTrace();
		}

		return null;
	}
	
	private Rectangle2D.Double adjustNodeBounds(Rectangle2D.Double nodeBounds, HyFeature feature) {

		try{
			Rectangle2D.Double adjustedNodeBounds = (Rectangle2D.Double) nodeBounds.clone();
	
			adjustedNodeBounds.x += offsetX;
			adjustedNodeBounds.y += offsetY;
			
			return adjustedNodeBounds;
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		

		return null;
	}

	private Rectangle2D.Double getNodeBounds(HyFeature feature) {
		Map<HyFeature, Double> elements = treeLayout.getNodeBounds();
		Rectangle2D.Double nodeBounds = elements.get(feature);
		
		return adjustNodeBounds(nodeBounds, feature);
	}
	

	
}
