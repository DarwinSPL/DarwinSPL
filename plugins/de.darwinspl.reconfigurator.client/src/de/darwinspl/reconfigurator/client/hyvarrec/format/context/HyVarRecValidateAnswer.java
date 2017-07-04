package de.darwinspl.reconfigurator.client.hyvarrec.format.context;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Result of validation attempt
 * 
 */
public class HyVarRecValidateAnswer {

    /**
     * The result may be valid or not_valid
     * (Required)
     * 
     */
    @SerializedName("result")
    @Expose
    private String result;
    /**
     * Values of the context that causes FM to be void
     * 
     */
    @SerializedName("contexts")
    @Expose
    private List<Context> contexts = null;

    /**
     * The result may be valid or not_valid
     * (Required)
     * 
     */
    public String getResult() {
        return result;
    }

    /**
     * The result may be valid or not_valid
     * (Required)
     * 
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Values of the context that causes FM to be void
     * 
     */
    public List<Context> getContexts() {
        return contexts;
    }

    /**
     * Values of the context that causes FM to be void
     * 
     */
    public void setContexts(List<Context> contexts) {
        this.contexts = contexts;
    }

}