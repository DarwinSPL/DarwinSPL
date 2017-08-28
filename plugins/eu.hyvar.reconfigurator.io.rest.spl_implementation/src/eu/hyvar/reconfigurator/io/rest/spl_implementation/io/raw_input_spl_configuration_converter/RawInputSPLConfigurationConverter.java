
package eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_input_spl_configuration_converter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RawInputSPLConfigurationConverter {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("msg_type")
    @Expose
    private String msgType = "translate_signature_configuration";
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
    @SerializedName("spl_id")
    @Expose
    private String splId;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("spl_manifest")
    @Expose
    private SplManifest splManifest;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("spl_feature_model")
    @Expose
    private SplFeatureModel splFeatureModel;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("signature_id")
    @Expose
    private String signatureId;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("signature_manifest")
    @Expose
    private SignatureManifest signatureManifest;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("signature_feature_model")
    @Expose
    private SignatureFeatureModel signatureFeatureModel;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("signature_configuration")
    @Expose
    private SignatureConfiguration signatureConfiguration;

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

    /**
     * 
     * (Required)
     * 
     */
    public SplManifest getSplManifest() {
        return splManifest;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSplManifest(SplManifest splManifest) {
        this.splManifest = splManifest;
    }

    /**
     * 
     * (Required)
     * 
     */
    public SplFeatureModel getSplFeatureModel() {
        return splFeatureModel;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSplFeatureModel(SplFeatureModel splFeatureModel) {
        this.splFeatureModel = splFeatureModel;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getSignatureId() {
        return signatureId;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSignatureId(String signatureId) {
        this.signatureId = signatureId;
    }

    /**
     * 
     * (Required)
     * 
     */
    public SignatureManifest getSignatureManifest() {
        return signatureManifest;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSignatureManifest(SignatureManifest signatureManifest) {
        this.signatureManifest = signatureManifest;
    }

    /**
     * 
     * (Required)
     * 
     */
    public SignatureFeatureModel getSignatureFeatureModel() {
        return signatureFeatureModel;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSignatureFeatureModel(SignatureFeatureModel signatureFeatureModel) {
        this.signatureFeatureModel = signatureFeatureModel;
    }

    /**
     * 
     * (Required)
     * 
     */
    public SignatureConfiguration getSignatureConfiguration() {
        return signatureConfiguration;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSignatureConfiguration(SignatureConfiguration signatureConfiguration) {
        this.signatureConfiguration = signatureConfiguration;
    }

}
