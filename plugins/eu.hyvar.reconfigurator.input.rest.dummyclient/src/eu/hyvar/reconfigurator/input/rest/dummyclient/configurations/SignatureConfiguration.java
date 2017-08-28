
package eu.hyvar.reconfigurator.input.rest.dummyclient.configurations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignatureConfiguration {

    @SerializedName("signature_configuration_model")
    @Expose
    private SignatureConfigurationModel signatureConfigurationModel;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("signature_id")
    @Expose
    private String signatureId;

    public SignatureConfigurationModel getSignatureConfigurationModel() {
        return signatureConfigurationModel;
    }

    public void setSignatureConfigurationModel(SignatureConfigurationModel signatureConfigurationModel) {
        this.signatureConfigurationModel = signatureConfigurationModel;
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

}
