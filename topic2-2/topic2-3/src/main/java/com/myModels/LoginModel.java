package com.myModels;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {

    //@NotNull comes from java validation, one of the dependencies that we imported before
    @NotEmpty(message = "Username can not be empty")
    @NotNull(message = "Username is required")
    @Size(min=3, max=15, message = "Usarname must be between 3 and 15 characters")
    private String userName;

    @NotNull(message = "Password is required")
    @Size(min=8, max=15, message = "Password must be between 8 and 15 characters")
    private String password;

    // Constructor
    public LoginModel(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }

    //Default Constructor
    public LoginModel() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
