package com.sudha.wsautomation.model;


public class Test {

    private String description;
    private String host;
    private Integer port;
    private String protocol;
    private String path;
    private String method;
    private Input input;
    private Output output;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "Test{" +
                "description='" + description + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", protocol='" + protocol + '\'' +
                ", path='" + path + '\'' +
                ", method='" + method + '\'' +
                ", input=" + input +
                ", output=" + output +
                '}';
    }
}