package com.ui.tests;

import com.ui.base.BaseTest;
import com.ui.pojos.EditLeadData;
import com.ui.utils.ExtentReportUtil;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.ui.listeners.TestListeners.class)
public class EditLeadTest extends BaseTest {

    @Test(priority = 1, description = "Verify lead details can be edited successfully",dataProvider = "testCase1Data",dataProviderClass = com.ui.dataproviders.EditLeadDataProvider.class)
    public void editLeadDetailsTest(EditLeadData editLeadData) {

        ExtentReportUtil.setTest("Verify lead details can be edited successfully");
        landingPage.signInLink().login(editLeadData.getUsername(),editLeadData.getPassword()).navigateToLead().
                editLead(editLeadData.getSearch()).newLeadDetails(editLeadData.getFirstname(),editLeadData.getEmail()
                        ,editLeadData.getPhone());
    }

    @Test(priority = 2,description = "verify error message will be displayed for missing company field",dataProvider = "testCase2Data",dataProviderClass = com.ui.dataproviders.EditLeadDataProvider.class)
    public void editLeadWithMissingCompanyFieldTest(EditLeadData editLeadData) {

        ExtentReportUtil.setTest("Verify error message for missing mandatory field company");
        Assert.assertEquals(landingPage.signInLink().login(editLeadData.getUsername(),editLeadData.getPassword()).navigateToLead().editLead(editLeadData.getSearch()).
                companyDetailsMissing(editLeadData.getFirstname(), editLeadData.getEmail()
                        , editLeadData.getPhone()), editLeadData.getExpectedResult());
    }

    @Test(priority = 3,description = "verify error message will be displayed for missing last name field",dataProvider = "testCase3Data",dataProviderClass = com.ui.dataproviders.EditLeadDataProvider.class)
    public void editLeadWithMissingLastNameFieldTest(EditLeadData editLeadData) {

        ExtentReportUtil.setTest("Verify error message for missing mandatory field last name");
        Assert.assertEquals( landingPage.signInLink().login(editLeadData.getUsername(),editLeadData.getPassword()).navigateToLead().editLead(editLeadData.getSearch()).
               lastNameDetailsMissing(editLeadData.getFirstname(),editLeadData.getEmail(),editLeadData.getPhone())
                ,editLeadData.getExpectedResult());
    }

    @Test(priority = 4,description = "verify user is navigated to lead details page",dataProvider = "testCase4Data",dataProviderClass = com.ui.dataproviders.EditLeadDataProvider.class)
    public void editLeadCancelledTest(EditLeadData editLeadData) {

        ExtentReportUtil.setTest("Verify navigation to lead view page is successful if user cancels the edit settings");
        Assert.assertEquals( landingPage.signInLink().login(editLeadData.getUsername(),editLeadData.getPassword()).navigateToLead()
                .editLead(editLeadData.getSearch()).cancelEdit(),editLeadData.getExpectedResult());
    }
}
