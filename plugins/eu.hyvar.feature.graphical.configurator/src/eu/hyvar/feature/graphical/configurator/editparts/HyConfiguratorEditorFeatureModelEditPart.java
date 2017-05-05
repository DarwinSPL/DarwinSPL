package eu.hyvar.feature.graphical.configurator.editparts;

import org.eclipse.gef.EditPart;

import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyEnumEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyParentChildConnectionEditPart;

public class HyConfiguratorEditorFeatureModelEditPart extends HyConfiguratorFeatureModelEditPart{
	public HyConfiguratorEditorFeatureModelEditPart(DwGraphicalFeatureModelViewer editor) {
		super(editor);
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
