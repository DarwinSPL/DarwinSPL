package dw.darwinspl.feature.graphical.base.figures;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.figures.shapes.DETriangleShape;
import org.deltaecore.feature.graphical.base.util.DEGeometryUtil;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

import eu.hyvar.feature.HyVersion;


public class DwVersionFigure extends Figure{
	private ConnectionAnchor connectionAnchor;

	private HyVersion version;

	private DETriangleShape triangle;
	private Label label;

	public DwVersionFigure(HyVersion version){
		this.version = version;

		setLayoutManager(new XYLayout());

		createChildFigures();
		update();
	}


	private void createChildFigures() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		triangle = new DETriangleShape();
		triangle.setSize(theme.getVersionTriangleEdgeLength(), theme.getVersionTriangleEdgeLength());
		add(triangle);

		label = new Label();
		label.setLabelAlignment(PositionConstants.CENTER);
		label.setFont(theme.getVersionFont());
		label.setForegroundColor(theme.getVersionFontColor());
		add(label);
	}

	@Override
	protected boolean useLocalCoordinates() {
		return true;
	}

	//@Override
	public void update() {
		updateContent();
		resizeToContent();
	}


	private void updateContent() {
		String number = version.getNumber();
		label.setText(number);
	}

	/*
	 *  Copied from DEGeometryUtil
	 *  Change DEGeometryUtil from DEVersion to String/Integer
	 */	
	public static int calculateVersionWidth(String number) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		int labelWidth = DEGeometryUtil.getTextWidth(number, theme.getVersionFont());
		int triangleWidth = theme.getVersionTriangleEdgeLength();
		return Math.max(labelWidth, triangleWidth) + 2 * theme.getSecondaryMargin();	
	}

	/*
	 *  Copied from DEGeometryUtil
	 *  Change DEGeometryUtil from DEVersion to String/Integer
	 */
	public static int calculateVersionHeight(String number) {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		int labelHeight = DEGeometryUtil.getTextHeight(number, theme.getVersionFont());
		int triangleHeight = theme.getVersionTriangleEdgeLength();
		return triangleHeight + theme.getSecondaryMargin() + labelHeight;
	}	
	private void resizeToContent() {
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		int width = calculateVersionWidth(version.getNumber());
		int height = calculateVersionHeight(version.getNumber());
		setSize(width, height);


		//Calculate position for version shape
		int versionShapeX = (width - theme.getVersionTriangleEdgeLength()) / 2;
		int versionShapeY = 0;

		triangle.setLocation(new Point(versionShapeX, versionShapeY));


		//Calculate position for label
		Dimension preferredLabelDimension = label.getPreferredSize();
		label.setSize(preferredLabelDimension);

		int labelX = (width - preferredLabelDimension.width) / 2;
		int labelY = theme.getVersionTriangleEdgeLength() + theme.getSecondaryMargin();

		label.setLocation(new Point(labelX, labelY));
	}

	public Label getLabel() {
		return label;
	}


	public ConnectionAnchor getConnectionAnchor() {
		if (connectionAnchor == null) {
			connectionAnchor = new ChopboxAnchor(this);
		}
		return connectionAnchor;
	}
}
