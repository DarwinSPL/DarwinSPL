
package eu.hyvar.feature.exporter.hfm_exporter.rest.input;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class HyVarInput {

    @SerializedName("msg_type")
    @Expose
    private String msgType;
    @SerializedName("feature_model")
    @Expose
    private FeatureModel featureModel;
    @SerializedName("mapping")
    @Expose
    private Mapping mapping;
    @SerializedName("configuration")
    @Expose
    private Configuration configuration;

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

    /**
     * 
     * @return
     *     The mapping
     */
    public Mapping getMapping() {
        return mapping;
    }

    /**
     * 
     * @param mapping
     *     The mapping
     */
    public void setMapping(Mapping mapping) {
        this.mapping = mapping;
    }

    /**
     * 
     * @return
     *     The configuration
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * 
     * @param configuration
     *     The configuration
     */
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

}
