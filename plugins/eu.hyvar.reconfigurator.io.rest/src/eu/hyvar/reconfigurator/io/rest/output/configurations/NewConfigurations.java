
package eu.hyvar.reconfigurator.io.rest.output.configurations;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewConfigurations {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("configuration")
    @Expose
    private Configuration configuration;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("msg_type")
    @Expose
    private String msgType = "configuration";
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("signature_configurations")
    @Expose
    private List<SignatureConfiguration> signatureConfigurations = null;
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
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
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
    public List<SignatureConfiguration> getSignatureConfigurations() {
        return signatureConfigurations;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSignatureConfigurations(List<SignatureConfiguration> signatureConfigurations) {
        this.signatureConfigurations = signatureConfigurations;
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
