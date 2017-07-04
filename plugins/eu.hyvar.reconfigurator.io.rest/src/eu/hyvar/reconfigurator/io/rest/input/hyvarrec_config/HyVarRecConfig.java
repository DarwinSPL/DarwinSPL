
package eu.hyvar.reconfigurator.io.rest.input.hyvarrec_config;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HyVarRecConfig {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("date")
    @Expose
    private String date;
    /**
     * 
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
    @SerializedName("dependencies")
    @Expose
    private List<Dependency> dependencies = null;
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
     */
    @SerializedName("features")
    @Expose
    private List<String> features = null;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("manifest")
    @Expose
    private Manifest manifest;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("msg_type")
    @Expose
    private String msgType = "hyvarrec_config_plus_fm";
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("result")
    @Expose
    private String result;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("spl_id")
    @Expose
    private String splId;

    /**
     * 
     * (Required)
     * 
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<Dependency> getDependencies() {
        return dependencies;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setDependencies(List<Dependency> dependencies) {
        this.dependencies = dependencies;
    }

    /**
     * 
     * (Required)
     * 
     */
    public FeatureModel getFeatureModel() {
        return featureModel;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setFeatureModel(FeatureModel featureModel) {
        this.featureModel = featureModel;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<String> getFeatures() {
        return features;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setFeatures(List<String> features) {
        this.features = features;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Manifest getManifest() {
        return manifest;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setManifest(Manifest manifest) {
        this.manifest = manifest;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getResult() {
        return result;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getSplId() {
        return splId;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSplId(String splId) {
        this.splId = splId;
    }

}
