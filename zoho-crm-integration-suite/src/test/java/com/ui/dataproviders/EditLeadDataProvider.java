package com.ui.dataproviders;

import com.ui.pojos.EditLeadData;
import com.ui.pojos.LoginData;
import com.ui.utils.ExcelReaderUtil;
import org.testng.annotations.DataProvider;

public class EditLeadDataProvider {

    private static final String FILE_PATH = "testdata.xlsx";
    private static final String SHEET_NAME = "Edit-Lead";

    @DataProvider(name = "testCase1Data")
    public static Object[][] getTestCase1Data() {
        return new Object[][]{{getEditLeadData("editLeadDetailsTest")}};
    }

    @DataProvider(name = "testCase2Data")
    public static Object[][] getTestCase2Data() {
        return new Object[][]{{getEditLeadData("editLeadWithMissingCompanyFieldTest")}};
    }
    @DataProvider(name = "testCase3Data")
    public static Object[][] getTestCase3Data() {
        return new Object[][]{{getEditLeadData("editLeadWithMissingLastNameFieldTest")}};
    }
    @DataProvider(name = "testCase4Data")
    public static Object[][] getTestCase4Data() {
        return new Object[][]{{getEditLeadData("editLeadCancelledTest")}};
    }

    private static EditLeadData getEditLeadData(String testCaseName) {
        ExcelReaderUtil excelReader = new ExcelReaderUtil(FILE_PATH);
        return (EditLeadData) excelReader.getLoginDataByTestCaseName(SHEET_NAME, testCaseName,EditLeadData.class);
    }

}
