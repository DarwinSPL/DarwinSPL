
package eu.hyvar.reconfigurator.io.rest.input.hyvarrec_config_and_fm;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class FeatureModel {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("filename")
    @Expose
    private String filename;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("specification")
    @Expose
    private String specification;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 
     * (Required)
     * 
     * @param filename
     *     The filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The specification
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * 
     * (Required)
     * 
     * @param specification
     *     The specification
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

}
