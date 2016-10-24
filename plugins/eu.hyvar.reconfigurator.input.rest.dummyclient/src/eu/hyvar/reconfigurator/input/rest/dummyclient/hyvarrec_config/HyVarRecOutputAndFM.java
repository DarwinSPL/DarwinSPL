
package eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class HyVarRecOutputAndFM {

    @SerializedName("msg_type")
    @Expose
    private String msgType;
    @SerializedName("selectedFeatures")
    @Expose
    private List<Integer> selectedFeatures = new ArrayList<Integer>();
    @SerializedName("attributeValues")
    @Expose
    private List<Integer> attributeValues = new ArrayList<Integer>();
    @SerializedName("feature_model")
    @Expose
    private FeatureModel featureModel;

    /**
     * 
     * @return
     *     The msgType
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * 
     * @param msgType
     *     The msg_type
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * 
     * @return
     *     The selectedFeatures
     */
    public List<Integer> getSelectedFeatures() {
        return selectedFeatures;
    }

    /**
     * 
     * @param selectedFeatures
     *     The selectedFeatures
     */
    public void setSelectedFeatures(List<Integer> selectedFeatures) {
        this.selectedFeatures = selectedFeatures;
    }

    /**
     * 
     * @return
     *     The attributeValues
     */
    public List<Integer> getAttributeValues() {
        return attributeValues;
    }

    /**
     * 
     * @param attributeValues
     *     The attributeValues
     */
    public void setAttributeValues(List<Integer> attributeValues) {
        this.attributeValues = attributeValues;
    }

    /**
     * 
     * @return
     *     The featureModel
     */
    public FeatureModel getFeatureModel() {
        return featureModel;
    }

    /**
     * 
     * @param featureModel
     *     The feature_model
     */
    public void setFeatureModel(FeatureModel featureModel) {
        this.featureModel = featureModel;
    }

}
