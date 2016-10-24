
package eu.hyvar.reconfigurator.io.rest.hyconfiguration;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class HyConfigurationJson {

    @SerializedName("msg_type")
    @Expose
    private String msgType;
    @SerializedName("configuration")
    @Expose
    private Configuration configuration;

    /**
     * 
     * @return
     *     The msgType
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * 
     * @param msgType
     *     The msg_type
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * 
     * @return
     *     The configuration
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * 
     * @param configuration
     *     The configuration
     */
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

}
