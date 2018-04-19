
package eu.hyvar.reconfigurator.input.format;

import com.google.gson.annotations.SerializedName;

public class ContextValue {

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
    @SerializedName("value")
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
