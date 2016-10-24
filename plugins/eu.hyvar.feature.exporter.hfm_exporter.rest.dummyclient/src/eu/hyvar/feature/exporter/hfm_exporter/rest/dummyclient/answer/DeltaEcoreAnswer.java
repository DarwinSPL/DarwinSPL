
package eu.hyvar.feature.exporter.hfm_exporter.rest.dummyclient.answer;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 *  Feature Model, Mapping, Configuration
 * 
 */
@Generated("org.jsonschema2pojo")
public class DeltaEcoreAnswer {

    /**
     * type of message
     * 
     */
    @SerializedName("msg_type")
    @Expose
    private String msgType;
    /**
     * feature model
     * 
     */
    @SerializedName("featureModel")
    @Expose
    private FeatureModel featureModel;
    /**
     * mapping of delta modules to features
     * 
     */
    @SerializedName("mapping")
    @Expose
    private Mapping mapping;
    /**
     * configuration
     * 
     */
    @SerializedName("configuration")
    @Expose
    private Configuration configuration;

    /**
     * type of message
     * 
     * @return
     *     The msgType
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * type of message
     * 
     * @param msgType
     *     The msg_type
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * feature model
     * 
     * @return
     *     The featureModel
     */
    public FeatureModel getFeatureModel() {
        return featureModel;
    }

    /**
     * feature model
     * 
     * @param featureModel
     *     The featureModel
     */
    public void setFeatureModel(FeatureModel featureModel) {
        this.featureModel = featureModel;
    }

    /**
     * mapping of delta modules to features
     * 
     * @return
     *     The mapping
     */
    public Mapping getMapping() {
        return mapping;
    }

    /**
     * mapping of delta modules to features
     * 
     * @param mapping
     *     The mapping
     */
    public void setMapping(Mapping mapping) {
        this.mapping = mapping;
    }

    /**
     * configuration
     * 
     * @return
     *     The configuration
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * configuration
     * 
     * @param configuration
     *     The configuration
     */
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

}
