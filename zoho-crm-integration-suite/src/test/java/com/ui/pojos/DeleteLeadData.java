package com.ui.pojos;

public class DeleteLeadData {

    private String username;
    private String password;
    private String phone;
    private String expectedResult;

    public DeleteLeadData(String username, String password, String phone, String expectedResult) {
        this.username = username;
        this.password = password;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    @Override
    public String toString() {
        return "DeleteLeadData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                '}';
    }
}
