
package eu.hyvar.feature.exporter.hfm_exporter.rest.dummyclient.answer;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * feature model
 * 
 */
@Generated("org.jsonschema2pojo")
public class FeatureModel {

    /**
     * name of the feature model
     * 
     */
    @SerializedName("name")
    @Expose
    private String name;
    /**
     * content of the feature model
     * 
     */
    @SerializedName("content")
    @Expose
    private String content;

    /**
     * name of the feature model
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * name of the feature model
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * content of the feature model
     * 
     * @return
     *     The content
     */
    public String getContent() {
        return content;
    }

    /**
     * content of the feature model
     * 
     * @param content
     *     The content
     */
    public void setContent(String content) {
        this.content = content;
    }

}
