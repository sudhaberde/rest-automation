package com.sudha.wsautomation.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Header {

    @Expose
    private String header;

    //@Expose
    private String value;
    private boolean result;
    private String description;

    @SerializedName("match-type")
    @Expose
    private String matchType;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    @Override
    public String toString() {
        return "Header{" +
                "header='" + header + '\'' +
                ", value='" + value + '\'' +
                ", result=" + result +
                ", description='" + description + '\'' +
                ", matchType='" + matchType + '\'' +
                '}';
    }
}