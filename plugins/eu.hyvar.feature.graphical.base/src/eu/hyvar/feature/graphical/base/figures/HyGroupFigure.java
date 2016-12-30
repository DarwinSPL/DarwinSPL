package eu.hyvar.feature.graphical.base.figures;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEDrawingUtil;
import org.deltaecore.feature.graphical.base.util.DEGeometryUtil;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;


public class HyGroupFigure extends HyAbstractFigure{

	protected Path groupTypeArc;
	protected HyGroupWrapped group;

	public HyGroupFigure(HyGraphicalFeatureModelViewer editor, HyGroupWrapped group) {
		super(editor);

		this.group = group;



		createGroupTypeArc(editor.getCurrentSelectedDate());
	}

	// copied from delta ecore DEGroupFigure
	public static Point scaleLineEndPoint(Point startPoint, Point endPoint, double targetLength) {
		double vectorX = endPoint.x - startPoint.x;
		double vectorY = endPoint.y - startPoint.y;
		double currentLength = Math.sqrt(vectorX * vectorX + vectorY * vectorY);

		double scaleFactor = targetLength / currentLength;

		double finalX = startPoint.x + scaleFactor * vectorX;
		double finalY = startPoint.y + scaleFactor * vectorY;

		return new Point((int) Math.round(finalX), (int) Math.round(finalY));
	}	

	protected void createGroupTypeArc(Date date) {
		groupTypeArc = null;
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		HashSet<HyFeatureWrapped> features = new HashSet<HyFeatureWrapped>();
		
		HyFeatureModelWrapped model = editor.getModelWrapped();
		for(HyFeature feature : group.getFeatures(date)){
			HyGroupComposition groupComposition = HyEvolutionUtil.getValidTemporalElement(group.getWrappedModelElement().getParentOf(), date);
			HyGroupComposition featureComposition = HyEvolutionUtil.getValidTemporalElement(feature.getGroupMembership(), date);
		
			if(!(groupComposition == null || featureComposition == null || (groupComposition != featureComposition))){
				features.add(model.getWrappedFeature(feature));
			}
		}


		if(features.size() > 0){
			HyFeatureWrapped firstFeature = features.iterator().next();
			HyFeatureWrapped lastFeature = firstFeature;
			Iterator<HyFeatureWrapped> it = features.iterator();
			while (it.hasNext()){
				HyFeatureWrapped currentFeature = it.next();
				if(currentFeature.getPosition(null).x < firstFeature.getPosition(null).x)
					firstFeature = currentFeature;

				if(currentFeature.getPosition(null).x > lastFeature.getPosition(null).x)
					lastFeature = currentFeature;			
			}


			Point originPoint = this.getLocation().getCopy();
			originPoint.x += this.getSize().width / 2 - theme.getLineWidth();	

			Point leftLineEndPoint = firstFeature.getPosition(null).getCopy();
			leftLineEndPoint.x+=firstFeature.getSize().width / 2;
			//leftLineEndPoint.y+=theme.getFeatureVariationTypeExtent()-4;

			Point rightLineEndPoint = lastFeature.getPosition(null).getCopy();
			rightLineEndPoint.x+=lastFeature.getSize().width / 2;
			//rightLineEndPoint.y+=theme.getFeatureVariationTypeExtent();

			Point intersectionPointOfLeftLineAndCircle = scaleLineEndPoint(originPoint, leftLineEndPoint, theme.getGroupSymbolRadius());


			int circleX = originPoint.x - theme.getGroupSymbolRadius() +1;
			int circleY = originPoint.y - theme.getGroupSymbolRadius();

			int circleWidth = 2 * theme.getGroupSymbolRadius();
			int circleHeight = 2 * theme.getGroupSymbolRadius();


			//Here is the problem: Trigonometric functions assume a Cartesian coordinate system with y coordinate extending towards the top.
			//However, drawing canvas has a Cartesian coordinate system where y extends towards the bottom.
			//Hence, coordinates have to be mirrored along the y-axis before being used as input to the trigonometric functions.



			Point mirroredOriginPoint = originPoint.getCopy();
			mirroredOriginPoint.y = -mirroredOriginPoint.y;

			Point mirroredLeftLineEndPoint = leftLineEndPoint.getCopy();
			mirroredLeftLineEndPoint.y = -mirroredLeftLineEndPoint.y;

			Point mirroredRightLineEndPoint = rightLineEndPoint.getCopy();
			mirroredRightLineEndPoint.y = -mirroredRightLineEndPoint.y;


			double rawAngle1 = DEGeometryUtil.calculateRotationAngleForLineWithEndpoints(mirroredOriginPoint, mirroredLeftLineEndPoint);
			double rawAngle2 = DEGeometryUtil.calculateRotationAngleForLineWithEndpoints(mirroredOriginPoint, mirroredRightLineEndPoint);


			float angle1 = (float) Math.toDegrees(rawAngle1);
			float angle2 = (float) Math.toDegrees(rawAngle2);


			Display display = Display.getCurrent();
			groupTypeArc = new Path(display);

			groupTypeArc.moveTo(originPoint.x, originPoint.y);
			groupTypeArc.lineTo(intersectionPointOfLeftLineAndCircle.x, intersectionPointOfLeftLineAndCircle.y);
			groupTypeArc.addArc(circleX, circleY, circleWidth, circleHeight, angle1, angle2 - angle1);
			groupTypeArc.close();
		}
	}	

	protected boolean groupTypeVisible() {
		HashSet<HyFeatureWrapped> features = group.getFeatures();

		return features.size() >= 2;
	}	

	@Override 
	public void paintFigure(Graphics graphics) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Date date = editor.getCurrentSelectedDate();

		HyFeatureWrapped parentFeatureWrapped = editor.getModelWrapped().getParentFeatureForGroup(group, date);
		if(parentFeatureWrapped == null){
			System.out.println("");
		}
		Point parentPosition = parentFeatureWrapped.getPosition(date).getCopy();
		parentPosition.y += parentFeatureWrapped.getSize().height;
		parentPosition.x += parentFeatureWrapped.getSize().width() / 2.0 - theme.getGroupSymbolRadius();

		int size = theme.getLineWidth() * 2 + theme.getGroupSymbolRadius() * 2;
		
		
		this.setBounds(new Rectangle(parentPosition, new Dimension(size, size)));

		
		
		
		HyGroup hygroup = group.getWrappedModelElement();
		boolean isAlternative = hygroup.isAlternative(date);
		boolean isAnd = hygroup.isAnd(date);
		
		
		if(!isAnd && group.getFeatures(editor.getCurrentSelectedDate()).size() > 1){
			createGroupTypeArc(date);
			//Draw group type
			if (groupTypeVisible() && groupTypeArc != null) {
				//boolean isAlternative = group.isAlternativeCardinalty(cardinality);
				Color light = isAlternative ? theme.getGroupAlternativePrimaryColor() : theme.getGroupOrPrimaryColor();
				Color dark = isAlternative ? theme.getGroupAlternativeSecondaryColor() : theme.getGroupOrSecondaryColor();

				DEDrawingUtil.gradientFillPath(graphics, groupTypeArc, light, dark);
				DEDrawingUtil.outlinePath(graphics, groupTypeArc, theme.getLineColor());
			}
		}
	}

}