package de.darwinspl.feature.stage.base.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feature.stage.StageFactory;
import de.darwinspl.feature.stage.StageModel;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;

public class StageModelWrapped implements PropertyChangeListener  {

	/**
	 * The real stage Model
	 */
	protected StageModel stageModel;
	
	/**
	 * Lists to keep track of stages and roles
	 * @param model
	 */
//	protected List<RoleWrapped> roles;
//	protected List<StageWrapped> stages;
	
	
//	public StageModelWrapped(HyFeatureModel model) {
//		super(model);
//		// TODO Auto-generated constructor stub
//	}
	
	/**
	 * Constructor for StageModelWrapped
	 * @param stageModel
	 */
	public StageModelWrapped(StageModel stageModel){
		this.stageModel = stageModel;
		
	//	groups = new ArrayList<RoleWrapped()>;
	//	stages = new ArrayList<StageWrapped()>;

	}
	
	
	/**
	 * getter for the current stageModel
	 * @return Stage Model
	 */
	public StageModel getModel(){
		return stageModel;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Function call to create a new named Stage
	 * @param text Name for the new Stage
	 */
	public void addNewStageToModel(String text) {
		// TODO Auto-generated method stub
		Stage newStage =StageFactory.eINSTANCE.createStage();
		HyName newName =  HyEvolutionFactory.eINSTANCE.createHyName();
		newName.setName(text);		
	    newStage.getNames().add(newName);		
		stageModel.getStages().add(newStage);
	}
	
	/**
	 * Function to Remove a Stage from the Model
	 * @param stage
	 */
	public void deleteStage(Stage stage){
		stageModel.getStages().remove(stage);
	}

}
