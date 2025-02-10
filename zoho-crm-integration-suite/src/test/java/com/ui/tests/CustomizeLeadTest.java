package com.ui.tests;

import com.ui.base.BaseTest;
import com.ui.pojos.CustomizeLeadData;
import com.ui.utils.ExtentReportUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomizeLeadTest extends BaseTest {

    @Test(priority = 1 , description = "verify user can be navigated to lead customization page",dataProvider = "testCase1Data",dataProviderClass = com.ui.dataproviders.CustomizeLeadDataProvider.class)
    public void navigationToLeadCustomizationTest(CustomizeLeadData customizeLeadData) {

        ExtentReportUtil.setTest("Verify navigation to customize lead settings is successful");
        Assert.assertEquals(landingPage.signInLink().login(customizeLeadData.getUsername(),customizeLeadData.getPassword()).
                navigateToCustomize().navigateToCustomizeLead(customizeLeadData.getModules())
                ,customizeLeadData.getExpectedResult());
    }

    @Test(priority = 2 , description = "verify user can be customize the lead standards",dataProvider = "testCase2Data",dataProviderClass = com.ui.dataproviders.CustomizeLeadDataProvider.class)
    public void openLeadLayoutTest(CustomizeLeadData customizeLeadData) {

        ExtentReportUtil.setTest("Verify layout settings can be opened");
        Assert.assertEquals(landingPage.signInLink().login(customizeLeadData.getUsername(),customizeLeadData.getPassword()).
                navigateToCustomize().openCustomizeLead(customizeLeadData.getModules())
                ,customizeLeadData.getExpectedResult());
    }

    @Test(priority = 3 , description = "verify user can be customize the email field",dataProvider = "testCase3Data",dataProviderClass = com.ui.dataproviders.CustomizeLeadDataProvider.class)
    public void customizeEmailFieldTest(CustomizeLeadData customizeLeadData) {

        ExtentReportUtil.setTest("Verify email field can be customized successfully");
        Assert.assertEquals(landingPage.signInLink().login(customizeLeadData.getUsername(),customizeLeadData.getPassword()).
                navigateToCustomize().editEmailLead(customizeLeadData.getModules())
                ,customizeLeadData.getExpectedResult());
    }

}
