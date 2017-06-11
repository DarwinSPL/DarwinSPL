package de.darwinspl.feature.stage.base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.darwinspl.feature.stage.StageModel;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;

public class StageModelWrapped extends HyFeatureModelWrapped {

	/**
	 * The real stage Model
	 */
	protected StageModel stageModel;
	
	/**
	 * Lists to keep track of stages and roles
	 * @param model
	 */
//	protected List<RoleeWrapped> roles;
//	protected List<StageWrapped> stages;
	
	
	public StageModelWrapped(HyFeatureModel model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	public StageModelWrapped(StageModel stageModel){
		super(stageModel.getFeatureModel());		
		this.stageModel = stageModel;
		

	}

}
