
package eu.hyvar.reconfigurator.input.format;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attribute {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("id")
    @Expose
    private String id;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("min")
    @Expose
    private Integer min;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("max")
    @Expose
    private Integer max;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("featureId")
    @Expose
    private String featureId;

    /**
     * 
     * (Required)
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Integer getMin() {
        return min;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setMin(Integer min) {
        this.min = min;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Integer getMax() {
        return max;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setMax(Integer max) {
        this.max = max;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getFeatureId() {
        return featureId;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

}
