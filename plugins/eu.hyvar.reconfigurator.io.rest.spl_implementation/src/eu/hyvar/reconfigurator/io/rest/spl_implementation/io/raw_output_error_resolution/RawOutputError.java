
package eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_output_error_resolution;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RawOutputError {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("msg_type")
    @Expose
    private String msgType = "mspl_error";
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("error_string")
    @Expose
    private String errorString;

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
    public String getErrorString() {
        return errorString;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

}
