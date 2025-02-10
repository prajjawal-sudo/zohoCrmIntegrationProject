package com.ui.pages;

import com.ui.utils.BrowserUtil;
import com.ui.utils.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CreateLeadPage extends BrowserUtil {

    private By FIRST_NAME_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_first_name_locator"));
    private By LAST_NAME_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_last_name_locator"));
    private By EMAIL_ADDRESS_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_email_address_locator"));
    private By PHONE_NUMBER_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_phone_number_locator"));
    private By COMPANY_NAME_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_company_name_locator"));
    private By STATUS_DROPDOWN_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_status_dropdown_locator"));
    private By STATUS_SELECT_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_statue_select_locator"));
    private By SAVE_LEAD_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_save_button_locator"));
    private By COMPANY_MISSING_LOCATOR = By.id(PropertiesUtil.getProperty("lead_company_field_missing_locator"));
    private By LAST_NAME_MISSING_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_last_name_field_missing_locator"));



    public CreateLeadPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SaveLeadPage fillLeadDetails(String firstName, String lastName , String email, String phoneNumber , String company)
    {
        sendText(FIRST_NAME_LOCATOR,firstName);
        sendText(LAST_NAME_LOCATOR,lastName);
        sendText(EMAIL_ADDRESS_LOCATOR,email);
        sendText(PHONE_NUMBER_LOCATOR,phoneNumber);
        sendText(COMPANY_NAME_LOCATOR,company);
        clickOn(STATUS_DROPDOWN_LOCATOR);
        clickOn(STATUS_SELECT_LOCATOR);
        clickOn(SAVE_LEAD_LOCATOR);
        SaveLeadPage saveLeadPage = new SaveLeadPage(getWebDriver());
        return saveLeadPage;
    }
    public String companyDetailsMissing(String firstName , String email, String phoneNumber , String lastName)
    {
        sendText(FIRST_NAME_LOCATOR,firstName);
        sendText(EMAIL_ADDRESS_LOCATOR,email);
        sendText(PHONE_NUMBER_LOCATOR,phoneNumber);
        clickOn(STATUS_DROPDOWN_LOCATOR);
        clickOn(STATUS_SELECT_LOCATOR);
        clickOn(SAVE_LEAD_LOCATOR);
        wait(COMPANY_MISSING_LOCATOR);
        return getText(COMPANY_MISSING_LOCATOR);

    }
    public String lastNameDetailsMissing(String firstName , String email, String phoneNumber , String company)
    {
        sendText(FIRST_NAME_LOCATOR,firstName);
        sendText(EMAIL_ADDRESS_LOCATOR,email);
        sendText(PHONE_NUMBER_LOCATOR,phoneNumber);
        sendText(COMPANY_NAME_LOCATOR,company);
        clickOn(STATUS_DROPDOWN_LOCATOR);
        clickOn(STATUS_SELECT_LOCATOR);
        clickOn(SAVE_LEAD_LOCATOR);
        wait(LAST_NAME_MISSING_LOCATOR);
        return getText(LAST_NAME_MISSING_LOCATOR);
    }
}
