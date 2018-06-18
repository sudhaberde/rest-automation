package com.sudha.wsautomation.httpclient;

import com.sudha.wsautomation.model.Header;
import com.sudha.wsautomation.model.Param;
import com.sudha.wsautomation.model.Test;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class HttpClientImpl implements HttpClient {


    @Override
    public HttpResponse execute(Test test) throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpRequestBase req = createHttpRequest(test, createUrl(test));
        addHeaders(test,req);
        return client.execute(req);
    }

    private String createUrl(Test test) {
        StringBuilder sb = new StringBuilder();
        sb.append(test.getProtocol());
        sb.append("://");
        sb.append(test.getHost());
        sb.append(":");
        sb.append(test.getPort());
        sb.append("/");
        sb.append(test.getPath());

        try {
            URIBuilder uriBuilder = new URIBuilder(sb.toString());
            addParams(test, uriBuilder);
            return uriBuilder.build().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Not a valid URI");
    }

    private HttpRequestBase createHttpRequest(Test test, String url) throws UnsupportedEncodingException {
        switch (test.getMethod()){
            case "GET":
                return new HttpGet(url);

            case "POST":
                HttpPost postRequest= new HttpPost(url);
                postRequest.setEntity(new StringEntity(test.getInput().getBody()));
                return postRequest;

            case "PUT":
                HttpPut putRequest= new HttpPut(url);
                putRequest.setEntity(new StringEntity(test.getInput().getBody()));
                return putRequest;

            case "DELETE":
                return new HttpDelete(url);

            default:
                throw new RuntimeException("Method not Supported");
        }

    }

    private void addParams(Test test, URIBuilder uriBuilder) {
        for(Param param: test.getInput().getParams()){
            uriBuilder.addParameter(param.getParam(), param.getValue());
        }
    }

    private void addHeaders(Test test, HttpRequestBase request) {
        for(Header header: test.getInput().getHeaders()){
            request.addHeader(header.getHeader(), header.getValue());
        }
    }
}
