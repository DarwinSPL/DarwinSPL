
package eu.hyvar.reconfigurator.io.rest.input.raw_hyvarrec;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Deprecated
@Generated("org.jsonschema2pojo")
public class RawInputForHyVarRecOld {

    @SerializedName("msg_type")
    @Expose
    private String msgType;
    @SerializedName("feature_model")
    @Expose
    private FeatureModel featureModel;
    @SerializedName("constraints")
    @Expose
    private Constraints constraints;
    @SerializedName("context_model")
    @Expose
    private ContextModel contextModel;
    @SerializedName("validity_formulas")
    @Expose
    private ValidityFormulas validityFormulas;
    @SerializedName("configuration")
    @Expose
    private Configuration configuration;
    /**
     * 
     */
    @SerializedName("context")
    @Expose
    private Context context;

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
     *     The featureModel
     */
    public FeatureModel getFeatureModel() {
        return featureModel;
    }

    /**
     * 
     * @param featureModel
     *     The feature_model
     */
    public void setFeatureModel(FeatureModel featureModel) {
        this.featureModel = featureModel;
    }

    /**
     * 
     * @return
     *     The constraints
     */
    public Constraints getConstraints() {
        return constraints;
    }

    /**
     * 
     * @param constraints
     *     The constraints
     */
    public void setConstraints(Constraints constraints) {
        this.constraints = constraints;
    }

    /**
     * 
     * @return
     *     The contextModel
     */
    public ContextModel getContextModel() {
        return contextModel;
    }

    /**
     * 
     * @param contextModel
     *     The context_model
     */
    public void setContextModel(ContextModel contextModel) {
        this.contextModel = contextModel;
    }

    /**
     * 
     * @return
     *     The validityFormulas
     */
    public ValidityFormulas getValidityFormulas() {
        return validityFormulas;
    }

    /**
     * 
     * @param validityFormulas
     *     The validity_formulas
     */
    public void setValidityFormulas(ValidityFormulas validityFormulas) {
        this.validityFormulas = validityFormulas;
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

    /**
     * 
     * @return
     *     The context
     */
    public Context getContext() {
        return context;
    }

    /**
     * 
     * @param context
     *     The context
     */
    public void setContext(Context context) {
        this.context = context;
    }

}
