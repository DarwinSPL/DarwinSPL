
package eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_input_spl_implementation_resolution;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SplSignature {

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
    @SerializedName("signature_id")
    @Expose
    private String signatureId;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("signature_model")
    @Expose
    private SignatureModel signatureModel;

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
    public SignatureModel getSignatureModel() {
        return signatureModel;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSignatureModel(SignatureModel signatureModel) {
        this.signatureModel = signatureModel;
    }

}
