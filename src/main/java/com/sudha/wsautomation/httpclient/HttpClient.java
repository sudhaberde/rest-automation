package com.sudha.wsautomation.httpclient;

import com.sudha.wsautomation.model.Test;
import org.apache.http.HttpResponse;

import java.io.IOException;

public interface HttpClient {

   HttpResponse execute(Test test) throws IOException;
}


