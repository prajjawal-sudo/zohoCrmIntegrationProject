package com.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CustomFilterUtil extends BrowserUtil {

    private WebDriver driver;
    WebDriverWait wait;

    public CustomFilterUtil(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public void applyCustomFilter(By searchFieldLocator, By tableRowsLocator,
                   By applyFilterButtonLocator, By textBoxLocator, String searchValue,String value , String text) {

        WebElement searchField = driver.findElement(searchFieldLocator);
        searchField.clear();
        searchField.sendKeys(searchValue);

        List<WebElement> rows = driver.findElements(tableRowsLocator);

        for (WebElement row : rows) {
            if (row.getText().contains(searchValue)) {
               WebElement checkbox = row.findElement(By.xpath("//lyte-checkbox[starts-with(@id,\"field_"+text+"\")]//span[@class='lyteCheckBoxDefault'][1]"));
               // WebElement checkbox = row.findElement(By.id("//lyte-checkbox[@id=\"field_"+text+"\"]"));
                if (!checkbox.isSelected()) {
                    checkbox.click();
                    break;
                }
            }
        }
        WebElement textBox = driver.findElement(textBoxLocator);
        textBox.sendKeys(value);

        driver.findElement(applyFilterButtonLocator).click();
        System.out.println("Filter applied successfully.");

    }
}


