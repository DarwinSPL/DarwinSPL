
package eu.hyvar.reconfigurator.io.rest.input.raw_input_for_hyvarrec;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RawInputForHyVarRec {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("constraints")
    @Expose
    private Constraints constraints;
    @SerializedName("context")
    @Expose
    private Context context;
    @SerializedName("context_model")
    @Expose
    private ContextModel contextModel;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("dependencies")
    @Expose
    private List<Dependency> dependencies = null;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("feature_model")
    @Expose
    private FeatureModel_ featureModel;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("manifest")
    @Expose
    private Manifest manifest;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("msg_type")
    @Expose
    private String msgType = "raw_hyvarrec_input";
    @SerializedName("old_configuration")
    @Expose
    private OldConfiguration oldConfiguration;
    @SerializedName("partial_configuration")
    @Expose
    private PartialConfiguration partialConfiguration;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("spl_id")
    @Expose
    private String splId;
    @SerializedName("validity_formulas")
    @Expose
    private ValidityFormulas_ validityFormulas;

    /**
     * 
     * (Required)
     * 
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setDate(String date) {
        this.date = date;
    }

    public Constraints getConstraints() {
        return constraints;
    }

    public void setConstraints(Constraints constraints) {
        this.constraints = constraints;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ContextModel getContextModel() {
        return contextModel;
    }

    public void setContextModel(ContextModel contextModel) {
        this.contextModel = contextModel;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<Dependency> getDependencies() {
        return dependencies;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setDependencies(List<Dependency> dependencies) {
        this.dependencies = dependencies;
    }

    /**
     * 
     * (Required)
     * 
     */
    public FeatureModel_ getFeatureModel() {
        return featureModel;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setFeatureModel(FeatureModel_ featureModel) {
        this.featureModel = featureModel;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Manifest getManifest() {
        return manifest;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setManifest(Manifest manifest) {
        this.manifest = manifest;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public OldConfiguration getOldConfiguration() {
        return oldConfiguration;
    }

    public void setOldConfiguration(OldConfiguration oldConfiguration) {
        this.oldConfiguration = oldConfiguration;
    }

    public PartialConfiguration getPartialConfiguration() {
        return partialConfiguration;
    }

    public void setPartialConfiguration(PartialConfiguration partialConfiguration) {
        this.partialConfiguration = partialConfiguration;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getSplId() {
        return splId;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSplId(String splId) {
        this.splId = splId;
    }

    public ValidityFormulas_ getValidityFormulas() {
        return validityFormulas;
    }

    public void setValidityFormulas(ValidityFormulas_ validityFormulas) {
        this.validityFormulas = validityFormulas;
    }

}
