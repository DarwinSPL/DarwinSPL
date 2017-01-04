
package eu.hyvar.reconfigurator.input.rest.dummyclient.input_for_hyvarrec;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class InputForHyVarRec {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes = new ArrayList<Attribute>();
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("contexts")
    @Expose
    private List<Context> contexts = new ArrayList<Context>();
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
    private List<String> constraints = new ArrayList<String>();
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("preferences")
    @Expose
    private List<String> preferences = new ArrayList<String>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The attributes
     */
    public List<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * 
     * (Required)
     * 
     * @param attributes
     *     The attributes
     */
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The contexts
     */
    public List<Context> getContexts() {
        return contexts;
    }

    /**
     * 
     * (Required)
     * 
     * @param contexts
     *     The contexts
     */
    public void setContexts(List<Context> contexts) {
        this.contexts = contexts;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The configuration
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * 
     * (Required)
     * 
     * @param configuration
     *     The configuration
     */
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The constraints
     */
    public List<String> getConstraints() {
        return constraints;
    }

    /**
     * 
     * (Required)
     * 
     * @param constraints
     *     The constraints
     */
    public void setConstraints(List<String> constraints) {
        this.constraints = constraints;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The preferences
     */
    public List<String> getPreferences() {
        return preferences;
    }

    /**
     * 
     * (Required)
     * 
     * @param preferences
     *     The preferences
     */
    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

}
