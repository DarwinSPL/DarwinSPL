package de.darwinspl.exporter.ui.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonFormat {

    @SerializedName("featuremodel")
    @Expose
    private JsonFeatureModel featuremodel;
    
    @SerializedName("configuration")
    @Expose
    private JsonConfiguration configuration;
	
    @SerializedName("contextmodel")
    @Expose
    private JsonContextModel contextmodel;
    
    @SerializedName("constraints")
    @Expose
    private JsonConstraintModel constraints;
    
    @SerializedName("mapping")
    @Expose
    private JsonMappingModel mapping;
    
    @SerializedName("validity")
    @Expose
    private JsonValidityModel validity;

	public JsonFeatureModel getFeaturemodel() {
		return featuremodel;
	}

	public void setFeaturemodel(JsonFeatureModel featuremodel) {
		this.featuremodel = featuremodel;
	}

	public JsonConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(JsonConfiguration configuration) {
		this.configuration = configuration;
	}

	public JsonContextModel getContextmodel() {
		return contextmodel;
	}

	public void setContextmodel(JsonContextModel contextmodel) {
		this.contextmodel = contextmodel;
	}

	public JsonConstraintModel getConstraints() {
		return constraints;
	}

	public void setConstraints(JsonConstraintModel constraints) {
		this.constraints = constraints;
	}

	public JsonMappingModel getMapping() {
		return mapping;
	}

	public void setMapping(JsonMappingModel mapping) {
		this.mapping = mapping;
	}

	public JsonValidityModel getValidity() {
		return validity;
	}

	public void setValidity(JsonValidityModel validity) {
		this.validity = validity;
	}
    
    
}
