
package eu.hyvar.reconfigurator.input.format;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InputForHyVarRec {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes = null;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("contexts")
    @Expose
    private List<Context> contexts = null;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("configuration")
    @Expose
    private Configuration configuration;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("constraints")
    @Expose
    private List<String> constraints = null;
    /**
     * list of expression to minimize
     * (Required)
     * 
     */
    @SerializedName("preferences")
    @Expose
    private List<String> preferences = null;
//    /**
//     * constraints given in smt format (faster to parse)
//     * 
//     */
//    @SerializedName("smt_constraints")
//    @Expose
//    private SmtConstraints smtConstraints;
    @SerializedName("context_constraints")
    @Expose
    private List<String> contextConstraints = null;
    /**
     * Map or the optional feature ids with a list representing their time validity if there is evolution, empty list otherwise.
     * 
     */
    @SerializedName("optional_features")
    @Expose
    private Map<String, List<List<Integer>>> optionalFeatures;
    /**
     * Optional filed used to indicate in case there is evolution which context id represent the time.
     * 
     */
    @SerializedName("time_context")
    @Expose
    private String timeContext;
    
    /**
     * Optional filed used to set options for hyvarrec.
     * 
     */
    @SerializedName("hyvar_options")
    @Expose
    private String hyvar_options;

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

    public List<String> getContextConstraints() {
        return contextConstraints;
    }

    public void setContextConstraints(List<String> contextConstraints) {
        this.contextConstraints = contextConstraints;
    }

    /**
     * Map or the optional feature ids with a list representing their time validity if there is evolution, empty list otherwise.
     * 
     */
    public Map<String, List<List<Integer>>> getOptionalFeatures() {
        return optionalFeatures;
    }

    /**
     * Map or the optional feature ids with a list representing their time validity if there is evolution, empty list otherwise.
     * 
     */
    public void setOptionalFeatures(Map<String, List<List<Integer>>> optionalFeatures) {
        this.optionalFeatures = optionalFeatures;
    }

    /**
     * Optional filed used to indicate in case there is evolution which context id represent the time.
     * 
     */
    public String getTimeContext() {
        return timeContext;
    }

    /**
     * Optional filed used to indicate in case there is evolution which context id represent the time.
     * 
     */
    public void setTimeContext(String timeContext) {
        this.timeContext = timeContext;
    }

    /**
     * Optional filed used to set options for hyvarrec.
     * 
     */
	public String getHyvar_options() {
		return hyvar_options;
	}

    /**
     * Optional filed used to set options for hyvarrec.
     * 
     */
	public void setHyvar_options(String hyvar_options) {
		this.hyvar_options = hyvar_options;
	}

    
}
