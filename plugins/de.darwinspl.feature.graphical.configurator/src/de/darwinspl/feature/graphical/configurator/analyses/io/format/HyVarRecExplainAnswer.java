package de.darwinspl.feature.graphical.configurator.analyses.io.format;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Final configuration
 * 
 */
public class HyVarRecExplainAnswer {

    /**
     * The result may be sat or unsat
     * (Required)
     * 
     */
    @SerializedName("result")
    @Expose
    private String result;
    /**
     * list representing which features are selected if result = sat
     * 
     */
    @SerializedName("features")
    @Expose
    private List<String> features = null;
    /**
     * list representing the values of the attributes if result = sat
     * 
     */
    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes = null;
    /**
     * list representing the constraints that causes the FM to be void
     * 
     */
    @SerializedName("constraints")
    @Expose
    private List<String> constraints = null;

    /**
     * The result may be sat or unsat
     * (Required)
     * 
     */
    public String getResult() {
        return result;
    }

    /**
     * The result may be sat or unsat
     * (Required)
     * 
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * list representing which features are selected if result = sat
     * 
     */
    public List<String> getFeatures() {
        return features;
    }

    /**
     * list representing which features are selected if result = sat
     * 
     */
    public void setFeatures(List<String> features) {
        this.features = features;
    }

    /**
     * list representing the values of the attributes if result = sat
     * 
     */
    public List<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * list representing the values of the attributes if result = sat
     * 
     */
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    /**
     * list representing the constraints that causes the FM to be void
     * 
     */
    public List<String> getConstraints() {
        return constraints;
    }

    /**
     * list representing the constraints that causes the FM to be void
     * 
     */
    public void setConstraints(List<String> constraints) {
        this.constraints = constraints;
    }

}