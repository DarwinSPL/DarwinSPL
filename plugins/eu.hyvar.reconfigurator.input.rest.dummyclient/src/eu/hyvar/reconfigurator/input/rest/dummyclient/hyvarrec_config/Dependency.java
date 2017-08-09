
package eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dependency {

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

}
