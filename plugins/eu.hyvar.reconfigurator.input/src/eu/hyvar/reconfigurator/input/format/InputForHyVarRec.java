
package eu.hyvar.reconfigurator.input.format;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class InputForHyVarRec {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("attributes")
    private List<Attribute> attributes = null;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("contexts")
    private List<Context> contexts = null;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("configuration")
    private Configuration configuration;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("constraints")
    private List<String> constraints = null;
    /**
     * list of expression to minimize
     * (Required)
     * 
     */
    @SerializedName("preferences")
    private List<String> preferences = null;
//    /**
//     * constraints given in smt format (faster to parse)
//     * 
//     */
//    @SerializedName("smt_constraints")
//    @Expose
//    private SmtConstraints smtConstraints;
    @SerializedName("context_constraints")
    private List<String> context_constraints = null;
    /**
     * Map or the optional feature ids with a list representing their time validity if there is evolution, empty list otherwise.
     * 
     */
    @SerializedName("optional_features")
    private Map<String, List<List<Integer>>> optional_features;
    /**
     * Optional filed used to indicate in case there is evolution which context id represent the time.
     * 
     */
    @SerializedName("time_context")
    private String time_context;
    
    /**
     * Optional filed used to set options for hyvarrec.
     * 
     */
    @SerializedName("hyvar_options")
    private List<String> hyvar_options;

    /**
     * 
     * (Required)
     * 
     */
    public List<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<Context> getContexts() {
        return contexts;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setContexts(List<Context> contexts) {
        this.contexts = contexts;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<String> getConstraints() {
        return constraints;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setConstraints(List<String> constraints) {
        this.constraints = constraints;
    }

    /**
     * list of expression to minimize
     * (Required)
     * 
     */
    public List<String> getPreferences() {
        return preferences;
    }

    /**
     * list of expression to minimize
     * (Required)
     * 
     */
    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

//    /**
//     * constraints given in smt format (faster to parse)
//     * 
//     */
//    public SmtConstraints getSmtConstraints() {
//        return smtConstraints;
//    }
//
//    /**
//     * constraints given in smt format (faster to parse)
//     * 
//     */
//    public void setSmtConstraints(SmtConstraints smtConstraints) {
//        this.smtConstraints = smtConstraints;
//    }

    public List<String> getContext_constraints() {
        return context_constraints;
    }

    public void setContext_constraints(List<String> context_constraints) {
        this.context_constraints = context_constraints;
    }

    /**
     * Map or the optional feature ids with a list representing their time validity if there is evolution, empty list otherwise.
     * 
     */
    public Map<String, List<List<Integer>>> getOptional_features() {
        return optional_features;
    }

    /**
     * Map or the optional feature ids with a list representing their time validity if there is evolution, empty list otherwise.
     * 
     */
    public void setOptional_features(Map<String, List<List<Integer>>> optional_features) {
        this.optional_features = optional_features;
    }

    /**
     * Optional filed used to indicate in case there is evolution which context id represent the time.
     * 
     */
    public String getTime_context() {
        return time_context;
    }

    /**
     * Optional filed used to indicate in case there is evolution which context id represent the time.
     * 
     */
    public void setTime_context(String time_context) {
        this.time_context = time_context;
    }

    /**
     * Optional filed used to set options for hyvarrec.
     * 
     */
	public List<String> getHyvar_options() {
		return hyvar_options;
	}

    /**
     * Optional filed used to set options for hyvarrec.
     * 
     */
	public void setHyvar_options(List<String> hyvar_options) {
		this.hyvar_options = hyvar_options;
	}

    
}
