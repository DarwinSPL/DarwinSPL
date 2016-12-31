
package eu.hyvar.reconfigurator.input.rest.dummyclient.input_for_hyvarrec;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Configuration {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("selectedFeatures")
    @Expose
    private List<String> selectedFeatures = new ArrayList<String>();
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("attribute_values")
    @Expose
    private List<AttributeValue> attributeValues = new ArrayList<AttributeValue>();
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("context_values")
    @Expose
    private List<ContextValue> contextValues = new ArrayList<ContextValue>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The selectedFeatures
     */
    public List<String> getSelectedFeatures() {
        return selectedFeatures;
    }

    /**
     * 
     * (Required)
     * 
     * @param selectedFeatures
     *     The selectedFeatures
     */
    public void setSelectedFeatures(List<String> selectedFeatures) {
        this.selectedFeatures = selectedFeatures;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The attributeValues
     */
    public List<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    /**
     * 
     * (Required)
     * 
     * @param attributeValues
     *     The attribute_values
     */
    public void setAttributeValues(List<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The contextValues
     */
    public List<ContextValue> getContextValues() {
        return contextValues;
    }

    /**
     * 
     * (Required)
     * 
     * @param contextValues
     *     The context_values
     */
    public void setContextValues(List<ContextValue> contextValues) {
        this.contextValues = contextValues;
    }

}
