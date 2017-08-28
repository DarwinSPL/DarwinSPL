
package eu.hyvar.reconfigurator.input.rest.dummyclient.raw_input_for_hyvarrec;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dependency {

    @SerializedName("dependency_constraints")
    @Expose
    private DependencyConstraints dependencyConstraints;
    @SerializedName("dependency_context_model")
    @Expose
    private DependencyContextModel dependencyContextModel;
    @SerializedName("dependency_feature_model")
    @Expose
    private DependencyFeatureModel dependencyFeatureModel;
    @SerializedName("dependency_signature")
    @Expose
    private DependencySignature dependencySignature;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("signature_id")
    @Expose
    private String signatureId;
    @SerializedName("dependency_validity_formulas")
    @Expose
    private DependencyValidityFormulas dependencyValidityFormulas;

    public DependencyConstraints getDependencyConstraints() {
        return dependencyConstraints;
    }

    public void setDependencyConstraints(DependencyConstraints dependencyConstraints) {
        this.dependencyConstraints = dependencyConstraints;
    }

    public DependencyContextModel getDependencyContextModel() {
        return dependencyContextModel;
    }

    public void setDependencyContextModel(DependencyContextModel dependencyContextModel) {
        this.dependencyContextModel = dependencyContextModel;
    }

    public DependencyFeatureModel getDependencyFeatureModel() {
        return dependencyFeatureModel;
    }

    public void setDependencyFeatureModel(DependencyFeatureModel dependencyFeatureModel) {
        this.dependencyFeatureModel = dependencyFeatureModel;
    }

    public DependencySignature getDependencySignature() {
        return dependencySignature;
    }

    public void setDependencySignature(DependencySignature dependencySignature) {
        this.dependencySignature = dependencySignature;
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

    public DependencyValidityFormulas getDependencyValidityFormulas() {
        return dependencyValidityFormulas;
    }

    public void setDependencyValidityFormulas(DependencyValidityFormulas dependencyValidityFormulas) {
        this.dependencyValidityFormulas = dependencyValidityFormulas;
    }

}
