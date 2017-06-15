
package eu.hyvar.reconfigurator.io.rest.input.raw_input_for_hyvarrec;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dependency {

    @SerializedName("constraints")
    @Expose
    private Constraints_ constraints;
    @SerializedName("context_model")
    @Expose
    private ContextModel_ contextModel;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("feature_model")
    @Expose
    private FeatureModel featureModel;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("signature")
    @Expose
    private Signature signature;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("signature_id")
    @Expose
    private String signatureId;
    @SerializedName("validity_formulas")
    @Expose
    private ValidityFormulas validityFormulas;

    public Constraints_ getConstraints() {
        return constraints;
    }

    public void setConstraints(Constraints_ constraints) {
        this.constraints = constraints;
    }

    public ContextModel_ getContextModel() {
        return contextModel;
    }

    public void setContextModel(ContextModel_ contextModel) {
        this.contextModel = contextModel;
    }

    /**
     * 
     * (Required)
     * 
     */
    public FeatureModel getFeatureModel() {
        return featureModel;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setFeatureModel(FeatureModel featureModel) {
        this.featureModel = featureModel;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Signature getSignature() {
        return signature;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSignature(Signature signature) {
        this.signature = signature;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getSignatureId() {
        return signatureId;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSignatureId(String signatureId) {
        this.signatureId = signatureId;
    }

    public ValidityFormulas getValidityFormulas() {
        return validityFormulas;
    }

    public void setValidityFormulas(ValidityFormulas validityFormulas) {
        this.validityFormulas = validityFormulas;
    }

}
