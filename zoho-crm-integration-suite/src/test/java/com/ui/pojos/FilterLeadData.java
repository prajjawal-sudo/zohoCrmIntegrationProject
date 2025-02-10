package com.ui.pojos;

public class FilterLeadData {

    private String username;
    private String password;
    private String filter;
    private String filterValue;
    private String textValue;
    private String expectedResult;

    public FilterLeadData(String username, String password, String filter, String filterValue, String textValue, String expectedResult) {
        this.username = username;
        this.password = password;
        this.filter = filter;
        this.filterValue = filterValue;
        this.textValue = textValue;
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

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    @Override
    public String toString() {
        return "FilterLeadData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", filter='" + filter + '\'' +
                ", filterValue='" + filterValue + '\'' +
                ", textValue='" + textValue + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                '}';
    }
}
