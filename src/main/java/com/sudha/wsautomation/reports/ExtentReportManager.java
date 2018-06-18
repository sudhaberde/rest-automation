package com.sudha.wsautomation.reports;
import com.relevantcodes.extentreports.ExtentReports;


public class ExtentReportManager {
    public static ExtentReports extent;

    //Generates the  html report
    public static ExtentReports getInstance() {

        if (extent == null) {
            extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/test_report.html",true);
            extent.config().documentTitle("Test Report").reportHeadline("Report for Web Service tests Exceution with Field to Field Comparison");

        }
        return extent;

    }

}
