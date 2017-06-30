package de.darwinspl.feature.graphical.configurator.editparts;

import org.eclipse.gef.EditPart;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwEnumEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwParentChildConnectionEditPart;
import de.darwinspl.feature.graphical.configurator.editparts.DwConfiguratorFeatureModelEditPart;

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
