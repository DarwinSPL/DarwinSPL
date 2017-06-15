
package eu.hyvar.reconfigurator.io.rest.input.raw_input_for_hyvarrec;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Context {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("lat")
    @Expose
    private String lat;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("long")
    @Expose
    private String _long;

    /**
     * 
     * (Required)
     * 
     */
    public String getLat() {
        return lat;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getLong() {
        return _long;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setLong(String _long) {
        this._long = _long;
    }

}
