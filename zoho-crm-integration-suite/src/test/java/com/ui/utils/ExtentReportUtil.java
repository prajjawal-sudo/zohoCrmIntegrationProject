package com.ui.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReports(String name) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//" + name);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void setTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }

}
