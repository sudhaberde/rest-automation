package com.sudha.wsautomation.model;

import java.util.List;

public class Input {

    private List<Header> headers = null;
    private List<Param> params = null;
    private String body;

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public List<Param> getParams() {
        return params;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Input{" +
                "headers=" + headers +
                ", params=" + params +
                ", body='" + body + '\'' +
                '}';
    }
}