package eu.hyvar.feature.graphical.configurator.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;

import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyEnumEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureModelEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyParentChildConnectionEditPart;
import eu.hyvar.feature.graphical.configurator.editor.HyFeatureModelDeltaModuleConfiguratorEditor;
import eu.hyvar.feature.graphical.configurator.figures.HyConfiguratorFeatureModelFigure;

public class HyConfiguratorFeatureModelEditPart extends HyFeatureModelEditPart{
	public HyConfiguratorFeatureModelEditPart(HyGraphicalFeatureModelViewer editor) {
		super(editor);
	}

	@Override
	protected IFigure createFigure() {
	    return new HyConfiguratorFeatureModelFigure(editor.getModelWrapped(), (HyFeatureModelDeltaModuleConfiguratorEditor)editor);
	}
	
	@Override
	public void refresh(){
		super.refresh();
		
		for(Object child : this.getChildren()){
			if(child instanceof HyParentChildConnectionEditPart)
				((EditPart)child).refresh();
			if(child instanceof HyFeatureEditPart){
				((EditPart)child).refresh();
			}
			if(child instanceof HyEnumEditPart){
				((EditPart)child).refresh();
			}
		}	
	}
}
