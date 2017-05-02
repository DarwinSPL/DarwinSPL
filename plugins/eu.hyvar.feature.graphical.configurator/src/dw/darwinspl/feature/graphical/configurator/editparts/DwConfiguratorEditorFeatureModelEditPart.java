package dw.darwinspl.feature.graphical.configurator.editparts;

import org.eclipse.gef.EditPart;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.editparts.DwEnumEditPart;
import dw.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import dw.darwinspl.feature.graphical.base.editparts.DwParentChildConnectionEditPart;
import dw.darwinspl.feature.graphical.configurator.editparts.DwConfiguratorFeatureModelEditPart;

public class DwConfiguratorEditorFeatureModelEditPart extends DwConfiguratorFeatureModelEditPart{
	public DwConfiguratorEditorFeatureModelEditPart(DwGraphicalFeatureModelViewer editor) {
		super(editor);
	}

	@Override
	public void refresh(){
		super.refresh();
						
		for(Object child : this.getChildren()){
			if(child instanceof DwParentChildConnectionEditPart)
				((EditPart)child).refresh();
			if(child instanceof DwFeatureEditPart){
				((EditPart)child).refresh();
			}
			if(child instanceof DwEnumEditPart){
				((EditPart)child).refresh();
			}
		}			
	}
}
