package com.example.a13110091.testweb;

/**
 * Created by 13110091 on 2018-03-22.
 */
//하나의 사용자를 저장할수있게 함
public class user {

    String userID;
    String userPassword;
    String userName;
    String userAge;
    String userSex;
    String userWeight;
    String userHeight;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(String userWeight) {
        this.userWeight = userWeight;
    }

    public String getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(String userHeight) {
        this.userHeight = userHeight;
    }

    public user(String userID, String userPassword, String userName, String userAge, String userSex, String userWeight, String userHeight) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userAge = userAge;
        this.userSex = userSex;
        this.userWeight = userWeight;
        this.userHeight = userHeight;
    }
}