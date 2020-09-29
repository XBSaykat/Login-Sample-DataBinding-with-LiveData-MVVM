package com.xbsaykat.logindatabindingwithlivedatamvvm;

import android.util.Patterns;

public class LoginUser {

    private String strEmail;
    private String strPassword;

    public LoginUser(String strEmail, String strPassword) {
        this.strEmail = strEmail;
        this.strPassword = strPassword;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public boolean isEmailValid(){
        return Patterns.EMAIL_ADDRESS.matcher(getStrEmail()).matches();
    }

    public boolean isPasswordValid(){
        return getStrPassword().length()>=6;
    }
}
