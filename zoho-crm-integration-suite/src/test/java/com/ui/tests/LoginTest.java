package com.ui.tests;

import com.ui.base.BaseTest;
import com.ui.pojos.LoginData;
import com.ui.utils.ExtentReportUtil;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.ui.listeners.TestListeners.class)
public class LoginTest extends BaseTest {


    @Test(priority = 1, description = "Verify user logged In successfully" , dataProviderClass = com.ui.dataproviders.LoginDataProvider.class ,dataProvider = "testCase1Data")
    public void loginWithValidCredentialsTest(LoginData loginData) {
        ExtentReportUtil.setTest("Verify login is successful with valid user credentials");
        landingPage.signInLink().login(loginData.getUsername(),loginData.getPassword());
    }
    @Test(priority = 2,description = "Verify error message is displayed with invalid email account",dataProviderClass = com.ui.dataproviders.LoginDataProvider.class ,dataProvider = "testCase2Data")
    public void loginWithInvalidCredentialsTest(LoginData loginData) {
        ExtentReportUtil.setTest("Verify error is displayed for invalid email account");
        Assert.assertEquals(landingPage.signInLink().invalidEmail(loginData.getUsername()),loginData.getExpectedResult());
    }
    @Test(priority = 3,description = "Verify error message is displayed with invalid login password",dataProviderClass = com.ui.dataproviders.LoginDataProvider.class ,dataProvider = "testCase3Data")
    public void invalidPasswordTest(LoginData loginData) {
        ExtentReportUtil.setTest("Verify error is displayed for invalid login password");
        Assert.assertEquals(landingPage.signInLink().invalidPassword(loginData.getUsername(),loginData.getPassword()),loginData.getExpectedResult());
    }
    @Test(priority = 4,description = "verify error is displayed for mandatory fields",dataProviderClass = com.ui.dataproviders.LoginDataProvider.class ,dataProvider = "testCase4Data")
    public void blankUserNameFieldTest(LoginData loginData) {
        ExtentReportUtil.setTest("Verify error is displayed for blank email field");
        Assert.assertEquals(landingPage.signInLink().blankUserName(""),loginData.getExpectedResult());
    }
    @Test(priority = 5,description = "verify error is displayed for mandatory fields",dataProviderClass = com.ui.dataproviders.LoginDataProvider.class ,dataProvider = "testCase5Data")
    public void blankPasswordNameFieldTest(LoginData loginData) {
        ExtentReportUtil.setTest("Verify error is displayed for blank password field");
        Assert.assertEquals(landingPage.signInLink().blankPassword(loginData.getUsername(),loginData.getPassword()),loginData.getExpectedResult());
    }
    @Test(priority = 6, description = "Verify test will be failed for incorrect user name",dataProviderClass = com.ui.dataproviders.LoginDataProvider.class ,dataProvider = "testCase6Data")
    public void invalidUserNameAtHomePageTest(LoginData loginData) {
        ExtentReportUtil.setTest("Verify user name  for logged in user");
        Assert.assertNotEquals(landingPage.signInLink().login(loginData.getUsername(),loginData.getPassword()).getUsername(),loginData.getExpectedResult());
    }

}
