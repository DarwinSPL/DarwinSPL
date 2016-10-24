
package eu.hyvar.reconfigurator.input.rest.dummyclient.answer;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Inital configuration and context infomration
 * 
 */
@Generated("org.jsonschema2pojo")
public class Configuration {

    /**
     * list representing wich features are selected
     * 
     */
    @SerializedName("selectedFeatures")
    @Expose
    private List<Integer> selectedFeatures = new ArrayList<Integer>();
    /**
     * list representing the intial values of the attributes. The values of the attributes of non selected features are set to the maximum.
     * 
     */
    @SerializedName("attributeValues")
    @Expose
    private List<Integer> attributeValues = new ArrayList<Integer>();
    /**
     * list representing the contextual values
     * 
     */
    @SerializedName("contextValues")
    @Expose
    private List<Integer> contextValues = new ArrayList<Integer>();

    /**
     * list representing wich features are selected
     * 
     * @return
     *     The selectedFeatures
     */
    public List<Integer> getSelectedFeatures() {
        return selectedFeatures;
    }

    /**
     * list representing wich features are selected
     * 
     * @param selectedFeatures
     *     The selectedFeatures
     */
    public void setSelectedFeatures(List<Integer> selectedFeatures) {
        this.selectedFeatures = selectedFeatures;
    }

    /**
     * list representing the intial values of the attributes. The values of the attributes of non selected features are set to the maximum.
     * 
     * @return
     *     The attributeValues
     */
    public List<Integer> getAttributeValues() {
        return attributeValues;
    }

    /**
     * list representing the intial values of the attributes. The values of the attributes of non selected features are set to the maximum.
     * 
     * @param attributeValues
     *     The attributeValues
     */
    public void setAttributeValues(List<Integer> attributeValues) {
        this.attributeValues = attributeValues;
    }

    /**
     * list representing the contextual values
     * 
     * @return
     *     The contextValues
     */
    public List<Integer> getContextValues() {
        return contextValues;
    }

    /**
     * list representing the contextual values
     * 
     * @param contextValues
     *     The contextValues
     */
    public void setContextValues(List<Integer> contextValues) {
        this.contextValues = contextValues;
    }

}
