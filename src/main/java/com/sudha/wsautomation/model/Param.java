package com.sudha.wsautomation.model;


public class Param {

    private String param;
    private String value;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Param{" +
                "param='" + param + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}