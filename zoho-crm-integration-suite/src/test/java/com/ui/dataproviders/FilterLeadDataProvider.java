package com.ui.dataproviders;

import com.ui.pojos.FilterLeadData;
import com.ui.pojos.LoginData;
import com.ui.utils.ExcelReaderUtil;
import org.testng.annotations.DataProvider;

public class FilterLeadDataProvider {

    private static final String FILE_PATH = "testdata.xlsx";
    private static final String SHEET_NAME = "Filter-Lead";

    @DataProvider(name = "testCase1Data")
    public static Object[][] getTestCase1Data() {
        return new Object[][]{{getFilterLeadData("searchLeadByPhoneFilterTest")}};
    }

    @DataProvider(name = "testCase2Data")
    public static Object[][] getTestCase2Data() {
        return new Object[][]{{getFilterLeadData("searchLeadByEmailFilterTest")}};
    }

    private static FilterLeadData getFilterLeadData(String testCaseName) {
        ExcelReaderUtil excelReader = new ExcelReaderUtil(FILE_PATH);
        return (FilterLeadData) excelReader.getLoginDataByTestCaseName(SHEET_NAME, testCaseName,FilterLeadData.class);
    }

}
