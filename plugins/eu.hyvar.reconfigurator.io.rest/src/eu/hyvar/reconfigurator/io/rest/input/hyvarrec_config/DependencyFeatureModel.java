
package eu.hyvar.reconfigurator.io.rest.input.hyvarrec_config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DependencyFeatureModel {

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
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

}
