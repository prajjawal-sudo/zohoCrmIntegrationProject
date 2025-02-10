package com.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PaginationUtil extends BrowserUtil {

    WebDriver webDriver = null;

    public PaginationUtil(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public  boolean searchLeadByPhoneNumber(String targetPhoneNumber , By tableRowsLocator , By phoneNumberColumnLocator , By nextButtonLocator) {
        while (true) {
            List<WebElement> rows = webDriver.findElements(tableRowsLocator);
            for (WebElement row : rows) {
                WebElement phoneNumberCell = row.findElement(phoneNumberColumnLocator);
                String phoneNumber = phoneNumberCell.getText();
                System.out.println(phoneNumber);
                if (phoneNumber.contains(targetPhoneNumber)) {
                    System.out.println("found");
                    return true;
                }
            }
            WebElement nextButton = webDriver.findElement(nextButtonLocator);
            if (!nextButton.isEnabled()) {
                break;
            }
            nextButton.click();
        }
        return false;
    }
}
