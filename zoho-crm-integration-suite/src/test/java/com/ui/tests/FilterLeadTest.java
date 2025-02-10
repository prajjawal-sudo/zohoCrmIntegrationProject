package com.ui.tests;

import com.ui.base.BaseTest;
import com.ui.pojos.FilterLeadData;
import com.ui.utils.ExtentReportUtil;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.ui.listeners.TestListeners.class)
public class FilterLeadTest extends BaseTest {

    @Test(priority = 1, description = "Verify lead can be found successfully from custom search filter",dataProvider = "testCase1Data",dataProviderClass = com.ui.dataproviders.FilterLeadDataProvider.class)
    public void searchLeadByPhoneFilterTest(FilterLeadData filterLeadData) {

        ExtentReportUtil.setTest("Verify results can be filtered successfully with phone number");
        Assert.assertEquals(landingPage.signInLink().login(filterLeadData.getUsername(),filterLeadData.getPassword()).
                navigateToLead().filterLead(filterLeadData.getFilter(), filterLeadData.getFilterValue(),filterLeadData.getTextValue())
                ,filterLeadData.getExpectedResult());
    }

    @Test(priority = 2, description = "Verify lead can be found successfully from custom search filter",dataProvider = "testCase2Data",dataProviderClass = com.ui.dataproviders.FilterLeadDataProvider.class)
    public void searchLeadByEmailFilterTest(FilterLeadData filterLeadData) {

        ExtentReportUtil.setTest("Verify results can be filtered successfully with email");
        Assert.assertEquals(landingPage.signInLink().login(filterLeadData.getUsername(),filterLeadData.getPassword()).
                navigateToLead().filterLead(filterLeadData.getFilter(), filterLeadData.getFilterValue(),filterLeadData.getTextValue())
                ,filterLeadData.getExpectedResult());
    }
}
