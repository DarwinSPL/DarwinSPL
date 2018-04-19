
package eu.hyvar.reconfigurator.input.format;

import com.google.gson.annotations.SerializedName;

public class Attribute {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("id")
    private String id;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("min")
    private Integer min;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("max")
    private Integer max;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("featureId")
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
