package de.darwinspl.feature.graphical.base.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.TextFlow;

public class DwTooltipFigure extends FlowPage {

    private TextFlow message;
     
    public DwTooltipFigure() {
        setOpaque(true);
        

        setBorder( new CompoundBorder(
                new LineBorder( ColorConstants.black, 2 ),
                new MarginBorder( 12 )));
        
        message = new TextFlow();
        message.setText("");
        add(message);
        
    }
     
    @Override
    public Dimension getPreferredSize(int w, int h) {
        Dimension d = super.getPreferredSize(-1, -1);
        if (d.width > 150)
            d = super.getPreferredSize(150, -1);
        return d;
    }
     
    public void setMessage(String txt) {
        message.setText(txt);
        revalidate();
        repaint();
    }
}
