
package eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_output_spl_configuration_converter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RawOutputSPLConfigurationConverter {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("msg_type")
    @Expose
    private String msgType = "translated_spl_configuration";
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
    @SerializedName("configuration")
    @Expose
    private Configuration configuration;

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

}
