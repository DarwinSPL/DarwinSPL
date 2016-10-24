
package eu.hyvar.reconfigurator.input.rest.dummyclient.answer;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class InputForHyVarRec {

    /**
     * amount of features
     * (Required)
     * 
     */
    @SerializedName("amountOfFeatures")
    @Expose
    private Integer amountOfFeatures;
    /**
     * amount of contexts
     * (Required)
     * 
     */
    @SerializedName("amountOfContexts")
    @Expose
    private Integer amountOfContexts;
    /**
     * list stating the number of attributes for array. The order of the features matter.
     * (Required)
     * 
     */
    @SerializedName("attributesPerFeature")
    @Expose
    private List<Integer> attributesPerFeature = new ArrayList<Integer>();
    /**
     * list stating the domains of the attributes. Attributes are listed accodring to the feature order and then their attribute number.
     * (Required)
     * 
     */
    @SerializedName("attributeDomains")
    @Expose
    private List<AttributeDomain> attributeDomains = new ArrayList<AttributeDomain>();
    /**
     * list stating the domains of the context. The order matters.
     * (Required)
     * 
     */
    @SerializedName("contextDomains")
    @Expose
    private List<ContextDomain> contextDomains = new ArrayList<ContextDomain>();
    /**
     * Inital configuration and context infomration
     * (Required)
     * 
     */
    @SerializedName("configuration")
    @Expose
    private Configuration configuration;
    /**
     * constraint derived from the FM. Their grammar is defined in SpecificationGrammar.g4
     * (Required)
     * 
     */
    @SerializedName("constraints")
    @Expose
    private List<String> constraints = new ArrayList<String>();
    /**
     * preferences derived from the user. Their grammar is defined in SpecificationGrammar.g4
     * (Required)
     * 
     */
    @SerializedName("preferences")
    @Expose
    private List<String> preferences = new ArrayList<String>();

    /**
     * amount of features
     * (Required)
     * 
     * @return
     *     The amountOfFeatures
     */
    public Integer getAmountOfFeatures() {
        return amountOfFeatures;
    }

    /**
     * amount of features
     * (Required)
     * 
     * @param amountOfFeatures
     *     The amountOfFeatures
     */
    public void setAmountOfFeatures(Integer amountOfFeatures) {
        this.amountOfFeatures = amountOfFeatures;
    }

    /**
     * amount of contexts
     * (Required)
     * 
     * @return
     *     The amountOfContexts
     */
    public Integer getAmountOfContexts() {
        return amountOfContexts;
    }

    /**
     * amount of contexts
     * (Required)
     * 
     * @param amountOfContexts
     *     The amountOfContexts
     */
    public void setAmountOfContexts(Integer amountOfContexts) {
        this.amountOfContexts = amountOfContexts;
    }

    /**
     * list stating the number of attributes for array. The order of the features matter.
     * (Required)
     * 
     * @return
     *     The attributesPerFeature
     */
    public List<Integer> getAttributesPerFeature() {
        return attributesPerFeature;
    }

    /**
     * list stating the number of attributes for array. The order of the features matter.
     * (Required)
     * 
     * @param attributesPerFeature
     *     The attributesPerFeature
     */
    public void setAttributesPerFeature(List<Integer> attributesPerFeature) {
        this.attributesPerFeature = attributesPerFeature;
    }

    /**
     * list stating the domains of the attributes. Attributes are listed accodring to the feature order and then their attribute number.
     * (Required)
     * 
     * @return
     *     The attributeDomains
     */
    public List<AttributeDomain> getAttributeDomains() {
        return attributeDomains;
    }

    /**
     * list stating the domains of the attributes. Attributes are listed accodring to the feature order and then their attribute number.
     * (Required)
     * 
     * @param attributeDomains
     *     The attributeDomains
     */
    public void setAttributeDomains(List<AttributeDomain> attributeDomains) {
        this.attributeDomains = attributeDomains;
    }

    /**
     * list stating the domains of the context. The order matters.
     * (Required)
     * 
     * @return
     *     The contextDomains
     */
    public List<ContextDomain> getContextDomains() {
        return contextDomains;
    }

    /**
     * list stating the domains of the context. The order matters.
     * (Required)
     * 
     * @param contextDomains
     *     The contextDomains
     */
    public void setContextDomains(List<ContextDomain> contextDomains) {
        this.contextDomains = contextDomains;
    }

    /**
     * Inital configuration and context infomration
     * (Required)
     * 
     * @return
     *     The configuration
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * Inital configuration and context infomration
     * (Required)
     * 
     * @param configuration
     *     The configuration
     */
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * constraint derived from the FM. Their grammar is defined in SpecificationGrammar.g4
     * (Required)
     * 
     * @return
     *     The constraints
     */
    public List<String> getConstraints() {
        return constraints;
    }

    /**
     * constraint derived from the FM. Their grammar is defined in SpecificationGrammar.g4
     * (Required)
     * 
     * @param constraints
     *     The constraints
     */
    public void setConstraints(List<String> constraints) {
        this.constraints = constraints;
    }

    /**
     * preferences derived from the user. Their grammar is defined in SpecificationGrammar.g4
     * (Required)
     * 
     * @return
     *     The preferences
     */
    public List<String> getPreferences() {
        return preferences;
    }

    /**
     * preferences derived from the user. Their grammar is defined in SpecificationGrammar.g4
     * (Required)
     * 
     * @param preferences
     *     The preferences
     */
    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

}
