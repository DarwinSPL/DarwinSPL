
package eu.hyvar.reconfigurator.input.rest.dummyclient.hyvar_rec_answer;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Final configuration
 * 
 */
@Generated("org.jsonschema2pojo")
public class HyVarRecAnswer {

    /**
     * list representing wich features are selected
     * (Required)
     * 
     */
    @SerializedName("selectedFeatures")
    @Expose
    private List<Integer> selectedFeatures = new ArrayList<Integer>();
    /**
     * list representing the intial values of the attributes. The values of the attributes of non selected features are set to a value within their domain.
     * (Required)
     * 
     */
    @SerializedName("attributeValues")
    @Expose
    private List<Integer> attributeValues = new ArrayList<Integer>();
    /**
     * is the solution optimal or not.
     * (Required)
     * 
     */
    @SerializedName("optimality")
    @Expose
    private Integer optimality;

    /**
     * list representing wich features are selected
     * (Required)
     * 
     * @return
     *     The selectedFeatures
     */
    public List<Integer> getSelectedFeatures() {
        return selectedFeatures;
    }

    /**
     * list representing wich features are selected
     * (Required)
     * 
     * @param selectedFeatures
     *     The selectedFeatures
     */
    public void setSelectedFeatures(List<Integer> selectedFeatures) {
        this.selectedFeatures = selectedFeatures;
    }

    /**
     * list representing the intial values of the attributes. The values of the attributes of non selected features are set to a value within their domain.
     * (Required)
     * 
     * @return
     *     The attributeValues
     */
    public List<Integer> getAttributeValues() {
        return attributeValues;
    }

    /**
     * list representing the intial values of the attributes. The values of the attributes of non selected features are set to a value within their domain.
     * (Required)
     * 
     * @param attributeValues
     *     The attributeValues
     */
    public void setAttributeValues(List<Integer> attributeValues) {
        this.attributeValues = attributeValues;
    }

    /**
     * is the solution optimal or not.
     * (Required)
     * 
     * @return
     *     The optimality
     */
    public Integer getOptimality() {
        return optimality;
    }

    /**
     * is the solution optimal or not.
     * (Required)
     * 
     * @param optimality
     *     The optimality
     */
    public void setOptimality(Integer optimality) {
        this.optimality = optimality;
    }

}
