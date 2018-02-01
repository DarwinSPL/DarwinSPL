
package de.darwinspl.reconfigurator.client.hyvarrec.format.check_features;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HyVarRecCheckFeaturesAnswer {

    /**
     * map of declared optional features that are dead with the time points in which are dead in case of evolution, empty list otherwise.
     * (Required)
     * 
     */
    @SerializedName("dead_features")
    @Expose
    private Object deadFeatures;
    /**
     * map of declared optional features that are false optionals with the time points in which are false optionals in case of evolution, empty list otherwise.
     * (Required)
     * 
     */
    @SerializedName("false_optionals")
    @Expose
    private Object falseOptionals;

    /**
     * map of declared optional features that are dead with the time points in which are dead in case of evolution, empty list otherwise.
     * (Required)
     * 
     */
    public Object getDeadFeatures() {
        return deadFeatures;
    }

    /**
     * map of declared optional features that are dead with the time points in which are dead in case of evolution, empty list otherwise.
     * (Required)
     * 
     */
    public void setDeadFeatures(Object deadFeatures) {
        this.deadFeatures = deadFeatures;
    }

    /**
     * map of declared optional features that are false optionals with the time points in which are false optionals in case of evolution, empty list otherwise.
     * (Required)
     * 
     */
    public Object getFalseOptionals() {
        return falseOptionals;
    }

    /**
     * map of declared optional features that are false optionals with the time points in which are false optionals in case of evolution, empty list otherwise.
     * (Required)
     * 
     */
    public void setFalseOptionals(Object falseOptionals) {
        this.falseOptionals = falseOptionals;
    }

}
