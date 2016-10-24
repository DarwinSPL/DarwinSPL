
package eu.hyvar.feature.exporter.hfm_exporter.rest.output;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * mapping of delta modules to features
 * 
 */
@Generated("org.jsonschema2pojo")
public class Mapping {

    /**
     * name of the mapping
     * 
     */
    @SerializedName("name")
    @Expose
    private String name;
    /**
     * content of the mapping
     * 
     */
    @SerializedName("content")
    @Expose
    private String content;

    /**
     * name of the mapping
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * name of the mapping
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * content of the mapping
     * 
     * @return
     *     The content
     */
    public String getContent() {
        return content;
    }

    /**
     * content of the mapping
     * 
     * @param content
     *     The content
     */
    public void setContent(String content) {
        this.content = content;
    }

}
