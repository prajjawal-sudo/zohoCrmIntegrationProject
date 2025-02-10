package com.ui.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ui.base.BaseTest;
import com.ui.utils.BrowserUtil;
import com.ui.utils.ExtentReportUtil;
import com.ui.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    private static Logger logger = LoggerUtil.getLogger(TestListeners.class);

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        logger.info("TEST SUITE STARTED");
        ExtentReportUtil.initReports("zoho-test-report.html");

    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        logger.info("TEST SUITE FINISHED");
        ExtentReportUtil.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        logger.info("TEST CASES STARTED : ",result.getMethod().getMethodName());
        ExtentReportUtil.setTest(result.getName());
        ExtentReportUtil.getTest().log(Status.INFO, "Test Started: " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        logger.info("TEST CASE SUCCESS : ",result.getMethod().getMethodName());
        logger.info("DESCRIPTION : " , result.getMethod().getDescription());
        ExtentReportUtil.getTest().log(Status.PASS, "Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        logger.error("TEST CASE FAILED : ",result.getMethod().getMethodName());
        logger.error("ERROR MESSAGE : " , result.getThrowable().getMessage());
        Object test = result.getInstance();
        BrowserUtil browserUtility = ((BaseTest)test).getInstance();
        String screenShot  = browserUtility.takeScreenshot(result.getMethod().getMethodName());
        ExtentReportUtil.getTest()
                .log(Status.FAIL, "Test Failed: " + result.getName())
                .fail(result.getThrowable(),
                        MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        logger.warn("TEST CASE SKIPPED : ",result.getMethod().getMethodName());
        logger.warn("DESCRIPTION : ",result.getMethod().getDescription());
        ExtentReportUtil.getTest().log(Status.SKIP, "Test SKIPPED: " + result.getName());
    }
}
