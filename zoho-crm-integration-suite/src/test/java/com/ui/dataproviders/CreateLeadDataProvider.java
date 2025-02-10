package com.ui.dataproviders;

import com.ui.pojos.CreateLeadData;
import com.ui.pojos.LoginData;
import com.ui.utils.ExcelReaderUtil;
import org.testng.annotations.DataProvider;

public class CreateLeadDataProvider {

    private static final String FILE_PATH = "testdata.xlsx";
    private static final String SHEET_NAME = "Customize-Lead";

    @DataProvider(name = "testCase1Data")
    public static Object[][] getTestCase1Data() {
        return new Object[][]{{getCreatedLeadData("createNewLeadTest")}};
    }

    @DataProvider(name = "testCase2Data")
    public static Object[][] getTestCase2Data() {
        return new Object[][]{{getCreatedLeadData("createLeadWithMissingCompanyFieldTest")}};
    }
    @DataProvider(name = "testCase3Data")
    public static Object[][] getTestCase3Data() {
        return new Object[][]{{getCreatedLeadData("createLeadWithMissingLastNameFieldTest")}};
    }

    private static CreateLeadData getCreatedLeadData(String testCaseName) {
        ExcelReaderUtil excelReader = new ExcelReaderUtil(FILE_PATH);
        return (CreateLeadData) excelReader.getLoginDataByTestCaseName(SHEET_NAME, testCaseName, CreateLeadData
                .class);
    }


}
