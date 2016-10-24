
package eu.hyvar.reconfigurator.io.rest.input.hyvarrec_config_and_fm;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class OutputOfHyVarRecAndFm {

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
    @SerializedName("feature_model")
    @Expose
    private FeatureModel featureModel;

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
     *     The featureModel
     */
    public FeatureModel getFeatureModel() {
        return featureModel;
    }

    /**
     * 
     * (Required)
     * 
     * @param featureModel
     *     The feature_model
     */
    public void setFeatureModel(FeatureModel featureModel) {
        this.featureModel = featureModel;
    }

}
