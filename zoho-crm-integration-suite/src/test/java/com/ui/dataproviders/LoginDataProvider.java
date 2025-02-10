package com.ui.dataproviders;

import com.ui.pojos.LoginData;
import com.ui.utils.ExcelReaderUtil;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    private static final String FILE_PATH = "testdata.xlsx";
    private static final String SHEET_NAME = "Login-Credentials";

    @DataProvider(name = "testCase1Data")
    public static Object[][] getTestCase1Data() {
        return new Object[][]{{getLoginData("loginWithValidCredentialsTest")}};
    }

    @DataProvider(name = "testCase2Data")
    public static Object[][] getTestCase2Data() {
        return new Object[][]{{getLoginData("loginWithInvalidCredentialsTest")}};
    }

    @DataProvider(name = "testCase3Data")
    public static Object[][] getTestCase3Data() {
        return new Object[][]{{getLoginData("invalidPasswordTest")}};
    }

    @DataProvider(name = "testCase4Data")
    public static Object[][] getTestCase4Data() {
        return new Object[][]{{getLoginData("blankUserNameFieldTest")}};
    }

    @DataProvider(name = "testCase5Data")
    public static Object[][] getTestCase5Data() {
        return new Object[][]{{getLoginData("blankPasswordFieldTest")}};
    }
    @DataProvider(name = "testCase6Data")
    public static Object[][] getTestCase6Data() {
        return new Object[][]{{getLoginData("invalidUserNameAtHomePageTest")}};
    }

    private static LoginData getLoginData(String testCaseName) {
        ExcelReaderUtil excelReader = new ExcelReaderUtil(FILE_PATH);
        return (LoginData) excelReader.getLoginDataByTestCaseName(SHEET_NAME, testCaseName,LoginData.class);
    }
}

