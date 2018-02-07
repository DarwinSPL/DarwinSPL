
package eu.hyvar.reconfigurator.input.format;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Configuration {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("selectedFeatures")
    @Expose
    private List<String> selectedFeatures = null;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("attribute_values")
    @Expose
    private List<AttributeValue> attributeValues = null;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("context_values")
    @Expose
    private List<ContextValue> contextValues = null;

    /**
     * 
     * (Required)
     * 
     */
    public List<String> getSelectedFeatures() {
        return selectedFeatures;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSelectedFeatures(List<String> selectedFeatures) {
        this.selectedFeatures = selectedFeatures;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setAttributeValues(List<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<ContextValue> getContextValues() {
        return contextValues;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setContextValues(List<ContextValue> contextValues) {
        this.contextValues = contextValues;
    }

}
