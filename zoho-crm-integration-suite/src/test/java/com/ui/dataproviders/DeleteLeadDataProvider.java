package com.ui.dataproviders;

import com.ui.pojos.DeleteLeadData;
import com.ui.pojos.LoginData;
import com.ui.utils.ExcelReaderUtil;
import org.testng.annotations.DataProvider;

public class DeleteLeadDataProvider {

    private static final String FILE_PATH = "testdata.xlsx";
    private static final String SHEET_NAME = "Delete-Lead";

    @DataProvider(name = "testCase1Data")
    public static Object[][] getTestCase1Data() {
        return new Object[][]{{getDeleteLeadData("deleteLeadTest")}};
    }

    @DataProvider(name = "testCase2Data")
    public static Object[][] getTestCase2Data() {
        return new Object[][]{{getDeleteLeadData("cancelDeleteTest")}};
    }

    private static DeleteLeadData getDeleteLeadData(String testCaseName) {
        ExcelReaderUtil excelReader = new ExcelReaderUtil(FILE_PATH);
        return (DeleteLeadData) excelReader.getLoginDataByTestCaseName(SHEET_NAME, testCaseName,DeleteLeadData.class);
    }

}
