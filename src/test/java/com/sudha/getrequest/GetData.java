package com.sudha.getrequest;
//import com.jayway.restassured.RestAssured;
//import com.jayway.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class GetData {

   /** @Test

    public void testResponseCode(){

       Response resp = RestAssured.get("http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=d1ed04867d9714f64e92b41a0bd707b8");

       int code = resp.getStatusCode();

       System.out.println(" Status code is "+ code);

        Assert.assertEquals(code, 200);


    }

    @Test
    public void testBody(){
        Response resp = RestAssured.get("http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=d1ed04867d9714f64e92b41a0bd707b8");

        String data = resp.asString();

        System.out.println(" Data is \n"+ data);

        System.out.println(" response time is \n"+resp.getTimeIn(TimeUnit.SECONDS));


    }--**/
}
