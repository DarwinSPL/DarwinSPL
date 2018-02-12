
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
    private List<AttributeValue> attribute_values = null;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("context_values")
    @Expose
    private List<ContextValue> context_values = null;

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
        return attribute_values;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setAttributeValues(List<AttributeValue> attributeValues) {
        this.attribute_values = attributeValues;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<ContextValue> getContextValues() {
        return context_values;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setContextValues(List<ContextValue> contextValues) {
        this.context_values = contextValues;
    }

}
