package com.sudha.wsautomation.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Output {

    @SerializedName("response-code")
    @Expose
    private int responseCode;
    @Expose
    private List<Header> headers = null;
    @Expose
    private List<Field> fields = null;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Output{" +
                "responseCode=" + responseCode +
                ", headers=" + headers +
                ", fields=" + fields +
                '}';
    }
}