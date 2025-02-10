package com.ui.dataproviders;

import com.ui.pojos.CustomizeLeadData;
import com.ui.pojos.LoginData;
import com.ui.utils.ExcelReaderUtil;
import org.testng.annotations.DataProvider;

public class CustomizeLeadDataProvider {

    private static final String FILE_PATH = "testdata.xlsx";
    private static final String SHEET_NAME = "Customize-Lead";


    @DataProvider(name = "testCase1Data")
    public static Object[][] getTestCase1Data() {
        return new Object[][]{{getCustomizedLeadData("navigationToLeadCustomizationTest")}};
    }

    @DataProvider(name = "testCase2Data")
    public static Object[][] getTestCase2Data() {
        return new Object[][]{{getCustomizedLeadData("openLeadLayoutTest")}};
    }
    @DataProvider(name = "testCase3Data")
    public static Object[][] getTestCase3Data() {
        return new Object[][]{{getCustomizedLeadData("customizeEmailFieldTest")}};
    }

    private static CustomizeLeadData getCustomizedLeadData(String testCaseName) {
        ExcelReaderUtil excelReader = new ExcelReaderUtil(FILE_PATH);
        return (CustomizeLeadData) excelReader.getLoginDataByTestCaseName(SHEET_NAME, testCaseName,CustomizeLeadData.class);
    }


}
