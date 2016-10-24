
package eu.hyvar.reconfigurator.output.translation.format;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class OutputOfHyVarRec {

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

}
