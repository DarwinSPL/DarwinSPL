
package eu.hyvar.reconfigurator.io.rest.input.hyvarrec_config;

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
