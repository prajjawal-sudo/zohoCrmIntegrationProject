package com.ui.utils;


import com.ui.pojos.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReaderUtil {

    private Workbook workbook;

    public ExcelReaderUtil(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//testData//" + filePath);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Object getLoginDataByTestCaseName(String sheetName, String testCaseName, Class<?> dataType) {
        Sheet sheet = workbook.getSheet(sheetName);
        DataFormatter formatter = new DataFormatter();

        if (dataType == LoginData.class) {
            for (Row row : sheet) {
                String currentTestCase = formatter.formatCellValue(row.getCell(0));  // TestCaseName column
                if (currentTestCase.equalsIgnoreCase(testCaseName)) {
                    String username = formatter.formatCellValue(row.getCell(1));
                    String password = formatter.formatCellValue(row.getCell(2));
                    String expectedResult = formatter.formatCellValue(row.getCell(3));
                    return new LoginData(username, password, expectedResult);
                }
            }
            throw new RuntimeException("Test case name not found in Excel: " + testCaseName);
        } else if (dataType == CreateLeadData.class) {
            for (Row row : sheet) {
                String currentTestCase = formatter.formatCellValue(row.getCell(0));  // TestCaseName column
                if (currentTestCase.equalsIgnoreCase(testCaseName)) {
                    String username = formatter.formatCellValue(row.getCell(1));
                    String password = formatter.formatCellValue(row.getCell(2));
                    String firstname = formatter.formatCellValue(row.getCell(3));
                    String lastname = formatter.formatCellValue(row.getCell(4));
                    String email = formatter.formatCellValue(row.getCell(5));
                    String phone = formatter.formatCellValue(row.getCell(6));
                    String company = formatter.formatCellValue(row.getCell(7));
                    String expectedResult = formatter.formatCellValue(row.getCell(8));
                    return new CreateLeadData(username, password, lastname, firstname, email, company, phone, expectedResult);
                }
            }
            throw new RuntimeException("Test case name not found in Excel: " + testCaseName);
        }
        else if (dataType == EditLeadData.class) {
            for (Row row : sheet) {
                String currentTestCase = formatter.formatCellValue(row.getCell(0));  // TestCaseName column
                if (currentTestCase.equalsIgnoreCase(testCaseName)) {
                    String username = formatter.formatCellValue(row.getCell(1));
                    String password = formatter.formatCellValue(row.getCell(2));
                    String firstname = formatter.formatCellValue(row.getCell(3));
                    String lastname = formatter.formatCellValue(row.getCell(4));
                    String email = formatter.formatCellValue(row.getCell(5));
                    String phone = formatter.formatCellValue(row.getCell(6));
                    String company = formatter.formatCellValue(row.getCell(7));
                    String expectedResult = formatter.formatCellValue(row.getCell(8));
                    String search = formatter.formatCellValue(row.getCell(9));
                    return new EditLeadData(username, password, lastname, firstname, email, company, phone, expectedResult,search);
                }
            }
            throw new RuntimeException("Test case name not found in Excel: " + testCaseName);
        }
        else if (dataType == FilterLeadData.class) {
            for (Row row : sheet) {
                String currentTestCase = formatter.formatCellValue(row.getCell(0));  // TestCaseName column
                if (currentTestCase.equalsIgnoreCase(testCaseName)) {
                    String username = formatter.formatCellValue(row.getCell(1));
                    String password = formatter.formatCellValue(row.getCell(2));
                    String filter = formatter.formatCellValue(row.getCell(3));
                    String filterValue = formatter.formatCellValue(row.getCell(4));
                    String textValue = formatter.formatCellValue(row.getCell(5));
                    String expectedResult = formatter.formatCellValue(row.getCell(6));
                    return new FilterLeadData(username, password,filter,filterValue,textValue,expectedResult);
                }
            }
            throw new RuntimeException("Test case name not found in Excel: " + testCaseName);
        }
        else if (dataType == DeleteLeadData.class) {
            for (Row row : sheet) {
                String currentTestCase = formatter.formatCellValue(row.getCell(0));  // TestCaseName column
                if (currentTestCase.equalsIgnoreCase(testCaseName)) {
                    String username = formatter.formatCellValue(row.getCell(1));
                    String password = formatter.formatCellValue(row.getCell(2));
                    String phone = formatter.formatCellValue(row.getCell(3));
                    String expectedResult = formatter.formatCellValue(row.getCell(4));
                    return new DeleteLeadData(username,password,phone,expectedResult);
                }
            }
            throw new RuntimeException("Test case name not found in Excel: " + testCaseName);
        }
        else if (dataType == DeleteLeadData.class) {
            for (Row row : sheet) {
                String currentTestCase = formatter.formatCellValue(row.getCell(0));  // TestCaseName column
                if (currentTestCase.equalsIgnoreCase(testCaseName)) {
                    String username = formatter.formatCellValue(row.getCell(1));
                    String password = formatter.formatCellValue(row.getCell(2));
                    String modules = formatter.formatCellValue(row.getCell(3));
                    String expectedResult = formatter.formatCellValue(row.getCell(4));
                    return new CustomizeLeadData(username,password,modules,expectedResult);
                }
            }
            throw new RuntimeException("Test case name not found in Excel: " + testCaseName);
        }

        return null;
    }
}






