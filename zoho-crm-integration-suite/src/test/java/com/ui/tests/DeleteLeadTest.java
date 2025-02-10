package com.ui.tests;

import com.ui.base.BaseTest;
import com.ui.pojos.DeleteLeadData;
import com.ui.utils.ExtentReportUtil;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.ui.listeners.TestListeners.class)
public class DeleteLeadTest extends BaseTest {

    @Test(priority = 1, description = "Verify lead can be deleted successfully",dataProvider = "testCase1Data",dataProviderClass = com.ui.dataproviders.DeleteLeadDataProvider.class)
    public void deleteLeadTest(DeleteLeadData deleteLeadData) {
        ExtentReportUtil.setTest("Verify lead details can be deleted successfully");
        landingPage.signInLink().login(deleteLeadData.getUsername(), deleteLeadData.getPassword()).
                navigateToLead().deleteLead(deleteLeadData.getPhone());
    }

    @Test(priority = 2, description = "Verify lead can cancel delete operation",dataProvider = "testCase2Data",dataProviderClass = com.ui.dataproviders.DeleteLeadDataProvider.class)
    public void cancelDeleteTest(DeleteLeadData deleteLeadData) {
        ExtentReportUtil.setTest("Verify navigation to lead view page is successful if user click on cancel button");
        Assert.assertEquals(landingPage.signInLink().login(deleteLeadData.getUsername(),deleteLeadData.getPassword())
                .navigateToLead().cancelDelete(deleteLeadData.getPhone()),deleteLeadData.getExpectedResult());
    }
}
