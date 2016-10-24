
package eu.hyvar.reconfigurator.input.rest.dummyclient.answer;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ContextDomain {

    /**
     * minimal value that the context can take
     * 
     */
    @SerializedName("min")
    @Expose
    private Integer min;
    /**
     * maximal value that the context can take
     * 
     */
    @SerializedName("max")
    @Expose
    private Integer max;

    /**
     * minimal value that the context can take
     * 
     * @return
     *     The min
     */
    public Integer getMin() {
        return min;
    }

    /**
     * minimal value that the context can take
     * 
     * @param min
     *     The min
     */
    public void setMin(Integer min) {
        this.min = min;
    }

    /**
     * maximal value that the context can take
     * 
     * @return
     *     The max
     */
    public Integer getMax() {
        return max;
    }

    /**
     * maximal value that the context can take
     * 
     * @param max
     *     The max
     */
    public void setMax(Integer max) {
        this.max = max;
    }

}
