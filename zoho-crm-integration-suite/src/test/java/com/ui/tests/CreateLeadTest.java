package com.ui.tests;

import com.ui.base.BaseTest;
import com.ui.pojos.CreateLeadData;
import com.ui.utils.ExtentReportUtil;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.ui.listeners.TestListeners.class)
public class CreateLeadTest extends BaseTest {

    @Test(priority = 1, description = "Verify new lead can be created successfully",dataProvider = "testCase1Data",dataProviderClass = com.ui.dataproviders.CreateLeadDataProvider.class)
    public void createNewLeadTest(CreateLeadData createLeadData) {

        ExtentReportUtil.setTest("Create New Lead Test Case");
        Assert.assertEquals(landingPage.signInLink().login(createLeadData.getUsername(),createLeadData.getPassword()).navigateToLead().createLead().
                        fillLeadDetails(createLeadData.getFirstname(), createLeadData.getLastname(), createLeadData.getEmail(), createLeadData.getPhone(),
                                createLeadData.getCompany()).leadSaved(),createLeadData.getExpectedResult());
    }

    @Test(priority = 2,description = "verify error message will be displayed for missing company field ",dataProvider = "testCase2Data",dataProviderClass = com.ui.dataproviders.CreateLeadDataProvider.class)
    public void createLeadWithMissingCompanyFieldTest(CreateLeadData createLeadData) {

        ExtentReportUtil.setTest("Verify error message when missing mandatory details for company ");
        Assert.assertEquals(landingPage.signInLink().login(createLeadData.getUsername(),createLeadData.getPassword()).navigateToLead().createLead().
                        companyDetailsMissing(createLeadData.getFirstname(), createLeadData.getEmail(), createLeadData.getPhone(),createLeadData.getLastname()),
                         createLeadData.getExpectedResult());
    }
    @Test(priority = 3,description = "verify error message will be displayed for missing last name field",dataProvider = "testCase3Data",dataProviderClass = com.ui.dataproviders.CreateLeadDataProvider.class)
    public void createLeadWithMissingLastNameFieldTest(CreateLeadData createLeadData) {

        ExtentReportUtil.setTest("Verify error message when missing mandatory details for last name ");
        Assert.assertEquals(landingPage.signInLink().login(createLeadData.getUsername(),createLeadData.getPassword()).navigateToLead().createLead().
                lastNameDetailsMissing(createLeadData.getFirstname(), createLeadData.getEmail(), createLeadData.getPhone(),createLeadData.getCompany()),"\n" +
                 createLeadData.getExpectedResult());
    }
}
