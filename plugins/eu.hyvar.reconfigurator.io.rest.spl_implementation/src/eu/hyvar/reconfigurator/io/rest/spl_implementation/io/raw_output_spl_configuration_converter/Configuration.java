
package eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_output_spl_configuration_converter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Configuration {

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
