
package eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_output_spl_implementation_resolution;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RawOutputSPLImplementationResolution {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("msg_type")
    @Expose
    private String msgType = "implementation_selected";
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

}
