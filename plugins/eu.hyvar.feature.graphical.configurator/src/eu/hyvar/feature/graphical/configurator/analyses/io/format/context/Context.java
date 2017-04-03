
package eu.hyvar.feature.graphical.configurator.analyses.io.format.context;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Context {

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
    @SerializedName("value")
    @Expose
    private Integer value;

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
    public Integer getValue() {
        return value;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setValue(Integer value) {
        this.value = value;
    }

}
