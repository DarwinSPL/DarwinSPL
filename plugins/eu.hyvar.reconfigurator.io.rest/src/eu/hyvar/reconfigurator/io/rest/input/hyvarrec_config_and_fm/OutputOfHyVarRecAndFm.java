
package eu.hyvar.reconfigurator.io.rest.input.hyvarrec_config_and_fm;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Deprecated
//Use instead: eu.hyvar.reconfigurator.io.rest.input.hyvarrec_config.HyVarRecConfig
public class OutputOfHyVarRecAndFm {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("msg_type")
    @Expose
    private String msgType;
    /**
     * list representing which features are selected
     * (Required)
     * 
     */
    @SerializedName("features")
    @Expose
    private List<String> features = null;
    /**
     * list representing the values of the attributes
     * (Required)
     * 
     */
    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes = null;
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
     *     The msgType
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * 
     * (Required)
     * 
     * @param msgType
     *     The msg_type
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * list representing which features are selected
     * (Required)
     * 
     * @return
     *     The features
     */
    public List<String> getFeatures() {
        return features;
    }

    /**
     * list representing which features are selected
     * (Required)
     * 
     * @param features
     *     The features
     */
    public void setFeatures(List<String> features) {
        this.features = features;
    }

    /**
     * list representing the values of the attributes
     * (Required)
     * 
     * @return
     *     The attributes
     */
    public List<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * list representing the values of the attributes
     * (Required)
     * 
     * @param attributes
     *     The attributes
     */
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
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
