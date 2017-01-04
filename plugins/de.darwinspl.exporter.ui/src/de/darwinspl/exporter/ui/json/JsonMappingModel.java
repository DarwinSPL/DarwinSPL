package de.darwinspl.exporter.ui.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonMappingModel {

    @SerializedName("specification")
    @Expose
    private String specification;
    
    
    /**
     * 
     * @return
     *     The specification
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * 
     * @param specification
     *     The specification
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }
	
}
