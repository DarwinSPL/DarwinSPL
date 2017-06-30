
package eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_input_spl_implementation_resolution;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RawInputSPLImplementationResolution {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("msg_type")
    @Expose
    private String msgType = "implementation_selection";
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
    @SerializedName("spl_signature")
    @Expose
    private SplSignature splSignature;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("spl_implementations")
    @Expose
    private List<SplImplementation> splImplementations = null;

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
    public SplSignature getSplSignature() {
        return splSignature;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSplSignature(SplSignature splSignature) {
        this.splSignature = splSignature;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<SplImplementation> getSplImplementations() {
        return splImplementations;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSplImplementations(List<SplImplementation> splImplementations) {
        this.splImplementations = splImplementations;
    }

}
