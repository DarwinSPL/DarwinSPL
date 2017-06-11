package de.darwinspl.feature.stage.impl.custom;


import de.darwinspl.feature.stage.Role;
import de.darwinspl.feature.stage.RoleInclusion;
import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feature.stage.StageComposition;
import de.darwinspl.feature.stage.StageFactory;
import de.darwinspl.feature.stage.impl.StageFactoryImpl;


public class StageModelFactoryWithIds extends StageFactoryImpl {

	public static StageFactory eINSTANCE = StageModelFactoryWithIds.init();
	
	public static StageFactory init() {
		StageFactory stageFactory = StageFactoryImpl.init();
		if(!(stageFactory instanceof StageModelFactoryWithIds)) {
			stageFactory = new StageModelFactoryWithIds();
		}
		return stageFactory;
	}
	
	@Override
	public Role createRole() {
		Role role = super.createRole();
		role.createId();
		return role;
	}
	
	@Override
	public RoleInclusion createRoleInclusion() {
		RoleInclusion roleInclusion = super.createRoleInclusion();
		roleInclusion.createId();
		return roleInclusion;
	}
	
	@Override
	public Stage createStage() {
		Stage stage = super.createStage();
		stage.createId();
		return stage;
	}
	
	@Override
	public StageComposition createStageComposition() {
		StageComposition stageComposition = super.createStageComposition();
		stageComposition.createId();
		return stageComposition;
	}	
	
}
