package de.darwinspl.feature.graphical.editor.commands.feature;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.gef.EditPart;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.editor.commands.DwFeatureModelEditorCommand;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;

public abstract class DwAbstractFeatureDeleteCommand extends DwFeatureModelEditorCommand{
	
	public DwAbstractFeatureDeleteCommand(DwGraphicalFeatureModelViewer viewer) {
		super(viewer);
	}

	EditPart host;
	
	protected DwFeatureWrapped feature;
	protected DwFeatureWrapped oldParent;
	protected HyFeature backupFeature;
	protected Date executionDate;
	
	protected List<HyGroupComposition> groupMemberships = new ArrayList<HyGroupComposition>();

	@Override
	public boolean canExecute() {
		return viewer.isLastDateSelected();
	}
	
	public HyFeature getRealModelFeature(HyFeature backupFeature){
		HyFeatureModel featureModel = viewer.getInternalFeatureModel();
		
		for(HyFeature feature : featureModel.getFeatures()){
			if(feature.getId().equals(backupFeature.getId())){
				return feature;
			}
		}
		
		return null;
	}	
	
	public HyGroupComposition getRealModelGroupComposition(HyGroup group, HyGroupComposition backupGroupComposition){
		for(HyGroupComposition composition : group.getParentOf()){
			if(composition.getId().equals(backupGroupComposition.getId())){
				return composition;
			}
		}
		
		return null;
	}	
	
	public HyGroup getRealModelGroup(HyGroup backupGroup){
		HyFeatureModel featureModel = viewer.getInternalFeatureModel();
		
		for(HyGroup group : featureModel.getGroups()){
			if(group.getId().equals(backupGroup.getId())){
				return group;
			}
		}
		
		return null;
	}
	
}
