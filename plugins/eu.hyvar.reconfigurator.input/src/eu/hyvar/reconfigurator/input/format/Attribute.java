
package eu.hyvar.reconfigurator.input.format;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
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
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The min
     */
    public Integer getMin() {
        return min;
    }

    /**
     * 
     * (Required)
     * 
     * @param min
     *     The min
     */
    public void setMin(Integer min) {
        this.min = min;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The max
     */
    public Integer getMax() {
        return max;
    }

    /**
     * 
     * (Required)
     * 
     * @param max
     *     The max
     */
    public void setMax(Integer max) {
        this.max = max;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The featureId
     */
    public String getFeatureId() {
        return featureId;
    }

    /**
     * 
     * (Required)
     * 
     * @param featureId
     *     The featureId
     */
    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

}
