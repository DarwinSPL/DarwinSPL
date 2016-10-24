
package eu.hyvar.reconfigurator.io.rest.input.raw_hyvarrec;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
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
    @SerializedName("lng")
    @Expose
    private String lng;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * 
     * (Required)
     * 
     * @param lat
     *     The lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * 
     * (Required)
     * 
     * @param lng
     *     The lng
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

}
