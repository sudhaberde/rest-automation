package com.sudha.wsautomation.manager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.wsautomation.httpclient.HttpClient;
import com.sudha.wsautomation.httpclient.HttpClientImpl;
import com.sudha.wsautomation.model.Field;
import com.sudha.wsautomation.model.Header;
import com.sudha.wsautomation.model.Test;
import com.sudha.wsautomation.reports.ExtentReportManager;
import com.sudha.wsautomation.utils.JsonParser;
import com.sudha.wsautomation.validation.ResponseValidator;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestManager {
    private ExtentReports extentReports = ExtentReportManager.getInstance();
    private ExtentTest report;


    public void runTest(String filePath) {

        HttpClient client = new HttpClientImpl();
        report = extentReports.startTest("---------- Result for test " + filePath + " --------------");
        try {
            Test test = getInput(filePath);

            //System.out.println("---------- Result for test " + filePath + " --------------");

            HttpResponse resp = client.execute(test);

            String responseStr = EntityUtils.toString(resp.getEntity(),"UTF-8");

            boolean testRes = ResponseValidator.validateResponseCode(resp, test);
           // System.out.println("Response code test result ->" + testRes);
            report.log(LogStatus.INFO,"Response code test result ->" + testRes);
            ResponseValidator.validateResponseHeaders(resp, test);
            ResponseValidator.validateResponse(responseStr, test);

            for(Header header:test.getOutput().getHeaders()){
                System.out.println(header);
                report.log(LogStatus.INFO, "Header type is = " + header.getHeader()+"\n");
                report.log(LogStatus.INFO, "Header value  is = " + header.getValue()+"\n");
                report.log(LogStatus.INFO, "Type of test done on header is =" + header.getMatchType()+"\n");
                report.log(LogStatus.INFO, "Result on the test for comparison of the headers  = " + header.isResult()+"\n");
            }
            for(Field field:test.getOutput().getFields()){
                System.out.println(field);
                report.log(LogStatus.INFO, " Field being validated is = " + field.getKey()+"\n");
                report.log(LogStatus.INFO, "Type of test done is = " + field.getMatchType()+"\n");
                report.log(LogStatus.INFO, " value in the field is =" + field.getValue()+"\n");
                report.log(LogStatus.INFO, "Result on the test done on the filed  = " + field.isResult()+"\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentReports.endTest(report);
        extentReports.flush();
    }

    public Test getInput(String filePath) throws IOException {
        return JsonParser.parseJsonFile(filePath, Test.class);
    }





}
