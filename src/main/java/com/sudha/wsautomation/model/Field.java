package com.sudha.wsautomation.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Field {

    @Expose
    private String key;

    @SerializedName("match-type")
    @Expose
    private String matchType;

    //@Expose
    private String value;
    private boolean result;
    private String description;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Field{" +
                "key='" + key + '\'' +
                ", matchType='" + matchType + '\'' +
                ", value='" + value + '\'' +
                ", result=" + result +
                ", description='" + description + '\'' +
                '}';
    }
}