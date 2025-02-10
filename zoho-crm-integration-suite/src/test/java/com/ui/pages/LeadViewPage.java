package com.ui.pages;

import com.ui.utils.BrowserUtil;
import com.ui.utils.CustomFilterUtil;
import com.ui.utils.PaginationUtil;
import com.ui.utils.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadViewPage extends BrowserUtil {

    PaginationUtil paginationUtil = null;
    CustomFilterUtil customFilterUtil = null;

    private By CREATE_LEAD_LOCATOR = By.xpath(PropertiesUtil.getProperty("create_lead_locator"));
    private By TABLE_ROWS_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_table_locator"));
    private By PHONE_NUMBER_COLUMN_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_table_column_locator"));  // Assuming the phone number is in the 4th column
    private By NEXT_BUTTON_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_table_next_button_locator"));
    private By MORE_ACTION_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_actions_menu"));
    private By EDIT_ACTION_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_edit_action"));
    private By CUSTOM_FILTER_SEARCH = By.xpath(PropertiesUtil.getProperty("lead_custom_filter_search_locator"));
    private By CUSTOM_FILTER_TABLE_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_custom_filter_table_locator"));
    private By APPLY_FILTER_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_custom_apply_filter_button_locator"));
    private By FILTER_VALUE_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_filter_text_box_locator"));
    private By LEAD_ACTION_DELETE = By.xpath(PropertiesUtil.getProperty("lead_action_delete_locator"));
    private By CONFIRMATION_DELETE_BUTTON_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_delete_alert_locator"));
    private By FILTER_RESULTS_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_filter_result_locator"));
    private By CANCEL_DELETE_LOCATOR = By.xpath(PropertiesUtil.getProperty("cancel_delete_locator"));



    public LeadViewPage(WebDriver webDriver) {
        super(webDriver);
        this.paginationUtil = new PaginationUtil(webDriver);
        this.customFilterUtil = new CustomFilterUtil(webDriver);
    }

    public CreateLeadPage createLead()
    {
        clickOn(CREATE_LEAD_LOCATOR);
        CreateLeadPage createLeadPage = new CreateLeadPage(getWebDriver());
        return createLeadPage;
    }

    public EditLeadPage editLead(String phone)
    {
        search(phone);
        clickOn(MORE_ACTION_LOCATOR);
        clickOn(EDIT_ACTION_LOCATOR);
        EditLeadPage editLeadPage = new EditLeadPage(getWebDriver());
        return editLeadPage;

    }

    public void search(String phoneNumber) {

        if(paginationUtil.searchLeadByPhoneNumber(phoneNumber,TABLE_ROWS_LOCATOR,PHONE_NUMBER_COLUMN_LOCATOR,NEXT_BUTTON_LOCATOR)){
            moveToElement(MORE_ACTION_LOCATOR);
        }
    }

    public String  filterLead(String filter , String filterValue , String text)
    {
     customFilterUtil.applyCustomFilter(CUSTOM_FILTER_SEARCH,CUSTOM_FILTER_TABLE_LOCATOR,APPLY_FILTER_LOCATOR,FILTER_VALUE_LOCATOR,filter,filterValue,text);
        implicitWait("5");
        return getText(FILTER_RESULTS_LOCATOR);
    }

    public SaveLeadPage deleteLead(String phoneNo)
    {
        search(phoneNo);
        clickOn(MORE_ACTION_LOCATOR);
        clickOn(LEAD_ACTION_DELETE);
        clickOn(CONFIRMATION_DELETE_BUTTON_LOCATOR);
        SaveLeadPage lead = new SaveLeadPage(getWebDriver());
        return lead;
    }
    public String cancelDelete(String phoneNo)
    {
        search(phoneNo);
        clickOn(MORE_ACTION_LOCATOR);
        clickOn(LEAD_ACTION_DELETE);
        clickOn(CANCEL_DELETE_LOCATOR);
        return getText(FILTER_RESULTS_LOCATOR);

    }


}
