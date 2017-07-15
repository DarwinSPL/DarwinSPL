package de.darwinspl.feature.stage.base.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.List;

import de.darwinspl.feature.stage.Role;
import de.darwinspl.feature.stage.RoleAssignment;
import de.darwinspl.feature.stage.RoleInclusion;
import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feature.stage.StageComposition;
import de.darwinspl.feature.stage.StageFactory;
import de.darwinspl.feature.stage.StageModel;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.util.HyEvolutionUtil;

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
	 * Function call to create a new named Stage and initial StageComposition
	 * @param text Name for the new Stage
	 */
	public void addNewStageToModel(String text, Date currentSelectedDate) {
		Stage newStage = StageFactory.eINSTANCE.createStage();
		StageComposition newStageComposition = StageFactory.eINSTANCE.createStageComposition();
		RoleAssignment newRoleAssignment = StageFactory.eINSTANCE.createRoleAssignment();
		HyName newName =  HyEvolutionFactory.eINSTANCE.createHyName();
		newName.setName(text);		
	    newStage.getNames().add(newName);
	    newStage.getComposition().add(newStageComposition);
	     
	    //add dates
	    newStage.getRoleAssignment().add(newRoleAssignment);
	    newStage.setValidSince(currentSelectedDate);
	    newRoleAssignment.setValidSince(currentSelectedDate);
	    newStageComposition.setValidSince(currentSelectedDate);
	    
		stageModel.getStages().add(newStage);
	}
	
	/**
	 * Function call to create a new named Role
	 * @param text Name for the new Stage
	 */
	public void addNewRoleToModel(String text, Date currentSelectedDate) {
		Role newRole =StageFactory.eINSTANCE.createRole();
		RoleInclusion newRoleInclusion = StageFactory.eINSTANCE.createRoleInclusion();
		HyName newName =  HyEvolutionFactory.eINSTANCE.createHyName();		
		newName.setName(text);		
	    newRole.getNames().add(newName);
	    newRole.getInclusions().add(newRoleInclusion);
	    
	    //add dates
	    newRole.setValidSince(currentSelectedDate);
	    newRoleInclusion.setValidSince(currentSelectedDate);
	    
		stageModel.getRoles().add(newRole);
	}
	
	/**
	 * Function call to assign Stage to Role
	 * @param selectedRole
	 * @param selectedStage
	 */
	public void assignRoleToStage(Role selectedRole, Stage selectedStage, Date currentSelectedDate){
		
		RoleAssignment currentRoleAssignment;		
		currentRoleAssignment = HyEvolutionUtil.getValidTemporalElement(selectedStage.getRoleAssignment(), currentSelectedDate);
		currentRoleAssignment.getRoles().add(selectedRole);
		
	}
	
	/**
	 * Function call to unassign Role from Stage
	 * @param selectedRole
	 * @param selectedStage
	 */
	public void unassignRoleFromStage(Role selectedRole, Stage selectedStage, Date currentSelectedDate){		
		RoleAssignment currentRoleAssignment;		
		currentRoleAssignment = HyEvolutionUtil.getValidTemporalElement(selectedStage.getRoleAssignment(), currentSelectedDate);		
		currentRoleAssignment.getRoles().remove(selectedRole);

	}
	
	
	/**
	 * Function to Remove a Stage from the Model
	 * @param stage Selected Stage
	 */
	public void deleteStage(Stage stage, Date currentSelectedDate){
		// Remove all assigned Roles
		if(stage.getValidSince().equals(currentSelectedDate)){

//			RoleAssignment currentRoleAssignment;
//			currentRoleAssignment = HyEvolutionUtil.getValidTemporalElement(stage.getRoleAssignment(), currentSelectedDate);
//			for(Role roles : currentRoleAssignment.getRoles()){
//				
//			}
			stageModel.getStages().remove(stage);
			
		}
		else if( stage.getValidSince().before(currentSelectedDate)){
			stage.setValidUntil(currentSelectedDate);
		}
		
	}
	
	/**
	 * Function to Remove a Role from the Model
	 * @param role Selected Role
	 */
	public void deleteRole(Role role, Date currentSelectedDate){
		// Remove all assigned Stages
		if(role.getValidSince().equals(currentSelectedDate)){
			stageModel.getRoles().remove(role);
//			role.getAssignedTo().clear();
		}
		else if (role.getValidSince().before(currentSelectedDate)){
			role.setValidUntil(currentSelectedDate);
		}
		
	}
	/**
	 * Function to include a role
	 *  @param role Active Role
	 *  @param role Role to be included
	 */
	public void includeRole(Role role, Role includedRole, Date currentSelectedDate){
		// TODO Alex: Add Evolution here, currently wrong
		
		RoleInclusion newInclusion;		

		if(role.getInclusions().get(0) == null){
			newInclusion = StageFactory.eINSTANCE.createRoleInclusion();	
			newInclusion.setInclusionsFor(role);
			role.getInclusions().add(newInclusion);			
		} else {

			newInclusion = HyEvolutionUtil.getValidTemporalElement(role.getInclusions(), currentSelectedDate);
		}
		
		// Add new role to inclusion reference
		newInclusion.getIncludes().add(includedRole);		
		includedRole.getIncludedBy().add(newInclusion);		

		
	}
	
	/**
	 * Function to remove Role from inclusion
	 *  @param role Active Role
	 *  @param role Role to be included
	 */
	public void unincludeRole(Role role, Role unincludedRole, Date currentSelectedDate){
		// Remove include from Role Inclusion
		RoleInclusion inclusion = HyEvolutionUtil.getValidTemporalElement(role.getInclusions(), currentSelectedDate);
		inclusion.getIncludes().remove(unincludedRole);
		
		// Remove reference to RoleInclsuion from unincludedRole
//		unincludedRole.getIncludedBy().remove(inclusion);
		
	}



}
