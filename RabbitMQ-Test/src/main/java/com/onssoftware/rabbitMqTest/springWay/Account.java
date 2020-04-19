package com.onssoftware.rabbitMqTest.springWay;

public class Account {

    private String accountName;
    private String primaryEmail;

    public Account() {
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", primaryEmail='" + primaryEmail + '\'' +
                '}';
    }
}