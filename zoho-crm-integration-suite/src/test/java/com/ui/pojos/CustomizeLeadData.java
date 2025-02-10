package com.ui.pojos;

public class CustomizeLeadData {

    private String username;
    private String password;
    private String modules;
    private String expectedResult;

    public CustomizeLeadData(String username, String password, String modules, String expectedResult) {
        this.username = username;
        this.password = password;
        this.modules = modules;
        this.expectedResult = expectedResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    @Override
    public String toString() {
        return "CustomizeLeadData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", modules='" + modules + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                '}';
    }
}
