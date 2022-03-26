package com.example.test.demo.Entity;

import java.io.Serializable;

public class User implements Serializable{
    
    private int userId;
    private String email;
    private String userName;
    private String userPassword;
    private String userDOB;
    private String userGen;
    private int groupID;
    private Boolean hasGroup;
    private String userNickName;

    public User(){
    }

    public User(String userName, String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(int userId, String email, String userName, String userDOB, String userGen, String userNickName){
        this.userId = userId;
        this.email= email;
        this.userName = userName;
        this.userDOB = userDOB;
        this.userGen = userGen;
        this.groupID = 0000;
        this.hasGroup = false;
        this.userNickName = userNickName;
    }

    public User(int userId, String email, String userName, String userPassword, String userDOB, String userGen, String userNickName){
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userDOB = userDOB;
        this.userGen = userGen;
        this.groupID = 0000;
        this.hasGroup = false;
        this.userNickName = userNickName;
    }

    public User(int userId, String email, String userName, String userDOB, String userGen, int groupID, Boolean hasGroup, String userNickName) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.userPassword = "";
        this.userDOB = userDOB;
        this.userGen = userGen;
        this.groupID = groupID;
        this.hasGroup = hasGroup;
        this.userNickName = userNickName;

    }

    public User(int userId, String email, String userName, String userPassword, String userDOB, String userGen, int groupID, Boolean hasGroup, String userNickName) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userDOB = userDOB;
        this.userGen = userGen;
        this.groupID = groupID;
        this.hasGroup = hasGroup;
        this.userNickName = userNickName;

    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserID(){
        return userId;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }

    public String getUserPassword(){
        return userPassword;
    }

    public void setUserDOB(String userDOB){
        this.userDOB = userDOB;
    }

    public String getUserDOB(){
        return userDOB;
    }

    public void setUserGen(String userGen){
        this.userGen = userGen;
    }

    public String getUserGen(){
        return userGen;
    }

    public void setGroupID(int groupID){
        this.groupID = groupID;
    }

    public int getGrouID(){
        return groupID;
    }

    public void setHasGroup(Boolean hasGroup){
        this.hasGroup = hasGroup;
    }

    public Boolean getHasGroup(){
        return hasGroup;
    }

    public void setUserNickName(String userNickName){
        this.userNickName = userNickName;
    }

    public String getUserNickName(){
        return userNickName;
    }

    
}
